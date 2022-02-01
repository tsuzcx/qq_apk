package com.tencent.mm.plugin.mv.ui.uic;

import android.animation.Animator.AnimatorListener;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.ui.view.f;
import com.tencent.mm.plugin.mv.ui.view.f.m;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "mediaIconIvMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Lkotlin/collections/HashMap;", "getMediaIconIvMap", "()Ljava/util/HashMap;", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "seekBarMap", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar;", "getSeekBarMap", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "getSnapHelper", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "setSnapHelper", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "songInfoDialog", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "getSongInfoDialog", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "setSongInfoDialog", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;)V", "songInfoDialogPrepared", "", "addMediaIconIvMap", "", "mediaIconIv", "addSeekBar", "seekBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "prepareSongInfoDialog", "update", "parent", "Landroid/view/ViewGroup;", "position", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "Companion", "plugin-mv_release"})
public final class MusicMvSongInfoUIC
  extends UIComponent
{
  public static final a Awm;
  private final d.a AhI;
  public axy Aqo;
  com.tencent.mm.emoji.panel.layout.a AtW;
  f Awi;
  private boolean Awj;
  public final HashMap<Integer, WeakReference<MusicMainSeekBar>> Awk;
  public final HashMap<Integer, WeakReference<WeImageView>> Awl;
  private final IListener<?> lEl;
  
  static
  {
    AppMethodBeat.i(257386);
    Awm = new a((byte)0);
    AppMethodBeat.o(257386);
  }
  
  public MusicMvSongInfoUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257385);
    this.AhI = ((d.a)new c(this, paramAppCompatActivity));
    this.Awk = new HashMap();
    this.Awl = new HashMap();
    this.lEl = ((IListener)new b(this, paramAppCompatActivity));
    AppMethodBeat.o(257385);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(257384);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(257384);
        return;
      } while (paramInt2 != -1);
      paramIntent = this.Awi;
    } while (paramIntent == null);
    paramIntent.hide();
    AppMethodBeat.o(257384);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257380);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", "onCreate");
    paramBundle = getActivity().findViewById(2131307165);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.root_layout)");
    this.Awi = new f((ViewGroup)paramBundle);
    this.lEl.alive();
    AppMethodBeat.o(257380);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257383);
    this.lEl.dead();
    Object localObject = this.Awi;
    if (localObject != null) {
      ((f)localObject).hide();
    }
    localObject = com.tencent.mm.plugin.music.e.k.euj();
    kotlin.g.b.p.g(localObject, "MusicPlayerManager.Instance()");
    ((com.tencent.mm.plugin.music.e.k)localObject).etW().a(null);
    super.onDestroy();
    AppMethodBeat.o(257383);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(257382);
    Object localObject = com.tencent.mm.plugin.music.e.k.euj();
    kotlin.g.b.p.g(localObject, "MusicPlayerManager.Instance()");
    ((com.tencent.mm.plugin.music.e.k)localObject).etW().a(null);
    localObject = this.Awi;
    if (localObject != null) {
      ((f)localObject).hide();
    }
    super.onPause();
    AppMethodBeat.o(257382);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(257381);
    super.onResume();
    Object localObject = this.Awi;
    if (localObject != null) {
      ((f)localObject).hide();
    }
    localObject = com.tencent.mm.plugin.music.e.k.euj();
    kotlin.g.b.p.g(localObject, "MusicPlayerManager.Instance()");
    ((com.tencent.mm.plugin.music.e.k)localObject).etW().a(this.AhI);
    AppMethodBeat.o(257381);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$Companion;", "", "()V", "TAG", "", "UPDATE_PROGRESS", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class b
    extends IListener<mx>
  {
    b(AppCompatActivity paramAppCompatActivity) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
  static final class c
    implements d.a
  {
    c(MusicMvSongInfoUIC paramMusicMvSongInfoUIC, AppCompatActivity paramAppCompatActivity) {}
    
    public final void fn(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(257376);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(257376);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(MusicMvSongInfoUIC paramMusicMvSongInfoUIC, int paramInt, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257377);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = new StringBuilder("onClick, position:").append(this.gUj).append(", snapPositin:");
      paramView = this.Awn.AtW;
      Object localObject2;
      Object localObject3;
      int i;
      if (paramView != null)
      {
        paramView = Integer.valueOf(paramView.hbQ);
        Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", paramView);
        if (!MusicMvSongInfoUIC.a(this.Awn))
        {
          paramView = com.tencent.mm.ui.component.a.PRN;
          paramView = com.tencent.mm.ui.component.a.b(this.Awn.getActivity()).get(MusicMvDataUIC.class);
          kotlin.g.b.p.g(paramView, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
          paramView = (MusicMvDataUIC)paramView;
          MusicMvSongInfoUIC.a(this.Awn, paramView.Aqo);
          MusicMvSongInfoUIC.b(this.Awn);
        }
        paramView = this.Awn.Awi;
        if (paramView != null)
        {
          localObject1 = this.Awc;
          kotlin.g.b.p.h(localObject1, "musicMv");
          paramView.Ayc = ((e)localObject1);
        }
        paramView = this.Awn.Awi;
        if (paramView != null)
        {
          localObject1 = f.TAG;
          localObject2 = new StringBuilder("show song info dialog, isShow:").append(paramView.dEF).append(", translateY:");
          localObject3 = paramView.ewB();
          kotlin.g.b.p.g(localObject3, "dialogRootLayout");
          Log.i((String)localObject1, ((RoundCornerRelativeLayout)localObject3).getTranslationY());
          if (!paramView.dEF)
          {
            Log.i(f.TAG, "doShow");
            localObject1 = com.tencent.mm.ui.component.a.PRN;
            localObject1 = paramView.parent.getContext();
            kotlin.g.b.p.g(localObject1, "parent.context");
            paramView.fuN = ((MusicMvDataUIC)com.tencent.mm.ui.component.a.ko((Context)localObject1).get(MusicMvDataUIC.class)).fuN;
            localObject1 = (CharSequence)paramView.fuN;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label526;
            }
            i = 1;
            label320:
            if ((i != 0) || (!com.tencent.mm.plugin.textstatus.a.p.fvC())) {
              break label531;
            }
            Log.i(f.TAG, "verifyInfo:" + paramView.fuN + ", textStatusSwitch:" + com.tencent.mm.plugin.textstatus.a.p.fvC() + ", hide status icon!");
            localObject1 = paramView.ewH();
            kotlin.g.b.p.g(localObject1, "statusButtonBlurLayout");
            ((BlurView)localObject1).setVisibility(0);
          }
        }
      }
      for (;;)
      {
        localObject1 = paramView.ewA();
        kotlin.g.b.p.g(localObject1, "songInfoFullScreenRoot");
        ((ViewGroup)localObject1).setVisibility(0);
        paramView.ewB().animate().translationY(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new f.m(paramView)).start();
        paramView.ewC().animate().alpha(1.0F).setDuration(300L);
        localObject1 = paramView.Aqo;
        localObject2 = paramView.Ayc;
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject3 = com.tencent.mm.plugin.mv.a.k.Aql;
          paramView = paramView.parent.getContext();
          kotlin.g.b.p.g(paramView, "parent.context");
          com.tencent.mm.plugin.mv.a.k.a(paramView, (axy)localObject1, (e)localObject2, 1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257377);
        return;
        paramView = null;
        break;
        label526:
        i = 0;
        break label320;
        label531:
        Log.i(f.TAG, "verifyInfo:" + paramView.fuN + ", textStatusSwitch:" + com.tencent.mm.plugin.textstatus.a.p.fvC() + ", show status icon!");
        localObject1 = paramView.ewH();
        kotlin.g.b.p.g(localObject1, "statusButtonBlurLayout");
        ((BlurView)localObject1).setVisibility(4);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "invoke"})
  public static final class e
    extends q
    implements kotlin.g.a.b<MotionEvent, Boolean>
  {
    public e(MusicMvSongInfoUIC paramMusicMvSongInfoUIC, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class f
    implements View.OnClickListener
  {
    public f(ViewGroup paramViewGroup, axy paramaxy) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257379);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.ui.component.a.PRN;
      paramView = this.hVi.getContext();
      kotlin.g.b.p.g(paramView, "parent.context");
      ((MusicMvMainUIC)com.tencent.mm.ui.component.a.ko(paramView).get(MusicMvMainUIC.class)).c(this.Awp);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257379);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvSongInfoUIC
 * JD-Core Version:    0.7.0.1
 */