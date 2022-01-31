package com.tencent.tencentmap.mapsdk.maps.a;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class dq
{
  public Number b()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String c()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public double d()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public float e()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public long f()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public int g()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean h()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean i()
  {
    return this instanceof dn;
  }
  
  public boolean j()
  {
    return this instanceof dt;
  }
  
  public boolean k()
  {
    return this instanceof dv;
  }
  
  public boolean l()
  {
    return this instanceof ds;
  }
  
  public dt m()
  {
    if (j()) {
      return (dt)this;
    }
    throw new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(this)));
  }
  
  public dn n()
  {
    if (i()) {
      return (dn)this;
    }
    throw new IllegalStateException("This is not a JSON Array.");
  }
  
  public dv o()
  {
    if (k()) {
      return (dv)this;
    }
    throw new IllegalStateException("This is not a JSON Primitive.");
  }
  
  Boolean p()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      fh localfh = new fh((Writer)localObject);
      localfh.b(true);
      eq.a(this, localfh);
      localObject = ((StringWriter)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dq
 * JD-Core Version:    0.7.0.1
 */