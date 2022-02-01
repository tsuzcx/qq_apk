package com.tencent.mm.plugin.mv.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvAlbumPreviewRecyclerUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvAlbumPreviewSelectedUIC;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/MusicMvAlbumPreviewUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "getForceOrientation", "", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onSwipeBack", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvAlbumPreviewUI
  extends MMSecDataActivity
{
  private static egz LZC;
  public static final MusicMvAlbumPreviewUI.a LZJ;
  
  static
  {
    AppMethodBeat.i(286380);
    LZJ = new MusicMvAlbumPreviewUI.a((byte)0);
    AppMethodBeat.o(286380);
  }
  
  private static final void a(MusicMvAlbumPreviewUI paramMusicMvAlbumPreviewUI, View paramView)
  {
    AppMethodBeat.i(286361);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvAlbumPreviewUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/mv/ui/MusicMvAlbumPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMusicMvAlbumPreviewUI, "this$0");
    paramView = k.aeZF;
    ((MusicMvAlbumPreviewSelectedUIC)k.d((AppCompatActivity)paramMusicMvAlbumPreviewUI).q(MusicMvAlbumPreviewSelectedUIC.class)).aed(0);
    a.a(new Object(), "com/tencent/mm/plugin/mv/ui/MusicMvAlbumPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286361);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.LVm;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(286395);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(286395);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(new Class[] { com.tencent.mm.plugin.mv.ui.uic.b.class, MusicMvAlbumPreviewRecyclerUIC.class, MusicMvAlbumPreviewSelectedUIC.class }));
    AppMethodBeat.o(286395);
    return localSet;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(286414);
    k localk = k.aeZF;
    ((MusicMvAlbumPreviewSelectedUIC)k.d((AppCompatActivity)this).q(MusicMvAlbumPreviewSelectedUIC.class)).aed(0);
    super.onBackPressed();
    AppMethodBeat.o(286414);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(286406);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(com.tencent.mm.plugin.mv.b.b.gallery_dark_mode_color));
    hideTitleView();
    setNavigationbarColor(getResources().getColor(com.tencent.mm.plugin.gallery.b.b.gallery_dark_mode_color));
    findViewById(b.e.back_btn).setOnClickListener(new MusicMvAlbumPreviewUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(286406);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(286440);
    c localc = c.LLZ;
    c.gnQ();
    super.onPause();
    AppMethodBeat.o(286440);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286434);
    super.onResume();
    c localc = c.LLZ;
    c.onResume();
    AppMethodBeat.o(286434);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(286422);
    k localk = k.aeZF;
    ((MusicMvAlbumPreviewSelectedUIC)k.d((AppCompatActivity)this).q(MusicMvAlbumPreviewSelectedUIC.class)).aed(0);
    super.onSwipeBack();
    AppMethodBeat.o(286422);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvAlbumPreviewUI
 * JD-Core Version:    0.7.0.1
 */