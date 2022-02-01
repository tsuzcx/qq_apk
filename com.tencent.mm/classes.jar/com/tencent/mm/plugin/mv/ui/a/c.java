package com.tencent.mm.plugin.mv.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.uniComments.UniCommentDrawer;
import com.tencent.mm.plugin.finder.uniComments.e.a;
import com.tencent.mm.plugin.finder.uniComments.model.a.d;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar.b;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.plugin.mv.model.o;
import com.tencent.mm.plugin.mv.ui.adapter.MusicLyricLayoutManager;
import com.tencent.mm.plugin.mv.ui.uic.e;
import com.tencent.mm.plugin.mv.ui.uic.r;
import com.tencent.mm.plugin.mv.ui.uic.x;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "forward2Runnable", "Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ForwardRunnable;", "getForward2Runnable", "()Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ForwardRunnable;", "setForward2Runnable", "(Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ForwardRunnable;)V", "fullScreenAnimate", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "hideSeekBar", "Ljava/lang/Runnable;", "isPopupWindowShowed", "", "shouldShowUinComponent", "getShouldShowUinComponent", "()Z", "setShouldShowUinComponent", "(Z)V", "showOnlyForward", "getShowOnlyForward", "setShowOnlyForward", "checkFullLyricStatus", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "checkPayLoadsToRefresh", "payloads", "", "", "doUniLike", "dataUIC", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDataUIC;", "forceLike", "getLayoutId", "", "initBgCover", "item", "initChattingInfo", "initDeleteStatus", "initFullScreen", "position", "initLocalPostStats", "initMvInfo", "initSongHolderView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "initSongInfo", "likeMvClick", "source", "onBindViewHolder", "type", "isHotPatch", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "refreshViewInSongInfoUIC", "updateCommentCount", "updateFullScreen", "updateLikeStatus", "updateMediaIconStatus", "updateUniCommentCount", "realNumber", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDataUIC;Ljava/lang/Integer;)V", "updateUniForwardStatus", "updateUniLikeStatus", "Companion", "ForwardRunnable", "ItemGestureListener", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.view.recyclerview.f<b>
{
  public static final c.a MaY;
  private static final String TAG;
  private final x MaZ;
  private boolean Mba;
  private final Runnable Mbb;
  boolean Mbc;
  private boolean Mbd;
  private b Mbe;
  final AppCompatActivity activity;
  
  static
  {
    AppMethodBeat.i(288317);
    MaY = new c.a((byte)0);
    TAG = "MicroMsg.Mv.MvItemConvert";
    AppMethodBeat.o(288317);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(288196);
    this.activity = paramAppCompatActivity;
    this.MaZ = new x();
    this.Mbb = new c..ExternalSyntheticLambda14(this);
    AppMethodBeat.o(288196);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(288256);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$item");
    paramb = paramb.MaX.LXg;
    if (paramb != null)
    {
      long l = ((Number)paramb).longValue();
      paramb = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      paramb = d.a.qr(l);
      if (paramb != null) {
        ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().fy(paramb);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288256);
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.mv.ui.uic.g paramg, View paramView)
  {
    AppMethodBeat.i(288272);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$item");
    kotlin.g.b.s.u(paramg, "$mvInfoUIC");
    paramb = paramb.MaX.LXp;
    if (paramb != null)
    {
      paramb = paramb.username;
      if (paramb != null) {
        paramg.cB(paramb, true);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288272);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(288246);
    kotlin.g.b.s.u(paramc, "this$0");
    k localk = k.aeZF;
    ((com.tencent.mm.plugin.mv.ui.uic.t)k.d(paramc.activity).q(com.tencent.mm.plugin.mv.ui.uic.t.class)).grj();
    AppMethodBeat.o(288246);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(288261);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramView = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramView = (dtk)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)paramc.activity, 7, dtk.class);
    if (paramView != null) {
      paramView.aaZe = 3;
    }
    com.tencent.mm.aw.a.bLi();
    paramView = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.zK(true);
    paramc.activity.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288261);
  }
  
  private static final void a(final c paramc, b paramb, e parame, final com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(288268);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramb, "$item");
    kotlin.g.b.s.u(parame, "$dataUIC");
    kotlin.g.b.s.u(paramj, "$holder");
    k localk = k.aeZF;
    ((com.tencent.mm.plugin.mv.ui.uic.g)k.d(paramc.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class)).a(paramb.MaX, parame.AAW, (CommentDrawerContract.CloseDrawerCallback)new j(paramb, paramc, paramj));
    parame.MdZ = false;
    AppMethodBeat.o(288268);
  }
  
  private static final void a(final c paramc, b paramb, final com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(288265);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramb);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramb, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    paramView = k.aeZF;
    paramView = k.d(paramc.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class);
    kotlin.g.b.s.s(paramView, "UICProvider.of(activity)…sicMvInfoUIC::class.java)");
    com.tencent.mm.plugin.mv.ui.uic.g.a((com.tencent.mm.plugin.mv.ui.uic.g)paramView, paramb.MaX, (CommentDrawerContract.CloseDrawerCallback)new i(paramb, paramc, paramj));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288265);
  }
  
  private static final void a(c paramc, final e parame, final com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(288289);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(parame, "$dataUIC");
    kotlin.g.b.s.u(paramj, "$holder");
    Object localObject = k.aeZF;
    localObject = (com.tencent.mm.plugin.mv.ui.uic.g)k.d(paramc.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class);
    paramc = new h(paramc, paramj, parame);
    ((com.tencent.mm.plugin.mv.ui.uic.g)localObject).a(parame.AAW, (e.a)paramc);
    AppMethodBeat.o(288289);
  }
  
  private static final void a(c paramc, com.tencent.mm.view.recyclerview.j paramj, b paramb, View paramView)
  {
    AppMethodBeat.i(288263);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramj);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramb, "$item");
    paramc.a(paramj, paramb, 1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288263);
  }
  
  private static final void a(c paramc, com.tencent.mm.view.recyclerview.j paramj, e parame, View paramView)
  {
    AppMethodBeat.i(288281);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramj);
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parame, "$dataUIC");
    a(paramj, parame, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288281);
  }
  
  private static final void a(com.tencent.mm.plugin.mv.ui.uic.g paramg, b paramb, View paramView)
  {
    AppMethodBeat.i(288277);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramg, "$mvInfoUIC");
    kotlin.g.b.s.u(paramb, "$item");
    paramg.i(paramb.MaX);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288277);
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, b paramb, int paramInt)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(288244);
    Object localObject1 = k.aeZF;
    localObject1 = k.d(this.activity).q(e.class);
    kotlin.g.b.s.s(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    Object localObject2 = (e)localObject1;
    Log.i(TAG, "likeMvClick " + paramb.MaX.LXj + ' ' + paramb.MaX.LXk + ' ' + paramb.MaX.LXs);
    boolean bool;
    label171:
    long l;
    if (paramb.MaX.LXs == 1)
    {
      localObject1 = paramb.MaX;
      com.tencent.mm.plugin.mv.model.f localf;
      if (!paramb.MaX.LXq)
      {
        bool = true;
        ((com.tencent.mm.plugin.mv.model.f)localObject1).LXq = bool;
        if (!paramb.MaX.LXq) {
          break label302;
        }
        localObject1 = paramb.MaX;
        ((com.tencent.mm.plugin.mv.model.f)localObject1).likeCount += 1;
        d(paramj, paramb);
        localObject1 = paramb.MaX.LXj;
        paramj = paramb.MaX.LXk;
        if ((localObject1 == null) || (paramj == null)) {
          break label527;
        }
        l = ((Number)localObject1).longValue();
        localObject1 = o.LYk;
        localObject1 = (Context)this.activity;
        localObject2 = ((e)localObject2).LWI;
        localf = paramb.MaX;
        if (!paramb.MaX.LXq) {
          break label323;
        }
      }
      for (;;)
      {
        o.a((Context)localObject1, (boo)localObject2, localf, i, paramInt);
        com.tencent.mm.kernel.h.aZW().a((p)new com.tencent.mm.plugin.mv.model.a.g(l, paramj, paramb.MaX.LXq), 0);
        AppMethodBeat.o(288244);
        return;
        bool = false;
        break;
        label302:
        localObject1 = paramb.MaX;
        ((com.tencent.mm.plugin.mv.model.f)localObject1).likeCount -= 1;
        break label171;
        label323:
        i = 2;
      }
    }
    else if (paramb.MaX.LXs == 4)
    {
      localObject1 = paramb.MaX;
      if (paramb.MaX.LXq) {
        break label534;
      }
      bool = true;
      ((com.tencent.mm.plugin.mv.model.f)localObject1).LXq = bool;
      if (!paramb.MaX.LXq) {
        break label540;
      }
      localObject1 = paramb.MaX;
      ((com.tencent.mm.plugin.mv.model.f)localObject1).likeCount += 1;
      label394:
      d(paramj, paramb);
      paramj = paramb.MaX.LXv;
      if (paramj != null) {
        break label561;
      }
      paramj = null;
      label413:
      localObject1 = paramb.MaX.LXv;
      if (localObject1 != null) {
        break label572;
      }
      localObject1 = null;
      label430:
      if ((paramj != null) && (localObject1 != null))
      {
        l = ((Number)paramj).longValue();
        com.tencent.mm.kernel.h.aZW().a((p)new com.tencent.mm.plugin.mv.model.a.g(l, (String)localObject1, paramb.MaX.LXq), 0);
        paramj = o.LYk;
        paramj = (Context)this.activity;
        localObject1 = ((e)localObject2).LWI;
        localObject2 = paramb.MaX;
        if (!paramb.MaX.LXq) {
          break label582;
        }
      }
    }
    label527:
    label534:
    label540:
    label561:
    label572:
    label582:
    for (i = j;; i = 2)
    {
      o.a(paramj, (boo)localObject1, (com.tencent.mm.plugin.mv.model.f)localObject2, i, paramInt);
      AppMethodBeat.o(288244);
      return;
      bool = false;
      break;
      localObject1 = paramb.MaX;
      ((com.tencent.mm.plugin.mv.model.f)localObject1).likeCount -= 1;
      break label394;
      paramj = Long.valueOf(paramj.id);
      break label413;
      localObject1 = ((FinderObject)localObject1).objectNonceId;
      break label430;
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, e parame, Integer paramInteger)
  {
    AppMethodBeat.i(288202);
    if (paramInteger != null)
    {
      int i = ((Number)paramInteger).intValue();
      paramj = (TextView)paramj.caK.findViewById(b.e.LSd);
      parame = av.GiL;
      paramj.setText((CharSequence)av.Up(i));
      AppMethodBeat.o(288202);
      return;
    }
    paramj = (TextView)paramj.caK.findViewById(b.e.LSd);
    if (parame.commentCount > 0)
    {
      paramInteger = av.GiL;
      paramj.setText((CharSequence)av.Up(parame.commentCount));
      AppMethodBeat.o(288202);
      return;
    }
    paramj.setText((CharSequence)this.activity.getResources().getString(b.h.finder_comment_count_text));
    AppMethodBeat.o(288202);
  }
  
  private static void a(com.tencent.mm.view.recyclerview.j paramj, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(288221);
    Object localObject1 = (WeImageView)paramj.caK.findViewById(b.e.LSP);
    if (!parame.Mei) {}
    for (boolean bool = true; (paramBoolean) && (!bool); bool = false)
    {
      AppMethodBeat.o(288221);
      return;
    }
    parame.Mei = bool;
    Object localObject2;
    label163:
    int i;
    if (bool)
    {
      ((WeImageView)localObject1).setImageResource(b.g.icons_filled_like);
      ((WeImageView)localObject1).setIconColor(paramj.caK.getResources().getColor(b.b.Red));
      localObject1 = com.tencent.mm.plugin.finder.uniComments.report.a.Gbf;
      localObject1 = parame.LWI;
      localObject2 = com.tencent.mm.plugin.finder.uniComments.report.a.a.Gbg;
      com.tencent.mm.plugin.finder.uniComments.report.a.a((boo)localObject1, com.tencent.mm.plugin.finder.uniComments.report.a.a.fdL());
      localObject1 = (TextView)paramj.caK.findViewById(b.e.LSS);
      if (!bool) {
        break label402;
      }
      parame.likeCount += 1;
      paramj = av.GiL;
      ((TextView)localObject1).setText((CharSequence)av.Up(parame.likeCount));
      parame = new com.tencent.mm.plugin.finder.uniComments.cgi.c(new com.tencent.mm.plugin.finder.uniComments.model.b(parame.Meg, parame.Meh));
      if (!bool) {
        break label466;
      }
      paramj = a.d.GaZ;
      i = a.d.fdI();
      label199:
      localObject1 = new com.tencent.mm.am.c.a();
      localObject2 = new bye();
      ((bye)localObject2).xlJ = parame.Gah.xlJ;
      ((bye)localObject2).GaE = parame.Gah.GaE;
      paramj = parame.Gah.Gbe;
      if (paramj != null) {
        break label477;
      }
    }
    for (paramj = null;; paramj = aw.j((com.tencent.mm.bx.a)paramj))
    {
      ((bye)localObject2).aagU = paramj;
      paramj = bi.ABn;
      ((bye)localObject2).aagN = bi.dVu();
      ((bye)localObject2).ZNy = System.currentTimeMillis();
      ((bye)localObject2).aagR = i;
      ((com.tencent.mm.am.c.a)localObject1).otE = ((com.tencent.mm.bx.a)localObject2);
      ((com.tencent.mm.am.c.a)localObject1).otF = ((com.tencent.mm.bx.a)new byf());
      ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderunilike";
      ((com.tencent.mm.am.c.a)localObject1).funcId = 6989;
      parame.c(((com.tencent.mm.am.c.a)localObject1).bEF());
      parame.bFJ();
      AppMethodBeat.o(288221);
      return;
      ((WeImageView)localObject1).setImageResource(b.g.icons_filled_like);
      ((WeImageView)localObject1).setIconColor(paramj.caK.getResources().getColor(b.b.White));
      localObject1 = com.tencent.mm.plugin.finder.uniComments.report.a.Gbf;
      localObject1 = parame.LWI;
      localObject2 = com.tencent.mm.plugin.finder.uniComments.report.a.a.Gbg;
      com.tencent.mm.plugin.finder.uniComments.report.a.a((boo)localObject1, com.tencent.mm.plugin.finder.uniComments.report.a.a.fdM());
      break;
      label402:
      if (parame.likeCount > 1)
      {
        parame.likeCount -= 1;
        paramj = av.GiL;
        ((TextView)localObject1).setText((CharSequence)av.Up(parame.likeCount));
        break label163;
      }
      ((TextView)localObject1).setText((CharSequence)paramj.caK.getResources().getString(b.h.music_main_like));
      break label163;
      label466:
      paramj = a.d.GaZ;
      i = a.d.fdJ();
      break label199;
      label477:
      aw localaw = aw.Gjk;
    }
  }
  
  private static final void b(b paramb, com.tencent.mm.plugin.mv.ui.uic.g paramg, View paramView)
  {
    AppMethodBeat.i(288275);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$item");
    kotlin.g.b.s.u(paramg, "$mvInfoUIC");
    paramb = paramb.MaX.LXp;
    if (paramb != null)
    {
      paramb = paramb.username;
      if (paramb != null) {
        paramg.cB(paramb, true);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288275);
  }
  
  private static final void b(c paramc, b paramb, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(288271);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramb);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramb, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    paramView = k.aeZF;
    paramView = ((com.tencent.mm.plugin.mv.ui.uic.g)k.d(paramc.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class)).Meo;
    if (paramView.isShowing()) {
      paramView.dismiss();
    }
    paramView = com.tencent.mm.plugin.mv.ui.a.Maz;
    if (com.tencent.mm.plugin.mv.ui.a.e(paramb.MaX))
    {
      paramView = k.aeZF;
      paramc = k.d(paramc.activity).q(r.class);
      kotlin.g.b.s.s(paramc, "UICProvider.of(activity)…icMvShareUIC::class.java)");
      r.a((r)paramc, paramj, paramb.MaX);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288271);
  }
  
  private static final void b(c paramc, final com.tencent.mm.view.recyclerview.j paramj, final e parame, View paramView)
  {
    AppMethodBeat.i(288283);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramj);
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parame, "$dataUIC");
    paramView = k.aeZF;
    ((com.tencent.mm.plugin.mv.ui.uic.g)k.d(paramc.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class)).a(0L, (e.a)new g(paramc, paramj, parame));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288283);
  }
  
  private static final boolean b(GestureDetector paramGestureDetector, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(288293);
    kotlin.g.b.s.u(paramGestureDetector, "$gestureDetector");
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramGestureDetector, paramView.aYi(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "initFullScreen$lambda-32", "(Landroid/view/GestureDetector;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramGestureDetector, paramGestureDetector.onTouchEvent((MotionEvent)paramView.sb(0)), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "initFullScreen$lambda-32", "(Landroid/view/GestureDetector;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(288293);
    return bool;
  }
  
  private static final void c(c paramc, b paramb, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(288285);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramb);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramb, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    paramView = k.aeZF;
    paramView = ((com.tencent.mm.plugin.mv.ui.uic.g)k.d(paramc.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class)).Meo;
    if (paramView.isShowing()) {
      paramView.dismiss();
    }
    paramView = com.tencent.mm.plugin.mv.ui.a.Maz;
    if (com.tencent.mm.plugin.mv.ui.a.e(paramb.MaX))
    {
      paramView = k.aeZF;
      paramc = k.d(paramc.activity).q(r.class);
      kotlin.g.b.s.s(paramc, "UICProvider.of(activity)…icMvShareUIC::class.java)");
      r.a((r)paramc, paramj, paramb.MaX);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288285);
  }
  
  private final void c(com.tencent.mm.view.recyclerview.j paramj, b paramb)
  {
    AppMethodBeat.i(288229);
    paramj = (TextView)paramj.caK.findViewById(b.e.comment_count_tv);
    if (paramb.MaX.commentCount > 0)
    {
      av localav = av.GiL;
      paramj.setText((CharSequence)av.Up(paramb.MaX.commentCount));
      AppMethodBeat.o(288229);
      return;
    }
    paramj.setText((CharSequence)this.activity.getResources().getString(b.h.finder_comment_count_text));
    AppMethodBeat.o(288229);
  }
  
  private static final void d(c paramc, b paramb, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(288290);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramb);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramb, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    paramView = k.aeZF;
    paramView = ((com.tencent.mm.plugin.mv.ui.uic.g)k.d(paramc.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class)).Meo;
    if (paramView.isShowing()) {
      paramView.dismiss();
    }
    paramView = com.tencent.mm.plugin.mv.ui.a.Maz;
    if (com.tencent.mm.plugin.mv.ui.a.e(paramb.MaX))
    {
      paramView = k.aeZF;
      paramc = k.d(paramc.activity).q(r.class);
      kotlin.g.b.s.s(paramc, "UICProvider.of(activity)…icMvShareUIC::class.java)");
      r.a((r)paramc, paramj, paramb.MaX);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288290);
  }
  
  private static void d(com.tencent.mm.view.recyclerview.j paramj, b paramb)
  {
    AppMethodBeat.i(288236);
    Object localObject = (WeImageView)paramj.caK.findViewById(b.e.icon_feed_like);
    if (paramb.MaX.LXq)
    {
      ((WeImageView)localObject).setImageResource(b.g.icons_filled_like);
      ((WeImageView)localObject).setIconColor(paramj.caK.getResources().getColor(b.b.Red));
      localObject = (TextView)paramj.caK.findViewById(b.e.like_count_tv);
      if (paramb.MaX.likeCount <= 0) {
        break label178;
      }
      paramj = av.GiL;
      ((TextView)localObject).setText((CharSequence)av.Up(paramb.MaX.likeCount));
    }
    for (;;)
    {
      Log.i(TAG, "updateLikeStatus isLike:" + paramb.MaX.LXq + " likeCount:" + paramb.MaX.likeCount);
      AppMethodBeat.o(288236);
      return;
      ((WeImageView)localObject).setImageResource(b.g.icons_filled_like);
      ((WeImageView)localObject).setIconColor(paramj.caK.getResources().getColor(b.b.White));
      break;
      label178:
      ((TextView)localObject).setText((CharSequence)paramj.caK.getResources().getString(b.h.music_main_like));
    }
  }
  
  private static final void m(com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(288251);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    paramj = paramj.caK.findViewById(b.e.LTK);
    if (paramj != null) {
      paramj.setVisibility(8);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288251);
  }
  
  public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(288365);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    paramj = (RecyclerView.v)paramj;
    ((MusicMainSeekBar)paramj.caK.findViewById(b.e.LTa)).setOnSeekBarChange((MusicMainSeekBar.b)new k(this, paramj));
    paramRecyclerView = (RecyclerView)paramj.caK.findViewById(b.e.LSX);
    if (paramRecyclerView != null)
    {
      Context localContext = paramj.caK.getContext();
      kotlin.g.b.s.s(localContext, "holder.itemView.context");
      paramRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new MusicLyricLayoutManager(localContext, (byte)0));
    }
    if (paramRecyclerView == null) {}
    for (paramRecyclerView = null;; paramRecyclerView = paramRecyclerView.getLayoutParams())
    {
      paramRecyclerView = (ViewGroup.MarginLayoutParams)paramRecyclerView;
      if (paramRecyclerView != null) {
        paramRecyclerView.topMargin = ((int)(this.activity.getResources().getDisplayMetrics().heightPixels * 0.37F - com.tencent.mm.cd.a.fromDPToPix(paramj.caK.getContext(), 15)));
      }
      AppMethodBeat.o(288365);
      return;
    }
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj, b paramb)
  {
    AppMethodBeat.i(288369);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramb, "item");
    paramb = ar.setOf(new Integer[] { Integer.valueOf(b.e.LUM), Integer.valueOf(b.e.LRY), Integer.valueOf(b.e.LSB), Integer.valueOf(b.e.footer_view) });
    k localk = k.aeZF;
    if (((e)k.d(this.activity).q(e.class)).Flq)
    {
      this.MaZ.ix(paramj.caK).A(paramb);
      this.MaZ.Mhg.clear();
      AppMethodBeat.o(288369);
      return;
    }
    this.MaZ.ix(paramj.caK).B(paramb);
    this.MaZ.Mhg.clear();
    AppMethodBeat.o(288369);
  }
  
  public final void b(com.tencent.mm.view.recyclerview.j paramj, b paramb)
  {
    AppMethodBeat.i(288374);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramb, "item");
    Object localObject = k.aeZF;
    if (!((e)k.d(this.activity).q(e.class)).Flq)
    {
      switch (paramb.MaX.LXs)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(288374);
        return;
        paramb = paramj.caK.findViewById(b.e.loading_layout);
        if (paramb != null) {
          paramb.setVisibility(8);
        }
        paramj = paramj.caK.findViewById(b.e.LSV);
        if (paramj == null) {
          break;
        }
        paramj.setVisibility(8);
        AppMethodBeat.o(288374);
        return;
        paramb = paramj.caK.findViewById(b.e.loading_layout);
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        paramj = paramj.caK.findViewById(b.e.LSV);
        if (paramj == null) {
          break;
        }
        paramj.setVisibility(8);
        AppMethodBeat.o(288374);
        return;
        localObject = paramj.caK.findViewById(b.e.loading_layout);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = paramj.caK.findViewById(b.e.LSV);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        paramj = paramj.caK.findViewById(b.e.LSV);
        if (paramj == null) {
          break;
        }
        paramj.setOnClickListener(new c..ExternalSyntheticLambda0(paramb));
        AppMethodBeat.o(288374);
        return;
        paramb = paramj.caK.findViewById(b.e.loading_layout);
        if (paramb != null) {
          paramb.setVisibility(8);
        }
        paramj = paramj.caK.findViewById(b.e.LSV);
        if (paramj == null) {
          break;
        }
        paramj.setVisibility(8);
      }
    }
    paramb = paramj.caK.findViewById(b.e.loading_layout);
    if (paramb != null) {
      paramb.setVisibility(8);
    }
    paramj = paramj.caK.findViewById(b.e.LSV);
    if (paramj != null) {
      paramj.setVisibility(8);
    }
    AppMethodBeat.o(288374);
  }
  
  public final int getLayoutId()
  {
    return b.f.LVB;
  }
  
  public final void m(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(288366);
    kotlin.g.b.s.u(paramj, "holder");
    super.m(paramj);
    AppMethodBeat.o(288366);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ForwardRunnable;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "mv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;Landroid/view/View;Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getView", "()Landroid/view/View;", "run", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements Runnable
  {
    private final com.tencent.mm.plugin.mv.model.f MaX;
    private final View view;
    
    public b(com.tencent.mm.plugin.mv.model.f paramf)
    {
      AppMethodBeat.i(288205);
      this.view = paramf;
      this.MaX = localObject;
      AppMethodBeat.o(288205);
    }
    
    public final void run()
    {
      AppMethodBeat.i(288222);
      Object localObject3 = this.view;
      c localc;
      if (localObject3 != null)
      {
        localc = c.this;
        try
        {
          Object localObject1 = new int[2];
          ((View)localObject3).getLocationInWindow((int[])localObject1);
          if ((localObject1[0] <= 0) || (localObject1[1] <= 0))
          {
            localObject3 = c.MaY;
            Log.e(c.access$getTAG$cp(), "invalid pos(" + localObject1 + "), return");
            AppMethodBeat.o(288222);
            return;
          }
          if (c.c(localc))
          {
            localObject1 = c.MaY;
            Log.i(c.access$getTAG$cp(), "has show, return");
            AppMethodBeat.o(288222);
            return;
          }
        }
        finally {}
      }
      label419:
      label428:
      label438:
      label449:
      label452:
      for (;;)
      {
        AppMethodBeat.o(288222);
        return;
        Object localObject4 = k.aeZF;
        if (!((com.tencent.mm.plugin.mv.ui.uic.h)k.d(localc.activity).q(com.tencent.mm.plugin.mv.ui.uic.h.class)).MeB)
        {
          localObject4 = k.aeZF;
          localObject4 = (com.tencent.mm.plugin.mv.ui.uic.g)k.d(localc.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class);
          Object localObject5 = ((com.tencent.mm.plugin.mv.ui.uic.g)localObject4).ATy;
          int i;
          boolean bool;
          if ((localObject5 != null) && (((com.tencent.mm.plugin.finder.view.f)localObject5).fkp() == true))
          {
            i = 1;
            if (i != 0) {
              break label449;
            }
            localObject4 = ((com.tencent.mm.plugin.mv.ui.uic.g)localObject4).Mem;
            if (localObject4 == null) {
              break label428;
            }
            localObject4 = ((com.tencent.mm.plugin.finder.uniComments.d)localObject4).FYA;
            if (localObject4 != null) {
              break label419;
            }
            bool = false;
            break label438;
          }
          for (;;)
          {
            if (i != 0) {
              break label452;
            }
            localObject4 = k.aeZF;
            localObject4 = ((com.tencent.mm.plugin.mv.ui.uic.g)k.d(localc.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class)).Meo;
            if (localObject4 != null)
            {
              localObject5 = this.MaX;
              kotlin.g.b.s.u(localObject5, "musicMv");
              ((com.tencent.mm.plugin.mv.ui.view.d)localObject4).Mcj = ((com.tencent.mm.plugin.mv.model.f)localObject5);
            }
            if (localObject4 != null)
            {
              localObject5 = k.aeZF;
              k.d(localc.activity).q(r.class);
              localObject5 = r.ji((Context)localc.activity);
              kotlin.g.b.s.u(localObject5, "tips");
              ((com.tencent.mm.plugin.mv.ui.view.d)localObject4).DMt.setText((CharSequence)localObject5);
            }
            if (localObject4 != null) {
              ((com.tencent.mm.plugin.mv.ui.view.d)localObject4).GDz = 10000L;
            }
            if (localObject4 != null) {
              ((com.tencent.mm.plugin.mv.ui.view.d)localObject4).GDy = localObject2[0];
            }
            if (localObject4 != null) {
              ((com.tencent.mm.plugin.mv.ui.view.d)localObject4).bmv = com.tencent.mm.cd.a.fromDPToPix((Context)localc.activity, 4);
            }
            if (localObject4 != null) {
              ((com.tencent.mm.plugin.mv.ui.view.d)localObject4).gX((View)localObject3);
            }
            if (localObject4 != null) {
              ((com.tencent.mm.plugin.mv.ui.view.d)localObject4).dUX();
            }
            c.d(localc);
            AppMethodBeat.o(288222);
            return;
            i = 0;
            break;
            bool = ((UniCommentDrawer)localObject4).fkp();
            for (i = 0; i == 0; i = 1)
            {
              i = 0;
              break;
              if (bool != true) {
                break label428;
              }
            }
            i = 1;
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "position", "", "(Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;I)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getItem", "()Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "getPosition", "()I", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "fullScreenTapLayout", "Landroid/view/ViewGroup;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onLongPress", "", "onSingleTapConfirmed", "onSingleTapUp", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends GestureDetector.SimpleOnGestureListener
  {
    private final com.tencent.mm.view.recyclerview.j AIz;
    private final b Mbg;
    private final int position;
    
    public c(b paramb, int paramInt)
    {
      AppMethodBeat.i(288209);
      this.AIz = paramb;
      this.Mbg = paramInt;
      int i;
      this.position = i;
      AppMethodBeat.o(288209);
    }
    
    private static WeImageView a(com.tencent.mm.view.recyclerview.j paramj, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(288223);
      WeImageView localWeImageView = new WeImageView(paramj.context);
      localWeImageView.setVisibility(4);
      int i = (int)paramj.context.getResources().getDimension(b.c.Edge_6_5_A);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      localLayoutParams.gravity = 17;
      ah localah = ah.aiuX;
      localWeImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      localWeImageView.setImageResource(b.g.finder_full_like);
      localWeImageView.setIconColor(paramj.context.getResources().getColor(b.b.Red_90));
      paramViewGroup.addView((View)localWeImageView);
      AppMethodBeat.o(288223);
      return localWeImageView;
    }
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(288260);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(288260);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(288255);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      localObject1 = c.MaY;
      Log.i(c.access$getTAG$cp(), "onDoubleTap");
      localObject1 = com.tencent.mm.plugin.mv.model.f.LXf;
      Object localObject2;
      com.tencent.mm.plugin.finder.view.animation.c localc;
      if (f.a.c(this.Mbg.MaX))
      {
        localObject1 = (ViewGroup)this.AIz.caK.findViewById(b.e.LSD);
        localObject2 = this.AIz;
        kotlin.g.b.s.s(localObject1, "fullScreenTapLayout");
        localObject2 = a((com.tencent.mm.view.recyclerview.j)localObject2, (ViewGroup)localObject1);
        localc = com.tencent.mm.plugin.finder.view.animation.c.GGo;
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localObject2, paramMotionEvent, ((ViewGroup)localObject1).getY());
        if (!this.Mbg.MaX.LXq)
        {
          c.a(c.this, this.AIz, this.Mbg);
          c.e(this.AIz, this.Mbg);
        }
      }
      if (c.this.Mbc)
      {
        localObject1 = (ViewGroup)this.AIz.caK.findViewById(b.e.LSD);
        localObject2 = this.AIz;
        kotlin.g.b.s.s(localObject1, "fullScreenTapLayout");
        localObject2 = a((com.tencent.mm.view.recyclerview.j)localObject2, (ViewGroup)localObject1);
        localc = com.tencent.mm.plugin.finder.view.animation.c.GGo;
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localObject2, paramMotionEvent, ((ViewGroup)localObject1).getY());
        paramMotionEvent = this.AIz;
        localObject1 = k.aeZF;
        localObject1 = k.d(c.this.activity).q(e.class);
        kotlin.g.b.s.s(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        c.a(paramMotionEvent, (e)localObject1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(288255);
      return false;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(288245);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      super.onLongPress(paramMotionEvent);
      paramMotionEvent = k.aeZF;
      paramMotionEvent = ((com.tencent.mm.plugin.mv.ui.uic.g)k.d(c.this.activity).q(com.tencent.mm.plugin.mv.ui.uic.g.class)).Meo;
      if (paramMotionEvent.isShowing()) {
        paramMotionEvent.dismiss();
      }
      paramMotionEvent = com.tencent.mm.plugin.mv.ui.a.Maz;
      if (com.tencent.mm.plugin.mv.ui.a.e(this.Mbg.MaX))
      {
        this.AIz.caK.performHapticFeedback(0, 2);
        paramMotionEvent = k.aeZF;
        ((r)k.d(c.this.activity).q(r.class)).a(this.AIz, this.Mbg.MaX, 3);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(288245);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(288241);
      paramMotionEvent = c.MaY;
      Log.i(c.access$getTAG$cp(), "onSingleTapConfirmed");
      paramMotionEvent = k.aeZF;
      if (((e)k.d(c.this.activity).q(e.class)).Flq)
      {
        paramMotionEvent = k.aeZF;
        ((e)k.d(c.this.activity).q(e.class)).Flq = false;
        c.this.a(this.AIz, this.Mbg);
        c.this.b(this.AIz, this.Mbg);
      }
      for (;;)
      {
        AppMethodBeat.o(288241);
        return false;
        c.a(c.this, this.AIz);
      }
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(288232);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(288232);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$10$1", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements e.a
  {
    g(c paramc, com.tencent.mm.view.recyclerview.j paramj, e parame) {}
    
    public final void z(int paramInt, List<? extends com.tencent.mm.plugin.finder.uniComments.storge.d> paramList)
    {
      AppMethodBeat.i(288199);
      kotlin.g.b.s.u(paramList, "data");
      c.a(this.Mbf, paramj, parame, Integer.valueOf(paramInt));
      AppMethodBeat.o(288199);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$12$1", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements e.a
  {
    h(c paramc, com.tencent.mm.view.recyclerview.j paramj, e parame) {}
    
    public final void z(int paramInt, List<? extends com.tencent.mm.plugin.finder.uniComments.storge.d> paramList)
    {
      AppMethodBeat.i(288215);
      kotlin.g.b.s.u(paramList, "data");
      c.a(this.Mbf, paramj, parame, Integer.valueOf(paramInt));
      AppMethodBeat.o(288215);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$2$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements CommentDrawerContract.CloseDrawerCallback
  {
    i(b paramb, c paramc, com.tencent.mm.view.recyclerview.j paramj) {}
    
    public final void z(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.t> paramList)
    {
      AppMethodBeat.i(288224);
      kotlin.g.b.s.u(paramList, "data");
      this.Mbk.MaX.commentCount = paramInt;
      c.b(paramc, paramj, this.Mbk);
      AppMethodBeat.o(288224);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$3$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements CommentDrawerContract.CloseDrawerCallback
  {
    j(b paramb, c paramc, com.tencent.mm.view.recyclerview.j paramj) {}
    
    public final void z(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.t> paramList)
    {
      AppMethodBeat.i(288226);
      kotlin.g.b.s.u(paramList, "data");
      this.Mbk.MaX.commentCount = paramInt;
      c.b(paramc, paramj, this.Mbk);
      AppMethodBeat.o(288226);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$1", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "onSeekBarChange", "", "seekPosition", "", "max", "onSeekEnd", "onSeekStart", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements MusicMainSeekBar.b
  {
    k(c paramc, RecyclerView.v paramv) {}
    
    public final void goV()
    {
      AppMethodBeat.i(288220);
      Object localObject = k.aeZF;
      ((com.tencent.mm.plugin.mv.ui.uic.t)k.d(this.Mbf.activity).q(com.tencent.mm.plugin.mv.ui.uic.t.class)).grn();
      localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject = (dtk)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)this.Mbf.activity, 7, dtk.class);
      if (localObject != null) {
        ((dtk)localObject).aaYT = 1;
      }
      paramj.caK.removeCallbacks(c.b(this.Mbf));
      AppMethodBeat.o(288220);
    }
    
    public final void kd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(288231);
      Object localObject = c.MaY;
      Log.i(c.access$getTAG$cp(), "onSeekEnd, seekPosition:" + paramInt1 + ", max:" + paramInt2);
      com.tencent.mm.aw.a.wH(paramInt1);
      float f1 = paramInt1 / paramInt2;
      float f2 = com.tencent.mm.plugin.music.logic.j.gnw().gnj().getDuration();
      localObject = (MultiMediaEffectVideoLayout)paramj.caK.findViewById(b.e.music_video_layout);
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).seekTo(kotlin.h.a.ai(f2 * f1));
      }
      com.tencent.mm.aw.a.bLh();
      paramj.caK.postDelayed(c.b(this.Mbf), 3000L);
      AppMethodBeat.o(288231);
    }
    
    public final void ke(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(288234);
      c.a locala = c.MaY;
      Log.i(c.access$getTAG$cp(), "onSeekBarChange " + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(288234);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c
 * JD-Core Version:    0.7.0.1
 */