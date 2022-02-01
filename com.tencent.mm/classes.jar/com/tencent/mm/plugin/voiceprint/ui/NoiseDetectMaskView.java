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
  ProgressBar ixl;
  private Context mContext;
  TextView rya;
  TextView zel;
  private b zem;
  private a zen;
  
  public NoiseDetectMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29824);
    this.ixl = null;
    this.mContext = null;
    this.mContext = paramContext;
    this.mContext.getSystemService("layout_inflater");
    LayoutInflater.from(this.mContext).inflate(2131495025, this);
    this.ixl = ((ProgressBar)findViewById(2131302892));
    this.rya = ((TextView)findViewById(2131302891));
    this.zel = ((TextView)findViewById(2131302893));
    this.zel.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29822);
        if (NoiseDetectMaskView.a(NoiseDetectMaskView.this) != null) {
          NoiseDetectMaskView.a(NoiseDetectMaskView.this).dRz();
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
          NoiseDetectMaskView.b(NoiseDetectMaskView.this).dRy();
        }
        AppMethodBeat.o(29823);
      }
    });
    AppMethodBeat.o(29824);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29825);
    if (this.ixl != null) {
      this.ixl.setVisibility(0);
    }
    this.rya.setText(2131764743);
    this.zel.setVisibility(8);
    AppMethodBeat.o(29825);
  }
  
  public void setOnCancelDetectCallback(a parama)
  {
    this.zen = parama;
  }
  
  public void setOnClickRetryCallback(b paramb)
  {
    this.zem = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void dRy();
  }
  
  public static abstract interface b
  {
    public abstract void dRz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView
 * JD-Core Version:    0.7.0.1
 */