package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.ui.LyricView;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC.a;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC.b;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewLyricUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewTrackUIC;
import com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@com.tencent.mm.ui.base.a(32)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "startPostUI", "", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "plugin-mv_release"})
public final class MusicMvMakerPreviewUI
  extends BaseMusicMvUI
{
  csp AqY;
  private boolean AqZ;
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256876);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256876);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256875);
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
    AppMethodBeat.o(256875);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131495792;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(256871);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.b(localSet, (Iterable)ak.setOf(new Class[] { MusicMvPreviewBgUIC.class, MusicMvPreviewTrackUIC.class, MusicMvPreviewLyricUIC.class }));
      AppMethodBeat.o(256871);
      return localSet;
    }
    AppMethodBeat.o(256871);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256872);
    super.onCreate(paramBundle);
    hideTitleView();
    paramBundle = findViewById(2131297163);
    Util.expandViewTouchArea(paramBundle, 200, 200, 200, 200);
    paramBundle.setOnClickListener((View.OnClickListener)new a(this));
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(2131101287));
    hideActionbarLine();
    this.AqY = new csp();
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null)
    {
      localObject1 = this.AqY;
      if (localObject1 != null) {
        ((csp)localObject1).parseFrom(paramBundle);
      }
    }
    paramBundle = k.euj();
    p.g(paramBundle, "MusicPlayerManager.Instance()");
    paramBundle.etW().tG(0);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    paramBundle = com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvPreviewBgUIC.class);
    p.g(paramBundle, "UICProvider.of(this).get…PreviewBgUIC::class.java)");
    Object localObject1 = (MusicMvPreviewBgUIC)paramBundle;
    paramBundle = this.AqY;
    label299:
    String str;
    Object localObject3;
    label429:
    int i;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.MxF;
      ((MusicMvPreviewBgUIC)localObject1).thumbPath = paramBundle;
      paramBundle = this.AqY;
      if (paramBundle == null) {
        break label831;
      }
      paramBundle = paramBundle.MxE;
      if (paramBundle == null) {
        break label831;
      }
      paramBundle = paramBundle.objectDesc;
      if (paramBundle == null) {
        break label831;
      }
      paramBundle = paramBundle.media;
      if (paramBundle == null) {
        break label831;
      }
      paramBundle = (FinderMedia)j.kt((List)paramBundle);
      if (paramBundle == null) {
        break label831;
      }
      paramBundle = paramBundle.thumbUrl + paramBundle.thumb_url_token;
      ((MusicMvPreviewBgUIC)localObject1).thumbUrl = paramBundle;
      localObject2 = (com.tencent.mm.plugin.mv.ui.uic.a)new b();
      paramBundle = (ImageView)((MusicMvPreviewBgUIC)localObject1).getActivity().findViewById(2131297176);
      localObject2 = new MusicMvPreviewBgUIC.a((MusicMvPreviewBgUIC)localObject1, paramBundle, (com.tencent.mm.plugin.mv.ui.uic.a)localObject2);
      str = ((MusicMvPreviewBgUIC)localObject1).thumbPath;
      if (str == null) {
        break label836;
      }
      Log.i(((MusicMvPreviewBgUIC)localObject1).TAG, "initBgCover thumbPath:" + ((MusicMvPreviewBgUIC)localObject1).thumbPath);
      localObject3 = new c.a().bdo().bdr().bdv();
      p.g(localObject3, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
      com.tencent.mm.av.q.bcV().a(str, paramBundle, (com.tencent.mm.av.a.a.c)localObject3, (h)localObject2);
      ((MusicMvPreviewBgUIC)localObject1).AqY = this.AqY;
      paramBundle = (com.tencent.mm.plugin.thumbplayer.view.d)new c(this);
      p.h(paramBundle, "listener");
      kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMV(), (kotlin.g.a.m)new MusicMvPreviewBgUIC.b((MusicMvPreviewBgUIC)localObject1, paramBundle, null), 2);
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvPreviewTrackUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvPreviewTrackUIC.class)).AvJ = ((com.tencent.mm.plugin.mv.ui.uic.b)new d((MusicMvPreviewBgUIC)localObject1));
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvPreviewTrackUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvPreviewTrackUIC.class)).AqY = this.AqY;
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvPreviewTrackUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvPreviewTrackUIC.class)).ewi();
      paramBundle = (Button)findViewById(2131298979);
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e(this));
      }
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      localObject1 = (MusicMvPreviewLyricUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvPreviewLyricUIC.class);
      paramBundle = this.AqY;
      if (paramBundle == null) {
        break label955;
      }
      paramBundle = paramBundle.MxE;
      if (paramBundle == null) {
        break label955;
      }
      paramBundle = paramBundle.objectDesc;
      if (paramBundle == null) {
        break label955;
      }
      paramBundle = paramBundle.mvInfo;
      if (paramBundle == null) {
        break label955;
      }
      paramBundle = paramBundle.Aqo;
      label662:
      ((MusicMvPreviewLyricUIC)localObject1).Aqo = paramBundle;
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      localObject1 = (MusicMvPreviewLyricUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(MusicMvPreviewLyricUIC.class);
      ((MusicMvPreviewLyricUIC)localObject1).Anv = ((LyricView)((MusicMvPreviewLyricUIC)localObject1).getActivity().findViewById(2131304298));
      i = com.tencent.mm.cb.a.fromDPToPix((Context)((MusicMvPreviewLyricUIC)localObject1).getActivity(), 22);
      int j = com.tencent.mm.cb.a.fromDPToPix((Context)((MusicMvPreviewLyricUIC)localObject1).getActivity(), 4.0F);
      int k = com.tencent.mm.cb.a.fromDPToPix((Context)((MusicMvPreviewLyricUIC)localObject1).getActivity(), 4.0F);
      paramBundle = ((MusicMvPreviewLyricUIC)localObject1).Anv;
      if (paramBundle != null) {
        paramBundle.a(Paint.Align.LEFT, i, j, k);
      }
      paramBundle = ((MusicMvPreviewLyricUIC)localObject1).Anv;
      if (paramBundle != null) {
        paramBundle.setMode(1);
      }
      paramBundle = ((MusicMvPreviewLyricUIC)localObject1).Anv;
      if (paramBundle == null) {
        break label960;
      }
    }
    label831:
    label960:
    for (paramBundle = paramBundle.getLayoutParams();; paramBundle = null)
    {
      if (paramBundle != null) {
        break label965;
      }
      paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(256872);
      throw paramBundle;
      paramBundle = null;
      break;
      paramBundle = null;
      break label299;
      label836:
      localObject3 = (MusicMvPreviewBgUIC)localObject1;
      str = ((MusicMvPreviewBgUIC)localObject3).thumbUrl;
      if (str == null) {
        break label429;
      }
      Object localObject4 = a.ArA;
      localObject4 = a.aIo(str);
      Log.i(((MusicMvPreviewBgUIC)localObject3).TAG, "initBgCover url:" + str + " fullPath:" + (String)localObject4);
      localObject3 = new c.a();
      ((c.a)localObject3).OS((String)localObject4);
      ((c.a)localObject3).bdp();
      ((c.a)localObject3).bdo();
      com.tencent.mm.av.q.bcV().a(str, paramBundle, ((c.a)localObject3).bdv(), (h)localObject2);
      break label429;
      paramBundle = null;
      break label662;
    }
    label955:
    label965:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    Object localObject2 = ((MusicMvPreviewLyricUIC)localObject1).getActivity().getResources();
    p.g(localObject2, "activity.resources");
    paramBundle.topMargin = ((int)(((Resources)localObject2).getDisplayMetrics().heightPixels * 0.37F));
    paramBundle = ((MusicMvPreviewLyricUIC)localObject1).Aqo;
    if (paramBundle != null)
    {
      localObject2 = (CharSequence)paramBundle.LIh;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label1151;
        }
        i = 1;
        label1048:
        if (i == 0) {
          break label1156;
        }
      }
      for (;;)
      {
        if (paramBundle != null)
        {
          localObject2 = ((MusicMvPreviewLyricUIC)localObject1).Anv;
          if (localObject2 != null) {
            ((LyricView)localObject2).setLyricObj(e.a(paramBundle.LIh, ((MusicMvPreviewLyricUIC)localObject1).getActivity().getString(2131763403), "", com.tencent.mm.plugin.music.model.m.iZ(paramBundle.LIg, paramBundle.musicDataUrl), paramBundle.lDR, false, false));
          }
          if (!com.tencent.mm.plugin.music.model.m.iZ(paramBundle.LIg, paramBundle.musicDataUrl))
          {
            paramBundle = ((MusicMvPreviewLyricUIC)localObject1).Anv;
            if (paramBundle != null)
            {
              paramBundle.setCurrentTime(1L);
              AppMethodBeat.o(256872);
              return;
              i = 0;
              break;
              label1151:
              i = 0;
              break label1048;
              label1156:
              paramBundle = null;
              continue;
            }
          }
          AppMethodBeat.o(256872);
          return;
        }
      }
    }
    AppMethodBeat.o(256872);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(256874);
    super.onPause();
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.Akc;
    com.tencent.mm.plugin.music.model.c.gFa();
    AppMethodBeat.o(256874);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256873);
    super.onResume();
    if (!this.AqZ)
    {
      this.AqZ = false;
      com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.Akc;
      com.tencent.mm.plugin.music.model.c.onResume();
    }
    AppMethodBeat.o(256873);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(MusicMvMakerPreviewUI paramMusicMvMakerPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256865);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.Ara.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256865);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$4", "Lcom/tencent/mm/plugin/mv/ui/uic/OnBackgroundBitmapReadyListener;", "onReady", "", "bitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
  public static final class b
    implements com.tencent.mm.plugin.mv.ui.uic.a
  {
    public final void ak(Bitmap paramBitmap)
    {
      AppMethodBeat.i(256866);
      p.h(paramBitmap, "bitmap");
      AppMethodBeat.o(256866);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$5", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", "index", "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
  public static final class c
    implements com.tencent.mm.plugin.thumbplayer.view.d
  {
    public final void a(final int paramInt, com.tencent.mm.plugin.thumbplayer.d.a parama)
    {
      AppMethodBeat.i(256868);
      p.h(parama, "targetMedia");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramInt));
      AppMethodBeat.o(256868);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(MusicMvMakerPreviewUI.c paramc, int paramInt)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$6", "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "select", "", "index", "", "plugin-mv_release"})
  public static final class d
    implements com.tencent.mm.plugin.mv.ui.uic.b
  {
    d(MusicMvPreviewBgUIC paramMusicMvPreviewBgUIC) {}
    
    public final void select(int paramInt)
    {
      AppMethodBeat.i(256869);
      MMMvVideoLayout localMMMvVideoLayout = this.Arc.AtX;
      if (localMMMvVideoLayout != null)
      {
        Log.i(localMMMvVideoLayout.TAG, "seekToIndex " + paramInt + ' ' + localMMMvVideoLayout.dFm());
        Object localObject1 = localMMMvVideoLayout.Gie;
        if (localObject1 != null)
        {
          int i;
          if ((((List)localObject1).size() > paramInt) && (paramInt >= 0) && (localMMMvVideoLayout.Gid != paramInt))
          {
            i = 1;
            if (i == 0) {
              break label183;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label188;
            }
            localObject1 = (com.tencent.mm.plugin.thumbplayer.d.a)((List)localObject1).get(paramInt);
            if (localObject1 == null) {
              break label188;
            }
            localMMMvVideoLayout.fxd();
            Object localObject2 = localMMMvVideoLayout.Gih;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.thumbplayer.view.c)localObject2).Tp((int)((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).Ghu);
            }
            localMMMvVideoLayout.Gid = paramInt;
            localObject2 = localMMMvVideoLayout.Gic;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setMediaInfo((com.tencent.mm.plugin.thumbplayer.d.a)localObject1);
            }
            localMMMvVideoLayout.start();
            AppMethodBeat.o(256869);
            return;
            i = 0;
            break;
            label183:
            localObject1 = null;
          }
        }
        label188:
        AppMethodBeat.o(256869);
        return;
      }
      AppMethodBeat.o(256869);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(MusicMvMakerPreviewUI paramMusicMvMakerPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256870);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent((Context)this.Ara, MusicMvPostUI.class);
      localObject = this.Ara.AqY;
      if (localObject != null) {
        paramView.putExtra("key_track_data", ((csp)localObject).toByteArray());
      }
      MusicMvMakerPreviewUI.a(this.Ara);
      localObject = com.tencent.mm.plugin.music.model.c.Akc;
      com.tencent.mm.plugin.music.model.c.sm(true);
      localObject = this.Ara;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MusicMvMakerPreviewUI)localObject).startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = com.tencent.mm.plugin.mv.a.l.Uqz;
      paramView = com.tencent.mm.plugin.mv.a.l.gFd();
      paramView.PF(7L);
      paramView.bfK();
      localObject = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerPreviewUI
 * JD-Core Version:    0.7.0.1
 */