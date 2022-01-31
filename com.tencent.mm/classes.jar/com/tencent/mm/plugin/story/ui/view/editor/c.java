package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorMoreDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSetFav", "getOnSetFav", "setOnSetFav", "initFavoriteBtn", "initNotifySnsBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class c
  extends android.support.design.widget.c
{
  boolean sAB;
  private View sPq;
  private TextView sPr;
  private ImageView sPs;
  private View sPt;
  private TextView sPu;
  private ImageView sPv;
  a.f.a.a<y> sPw;
  a.f.a.a<y> sPx;
  boolean sPy;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138926);
    this.sPy = true;
    setContentView(2130970946);
    AppMethodBeat.o(138926);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(138925);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(134218752);
      paramBundle.clearFlags(2);
    }
    this.sPt = findViewById(2131828389);
    this.sPu = ((TextView)findViewById(2131828391));
    this.sPv = ((ImageView)findViewById(2131828390));
    this.sPq = findViewById(2131828392);
    this.sPr = ((TextView)findViewById(2131828394));
    this.sPs = ((ImageView)findViewById(2131828393));
    if (!com.tencent.mm.plugin.story.c.a.a.srz.czD())
    {
      paramBundle = this.sPq;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      paramBundle = this.sPt;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(2131823375);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setBackgroundResource(2131690605);
      AppMethodBeat.o(138925);
      return;
      paramBundle = this.sPq;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.sPq;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c.a(this));
      }
      Context localContext;
      if (this.sPy)
      {
        paramBundle = this.sPr;
        if (paramBundle != null)
        {
          localContext = getContext();
          j.p(localContext, "context");
          paramBundle.setText((CharSequence)localContext.getResources().getString(2131304150));
        }
        paramBundle = this.sPs;
        if (paramBundle != null) {
          paramBundle.setImageDrawable(aj.g(getContext(), 2131231519, -16777216));
        }
      }
      else
      {
        paramBundle = this.sPr;
        if (paramBundle != null)
        {
          localContext = getContext();
          j.p(localContext, "context");
          paramBundle.setText((CharSequence)localContext.getResources().getString(2131304151));
        }
        paramBundle = this.sPs;
        if (paramBundle != null) {
          paramBundle.setImageDrawable(aj.g(getContext(), 2131231518, -16777216));
        }
      }
    }
    AppMethodBeat.o(138925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.c
 * JD-Core Version:    0.7.0.1
 */