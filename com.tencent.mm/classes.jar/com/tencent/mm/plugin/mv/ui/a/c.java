package com.tencent.mm.plugin.mv.ui.a;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar;
import com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar.b;
import com.tencent.mm.plugin.mv.a.e.a;
import com.tencent.mm.plugin.mv.ui.adapter.MusicLyricLayoutManager;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvChattingUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDataUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC.b;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC.c;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC.d;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC.e;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC.f;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvInfoUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC.b;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC.c;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC.d;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC.e;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC.f;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC.g;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC.h;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.h;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "getActivity", "()Landroid/support/v7/app/AppCompatActivity;", "fullScreenAnimate", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "lyricRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "initBgCover", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "initChattingInfo", "initDeleteStatus", "initFullScreen", "position", "initLocalPostStats", "initMvInfo", "initSongHolderView", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "initSongInfo", "likeMvClick", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "onViewRecycled", "updateCommentCount", "updateFullScreen", "updateLikeStatus", "Companion", "ItemGestureListener", "plugin-mv_release"})
public final class c
  extends com.tencent.mm.view.recyclerview.e<b>
{
  private static final String TAG = "MicroMsg.Mv.MvItemConvert";
  public static final c.s UqW;
  private RecyclerView ArZ;
  private final com.tencent.mm.plugin.mv.ui.uic.c Asa;
  final AppCompatActivity tUQ;
  
  static
  {
    AppMethodBeat.i(258893);
    UqW = new c.s((byte)0);
    TAG = "MicroMsg.Mv.MvItemConvert";
    AppMethodBeat.o(258893);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(257036);
    this.tUQ = paramAppCompatActivity;
    this.Asa = new com.tencent.mm.plugin.mv.ui.uic.c();
    AppMethodBeat.o(257036);
  }
  
  public static void b(h paramh, b paramb)
  {
    AppMethodBeat.i(257033);
    p.h(paramh, "holder");
    p.h(paramb, "item");
    if (!paramb.ArY.onr)
    {
      switch (paramb.ArY.ApM)
      {
      default: 
        AppMethodBeat.o(257033);
        return;
      case 1: 
        paramb = paramh.aus.findViewById(2131303706);
        if (paramb != null) {
          paramb.setVisibility(8);
        }
        paramh = paramh.aus.findViewById(2131303702);
        if (paramh != null)
        {
          paramh.setVisibility(8);
          AppMethodBeat.o(257033);
          return;
        }
        AppMethodBeat.o(257033);
        return;
      case 2: 
        paramb = paramh.aus.findViewById(2131303706);
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        paramh = paramh.aus.findViewById(2131303702);
        if (paramh != null)
        {
          paramh.setVisibility(8);
          AppMethodBeat.o(257033);
          return;
        }
        AppMethodBeat.o(257033);
        return;
      case 3: 
        paramb = paramh.aus.findViewById(2131303706);
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        paramh = paramh.aus.findViewById(2131303702);
        if (paramh != null)
        {
          paramh.setVisibility(0);
          AppMethodBeat.o(257033);
          return;
        }
        AppMethodBeat.o(257033);
        return;
      }
      paramb = paramh.aus.findViewById(2131303706);
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      paramh = paramh.aus.findViewById(2131303702);
      if (paramh != null)
      {
        paramh.setVisibility(8);
        AppMethodBeat.o(257033);
        return;
      }
      AppMethodBeat.o(257033);
      return;
    }
    paramb = paramh.aus.findViewById(2131303706);
    if (paramb != null) {
      paramb.setVisibility(8);
    }
    paramh = paramh.aus.findViewById(2131303702);
    if (paramh != null)
    {
      paramh.setVisibility(8);
      AppMethodBeat.o(257033);
      return;
    }
    AppMethodBeat.o(257033);
  }
  
  private final void c(h paramh, b paramb)
  {
    AppMethodBeat.i(257034);
    paramh = (TextView)paramh.aus.findViewById(2131298937);
    if (paramb.ArY.commentCount > 0)
    {
      p.g(paramh, "commentCntTv");
      y localy = y.vXH;
      paramh.setText((CharSequence)y.LT(paramb.ArY.commentCount));
      AppMethodBeat.o(257034);
      return;
    }
    p.g(paramh, "commentCntTv");
    paramh.setText((CharSequence)this.tUQ.getResources().getString(2131759594));
    AppMethodBeat.o(257034);
  }
  
  @SuppressLint({"ResourceType"})
  private static void d(h paramh, b paramb)
  {
    AppMethodBeat.i(257035);
    Object localObject = (WeImageView)paramh.aus.findViewById(2131302492);
    View localView;
    if (paramb.ArY.ApK)
    {
      ((WeImageView)localObject).setImageResource(2131690577);
      localView = paramh.aus;
      p.g(localView, "holder.itemView");
      ((WeImageView)localObject).setIconColor(localView.getResources().getColor(2131099818));
      localObject = (TextView)paramh.aus.findViewById(2131303177);
      if (paramb.ArY.likeCount <= 0) {
        break label203;
      }
      p.g(localObject, "likeTv");
      paramh = y.vXH;
      ((TextView)localObject).setText((CharSequence)y.LT(paramb.ArY.likeCount));
    }
    for (;;)
    {
      Log.i(TAG, "updateLikeStatus isLike:" + paramb.ArY.ApK + " likeCount:" + paramb.ArY.likeCount);
      AppMethodBeat.o(257035);
      return;
      ((WeImageView)localObject).setImageResource(2131690577);
      localView = paramh.aus;
      p.g(localView, "holder.itemView");
      ((WeImageView)localObject).setIconColor(localView.getResources().getColor(2131099844));
      break;
      label203:
      p.g(localObject, "likeTv");
      paramh = paramh.aus;
      p.g(paramh, "holder.itemView");
      ((TextView)localObject).setText((CharSequence)paramh.getResources().getString(2131763359));
    }
  }
  
  public final void a(final RecyclerView paramRecyclerView, final h paramh, int paramInt)
  {
    AppMethodBeat.i(257029);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramh = (RecyclerView.v)paramh;
    Object localObject = (MusicMainSeekBar)paramh.aus.findViewById(2131304330);
    paramRecyclerView = (WeImageView)paramh.aus.findViewById(2131304559);
    ((MusicMainSeekBar)localObject).setOnSeekBarChange((MusicMainSeekBar.b)new n(this, paramh, paramRecyclerView));
    localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = com.tencent.mm.ui.component.a.b(this.tUQ).get(MusicMvDataUIC.class);
    p.g(localObject, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject = (MusicMvDataUIC)localObject;
    if (paramRecyclerView != null) {
      paramRecyclerView.setOnClickListener((View.OnClickListener)new o(this, paramRecyclerView, paramh, (MusicMvDataUIC)localObject));
    }
    this.ArZ = ((RecyclerView)paramh.aus.findViewById(2131304296));
    paramRecyclerView = this.ArZ;
    if (paramRecyclerView != null)
    {
      localObject = paramh.aus;
      p.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getContext();
      p.g(localObject, "holder.itemView.context");
      paramRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new MusicLyricLayoutManager((Context)localObject, (byte)0));
    }
    paramRecyclerView = this.ArZ;
    if (paramRecyclerView != null) {}
    for (paramRecyclerView = paramRecyclerView.getLayoutParams();; paramRecyclerView = null)
    {
      paramRecyclerView = (ViewGroup.MarginLayoutParams)paramRecyclerView;
      if (paramRecyclerView == null) {
        break;
      }
      localObject = this.tUQ.getResources();
      p.g(localObject, "activity.resources");
      float f = ((Resources)localObject).getDisplayMetrics().heightPixels;
      paramh = paramh.aus;
      p.g(paramh, "holder.itemView");
      paramRecyclerView.topMargin = ((int)(f * 0.37F - com.tencent.mm.cb.a.fromDPToPix(paramh.getContext(), 15)));
      AppMethodBeat.o(257029);
      return;
    }
    AppMethodBeat.o(257029);
  }
  
  public final void a(h paramh, b paramb)
  {
    AppMethodBeat.i(257032);
    p.h(paramh, "holder");
    p.h(paramb, "item");
    Set localSet = ak.setOf(new Integer[] { Integer.valueOf(2131304559), Integer.valueOf(2131304330), Integer.valueOf(2131296374), Integer.valueOf(2131308283), Integer.valueOf(2131301663), Integer.valueOf(2131301686) });
    if (paramb.ArY.onr)
    {
      this.Asa.eD(paramh.aus).s(localSet).t(ak.setOf(Integer.valueOf(2131297163)));
      this.Asa.Awq.clear();
      paramb = paramh.aus.findViewById(2131308288);
      if (paramb != null)
      {
        paramb.animate().cancel();
        paramb.animate().translationX(-com.tencent.mm.cb.a.fromDPToPix(paramh.getContext(), 24)).start();
        AppMethodBeat.o(257032);
        return;
      }
      AppMethodBeat.o(257032);
      return;
    }
    this.Asa.eD(paramh.aus).u(localSet).u(ak.setOf(Integer.valueOf(2131297163)));
    this.Asa.Awq.clear();
    paramh = paramh.aus.findViewById(2131308288);
    if (paramh != null)
    {
      paramh.animate().cancel();
      paramh.animate().translationX(0.0F).start();
      AppMethodBeat.o(257032);
      return;
    }
    AppMethodBeat.o(257032);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(257030);
    p.h(paramh, "holder");
    super.b(paramh);
    AppMethodBeat.o(257030);
  }
  
  public final int getLayoutId()
  {
    return 2131495789;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "position", "", "(Lcom/tencent/mm/plugin/mv/ui/convert/MvItemConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;I)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getItem", "()Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "getPosition", "()I", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "fullScreenTapLayout", "Landroid/view/ViewGroup;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onSingleTapConfirmed", "onSingleTapUp", "plugin-mv_release"})
  public final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private final b Asb;
    private final int position;
    private final h tAm;
    
    public a(b paramb, int paramInt)
    {
      AppMethodBeat.i(257006);
      this.tAm = paramb;
      this.Asb = paramInt;
      int i;
      this.position = i;
      AppMethodBeat.o(257006);
    }
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257008);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(257008);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257005);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = c.UqW;
      Log.i(c.access$getTAG$cp(), "onDoubleTap");
      localObject1 = com.tencent.mm.plugin.mv.a.e.ApR;
      if (e.a.b(this.Asb.ArY))
      {
        localObject1 = (ViewGroup)this.tAm.aus.findViewById(2131301847);
        Object localObject2 = this.tAm;
        p.g(localObject1, "fullScreenTapLayout");
        WeImageView localWeImageView = new WeImageView(((h)localObject2).getContext());
        localWeImageView.setVisibility(4);
        Object localObject3 = ((h)localObject2).getContext();
        p.g(localObject3, "holder.context");
        int i = (int)((Context)localObject3).getResources().getDimension(2131165309);
        localObject3 = new FrameLayout.LayoutParams(i, i);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        localWeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localWeImageView.setImageResource(2131690243);
        localObject2 = ((h)localObject2).getContext();
        p.g(localObject2, "holder.context");
        localWeImageView.setIconColor(((Context)localObject2).getResources().getColor(2131099824));
        ((ViewGroup)localObject1).addView((View)localWeImageView);
        localObject2 = com.tencent.mm.plugin.finder.view.animation.c.wrB;
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localWeImageView, 1.4F, paramMotionEvent, true, ((ViewGroup)localObject1).getY());
        if (!this.Asb.ArY.ApK)
        {
          c.a(c.this, this.tAm, this.Asb);
          c.e(this.tAm, this.Asb);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(257005);
      return false;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257007);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(257007);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257004);
      paramMotionEvent = c.UqW;
      Log.i(c.access$getTAG$cp(), "onSingleTapConfirmed");
      paramMotionEvent = com.tencent.mm.plugin.mv.a.e.ApR;
      if (e.a.b(this.Asb.ArY))
      {
        paramMotionEvent = this.Asb.ArY;
        if (this.Asb.ArY.onr) {
          break label95;
        }
      }
      label95:
      for (boolean bool = true;; bool = false)
      {
        paramMotionEvent.onr = bool;
        c.b(this.tAm, this.Asb);
        c.this.a(this.tAm, this.Asb);
        AppMethodBeat.o(257004);
        return false;
      }
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257003);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$ItemGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(257003);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "onImageDownload", "(Z[Ljava/lang/Object;)V"})
  static final class b
    implements com.tencent.mm.av.a.c.d
  {
    public static final b Asd;
    
    static
    {
      AppMethodBeat.i(257009);
      Asd = new b();
      AppMethodBeat.o(257009);
    }
    
    public final void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initChattingInfo$1", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "onReferLinkClicked", "", "feedId", "", "nonceId", "", "plugin-mv_release"})
  public static final class c
    implements com.tencent.mm.plugin.mv.ui.uic.a.a
  {
    c(MusicMvChattingUIC paramMusicMvChattingUIC) {}
    
    public final void B(long paramLong, String paramString)
    {
      AppMethodBeat.i(257010);
      p.h(paramString, "nonceId");
      com.tencent.mm.plugin.mv.ui.uic.a.a locala = this.Ase.AsZ;
      if (locala != null)
      {
        locala.B(paramLong, paramString);
        AppMethodBeat.o(257010);
        return;
      }
      AppMethodBeat.o(257010);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(c paramc, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257011);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initDeleteStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvInfoUIC)com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvInfoUIC.class)).f(this.Asf.ArY);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initDeleteStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257011);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class e
    implements View.OnTouchListener
  {
    e(GestureDetector paramGestureDetector) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257012);
      paramView = this.AoY;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.axQ(), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initFullScreen$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initFullScreen$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(257012);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$5$2"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb, MusicMvInfoUIC paramMusicMvInfoUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257013);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.Asg.ArY.ApJ;
      if (paramView != null)
      {
        paramView = paramView.username;
        if (paramView != null)
        {
          localObject = this.Ash;
          p.g(paramView, "it");
          ((MusicMvInfoUIC)localObject).aIr(paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257013);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$6$2"})
  static final class g
    implements View.OnClickListener
  {
    g(c paramc, b paramb, MusicMvInfoUIC paramMusicMvInfoUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257014);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.Asg.ArY.ApJ;
      if (paramView != null)
      {
        paramView = paramView.username;
        if (paramView != null)
        {
          localObject = this.Ash;
          p.g(paramView, "it");
          ((MusicMvInfoUIC)localObject).aIr(paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257014);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(c paramc, h paramh, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257015);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      c.a(this.Asc, this.qhp, this.Asf);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257015);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(c paramc, b paramb, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257017);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.ui.component.a.PRN;
      MusicMvInfoUIC.a((MusicMvInfoUIC)com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvInfoUIC.class), this.Asf.ArY, (CommentDrawerContract.CloseDrawerCallback)new CommentDrawerContract.CloseDrawerCallback()
      {
        public final void g(int paramAnonymousInt, List<? extends s> paramAnonymousList)
        {
          AppMethodBeat.i(257016);
          p.h(paramAnonymousList, "data");
          this.Asi.Asf.ArY.commentCount = paramAnonymousInt;
          c.b(this.Asi.Asc, this.Asi.qhp, this.Asi.Asf);
          AppMethodBeat.o(257016);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257017);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(c paramc, b paramb, MusicMvDataUIC paramMusicMvDataUIC, h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(258892);
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvInfoUIC)com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvInfoUIC.class)).a(this.Asf.ArY, this.UqX.tuj, (CommentDrawerContract.CloseDrawerCallback)new c.j.1(this));
      this.UqX.Ats = false;
      AppMethodBeat.o(258892);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(c paramc, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257019);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = com.tencent.mm.plugin.mv.ui.a.ArA;
      Object localObject2;
      int i;
      if (com.tencent.mm.plugin.mv.ui.a.c(this.Asf.ArY))
      {
        paramView = com.tencent.mm.ui.component.a.PRN;
        paramView = (MusicMvShareUIC)com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvShareUIC.class);
        localObject1 = this.Asf.ArY;
        p.h(localObject1, "musicMv");
        localObject2 = ((com.tencent.mm.plugin.mv.a.e)localObject1).ApJ;
        if (localObject2 == null) {
          break label164;
        }
        i = ((FinderContact)localObject2).extFlag;
        if ((i & 0x400) == 0) {
          break label169;
        }
        localObject1 = y.vXH;
        localObject1 = (Context)paramView.getActivity();
        paramView = paramView.getActivity().getString(2131760436);
        p.g(paramView, "activity.getString(com.t…finder_private_ban_share)");
        y.aF((Context)localObject1, paramView);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257019);
        return;
        label164:
        i = 0;
        break;
        label169:
        localObject2 = new com.tencent.mm.ui.widget.a.e((Context)paramView.getActivity(), 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject2).a((o.f)new MusicMvShareUIC.b(paramView));
        ((com.tencent.mm.ui.widget.a.e)localObject2).a((o.g)new MusicMvShareUIC.c(paramView, (com.tencent.mm.plugin.mv.a.e)localObject1));
        ((com.tencent.mm.ui.widget.a.e)localObject2).dGm();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(MusicMvInfoUIC paramMusicMvInfoUIC, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257020);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.Asj.f(this.Asf.ArY);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257020);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(c paramc, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257021);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvShareUIC)com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvShareUIC.class)).i(this.Asf.ArY);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initMvInfo$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257021);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$1", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "onSeekBarChange", "", "seekPosition", "", "max", "onSeekEnd", "onSeekStart", "plugin-mv_release"})
  public static final class n
    implements MusicMainSeekBar.b
  {
    n(RecyclerView.v paramv, WeImageView paramWeImageView) {}
    
    public final void evo()
    {
      AppMethodBeat.i(257022);
      Object localObject = paramh.aus.findViewById(2131302307);
      p.g(localObject, "holder.itemView.findView…>(R.id.header_song_panel)");
      ((View)localObject).setVisibility(4);
      localObject = paramRecyclerView;
      p.g(localObject, "mediaIconIv");
      ((WeImageView)localObject).setVisibility(4);
      localObject = SecDataUIC.CWq;
      localObject = (cst)SecDataUIC.a.a((Context)this.Asc.tUQ, 7, cst.class);
      if (localObject != null)
      {
        ((cst)localObject).Uud = 1;
        AppMethodBeat.o(257022);
        return;
      }
      AppMethodBeat.o(257022);
    }
    
    public final void hv(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257023);
      Object localObject = c.UqW;
      Log.i(c.access$getTAG$cp(), "onSeekEnd, seekPosition:" + paramInt1 + ", max:" + paramInt2);
      localObject = paramh.aus.findViewById(2131302307);
      p.g(localObject, "holder.itemView.findView…>(R.id.header_song_panel)");
      ((View)localObject).setVisibility(0);
      com.tencent.mm.ay.a.tG(paramInt1);
      float f1 = paramInt1 / paramInt2;
      localObject = com.tencent.mm.plugin.music.e.k.euj();
      p.g(localObject, "MusicPlayerManager.Instance()");
      localObject = ((com.tencent.mm.plugin.music.e.k)localObject).etW();
      p.g(localObject, "MusicPlayerManager.Instance().musicPlayer");
      float f2 = ((com.tencent.mm.plugin.music.f.a.d)localObject).getDuration();
      localObject = (MMMvVideoLayout)paramh.aus.findViewById(2131305117);
      if (localObject != null) {
        ((MMMvVideoLayout)localObject).KG(kotlin.h.a.L(f2 * f1));
      }
      com.tencent.mm.ay.a.bdZ();
      paramRecyclerView.setImageResource(2131690631);
      localObject = paramRecyclerView;
      View localView = paramh.aus;
      p.g(localView, "holder.itemView");
      ((WeImageView)localObject).setIconColor(localView.getResources().getColor(2131099681));
      localObject = paramRecyclerView;
      p.g(localObject, "mediaIconIv");
      ((WeImageView)localObject).setVisibility(0);
      AppMethodBeat.o(257023);
    }
    
    public final void hw(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257024);
      c.s locals = c.UqW;
      Log.i(c.access$getTAG$cp(), "onSeekBarChange " + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(257024);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-mv_release"})
  public static final class o
    implements View.OnClickListener
  {
    o(WeImageView paramWeImageView, RecyclerView.v paramv, MusicMvDataUIC paramMusicMvDataUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257025);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.music.e.k.euj();
      p.g(paramView, "MusicPlayerManager.Instance()");
      paramView = paramView.etW();
      p.g(paramView, "MusicPlayerManager.Instance().musicPlayer");
      if (paramView.bec())
      {
        paramView = c.UqW;
        Log.i(c.access$getTAG$cp(), "onSingleTap, stop music");
        com.tencent.mm.ay.a.bdY();
        paramRecyclerView.setImageResource(2131690647);
        paramView = paramRecyclerView;
        localObject = paramh.aus;
        p.g(localObject, "holder.itemView");
        paramView.setIconColor(((View)localObject).getResources().getColor(2131099681));
        paramView = com.tencent.mm.plugin.mv.a.k.Aql;
        com.tencent.mm.plugin.mv.a.k.a((Context)this.Asc.tUQ, this.UqX.Aqo, 2);
        paramView = SecDataUIC.CWq;
        paramView = (cst)SecDataUIC.a.a((Context)this.Asc.tUQ, 7, cst.class);
        if (paramView != null) {
          paramView.Uug = Util.currentTicks();
        }
        paramView = (MMMvVideoLayout)paramh.aus.findViewById(2131305117);
        if (paramView != null) {
          paramView.pause();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongHolderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257025);
        return;
      }
      paramView = com.tencent.mm.plugin.music.e.k.euj();
      p.g(paramView, "MusicPlayerManager.Instance()");
      paramView = paramView.etW();
      p.g(paramView, "MusicPlayerManager.Instance().musicPlayer");
      if (paramView.bee())
      {
        paramView = com.tencent.mm.plugin.music.e.k.euj();
        p.g(paramView, "MusicPlayerManager.Instance()");
        paramView.etW().resume();
      }
      for (;;)
      {
        paramRecyclerView.setImageResource(2131690631);
        paramView = paramRecyclerView;
        localObject = paramh.aus;
        p.g(localObject, "holder.itemView");
        paramView.setIconColor(((View)localObject).getResources().getColor(2131099681));
        paramView = (MMMvVideoLayout)paramh.aus.findViewById(2131305117);
        if (paramView != null) {
          paramView.resume();
        }
        paramView = com.tencent.mm.plugin.mv.a.k.Aql;
        com.tencent.mm.plugin.mv.a.k.a((Context)this.Asc.tUQ, this.UqX.Aqo, 1);
        paramView = SecDataUIC.CWq;
        paramView = (cst)SecDataUIC.a.a((Context)this.Asc.tUQ, 7, cst.class);
        if ((paramView == null) || (paramView.Uug <= 0L)) {
          break;
        }
        long l = Util.ticksToNow(paramView.Uug);
        localObject = c.UqW;
        Log.i(c.access$getTAG$cp(), "accumulate pauseTime:".concat(String.valueOf(l)));
        paramView.Uuf = (l + paramView.Uuf);
        paramView.Uug = -1L;
        break;
        paramView = com.tencent.mm.ay.a.bef();
        com.tencent.mm.plugin.music.e.k.euj().t(paramView);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257026);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.Asc.tUQ.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257026);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(c paramc, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257027);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.ui.component.a.PRN;
      localObject = (MusicMvShareUIC)com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvShareUIC.class);
      com.tencent.mm.plugin.mv.a.e locale = this.Asf.ArY;
      p.h(locale, "musicMv");
      paramView = com.tencent.mm.ui.component.a.PRN;
      paramView = com.tencent.mm.ui.component.a.ko((Context)((MusicMvShareUIC)localObject).getContext()).get(MusicMvDataUIC.class);
      p.g(paramView, "UICProvider.of(context).…sicMvDataUIC::class.java)");
      MusicMvDataUIC localMusicMvDataUIC = (MusicMvDataUIC)paramView;
      paramView = locale.ApJ;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (paramView != null)
      {
        paramView = paramView.username;
        bool1 = p.j(paramView, z.aUg());
        paramView = com.tencent.mm.plugin.mv.ui.a.ArA;
        bool2 = com.tencent.mm.plugin.mv.ui.a.c(locale);
        bool3 = localMusicMvDataUIC.d(locale);
        if (!bool2) {
          break label288;
        }
        paramView = new com.tencent.mm.ui.widget.a.e((Context)((MusicMvShareUIC)localObject).getActivity(), 0, false);
      }
      for (;;)
      {
        paramView.a((o.f)new MusicMvShareUIC.d((MusicMvShareUIC)localObject, bool2));
        paramView.b((o.f)new MusicMvShareUIC.e((MusicMvShareUIC)localObject, bool3, bool1 ^ true, locale, bool2));
        paramView.a((o.g)new MusicMvShareUIC.f((MusicMvShareUIC)localObject, locale));
        paramView.b((o.g)new MusicMvShareUIC.g((MusicMvShareUIC)localObject, locale));
        paramView.b((e.b)MusicMvShareUIC.h.Awh);
        paramView.dGm();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257027);
        return;
        paramView = null;
        break;
        label288:
        paramView = new com.tencent.mm.ui.widget.a.e((Context)((MusicMvShareUIC)localObject).getActivity(), 0, true);
        paramView.j((CharSequence)((MusicMvShareUIC)localObject).getActivity().getResources().getString(2131763372), 17, com.tencent.mm.cb.a.fromDPToPix((Context)((MusicMvShareUIC)localObject).getActivity(), 12));
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class r
    implements View.OnLongClickListener
  {
    r(c paramc, b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      String str = null;
      AppMethodBeat.i(257028);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = com.tencent.mm.ui.component.a.PRN;
      localObject1 = (MusicMvDebugUIC)com.tencent.mm.ui.component.a.b(this.Asc.tUQ).get(MusicMvDebugUIC.class);
      Object localObject2 = this.Asf.ArY;
      p.h(localObject2, "musicMv");
      paramView = com.tencent.mm.util.c.QYz;
      Object localObject4;
      Object localObject3;
      if (com.tencent.mm.util.c.hdg())
      {
        paramView = com.tencent.mm.ui.component.a.PRN;
        localObject4 = ((MusicMvDataUIC)com.tencent.mm.ui.component.a.b(((MusicMvDebugUIC)localObject1).getActivity()).get(MusicMvDataUIC.class)).Aqo;
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("songId", ((axy)localObject4).AqO);
        ((JSONObject)localObject3).put("songName", ((axy)localObject4).BPc);
        ((JSONObject)localObject3).put("singer", ((axy)localObject4).lDR);
        ((JSONObject)localObject3).put("albumName", ((axy)localObject4).albumName);
        ((JSONObject)localObject3).put("albumUrl", ((axy)localObject4).Djf);
        ((JSONObject)localObject3).put("musicWebUrl", ((axy)localObject4).LIg);
        ((JSONObject)localObject3).put("musicDataUrl", ((axy)localObject4).musicDataUrl);
        ((JSONObject)localObject3).put("genre", ((axy)localObject4).LIi);
        ((JSONObject)localObject3).put("publicTime", ((axy)localObject4).LIj);
        ((JSONObject)localObject3).put("musicAppId", ((axy)localObject4).LIf);
        ((JSONObject)localObject3).put("publicTimeS", ((axy)localObject4).LIk);
        ((JSONObject)localObject3).put("extraInfo", ((axy)localObject4).extraInfo);
        ((JSONObject)localObject3).put("identification", ((axy)localObject4).identification);
        paramView = com.tencent.mm.plugin.music.e.k.euj();
        p.g(paramView, "MusicPlayerManager.Instance()");
        paramView = paramView.etW();
        if (paramView == null) {
          break label652;
        }
      }
      label652:
      for (paramView = Integer.valueOf(paramView.getDuration());; paramView = null)
      {
        ((JSONObject)localObject3).put("duration", paramView);
        ((JSONObject)localObject3).put("musicDuration", ((axy)localObject4).duration);
        paramView = com.tencent.mm.plugin.music.e.k.euj();
        p.g(paramView, "MusicPlayerManager.Instance()");
        localObject4 = paramView.etW();
        paramView = str;
        if (localObject4 != null) {
          paramView = Integer.valueOf(((com.tencent.mm.plugin.music.f.a.d)localObject4).etn());
        }
        ((JSONObject)localObject3).put("currentPosition", paramView);
        paramView = ((JSONObject)localObject3).toString();
        p.g(paramView, "songInfoJson.toString()");
        str = MusicMvDebugUIC.l((com.tencent.mm.plugin.mv.a.e)localObject2);
        localObject3 = MusicMvDebugUIC.m((com.tencent.mm.plugin.mv.a.e)localObject2);
        localObject2 = MusicMvDebugUIC.n((com.tencent.mm.plugin.mv.a.e)localObject2);
        localObject4 = MusicMvDebugUIC.gFm();
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)((MusicMvDebugUIC)localObject1).getActivity(), 0, false);
        locale.a((o.f)new MusicMvDebugUIC.b((MusicMvDebugUIC)localObject1));
        locale.b((o.f)new MusicMvDebugUIC.c((MusicMvDebugUIC)localObject1));
        locale.a((o.g)new MusicMvDebugUIC.d((MusicMvDebugUIC)localObject1, paramView, str, (String)localObject3, (String)localObject2, (String)localObject4));
        locale.b((o.g)new MusicMvDebugUIC.e((MusicMvDebugUIC)localObject1));
        locale.b((e.b)MusicMvDebugUIC.f.Urg);
        locale.dGm();
        Log.e(((MusicMvDebugUIC)localObject1).TAG, "MV START####################################################START");
        Log.e(((MusicMvDebugUIC)localObject1).TAG, "songInfoText: ".concat(String.valueOf(paramView)));
        Log.e(((MusicMvDebugUIC)localObject1).TAG, "mvHeadInfoText: ".concat(String.valueOf(str)));
        Log.e(((MusicMvDebugUIC)localObject1).TAG, "mvTrackInfoText: ".concat(String.valueOf(localObject3)));
        Log.e(((MusicMvDebugUIC)localObject1).TAG, "mvRefObjInfoText: ".concat(String.valueOf(localObject2)));
        Log.e(((MusicMvDebugUIC)localObject1).TAG, "cgiInfo: ".concat(String.valueOf(localObject2)));
        Log.e(((MusicMvDebugUIC)localObject1).TAG, "MV END  ####################################################  END");
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initSongInfo$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(257028);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c
 * JD-Core Version:    0.7.0.1
 */