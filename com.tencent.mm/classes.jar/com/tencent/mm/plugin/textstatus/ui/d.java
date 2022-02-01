package com.tencent.mm.plugin.textstatus.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.a.f.a;
import com.tencent.mm.plugin.textstatus.a.j;
import com.tencent.mm.plugin.textstatus.d.e;
import com.tencent.mm.plugin.textstatus.f.k.e;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ah.a;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "extraPadding", "", "(Landroid/content/Context;Landroid/widget/RelativeLayout;Landroid/widget/LinearLayout;I)V", "backgroundId", "getBackgroundId", "()I", "setBackgroundId", "(I)V", "btnJoin", "Landroid/widget/ImageView;", "getBtnJoin", "()Landroid/widget/ImageView;", "setBtnJoin", "(Landroid/widget/ImageView;)V", "btnLike", "getBtnLike", "setBtnLike", "cardView", "Landroid/view/View;", "clickListener", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "iconAvatarNotify", "getIconAvatarNotify", "setIconAvatarNotify", "iconAvatarNotifyNoStatus", "getIconAvatarNotifyNoStatus", "setIconAvatarNotifyNoStatus", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivRealAddStatus", "getIvRealAddStatus", "setIvRealAddStatus", "lastExposedSessionId", "", "layoutAddStatus", "getLayoutAddStatus", "()Landroid/view/View;", "setLayoutAddStatus", "(Landroid/view/View;)V", "layoutCardContent", "getLayoutCardContent", "()Landroid/widget/RelativeLayout;", "setLayoutCardContent", "(Landroid/widget/RelativeLayout;)V", "layoutNoStatus", "getLayoutNoStatus", "setLayoutNoStatus", "layoutNotify", "getLayoutNotify", "()Landroid/widget/LinearLayout;", "setLayoutNotify", "(Landroid/widget/LinearLayout;)V", "layoutNotifyNoStatus", "getLayoutNotifyNoStatus", "setLayoutNotifyNoStatus", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "moreTabState", "Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;", "getMoreTabState", "()Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;", "setMoreTabState", "(Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;)V", "oriColorMap", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "Lkotlin/collections/HashMap;", "getOriColorMap", "()Ljava/util/HashMap;", "setOriColorMap", "(Ljava/util/HashMap;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "sessionId", "tvAddStatus", "getTvAddStatus", "()Landroid/widget/TextView;", "setTvAddStatus", "(Landroid/widget/TextView;)V", "tvChatCount", "getTvChatCount", "setTvChatCount", "tvDesc", "getTvDesc", "setTvDesc", "tvDescNotify", "getTvDescNotify", "setTvDescNotify", "tvDescNotifyNoStatus", "getTvDescNotifyNoStatus", "setTvDescNotifyNoStatus", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvNew", "getTvNew", "setTvNew", "tvNewInvisible", "getTvNewInvisible", "setTvNewInvisible", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "username", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "vBack", "getVBack", "setVBack", "fixLayout", "", "loadRes", "", "getLayoutId", "getView", "goDetail", "handleAddStatus", "handleNotify", "init", "initData", "isSelf", "onClick", "v", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTransAnim", "persent", "", "resumeNormalHeader", "setEventListener", "l", "setItemClickListener", "update", "updateNewTips", "Companion", "MoreTabState", "plugin-textstatus_release"})
public final class d
  implements View.OnClickListener, i, com.tencent.mm.plugin.textstatus.a.d
{
  public static final d.a Gdb;
  private static final String TAG = "MicroMsg.TxtStatus.MoreTabCardView";
  private f.a FXT;
  private TextView FYd;
  private TextView FYe;
  private TextView FYg;
  private ImageView FYh;
  private TextView FYj;
  private ImageView FYo;
  private ImageView FYp;
  private TextView FYq;
  com.tencent.mm.plugin.textstatus.f.f.a FYx;
  private RelativeLayout GcI;
  private ImageView GcJ;
  public View GcK;
  public TextView GcL;
  View GcM;
  ImageView GcN;
  private ImageView GcO;
  private TextView GcP;
  LinearLayout GcQ;
  private ImageView GcR;
  private TextView GcS;
  LinearLayout GcT;
  private TextView GcU;
  private com.tencent.mm.plugin.textstatus.d.c GcV;
  private HashMap<TextView, ColorStateList> GcW;
  private d.b GcX;
  private final LinearLayout GcZ;
  private final int Gda;
  private TextView UsO;
  private String UsP;
  private View.OnClickListener dec;
  com.tencent.mm.ui.base.q gut;
  private final RelativeLayout hOX;
  int jLt;
  Context mContext;
  private String sessionId;
  private final View tlx;
  private String username;
  
  static
  {
    AppMethodBeat.i(216397);
    Gdb = new d.a((byte)0);
    TAG = "MicroMsg.TxtStatus.MoreTabCardView";
    AppMethodBeat.o(216397);
  }
  
  public d(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(216396);
    this.hOX = paramRelativeLayout;
    this.GcZ = paramLinearLayout;
    this.Gda = 0;
    paramRelativeLayout = LayoutInflater.from(paramContext).inflate(2131496691, null, false);
    kotlin.g.b.p.g(paramRelativeLayout, "LayoutInflater.from(cont…tLayoutId(), null, false)");
    this.tlx = paramRelativeLayout;
    this.mContext = paramContext;
    this.GcW = new HashMap();
    this.jLt = 2131235261;
    paramRelativeLayout = e.FYH;
    this.GcV = e.fvR();
    this.GcV.ba(this.tlx);
    this.FYd = ((TextView)this.tlx.findViewById(2131309533));
    this.FYg = ((TextView)this.tlx.findViewById(2131309519));
    this.FYe = ((TextView)this.tlx.findViewById(2131309471));
    this.FYj = ((TextView)this.tlx.findViewById(2131309512));
    this.GcJ = ((ImageView)this.tlx.findViewById(2131297834));
    paramRelativeLayout = this.tlx.findViewById(2131297836);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.id.btn_like)");
    this.FYo = ((ImageView)paramRelativeLayout);
    this.FYp = ((ImageView)this.tlx.findViewById(2131302508));
    paramRelativeLayout = this.tlx.findViewById(2131302480);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.id.icon_avatar_notify)");
    this.GcO = ((ImageView)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131309472);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.id.tv_desc_notify)");
    this.GcP = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131303093);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.id.layout_notify)");
    this.GcQ = ((LinearLayout)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131302481);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.…_avatar_notify_no_status)");
    this.GcR = ((ImageView)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131309473);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.…tv_desc_notify_no_status)");
    this.GcS = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131303094);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.….layout_notify_no_status)");
    this.GcT = ((LinearLayout)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131309500);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.id.tv_like_num)");
    this.FYq = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131309508);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.id.tv_new)");
    this.GcU = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131310694);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.id.tv_new_invisible)");
    this.UsO = ((TextView)paramRelativeLayout);
    this.FYh = ((ImageView)this.tlx.findViewById(2131309661));
    this.GcI = ((RelativeLayout)this.tlx.findViewById(2131303084));
    paramRelativeLayout = this.tlx.findViewById(2131303092);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.id.layout_no_status)");
    this.GcK = paramRelativeLayout;
    paramRelativeLayout = this.tlx.findViewById(2131309451);
    kotlin.g.b.p.g(paramRelativeLayout, "cardView.findViewById(R.id.tv_add_status)");
    this.GcL = ((TextView)paramRelativeLayout);
    this.GcM = this.tlx.findViewById(2131303077);
    this.GcN = ((ImageView)this.tlx.findViewById(2131302904));
    paramRelativeLayout = com.tencent.mm.plugin.textstatus.j.f.Ggk;
    com.tencent.mm.plugin.textstatus.j.f.B((View)this.GcO, com.tencent.mm.cb.a.fromDPToPix(paramContext, 10.0F));
    paramRelativeLayout = com.tencent.mm.plugin.textstatus.j.f.Ggk;
    com.tencent.mm.plugin.textstatus.j.f.B((View)this.GcR, com.tencent.mm.cb.a.fromDPToPix(paramContext, 10.0F));
    this.tlx.setOnClickListener((View.OnClickListener)this);
    paramContext = (View.OnClickListener)new c(this);
    paramRelativeLayout = this.GcN;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setOnClickListener(paramContext);
    }
    paramRelativeLayout = this.GcM;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setOnClickListener(paramContext);
    }
    this.GcX = d.b.Gdc;
    this.sessionId = "";
    this.UsP = "";
    AppMethodBeat.o(216396);
  }
  
  @SuppressLint({"ResourceType"})
  private final void a(LinearLayout paramLinearLayout, ImageView paramImageView, TextView paramTextView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(216380);
    if (kotlin.g.b.p.j(com.tencent.mm.plugin.auth.a.a.ceA(), this.username))
    {
      Object localObject2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      final int i = com.tencent.mm.plugin.textstatus.b.f.fvN().ctM();
      if (i > 0)
      {
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.fvN().db.rawQuery("select rowid, * from TextStatusLike order by CreateTime DESC LIMIT 1", null);
        kotlin.g.b.p.g(localObject2, "db.rawQuery(sql, null)");
        if (localObject2 != null)
        {
          localObject1 = new com.tencent.mm.plugin.textstatus.f.f.b();
          if (((Cursor)localObject2).moveToNext()) {
            ((com.tencent.mm.plugin.textstatus.f.f.b)localObject1).convertFrom((Cursor)localObject2);
          }
          ((Cursor)localObject2).close();
        }
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
          localObject1 = com.tencent.mm.plugin.textstatus.b.f.fvO().aTn(((com.tencent.mm.plugin.textstatus.f.f.b)localObject1).field_HashUserName);
          if ((localObject1 != null) && (((as)localObject1).arv())) {
            a.b.c(paramImageView, ((as)localObject1).getUsername());
          }
        }
        else
        {
          if (i >= 99) {
            break label282;
          }
        }
        label282:
        for (paramImageView = this.mContext.getString(2131766730, new Object[] { Integer.valueOf(i) });; paramImageView = this.mContext.getString(2131766731))
        {
          kotlin.g.b.p.g(paramImageView, "if(unreadCnt < 99){\n    …o_many)\n                }");
          paramTextView.setText((CharSequence)paramImageView);
          paramLinearLayout.setVisibility(0);
          paramImageView = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.report22208(9L, String.valueOf(i));
          paramImageView = SecDataUIC.CWq;
          paramImageView = (y)SecDataUIC.a.a(this.mContext, 9, y.class);
          if (paramImageView != null) {
            paramImageView.UrZ = i;
          }
          paramLinearLayout.setOnClickListener((View.OnClickListener)new d(this, i));
          AppMethodBeat.o(216380);
          return;
          paramImageView.setImageResource(2131690042);
          break;
        }
      }
    }
    paramLinearLayout.setVisibility(8);
    AppMethodBeat.o(216380);
  }
  
  private final void fwk()
  {
    AppMethodBeat.i(216379);
    Object localObject = this.GcZ;
    if (localObject != null)
    {
      localObject = (NoMeasuredTextView)((LinearLayout)localObject).findViewById(2131305433);
      if (localObject != null) {
        ((NoMeasuredTextView)localObject).setTextColor(this.mContext.getResources().getColor(2131099746));
      }
    }
    localObject = this.GcZ;
    if (localObject != null)
    {
      localObject = (TextView)((LinearLayout)localObject).findViewById(2131309643);
      if (localObject != null)
      {
        ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131099748));
        ((TextView)localObject).setAlpha(1.0F);
      }
    }
    localObject = this.GcZ;
    if (localObject != null)
    {
      localObject = (WeImageView)((LinearLayout)localObject).findViewById(2131306383);
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(this.mContext.getResources().getColor(2131099748));
      }
    }
    localObject = this.GcZ;
    if (localObject != null)
    {
      localObject = (WeImageView)((LinearLayout)localObject).findViewById(2131297043);
      if (localObject != null)
      {
        ((WeImageView)localObject).setIconColor(this.mContext.getResources().getColor(2131099749));
        AppMethodBeat.o(216379);
        return;
      }
    }
    AppMethodBeat.o(216379);
  }
  
  public final void DV(String paramString)
  {
    AppMethodBeat.i(216381);
    Log.i(TAG, "[update] username:%s", new Object[] { paramString });
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216381);
      return;
    }
    new k.e(paramString, (j)this);
    localObject = SecDataUIC.CWq;
    localObject = (y)SecDataUIC.a.a(this.mContext, 9, y.class);
    if (localObject != null)
    {
      String str = ((y)localObject).sessionId;
      kotlin.g.b.p.g(str, "it.sessionId");
      this.sessionId = str;
      ((y)localObject).username = paramString;
      ((y)localObject).UrY = 5;
    }
    this.username = paramString;
    new k.e(paramString, (j)this);
    localObject = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    this.FYx = com.tencent.mm.plugin.textstatus.b.f.aTf(paramString);
    this.GcV.a(new com.tencent.mm.plugin.textstatus.d.d.a(false));
    boolean bool = this.GcV.aNc(paramString);
    if (!bool)
    {
      paramString = this.GcZ;
      if (paramString != null) {
        paramString.setPadding(paramString.getPaddingLeft(), paramString.getPaddingTop(), paramString.getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16));
      }
      this.tlx.getLayoutParams().height = -2;
      paramString = this.hOX;
      if (paramString != null)
      {
        paramString = paramString.getLayoutParams();
        if (paramString != null) {
          paramString.height = -2;
        }
      }
      if (bool) {
        break label683;
      }
      paramString = this.GcI;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.FYh;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.GcK;
      if (paramString == null) {
        kotlin.g.b.p.btv("layoutNoStatus");
      }
      paramString.setVisibility(0);
      fwk();
      if (!com.tencent.mm.plugin.textstatus.a.p.fvF()) {
        break label662;
      }
      this.GcU.setVisibility(0);
      this.UsO.setVisibility(4);
      paramString = com.tencent.mm.plugin.textstatus.k.a.UsD;
      com.tencent.mm.plugin.textstatus.k.a.Rk(19L);
      label356:
      this.tlx.post((Runnable)new d.h(this));
      this.GcX = d.b.Gdc;
      label382:
      if (this.GcX != d.b.Gdc) {
        break label865;
      }
      a(this.GcT, this.GcR, this.GcS);
      label408:
      paramString = com.tencent.mm.plugin.textstatus.j.b.GfZ;
      paramString = this.FYx;
      if (paramString == null) {
        break label884;
      }
    }
    label657:
    label662:
    label683:
    label865:
    label884:
    for (paramString = paramString.field_IconID;; paramString = null)
    {
      paramString = com.tencent.mm.plugin.textstatus.j.b.getName(paramString);
      localObject = this.FYd;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)(this.mContext.getString(2131766739) + paramString));
      }
      paramString = SecDataUIC.CWq;
      paramString = (y)SecDataUIC.a.a(this.mContext, 9, y.class);
      if ((paramString == null) || (TextUtils.equals((CharSequence)paramString.sessionId, (CharSequence)this.UsP))) {
        break label889;
      }
      localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
      com.tencent.mm.plugin.textstatus.k.a.a(1L, paramString);
      paramString = paramString.sessionId;
      kotlin.g.b.p.g(paramString, "it.sessionId");
      this.UsP = paramString;
      AppMethodBeat.o(216381);
      return;
      i = ah.jS(this.mContext).width;
      paramString = this.hOX;
      if (paramString != null)
      {
        paramString = paramString.getLayoutParams();
        if (paramString != null) {
          paramString.height = i;
        }
      }
      localObject = this.hOX;
      if (localObject != null)
      {
        paramString = this.hOX;
        if (paramString == null) {
          break label657;
        }
      }
      for (paramString = paramString.getLayoutParams();; paramString = null)
      {
        ((RelativeLayout)localObject).setLayoutParams(paramString);
        paramString = this.GcZ;
        if (paramString == null) {
          break;
        }
        paramString.setPadding(paramString.getPaddingLeft(), paramString.getPaddingTop(), paramString.getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16));
        break;
      }
      this.GcU.setVisibility(8);
      this.UsO.setVisibility(8);
      break label356;
      paramString = this.GcI;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.FYh;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.GcK;
      if (paramString == null) {
        kotlin.g.b.p.btv("layoutNoStatus");
      }
      paramString.setVisibility(8);
      paramString = this.GcZ;
      if (paramString != null)
      {
        paramString = (TextView)paramString.findViewById(2131309643);
        if (paramString != null)
        {
          paramString.setTextColor(-1);
          paramString.setAlpha(0.6F);
        }
      }
      paramString = this.GcZ;
      if (paramString != null)
      {
        paramString = (NoMeasuredTextView)paramString.findViewById(2131305433);
        if (paramString != null) {
          paramString.setTextColor(-1);
        }
      }
      paramString = this.GcZ;
      if (paramString != null)
      {
        paramString = (WeImageView)paramString.findViewById(2131306383);
        if (paramString != null) {
          paramString.setIconColor(-1);
        }
      }
      paramString = this.GcZ;
      if (paramString != null)
      {
        paramString = (WeImageView)paramString.findViewById(2131297043);
        if (paramString != null) {
          paramString.setIconColor(-1);
        }
      }
      this.GcX = d.b.Gdd;
      break label382;
      a(this.GcQ, this.GcO, this.GcP);
      break label408;
    }
    label889:
    AppMethodBeat.o(216381);
  }
  
  public final void UC(int paramInt)
  {
    AppMethodBeat.i(216391);
    this.GcV.UC(paramInt);
    AppMethodBeat.o(216391);
  }
  
  public final void UD(int paramInt)
  {
    AppMethodBeat.i(216392);
    this.GcV.UD(paramInt);
    AppMethodBeat.o(216392);
  }
  
  public final void UE(int paramInt)
  {
    AppMethodBeat.i(216393);
    this.GcV.UE(paramInt);
    AppMethodBeat.o(216393);
  }
  
  public final void a(f.a parama)
  {
    this.FXT = parama;
  }
  
  public final void cd(float paramFloat) {}
  
  public final void eEk()
  {
    AppMethodBeat.i(216387);
    com.tencent.mm.plugin.textstatus.k.a locala = com.tencent.mm.plugin.textstatus.k.a.UsD;
    com.tencent.mm.plugin.textstatus.k.a.report22208(17L, "1");
    this.GcV.eEk();
    AppMethodBeat.o(216387);
  }
  
  public final void eEl()
  {
    AppMethodBeat.i(216388);
    this.GcV.eEl();
    AppMethodBeat.o(216388);
  }
  
  public final void eEm()
  {
    AppMethodBeat.i(216389);
    this.GcV.eEm();
    AppMethodBeat.o(216389);
  }
  
  public final void eEn()
  {
    AppMethodBeat.i(216390);
    this.GcV.eEn();
    AppMethodBeat.o(216390);
  }
  
  public final void f(View.OnClickListener paramOnClickListener)
  {
    this.dec = paramOnClickListener;
  }
  
  public final void fvv()
  {
    AppMethodBeat.i(216382);
    fwk();
    Object localObject = this.hOX;
    if (localObject != null) {
      ((RelativeLayout)localObject).removeView(this.tlx);
    }
    localObject = this.hOX;
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -2;
      }
    }
    localObject = this.GcZ;
    if (localObject != null)
    {
      ((LinearLayout)localObject).setPadding(((LinearLayout)localObject).getPaddingLeft(), ((LinearLayout)localObject).getPaddingTop(), ((LinearLayout)localObject).getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 40));
      AppMethodBeat.o(216382);
      return;
    }
    AppMethodBeat.o(216382);
  }
  
  public final void fvw()
  {
    AppMethodBeat.i(216383);
    DV(this.username);
    AppMethodBeat.o(216383);
  }
  
  public final void fvx()
  {
    AppMethodBeat.i(216384);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216384);
    throw localThrowable;
  }
  
  public final View getView()
  {
    return this.tlx;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216394);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    localObject = this.dec;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label99;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216394);
      return;
      paramView = null;
      break;
      label99:
      if ((paramView.intValue() == 2131309012) && (TextUtils.equals((CharSequence)this.username, (CharSequence)com.tencent.mm.plugin.auth.a.a.ceA())) && (this.GcX != d.b.Gdc))
      {
        paramView = new com.tencent.mm.ui.tools.l(this.mContext);
        paramView.a((o.f)new e(this));
        paramView.a((o.g)new f(this));
        paramView.a((e.a)new g(this));
        paramView.gXI();
        paramView = SecDataUIC.CWq;
        paramView = (y)SecDataUIC.a.a(this.mContext, 9, y.class);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.a(31L, paramView);
        }
      }
    }
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(216386);
    this.GcV.onPostClose();
    AppMethodBeat.o(216386);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(216385);
    this.GcV.onPostOpen(paramBoolean);
    AppMethodBeat.o(216385);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216395);
    boolean bool;
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.f.b))
    {
      g.azz().b(((com.tencent.mm.plugin.textstatus.f.b)paramq).getType(), (i)this);
      bool = false;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label86;
      }
      bool = true;
    }
    for (;;)
    {
      paramString = this.FXT;
      if (paramString != null) {
        paramString.dV(Boolean.valueOf(bool));
      }
      paramString = this.gut;
      if (paramString == null) {
        break;
      }
      paramString.dismiss();
      AppMethodBeat.o(216395);
      return;
      label86:
      h.X(this.mContext, this.mContext.getString(2131766714), "");
    }
    AppMethodBeat.o(216395);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216374);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$addStatusListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (com.tencent.mm.plugin.textstatus.a.p.fvF())
      {
        paramView = this.Gdf.GcN;
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        paramView = this.Gdf.GcM;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
      }
      com.tencent.mm.plugin.textstatus.a.p.fvE();
      paramView = new Bundle();
      paramView.putInt("KEY_DEFAULT_BACKGROUND_ID", this.Gdf.jLt);
      localObject = new com.tencent.mm.plugin.textstatus.a.m();
      ((com.tencent.mm.plugin.textstatus.a.m)localObject).sessionId = d.c(this.Gdf);
      if (this.Gdf.FYx == null) {}
      for (long l = 3L;; l = 4L)
      {
        ((com.tencent.mm.plugin.textstatus.a.m)localObject).UrT = l;
        paramView.putByteArray("SET_TEXT_PARAMS", ((com.tencent.mm.plugin.textstatus.a.m)localObject).toByteArray());
        localObject = TextStatusDoWhatActivity.GdF;
        TextStatusDoWhatActivity.a.g(this.Gdf.mContext, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$addStatusListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216374);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(d paramd, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(258442);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$handleNotify$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = TextStatusLikeListActivity.Gfx;
      TextStatusLikeListActivity.b.hs(this.Gdf.mContext);
      this.Gdf.GcQ.setVisibility(8);
      this.Gdf.GcT.setVisibility(8);
      paramView = com.tencent.mm.plugin.textstatus.k.a.UsD;
      com.tencent.mm.plugin.textstatus.k.a.report22208(10L, String.valueOf(i));
      paramView = SecDataUIC.CWq;
      paramView = (y)SecDataUIC.a.a(this.Gdf.mContext, 9, y.class);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
        com.tencent.mm.plugin.textstatus.k.a.a(41L, String.valueOf(i), paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$handleNotify$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(258442);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements o.f
  {
    e(d paramd) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(216376);
      paramm.d(2131304629, (CharSequence)this.Gdf.mContext.getString(2131766736));
      paramm.d(2131304615, (CharSequence)this.Gdf.mContext.getString(2131766720));
      AppMethodBeat.o(216376);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements o.g
  {
    f(d paramd) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(216377);
      kotlin.g.b.p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == 2131304633)
      {
        d.b(this.Gdf);
        AppMethodBeat.o(216377);
        return;
      }
      Object localObject;
      if (paramInt == 2131304629)
      {
        paramMenuItem = TextStatusEditActivity.GeM;
        TextStatusEditActivity.a.b(this.Gdf.mContext, null);
        paramMenuItem = com.tencent.mm.plugin.textstatus.k.a.UsD;
        com.tencent.mm.plugin.textstatus.k.a.Rk(16L);
        paramMenuItem = SecDataUIC.CWq;
        paramMenuItem = (y)SecDataUIC.a.a(this.Gdf.mContext, 9, y.class);
        if (paramMenuItem != null)
        {
          localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.a(32L, paramMenuItem);
          AppMethodBeat.o(216377);
          return;
        }
        AppMethodBeat.o(216377);
        return;
      }
      Context localContext;
      if (paramInt == 2131304615)
      {
        paramMenuItem = this.Gdf.FYx;
        if (paramMenuItem != null)
        {
          localObject = this.Gdf;
          localContext = this.Gdf.mContext;
          this.Gdf.mContext.getString(2131766715);
          ((d)localObject).gut = h.a(localContext, this.Gdf.mContext.getString(2131766715), false, null);
          paramMenuItem = paramMenuItem.field_StatusID;
          kotlin.g.b.p.g(paramMenuItem, "this.field_StatusID");
          paramMenuItem = new com.tencent.mm.plugin.textstatus.f.a(paramMenuItem, 1);
          g.azz().a(paramMenuItem.getType(), (i)new com.tencent.mm.plugin.textstatus.d.f((i)this.Gdf));
          g.azz().b((com.tencent.mm.ak.q)paramMenuItem);
        }
        paramMenuItem = SecDataUIC.CWq;
        paramMenuItem = (y)SecDataUIC.a.a(this.Gdf.mContext, 9, y.class);
        if (paramMenuItem != null)
        {
          localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.a(33L, paramMenuItem);
          AppMethodBeat.o(216377);
          return;
        }
        AppMethodBeat.o(216377);
        return;
      }
      if (paramInt == 2131304610)
      {
        paramMenuItem = this.Gdf.FYx;
        if (paramMenuItem != null)
        {
          localObject = this.Gdf;
          localContext = this.Gdf.mContext;
          this.Gdf.mContext.getString(2131766715);
          ((d)localObject).gut = h.a(localContext, this.Gdf.mContext.getString(2131766715), false, null);
          paramMenuItem = paramMenuItem.field_StatusID;
          kotlin.g.b.p.g(paramMenuItem, "this.field_StatusID");
          paramMenuItem = new com.tencent.mm.plugin.textstatus.f.a(paramMenuItem, 2);
          g.azz().a(paramMenuItem.getType(), (i)new com.tencent.mm.plugin.textstatus.d.f((i)this.Gdf));
          g.azz().b((com.tencent.mm.ak.q)paramMenuItem);
          AppMethodBeat.o(216377);
          return;
        }
      }
      AppMethodBeat.o(216377);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class g
    implements e.a
  {
    g(d paramd) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(258443);
      Object localObject = SecDataUIC.CWq;
      localObject = (y)SecDataUIC.a.a(this.Gdf.mContext, 9, y.class);
      if (localObject != null)
      {
        com.tencent.mm.plugin.textstatus.k.a locala = com.tencent.mm.plugin.textstatus.k.a.UsD;
        com.tencent.mm.plugin.textstatus.k.a.a(34L, (y)localObject);
        AppMethodBeat.o(258443);
        return;
      }
      AppMethodBeat.o(258443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.d
 * JD-Core Version:    0.7.0.1
 */