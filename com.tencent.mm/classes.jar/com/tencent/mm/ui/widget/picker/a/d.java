package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements e<Integer>
{
  private c QUv;
  private int jJW;
  private int jJX;
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198504);
    a(paramInt1, paramInt2, null);
    AppMethodBeat.o(198504);
  }
  
  public d(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(198502);
    a(paramInt1, paramInt2, paramc);
    AppMethodBeat.o(198502);
  }
  
  private void a(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(198503);
    this.QUv = paramc;
    if (this.QUv == null) {
      this.QUv = new a();
    }
    this.jJW = paramInt1;
    this.jJX = paramInt2;
    AppMethodBeat.o(198503);
  }
  
  public int getItemsCount()
  {
    return this.jJX - this.jJW + 1;
  }
  
  public int getMaxValue()
  {
    return this.jJX;
  }
  
  public int getMinValue()
  {
    return this.jJW;
  }
  
  public String uG(int paramInt)
  {
    AppMethodBeat.i(198506);
    Object localObject = uH(paramInt);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((Integer)localObject).toString())
    {
      localObject = this.QUv.Sf((String)localObject);
      AppMethodBeat.o(198506);
      return localObject;
    }
  }
  
  public Integer uH(int paramInt)
  {
    AppMethodBeat.i(198505);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      int i = this.jJW;
      AppMethodBeat.o(198505);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(198505);
    return null;
  }
  
  final class a
    implements c
  {
    a() {}
    
    public final String Sf(String paramString)
    {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.d
 * JD-Core Version:    0.7.0.1
 */