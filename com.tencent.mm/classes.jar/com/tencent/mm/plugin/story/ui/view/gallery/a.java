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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class a
  extends android.support.design.widget.a
{
  boolean ljQ;
  private ImageView oQg;
  private View vrS;
  private TextView vrT;
  private ImageView vrU;
  boolean xDc;
  d.g.a.a<y> yxA;
  d.g.a.a<y> yxB;
  boolean yxC;
  boolean yxD;
  boolean yxE;
  boolean yxF;
  private View yxs;
  private View yxt;
  private View yxu;
  private ImageView yxv;
  private ImageView yxw;
  private TextView yxx;
  d.g.a.a<y> yxy;
  d.g.a.a<y> yxz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120325);
    this.ljQ = true;
    this.yxD = true;
    this.yxF = true;
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
    this.yxs = findViewById(2131305335);
    this.yxt = findViewById(2131305343);
    this.yxu = findViewById(2131305340);
    this.oQg = ((ImageView)findViewById(2131305336));
    this.yxv = ((ImageView)findViewById(2131305344));
    this.yxw = ((ImageView)findViewById(2131305341));
    this.yxx = ((TextView)findViewById(2131305342));
    this.vrS = findViewById(2131305337);
    this.vrS = findViewById(2131305337);
    this.vrT = ((TextView)findViewById(2131305339));
    this.vrU = ((ImageView)findViewById(2131305338));
    paramBundle = getContext();
    k.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131099803);
    paramBundle = this.oQg;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(am.i(getContext(), 2131690044, i));
    }
    paramBundle = this.yxv;
    Context localContext1;
    Context localContext2;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      k.g(localContext2, "context");
      paramBundle.setImageDrawable(am.i(localContext1, 2131690644, localContext2.getResources().getColor(2131099664)));
    }
    paramBundle = this.vrU;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      k.g(localContext2, "context");
      paramBundle.setImageDrawable(am.i(localContext1, 2131690657, localContext2.getResources().getColor(2131099664)));
    }
    paramBundle = this.yxt;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    }
    if (this.yxC)
    {
      paramBundle = this.yxt;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    if (this.ljQ)
    {
      paramBundle = this.yxs;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.yxs;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a(this));
      }
      if (!this.yxD) {
        break label717;
      }
      paramBundle = this.yxu;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.yxu;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      if (!this.xDc) {
        break label640;
      }
      paramBundle = this.yxw;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        k.g(localContext2, "context");
        paramBundle.setImageDrawable(am.i(localContext1, 2131690671, localContext2.getResources().getColor(2131099664)));
      }
      paramBundle = this.yxx;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(2131764233));
      }
      label510:
      if ((!this.yxF) || (!com.tencent.mm.plugin.story.c.a.a.ydB.dGf())) {
        break label764;
      }
      paramBundle = this.vrS;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.vrS;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      if (!this.yxE) {
        break label735;
      }
      paramBundle = this.vrT;
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
      paramBundle = this.yxs;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label640:
      paramBundle = this.yxw;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        k.g(localContext2, "context");
        paramBundle.setImageDrawable(am.i(localContext1, 2131690590, localContext2.getResources().getColor(2131099664)));
      }
      paramBundle = this.yxx;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setText((CharSequence)getContext().getString(2131764234));
      break label510;
      label717:
      paramBundle = this.yxu;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setVisibility(8);
      break label510;
      label735:
      paramBundle = this.vrT;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)getContext().getString(2131764231));
        continue;
        label764:
        paramBundle = this.vrS;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
    }
    label782:
    AppMethodBeat.o(120324);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120320);
      paramView = this.yxG.yxy;
      if (paramView != null) {
        paramView.invoke();
      }
      this.yxG.dismiss();
      AppMethodBeat.o(120320);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120321);
      paramView = this.yxG.yxB;
      if (paramView != null) {
        paramView.invoke();
      }
      this.yxG.dismiss();
      AppMethodBeat.o(120321);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120322);
      paramView = this.yxG.yxA;
      if (paramView != null) {
        paramView.invoke();
      }
      this.yxG.dismiss();
      AppMethodBeat.o(120322);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120323);
      paramView = this.yxG.yxz;
      if (paramView != null) {
        paramView.invoke();
      }
      this.yxG.dismiss();
      AppMethodBeat.o(120323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a
 * JD-Core Version:    0.7.0.1
 */