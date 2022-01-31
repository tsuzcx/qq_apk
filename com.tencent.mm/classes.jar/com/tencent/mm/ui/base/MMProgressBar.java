package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ap;

public class MMProgressBar
  extends LinearLayout
{
  private int max;
  private ap pkE;
  private TextView qUj;
  private int zle;
  private int zlf;
  private TextView zlg;
  private MMProgressBar.a zlh;
  
  public MMProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106705);
    this.max = 100;
    this.zle = 0;
    this.zlf = 0;
    this.pkE = new ap(new MMProgressBar.1(this), false);
    inflate(getContext(), 2130970265, this);
    this.zlg = ((TextView)findViewById(2131826264));
    this.qUj = ((TextView)findViewById(2131826263));
    AppMethodBeat.o(106705);
  }
  
  private int getProgressLength()
  {
    AppMethodBeat.i(106709);
    int j = getWidth() * this.zle / this.max;
    int i = j;
    if (j < BackwardSupportUtil.b.b(getContext(), 20.0F)) {
      i = BackwardSupportUtil.b.b(getContext(), 20.0F);
    }
    AppMethodBeat.o(106709);
    return i;
  }
  
  public int getMax()
  {
    return this.max;
  }
  
  public int getProgress()
  {
    return this.zlf;
  }
  
  public void setAutoProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(106707);
    if (paramBoolean)
    {
      this.pkE.ag(40L, 40L);
      AppMethodBeat.o(106707);
      return;
    }
    this.pkE.stopTimer();
    AppMethodBeat.o(106707);
  }
  
  public void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public void setOnProgressChangedListener(MMProgressBar.a parama)
  {
    this.zlh = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(106706);
    int i = paramInt;
    if (paramInt > this.max) {
      i = this.max;
    }
    this.zlf = i;
    if (this.pkE.dtj()) {
      setAutoProgress(true);
    }
    AppMethodBeat.o(106706);
  }
  
  public void setTips(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(106708);
    this.qUj.setText(paramCharSequence);
    AppMethodBeat.o(106708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMProgressBar
 * JD-Core Version:    0.7.0.1
 */