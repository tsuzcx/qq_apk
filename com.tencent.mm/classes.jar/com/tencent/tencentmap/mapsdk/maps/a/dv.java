package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;

public final class dv
  extends dq
{
  private static final Class<?>[] a = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  private Object b;
  
  public dv(Boolean paramBoolean)
  {
    AppMethodBeat.i(147507);
    a(paramBoolean);
    AppMethodBeat.o(147507);
  }
  
  public dv(Number paramNumber)
  {
    AppMethodBeat.i(147508);
    a(paramNumber);
    AppMethodBeat.o(147508);
  }
  
  public dv(String paramString)
  {
    AppMethodBeat.i(147509);
    a(paramString);
    AppMethodBeat.o(147509);
  }
  
  private static boolean a(dv paramdv)
  {
    if ((paramdv.b instanceof Number))
    {
      paramdv = (Number)paramdv.b;
      return ((paramdv instanceof BigInteger)) || ((paramdv instanceof Long)) || ((paramdv instanceof Integer)) || ((paramdv instanceof Short)) || ((paramdv instanceof Byte));
    }
    return false;
  }
  
  private static boolean b(Object paramObject)
  {
    AppMethodBeat.i(147518);
    if ((paramObject instanceof String))
    {
      AppMethodBeat.o(147518);
      return true;
    }
    paramObject = paramObject.getClass();
    Class[] arrayOfClass = a;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].isAssignableFrom(paramObject))
      {
        AppMethodBeat.o(147518);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(147518);
    return false;
  }
  
  final void a(Object paramObject)
  {
    AppMethodBeat.i(147510);
    if ((paramObject instanceof Character))
    {
      this.b = String.valueOf(((Character)paramObject).charValue());
      AppMethodBeat.o(147510);
      return;
    }
    if (((paramObject instanceof Number)) || (b(paramObject))) {}
    for (boolean bool = true;; bool = false)
    {
      eh.a(bool);
      this.b = paramObject;
      AppMethodBeat.o(147510);
      return;
    }
  }
  
  public final boolean a()
  {
    return this.b instanceof Boolean;
  }
  
  public final Number b()
  {
    AppMethodBeat.i(147512);
    if ((this.b instanceof String))
    {
      localObject = new em((String)this.b);
      AppMethodBeat.o(147512);
      return localObject;
    }
    Object localObject = (Number)this.b;
    AppMethodBeat.o(147512);
    return localObject;
  }
  
  public final String c()
  {
    AppMethodBeat.i(147513);
    if (q())
    {
      str = b().toString();
      AppMethodBeat.o(147513);
      return str;
    }
    if (a())
    {
      str = p().toString();
      AppMethodBeat.o(147513);
      return str;
    }
    String str = (String)this.b;
    AppMethodBeat.o(147513);
    return str;
  }
  
  public final double d()
  {
    AppMethodBeat.i(147514);
    if (q())
    {
      d = b().doubleValue();
      AppMethodBeat.o(147514);
      return d;
    }
    double d = Double.parseDouble(c());
    AppMethodBeat.o(147514);
    return d;
  }
  
  public final float e()
  {
    AppMethodBeat.i(147515);
    if (q())
    {
      f = b().floatValue();
      AppMethodBeat.o(147515);
      return f;
    }
    float f = Float.parseFloat(c());
    AppMethodBeat.o(147515);
    return f;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147520);
    if (this == paramObject)
    {
      AppMethodBeat.o(147520);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(147520);
      return false;
    }
    paramObject = (dv)paramObject;
    if (this.b == null)
    {
      if (paramObject.b == null)
      {
        AppMethodBeat.o(147520);
        return true;
      }
      AppMethodBeat.o(147520);
      return false;
    }
    if ((a(this)) && (a(paramObject)))
    {
      if (b().longValue() == paramObject.b().longValue())
      {
        AppMethodBeat.o(147520);
        return true;
      }
      AppMethodBeat.o(147520);
      return false;
    }
    if (((this.b instanceof Number)) && ((paramObject.b instanceof Number)))
    {
      double d1 = b().doubleValue();
      double d2 = paramObject.b().doubleValue();
      if ((d1 == d2) || ((Double.isNaN(d1)) && (Double.isNaN(d2))))
      {
        AppMethodBeat.o(147520);
        return true;
      }
      AppMethodBeat.o(147520);
      return false;
    }
    boolean bool = this.b.equals(paramObject.b);
    AppMethodBeat.o(147520);
    return bool;
  }
  
  public final long f()
  {
    AppMethodBeat.i(147516);
    if (q())
    {
      l = b().longValue();
      AppMethodBeat.o(147516);
      return l;
    }
    long l = Long.parseLong(c());
    AppMethodBeat.o(147516);
    return l;
  }
  
  public final int g()
  {
    AppMethodBeat.i(147517);
    if (q())
    {
      i = b().intValue();
      AppMethodBeat.o(147517);
      return i;
    }
    int i = Integer.parseInt(c());
    AppMethodBeat.o(147517);
    return i;
  }
  
  public final boolean h()
  {
    AppMethodBeat.i(147511);
    if (a())
    {
      bool = p().booleanValue();
      AppMethodBeat.o(147511);
      return bool;
    }
    boolean bool = Boolean.parseBoolean(c());
    AppMethodBeat.o(147511);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(147519);
    if (this.b == null)
    {
      AppMethodBeat.o(147519);
      return 31;
    }
    long l;
    if (a(this))
    {
      l = b().longValue();
      i = (int)(l ^ l >>> 32);
      AppMethodBeat.o(147519);
      return i;
    }
    if ((this.b instanceof Number))
    {
      l = Double.doubleToLongBits(b().doubleValue());
      i = (int)(l ^ l >>> 32);
      AppMethodBeat.o(147519);
      return i;
    }
    int i = this.b.hashCode();
    AppMethodBeat.o(147519);
    return i;
  }
  
  final Boolean p()
  {
    return (Boolean)this.b;
  }
  
  public final boolean q()
  {
    return this.b instanceof Number;
  }
  
  public final boolean r()
  {
    return this.b instanceof String;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dv
 * JD-Core Version:    0.7.0.1
 */