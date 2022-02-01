package com.tencent.mm.ui.widget.picker.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends d
{
  private c Lce;
  public boolean Lcg;
  private int iKq;
  private int iKr;
  private Context mContext;
  
  public f(int paramInt1, int paramInt2, Context paramContext)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(192777);
    this.mContext = paramContext;
    this.Lce = this.Lce;
    if (this.Lce == null) {
      this.Lce = new a();
    }
    this.iKq = paramInt1;
    this.iKr = paramInt2;
    AppMethodBeat.o(192777);
  }
  
  public final int getItemsCount()
  {
    if (this.Lcg) {
      return this.iKr - this.iKq + 1 + 1;
    }
    return this.iKr - this.iKq + 1;
  }
  
  public final int getMaxValue()
  {
    return this.iKr;
  }
  
  public final int getMinValue()
  {
    return this.iKq;
  }
  
  public final String qL(int paramInt)
  {
    AppMethodBeat.i(192779);
    if ((paramInt == 0) && (this.Lcg))
    {
      str = this.mContext.getString(2131766375);
      AppMethodBeat.o(192779);
      return str;
    }
    String str = super.qL(paramInt);
    AppMethodBeat.o(192779);
    return str;
  }
  
  public final Integer qM(int paramInt)
  {
    AppMethodBeat.i(192778);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      if (this.Lcg)
      {
        i = this.iKq;
        AppMethodBeat.o(192778);
        return Integer.valueOf(i + paramInt - 1);
      }
      int i = this.iKq;
      AppMethodBeat.o(192778);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(192778);
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
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.f
 * JD-Core Version:    0.7.0.1
 */