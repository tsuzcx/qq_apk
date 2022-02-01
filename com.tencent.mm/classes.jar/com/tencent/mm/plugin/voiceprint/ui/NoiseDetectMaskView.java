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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class NoiseDetectMaskView
  extends RelativeLayout
{
  TextView HDu;
  TextView UtY;
  private b UtZ;
  private a Uua;
  private Context mContext;
  ProgressBar qgC;
  
  public NoiseDetectMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29824);
    this.qgC = null;
    this.mContext = null;
    this.mContext = paramContext;
    this.mContext.getSystemService("layout_inflater");
    LayoutInflater.from(this.mContext).inflate(R.i.gmC, this);
    this.qgC = ((ProgressBar)findViewById(R.h.fRv));
    this.HDu = ((TextView)findViewById(R.h.fRu));
    this.UtY = ((TextView)findViewById(R.h.fRw));
    this.UtY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29822);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (NoiseDetectMaskView.a(NoiseDetectMaskView.this) != null) {
          NoiseDetectMaskView.a(NoiseDetectMaskView.this).hUY();
        }
        a.a(this, "com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29822);
      }
    });
    findViewById(R.h.left_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29823);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/voiceprint/ui/NoiseDetectMaskView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (NoiseDetectMaskView.b(NoiseDetectMaskView.this) != null) {
          NoiseDetectMaskView.b(NoiseDetectMaskView.this).hUX();
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
    if (this.qgC != null) {
      this.qgC.setVisibility(0);
    }
    this.HDu.setText(R.l.gYg);
    this.UtY.setVisibility(8);
    AppMethodBeat.o(29825);
  }
  
  public void setOnCancelDetectCallback(a parama)
  {
    this.Uua = parama;
  }
  
  public void setOnClickRetryCallback(b paramb)
  {
    this.UtZ = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void hUX();
  }
  
  public static abstract interface b
  {
    public abstract void hUY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView
 * JD-Core Version:    0.7.0.1
 */