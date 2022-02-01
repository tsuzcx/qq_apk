package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvAlbumPreviewRecyclerUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvAlbumPreviewSelectedUIC;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/MusicMvAlbumPreviewUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "getForceOrientation", "", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onSwipeBack", "Companion", "plugin-mv_release"})
public final class MusicMvAlbumPreviewUI
  extends MMSecDataActivity
{
  private static doi GdU;
  public static final MusicMvAlbumPreviewUI.a Gec;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(228235);
    Gec = new MusicMvAlbumPreviewUI.a((byte)0);
    AppMethodBeat.o(228235);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(228238);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(228238);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(228237);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(228237);
    return localView1;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.FZp;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(228223);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.b(localSet, (Iterable)ak.setOf(new Class[] { com.tencent.mm.plugin.mv.ui.uic.b.class, MusicMvAlbumPreviewRecyclerUIC.class, MusicMvAlbumPreviewSelectedUIC.class }));
      AppMethodBeat.o(228223);
      return localSet;
    }
    AppMethodBeat.o(228223);
    return null;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(228227);
    g localg = g.Xox;
    ((MusicMvAlbumPreviewSelectedUIC)g.b((AppCompatActivity)this).i(MusicMvAlbumPreviewSelectedUIC.class)).ZO(0);
    super.onBackPressed();
    AppMethodBeat.o(228227);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(228224);
    super.onCreate(paramBundle);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(com.tencent.mm.plugin.mv.b.b.gallery_dark_mode_color));
    hideTitleView();
    setNavigationbarColor(getResources().getColor(com.tencent.mm.plugin.gallery.b.b.gallery_dark_mode_color));
    findViewById(b.e.back_btn).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(228224);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(228233);
    c localc = c.FRf;
    c.feJ();
    super.onPause();
    AppMethodBeat.o(228233);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(228232);
    super.onResume();
    c localc = c.FRf;
    c.onResume();
    AppMethodBeat.o(228232);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(228229);
    g localg = g.Xox;
    ((MusicMvAlbumPreviewSelectedUIC)g.b((AppCompatActivity)this).i(MusicMvAlbumPreviewSelectedUIC.class)).ZO(0);
    super.onSwipeBack();
    AppMethodBeat.o(228229);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(MusicMvAlbumPreviewUI paramMusicMvAlbumPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231371);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/mv/ui/MusicMvAlbumPreviewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Xox;
      ((MusicMvAlbumPreviewSelectedUIC)g.b((AppCompatActivity)this.Ged).i(MusicMvAlbumPreviewSelectedUIC.class)).ZO(0);
      a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvAlbumPreviewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(231371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvAlbumPreviewUI
 * JD-Core Version:    0.7.0.1
 */