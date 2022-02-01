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
  TextView BWm;
  private b BWn;
  private a BWo;
  ProgressBar jqx;
  private Context mContext;
  TextView tDL;
  
  public NoiseDetectMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29824);
    this.jqx = null;
    this.mContext = null;
    this.mContext = paramContext;
    this.mContext.getSystemService("layout_inflater");
    LayoutInflater.from(this.mContext).inflate(2131495025, this);
    this.jqx = ((ProgressBar)findViewById(2131302892));
    this.tDL = ((TextView)findViewById(2131302891));
    this.BWm = ((TextView)findViewById(2131302893));
    this.BWm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29822);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (NoiseDetectMaskView.a(NoiseDetectMaskView.this) != null) {
          NoiseDetectMaskView.a(NoiseDetectMaskView.this).euu();
        }
        a.a(this, "com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29822);
      }
    });
    findViewById(2131301383).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29823);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (NoiseDetectMaskView.b(NoiseDetectMaskView.this) != null) {
          NoiseDetectMaskView.b(NoiseDetectMaskView.this).eut();
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
    if (this.jqx != null) {
      this.jqx.setVisibility(0);
    }
    this.tDL.setText(2131764743);
    this.BWm.setVisibility(8);
    AppMethodBeat.o(29825);
  }
  
  public void setOnCancelDetectCallback(a parama)
  {
    this.BWo = parama;
  }
  
  public void setOnClickRetryCallback(b paramb)
  {
    this.BWn = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void eut();
  }
  
  public static abstract interface b
  {
    public abstract void euu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView
 * JD-Core Version:    0.7.0.1
 */