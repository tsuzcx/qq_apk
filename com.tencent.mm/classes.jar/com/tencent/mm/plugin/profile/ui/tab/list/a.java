package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.dda;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "addContactScene", "", "contact", "Lcom/tencent/mm/storage/Contact;", "enterTime", "", "(Landroid/content/Context;ILcom/tencent/mm/storage/Contact;J)V", "getAddContactScene", "()I", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "changedPlayId", "", "getContact", "()Lcom/tencent/mm/storage/Contact;", "getContext", "()Landroid/content/Context;", "getEnterTime", "()J", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getExpandSet", "()Ljava/util/HashSet;", "isBizPayOpen", "", "()Z", "messageHandler", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "onLoadMore", "Lkotlin/Function0;", "", "getOnLoadMore", "()Lkotlin/jvm/functions/Function0;", "setOnLoadMore", "(Lkotlin/jvm/functions/Function0;)V", "originalCount", "getOriginalCount", "setOriginalCount", "(I)V", "getFooterCount", "getItemCount", "getItemId", "position", "getItemViewType", "getMsgPosition", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onMusicStateChanged", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "update", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "notifyInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "BizDateViewHolder", "BizMsgViewHolder", "CommonSlotViewModel", "Companion", "LoadingViewHolder", "SlotType", "SlotViewModel", "TopSlotViewModel", "VideoChannelViewHolder", "ViewHolder", "newBizMsgViewHolder", "newVideoChannelViewHolder", "app_release"})
public final class a
  extends RecyclerView.a<RecyclerView.v>
{
  public static final a.c Hhq;
  private static final String TAG = "MicroMsg.NewBizInfoAdapter";
  private String HeI;
  private int HeJ;
  private final kotlin.f HeK;
  final boolean HeL;
  private final HashSet<Integer> HeM;
  private final com.tencent.mm.plugin.profile.ui.newbizinfo.b.a Hho;
  kotlin.g.a.a<kotlin.x> Hhp;
  final as contact;
  final Context context;
  final long enterTime;
  final int mXL;
  
  static
  {
    AppMethodBeat.i(264073);
    Hhq = new a.c((byte)0);
    TAG = "MicroMsg.NewBizInfoAdapter";
    AppMethodBeat.o(264073);
  }
  
  public a(Context paramContext, as paramas, long paramLong)
  {
    AppMethodBeat.i(264072);
    this.context = paramContext;
    this.mXL = 0;
    this.contact = paramas;
    this.enterTime = paramLong;
    this.Hho = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.a();
    com.tencent.mm.plugin.brandservice.b.d.init();
    this.HeI = "none";
    this.HeK = g.ar((kotlin.g.a.a)a.h.HhC);
    paramContext = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
    p.j(paramContext, "MMKernel.service(IBrandService::class.java)");
    this.HeL = ((com.tencent.mm.plugin.brandservice.a.c)paramContext).cyB();
    this.HeM = new HashSet();
    AppMethodBeat.o(264072);
  }
  
  private int abJ(int paramInt)
  {
    return paramInt - this.HeJ + 0;
  }
  
  private final com.tencent.mm.plugin.brandservice.a.c fra()
  {
    AppMethodBeat.i(264068);
    com.tencent.mm.plugin.brandservice.a.c localc = (com.tencent.mm.plugin.brandservice.a.c)this.HeK.getValue();
    AppMethodBeat.o(264068);
    return localc;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(264070);
    p.k(paramViewGroup, "parent");
    if (paramInt == com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b.HeE.ordinal())
    {
      paramViewGroup = LayoutInflater.from(this.context).inflate(R.i.efa, paramViewGroup, false);
      p.j(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new a.d(paramViewGroup);
      AppMethodBeat.o(264070);
      return paramViewGroup;
    }
    if (paramInt == com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b.HeD.ordinal())
    {
      paramViewGroup = LayoutInflater.from(this.context).inflate(R.i.eeX, paramViewGroup, false);
      p.j(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new i(paramViewGroup);
      AppMethodBeat.o(264070);
      return paramViewGroup;
    }
    if (paramInt == com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.b.HeF.ordinal())
    {
      paramViewGroup = LayoutInflater.from(this.context).inflate(R.i.efh, paramViewGroup, false);
      p.j(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new j(paramViewGroup);
      AppMethodBeat.o(264070);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.context).inflate(R.i.eeZ, paramViewGroup, false);
    p.j(paramViewGroup, "view");
    paramViewGroup = (RecyclerView.v)new a.a(paramViewGroup);
    AppMethodBeat.o(264070);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(264071);
    p.k(paramv, "holder");
    if ((paramv instanceof a.d))
    {
      paramv = this.Hhp;
      if (paramv != null)
      {
        paramv.invoke();
        AppMethodBeat.o(264071);
        return;
      }
      AppMethodBeat.o(264071);
      return;
    }
    Object localObject1;
    if ((paramv instanceof i))
    {
      paramInt = abJ(paramInt);
      localObject1 = this.Hho.getItem(paramInt);
      if (localObject1 == null)
      {
        paramv = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
        AppMethodBeat.o(264071);
        throw paramv;
      }
      localObject1 = (oo)localObject1;
      if ((((oo)localObject1).RWw.COi == 49) && (fra().Gw(16)))
      {
        com.tencent.mm.plugin.brandservice.a.c localc = fra();
        Object localObject2 = ((oo)localObject1).RWB.RTM;
        p.j(localObject2, "bizMessage.AppMsg.DetailInfo");
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          my localmy = (my)((Iterator)localObject3).next();
          ((Collection)localObject2).add(j.listOf(new String[] { localmy.RTk, String.valueOf(localmy.lpx) }));
        }
        localc.j((List)localObject2, 126);
      }
      ((i)paramv).a(this, (oo)localObject1, this.HeM, paramInt / 2);
      AppMethodBeat.o(264071);
      return;
    }
    if ((paramv instanceof j))
    {
      paramInt = abJ(paramInt);
      paramv = (j)paramv;
      localObject1 = this.Hho.getItem(paramInt);
      if (localObject1 == null)
      {
        paramv = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ProfileNotifyInfo");
        AppMethodBeat.o(264071);
        throw paramv;
      }
      localObject1 = (dor)localObject1;
      p.k(this, "widget");
      p.k(localObject1, "videoInfo");
      paramv.HhD = this;
      paramv.b((dor)localObject1);
      AppMethodBeat.o(264071);
      return;
    }
    if ((paramv instanceof a.a))
    {
      paramInt = abJ(paramInt);
      paramv = ((a.a)paramv).Hhr;
      p.j(paramv, "holder.dateTextView");
      paramv.setText((CharSequence)this.Hho.abz(paramInt));
    }
    AppMethodBeat.o(264071);
  }
  
  public final void d(op paramop)
  {
    AppMethodBeat.i(264066);
    p.k(paramop, "msgList");
    this.Hho.b(paramop);
    this.Hho.a(null);
    notifyDataSetChanged();
    AppMethodBeat.o(264066);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(264067);
    int i = this.Hho.getSize();
    AppMethodBeat.o(264067);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(264069);
    paramInt = abJ(paramInt);
    paramInt = this.Hho.abA(paramInt).ordinal();
    AppMethodBeat.o(264069);
    return paramInt;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$CommonSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;Landroid/view/ViewGroup;)V", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "picCntTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "Lkotlin/Lazy;", "picInfo", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getPicInfo", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "picInfo$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "titleTv$delegate", "url", "getUrl", "setUrl", "weakPicInfo", "Ljava/lang/ref/WeakReference;", "getWeakPicInfo", "()Ljava/lang/ref/WeakReference;", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "app_release"})
  static final class b
    extends a.f
  {
    private final kotlin.f DHR;
    private final int HeY;
    private final kotlin.f HeZ;
    private final WeakReference<ConstraintLayout> Hfa;
    private final kotlin.f Hfb;
    private final kotlin.f Hfc;
    int Hfd;
    private String title;
    String url;
    
    public b(int paramInt, a.e parame, ViewGroup paramViewGroup)
    {
      super(parame, paramViewGroup);
      AppMethodBeat.i(273478);
      this.HeY = R.g.don;
      this.HeZ = g.ar((kotlin.g.a.a)new b(this));
      this.Hfa = new WeakReference((ConstraintLayout)this.HeZ.getValue());
      this.Hfb = g.ar((kotlin.g.a.a)new a(this));
      this.Hfc = g.ar((kotlin.g.a.a)new c(this));
      this.DHR = g.ar((kotlin.g.a.a)new d(this));
      this.url = "";
      this.title = "";
      AppMethodBeat.o(273478);
    }
    
    protected final void a(View paramView, a.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(273471);
      p.k(paramView, "container");
      p.k(parame, "slotType");
      switch (b.$EnumSwitchMapping$0[parame.ordinal()])
      {
      default: 
        localObject = paramView.findViewById(R.h.dum);
        p.j(localObject, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject).setVisibility(8);
        switch (getItemShowType())
        {
        case 6: 
        case 9: 
        default: 
          localObject = paramView.findViewById(R.h.dtY);
          p.j(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
          ((ImageView)localObject).setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        super.a(paramView, parame, paramBoolean);
        AppMethodBeat.o(273471);
        return;
        localObject = paramView.findViewById(R.h.dtV);
        p.j(localObject, "container.findViewById<V…d.biz_slot_common_line_v)");
        ((View)localObject).setVisibility(0);
        break;
        localObject = paramView.findViewById(R.h.dtY);
        p.j(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(0);
        localObject = paramView.findViewById(R.h.duj);
        p.j(localObject, "container.findViewById<I….biz_slot_video_play_img)");
        ((ImageView)localObject).setVisibility(0);
        continue;
        localObject = paramView.findViewById(R.h.dtY);
        p.j(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(0);
        localObject = paramView.findViewById(R.h.dtU);
        p.j(localObject, "container.findViewById<C…slot_common_content_desc)");
        ((ConstraintLayout)localObject).setVisibility(0);
        continue;
        localObject = paramView.findViewById(R.h.dum);
        p.j(localObject, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject).setVisibility(0);
      }
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)paramView.findViewById(R.h.duf);
      p.j(localMMNeat7extView, "tv");
      if ((localMMNeat7extView.getLayoutParams() instanceof ConstraintLayout.LayoutParams))
      {
        localObject = localMMNeat7extView.getLayoutParams();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
          AppMethodBeat.o(273471);
          throw paramView;
        }
      }
      for (Object localObject = (ViewGroup.MarginLayoutParams)localObject;; localObject = (ViewGroup.MarginLayoutParams)localObject)
      {
        if (localObject != null)
        {
          ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(0);
          localMMNeat7extView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localObject = paramView.findViewById(R.h.dtY);
        p.j(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(8);
        break;
        ViewGroup.LayoutParams localLayoutParams = localMMNeat7extView.getLayoutParams();
        localObject = localLayoutParams;
        if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
          localObject = null;
        }
      }
    }
    
    protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(273470);
      p.k(paramContext, "context");
      p.k(paramViewGroup, "container");
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.eeY, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(273470);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      paramViewGroup.addView((View)paramContext);
      AppMethodBeat.o(273470);
      return paramContext;
    }
    
    public final TextView frL()
    {
      AppMethodBeat.i(273474);
      TextView localTextView = (TextView)this.Hfb.getValue();
      AppMethodBeat.o(273474);
      return localTextView;
    }
    
    protected final void frb()
    {
      AppMethodBeat.i(273472);
      if (this.Hfa == null)
      {
        AppMethodBeat.o(273472);
        return;
      }
      ConstraintLayout localConstraintLayout = (ConstraintLayout)this.Hfa.get();
      if (localConstraintLayout != null)
      {
        localConstraintLayout.setBackgroundResource(R.g.biz_msg_cover_gradient_mask);
        AppMethodBeat.o(273472);
        return;
      }
      AppMethodBeat.o(273472);
    }
    
    protected final float[] frc()
    {
      AppMethodBeat.i(273473);
      float[] arrayOfFloat = kotlin.a.e.b(new Float[] { Float.valueOf(bP(1.0F)), Float.valueOf(bP(1.0F)), Float.valueOf(bP(1.0F)), Float.valueOf(bP(1.0F)) });
      AppMethodBeat.o(273473);
      return arrayOfFloat;
    }
    
    protected final int frd()
    {
      return this.HeY;
    }
    
    public final TextView fre()
    {
      AppMethodBeat.i(273475);
      TextView localTextView = (TextView)this.Hfc.getValue();
      AppMethodBeat.o(273475);
      return localTextView;
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(273476);
      p.k(paramString, "value");
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.DHR.getValue();
      p.j(localMMNeat7extView, "titleTv");
      a(localMMNeat7extView, paramString, this.Hfd, this.url, 5);
      AppMethodBeat.o(273476);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      a(a.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ConstraintLayout>
    {
      b(a.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      c(a.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      d(a.b paramb)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "", "(Ljava/lang/String;I)V", "TOP", "COMMON", "BOTTOM", "SINGLE", "app_release"})
  static enum e
  {
    static
    {
      AppMethodBeat.i(278094);
      e locale1 = new e("TOP", 0);
      Hht = locale1;
      e locale2 = new e("COMMON", 1);
      Hhu = locale2;
      e locale3 = new e("BOTTOM", 2);
      Hhv = locale3;
      e locale4 = new e("SINGLE", 3);
      Hhw = locale4;
      Hhx = new e[] { locale1, locale2, locale3, locale4 };
      AppMethodBeat.o(278094);
    }
    
    private e() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel;", "", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;Landroid/view/ViewGroup;)V", "audioPadding", "getAudioPadding", "()I", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "imageDefaultRes", "getImageDefaultRes", "imageIv", "Landroid/widget/ImageView;", "getImageIv", "()Landroid/widget/ImageView;", "imageIv$delegate", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "value", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "item", "getItem", "()Landroid/view/ViewGroup;", "item$delegate", "getItemShowType", "largePading", "getLargePading", "listPadding", "getListPadding", "normalPading", "getNormalPading", "getSlotType", "()Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "smallPadding", "getSmallPadding", "dpToPixel", "", "getDpToPixel", "(F)F", "resFromRaw", "getResFromRaw", "(I)F", "resToPixel", "getResToPixel", "(I)I", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "isPayMsg", "url", "scene", "app_release"})
  static class f
  {
    private final int HeY;
    private final kotlin.f Hfk;
    private final kotlin.f Hfl;
    private final int Hfm;
    private final int Hfn;
    private final int Hfo;
    private final int Hfp;
    private final int Hfq;
    private final float[] Hfr;
    final a.e Hhy;
    String imageUrl;
    private final int llp;
    private final kotlin.f xwp;
    
    public f(int paramInt, a.e parame, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(273804);
      this.llp = paramInt;
      this.Hhy = parame;
      this.Hfk = g.ar((kotlin.g.a.a)new e(this, paramViewGroup));
      this.Hfl = g.ar((kotlin.g.a.a)new b(this));
      this.xwp = g.ar((kotlin.g.a.a)new a(this));
      this.Hfm = ((int)bP(36.0F));
      paramInt = R.f.ListPadding;
      this.Hfn = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      paramInt = R.f.NormalPadding;
      this.Hfo = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      paramInt = R.f.LargePadding;
      this.Hfp = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      paramInt = R.f.SmallPadding;
      this.Hfq = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      this.Hfr = kotlin.a.e.b(new Float[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      this.HeY = R.e.chatting_item_biz_default_bg;
      this.imageUrl = "";
      AppMethodBeat.o(273804);
    }
    
    protected static float bP(float paramFloat)
    {
      AppMethodBeat.i(273801);
      Resources localResources = MMApplicationContext.getResources();
      p.j(localResources, "MMApplicationContext.getResources()");
      float f = localResources.getDisplayMetrics().density;
      AppMethodBeat.o(273801);
      return f * paramFloat + 0.5F;
    }
    
    protected void a(View paramView, a.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(273795);
      p.k(paramView, "container");
      p.k(parame, "slotType");
      int i;
      switch (c.$EnumSwitchMapping$0[parame.ordinal()])
      {
      default: 
        AppMethodBeat.o(273795);
        return;
      case 1: 
        paramView.setPadding(this.Hfp, this.Hfq, this.Hfp, 0);
        if (paramBoolean) {}
        for (i = R.g.dmu;; i = R.g.dmt)
        {
          paramView.setBackgroundResource(i);
          AppMethodBeat.o(273795);
          return;
        }
      case 2: 
        paramView.setPadding(this.Hfp, this.Hfq, this.Hfp, 0);
        i = R.g.dmq;
      }
      for (;;)
      {
        paramView.setBackgroundResource(i);
        break;
        paramView.setPadding(this.Hfp, this.Hfq, this.Hfp, this.Hfp);
        i = R.g.dmp;
        continue;
        paramView.setPadding(this.Hfp, this.Hfq, this.Hfp, this.Hfq);
        if (paramBoolean) {
          i = R.g.dms;
        } else {
          i = R.g.dmr;
        }
      }
    }
    
    protected final void a(MMNeat7extView paramMMNeat7extView, String paramString1, int paramInt1, String paramString2, int paramInt2)
    {
      boolean bool = true;
      AppMethodBeat.i(273797);
      p.k(paramMMNeat7extView, "neatText");
      p.k(paramString1, "text");
      paramString1 = com.tencent.mm.pluginsdk.ui.span.l.c(paramMMNeat7extView.getContext(), (CharSequence)paramString1);
      if ((this.llp == 0) && (paramInt1 == 1)) {}
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.b.b localb = com.tencent.mm.plugin.brandservice.b.b.svR;
        p.j(paramString1, "text");
        localb.a((CharSequence)paramString1, paramMMNeat7extView, bool, paramString2, paramInt2);
        paramMMNeat7extView.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)paramMMNeat7extView, (View.OnTouchListener)new o(paramMMNeat7extView.getContext())));
        AppMethodBeat.o(273797);
        return;
        bool = false;
      }
    }
    
    protected ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(273793);
      p.k(paramContext, "context");
      p.k(paramViewGroup, "container");
      paramContext = (Throwable)new kotlin.n();
      AppMethodBeat.o(273793);
      throw paramContext;
    }
    
    protected void frb() {}
    
    protected float[] frc()
    {
      return this.Hfr;
    }
    
    protected int frd()
    {
      return this.HeY;
    }
    
    public final ViewGroup frf()
    {
      AppMethodBeat.i(273791);
      ViewGroup localViewGroup = (ViewGroup)this.Hfk.getValue();
      AppMethodBeat.o(273791);
      return localViewGroup;
    }
    
    final ImageView frg()
    {
      AppMethodBeat.i(273792);
      ImageView localImageView = (ImageView)this.Hfl.getValue();
      AppMethodBeat.o(273792);
      return localImageView;
    }
    
    protected final int frh()
    {
      return this.Hfm;
    }
    
    protected final int fri()
    {
      return this.Hfo;
    }
    
    protected final int frj()
    {
      return this.Hfp;
    }
    
    protected void frk() {}
    
    protected final Context getContext()
    {
      AppMethodBeat.i(273794);
      Context localContext = (Context)this.xwp.getValue();
      AppMethodBeat.o(273794);
      return localContext;
    }
    
    public final int getItemShowType()
    {
      return this.llp;
    }
    
    public final void setImageUrl(String paramString)
    {
      AppMethodBeat.i(273799);
      p.k(paramString, "value");
      if (kotlin.n.n.ba((CharSequence)paramString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(273799);
        return;
      }
      paramString = com.tencent.mm.api.b.M(paramString, 2);
      p.j(paramString, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
      this.imageUrl = paramString;
      paramString = a.Hhq;
      Log.v(a.access$getTAG$cp(), "imageUrl:" + this.imageUrl);
      paramString = frc();
      String str = this.imageUrl;
      Object localObject1 = new c.a().bmF();
      Object localObject2 = new StringBuilder("radius_");
      Object localObject3 = Arrays.toString(paramString);
      p.j(localObject3, "java.util.Arrays.toString(this)");
      localObject1 = ((c.a)localObject1).Ws((String)localObject3).wz(frd()).a((com.tencent.mm.ay.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.ay.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).Wq(w.bpO(this.imageUrl)).bmL();
      localObject2 = new d(this);
      localObject3 = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, paramString, (m.a)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).aM((Runnable)new a.f.c(this, str, (com.tencent.mm.ay.a.a.c)localObject1, paramString, (d)localObject2));
      com.tencent.mm.ay.q.bml().a(str, frg(), (com.tencent.mm.ay.a.a.c)localObject1, (com.tencent.mm.ay.a.c.h)localObject3);
      AppMethodBeat.o(273799);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Context>
    {
      a(a.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ImageView>
    {
      b(a.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel$imageUrl$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class d
      implements m.a
    {
      public final void onFinish()
      {
        AppMethodBeat.i(271662);
        a.c localc = a.Hhq;
        Log.v(a.access$getTAG$cp(), "imageUrl onFinish:" + this.Hhz.imageUrl);
        this.Hhz.frb();
        AppMethodBeat.o(271662);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(271664);
        a.c localc = a.Hhq;
        Log.v(a.access$getTAG$cp(), "imageUrl onStart:" + this.Hhz.imageUrl);
        this.Hhz.frk();
        AppMethodBeat.o(271664);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ViewGroup>
    {
      e(a.f paramf, ViewGroup paramViewGroup)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$TopSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;Landroid/view/ViewGroup;)V", "collapseTextLayout", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "getCollapseTextLayout", "()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "collapseTextLayout$delegate", "Lkotlin/Lazy;", "descMask", "Landroid/view/View;", "getDescMask", "()Landroid/view/View;", "descMask$delegate", "digestTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigestTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "digestTv$delegate", "value", "", "hasAudioDesc", "getHasAudioDesc", "()Z", "setHasAudioDesc", "(Z)V", "hasDesc", "setHasDesc", "hasSingleInfo", "hasTitle", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "isSingleImage", "picCntTv", "Landroid/widget/TextView;", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "singleDescLayout", "getSingleDescLayout", "singleDescLayout$delegate", "singleTitleTv", "getSingleTitleTv", "singleTitleTv$delegate", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleDescViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "titleTv", "getTitleTv", "titleTv$delegate", "topMask", "Landroid/widget/ImageView;", "getTopMask", "()Landroid/widget/ImageView;", "topMask$delegate", "url", "getUrl", "setUrl", "videPlayImg", "getVidePlayImg", "videPlayImg$delegate", "videoDurationTv", "getVideoDurationTv", "videoDurationTv$delegate", "voiceDurationTv", "getVoiceDurationTv", "voiceDurationTv$delegate", "fillBackground", "", "selector", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "onImageLoadStart", "setText", "id", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "text", "setTitleDescTextColor", "color", "app_release"})
  static final class g
    extends a.f
  {
    private final kotlin.f DHR;
    boolean HfA;
    ArrayList<View> HfB;
    private final kotlin.f HfC;
    private final kotlin.f HfD;
    final kotlin.f HfE;
    final kotlin.f HfF;
    private final kotlin.f HfG;
    private final kotlin.f HfH;
    private final kotlin.f HfI;
    final kotlin.f HfJ;
    private final kotlin.f HfK;
    private boolean HfL;
    final kotlin.f Hfb;
    private final kotlin.f Hfc;
    int Hfd;
    private boolean Hfy;
    boolean Hfz;
    private String title;
    String url;
    
    public g(final int paramInt, a.e parame, ViewGroup paramViewGroup)
    {
      super(parame, paramViewGroup);
      AppMethodBeat.i(274019);
      this.url = "";
      this.HfB = new ArrayList();
      this.HfC = g.ar((kotlin.g.a.a)new l(this));
      this.HfD = g.ar((kotlin.g.a.a)new b(this));
      this.Hfc = g.ar((kotlin.g.a.a)new h(this));
      this.HfE = g.ar((kotlin.g.a.a)new n(this));
      this.HfF = g.ar((kotlin.g.a.a)new o(this));
      this.Hfb = g.ar((kotlin.g.a.a)new e(this));
      this.DHR = g.ar((kotlin.g.a.a)new k(this, paramInt));
      this.HfG = g.ar((kotlin.g.a.a)new m(this));
      this.HfH = g.ar((kotlin.g.a.a)new i(this));
      this.HfI = g.ar((kotlin.g.a.a)new j(this));
      this.HfJ = g.ar((kotlin.g.a.a)new c(this));
      this.HfK = g.ar((kotlin.g.a.a)new a(this));
      this.title = "";
      AppMethodBeat.o(274019);
    }
    
    private final boolean frm()
    {
      return (this.Hhy == a.e.Hhw) && (!this.HfA);
    }
    
    private final ImageView frn()
    {
      AppMethodBeat.i(274005);
      ImageView localImageView = (ImageView)this.HfC.getValue();
      AppMethodBeat.o(274005);
      return localImageView;
    }
    
    private final MMNeat7extView fro()
    {
      AppMethodBeat.i(274007);
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.DHR.getValue();
      AppMethodBeat.o(274007);
      return localMMNeat7extView;
    }
    
    private final ImageView frp()
    {
      AppMethodBeat.i(274008);
      ImageView localImageView = (ImageView)this.HfG.getValue();
      AppMethodBeat.o(274008);
      return localImageView;
    }
    
    private MMCollapsibleTextView frr()
    {
      AppMethodBeat.i(274012);
      MMCollapsibleTextView localMMCollapsibleTextView = (MMCollapsibleTextView)this.HfK.getValue();
      AppMethodBeat.o(274012);
      return localMMCollapsibleTextView;
    }
    
    public final void a(int paramInt, HashSet<Integer> paramHashSet, String paramString)
    {
      AppMethodBeat.i(274015);
      p.k(paramHashSet, "expandSet");
      p.k(paramString, "text");
      MMCollapsibleTextView localMMCollapsibleTextView = frr();
      p.j(localMMCollapsibleTextView, "collapseTextLayout");
      paramString = com.tencent.mm.pluginsdk.ui.span.l.k(localMMCollapsibleTextView.getContext(), (CharSequence)paramString, (int)frr().getTextSize());
      localMMCollapsibleTextView = frr();
      if (!paramHashSet.contains(Integer.valueOf(paramInt))) {}
      for (boolean bool = true;; bool = false)
      {
        localMMCollapsibleTextView.setCollapsed(bool);
        localMMCollapsibleTextView = frr();
        p.j(paramString, "text");
        localMMCollapsibleTextView.setText((CharSequence)paramString);
        if (!(frr().getContentText() instanceof MMNeat7extView)) {
          break label194;
        }
        paramString = frr().getContentText();
        if (paramString != null) {
          break;
        }
        paramHashSet = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(274015);
        throw paramHashSet;
      }
      paramString = (MMNeat7extView)paramString;
      frr().setOnTextTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)paramString, (View.OnTouchListener)new o(paramString.getContext())));
      label194:
      frr().setOnCollapse((kotlin.g.a.a)new a.g.f(paramHashSet, paramInt));
      frr().setOnExpand((kotlin.g.a.a)new a.g.g(paramHashSet, paramInt));
      AppMethodBeat.o(274015);
    }
    
    protected final void a(View paramView, a.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(274001);
      p.k(paramView, "container");
      p.k(parame, "slotType");
      switch (getItemShowType())
      {
      case 8: 
      case 9: 
      default: 
        paramView.setPadding(0, 0, 0, 0);
        paramView.setBackgroundResource(0);
        AppMethodBeat.o(274001);
        return;
      case 6: 
      case 7: 
        if (parame == a.e.Hht)
        {
          View localView = paramView.findViewById(R.h.dug);
          p.j(localView, "container.findViewById<V…R.id.biz_slot_top_line_v)");
          localView.setVisibility(0);
        }
        super.a(paramView, parame, false);
        paramView.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(274001);
        return;
      }
      super.a(paramView, parame, false);
      AppMethodBeat.o(274001);
    }
    
    final void abG(int paramInt)
    {
      AppMethodBeat.i(274018);
      Iterator localIterator = ((Iterable)this.HfB).iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if ((localView instanceof TextView)) {
          ((TextView)localView).setTextColor(paramInt);
        } else if ((localView instanceof MMNeat7extView)) {
          ((MMNeat7extView)localView).setTextColor(paramInt);
        }
      }
      AppMethodBeat.o(274018);
    }
    
    protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(274000);
      p.k(paramContext, "context");
      p.k(paramViewGroup, "container");
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.efb, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(274000);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      int i;
      switch (getItemShowType())
      {
      case 9: 
      default: 
        i = R.h.dAO;
      }
      for (;;)
      {
        ((ViewStub)paramContext.findViewById(i)).inflate();
        paramViewGroup.addView((View)paramContext);
        AppMethodBeat.o(274000);
        return paramContext;
        i = R.h.dAR;
        continue;
        i = R.h.dAP;
        frl();
        continue;
        i = R.h.dAQ;
        continue;
        i = R.h.dAN;
      }
    }
    
    protected final void frb()
    {
      AppMethodBeat.i(274017);
      Object localObject = getContext();
      p.j(localObject, "context");
      abG(((Context)localObject).getResources().getColor(R.e.white_text_color));
      if (this.Hfy)
      {
        localObject = (View)this.HfD.getValue();
        if (!frm()) {
          break label113;
        }
        if (this.Hfz)
        {
          i = R.g.dou;
          ((View)localObject).setBackgroundResource(i);
        }
      }
      else
      {
        localObject = frn();
        if (this.Hhy != a.e.Hht) {
          break label134;
        }
      }
      label134:
      for (int i = R.g.dmv;; i = R.g.dmw)
      {
        ((ImageView)localObject).setBackgroundResource(i);
        AppMethodBeat.o(274017);
        return;
        i = R.g.dos;
        break;
        label113:
        if (this.Hfz)
        {
          i = R.g.dor;
          break;
        }
        i = R.g.doq;
        break;
      }
    }
    
    protected final float[] frc()
    {
      AppMethodBeat.i(274002);
      if (frm())
      {
        arrayOfFloat = kotlin.a.e.b(new Float[] { Float.valueOf(bP(8.0F)), Float.valueOf(bP(8.0F)), Float.valueOf(bP(8.0F)), Float.valueOf(bP(8.0F)) });
        AppMethodBeat.o(274002);
        return arrayOfFloat;
      }
      float[] arrayOfFloat = kotlin.a.e.b(new Float[] { Float.valueOf(bP(8.0F)), Float.valueOf(bP(8.0F)), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      AppMethodBeat.o(274002);
      return arrayOfFloat;
    }
    
    protected final int frd()
    {
      AppMethodBeat.i(274003);
      if (frm())
      {
        i = R.g.doo;
        AppMethodBeat.o(274003);
        return i;
      }
      int i = R.g.dop;
      AppMethodBeat.o(274003);
      return i;
    }
    
    public final TextView fre()
    {
      AppMethodBeat.i(274006);
      TextView localTextView = (TextView)this.Hfc.getValue();
      AppMethodBeat.o(274006);
      return localTextView;
    }
    
    protected final void frk()
    {
      AppMethodBeat.i(274016);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
      AppMethodBeat.o(274016);
    }
    
    final void frl()
    {
      AppMethodBeat.i(274004);
      this.Hfy = true;
      if (getItemShowType() == 5)
      {
        Object localObject = frp();
        p.j(localObject, "videPlayImg");
        localObject = ((ImageView)localObject).getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
          AppMethodBeat.o(274004);
          throw ((Throwable)localObject);
        }
        localObject = (ConstraintLayout.LayoutParams)localObject;
        if (((ConstraintLayout.LayoutParams)localObject).Fw != 0.56F)
        {
          ((ConstraintLayout.LayoutParams)localObject).Fw = 0.56F;
          ImageView localImageView = frp();
          p.j(localImageView, "videPlayImg");
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(274004);
    }
    
    final View frq()
    {
      AppMethodBeat.i(274010);
      View localView = (View)this.HfH.getValue();
      AppMethodBeat.o(274010);
      return localView;
    }
    
    public final void setTitle(String paramString)
    {
      int i = 4;
      AppMethodBeat.i(274014);
      p.k(paramString, "value");
      MMNeat7extView localMMNeat7extView;
      int j;
      String str;
      switch (getItemShowType())
      {
      default: 
        if (this.Hhy == a.e.Hhw)
        {
          localMMNeat7extView = (MMNeat7extView)this.HfI.getValue();
          p.j(localMMNeat7extView, "if (slotType == SlotType…ingleTitleTv else titleTv");
          j = this.Hfd;
          str = this.url;
          if (this.Hhy != a.e.Hhw) {
            break label188;
          }
        }
        break;
      }
      for (;;)
      {
        a(localMMNeat7extView, paramString, j, str, i);
        AppMethodBeat.o(274014);
        return;
        localMMNeat7extView = fro();
        p.j(localMMNeat7extView, "titleTv");
        a(localMMNeat7extView, paramString, this.Hfd, this.url, 4);
        paramString = frn();
        if (this.Hhy == a.e.Hht) {}
        for (i = R.g.dmw;; i = R.g.dmv)
        {
          paramString.setBackgroundResource(i);
          AppMethodBeat.o(274014);
          return;
        }
        localMMNeat7extView = fro();
        break;
        label188:
        i = 41;
      }
    }
    
    public final void wg(boolean paramBoolean)
    {
      AppMethodBeat.i(274013);
      if (!paramBoolean) {
        frq().setPadding(0, 0, 0, frh());
      }
      for (;;)
      {
        this.HfL = paramBoolean;
        AppMethodBeat.o(274013);
        return;
        frq().setPadding(frj(), fri(), frj(), frh());
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMCollapsibleTextView>
    {
      a(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<View>
    {
      b(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      c(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      d(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      e(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      h(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i
      extends kotlin.g.b.q
      implements kotlin.g.a.a<View>
    {
      i(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      j(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      k(a.g paramg, int paramInt)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ImageView>
    {
      l(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ImageView>
    {
      m(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      n(a.g paramg)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class o
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      o(a.g paramg)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "isBizPayOpen", "", "()Z", "setBizPayOpen", "(Z)V", "widget", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "dealMsgData", "", "interpolator", "bizMsg", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "position", "fillCommonSlot", "container", "Landroid/view/ViewGroup;", "detail", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "base", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "fillSingleText", "text", "Lcom/tencent/mm/protocal/protobuf/BizTextMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/CommMsgBaseInfo;", "fillSlotTarget", "fillTopSlot", "commBase", "getPlayId", "", "isPlaying", "playId", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "app_release"})
  static final class i
    extends RecyclerView.v
  {
    private boolean HeL;
    private HashSet<Integer> HeM;
    private a HhD;
    private Context context;
    
    public i(View paramView)
    {
      super();
      AppMethodBeat.i(291952);
      this.HeM = new HashSet();
      this.HeL = true;
      AppMethodBeat.o(291952);
    }
    
    private static String M(String[] paramArrayOfString)
    {
      AppMethodBeat.i(291945);
      int k = paramArrayOfString.length;
      int i = 0;
      Object localObject;
      int j;
      if (i < k)
      {
        localObject = paramArrayOfString[i];
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence == null) || (kotlin.n.n.ba(localCharSequence)))
        {
          j = 1;
          label42:
          if (j != 0) {
            break label79;
          }
          j = 1;
          label48:
          if (j == 0) {
            break label84;
          }
        }
      }
      for (paramArrayOfString = (String[])localObject;; paramArrayOfString = null)
      {
        localObject = paramArrayOfString;
        if (paramArrayOfString == null) {
          localObject = "";
        }
        AppMethodBeat.o(291945);
        return localObject;
        j = 0;
        break label42;
        label79:
        j = 0;
        break label48;
        label84:
        i += 1;
        break;
      }
    }
    
    private static String a(my parammy)
    {
      AppMethodBeat.i(291950);
      parammy = parammy.RTk;
      p.j(parammy, "detail.ContentUrl");
      parammy = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apJ(parammy);
      AppMethodBeat.o(291950);
      return parammy;
    }
    
    private final void a(final View paramView, final my parammy, final mx parammx, final int paramInt)
    {
      AppMethodBeat.i(291947);
      Object localObject;
      c localc;
      if (parammy.lpx == 7)
      {
        localObject = (ImageView)paramView.findViewById(R.h.duk);
        if (localObject != null)
        {
          b localb = new b((ImageView)localObject);
          localc = new c((ImageView)localObject);
          final String str = a(parammy);
          if (!hA(str)) {
            break label119;
          }
          localb.invoke();
          ((ImageView)localObject).setOnClickListener((View.OnClickListener)new a(localb, str, this, parammy));
        }
      }
      for (;;)
      {
        paramView.setOnClickListener((View.OnClickListener)new d(this, parammy, parammx, paramView, paramInt));
        AppMethodBeat.o(291947);
        return;
        label119:
        localc.invoke();
        break;
        if (parammy.lpx == 5)
        {
          localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.sKW;
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.G(parammy.RTk, parammy.lpx, "");
        }
      }
    }
    
    private final void a(ViewGroup paramViewGroup, my parammy, mx parammx, a.e parame, int paramInt)
    {
      AppMethodBeat.i(291944);
      a.c localc = a.Hhq;
      Log.v(a.access$getTAG$cp(), "fillCommonSlot:" + parammy.RTk);
      paramViewGroup = new a.b(parammy.lpx, parame, paramViewGroup);
      paramViewGroup.Hfd = parammy.RTG;
      paramViewGroup.url = parammy.RTk;
      parame = parammy.fwr;
      p.j(parame, "detail.Title");
      paramViewGroup.setTitle(parame);
      parame = (CharSequence)parammy.RTz;
      if ((parame == null) || (kotlin.n.n.ba(parame)))
      {
        i = 1;
        if (i == 0)
        {
          parame = paramViewGroup.fre();
          p.j(parame, "view.showDescTv");
          parame.setText((CharSequence)parammy.RTz);
        }
        parame = paramViewGroup.fre();
        if (parame != null) {
          if ((paramViewGroup.Hfd != 1) || (this.HeL)) {
            break label274;
          }
        }
      }
      label274:
      for (int i = 4;; i = 0)
      {
        parame.setVisibility(i);
        if ((parammy.lpx == 8) && (parammy.EFG > 1))
        {
          parame = paramViewGroup.frL();
          p.j(parame, "view.picCntTv");
          parame.setText((CharSequence)String.valueOf(parammy.EFG));
        }
        paramViewGroup.setImageUrl(M(new String[] { parammy.RTn, parammy.RTm }));
        a((View)paramViewGroup.frf(), parammy, parammx, paramInt);
        AppMethodBeat.o(291944);
        return;
        i = 0;
        break;
      }
    }
    
    private static boolean hA(String paramString)
    {
      AppMethodBeat.i(291949);
      com.tencent.mm.bb.f localf = com.tencent.mm.bb.a.bnA();
      if (localf != null)
      {
        if ((p.h(localf.lVt, paramString)) && (localf.lVr == 0) && (com.tencent.mm.bb.a.bnx()))
        {
          AppMethodBeat.o(291949);
          return true;
        }
        AppMethodBeat.o(291949);
        return false;
      }
      AppMethodBeat.o(291949);
      return false;
    }
    
    public final void a(a parama, oo paramoo, HashSet<Integer> paramHashSet, int paramInt)
    {
      AppMethodBeat.i(291941);
      p.k(parama, "interpolator");
      p.k(paramoo, "bizMsg");
      p.k(paramHashSet, "expandSet");
      this.context = parama.context;
      this.HhD = parama;
      this.HeM = paramHashSet;
      this.HeL = parama.HeL;
      paramHashSet = this.amk;
      if (paramHashSet != null) {
        paramHashSet = paramHashSet.getTag();
      }
      int i;
      while (p.h(paramHashSet, paramoo))
      {
        paramHashSet = paramoo.RWB;
        if (paramHashSet != null)
        {
          paramHashSet = paramHashSet.RTM;
          if (paramHashSet != null)
          {
            i = 0;
            paramHashSet = ((Iterable)paramHashSet).iterator();
            for (;;)
            {
              if (paramHashSet.hasNext())
              {
                localObject1 = (my)paramHashSet.next();
                p.j(localObject1, "detail");
                if (p.h(a((my)localObject1), a.a(parama)))
                {
                  a.a(parama, "none");
                  i = 1;
                  continue;
                  paramHashSet = null;
                  break;
                }
              }
            }
            if (i == 1) {
              break;
            }
            AppMethodBeat.o(291941);
            return;
          }
        }
        AppMethodBeat.o(291941);
        return;
      }
      parama = this.amk;
      p.j(parama, "itemView");
      parama.setTag(paramoo);
      try
      {
        i = paramoo.RWw.COi;
        switch (i)
        {
        default: 
          AppMethodBeat.o(291941);
          return;
        }
      }
      catch (Exception parama)
      {
        paramoo = a.Hhq;
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)parama, "", new Object[0]);
      }
      parama = this.amk;
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(291941);
        throw parama;
        AppMethodBeat.o(291941);
        return;
      }
      ((ViewGroup)parama).removeAllViews();
      parama = this.amk;
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(291941);
        throw parama;
      }
      paramHashSet = (ViewGroup)parama;
      parama = paramoo.RWx;
      p.j(parama, "bizMsg.Text");
      Object localObject1 = paramoo.RWw;
      p.j(localObject1, "bizMsg.BaseInfo");
      paramoo = new a.g(10, a.e.Hhw, paramHashSet);
      paramInt = ((acj)localObject1).HlE;
      paramHashSet = this.HeM;
      parama = parama.lpy;
      p.j(parama, "text.Content");
      paramoo.a(paramInt, paramHashSet, parama);
      AppMethodBeat.o(291941);
      return;
      parama = this.amk;
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(291941);
        throw parama;
      }
      ((ViewGroup)parama).removeAllViews();
      int j = paramoo.RWB.RTM.size();
      if (j > 1) {
        parama = a.e.Hht;
      }
      Object localObject2;
      label720:
      label868:
      boolean bool;
      while (paramoo.RWB.RTK.RTh != 0)
      {
        paramHashSet = this.amk;
        if (paramHashSet == null)
        {
          parama = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(291941);
          throw parama;
          parama = a.e.Hhw;
        }
        else
        {
          localObject2 = (ViewGroup)paramHashSet;
          paramHashSet = paramoo.RWB.RTM.get(0);
          p.j(paramHashSet, "bizMsg.AppMsg.DetailInfo[0]");
          paramHashSet = (my)paramHashSet;
          localObject1 = paramoo.RWB.RTK;
          p.j(localObject1, "bizMsg.AppMsg.BaseInfo");
          Object localObject3 = paramoo.RWw;
          p.j(localObject3, "bizMsg.BaseInfo");
          Object localObject4 = a.Hhq;
          Log.v(a.access$getTAG$cp(), "fillTopSlot:" + paramHashSet.RTk);
          localObject2 = new a.g(paramHashSet.lpx, parama, (ViewGroup)localObject2);
          if ((paramHashSet.lpx != 8) && (paramHashSet.lpx != 10))
          {
            ((a.g)localObject2).Hfd = paramHashSet.RTG;
            ((a.g)localObject2).url = paramHashSet.RTk;
            localObject4 = paramHashSet.fwr;
            p.j(localObject4, "detail.Title");
            ((a.g)localObject2).setTitle((String)localObject4);
          }
          if (parama == a.e.Hhw)
          {
            parama = (CharSequence)paramHashSet.RTi;
            if (parama == null) {
              break label1477;
            }
            if (!kotlin.n.n.ba(parama)) {
              break label1510;
            }
            break label1477;
            if (i == 0) {
              ((MMNeat7extView)((a.g)localObject2).HfJ.getValue()).aL((CharSequence)paramHashSet.RTi);
            }
          }
          parama = (CharSequence)paramHashSet.RTz;
          if (parama == null) {
            break label1483;
          }
          if (!kotlin.n.n.ba(parama)) {
            break label1516;
          }
          break label1483;
          label770:
          if (i == 0)
          {
            parama = ((a.g)localObject2).fre();
            p.j(parama, "view.showDescTv");
            parama.setText((CharSequence)paramHashSet.RTz);
          }
          parama = ((a.g)localObject2).fre();
          if (parama != null)
          {
            if ((((a.g)localObject2).Hfd != 1) || (this.HeL)) {
              break label1522;
            }
            i = 4;
            label827:
            parama.setVisibility(i);
          }
          switch (paramHashSet.lpx)
          {
          case 6: 
            switch (paramHashSet.lpx)
            {
            case 8: 
            case 9: 
              switch (paramHashSet.lpx)
              {
              case 0: 
                parama = new String[2];
                parama[0] = paramHashSet.RTm;
                parama[1] = paramHashSet.RTo;
                ((a.g)localObject2).setImageUrl(M(parama));
              }
              break;
            }
          case 5: 
          case 7: 
          case 8: 
            for (;;)
            {
              label912:
              label936:
              label955:
              label964:
              a((View)((a.g)localObject2).frf(), paramHashSet, (mx)localObject1, paramInt);
              break label1498;
              label984:
              while (i < j)
              {
                parama = this.amk;
                p.j(parama, "itemView");
                paramHashSet = (ViewGroup)parama;
                parama = paramoo.RWB.RTM.get(i);
                p.j(parama, "bizMsg.AppMsg.DetailInfo[i]");
                localObject1 = (my)parama;
                localObject2 = paramoo.RWB.RTK;
                p.j(localObject2, "bizMsg.AppMsg.BaseInfo");
                if (i != j - 1) {
                  break label1470;
                }
                parama = a.e.Hhv;
                a(paramHashSet, (my)localObject1, (mx)localObject2, parama, paramInt);
                i += 1;
              }
              label1063:
              parama = (TextView)((a.g)localObject2).HfE.getValue();
              p.j(parama, "view.videoDurationTv");
              parama.setText((CharSequence)com.tencent.mm.aj.m.uD(paramHashSet.RTy));
              break label868;
              parama = (TextView)((a.g)localObject2).HfF.getValue();
              p.j(parama, "view.voiceDurationTv");
              parama.setText((CharSequence)com.tencent.mm.aj.m.uD(paramHashSet.RTt));
              break label868;
              if (paramHashSet.EFG <= 1) {
                break label868;
              }
              parama = (TextView)((a.g)localObject2).Hfb.getValue();
              p.j(parama, "view.picCntTv");
              parama.setText((CharSequence)String.valueOf(paramHashSet.EFG));
              break label868;
              parama = (CharSequence)paramHashSet.RTi;
              if (parama == null) {
                break label1528;
              }
              if (!kotlin.n.n.ba(parama)) {
                break label1542;
              }
              break label1528;
              label1228:
              ((a.g)localObject2).wg(bool);
            }
            i = ((acj)localObject3).HlE;
            parama = this.HeM;
            localObject3 = paramHashSet.fwr;
            p.j(localObject3, "detail.Title");
            ((a.g)localObject2).a(i, parama, (String)localObject3);
            parama = (CharSequence)paramHashSet.RTz;
            if (parama == null) {
              break label1554;
            }
            if (!kotlin.n.n.ba(parama)) {
              break label1560;
            }
            break label1554;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label964;
        }
        parama = ((a.g)localObject2).fre();
        p.j(parama, "view.showDescTv");
        parama.setText((CharSequence)paramHashSet.RTz);
        break label964;
        parama = new String[3];
        parama[0] = paramHashSet.RTI;
        parama[1] = paramHashSet.RTm;
        parama[2] = paramHashSet.RTo;
        break label955;
        parama = new String[2];
        parama[0] = paramHashSet.RTo;
        parama[1] = paramHashSet.RTm;
        break label955;
        paramHashSet = this.amk;
        if (paramHashSet == null)
        {
          parama = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(291941);
          throw parama;
        }
        paramHashSet = (ViewGroup)paramHashSet;
        localObject1 = paramoo.RWB.RTM.get(0);
        p.j(localObject1, "bizMsg.AppMsg.DetailInfo[0]");
        localObject1 = (my)localObject1;
        localObject2 = paramoo.RWB.RTK;
        p.j(localObject2, "bizMsg.AppMsg.BaseInfo");
        a(paramHashSet, (my)localObject1, (mx)localObject2, parama, paramInt);
        break label1498;
        label1470:
        parama = a.e.Hhu;
        break label1063;
        label1477:
        i = 1;
        break label720;
        label1483:
        i = 1;
        break label770;
        break label868;
        break label912;
        break label936;
        label1498:
        if (j <= 1) {
          break;
        }
        i = 1;
        break label984;
        label1510:
        i = 0;
        break label720;
        label1516:
        i = 0;
        break label770;
        label1522:
        i = 0;
        break label827;
        label1528:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1548;
          }
          bool = true;
          break;
        }
        label1542:
        label1548:
        bool = false;
        break label1228;
        label1554:
        i = 1;
        continue;
        label1560:
        i = 0;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder$fillSlotTarget$1$3"})
    static final class a
      implements View.OnClickListener
    {
      a(a.i.b paramb, String paramString, a.i parami, my parammy) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(285844);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        this.HhE.invoke();
        localObject = new e.g();
        e.h localh = new e.h();
        localh.QuD = str;
        localh.url = parammy.RTk;
        localh.title = parammy.fwr;
        localh.lpY = "";
        localh.playUrl = parammy.RTu;
        localh.coverUrl = parammy.RTm;
        ((e.g)localObject).XeN = localh;
        paramView.setTag(localObject);
        s.hL(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285844);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"drawPlaying", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(283272);
        this.wXn.setImageResource(R.g.dmz);
        Object localObject = this.wXn.getDrawable();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(283272);
          throw ((Throwable)localObject);
        }
        localObject = (AnimationDrawable)localObject;
        if (localObject != null)
        {
          ((AnimationDrawable)localObject).start();
          AppMethodBeat.o(283272);
          return;
        }
        AppMethodBeat.o(283272);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"drawPlay", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      c(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(280206);
        this.wXn.setImageResource(R.g.dmy);
        AppMethodBeat.o(280206);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(a.i parami, my parammy, mx parammx, View paramView, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(197343);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramView = a.Hhq;
        Log.i(a.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { parammy.RTk });
        if (a.i.a(this.HhF) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(197343);
          return;
        }
        paramView = new Intent();
        localObject1 = com.tencent.mm.aj.m.e(parammy.RTk, 126, -1, 0);
        paramView.putExtra("rawUrl", (String)localObject1);
        paramView.putExtra("useJs", true);
        paramView.putExtra("vertical_scroll", true);
        paramView.putExtra("geta8key_scene", 3);
        Object localObject2 = a.i.a(this.HhF);
        if (localObject2 == null) {
          p.iCn();
        }
        paramView.putExtra("geta8key_username", ((a)localObject2).contact.getUsername());
        localObject2 = paramView.getStringExtra("prePublishId");
        int i;
        int j;
        int k;
        if (!Util.isNullOrNil((String)localObject2))
        {
          paramView.putExtra("KPublisherId", (String)localObject2);
          paramView.putExtra("prePublishId", (String)localObject2);
          paramView.putExtra("preUsername", paramView.getStringExtra("preUsername"));
          paramView.putExtra("preChatName", paramView.getStringExtra("preChatName"));
          paramView.putExtra("preChatTYPE", paramView.getIntExtra("preChatTYPE", 0));
          i = paramView.getIntExtra("KOpenArticleSceneFromScene", 10000);
          if (parammy.lpx == 5)
          {
            paramView.putExtra(f.b.VRT, 126);
            paramView.putExtra(f.b.VRU, i);
            paramView.putExtra("biz_video_session_id", ab.getSessionId());
            localObject2 = new com.tencent.mm.aj.x();
            ((com.tencent.mm.aj.x)localObject2).lpD = paramView.getStringExtra("KPublisherId");
            Object localObject3 = a.i.a(this.HhF);
            if (localObject3 == null) {
              p.iCn();
            }
            ((com.tencent.mm.aj.x)localObject2).fzT = ((a)localObject3).contact.getUsername();
            localObject3 = a.i.a(this.HhF);
            if (localObject3 == null) {
              p.iCn();
            }
            ((com.tencent.mm.aj.x)localObject2).lpC = ((a)localObject3).contact.ayr();
            ((com.tencent.mm.aj.x)localObject2).lpE.url = ((String)localObject1);
            ((com.tencent.mm.aj.x)localObject2).lpE.title = parammy.fwr;
            ((com.tencent.mm.aj.x)localObject2).lpE.lpM = "detail.videoDigest";
            ((com.tencent.mm.aj.x)localObject2).lpE.lpK = parammy.RTm;
            ((com.tencent.mm.aj.x)localObject2).lpE.type = parammy.lpx;
            ((com.tencent.mm.aj.x)localObject2).lpE.time = parammx.CreateTime;
            ((com.tencent.mm.aj.x)localObject2).lpE.lpO = parammy.RTy;
            ((com.tencent.mm.aj.x)localObject2).lpE.videoWidth = parammy.RTw;
            ((com.tencent.mm.aj.x)localObject2).lpE.videoHeight = parammy.RTx;
            ((com.tencent.mm.aj.x)localObject2).lpE.vid = parammy.RTv;
            ((com.tencent.mm.aj.x)localObject2).v(paramView);
            localObject2 = a.Hhq;
            Log.i(a.access$getTAG$cp(), "jump to native video");
            localObject2 = new int[2];
            localObject3 = (ImageView)paramView.findViewById(R.h.dtY);
            if (localObject3 != null)
            {
              j = ((ImageView)localObject3).getWidth();
              k = ((ImageView)localObject3).getHeight();
              ((ImageView)localObject3).getLocationInWindow((int[])localObject2);
              paramView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
            }
            paramView.addFlags(268435456);
          }
          if ((!((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(6)) || (!((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(a.i.b(this.HhF), (String)localObject1, parammy.lpx, 126, i, paramView))) {
            break label879;
          }
          paramView = a.Hhq;
          Log.i(a.access$getTAG$cp(), "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.Hgc;
          paramView = a.i.a(this.HhF);
          if (paramView == null) {
            p.iCn();
          }
          paramView = paramView.contact.getUsername();
          p.j(paramView, "widget!!.contact.username");
          localObject1 = a.i.a(this.HhF);
          if (localObject1 == null) {
            p.iCn();
          }
          long l = ((a)localObject1).enterTime;
          i = parammx.RTg;
          j = parammy.RTj;
          k = parammy.lpx;
          int m = paramInt;
          int n = parammx.CreateTime;
          localObject1 = a.i.a(this.HhF);
          if (localObject1 == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a(paramView, l, i, j, k, m, n, ((a)localObject1).mXL);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newBizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(197343);
          return;
          paramView.putExtra("prePublishId", "brand_profile");
          paramView.putExtra("KPublisherId", "brand_profile");
          break;
          label879:
          com.tencent.mm.by.c.b(a.i.b(this.HhF), "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newVideoChannelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "coverSize", "", "inflater", "Landroid/view/LayoutInflater;", "radius", "", "widget", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "dealData", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "fillVideoChannel", "fillVideoItem", "videoItem", "Lcom/tencent/mm/protocal/protobuf/NotifyVideoInfo;", "getDurationText", "", "app_release"})
  public static final class j
    extends RecyclerView.v
  {
    private int HfO;
    a HhD;
    private LayoutInflater mYa;
    private float radius;
    
    public j(View paramView)
    {
      super();
      AppMethodBeat.i(272596);
      this.HfO = com.tencent.mm.ci.a.fromDPToPix(paramView.getContext(), 64);
      this.radius = 2.0F;
      paramView = LayoutInflater.from(paramView.getContext());
      p.j(paramView, "LayoutInflater.from(itemView.context)");
      this.mYa = paramView;
      AppMethodBeat.o(272596);
    }
    
    final void b(final dor paramdor)
    {
      AppMethodBeat.i(272595);
      Object localObject2 = (TextView)this.amk.findViewById(R.h.dYO);
      Object localObject1 = (CharSequence)paramdor.TVS;
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
          break label651;
        }
        localObject1 = (CharSequence)paramdor.TVS;
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
        com.tencent.mm.plugin.brandservice.ui.b.d.l((TextView)localObject2);
        localObject2 = (TextView)this.amk.findViewById(R.h.dYN);
        localObject1 = (CharSequence)paramdor.wording;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label685;
        }
        i = 1;
        if (i != 0) {
          break label690;
        }
        localObject1 = (CharSequence)paramdor.wording;
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = paramdor.TVR;
        localObject2 = a.Hhq;
        Log.v(a.access$getTAG$cp(), "alvinluo fillVideoChannel size: %d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
        localObject2 = (LinearLayout)this.amk.findViewById(R.h.dYD);
        ((LinearLayout)localObject2).removeAllViews();
        if (localObject1 == null) {
          break label771;
        }
        Iterator localIterator = ((Iterable)localObject1).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = (dda)localIterator.next();
        } while (localObject3 == null);
        localObject1 = a.Hhq;
        Log.d(a.access$getTAG$cp(), "alvinluo videoItem url: %s, duration: %d", new Object[] { ((dda)localObject3).TKP, Integer.valueOf(((dda)localObject3).duration) });
        localObject4 = this.mYa.inflate(R.i.efi, null, false);
        ((LinearLayout)localObject2).addView((View)localObject4);
        p.j(localObject4, "itemView");
        localObject1 = ((View)localObject4).findViewById(R.h.video_duration);
        p.j(localObject1, "itemView.findViewById<Te…iew>(R.id.video_duration)");
        localObject5 = (TextView)localObject1;
        i = ((dda)localObject3).duration / 3600;
        j = (((dda)localObject3).duration - i * 3600) / 60;
        k = ((dda)localObject3).duration % 60;
        localObject1 = a.Hhq;
        Log.i(a.access$getTAG$cp(), "alvinluo getDurationText " + i + ':' + j + ':' + k);
        if (i <= 0) {
          break label724;
        }
        localObject1 = af.aaBG;
        localObject1 = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }, 3));
        p.j(localObject1, "java.lang.String.format(format, *args)");
      }
      for (;;)
      {
        ((TextView)localObject5).setText((CharSequence)localObject1);
        localObject1 = (ImageView)((View)localObject4).findViewById(R.h.dYH);
        localObject3 = com.tencent.mm.api.b.M(((dda)localObject3).TKP, 2);
        localObject4 = new c.a().bmF().dO(this.HfO, this.HfO).Ws("radius_" + this.radius).wz(R.g.don).a((com.tencent.mm.ay.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.ay.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).Wq(w.bpO((String)localObject3)).bmL();
        localObject5 = new b((String)localObject3, (ImageView)localObject1);
        localObject5 = new com.tencent.mm.pluginsdk.ui.applet.m(3, this.HfO, this.HfO, true, true, this.radius, (m.a)localObject5);
        com.tencent.mm.ay.q.bml().a((String)localObject3, (ImageView)localObject1, (com.tencent.mm.ay.a.a.c)localObject4, (com.tencent.mm.ay.a.c.h)localObject5);
        break label208;
        i = 0;
        break;
        label651:
        localObject1 = ((TextView)localObject2).getContext();
        p.j(localObject1, "context");
        localObject1 = (CharSequence)((Context)localObject1).getResources().getString(R.l.esW);
        break label59;
        label685:
        i = 0;
        break label117;
        label690:
        localObject1 = ((TextView)localObject2).getContext();
        p.j(localObject1, "context");
        localObject1 = (CharSequence)((Context)localObject1).getResources().getString(R.l.esV);
        break label130;
        label724:
        localObject1 = af.aaBG;
        localObject1 = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(j), Integer.valueOf(k) }, 2));
        p.j(localObject1, "java.lang.String.format(format, *args)");
      }
      label771:
      localObject1 = this.amk.findViewById(R.h.root_layout);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new a(this, paramdor));
        AppMethodBeat.o(272595);
        return;
      }
      AppMethodBeat.o(272595);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(a.j paramj, dor paramdor) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(284926);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newVideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (a.j.a(this.HhG) != null)
        {
          paramView = (CharSequence)paramdor.jump_url;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label252;
          }
        }
        label252:
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            if (a.j.a(this.HhG) == null) {
              p.iCn();
            }
            paramView = new Intent();
            paramView.putExtra("rawUrl", paramdor.jump_url);
            localObject = a.j.a(this.HhG);
            if (localObject == null) {
              p.iCn();
            }
            paramView.putExtra("geta8key_username", ((a)localObject).contact.getUsername());
            localObject = this.HhG.amk;
            p.j(localObject, "itemView");
            com.tencent.mm.by.c.b(((View)localObject).getContext(), "webview", ".ui.tools.WebViewUI", paramView);
            paramView = a.j.a(this.HhG);
            if (paramView == null) {
              p.iCn();
            }
            paramView = paramView.contact.getUsername();
            localObject = a.j.a(this.HhG);
            if (localObject == null) {
              p.iCn();
            }
            i = ((a)localObject).mXL;
            localObject = a.j.a(this.HhG);
            if (localObject == null) {
              p.iCn();
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramView, 1402, i, ((a)localObject).enterTime);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newVideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(284926);
          return;
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$newVideoChannelViewHolder$fillVideoItem$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class b
      implements m.a
    {
      b(String paramString, ImageView paramImageView) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(275788);
        a.c localc = a.Hhq;
        Log.v(a.access$getTAG$cp(), "imageUrl onFinish:" + this.wXO);
        this.HfR.setBackgroundResource(R.g.mm_trans);
        AppMethodBeat.o(275788);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(275789);
        a.c localc = a.Hhq;
        Log.v(a.access$getTAG$cp(), "imageUrl onStart:" + this.wXO);
        AppMethodBeat.o(275789);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.a
 * JD-Core Version:    0.7.0.1
 */