package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class SnsNotifyBanner
  extends RelativeLayout
{
  private TextView EHf;
  private ImageView EHg;
  int EHh;
  private a EHi;
  private View mContentView;
  private LayoutInflater mInflater;
  
  public SnsNotifyBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98934);
    this.EHh = 0;
    init();
    AppMethodBeat.o(98934);
  }
  
  public SnsNotifyBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98933);
    this.EHh = 0;
    init();
    AppMethodBeat.o(98933);
  }
  
  private void init()
  {
    AppMethodBeat.i(98935);
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.mContentView = this.mInflater.inflate(2131496468, this, true);
    this.EHf = ((TextView)this.mContentView.findViewById(2131308080));
    this.EHg = ((ImageView)this.mContentView.findViewById(2131308079));
    this.EHg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98931);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SnsNotifyBanner.this.setVisibility(8);
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98931);
      }
    });
    AppMethodBeat.o(98935);
  }
  
  public void setOnClickNotify(a parama)
  {
    AppMethodBeat.i(98936);
    this.EHi = parama;
    this.EHf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98932);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SnsNotifyBanner.a(SnsNotifyBanner.this) == null)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98932);
          return;
        }
        if (SnsNotifyBanner.this.EHh > 0)
        {
          SnsNotifyBanner.this.EHh = 0;
          SnsNotifyBanner.a(SnsNotifyBanner.this);
        }
        for (;;)
        {
          SnsNotifyBanner.this.setVisibility(8);
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotifyBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98932);
          return;
          SnsNotifyBanner.a(SnsNotifyBanner.this);
        }
      }
    });
    AppMethodBeat.o(98936);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotifyBanner
 * JD-Core Version:    0.7.0.1
 */