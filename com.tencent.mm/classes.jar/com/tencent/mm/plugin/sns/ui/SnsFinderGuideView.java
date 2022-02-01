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
import com.tencent.mm.ui.z;

public class SnsFinderGuideView
  extends RelativeLayout
{
  private a AcZ;
  private Button gUt;
  
  public SnsFinderGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198353);
    this.gUt = null;
    this.AcZ = null;
    init();
    AppMethodBeat.o(198353);
  }
  
  public SnsFinderGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198354);
    this.gUt = null;
    this.AcZ = null;
    init();
    AppMethodBeat.o(198354);
  }
  
  private void init()
  {
    AppMethodBeat.i(198355);
    z.jO(getContext()).inflate(2131496488, this);
    this.gUt = ((Button)findViewById(2131308424));
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198352);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (SnsFinderGuideView.a(SnsFinderGuideView.this) != null) {
          SnsFinderGuideView.a(SnsFinderGuideView.this);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsFinderGuideView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198352);
      }
    });
    AppMethodBeat.o(198355);
  }
  
  public void setOnFinishDialogViewCallback(a parama)
  {
    this.AcZ = parama;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsFinderGuideView
 * JD-Core Version:    0.7.0.1
 */