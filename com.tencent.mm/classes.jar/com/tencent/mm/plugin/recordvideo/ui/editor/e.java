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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSelectRange", "getOnSelectRange", "setOnSelectRange", "onSetFav", "getOnSetFav", "setOnSetFav", "rangeIcon", "rangeTv", "rangeView", "initFavoriteBtn", "initNotifySnsBtn", "initRangeBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-recordvideo_release"})
public final class e
  extends android.support.design.widget.a
{
  private View ycf;
  private TextView ycg;
  private ImageView ych;
  private View yci;
  private TextView ycj;
  private ImageView yck;
  private View ycl;
  private TextView ycm;
  private ImageView ycn;
  public d.g.a.a<z> yco;
  public boolean ycp;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76012);
    this.ycp = true;
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
    this.yci = findViewById(2131305390);
    this.ycj = ((TextView)findViewById(2131305392));
    this.yck = ((ImageView)findViewById(2131305391));
    this.ycf = findViewById(2131305393);
    this.ycg = ((TextView)findViewById(2131305395));
    this.ych = ((ImageView)findViewById(2131305394));
    this.ycl = findViewById(2131305396);
    this.ycm = ((TextView)findViewById(2131305398));
    this.ycn = ((ImageView)findViewById(2131305397));
    if (!com.tencent.mm.plugin.recordvideo.b.a.a.xNF.dIQ())
    {
      paramBundle = this.ycf;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      paramBundle = this.yci;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.ycl;
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
      paramBundle = this.ycf;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.ycf;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new a(this));
      }
      Context localContext1;
      Context localContext2;
      if (this.ycp)
      {
        paramBundle = this.ycg;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          p.g(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(2131764251));
        }
        paramBundle = this.ych;
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
        paramBundle = this.ycg;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          p.g(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(2131764252));
        }
        paramBundle = this.ych;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(76010);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog$initNotifySnsBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.ycq.yco;
      if (paramView != null) {
        paramView.invoke();
      }
      this.ycq.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog$initNotifySnsBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(76010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.e
 * JD-Core Version:    0.7.0.1
 */