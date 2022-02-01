package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaPlatformLayout
  extends LinearLayout
{
  public static String TAG = "KindaPlatformLayout";
  private i Olj;
  
  public KindaPlatformLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67928);
    this.Olj = new i();
    AppMethodBeat.o(67928);
  }
  
  public KindaPlatformLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67929);
    this.Olj = new i();
    AppMethodBeat.o(67929);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(67932);
    long l = System.currentTimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    l = System.currentTimeMillis() - l;
    i locali = this.Olj;
    locali.valLayout += l;
    Log.i(TAG, "testandroid root layout out %s %s", new Object[] { Long.valueOf(l), this.Olj.result() });
    AppMethodBeat.o(67932);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67930);
    long l = System.currentTimeMillis();
    super.onMeasure(paramInt1, paramInt2);
    l = System.currentTimeMillis() - l;
    i locali = this.Olj;
    locali.valMeasure += l;
    Log.i(TAG, "testandroid root measure out %s %s", new Object[] { Long.valueOf(l), this.Olj.result() });
    AppMethodBeat.o(67930);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(67931);
    super.requestLayout();
    AppMethodBeat.o(67931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.KindaPlatformLayout
 * JD-Core Version:    0.7.0.1
 */