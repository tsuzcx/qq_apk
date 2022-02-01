package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  implements e<Integer>
{
  private c HKk;
  private int hRi;
  private int hRj;
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195356);
    a(paramInt1, paramInt2, null);
    AppMethodBeat.o(195356);
  }
  
  public d(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(195354);
    a(paramInt1, paramInt2, paramc);
    AppMethodBeat.o(195354);
  }
  
  private void a(int paramInt1, int paramInt2, c paramc)
  {
    AppMethodBeat.i(195355);
    this.HKk = paramc;
    if (this.HKk == null) {
      this.HKk = new a();
    }
    this.hRi = paramInt1;
    this.hRj = paramInt2;
    AppMethodBeat.o(195355);
  }
  
  public int getItemsCount()
  {
    return this.hRj - this.hRi + 1;
  }
  
  public int getMaxValue()
  {
    return this.hRj;
  }
  
  public int getMinValue()
  {
    return this.hRi;
  }
  
  public String pw(int paramInt)
  {
    AppMethodBeat.i(195358);
    Object localObject = py(paramInt);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((Integer)localObject).toString())
    {
      localObject = this.HKk.Bp((String)localObject);
      AppMethodBeat.o(195358);
      return localObject;
    }
  }
  
  public Integer py(int paramInt)
  {
    AppMethodBeat.i(195357);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      int i = this.hRi;
      AppMethodBeat.o(195357);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(195357);
    return null;
  }
  
  final class a
    implements c
  {
    a() {}
    
    public final String Bp(String paramString)
    {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.d
 * JD-Core Version:    0.7.0.1
 */