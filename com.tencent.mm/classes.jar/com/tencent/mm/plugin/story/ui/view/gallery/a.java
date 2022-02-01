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
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class a
  extends android.support.design.widget.a
{
  boolean Ahm;
  private View Bci;
  private View Bcj;
  private View Bck;
  private ImageView Bcl;
  private ImageView Bcm;
  private TextView Bcn;
  d.g.a.a<z> Bco;
  d.g.a.a<z> Bcp;
  d.g.a.a<z> Bcq;
  d.g.a.a<z> Bcr;
  boolean Bcs;
  boolean Bct;
  boolean Bcu;
  boolean Bcv;
  boolean mjv;
  private ImageView pWX;
  private View xMo;
  private TextView xMp;
  private ImageView xMq;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120325);
    this.mjv = true;
    this.Bct = true;
    this.Bcv = true;
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
    this.Bci = findViewById(2131305335);
    this.Bcj = findViewById(2131305343);
    this.Bck = findViewById(2131305340);
    this.pWX = ((ImageView)findViewById(2131305336));
    this.Bcl = ((ImageView)findViewById(2131305344));
    this.Bcm = ((ImageView)findViewById(2131305341));
    this.Bcn = ((TextView)findViewById(2131305342));
    this.xMo = findViewById(2131305337);
    this.xMo = findViewById(2131305337);
    this.xMp = ((TextView)findViewById(2131305339));
    this.xMq = ((ImageView)findViewById(2131305338));
    paramBundle = getContext();
    p.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131099803);
    paramBundle = this.pWX;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(ao.k(getContext(), 2131690044, i));
    }
    paramBundle = this.Bcl;
    Context localContext1;
    Context localContext2;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      p.g(localContext2, "context");
      paramBundle.setImageDrawable(ao.k(localContext1, 2131690644, localContext2.getResources().getColor(2131099664)));
    }
    paramBundle = this.xMq;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      p.g(localContext2, "context");
      paramBundle.setImageDrawable(ao.k(localContext1, 2131690657, localContext2.getResources().getColor(2131099664)));
    }
    paramBundle = this.Bcj;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    }
    if (this.Bcs)
    {
      paramBundle = this.Bcj;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    if (this.mjv)
    {
      paramBundle = this.Bci;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.Bci;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a(this));
      }
      if (!this.Bct) {
        break label717;
      }
      paramBundle = this.Bck;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.Bck;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      if (!this.Ahm) {
        break label640;
      }
      paramBundle = this.Bcm;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        p.g(localContext2, "context");
        paramBundle.setImageDrawable(ao.k(localContext1, 2131690671, localContext2.getResources().getColor(2131099664)));
      }
      paramBundle = this.Bcn;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(2131764233));
      }
      label510:
      if ((!this.Bcv) || (!com.tencent.mm.plugin.story.c.a.a.AIv.egU())) {
        break label764;
      }
      paramBundle = this.xMo;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.xMo;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      if (!this.Bcu) {
        break label735;
      }
      paramBundle = this.xMp;
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
      paramBundle = this.Bci;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label640:
      paramBundle = this.Bcm;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        p.g(localContext2, "context");
        paramBundle.setImageDrawable(ao.k(localContext1, 2131690590, localContext2.getResources().getColor(2131099664)));
      }
      paramBundle = this.Bcn;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setText((CharSequence)getContext().getString(2131764234));
      break label510;
      label717:
      paramBundle = this.Bck;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setVisibility(8);
      break label510;
      label735:
      paramBundle = this.xMp;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)getContext().getString(2131764231));
        continue;
        label764:
        paramBundle = this.xMo;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
    }
    label782:
    AppMethodBeat.o(120324);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120320);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.Bcw.Bco;
      if (paramView != null) {
        paramView.invoke();
      }
      this.Bcw.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120320);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120321);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.Bcw.Bcr;
      if (paramView != null) {
        paramView.invoke();
      }
      this.Bcw.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120321);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120322);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.Bcw.Bcq;
      if (paramView != null) {
        paramView.invoke();
      }
      this.Bcw.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120322);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120323);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.Bcw.Bcp;
      if (paramView != null) {
        paramView.invoke();
      }
      this.Bcw.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a
 * JD-Core Version:    0.7.0.1
 */