package com.tencent.mm.ui.widget.picker.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends d
{
  private c LyF;
  public boolean LyH;
  private int iNj;
  private int iNk;
  private Context mContext;
  
  public f(int paramInt1, int paramInt2, Context paramContext)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(200550);
    this.mContext = paramContext;
    this.LyF = this.LyF;
    if (this.LyF == null) {
      this.LyF = new a();
    }
    this.iNj = paramInt1;
    this.iNk = paramInt2;
    AppMethodBeat.o(200550);
  }
  
  public final int getItemsCount()
  {
    if (this.LyH) {
      return this.iNk - this.iNj + 1 + 1;
    }
    return this.iNk - this.iNj + 1;
  }
  
  public final int getMaxValue()
  {
    return this.iNk;
  }
  
  public final int getMinValue()
  {
    return this.iNj;
  }
  
  public final String qO(int paramInt)
  {
    AppMethodBeat.i(200552);
    if ((paramInt == 0) && (this.LyH))
    {
      str = this.mContext.getString(2131766375);
      AppMethodBeat.o(200552);
      return str;
    }
    String str = super.qO(paramInt);
    AppMethodBeat.o(200552);
    return str;
  }
  
  public final Integer qP(int paramInt)
  {
    AppMethodBeat.i(200551);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      if (this.LyH)
      {
        i = this.iNj;
        AppMethodBeat.o(200551);
        return Integer.valueOf(i + paramInt - 1);
      }
      int i = this.iNj;
      AppMethodBeat.o(200551);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(200551);
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
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.f
 * JD-Core Version:    0.7.0.1
 */