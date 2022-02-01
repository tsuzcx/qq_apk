package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.d.a.a.a.b.d;
import com.tencent.d.a.a.a.b.b.e;
import com.tencent.d.a.a.a.b.b.e.a;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.d.a.a.a.b.b.k;
import com.tencent.d.a.a.a.b.b.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.report.o;
import com.tencent.mm.plugin.finder.live.report.q.ca;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.u;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed;", "", "()V", "AppMsgFinderLiveFeedHolder", "BaseChattingItemAppMsgFinderLiveFeed", "ChattingItemAppMsgFinderLiveFeedFrom", "ChattingItemAppMsgFinderLiveFeedTo", "Companion", "IChattingItemAppMsgFinderLiveFeed", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ChatingItemAppMsgFinderLiveFeed
{
  private static final String TAG;
  public static final d aeLU;
  
  static
  {
    AppMethodBeat.i(255224);
    aeLU = new d((byte)0);
    TAG = "ChatingItemAppMsgFinderLiveFeed";
    AppMethodBeat.o(255224);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "()V", "activityInfoIcon", "Landroid/widget/ImageView;", "getActivityInfoIcon", "()Landroid/widget/ImageView;", "setActivityInfoIcon", "(Landroid/widget/ImageView;)V", "bottomMask", "Landroid/widget/LinearLayout;", "getBottomMask", "()Landroid/widget/LinearLayout;", "setBottomMask", "(Landroid/widget/LinearLayout;)V", "detailLayout", "Landroid/view/View;", "getDetailLayout", "()Landroid/view/View;", "setDetailLayout", "(Landroid/view/View;)V", "finderAuthIcon", "getFinderAuthIcon", "setFinderAuthIcon", "finderAvatar", "getFinderAvatar", "setFinderAvatar", "finderDesc", "Landroid/widget/TextView;", "getFinderDesc", "()Landroid/widget/TextView;", "setFinderDesc", "(Landroid/widget/TextView;)V", "finderIcon", "getFinderIcon", "setFinderIcon", "finderNickname", "getFinderNickname", "setFinderNickname", "finderOlympicView", "getFinderOlympicView", "setFinderOlympicView", "finderText", "getFinderText", "setFinderText", "finderThumb", "getFinderThumb", "setFinderThumb", "liveEndTag", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getLiveEndTag", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setLiveEndTag", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "liveId", "", "getLiveId", "()J", "setLiveId", "(J)V", "liveTag", "getLiveTag", "setLiveTag", "onViewExposedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isExposed", "", "getOnViewExposedListener", "()Lkotlin/jvm/functions/Function1;", "setOnViewExposedListener", "(Lkotlin/jvm/functions/Function1;)V", "reasonTv", "getReasonTv", "setReasonTv", "tickIV", "getTickIV", "setTickIV", "width", "", "getWidth", "()I", "setWidth", "(I)V", "createAppMsgFinderFeedHolder", "view", "isSend", "getMainContainerView", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class AppMsgFinderLiveFeedHolder
    extends c.a
  {
    private ImageView activityInfoIcon;
    private LinearLayout bottomMask;
    private View detailLayout;
    private ImageView finderAuthIcon;
    private ImageView finderAvatar;
    private TextView finderDesc;
    private ImageView finderIcon;
    private TextView finderNickname;
    private View finderOlympicView;
    private TextView finderText;
    private ImageView finderThumb;
    private FinderLiveOnliveWidget liveEndTag;
    private long liveId;
    private FinderLiveOnliveWidget liveTag;
    private kotlin.g.a.b<? super Boolean, ah> onViewExposedListener;
    private TextView reasonTv;
    private ImageView tickIV;
    private int width;
    
    public final AppMsgFinderLiveFeedHolder createAppMsgFinderFeedHolder(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(255338);
      kotlin.g.b.s.u(paramView, "view");
      super.create(paramView);
      Object localObject1 = (LinearLayout)paramView.findViewById(R.h.chatting_click_area);
      Object localObject2 = paramView.getContext();
      Point localPoint = bf.bf((Context)localObject2);
      int i = Math.min(localPoint.x, localPoint.y);
      float f = ((Context)localObject2).getResources().getDimension(R.f.Edge_1_5_A);
      this.width = ((int)((i - f) / 2.0F));
      localObject2 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(255338);
        throw paramView;
      }
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout.LayoutParams)localObject2).width = this.width;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = ChatingItemAppMsgFinderLiveFeed.aeLU;
      Log.i(ChatingItemAppMsgFinderLiveFeed.access$getTAG$cp(), "real widthPixels:" + i + " ,dp:" + f + " , width:" + this.width);
      this.finderAvatar = ((ImageView)paramView.findViewById(R.h.fyI));
      this.finderNickname = ((TextView)paramView.findViewById(R.h.fyN));
      this.finderAuthIcon = ((ImageView)paramView.findViewById(R.h.fyH));
      this.finderThumb = ((ImageView)paramView.findViewById(R.h.fyR));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.fyK));
      this.finderText = ((TextView)paramView.findViewById(R.h.fyQ));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.chatting_item_finder_icon));
      this.finderOlympicView = paramView.findViewById(R.h.finder_olympic_invite_view);
      this.liveEndTag = ((FinderLiveOnliveWidget)paramView.findViewById(R.h.finder_live_end_tag));
      this.activityInfoIcon = ((ImageView)paramView.findViewById(R.h.iv_live_activity_info_icon));
      this.reasonTv = ((TextView)paramView.findViewById(R.h.tv_reason));
      this.bottomMask = ((LinearLayout)paramView.findViewById(R.h.fyJ));
      localObject1 = paramView.findViewById(R.h.fAr);
      if ((localObject1 instanceof TextView))
      {
        localObject1 = (TextView)localObject1;
        if (localObject1 != null) {
          this.userTV = ((TextView)localObject1);
        }
        this.detailLayout = paramView.findViewById(R.h.fxi);
        this.liveTag = ((FinderLiveOnliveWidget)paramView.findViewById(R.h.finder_live_icon));
        if (((cn)h.az(cn.class)).showFinderEntry()) {
          break label534;
        }
      }
      label534:
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
          this.maskView = paramView.findViewById(R.h.fzn);
        }
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
        if (!paramBoolean) {
          break label614;
        }
        this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        if (!(this.finderThumb instanceof NinePatchCropImageView)) {
          break label550;
        }
        paramView = this.finderThumb;
        if (paramView != null) {
          break label540;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.NinePatchCropImageView");
        AppMethodBeat.o(255338);
        throw paramView;
        localObject1 = null;
        break;
      }
      label540:
      ((NinePatchCropImageView)paramView).setNinePatchId(R.g.chatto_finder_image_bg);
      for (;;)
      {
        label550:
        paramView = this.finderIcon;
        if (paramView != null) {
          paramView.setImageDrawable(bb.m(paramView.getContext(), R.k.icons_outlined_finder_icon, com.tencent.mm.cd.a.w(paramView.getContext(), R.e.Orange)));
        }
        paramView = this.convertView;
        if (paramView != null) {
          f.a(paramView, (e.b)new a(this));
        }
        AppMethodBeat.o(255338);
        return this;
        label614:
        paramView = this.uploadingPB;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        if ((this.finderThumb instanceof NinePatchCropImageView))
        {
          paramView = this.finderThumb;
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.NinePatchCropImageView");
            AppMethodBeat.o(255338);
            throw paramView;
          }
          ((NinePatchCropImageView)paramView).setNinePatchId(R.g.chatfrom_finder_image_bg);
        }
      }
    }
    
    public final ImageView getActivityInfoIcon()
    {
      return this.activityInfoIcon;
    }
    
    public final LinearLayout getBottomMask()
    {
      return this.bottomMask;
    }
    
    public final View getDetailLayout()
    {
      return this.detailLayout;
    }
    
    public final ImageView getFinderAuthIcon()
    {
      return this.finderAuthIcon;
    }
    
    public final ImageView getFinderAvatar()
    {
      return this.finderAvatar;
    }
    
    public final TextView getFinderDesc()
    {
      return this.finderDesc;
    }
    
    public final ImageView getFinderIcon()
    {
      return this.finderIcon;
    }
    
    public final TextView getFinderNickname()
    {
      return this.finderNickname;
    }
    
    public final View getFinderOlympicView()
    {
      return this.finderOlympicView;
    }
    
    public final TextView getFinderText()
    {
      return this.finderText;
    }
    
    public final ImageView getFinderThumb()
    {
      return this.finderThumb;
    }
    
    public final FinderLiveOnliveWidget getLiveEndTag()
    {
      return this.liveEndTag;
    }
    
    public final long getLiveId()
    {
      return this.liveId;
    }
    
    public final FinderLiveOnliveWidget getLiveTag()
    {
      return this.liveTag;
    }
    
    public final View getMainContainerView()
    {
      return this.detailLayout;
    }
    
    public final kotlin.g.a.b<Boolean, ah> getOnViewExposedListener()
    {
      return this.onViewExposedListener;
    }
    
    public final TextView getReasonTv()
    {
      return this.reasonTv;
    }
    
    public final ImageView getTickIV()
    {
      return this.tickIV;
    }
    
    public final int getWidth()
    {
      return this.width;
    }
    
    public final void setActivityInfoIcon(ImageView paramImageView)
    {
      this.activityInfoIcon = paramImageView;
    }
    
    public final void setBottomMask(LinearLayout paramLinearLayout)
    {
      this.bottomMask = paramLinearLayout;
    }
    
    public final void setDetailLayout(View paramView)
    {
      this.detailLayout = paramView;
    }
    
    public final void setFinderAuthIcon(ImageView paramImageView)
    {
      this.finderAuthIcon = paramImageView;
    }
    
    public final void setFinderAvatar(ImageView paramImageView)
    {
      this.finderAvatar = paramImageView;
    }
    
    public final void setFinderDesc(TextView paramTextView)
    {
      this.finderDesc = paramTextView;
    }
    
    public final void setFinderIcon(ImageView paramImageView)
    {
      this.finderIcon = paramImageView;
    }
    
    public final void setFinderNickname(TextView paramTextView)
    {
      this.finderNickname = paramTextView;
    }
    
    public final void setFinderOlympicView(View paramView)
    {
      this.finderOlympicView = paramView;
    }
    
    public final void setFinderText(TextView paramTextView)
    {
      this.finderText = paramTextView;
    }
    
    public final void setFinderThumb(ImageView paramImageView)
    {
      this.finderThumb = paramImageView;
    }
    
    public final void setLiveEndTag(FinderLiveOnliveWidget paramFinderLiveOnliveWidget)
    {
      this.liveEndTag = paramFinderLiveOnliveWidget;
    }
    
    public final void setLiveId(long paramLong)
    {
      this.liveId = paramLong;
    }
    
    public final void setLiveTag(FinderLiveOnliveWidget paramFinderLiveOnliveWidget)
    {
      this.liveTag = paramFinderLiveOnliveWidget;
    }
    
    public final void setOnViewExposedListener(kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      this.onViewExposedListener = paramb;
    }
    
    public final void setReasonTv(TextView paramTextView)
    {
      this.reasonTv = paramTextView;
    }
    
    public final void setTickIV(ImageView paramImageView)
    {
      this.tickIV = paramImageView;
    }
    
    public final void setWidth(int paramInt)
    {
      this.width = paramInt;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder$createAppMsgFinderFeedHolder$3", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends e.b
    {
      a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder) {}
      
      public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
      {
        AppMethodBeat.i(255034);
        kotlin.g.b.s.u(paramView, "view");
        paramView = this.aeLV.getOnViewExposedListener();
        if (paramView != null) {
          paramView.invoke(Boolean.valueOf(paramBoolean));
        }
        AppMethodBeat.o(255034);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$BaseChattingItemAppMsgFinderLiveFeed;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$IChattingItemAppMsgFinderLiveFeed;", "Lcom/tencent/mm/ui/chatting/ChattingListEventListener$StateBtnClickListener;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "refreshActivityIconJob", "Lkotlinx/coroutines/Job;", "fillActivityIcon", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "finderObject", "Lcom/tencent/mm/plugin/findersdk/api/AppMSgContentFinderLiveObject;", "filling", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
    extends c
    implements v.n
  {
    public static final ChatingItemAppMsgFinderLiveFeed.a.a aeLW = new ChatingItemAppMsgFinderLiveFeed.a.a((byte)0);
    private cb RMm;
    private aq coroutineScope = ar.kBZ();
    
    public void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, final String paramString)
    {
      kotlin.g.b.s.u(parama, "holder");
      kotlin.g.b.s.u(parama1, "chattingContext");
      kotlin.g.b.s.u(paramcc, "msg");
      kotlin.g.b.s.u(paramString, "userName");
      Log.i("BaseChattingItemAppMsgFinderLiveFeed", "filling");
      paramString = this.RMm;
      if (paramString != null) {
        paramString.a(null);
      }
      if (!(parama instanceof ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder))
      {
        Log.i("BaseChattingItemAppMsgFinderLiveFeed", "filling not AppMsgFinderLiveFeedHolder return");
        return;
      }
      ((ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama).setOnViewExposedListener((kotlin.g.a.b)new c(this));
      paramString = paramcc.field_content;
      if (paramString != null) {}
      for (paramcc = k.b.aP(paramString, paramcc.field_reserved);; paramcc = null)
      {
        if (paramcc == null)
        {
          paramcc = null;
          paramString = (ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama;
          if ((((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isFinderLiveActivityIconSharedEnable()) && (parama1.ffv))
          {
            if ((paramcc != null) && (paramcc.HbV.liveStatus == 1)) {
              break label217;
            }
            Log.i("BaseChattingItemAppMsgFinderLiveFeed", "filling not living return");
          }
        }
        for (;;)
        {
          ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).fillAuthIcon(((ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama).getFinderNickname(), ((ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama).getFinderAuthIcon(), paramcc, 20.0F);
          return;
          paramcc = (com.tencent.mm.plugin.findersdk.a.b)paramcc.aK(com.tencent.mm.plugin.findersdk.a.b.class);
          break;
          label217:
          final long l = com.tencent.mm.ae.d.FK(paramcc.HbV.feedId);
          Log.i("BaseChattingItemAppMsgFinderLiveFeed", kotlin.g.b.s.X("filling feedId=", com.tencent.mm.ae.d.hF(l)));
          if (l != 0L)
          {
            paramString = paramString.getActivityInfoIcon();
            if (paramString != null) {
              this.RMm = kotlinx.coroutines.j.a(this.coroutineScope, null, null, (kotlin.g.a.m)new b(parama1, l, paramcc, paramString, null), 3);
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      b(com.tencent.mm.ui.chatting.d.a parama, long paramLong, com.tencent.mm.plugin.findersdk.a.b paramb, ImageView paramImageView, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(255426);
        paramObject = (kotlin.d.d)new b(this.aeLX, l, paramString, this.Byq, paramd);
        AppMethodBeat.o(255426);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(255423);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(255423);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          com.tencent.d.a.a.a.b localb = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
          paramObject = this.aeLX.aezO.getContext();
          kotlin.g.b.s.s(paramObject, "chattingContext.context");
          Context localContext = (Context)paramObject;
          long l = l;
          Object localObject = paramString.HbV.objectNonceId;
          paramObject = localObject;
          if (localObject == null) {
            paramObject = "";
          }
          localObject = this.Byq;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (localb.executeCirculationFillingActivityIcon(localContext, l, paramObject, (ImageView)localObject, 2, locald) == locala)
          {
            AppMethodBeat.o(255423);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(255423);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.b<Boolean, ah>
    {
      c(ChatingItemAppMsgFinderLiveFeed.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedFrom;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$BaseChattingItemAppMsgFinderLiveFeed;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "filling", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class b
    extends ChatingItemAppMsgFinderLiveFeed.a
  {
    public static final a aeMb;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    static
    {
      AppMethodBeat.i(255501);
      aeMb = new a((byte)0);
      AppMethodBeat.o(255501);
    }
    
    public static final boolean a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255499);
      boolean bool = a.a(paramView, parama, paramcc, paramString);
      AppMethodBeat.o(255499);
      return bool;
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255516);
      kotlin.g.b.s.u(paramLayoutInflater, "inflater");
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localView = (View)new ap(paramLayoutInflater, R.i.gfG);
        ((ap)localView).setTag(new ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder().createAppMsgFinderFeedHolder(localView, false));
      }
      AppMethodBeat.o(255516);
      return localView;
    }
    
    public void a(Activity paramActivity, cc paramcc)
    {
      AppMethodBeat.i(255552);
      kotlin.g.b.s.u(paramActivity, "context");
      kotlin.g.b.s.u(paramcc, "msg");
      ChatingItemAppMsgFinderLiveFeed.d locald = ChatingItemAppMsgFinderLiveFeed.aeLU;
      ChatingItemAppMsgFinderLiveFeed.d.a(paramActivity, paramcc);
      AppMethodBeat.o(255552);
    }
    
    public void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bmr parambmr, com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(255555);
      kotlin.g.b.s.u(paramAppMsgFinderLiveFeedHolder, "holder");
      kotlin.g.b.s.u(parambmr, "shareObject");
      kotlin.g.b.s.u(parama, "ui");
      ChatingItemAppMsgFinderLiveFeed.d locald = ChatingItemAppMsgFinderLiveFeed.aeLU;
      ChatingItemAppMsgFinderLiveFeed.d.a(paramAppMsgFinderLiveFeedHolder, parambmr, parama);
      AppMethodBeat.o(255555);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255534);
      kotlin.g.b.s.u(parama, "tag");
      kotlin.g.b.s.u(parama1, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      kotlin.g.b.s.u(paramString, "userName");
      super.a(parama, paramInt, parama1, paramcc, paramString);
      this.aeiK = parama1;
      ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder localAppMsgFinderLiveFeedHolder = (ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama;
      localAppMsgFinderLiveFeedHolder.setLiveId(0L);
      paramString = localAppMsgFinderLiveFeedHolder.getDetailLayout();
      kotlin.g.b.s.checkNotNull(paramString);
      paramString.animate().cancel();
      paramString = localAppMsgFinderLiveFeedHolder.getDetailLayout();
      kotlin.g.b.s.checkNotNull(paramString);
      paramString.setTag(Long.valueOf(System.currentTimeMillis()));
      Object localObject = paramcc.field_content;
      paramString = null;
      if (localObject != null) {
        paramString = k.b.aP((String)localObject, paramcc.field_reserved);
      }
      com.tencent.mm.plugin.findersdk.a.b localb;
      int i;
      if (paramString != null)
      {
        localb = (com.tencent.mm.plugin.findersdk.a.b)paramString.aK(com.tencent.mm.plugin.findersdk.a.b.class);
        if (localb != null)
        {
          localObject = localb.HbV.liveId;
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = "0";
          }
          localAppMsgFinderLiveFeedHolder.setLiveId(Util.getLong(paramString, 0L));
          paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString = com.tencent.mm.plugin.finder.loader.p.eCp();
          localObject = new com.tencent.mm.plugin.finder.loader.s(localb.HbV.headUrl, v.FKZ);
          ImageView localImageView = localAppMsgFinderLiveFeedHolder.getFinderAvatar();
          kotlin.g.b.s.checkNotNull(localImageView);
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString.a(localObject, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExP));
          paramString = localAppMsgFinderLiveFeedHolder.getFinderNickname();
          kotlin.g.b.s.checkNotNull(paramString);
          paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)parama1.aezO.getContext(), (CharSequence)localb.HbV.nickName));
          paramString = localAppMsgFinderLiveFeedHolder.getFinderNickname();
          kotlin.g.b.s.checkNotNull(paramString);
          aw.a((Paint)paramString.getPaint(), 0.8F);
          paramString = ChatingItemAppMsgFinderLiveFeed.aeLU;
          if (ChatingItemAppMsgFinderLiveFeed.d.a(parama1, parama, localb.HbV, localb.HbV.liveStatus, localb.HbV.ZVm)) {
            a(localAppMsgFinderLiveFeedHolder, localb.HbV, parama1);
          }
          parama = ChatingItemAppMsgFinderLiveFeed.aeLU;
          ChatingItemAppMsgFinderLiveFeed.d.a(localAppMsgFinderLiveFeedHolder);
          parama = localAppMsgFinderLiveFeedHolder.getFinderThumb();
          kotlin.g.b.s.checkNotNull(parama);
          parama.setVisibility(0);
          parama = (CharSequence)localb.HbV.desc;
          if ((parama != null) && (parama.length() != 0)) {
            break label1097;
          }
          i = 1;
          if (i == 0) {
            break label1103;
          }
          parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
          kotlin.g.b.s.checkNotNull(parama);
          parama.setVisibility(8);
          label436:
          parama = (CharSequence)localb.HbV.ZVq;
          if ((parama != null) && (parama.length() != 0)) {
            break label1146;
          }
          i = 1;
          label464:
          if ((i != 0) || (localb.HbV.liveStatus == 2)) {
            break label1215;
          }
          parama = (CharSequence)localb.HbV.eventId;
          if ((parama != null) && (parama.length() != 0)) {
            break label1152;
          }
          i = 1;
          label509:
          if ((i != 0) || (!kotlin.g.b.s.p(localb.HbV.eventId, "1"))) {
            break label1215;
          }
          parama = localAppMsgFinderLiveFeedHolder.getFinderOlympicView();
          if (parama != null)
          {
            paramString = parama.findViewById(R.h.finder_olympic_invite_bg);
            kotlin.g.b.s.s(paramString, "it.findViewById(R.id.finder_olympic_invite_bg)");
            paramString = (ImageView)paramString;
            localObject = parama.findViewById(R.h.finder_olympic_invite_icon);
            kotlin.g.b.s.s(localObject, "it.findViewById(R.id.finder_olympic_invite_icon)");
            localObject = (ImageView)localObject;
            ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage(paramString, b.j.ahpn, R.g.finder_olympic_live_share_bg);
            ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage((ImageView)localObject, b.j.ahpo, R.g.finder_olympic_live_share_icon);
            paramString = parama.findViewById(R.h.finder_olympic_invite_text);
            kotlin.g.b.s.s(paramString, "it.findViewById(R.id.finder_olympic_invite_text)");
            localObject = (TextView)paramString;
            ((TextView)localObject).setTextSize(1, 14.0F);
            paramString = parama.findViewById(R.h.finder_olympic_invite_name);
            kotlin.g.b.s.s(paramString, "it.findViewById(R.id.finder_olympic_invite_name)");
            paramString = (TextView)paramString;
            paramString.setTextSize(1, 14.0F);
            parama = parama.findViewById(R.h.finder_olympic_invite_you);
            kotlin.g.b.s.s(parama, "it.findViewById(R.id.finder_olympic_invite_you)");
            parama = (TextView)parama;
            parama.setTextSize(1, 17.0F);
            i.setTextBold((TextView)localObject);
            i.setTextBold(paramString);
            i.setTextBold(parama);
            parama = (CharSequence)localb.HbV.ZVr;
            if ((parama != null) && (parama.length() != 0)) {
              break label1158;
            }
            i = 1;
            label769:
            if (i == 0) {
              break label1164;
            }
            paramString.setVisibility(8);
            label781:
            parama = parama1.aezO.getContext().getResources().getString(R.l.finder_olympic_invite_text_3, new Object[] { localb.HbV.ZVq });
            kotlin.g.b.s.s(parama, "ui.context.resources.get…t.shareObject.relayIndex)");
            i = localAppMsgFinderLiveFeedHolder.getWidth();
            int j = com.tencent.mm.cd.a.fromDPToPix((Context)parama1.aezO.getContext(), 12);
            paramString = kotlin.n.n.m(parama, "\n", "", false);
            if (new StaticLayout((CharSequence)paramString, 0, paramString.length(), ((TextView)localObject).getPaint(), i - j * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() > 1) {
              break label1264;
            }
            parama = paramString;
          }
        }
      }
      label1097:
      label1103:
      label1264:
      for (;;)
      {
        ((TextView)localObject).setText((CharSequence)parama);
        parama = localAppMsgFinderLiveFeedHolder.getFinderOlympicView();
        if (parama != null) {
          parama.setVisibility(0);
        }
        parama = localAppMsgFinderLiveFeedHolder.getFinderThumb();
        if (parama != null) {
          parama.setVisibility(8);
        }
        parama = localAppMsgFinderLiveFeedHolder.getBottomMask();
        if (parama != null) {
          parama.setVisibility(8);
        }
        for (;;)
        {
          localAppMsgFinderLiveFeedHolder.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
          localAppMsgFinderLiveFeedHolder.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
          localAppMsgFinderLiveFeedHolder.clickArea.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
          parama = this.aeiK;
          kotlin.g.b.s.checkNotNull(parama);
          parama = new bz(paramcc, parama.juG(), paramInt, null, '\000');
          localAppMsgFinderLiveFeedHolder.clickArea.setTag(parama);
          parama = localAppMsgFinderLiveFeedHolder.getBottomMask();
          if (parama != null) {
            ((cn)h.az(cn.class)).getFinderUtilApi().e((ViewGroup)parama, R.g.fnO, R.g.fnN);
          }
          AppMethodBeat.o(255534);
          return;
          i = 0;
          break;
          parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
          kotlin.g.b.s.checkNotNull(parama);
          parama.setVisibility(0);
          parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
          kotlin.g.b.s.checkNotNull(parama);
          parama.setText((CharSequence)localb.HbV.desc);
          break label436;
          label1146:
          i = 0;
          break label464;
          i = 0;
          break label509;
          i = 0;
          break label769;
          paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)parama1.aezO.getContext(), (CharSequence)localb.HbV.ZVr));
          if (paramString.getVisibility() != 8) {
            break label781;
          }
          paramString.setVisibility(0);
          break label781;
          parama = localAppMsgFinderLiveFeedHolder.getFinderOlympicView();
          if (parama != null) {
            parama.setVisibility(8);
          }
          parama = localAppMsgFinderLiveFeedHolder.getFinderThumb();
          if (parama != null) {
            parama.setVisibility(0);
          }
          parama = localAppMsgFinderLiveFeedHolder.getBottomMask();
          if (parama != null) {
            parama.setVisibility(0);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255545);
      kotlin.g.b.s.u(paramMenuItem, "item");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = parama.aezO.getContext();
        kotlin.g.b.s.s(paramMenuItem, "ui.context");
        a(paramMenuItem, paramcc);
        AppMethodBeat.o(255545);
        return true;
      }
      AppMethodBeat.o(255545);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255539);
      kotlin.g.b.s.u(params, "menu");
      kotlin.g.b.s.u(paramView, "v");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        params = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(255539);
        throw params;
      }
      int i = ((bz)paramView).position;
      if (paramcc != null)
      {
        paramView = this.aeiK;
        kotlin.g.b.s.checkNotNull(paramView);
        params.a(i, 111, (CharSequence)paramView.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        params.removeItem(116);
      }
      AppMethodBeat.o(255539);
      return true;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc) {}
    
    public boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255550);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      boolean bool = a.a(paramView, parama, paramcc, a(parama, paramcc));
      AppMethodBeat.o(255550);
      return bool;
    }
    
    public boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 973078577) || (paramInt == 975175729));
    }
    
    public final boolean fXn()
    {
      return false;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedFrom$Companion;", "", "()V", "TAG", "", "onQuoteLiveMsgClick", "", "v", "Landroid/view/View;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "username", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static boolean a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc, String paramString)
      {
        AppMethodBeat.i(255066);
        kotlin.g.b.s.u(paramView, "v");
        kotlin.g.b.s.u(parama, "ui");
        kotlin.g.b.s.u(paramcc, "msg");
        Object localObject2 = paramcc.field_content;
        Object localObject1 = null;
        if (localObject2 != null) {
          localObject1 = k.b.aP((String)localObject2, paramcc.field_reserved);
        }
        com.tencent.mm.plugin.findersdk.a.b localb;
        long l2;
        long l3;
        boolean bool;
        if (localObject1 != null)
        {
          localb = (com.tencent.mm.plugin.findersdk.a.b)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.b.class);
          if (localb != null)
          {
            l2 = com.tencent.mm.ae.d.FK(localb.HbV.feedId);
            l3 = com.tencent.mm.ae.d.FK(localb.HbV.liveId);
            if (l2 != 0L)
            {
              bool = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(paramView.findViewById(R.h.finder_live_icon), paramView.findViewById(R.h.finder_live_end_tag), l3);
              paramView = com.tencent.d.a.a.a.a.a.ahiX;
              if (!((Boolean)com.tencent.d.a.a.a.a.a.jSP().bmg()).booleanValue()) {
                break label209;
              }
              paramView = new Intent();
              paramView.putExtra("feed_object_id", l2);
              paramView.putExtra("feed_object_nonceId", localb.HbV.objectNonceId);
              ((cn)h.az(cn.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramView);
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(255066);
          return false;
          label209:
          if (bool)
          {
            if (!parama.juF()) {}
            for (paramView = ((cn)h.az(cn.class)).genContextId(2, 2, 65);; paramView = ((cn)h.az(cn.class)).genContextId(3, 2, 65))
            {
              localObject1 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
              localObject2 = (Context)parama.aezO.getContext();
              paramcc = localb.HbV.username;
              parama = paramcc;
              if (paramcc == null) {
                parama = "";
              }
              paramString = localb.HbV.objectNonceId;
              paramcc = paramString;
              if (paramString == null) {
                paramcc = "";
              }
              paramString = localb.HbV.desc;
              kotlin.g.b.s.s(paramView, "contextId");
              ((com.tencent.d.a.a.a.b)localObject1).enterFinderLiveReplayUI(null, (Context)localObject2, l2, l3, parama, paramcc, paramString, paramView, ((cn)h.az(cn.class)).getFinderUtilApi().fgH());
              ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).reportFinderLiveReplay(l2, "share");
              break;
            }
          }
          if (!Util.isEqual(localb.HbV.username, z.bAW())) {
            break;
          }
          paramcc = new Intent();
          paramcc.putExtra("KEY_PARAMS_SOURCE_TYPE", localb.HbV.sourceType);
          paramString = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
          localObject1 = MMApplicationContext.getContext();
          parama = localb.HbV.objectNonceId;
          paramView = parama;
          if (parama == null) {
            paramView = "";
          }
          paramString.enterFinderLiveAnchorUI(paramcc, (Context)localObject1, l2, Long.valueOf(l3), paramView, localb.HbV.desc, "", "", "");
        }
        label516:
        Object localObject3;
        long l1;
        label589:
        int j;
        if (paramString == null)
        {
          paramcc = parama.Uxa.field_username;
          paramView = paramcc;
          if (paramcc == null) {
            paramView = "";
          }
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq = paramView;
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr = com.tencent.mm.plugin.expt.hellhound.core.b.hF(parama.Uxa.maN);
          localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramcc = localb.HbV.username;
          paramView = paramcc;
          if (paramcc == null) {
            paramView = "";
          }
          q.w localw = q.w.DwU;
          String str = q.n.Dty.scene;
          if (localb.HbV.liveStatus != 1) {
            break label1469;
          }
          l1 = q.u.DwE.status;
          paramcc = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          long l4 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.dKk();
          localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq;
          paramcc = (cc)localObject1;
          if (localObject1 == null) {
            paramcc = "";
          }
          localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.plugin.finder.live.report.j)localObject3).b(new o(l2, l3, paramView, 0L, -1L, localw, str, l1, l4, paramcc, (String)localObject1, System.currentTimeMillis(), q.ca.DDZ, null, null, null, null, 122880));
          if (parama.juF()) {
            break label1480;
          }
          paramcc = ((cn)h.az(cn.class)).genContextId(2, 2, 65);
          label703:
          localObject2 = new Intent();
          localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((Intent)localObject2).putExtra("key_enter_live_param_share_username", paramView);
          ((Intent)localObject2).putExtra("key_enter_live_param_from_share_scene", 0);
          ((Intent)localObject2).putExtra("key_enter_live_param_visitor_enter_scene", 1);
          localObject1 = localb.HbV.ecSource;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((Intent)localObject2).putExtra("key_enter_live_param_ecsource", paramView);
          localObject1 = localb.HbV.ecSource;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          Log.i("MicroMsg.ChattingItemAppMsgFinderLiveFeedFrom", "from ecSource:%s", new Object[] { paramView });
          ((Intent)localObject2).putExtra("key_enter_live_param_bind_type", localb.HbV.mIJ);
          localObject1 = localb.HbV.hUQ;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((Intent)localObject2).putExtra("key_enter_live_param_by_biz_username", paramView);
          localObject1 = localb.HbV.mIK;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((Intent)localObject2).putExtra("key_enter_live_param_by_biz_nickname", paramView);
          paramView = (CharSequence)localb.HbV.coverUrl;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label1501;
          }
          i = 1;
          label934:
          if (i != 0) {
            break label1507;
          }
          paramView = localb.HbV.coverUrl;
          label948:
          ((Intent)localObject2).putExtra("key_enter_live_cover_url", paramView);
          ((Intent)localObject2).putExtra("key_enter_live_param_is_from_chat_group", parama.juG());
          int k = 0;
          paramView = (CharSequence)localb.HbV.ZVq;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label1564;
          }
          j = 1;
          label1002:
          i = k;
          if (j == 0)
          {
            paramView = (CharSequence)localb.HbV.eventId;
            if ((paramView != null) && (paramView.length() != 0)) {
              break label1570;
            }
            j = 1;
            label1039:
            i = k;
            if (j == 0)
            {
              i = k;
              if (kotlin.g.b.s.p(localb.HbV.eventId, "1"))
              {
                paramView = new brs();
                paramView.ZVq = localb.HbV.ZVq;
                paramView.ZVp = localb.HbV.ZVp;
                paramView.ZVs = localb.HbV.ZVs;
                paramView.ZVr = localb.HbV.ZVr;
                localObject1 = ah.aiuX;
                ((Intent)localObject2).putExtra("KEY_ENTER_LIVE_PARAM_OLYMPIC_FIRE_AUTHOR_INFO", paramView.toByteArray());
                i = 1;
              }
            }
          }
          paramView = b.k.ahpq;
          ((Intent)localObject2).putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWo());
          paramView = (CharSequence)localb.HbV.eventId;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label1576;
          }
          j = 1;
          label1190:
          if (j == 0)
          {
            localObject1 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
            localObject3 = new dwa();
            paramView = b.e.ahon;
            ((dwa)localObject3).abbK = b.e.a.jWb();
            paramView = paramString;
            if (paramString == null) {
              paramView = "";
            }
            ((dwa)localObject3).hLv = paramView;
            ((dwa)localObject3).abbL = i;
            ((dwa)localObject3).abbM = parama.juG();
            paramView = ah.aiuX;
            ((com.tencent.d.a.a.a.b)localObject1).initOlympicsReport((dwa)localObject3);
          }
          if (parama.juG())
          {
            paramView = parama.getTalkerUserName();
            if ((paramView == null) || (kotlin.n.n.rs(paramView, "@chatroom") != true)) {
              break label1582;
            }
          }
        }
        label1558:
        label1564:
        label1570:
        label1576:
        label1582:
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramString = parama.getTalkerUserName();
            paramView = paramString;
            if (paramString == null) {
              paramView = "";
            }
            ((Intent)localObject2).putExtra("KEY_ENTER_LIVE_PARAM_BOX_GROUP_ID", paramView);
            ((Intent)localObject2).putExtra("KEY_ENTER_LIVE_PARAM_BOX_GROUP_TO_LIVEID", l3);
          }
          localObject1 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
          localObject3 = (Context)parama.aezO.getContext();
          parama = localb.HbV.username;
          paramView = parama;
          if (parama == null) {
            paramView = "";
          }
          paramString = localb.HbV.objectNonceId;
          parama = paramString;
          if (paramString == null) {
            parama = "";
          }
          paramString = localb.HbV.desc;
          kotlin.g.b.s.s(paramcc, "contextId");
          ((com.tencent.d.a.a.a.b)localObject1).enterFinderLiveVisitorUI((Intent)localObject2, (Context)localObject3, l2, Long.valueOf(l3), paramView, parama, paramString, paramcc, "", "", 0, "", 1, ((cn)h.az(cn.class)).getFinderUtilApi().fgH());
          break;
          paramView = paramString;
          break label516;
          label1469:
          l1 = q.u.DwF.status;
          break label589;
          label1480:
          paramcc = ((cn)h.az(cn.class)).genContextId(3, 2, 65);
          break label703;
          label1501:
          i = 0;
          break label934;
          label1507:
          paramView = (CharSequence)localb.HbV.headUrl;
          if ((paramView == null) || (paramView.length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label1558;
            }
            paramView = localb.HbV.headUrl;
            break;
          }
          paramView = "";
          break label948;
          j = 0;
          break label1002;
          j = 0;
          break label1039;
          j = 0;
          break label1190;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedTo;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$BaseChattingItemAppMsgFinderLiveFeed;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "filling", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class c
    extends ChatingItemAppMsgFinderLiveFeed.a
  {
    public static final a aeMc;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    static
    {
      AppMethodBeat.i(255498);
      aeMc = new a((byte)0);
      AppMethodBeat.o(255498);
    }
    
    public static final boolean a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255497);
      boolean bool = a.a(paramView, parama, paramcc, paramString);
      AppMethodBeat.o(255497);
      return bool;
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255513);
      kotlin.g.b.s.u(paramLayoutInflater, "inflater");
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localView = (View)new ap(paramLayoutInflater, R.i.ggG);
        ((ap)localView).setTag(new ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder().createAppMsgFinderFeedHolder(localView, true));
      }
      AppMethodBeat.o(255513);
      return localView;
    }
    
    public void a(Activity paramActivity, cc paramcc)
    {
      AppMethodBeat.i(255553);
      kotlin.g.b.s.u(paramActivity, "context");
      kotlin.g.b.s.u(paramcc, "msg");
      ChatingItemAppMsgFinderLiveFeed.d locald = ChatingItemAppMsgFinderLiveFeed.aeLU;
      ChatingItemAppMsgFinderLiveFeed.d.a(paramActivity, paramcc);
      AppMethodBeat.o(255553);
    }
    
    public void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bmr parambmr, com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(255558);
      kotlin.g.b.s.u(paramAppMsgFinderLiveFeedHolder, "holder");
      kotlin.g.b.s.u(parambmr, "shareObject");
      kotlin.g.b.s.u(parama, "ui");
      ChatingItemAppMsgFinderLiveFeed.d locald = ChatingItemAppMsgFinderLiveFeed.aeLU;
      ChatingItemAppMsgFinderLiveFeed.d.a(paramAppMsgFinderLiveFeedHolder, parambmr, parama);
      AppMethodBeat.o(255558);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255532);
      kotlin.g.b.s.u(parama, "tag");
      kotlin.g.b.s.u(parama1, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      kotlin.g.b.s.u(paramString, "userName");
      super.a(parama, paramInt, parama1, paramcc, paramString);
      this.aeiK = parama1;
      ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder localAppMsgFinderLiveFeedHolder = (ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama;
      localAppMsgFinderLiveFeedHolder.setLiveId(0L);
      paramString = localAppMsgFinderLiveFeedHolder.getDetailLayout();
      kotlin.g.b.s.checkNotNull(paramString);
      paramString.animate().cancel();
      paramString = localAppMsgFinderLiveFeedHolder.getDetailLayout();
      kotlin.g.b.s.checkNotNull(paramString);
      paramString.setTag(Long.valueOf(System.currentTimeMillis()));
      Object localObject = paramcc.field_content;
      paramString = null;
      if (localObject != null) {
        paramString = k.b.aP((String)localObject, paramcc.field_reserved);
      }
      bmr localbmr;
      int i;
      if (paramString != null)
      {
        localbmr = ((com.tencent.mm.plugin.findersdk.a.b)paramString.aK(com.tencent.mm.plugin.findersdk.a.b.class)).HbV;
        if (localbmr != null)
        {
          localObject = localbmr.liveId;
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = "0";
          }
          localAppMsgFinderLiveFeedHolder.setLiveId(Util.getLong(paramString, 0L));
          paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString = com.tencent.mm.plugin.finder.loader.p.eCp();
          localObject = new com.tencent.mm.plugin.finder.loader.s(localbmr.headUrl, v.FKZ);
          ImageView localImageView = localAppMsgFinderLiveFeedHolder.getFinderAvatar();
          kotlin.g.b.s.checkNotNull(localImageView);
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString.a(localObject, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExP));
          paramString = localAppMsgFinderLiveFeedHolder.getFinderNickname();
          kotlin.g.b.s.checkNotNull(paramString);
          paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)parama1.aezO.getContext(), (CharSequence)localbmr.nickName));
          paramString = localAppMsgFinderLiveFeedHolder.getFinderNickname();
          kotlin.g.b.s.checkNotNull(paramString);
          aw.a((Paint)paramString.getPaint(), 0.8F);
          paramString = ChatingItemAppMsgFinderLiveFeed.aeLU;
          if (ChatingItemAppMsgFinderLiveFeed.d.a(parama1, parama, localbmr, localbmr.liveStatus, localbmr.ZVm)) {
            a(localAppMsgFinderLiveFeedHolder, localbmr, parama1);
          }
          parama = ChatingItemAppMsgFinderLiveFeed.aeLU;
          ChatingItemAppMsgFinderLiveFeed.d.a(localAppMsgFinderLiveFeedHolder);
          parama = localAppMsgFinderLiveFeedHolder.getFinderThumb();
          kotlin.g.b.s.checkNotNull(parama);
          parama.setVisibility(0);
          parama = (CharSequence)localbmr.desc;
          if ((parama != null) && (parama.length() != 0)) {
            break label1160;
          }
          i = 1;
          if (i == 0) {
            break label1166;
          }
          parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
          kotlin.g.b.s.checkNotNull(parama);
          parama.setVisibility(8);
          label415:
          parama = (CharSequence)localbmr.ZVq;
          if ((parama != null) && (parama.length() != 0)) {
            break label1206;
          }
          i = 1;
          label440:
          if ((i != 0) || (localbmr.liveStatus == 2)) {
            break label1272;
          }
          parama = (CharSequence)localbmr.eventId;
          if ((parama != null) && (parama.length() != 0)) {
            break label1212;
          }
          i = 1;
          label479:
          if ((i != 0) || (!kotlin.g.b.s.p(localbmr.eventId, "1"))) {
            break label1272;
          }
          parama = localAppMsgFinderLiveFeedHolder.getFinderOlympicView();
          if (parama != null)
          {
            paramString = parama.findViewById(R.h.finder_olympic_invite_bg);
            kotlin.g.b.s.s(paramString, "it.findViewById(R.id.finder_olympic_invite_bg)");
            paramString = (ImageView)paramString;
            localObject = parama.findViewById(R.h.finder_olympic_invite_icon);
            kotlin.g.b.s.s(localObject, "it.findViewById(R.id.finder_olympic_invite_icon)");
            localObject = (ImageView)localObject;
            ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage(paramString, b.j.ahpn, R.g.finder_olympic_live_share_bg);
            ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage((ImageView)localObject, b.j.ahpo, R.g.finder_olympic_live_share_icon);
            paramString = parama.findViewById(R.h.finder_olympic_invite_text);
            kotlin.g.b.s.s(paramString, "it.findViewById(R.id.finder_olympic_invite_text)");
            localObject = (TextView)paramString;
            ((TextView)localObject).setTextSize(1, 14.0F);
            paramString = parama.findViewById(R.h.finder_olympic_invite_name);
            kotlin.g.b.s.s(paramString, "it.findViewById(R.id.finder_olympic_invite_name)");
            paramString = (TextView)paramString;
            paramString.setTextSize(1, 14.0F);
            parama = parama.findViewById(R.h.finder_olympic_invite_you);
            kotlin.g.b.s.s(parama, "it.findViewById(R.id.finder_olympic_invite_you)");
            parama = (TextView)parama;
            parama.setTextSize(1, 17.0F);
            i.setTextBold((TextView)localObject);
            i.setTextBold(paramString);
            i.setTextBold(parama);
            parama = (CharSequence)localbmr.ZVr;
            if ((parama != null) && (parama.length() != 0)) {
              break label1218;
            }
            i = 1;
            label733:
            if (i == 0) {
              break label1224;
            }
            paramString.setVisibility(8);
            label745:
            parama = parama1.aezO.getContext().getResources().getString(R.l.finder_olympic_invite_text_3, new Object[] { localbmr.ZVq });
            kotlin.g.b.s.s(parama, "ui.context.resources.get… finderObject.relayIndex)");
            i = localAppMsgFinderLiveFeedHolder.getWidth();
            int j = com.tencent.mm.cd.a.fromDPToPix((Context)parama1.aezO.getContext(), 12);
            paramString = kotlin.n.n.m(parama, "\n", "", false);
            if (new StaticLayout((CharSequence)paramString, 0, paramString.length(), ((TextView)localObject).getPaint(), i - j * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() > 1) {
              break label1406;
            }
            parama = paramString;
          }
        }
      }
      label920:
      label1206:
      label1212:
      label1218:
      label1224:
      label1272:
      label1406:
      for (;;)
      {
        ((TextView)localObject).setText((CharSequence)parama);
        parama = localAppMsgFinderLiveFeedHolder.getFinderOlympicView();
        if (parama != null) {
          parama.setVisibility(0);
        }
        parama = localAppMsgFinderLiveFeedHolder.getFinderThumb();
        if (parama != null) {
          parama.setVisibility(8);
        }
        parama = localAppMsgFinderLiveFeedHolder.getBottomMask();
        if (parama != null) {
          parama.setVisibility(8);
        }
        localAppMsgFinderLiveFeedHolder.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
        localAppMsgFinderLiveFeedHolder.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
        localAppMsgFinderLiveFeedHolder.clickArea.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
        parama = this.aeiK;
        kotlin.g.b.s.checkNotNull(parama);
        parama = new bz(paramcc, parama.juG(), paramInt, null, '\000');
        localAppMsgFinderLiveFeedHolder.clickArea.setTag(parama);
        parama = localAppMsgFinderLiveFeedHolder.getBottomMask();
        if (parama != null) {
          ((cn)h.az(cn.class)).getFinderUtilApi().e((ViewGroup)parama, R.g.fnO, R.g.fnN);
        }
        if (c.jxj())
        {
          if (localAppMsgFinderLiveFeedHolder.uploadingPB != null) {
            localAppMsgFinderLiveFeedHolder.uploadingPB.setVisibility(8);
          }
          if ((paramcc.field_status == 2) && (b((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class), paramcc.field_msgId))) {
            if (localAppMsgFinderLiveFeedHolder.getTickIV() != null)
            {
              parama = localAppMsgFinderLiveFeedHolder.getTickIV();
              kotlin.g.b.s.checkNotNull(parama);
              parama.setVisibility(0);
            }
          }
          for (;;)
          {
            a(paramInt, (c.a)localAppMsgFinderLiveFeedHolder, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, (v.n)this);
            AppMethodBeat.o(255532);
            return;
            i = 0;
            break;
            parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
            kotlin.g.b.s.checkNotNull(parama);
            parama.setVisibility(0);
            parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
            kotlin.g.b.s.checkNotNull(parama);
            parama.setText((CharSequence)localbmr.desc);
            break label415;
            i = 0;
            break label440;
            i = 0;
            break label479;
            i = 0;
            break label733;
            paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)parama1.aezO.getContext(), (CharSequence)localbmr.ZVr));
            if (paramString.getVisibility() != 8) {
              break label745;
            }
            paramString.setVisibility(0);
            break label745;
            parama = localAppMsgFinderLiveFeedHolder.getFinderOlympicView();
            kotlin.g.b.s.checkNotNull(parama);
            parama.setVisibility(8);
            parama = localAppMsgFinderLiveFeedHolder.getFinderThumb();
            kotlin.g.b.s.checkNotNull(parama);
            parama.setVisibility(0);
            parama = localAppMsgFinderLiveFeedHolder.getBottomMask();
            kotlin.g.b.s.checkNotNull(parama);
            parama.setVisibility(0);
            break label920;
            if (localAppMsgFinderLiveFeedHolder.getTickIV() != null)
            {
              parama = localAppMsgFinderLiveFeedHolder.getTickIV();
              kotlin.g.b.s.checkNotNull(parama);
              parama.setVisibility(8);
            }
          }
        }
        if (localAppMsgFinderLiveFeedHolder.getTickIV() != null)
        {
          parama = localAppMsgFinderLiveFeedHolder.getTickIV();
          kotlin.g.b.s.checkNotNull(parama);
          parama.setVisibility(8);
        }
        parama = (c.a)localAppMsgFinderLiveFeedHolder;
        if (paramcc.field_status < 2) {}
        for (boolean bool = true;; bool = false)
        {
          b(parama, bool);
          break;
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255547);
      kotlin.g.b.s.u(paramMenuItem, "item");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = parama.aezO.getContext();
        kotlin.g.b.s.s(paramMenuItem, "ui.context");
        a(paramMenuItem, paramcc);
        AppMethodBeat.o(255547);
        return true;
      }
      AppMethodBeat.o(255547);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255543);
      kotlin.g.b.s.u(params, "menu");
      kotlin.g.b.s.u(paramView, "v");
      paramContextMenuInfo = paramView.getTag();
      if (paramContextMenuInfo == null)
      {
        params = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(255543);
        throw params;
      }
      int i = ((bz)paramContextMenuInfo).position;
      if (paramcc != null)
      {
        paramContextMenuInfo = this.aeiK;
        kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
        params.a(i, 111, (CharSequence)paramContextMenuInfo.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        params.removeItem(116);
        if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)))
        {
          paramContextMenuInfo = this.aeiK;
          kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
          if (!au.Hh(paramContextMenuInfo.getTalkerUserName())) {
            params.a(i, 123, (CharSequence)paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
          }
        }
      }
      AppMethodBeat.o(255543);
      return true;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255537);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      if (paramcc.fxR())
      {
        com.tencent.mm.pluginsdk.model.app.n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255537);
    }
    
    public boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255551);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      boolean bool = a.a(paramView, parama, paramcc, a(parama, paramcc));
      AppMethodBeat.o(255551);
      return bool;
    }
    
    public boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 973078577) || (paramInt == 975175729));
    }
    
    public final boolean fXn()
    {
      return true;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedTo$Companion;", "", "()V", "TAG", "", "onQuoteLiveMsgClick", "", "v", "Landroid/view/View;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "username", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static boolean a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc, String paramString)
      {
        AppMethodBeat.i(255587);
        kotlin.g.b.s.u(paramView, "v");
        kotlin.g.b.s.u(parama, "ui");
        kotlin.g.b.s.u(paramcc, "msg");
        Object localObject2 = paramcc.field_content;
        Object localObject1 = null;
        if (localObject2 != null) {
          localObject1 = k.b.aP((String)localObject2, paramcc.field_reserved);
        }
        com.tencent.mm.plugin.findersdk.a.b localb;
        long l2;
        long l3;
        if (localObject1 != null)
        {
          localb = (com.tencent.mm.plugin.findersdk.a.b)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.b.class);
          if (localb != null)
          {
            l2 = com.tencent.mm.ae.d.FK(localb.HbV.feedId);
            l3 = com.tencent.mm.ae.d.FK(localb.HbV.liveId);
            if (l2 != 0L)
            {
              paramcc = com.tencent.d.a.a.a.a.a.ahiX;
              if (!((Boolean)com.tencent.d.a.a.a.a.a.jSP().bmg()).booleanValue()) {
                break label186;
              }
              paramView = new Intent();
              paramView.putExtra("feed_object_id", l2);
              paramView.putExtra("feed_object_nonceId", localb.HbV.objectNonceId);
              ((cn)h.az(cn.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramView);
            }
          }
        }
        for (;;)
        {
          paramView = ah.aiuX;
          paramView = ah.aiuX;
          AppMethodBeat.o(255587);
          return false;
          label186:
          if (paramString == null)
          {
            localObject1 = parama.Uxa.field_username;
            paramcc = (cc)localObject1;
            if (localObject1 == null) {
              paramcc = "";
            }
            label210:
            com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq = paramcc;
            com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr = com.tencent.mm.plugin.expt.hellhound.core.b.hF(parama.Uxa.maN);
            if (!((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(paramView.findViewById(R.h.finder_live_icon), paramView.findViewById(R.h.finder_live_end_tag), l3)) {
              break label440;
            }
            if (parama.juF()) {
              break label419;
            }
          }
          label419:
          for (paramView = ((cn)h.az(cn.class)).genContextId(2, 2, 65);; paramView = ((cn)h.az(cn.class)).genContextId(3, 2, 65))
          {
            localObject1 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
            localObject2 = (Context)parama.aezO.getContext();
            paramcc = localb.HbV.username;
            parama = paramcc;
            if (paramcc == null) {
              parama = "";
            }
            paramString = localb.HbV.objectNonceId;
            paramcc = paramString;
            if (paramString == null) {
              paramcc = "";
            }
            paramString = localb.HbV.desc;
            kotlin.g.b.s.s(paramView, "contextId");
            ((com.tencent.d.a.a.a.b)localObject1).enterFinderLiveReplayUI(null, (Context)localObject2, l2, l3, parama, paramcc, paramString, paramView, ((cn)h.az(cn.class)).getFinderUtilApi().fgH());
            ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).reportFinderLiveReplay(l2, "share");
            break;
            paramcc = paramString;
            break label210;
          }
          label440:
          if (!Util.isEqual(localb.HbV.username, z.bAW())) {
            break;
          }
          paramcc = new Intent();
          paramcc.putExtra("KEY_PARAMS_SOURCE_TYPE", localb.HbV.sourceType);
          paramString = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
          localObject1 = MMApplicationContext.getContext();
          parama = localb.HbV.objectNonceId;
          paramView = parama;
          if (parama == null) {
            paramView = "";
          }
          paramString.enterFinderLiveAnchorUI(paramcc, (Context)localObject1, l2, Long.valueOf(l3), paramView, localb.HbV.desc, "", "", "");
        }
        Object localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramcc = localb.HbV.username;
        paramView = paramcc;
        if (paramcc == null) {
          paramView = "";
        }
        q.w localw = q.w.DwU;
        String str = q.n.Dty.scene;
        long l1;
        label603:
        int j;
        if (localb.HbV.liveStatus == 1)
        {
          l1 = q.u.DwE.status;
          paramcc = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          long l4 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.dKk();
          localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq;
          paramcc = (cc)localObject1;
          if (localObject1 == null) {
            paramcc = "";
          }
          localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.plugin.finder.live.report.j)localObject3).b(new o(l2, l3, paramView, 0L, -1L, localw, str, l1, l4, paramcc, (String)localObject1, System.currentTimeMillis(), q.ca.DDZ, null, null, null, null, 122880));
          paramView = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
          com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999697);
          if (parama.juF()) {
            break label1499;
          }
          paramcc = ((cn)h.az(cn.class)).genContextId(2, 2, 65);
          label727:
          localObject2 = new Intent();
          localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((Intent)localObject2).putExtra("key_enter_live_param_share_username", paramView);
          ((Intent)localObject2).putExtra("key_enter_live_param_from_share_scene", 0);
          ((Intent)localObject2).putExtra("key_enter_live_param_visitor_enter_scene", 1);
          localObject1 = localb.HbV.ecSource;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((Intent)localObject2).putExtra("key_enter_live_param_ecsource", paramView);
          localObject1 = localb.HbV.ecSource;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          Log.i("MicroMsg.ChattingItemAppMsgFinderLiveFeedTo", "to ecSource:%s", new Object[] { paramView });
          ((Intent)localObject2).putExtra("key_enter_live_param_bind_type", localb.HbV.mIJ);
          localObject1 = localb.HbV.hUQ;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((Intent)localObject2).putExtra("key_enter_live_param_by_biz_username", paramView);
          localObject1 = localb.HbV.mIK;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((Intent)localObject2).putExtra("key_enter_live_param_by_biz_nickname", paramView);
          paramView = (CharSequence)localb.HbV.coverUrl;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label1520;
          }
          i = 1;
          label958:
          if (i != 0) {
            break label1526;
          }
          paramView = localb.HbV.coverUrl;
          label972:
          ((Intent)localObject2).putExtra("key_enter_live_cover_url", paramView);
          ((Intent)localObject2).putExtra("key_enter_live_param_is_from_chat_group", parama.juG());
          paramView = b.k.ahpq;
          ((Intent)localObject2).putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWo());
          int k = 0;
          paramView = (CharSequence)localb.HbV.ZVq;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label1583;
          }
          j = 1;
          label1042:
          i = k;
          if (j == 0)
          {
            paramView = (CharSequence)localb.HbV.eventId;
            if ((paramView != null) && (paramView.length() != 0)) {
              break label1589;
            }
            j = 1;
            label1079:
            i = k;
            if (j == 0)
            {
              i = k;
              if (kotlin.g.b.s.p(localb.HbV.eventId, "1"))
              {
                paramView = new brs();
                paramView.ZVq = localb.HbV.ZVq;
                paramView.ZVp = localb.HbV.ZVp;
                paramView.ZVs = localb.HbV.ZVs;
                paramView.ZVr = localb.HbV.ZVr;
                localObject1 = ah.aiuX;
                ((Intent)localObject2).putExtra("KEY_ENTER_LIVE_PARAM_OLYMPIC_FIRE_AUTHOR_INFO", paramView.toByteArray());
                i = 1;
              }
            }
          }
          paramView = (CharSequence)localb.HbV.eventId;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label1595;
          }
          j = 1;
          label1214:
          if (j == 0)
          {
            localObject1 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
            localObject3 = new dwa();
            paramView = b.e.ahon;
            ((dwa)localObject3).abbK = b.e.a.jWb();
            paramView = paramString;
            if (paramString == null) {
              paramView = "";
            }
            ((dwa)localObject3).hLv = paramView;
            ((dwa)localObject3).abbL = i;
            ((dwa)localObject3).abbM = parama.juG();
            paramView = ah.aiuX;
            ((com.tencent.d.a.a.a.b)localObject1).initOlympicsReport((dwa)localObject3);
          }
          if (parama.juG())
          {
            paramView = parama.getTalkerUserName();
            if ((paramView == null) || (kotlin.n.n.rs(paramView, "@chatroom") != true)) {
              break label1601;
            }
          }
        }
        label1577:
        label1583:
        label1589:
        label1595:
        label1601:
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramString = parama.getTalkerUserName();
            paramView = paramString;
            if (paramString == null) {
              paramView = "";
            }
            ((Intent)localObject2).putExtra("KEY_ENTER_LIVE_PARAM_BOX_GROUP_ID", paramView);
            ((Intent)localObject2).putExtra("KEY_ENTER_LIVE_PARAM_BOX_GROUP_TO_LIVEID", l3);
          }
          localObject1 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
          localObject3 = (Context)parama.aezO.getContext();
          parama = localb.HbV.username;
          paramView = parama;
          if (parama == null) {
            paramView = "";
          }
          paramString = localb.HbV.objectNonceId;
          parama = paramString;
          if (paramString == null) {
            parama = "";
          }
          paramString = localb.HbV.desc;
          kotlin.g.b.s.s(paramcc, "contextId");
          ((com.tencent.d.a.a.a.b)localObject1).enterFinderLiveVisitorUI((Intent)localObject2, (Context)localObject3, l2, Long.valueOf(l3), paramView, parama, paramString, paramcc, "", "", 0, "", 1, ((cn)h.az(cn.class)).getFinderUtilApi().fgH());
          break;
          l1 = q.u.DwF.status;
          break label603;
          label1499:
          paramcc = ((cn)h.az(cn.class)).genContextId(3, 2, 65);
          break label727;
          label1520:
          i = 0;
          break label958;
          label1526:
          paramView = (CharSequence)localb.HbV.headUrl;
          if ((paramView == null) || (paramView.length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label1577;
            }
            paramView = localb.HbV.headUrl;
            break;
          }
          paramView = "";
          break label972;
          j = 0;
          break label1042;
          j = 0;
          break label1079;
          j = 0;
          break label1214;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adjustMediaHeight", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "width", "", "height", "checkLiveStatus", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "retransmit", "context", "Landroid/app/Activity;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "updateLiveTag", "", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "liveStatus", "", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    public static void a(Activity paramActivity, cc paramcc)
    {
      AppMethodBeat.i(255519);
      kotlin.g.b.s.u(paramActivity, "context");
      kotlin.g.b.s.u(paramcc, "msg");
      k.b localb;
      Intent localIntent;
      if (!Util.isNullOrNil(paramcc.field_content))
      {
        localb = k.b.Hf(paramcc.field_content);
        if (localb != null)
        {
          localIntent = new Intent((Context)paramActivity, MsgRetransmitUI.class);
          localIntent.putExtra("Retr_Msg_Id", paramcc.field_msgId);
          if (localb.type != 63) {
            break label203;
          }
          localIntent.putExtra("Retr_Msg_Type", 23);
        }
      }
      for (;;)
      {
        Log.i(ChatingItemAppMsgFinderLiveFeed.access$getTAG$cp(), kotlin.g.b.s.X("retransmit content.type:", Integer.valueOf(localb.type)));
        localIntent.putExtra("Multi_Retr", true);
        localIntent.putExtra("Retr_Msg_content", k.b.a(localb, null, null));
        localIntent.putExtra("Retr_go_to_chattingUI", false);
        localIntent.putExtra("Retr_show_success_tips", true);
        paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramcc.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramcc.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(255519);
        return;
        label203:
        if (localb.type == 88) {
          localIntent.putExtra("Retr_Msg_Type", 31);
        }
      }
    }
    
    public static void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder)
    {
      AppMethodBeat.i(255511);
      kotlin.g.b.s.u(paramAppMsgFinderLiveFeedHolder, "holder");
      int i = (int)(paramAppMsgFinderLiveFeedHolder.getWidth() * 1.333333373069763D);
      Object localObject = paramAppMsgFinderLiveFeedHolder.getFinderThumb();
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((ImageView)localObject).getLayoutParams();
      if (localObject == null)
      {
        paramAppMsgFinderLiveFeedHolder = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(255511);
        throw paramAppMsgFinderLiveFeedHolder;
      }
      localObject = (FrameLayout.LayoutParams)localObject;
      ((FrameLayout.LayoutParams)localObject).height = i;
      ImageView localImageView = paramAppMsgFinderLiveFeedHolder.getFinderThumb();
      kotlin.g.b.s.checkNotNull(localImageView);
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramAppMsgFinderLiveFeedHolder = paramAppMsgFinderLiveFeedHolder.getFinderOlympicView();
      kotlin.g.b.s.checkNotNull(paramAppMsgFinderLiveFeedHolder);
      paramAppMsgFinderLiveFeedHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(255511);
    }
    
    public static void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, final bmr parambmr, com.tencent.mm.ui.chatting.d.a parama)
    {
      final long l = 0L;
      AppMethodBeat.i(255535);
      kotlin.g.b.s.u(paramAppMsgFinderLiveFeedHolder, "holder");
      kotlin.g.b.s.u(parambmr, "shareObject");
      kotlin.g.b.s.u(parama, "ui");
      Object localObject = parambmr.liveId;
      if (localObject == null) {}
      for (;;)
      {
        parambmr = new a(paramAppMsgFinderLiveFeedHolder, parambmr, l, parama);
        if (!(parama.aezO.getContext() instanceof MMFragmentActivity)) {
          break label147;
        }
        paramAppMsgFinderLiveFeedHolder = parama.aezO.getContext();
        if (paramAppMsgFinderLiveFeedHolder != null) {
          break;
        }
        paramAppMsgFinderLiveFeedHolder = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(255535);
        throw paramAppMsgFinderLiveFeedHolder;
        localObject = kotlin.n.n.bJH((String)localObject);
        if (localObject != null) {
          l = ((Long)localObject).longValue();
        }
      }
      label147:
      for (paramAppMsgFinderLiveFeedHolder = (MMFragmentActivity)paramAppMsgFinderLiveFeedHolder;; paramAppMsgFinderLiveFeedHolder = null)
      {
        ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getLiveInfo(l, false, (com.tencent.mm.vending.e.b)paramAppMsgFinderLiveFeedHolder, (b.d)parambmr);
        AppMethodBeat.o(255535);
        return;
      }
    }
    
    private static final boolean a(bmr parambmr, bip parambip)
    {
      AppMethodBeat.i(255546);
      if (parambip != null)
      {
        boolean bool = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(parambip);
        AppMethodBeat.o(255546);
        return bool;
      }
      if (parambmr.ZVl == 2)
      {
        AppMethodBeat.o(255546);
        return true;
      }
      AppMethodBeat.o(255546);
      return false;
    }
    
    public static boolean a(com.tencent.mm.ui.chatting.d.a parama, c.a parama1, bmr parambmr, int paramInt, bip parambip)
    {
      AppMethodBeat.i(255530);
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(parama1, "tag");
      kotlin.g.b.s.u(parambmr, "shareObject");
      ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder localAppMsgFinderLiveFeedHolder = (ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama1;
      boolean bool3 = a(parambmr, parambip);
      boolean bool4 = b(parambmr, parambip);
      boolean bool1;
      label168:
      boolean bool2;
      if ((!bool3) && (!bool4) && (parambip != null) && ((parambmr.ZVl == 2) || (parambmr.ZVl == 6)))
      {
        bool1 = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).producingReplay(parambip);
        String str = ChatingItemAppMsgFinderLiveFeed.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("updateLiveTag desc:").append(parambmr.desc).append("(live:").append(parambmr.liveId).append(' ').append(parambmr.nickName).append("),liveStatus:").append(paramInt).append('(');
        if (parambip != null) {
          break label429;
        }
        parama1 = null;
        parama1 = localStringBuilder.append(parama1).append("),chargFlag:").append(parambmr.ZVl).append(",isChargeLive:").append(bool3).append(",isLiveReplay:").append(bool4).append(", producingReplay:").append(bool1).append(", liveInfo null:");
        if (parambip != null) {
          break label441;
        }
        bool2 = true;
        label235:
        localStringBuilder = parama1.append(bool2).append(",purchaseInfo null:");
        if (parambip != null) {
          break label447;
        }
        parama1 = null;
        label256:
        if (parama1 != null) {
          break label456;
        }
        bool2 = true;
        label263:
        Log.i(str, bool2);
        if ((parambip == null) || (paramInt == parambip.liveStatus)) {
          break label661;
        }
        bool2 = false;
        bool3 = false;
      }
      for (;;)
      {
        int i;
        if ((bool3) || (bool2) || (paramInt == 1))
        {
          i = 1;
          label316:
          if (i == 0) {
            break label484;
          }
          parama = localAppMsgFinderLiveFeedHolder.getLiveTag();
          if (parama != null) {
            parama.setVisibility(0);
          }
          parama = localAppMsgFinderLiveFeedHolder.getLiveEndTag();
          if (parama != null) {
            parama.setVisibility(8);
          }
          if (!bool3) {
            break label468;
          }
          paramInt = 2;
          label359:
          ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).setFinderLiveTagText((View)localAppMsgFinderLiveFeedHolder.getLiveTag(), paramInt);
          ((cn)h.az(cn.class)).loadImage(f(parambmr), localAppMsgFinderLiveFeedHolder.getFinderThumb());
        }
        for (;;)
        {
          if ((i == 0) && (!bool1)) {
            break label653;
          }
          AppMethodBeat.o(255530);
          return true;
          bool1 = false;
          break;
          label429:
          parama1 = Integer.valueOf(parambip.liveStatus);
          break label168;
          label441:
          bool2 = false;
          break label235;
          label447:
          parama1 = parambip.ZSc;
          break label256;
          label456:
          bool2 = false;
          break label263;
          i = 0;
          break label316;
          label468:
          if (bool2)
          {
            paramInt = 6;
            break label359;
          }
          paramInt = 0;
          break label359;
          label484:
          if (paramInt == 2)
          {
            parama1 = localAppMsgFinderLiveFeedHolder.getLiveTag();
            if (parama1 != null) {
              parama1.setVisibility(8);
            }
            parama1 = localAppMsgFinderLiveFeedHolder.getLiveEndTag();
            if (parama1 != null) {
              parama1.setVisibility(0);
            }
            parama1 = localAppMsgFinderLiveFeedHolder.getLiveTag();
            if (parama1 != null)
            {
              parama = parama.aezO.getContext().getResources().getString(R.l.finder_live_share_onlive_status);
              kotlin.g.b.s.s(parama, "ui.context.resources.get…live_share_onlive_status)");
              parama1.setText(parama);
            }
            ((cn)h.az(cn.class)).getFinderUtilApi().a(localAppMsgFinderLiveFeedHolder.getFinderThumb(), f(parambmr));
            parama = localAppMsgFinderLiveFeedHolder.getFinderThumb();
            if (parama != null) {
              parama.setVisibility(0);
            }
            parama = localAppMsgFinderLiveFeedHolder.getFinderOlympicView();
            if (parama != null) {
              parama.setVisibility(8);
            }
            parama = localAppMsgFinderLiveFeedHolder.getActivityInfoIcon();
            if (parama != null) {
              parama.setVisibility(8);
            }
            parama = localAppMsgFinderLiveFeedHolder.getReasonTv();
            if (parama != null) {
              parama.setVisibility(8);
            }
          }
        }
        label653:
        AppMethodBeat.o(255530);
        return false;
        label661:
        bool2 = bool4;
      }
    }
    
    private static final boolean b(bmr parambmr, bip parambip)
    {
      AppMethodBeat.i(255549);
      if (parambip != null)
      {
        boolean bool = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(parambip);
        AppMethodBeat.o(255549);
        return bool;
      }
      if (parambmr.ZVl == 6)
      {
        AppMethodBeat.o(255549);
        return true;
      }
      AppMethodBeat.o(255549);
      return false;
    }
    
    private static final String f(bmr parambmr)
    {
      AppMethodBeat.i(255540);
      CharSequence localCharSequence = (CharSequence)parambmr.coverUrl;
      int i;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
        i = 1;
      }
      while (i == 0)
      {
        parambmr = parambmr.coverUrl;
        if (parambmr == null)
        {
          AppMethodBeat.o(255540);
          return "";
          i = 0;
        }
        else
        {
          AppMethodBeat.o(255540);
          return parambmr;
        }
      }
      localCharSequence = (CharSequence)parambmr.headUrl;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
        i = 1;
      }
      while (i == 0)
      {
        parambmr = parambmr.headUrl;
        if (parambmr == null)
        {
          AppMethodBeat.o(255540);
          return "";
          i = 0;
        }
        else
        {
          AppMethodBeat.o(255540);
          return parambmr;
        }
      }
      AppMethodBeat.o(255540);
      return "";
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion$checkLiveStatus$statusCallBack$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "status", "", "liveInfo", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements b.d
    {
      a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bmr parambmr, long paramLong, com.tencent.mm.ui.chatting.d.a parama) {}
      
      public final void onLiveStatusCallback(long paramLong, int paramInt, Object paramObject)
      {
        Object localObject2 = null;
        AppMethodBeat.i(255077);
        if (this.aeMd.getLiveId() != paramLong)
        {
          paramObject = ChatingItemAppMsgFinderLiveFeed.aeLU;
          Log.i(ChatingItemAppMsgFinderLiveFeed.access$getTAG$cp(), "#checkLiveStatus.onLiveStatusCallback not match, return");
          AppMethodBeat.o(255077);
          return;
        }
        parambmr.liveStatus = paramInt;
        Object localObject3 = parambmr;
        Object localObject1;
        label76:
        int i;
        if ((paramObject instanceof azl))
        {
          localObject1 = (azl)paramObject;
          if (localObject1 != null) {
            break label396;
          }
          localObject1 = null;
          ((bmr)localObject3).ZVm = ((bip)localObject1);
          localObject1 = ChatingItemAppMsgFinderLiveFeed.aeLU;
          localObject3 = ChatingItemAppMsgFinderLiveFeed.access$getTAG$cp();
          StringBuilder localStringBuilder = new StringBuilder("[checkLiveStatus] thisLiveId:").append(l).append(",liveID:").append(paramLong).append(",desc:").append(parambmr.desc).append(",share status:").append(parambmr.liveStatus).append(",callback liveStatus:").append(paramInt).append(',');
          localObject1 = parambmr.ZVm;
          if (localObject1 != null) {
            break label406;
          }
          localObject1 = localObject2;
          label182:
          Log.i((String)localObject3, localObject1);
          localObject1 = ChatingItemAppMsgFinderLiveFeed.aeLU;
          localObject1 = this.aeMf;
          localObject2 = (c.a)this.aeMd;
          localObject3 = parambmr;
          ChatingItemAppMsgFinderLiveFeed.d.a((com.tencent.mm.ui.chatting.d.a)localObject1, (c.a)localObject2, (bmr)localObject3, paramInt, ((bmr)localObject3).ZVm);
          localObject1 = "";
          if ((paramObject instanceof azl))
          {
            localObject1 = ((azl)paramObject).recommend_reason;
            paramObject = localObject1;
            if (localObject1 == null) {
              paramObject = "";
            }
            localObject1 = paramObject;
          }
          if (((CharSequence)localObject1).length() != 0) {
            break label421;
          }
          i = 1;
          label294:
          if ((i == 0) && (paramInt != 2) && (((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isFinderLiveActivityIconSharedEnable())) {
            break label427;
          }
          paramObject = this.aeMd.getReasonTv();
          if (paramObject != null) {
            paramObject.setVisibility(8);
          }
        }
        for (;;)
        {
          paramObject = this.aeMd.getBottomMask();
          if (paramObject != null) {
            ((cn)h.az(cn.class)).getFinderUtilApi().e((ViewGroup)paramObject, R.g.fnO, R.g.fnN);
          }
          AppMethodBeat.o(255077);
          return;
          localObject1 = null;
          break;
          label396:
          localObject1 = ((azl)localObject1).liveInfo;
          break label76;
          label406:
          localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
          localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.c((bip)localObject1);
          break label182;
          label421:
          i = 0;
          break label294;
          label427:
          paramObject = this.aeMd.getReasonTv();
          if (paramObject != null) {
            paramObject.setText((CharSequence)localObject1);
          }
          paramObject = this.aeMd.getReasonTv();
          if (paramObject != null) {
            paramObject.setVisibility(0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed
 * JD-Core Version:    0.7.0.1
 */