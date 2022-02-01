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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class NoiseDetectMaskView
  extends RelativeLayout
{
  TextView GRM;
  private b GRN;
  private a GRO;
  ProgressBar krF;
  private Context mContext;
  TextView xfB;
  
  public NoiseDetectMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29824);
    this.krF = null;
    this.mContext = null;
    this.mContext = paramContext;
    this.mContext.getSystemService("layout_inflater");
    LayoutInflater.from(this.mContext).inflate(2131495857, this);
    this.krF = ((ProgressBar)findViewById(2131305471));
    this.xfB = ((TextView)findViewById(2131305470));
    this.GRM = ((TextView)findViewById(2131305472));
    this.GRM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29822);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (NoiseDetectMaskView.a(NoiseDetectMaskView.this) != null) {
          NoiseDetectMaskView.a(NoiseDetectMaskView.this).fEO();
        }
        a.a(this, "com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29822);
      }
    });
    findViewById(2131303137).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29823);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (NoiseDetectMaskView.b(NoiseDetectMaskView.this) != null) {
          NoiseDetectMaskView.b(NoiseDetectMaskView.this).fEN();
        }
        a.a(this, "com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29823);
      }
    });
    AppMethodBeat.o(29824);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29825);
    if (this.krF != null) {
      this.krF.setVisibility(0);
    }
    this.xfB.setText(2131767180);
    this.GRM.setVisibility(8);
    AppMethodBeat.o(29825);
  }
  
  public void setOnCancelDetectCallback(a parama)
  {
    this.GRO = parama;
  }
  
  public void setOnClickRetryCallback(b paramb)
  {
    this.GRN = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void fEN();
  }
  
  public static abstract interface b
  {
    public abstract void fEO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView
 * JD-Core Version:    0.7.0.1
 */