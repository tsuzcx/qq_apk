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
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSelectRange", "getOnSelectRange", "setOnSelectRange", "onSetFav", "getOnSetFav", "setOnSetFav", "rangeIcon", "rangeTv", "rangeView", "initFavoriteBtn", "initNotifySnsBtn", "initRangeBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-recordvideo_release"})
public final class e
  extends android.support.design.widget.a
{
  private View xMl;
  private TextView xMm;
  private ImageView xMn;
  private View xMo;
  private TextView xMp;
  private ImageView xMq;
  private View xMr;
  private TextView xMs;
  private ImageView xMt;
  public d.g.a.a<z> xMu;
  public boolean xMv;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76012);
    this.xMv = true;
    setContentView(2131495684);
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
    this.xMo = findViewById(2131305390);
    this.xMp = ((TextView)findViewById(2131305392));
    this.xMq = ((ImageView)findViewById(2131305391));
    this.xMl = findViewById(2131305393);
    this.xMm = ((TextView)findViewById(2131305395));
    this.xMn = ((ImageView)findViewById(2131305394));
    this.xMr = findViewById(2131305396);
    this.xMs = ((TextView)findViewById(2131305398));
    this.xMt = ((ImageView)findViewById(2131305397));
    if (!com.tencent.mm.plugin.recordvideo.b.a.a.xxI.dFz())
    {
      paramBundle = this.xMl;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      paramBundle = this.xMo;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.xMr;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(2131299011);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setBackgroundResource(2131101053);
      AppMethodBeat.o(76011);
      return;
      paramBundle = this.xMl;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.xMl;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e.a(this));
      }
      Context localContext1;
      Context localContext2;
      if (this.xMv)
      {
        paramBundle = this.xMm;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          p.g(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(2131764251));
        }
        paramBundle = this.xMn;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          localContext2 = getContext();
          p.g(localContext2, "context");
          paramBundle.setImageDrawable(ao.k(localContext1, 2131690602, localContext2.getResources().getColor(2131099664)));
        }
      }
      else
      {
        paramBundle = this.xMm;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          p.g(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(2131764252));
        }
        paramBundle = this.xMn;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          localContext2 = getContext();
          p.g(localContext2, "context");
          paramBundle.setImageDrawable(ao.k(localContext1, 2131690601, localContext2.getResources().getColor(2131099664)));
        }
      }
    }
    AppMethodBeat.o(76011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.e
 * JD-Core Version:    0.7.0.1
 */