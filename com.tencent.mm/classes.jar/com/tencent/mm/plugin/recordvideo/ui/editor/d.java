package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSelectRange", "getOnSelectRange", "setOnSelectRange", "onSetFav", "getOnSetFav", "setOnSetFav", "rangeIcon", "rangeTv", "rangeView", "initFavoriteBtn", "initNotifySnsBtn", "initRangeBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.google.android.material.bottomsheet.a
{
  private View NWd;
  private TextView NWe;
  private ImageView NWf;
  private View NWg;
  private TextView NWh;
  private ImageView NWi;
  private View NWj;
  private TextView NWk;
  private ImageView NWl;
  public kotlin.g.a.a<ah> NWm;
  public boolean NWn;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76012);
    this.NWn = true;
    setContentView(b.f.story_editor_dialog_view);
    AppMethodBeat.o(76012);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(279887);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramView = paramd.NWm;
    if (paramView != null) {
      paramView.invoke();
    }
    paramd.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279887);
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
    this.NWg = findViewById(b.e.story_editor_dialog_favorite);
    this.NWh = ((TextView)findViewById(b.e.story_editor_dialog_favorite_text));
    this.NWi = ((ImageView)findViewById(b.e.story_editor_dialog_favorite_icon));
    this.NWd = findViewById(b.e.story_editor_dialog_notify_sns);
    this.NWe = ((TextView)findViewById(b.e.story_editor_dialog_notify_sns_text));
    this.NWf = ((ImageView)findViewById(b.e.story_editor_dialog_notify_sns_icon));
    this.NWj = findViewById(b.e.story_editor_dialog_range);
    this.NWk = ((TextView)findViewById(b.e.story_editor_dialog_range_text));
    this.NWl = ((ImageView)findViewById(b.e.story_editor_dialog_range_icon));
    if (!com.tencent.mm.plugin.recordvideo.c.a.a.NHs.gHB())
    {
      paramBundle = this.NWd;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      paramBundle = this.NWg;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.NWj;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(b.e.design_bottom_sheet);
      if (paramBundle != null) {
        paramBundle.setBackgroundResource(b.b.transparent);
      }
      AppMethodBeat.o(76011);
      return;
      paramBundle = this.NWd;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.NWd;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new d..ExternalSyntheticLambda0(this));
      }
      if (this.NWn)
      {
        paramBundle = this.NWe;
        if (paramBundle != null) {
          paramBundle.setText((CharSequence)getContext().getResources().getString(b.h.story_editor_not_notify_moment_tip));
        }
        paramBundle = this.NWf;
        if (paramBundle != null) {
          paramBundle.setImageDrawable(bb.m(getContext(), b.g.icons_outlined_moment_off, getContext().getResources().getColor(b.b.BW_0_Alpha_0_9)));
        }
      }
      else
      {
        paramBundle = this.NWe;
        if (paramBundle != null) {
          paramBundle.setText((CharSequence)getContext().getResources().getString(b.h.story_editor_notify_moment_tip));
        }
        paramBundle = this.NWf;
        if (paramBundle != null) {
          paramBundle.setImageDrawable(bb.m(getContext(), b.g.icons_outlined_moment, getContext().getResources().getColor(b.b.BW_0_Alpha_0_9)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.d
 * JD-Core Version:    0.7.0.1
 */