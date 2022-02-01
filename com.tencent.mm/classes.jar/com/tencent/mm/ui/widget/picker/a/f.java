package com.tencent.mm.ui.widget.picker.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends d
{
  private c QUv;
  public boolean QUx;
  private int jJW;
  private int jJX;
  private Context mContext;
  
  public f(int paramInt1, int paramInt2, Context paramContext)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(198508);
    this.mContext = paramContext;
    this.QUv = this.QUv;
    if (this.QUv == null) {
      this.QUv = new a();
    }
    this.jJW = paramInt1;
    this.jJX = paramInt2;
    AppMethodBeat.o(198508);
  }
  
  public final int getItemsCount()
  {
    if (this.QUx) {
      return this.jJX - this.jJW + 1 + 1;
    }
    return this.jJX - this.jJW + 1;
  }
  
  public final int getMaxValue()
  {
    return this.jJX;
  }
  
  public final int getMinValue()
  {
    return this.jJW;
  }
  
  public final String uG(int paramInt)
  {
    AppMethodBeat.i(198510);
    if ((paramInt == 0) && (this.QUx))
    {
      str = this.mContext.getString(2131763917);
      AppMethodBeat.o(198510);
      return str;
    }
    String str = super.uG(paramInt);
    AppMethodBeat.o(198510);
    return str;
  }
  
  public final Integer uH(int paramInt)
  {
    AppMethodBeat.i(198509);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      if (this.QUx)
      {
        i = this.jJW;
        AppMethodBeat.o(198509);
        return Integer.valueOf(i + paramInt - 1);
      }
      int i = this.jJW;
      AppMethodBeat.o(198509);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(198509);
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
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.f
 * JD-Core Version:    0.7.0.1
 */