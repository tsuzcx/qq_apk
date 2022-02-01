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
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class a
  extends android.support.design.widget.a
{
  private View Cdl;
  private TextView Cdm;
  private ImageView Cdn;
  boolean EHQ;
  kotlin.g.a.a<x> FEA;
  kotlin.g.a.a<x> FEB;
  kotlin.g.a.a<x> FEC;
  boolean FED;
  boolean FEE;
  boolean FEF;
  boolean FEG;
  private View FEt;
  private View FEu;
  private View FEv;
  private ImageView FEw;
  private ImageView FEx;
  private TextView FEy;
  kotlin.g.a.a<x> FEz;
  boolean nze;
  private ImageView ruA;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120325);
    this.nze = true;
    this.FEE = true;
    this.FEG = true;
    setContentView(2131496585);
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
    this.FEt = findViewById(2131308540);
    this.FEu = findViewById(2131308548);
    this.FEv = findViewById(2131308545);
    this.ruA = ((ImageView)findViewById(2131308541));
    this.FEw = ((ImageView)findViewById(2131308549));
    this.FEx = ((ImageView)findViewById(2131308546));
    this.FEy = ((TextView)findViewById(2131308547));
    this.Cdl = findViewById(2131308542);
    this.Cdl = findViewById(2131308542);
    this.Cdm = ((TextView)findViewById(2131308544));
    this.Cdn = ((ImageView)findViewById(2131308543));
    paramBundle = getContext();
    p.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131099818);
    paramBundle = this.ruA;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(ar.m(getContext(), 2131690074, i));
    }
    paramBundle = this.FEw;
    Context localContext1;
    Context localContext2;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      p.g(localContext2, "context");
      paramBundle.setImageDrawable(ar.m(localContext1, 2131690895, localContext2.getResources().getColor(2131099669)));
    }
    paramBundle = this.Cdn;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      p.g(localContext2, "context");
      paramBundle.setImageDrawable(ar.m(localContext1, 2131690911, localContext2.getResources().getColor(2131099669)));
    }
    paramBundle = this.FEu;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    }
    if (this.FED)
    {
      paramBundle = this.FEu;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    if (this.nze)
    {
      paramBundle = this.FEt;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.FEt;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a(this));
      }
      if (!this.FEE) {
        break label717;
      }
      paramBundle = this.FEv;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.FEv;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      if (!this.EHQ) {
        break label640;
      }
      paramBundle = this.FEx;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        p.g(localContext2, "context");
        paramBundle.setImageDrawable(ar.m(localContext1, 2131690927, localContext2.getResources().getColor(2131099669)));
      }
      paramBundle = this.FEy;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(2131766489));
      }
      label510:
      if ((!this.FEG) || (!com.tencent.mm.plugin.story.c.a.a.FkW.fnd())) {
        break label764;
      }
      paramBundle = this.Cdl;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.Cdl;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      if (!this.FEF) {
        break label735;
      }
      paramBundle = this.Cdm;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(2131766488));
      }
    }
    for (;;)
    {
      paramBundle = findViewById(2131299514);
      if (paramBundle == null) {
        break label782;
      }
      paramBundle.setBackgroundResource(2131101287);
      AppMethodBeat.o(120324);
      return;
      paramBundle = this.FEt;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label640:
      paramBundle = this.FEx;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        p.g(localContext2, "context");
        paramBundle.setImageDrawable(ar.m(localContext1, 2131690827, localContext2.getResources().getColor(2131099669)));
      }
      paramBundle = this.FEy;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setText((CharSequence)getContext().getString(2131766490));
      break label510;
      label717:
      paramBundle = this.FEv;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setVisibility(8);
      break label510;
      label735:
      paramBundle = this.Cdm;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)getContext().getString(2131766487));
        continue;
        label764:
        paramBundle = this.Cdl;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
    }
    label782:
    AppMethodBeat.o(120324);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120320);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.FEH.FEz;
      if (paramView != null) {
        paramView.invoke();
      }
      this.FEH.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120320);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120321);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.FEH.FEC;
      if (paramView != null) {
        paramView.invoke();
      }
      this.FEH.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120321);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120322);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.FEH.FEB;
      if (paramView != null) {
        paramView.invoke();
      }
      this.FEH.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120322);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120323);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.FEH.FEA;
      if (paramView != null) {
        paramView.invoke();
      }
      this.FEH.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a
 * JD-Core Version:    0.7.0.1
 */