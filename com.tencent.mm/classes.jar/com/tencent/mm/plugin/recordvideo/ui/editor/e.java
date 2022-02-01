package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSelectRange", "getOnSelectRange", "setOnSelectRange", "onSetFav", "getOnSetFav", "setOnSetFav", "rangeIcon", "rangeTv", "rangeView", "initFavoriteBtn", "initNotifySnsBtn", "initRangeBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-recordvideo_release"})
public final class e
  extends android.support.design.widget.a
{
  private View Cdi;
  private TextView Cdj;
  private ImageView Cdk;
  private View Cdl;
  private TextView Cdm;
  private ImageView Cdn;
  private View Cdo;
  private TextView Cdp;
  private ImageView Cdq;
  public kotlin.g.a.a<x> Cdr;
  public boolean Cds;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76012);
    this.Cds = true;
    setContentView(2131496589);
    AppMethodBeat.o(76012);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(76011);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(134218752);
      paramBundle.clearFlags(2);
    }
    this.Cdl = findViewById(2131308596);
    this.Cdm = ((TextView)findViewById(2131308598));
    this.Cdn = ((ImageView)findViewById(2131308597));
    this.Cdi = findViewById(2131308599);
    this.Cdj = ((TextView)findViewById(2131308601));
    this.Cdk = ((ImageView)findViewById(2131308600));
    this.Cdo = findViewById(2131308602);
    this.Cdp = ((TextView)findViewById(2131308604));
    this.Cdq = ((ImageView)findViewById(2131308603));
    if (!com.tencent.mm.plugin.recordvideo.b.a.a.BNL.eJD())
    {
      paramBundle = this.Cdi;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      paramBundle = this.Cdl;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.Cdo;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(2131299514);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setBackgroundResource(2131101287);
      AppMethodBeat.o(76011);
      return;
      paramBundle = this.Cdi;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.Cdi;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e.a(this));
      }
      Context localContext1;
      Context localContext2;
      if (this.Cds)
      {
        paramBundle = this.Cdj;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          p.g(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(2131766508));
        }
        paramBundle = this.Cdk;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          localContext2 = getContext();
          p.g(localContext2, "context");
          paramBundle.setImageDrawable(ar.m(localContext1, 2131690842, localContext2.getResources().getColor(2131099669)));
        }
      }
      else
      {
        paramBundle = this.Cdj;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          p.g(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(2131766509));
        }
        paramBundle = this.Cdk;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          localContext2 = getContext();
          p.g(localContext2, "context");
          paramBundle.setImageDrawable(ar.m(localContext1, 2131690841, localContext2.getResources().getColor(2131099669)));
        }
      }
    }
    AppMethodBeat.o(76011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.e
 * JD-Core Version:    0.7.0.1
 */