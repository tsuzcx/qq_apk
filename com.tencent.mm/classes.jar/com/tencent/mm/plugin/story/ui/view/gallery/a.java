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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class a
  extends android.support.design.widget.a
{
  boolean Ayy;
  private View BtG;
  private View BtH;
  private View BtI;
  private ImageView BtJ;
  private ImageView BtK;
  private TextView BtL;
  d.g.a.a<z> BtM;
  d.g.a.a<z> BtN;
  d.g.a.a<z> BtO;
  d.g.a.a<z> BtP;
  boolean BtQ;
  boolean BtR;
  boolean BtS;
  boolean BtT;
  boolean mos;
  private ImageView qdC;
  private View yci;
  private TextView ycj;
  private ImageView yck;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120325);
    this.mos = true;
    this.BtR = true;
    this.BtT = true;
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
    this.BtG = findViewById(2131305335);
    this.BtH = findViewById(2131305343);
    this.BtI = findViewById(2131305340);
    this.qdC = ((ImageView)findViewById(2131305336));
    this.BtJ = ((ImageView)findViewById(2131305344));
    this.BtK = ((ImageView)findViewById(2131305341));
    this.BtL = ((TextView)findViewById(2131305342));
    this.yci = findViewById(2131305337);
    this.yci = findViewById(2131305337);
    this.ycj = ((TextView)findViewById(2131305339));
    this.yck = ((ImageView)findViewById(2131305338));
    paramBundle = getContext();
    p.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131099803);
    paramBundle = this.qdC;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(ao.k(getContext(), 2131690044, i));
    }
    paramBundle = this.BtJ;
    Context localContext1;
    Context localContext2;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      p.g(localContext2, "context");
      paramBundle.setImageDrawable(ao.k(localContext1, 2131690644, localContext2.getResources().getColor(2131099664)));
    }
    paramBundle = this.yck;
    if (paramBundle != null)
    {
      localContext1 = getContext();
      localContext2 = getContext();
      p.g(localContext2, "context");
      paramBundle.setImageDrawable(ao.k(localContext1, 2131690657, localContext2.getResources().getColor(2131099664)));
    }
    paramBundle = this.BtH;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    }
    if (this.BtQ)
    {
      paramBundle = this.BtH;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    if (this.mos)
    {
      paramBundle = this.BtG;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.BtG;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a(this));
      }
      if (!this.BtR) {
        break label717;
      }
      paramBundle = this.BtI;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.BtI;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      if (!this.Ayy) {
        break label640;
      }
      paramBundle = this.BtK;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        p.g(localContext2, "context");
        paramBundle.setImageDrawable(ao.k(localContext1, 2131690671, localContext2.getResources().getColor(2131099664)));
      }
      paramBundle = this.BtL;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(2131764233));
      }
      label510:
      if ((!this.BtT) || (!com.tencent.mm.plugin.story.c.a.a.AZY.ekC())) {
        break label764;
      }
      paramBundle = this.yci;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.yci;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      if (!this.BtS) {
        break label735;
      }
      paramBundle = this.ycj;
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
      paramBundle = this.BtG;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label640:
      paramBundle = this.BtK;
      if (paramBundle != null)
      {
        localContext1 = getContext();
        localContext2 = getContext();
        p.g(localContext2, "context");
        paramBundle.setImageDrawable(ao.k(localContext1, 2131690590, localContext2.getResources().getColor(2131099664)));
      }
      paramBundle = this.BtL;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setText((CharSequence)getContext().getString(2131764234));
      break label510;
      label717:
      paramBundle = this.BtI;
      if (paramBundle == null) {
        break label510;
      }
      paramBundle.setVisibility(8);
      break label510;
      label735:
      paramBundle = this.ycj;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)getContext().getString(2131764231));
        continue;
        label764:
        paramBundle = this.yci;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
    }
    label782:
    AppMethodBeat.o(120324);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120320);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.BtU.BtM;
      if (paramView != null) {
        paramView.invoke();
      }
      this.BtU.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120320);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120321);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.BtU.BtP;
      if (paramView != null) {
        paramView.invoke();
      }
      this.BtU.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120321);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120322);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.BtU.BtO;
      if (paramView != null) {
        paramView.invoke();
      }
      this.BtU.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120322);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120323);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.BtU.BtN;
      if (paramView != null) {
        paramView.invoke();
      }
      this.BtU.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a
 * JD-Core Version:    0.7.0.1
 */