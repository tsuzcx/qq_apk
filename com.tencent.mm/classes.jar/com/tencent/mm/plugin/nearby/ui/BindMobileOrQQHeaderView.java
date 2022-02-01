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
  private WeImageView soo;
  private TextView wEa;
  private a wEb;
  private View.OnClickListener wEc;
  
  public BindMobileOrQQHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89803);
    this.wEc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89797);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
        paramAnonymousView.putExtra("key_upload_scene", 7);
        MMWizardActivity.al(BindMobileOrQQHeaderView.this.getContext(), paramAnonymousView);
        if (g.aDh().Cg("3") != null)
        {
          g.aDh().Cg("3").result = "1";
          f.Cl("3");
        }
        a.a(this, "com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(89797);
      }
    };
    this.wEb = a.wEf;
    aN(paramContext);
    AppMethodBeat.o(89803);
  }
  
  public BindMobileOrQQHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89802);
    this.wEc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89797);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
        paramAnonymousView.putExtra("key_upload_scene", 7);
        MMWizardActivity.al(BindMobileOrQQHeaderView.this.getContext(), paramAnonymousView);
        if (g.aDh().Cg("3") != null)
        {
          g.aDh().Cg("3").result = "1";
          f.Cl("3");
        }
        a.a(this, "com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(89797);
      }
    };
    aN(paramContext);
    AppMethodBeat.o(89802);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(89804);
    paramContext = View.inflate(paramContext, 2131494999, this);
    this.wEa = ((TextView)paramContext.findViewById(2131302701));
    this.soo = ((WeImageView)paramContext.findViewById(2131302683));
    switch (2.wEe[this.wEb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.wEc);
      this.soo.setImageResource(2131690530);
      AppMethodBeat.o(89804);
      return;
      setOnClickListener(this.wEc);
      this.soo.setImageResource(2131690548);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89801);
      wEf = new a("Mobile", 0);
      wEg = new a("UploadContact", 1);
      wEh = new a[] { wEf, wEg };
      AppMethodBeat.o(89801);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView
 * JD-Core Version:    0.7.0.1
 */