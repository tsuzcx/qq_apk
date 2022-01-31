package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NoiseDetectMaskView
  extends RelativeLayout
{
  ProgressBar gJE;
  private Context mContext;
  TextView nca;
  TextView tsa;
  private NoiseDetectMaskView.b tsb;
  private NoiseDetectMaskView.a tsc;
  
  public NoiseDetectMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26143);
    this.gJE = null;
    this.mContext = null;
    this.mContext = paramContext;
    this.mContext.getSystemService("layout_inflater");
    LayoutInflater.from(this.mContext).inflate(2130970364, this);
    this.gJE = ((ProgressBar)findViewById(2131826555));
    this.nca = ((TextView)findViewById(2131826556));
    this.tsa = ((TextView)findViewById(2131826557));
    this.tsa.setOnClickListener(new NoiseDetectMaskView.1(this));
    findViewById(2131823924).setOnClickListener(new NoiseDetectMaskView.2(this));
    AppMethodBeat.o(26143);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(26144);
    if (this.gJE != null) {
      this.gJE.setVisibility(0);
    }
    this.nca.setText(2131304570);
    this.tsa.setVisibility(8);
    AppMethodBeat.o(26144);
  }
  
  public void setOnCancelDetectCallback(NoiseDetectMaskView.a parama)
  {
    this.tsc = parama;
  }
  
  public void setOnClickRetryCallback(NoiseDetectMaskView.b paramb)
  {
    this.tsb = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView
 * JD-Core Version:    0.7.0.1
 */