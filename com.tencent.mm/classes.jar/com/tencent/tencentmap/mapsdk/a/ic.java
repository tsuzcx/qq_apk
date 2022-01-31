package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;

public final class ic
  extends ig
{
  int b;
  
  private ic(hu paramhu, int paramInt)
  {
    super(paramhu);
    a(paramInt);
  }
  
  public static ic a(hu paramhu, int paramInt, if paramif, Object... paramVarArgs)
  {
    paramhu = new ic(paramhu, paramInt);
    paramhu.a(paramVarArgs);
    paramhu.a(paramif);
    return paramhu;
  }
  
  public static ic a(hu paramhu, int paramInt, double... paramVarArgs)
  {
    paramhu = new ic(paramhu, paramInt);
    paramhu.a(paramVarArgs);
    return paramhu;
  }
  
  public final void a(int paramInt)
  {
    if (this.e != null)
    {
      id localid = this.e[0];
      int i = localid.b();
      this.f.remove(Integer.valueOf(i));
      this.f.put(Integer.valueOf(paramInt), localid);
    }
    this.b = paramInt;
  }
  
  public final void a(double... paramVarArgs)
  {
    if ((this.e == null) || (this.e.length == 0))
    {
      a(new id[] { id.a(this.b, paramVarArgs) });
      return;
    }
    super.a(paramVarArgs);
  }
  
  public final void a(Object... paramVarArgs)
  {
    if ((this.e == null) || (this.e.length == 0))
    {
      a(new id[] { id.a(this.b, null, paramVarArgs) });
      return;
    }
    super.a(paramVarArgs);
  }
  
  public final ic b()
  {
    return (ic)super.a();
  }
  
  public final String toString()
  {
    String str1 = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.g;
    String str2 = str1;
    if (this.e != null)
    {
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.e.length) {
          break;
        }
        str1 = str1 + "\n    " + this.e[i].toString();
        i += 1;
      }
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ic
 * JD-Core Version:    0.7.0.1
 */