package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NoiseDetectMaskView
  extends RelativeLayout
{
  TextView AwR;
  private b AwS;
  private a AwT;
  ProgressBar iXo;
  private Context mContext;
  TextView sGS;
  
  public NoiseDetectMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29824);
    this.iXo = null;
    this.mContext = null;
    this.mContext = paramContext;
    this.mContext.getSystemService("layout_inflater");
    LayoutInflater.from(this.mContext).inflate(2131495025, this);
    this.iXo = ((ProgressBar)findViewById(2131302892));
    this.sGS = ((TextView)findViewById(2131302891));
    this.AwR = ((TextView)findViewById(2131302893));
    this.AwR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29822);
        if (NoiseDetectMaskView.a(NoiseDetectMaskView.this) != null) {
          NoiseDetectMaskView.a(NoiseDetectMaskView.this).egJ();
        }
        AppMethodBeat.o(29822);
      }
    });
    findViewById(2131301383).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29823);
        if (NoiseDetectMaskView.b(NoiseDetectMaskView.this) != null) {
          NoiseDetectMaskView.b(NoiseDetectMaskView.this).egI();
        }
        AppMethodBeat.o(29823);
      }
    });
    AppMethodBeat.o(29824);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29825);
    if (this.iXo != null) {
      this.iXo.setVisibility(0);
    }
    this.sGS.setText(2131764743);
    this.AwR.setVisibility(8);
    AppMethodBeat.o(29825);
  }
  
  public void setOnCancelDetectCallback(a parama)
  {
    this.AwT = parama;
  }
  
  public void setOnClickRetryCallback(b paramb)
  {
    this.AwS = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void egI();
  }
  
  public static abstract interface b
  {
    public abstract void egJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView
 * JD-Core Version:    0.7.0.1
 */