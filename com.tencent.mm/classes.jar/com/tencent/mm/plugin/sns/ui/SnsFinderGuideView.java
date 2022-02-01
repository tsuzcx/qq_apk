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
import com.tencent.mm.ui.aa;

public class SnsFinderGuideView
  extends RelativeLayout
{
  private a EDv;
  private Button hPX;
  
  public SnsFinderGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203572);
    this.hPX = null;
    this.EDv = null;
    init();
    AppMethodBeat.o(203572);
  }
  
  public SnsFinderGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203573);
    this.hPX = null;
    this.EDv = null;
    init();
    AppMethodBeat.o(203573);
  }
  
  private void init()
  {
    AppMethodBeat.i(203574);
    aa.jQ(getContext()).inflate(2131496434, this);
    this.hPX = ((Button)findViewById(2131308120));
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203571);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SnsFinderGuideView.a(SnsFinderGuideView.this) != null) {
          SnsFinderGuideView.a(SnsFinderGuideView.this);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203571);
      }
    });
    AppMethodBeat.o(203574);
  }
  
  public void setOnFinishDialogViewCallback(a parama)
  {
    this.EDv = parama;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsFinderGuideView
 * JD-Core Version:    0.7.0.1
 */