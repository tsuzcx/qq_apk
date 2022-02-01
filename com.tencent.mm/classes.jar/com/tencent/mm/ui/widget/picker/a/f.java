package com.tencent.mm.ui.widget.picker.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends d
{
  private c JkH;
  public boolean JkJ;
  private int irm;
  private int irn;
  private Context mContext;
  
  public f(int paramInt1, int paramInt2, Context paramContext)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(199831);
    this.mContext = paramContext;
    this.JkH = this.JkH;
    if (this.JkH == null) {
      this.JkH = new a();
    }
    this.irm = paramInt1;
    this.irn = paramInt2;
    AppMethodBeat.o(199831);
  }
  
  public final int getItemsCount()
  {
    if (this.JkJ) {
      return this.irn - this.irm + 1 + 1;
    }
    return this.irn - this.irm + 1;
  }
  
  public final int getMaxValue()
  {
    return this.irn;
  }
  
  public final int getMinValue()
  {
    return this.irm;
  }
  
  public final String qk(int paramInt)
  {
    AppMethodBeat.i(199833);
    if ((paramInt == 0) && (this.JkJ))
    {
      str = this.mContext.getString(2131766375);
      AppMethodBeat.o(199833);
      return str;
    }
    String str = super.qk(paramInt);
    AppMethodBeat.o(199833);
    return str;
  }
  
  public final Integer ql(int paramInt)
  {
    AppMethodBeat.i(199832);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      if (this.JkJ)
      {
        i = this.irm;
        AppMethodBeat.o(199832);
        return Integer.valueOf(i + paramInt - 1);
      }
      int i = this.irm;
      AppMethodBeat.o(199832);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(199832);
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
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.f
 * JD-Core Version:    0.7.0.1
 */