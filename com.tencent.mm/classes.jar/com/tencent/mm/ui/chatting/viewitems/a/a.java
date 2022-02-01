package com.tencent.mm.ui.chatting.viewitems.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import com.tencent.d.a.a.a.d.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.live.model.cgi.aj;
import com.tencent.mm.plugin.finder.live.model.cgi.aj.a;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.viewitems.au.a;
import com.tencent.mm.ui.widget.a.f;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveGameTeamUpNotifyTmpl;", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "filling", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl$FinderLiveNotifyHolder;", "values", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "hasRejected", "", "finderUserName", "reportLiveNotify", "liveId", "", "info", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "noticeType", "tipsId", "setReject", "reject", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  public static final a.a aeZh;
  private static final String aeZi;
  private final String TAG = "FinderLiveGameTeamUpNotifyTmpl";
  
  static
  {
    AppMethodBeat.i(255483);
    aeZh = new a.a((byte)0);
    aeZi = "TipsTempl_GamePurchaseTeamUp_Live";
    AppMethodBeat.o(255483);
  }
  
  private static final void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, String paramString1, Map paramMap, String paramString2, long paramLong1, long paramLong2, c.c paramc, View paramView)
  {
    AppMethodBeat.i(255471);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(parama1);
    localb.cH(paramString1);
    localb.cH(paramMap);
    localb.cH(paramString2);
    localb.hB(paramLong1);
    localb.hB(paramLong2);
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveGameTeamUpNotifyTmpl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(parama1, "$ui");
    kotlin.g.b.s.u(paramMap, "$values");
    kotlin.g.b.s.u(paramString2, "$xmlPrefix");
    parama.c(new f((Context)parama1.aezO.getContext(), 1, false));
    boolean bool = bBF(paramString1);
    paramView = parama.jxF();
    kotlin.g.b.s.checkNotNull(paramView);
    paramView.Vtg = new a..ExternalSyntheticLambda1(bool, parama, paramMap, paramString2);
    paramMap = parama.jxF();
    kotlin.g.b.s.checkNotNull(paramMap);
    paramMap.GAC = new a..ExternalSyntheticLambda2(parama, paramString1, paramLong1, parama1, paramLong2, paramc);
    parama = parama.jxF();
    if (parama != null) {
      parama.dDn();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveGameTeamUpNotifyTmpl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(255471);
  }
  
  private static final void a(a parama, final String paramString, long paramLong1, com.tencent.mm.ui.chatting.d.a parama1, long paramLong2, final c.c paramc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(255461);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(parama1, "$ui");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == parama.jxH())
    {
      if (paramString != null)
      {
        parama1 = aj.CKd;
        kotlin.g.b.s.s(paramString, "finderUserName");
        d.b((com.tencent.mm.vending.g.c)new aj(paramLong1, paramLong2, 3, aj.a.bx(paramString, false)).bFJ(), (kotlin.g.a.b)new b(parama, paramString, paramc));
        AppMethodBeat.o(255461);
      }
    }
    else if (paramInt == parama.jxI())
    {
      if (paramString != null)
      {
        parama1 = aj.CKd;
        kotlin.g.b.s.s(paramString, "finderUserName");
        d.b((com.tencent.mm.vending.g.c)new aj(paramLong1, paramLong2, 3, aj.a.bx(paramString, true)).bFJ(), (kotlin.g.a.b)new c(parama, paramString, paramc));
        AppMethodBeat.o(255461);
      }
    }
    else if (paramInt == parama.jxG())
    {
      paramc = am.aixg;
      paramString = String.format(parama.jxJ(), Arrays.copyOf(new Object[] { Long.valueOf(paramLong1), paramString, LocaleUtil.getApplicationLanguage() }, 3));
      kotlin.g.b.s.s(paramString, "java.lang.String.format(format, *args)");
      Log.i(parama.TAG, "go to complain page");
      parama = new Intent();
      parama.putExtra("rawUrl", paramString);
      com.tencent.mm.ui.chatting.viewitems.c.s(parama, parama1.getTalkerUserName());
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", parama);
    }
    AppMethodBeat.o(255461);
  }
  
  private static final void a(boolean paramBoolean, a parama, Map paramMap, String paramString, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(255452);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramMap, "$values");
    kotlin.g.b.s.u(paramString, "$xmlPrefix");
    params.clear();
    if (paramBoolean) {
      params.add(0, parama.jxI(), 0, (CharSequence)MMApplicationContext.getContext().getResources().getString(R.l.gwh, new Object[] { paramMap.get(kotlin.g.b.s.X(paramString, ".title.nickname")) }));
    }
    for (;;)
    {
      params.add(0, parama.jxG(), 0, (CharSequence)MMApplicationContext.getContext().getResources().getString(R.l.gQq));
      AppMethodBeat.o(255452);
      return;
      params.a(parama.jxH(), MMApplicationContext.getContext().getResources().getColor(R.e.Red), (CharSequence)MMApplicationContext.getContext().getResources().getString(R.l.gwg, new Object[] { paramMap.get(kotlin.g.b.s.X(paramString, ".title.nickname")) }));
    }
  }
  
  private static boolean bBF(String paramString)
  {
    AppMethodBeat.i(255443);
    boolean bool = c.iTS().getBoolean(kotlin.g.b.s.X(paramString, "_game_team"), false);
    AppMethodBeat.o(255443);
    return bool;
  }
  
  public final void a(au.a parama, Map<String, String> paramMap, cc paramcc, com.tencent.mm.ui.chatting.d.a parama1)
  {
    AppMethodBeat.i(255506);
    kotlin.g.b.s.u(paramMap, "values");
    kotlin.g.b.s.u(parama1, "ui");
    if (parama == null) {}
    for (parama = null;; parama = (c.c)parama.bBB(aeZi))
    {
      long l1 = d.FK(Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.object_id"))));
      long l2 = d.FK(Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.live_id"))));
      String str2 = (String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.object_nonce_id"));
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      String str3 = Util.nullAsNil(str1);
      kotlin.g.b.s.s(str3, "nullAsNil(values[\"$xmlPr….object_nonce_id\"] ?: \"\")");
      str2 = (String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.tips_id"));
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      String str4 = Util.nullAsNil(str1);
      kotlin.g.b.s.s(str4, "nullAsNil(values[\"$xmlPr…tipsinfo.tips_id\"] ?: \"\")");
      str2 = (String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.notice_id"));
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      str2 = Util.nullAsNil(str1);
      str1 = Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.finder_username")));
      boolean bool = bBF(str1);
      kotlin.g.b.s.s(str2, "noticeId");
      a(paramMap, ".msg.appmsg.extinfo.notifymsg", parama, bool, str2, parama1, l1, l2, str3, paramcc, str1, str4);
      if (parama != null)
      {
        paramcc = parama.aeZs;
        if (paramcc != null) {
          paramcc.setOnClickListener(new a..ExternalSyntheticLambda0(this, parama1, str1, paramMap, ".msg.appmsg.extinfo.notifymsg", l2, l1, parama));
        }
      }
      AppMethodBeat.o(255506);
      return;
    }
  }
  
  public final void a(String paramString1, long paramLong1, g paramg, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(255510);
    kotlin.g.b.s.u(paramg, "info");
    kotlin.g.b.s.u(paramString2, "tipsId");
    AppMethodBeat.o(255510);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBasicInfoResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<b.a<bjr>, ah>
  {
    b(a parama, String paramString, c.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBasicInfoResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<b.a<bjr>, ah>
  {
    c(a parama, String paramString, c.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.a
 * JD-Core Version:    0.7.0.1
 */