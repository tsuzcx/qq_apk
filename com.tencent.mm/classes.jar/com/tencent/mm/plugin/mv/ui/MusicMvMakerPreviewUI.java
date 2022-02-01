package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.uic.r;
import com.tencent.mm.plugin.mv.ui.uic.s;
import com.tencent.mm.plugin.mv.ui.uic.y;
import com.tencent.mm.plugin.thumbplayer.d.e;
import com.tencent.mm.plugin.thumbplayer.d.f;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "startPostUI", "", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "plugin-mv_release"})
public final class MusicMvMakerPreviewUI
  extends BaseMusicMvUI
{
  dbo Geg;
  private boolean Geh;
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(237856);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(237856);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(237854);
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
    AppMethodBeat.o(237854);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.f.FZH;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(237844);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.b(localSet, (Iterable)ak.setOf(new Class[] { com.tencent.mm.plugin.mv.ui.uic.q.class, s.class, r.class }));
      AppMethodBeat.o(237844);
      return localSet;
    }
    AppMethodBeat.o(237844);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(237847);
    super.onCreate(paramBundle);
    hideTitleView();
    paramBundle = findViewById(b.e.back_btn);
    Util.expandViewTouchArea(paramBundle, 200, 200, 200, 200);
    paramBundle.setOnClickListener((View.OnClickListener)new a(this));
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(b.b.transparent));
    hideActionbarLine();
    this.Geg = new dbo();
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null)
    {
      localObject2 = this.Geg;
      if (localObject2 != null) {
        ((dbo)localObject2).parseFrom(paramBundle);
      }
    }
    paramBundle = k.fet();
    p.j(paramBundle, "MusicPlayerManager.Instance()");
    paramBundle.feg().wG(0);
    paramBundle = g.Xox;
    paramBundle = g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.mv.ui.uic.q.class);
    p.j(paramBundle, "UICProvider.of(this).get…PreviewBgUIC::class.java)");
    Object localObject2 = (com.tencent.mm.plugin.mv.ui.uic.q)paramBundle;
    paramBundle = this.Geg;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.TIW;
      ((com.tencent.mm.plugin.mv.ui.uic.q)localObject2).thumbPath = paramBundle;
      paramBundle = this.Geg;
      if (paramBundle == null) {
        break label560;
      }
      paramBundle = paramBundle.TIV;
      if (paramBundle == null) {
        break label560;
      }
      paramBundle = paramBundle.objectDesc;
      if (paramBundle == null) {
        break label560;
      }
      paramBundle = paramBundle.media;
      if (paramBundle == null) {
        break label560;
      }
      paramBundle = (FinderMedia)j.lp((List)paramBundle);
      if (paramBundle == null) {
        break label560;
      }
    }
    label560:
    for (paramBundle = paramBundle.thumbUrl + paramBundle.thumb_url_token;; paramBundle = null)
    {
      ((com.tencent.mm.plugin.mv.ui.uic.q)localObject2).thumbUrl = paramBundle;
      ((com.tencent.mm.plugin.mv.ui.uic.q)localObject2).a((com.tencent.mm.plugin.mv.ui.uic.x)new b());
      ((com.tencent.mm.plugin.mv.ui.uic.q)localObject2).Geg = this.Geg;
      ((com.tencent.mm.plugin.mv.ui.uic.q)localObject2).a((com.tencent.mm.plugin.thumbplayer.view.d)new c(this));
      paramBundle = g.Xox;
      paramBundle = g.b((AppCompatActivity)this).i(s.class);
      p.j(paramBundle, "UICProvider.of(this).get…viewTrackUIC::class.java)");
      paramBundle = (s)paramBundle;
      ((com.tencent.mm.plugin.mv.ui.uic.q)localObject2).GlW = ((kotlin.g.a.m)new d(paramBundle));
      paramBundle.Gmm = ((y)new e((com.tencent.mm.plugin.mv.ui.uic.q)localObject2));
      paramBundle.Geg = this.Geg;
      paramBundle.fhu();
      paramBundle = (Button)findViewById(b.e.complete_btn);
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      }
      paramBundle = g.Xox;
      localObject2 = (r)g.b((AppCompatActivity)this).i(r.class);
      Object localObject3 = this.Geg;
      paramBundle = localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((dbo)localObject3).TIV;
        paramBundle = localObject1;
        if (localObject3 != null)
        {
          localObject3 = ((FinderObject)localObject3).objectDesc;
          paramBundle = localObject1;
          if (localObject3 != null)
          {
            localObject3 = ((FinderObjectDesc)localObject3).mvInfo;
            paramBundle = localObject1;
            if (localObject3 != null) {
              paramBundle = ((bdp)localObject3).GaB;
            }
          }
        }
      }
      ((r)localObject2).GaB = paramBundle;
      paramBundle = g.Xox;
      ((r)g.b((AppCompatActivity)this).i(r.class)).fht();
      AppMethodBeat.o(237847);
      return;
      paramBundle = null;
      break;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(237852);
    super.onPause();
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.FRf;
    com.tencent.mm.plugin.music.model.c.feJ();
    AppMethodBeat.o(237852);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(237849);
    super.onResume();
    if (!this.Geh)
    {
      this.Geh = false;
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.FRf;
      com.tencent.mm.plugin.music.model.c.onResume();
    }
    AppMethodBeat.o(237849);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(MusicMvMakerPreviewUI paramMusicMvMakerPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228286);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Gei.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228286);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$4", "Lcom/tencent/mm/plugin/mv/ui/uic/OnBackgroundBitmapReadyListener;", "onReady", "", "bitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
  public static final class b
    implements com.tencent.mm.plugin.mv.ui.uic.x
  {
    public final void ah(Bitmap paramBitmap)
    {
      AppMethodBeat.i(227528);
      p.k(paramBitmap, "bitmap");
      AppMethodBeat.o(227528);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$5", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", "index", "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
  public static final class c
    implements com.tencent.mm.plugin.thumbplayer.view.d
  {
    public final void a(final int paramInt, com.tencent.mm.plugin.thumbplayer.e.d paramd)
    {
      AppMethodBeat.i(225316);
      p.k(paramd, "targetMedia");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramInt));
      AppMethodBeat.o(225316);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(MusicMvMakerPreviewUI.c paramc, int paramInt)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "select", "", "index", "", "plugin-mv_release"})
  public static final class e
    implements y
  {
    e(com.tencent.mm.plugin.mv.ui.uic.q paramq) {}
    
    public final void select(int paramInt)
    {
      AppMethodBeat.i(231323);
      Object localObject = this.Gek.GgY;
      if (localObject != null)
      {
        com.tencent.mm.plugin.thumbplayer.d.c localc = ((MultiMediaEffectVideoLayout)localObject).MUy;
        String str = localc.TAG;
        StringBuilder localStringBuilder = new StringBuilder("seekToIndex:").append(paramInt).append(", renderPts:").append(localc.MQt).append(", playingPlayers.size:").append(localc.MQo.size()).append(", status:").append(localc.MQs).append(", trackList.size:");
        localObject = localc.MQr;
        if (localObject != null)
        {
          localObject = ((f)localObject).MQY;
          if (localObject == null) {}
        }
        for (localObject = Integer.valueOf(((ArrayList)localObject).size());; localObject = null)
        {
          Log.i(str, localObject);
          localObject = localc.MQr;
          if (localObject != null)
          {
            localObject = ((f)localObject).MQY;
            if (localObject != null) {
              break;
            }
          }
          AppMethodBeat.o(231323);
          return;
        }
        if (paramInt <= ((ArrayList)localObject).size())
        {
          localObject = ((ArrayList)localObject).get(paramInt);
          p.j(localObject, "trackList[index]");
          localObject = (e)localObject;
          long l = ((e)localObject).MQV;
          Log.i(localc.TAG, "found seek target track:" + localObject + ", trackSeekTime:" + l + ", trackStartTimeMs:" + ((e)localObject).MQV);
          localc.MQy = ((e)localObject).startTimeMs;
          localc.a((e)localObject, l);
        }
        AppMethodBeat.o(231323);
        return;
      }
      AppMethodBeat.o(231323);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(MusicMvMakerPreviewUI paramMusicMvMakerPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230750);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = new Intent((Context)this.Gei, MusicMvPostUI.class);
      localObject = this.Gei.Geg;
      if (localObject != null) {
        paramView.putExtra("key_track_data", ((dbo)localObject).toByteArray());
      }
      com.tencent.mm.ae.d.a(paramView, this.Gei.getIntent(), "key_mv_from_scene");
      MusicMvMakerPreviewUI.a(this.Gei);
      localObject = com.tencent.mm.plugin.music.model.c.FRf;
      com.tencent.mm.plugin.music.model.c.vs(true);
      localObject = this.Gei;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aFh(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MusicMvMakerPreviewUI)localObject).startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.Gei.finish();
      paramView = com.tencent.mm.plugin.mv.model.m.GcA;
      com.tencent.mm.plugin.mv.model.m.fgj();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerPreviewUI
 * JD-Core Version:    0.7.0.1
 */