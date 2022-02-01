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
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSelectRange", "getOnSelectRange", "setOnSelectRange", "onSetFav", "getOnSetFav", "setOnSetFav", "rangeIcon", "rangeTv", "rangeView", "initFavoriteBtn", "initNotifySnsBtn", "initRangeBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-recordvideo_release"})
public final class c
  extends android.support.design.widget.a
{
  private View wBO;
  private TextView wBP;
  private ImageView wBQ;
  private View wBR;
  private TextView wBS;
  private ImageView wBT;
  private View wBU;
  private TextView wBV;
  private ImageView wBW;
  public d.g.a.a<y> wBX;
  public boolean wBY;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76012);
    this.wBY = true;
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
    this.wBR = findViewById(2131305390);
    this.wBS = ((TextView)findViewById(2131305392));
    this.wBT = ((ImageView)findViewById(2131305391));
    this.wBO = findViewById(2131305393);
    this.wBP = ((TextView)findViewById(2131305395));
    this.wBQ = ((ImageView)findViewById(2131305394));
    this.wBU = findViewById(2131305396);
    this.wBV = ((TextView)findViewById(2131305398));
    this.wBW = ((ImageView)findViewById(2131305397));
    if (!com.tencent.mm.plugin.recordvideo.b.a.a.wpS.dve())
    {
      paramBundle = this.wBO;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      paramBundle = this.wBR;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.wBU;
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
      paramBundle = this.wBO;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.wBO;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a(this));
      }
      Context localContext1;
      Context localContext2;
      if (this.wBY)
      {
        paramBundle = this.wBP;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          k.g(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(2131764251));
        }
        paramBundle = this.wBQ;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          localContext2 = getContext();
          k.g(localContext2, "context");
          paramBundle.setImageDrawable(am.k(localContext1, 2131690602, localContext2.getResources().getColor(2131099664)));
        }
      }
      else
      {
        paramBundle = this.wBP;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          k.g(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(2131764252));
        }
        paramBundle = this.wBQ;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          localContext2 = getContext();
          k.g(localContext2, "context");
          paramBundle.setImageDrawable(am.k(localContext1, 2131690601, localContext2.getResources().getColor(2131099664)));
        }
      }
    }
    AppMethodBeat.o(76011);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(76010);
      paramView = this.wBZ.wBX;
      if (paramView != null) {
        paramView.invoke();
      }
      this.wBZ.dismiss();
      AppMethodBeat.o(76010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c
 * JD-Core Version:    0.7.0.1
 */