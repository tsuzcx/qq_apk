package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", "privacy", "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class a
  extends c
{
  boolean iDd;
  private ImageView lzq;
  boolean rUw;
  boolean sAB;
  private View sPt;
  private TextView sPu;
  private ImageView sPv;
  boolean sRA;
  boolean sRB;
  boolean sRC;
  private View sRq;
  private View sRr;
  private View sRs;
  private ImageView sRt;
  private ImageView sRu;
  private TextView sRv;
  a.f.a.a<y> sRw;
  a.f.a.a<y> sRx;
  a.f.a.a<y> sRy;
  a.f.a.a<y> sRz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(110703);
    this.iDd = true;
    this.sRB = true;
    this.sRC = true;
    setContentView(2130970942);
    AppMethodBeat.o(110703);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110702);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(134218752);
      paramBundle.clearFlags(2);
    }
    this.sRq = findViewById(2131828348);
    this.sRr = findViewById(2131828340);
    this.sRs = findViewById(2131828345);
    this.lzq = ((ImageView)findViewById(2131828349));
    this.sRt = ((ImageView)findViewById(2131828341));
    this.sRu = ((ImageView)findViewById(2131828346));
    this.sRv = ((TextView)findViewById(2131828347));
    this.sPt = findViewById(2131828342);
    this.sPt = findViewById(2131828342);
    this.sPu = ((TextView)findViewById(2131828344));
    this.sPv = ((ImageView)findViewById(2131828343));
    paramBundle = getContext();
    j.p(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131689604);
    paramBundle = this.lzq;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(aj.g(getContext(), 2131231238, i));
    }
    paramBundle = this.sRt;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(aj.g(getContext(), 2131231531, -16777216));
    }
    paramBundle = this.sPv;
    if (paramBundle != null) {
      paramBundle.setImageDrawable(aj.g(getContext(), 2131231538, -16777216));
    }
    paramBundle = this.sRr;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new a.d(this));
    }
    if (this.sRA)
    {
      paramBundle = this.sRr;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    if (this.iDd)
    {
      paramBundle = this.sRq;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.sRq;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a.a(this));
      }
      if (!this.sRB) {
        break label625;
      }
      paramBundle = this.sRs;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.sRs;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a.c(this));
      }
      if (!this.rUw) {
        break label571;
      }
      paramBundle = this.sRu;
      if (paramBundle != null) {
        paramBundle.setImageDrawable(aj.g(getContext(), 2131231539, -16777216));
      }
      paramBundle = this.sRv;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(2131304132));
      }
      label441:
      if ((!this.sRC) || (!com.tencent.mm.plugin.story.c.a.a.srz.czq())) {
        break label672;
      }
      paramBundle = this.sPt;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.sPt;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a.b(this));
      }
      if (!this.sAB) {
        break label643;
      }
      paramBundle = this.sPu;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)getContext().getString(2131304131));
      }
    }
    for (;;)
    {
      paramBundle = findViewById(2131823375);
      if (paramBundle == null) {
        break label690;
      }
      paramBundle.setBackgroundResource(2131690605);
      AppMethodBeat.o(110702);
      return;
      paramBundle = this.sRq;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label571:
      paramBundle = this.sRu;
      if (paramBundle != null) {
        paramBundle.setImageDrawable(aj.g(getContext(), 2131231512, -16777216));
      }
      paramBundle = this.sRv;
      if (paramBundle == null) {
        break label441;
      }
      paramBundle.setText((CharSequence)getContext().getString(2131304133));
      break label441;
      label625:
      paramBundle = this.sRs;
      if (paramBundle == null) {
        break label441;
      }
      paramBundle.setVisibility(8);
      break label441;
      label643:
      paramBundle = this.sPu;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)getContext().getString(2131304130));
        continue;
        label672:
        paramBundle = this.sPt;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
    }
    label690:
    AppMethodBeat.o(110702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a
 * JD-Core Version:    0.7.0.1
 */