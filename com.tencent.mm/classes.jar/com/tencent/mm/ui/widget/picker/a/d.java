package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements e<Integer>
{
  private c LyF;
  private int iNj;
  private int iNk;
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200546);
    a(paramInt1, paramInt2, null);
    AppMethodBeat.o(200546);
  }
  
  public d(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(200544);
    a(paramInt1, paramInt2, paramc);
    AppMethodBeat.o(200544);
  }
  
  private void a(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(200545);
    this.LyF = paramc;
    if (this.LyF == null) {
      this.LyF = new a();
    }
    this.iNj = paramInt1;
    this.iNk = paramInt2;
    AppMethodBeat.o(200545);
  }
  
  public int getItemsCount()
  {
    return this.iNk - this.iNj + 1;
  }
  
  public int getMaxValue()
  {
    return this.iNk;
  }
  
  public int getMinValue()
  {
    return this.iNj;
  }
  
  public String qO(int paramInt)
  {
    AppMethodBeat.i(200548);
    Object localObject = qP(paramInt);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((Integer)localObject).toString())
    {
      localObject = this.LyF.Ji((String)localObject);
      AppMethodBeat.o(200548);
      return localObject;
    }
  }
  
  public Integer qP(int paramInt)
  {
    AppMethodBeat.i(200547);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      int i = this.iNj;
      AppMethodBeat.o(200547);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(200547);
    return null;
  }
  
  final class a
    implements c
  {
    a() {}
    
    public final String Ji(String paramString)
    {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.d
 * JD-Core Version:    0.7.0.1
 */