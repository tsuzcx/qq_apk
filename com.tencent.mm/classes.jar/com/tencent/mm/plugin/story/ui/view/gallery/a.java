package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class a
  extends android.support.design.widget.a
{
  boolean lJI;
  private ImageView ptt;
  private View wBR;
  private TextView wBS;
  private ImageView wBT;
  boolean yPQ;
  private View zKH;
  private View zKI;
  private View zKJ;
  private ImageView zKK;
  private ImageView zKL;
  private TextView zKM;
  d.g.a.a<y> zKN;
  d.g.a.a<y> zKO;
  d.g.a.a<y> zKP;
  d.g.a.a<y> zKQ;
  boolean zKR;
  boolean zKS;
  boolean zKT;
  boolean zKU;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120325);
    this.lJI = true;
    this.zKS = true;
    this.zKU = true;
    setContentView(2131495680);
    AppMethodBeat.o(120325);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(120324);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(134218752);
      paramBundle.clearFlags(2);
    }
    this.zKH = findViewById(2131305335);
    this.zKI = findViewById(2131305343);
    this.zKJ = findViewById(2131305340);
    this.ptt = ((ImageView)findViewById(2131305336));
    this.zKK = ((ImageView)findViewById(2131305344));
    this.zKL = ((ImageView)findViewById(2131305341));
    this.zKM = ((TextView)findViewById(2131305342));
    this.wBR = findViewById(2131305337);
    this.wBR = findViewById(2131305337);
    this.wBS = ((TextView)findViewById(2131305339));
    this.wBT = ((ImageView)findViewById(2131305338));
    paramBundle = getContext();
    k.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131099803);
    paramBundle = this.ptt;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(am.k(getContext(), 2131690044, i));
    }
    paramBundle = this.zKK;
    Context localContext1;
    Context localContext2;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      k.g(localContext2, "context");
      paramBundle.setImageDrawable(am.k(localContext1, 2131690644, localContext2.getResources().getColor(2131099664)));
    }
    paramBundle = this.wBT;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      k.g(localContext2, "context");
      paramBundle.setImageDrawable(am.k(localContext1, 2131690657, localContext2.getResources().getColor(2131099664)));
    }
    paramBundle = this.zKI;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    }
    if (this.zKR)
    {
      paramBundle = this.zKI;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    if (this.lJI)
    {
      paramBundle = this.zKH;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.zKH;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a(this));
      }
      if (!this.zKS) {
        break label717;
      }
      paramBundle = this.zKJ;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.zKJ;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      if (!this.yPQ) {
        break label640;
      }
      paramBundle = this.zKL;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        k.g(localContext2, "context");
        paramBundle.setImageDrawable(am.k(localContext1, 2131690671, localContext2.getResources().getColor(2131099664)));
      }
      paramBundle = this.zKM;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(2131764233));
      }
      label510:
      if ((!this.zKU) || (!com.tencent.mm.plugin.story.c.a.a.zqB.dUG())) {
        break label764;
      }
      paramBundle = this.wBR;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.wBR;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      if (!this.zKT) {
        break label735;
      }
      paramBundle = this.wBS;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(2131764232));
      }
    }
    for (;;)
    {
      paramBundle = findViewById(2131299011);
      if (paramBundle == null) {
        break label782;
      }
      paramBundle.setBackgroundResource(2131101053);
      AppMethodBeat.o(120324);
      return;
      paramBundle = this.zKH;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label640:
      paramBundle = this.zKL;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        k.g(localContext2, "context");
        paramBundle.setImageDrawable(am.k(localContext1, 2131690590, localContext2.getResources().getColor(2131099664)));
      }
      paramBundle = this.zKM;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setText((CharSequence)getContext().getString(2131764234));
      break label510;
      label717:
      paramBundle = this.zKJ;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setVisibility(8);
      break label510;
      label735:
      paramBundle = this.wBS;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)getContext().getString(2131764231));
        continue;
        label764:
        paramBundle = this.wBR;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
    }
    label782:
    AppMethodBeat.o(120324);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120320);
      paramView = this.zKV.zKN;
      if (paramView != null) {
        paramView.invoke();
      }
      this.zKV.dismiss();
      AppMethodBeat.o(120320);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120321);
      paramView = this.zKV.zKQ;
      if (paramView != null) {
        paramView.invoke();
      }
      this.zKV.dismiss();
      AppMethodBeat.o(120321);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120322);
      paramView = this.zKV.zKP;
      if (paramView != null) {
        paramView.invoke();
      }
      this.zKV.dismiss();
      AppMethodBeat.o(120322);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120323);
      paramView = this.zKV.zKO;
      if (paramView != null) {
        paramView.invoke();
      }
      this.zKV.dismiss();
      AppMethodBeat.o(120323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a
 * JD-Core Version:    0.7.0.1
 */