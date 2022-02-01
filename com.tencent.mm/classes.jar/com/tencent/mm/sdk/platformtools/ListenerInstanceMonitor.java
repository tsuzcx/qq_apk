package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.Debug;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static final Map<Object, Set<a>> Ixj;
  private static final byte[] Ixk;
  private static Field Ixl;
  private static aq Ixm;
  private static volatile boolean Ixn;
  private static final String Ixo;
  private static final Runnable Ixp;
  
  static
  {
    AppMethodBeat.i(125253);
    Ixj = new WeakHashMap();
    Ixk = new byte[0];
    Ixl = null;
    Ixm = null;
    Ixn = false;
    Ixo = Activity.class.getName();
    Ixp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125239);
        synchronized (ListenerInstanceMonitor.fof())
        {
          if (!ListenerInstanceMonitor.Ixn)
          {
            AppMethodBeat.o(125239);
            return;
          }
          synchronized (ListenerInstanceMonitor.WS())
          {
            if (ListenerInstanceMonitor.Ixj.isEmpty()) {
              ae.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: no listener or cb was added, skip rest logic.");
            }
          }
        }
        for (;;)
        {
          synchronized (ListenerInstanceMonitor.fof())
          {
            if (ListenerInstanceMonitor.Ixn) {
              ListenerInstanceMonitor.dCh().postDelayed(this, 10000L);
            }
            AppMethodBeat.o(125239);
            return;
            localObject4 = finally;
            AppMethodBeat.o(125239);
            throw localObject4;
            if (Debug.isDebuggerConnected())
            {
              ae.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.");
              continue;
              localObject5 = finally;
              AppMethodBeat.o(125239);
              throw localObject5;
            }
            ae.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: triggering gc...");
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
              synchronized (ListenerInstanceMonitor.WS())
              {
                Iterator localIterator1 = ListenerInstanceMonitor.Ixj.entrySet().iterator();
                if (!localIterator1.hasNext()) {
                  break;
                }
                localIterator2 = ((Set)((Map.Entry)localIterator1.next()).getValue()).iterator();
                if (!localIterator2.hasNext()) {
                  continue;
                }
                locala = (ListenerInstanceMonitor.a)localIterator2.next();
                ??? = locala.Ixq.get();
                localObject7 = (Activity)locala.Ixr.get();
                if (localObject7 == null)
                {
                  ae.i("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: Ok, ui [%s] was recycled.", new Object[] { locala.Ixs.getName() });
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
                if (locala.Ixv <= 3) {
                  break label660;
                }
                localIterator2.remove();
                if (bv.fpT()) {
                  break label732;
                }
                if (!bv.fnD()) {
                  break label744;
                }
                break label732;
                if (locala.Ixr.get() != null) {
                  break label557;
                }
                if (locala.Ixt == null) {
                  break label524;
                }
                localObject3 = "ui of class [" + locala.Ixs.getName() + "] held by\n [" + locala.foh() + "] is recycled";
              }
              for (;;)
              {
                localObject3 = new ListenerInstanceMonitor.ListenerLeakedException((String)localObject3, locala.Ixu);
                if (i == 0) {
                  break label644;
                }
                AppMethodBeat.o(125239);
                throw ((Throwable)localObject3);
                localObject7 = Looper.getMainLooper().getThread().getStackTrace();
                int j = localObject7.length;
                i = 0;
                k = bool;
                if (i >= j) {
                  break label331;
                }
                Object localObject8 = localObject7[i];
                if ((!ListenerInstanceMonitor.bbZ().equals(localObject8.getClassName())) || (!"performDestroy".equals(localObject8.getMethodName()))) {
                  break label737;
                }
                k = 0;
                break label331;
                label522:
                break;
                label524:
                localObject3 = "ui of class [" + locala.Ixs.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
                continue;
                label557:
                if (locala.Ixt != null) {
                  localObject3 = "ui of class [" + locala.Ixs.getName() + "] held by\n [" + locala.foh() + "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
                } else {
                  localObject3 = "ui of class [" + locala.Ixs.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
                }
              }
              label644:
              ae.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", (Throwable)localObject3, "", new Object[0]);
              continue;
              label660:
              locala.Ixv += 1;
              ae.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.", new Object[] { locala.Ixs.getName(), Integer.valueOf(locala.Ixv) });
            }
            continue;
            localObject6 = finally;
            AppMethodBeat.o(125239);
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
    if ((bv.fpT()) || (bv.fnD()))
    {
      if (ak.cpe()) {
        try
        {
          Field localField = View.class.getDeclaredField("mContext");
          Ixl = localField;
          localField.setAccessible(true);
          cqn();
          AppMethodBeat.o(125253);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", localThrowable, "init failed, keep disabled.", new Object[0]);
          AppMethodBeat.o(125253);
          return;
        }
      }
      ae.w("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
      AppMethodBeat.o(125253);
      return;
    }
    ae.w("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
    AppMethodBeat.o(125253);
  }
  
  private static void a(Object paramObject, Activity paramActivity, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(125251);
    Object localObject2 = null;
    Object localObject1;
    int j;
    if (paramObject.getClass().isAnnotationPresent(l.class))
    {
      localObject1 = (l)paramObject.getClass().getAnnotation(l.class);
      if (localObject1 == null) {
        break label210;
      }
      localObject2 = paramActivity.getClass();
      localObject1 = ((l)localObject1).fnV();
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
        if (((Method)localObject1).isAnnotationPresent(l.class))
        {
          localObject1 = (l)((Method)localObject1).getAnnotation(l.class);
          break;
        }
        i += 1;
      }
    }
    label204:
    for (int i = 0; i != 0; i = 1)
    {
      ae.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", new Object[] { paramActivity, paramObject });
      AppMethodBeat.o(125251);
      return;
    }
    synchronized (Ixk)
    {
      label210:
      localObject2 = (Set)Ixj.get(paramObject);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        Ixj.put(paramObject, localObject1);
      }
      ((Set)localObject1).add(new a(paramActivity, paramField, paramThrowable));
      AppMethodBeat.o(125251);
      return;
    }
  }
  
  private static void a(Object paramObject, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(125249);
    Object localObject;
    if (paramField == null) {
      if ((paramObject instanceof Activity)) {
        localObject = (Activity)paramObject;
      }
    }
    for (;;)
    {
      a(paramObject, (Activity)localObject, paramField, paramThrowable);
      AppMethodBeat.o(125249);
      return;
      AppMethodBeat.o(125249);
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
          AppMethodBeat.o(125249);
          return;
        }
      }
      catch (Throwable paramObject)
      {
        AppMethodBeat.o(125249);
      }
    }
  }
  
  private static void b(Object paramObject, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(125250);
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
        localObject = Ixl.get(localObject);
        if ((localObject instanceof Activity)) {
          a(paramObject, (Activity)localObject, paramField, paramThrowable);
        }
        AppMethodBeat.o(125250);
        return;
      }
      catch (Throwable paramObject)
      {
        AppMethodBeat.o(125250);
      }
      AppMethodBeat.o(125250);
      return;
      if (Ixl == null)
      {
        AppMethodBeat.o(125250);
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
          AppMethodBeat.o(125250);
          return;
        }
      }
      catch (Throwable paramObject)
      {
        AppMethodBeat.o(125250);
        return;
      }
    }
  }
  
  private static void cqn()
  {
    AppMethodBeat.i(125247);
    synchronized (Ixp)
    {
      if (!Ixn)
      {
        aq localaq = new aq("ListenerInstanceMonitor");
        Ixm = localaq;
        localaq.setLogging(false);
        Ixm.postDelayed(Ixp, 10000L);
        Ixn = true;
      }
      AppMethodBeat.o(125247);
      return;
    }
  }
  
  public static void dS(Object paramObject)
  {
    AppMethodBeat.i(125248);
    if (paramObject == null)
    {
      AppMethodBeat.o(125248);
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
    AppMethodBeat.o(125248);
  }
  
  public static void dT(Object paramObject)
  {
    AppMethodBeat.i(125252);
    if (paramObject == null)
    {
      AppMethodBeat.o(125252);
      return;
    }
    synchronized (Ixk)
    {
      Ixj.remove(paramObject);
      AppMethodBeat.o(125252);
      return;
    }
  }
  
  static final class ListenerLeakedException
    extends RuntimeException
  {
    ListenerLeakedException(String paramString, Throwable paramThrowable)
    {
      super();
      AppMethodBeat.i(125246);
      setStackTrace(paramThrowable.getStackTrace());
      AppMethodBeat.o(125246);
    }
    
    public final Throwable fillInStackTrace()
    {
      return this;
    }
  }
  
  static final class a
  {
    final WeakReference<Object> Ixq;
    WeakReference<Activity> Ixr;
    Class<?> Ixs;
    Field Ixt;
    Throwable Ixu;
    int Ixv;
    
    a(Activity paramActivity, Field paramField, Throwable paramThrowable)
    {
      AppMethodBeat.i(125240);
      this.Ixq = new WeakReference(new Object());
      this.Ixr = new WeakReference(paramActivity);
      this.Ixs = paramActivity.getClass();
      this.Ixt = paramField;
      this.Ixu = paramThrowable;
      this.Ixv = 0;
      AppMethodBeat.o(125240);
    }
    
    private String fog()
    {
      AppMethodBeat.i(125242);
      Object localObject1 = new StringWriter();
      try
      {
        PrintWriter localPrintWriter = new PrintWriter((Writer)localObject1);
        bu.d(localPrintWriter);
      }
      finally
      {
        try
        {
          this.Ixu.printStackTrace(localPrintWriter);
          bu.d(localPrintWriter);
          localObject1 = ((StringWriter)localObject1).toString();
          AppMethodBeat.o(125242);
          return localObject1;
        }
        finally {}
        localObject2 = finally;
        localPrintWriter = null;
      }
      AppMethodBeat.o(125242);
      throw localObject2;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      AppMethodBeat.i(125245);
      if ((paramObject == null) || (!(paramObject instanceof a)))
      {
        AppMethodBeat.o(125245);
        return false;
      }
      paramObject = (a)paramObject;
      Object localObject1 = this.Ixr.get();
      Object localObject2 = paramObject.Ixr.get();
      boolean bool1;
      if ((localObject1 == null) && (localObject2 == null)) {
        bool1 = true;
      }
      while (!bool1)
      {
        AppMethodBeat.o(125245);
        return false;
        if ((localObject1 != null) && (localObject2 != null)) {
          bool1 = localObject1.equals(localObject2);
        } else {
          bool1 = false;
        }
      }
      localObject1 = this.Ixt;
      localObject2 = paramObject.Ixt;
      if ((localObject1 == null) && (localObject2 == null)) {
        bool1 = true;
      }
      while (!bool1)
      {
        AppMethodBeat.o(125245);
        return false;
        if ((localObject1 != null) && (localObject2 != null)) {
          bool1 = ((Field)localObject1).equals(localObject2);
        } else {
          bool1 = false;
        }
      }
      localObject1 = this.Ixu;
      paramObject = paramObject.Ixu;
      if ((localObject1 == null) && (paramObject == null)) {
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(125245);
        return bool1;
        if ((localObject1 != null) && (paramObject != null)) {
          bool1 = localObject1.equals(paramObject);
        } else {
          bool1 = false;
        }
      }
    }
    
    final String foh()
    {
      AppMethodBeat.i(125243);
      if (this.Ixt == null)
      {
        AppMethodBeat.o(125243);
        return "#null#";
      }
      Object localObject = this.Ixt.getDeclaringClass();
      if (!((Class)localObject).isAnonymousClass())
      {
        localObject = "field " + this.Ixt.getName() + " defined in " + ((Class)localObject).getName();
        AppMethodBeat.o(125243);
        return localObject;
      }
      Type localType = ((Class)localObject).getGenericSuperclass();
      if (Object.class.equals(localType)) {
        localObject = localObject.getGenericInterfaces()[0];
      }
      for (;;)
      {
        localObject = "field " + this.Ixt.getName() + " define in anonymous class of " + localObject.toString().replace('<', '#').replace('>', '#');
        AppMethodBeat.o(125243);
        return localObject;
        if (localType != null) {
          localObject = localType;
        }
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(125244);
      Object localObject = this.Ixr.get();
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        if (this.Ixt == null) {
          break label73;
        }
      }
      label73:
      for (int j = this.Ixt.hashCode();; j = 0)
      {
        if (this.Ixu != null) {
          k = this.Ixu.hashCode();
        }
        AppMethodBeat.o(125244);
        return i + j + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(125241);
      String str = foh() + "@" + fog().replace('\n', '|');
      AppMethodBeat.o(125241);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor
 * JD-Core Version:    0.7.0.1
 */