package rx.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class f
{
  private static final f akei;
  static final b akeo;
  private final AtomicReference<b> akej;
  private final AtomicReference<d> akek;
  private final AtomicReference<h> akel;
  private final AtomicReference<a> akem;
  private final AtomicReference<g> aken;
  
  static
  {
    AppMethodBeat.i(90495);
    akei = new f();
    akeo = new b() {};
    AppMethodBeat.o(90495);
  }
  
  f()
  {
    AppMethodBeat.i(90488);
    this.akej = new AtomicReference();
    this.akek = new AtomicReference();
    this.akel = new AtomicReference();
    this.akem = new AtomicReference();
    this.aken = new AtomicReference();
    AppMethodBeat.o(90488);
  }
  
  private static Object a(Class<?> paramClass, Properties paramProperties)
  {
    AppMethodBeat.i(90493);
    Properties localProperties = (Properties)paramProperties.clone();
    String str1 = paramClass.getSimpleName();
    paramProperties = localProperties.getProperty("rxjava.plugin." + str1 + ".implementation");
    if (paramProperties == null)
    {
      Object localObject = localProperties.entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          String str2 = localEntry.getKey().toString();
          if ((str2.startsWith("rxjava.plugin.")) && (str2.endsWith(".class")) && (str1.equals(localEntry.getValue().toString())))
          {
            paramProperties = str2.substring(0, str2.length() - ".class".length()).substring("rxjava.plugin.".length());
            localObject = "rxjava.plugin." + paramProperties + ".impl";
            paramProperties = localProperties.getProperty((String)localObject);
            if (paramProperties == null)
            {
              paramClass = new IllegalStateException("Implementing class declaration for " + str1 + " missing: " + (String)localObject);
              AppMethodBeat.o(90493);
              throw paramClass;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramProperties != null) {
        try
        {
          paramClass = Class.forName(paramProperties).asSubclass(paramClass).newInstance();
          AppMethodBeat.o(90493);
          return paramClass;
        }
        catch (ClassCastException paramClass)
        {
          paramClass = new IllegalStateException(str1 + " implementation is not an instance of " + str1 + ": " + paramProperties, paramClass);
          AppMethodBeat.o(90493);
          throw paramClass;
        }
        catch (ClassNotFoundException paramClass)
        {
          paramClass = new IllegalStateException(str1 + " implementation class not found: " + paramProperties, paramClass);
          AppMethodBeat.o(90493);
          throw paramClass;
        }
        catch (InstantiationException paramClass)
        {
          paramClass = new IllegalStateException(str1 + " implementation not able to be instantiated: " + paramProperties, paramClass);
          AppMethodBeat.o(90493);
          throw paramClass;
        }
        catch (IllegalAccessException paramClass)
        {
          paramClass = new IllegalStateException(str1 + " implementation not able to be accessed: " + paramProperties, paramClass);
          AppMethodBeat.o(90493);
          throw paramClass;
        }
      }
      AppMethodBeat.o(90493);
      return null;
    }
  }
  
  @Deprecated
  public static f kKE()
  {
    return akei;
  }
  
  public final b kKF()
  {
    AppMethodBeat.i(90489);
    Object localObject;
    if (this.akej.get() == null)
    {
      localObject = a(b.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.akej.compareAndSet(null, akeo);
    }
    for (;;)
    {
      localObject = (b)this.akej.get();
      AppMethodBeat.o(90489);
      return localObject;
      label58:
      this.akej.compareAndSet(null, (b)localObject);
    }
  }
  
  public final d kKG()
  {
    AppMethodBeat.i(90490);
    Object localObject;
    if (this.akek.get() == null)
    {
      localObject = a(d.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.akek.compareAndSet(null, e.kKD());
    }
    for (;;)
    {
      localObject = (d)this.akek.get();
      AppMethodBeat.o(90490);
      return localObject;
      label58:
      this.akek.compareAndSet(null, (d)localObject);
    }
  }
  
  public final h kKH()
  {
    AppMethodBeat.i(90491);
    Object localObject;
    if (this.akel.get() == null)
    {
      localObject = a(h.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.akel.compareAndSet(null, i.kKR());
    }
    for (;;)
    {
      localObject = (h)this.akel.get();
      AppMethodBeat.o(90491);
      return localObject;
      label58:
      this.akel.compareAndSet(null, (h)localObject);
    }
  }
  
  public final a kKI()
  {
    AppMethodBeat.i(90492);
    Object localObject;
    if (this.akem.get() == null)
    {
      localObject = a(a.class, System.getProperties());
      if (localObject != null) {
        break label63;
      }
      this.akem.compareAndSet(null, new a() {});
    }
    for (;;)
    {
      localObject = (a)this.akem.get();
      AppMethodBeat.o(90492);
      return localObject;
      label63:
      this.akem.compareAndSet(null, (a)localObject);
    }
  }
  
  public final g kKJ()
  {
    AppMethodBeat.i(90494);
    Object localObject;
    if (this.aken.get() == null)
    {
      localObject = a(g.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.aken.compareAndSet(null, g.kKQ());
    }
    for (;;)
    {
      localObject = (g)this.aken.get();
      AppMethodBeat.o(90494);
      return localObject;
      label58:
      this.aken.compareAndSet(null, (g)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.d.f
 * JD-Core Version:    0.7.0.1
 */