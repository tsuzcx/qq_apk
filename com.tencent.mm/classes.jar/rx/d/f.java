package rx.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class f
{
  private static final f abRq;
  static final b abRw;
  private final AtomicReference<b> abRr;
  private final AtomicReference<d> abRs;
  private final AtomicReference<h> abRt;
  private final AtomicReference<a> abRu;
  private final AtomicReference<g> abRv;
  
  static
  {
    AppMethodBeat.i(90495);
    abRq = new f();
    abRw = new b() {};
    AppMethodBeat.o(90495);
  }
  
  f()
  {
    AppMethodBeat.i(90488);
    this.abRr = new AtomicReference();
    this.abRs = new AtomicReference();
    this.abRt = new AtomicReference();
    this.abRu = new AtomicReference();
    this.abRv = new AtomicReference();
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
  public static f iWg()
  {
    return abRq;
  }
  
  public final b iWh()
  {
    AppMethodBeat.i(90489);
    Object localObject;
    if (this.abRr.get() == null)
    {
      localObject = a(b.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.abRr.compareAndSet(null, abRw);
    }
    for (;;)
    {
      localObject = (b)this.abRr.get();
      AppMethodBeat.o(90489);
      return localObject;
      label58:
      this.abRr.compareAndSet(null, (b)localObject);
    }
  }
  
  public final d iWi()
  {
    AppMethodBeat.i(90490);
    Object localObject;
    if (this.abRs.get() == null)
    {
      localObject = a(d.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.abRs.compareAndSet(null, e.iWf());
    }
    for (;;)
    {
      localObject = (d)this.abRs.get();
      AppMethodBeat.o(90490);
      return localObject;
      label58:
      this.abRs.compareAndSet(null, (d)localObject);
    }
  }
  
  public final h iWj()
  {
    AppMethodBeat.i(90491);
    Object localObject;
    if (this.abRt.get() == null)
    {
      localObject = a(h.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.abRt.compareAndSet(null, i.iWq());
    }
    for (;;)
    {
      localObject = (h)this.abRt.get();
      AppMethodBeat.o(90491);
      return localObject;
      label58:
      this.abRt.compareAndSet(null, (h)localObject);
    }
  }
  
  public final a iWk()
  {
    AppMethodBeat.i(90492);
    Object localObject;
    if (this.abRu.get() == null)
    {
      localObject = a(a.class, System.getProperties());
      if (localObject != null) {
        break label63;
      }
      this.abRu.compareAndSet(null, new a() {});
    }
    for (;;)
    {
      localObject = (a)this.abRu.get();
      AppMethodBeat.o(90492);
      return localObject;
      label63:
      this.abRu.compareAndSet(null, (a)localObject);
    }
  }
  
  public final g iWl()
  {
    AppMethodBeat.i(90494);
    Object localObject;
    if (this.abRv.get() == null)
    {
      localObject = a(g.class, System.getProperties());
      if (localObject != null) {
        break label58;
      }
      this.abRv.compareAndSet(null, g.iWp());
    }
    for (;;)
    {
      localObject = (g)this.abRv.get();
      AppMethodBeat.o(90494);
      return localObject;
      label58:
      this.abRv.compareAndSet(null, (g)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.d.f
 * JD-Core Version:    0.7.0.1
 */