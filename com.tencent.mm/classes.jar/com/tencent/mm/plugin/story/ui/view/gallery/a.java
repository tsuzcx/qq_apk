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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class a
  extends com.google.android.material.bottomsheet.a
{
  private View HZA;
  private TextView HZB;
  private ImageView HZC;
  boolean KVS;
  kotlin.g.a.a<x> LYA;
  kotlin.g.a.a<x> LYB;
  kotlin.g.a.a<x> LYC;
  kotlin.g.a.a<x> LYD;
  boolean LYE;
  boolean LYF;
  boolean LYG;
  boolean LYH;
  private View LYu;
  private View LYv;
  private View LYw;
  private ImageView LYx;
  private ImageView LYy;
  private TextView LYz;
  boolean qBp;
  private ImageView vae;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120325);
    this.qBp = true;
    this.LYF = true;
    this.LYH = true;
    setContentView(a.e.LCQ);
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
    this.LYu = findViewById(com.tencent.mm.plugin.story.a.d.LBk);
    this.LYv = findViewById(com.tencent.mm.plugin.story.a.d.LBs);
    this.LYw = findViewById(com.tencent.mm.plugin.story.a.d.LBp);
    this.vae = ((ImageView)findViewById(com.tencent.mm.plugin.story.a.d.LBl));
    this.LYx = ((ImageView)findViewById(com.tencent.mm.plugin.story.a.d.LBt));
    this.LYy = ((ImageView)findViewById(com.tencent.mm.plugin.story.a.d.LBq));
    this.LYz = ((TextView)findViewById(com.tencent.mm.plugin.story.a.d.LBr));
    this.HZA = findViewById(com.tencent.mm.plugin.story.a.d.LBm);
    this.HZA = findViewById(com.tencent.mm.plugin.story.a.d.LBm);
    this.HZB = ((TextView)findViewById(com.tencent.mm.plugin.story.a.d.LBo));
    this.HZC = ((ImageView)findViewById(com.tencent.mm.plugin.story.a.d.LBn));
    paramBundle = getContext();
    p.j(paramBundle, "context");
    int i = paramBundle.getResources().getColor(com.tencent.mm.plugin.story.a.a.Red);
    paramBundle = this.vae;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(au.o(getContext(), a.f.delete_icon_nor, i));
    }
    paramBundle = this.LYx;
    Context localContext1;
    Context localContext2;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      i = a.f.icons_outlined_refresh;
      localContext2 = getContext();
      p.j(localContext2, "context");
      paramBundle.setImageDrawable(au.o(localContext1, i, localContext2.getResources().getColor(com.tencent.mm.plugin.story.a.a.BW_0_Alpha_0_9)));
    }
    paramBundle = this.HZC;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      i = a.f.icons_outlined_star;
      localContext2 = getContext();
      p.j(localContext2, "context");
      paramBundle.setImageDrawable(au.o(localContext1, i, localContext2.getResources().getColor(com.tencent.mm.plugin.story.a.a.BW_0_Alpha_0_9)));
    }
    paramBundle = this.LYv;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    }
    if (this.LYE)
    {
      paramBundle = this.LYv;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    if (this.qBp)
    {
      paramBundle = this.LYu;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.LYu;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a(this));
      }
      if (!this.LYF) {
        break label746;
      }
      paramBundle = this.LYw;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.LYw;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      if (!this.KVS) {
        break label666;
      }
      paramBundle = this.LYy;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        i = a.f.icons_outlined_unlock;
        localContext2 = getContext();
        p.j(localContext2, "context");
        paramBundle.setImageDrawable(au.o(localContext1, i, localContext2.getResources().getColor(com.tencent.mm.plugin.story.a.a.BW_0_Alpha_0_9)));
      }
      paramBundle = this.LYz;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(a.g.LDL));
      }
      label536:
      if ((!this.LYH) || (!com.tencent.mm.plugin.story.c.a.a.LEY.gbw())) {
        break label793;
      }
      paramBundle = this.HZA;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.HZA;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      if (!this.LYG) {
        break label764;
      }
      paramBundle = this.HZB;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(a.g.LDK));
      }
    }
    for (;;)
    {
      paramBundle = findViewById(com.tencent.mm.plugin.story.a.d.design_bottom_sheet);
      if (paramBundle == null) {
        break label811;
      }
      paramBundle.setBackgroundResource(com.tencent.mm.plugin.story.a.a.transparent);
      AppMethodBeat.o(120324);
      return;
      paramBundle = this.LYu;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label666:
      paramBundle = this.LYy;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        i = a.f.icons_outlined_lock;
        localContext2 = getContext();
        p.j(localContext2, "context");
        paramBundle.setImageDrawable(au.o(localContext1, i, localContext2.getResources().getColor(com.tencent.mm.plugin.story.a.a.BW_0_Alpha_0_9)));
      }
      paramBundle = this.LYz;
      if (paramBundle == null) {
        break label536;
      }
      paramBundle.setText((CharSequence)getContext().getString(a.g.LBr));
      break label536;
      label746:
      paramBundle = this.LYw;
      if (paramBundle == null) {
        break label536;
      }
      paramBundle.setVisibility(8);
      break label536;
      label764:
      paramBundle = this.HZB;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)getContext().getString(a.g.LBo));
        continue;
        label793:
        paramBundle = this.HZA;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
    }
    label811:
    AppMethodBeat.o(120324);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120320);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.LYI.LYA;
      if (paramView != null) {
        paramView.invoke();
      }
      this.LYI.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120320);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120321);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.LYI.LYD;
      if (paramView != null) {
        paramView.invoke();
      }
      this.LYI.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120321);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120322);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.LYI.LYC;
      if (paramView != null) {
        paramView.invoke();
      }
      this.LYI.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120322);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120323);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.LYI.LYB;
      if (paramView != null) {
        paramView.invoke();
      }
      this.LYI.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a
 * JD-Core Version:    0.7.0.1
 */