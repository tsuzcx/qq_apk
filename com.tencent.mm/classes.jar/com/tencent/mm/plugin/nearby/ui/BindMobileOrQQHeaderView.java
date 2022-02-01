package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.a.c;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class BindMobileOrQQHeaderView
  extends LinearLayout
{
  private TextView AzH;
  private a AzI;
  private View.OnClickListener AzJ;
  private WeImageView ubT;
  
  public BindMobileOrQQHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89803);
    this.AzJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89797);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
        paramAnonymousView.putExtra("key_upload_scene", 7);
        MMWizardActivity.ay(BindMobileOrQQHeaderView.this.getContext(), paramAnonymousView);
        if (g.aWT().KR("3") != null)
        {
          g.aWT().KR("3").result = "1";
          f.KW("3");
        }
        a.a(this, "com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(89797);
      }
    };
    this.AzI = a.AzM;
    bh(paramContext);
    AppMethodBeat.o(89803);
  }
  
  public BindMobileOrQQHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89802);
    this.AzJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89797);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
        paramAnonymousView.putExtra("key_upload_scene", 7);
        MMWizardActivity.ay(BindMobileOrQQHeaderView.this.getContext(), paramAnonymousView);
        if (g.aWT().KR("3") != null)
        {
          g.aWT().KR("3").result = "1";
          f.KW("3");
        }
        a.a(this, "com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(89797);
      }
    };
    bh(paramContext);
    AppMethodBeat.o(89802);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(89804);
    paramContext = View.inflate(paramContext, 2131495812, this);
    this.AzH = ((TextView)paramContext.findViewById(2131305255));
    this.ubT = ((WeImageView)paramContext.findViewById(2131305237));
    switch (2.AzL[this.AzI.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.AzJ);
      this.ubT.setImageResource(2131690755);
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.AzJ);
      this.ubT.setImageResource(2131690776);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89801);
      AzM = new a("Mobile", 0);
      AzN = new a("UploadContact", 1);
      AzO = new a[] { AzM, AzN };
      AppMethodBeat.o(89801);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView
 * JD-Core Version:    0.7.0.1
 */