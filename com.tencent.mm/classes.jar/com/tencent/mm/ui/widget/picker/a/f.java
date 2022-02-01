package com.tencent.mm.ui.widget.picker.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends d
{
  private c HKk;
  public boolean HKm;
  private int hRi;
  private int hRj;
  private Context mContext;
  
  public f(int paramInt1, int paramInt2, Context paramContext)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(195360);
    this.mContext = paramContext;
    this.HKk = this.HKk;
    if (this.HKk == null) {
      this.HKk = new a();
    }
    this.hRi = paramInt1;
    this.hRj = paramInt2;
    AppMethodBeat.o(195360);
  }
  
  public final int getItemsCount()
  {
    if (this.HKm) {
      return this.hRj - this.hRi + 1 + 1;
    }
    return this.hRj - this.hRi + 1;
  }
  
  public final int getMaxValue()
  {
    return this.hRj;
  }
  
  public final int getMinValue()
  {
    return this.hRi;
  }
  
  public final String pw(int paramInt)
  {
    AppMethodBeat.i(195362);
    if ((paramInt == 0) && (this.HKm))
    {
      str = this.mContext.getString(2131766375);
      AppMethodBeat.o(195362);
      return str;
    }
    String str = super.pw(paramInt);
    AppMethodBeat.o(195362);
    return str;
  }
  
  public final Integer py(int paramInt)
  {
    AppMethodBeat.i(195361);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      if (this.HKm)
      {
        i = this.hRi;
        AppMethodBeat.o(195361);
        return Integer.valueOf(i + paramInt - 1);
      }
      int i = this.hRi;
      AppMethodBeat.o(195361);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(195361);
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
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.f
 * JD-Core Version:    0.7.0.1
 */