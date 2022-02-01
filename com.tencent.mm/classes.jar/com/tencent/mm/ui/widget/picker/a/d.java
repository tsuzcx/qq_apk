package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements e<Integer>
{
  private c Lce;
  private int iKq;
  private int iKr;
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192773);
    a(paramInt1, paramInt2, null);
    AppMethodBeat.o(192773);
  }
  
  public d(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(192771);
    a(paramInt1, paramInt2, paramc);
    AppMethodBeat.o(192771);
  }
  
  private void a(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(192772);
    this.Lce = paramc;
    if (this.Lce == null) {
      this.Lce = new a();
    }
    this.iKq = paramInt1;
    this.iKr = paramInt2;
    AppMethodBeat.o(192772);
  }
  
  public int getItemsCount()
  {
    return this.iKr - this.iKq + 1;
  }
  
  public int getMaxValue()
  {
    return this.iKr;
  }
  
  public int getMinValue()
  {
    return this.iKq;
  }
  
  public String qL(int paramInt)
  {
    AppMethodBeat.i(192775);
    Object localObject = qM(paramInt);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((Integer)localObject).toString())
    {
      localObject = this.Lce.IJ((String)localObject);
      AppMethodBeat.o(192775);
      return localObject;
    }
  }
  
  public Integer qM(int paramInt)
  {
    AppMethodBeat.i(192774);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      int i = this.iKq;
      AppMethodBeat.o(192774);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(192774);
    return null;
  }
  
  final class a
    implements c
  {
    a() {}
    
    public final String IJ(String paramString)
    {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.d
 * JD-Core Version:    0.7.0.1
 */