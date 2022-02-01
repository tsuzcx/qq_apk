package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements e<Integer>
{
  private c JkH;
  private int irm;
  private int irn;
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199827);
    a(paramInt1, paramInt2, null);
    AppMethodBeat.o(199827);
  }
  
  public d(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(199825);
    a(paramInt1, paramInt2, paramc);
    AppMethodBeat.o(199825);
  }
  
  private void a(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(199826);
    this.JkH = paramc;
    if (this.JkH == null) {
      this.JkH = new a();
    }
    this.irm = paramInt1;
    this.irn = paramInt2;
    AppMethodBeat.o(199826);
  }
  
  public int getItemsCount()
  {
    return this.irn - this.irm + 1;
  }
  
  public int getMaxValue()
  {
    return this.irn;
  }
  
  public int getMinValue()
  {
    return this.irm;
  }
  
  public String qk(int paramInt)
  {
    AppMethodBeat.i(199829);
    Object localObject = ql(paramInt);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((Integer)localObject).toString())
    {
      localObject = this.JkH.Ft((String)localObject);
      AppMethodBeat.o(199829);
      return localObject;
    }
  }
  
  public Integer ql(int paramInt)
  {
    AppMethodBeat.i(199828);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      int i = this.irm;
      AppMethodBeat.o(199828);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(199828);
    return null;
  }
  
  final class a
    implements c
  {
    a() {}
    
    public final String Ft(String paramString)
    {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.d
 * JD-Core Version:    0.7.0.1
 */