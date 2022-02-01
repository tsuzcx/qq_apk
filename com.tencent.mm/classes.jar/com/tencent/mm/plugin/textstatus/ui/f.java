package com.tencent.mm.plugin.textstatus.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.h.a;
import com.tencent.mm.plugin.textstatus.a.q.a;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.a.t.b;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.g;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.e.g;
import com.tencent.mm.plugin.textstatus.g.n.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "extraPadding", "", "(Landroid/content/Context;Landroid/widget/RelativeLayout;Landroid/widget/LinearLayout;I)V", "btnJoin", "Landroid/widget/ImageView;", "getBtnJoin", "()Landroid/widget/ImageView;", "setBtnJoin", "(Landroid/widget/ImageView;)V", "btnLike", "getBtnLike", "setBtnLike", "btnStyle", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusSwitch$StatusBtnStyle;", "getBtnStyle", "()Lcom/tencent/mm/plugin/textstatus/api/TextStatusSwitch$StatusBtnStyle;", "setBtnStyle", "(Lcom/tencent/mm/plugin/textstatus/api/TextStatusSwitch$StatusBtnStyle;)V", "cardView", "Landroid/view/View;", "clickListener", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "iconAvatarNotify", "getIconAvatarNotify", "setIconAvatarNotify", "iconAvatarNotifyNoStatus", "getIconAvatarNotifyNoStatus", "setIconAvatarNotifyNoStatus", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivSameFriendsRecommend", "getIvSameFriendsRecommend", "setIvSameFriendsRecommend", "ivTopicSquareEntry", "getIvTopicSquareEntry", "setIvTopicSquareEntry", "ivTopicSquareEntryStoryStyle", "getIvTopicSquareEntryStoryStyle", "setIvTopicSquareEntryStoryStyle", "lastClickTime", "", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lastExposedSessionId", "", "lastStatusId", "layoutAddStatus", "getLayoutAddStatus", "()Landroid/view/View;", "setLayoutAddStatus", "(Landroid/view/View;)V", "layoutCardContent", "getLayoutCardContent", "()Landroid/widget/RelativeLayout;", "setLayoutCardContent", "(Landroid/widget/RelativeLayout;)V", "layoutCenter", "getLayoutCenter", "()Landroid/widget/LinearLayout;", "setLayoutCenter", "(Landroid/widget/LinearLayout;)V", "layoutNoStatus", "getLayoutNoStatus", "setLayoutNoStatus", "layoutNotify", "getLayoutNotify", "setLayoutNotify", "layoutNotifyNoStatus", "getLayoutNotifyNoStatus", "setLayoutNotifyNoStatus", "layoutSameFriendsRecommend", "getLayoutSameFriendsRecommend", "setLayoutSameFriendsRecommend", "layoutTopicSquareEntry", "getLayoutTopicSquareEntry", "setLayoutTopicSquareEntry", "layoutTopicSquareEntryAvatarStyle", "getLayoutTopicSquareEntryAvatarStyle", "setLayoutTopicSquareEntryAvatarStyle", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "moreTabState", "Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;", "getMoreTabState", "()Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;", "setMoreTabState", "(Lcom/tencent/mm/plugin/textstatus/ui/MoreTabCardView$MoreTabState;)V", "oriColorMap", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "Lkotlin/collections/HashMap;", "getOriColorMap", "()Ljava/util/HashMap;", "setOriColorMap", "(Ljava/util/HashMap;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "sessionId", "tvAddStatus", "getTvAddStatus", "()Landroid/widget/TextView;", "setTvAddStatus", "(Landroid/widget/TextView;)V", "tvChatCount", "getTvChatCount", "setTvChatCount", "tvDesc", "getTvDesc", "setTvDesc", "tvDescNotify", "getTvDescNotify", "setTvDescNotify", "tvDescNotifyNoStatus", "getTvDescNotifyNoStatus", "setTvDescNotifyNoStatus", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvNewInvisible", "getTvNewInvisible", "setTvNewInvisible", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsRecommend", "getTvSameFriendsRecommend", "setTvSameFriendsRecommend", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "tvTopicSquareEntry", "getTvTopicSquareEntry", "setTvTopicSquareEntry", "username", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "vBack", "getVBack", "setVBack", "cardClick", "", "fixLayout", "loadRes", "", "getLayoutId", "getSetStatusParams", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "isInModify", "getView", "goDetail", "goModifyStatus", "handleNotify", "resIdNewMsg", "resIdNewMsgTooMany", "handleTopicSquareEntry", "init", "initData", "isSelf", "jumpToPickAndEdit", "backgroundId", "onClick", "v", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onPullDownProgress", "persent", "", "curTranslation", "unfoldTranslation", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "resumeNormalHeader", "setEventListener", "l", "setItemClickListener", "update", "updateNewTips", "Companion", "MoreTabState", "plugin-textstatus_release"})
public final class f
  implements View.OnClickListener, i, com.tencent.mm.plugin.textstatus.a.e
{
  public static final f.a MKg;
  private static final String TAG = "MicroMsg.TextStatus.MoreTabCardView";
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
  com.tencent.mm.plugin.textstatus.g.e.a MCs;
  private RelativeLayout MJG;
  private ImageView MJH;
  public View MJI;
  public TextView MJJ;
  View MJK;
  private ImageView MJL;
  private TextView MJM;
  LinearLayout MJN;
  private View MJO;
  private ImageView MJP;
  private TextView MJQ;
  LinearLayout MJR;
  private TextView MJS;
  private ImageView MJT;
  private ImageView MJU;
  private LinearLayout MJV;
  private TextView MJW;
  private LinearLayout MJX;
  private com.tencent.mm.plugin.textstatus.e.d MJY;
  private HashMap<TextView, ColorStateList> MJZ;
  private f.b MKa;
  private String MKb;
  private String MKc;
  t.b MKd;
  private final LinearLayout MKe;
  private final int MKf;
  private View.OnClickListener dig;
  s iYE;
  private final RelativeLayout kDt;
  private long lastClickTime;
  Context mContext;
  private String sessionId;
  private String username;
  private final View wRV;
  
  static
  {
    AppMethodBeat.i(232778);
    MKg = new f.a((byte)0);
    TAG = "MicroMsg.TextStatus.MoreTabCardView";
    AppMethodBeat.o(232778);
  }
  
  public f(final Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(232777);
    this.kDt = paramRelativeLayout;
    this.MKe = paramLinearLayout;
    this.MKf = 0;
    paramRelativeLayout = LayoutInflater.from(paramContext).inflate(b.f.MxS, null, false);
    p.j(paramRelativeLayout, "LayoutInflater.from(cont…tLayoutId(), null, false)");
    this.wRV = paramRelativeLayout;
    this.mContext = paramContext;
    this.MJZ = new HashMap();
    paramRelativeLayout = com.tencent.mm.plugin.textstatus.e.f.MCG;
    paramRelativeLayout = r.gkR();
    p.j(paramRelativeLayout, "StatusShowParam.defMoreTab()");
    this.MJY = com.tencent.mm.plugin.textstatus.e.f.b(paramRelativeLayout);
    this.MJY.g(this.wRV);
    this.MJY.ag((kotlin.g.a.a)new f.1(this));
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
    paramRelativeLayout = this.wRV.findViewById(b.e.Mvf);
    p.j(paramRelativeLayout, "cardView.findViewById(R.…_avatar_notify_no_status)");
    this.MJP = ((ImageView)paramRelativeLayout);
    paramRelativeLayout = this.wRV.findViewById(b.e.MwS);
    p.j(paramRelativeLayout, "cardView.findViewById(R.…tv_desc_notify_no_status)");
    this.MJQ = ((TextView)paramRelativeLayout);
    this.MJQ.setTextSize(0, com.tencent.mm.ci.a.aZ(paramContext, b.c.DescTextSize));
    paramRelativeLayout = this.wRV.findViewById(b.e.MvX);
    p.j(paramRelativeLayout, "cardView.findViewById(R.….layout_notify_no_status)");
    this.MJR = ((LinearLayout)paramRelativeLayout);
    paramRelativeLayout = this.wRV.findViewById(b.e.MwY);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.tv_like_num)");
    this.MCh = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.wRV.findViewById(b.e.Mxb);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.tv_new_invisible)");
    this.MJS = ((TextView)paramRelativeLayout);
    this.MBW = ((ImageView)this.wRV.findViewById(b.e.Mxr));
    this.MJG = ((RelativeLayout)this.wRV.findViewById(b.e.MvM));
    paramRelativeLayout = this.wRV.findViewById(b.e.MvV);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.layout_no_status)");
    this.MJI = paramRelativeLayout;
    paramRelativeLayout = this.wRV.findViewById(b.e.MwN);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.tv_add_status)");
    this.MJJ = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.MJJ;
    if (paramRelativeLayout == null) {
      p.bGy("tvAddStatus");
    }
    paramRelativeLayout.setTextSize(0, com.tencent.mm.ci.a.aZ(paramContext, b.c.DescTextSize));
    this.MJK = this.wRV.findViewById(b.e.MvE);
    this.MJT = ((ImageView)this.wRV.findViewById(b.e.MvC));
    this.MJU = ((ImageView)this.wRV.findViewById(b.e.MvD));
    this.MJV = ((LinearLayout)this.wRV.findViewById(b.e.Mwe));
    this.MJX = ((LinearLayout)this.wRV.findViewById(b.e.Mwl));
    int i = paramContext.getResources().getColor(b.b.FG_1);
    paramRelativeLayout = au.e(paramContext.getResources().getDrawable(b.g.icons_filled_more), i);
    p.j(paramRelativeLayout, "iconDrawable");
    paramRelativeLayout.setAlpha(Color.alpha(i));
    paramLinearLayout = this.MJT;
    if (paramLinearLayout != null) {
      paramLinearLayout.setImageDrawable(paramRelativeLayout);
    }
    this.MJW = ((TextView)this.wRV.findViewById(b.e.Mxo));
    paramRelativeLayout = this.MJW;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setTextSize(0, com.tencent.mm.ci.a.aZ(paramContext, b.c.DescTextSize));
    }
    paramRelativeLayout = this.wRV.findViewById(b.e.MvN);
    p.j(paramRelativeLayout, "cardView.findViewById(R.id.layout_center)");
    this.MCq = ((LinearLayout)paramRelativeLayout);
    paramRelativeLayout = com.tencent.mm.plugin.textstatus.k.n.MOY;
    com.tencent.mm.plugin.textstatus.k.n.B((View)this.MJL, com.tencent.mm.ci.a.fromDPToPix(paramContext, 10.0F));
    paramRelativeLayout = com.tencent.mm.plugin.textstatus.k.n.MOY;
    com.tencent.mm.plugin.textstatus.k.n.B((View)this.MJP, com.tencent.mm.ci.a.fromDPToPix(paramContext, 10.0F));
    this.wRV.setOnClickListener((View.OnClickListener)this);
    paramRelativeLayout = (View.OnClickListener)new f.c(this);
    paramLinearLayout = this.MJK;
    if (paramLinearLayout != null) {
      paramLinearLayout.setOnClickListener(paramRelativeLayout);
    }
    paramRelativeLayout = this.MJX;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(237386);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.textstatus.a.t.a(this.MKh.MKd);
          paramAnonymousView = TextStatusOtherTopicFriendsActivity.MNI;
          TextStatusOtherTopicFriendsActivity.a.iy(paramContext);
          paramAnonymousView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
          paramAnonymousView = com.tencent.mm.plugin.textstatus.b.f.MAm;
          com.tencent.mm.plugin.textstatus.h.a.a(21L, String.valueOf(com.tencent.mm.plugin.textstatus.b.f.gly().gmg()), null, this.MKh.MKd.glx(), 4);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(237386);
        }
      });
    }
    this.MKa = f.b.MKi;
    this.sessionId = "";
    this.MKb = "";
    this.MKc = "";
    this.MKd = new t.b();
    AppMethodBeat.o(232777);
  }
  
  private final com.tencent.mm.plugin.textstatus.a.q Ae(boolean paramBoolean)
  {
    AppMethodBeat.i(232730);
    com.tencent.mm.plugin.textstatus.a.q localq = new q.a().gkO();
    localq.sessionId = this.sessionId;
    long l;
    if (paramBoolean) {
      l = 6L;
    }
    for (;;)
    {
      localq.MEC = l;
      p.j(localq, "setStatusParam");
      AppMethodBeat.o(232730);
      return localq;
      if (this.MCs == null) {
        l = 3L;
      } else {
        l = 4L;
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  private final void a(final LinearLayout paramLinearLayout, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2)
  {
    int j = -2147483648;
    Object localObject1 = null;
    AppMethodBeat.i(232736);
    Object localObject2;
    int i;
    final int k;
    Object localObject3;
    if (p.h(com.tencent.mm.plugin.auth.a.a.crN(), this.username))
    {
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      i = com.tencent.mm.plugin.textstatus.b.f.glz().cHo();
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      k = i + com.tencent.mm.plugin.textstatus.b.f.glB().cHo();
      if (k <= 0)
      {
        paramLinearLayout.setVisibility(8);
        paramLinearLayout = com.tencent.mm.plugin.secdata.ui.a.JbV;
        paramLinearLayout = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a(this.mContext, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
        if (paramLinearLayout != null)
        {
          paramLinearLayout.MFa = k;
          AppMethodBeat.o(232736);
        }
      }
      else
      {
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        localObject3 = com.tencent.mm.plugin.textstatus.b.f.glz().db.rawQuery("select rowid, * from TextStatusLike order by CreateTime DESC LIMIT 1", null);
        p.j(localObject3, "db.rawQuery(sql, null)");
        if (localObject3 == null) {
          break label514;
        }
        localObject2 = new com.tencent.mm.plugin.textstatus.g.e.b();
        if (((Cursor)localObject3).moveToNext()) {
          ((com.tencent.mm.plugin.textstatus.g.e.b)localObject2).convertFrom((Cursor)localObject3);
        }
        ((Cursor)localObject3).close();
      }
    }
    for (;;)
    {
      localObject3 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      Cursor localCursor = com.tencent.mm.plugin.textstatus.b.f.glB().db.rawQuery("select rowid, * from TextStatusReference order by CreateTime DESC LIMIT 1", null);
      p.j(localCursor, "db.rawQuery(sql, null)");
      if (localCursor != null)
      {
        localObject3 = new com.tencent.mm.plugin.textstatus.g.e.d();
        if (localCursor.moveToNext()) {
          ((com.tencent.mm.plugin.textstatus.g.e.d)localObject3).convertFrom(localCursor);
        }
        localCursor.close();
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          i = ((com.tencent.mm.plugin.textstatus.g.e.b)localObject2).field_CreateTime;
          label252:
          if (localObject3 != null) {
            j = ((com.tencent.mm.plugin.textstatus.g.e.d)localObject3).field_CreateTime;
          }
          if (i <= j) {
            break label419;
          }
          if (localObject2 != null)
          {
            localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
            localObject1 = com.tencent.mm.plugin.textstatus.b.f.glA().beA(((com.tencent.mm.plugin.textstatus.g.e.b)localObject2).field_HashUserName);
          }
          label294:
          if ((localObject1 == null) || (!((as)localObject1).axZ())) {
            break label465;
          }
          paramImageView.setImageResource(b.g.default_avatar);
          a.b.c(paramImageView, ((as)localObject1).getUsername());
          label323:
          if (k >= 99) {
            break label475;
          }
        }
        label419:
        label465:
        label475:
        for (paramImageView = this.mContext.getString(paramInt1, new Object[] { Integer.valueOf(k) });; paramImageView = this.mContext.getString(paramInt2))
        {
          p.j(paramImageView, "if(unreadCnt < 99){\n    …ooMany)\n                }");
          paramTextView.setText((CharSequence)paramImageView);
          paramLinearLayout.setVisibility(0);
          paramLinearLayout.post((Runnable)new h(this, paramLinearLayout, k));
          paramLinearLayout.setOnClickListener((View.OnClickListener)new i(this, k));
          break;
          i = -2147483648;
          break label252;
          if (localObject3 == null) {
            break label294;
          }
          localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).bbL().bwg(((com.tencent.mm.plugin.textstatus.g.e.d)localObject3).field_UserName);
          break label294;
          paramImageView.setImageResource(b.g.default_avatar);
          break label323;
        }
        AppMethodBeat.o(232736);
        return;
        paramLinearLayout.setVisibility(8);
        AppMethodBeat.o(232736);
        return;
        localObject3 = null;
      }
      label514:
      localObject2 = null;
    }
  }
  
  private final void gmw()
  {
    AppMethodBeat.i(232732);
    Object localObject = this.MKe;
    if (localObject != null)
    {
      localObject = (NoMeasuredTextView)((LinearLayout)localObject).findViewById(b.e.nick_name_tv);
      if (localObject != null) {
        ((NoMeasuredTextView)localObject).setTextColor(this.mContext.getResources().getColor(b.b.FG_0));
      }
    }
    localObject = this.MKe;
    if (localObject != null)
    {
      localObject = (TextView)((LinearLayout)localObject).findViewById(b.e.user_name_tv);
      if (localObject != null)
      {
        ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(b.b.FG_1));
        ((TextView)localObject).setAlpha(1.0F);
      }
    }
    localObject = this.MKe;
    if (localObject != null)
    {
      localObject = (WeImageView)((LinearLayout)localObject).findViewById(b.e.qr_code);
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(this.mContext.getResources().getColor(b.b.FG_1));
      }
    }
    localObject = this.MKe;
    if (localObject != null)
    {
      localObject = (WeImageView)((LinearLayout)localObject).findViewById(b.e.arrow);
      if (localObject != null)
      {
        ((WeImageView)localObject).setIconColor(this.mContext.getResources().getColor(b.b.FG_2));
        AppMethodBeat.o(232732);
        return;
      }
    }
    AppMethodBeat.o(232732);
  }
  
  public final void KN(String paramString)
  {
    AppMethodBeat.i(232744);
    Log.i(TAG, "[update] username:%s", new Object[] { paramString });
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(232744);
      return;
    }
    new n.e(paramString, (com.tencent.mm.plugin.textstatus.a.n)this);
    this.username = paramString;
    new n.e(paramString, (com.tencent.mm.plugin.textstatus.a.n)this);
    localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    this.MCs = com.tencent.mm.plugin.textstatus.b.f.bep(paramString);
    localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    Object localObject3 = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a(this.mContext, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
    Object localObject2;
    if (localObject3 != null)
    {
      localObject1 = this.MCs;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_StatusID;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)this.MKc)) {
        ((com.tencent.mm.plugin.textstatus.proto.f)localObject3).sessionId = com.tencent.mm.plugin.fts.a.d.Sx(1);
      }
      localObject1 = ((com.tencent.mm.plugin.textstatus.proto.f)localObject3).sessionId;
      p.j(localObject1, "it.sessionId");
      this.sessionId = ((String)localObject1);
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject3).username = paramString;
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject3).MEZ = 5;
      localObject1 = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a((com.tencent.mm.plugin.textstatus.proto.f)localObject3);
    }
    boolean bool = this.MJY.aUx(paramString);
    paramString = this.mContext.getResources();
    p.j(paramString, "mContext.resources");
    paramString = paramString.getConfiguration();
    p.j(paramString, "mContext.resources.configuration");
    if (paramString.orientation == 2)
    {
      i = 1;
      if ((!bool) || (i != 0)) {
        break label404;
      }
      j = 1;
      label293:
      if (j != 0) {
        break label409;
      }
      paramString = this.MKe;
      if (paramString != null) {
        paramString.setPadding(paramString.getPaddingLeft(), paramString.getPaddingTop(), paramString.getPaddingRight(), com.tencent.mm.ci.a.fromDPToPix(this.mContext, 16));
      }
      this.wRV.getLayoutParams().height = -2;
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
        break label692;
      }
    }
    label404:
    label409:
    label687:
    label692:
    for (int j = 8;; j = 0)
    {
      paramString.setVisibility(j);
      if (i == 0) {
        break label697;
      }
      gmw();
      AppMethodBeat.o(232744);
      return;
      i = 0;
      break;
      j = 0;
      break label293;
      j = ak.kU(this.mContext).width;
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
          AppMethodBeat.o(232744);
          throw paramString;
        }
        ((LinearLayout.LayoutParams)paramString).weight = 1.0F;
        label505:
        localObject1 = this.kDt;
        if (localObject1 != null)
        {
          paramString = this.kDt;
          if (paramString == null) {
            break label687;
          }
        }
      }
      for (paramString = paramString.getLayoutParams();; paramString = null)
      {
        ((RelativeLayout)localObject1).setLayoutParams(paramString);
        paramString = this.MKe;
        if (paramString != null) {
          paramString.setPadding(paramString.getPaddingLeft(), paramString.getPaddingTop(), paramString.getPaddingRight(), com.tencent.mm.ci.a.fromDPToPix(this.mContext, 16));
        }
        paramString = this.kDt;
        if (paramString == null) {
          break;
        }
        paramString = paramString.findViewById(b.e.v_intercept_head_root_click);
        if (paramString == null) {
          break;
        }
        paramString.setOnClickListener((View.OnClickListener)new f.g(this));
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
          AppMethodBeat.o(232744);
          throw paramString;
        }
        ((LinearLayout.LayoutParams)paramString).weight = 0.0F;
        break label505;
      }
    }
    label697:
    if (!bool)
    {
      paramString = this.MJG;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.MBW;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.MJI;
      if (paramString == null) {
        p.bGy("layoutNoStatus");
      }
      paramString.setVisibility(0);
      gmw();
      if (com.tencent.mm.plugin.textstatus.a.t.gle())
      {
        this.MJS.setVisibility(0);
        paramString = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(19L, null, null, 0L, 14);
        this.MKa = f.b.MKi;
        if (this.MKa != f.b.MKi) {
          break label1937;
        }
        a(this.MJR, this.MJP, this.MJQ, b.h.MyZ, b.h.Mza);
        bool = com.tencent.mm.plugin.textstatus.a.t.glq();
        paramString = com.tencent.mm.plugin.textstatus.b.f.MAm;
        i = com.tencent.mm.plugin.textstatus.b.f.gly().gmg();
        if ((!bool) || (i <= 0)) {
          break label1919;
        }
        paramString = this.MJX;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = com.tencent.mm.plugin.textstatus.a.t.glw();
        p.j(paramString, "TextStatusSwitch.getFriendsStatusBtnStyle()");
        this.MKd = paramString;
        switch (this.MKd.style)
        {
        }
      }
    }
    label792:
    label934:
    label953:
    label1604:
    while (!((Iterator)localObject2).hasNext())
    {
      for (;;)
      {
        paramString = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(20L, null, null, this.MKd.glx(), 6);
        localObject1 = com.tencent.mm.plugin.textstatus.k.c.gnz();
        paramString = this.MCs;
        if (paramString == null) {
          break label1977;
        }
        paramString = paramString.field_IconID;
        paramString = ((com.tencent.mm.plugin.textstatus.k.a)localObject1).beJ(paramString);
        localObject1 = this.MBS;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)(this.mContext.getString(b.h.Mzd) + paramString));
        }
        paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject2 = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a(this.mContext, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
        if ((localObject2 == null) || (TextUtils.equals((CharSequence)((com.tencent.mm.plugin.textstatus.proto.f)localObject2).sessionId, (CharSequence)this.MKb))) {
          break label1982;
        }
        if (this.MKa == f.b.MKj)
        {
          paramString = com.tencent.mm.plugin.textstatus.h.a.MGJ;
          com.tencent.mm.plugin.textstatus.h.a.a(this.mContext, 1L, null, null, 12);
        }
        paramString = ((com.tencent.mm.plugin.textstatus.proto.f)localObject2).sessionId;
        p.j(paramString, "it.sessionId");
        this.MKb = paramString;
        paramString = this.MCs;
        if (paramString != null)
        {
          localObject1 = paramString.field_StatusID;
          paramString = (String)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramString = "";
        }
        this.MKc = paramString;
        paramString = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a((com.tencent.mm.plugin.textstatus.proto.f)localObject2);
        AppMethodBeat.o(232744);
        return;
        this.MJS.setVisibility(8);
        break;
        paramString = this.MJG;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.MBW;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.MJI;
        if (paramString == null) {
          p.bGy("layoutNoStatus");
        }
        paramString.setVisibility(8);
        paramString = this.MKe;
        if (paramString != null)
        {
          paramString = (TextView)paramString.findViewById(b.e.user_name_tv);
          if (paramString != null)
          {
            paramString.setTextColor(-1);
            paramString.setAlpha(0.6F);
          }
        }
        paramString = this.MKe;
        if (paramString != null)
        {
          paramString = (NoMeasuredTextView)paramString.findViewById(b.e.nick_name_tv);
          if (paramString != null) {
            paramString.setTextColor(-1);
          }
        }
        paramString = this.MKe;
        if (paramString != null)
        {
          paramString = (WeImageView)paramString.findViewById(b.e.qr_code);
          if (paramString != null) {
            paramString.setIconColor(-1);
          }
        }
        paramString = this.MKe;
        if (paramString != null)
        {
          paramString = (WeImageView)paramString.findViewById(b.e.arrow);
          if (paramString != null) {
            paramString.setIconColor(-1);
          }
        }
        this.MKa = f.b.MKj;
        break label792;
        paramString = this.MJT;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.MJU;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.MJV;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.MJW;
        if (paramString != null)
        {
          paramString.setVisibility(8);
          continue;
          paramString = this.MJU;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = this.MJW;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = this.MJT;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = this.MJV;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = this.MJW;
          if (paramString != null) {
            paramString.setText((CharSequence)this.mContext.getResources().getString(b.h.Mzf, new Object[] { Integer.valueOf(i) }));
          }
        }
      }
      paramString = this.MJV;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.MJW;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.MJT;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.MJU;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      localObject1 = this.MJW;
      if (localObject1 != null)
      {
        if (i > 3) {
          break label1888;
        }
        paramString = (CharSequence)this.mContext.getResources().getString(b.h.Mzf, new Object[] { Integer.valueOf(i) });
        ((TextView)localObject1).setText(paramString);
      }
      paramString = this.MJV;
      if (paramString != null) {
        paramString.removeAllViews();
      }
      paramString = com.tencent.mm.plugin.textstatus.b.f.MAm;
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.gly().lA(null, com.tencent.mm.plugin.auth.a.a.crN()).iterator();
      i = 0;
    }
    label912:
    paramString = (com.tencent.mm.plugin.textstatus.g.e.f.c)((Iterator)localObject2).next();
    j = i;
    if (paramString.isValid()) {
      localObject3 = paramString.lxh.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.plugin.textstatus.g.e.a locala = (com.tencent.mm.plugin.textstatus.g.e.a)((Iterator)localObject3).next();
        ImageView localImageView = new ImageView(this.mContext);
        paramString = this.MJV;
        if (paramString != null) {
          paramString.addView((View)localImageView);
        }
        localObject1 = localImageView.getLayoutParams();
        paramString = (String)localObject1;
        if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
          paramString = null;
        }
        paramString = (LinearLayout.LayoutParams)paramString;
        if (paramString != null) {
          paramString.width = -2;
        }
        if (paramString != null) {
          paramString.height = -1;
        }
        localImageView.setAdjustViewBounds(true);
        j = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 1);
        localImageView.setPadding(j, j, j, j);
        localImageView.setBackgroundColor(-1);
        localObject1 = com.tencent.mm.plugin.textstatus.k.n.MOY;
        com.tencent.mm.plugin.textstatus.k.n.hb((View)localImageView);
        localImageView.setImageResource(b.g.default_avatar);
        a.b.d(localImageView, locala.field_UserName);
        i += 1;
        if ((i > 1) && (paramString != null)) {
          paramString.setMarginStart(com.tencent.mm.ci.a.fromDPToPix(this.mContext, -4));
        }
        if (i < 3) {}
      }
      else
      {
        for (j = i;; j = i)
        {
          i = j;
          if (j < 3) {
            break;
          }
          break label912;
          label1888:
          paramString = (CharSequence)this.mContext.getResources().getString(b.h.Mzg, new Object[] { Integer.valueOf(i) });
          break label1604;
          label1919:
          paramString = this.MJX;
          if (paramString == null) {
            break label934;
          }
          paramString.setVisibility(8);
          break label934;
          label1937:
          a(this.MJN, this.MJL, this.MJM, b.h.MyZ, b.h.Mza);
          paramString = this.MJO;
          if (paramString == null) {
            break label934;
          }
          paramString.setVisibility(8);
          break label934;
          label1977:
          paramString = null;
          break label953;
          label1982:
          AppMethodBeat.o(232744);
          return;
        }
      }
    }
  }
  
  public final void a(h.a parama)
  {
    this.MAH = parama;
  }
  
  public final void abo(int paramInt)
  {
    AppMethodBeat.i(232768);
    this.MJY.abo(paramInt);
    AppMethodBeat.o(232768);
  }
  
  public final void abp(int paramInt)
  {
    AppMethodBeat.i(232769);
    this.MJY.abp(paramInt);
    AppMethodBeat.o(232769);
  }
  
  public final void abq(int paramInt)
  {
    AppMethodBeat.i(232771);
    this.MJY.abq(paramInt);
    AppMethodBeat.o(232771);
  }
  
  public final void dDB()
  {
    AppMethodBeat.i(232762);
    com.tencent.mm.plugin.textstatus.h.a locala = com.tencent.mm.plugin.textstatus.h.a.MGJ;
    com.tencent.mm.plugin.textstatus.h.a.a(17L, "1", null, 0L, 12);
    this.MJY.dDB();
    AppMethodBeat.o(232762);
  }
  
  public final void dDC()
  {
    AppMethodBeat.i(232763);
    this.MJY.dDC();
    AppMethodBeat.o(232763);
  }
  
  public final void fqe()
  {
    AppMethodBeat.i(232765);
    this.MJY.fqe();
    AppMethodBeat.o(232765);
  }
  
  public final void fqf()
  {
    AppMethodBeat.i(232766);
    this.MJY.fqf();
    AppMethodBeat.o(232766);
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
    AppMethodBeat.i(232746);
    gmw();
    Object localObject = this.kDt;
    if (localObject != null) {
      ((RelativeLayout)localObject).removeView(this.wRV);
    }
    localObject = this.kDt;
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -2;
      }
    }
    localObject = this.MKe;
    if (localObject != null)
    {
      ((LinearLayout)localObject).setPadding(((LinearLayout)localObject).getPaddingLeft(), ((LinearLayout)localObject).getPaddingTop(), ((LinearLayout)localObject).getPaddingRight(), com.tencent.mm.ci.a.fromDPToPix(this.mContext, 40));
      AppMethodBeat.o(232746);
      return;
    }
    AppMethodBeat.o(232746);
  }
  
  public final void gkJ()
  {
    AppMethodBeat.i(232748);
    KN(this.username);
    AppMethodBeat.o(232748);
  }
  
  public final void gkK()
  {
    AppMethodBeat.i(232750);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(232750);
    throw localThrowable;
  }
  
  public final void gmx()
  {
    AppMethodBeat.i(232773);
    if ((TextUtils.equals((CharSequence)this.username, (CharSequence)com.tencent.mm.plugin.auth.a.a.crN())) && (this.MKa != f.b.MKi))
    {
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.lastClickTime) < 1000L)
      {
        AppMethodBeat.o(232773);
        return;
      }
      this.lastClickTime = l;
      Object localObject = new m(this.mContext);
      ((m)localObject).a((q.f)new d(this));
      ((m)localObject).a((q.g)new e(this));
      ((m)localObject).a((e.a)new f(this));
      ((m)localObject).hYu();
      localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(this.mContext, 31L, null, null, 12);
    }
    AppMethodBeat.o(232773);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(232775);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
        break label103;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232775);
      return;
      paramView = null;
      break;
      label103:
      if (paramView.intValue() == i) {
        gmx();
      }
    }
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(232760);
    this.MJY.onPostClose();
    AppMethodBeat.o(232760);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(232757);
    this.MJY.onPostOpen(paramBoolean);
    AppMethodBeat.o(232757);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(232776);
    boolean bool;
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.g.b))
    {
      com.tencent.mm.kernel.h.aGY().b(((com.tencent.mm.plugin.textstatus.g.b)paramq).getType(), (i)this);
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
      AppMethodBeat.o(232776);
      return;
      label86:
      com.tencent.mm.ui.base.h.af(this.mContext, this.mContext.getString(b.h.Myu), "");
    }
    AppMethodBeat.o(232776);
  }
  
  public final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(232751);
    this.MJY.r(paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(232751);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements q.f
  {
    d(f paramf) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(238192);
      paramo.d(b.e.Mwx, (CharSequence)this.MKh.mContext.getString(b.h.Mzc));
      paramo.d(b.e.Mwv, (CharSequence)this.MKh.mContext.getString(b.h.MyV));
      Object localObject = this.MKh.MCs;
      int i;
      if (localObject != null)
      {
        i = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_ExpireTime;
        i -= cm.bfF();
        if (i >= 0) {
          break label157;
        }
        i = 0;
        label82:
        if (i <= 0) {
          break label166;
        }
      }
      label157:
      label166:
      for (localObject = this.MKh.mContext.getString(b.h.MyO, new Object[] { Integer.valueOf(i) });; localObject = this.MKh.mContext.getString(b.h.MyM))
      {
        p.j(localObject, "if(expireTimeLeftInHour …r_tips)\n                }");
        paramo.a(b.e.Mwq, (CharSequence)this.MKh.mContext.getString(b.h.MyN), (CharSequence)localObject, 0);
        AppMethodBeat.o(238192);
        return;
        i = 0;
        break;
        i /= 3600;
        break label82;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements q.g
  {
    e(f paramf) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(238729);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == b.e.Mwy)
      {
        f.c(this.MKh);
        AppMethodBeat.o(238729);
        return;
      }
      if (paramInt == b.e.Mwv)
      {
        f.d(this.MKh);
        paramMenuItem = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.MKh.mContext, 35L, null, null, 12);
        AppMethodBeat.o(238729);
        return;
      }
      if (paramInt == b.e.Mwx)
      {
        f.a(this.MKh);
        paramMenuItem = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.MKh.mContext, 32L, null, null, 12);
        AppMethodBeat.o(238729);
        return;
      }
      f localf;
      Context localContext;
      if (paramInt == b.e.Mwq)
      {
        paramMenuItem = this.MKh.MCs;
        if (paramMenuItem != null)
        {
          localf = this.MKh;
          localContext = this.MKh.mContext;
          this.MKh.mContext.getString(b.h.Myv);
          localf.iYE = com.tencent.mm.ui.base.h.a(localContext, this.MKh.mContext.getString(b.h.Myv), false, null);
          paramMenuItem = paramMenuItem.field_StatusID;
          p.j(paramMenuItem, "this.field_StatusID");
          paramMenuItem = new com.tencent.mm.plugin.textstatus.g.a(paramMenuItem, 1);
          com.tencent.mm.kernel.h.aGY().a(paramMenuItem.getType(), (i)new g((i)this.MKh));
          com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramMenuItem);
        }
        paramMenuItem = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.MKh.mContext, 33L, null, null, 12);
        AppMethodBeat.o(238729);
        return;
      }
      if (paramInt == b.e.Mwp)
      {
        paramMenuItem = this.MKh.MCs;
        if (paramMenuItem != null)
        {
          localf = this.MKh;
          localContext = this.MKh.mContext;
          this.MKh.mContext.getString(b.h.Myv);
          localf.iYE = com.tencent.mm.ui.base.h.a(localContext, this.MKh.mContext.getString(b.h.Myv), false, null);
          paramMenuItem = paramMenuItem.field_StatusID;
          p.j(paramMenuItem, "this.field_StatusID");
          paramMenuItem = new com.tencent.mm.plugin.textstatus.g.a(paramMenuItem, 2);
          com.tencent.mm.kernel.h.aGY().a(paramMenuItem.getType(), (i)new g((i)this.MKh));
          com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramMenuItem);
          AppMethodBeat.o(238729);
          return;
        }
      }
      AppMethodBeat.o(238729);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class f
    implements e.a
  {
    f(f paramf) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(238581);
      com.tencent.mm.plugin.textstatus.h.a locala = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(this.MKh.mContext, 34L, null, null, 12);
      AppMethodBeat.o(238581);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(f paramf, LinearLayout paramLinearLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(234251);
      try
      {
        if (paramLinearLayout.getGlobalVisibleRect(new Rect()))
        {
          com.tencent.mm.plugin.textstatus.h.a locala = com.tencent.mm.plugin.textstatus.h.a.MGJ;
          com.tencent.mm.plugin.textstatus.h.a.a(9L, String.valueOf(k), f.b(this.MKh), 0L, 8);
          AppMethodBeat.o(234251);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace(f.access$getTAG$cp(), localThrowable, "[expose notify]err", new Object[0]);
        AppMethodBeat.o(234251);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(f paramf, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232867);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$handleNotify$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = TextStatusLikeListActivity.MNs;
      TextStatusLikeListActivity.b.ix(this.MKh.mContext);
      this.MKh.MJN.setVisibility(8);
      this.MKh.MJR.setVisibility(8);
      paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(10L, String.valueOf(k), f.b(this.MKh), 0L, 8);
      paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(this.MKh.mContext, 41L, String.valueOf(k), this.MKh.MCs);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$handleNotify$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.f
 * JD-Core Version:    0.7.0.1
 */