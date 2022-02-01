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
  private static final Map<Object, Set<a>> IcY;
  private static final byte[] IcZ;
  private static Field Ida;
  private static ap Idb;
  private static volatile boolean Idc;
  private static final String Idd;
  private static final Runnable Ide;
  
  static
  {
    AppMethodBeat.i(125253);
    IcY = new WeakHashMap();
    IcZ = new byte[0];
    Ida = null;
    Idb = null;
    Idc = false;
    Idd = Activity.class.getName();
    Ide = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125239);
        synchronized (ListenerInstanceMonitor.fkl())
        {
          if (!ListenerInstanceMonitor.Idc)
          {
            AppMethodBeat.o(125239);
            return;
          }
          synchronized (ListenerInstanceMonitor.WK())
          {
            if (ListenerInstanceMonitor.IcY.isEmpty()) {
              ad.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: no listener or cb was added, skip rest logic.");
            }
          }
        }
        for (;;)
        {
          synchronized (ListenerInstanceMonitor.fkl())
          {
            if (ListenerInstanceMonitor.Idc) {
              ListenerInstanceMonitor.dyQ().postDelayed(this, 10000L);
            }
            AppMethodBeat.o(125239);
            return;
            localObject4 = finally;
            AppMethodBeat.o(125239);
            throw localObject4;
            if (Debug.isDebuggerConnected())
            {
              ad.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.");
              continue;
              localObject5 = finally;
              AppMethodBeat.o(125239);
              throw localObject5;
            }
            ad.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: triggering gc...");
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
              synchronized (ListenerInstanceMonitor.WK())
              {
                Iterator localIterator1 = ListenerInstanceMonitor.IcY.entrySet().iterator();
                if (!localIterator1.hasNext()) {
                  break;
                }
                localIterator2 = ((Set)((Map.Entry)localIterator1.next()).getValue()).iterator();
                if (!localIterator2.hasNext()) {
                  continue;
                }
                locala = (ListenerInstanceMonitor.a)localIterator2.next();
                ??? = locala.Idf.get();
                localObject7 = (Activity)locala.Idg.get();
                if (localObject7 == null)
                {
                  ad.i("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: Ok, ui [%s] was recycled.", new Object[] { locala.Idh.getName() });
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
                if (locala.Idk <= 3) {
                  break label660;
                }
                localIterator2.remove();
                if (bu.flY()) {
                  break label732;
                }
                if (!bu.fjL()) {
                  break label744;
                }
                break label732;
                if (locala.Idg.get() != null) {
                  break label557;
                }
                if (locala.Idi == null) {
                  break label524;
                }
                localObject3 = "ui of class [" + locala.Idh.getName() + "] held by\n [" + locala.fkn() + "] is recycled";
              }
              for (;;)
              {
                localObject3 = new ListenerInstanceMonitor.ListenerLeakedException((String)localObject3, locala.Idj);
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
                if ((!ListenerInstanceMonitor.bbx().equals(localObject8.getClassName())) || (!"performDestroy".equals(localObject8.getMethodName()))) {
                  break label737;
                }
                k = 0;
                break label331;
                label522:
                break;
                label524:
                localObject3 = "ui of class [" + locala.Idh.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
                continue;
                label557:
                if (locala.Idi != null) {
                  localObject3 = "ui of class [" + locala.Idh.getName() + "] held by\n [" + locala.fkn() + "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
                } else {
                  localObject3 = "ui of class [" + locala.Idh.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
                }
              }
              label644:
              ad.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", (Throwable)localObject3, "", new Object[0]);
              continue;
              label660:
              locala.Idk += 1;
              ad.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.", new Object[] { locala.Idh.getName(), Integer.valueOf(locala.Idk) });
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
    if ((bu.flY()) || (bu.fjL()))
    {
      if (aj.cnC()) {
        try
        {
          Field localField = View.class.getDeclaredField("mContext");
          Ida = localField;
          localField.setAccessible(true);
          coL();
          AppMethodBeat.o(125253);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", localThrowable, "init failed, keep disabled.", new Object[0]);
          AppMethodBeat.o(125253);
          return;
        }
      }
      ad.w("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
      AppMethodBeat.o(125253);
      return;
    }
    ad.w("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
    AppMethodBeat.o(125253);
  }
  
  private static void a(Object paramObject, Activity paramActivity, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(125251);
    Object localObject2 = null;
    Object localObject1;
    int j;
    if (paramObject.getClass().isAnnotationPresent(k.class))
    {
      localObject1 = (k)paramObject.getClass().getAnnotation(k.class);
      if (localObject1 == null) {
        break label210;
      }
      localObject2 = paramActivity.getClass();
      localObject1 = ((k)localObject1).fkb();
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
        if (((Method)localObject1).isAnnotationPresent(k.class))
        {
          localObject1 = (k)((Method)localObject1).getAnnotation(k.class);
          break;
        }
        i += 1;
      }
    }
    label204:
    for (int i = 0; i != 0; i = 1)
    {
      ad.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", new Object[] { paramActivity, paramObject });
      AppMethodBeat.o(125251);
      return;
    }
    synchronized (IcZ)
    {
      label210:
      localObject2 = (Set)IcY.get(paramObject);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        IcY.put(paramObject, localObject1);
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
        localObject = Ida.get(localObject);
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
      if (Ida == null)
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
  
  private static void coL()
  {
    AppMethodBeat.i(125247);
    synchronized (Ide)
    {
      if (!Idc)
      {
        ap localap = new ap("ListenerInstanceMonitor");
        Idb = localap;
        localap.setLogging(false);
        Idb.postDelayed(Ide, 10000L);
        Idc = true;
      }
      AppMethodBeat.o(125247);
      return;
    }
  }
  
  public static void dR(Object paramObject)
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
  
  public static void dS(Object paramObject)
  {
    AppMethodBeat.i(125252);
    if (paramObject == null)
    {
      AppMethodBeat.o(125252);
      return;
    }
    synchronized (IcZ)
    {
      IcY.remove(paramObject);
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
    final WeakReference<Object> Idf;
    WeakReference<Activity> Idg;
    Class<?> Idh;
    Field Idi;
    Throwable Idj;
    int Idk;
    
    a(Activity paramActivity, Field paramField, Throwable paramThrowable)
    {
      AppMethodBeat.i(125240);
      this.Idf = new WeakReference(new Object());
      this.Idg = new WeakReference(paramActivity);
      this.Idh = paramActivity.getClass();
      this.Idi = paramField;
      this.Idj = paramThrowable;
      this.Idk = 0;
      AppMethodBeat.o(125240);
    }
    
    private String fkm()
    {
      AppMethodBeat.i(125242);
      Object localObject1 = new StringWriter();
      try
      {
        PrintWriter localPrintWriter = new PrintWriter((Writer)localObject1);
        bt.d(localPrintWriter);
      }
      finally
      {
        try
        {
          this.Idj.printStackTrace(localPrintWriter);
          bt.d(localPrintWriter);
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
      Object localObject1 = this.Idg.get();
      Object localObject2 = paramObject.Idg.get();
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
      localObject1 = this.Idi;
      localObject2 = paramObject.Idi;
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
      localObject1 = this.Idj;
      paramObject = paramObject.Idj;
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
    
    final String fkn()
    {
      AppMethodBeat.i(125243);
      if (this.Idi == null)
      {
        AppMethodBeat.o(125243);
        return "#null#";
      }
      Object localObject = this.Idi.getDeclaringClass();
      if (!((Class)localObject).isAnonymousClass())
      {
        localObject = "field " + this.Idi.getName() + " defined in " + ((Class)localObject).getName();
        AppMethodBeat.o(125243);
        return localObject;
      }
      Type localType = ((Class)localObject).getGenericSuperclass();
      if (Object.class.equals(localType)) {
        localObject = localObject.getGenericInterfaces()[0];
      }
      for (;;)
      {
        localObject = "field " + this.Idi.getName() + " define in anonymous class of " + localObject.toString().replace('<', '#').replace('>', '#');
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
      Object localObject = this.Idg.get();
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        if (this.Idi == null) {
          break label73;
        }
      }
      label73:
      for (int j = this.Idi.hashCode();; j = 0)
      {
        if (this.Idj != null) {
          k = this.Idj.hashCode();
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
      String str = fkn() + "@" + fkm().replace('\n', '|');
      AppMethodBeat.o(125241);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor
 * JD-Core Version:    0.7.0.1
 */