package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.h.a;
import com.tencent.mm.plugin.textstatus.a.q.a;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.g.n.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/ProfileCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "extraPadding", "", "(Landroid/content/Context;Landroid/widget/RelativeLayout;Landroid/widget/LinearLayout;I)V", "btnJoin", "Landroid/widget/ImageView;", "getBtnJoin", "()Landroid/widget/ImageView;", "setBtnJoin", "(Landroid/widget/ImageView;)V", "btnLike", "getBtnLike", "setBtnLike", "cardView", "Landroid/view/View;", "clickListener", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "iconAvatarNotify", "getIconAvatarNotify", "setIconAvatarNotify", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "lastClickTime", "", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lastExposedSessionId", "", "layoutCardContent", "getLayoutCardContent", "()Landroid/widget/RelativeLayout;", "setLayoutCardContent", "(Landroid/widget/RelativeLayout;)V", "layoutCenter", "getLayoutCenter", "()Landroid/widget/LinearLayout;", "setLayoutCenter", "(Landroid/widget/LinearLayout;)V", "layoutNotify", "getLayoutNotify", "setLayoutNotify", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "oriColorMap", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "Lkotlin/collections/HashMap;", "getOriColorMap", "()Ljava/util/HashMap;", "setOriColorMap", "(Ljava/util/HashMap;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "sessionId", "tvChatCount", "getTvChatCount", "()Landroid/widget/TextView;", "setTvChatCount", "(Landroid/widget/TextView;)V", "tvDesc", "getTvDesc", "setTvDesc", "tvDescNotify", "getTvDescNotify", "setTvDescNotify", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvPoi", "getTvPoi", "setTvPoi", "tvRef", "getTvRef", "setTvRef", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "username", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "vBack", "getVBack", "setVBack", "cardClick", "", "fixLayout", "hasStatus", "", "getLayoutId", "getSetStatusParams", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "getView", "goDetail", "goReferenceEdit", "handleNotify", "init", "initData", "isCanRef", "isSelf", "isShowRef", "onClick", "v", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onPullDownProgress", "persent", "", "curTranslation", "unfoldTranslation", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "setEventListener", "l", "setItemClickListener", "update", "Companion", "plugin-textstatus_release"})
public final class g
  implements View.OnClickListener, com.tencent.mm.an.i, e
{
  public static final g.a MKo;
  private static final String TAG = "MicroMsg.TextStatus.StatusCardView";
  private h.a MAH;
  private TextView MBS;
  private TextView MBT;
  private TextView MBV;
  private ImageView MBW;
  private TextView MBY;
  private ImageView MCe;
  private ImageView MCg;
  private TextView MCh;
  private LinearLayout MCq;
  private com.tencent.mm.plugin.textstatus.g.e.a MCs;
  private RelativeLayout MJG;
  private ImageView MJH;
  private ImageView MJL;
  private TextView MJM;
  private LinearLayout MJN;
  private com.tencent.mm.plugin.textstatus.e.d MJY;
  private HashMap<TextView, ColorStateList> MJZ;
  private String MKb;
  private final LinearLayout MKe;
  private final int MKf;
  private TextView MKn;
  private View.OnClickListener dig;
  private com.tencent.mm.ui.base.s iYE;
  private final RelativeLayout kDt;
  private long lastClickTime;
  Context mContext;
  private String sessionId;
  private String username;
  private final View wRV;
  
  static
  {
    AppMethodBeat.i(234749);
    MKo = new g.a((byte)0);
    TAG = "MicroMsg.TextStatus.StatusCardView";
    AppMethodBeat.o(234749);
  }
  
  public g(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, int paramInt)
  {
    AppMethodBeat.i(234747);
    this.kDt = paramRelativeLayout;
    this.MKe = paramLinearLayout;
    this.MKf = paramInt;
    paramRelativeLayout = LayoutInflater.from(paramContext).inflate(b.f.Mya, null, false);
    p.j(paramRelativeLayout, "LayoutInflater.from(cont…tLayoutId(), null, false)");
    this.wRV = paramRelativeLayout;
    this.mContext = paramContext;
    this.MJZ = new HashMap();
    paramRelativeLayout = com.tencent.mm.plugin.textstatus.e.f.MCG;
    paramRelativeLayout = r.gkS();
    p.j(paramRelativeLayout, "StatusShowParam.defProfile()");
    this.MJY = com.tencent.mm.plugin.textstatus.e.f.b(paramRelativeLayout);
    this.MJY.g(this.wRV);
    this.MJY.ag((kotlin.g.a.a)new g.1(this));
    this.MBS = ((TextView)this.wRV.findViewById(b.e.Mxj));
    this.MBV = ((TextView)this.wRV.findViewById(b.e.Mxh));
    this.MBT = ((TextView)this.wRV.findViewById(b.e.MwQ));
    this.MBY = ((TextView)this.wRV.findViewById(b.e.Mxf));
    this.MJH = ((ImageView)this.wRV.findViewById(b.e.MuN));
    paramRelativeLayout = this.wRV.findViewById(b.e.MuO);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.btn_like)");
    this.MCe = ((ImageView)paramRelativeLayout);
    this.MCg = ((ImageView)this.wRV.findViewById(b.e.Mvi));
    paramRelativeLayout = this.wRV.findViewById(b.e.Mve);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.icon_avatar_notify)");
    this.MJL = ((ImageView)paramRelativeLayout);
    paramRelativeLayout = this.wRV.findViewById(b.e.MwR);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.tv_desc_notify)");
    this.MJM = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.wRV.findViewById(b.e.MvW);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.layout_notify)");
    this.MJN = ((LinearLayout)paramRelativeLayout);
    paramRelativeLayout = this.wRV.findViewById(b.e.MwY);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.tv_like_num)");
    this.MCh = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.wRV.findViewById(b.e.MvN);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.layout_center)");
    this.MCq = ((LinearLayout)paramRelativeLayout);
    this.MKn = ((TextView)this.wRV.findViewById(b.e.Mxg));
    this.MBW = ((ImageView)this.wRV.findViewById(b.e.Mxr));
    this.MJG = ((RelativeLayout)this.wRV.findViewById(b.e.MvM));
    paramRelativeLayout = com.tencent.mm.plugin.textstatus.k.n.MOY;
    com.tencent.mm.plugin.textstatus.k.n.B((View)this.MJL, com.tencent.mm.ci.a.fromDPToPix(paramContext, 10.0F));
    paramContext = com.tencent.mm.plugin.fts.a.d.Sx(1);
    p.j(paramContext, "FTSApiLogic.getUnsignedM…atus.SessionScene.NORMAL)");
    this.sessionId = paramContext;
    this.MKb = "";
    AppMethodBeat.o(234747);
  }
  
  private final com.tencent.mm.plugin.textstatus.a.q gmA()
  {
    AppMethodBeat.i(234740);
    com.tencent.mm.plugin.textstatus.a.q localq = new q.a().gkO();
    localq.sessionId = this.sessionId;
    localq.MEB = false;
    p.j(localq, "setStatusParam");
    AppMethodBeat.o(234740);
    return localq;
  }
  
  private boolean gmy()
  {
    AppMethodBeat.i(234734);
    com.tencent.mm.plugin.textstatus.g.e.a locala = this.MCs;
    if (locala == null)
    {
      AppMethodBeat.o(234734);
      return false;
    }
    Object localObject2 = this.username;
    if (localObject2 == null)
    {
      AppMethodBeat.o(234734);
      return false;
    }
    Object localObject1;
    boolean bool;
    switch (locala.field_MediaType)
    {
    default: 
      localObject1 = this.MJY.glR();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.textstatus.a.i)localObject1).dDH() == true))
      {
        localObject1 = this.MJY.glR();
        if ((localObject1 != null) && (((com.tencent.mm.plugin.textstatus.a.i)localObject1).dOW() == true)) {
          bool = true;
        }
      }
      break;
    }
    for (;;)
    {
      Log.i(TAG, "isCanRef:" + bool + " mtpe:" + locala.field_MediaType);
      AppMethodBeat.o(234734);
      return bool;
      localObject1 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject1 = com.tencent.mm.plugin.textstatus.k.f.lD("thumb", (String)localObject2);
      Object localObject3 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject2 = com.tencent.mm.plugin.textstatus.k.f.lD("image", (String)localObject2);
      localObject3 = (CharSequence)locala.field_MediaThumbUrl;
      if ((localObject3 == null) || (kotlin.n.n.ba((CharSequence)localObject3)))
      {
        i = 1;
        label218:
        if (i != 0) {
          break label281;
        }
        localObject3 = (CharSequence)locala.field_MediaUrl;
        if ((localObject3 != null) && (!kotlin.n.n.ba((CharSequence)localObject3))) {
          break label276;
        }
      }
      label276:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (!u.agG((String)localObject1)) || (!u.agG((String)localObject2))) {
          break label281;
        }
        bool = true;
        break;
        i = 0;
        break label218;
      }
      label281:
      bool = false;
      continue;
      localObject1 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject1 = com.tencent.mm.plugin.textstatus.k.f.lD("thumb", (String)localObject2);
      localObject2 = (CharSequence)locala.field_MediaThumbUrl;
      if ((localObject2 == null) || (kotlin.n.n.ba((CharSequence)localObject2)))
      {
        i = 1;
        label325:
        if (i != 0) {
          break label380;
        }
        localObject2 = (CharSequence)locala.field_MediaUrl;
        if ((localObject2 != null) && (!kotlin.n.n.ba((CharSequence)localObject2))) {
          break label375;
        }
      }
      label375:
      for (i = 1;; i = 0)
      {
        if ((i != 0) || (!u.agG((String)localObject1))) {
          break label380;
        }
        bool = true;
        break;
        i = 0;
        break label325;
      }
      label380:
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private final void gmz()
  {
    AppMethodBeat.i(234738);
    Object localObject = gmA();
    ((com.tencent.mm.plugin.textstatus.a.q)localObject).MEI = 2;
    ((com.tencent.mm.plugin.textstatus.a.q)localObject).MEJ = this.username;
    ((com.tencent.mm.plugin.textstatus.a.q)localObject).MEB = false;
    ((com.tencent.mm.plugin.textstatus.a.q)localObject).MEC = 7L;
    com.tencent.mm.plugin.textstatus.a.s locals = com.tencent.mm.plugin.textstatus.a.s.MzQ;
    com.tencent.mm.plugin.textstatus.a.s.a(this.mContext, (com.tencent.mm.plugin.textstatus.a.q)localObject);
    localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
    com.tencent.mm.plugin.textstatus.h.a.a(this.mContext, 52L, null, null, 12);
    AppMethodBeat.o(234738);
  }
  
  private final boolean isSelf()
  {
    AppMethodBeat.i(234741);
    boolean bool = TextUtils.equals((CharSequence)this.username, (CharSequence)com.tencent.mm.plugin.auth.a.a.crN());
    AppMethodBeat.o(234741);
    return bool;
  }
  
  public final void KN(String paramString)
  {
    AppMethodBeat.i(234718);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(234718);
      return;
    }
    new n.e(paramString, (com.tencent.mm.plugin.textstatus.a.n)this);
    localObject = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.secdata.ui.a)com.tencent.mm.ui.component.g.lm(this.mContext).i(com.tencent.mm.plugin.secdata.ui.a.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(com.tencent.mm.plugin.textstatus.proto.f.class, 9, (byte)0));
    localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a(this.mContext, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject).sessionId = this.sessionId;
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject).username = paramString;
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject).MEZ = 4;
    }
    this.username = paramString;
    new n.e(paramString, (com.tencent.mm.plugin.textstatus.a.n)this);
    localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
    this.MCs = com.tencent.mm.plugin.textstatus.b.f.bep(paramString);
    localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
    com.tencent.mm.plugin.textstatus.b.f.gly().bew(paramString);
    boolean bool = this.MJY.aUx(paramString);
    paramString = this.mContext.getResources();
    p.j(paramString, "mContext.resources");
    paramString = paramString.getConfiguration();
    p.j(paramString, "mContext.resources.configuration");
    if (paramString.orientation == 2)
    {
      i = 1;
      if ((!bool) || (i != 0)) {
        break label356;
      }
      j = 1;
      label247:
      if (j != 0) {
        break label361;
      }
      paramString = this.MKe;
      if (paramString != null) {
        paramString.setPadding(paramString.getPaddingLeft(), paramString.getPaddingTop(), paramString.getPaddingRight(), com.tencent.mm.ci.a.fromDPToPix(this.mContext, 32));
      }
      paramString = this.kDt;
      if (paramString != null)
      {
        paramString = paramString.getLayoutParams();
        if (paramString != null) {
          paramString.height = -2;
        }
      }
      paramString = this.wRV;
      if (i == 0) {
        break label608;
      }
    }
    label608:
    for (int j = 8;; j = 0)
    {
      paramString.setVisibility(j);
      if (i == 0) {
        break label613;
      }
      paramString = com.tencent.mm.plugin.textstatus.k.n.MOY;
      com.tencent.mm.plugin.textstatus.k.n.aN((Map)this.MJZ);
      AppMethodBeat.o(234718);
      return;
      i = 0;
      break;
      label356:
      j = 0;
      break label247;
      label361:
      j = ak.kU(this.mContext).width;
      paramString = this.MKe;
      if (paramString != null) {
        paramString.setPadding(paramString.getPaddingLeft(), paramString.getPaddingTop(), paramString.getPaddingRight(), com.tencent.mm.ci.a.fromDPToPix(this.mContext, 16));
      }
      if (this.MJY.gkG())
      {
        paramString = this.kDt;
        if (paramString != null)
        {
          paramString = paramString.getLayoutParams();
          if (paramString != null) {
            paramString.height = j;
          }
        }
        this.MCq.getLayoutParams().height = 0;
        paramString = this.MCq.getLayoutParams();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(234718);
          throw paramString;
        }
      }
      for (((LinearLayout.LayoutParams)paramString).weight = 1.0F;; ((LinearLayout.LayoutParams)paramString).weight = 0.0F)
      {
        paramString = this.kDt;
        if (paramString == null) {
          break;
        }
        paramString = paramString.findViewById(b.e.v_intercept_head_root_click);
        if (paramString == null) {
          break;
        }
        paramString.setOnClickListener((View.OnClickListener)new g.d(this));
        break;
        paramString = this.kDt;
        if (paramString != null)
        {
          paramString = paramString.getLayoutParams();
          if (paramString != null) {
            paramString.height = -2;
          }
        }
        this.MCq.getLayoutParams().height = -2;
        paramString = this.MCq.getLayoutParams();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(234718);
          throw paramString;
        }
      }
    }
    label613:
    if (!bool)
    {
      this.wRV.setVisibility(8);
      paramString = com.tencent.mm.plugin.textstatus.k.n.MOY;
      com.tencent.mm.plugin.textstatus.k.n.aN((Map)this.MJZ);
      AppMethodBeat.o(234718);
      return;
    }
    this.wRV.setVisibility(0);
    com.tencent.mm.plugin.textstatus.k.n.MOY.a((View)this.MKe, -1, (Map)this.MJZ);
    localObject = com.tencent.mm.plugin.textstatus.k.c.gnz();
    paramString = this.MCs;
    if (paramString != null) {}
    for (paramString = paramString.field_IconID;; paramString = null)
    {
      paramString = ((com.tencent.mm.plugin.textstatus.k.a)localObject).beJ(paramString);
      localObject = this.MBS;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)(this.mContext.getString(b.h.Mzd) + paramString));
      }
      this.wRV.setOnClickListener((View.OnClickListener)this);
      paramString = this.MKn;
      if (paramString != null) {
        paramString.setOnClickListener((View.OnClickListener)this);
      }
      paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramString = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a(this.mContext, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
      if ((paramString == null) || (TextUtils.equals((CharSequence)paramString.sessionId, (CharSequence)this.MKb))) {
        break;
      }
      localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(this.mContext, 1L, null, null, 12);
      localObject = paramString.sessionId;
      p.j(localObject, "it.sessionId");
      this.MKb = ((String)localObject);
      localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(paramString);
      AppMethodBeat.o(234718);
      return;
    }
    AppMethodBeat.o(234718);
  }
  
  public final void a(h.a parama)
  {
    this.MAH = parama;
  }
  
  public final void abo(int paramInt)
  {
    AppMethodBeat.i(234730);
    this.MJY.abo(paramInt);
    AppMethodBeat.o(234730);
  }
  
  public final void abp(int paramInt)
  {
    AppMethodBeat.i(234731);
    this.MJY.abp(paramInt);
    AppMethodBeat.o(234731);
  }
  
  public final void abq(int paramInt)
  {
    AppMethodBeat.i(234732);
    this.MJY.abq(paramInt);
    AppMethodBeat.o(234732);
  }
  
  public final void dDB()
  {
    AppMethodBeat.i(234726);
    this.MJY.dDB();
    AppMethodBeat.o(234726);
  }
  
  public final void dDC()
  {
    AppMethodBeat.i(234727);
    this.MJY.dDC();
    AppMethodBeat.o(234727);
  }
  
  public final void fqe()
  {
    AppMethodBeat.i(234728);
    this.MJY.fqe();
    AppMethodBeat.o(234728);
  }
  
  public final void fqf()
  {
    AppMethodBeat.i(234729);
    this.MJY.fqf();
    AppMethodBeat.o(234729);
  }
  
  public final void g(View.OnClickListener paramOnClickListener)
  {
    this.dig = paramOnClickListener;
  }
  
  public final View getView()
  {
    return this.wRV;
  }
  
  public final void gkI()
  {
    AppMethodBeat.i(234720);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(234720);
    throw localThrowable;
  }
  
  public final void gkJ()
  {
    AppMethodBeat.i(234721);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(234721);
    throw localThrowable;
  }
  
  public final void gkK()
  {
    AppMethodBeat.i(234722);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(234722);
    throw localThrowable;
  }
  
  public final void gmx()
  {
    AppMethodBeat.i(234736);
    int i;
    if ((!isSelf()) && (gmy())) {
      i = 1;
    }
    while (i != 0)
    {
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.lastClickTime) < 1000L)
      {
        AppMethodBeat.o(234736);
        return;
        i = 0;
      }
      else
      {
        this.lastClickTime = l;
        Object localObject = new m(this.mContext);
        ((m)localObject).a((q.f)g.b.MKq);
        ((m)localObject).a((q.g)new c(this));
        ((m)localObject).hYu();
        localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.mContext, 51L, null, null, 12);
      }
    }
    AppMethodBeat.o(234736);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(234737);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/ProfileCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    localObject = this.dig;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.e.MwH;
      if (paramView != null) {
        break label111;
      }
      label75:
      i = b.e.Mxg;
      if (paramView != null) {
        break label126;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/ProfileCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234737);
      return;
      paramView = null;
      break;
      label111:
      if (paramView.intValue() != i) {
        break label75;
      }
      gmx();
      continue;
      label126:
      if (paramView.intValue() == i)
      {
        gmz();
        paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.mContext, 53L, null, null, 12);
      }
    }
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(234725);
    this.MJY.onPostClose();
    TextView localTextView = this.MKn;
    if (localTextView != null)
    {
      localTextView.setVisibility(8);
      AppMethodBeat.o(234725);
      return;
    }
    AppMethodBeat.o(234725);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(234724);
    this.MJY.onPostOpen(paramBoolean);
    if ((!isSelf()) && (gmy()))
    {
      TextView localTextView = this.MKn;
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        AppMethodBeat.o(234724);
        return;
      }
    }
    AppMethodBeat.o(234724);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(234743);
    boolean bool;
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.g.b))
    {
      com.tencent.mm.kernel.h.aGY().b(((com.tencent.mm.plugin.textstatus.g.b)paramq).getType(), (com.tencent.mm.an.i)this);
      bool = false;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label86;
      }
      bool = true;
    }
    for (;;)
    {
      paramString = this.MAH;
      if (paramString != null) {
        paramString.dZ(Boolean.valueOf(bool));
      }
      paramString = this.iYE;
      if (paramString == null) {
        break;
      }
      paramString.dismiss();
      AppMethodBeat.o(234743);
      return;
      label86:
      com.tencent.mm.ui.base.h.af(this.mContext, this.mContext.getString(b.h.Myu), "");
    }
    AppMethodBeat.o(234743);
  }
  
  public final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(234723);
    this.MJY.r(paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(234723);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements q.g
  {
    c(g paramg) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(233003);
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == b.e.Mww)
      {
        g.a(this.MKp);
        paramMenuItem = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.MKp.mContext, 52L, null, null, 12);
      }
      AppMethodBeat.o(233003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.g
 * JD-Core Version:    0.7.0.1
 */