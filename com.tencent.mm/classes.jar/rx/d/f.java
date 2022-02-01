package rx.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class f
{
  private static final f Obj;
  static final b Obp;
  private final AtomicReference<b> Obk;
  private final AtomicReference<d> Obl;
  private final AtomicReference<h> Obm;
  private final AtomicReference<a> Obn;
  private final AtomicReference<g> Obo;
  
  static
  {
    AppMethodBeat.i(90495);
    Obj = new f();
    Obp = new b() {};
    AppMethodBeat.o(90495);
  }
  
  f()
  {
    AppMethodBeat.i(90488);
    this.Obk = new AtomicReference();
    this.Obl = new AtomicReference();
    this.Obm = new AtomicReference();
    this.Obn = new AtomicReference();
    this.Obo = new AtomicReference();
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
  public static f gzm()
  {
    return Obj;
  }
  
  public final b gzn()
  {
    AppMethodBeat.i(90489);
    Object localObject;
    if (this.Obk.get() == null)
    {
      localObject = a(b.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.Obk.compareAndSet(null, Obp);
    }
    for (;;)
    {
      localObject = (b)this.Obk.get();
      AppMethodBeat.o(90489);
      return localObject;
      label58:
      this.Obk.compareAndSet(null, (b)localObject);
    }
  }
  
  public final d gzo()
  {
    AppMethodBeat.i(90490);
    Object localObject;
    if (this.Obl.get() == null)
    {
      localObject = a(d.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.Obl.compareAndSet(null, e.gzl());
    }
    for (;;)
    {
      localObject = (d)this.Obl.get();
      AppMethodBeat.o(90490);
      return localObject;
      label58:
      this.Obl.compareAndSet(null, (d)localObject);
    }
  }
  
  public final h gzp()
  {
    AppMethodBeat.i(90491);
    Object localObject;
    if (this.Obm.get() == null)
    {
      localObject = a(h.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.Obm.compareAndSet(null, i.gzw());
    }
    for (;;)
    {
      localObject = (h)this.Obm.get();
      AppMethodBeat.o(90491);
      return localObject;
      label58:
      this.Obm.compareAndSet(null, (h)localObject);
    }
  }
  
  public final a gzq()
  {
    AppMethodBeat.i(90492);
    Object localObject;
    if (this.Obn.get() == null)
    {
      localObject = a(a.class, System.getProperties());
      if (localObject != null) {
        break label63;
      }
      this.Obn.compareAndSet(null, new a() {});
    }
    for (;;)
    {
      localObject = (a)this.Obn.get();
      AppMethodBeat.o(90492);
      return localObject;
      label63:
      this.Obn.compareAndSet(null, (a)localObject);
    }
  }
  
  public final g gzr()
  {
    AppMethodBeat.i(90494);
    Object localObject;
    if (this.Obo.get() == null)
    {
      localObject = a(g.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.Obo.compareAndSet(null, g.gzv());
    }
    for (;;)
    {
      localObject = (g)this.Obo.get();
      AppMethodBeat.o(90494);
      return localObject;
      label58:
      this.Obo.compareAndSet(null, (g)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.d.f
 * JD-Core Version:    0.7.0.1
 */