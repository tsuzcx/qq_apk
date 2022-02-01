package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.ui.af;

public class SnsFinderGuideView
  extends RelativeLayout
{
  private a Rrd;
  private Button nhC;
  
  public SnsFinderGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(307705);
    this.nhC = null;
    this.Rrd = null;
    init();
    AppMethodBeat.o(307705);
  }
  
  public SnsFinderGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(307709);
    this.nhC = null;
    this.Rrd = null;
    init();
    AppMethodBeat.o(307709);
  }
  
  private void init()
  {
    AppMethodBeat.i(307711);
    af.mU(getContext()).inflate(b.g.sns_finder_guide_view, this);
    this.nhC = ((Button)findViewById(b.f.sns_finder_guide_ok_btn));
    this.nhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308467);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (SnsFinderGuideView.a(SnsFinderGuideView.this) != null) {
          SnsFinderGuideView.a(SnsFinderGuideView.this);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308467);
      }
    });
    AppMethodBeat.o(307711);
  }
  
  public void setOnFinishDialogViewCallback(a parama)
  {
    this.Rrd = parama;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsFinderGuideView
 * JD-Core Version:    0.7.0.1
 */