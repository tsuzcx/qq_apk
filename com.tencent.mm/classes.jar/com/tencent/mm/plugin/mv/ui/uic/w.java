package com.tencent.mm.plugin.mv.ui.uic;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.np;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.plugin.mv.ui.view.d.b;
import com.tencent.mm.plugin.mv.ui.view.e;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "alertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "lyricLineViewMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/collections/HashMap;", "mediaIconIvMap", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "musicCheckErrorListener", "Lcom/tencent/mm/sdk/event/IListener;", "musicPlayerListener", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "seekBarMap", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar;", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "getSnapHelper", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "setSnapHelper", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "songInfoDialog", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "getSongInfoDialog", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "setSongInfoDialog", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;)V", "songInfoDialogPrepared", "", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "addLyricView", "", "lyricRecyclerView", "addMediaIconIvMap", "mediaIconIv", "addSeekBar", "seekBar", "doSongInfoDialogHide", "doSongInfoDialogShow", "parent", "Landroid/view/ViewGroup;", "hideLyricView", "hideMediaIcon", "hideSeekBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "prepareSongInfoDialog", "processPlayError", "errMsg", "", "showLyricView", "showMediaIcon", "showSeekBar", "update", "position", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "Companion", "plugin-mv_release"})
public final class w
  extends UIComponent
{
  public static final w.a GmX;
  private final d.a FOE;
  public bds GaB;
  private final z GiQ;
  com.tencent.mm.emoji.panel.layout.a GjI;
  public com.tencent.mm.plugin.mv.ui.view.d GmS;
  private boolean GmT;
  public final HashMap<Integer, WeakReference<MusicMainSeekBar>> GmU;
  public final HashMap<Integer, WeakReference<RecyclerView>> GmV;
  public final HashMap<Integer, WeakReference<WeImageView>> GmW;
  private com.tencent.mm.ui.widget.a.d alertDialog;
  private final IListener<?> ozM;
  private final IListener<?> wNM;
  
  static
  {
    AppMethodBeat.i(227865);
    GmX = new w.a((byte)0);
    AppMethodBeat.o(227865);
  }
  
  public w(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(227862);
    this.GiQ = new z();
    this.FOE = ((d.a)new e(this, paramAppCompatActivity));
    this.GmU = new HashMap();
    this.GmV = new HashMap();
    this.GmW = new HashMap();
    this.wNM = ((IListener)new w.b(this, paramAppCompatActivity));
    this.ozM = ((IListener)new c(paramAppCompatActivity));
    AppMethodBeat.o(227862);
  }
  
  private final void fhv()
  {
    AppMethodBeat.i(227850);
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = ((i)com.tencent.mm.ui.component.g.b(getActivity()).i(i.class)).Gjj.getContentView();
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.GmS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mv.ui.view.d)localObject).hide();
    }
    this.GiQ.restore();
    AppMethodBeat.o(227850);
  }
  
  public final void fhw()
  {
    AppMethodBeat.i(227855);
    Object localObject = this.GmU.values();
    p.j(localObject, "seekBarMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MusicMainSeekBar localMusicMainSeekBar = (MusicMainSeekBar)((WeakReference)((Iterator)localObject).next()).get();
      if (localMusicMainSeekBar != null) {
        localMusicMainSeekBar.setVisibility(8);
      }
    }
    AppMethodBeat.o(227855);
  }
  
  public final void fhx()
  {
    AppMethodBeat.i(227857);
    Object localObject = this.GmW.values();
    p.j(localObject, "mediaIconIvMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeImageView localWeImageView = (WeImageView)((WeakReference)((Iterator)localObject).next()).get();
      if (localWeImageView != null) {
        localWeImageView.setVisibility(8);
      }
    }
    AppMethodBeat.o(227857);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(227859);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227859);
      return;
      if (paramInt2 == -1) {
        fhv();
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227848);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", "onCreate");
    paramBundle = getActivity().findViewById(b.e.root_layout);
    p.j(paramBundle, "activity.findViewById(R.id.root_layout)");
    this.GmS = new com.tencent.mm.plugin.mv.ui.view.d((ViewGroup)paramBundle);
    paramBundle = this.GmS;
    if (paramBundle != null)
    {
      d.b localb = (d.b)new d(this);
      p.k(localb, "listener");
      paramBundle.Gpz = localb;
    }
    this.wNM.alive();
    this.ozM.alive();
    AppMethodBeat.o(227848);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(227854);
    Object localObject = this.alertDialog;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.a.d)localObject).dismiss();
    }
    this.wNM.dead();
    this.ozM.dead();
    fhv();
    localObject = k.fet();
    p.j(localObject, "MusicPlayerManager.Instance()");
    ((k)localObject).feg().b(this.FOE);
    super.onDestroy();
    AppMethodBeat.o(227854);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(227852);
    k localk = k.fet();
    p.j(localk, "MusicPlayerManager.Instance()");
    localk.feg().b(this.FOE);
    fhv();
    super.onPause();
    AppMethodBeat.o(227852);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(227851);
    super.onResume();
    fhv();
    k localk = k.fet();
    p.j(localk, "MusicPlayerManager.Instance()");
    localk.feg().a(this.FOE);
    AppMethodBeat.o(227851);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class c
    extends IListener<np>
  {
    c(AppCompatActivity paramAppCompatActivity) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$onCreate$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$OnCloseBtnClickListener;", "onClicked", "", "plugin-mv_release"})
  public static final class d
    implements d.b
  {
    public final void fhy()
    {
      AppMethodBeat.i(230757);
      w.a(this.GmY);
      AppMethodBeat.o(230757);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
  static final class e
    implements d.a
  {
    e(w paramw, AppCompatActivity paramAppCompatActivity) {}
    
    public final void fK(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(231698);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(231698);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(w paramw) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(231717);
      this.GmY.getActivity().finish();
      AppMethodBeat.o(231717);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class g
    implements View.OnClickListener
  {
    public g(w paramw, int paramInt, f paramf, ViewGroup paramViewGroup) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(225450);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = new StringBuilder("onClick, position:").append(this.jEN).append(", snapPositin:");
      paramView = this.GmY.GjI;
      if (paramView != null) {}
      for (paramView = Integer.valueOf(paramView.jNa);; paramView = null)
      {
        Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", paramView);
        if (!w.b(this.GmY))
        {
          paramView = com.tencent.mm.ui.component.g.Xox;
          paramView = com.tencent.mm.ui.component.g.b(this.GmY.getActivity()).i(g.class);
          p.j(paramView, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
          paramView = (g)paramView;
          w.a(this.GmY, paramView.GaB);
          w.c(this.GmY);
        }
        paramView = this.GmY.GmS;
        if (paramView != null)
        {
          localObject = this.Gkl;
          p.k(localObject, "musicMv");
          paramView.GgZ = ((f)localObject);
        }
        w.a(this.GmY, this.kJH);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(225450);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "invoke"})
  public static final class h
    extends q
    implements kotlin.g.a.b<MotionEvent, Boolean>
  {
    public h(w paramw, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.w
 * JD-Core Version:    0.7.0.1
 */