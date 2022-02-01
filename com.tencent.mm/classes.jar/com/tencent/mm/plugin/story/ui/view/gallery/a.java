package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.google.android.material.bottomsheet.a
{
  private View NWg;
  private TextView NWh;
  private ImageView NWi;
  boolean RvP;
  kotlin.g.a.a<ah> SAa;
  kotlin.g.a.a<ah> SAb;
  kotlin.g.a.a<ah> SAc;
  boolean SAd;
  boolean SAe;
  boolean SAf;
  boolean SAg;
  private View SzU;
  private View SzV;
  private View SzW;
  private ImageView SzX;
  private ImageView SzY;
  kotlin.g.a.a<ah> SzZ;
  boolean tGy;
  private TextView xta;
  private ImageView ymf;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120325);
    this.tGy = true;
    this.SAe = true;
    this.SAg = true;
    setContentView(a.e.SgB);
    AppMethodBeat.o(120325);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(367687);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.SAb;
    if (paramView != null) {
      paramView.invoke();
    }
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367687);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(367692);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.SAc;
    if (paramView != null) {
      paramView.invoke();
    }
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367692);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(367698);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.SzZ;
    if (paramView != null) {
      paramView.invoke();
    }
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367698);
  }
  
  private static final void d(a parama, View paramView)
  {
    AppMethodBeat.i(367702);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.SAa;
    if (paramView != null) {
      paramView.invoke();
    }
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367702);
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
    this.SzU = findViewById(a.d.SeV);
    this.SzV = findViewById(a.d.Sfd);
    this.SzW = findViewById(a.d.Sfa);
    this.ymf = ((ImageView)findViewById(a.d.SeW));
    this.SzX = ((ImageView)findViewById(a.d.Sfe));
    this.SzY = ((ImageView)findViewById(a.d.Sfb));
    this.xta = ((TextView)findViewById(a.d.Sfc));
    this.NWg = findViewById(a.d.SeX);
    this.NWg = findViewById(a.d.SeX);
    this.NWh = ((TextView)findViewById(a.d.SeZ));
    this.NWi = ((ImageView)findViewById(a.d.SeY));
    int i = getContext().getResources().getColor(a.a.Red);
    paramBundle = this.ymf;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(bb.m(getContext(), a.f.delete_icon_nor, i));
    }
    paramBundle = this.SzX;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(bb.m(getContext(), a.f.icons_outlined_refresh, getContext().getResources().getColor(a.a.BW_0_Alpha_0_9)));
    }
    paramBundle = this.NWi;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(bb.m(getContext(), a.f.icons_outlined_star, getContext().getResources().getColor(a.a.BW_0_Alpha_0_9)));
    }
    paramBundle = this.SzV;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new a..ExternalSyntheticLambda3(this));
    }
    if (this.SAd)
    {
      paramBundle = this.SzV;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    if (this.tGy)
    {
      paramBundle = this.SzU;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.SzU;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new a..ExternalSyntheticLambda0(this));
      }
      if (!this.SAe) {
        break label666;
      }
      paramBundle = this.SzW;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.SzW;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new a..ExternalSyntheticLambda1(this));
      }
      if (!this.RvP) {
        break label601;
      }
      paramBundle = this.SzY;
      if (paramBundle != null) {
        paramBundle.setImageDrawable(bb.m(getContext(), a.f.icons_outlined_unlock, getContext().getResources().getColor(a.a.BW_0_Alpha_0_9)));
      }
      paramBundle = this.xta;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(a.g.Shw));
      }
      label474:
      if ((!this.SAg) || (!com.tencent.mm.plugin.story.c.a.a.SiJ.huP())) {
        break label713;
      }
      paramBundle = this.NWg;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.NWg;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new a..ExternalSyntheticLambda2(this));
      }
      if (!this.SAf) {
        break label684;
      }
      paramBundle = this.NWh;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(a.g.Shv));
      }
    }
    for (;;)
    {
      paramBundle = findViewById(a.d.design_bottom_sheet);
      if (paramBundle != null) {
        paramBundle.setBackgroundResource(a.a.transparent);
      }
      AppMethodBeat.o(120324);
      return;
      paramBundle = this.SzU;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label601:
      paramBundle = this.SzY;
      if (paramBundle != null) {
        paramBundle.setImageDrawable(bb.m(getContext(), a.f.icons_outlined_lock, getContext().getResources().getColor(a.a.BW_0_Alpha_0_9)));
      }
      paramBundle = this.xta;
      if (paramBundle == null) {
        break label474;
      }
      paramBundle.setText((CharSequence)getContext().getString(a.g.Sfc));
      break label474;
      label666:
      paramBundle = this.SzW;
      if (paramBundle == null) {
        break label474;
      }
      paramBundle.setVisibility(8);
      break label474;
      label684:
      paramBundle = this.NWh;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)getContext().getString(a.g.SeZ));
        continue;
        label713:
        paramBundle = this.NWg;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a
 * JD-Core Version:    0.7.0.1
 */