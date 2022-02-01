package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.message.x;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.duv;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qk;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.j;
import kotlin.k;
import kotlin.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "addContactScene", "", "contact", "Lcom/tencent/mm/storage/Contact;", "enterTime", "", "(Landroid/content/Context;ILcom/tencent/mm/storage/Contact;J)V", "getAddContactScene", "()I", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "changedPlayId", "", "getContact", "()Lcom/tencent/mm/storage/Contact;", "getContext", "()Landroid/content/Context;", "getEnterTime", "()J", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getExpandSet", "()Ljava/util/HashSet;", "isBizPayOpen", "", "()Z", "messageHandler", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "onLoadMore", "Lkotlin/Function0;", "", "getOnLoadMore", "()Lkotlin/jvm/functions/Function0;", "setOnLoadMore", "(Lkotlin/jvm/functions/Function0;)V", "originalCount", "getOriginalCount", "setOriginalCount", "(I)V", "getFooterCount", "getItemCount", "getItemId", "position", "getItemViewType", "getMsgPosition", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onMusicStateChanged", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "update", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "notifyInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "BizDateViewHolder", "CommonSlotViewModel", "Companion", "LoadingViewHolder", "SlotType", "SlotViewModel", "TopSlotViewModel", "VideoChannelViewHolder", "ViewHolder", "newBizMsgViewHolder", "newVideoChannelViewHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<RecyclerView.v>
{
  public static final a.c NeA;
  private static final String TAG;
  private final com.tencent.mm.plugin.profile.ui.newbizinfo.b.a NeB;
  private String NeC;
  private int NeD;
  kotlin.g.a.a<ah> NeE;
  private final j NeF;
  final boolean NeG;
  private final HashSet<Integer> NeH;
  final au contact;
  final Context context;
  final long enterTime;
  final int pUt;
  
  static
  {
    AppMethodBeat.i(306187);
    NeA = new a.c((byte)0);
    TAG = "MicroMsg.NewBizInfoAdapter";
    AppMethodBeat.o(306187);
  }
  
  public a(Context paramContext, au paramau, long paramLong)
  {
    AppMethodBeat.i(306156);
    this.context = paramContext;
    this.pUt = 0;
    this.contact = paramau;
    this.enterTime = paramLong;
    this.NeB = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.a();
    com.tencent.mm.plugin.brandservice.model.d.init();
    this.NeC = "none";
    this.NeF = k.cm((kotlin.g.a.a)a.h.Nfw);
    this.NeG = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbx();
    this.NeH = new HashSet();
    AppMethodBeat.o(306156);
  }
  
  private int afW(int paramInt)
  {
    return paramInt - this.NeD + 0;
  }
  
  private final com.tencent.mm.plugin.brandservice.api.c gCY()
  {
    AppMethodBeat.i(306166);
    com.tencent.mm.plugin.brandservice.api.c localc = (com.tencent.mm.plugin.brandservice.api.c)this.NeF.getValue();
    AppMethodBeat.o(306166);
    return localc;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(306214);
    kotlin.g.b.s.u(paramViewGroup, "parent");
    if (paramInt == com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b.Ncz.ordinal())
    {
      paramViewGroup = LayoutInflater.from(this.context).inflate(R.i.ghU, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new a.d(paramViewGroup);
      AppMethodBeat.o(306214);
      return paramViewGroup;
    }
    if (paramInt == com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b.Ncy.ordinal())
    {
      paramViewGroup = LayoutInflater.from(this.context).inflate(R.i.ghQ, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new i(paramViewGroup);
      AppMethodBeat.o(306214);
      return paramViewGroup;
    }
    if (paramInt == com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b.NcA.ordinal())
    {
      paramViewGroup = LayoutInflater.from(this.context).inflate(R.i.gib, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new j(paramViewGroup);
      AppMethodBeat.o(306214);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.context).inflate(R.i.ghS, paramViewGroup, false);
    kotlin.g.b.s.s(paramViewGroup, "view");
    paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
    AppMethodBeat.o(306214);
    return paramViewGroup;
  }
  
  public final void c(py parampy)
  {
    AppMethodBeat.i(306194);
    kotlin.g.b.s.u(parampy, "msgList");
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.a locala = this.NeB;
    kotlin.g.b.s.u(parampy, "msgList");
    locala.lPK.clear();
    kotlin.g.b.s.s(Calendar.getInstance(), "getInstance()");
    new Date();
    Object localObject = parampy.YUi;
    kotlin.g.b.s.s(localObject, "msgList.Msg");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      px localpx = (px)((Iterator)localObject).next();
      locala.lPK.add(new kotlin.r(com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b.Ncx, localpx));
      locala.lPK.add(new kotlin.r(com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b.Ncy, localpx));
    }
    parampy = parampy.YUj;
    if ((parampy != null) && (parampy.YVg == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        locala.lPK.add(new kotlin.r(com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b.Ncz, new px()));
      }
      this.bZE.notifyChanged();
      AppMethodBeat.o(306194);
      return;
    }
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(306226);
    kotlin.g.b.s.u(paramv, "holder");
    if ((paramv instanceof a.d))
    {
      paramv = this.NeE;
      if (paramv != null)
      {
        paramv.invoke();
        AppMethodBeat.o(306226);
      }
    }
    else
    {
      Object localObject1;
      Object localObject2;
      if ((paramv instanceof i))
      {
        paramInt = afW(paramInt);
        localObject1 = (px)this.NeB.getItem(paramInt);
        if ((((px)localObject1).YUc.IIs == 49) && (gCY().GV(16)))
        {
          localObject2 = gCY();
          Object localObject3 = ((px)localObject1).YUh.YRm;
          kotlin.g.b.s.s(localObject3, "bizMessage.AppMsg.DetailInfo");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            od localod = (od)((Iterator)localObject4).next();
            ((Collection)localObject3).add(kotlin.a.p.listOf(new String[] { localod.YQK, String.valueOf(localod.nUA) }));
          }
          ((com.tencent.mm.plugin.brandservice.api.c)localObject2).s((List)localObject3, 126);
        }
        ((i)paramv).a(this, (px)localObject1, this.NeH, paramInt / 2);
        AppMethodBeat.o(306226);
        return;
      }
      if ((paramv instanceof j))
      {
        paramInt = afW(paramInt);
        paramv = (j)paramv;
        localObject1 = (ehk)this.NeB.getItem(paramInt);
        kotlin.g.b.s.u(this, "widget");
        kotlin.g.b.s.u(localObject1, "videoInfo");
        paramv.Nfx = this;
        paramv.a((ehk)localObject1);
        AppMethodBeat.o(306226);
        return;
      }
      if ((paramv instanceof a))
      {
        paramInt = afW(paramInt);
        paramv = ((a)paramv).NeI;
        localObject2 = this.NeB;
        localObject1 = MMApplicationContext.getContext();
        ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.a)localObject2).afT(paramInt);
        long l = ((px)((com.tencent.mm.plugin.profile.ui.newbizinfo.b.a)localObject2).getItem(paramInt)).YUc.Zmz * 1000L;
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTime(new Date(l));
        kotlin.g.b.s.s(localObject2, "getInstance().apply { time = Date(date) }");
        DateFormat.format((CharSequence)((Context)localObject1).getString(R.l.fmt_normal_time), l);
        paramv.setText((CharSequence)com.tencent.mm.pluginsdk.platformtools.f.D((Context)localObject1, l).toString());
      }
    }
    AppMethodBeat.o(306226);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(306201);
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.a locala = this.NeB;
    int i = locala.lPK.size();
    int j = locala.Ncp.size();
    AppMethodBeat.o(306201);
    return j + i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(306208);
    paramInt = afW(paramInt);
    paramInt = this.NeB.afT(paramInt).ordinal();
    AppMethodBeat.o(306208);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$BizDateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "dateTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDateTextView", "()Landroid/widget/TextView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final TextView NeI;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(306039);
      this.NeI = ((TextView)paramView.findViewById(R.h.fun));
      AppMethodBeat.o(306039);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$CommonSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;Landroid/view/ViewGroup;)V", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusInfo", "Lcom/tencent/mm/plugin/profile/ui/tab/list/ImageRadiusInfo;", "getImageRadiusInfo", "()Lcom/tencent/mm/plugin/profile/ui/tab/list/ImageRadiusInfo;", "isPayMsg", "setPayMsg", "(I)V", "picCntTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "Lkotlin/Lazy;", "picInfo", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getPicInfo", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "picInfo$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "titleTv$delegate", "url", "getUrl", "setUrl", "weakPicInfo", "Ljava/lang/ref/WeakReference;", "getWeakPicInfo", "()Ljava/lang/ref/WeakReference;", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends a.f
  {
    private final int NeJ;
    private final j NeK;
    private final WeakReference<ConstraintLayout> NeL;
    private final j NeM;
    private final j NeN;
    int NeO;
    private String title;
    String url;
    private final j vOl;
    
    public b(int paramInt, a.e parame, ViewGroup paramViewGroup)
    {
      super(parame, paramViewGroup);
      AppMethodBeat.i(306047);
      this.NeJ = R.g.foL;
      this.NeK = k.cm((kotlin.g.a.a)new c(this));
      parame = this.NeK.getValue();
      kotlin.g.b.s.s(parame, "<get-picInfo>(...)");
      this.NeL = new WeakReference((ConstraintLayout)parame);
      this.NeM = k.cm((kotlin.g.a.a)new b(this));
      this.NeN = k.cm((kotlin.g.a.a)new d(this));
      this.vOl = k.cm((kotlin.g.a.a)new e(this));
      this.url = "";
      this.title = "";
      AppMethodBeat.o(306047);
    }
    
    protected final void a(View paramView, a.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(306066);
      kotlin.g.b.s.u(paramView, "container");
      kotlin.g.b.s.u(parame, "slotType");
      switch (a.$EnumSwitchMapping$0[parame.ordinal()])
      {
      default: 
        ((FrameLayout)paramView.findViewById(R.h.biz_slot_voice_layout)).setVisibility(8);
        switch (getItemShowType())
        {
        case 6: 
        case 9: 
        default: 
          ((ImageView)paramView.findViewById(R.h.fup)).setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        super.a(paramView, parame, paramBoolean);
        AppMethodBeat.o(306066);
        return;
        paramView.findViewById(R.h.fum).setVisibility(0);
        break;
        ((ImageView)paramView.findViewById(R.h.fup)).setVisibility(0);
        ((ImageView)paramView.findViewById(R.h.fuB)).setVisibility(0);
        continue;
        ((ImageView)paramView.findViewById(R.h.fup)).setVisibility(0);
        ((ConstraintLayout)paramView.findViewById(R.h.ful)).setVisibility(0);
        continue;
        ((FrameLayout)paramView.findViewById(R.h.biz_slot_voice_layout)).setVisibility(0);
      }
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)paramView.findViewById(R.h.fuw);
      Object localObject;
      if ((localMMNeat7extView.getLayoutParams() instanceof ConstraintLayout.LayoutParams))
      {
        localObject = localMMNeat7extView.getLayoutParams();
        if (localObject == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
          AppMethodBeat.o(306066);
          throw paramView;
        }
        localObject = (ConstraintLayout.LayoutParams)localObject;
      }
      for (;;)
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        if (localObject != null)
        {
          ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(0);
          localMMNeat7extView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        ((ImageView)paramView.findViewById(R.h.fup)).setVisibility(8);
        break;
        localObject = localMMNeat7extView.getLayoutParams();
        if ((localObject instanceof LinearLayout.LayoutParams)) {
          localObject = (LinearLayout.LayoutParams)localObject;
        } else {
          localObject = null;
        }
      }
    }
    
    protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(306054);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramViewGroup, "container");
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ghR, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(306054);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      paramViewGroup.addView((View)paramContext);
      AppMethodBeat.o(306054);
      return paramContext;
    }
    
    protected final void gCZ()
    {
      AppMethodBeat.i(306074);
      if (this.NeL == null)
      {
        AppMethodBeat.o(306074);
        return;
      }
      ConstraintLayout localConstraintLayout = (ConstraintLayout)this.NeL.get();
      if (localConstraintLayout != null) {
        localConstraintLayout.setBackgroundResource(R.g.biz_msg_cover_gradient_mask);
      }
      AppMethodBeat.o(306074);
    }
    
    protected final c gDa()
    {
      AppMethodBeat.i(306079);
      c localc = new c(cT(1.0F), true, true);
      AppMethodBeat.o(306079);
      return localc;
    }
    
    protected final int gDb()
    {
      return this.NeJ;
    }
    
    public final TextView gDc()
    {
      AppMethodBeat.i(306099);
      TextView localTextView = (TextView)this.NeM.getValue();
      AppMethodBeat.o(306099);
      return localTextView;
    }
    
    public final TextView gDd()
    {
      AppMethodBeat.i(306106);
      TextView localTextView = (TextView)this.NeN.getValue();
      AppMethodBeat.o(306106);
      return localTextView;
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(306114);
      kotlin.g.b.s.u(paramString, "value");
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.vOl.getValue();
      kotlin.g.b.s.s(localMMNeat7extView, "titleTv");
      a(localMMNeat7extView, paramString, this.NeO, this.url, 5);
      AppMethodBeat.o(306114);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<TextView>
    {
      b(a.b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ConstraintLayout>
    {
      c(a.b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.g.b.u
      implements kotlin.g.a.a<TextView>
    {
      d(a.b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends kotlin.g.b.u
      implements kotlin.g.a.a<MMNeat7extView>
    {
      e(a.b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "", "(Ljava/lang/String;I)V", "TOP", "COMMON", "BOTTOM", "SINGLE", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static enum e
  {
    static
    {
      AppMethodBeat.i(306070);
      NeQ = new e("TOP", 0);
      NeR = new e("COMMON", 1);
      NeS = new e("BOTTOM", 2);
      NeT = new e("SINGLE", 3);
      NeU = new e[] { NeQ, NeR, NeS, NeT };
      AppMethodBeat.o(306070);
    }
    
    private e() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel;", "", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;Landroid/view/ViewGroup;)V", "audioPadding", "getAudioPadding", "()I", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "imageDefaultRes", "getImageDefaultRes", "imageIv", "Landroid/widget/ImageView;", "getImageIv", "()Landroid/widget/ImageView;", "imageIv$delegate", "imageRadiusInfo", "Lcom/tencent/mm/plugin/profile/ui/tab/list/ImageRadiusInfo;", "getImageRadiusInfo", "()Lcom/tencent/mm/plugin/profile/ui/tab/list/ImageRadiusInfo;", "value", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "item", "getItem", "()Landroid/view/ViewGroup;", "item$delegate", "getItemShowType", "largePading", "getLargePading", "listPadding", "getListPadding", "normalPading", "getNormalPading", "getSlotType", "()Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "smallPadding", "getSmallPadding", "dpToPixel", "", "getDpToPixel", "(F)F", "resFromRaw", "getResFromRaw", "(I)F", "resToPixel", "getResToPixel", "(I)I", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "isPayMsg", "url", "scene", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static class f
  {
    private final j ATU;
    private final int NeJ;
    final a.e NeV;
    private final j NeW;
    private final j NeX;
    private final int NeY;
    private final int NeZ;
    private final int Nfa;
    private final int Nfb;
    private final int Nfc;
    private final c Nfd;
    String imageUrl;
    private final int nQm;
    
    public f(int paramInt, a.e parame, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(306071);
      this.nQm = paramInt;
      this.NeV = parame;
      this.NeW = k.cm((kotlin.g.a.a)new e(this, paramViewGroup));
      this.NeX = k.cm((kotlin.g.a.a)new c(this));
      this.ATU = k.cm((kotlin.g.a.a)new b(this));
      this.NeY = ((int)cT(36.0F));
      paramInt = R.f.ListPadding;
      this.NeZ = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      paramInt = R.f.NormalPadding;
      this.Nfa = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      paramInt = R.f.LargePadding;
      this.Nfb = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      paramInt = R.f.SmallPadding;
      this.Nfc = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      this.Nfd = new c(0.0F, false, false);
      this.NeJ = R.e.chatting_item_biz_default_bg;
      this.imageUrl = "";
      AppMethodBeat.o(306071);
    }
    
    protected static float cT(float paramFloat)
    {
      AppMethodBeat.i(306094);
      float f = MMApplicationContext.getResources().getDisplayMetrics().density;
      AppMethodBeat.o(306094);
      return f * paramFloat + 0.5F;
    }
    
    private final ImageView gDf()
    {
      AppMethodBeat.i(306078);
      ImageView localImageView = (ImageView)this.NeX.getValue();
      AppMethodBeat.o(306078);
      return localImageView;
    }
    
    protected void a(View paramView, a.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(306140);
      kotlin.g.b.s.u(paramView, "container");
      kotlin.g.b.s.u(parame, "slotType");
      int i;
      switch (a.$EnumSwitchMapping$0[parame.ordinal()])
      {
      default: 
        AppMethodBeat.o(306140);
        return;
      case 1: 
        paramView.setPadding(this.Nfb, this.Nfc, this.Nfb, 0);
        if (paramBoolean) {}
        for (i = R.g.fmL;; i = R.g.fmK)
        {
          paramView.setBackgroundResource(i);
          AppMethodBeat.o(306140);
          return;
        }
      case 2: 
        paramView.setPadding(this.Nfb, this.Nfc, this.Nfb, 0);
        i = R.g.fmH;
      }
      for (;;)
      {
        paramView.setBackgroundResource(i);
        break;
        paramView.setPadding(this.Nfb, this.Nfc, this.Nfb, this.Nfb);
        i = R.g.fmG;
        continue;
        paramView.setPadding(this.Nfb, this.Nfc, this.Nfb, this.Nfc);
        if (paramBoolean) {
          i = R.g.fmJ;
        } else {
          i = R.g.fmI;
        }
      }
    }
    
    protected final void a(MMNeat7extView paramMMNeat7extView, String paramString1, int paramInt1, String paramString2, int paramInt2)
    {
      boolean bool = true;
      AppMethodBeat.i(306148);
      kotlin.g.b.s.u(paramMMNeat7extView, "neatText");
      kotlin.g.b.s.u(paramString1, "text");
      paramString1 = com.tencent.mm.pluginsdk.ui.span.p.b(paramMMNeat7extView.getContext(), (CharSequence)paramString1);
      if ((this.nQm == 0) && (paramInt1 == 1)) {}
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.model.b localb = com.tencent.mm.plugin.brandservice.model.b.vBC;
        kotlin.g.b.s.s(paramString1, "text");
        localb.a((CharSequence)paramString1, paramMMNeat7extView, bool, paramString2, paramInt2);
        paramMMNeat7extView.setOnTouchListener((View.OnTouchListener)new l((NeatTextView)paramMMNeat7extView, (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s(paramMMNeat7extView.getContext())));
        AppMethodBeat.o(306148);
        return;
        bool = false;
      }
    }
    
    protected ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(306113);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramViewGroup, "container");
      paramContext = new q();
      AppMethodBeat.o(306113);
      throw paramContext;
    }
    
    protected void gCZ() {}
    
    protected c gDa()
    {
      return this.Nfd;
    }
    
    protected int gDb()
    {
      return this.NeJ;
    }
    
    public final ViewGroup gDe()
    {
      AppMethodBeat.i(306107);
      ViewGroup localViewGroup = (ViewGroup)this.NeW.getValue();
      AppMethodBeat.o(306107);
      return localViewGroup;
    }
    
    protected final int gDg()
    {
      return this.NeY;
    }
    
    protected final int gDh()
    {
      return this.Nfa;
    }
    
    protected final int gDi()
    {
      return this.Nfb;
    }
    
    protected void gDj() {}
    
    protected final Context getContext()
    {
      AppMethodBeat.i(306119);
      Context localContext = (Context)this.ATU.getValue();
      AppMethodBeat.o(306119);
      return localContext;
    }
    
    public final int getItemShowType()
    {
      return this.nQm;
    }
    
    public final void setImageUrl(String paramString)
    {
      AppMethodBeat.i(306162);
      kotlin.g.b.s.u(paramString, "value");
      if (kotlin.n.n.bp((CharSequence)paramString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(306162);
        return;
      }
      paramString = com.tencent.mm.api.b.U(paramString, 2);
      kotlin.g.b.s.s(paramString, "getUrl(value, BizImageStrategy.SCENE_BIZ_PROFILE)");
      this.imageUrl = paramString;
      paramString = a.NeA;
      Log.v(a.access$getTAG$cp(), kotlin.g.b.s.X("imageUrl:", this.imageUrl));
      paramString = this.imageUrl;
      Object localObject = new c.a();
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).oKG = String.valueOf(gDa().gDv());
      ((c.a)localObject).oKE = gDb();
      ((c.a)localObject).oKJ = true;
      ((c.a)localObject).oKe = ((com.tencent.mm.modelimage.loader.b.c)new com.tencent.mm.pluginsdk.ui.applet.n(3));
      ((c.a)localObject).oKN = ((com.tencent.mm.modelimage.loader.b.a)new com.tencent.mm.pluginsdk.ui.applet.e(3));
      ((c.a)localObject).fullPath = y.bpF(this.imageUrl);
      localObject = ((c.a)localObject).bKx();
      com.tencent.mm.pluginsdk.ui.applet.m localm = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, (m.a)new d(this));
      com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
      com.tencent.mm.plugin.bizui.a.a.a((View)gDf(), gDa().radius, gDa().NfQ, gDa().NfR);
      com.tencent.mm.modelimage.r.bKe().a(paramString, gDf(), (com.tencent.mm.modelimage.loader.a.c)localObject, (com.tencent.mm.modelimage.loader.b.h)localm);
      AppMethodBeat.o(306162);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<Context>
    {
      b(a.f paramf)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ImageView>
    {
      c(a.f paramf)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel$imageUrl$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      implements m.a
    {
      d(a.f paramf) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(306189);
        a.c localc = a.NeA;
        Log.v(a.access$getTAG$cp(), kotlin.g.b.s.X("imageUrl onFinish:", this.Nfe.imageUrl));
        this.Nfe.gCZ();
        AppMethodBeat.o(306189);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(306199);
        a.c localc = a.NeA;
        Log.v(a.access$getTAG$cp(), kotlin.g.b.s.X("imageUrl onStart:", this.Nfe.imageUrl));
        this.Nfe.gDj();
        AppMethodBeat.o(306199);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ViewGroup>
    {
      e(a.f paramf, ViewGroup paramViewGroup)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$TopSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;Landroid/view/ViewGroup;)V", "collapseTextLayout", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "getCollapseTextLayout", "()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "collapseTextLayout$delegate", "Lkotlin/Lazy;", "descMask", "Landroid/view/View;", "getDescMask", "()Landroid/view/View;", "descMask$delegate", "digestTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigestTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "digestTv$delegate", "value", "", "hasAudioDesc", "getHasAudioDesc", "()Z", "setHasAudioDesc", "(Z)V", "hasDesc", "setHasDesc", "hasSingleInfo", "hasTitle", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusInfo", "Lcom/tencent/mm/plugin/profile/ui/tab/list/ImageRadiusInfo;", "getImageRadiusInfo", "()Lcom/tencent/mm/plugin/profile/ui/tab/list/ImageRadiusInfo;", "isPayMsg", "setPayMsg", "(I)V", "isSingleImage", "picCntTv", "Landroid/widget/TextView;", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "singleDescLayout", "getSingleDescLayout", "singleDescLayout$delegate", "singleTitleTv", "getSingleTitleTv", "singleTitleTv$delegate", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleDescViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "titleTv", "getTitleTv", "titleTv$delegate", "topMask", "Landroid/widget/ImageView;", "getTopMask", "()Landroid/widget/ImageView;", "topMask$delegate", "url", "getUrl", "setUrl", "videPlayImg", "getVidePlayImg", "videPlayImg$delegate", "videoDurationTv", "getVideoDurationTv", "videoDurationTv$delegate", "voiceDurationTv", "getVoiceDurationTv", "voiceDurationTv$delegate", "fillBackground", "", "selector", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "onImageLoadStart", "setText", "id", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "text", "setTitleDescTextColor", "color", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class g
    extends a.f
  {
    private final j NeM;
    private final j NeN;
    int NeO;
    private boolean Nfg;
    boolean Nfh;
    boolean Nfi;
    ArrayList<View> Nfj;
    private final j Nfk;
    private final j Nfl;
    private final j Nfm;
    private final j Nfn;
    private final j Nfo;
    private final j Nfp;
    private final j Nfq;
    final j Nfr;
    private final j Nfs;
    private boolean Nft;
    private String title;
    String url;
    private final j vOl;
    
    public g(final int paramInt, a.e parame, ViewGroup paramViewGroup)
    {
      super(parame, paramViewGroup);
      AppMethodBeat.i(306091);
      this.url = "";
      this.Nfj = new ArrayList();
      this.Nfk = k.cm((kotlin.g.a.a)new l(this));
      this.Nfl = k.cm((kotlin.g.a.a)new b(this));
      this.NeN = k.cm((kotlin.g.a.a)new h(this));
      this.Nfm = k.cm((kotlin.g.a.a)new n(this));
      this.Nfn = k.cm((kotlin.g.a.a)new o(this));
      this.NeM = k.cm((kotlin.g.a.a)new e(this));
      this.vOl = k.cm((kotlin.g.a.a)new k(this, paramInt));
      this.Nfo = k.cm((kotlin.g.a.a)new m(this));
      this.Nfp = k.cm((kotlin.g.a.a)new i(this));
      this.Nfq = k.cm((kotlin.g.a.a)new j(this));
      this.Nfr = k.cm((kotlin.g.a.a)new c(this));
      this.Nfs = k.cm((kotlin.g.a.a)new a(this));
      this.title = "";
      AppMethodBeat.o(306091);
    }
    
    private final boolean gDl()
    {
      return (this.NeV == a.e.NeT) && (!this.Nfi);
    }
    
    private final ImageView gDm()
    {
      AppMethodBeat.i(306116);
      ImageView localImageView = (ImageView)this.Nfk.getValue();
      AppMethodBeat.o(306116);
      return localImageView;
    }
    
    private final MMNeat7extView gDp()
    {
      AppMethodBeat.i(306126);
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.vOl.getValue();
      AppMethodBeat.o(306126);
      return localMMNeat7extView;
    }
    
    private final ImageView gDq()
    {
      AppMethodBeat.i(306136);
      ImageView localImageView = (ImageView)this.Nfo.getValue();
      AppMethodBeat.o(306136);
      return localImageView;
    }
    
    private MMCollapsibleTextView gDs()
    {
      AppMethodBeat.i(306151);
      MMCollapsibleTextView localMMCollapsibleTextView = (MMCollapsibleTextView)this.Nfs.getValue();
      AppMethodBeat.o(306151);
      return localMMCollapsibleTextView;
    }
    
    public final void AI(boolean paramBoolean)
    {
      AppMethodBeat.i(306252);
      if (!paramBoolean) {
        gDr().setPadding(0, 0, 0, gDg());
      }
      for (;;)
      {
        this.Nft = paramBoolean;
        AppMethodBeat.o(306252);
        return;
        gDr().setPadding(gDi(), gDh(), gDi(), gDg());
      }
    }
    
    public final void a(int paramInt, HashSet<Integer> paramHashSet, String paramString)
    {
      AppMethodBeat.i(306274);
      kotlin.g.b.s.u(paramHashSet, "expandSet");
      kotlin.g.b.s.u(paramString, "text");
      paramString = com.tencent.mm.pluginsdk.ui.span.p.j(gDs().getContext(), (CharSequence)paramString, (int)gDs().getTextSize());
      gDs().setContentDescription((CharSequence)paramString);
      MMCollapsibleTextView localMMCollapsibleTextView = gDs();
      if (!paramHashSet.contains(Integer.valueOf(paramInt))) {}
      for (boolean bool = true;; bool = false)
      {
        localMMCollapsibleTextView.setCollapsed(bool);
        localMMCollapsibleTextView = gDs();
        kotlin.g.b.s.s(paramString, "text");
        localMMCollapsibleTextView.setText((CharSequence)paramString);
        if ((gDs().getContentText() instanceof MMNeat7extView))
        {
          paramString = (MMNeat7extView)gDs().getContentText();
          gDs().setOnTextTouchListener((View.OnTouchListener)new l((NeatTextView)paramString, (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s(paramString.getContext())));
        }
        gDs().setOnCollapse((kotlin.g.a.a)new a.g.f(paramHashSet, paramInt));
        gDs().setOnExpand((kotlin.g.a.a)new a.g.g(paramHashSet, paramInt));
        AppMethodBeat.o(306274);
        return;
      }
    }
    
    protected final void a(View paramView, a.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(306173);
      kotlin.g.b.s.u(paramView, "container");
      kotlin.g.b.s.u(parame, "slotType");
      switch (getItemShowType())
      {
      case 8: 
      case 9: 
      default: 
        paramView.setPadding(0, 0, 0, 0);
        paramView.setBackgroundResource(0);
        AppMethodBeat.o(306173);
        return;
      case 6: 
      case 7: 
        if (parame == a.e.NeQ) {
          paramView.findViewById(R.h.fuy).setVisibility(0);
        }
        super.a(paramView, parame, false);
        paramView.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(306173);
        return;
      }
      super.a(paramView, parame, false);
      AppMethodBeat.o(306173);
    }
    
    final void afX(int paramInt)
    {
      AppMethodBeat.i(306287);
      Iterator localIterator = ((Iterable)this.Nfj).iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if ((localView instanceof TextView)) {
          ((TextView)localView).setTextColor(paramInt);
        } else if ((localView instanceof MMNeat7extView)) {
          ((MMNeat7extView)localView).setTextColor(paramInt);
        }
      }
      AppMethodBeat.o(306287);
    }
    
    protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(306164);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramViewGroup, "container");
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ghV, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(306164);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      int i;
      switch (getItemShowType())
      {
      case 9: 
      default: 
        i = R.h.fBP;
      }
      for (;;)
      {
        ((ViewStub)paramContext.findViewById(i)).inflate();
        paramViewGroup.addView((View)paramContext);
        AppMethodBeat.o(306164);
        return paramContext;
        i = R.h.fBS;
        continue;
        i = R.h.fBQ;
        gDk();
        ah localah = ah.aiuX;
        continue;
        i = R.h.fBR;
        continue;
        i = R.h.fBO;
      }
    }
    
    protected final void gCZ()
    {
      AppMethodBeat.i(306283);
      afX(getContext().getResources().getColor(R.e.white_text_color));
      Object localObject;
      if (this.Nfg)
      {
        localObject = (View)this.Nfl.getValue();
        if (!gDl()) {
          break label104;
        }
        if (this.Nfh)
        {
          i = R.g.foR;
          ((View)localObject).setBackgroundResource(i);
        }
      }
      else
      {
        localObject = gDm();
        if (this.NeV != a.e.NeQ) {
          break label125;
        }
      }
      label104:
      label125:
      for (int i = R.g.fmM;; i = R.g.fmN)
      {
        ((ImageView)localObject).setBackgroundResource(i);
        AppMethodBeat.o(306283);
        return;
        i = R.g.foQ;
        break;
        if (this.Nfh)
        {
          i = R.g.foP;
          break;
        }
        i = R.g.foO;
        break;
      }
    }
    
    protected final c gDa()
    {
      AppMethodBeat.i(306183);
      if (gDl())
      {
        localc = new c(cT(8.0F), true, true);
        AppMethodBeat.o(306183);
        return localc;
      }
      c localc = new c(cT(8.0F), true, false);
      AppMethodBeat.o(306183);
      return localc;
    }
    
    protected final int gDb()
    {
      AppMethodBeat.i(306192);
      if (gDl())
      {
        i = R.g.foM;
        AppMethodBeat.o(306192);
        return i;
      }
      int i = R.g.foN;
      AppMethodBeat.o(306192);
      return i;
    }
    
    public final TextView gDc()
    {
      AppMethodBeat.i(306236);
      TextView localTextView = (TextView)this.NeM.getValue();
      AppMethodBeat.o(306236);
      return localTextView;
    }
    
    public final TextView gDd()
    {
      AppMethodBeat.i(306213);
      TextView localTextView = (TextView)this.NeN.getValue();
      AppMethodBeat.o(306213);
      return localTextView;
    }
    
    protected final void gDj()
    {
      AppMethodBeat.i(306279);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
      AppMethodBeat.o(306279);
    }
    
    final void gDk()
    {
      int i = 1;
      AppMethodBeat.i(306204);
      this.Nfg = true;
      Object localObject;
      if (getItemShowType() == 5)
      {
        localObject = gDq().getLayoutParams();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
          AppMethodBeat.o(306204);
          throw ((Throwable)localObject);
        }
        localObject = (ConstraintLayout.LayoutParams)localObject;
        if (((ConstraintLayout.LayoutParams)localObject).atV != 0.56F) {
          break label97;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          ((ConstraintLayout.LayoutParams)localObject).atV = 0.56F;
          gDq().setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(306204);
        return;
        label97:
        i = 0;
      }
    }
    
    public final TextView gDn()
    {
      AppMethodBeat.i(306221);
      TextView localTextView = (TextView)this.Nfm.getValue();
      AppMethodBeat.o(306221);
      return localTextView;
    }
    
    public final TextView gDo()
    {
      AppMethodBeat.i(306228);
      TextView localTextView = (TextView)this.Nfn.getValue();
      AppMethodBeat.o(306228);
      return localTextView;
    }
    
    final View gDr()
    {
      AppMethodBeat.i(306245);
      View localView = (View)this.Nfp.getValue();
      AppMethodBeat.o(306245);
      return localView;
    }
    
    public final void setTitle(String paramString)
    {
      int i = 4;
      AppMethodBeat.i(306263);
      kotlin.g.b.s.u(paramString, "value");
      MMNeat7extView localMMNeat7extView;
      int j;
      String str;
      switch (getItemShowType())
      {
      default: 
        if (this.NeV == a.e.NeT)
        {
          localMMNeat7extView = (MMNeat7extView)this.Nfq.getValue();
          kotlin.g.b.s.s(localMMNeat7extView, "if (slotType == SlotType…ingleTitleTv else titleTv");
          j = this.NeO;
          str = this.url;
          if (this.NeV != a.e.NeT) {
            break label188;
          }
        }
        break;
      }
      for (;;)
      {
        a(localMMNeat7extView, paramString, j, str, i);
        AppMethodBeat.o(306263);
        return;
        localMMNeat7extView = gDp();
        kotlin.g.b.s.s(localMMNeat7extView, "titleTv");
        a(localMMNeat7extView, paramString, this.NeO, this.url, 4);
        paramString = gDm();
        if (this.NeV == a.e.NeQ) {}
        for (i = R.g.fmN;; i = R.g.fmM)
        {
          paramString.setBackgroundResource(i);
          AppMethodBeat.o(306263);
          return;
        }
        localMMNeat7extView = gDp();
        break;
        label188:
        i = 41;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<MMCollapsibleTextView>
    {
      a(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<View>
    {
      b(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.a<MMNeat7extView>
    {
      c(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      d(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends kotlin.g.b.u
      implements kotlin.g.a.a<TextView>
    {
      e(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class h
      extends kotlin.g.b.u
      implements kotlin.g.a.a<TextView>
    {
      h(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class i
      extends kotlin.g.b.u
      implements kotlin.g.a.a<View>
    {
      i(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class j
      extends kotlin.g.b.u
      implements kotlin.g.a.a<MMNeat7extView>
    {
      j(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class k
      extends kotlin.g.b.u
      implements kotlin.g.a.a<MMNeat7extView>
    {
      k(a.g paramg, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class l
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ImageView>
    {
      l(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class m
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ImageView>
    {
      m(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class n
      extends kotlin.g.b.u
      implements kotlin.g.a.a<TextView>
    {
      n(a.g paramg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class o
      extends kotlin.g.b.u
      implements kotlin.g.a.a<TextView>
    {
      o(a.g paramg)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isBizPayOpen", "", "()Z", "setBizPayOpen", "(Z)V", "widget", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "dealMsgData", "", "interpolator", "bizMsg", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "position", "fillCommonSlot", "container", "Landroid/view/ViewGroup;", "detail", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "base", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "fillSingleText", "text", "Lcom/tencent/mm/protocal/protobuf/BizTextMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/CommMsgBaseInfo;", "fillSlotTarget", "fillTopSlot", "commBase", "getPlayId", "", "isPlaying", "playId", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class i
    extends RecyclerView.v
  {
    private boolean NeG;
    private HashSet<Integer> NeH;
    private a Nfx;
    private Context context;
    
    public i(View paramView)
    {
      super();
      AppMethodBeat.i(306041);
      this.NeH = new HashSet();
      this.NeG = true;
      AppMethodBeat.o(306041);
    }
    
    private static String N(String[] paramArrayOfString)
    {
      AppMethodBeat.i(306058);
      int k = paramArrayOfString.length;
      int i = 0;
      String str;
      int j;
      if (i < k)
      {
        str = paramArrayOfString[i];
        CharSequence localCharSequence = (CharSequence)str;
        if ((localCharSequence == null) || (kotlin.n.n.bp(localCharSequence)))
        {
          j = 1;
          label42:
          if (j != 0) {
            break label72;
          }
          j = 1;
          label48:
          if (j == 0) {
            break label77;
          }
        }
      }
      for (paramArrayOfString = str;; paramArrayOfString = null)
      {
        if (paramArrayOfString != null) {
          break label89;
        }
        AppMethodBeat.o(306058);
        return "";
        j = 0;
        break label42;
        label72:
        j = 0;
        break label48;
        label77:
        i += 1;
        break;
      }
      label89:
      AppMethodBeat.o(306058);
      return paramArrayOfString;
    }
    
    private static String a(od paramod)
    {
      AppMethodBeat.i(306085);
      paramod = paramod.YQK;
      kotlin.g.b.s.s(paramod, "detail.ContentUrl");
      paramod = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajk(paramod);
      AppMethodBeat.o(306085);
      return paramod;
    }
    
    private final void a(View paramView, od paramod, oc paramoc, int paramInt)
    {
      AppMethodBeat.i(306068);
      Object localObject;
      if (paramod.nUA == 7)
      {
        localObject = (ImageView)paramView.findViewById(R.h.fuC);
        if (localObject != null)
        {
          String str = a(paramod);
          if (!jb(str)) {
            break label90;
          }
          s((ImageView)localObject);
          ((ImageView)localObject).setOnClickListener(new a.i..ExternalSyntheticLambda0((ImageView)localObject, str, paramod));
        }
      }
      for (;;)
      {
        paramView.setOnClickListener(new a.i..ExternalSyntheticLambda1(paramod, this, paramoc, paramView, paramInt));
        AppMethodBeat.o(306068);
        return;
        label90:
        ((ImageView)localObject).setImageResource(R.g.biz_time_line_item_voice_play_selector);
        break;
        if (paramod.nUA == 5)
        {
          localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(paramod.YQK, paramod.nUA, "");
        }
      }
    }
    
    private final void a(ViewGroup paramViewGroup, od paramod, oc paramoc, a.e parame, int paramInt)
    {
      AppMethodBeat.i(306052);
      a.c localc = a.NeA;
      Log.v(a.access$getTAG$cp(), kotlin.g.b.s.X("fillCommonSlot:", paramod.YQK));
      paramViewGroup = new a.b(paramod.nUA, parame, paramViewGroup);
      paramViewGroup.NeO = paramod.YRg;
      paramViewGroup.url = paramod.YQK;
      parame = paramod.hAP;
      kotlin.g.b.s.s(parame, "detail.Title");
      paramViewGroup.setTitle(parame);
      parame = (CharSequence)paramod.YQZ;
      if ((parame == null) || (kotlin.n.n.bp(parame)))
      {
        i = 1;
        if (i == 0) {
          paramViewGroup.gDd().setText((CharSequence)paramod.YQZ);
        }
        parame = paramViewGroup.gDd();
        if (parame != null) {
          if ((paramViewGroup.NeO != 1) || (this.NeG)) {
            break label241;
          }
        }
      }
      label241:
      for (int i = 4;; i = 0)
      {
        parame.setVisibility(i);
        if ((paramod.nUA == 8) && (paramod.KyM > 1)) {
          paramViewGroup.gDc().setText((CharSequence)String.valueOf(paramod.KyM));
        }
        paramViewGroup.setImageUrl(N(new String[] { paramod.YQN, paramod.YQM }));
        a((View)paramViewGroup.gDe(), paramod, paramoc, paramInt);
        AppMethodBeat.o(306052);
        return;
        i = 0;
        break;
      }
    }
    
    private static final void a(ImageView paramImageView, String paramString, od paramod, View paramView)
    {
      AppMethodBeat.i(306105);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramImageView);
      localb.cH(paramString);
      localb.cH(paramod);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramImageView, "$this_apply");
      kotlin.g.b.s.u(paramString, "$playId");
      kotlin.g.b.s.u(paramod, "$detail");
      s(paramImageView);
      paramImageView = new e.g();
      localObject = new e.h();
      ((e.h)localObject).XmC = paramString;
      ((e.h)localObject).url = paramod.YQK;
      ((e.h)localObject).title = paramod.hAP;
      ((e.h)localObject).nVa = "";
      ((e.h)localObject).playUrl = paramod.YQU;
      ((e.h)localObject).coverUrl = paramod.YQM;
      paramString = ah.aiuX;
      paramImageView.aeOL = ((e.h)localObject);
      paramString = ah.aiuX;
      paramView.setTag(paramImageView);
      com.tencent.mm.ui.chatting.u.li(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(306105);
    }
    
    private static final void a(od paramod, i parami, oc paramoc, View paramView1, int paramInt, View paramView2)
    {
      AppMethodBeat.i(306129);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramod);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parami);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramoc);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      kotlin.g.b.s.u(paramod, "$detail");
      kotlin.g.b.s.u(parami, "this$0");
      kotlin.g.b.s.u(paramoc, "$base");
      kotlin.g.b.s.u(paramView1, "$container");
      paramView2 = a.NeA;
      Log.i(a.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { paramod.YQK });
      if (parami.Nfx == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(306129);
        return;
      }
      if (!Util.isNullOrNil(paramod.YRk))
      {
        paramView2 = XmlParser.parseXml(paramod.YRk, "finder_feed", null);
        if (paramView2 != null)
        {
          localObject1 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(5, 2, 25, null);
          if (((br)com.tencent.mm.kernel.h.ax(br.class)).a(parami.context, "", paramView2, (String)localObject1))
          {
            paramod = a.NeA;
            Log.i(a.access$getTAG$cp(), "profile open finder success!");
            com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(306129);
            return;
          }
        }
      }
      localObject1 = new Intent();
      localObject2 = com.tencent.mm.message.m.e(paramod.YQK, 126, -1, (int)(System.currentTimeMillis() / 1000L));
      ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).putExtra("geta8key_scene", 3);
      paramView2 = parami.Nfx;
      kotlin.g.b.s.checkNotNull(paramView2);
      ((Intent)localObject1).putExtra("geta8key_username", paramView2.contact.field_username);
      ((Intent)localObject1).putExtra("webpageTitle", paramod.hAP);
      paramView2 = (CharSequence)paramod.YQN;
      int i;
      label438:
      int j;
      label523:
      int k;
      if ((paramView2 == null) || (kotlin.n.n.bp(paramView2)))
      {
        i = 1;
        if (i == 0) {
          break label1173;
        }
        paramView2 = paramod.YQM;
        ((Intent)localObject1).putExtra("thumbUrl", paramView2);
        paramView2 = ((Intent)localObject1).getStringExtra("prePublishId");
        if (Util.isNullOrNil(paramView2)) {
          break label1182;
        }
        ((Intent)localObject1).putExtra("KPublisherId", paramView2);
        ((Intent)localObject1).putExtra("prePublishId", paramView2);
        ((Intent)localObject1).putExtra("preUsername", ((Intent)localObject1).getStringExtra("preUsername"));
        ((Intent)localObject1).putExtra("preChatName", ((Intent)localObject1).getStringExtra("preChatName"));
        ((Intent)localObject1).putExtra("preChatTYPE", ((Intent)localObject1).getIntExtra("preChatTYPE", 0));
        i = ((Intent)localObject1).getIntExtra("KOpenArticleSceneFromScene", 10000);
        if (paramod.nUA == 5)
        {
          ((Intent)localObject1).putExtra("biz_video_scene", 126);
          ((Intent)localObject1).putExtra(f.b.adwc, i);
          ((Intent)localObject1).putExtra("biz_video_session_id", ad.getSessionId());
          paramView2 = new x();
          paramView2.mso = ((Intent)localObject1).getStringExtra("KPublisherId");
          a locala = parami.Nfx;
          kotlin.g.b.s.checkNotNull(locala);
          paramView2.hEE = locala.contact.field_username;
          locala = parami.Nfx;
          kotlin.g.b.s.checkNotNull(locala);
          paramView2.nUF = locala.contact.aSU();
          paramView2.nUG.url = ((String)localObject2);
          paramView2.nUG.title = paramod.hAP;
          paramView2.nUG.nUO = "detail.videoDigest";
          paramView2.nUG.nUM = paramod.YQM;
          paramView2.nUG.type = paramod.nUA;
          paramView2.nUG.time = paramoc.CreateTime;
          paramView2.nUG.nUQ = paramod.YQY;
          paramView2.nUG.videoWidth = paramod.YQW;
          paramView2.nUG.videoHeight = paramod.YQX;
          paramView2.nUG.vid = paramod.YQV;
          paramView2.w((Intent)localObject1);
          paramView2 = a.NeA;
          Log.i(a.access$getTAG$cp(), "jump to native video");
          paramView2 = new int[2];
          paramView1 = (ImageView)paramView1.findViewById(R.h.fup);
          if (paramView1 != null)
          {
            j = paramView1.getWidth();
            k = paramView1.getHeight();
            paramView1.getLocationInWindow(paramView2);
            ((Intent)localObject1).putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", paramView2[0]).putExtra("img_gallery_top", paramView2[1]);
          }
          ((Intent)localObject1).addFlags(268435456);
        }
        if ((!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(6)) || (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(parami.context, (String)localObject2, paramod.nUA, 126, i, (Intent)localObject1))) {
          break label1209;
        }
        paramView1 = a.NeA;
        Log.i(a.access$getTAG$cp(), "jump to TmplWebview");
      }
      for (;;)
      {
        paramView1 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.NcJ;
        paramView1 = parami.Nfx;
        kotlin.g.b.s.checkNotNull(paramView1);
        paramView1 = paramView1.contact.field_username;
        kotlin.g.b.s.s(paramView1, "widget!!.contact.username");
        paramView2 = parami.Nfx;
        kotlin.g.b.s.checkNotNull(paramView2);
        long l = paramView2.enterTime;
        i = paramoc.YQG;
        j = paramod.YQJ;
        k = paramod.nUA;
        int m = paramoc.CreateTime;
        paramod = parami.Nfx;
        kotlin.g.b.s.checkNotNull(paramod);
        int n = paramod.pUt;
        kotlin.g.b.s.u(paramView1, "userName");
        int i1 = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.NcL;
        com.tencent.mm.plugin.report.service.h.OAn.b(17523, new Object[] { Integer.valueOf(i1), paramView1, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(n) });
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(306129);
        return;
        i = 0;
        break;
        label1173:
        paramView2 = paramod.YQN;
        break label438;
        label1182:
        ((Intent)localObject1).putExtra("prePublishId", "brand_profile");
        ((Intent)localObject1).putExtra("KPublisherId", "brand_profile");
        break label523;
        label1209:
        com.tencent.mm.br.c.b(parami.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
    }
    
    private static boolean jb(String paramString)
    {
      AppMethodBeat.i(306076);
      com.tencent.mm.aw.f localf = com.tencent.mm.aw.a.bLn();
      if (localf == null)
      {
        AppMethodBeat.o(306076);
        return false;
      }
      if ((kotlin.g.b.s.p(localf.oOv, paramString)) && (localf.oOt == 0) && (com.tencent.mm.aw.a.bLk()))
      {
        AppMethodBeat.o(306076);
        return true;
      }
      AppMethodBeat.o(306076);
      return false;
    }
    
    private static final void s(ImageView paramImageView)
    {
      AppMethodBeat.i(306090);
      paramImageView.setImageResource(R.g.biz_time_line_item_voice_playing_selector);
      paramImageView = paramImageView.getDrawable();
      if (paramImageView == null)
      {
        paramImageView = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(306090);
        throw paramImageView;
      }
      ((AnimationDrawable)paramImageView).start();
      AppMethodBeat.o(306090);
    }
    
    public final void a(a parama, px parampx, HashSet<Integer> paramHashSet, int paramInt)
    {
      AppMethodBeat.i(306163);
      kotlin.g.b.s.u(parama, "interpolator");
      kotlin.g.b.s.u(parampx, "bizMsg");
      kotlin.g.b.s.u(paramHashSet, "expandSet");
      this.context = parama.context;
      this.Nfx = parama;
      this.NeH = paramHashSet;
      this.NeG = parama.NeG;
      paramHashSet = this.caK;
      if (paramHashSet == null) {
        paramHashSet = null;
      }
      int i;
      while (kotlin.g.b.s.p(paramHashSet, parampx))
      {
        paramHashSet = parampx.YUh;
        if (paramHashSet != null)
        {
          paramHashSet = paramHashSet.YRm;
          if (paramHashSet != null)
          {
            i = 0;
            paramHashSet = ((Iterable)paramHashSet).iterator();
            for (;;)
            {
              if (paramHashSet.hasNext())
              {
                localObject1 = (od)paramHashSet.next();
                kotlin.g.b.s.s(localObject1, "detail");
                if (kotlin.g.b.s.p(a((od)localObject1), a.a(parama)))
                {
                  a.a(parama, "none");
                  i = 1;
                  continue;
                  paramHashSet = paramHashSet.getTag();
                  break;
                }
              }
            }
            if (i != 1) {}
          }
        }
        for (i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(306163);
          return;
        }
      }
      this.caK.setTag(parampx);
      try
      {
        i = parampx.YUc.IIs;
        switch (i)
        {
        default: 
          AppMethodBeat.o(306163);
          return;
        }
      }
      catch (Exception parama)
      {
        parampx = a.NeA;
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)parama, "", new Object[0]);
      }
      ((ViewGroup)this.caK).removeAllViews();
      paramHashSet = (ViewGroup)this.caK;
      parama = parampx.YUd;
      kotlin.g.b.s.s(parama, "bizMsg.Text");
      Object localObject1 = parampx.YUc;
      kotlin.g.b.s.s(localObject1, "bizMsg.BaseInfo");
      parampx = new a.g(10, a.e.NeT, paramHashSet);
      paramInt = ((aen)localObject1).Njs;
      paramHashSet = this.NeH;
      parama = parama.nUB;
      kotlin.g.b.s.s(parama, "text.Content");
      parampx.a(paramInt, paramHashSet, parama);
      AppMethodBeat.o(306163);
      return;
      AppMethodBeat.o(306163);
      return;
      ((ViewGroup)this.caK).removeAllViews();
      int k = parampx.YUh.YRm.size();
      label404:
      Object localObject2;
      Object localObject3;
      if (k > 1)
      {
        parama = a.e.NeQ;
        if (parampx.YUh.YRl.YQH == 0) {
          break label1559;
        }
        localObject2 = (ViewGroup)this.caK;
        paramHashSet = parampx.YUh.YRm.get(0);
        kotlin.g.b.s.s(paramHashSet, "bizMsg.AppMsg.DetailInfo[0]");
        paramHashSet = (od)paramHashSet;
        localObject1 = parampx.YUh.YRl;
        kotlin.g.b.s.s(localObject1, "bizMsg.AppMsg.BaseInfo");
        localObject3 = parampx.YUc;
        kotlin.g.b.s.s(localObject3, "bizMsg.BaseInfo");
        Object localObject4 = a.NeA;
        Log.v(a.access$getTAG$cp(), kotlin.g.b.s.X("fillTopSlot:", paramHashSet.YQK));
        localObject2 = new a.g(paramHashSet.nUA, parama, (ViewGroup)localObject2);
        localObject4 = ((a.g)localObject2).gDn();
        if (localObject4 != null) {
          ((TextView)localObject4).setContentDescription((CharSequence)"");
        }
        localObject4 = ((a.g)localObject2).gDc();
        if (localObject4 != null) {
          ((TextView)localObject4).setContentDescription((CharSequence)"");
        }
        if ((paramHashSet.nUA != 8) && (paramHashSet.nUA != 10))
        {
          ((a.g)localObject2).NeO = paramHashSet.YRg;
          ((a.g)localObject2).url = paramHashSet.YQK;
          localObject4 = paramHashSet.hAP;
          kotlin.g.b.s.s(localObject4, "detail.Title");
          ((a.g)localObject2).setTitle((String)localObject4);
        }
        if (parama == a.e.NeT)
        {
          parama = (CharSequence)paramHashSet.YQI;
          if (parama == null) {
            break label1634;
          }
          if (!kotlin.n.n.bp(parama)) {
            break label1670;
          }
          break label1634;
          label647:
          if (i == 0) {
            ((MMNeat7extView)((a.g)localObject2).Nfr.getValue()).aZ((CharSequence)paramHashSet.YQI);
          }
        }
        parama = (CharSequence)paramHashSet.YQZ;
        if (parama == null) {
          break label1640;
        }
        if (!kotlin.n.n.bp(parama)) {
          break label1676;
        }
        break label1640;
        label697:
        if (i == 0) {
          ((a.g)localObject2).gDd().setText((CharSequence)paramHashSet.YQZ);
        }
        parama = ((a.g)localObject2).gDd();
        if (parama != null)
        {
          if ((((a.g)localObject2).NeO != 1) || (this.NeG)) {
            break label1682;
          }
          i = 4;
          label746:
          parama.setVisibility(i);
        }
      }
      label788:
      label832:
      label858:
      label867:
      boolean bool;
      switch (paramHashSet.nUA)
      {
      case 6: 
        switch (paramHashSet.nUA)
        {
        case 8: 
        case 9: 
          if (paramHashSet.nUA == 0)
          {
            parama = new String[2];
            parama[0] = paramHashSet.YQO;
            parama[1] = paramHashSet.YQM;
            ((a.g)localObject2).setImageUrl(N(parama));
          }
          break;
        }
      case 5: 
      case 7: 
      case 8: 
        for (;;)
        {
          if (this.context != null)
          {
            parama = ((a.g)localObject2).gDo();
            if (parama != null)
            {
              localObject3 = am.aixg;
              localObject3 = this.context;
              kotlin.g.b.s.checkNotNull(localObject3);
              localObject3 = ((Context)localObject3).getResources().getString(R.l.biz_timeline_msg_voice);
              kotlin.g.b.s.s(localObject3, "context!!.resources.getS…g.biz_timeline_msg_voice)");
              localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { ((a.g)localObject2).gDo().getText() }, 1));
              kotlin.g.b.s.s(localObject3, "java.lang.String.format(format, *args)");
              parama.setContentDescription((CharSequence)localObject3);
            }
            parama = ((a.g)localObject2).gDn();
            if (parama != null)
            {
              localObject3 = am.aixg;
              localObject3 = this.context;
              kotlin.g.b.s.checkNotNull(localObject3);
              localObject3 = ((Context)localObject3).getResources().getString(R.l.biz_timeline_msg_video);
              kotlin.g.b.s.s(localObject3, "context!!.resources.getS…g.biz_timeline_msg_video)");
              localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { ((a.g)localObject2).gDn().getText() }, 1));
              kotlin.g.b.s.s(localObject3, "java.lang.String.format(format, *args)");
              parama.setContentDescription((CharSequence)localObject3);
            }
            if (paramHashSet.KyM <= 1) {
              break label1517;
            }
            parama = ((a.g)localObject2).gDc();
            if (parama != null)
            {
              localObject3 = am.aixg;
              localObject3 = this.context;
              kotlin.g.b.s.checkNotNull(localObject3);
              localObject3 = ((Context)localObject3).getResources().getString(R.l.biz_timeline_msg_img_multi);
              kotlin.g.b.s.s(localObject3, "context!!.resources.getS…z_timeline_msg_img_multi)");
              localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { ((a.g)localObject2).gDc().getText() }, 1));
              kotlin.g.b.s.s(localObject3, "java.lang.String.format(format, *args)");
              parama.setContentDescription((CharSequence)localObject3);
            }
          }
          label1152:
          a((View)((a.g)localObject2).gDe(), paramHashSet, (oc)localObject1, paramInt);
          break label1652;
          for (;;)
          {
            label1172:
            int j = i + 1;
            parama = this.caK;
            kotlin.g.b.s.s(parama, "itemView");
            paramHashSet = (ViewGroup)parama;
            parama = parampx.YUh.YRm.get(i);
            kotlin.g.b.s.s(parama, "bizMsg.AppMsg.DetailInfo[i]");
            localObject1 = (od)parama;
            localObject2 = parampx.YUh.YRl;
            kotlin.g.b.s.s(localObject2, "bizMsg.AppMsg.BaseInfo");
            if (i != k - 1) {
              break label1627;
            }
            parama = a.e.NeS;
            label1250:
            a(paramHashSet, (od)localObject1, (oc)localObject2, parama, paramInt);
            if (j >= k) {
              break;
            }
            i = j;
          }
          parama = a.e.NeT;
          break label404;
          ((a.g)localObject2).gDn().setText((CharSequence)com.tencent.mm.message.m.uD(paramHashSet.YQY));
          break label788;
          ((a.g)localObject2).gDo().setText((CharSequence)com.tencent.mm.message.m.uD(paramHashSet.YQT));
          break label788;
          if (paramHashSet.KyM <= 1) {
            break label788;
          }
          ((a.g)localObject2).gDc().setText((CharSequence)String.valueOf(paramHashSet.KyM));
          break label788;
          parama = (CharSequence)paramHashSet.YQI;
          if (parama == null) {
            break label1688;
          }
          if (!kotlin.n.n.bp(parama)) {
            break label1702;
          }
          break label1688;
          label1376:
          ((a.g)localObject2).AI(bool);
        }
        i = ((aen)localObject3).Njs;
        parama = this.NeH;
        localObject3 = paramHashSet.hAP;
        kotlin.g.b.s.s(localObject3, "detail.Title");
        ((a.g)localObject2).a(i, parama, (String)localObject3);
        parama = (CharSequence)paramHashSet.YQZ;
        if (parama != null) {
          if (!kotlin.n.n.bp(parama)) {
            break label1720;
          }
        }
        break;
      }
      for (;;)
      {
        if (i != 0) {
          break label867;
        }
        ((a.g)localObject2).gDd().setText((CharSequence)paramHashSet.YQZ);
        break label867;
        parama = new String[3];
        parama[0] = paramHashSet.YRi;
        parama[1] = paramHashSet.YQM;
        parama[2] = paramHashSet.YQO;
        break label858;
        parama = new String[2];
        parama[0] = paramHashSet.YQM;
        parama[1] = paramHashSet.YQO;
        break label858;
        label1517:
        parama = ((a.g)localObject2).gDc();
        if (parama == null) {
          break label1152;
        }
        localObject3 = this.context;
        kotlin.g.b.s.checkNotNull(localObject3);
        parama.setContentDescription((CharSequence)((Context)localObject3).getResources().getString(R.l.biz_timeline_msg_img_single));
        break label1152;
        label1559:
        paramHashSet = (ViewGroup)this.caK;
        localObject1 = parampx.YUh.YRm.get(0);
        kotlin.g.b.s.s(localObject1, "bizMsg.AppMsg.DetailInfo[0]");
        localObject1 = (od)localObject1;
        localObject2 = parampx.YUh.YRl;
        kotlin.g.b.s.s(localObject2, "bizMsg.AppMsg.BaseInfo");
        a(paramHashSet, (od)localObject1, (oc)localObject2, parama, paramInt);
        break label1652;
        label1627:
        parama = a.e.NeR;
        break label1250;
        label1634:
        i = 1;
        break label647;
        label1640:
        i = 1;
        break label697;
        break label788;
        break label832;
        label1652:
        if (k <= 1) {
          break;
        }
        i = 1;
        if (1 >= k) {
          break;
        }
        break label1172;
        label1670:
        i = 0;
        break label647;
        label1676:
        i = 0;
        break label697;
        label1682:
        i = 0;
        break label746;
        label1688:
        label1702:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1708;
          }
          bool = true;
          break;
        }
        label1708:
        bool = false;
        break label1376;
        i = 1;
        continue;
        label1720:
        i = 0;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newVideoChannelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "coverSize", "", "inflater", "Landroid/view/LayoutInflater;", "radius", "", "widget", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "dealData", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "fillVideoChannel", "fillVideoItem", "videoItem", "Lcom/tencent/mm/protocal/protobuf/NotifyVideoInfo;", "getDurationText", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends RecyclerView.v
  {
    a Nfx;
    private int Nfy;
    private LayoutInflater pUI;
    private float radius;
    
    public j(View paramView)
    {
      super();
      AppMethodBeat.i(306023);
      this.Nfy = com.tencent.mm.cd.a.fromDPToPix(paramView.getContext(), 64);
      this.radius = 2.0F;
      paramView = LayoutInflater.from(paramView.getContext());
      kotlin.g.b.s.s(paramView, "from(itemView.context)");
      this.pUI = paramView;
      AppMethodBeat.o(306023);
    }
    
    private static final void a(j paramj, ehk paramehk, View paramView)
    {
      AppMethodBeat.i(306035);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramj);
      localb.cH(paramehk);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newVideoChannelViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramj, "this$0");
      kotlin.g.b.s.u(paramehk, "$videoInfo");
      if (paramj.Nfx != null)
      {
        paramView = (CharSequence)paramehk.jump_url;
        if ((paramView != null) && (paramView.length() != 0)) {
          break label249;
        }
      }
      label249:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          kotlin.g.b.s.checkNotNull(paramj.Nfx);
          paramView = new Intent();
          paramView.putExtra("rawUrl", paramehk.jump_url);
          paramehk = paramj.Nfx;
          kotlin.g.b.s.checkNotNull(paramehk);
          paramView.putExtra("geta8key_username", paramehk.contact.field_username);
          com.tencent.mm.br.c.b(paramj.caK.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          paramehk = paramj.Nfx;
          kotlin.g.b.s.checkNotNull(paramehk);
          paramehk = paramehk.contact.field_username;
          localObject = paramj.Nfx;
          kotlin.g.b.s.checkNotNull(localObject);
          i = ((a)localObject).pUt;
          paramj = paramj.Nfx;
          kotlin.g.b.s.checkNotNull(paramj);
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramehk, 1402, i, paramj.enterTime, paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newVideoChannelViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(306035);
        return;
      }
    }
    
    final void a(ehk paramehk)
    {
      AppMethodBeat.i(306065);
      Object localObject2 = (TextView)this.caK.findViewById(R.h.gbC);
      Object localObject1 = (CharSequence)paramehk.abmG;
      int i;
      label59:
      label117:
      Object localObject3;
      label130:
      label208:
      Object localObject4;
      Object localObject5;
      int j;
      int k;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label656;
        }
        localObject1 = (CharSequence)paramehk.abmG;
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
        com.tencent.mm.plugin.brandservice.ui.b.e.l((TextView)localObject2);
        localObject2 = (TextView)this.caK.findViewById(R.h.gbB);
        localObject1 = (CharSequence)paramehk.wording;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label678;
        }
        i = 1;
        if (i != 0) {
          break label683;
        }
        localObject1 = (CharSequence)paramehk.wording;
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = paramehk.abmF;
        localObject2 = a.NeA;
        Log.v(a.access$getTAG$cp(), "alvinluo fillVideoChannel size: %d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
        localObject2 = (LinearLayout)this.caK.findViewById(R.h.gbr);
        ((LinearLayout)localObject2).removeAllViews();
        if (localObject1 == null) {
          break label752;
        }
        Iterator localIterator = ((Iterable)localObject1).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = (duv)localIterator.next();
        } while (localObject3 == null);
        localObject1 = a.NeA;
        Log.d(a.access$getTAG$cp(), "alvinluo videoItem url: %s, duration: %d", new Object[] { ((duv)localObject3).vPS, Integer.valueOf(((duv)localObject3).duration) });
        localObject4 = this.pUI.inflate(R.i.gic, null, false);
        ((LinearLayout)localObject2).addView((View)localObject4);
        kotlin.g.b.s.s(localObject4, "itemView");
        localObject5 = (TextView)((View)localObject4).findViewById(R.h.video_duration);
        i = ((duv)localObject3).duration / 3600;
        j = (((duv)localObject3).duration - i * 3600) / 60;
        k = ((duv)localObject3).duration % 60;
        localObject1 = a.NeA;
        Log.i(a.access$getTAG$cp(), "alvinluo getDurationText " + i + ':' + j + ':' + k);
        if (i <= 0) {
          break label705;
        }
        localObject1 = am.aixg;
        localObject1 = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }, 3));
        kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
      }
      for (;;)
      {
        ((TextView)localObject5).setText((CharSequence)localObject1);
        localObject1 = (ImageView)((View)localObject4).findViewById(R.h.gbv);
        localObject3 = com.tencent.mm.api.b.U(((duv)localObject3).vPS, 2);
        localObject4 = new c.a();
        ((c.a)localObject4).oKp = true;
        localObject4 = ((c.a)localObject4).eG(this.Nfy, this.Nfy);
        ((c.a)localObject4).oKG = kotlin.g.b.s.X("radius_", Float.valueOf(this.radius));
        ((c.a)localObject4).oKE = R.g.foL;
        ((c.a)localObject4).oKe = ((com.tencent.mm.modelimage.loader.b.c)new com.tencent.mm.pluginsdk.ui.applet.n(3));
        ((c.a)localObject4).oKN = ((com.tencent.mm.modelimage.loader.b.a)new com.tencent.mm.pluginsdk.ui.applet.e(3));
        ((c.a)localObject4).fullPath = y.bpF((String)localObject3);
        localObject4 = ((c.a)localObject4).bKx();
        localObject5 = new a((String)localObject3, (ImageView)localObject1);
        localObject5 = new com.tencent.mm.pluginsdk.ui.applet.m(3, this.Nfy, this.Nfy, true, true, this.radius, (m.a)localObject5);
        com.tencent.mm.modelimage.r.bKe().a((String)localObject3, (ImageView)localObject1, (com.tencent.mm.modelimage.loader.a.c)localObject4, (com.tencent.mm.modelimage.loader.b.h)localObject5);
        break label208;
        i = 0;
        break;
        label656:
        localObject1 = (CharSequence)((TextView)localObject2).getContext().getResources().getString(R.l.biz_video_channel_entry_title);
        break label59;
        label678:
        i = 0;
        break label117;
        label683:
        localObject1 = (CharSequence)((TextView)localObject2).getContext().getResources().getString(R.l.biz_video_channel_entry_sub_title);
        break label130;
        label705:
        localObject1 = am.aixg;
        localObject1 = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(j), Integer.valueOf(k) }, 2));
        kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
      }
      label752:
      localObject1 = this.caK.findViewById(R.h.root_layout);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new a.j..ExternalSyntheticLambda0(this, paramehk));
      }
      AppMethodBeat.o(306065);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newVideoChannelViewHolder$fillVideoItem$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements m.a
    {
      a(String paramString, ImageView paramImageView) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(306185);
        a.c localc = a.NeA;
        Log.v(a.access$getTAG$cp(), kotlin.g.b.s.X("imageUrl onFinish:", this.CXb));
        this.Nfz.setBackgroundResource(R.g.mm_trans);
        AppMethodBeat.o(306185);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(306188);
        a.c localc = a.NeA;
        Log.v(a.access$getTAG$cp(), kotlin.g.b.s.X("imageUrl onStart:", this.CXb));
        AppMethodBeat.o(306188);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.a
 * JD-Core Version:    0.7.0.1
 */