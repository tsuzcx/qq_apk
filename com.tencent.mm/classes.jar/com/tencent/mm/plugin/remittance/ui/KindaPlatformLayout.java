package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class KindaPlatformLayout
  extends LinearLayout
{
  public static String TAG = "KindaPlatformLayout";
  private h qkX;
  
  public KindaPlatformLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142133);
    this.qkX = new h();
    AppMethodBeat.o(142133);
  }
  
  public KindaPlatformLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142134);
    this.qkX = new h();
    AppMethodBeat.o(142134);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142137);
    long l = System.currentTimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    l = System.currentTimeMillis() - l;
    h localh = this.qkX;
    localh.valLayout += l;
    ab.i(TAG, "testandroid root layout out %s %s", new Object[] { Long.valueOf(l), this.qkX.result() });
    AppMethodBeat.o(142137);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142135);
    long l = System.currentTimeMillis();
    super.onMeasure(paramInt1, paramInt2);
    l = System.currentTimeMillis() - l;
    h localh = this.qkX;
    localh.valMeasure += l;
    ab.i(TAG, "testandroid root measure out %s %s", new Object[] { Long.valueOf(l), this.qkX.result() });
    AppMethodBeat.o(142135);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(142136);
    super.requestLayout();
    AppMethodBeat.o(142136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.KindaPlatformLayout
 * JD-Core Version:    0.7.0.1
 */