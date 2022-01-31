package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class cu
  implements Cloneable
{
  private String a;
  private String b;
  private int c;
  private List<cw> d;
  
  public cu(String paramString1, String paramString2, List<cw> paramList, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramList;
    this.c = paramInt;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final List<cw> c()
  {
    return this.d;
  }
  
  protected final Object clone()
  {
    AppMethodBeat.i(150021);
    cu localcu = (cu)super.clone();
    if (this.d != null)
    {
      localcu.d = new ArrayList(this.d.size());
      int i = 0;
      while (i < this.d.size())
      {
        localcu.d.add(new cw(((cw)this.d.get(i)).a()));
        i += 1;
      }
    }
    AppMethodBeat.o(150021);
    return localcu;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150020);
    if ((this.a == null) || (this.d == null) || (this.d.size() <= this.c))
    {
      AppMethodBeat.o(150020);
      return "";
    }
    String str = this.a + "_" + ((cw)this.d.get(this.c)).a();
    AppMethodBeat.o(150020);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cu
 * JD-Core Version:    0.7.0.1
 */