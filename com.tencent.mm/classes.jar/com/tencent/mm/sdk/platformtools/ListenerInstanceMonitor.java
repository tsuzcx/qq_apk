package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.Debug;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class ListenerInstanceMonitor
{
  private static final Map<Object, Set<a>> ynh;
  private static final byte[] yni;
  private static Field ynj;
  private static HandlerThread ynk;
  private static ak ynl;
  private static volatile boolean ynm;
  private static final String ynn;
  private static final Runnable yno;
  
  static
  {
    AppMethodBeat.i(115218);
    ynh = new WeakHashMap();
    yni = new byte[0];
    ynj = null;
    ynk = null;
    ynl = null;
    ynm = false;
    ynn = Activity.class.getName();
    yno = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115204);
        synchronized (ListenerInstanceMonitor.dsy())
        {
          if (!ListenerInstanceMonitor.ynm)
          {
            AppMethodBeat.o(115204);
            return;
          }
          synchronized (ListenerInstanceMonitor.dsz())
          {
            if (ListenerInstanceMonitor.ynh.isEmpty()) {
              ab.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: no listener or cb was added, skip rest logic.");
            }
          }
        }
        for (;;)
        {
          synchronized (ListenerInstanceMonitor.dsy())
          {
            if (ListenerInstanceMonitor.ynm) {
              ListenerInstanceMonitor.caJ().postDelayed(this, 10000L);
            }
            AppMethodBeat.o(115204);
            return;
            localObject4 = finally;
            AppMethodBeat.o(115204);
            throw localObject4;
            if (Debug.isDebuggerConnected())
            {
              ab.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.");
              continue;
              localObject5 = finally;
              AppMethodBeat.o(115204);
              throw localObject5;
            }
            ab.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: triggering gc...");
          }
          try
          {
            Runtime.getRuntime().gc();
            Thread.sleep(100L);
            Runtime.getRuntime().runFinalization();
            label331:
            Object localObject3;
            for (;;)
            {
              Iterator localIterator2;
              ListenerInstanceMonitor.a locala;
              Object localObject7;
              synchronized (ListenerInstanceMonitor.dsz())
              {
                Iterator localIterator1 = ListenerInstanceMonitor.ynh.entrySet().iterator();
                if (!localIterator1.hasNext()) {
                  break;
                }
                localIterator2 = ((Set)((Map.Entry)localIterator1.next()).getValue()).iterator();
                if (!localIterator2.hasNext()) {
                  continue;
                }
                locala = (ListenerInstanceMonitor.a)localIterator2.next();
                ??? = locala.ynp.get();
                localObject7 = (Activity)locala.ynq.get();
                if (localObject7 == null)
                {
                  ab.i("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: Ok, ui [%s] was recycled.", new Object[] { locala.ynr.getName() });
                  localIterator2.remove();
                }
              }
              boolean bool = ((Activity)localObject7).isDestroyed();
              int k;
              if (!bool)
              {
                k = 0;
                if ((k == 0) || (localObject2 != null)) {
                  break label522;
                }
                if (locala.ynu <= 3) {
                  break label660;
                }
                localIterator2.remove();
                if (bp.dud()) {
                  break label732;
                }
                if (!bp.dsd()) {
                  break label744;
                }
                break label732;
                if (locala.ynq.get() != null) {
                  break label557;
                }
                if (locala.yns == null) {
                  break label524;
                }
                localObject3 = "ui of class [" + locala.ynr.getName() + "] held by\n [" + locala.dsB() + "] is recycled";
              }
              for (;;)
              {
                localObject3 = new ListenerInstanceMonitor.ListenerLeakedException((String)localObject3, locala.ynt);
                if (i == 0) {
                  break label644;
                }
                AppMethodBeat.o(115204);
                throw ((Throwable)localObject3);
                localObject7 = Looper.getMainLooper().getThread().getStackTrace();
                int j = localObject7.length;
                i = 0;
                k = bool;
                if (i >= j) {
                  break label331;
                }
                Object localObject8 = localObject7[i];
                if ((!ListenerInstanceMonitor.ynn.equals(localObject8.getClassName())) || (!"performDestroy".equals(localObject8.getMethodName()))) {
                  break label737;
                }
                k = 0;
                break label331;
                label522:
                break;
                label524:
                localObject3 = "ui of class [" + locala.ynr.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
                continue;
                label557:
                if (locala.yns != null) {
                  localObject3 = "ui of class [" + locala.ynr.getName() + "] held by\n [" + locala.dsB() + "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
                } else {
                  localObject3 = "ui of class [" + locala.ynr.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
                }
              }
              label644:
              ab.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", (Throwable)localObject3, "", new Object[0]);
              continue;
              label660:
              locala.ynu += 1;
              ab.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.", new Object[] { locala.ynr.getName(), Integer.valueOf(locala.ynu) });
            }
            continue;
            localObject6 = finally;
            AppMethodBeat.o(115204);
            throw localObject6;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              continue;
              label732:
              int i = 1;
              continue;
              label737:
              i += 1;
              continue;
              label744:
              i = 0;
            }
          }
        }
      }
    };
    if ((bp.dud()) || (bp.dsd()))
    {
      if (ah.brt()) {
        try
        {
          Field localField = View.class.getDeclaredField("mContext");
          ynj = localField;
          localField.setAccessible(true);
          dsx();
          AppMethodBeat.o(115218);
          return;
        }
        catch (Throwable localThrowable)
        {
          ab.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", localThrowable, "init failed, keep disabled.", new Object[0]);
          AppMethodBeat.o(115218);
          return;
        }
      }
      ab.w("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
      AppMethodBeat.o(115218);
      return;
    }
    ab.w("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
    AppMethodBeat.o(115218);
  }
  
  private static void a(Object paramObject, Activity paramActivity, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(115216);
    Object localObject2 = null;
    Object localObject1;
    int j;
    if (paramObject.getClass().isAnnotationPresent(h.class))
    {
      localObject1 = (h)paramObject.getClass().getAnnotation(h.class);
      if (localObject1 == null) {
        break label210;
      }
      localObject2 = paramActivity.getClass();
      localObject1 = ((h)localObject1).dsp();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          if (localObject2.equals(localObject1[i])) {
            break label204;
          }
          i += 1;
        }
      }
    }
    else
    {
      ??? = paramObject.getClass().getDeclaredMethods();
      j = ???.length;
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = ???[i];
        if (((Method)localObject1).isAnnotationPresent(h.class))
        {
          localObject1 = (h)((Method)localObject1).getAnnotation(h.class);
          break;
        }
        i += 1;
      }
    }
    label204:
    for (int i = 0; i != 0; i = 1)
    {
      ab.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", new Object[] { paramActivity, paramObject });
      AppMethodBeat.o(115216);
      return;
    }
    synchronized (yni)
    {
      label210:
      localObject2 = (Set)ynh.get(paramObject);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        ynh.put(paramObject, localObject1);
      }
      ((Set)localObject1).add(new a(paramActivity, paramField, paramThrowable));
      AppMethodBeat.o(115216);
      return;
    }
  }
  
  private static void a(Object paramObject, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(115214);
    Object localObject;
    if (paramField == null) {
      if ((paramObject instanceof Activity)) {
        localObject = (Activity)paramObject;
      }
    }
    for (;;)
    {
      a(paramObject, (Activity)localObject, paramField, paramThrowable);
      AppMethodBeat.o(115214);
      return;
      AppMethodBeat.o(115214);
      return;
      if (!paramField.isAccessible()) {
        paramField.setAccessible(true);
      }
      try
      {
        Activity localActivity = (Activity)paramField.get(paramObject);
        localObject = localActivity;
        if (localActivity == null)
        {
          AppMethodBeat.o(115214);
          return;
        }
      }
      catch (Throwable paramObject)
      {
        AppMethodBeat.o(115214);
      }
    }
  }
  
  private static void b(Object paramObject, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(115215);
    Object localObject;
    if (paramField == null) {
      if ((paramObject instanceof View)) {
        localObject = (View)paramObject;
      }
    }
    for (;;)
    {
      try
      {
        localObject = ynj.get(localObject);
        if ((localObject instanceof Activity)) {
          a(paramObject, (Activity)localObject, paramField, paramThrowable);
        }
        AppMethodBeat.o(115215);
        return;
      }
      catch (Throwable paramObject)
      {
        AppMethodBeat.o(115215);
      }
      AppMethodBeat.o(115215);
      return;
      if (ynj == null)
      {
        AppMethodBeat.o(115215);
        return;
      }
      if (!paramField.isAccessible()) {
        paramField.setAccessible(true);
      }
      try
      {
        View localView = (View)paramField.get(paramObject);
        localObject = localView;
        if (localView == null)
        {
          AppMethodBeat.o(115215);
          return;
        }
      }
      catch (Throwable paramObject)
      {
        AppMethodBeat.o(115215);
        return;
      }
    }
  }
  
  public static void ct(Object paramObject)
  {
    AppMethodBeat.i(115213);
    if (paramObject == null)
    {
      AppMethodBeat.o(115213);
      return;
    }
    Throwable localThrowable = new Throwable();
    Class localClass1 = paramObject.getClass();
    if (!Object.class.equals(localClass1))
    {
      if (Activity.class.isAssignableFrom(localClass1)) {
        a(paramObject, null, localThrowable);
      }
      for (;;)
      {
        localClass1 = localClass1.getSuperclass();
        break;
        if (!View.class.isAssignableFrom(localClass1)) {
          break label81;
        }
        b(paramObject, null, localThrowable);
      }
      label81:
      Field[] arrayOfField = localClass1.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      label93:
      Field localField;
      Class localClass2;
      if (i < j)
      {
        localField = arrayOfField[i];
        localClass2 = localField.getType();
        if (!Activity.class.isAssignableFrom(localClass2)) {
          break label136;
        }
        a(paramObject, localField, localThrowable);
      }
      for (;;)
      {
        i += 1;
        break label93;
        break;
        label136:
        if (View.class.isAssignableFrom(localClass2)) {
          b(paramObject, localField, localThrowable);
        }
      }
    }
    AppMethodBeat.o(115213);
  }
  
  public static void cu(Object paramObject)
  {
    AppMethodBeat.i(115217);
    if (paramObject == null)
    {
      AppMethodBeat.o(115217);
      return;
    }
    synchronized (yni)
    {
      ynh.remove(paramObject);
      AppMethodBeat.o(115217);
      return;
    }
  }
  
  private static void dsx()
  {
    AppMethodBeat.i(115212);
    synchronized (yno)
    {
      if (!ynm)
      {
        Object localObject1 = d.aqu("ListenerInstanceMonitor");
        ynk = (HandlerThread)localObject1;
        ((HandlerThread)localObject1).start();
        localObject1 = new ak(ynk.getLooper());
        ynl = (ak)localObject1;
        ((ak)localObject1).postDelayed(yno, 10000L);
        ynm = true;
      }
      AppMethodBeat.o(115212);
      return;
    }
  }
  
  static final class ListenerLeakedException
    extends RuntimeException
  {
    ListenerLeakedException(String paramString, Throwable paramThrowable)
    {
      super();
      AppMethodBeat.i(115211);
      setStackTrace(paramThrowable.getStackTrace());
      AppMethodBeat.o(115211);
    }
    
    public final Throwable fillInStackTrace()
    {
      return this;
    }
  }
  
  static final class a
  {
    final WeakReference<Object> ynp;
    WeakReference<Activity> ynq;
    Class<?> ynr;
    Field yns;
    Throwable ynt;
    int ynu;
    
    a(Activity paramActivity, Field paramField, Throwable paramThrowable)
    {
      AppMethodBeat.i(115205);
      this.ynp = new WeakReference(new Object());
      this.ynq = new WeakReference(paramActivity);
      this.ynr = paramActivity.getClass();
      this.yns = paramField;
      this.ynt = paramThrowable;
      this.ynu = 0;
      AppMethodBeat.o(115205);
    }
    
    private String dsA()
    {
      AppMethodBeat.i(115207);
      Object localObject1 = new StringWriter();
      try
      {
        PrintWriter localPrintWriter = new PrintWriter((Writer)localObject1);
        bo.b(localPrintWriter);
      }
      finally
      {
        try
        {
          this.ynt.printStackTrace(localPrintWriter);
          bo.b(localPrintWriter);
          localObject1 = ((StringWriter)localObject1).toString();
          AppMethodBeat.o(115207);
          return localObject1;
        }
        finally {}
        localObject2 = finally;
        localPrintWriter = null;
      }
      AppMethodBeat.o(115207);
      throw localObject2;
    }
    
    final String dsB()
    {
      AppMethodBeat.i(115208);
      if (this.yns == null)
      {
        AppMethodBeat.o(115208);
        return "#null#";
      }
      Object localObject = this.yns.getDeclaringClass();
      if (!((Class)localObject).isAnonymousClass())
      {
        localObject = "field " + this.yns.getName() + " defined in " + ((Class)localObject).getName();
        AppMethodBeat.o(115208);
        return localObject;
      }
      Type localType = ((Class)localObject).getGenericSuperclass();
      if (Object.class.equals(localType)) {
        localObject = localObject.getGenericInterfaces()[0];
      }
      for (;;)
      {
        localObject = "field " + this.yns.getName() + " define in anonymous class of " + localObject.toString().replace('<', '#').replace('>', '#');
        AppMethodBeat.o(115208);
        return localObject;
        if (localType != null) {
          localObject = localType;
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      AppMethodBeat.i(115210);
      if ((paramObject == null) || (!(paramObject instanceof a)))
      {
        AppMethodBeat.o(115210);
        return false;
      }
      paramObject = (a)paramObject;
      Object localObject1 = this.ynq.get();
      Object localObject2 = paramObject.ynq.get();
      boolean bool1;
      if ((localObject1 == null) && (localObject2 == null)) {
        bool1 = true;
      }
      while (!bool1)
      {
        AppMethodBeat.o(115210);
        return false;
        if ((localObject1 != null) && (localObject2 != null)) {
          bool1 = localObject1.equals(localObject2);
        } else {
          bool1 = false;
        }
      }
      localObject1 = this.yns;
      localObject2 = paramObject.yns;
      if ((localObject1 == null) && (localObject2 == null)) {
        bool1 = true;
      }
      while (!bool1)
      {
        AppMethodBeat.o(115210);
        return false;
        if ((localObject1 != null) && (localObject2 != null)) {
          bool1 = ((Field)localObject1).equals(localObject2);
        } else {
          bool1 = false;
        }
      }
      localObject1 = this.ynt;
      paramObject = paramObject.ynt;
      if ((localObject1 == null) && (paramObject == null)) {
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(115210);
        return bool1;
        if ((localObject1 != null) && (paramObject != null)) {
          bool1 = localObject1.equals(paramObject);
        } else {
          bool1 = false;
        }
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(115209);
      Object localObject = this.ynq.get();
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        if (this.yns == null) {
          break label73;
        }
      }
      label73:
      for (int j = this.yns.hashCode();; j = 0)
      {
        if (this.ynt != null) {
          k = this.ynt.hashCode();
        }
        AppMethodBeat.o(115209);
        return i + j + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(115206);
      String str = dsB() + "@" + dsA().replace('\n', '|');
      AppMethodBeat.o(115206);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor
 * JD-Core Version:    0.7.0.1
 */