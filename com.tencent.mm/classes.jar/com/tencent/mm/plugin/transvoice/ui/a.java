package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.MMBottomSheetBehavior;
import android.support.design.widget.MMBottomSheetBehavior.a;
import android.support.v7.app.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "canClosePanel", "", "cantoneseItem", "cantoneseSelected", "Landroid/widget/ImageView;", "closePanel", "englishItem", "englishSelected", "langType", "", "getLangType", "()I", "setLangType", "(I)V", "mandarinItem", "mandarinSelected", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "targetView", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setOnLanguageItemClick", "show", "updateSelectedType", "Companion", "OnLanguageItemClick", "plugin-transvoice_release"})
public final class a
  extends e
{
  public static final a.a tpQ;
  int gbb;
  private View targetView;
  private ImageView tpG;
  private ImageView tpH;
  private ImageView tpI;
  private ImageView tpJ;
  private View tpK;
  private View tpL;
  private View tpM;
  private MMBottomSheetBehavior<View> tpN;
  private boolean tpO;
  a.b tpP;
  
  static
  {
    AppMethodBeat.i(155222);
    tpQ = new a.a((byte)0);
    AppMethodBeat.o(155222);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131493698);
    AppMethodBeat.i(155221);
    this.gbb = 1;
    eS();
    AppMethodBeat.o(155221);
  }
  
  public final void cLa()
  {
    AppMethodBeat.i(155219);
    switch (this.gbb)
    {
    }
    ImageView localImageView;
    do
    {
      AppMethodBeat.o(155219);
      return;
      localImageView = this.tpH;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
      localImageView = this.tpI;
      if (localImageView != null) {
        localImageView.setVisibility(4);
      }
      localImageView = this.tpJ;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(155219);
        return;
      }
      AppMethodBeat.o(155219);
      return;
      localImageView = this.tpH;
      if (localImageView != null) {
        localImageView.setVisibility(4);
      }
      localImageView = this.tpI;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
      localImageView = this.tpJ;
      if (localImageView != null)
      {
        localImageView.setVisibility(4);
        AppMethodBeat.o(155219);
        return;
      }
      AppMethodBeat.o(155219);
      return;
      localImageView = this.tpH;
      if (localImageView != null) {
        localImageView.setVisibility(4);
      }
      localImageView = this.tpI;
      if (localImageView != null) {
        localImageView.setVisibility(4);
      }
      localImageView = this.tpJ;
    } while (localImageView == null);
    localImageView.setVisibility(0);
    AppMethodBeat.o(155219);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(155218);
    this.targetView = LayoutInflater.from(getContext()).inflate(2130969962, null, false);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    setContentView(this.targetView, localLayoutParams);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(67108864);
      paramBundle.setLayout(-1, -1);
      paramBundle.setSoftInputMode(34);
      paramBundle.setDimAmount(0.5F);
      paramBundle.setWindowAnimations(2131493120);
    }
    paramBundle = this.targetView;
    if (paramBundle != null)
    {
      this.tpG = ((ImageView)paramBundle.findViewById(2131825351));
      this.tpH = ((ImageView)paramBundle.findViewById(2131825355));
      this.tpI = ((ImageView)paramBundle.findViewById(2131825359));
      this.tpJ = ((ImageView)paramBundle.findViewById(2131825363));
      this.tpK = paramBundle.findViewById(2131825354);
      this.tpL = paramBundle.findViewById(2131825358);
      this.tpM = paramBundle.findViewById(2131825362);
    }
    paramBundle = this.tpG;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new a.c(this));
    }
    paramBundle = this.tpK;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new a.d(this));
    }
    paramBundle = this.tpL;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new a.e(this));
    }
    paramBundle = this.tpM;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new a.f(this));
    }
    paramBundle = this.targetView;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.findViewById(2131825349);; paramBundle = null)
    {
      this.tpN = MMBottomSheetBehavior.r(paramBundle);
      paramBundle = this.tpN;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new a.g(this));
      }
      cLa();
      AppMethodBeat.o(155218);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(155220);
    super.show();
    MMBottomSheetBehavior localMMBottomSheetBehavior = this.tpN;
    if (localMMBottomSheetBehavior != null)
    {
      localMMBottomSheetBehavior.bC();
      AppMethodBeat.o(155220);
      return;
    }
    AppMethodBeat.o(155220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a
 * JD-Core Version:    0.7.0.1
 */