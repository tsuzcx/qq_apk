package com.tencent.mm.plugin.profile.ui.tab;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.plugin.finder.feed.model.j;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.g;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.tools.o;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/ContactBizHeaderLiveNoticeLogic;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "profileInfo", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "rootView", "Landroid/view/View;", "enterTime", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;Landroid/view/View;J)V", "liveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/BizFinderLiveNoticeInfo;", "liveNotifyContainer", "liveNotifyDescDetailCollapseTv", "Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "liveNotifyDescTimingTv", "Landroid/widget/TextView;", "liveNotifyDivider", "liveNotifyDoneIcon", "liveNotifySubscribeContainer", "liveNotifySubscribeTv", "mContext", "Landroid/content/Context;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "checkLiveInfoLegal", "", "doReserveCgi", "", "needReserve", "initDisplayView", "initSubscribeBtnLogic", "refreshNoticeBtnStatue", "reserved", "setupLiveNotifyView", "updateCollapseLayout", "updateProfileInfo", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a NcN;
  static final String TAG;
  qm NcO;
  private View NcP;
  private TextView NcQ;
  private FinderCollapsibleTextView NcR;
  private View NcS;
  private TextView NcT;
  private View NcU;
  private View NcV;
  pj NcW;
  private final MMActivity activity;
  private final long enterTime;
  private final Context mContext;
  private final View rootView;
  private com.tencent.mm.ui.base.w tipDialog;
  
  static
  {
    AppMethodBeat.i(305926);
    NcN = new c.a((byte)0);
    TAG = "ContactBizHeaderLiveNoticeLogic";
    AppMethodBeat.o(305926);
  }
  
  public c(MMActivity paramMMActivity, qm paramqm, View paramView, long paramLong)
  {
    AppMethodBeat.i(305884);
    this.activity = paramMMActivity;
    this.NcO = paramqm;
    this.rootView = paramView;
    this.enterTime = paramLong;
    paramMMActivity = this.rootView.findViewById(R.h.fBT);
    kotlin.g.b.s.s(paramMMActivity, "rootView.findViewById(R.…ader_live_notify_card_id)");
    this.NcP = paramMMActivity;
    paramMMActivity = this.rootView.findViewById(R.h.fBB);
    kotlin.g.b.s.s(paramMMActivity, "rootView.findViewById(R.…_header_live_desc_timing)");
    this.NcQ = ((TextView)paramMMActivity);
    paramMMActivity = this.rootView.findViewById(R.h.fBA);
    kotlin.g.b.s.s(paramMMActivity, "rootView.findViewById(R.…_header_live_desc_detail)");
    this.NcR = ((FinderCollapsibleTextView)paramMMActivity);
    paramMMActivity = this.rootView.findViewById(R.h.fBF);
    kotlin.g.b.s.s(paramMMActivity, "rootView.findViewById(R.…live_subscribe_container)");
    this.NcS = paramMMActivity;
    paramMMActivity = this.rootView.findViewById(R.h.fBE);
    kotlin.g.b.s.s(paramMMActivity, "rootView.findViewById(R.…iz_header_live_subscribe)");
    this.NcT = ((TextView)paramMMActivity);
    paramMMActivity = this.rootView.findViewById(R.h.fBC);
    kotlin.g.b.s.s(paramMMActivity, "rootView.findViewById(R.…_biz_header_live_divider)");
    this.NcU = paramMMActivity;
    paramMMActivity = this.rootView.findViewById(R.h.fBD);
    kotlin.g.b.s.s(paramMMActivity, "rootView.findViewById(R.…z_header_live_right_icon)");
    this.NcV = paramMMActivity;
    paramMMActivity = this.activity.getContext();
    kotlin.g.b.s.s(paramMMActivity, "activity.context");
    this.mContext = ((Context)paramMMActivity);
    if (this.NcO.YVy.size() > 0)
    {
      this.NcW = ((pj)this.NcO.YVy.getFirst());
      Log.i(TAG, "init liveNoticeInfo ok!");
    }
    AppMethodBeat.o(305884);
  }
  
  private final void AD(boolean paramBoolean)
  {
    AppMethodBeat.i(305896);
    if (!gCx())
    {
      AppMethodBeat.o(305896);
      return;
    }
    String str = com.tencent.mm.platformtools.w.a(this.NcO.YVw.YWz);
    this.tipDialog = com.tencent.mm.ui.base.w.a(this.mContext, (CharSequence)this.mContext.getString(R.l.app_waiting), true, 3, null);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      Log.i(TAG, kotlin.g.b.s.X("try to send cgi, sendCgiType = ", Integer.valueOf(i)));
      g localg = (g)h.ax(g.class);
      kotlin.g.b.s.s(str, "finderUserName");
      Object localObject = this.NcW;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((pj)localObject).YSS;
      kotlin.g.b.s.s(localObject, "liveNoticeInfo!!.notice_id");
      localg.a(str, (String)localObject, i, 1).bFJ().g(new c..ExternalSyntheticLambda3(this, paramBoolean, str));
      AppMethodBeat.o(305896);
      return;
    }
  }
  
  private final void AE(boolean paramBoolean)
  {
    AppMethodBeat.i(305900);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.mContext.getResources().getString(R.l.finder_create_live_notice_btn_book_cancel);
      kotlin.g.b.s.s(localObject, "{ //已预约\n            mCon…tn_book_cancel)\n        }");
      this.NcT.setText((CharSequence)localObject);
      localObject = this.NcV;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.NcR.bDL();
      AppMethodBeat.o(305900);
      return;
      localObject = this.mContext.getResources().getString(R.l.finder_create_live_notice_btn_book);
      kotlin.g.b.s.s(localObject, "{ //未预约\n            mCon…otice_btn_book)\n        }");
      break;
    }
  }
  
  private static final Boolean a(c paramc, boolean paramBoolean, String paramString, b.a parama)
  {
    AppMethodBeat.i(305918);
    kotlin.g.b.s.u(paramc, "this$0");
    if (paramc.tipDialog != null)
    {
      com.tencent.mm.ui.base.w localw = paramc.tipDialog;
      kotlin.g.b.s.checkNotNull(localw);
      if (localw.isShowing())
      {
        localw = paramc.tipDialog;
        kotlin.g.b.s.checkNotNull(localw);
        localw.dismiss();
      }
    }
    if (paramc.activity.isFinishing())
    {
      Log.i(TAG, "activity.isFinishing");
      paramc = Boolean.TRUE;
      AppMethodBeat.o(305918);
      return paramc;
    }
    Log.i(TAG, "reserve: cgi result: type = %s, code = %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      if (paramBoolean) {}
      for (paramString = paramc.mContext.getString(R.l.finder_live_notice_reserve_fail_toast_tips);; paramString = paramc.mContext.getString(R.l.finder_live_notice_cancel_reserve_fail_toast_tips))
      {
        kotlin.g.b.s.s(paramString, "if (needReserve) mContex…_reserve_fail_toast_tips)");
        paramc = aa.makeText(paramc.mContext, (CharSequence)paramString, 0);
        paramc.setGravity(17, 0, 0);
        paramc.show();
        paramc = Boolean.TRUE;
        AppMethodBeat.o(305918);
        return paramc;
      }
    }
    Log.i(TAG, kotlin.g.b.s.X("cgi ok,  ", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      parama = j.BfL;
      kotlin.g.b.s.s(paramString, "finderUserName");
      paramString = j.Sv(paramString);
      if (paramString != null) {
        paramString.status = 0;
      }
      paramString = aa.makeText(paramc.mContext, (CharSequence)paramc.mContext.getString(R.l.finder_live_notice_edu_toast_tips), 0);
      paramString.setGravity(17, 0, 0);
      paramString.show();
    }
    for (;;)
    {
      paramc.AE(paramBoolean);
      paramc = Boolean.TRUE;
      AppMethodBeat.o(305918);
      return paramc;
      parama = j.BfL;
      kotlin.g.b.s.s(paramString, "finderUserName");
      paramString = j.Sv(paramString);
      if (paramString != null) {
        paramString.status = 1;
      }
      aa.y(paramc.mContext, paramc.mContext.getResources().getString(R.l.finder_cancel_succ), R.k.icons_filled_done);
    }
  }
  
  private static final void a(c paramc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(305909);
    kotlin.g.b.s.u(paramc, "this$0");
    if (paramMenuItem.getItemId() == 4)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramc.NcO.YVl.UserName, 1703, paramc.enterTime, paramc.activity.getIntent());
      paramc.AD(false);
    }
    AppMethodBeat.o(305909);
  }
  
  private static final void a(c paramc, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(305904);
    kotlin.g.b.s.u(paramc, "this$0");
    if (params.jmw()) {
      params.a(4, paramc.mContext.getResources().getColor(R.e.Red), (CharSequence)paramc.mContext.getResources().getString(R.l.finder_live_notice_unreserve));
    }
    AppMethodBeat.o(305904);
  }
  
  private static final void a(ah.a parama, c paramc, View paramView)
  {
    AppMethodBeat.i(305914);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactBizHeaderLiveNoticeLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "$realReserved");
    kotlin.g.b.s.u(paramc, "this$0");
    boolean bool;
    if (paramc.NcV.getVisibility() == 0)
    {
      bool = true;
      parama.aiwY = bool;
      Log.i(TAG, kotlin.g.b.s.X("btn clicked, cur status = ", Boolean.valueOf(parama.aiwY)));
      if (!parama.aiwY) {
        break label206;
      }
      Log.i(TAG, "btn clicked, try to cancel!");
      parama = new com.tencent.mm.ui.widget.a.f(paramc.mContext, 1, true);
      parama.Vtg = new c..ExternalSyntheticLambda1(paramc);
      parama.GAC = new c..ExternalSyntheticLambda2(paramc);
      parama.dDn();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/ContactBizHeaderLiveNoticeLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(305914);
      return;
      bool = false;
      break;
      label206:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(paramc.NcO.YVl.UserName, 1702, paramc.enterTime, paramc.activity.getIntent());
      Log.i(TAG, "btn clicked, try to reserve!");
      paramc.AD(true);
    }
  }
  
  private final boolean gCx()
  {
    AppMethodBeat.i(305890);
    if (this.NcW == null)
    {
      Log.i(TAG, "liveInfo == null");
      AppMethodBeat.o(305890);
      return false;
    }
    Object localObject = this.NcW;
    kotlin.g.b.s.checkNotNull(localObject);
    if (!Util.isNullOrNil(((pj)localObject).YSS))
    {
      localObject = this.NcW;
      kotlin.g.b.s.checkNotNull(localObject);
      if (((pj)localObject).start_time != 0) {}
    }
    else
    {
      localObject = TAG;
      pj localpj = this.NcW;
      kotlin.g.b.s.checkNotNull(localpj);
      boolean bool2 = Util.isNullOrNil(localpj.YSS);
      localpj = this.NcW;
      kotlin.g.b.s.checkNotNull(localpj);
      if (localpj.start_time == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.i((String)localObject, "notice_id is empty? %s, start_time == 0? %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        AppMethodBeat.o(305890);
        return false;
      }
    }
    if (this.NcO.YVw.YWz.Op.length == 0)
    {
      Log.i(TAG, "finder username is empty");
      AppMethodBeat.o(305890);
      return false;
    }
    AppMethodBeat.o(305890);
    return true;
  }
  
  public final void gCy()
  {
    AppMethodBeat.i(305967);
    if (!gCx())
    {
      Log.i(TAG, "check fail!");
      this.NcP.setVisibility(8);
      AppMethodBeat.o(305967);
      return;
    }
    if (this.rootView.getTag(R.h.ftz) == null)
    {
      this.rootView.setTag(R.h.ftz, Boolean.TRUE);
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.NcO.YVl.UserName, 1701, this.enterTime, this.activity.getIntent());
    }
    this.NcP.setVisibility(0);
    Object localObject1 = e.vYK;
    e.l(this.NcQ);
    localObject1 = e.vYK;
    e.l(this.NcT);
    localObject1 = this.NcW;
    kotlin.g.b.s.checkNotNull(localObject1);
    long l = ((pj)localObject1).start_time;
    localObject1 = aw.Gjk;
    localObject1 = aw.a(l * 1000L, Boolean.FALSE, false, 4);
    Log.i(TAG, kotlin.g.b.s.X("noticeTimeStr = ", localObject1));
    this.NcQ.setText((CharSequence)this.mContext.getResources().getString(R.l.finder_create_live_notice_time_info, new Object[] { localObject1 }));
    localObject1 = this.NcR;
    Object localObject2 = this.NcW;
    kotlin.g.b.s.checkNotNull(localObject2);
    ((FinderCollapsibleTextView)localObject1).setText((CharSequence)((pj)localObject2).YSR);
    ((FinderCollapsibleTextView)localObject1).setVisibility(0);
    ((FinderCollapsibleTextView)localObject1).setTextColor(this.mContext.getResources().getColor(R.e.FG_1));
    ((FinderCollapsibleTextView)localObject1).getContentTextView().setTextSize(0, com.tencent.mm.cd.a.br(this.mContext, R.f.FootnoteextSize));
    ((FinderCollapsibleTextView)localObject1).setLimitLine(1);
    ((FinderCollapsibleTextView)localObject1).setCollapse(true);
    this.NcR.setOnCollapse((kotlin.g.a.b)new b(this));
    o.F(this.NcS, 0.5F);
    localObject2 = com.tencent.mm.platformtools.w.a(this.NcO.YVw.YWz);
    localObject1 = new ah.a();
    j localj = j.BfL;
    kotlin.g.b.s.s(localObject2, "finderUserName");
    localObject2 = j.Sv((String)localObject2);
    if ((localObject2 != null) && (((bkk)localObject2).status == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((ah.a)localObject1).aiwY = bool;
      Log.i(TAG, kotlin.g.b.s.X("init btn, status = ", Boolean.valueOf(((ah.a)localObject1).aiwY)));
      AE(((ah.a)localObject1).aiwY);
      this.NcS.setOnClickListener(new c..ExternalSyntheticLambda0((ah.a)localObject1, this));
      AppMethodBeat.o(305967);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isCollapse", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.c
 * JD-Core Version:    0.7.0.1
 */