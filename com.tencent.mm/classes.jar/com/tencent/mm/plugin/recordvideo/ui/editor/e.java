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
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSelectRange", "getOnSelectRange", "setOnSelectRange", "onSetFav", "getOnSetFav", "setOnSetFav", "rangeIcon", "rangeTv", "rangeView", "initFavoriteBtn", "initNotifySnsBtn", "initRangeBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-recordvideo_release"})
public final class e
  extends com.google.android.material.bottomsheet.a
{
  private View HZA;
  private TextView HZB;
  private ImageView HZC;
  private View HZD;
  private TextView HZE;
  private ImageView HZF;
  public kotlin.g.a.a<x> HZG;
  public boolean HZH;
  private View HZx;
  private TextView HZy;
  private ImageView HZz;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76012);
    this.HZH = true;
    setContentView(b.f.story_editor_dialog_view);
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
    this.HZA = findViewById(b.e.story_editor_dialog_favorite);
    this.HZB = ((TextView)findViewById(b.e.story_editor_dialog_favorite_text));
    this.HZC = ((ImageView)findViewById(b.e.story_editor_dialog_favorite_icon));
    this.HZx = findViewById(b.e.story_editor_dialog_notify_sns);
    this.HZy = ((TextView)findViewById(b.e.story_editor_dialog_notify_sns_text));
    this.HZz = ((ImageView)findViewById(b.e.story_editor_dialog_notify_sns_icon));
    this.HZD = findViewById(b.e.story_editor_dialog_range);
    this.HZE = ((TextView)findViewById(b.e.story_editor_dialog_range_text));
    this.HZF = ((ImageView)findViewById(b.e.story_editor_dialog_range_icon));
    if (!com.tencent.mm.plugin.recordvideo.b.a.a.HKu.fvN())
    {
      paramBundle = this.HZx;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      paramBundle = this.HZA;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.HZD;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(b.e.design_bottom_sheet);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setBackgroundResource(b.b.transparent);
      AppMethodBeat.o(76011);
      return;
      paramBundle = this.HZx;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.HZx;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e.a(this));
      }
      Context localContext1;
      int i;
      Context localContext2;
      if (this.HZH)
      {
        paramBundle = this.HZy;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          p.j(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(b.h.story_editor_not_notify_moment_tip));
        }
        paramBundle = this.HZz;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          i = b.g.icons_outlined_moment_off;
          localContext2 = getContext();
          p.j(localContext2, "context");
          paramBundle.setImageDrawable(au.o(localContext1, i, localContext2.getResources().getColor(b.b.BW_0_Alpha_0_9)));
        }
      }
      else
      {
        paramBundle = this.HZy;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          p.j(localContext1, "context");
          paramBundle.setText((CharSequence)localContext1.getResources().getString(b.h.story_editor_notify_moment_tip));
        }
        paramBundle = this.HZz;
        if (paramBundle != null)
        {
          localContext1 = getContext();
          i = b.g.icons_outlined_moment;
          localContext2 = getContext();
          p.j(localContext2, "context");
          paramBundle.setImageDrawable(au.o(localContext1, i, localContext2.getResources().getColor(b.b.BW_0_Alpha_0_9)));
        }
      }
    }
    AppMethodBeat.o(76011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.e
 * JD-Core Version:    0.7.0.1
 */