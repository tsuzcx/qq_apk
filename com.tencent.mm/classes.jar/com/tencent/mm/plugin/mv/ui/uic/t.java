package com.tencent.mm.plugin.mv.ui.uic;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.music.e.a.d.a;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.o;
import com.tencent.mm.plugin.mv.ui.view.InterceptRelativeLayout;
import com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView;
import com.tencent.mm.plugin.mv.ui.view.c.b;
import com.tencent.mm.plugin.mv.ui.view.c.l;
import com.tencent.mm.plugin.mv.ui.view.c.r;
import com.tencent.mm.plugin.mv.ui.view.c.u;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "alertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "hasAlreadyShowLongTryListen", "", "getHasAlreadyShowLongTryListen", "()Z", "setHasAlreadyShowLongTryListen", "(Z)V", "isTryingMusic", "setTryingMusic", "lyricLineViewMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/collections/HashMap;", "mediaIconIvMap", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "musicCheckErrorListener", "Lcom/tencent/mm/sdk/event/IListener;", "musicPlayerListener", "parentView", "Landroid/view/View;", "getParentView", "()Landroid/view/View;", "setParentView", "(Landroid/view/View;)V", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "seekBarMap", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar;", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "getSnapHelper", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "setSnapHelper", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "songInfoDialog", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "getSongInfoDialog", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "setSongInfoDialog", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;)V", "songInfoDialogPrepared", "songInfoDialogVisibility", "getSongInfoDialogVisibility", "setSongInfoDialogVisibility", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "addLyricView", "", "lyricRecyclerView", "addMediaIconIvMap", "mediaIconIv", "addSeekBar", "seekBar", "doAlphaAnimation", "view", "from", "", "to", "doSongInfoDialogHide", "doSongInfoDialogShow", "parent", "Landroid/view/ViewGroup;", "hideLyricView", "hideMediaIcon", "hideSeekBar", "hideTryListenIcon", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "prepareSongInfoDialog", "processPlayError", "errMsg", "", "releaseSongInfoDialog", "showLongTryListen", "showLyricView", "showMediaIcon", "showSeekBar", "showTryListenIcon", "update", "position", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends UIComponent
{
  public static final t.a MgV;
  private final IListener<?> Akp;
  private final d.a LJz;
  boo LWI;
  private final x MdQ;
  com.tencent.mm.emoji.panel.layout.a MeK;
  public com.tencent.mm.plugin.mv.ui.view.c MgW;
  private boolean MgX;
  boolean MgY;
  private boolean MgZ;
  boolean Mha;
  public final HashMap<Integer, WeakReference<MusicMainSeekBar>> Mhb;
  public final HashMap<Integer, WeakReference<RecyclerView>> Mhc;
  public final HashMap<Integer, WeakReference<WeImageView>> Mhd;
  private com.tencent.mm.ui.widget.a.e alertDialog;
  private final IListener<?> rDF;
  View uJh;
  
  static
  {
    AppMethodBeat.i(287608);
    MgV = new t.a((byte)0);
    AppMethodBeat.o(287608);
  }
  
  public t(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287472);
    this.MdQ = new x();
    this.LJz = new t..ExternalSyntheticLambda4(this, paramAppCompatActivity);
    this.Mhb = new HashMap();
    this.Mhc = new HashMap();
    this.Mhd = new HashMap();
    this.Akp = ((IListener)new MusicMvSongInfoUIC.musicCheckErrorListener.1(paramAppCompatActivity, this, com.tencent.mm.app.f.hfK));
    this.rDF = ((IListener)new MusicMvSongInfoUIC.musicPlayerListener.1(paramAppCompatActivity, this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(287472);
  }
  
  private static final void a(int paramInt1, int paramInt2, View paramView, ValueAnimator paramValueAnimator)
  {
    Object localObject = null;
    AppMethodBeat.i(287559);
    float f1 = paramValueAnimator.getAnimatedFraction();
    float f2 = paramInt1;
    float f3 = paramInt2 - paramInt1;
    if (paramView == null)
    {
      paramValueAnimator = null;
      paramValueAnimator = paramValueAnimator.getLayoutParams();
      paramValueAnimator.width = ((int)(f2 + f1 * f3));
      if (paramView != null) {
        break label79;
      }
    }
    label79:
    for (paramView = localObject;; paramView = paramView.findViewById(b.e.LUV))
    {
      paramView.setLayoutParams(paramValueAnimator);
      AppMethodBeat.o(287559);
      return;
      paramValueAnimator = paramView.findViewById(b.e.LUV);
      break;
    }
  }
  
  private static final void a(int paramInt, t paramt, ViewGroup paramViewGroup, com.tencent.mm.plugin.mv.model.f paramf, View paramView)
  {
    AppMethodBeat.i(287545);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.sc(paramInt);
    localb.cH(paramt);
    localb.cH(paramViewGroup);
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramt, "this$0");
    s.u(paramViewGroup, "$parent");
    s.u(paramf, "$musicMv");
    paramView = new StringBuilder("song_copyright_ll onClick, position:").append(paramInt).append(", snapPositin:");
    paramt = paramt.MeK;
    if (paramt == null) {}
    for (paramt = null;; paramt = Integer.valueOf(paramt.mma))
    {
      Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", paramt);
      paramt = k.aeZF;
      paramt = paramViewGroup.getContext();
      s.s(paramt, "parent.context");
      paramt = ((e)k.nq(paramt).q(e.class)).LWI;
      paramView = k.aeZF;
      paramView = paramViewGroup.getContext();
      s.s(paramView, "parent.context");
      paramInt = ((i)k.nq(paramView).q(i.class)).a(paramt, new t..ExternalSyntheticLambda5(paramt, paramf, paramViewGroup));
      if ((paramInt != 7) && (paramt != null))
      {
        paramView = o.LYk;
        paramViewGroup = paramViewGroup.getContext();
        s.s(paramViewGroup, "parent.context");
        o.a(paramViewGroup, paramt, paramf, 2, paramInt, 1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287545);
      return;
    }
  }
  
  private static final void a(int paramInt, t paramt, com.tencent.mm.plugin.mv.model.f paramf, ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(287528);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramViewGroup);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramt, "this$0");
    s.u(paramf, "$musicMv");
    s.u(paramViewGroup, "$parent");
    localObject1 = new StringBuilder("onClick, position:").append(paramInt).append(", snapPositin:");
    paramView = paramt.MeK;
    boo localboo;
    com.tencent.mm.plugin.mv.ui.view.c localc;
    if (paramView == null)
    {
      paramView = null;
      Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", paramView);
      if (!paramt.MgX)
      {
        paramView = k.aeZF;
        paramView = k.d(paramt.getActivity()).q(e.class);
        s.s(paramView, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        localboo = ((e)paramView).LWI;
        Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", "prepareSongInfoDialog");
        localc = paramt.MgW;
        if (localc != null)
        {
          localc.LWI = localboo;
          if (localboo != null) {
            break label372;
          }
          Log.i(com.tencent.mm.plugin.mv.ui.view.c.TAG, "passParameters songInfo is null");
        }
        label236:
        paramView = paramt.MgW;
        if (paramView != null)
        {
          paramView.Mjy = false;
          paramView.grL().setTranslationY(paramView.MjB * -1.0F);
        }
        paramt.MgX = true;
      }
      paramView = paramt.MgW;
      if (paramView != null)
      {
        s.u(paramf, "musicMv");
        paramView.Mcj = paramf;
      }
      paramf = paramt.MgW;
      if ((paramf == null) || (paramf.Mjy != true)) {
        break label1813;
      }
      paramInt = 1;
      label319:
      if ((paramInt == 0) && (!paramt.MgZ)) {
        break label1818;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287528);
      return;
      paramView = Integer.valueOf(paramView.mma);
      break;
      label372:
      localObject2 = null;
      paramView = localboo.ZWW;
      localObject1 = localObject2;
      if (paramView != null)
      {
        paramView = paramView.ZWX;
        localObject1 = localObject2;
        if (paramView != null)
        {
          if (paramView.length() <= 0) {
            break label1166;
          }
          paramInt = 1;
          label417:
          if (paramInt == 0) {
            break label1171;
          }
          label421:
          localObject1 = localObject2;
          if (paramView != null) {
            localObject1 = paramView;
          }
        }
      }
      paramView = com.tencent.mm.plugin.comm.a.xeG;
      paramView = localboo.ZWQ;
      boolean bool;
      label457:
      label739:
      int i;
      if (Util.isNullOrNil(paramView))
      {
        bool = false;
        Log.i(com.tencent.mm.plugin.mv.ui.view.c.TAG, "mvOperationUrl:" + localObject1 + ", isShieldAppId:" + bool);
        if ((!Util.isNullOrNil((String)localObject1)) && (!bool)) {
          break label1421;
        }
        localc.Mjz = false;
        localc.grS().setVisibility(0);
        localc.grT().setVisibility(8);
        localc.grX().setVisibility(8);
        localObject1 = localc.grP().getDrawable();
        paramView = localc.grU();
        if (paramView != null)
        {
          localObject1 = paramView.ad((ViewGroup)localc.grL()).V((Drawable)localObject1).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f(paramView.getContext())).eb(30.0F);
          ((BlurView)localObject1).aedd = true;
          ((BlurView)localObject1).Rx = com.tencent.mm.cd.a.br(paramView.getContext(), b.c.Edge_A);
          ((BlurView)localObject1).joa().aBy(Color.parseColor("#61D2D2D2"));
        }
        label644:
        Log.i(com.tencent.mm.plugin.mv.ui.view.c.TAG, "updateView songName:" + localboo.songName + " songId:" + localboo.mLQ);
        if (Util.isNullOrNil(localboo.rDl)) {
          break label1637;
        }
        paramView = localc.grN();
        if (paramView != null) {
          paramView.setText((CharSequence)localboo.rDl);
        }
        paramView = localc.grN();
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramInt = com.tencent.mm.cd.a.fromDPToPix(localc.parent.getContext(), 22);
        i = localc.parent.getContext().getResources().getColor(b.b.BW_0);
        localObject2 = localc.grM();
        if (localObject2 != null)
        {
          localObject1 = localboo.songName;
          float f = paramInt;
          ((MusicMvMarqueeTextView)localObject2).paint.setTextSize(f);
          ((MusicMvMarqueeTextView)localObject2).paint.setColor(i);
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((MusicMvMarqueeTextView)localObject2).MiO = paramView;
          ((MusicMvMarqueeTextView)localObject2).grE();
          ((MusicMvMarqueeTextView)localObject2).grF();
        }
        paramView = localc.grM();
        if (paramView != null) {
          paramView.setTag(localboo.songName);
        }
        paramView = localboo.ZWS;
        localObject1 = new e.a();
        Log.d(com.tencent.mm.plugin.mv.ui.view.c.TAG, s.X("thumb url:", paramView));
        localc.grP().setVisibility(8);
        localc.grQ().setVisibility(0);
        localObject2 = com.tencent.mm.plugin.music.model.g.LMs;
        ((e.a)localObject1).GG(com.tencent.mm.plugin.music.model.g.aOX(paramView));
        ((e.a)localObject1).nqd = true;
        ((e.a)localObject1).nqc = true;
        localObject1 = ((e.a)localObject1).blI();
        localObject2 = localc.grP();
        if ((paramView != null) && (localObject2 != null))
        {
          com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.noo;
          com.tencent.mm.loader.e.blh().a(paramView, (ImageView)localObject2, (com.tencent.mm.loader.b.e)localObject1, (m)new c.r(paramView, (MMImageView)localObject2, localc));
        }
        if (Util.isNullOrNil(localboo.ZWQ)) {
          break label1792;
        }
        paramView = localc.parent.getContext();
        localObject1 = com.tencent.mm.plugin.comm.a.xeG;
        if (!com.tencent.mm.plugin.comm.a.aml(localboo.ZWQ)) {
          break label1658;
        }
        localObject1 = paramView.getString(b.h.qq_music);
        s.s(localObject1, "context.getString(R.string.qq_music)");
        localc.grW().setText((CharSequence)paramView.getString(b.h.go_to_app_tips, new Object[] { localObject1 }));
        localc.grY().setText((CharSequence)paramView.getString(b.h.music_mv_h5_title, new Object[] { localObject1 }));
      }
      for (;;)
      {
        localc.grV().setRadius(com.tencent.mm.cd.a.fromDPToPix(paramView, 4));
        paramView = com.tencent.mm.plugin.mv.ui.a.Maz;
        if (!com.tencent.mm.plugin.mv.ui.a.l(localboo.ZWQ, (ImageView)localc.grV())) {
          break;
        }
        localc.grV().setVisibility(0);
        break;
        label1166:
        paramInt = 0;
        break label417;
        label1171:
        paramView = null;
        break label421;
        localObject2 = com.tencent.mm.util.i.agtt;
        label1194:
        label1212:
        int j;
        if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.agqX, 0) > 0)
        {
          paramInt = 1;
          localObject2 = com.tencent.mm.util.i.agtt;
          if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.agqY, 0) <= 0) {
            break label1293;
          }
          i = 1;
          localObject2 = com.tencent.mm.util.i.agtt;
          if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.agqZ, 0) <= 0) {
            break label1299;
          }
          j = 1;
          label1230:
          localObject2 = com.tencent.mm.util.i.agtt;
          if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.agra, 0) <= 0) {
            break label1305;
          }
        }
        label1293:
        label1299:
        label1305:
        for (int k = 1;; k = 0)
        {
          localObject2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zic, "");
          if ((!com.tencent.mm.plugin.comm.a.aml(paramView)) || (paramInt == 0)) {
            break label1311;
          }
          bool = true;
          break;
          paramInt = 0;
          break label1194;
          i = 0;
          break label1212;
          j = 0;
          break label1230;
        }
        label1311:
        if ((com.tencent.mm.plugin.comm.a.amm(paramView)) && (i != 0))
        {
          bool = true;
          break label457;
        }
        if ((com.tencent.mm.plugin.comm.a.amo(paramView)) && (j != 0))
        {
          bool = true;
          break label457;
        }
        if ((com.tencent.mm.plugin.comm.a.amn(paramView)) && (k != 0))
        {
          bool = true;
          break label457;
        }
        s.s(localObject2, "shieldAppIds");
        if (Util.isNullOrNil((String)localObject2))
        {
          bool = false;
          break label457;
        }
        bool = p.a((Iterable)n.b((CharSequence)localObject2, new String[] { "," }), paramView);
        break label457;
        label1421:
        localc.Mjz = true;
        localc.grS().setVisibility(8);
        localc.grT().setVisibility(0);
        localc.grX().setVisibility(0);
        localc.grZ().setVisibility(0);
        s.checkNotNull(localObject1);
        Log.i(com.tencent.mm.plugin.mv.ui.view.c.TAG, "showWebView");
        localc.MjC.setValue(Boolean.FALSE);
        if (localc.webView == null) {
          localc.webView = MMWebView.a.nL(localc.parent.getContext());
        }
        paramView = localc.webView;
        if (paramView == null) {
          break label644;
        }
        localc.e(paramView);
        paramView.setVisibility(4);
        paramView.setAlpha(0.0F);
        localc.Mju = new com.tencent.mm.plugin.mv.ui.view.e(localboo, paramView);
        paramView = localc.Mju;
        if (paramView != null) {
          paramView.a((l)localc.MjG);
        }
        paramView = localc.Mju;
        if (paramView != null) {
          paramView.a((com.tencent.mm.plugin.webview.core.h)localc.MjF);
        }
        paramView = localc.Mju;
        if (paramView != null) {
          paramView.init();
        }
        localc.aPH((String)localObject1);
        break label644;
        label1637:
        paramView = localc.grN();
        if (paramView == null) {
          break label739;
        }
        paramView.setVisibility(4);
        break label739;
        label1658:
        localObject1 = com.tencent.mm.pluginsdk.model.app.h.x(paramView, localboo.ZWQ);
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() > 0)
          {
            paramInt = 1;
            label1690:
            if (paramInt != 1) {
              break label1774;
            }
          }
        }
        label1774:
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label1779;
          }
          localc.grW().setVisibility(0);
          localc.grW().setText((CharSequence)paramView.getString(b.h.go_to_app_tips, new Object[] { localObject1 }));
          localc.grY().setText((CharSequence)paramView.getString(b.h.music_mv_h5_title, new Object[] { localObject1 }));
          break;
          paramInt = 0;
          break label1690;
        }
        label1779:
        localc.grW().setVisibility(8);
      }
      label1792:
      paramView = localc.grU();
      if (paramView == null) {
        break label236;
      }
      paramView.setVisibility(4);
      break label236;
      label1813:
      paramInt = 0;
      break label319;
      label1818:
      paramt.MgZ = true;
      paramf = k.aeZF;
      ((g)k.d(paramt.getActivity()).q(g.class)).Meo.gsf();
      paramf = paramt.MgW;
      if (paramf != null)
      {
        Log.i(com.tencent.mm.plugin.mv.ui.view.c.TAG, "show song info dialog, isShow:" + paramf.Mjy + ", translateY:" + paramf.grL().getTranslationY());
        if (!paramf.Mjy)
        {
          Log.i(com.tencent.mm.plugin.mv.ui.view.c.TAG, "doShow");
          if ((paramf.Mjz) && (paramf.uGn != 0))
          {
            paramf.grR().setAlpha(0.0F);
            paramView = paramf.webView;
            if (paramView != null) {
              paramView.setAlpha(0.0F);
            }
          }
          paramf.grK().setVisibility(0);
          paramf.grL().animate().translationY(0.0F).alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new c.u(paramf)).start();
          paramView = paramf.LWI;
          localObject1 = paramf.Mcj;
          if ((paramView != null) && (localObject1 != null))
          {
            localObject2 = o.LYk;
            paramf = paramf.parent.getContext();
            s.s(paramf, "parent.context");
            o.a(paramf, paramView, (com.tencent.mm.plugin.mv.model.f)localObject1, 1, 0, 0);
          }
        }
      }
      if (paramViewGroup != null) {
        paramt.MdQ.ix((View)paramViewGroup).A(ar.setOf(new Integer[] { Integer.valueOf(b.e.lyric_view), Integer.valueOf(b.e.LTL), Integer.valueOf(b.e.LSB), Integer.valueOf(b.e.LSK), Integer.valueOf(b.e.LUZ), Integer.valueOf(b.e.LTK) }));
      }
    }
  }
  
  private static final void a(t paramt, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(287573);
    s.u(paramt, "this$0");
    paramt.getActivity().finish();
    AppMethodBeat.o(287573);
  }
  
  private static final void a(t paramt, View paramView)
  {
    AppMethodBeat.i(287551);
    s.u(paramt, "this$0");
    s.u(paramView, "$parent");
    paramt.iv(paramView);
    AppMethodBeat.o(287551);
  }
  
  private static final void a(t paramt, AppCompatActivity paramAppCompatActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287565);
    s.u(paramt, "this$0");
    s.u(paramAppCompatActivity, "$activity");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new t.d(paramInt1, paramInt2, paramt, paramAppCompatActivity));
    AppMethodBeat.o(287565);
  }
  
  private static final void a(boo paramboo, com.tencent.mm.plugin.mv.model.f paramf, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(287536);
    s.u(paramboo, "$songInfo");
    s.u(paramf, "$musicMv");
    s.u(paramViewGroup, "$parent");
    Object localObject;
    if (paramBoolean1)
    {
      localObject = o.LYk;
      localObject = paramViewGroup.getContext();
      s.s(localObject, "parent.context");
      o.a((Context)localObject, paramboo, paramf, 2, 1, 1);
    }
    if (paramBoolean2)
    {
      localObject = o.LYk;
      paramViewGroup = paramViewGroup.getContext();
      s.s(paramViewGroup, "parent.context");
      o.a(paramViewGroup, paramboo, paramf, 2, 3, 1);
    }
    AppMethodBeat.o(287536);
  }
  
  private final void grh()
  {
    AppMethodBeat.i(287480);
    this.MgZ = false;
    Object localObject = k.aeZF;
    ((g)k.d(getActivity()).q(g.class)).Meo.dUX();
    localObject = this.MgW;
    if (localObject != null)
    {
      Log.i(com.tencent.mm.plugin.mv.ui.view.c.TAG, "hide song info dialog, isShow:" + ((com.tencent.mm.plugin.mv.ui.view.c)localObject).Mjy + ", translateY:" + ((com.tencent.mm.plugin.mv.ui.view.c)localObject).grL().getTranslationY());
      if (((com.tencent.mm.plugin.mv.ui.view.c)localObject).Mjy) {
        ((com.tencent.mm.plugin.mv.ui.view.c)localObject).grL().animate().translationY(1.0F * ((com.tencent.mm.plugin.mv.ui.view.c)localObject).MjB).alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new c.l((com.tencent.mm.plugin.mv.ui.view.c)localObject)).start();
      }
    }
    this.MdQ.restore();
    AppMethodBeat.o(287480);
  }
  
  private final void iu(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = null;
    AppMethodBeat.i(287492);
    Object localObject1 = com.tencent.mm.plugin.music.model.a.b.LMO;
    localObject1 = com.tencent.mm.aw.a.bLn();
    label158:
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = com.tencent.mm.plugin.music.model.a.b.aOZ((String)localObject1);
      Object localObject2 = k.aeZF;
      localObject2 = k.d(getActivity()).q(e.class);
      s.s(localObject2, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
      localObject2 = (e)localObject2;
      if (localObject1 != null) {
        break label365;
      }
      label66:
      if (((e)localObject2).LIC == 2)
      {
        label75:
        paramView.findViewById(b.e.LUK).setVisibility(8);
        ((TextView)paramView.findViewById(b.e.LUO)).setPadding(0, 0, 0, 0);
        paramView.findViewById(b.e.LUV).setVisibility(0);
        this.MgY = true;
        if (com.tencent.mm.ce.a.dH(com.tencent.mm.cd.a.mk((Context)getContext())) >= 6)
        {
          localObject1 = paramView.findViewById(b.e.LSF);
          if (!(localObject1 instanceof TextView)) {
            break label376;
          }
          localObject1 = (TextView)localObject1;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)getActivity().getString(b.h.LWh));
          }
          localObject1 = paramView.findViewById(b.e.LSG);
          if (!(localObject1 instanceof TextView)) {
            break label381;
          }
          localObject1 = (TextView)localObject1;
          label199:
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)getActivity().getString(b.h.LWh));
          }
        }
        localObject1 = com.tencent.mm.plugin.music.model.a.b.LMO;
        localObject1 = com.tencent.mm.aw.a.bLn();
        if (localObject1 != null) {
          break label386;
        }
        localObject1 = null;
        label234:
        if (s.p(com.tencent.mm.plugin.music.model.a.b.aPa((String)localObject1), Boolean.TRUE))
        {
          localObject1 = this.MgW;
          if (localObject1 != null) {
            break label394;
          }
          localObject1 = null;
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
          localObject1 = this.MgW;
          if (localObject1 != null) {
            break label402;
          }
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      label258:
      if ((localObject1 instanceof LinearLayout.LayoutParams)) {
        localLayoutParams = (LinearLayout.LayoutParams)localObject1;
      }
      if (localLayoutParams != null) {
        localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 12);
      }
      localObject1 = k.aeZF;
      if (((e)k.d(getActivity()).q(e.class)).LMi) {
        paramView.post(new t..ExternalSyntheticLambda6(this, paramView));
      }
      AppMethodBeat.o(287492);
      return;
      localObject1 = ((com.tencent.mm.aw.f)localObject1).oOZ;
      break;
      label365:
      if (((Integer)localObject1).intValue() == 2) {
        break label75;
      }
      break label66;
      label376:
      localObject1 = null;
      break label158;
      label381:
      localObject1 = null;
      break label199;
      label386:
      localObject1 = ((com.tencent.mm.aw.f)localObject1).oOZ;
      break label234;
      label394:
      localObject1 = ((com.tencent.mm.plugin.mv.ui.view.c)localObject1).gsc();
      break label258;
      label402:
      localObject1 = ((com.tencent.mm.plugin.mv.ui.view.c)localObject1).gsb();
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((View)localObject1).getLayoutParams();
      }
    }
  }
  
  private final void iv(View paramView)
  {
    Object localObject2 = null;
    ValueAnimator localValueAnimator = null;
    AppMethodBeat.i(287502);
    Object localObject1 = com.tencent.mm.plugin.music.model.a.b.LMO;
    localObject1 = com.tencent.mm.aw.a.bLn();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.aw.f)localObject1).oOZ)
    {
      localObject1 = com.tencent.mm.plugin.music.model.a.b.aOZ((String)localObject1);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(287502);
      return;
    }
    label132:
    label144:
    label199:
    int i;
    if (((Integer)localObject1).intValue() == 2)
    {
      localObject1 = com.tencent.mm.plugin.music.model.a.b.LMO;
      localObject1 = com.tencent.mm.aw.a.bLn();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!s.p(com.tencent.mm.plugin.music.model.a.b.aPa((String)localObject1), Boolean.TRUE)) {
          break label314;
        }
        com.tencent.mm.plugin.music.model.b.gnE();
        if (paramView != null) {
          break label132;
        }
      }
      for (localObject1 = null;; localObject1 = paramView.findViewById(b.e.LUV))
      {
        if (localObject1 != null) {
          break label144;
        }
        AppMethodBeat.o(287502);
        return;
        localObject1 = ((com.tencent.mm.aw.f)localObject1).oOZ;
        break;
      }
      if (this.Mha)
      {
        if (paramView == null)
        {
          localObject1 = null;
          ((View)localObject1).setVisibility(0);
          if (paramView != null) {
            break label199;
          }
        }
        for (paramView = localValueAnimator;; paramView = paramView.findViewById(b.e.LSF))
        {
          if (paramView != null) {
            paramView.setAlpha(1.0F);
          }
          AppMethodBeat.o(287502);
          return;
          localObject1 = paramView.findViewById(b.e.LSF);
          break;
        }
      }
      localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(150L);
      if (paramView != null) {
        break label321;
      }
      localObject1 = null;
      i = ((View)localObject1).getWidth();
      if (paramView != null) {
        break label333;
      }
    }
    label314:
    label321:
    label333:
    for (localObject1 = localObject2;; localObject1 = paramView.findViewById(b.e.LUW))
    {
      int j = ((View)localObject1).getWidth();
      localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
      localValueAnimator.addUpdateListener(new t..ExternalSyntheticLambda0(i, j, paramView));
      localValueAnimator.addListener((Animator.AnimatorListener)new e(paramView, this));
      localValueAnimator.start();
      AppMethodBeat.o(287502);
      return;
      localObject1 = paramView.findViewById(b.e.LUV);
      break;
    }
  }
  
  public final void a(final ViewGroup paramViewGroup, int paramInt, boo paramboo, com.tencent.mm.plugin.mv.model.f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(287664);
    s.u(paramViewGroup, "parent");
    s.u(paramboo, "songInfo");
    s.u(paramf, "musicMv");
    this.LWI = paramboo;
    Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", "update");
    TextView localTextView = (TextView)paramViewGroup.findViewById(b.e.LUO);
    Object localObject1;
    if ((!Util.isNullOrNil(paramboo.songName)) && (!Util.isNullOrNil(paramboo.rDl))) {
      localObject1 = paramboo.songName + '·' + paramboo.rDl;
    }
    for (;;)
    {
      localTextView.setContentDescription((CharSequence)localObject1);
      localTextView.setText((CharSequence)localObject1);
      localObject1 = paramViewGroup.findViewById(b.e.LUM);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new t..ExternalSyntheticLambda3(paramInt, this, paramf, paramViewGroup));
      }
      localObject1 = paramViewGroup.findViewById(b.e.LUG);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new t..ExternalSyntheticLambda2(paramInt, this, paramViewGroup, paramf));
      }
      if ((paramViewGroup instanceof InterceptRelativeLayout)) {
        ((InterceptRelativeLayout)paramViewGroup).setBeforeDispatchTouchEvent((kotlin.g.a.b)new f(paramInt, this));
      }
      paramf = com.tencent.mm.plugin.mv.ui.a.Maz;
      if (com.tencent.mm.plugin.mv.ui.a.k(paramboo.ZWQ, (ImageView)paramViewGroup.findViewById(b.e.LSj)))
      {
        paramViewGroup.findViewById(b.e.LSj).setAlpha(0.8F);
        paramViewGroup.findViewById(b.e.LSj).setVisibility(0);
        label266:
        paramf = com.tencent.mm.aw.a.bLn();
        if (paramf != null) {
          break label501;
        }
        paramf = null;
        label279:
        if (paramf != null)
        {
          paramf = com.tencent.mm.plugin.music.model.a.b.LMO;
          paramf = com.tencent.mm.aw.a.bLn();
          if (paramf != null) {
            break label511;
          }
          paramf = localObject2;
          label303:
          if (com.tencent.mm.plugin.music.model.a.b.aOZ(paramf) == null)
          {
            paramf = com.tencent.mm.plugin.music.model.a.b.LMO;
            com.tencent.mm.plugin.music.model.a.b.a((com.tencent.mm.plugin.music.model.a.b.a)new g(this, paramViewGroup));
          }
        }
        this.uJh = ((View)paramViewGroup);
        iu((View)paramViewGroup);
        paramboo = com.tencent.mm.pluginsdk.model.app.h.x((Context)getContext(), paramboo.ZWQ);
        if (paramboo == null) {
          break label526;
        }
        if (((CharSequence)paramboo).length() <= 0) {
          break label521;
        }
        paramInt = 1;
        label380:
        if (paramInt != 1) {
          break label526;
        }
        paramInt = 1;
        label387:
        if (paramInt != 0) {
          break label531;
        }
        paramViewGroup.findViewById(b.e.LSk).setVisibility(8);
      }
      for (;;)
      {
        if ((paramViewGroup.findViewById(b.e.LSk).getVisibility() != 0) && (paramViewGroup.findViewById(b.e.LSj).getVisibility() != 0)) {
          paramViewGroup.findViewById(b.e.LUJ).setVisibility(8);
        }
        AppMethodBeat.o(287664);
        return;
        if (!Util.isNullOrNil(paramboo.songName))
        {
          localObject1 = paramboo.songName;
          break;
        }
        if (Util.isNullOrNil(paramboo.rDl)) {
          break label579;
        }
        localObject1 = paramboo.rDl;
        break;
        paramViewGroup.findViewById(b.e.LSj).setVisibility(8);
        break label266;
        label501:
        paramf = paramf.oOZ;
        break label279;
        label511:
        paramf = paramf.oOZ;
        break label303;
        label521:
        paramInt = 0;
        break label380;
        label526:
        paramInt = 0;
        break label387;
        label531:
        paramViewGroup.findViewById(b.e.LSk).setVisibility(0);
        ((TextView)paramViewGroup.findViewById(b.e.LSk)).setText((CharSequence)getContext().getString(b.h.LVY, new Object[] { paramboo }));
      }
      label579:
      localObject1 = null;
    }
  }
  
  public final void gri()
  {
    AppMethodBeat.i(287686);
    Object localObject = this.Mhb.values();
    s.s(localObject, "seekBarMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MusicMainSeekBar localMusicMainSeekBar = (MusicMainSeekBar)((WeakReference)((Iterator)localObject).next()).get();
      if (localMusicMainSeekBar != null) {
        localMusicMainSeekBar.setVisibility(0);
      }
    }
    AppMethodBeat.o(287686);
  }
  
  public final void grj()
  {
    AppMethodBeat.i(287689);
    Object localObject = this.Mhb.values();
    s.s(localObject, "seekBarMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MusicMainSeekBar localMusicMainSeekBar = (MusicMainSeekBar)((WeakReference)((Iterator)localObject).next()).get();
      if (localMusicMainSeekBar != null) {
        localMusicMainSeekBar.setVisibility(8);
      }
    }
    AppMethodBeat.o(287689);
  }
  
  public final void grk()
  {
    AppMethodBeat.i(287698);
    Object localObject = k.aeZF;
    if (!((h)k.d(getActivity()).q(h.class)).MeB)
    {
      localObject = this.Mhc.values();
      s.s(localObject, "lyricLineViewMap.values");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecyclerView localRecyclerView = (RecyclerView)((WeakReference)((Iterator)localObject).next()).get();
        if (localRecyclerView != null) {
          localRecyclerView.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(287698);
  }
  
  public final void grl()
  {
    AppMethodBeat.i(287704);
    Object localObject = this.Mhc.values();
    s.s(localObject, "lyricLineViewMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecyclerView localRecyclerView = (RecyclerView)((WeakReference)((Iterator)localObject).next()).get();
      if (localRecyclerView != null) {
        localRecyclerView.setVisibility(8);
      }
    }
    AppMethodBeat.o(287704);
  }
  
  public final void grm()
  {
    AppMethodBeat.i(287711);
    Object localObject = this.Mhd.values();
    s.s(localObject, "mediaIconIvMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeImageView localWeImageView = (WeImageView)((WeakReference)((Iterator)localObject).next()).get();
      if (localWeImageView != null) {
        localWeImageView.setVisibility(0);
      }
    }
    AppMethodBeat.o(287711);
  }
  
  public final void grn()
  {
    AppMethodBeat.i(287719);
    Object localObject = this.Mhd.values();
    s.s(localObject, "mediaIconIvMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeImageView localWeImageView = (WeImageView)((WeakReference)((Iterator)localObject).next()).get();
      if (localWeImageView != null) {
        localWeImageView.setVisibility(8);
      }
    }
    AppMethodBeat.o(287719);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(287730);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      grh();
    }
    AppMethodBeat.o(287730);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287651);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.Mv.MusicMvSongInfoUIC", "onCreate");
    paramBundle = getActivity().findViewById(b.e.root_layout);
    s.s(paramBundle, "activity.findViewById(R.id.root_layout)");
    this.MgW = new com.tencent.mm.plugin.mv.ui.view.c((ViewGroup)paramBundle);
    paramBundle = this.MgW;
    if (paramBundle != null)
    {
      c.b localb = (c.b)new c(this);
      s.u(localb, "listener");
      paramBundle.MjE = localb;
    }
    this.Akp.alive();
    this.rDF.alive();
    AppMethodBeat.o(287651);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287678);
    Object localObject = this.alertDialog;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.a.e)localObject).dismiss();
    }
    this.Akp.dead();
    this.rDF.dead();
    grh();
    localObject = this.MgW;
    if (localObject != null)
    {
      MMWebView localMMWebView = ((com.tencent.mm.plugin.mv.ui.view.c)localObject).webView;
      if (localMMWebView != null) {
        localMMWebView.destroy();
      }
      localObject = ((com.tencent.mm.plugin.mv.ui.view.c)localObject).Mju;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mv.ui.view.e)localObject).onDestroy();
      }
    }
    j.gnw().gnj().b(this.LJz);
    localObject = com.tencent.mm.plugin.music.model.a.b.LMO;
    com.tencent.mm.plugin.music.model.a.b.goh();
    super.onDestroy();
    AppMethodBeat.o(287678);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(287673);
    j.gnw().gnj().b(this.LJz);
    super.onPause();
    AppMethodBeat.o(287673);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(287669);
    super.onResume();
    j.gnw().gnj().a(this.LJz);
    AppMethodBeat.o(287669);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$onCreate$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$OnCloseBtnClickListener;", "onClicked", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements c.b
  {
    c(t paramt) {}
    
    public final void fTj()
    {
      AppMethodBeat.i(287919);
      t.a(this.Mhe);
      AppMethodBeat.o(287919);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$showLongTryListen$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(View paramView, t paramt) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(287935);
      paramAnimator = this.Gaa;
      if (paramAnimator == null) {}
      for (paramAnimator = null; paramAnimator == null; paramAnimator = paramAnimator.findViewById(b.e.LSF))
      {
        AppMethodBeat.o(287935);
        return;
      }
      paramAnimator.setVisibility(0);
      t.iw(paramAnimator);
      jdField_this.Mha = true;
      AppMethodBeat.o(287935);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/MotionEvent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<MotionEvent, Boolean>
  {
    f(int paramInt, t paramt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$update$5", "Lcom/tencent/mm/plugin/music/model/cache/MusicLiveLinkCacheHelper$CacheSaveCallBack;", "onCallBack", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.plugin.music.model.a.b.a
  {
    g(t paramt, ViewGroup paramViewGroup) {}
    
    public final void goi()
    {
      AppMethodBeat.i(287939);
      t.b(this.Mhe, (View)paramViewGroup);
      com.tencent.mm.plugin.music.model.a.b localb = com.tencent.mm.plugin.music.model.a.b.LMO;
      com.tencent.mm.plugin.music.model.a.b.goh();
      AppMethodBeat.o(287939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.t
 * JD-Core Version:    0.7.0.1
 */