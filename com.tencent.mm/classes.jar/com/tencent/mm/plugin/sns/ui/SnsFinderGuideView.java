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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.ui.ad;

public class SnsFinderGuideView
  extends RelativeLayout
{
  private a KRk;
  private Button kEt;
  
  public SnsFinderGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(246161);
    this.kEt = null;
    this.KRk = null;
    init();
    AppMethodBeat.o(246161);
  }
  
  public SnsFinderGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246164);
    this.kEt = null;
    this.KRk = null;
    init();
    AppMethodBeat.o(246164);
  }
  
  private void init()
  {
    AppMethodBeat.i(246166);
    ad.kS(getContext()).inflate(i.g.sns_finder_guide_view, this);
    this.kEt = ((Button)findViewById(i.f.sns_finder_guide_ok_btn));
    this.kEt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216970);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (SnsFinderGuideView.a(SnsFinderGuideView.this) != null) {
          SnsFinderGuideView.a(SnsFinderGuideView.this);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216970);
      }
    });
    AppMethodBeat.o(246166);
  }
  
  public void setOnFinishDialogViewCallback(a parama)
  {
    this.KRk = parama;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsFinderGuideView
 * JD-Core Version:    0.7.0.1
 */