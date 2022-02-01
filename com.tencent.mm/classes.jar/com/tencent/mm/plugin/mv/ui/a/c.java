package com.tencent.mm.plugin.mv.ui.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.v;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar.b;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.b.i;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.plugin.mv.ui.adapter.MusicLyricLayoutManager;
import com.tencent.mm.plugin.mv.ui.uic.u;
import com.tencent.mm.plugin.mv.ui.uic.w;
import com.tencent.mm.plugin.mv.ui.uic.z;
import com.tencent.mm.plugin.mv.ui.view.e.c;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ak.a;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "forward2Runnable", "Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ForwardRunnable;", "getForward2Runnable", "()Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ForwardRunnable;", "setForward2Runnable", "(Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ForwardRunnable;)V", "fullScreenAnimate", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "hideSeekBar", "Ljava/lang/Runnable;", "isPopupWindowShowed", "", "getLayoutId", "", "initBgCover", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "initChattingInfo", "initDeleteStatus", "initFullScreen", "position", "initLocalPostStats", "initMvInfo", "initSongHolderView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "initSongInfo", "likeMvClick", "source", "onBindViewHolder", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "updateCommentCount", "updateFullScreen", "updateLikeStatus", "updateMediaIconStatus", "Companion", "ForwardRunnable", "ItemGestureListener", "plugin-mv_release"})
public final class c
  extends com.tencent.mm.view.recyclerview.e<b>
{
  public static final c.a GfN;
  private static final String TAG = "MicroMsg.Mv.MvItemConvert";
  private final z GfJ;
  private boolean GfK;
  private final Runnable GfL;
  private b GfM;
  final AppCompatActivity xGq;
  
  static
  {
    AppMethodBeat.i(241747);
    GfN = new c.a((byte)0);
    TAG = "MicroMsg.Mv.MvItemConvert";
    AppMethodBeat.o(241747);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(241745);
    this.xGq = paramAppCompatActivity;
    this.GfJ = new z();
    this.GfL = ((Runnable)new d(this));
    AppMethodBeat.o(241745);
  }
  
  private final void c(com.tencent.mm.view.recyclerview.i parami, b paramb)
  {
    AppMethodBeat.i(241743);
    parami = (TextView)parami.amk.findViewById(b.e.comment_count_tv);
    if (paramb.GfI.commentCount > 0)
    {
      p.j(parami, "commentCntTv");
      aj localaj = aj.AGc;
      parami.setText((CharSequence)aj.Rh(paramb.GfI.commentCount));
      AppMethodBeat.o(241743);
      return;
    }
    p.j(parami, "commentCntTv");
    parami.setText((CharSequence)this.xGq.getResources().getString(b.h.finder_comment_count_text));
    AppMethodBeat.o(241743);
  }
  
  @SuppressLint({"ResourceType"})
  private static void d(com.tencent.mm.view.recyclerview.i parami, b paramb)
  {
    AppMethodBeat.i(241744);
    Object localObject = (WeImageView)parami.amk.findViewById(b.e.icon_feed_like);
    View localView;
    if (paramb.GfI.Gbs)
    {
      ((WeImageView)localObject).setImageResource(b.g.icons_filled_like);
      localView = parami.amk;
      p.j(localView, "holder.itemView");
      ((WeImageView)localObject).setIconColor(localView.getResources().getColor(b.b.Red));
      localObject = (TextView)parami.amk.findViewById(b.e.like_count_tv);
      if (paramb.GfI.likeCount <= 0) {
        break label203;
      }
      p.j(localObject, "likeTv");
      parami = aj.AGc;
      ((TextView)localObject).setText((CharSequence)aj.Rh(paramb.GfI.likeCount));
    }
    for (;;)
    {
      Log.i(TAG, "updateLikeStatus isLike:" + paramb.GfI.Gbs + " likeCount:" + paramb.GfI.likeCount);
      AppMethodBeat.o(241744);
      return;
      ((WeImageView)localObject).setImageResource(b.g.icons_filled_like);
      localView = parami.amk;
      p.j(localView, "holder.itemView");
      ((WeImageView)localObject).setIconColor(localView.getResources().getColor(b.b.White));
      break;
      label203:
      p.j(localObject, "likeTv");
      parami = parami.amk;
      p.j(parami, "holder.itemView");
      ((TextView)localObject).setText((CharSequence)parami.getResources().getString(b.h.music_main_like));
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(241735);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    parami = (RecyclerView.v)parami;
    ((MusicMainSeekBar)parami.amk.findViewById(b.e.FXA)).setOnSeekBarChange((MusicMainSeekBar.b)new t(this, parami));
    paramRecyclerView = (RecyclerView)parami.amk.findViewById(b.e.FXx);
    Object localObject;
    if (paramRecyclerView != null)
    {
      localObject = parami.amk;
      p.j(localObject, "holder.itemView");
      localObject = ((View)localObject).getContext();
      p.j(localObject, "holder.itemView.context");
      paramRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new MusicLyricLayoutManager((Context)localObject, (byte)0));
    }
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.getLayoutParams();; paramRecyclerView = null)
    {
      paramRecyclerView = (ViewGroup.MarginLayoutParams)paramRecyclerView;
      if (paramRecyclerView == null) {
        break;
      }
      localObject = this.xGq.getResources();
      p.j(localObject, "activity.resources");
      float f = ((Resources)localObject).getDisplayMetrics().heightPixels;
      parami = parami.amk;
      p.j(parami, "holder.itemView");
      paramRecyclerView.topMargin = ((int)(f * 0.37F - com.tencent.mm.ci.a.fromDPToPix(parami.getContext(), 15)));
      AppMethodBeat.o(241735);
      return;
    }
    AppMethodBeat.o(241735);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, b paramb)
  {
    AppMethodBeat.i(241741);
    p.k(parami, "holder");
    p.k(paramb, "item");
    paramb = kotlin.a.ak.setOf(new Integer[] { Integer.valueOf(b.e.FZa), Integer.valueOf(b.e.FWL), Integer.valueOf(b.e.FXm), Integer.valueOf(b.e.FXn) });
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    if (((com.tencent.mm.plugin.mv.ui.uic.g)com.tencent.mm.ui.component.g.b(this.xGq).i(com.tencent.mm.plugin.mv.ui.uic.g.class)).AJP)
    {
      this.GfJ.fF(parami.amk).s(paramb);
      this.GfJ.Gna.clear();
      AppMethodBeat.o(241741);
      return;
    }
    this.GfJ.fF(parami.amk).t(paramb);
    this.GfJ.Gna.clear();
    AppMethodBeat.o(241741);
  }
  
  public final void b(com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(241737);
    p.k(parami, "holder");
    super.b(parami);
    AppMethodBeat.o(241737);
  }
  
  public final void b(com.tencent.mm.view.recyclerview.i parami, b paramb)
  {
    AppMethodBeat.i(241742);
    p.k(parami, "holder");
    p.k(paramb, "item");
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    if (!((com.tencent.mm.plugin.mv.ui.uic.g)com.tencent.mm.ui.component.g.b(this.xGq).i(com.tencent.mm.plugin.mv.ui.uic.g.class)).AJP)
    {
      switch (paramb.GfI.Gbu)
      {
      default: 
        AppMethodBeat.o(241742);
        return;
      case 1: 
        paramb = parami.amk.findViewById(b.e.loading_layout);
        if (paramb != null) {
          paramb.setVisibility(8);
        }
        parami = parami.amk.findViewById(b.e.FXv);
        if (parami != null)
        {
          parami.setVisibility(8);
          AppMethodBeat.o(241742);
          return;
        }
        AppMethodBeat.o(241742);
        return;
      case 2: 
        paramb = parami.amk.findViewById(b.e.loading_layout);
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        parami = parami.amk.findViewById(b.e.FXv);
        if (parami != null)
        {
          parami.setVisibility(8);
          AppMethodBeat.o(241742);
          return;
        }
        AppMethodBeat.o(241742);
        return;
      case 3: 
        localObject = parami.amk.findViewById(b.e.loading_layout);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = parami.amk.findViewById(b.e.FXv);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        parami = parami.amk.findViewById(b.e.FXv);
        if (parami != null)
        {
          parami.setOnClickListener((View.OnClickListener)new c.j(paramb));
          AppMethodBeat.o(241742);
          return;
        }
        AppMethodBeat.o(241742);
        return;
      }
      paramb = parami.amk.findViewById(b.e.loading_layout);
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      parami = parami.amk.findViewById(b.e.FXv);
      if (parami != null)
      {
        parami.setVisibility(8);
        AppMethodBeat.o(241742);
        return;
      }
      AppMethodBeat.o(241742);
      return;
    }
    paramb = parami.amk.findViewById(b.e.loading_layout);
    if (paramb != null) {
      paramb.setVisibility(8);
    }
    parami = parami.amk.findViewById(b.e.FXv);
    if (parami != null)
    {
      parami.setVisibility(8);
      AppMethodBeat.o(241742);
      return;
    }
    AppMethodBeat.o(241742);
  }
  
  public final int getLayoutId()
  {
    return b.f.FZE;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ForwardRunnable;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "mv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;Landroid/view/View;Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getView", "()Landroid/view/View;", "run", "", "plugin-mv_release"})
  public final class b
    implements Runnable
  {
    private final f GfI;
    private final View view;
    
    public b(f paramf)
    {
      AppMethodBeat.i(240808);
      this.view = paramf;
      this.GfI = localObject;
      AppMethodBeat.o(240808);
    }
    
    public final void run()
    {
      AppMethodBeat.i(240806);
      Object localObject1 = this.view;
      if (localObject1 != null)
      {
        Object localObject4;
        try
        {
          localObject4 = new int[2];
          ((View)localObject1).getLocationInWindow((int[])localObject4);
          if ((localObject4[0] <= 0) || (localObject4[1] <= 0))
          {
            localObject1 = c.GfN;
            Log.e(c.access$getTAG$cp(), "invalid pos(" + localObject4 + "), return");
            AppMethodBeat.o(240806);
            return;
          }
          if (c.a(c.this))
          {
            localObject1 = c.GfN;
            Log.i(c.access$getTAG$cp(), "has show, return");
            AppMethodBeat.o(240806);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(240806);
          return;
        }
        Object localObject3 = com.tencent.mm.ui.component.g.Xox;
        localObject3 = ((com.tencent.mm.plugin.mv.ui.uic.i)com.tencent.mm.ui.component.g.b(c.this.xGq).i(com.tencent.mm.plugin.mv.ui.uic.i.class)).Gjj;
        Object localObject5;
        if (localObject3 != null)
        {
          localObject5 = this.GfI;
          p.k(localObject5, "musicMv");
          ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).GgZ = ((f)localObject5);
        }
        if (localObject3 != null)
        {
          localObject5 = com.tencent.mm.ui.component.g.Xox;
          com.tencent.mm.ui.component.g.b(c.this.xGq).i(u.class);
          localObject5 = u.hH((Context)c.this.xGq);
          p.k(localObject5, "tips");
          ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).AWF.setText((CharSequence)localObject5);
        }
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).Bbk = 10000L;
        }
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).Bbj = localObject4[0];
        }
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).Gr = com.tencent.mm.ci.a.fromDPToPix((Context)c.this.xGq, 4);
        }
        int i;
        int j;
        int k;
        int m;
        int i1;
        int n;
        Object localObject2;
        if (localObject3 != null)
        {
          p.k(localThrowable, "anchor");
          if (!((com.tencent.mm.plugin.mv.ui.view.e)localObject3).Bbh)
          {
            ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).getContentView().measure(0, 0);
            ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).Bbh = true;
          }
          localObject4 = ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).getContentView();
          p.j(localObject4, "contentView");
          i = ((View)localObject4).getMeasuredWidth();
          localObject4 = ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).getContentView();
          p.j(localObject4, "contentView");
          j = ((View)localObject4).getMeasuredHeight();
          localObject4 = new int[2];
          localThrowable.getLocationInWindow((int[])localObject4);
          localObject5 = com.tencent.mm.ui.ak.kU(((com.tencent.mm.plugin.mv.ui.view.e)localObject3).context);
          k = ((ak.a)localObject5).width;
          m = ((ak.a)localObject5).height;
          i1 = com.tencent.mm.ci.a.fromDPToPix(((com.tencent.mm.plugin.mv.ui.view.e)localObject3).context, 16);
          n = localObject4[1] - j;
          i1 = k - i - i1;
          localObject5 = ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).Bbf.getLayoutParams();
          if (localObject5 == null)
          {
            localObject2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(240806);
            throw ((Throwable)localObject2);
          }
          localObject5 = (RelativeLayout.LayoutParams)localObject5;
          ((RelativeLayout.LayoutParams)localObject5).setMarginStart(localObject4[0] + ((View)localObject2).getWidth() / 2 - i1 - ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).Bbf.getMeasuredWidth() / 2);
          if (((RelativeLayout.LayoutParams)localObject5).getMarginStart() >= 0) {
            break label539;
          }
          new StringBuilder("invalid loc:").append(((RelativeLayout.LayoutParams)localObject5).getMarginStart());
          ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).dismiss();
        }
        for (;;)
        {
          c.b(c.this);
          AppMethodBeat.o(240806);
          return;
          label539:
          ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).setAnimationStyle(b.i.Gac);
          ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).showAtLocation((View)localObject2, 0, i1, n);
          localObject2 = ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).getContentView();
          if (localObject2 != null) {
            ((View)localObject2).postDelayed((Runnable)new e.c((com.tencent.mm.plugin.mv.ui.view.e)localObject3), ((com.tencent.mm.plugin.mv.ui.view.e)localObject3).Bbk);
          }
          localObject2 = af.aaBG;
          p.j(String.format("popX:%s, popY:%s, sw:%s, sh:%s, pw:%s, ph:%s", Arrays.copyOf(new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) }, 6)), "java.lang.String.format(format, *args)");
        }
      }
      AppMethodBeat.o(240806);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "position", "", "(Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;I)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getItem", "()Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "getPosition", "()I", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "fullScreenTapLayout", "Landroid/view/ViewGroup;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onSingleTapConfirmed", "onSingleTapUp", "plugin-mv_release"})
  public final class c
    extends GestureDetector.SimpleOnGestureListener
  {
    private final b GfP;
    private final int position;
    private final com.tencent.mm.view.recyclerview.i xhX;
    
    public c(b paramb, int paramInt)
    {
      AppMethodBeat.i(225778);
      this.xhX = paramb;
      this.GfP = paramInt;
      int i;
      this.position = i;
      AppMethodBeat.o(225778);
    }
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(225782);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(225782);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(225777);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      localObject1 = c.GfN;
      Log.i(c.access$getTAG$cp(), "onDoubleTap");
      localObject1 = f.GbD;
      if (f.a.c(this.GfP.GfI))
      {
        localObject1 = (ViewGroup)this.xhX.amk.findViewById(b.e.FXp);
        Object localObject2 = this.xhX;
        p.j(localObject1, "fullScreenTapLayout");
        WeImageView localWeImageView = new WeImageView(((com.tencent.mm.view.recyclerview.i)localObject2).getContext());
        localWeImageView.setVisibility(4);
        Object localObject3 = ((com.tencent.mm.view.recyclerview.i)localObject2).getContext();
        p.j(localObject3, "holder.context");
        int i = (int)((Context)localObject3).getResources().getDimension(b.c.Edge_6_5_A);
        localObject3 = new FrameLayout.LayoutParams(i, i);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        localWeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localWeImageView.setImageResource(b.g.finder_full_like);
        localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject2).getContext();
        p.j(localObject2, "holder.context");
        localWeImageView.setIconColor(((Context)localObject2).getResources().getColor(b.b.Red_90));
        ((ViewGroup)localObject1).addView((View)localWeImageView);
        localObject2 = com.tencent.mm.plugin.finder.view.animation.c.BdF;
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localWeImageView, 1.4F, paramMotionEvent, true, ((ViewGroup)localObject1).getY());
        if (!this.GfP.GfI.Gbs)
        {
          c.a(c.this, this.xhX, this.GfP, 2);
          c.e(this.xhX, this.GfP);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(225777);
      return false;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(225781);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(225781);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(225765);
      paramMotionEvent = c.GfN;
      Log.i(c.access$getTAG$cp(), "onSingleTapConfirmed");
      paramMotionEvent = com.tencent.mm.ui.component.g.Xox;
      if (((com.tencent.mm.plugin.mv.ui.uic.g)com.tencent.mm.ui.component.g.b(c.this.xGq).i(com.tencent.mm.plugin.mv.ui.uic.g.class)).AJP)
      {
        paramMotionEvent = com.tencent.mm.ui.component.g.Xox;
        ((com.tencent.mm.plugin.mv.ui.uic.g)com.tencent.mm.ui.component.g.b(c.this.xGq).i(com.tencent.mm.plugin.mv.ui.uic.g.class)).AJP = false;
        c.this.a(this.xhX, this.GfP);
        c.this.b(this.xhX, this.GfP);
      }
      for (;;)
      {
        AppMethodBeat.o(225765);
        return false;
        c.a(c.this, this.xhX);
      }
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(225763);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(225763);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(227674);
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      ((w)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(w.class)).fhw();
      AppMethodBeat.o(227674);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initBgCover$2", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
  public static final class f
    implements h
  {
    f(ImageView paramImageView) {}
    
    public final Bitmap a(String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
    {
      return null;
    }
    
    public final void b(String paramString, View paramView) {}
    
    public final void b(final String paramString, View paramView, com.tencent.mm.ay.a.d.b paramb)
    {
      AppMethodBeat.i(225647);
      p.k(paramString, "url");
      if (paramb != null) {}
      for (paramString = paramb.bitmap;; paramString = null)
      {
        if (paramString != null)
        {
          paramString = paramb.bitmap;
          p.j(paramString, "imageData.bitmap");
          if (!paramString.isRecycled())
          {
            paramString = BitmapUtil.fastblur(paramb.bitmap, 10);
            if (paramString != null) {
              com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramString));
            }
          }
        }
        AppMethodBeat.o(225647);
        return;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(c.f paramf, Bitmap paramBitmap)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$5$2"})
  static final class k
    implements View.OnClickListener
  {
    k(b paramb, com.tencent.mm.plugin.mv.ui.uic.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228969);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.GfW.GfI.Gbr;
      if (paramView != null)
      {
        paramView = paramView.username;
        if (paramView != null)
        {
          localObject = this.GfX;
          p.j(paramView, "it");
          ((com.tencent.mm.plugin.mv.ui.uic.i)localObject).cf(paramView, true);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228969);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$6$2"})
  static final class l
    implements View.OnClickListener
  {
    l(c paramc, b paramb, com.tencent.mm.plugin.mv.ui.uic.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228793);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.GfW.GfI.Gbr;
      if (paramView != null)
      {
        paramView = paramView.username;
        if (paramView != null)
        {
          localObject = this.GfX;
          p.j(paramView, "username");
          ((com.tencent.mm.plugin.mv.ui.uic.i)localObject).cf(paramView, true);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228793);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(c paramc, com.tencent.mm.view.recyclerview.i parami, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232961);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      c.a(this.GfO, this.tDl, this.GfV, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232961);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(c paramc, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229112);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.ui.component.g.Xox;
      paramView = ((com.tencent.mm.plugin.mv.ui.uic.i)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(com.tencent.mm.plugin.mv.ui.uic.i.class)).Gjj;
      if (paramView.isShowing()) {
        paramView.dismiss();
      }
      paramView = com.tencent.mm.ui.component.g.Xox;
      ((u)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(u.class)).k(this.GfV.GfI);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(229112);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(c paramc, b paramb, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242026);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.ui.component.g.Xox;
      com.tencent.mm.plugin.mv.ui.uic.i.a((com.tencent.mm.plugin.mv.ui.uic.i)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(com.tencent.mm.plugin.mv.ui.uic.i.class), this.GfV.GfI, (CommentDrawerContract.CloseDrawerCallback)new CommentDrawerContract.CloseDrawerCallback()
      {
        public final void i(int paramAnonymousInt, List<? extends s> paramAnonymousList)
        {
          AppMethodBeat.i(227209);
          p.k(paramAnonymousList, "data");
          this.GfY.GfV.GfI.commentCount = paramAnonymousInt;
          c.a(this.GfY.GfO, this.GfY.tDl, this.GfY.GfV);
          AppMethodBeat.o(227209);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242026);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(c paramc, b paramb, com.tencent.mm.plugin.mv.ui.uic.g paramg, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(238893);
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.mv.ui.uic.i)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(com.tencent.mm.plugin.mv.ui.uic.i.class)).a(this.GfV.GfI, this.GfZ.xbT, (CommentDrawerContract.CloseDrawerCallback)new CommentDrawerContract.CloseDrawerCallback()
      {
        public final void i(int paramAnonymousInt, List<? extends s> paramAnonymousList)
        {
          AppMethodBeat.i(243612);
          p.k(paramAnonymousList, "data");
          this.Gga.GfV.GfI.commentCount = paramAnonymousInt;
          c.a(this.Gga.GfO, this.Gga.tDl, this.Gga.GfV);
          AppMethodBeat.o(243612);
        }
      });
      this.GfZ.GiY = false;
      AppMethodBeat.o(238893);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(c paramc, b paramb, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(236336);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.ui.component.g.Xox;
      paramView = ((com.tencent.mm.plugin.mv.ui.uic.i)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(com.tencent.mm.plugin.mv.ui.uic.i.class)).Gjj;
      if (paramView.isShowing()) {
        paramView.dismiss();
      }
      paramView = com.tencent.mm.plugin.mv.ui.a.Gfi;
      if (com.tencent.mm.plugin.mv.ui.a.e(this.GfV.GfI))
      {
        paramView = com.tencent.mm.ui.component.g.Xox;
        ((u)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(u.class)).a(this.tDl, this.GfV.GfI);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236336);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(com.tencent.mm.plugin.mv.ui.uic.i parami, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226279);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = this.Ggb;
      localObject1 = this.GfV.GfI;
      p.k(localObject1, "musicMv");
      Object localObject2 = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.mv.ui.uic.k)com.tencent.mm.ui.component.g.b(paramView.getActivity()).i(com.tencent.mm.plugin.mv.ui.uic.k.class)).GjL.YQS = true;
      localObject2 = com.tencent.mm.ui.component.g.Xox;
      localObject2 = com.tencent.mm.ui.component.g.b(paramView.getActivity()).i(com.tencent.mm.plugin.mv.ui.uic.k.class);
      p.j(localObject2, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
      Object localObject3 = (com.tencent.mm.plugin.mv.ui.uic.k)localObject2;
      localObject2 = paramView.Gji;
      Object localObject4 = (Iterable)((com.tencent.mm.plugin.mv.ui.uic.k)localObject3).mXB;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(((b)((Iterator)localObject4).next()).GfI);
      }
      ((com.tencent.mm.plugin.mv.ui.view.c)localObject2).a((f)localObject1, (List)localObject3);
      paramView = paramView.Gji;
      if (!paramView.GoG.isShowing())
      {
        paramView = paramView.GoG;
        paramView.pMD = paramView.isLandscape();
        paramView.pME = paramView.getRotation();
        if (paramView.pMz != null)
        {
          localObject1 = paramView.oFW;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((View)localObject1).getParent();
          if (localObject1 == null)
          {
            paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(226279);
            throw paramView;
          }
          ((ViewGroup)localObject1).setVisibility(0);
          localObject1 = paramView.oFW;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((View)localObject1).getLayoutParams();
          if (localObject1 == null)
          {
            paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(226279);
            throw paramView;
          }
          localObject1 = (FrameLayout.LayoutParams)localObject1;
          if ((paramView.pMD) && (paramView.lJ != null))
          {
            localObject2 = new Rect();
            localObject3 = paramView.lJ;
            if (localObject3 == null) {
              p.iCn();
            }
            ((View)localObject3).getWindowVisibleDisplayFrame((Rect)localObject2);
            ((FrameLayout.LayoutParams)localObject1).width = ((Rect)localObject2).right;
          }
          localObject2 = paramView.oFW;
          if (localObject2 == null) {
            p.iCn();
          }
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject1 = paramView.pMz;
            if (localObject1 == null) {
              p.iCn();
            }
            localObject1 = ((Dialog)localObject1).getWindow();
            if (localObject1 == null) {
              p.iCn();
            }
            ((Window)localObject1).addFlags(-2147483648);
          }
          if ((paramView.AUA) && (Build.VERSION.SDK_INT >= 23) && (paramView.pMz != null))
          {
            localObject1 = paramView.pMz;
            if (localObject1 == null) {
              p.iCn();
            }
            localObject1 = ((Dialog)localObject1).getWindow();
            if (localObject1 == null) {
              p.iCn();
            }
            p.j(localObject1, "mBottomSheetDialog!!.window!!");
            localObject1 = ((Window)localObject1).getDecorView();
            p.j(localObject1, "mBottomSheetDialog!!.window!!.decorView");
            ((View)localObject1).setSystemUiVisibility(9216);
            localObject1 = paramView.pMz;
            if (localObject1 == null) {
              p.iCn();
            }
            localObject1 = ((Dialog)localObject1).getWindow();
            if (localObject1 == null) {
              p.iCn();
            }
            p.j(localObject1, "mBottomSheetDialog!!.window!!");
            ((Window)localObject1).setStatusBarColor(0);
          }
          if (!paramView.pMG) {
            break label817;
          }
          localObject1 = paramView.pMz;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((Dialog)localObject1).getWindow();
          if (localObject1 == null) {
            p.iCn();
          }
          ((Window)localObject1).setFlags(8, 8);
          localObject1 = paramView.pMz;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((Dialog)localObject1).getWindow();
          if (localObject1 == null) {
            p.iCn();
          }
          ((Window)localObject1).addFlags(131200);
          localObject1 = paramView.pMz;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((Dialog)localObject1).getWindow();
          if (localObject1 == null) {
            p.iCn();
          }
          p.j(localObject1, "mBottomSheetDialog!!.window!!");
          localObject1 = ((Window)localObject1).getDecorView();
          p.j(localObject1, "mBottomSheetDialog!!.window!!.decorView");
          ((View)localObject1).setSystemUiVisibility(6);
          if (paramView.lJ != null) {
            if (paramView.lS != null) {
              break label960;
            }
          }
        }
      }
      label817:
      label960:
      for (int i = 1;; i = 0)
      {
        localObject1 = paramView.lJ;
        if (localObject1 == null) {
          p.iCn();
        }
        paramView.lS = ((View)localObject1).getViewTreeObserver();
        if (i != 0)
        {
          localObject1 = paramView.lS;
          if (localObject1 == null) {
            p.iCn();
          }
          ((ViewTreeObserver)localObject1).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)paramView);
        }
        if (((paramView.mContext instanceof Activity)) && (!((Activity)paramView.mContext).isFinishing()))
        {
          localObject1 = paramView.pMz;
          if (localObject1 == null) {
            p.iCn();
          }
          ((Dialog)localObject1).show();
        }
        if (paramView.pMC != null)
        {
          paramView = paramView.pMC;
          if (paramView == null) {
            p.iCn();
          }
          paramView.bd(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(226279);
        return;
        localObject1 = paramView.pMz;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((Dialog)localObject1).getWindow();
        if (localObject1 == null) {
          p.iCn();
        }
        ((Window)localObject1).clearFlags(8);
        localObject1 = paramView.pMz;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((Dialog)localObject1).getWindow();
        if (localObject1 == null) {
          p.iCn();
        }
        ((Window)localObject1).clearFlags(131072);
        localObject1 = paramView.pMz;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((Dialog)localObject1).getWindow();
        if (localObject1 == null) {
          p.iCn();
        }
        ((Window)localObject1).clearFlags(128);
        localObject1 = paramView.pMz;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((Dialog)localObject1).getWindow();
        if (localObject1 == null) {
          p.iCn();
        }
        p.j(localObject1, "mBottomSheetDialog!!.window!!");
        localObject1 = ((Window)localObject1).getDecorView();
        p.j(localObject1, "mBottomSheetDialog!!.window!!.decorView");
        ((View)localObject1).setSystemUiVisibility(0);
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(c paramc, com.tencent.mm.view.recyclerview.i parami, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230479);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.ui.component.g.Xox;
      paramView = ((com.tencent.mm.plugin.mv.ui.uic.i)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(com.tencent.mm.plugin.mv.ui.uic.i.class)).Gjj;
      if (paramView.isShowing()) {
        paramView.dismiss();
      }
      paramView = com.tencent.mm.ui.component.g.Xox;
      ((u)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(u.class)).a(this.tDl, this.GfV.GfI);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230479);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$1", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "onSeekBarChange", "", "seekPosition", "", "max", "onSeekEnd", "onSeekStart", "plugin-mv_release"})
  public static final class t
    implements MusicMainSeekBar.b
  {
    t(RecyclerView.v paramv) {}
    
    public final void ffH()
    {
      AppMethodBeat.i(242797);
      Object localObject = com.tencent.mm.ui.component.g.Xox;
      ((w)com.tencent.mm.ui.component.g.b(this.GfO.xGq).i(w.class)).fhx();
      localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject = (dbs)a.a.a((Context)this.GfO.xGq, 7, dbs.class);
      if (localObject != null) {
        ((dbs)localObject).TJd = 1;
      }
      parami.amk.removeCallbacks(c.c(this.GfO));
      AppMethodBeat.o(242797);
    }
    
    public final void iA(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242799);
      c.a locala = c.GfN;
      Log.i(c.access$getTAG$cp(), "onSeekBarChange " + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(242799);
    }
    
    public final void iz(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242798);
      Object localObject = c.GfN;
      Log.i(c.access$getTAG$cp(), "onSeekEnd, seekPosition:" + paramInt1 + ", max:" + paramInt2);
      com.tencent.mm.bb.a.wG(paramInt1);
      float f1 = paramInt1 / paramInt2;
      localObject = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localObject, "MusicPlayerManager.Instance()");
      localObject = ((com.tencent.mm.plugin.music.e.k)localObject).feg();
      p.j(localObject, "MusicPlayerManager.Instance().musicPlayer");
      float f2 = ((com.tencent.mm.plugin.music.f.a.d)localObject).getDuration();
      localObject = (MultiMediaEffectVideoLayout)parami.amk.findViewById(b.e.music_video_layout);
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).seekTo(kotlin.h.a.N(f2 * f1));
      }
      com.tencent.mm.bb.a.bnu();
      parami.amk.postDelayed(c.c(this.GfO), 3000L);
      AppMethodBeat.o(242798);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228585);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramView = (dbs)a.a.a((Context)this.GfO.xGq, 7, dbs.class);
      if (paramView != null) {
        paramView.TJo = 3;
      }
      com.tencent.mm.bb.a.bnv();
      this.GfO.xGq.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c
 * JD-Core Version:    0.7.0.1
 */