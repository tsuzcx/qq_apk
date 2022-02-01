package com.tencent.mm.ui.chatting.viewitems.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.a.a.a.b.b;
import com.tencent.d.a.a.a.d.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.finder.live.e;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.at;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.viewitems.au.a;
import com.tencent.mm.view.e.b;
import com.tencent.threadpool.i;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1;", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl;", "()V", "INFRINGEMENT_URL_FORMAT", "", "getINFRINGEMENT_URL_FORMAT", "()Ljava/lang/String;", "MENU_ID_COMPLAINT", "", "getMENU_ID_COMPLAINT", "()I", "MENU_ID_REJECT", "getMENU_ID_REJECT", "MENU_ID_UNREJECT", "getMENU_ID_UNREJECT", "TAG", "getTAG", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$TmplHolderV1;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "moreMenu", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getMoreMenu", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "setMoreMenu", "(Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;)V", "filling", "", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl$FinderLiveNotifyHolder;", "values", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "getHolder", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "reportLiveNotify", "finderUserName", "liveId", "", "info", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "noticeType", "tipsId", "setupUI", "xmlPrefix", "tmplHolder", "hasRejected", "", "noticeId", "feedId", "nonceId", "setupUI$app_release", "Companion", "InfoItem", "TmplHolderV1", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  implements d
{
  private static final String aeZi;
  public static final c.a aeZm;
  private static final MultiProcessMMKV eMf;
  private final String TAG;
  private final String aeSD;
  private com.tencent.mm.ui.widget.a.f aeSY;
  private final int aeZn;
  private final int aeZo;
  private final int aeZp;
  private final c.c aeZq;
  
  static
  {
    AppMethodBeat.i(255500);
    aeZm = new c.a((byte)0);
    aeZi = "TipsTempl_MultiReason_Live";
    eMf = MultiProcessMMKV.getMMKV("FINDER_LIVE_NOTIFY_REJECT_STATUS");
    AppMethodBeat.o(255500);
  }
  
  public c()
  {
    AppMethodBeat.i(255454);
    this.TAG = "FinderLiveNotifyTmplV1";
    this.aeZn = 1;
    this.aeZo = 2;
    this.aeZp = 3;
    this.aeSD = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=62&liveid=%s&liveidentityid=%s&wechat_real_lang=%s";
    this.aeZq = new c.c();
    AppMethodBeat.o(255454);
  }
  
  private static final void a(cc paramcc, boolean paramBoolean, c paramc, Map paramMap, String paramString, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(255460);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramMap, "$values");
    kotlin.g.b.s.u(paramString, "$xmlPrefix");
    params.clear();
    av localav = av.GiL;
    long l;
    if (paramcc == null)
    {
      l = -1L;
      if (!av.ag(l, 8))
      {
        if (!paramBoolean) {
          break label146;
        }
        params.add(0, paramc.aeZp, 0, (CharSequence)MMApplicationContext.getContext().getResources().getString(R.l.gwj, new Object[] { paramMap.get(kotlin.g.b.s.X(paramString, ".title.nickname")) }));
      }
    }
    for (;;)
    {
      params.add(0, paramc.aeZn, 0, (CharSequence)MMApplicationContext.getContext().getResources().getString(R.l.gQq));
      AppMethodBeat.o(255460);
      return;
      l = paramcc.field_msgId;
      break;
      label146:
      params.a(paramc.aeZo, MMApplicationContext.getContext().getResources().getColor(R.e.Red), (CharSequence)MMApplicationContext.getContext().getResources().getString(R.l.gwi, new Object[] { paramMap.get(kotlin.g.b.s.X(paramString, ".title.nickname")) }));
    }
  }
  
  private static final void a(c paramc, com.tencent.mm.ui.chatting.d.a parama, String paramString1, cc paramcc, Map paramMap, String paramString2, long paramLong, c.c paramc1, View paramView)
  {
    AppMethodBeat.i(255477);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(parama);
    localb.cH(paramString1);
    localb.cH(paramcc);
    localb.cH(paramMap);
    localb.cH(paramString2);
    localb.hB(paramLong);
    localb.cH(paramc1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(parama, "$ui");
    kotlin.g.b.s.u(paramMap, "$values");
    kotlin.g.b.s.u(paramString2, "$xmlPrefix");
    paramc.aeSY = new com.tencent.mm.ui.widget.a.f((Context)parama.aezO.getContext(), 1, false);
    boolean bool = eMf.getBoolean(paramString1, false);
    paramView = paramc.aeSY;
    kotlin.g.b.s.checkNotNull(paramView);
    paramView.Vtg = new c..ExternalSyntheticLambda2(paramcc, bool, paramc, paramMap, paramString2);
    paramcc = paramc.aeSY;
    kotlin.g.b.s.checkNotNull(paramcc);
    paramcc.GAC = new c..ExternalSyntheticLambda3(paramc, paramString1, paramLong, parama, paramc1);
    paramc = paramc.aeSY;
    if (paramc != null) {
      paramc.dDn();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(255477);
  }
  
  private static final void a(c paramc, final String paramString, long paramLong, com.tencent.mm.ui.chatting.d.a parama, final c.c paramc1, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(255469);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(parama, "$ui");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == paramc.aeZo)
    {
      if (paramString != null)
      {
        ((at)com.tencent.mm.kernel.h.ax(at.class)).c(paramString, true, (ck)new d(paramc, paramc1, paramString));
        AppMethodBeat.o(255469);
      }
    }
    else if (paramInt == paramc.aeZp)
    {
      if (paramString != null)
      {
        ((at)com.tencent.mm.kernel.h.ax(at.class)).c(paramString, false, (ck)new e(paramc, paramc1, paramString));
        AppMethodBeat.o(255469);
      }
    }
    else if (paramInt == paramc.aeZn)
    {
      paramc1 = am.aixg;
      paramString = String.format(paramc.aeSD, Arrays.copyOf(new Object[] { Long.valueOf(paramLong), paramString, LocaleUtil.getApplicationLanguage() }, 3));
      kotlin.g.b.s.s(paramString, "java.lang.String.format(format, *args)");
      Log.i(paramc.getTAG(), "go to complain page");
      paramc = new Intent();
      paramc.putExtra("rawUrl", paramString);
      com.tencent.mm.ui.chatting.viewitems.c.s(paramc, parama.getTalkerUserName());
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramc);
    }
    AppMethodBeat.o(255469);
  }
  
  private static final void a(String paramString1, cc paramcc, com.tencent.mm.ui.chatting.d.a parama, long paramLong1, long paramLong2, String paramString2, c paramc, String paramString3, String paramString4, View paramView)
  {
    AppMethodBeat.i(255491);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramcc);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).hB(paramLong1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).hB(paramLong2);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString2);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramc);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString3);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString4);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramString1, "$noticeId");
    kotlin.g.b.s.u(parama, "$ui");
    kotlin.g.b.s.u(paramString2, "$nonceId");
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramString4, "$tipsId");
    for (;;)
    {
      try
      {
        localObject1 = new Intent();
        localObject2 = new JSONObject();
        if (((CharSequence)paramString1).length() != 0) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        ((JSONObject)localObject2).put("type", 2);
        paramView = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(24, 2, 65);
        Object localObject3 = j.Dob;
        j.Doc.axz("temp_7");
        localObject3 = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage();
        if (paramcc != null) {
          continue;
        }
        l = -1L;
        paramcc = ((com.tencent.d.a.a.a.d.h)localObject3).oC(l);
        localObject3 = paramcc.field_businessBuf;
        if (localObject3 != null)
        {
          Log.i(paramc.getTAG(), kotlin.g.b.s.X("source_type:", localObject3));
          ((JSONObject)localObject2).put("source_type", new String((byte[])localObject3, kotlin.n.d.UTF_8));
        }
        ((Intent)localObject1).putExtra("key_chnl_extra", ((JSONObject)localObject2).toString());
        localObject2 = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
        kotlin.g.b.s.s(localObject2, "plugin(IPluginFinderLive::class.java)");
        localObject2 = (com.tencent.d.a.a.a.b)localObject2;
        parama = (Context)parama.aezO.getContext();
        kotlin.g.b.s.s(paramView, "contextId");
        b.b.a((com.tencent.d.a.a.a.b)localObject2, (Intent)localObject1, parama, paramLong1, Long.valueOf(paramLong2), "", paramString2, "", paramView, "", "", "", 0);
        parama = e.BvY;
        e.egO();
        com.tencent.mm.plugin.expt.hellhound.a.aqz(q.n.Dtz.scene);
        if (((CharSequence)paramString1).length() != 0) {
          continue;
        }
        i = 1;
      }
      finally
      {
        int i;
        long l;
        Log.i(paramc.getTAG(), kotlin.g.b.s.X("click ,err msg: ", paramString1.getMessage()));
        continue;
        if (i == 0) {
          continue;
        }
        paramLong1 = 2L;
        continue;
      }
      paramc.a(paramString3, paramLong2, paramcc, paramLong1, paramString4);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255491);
      return;
      i = 0;
      continue;
      ((JSONObject)localObject2).put("type", 1);
      paramView = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(24, 2, 65);
      continue;
      l = paramcc.field_msgId;
      continue;
      i = 0;
      continue;
      paramLong1 = 1L;
    }
  }
  
  private static final void dN(cc paramcc)
  {
    AppMethodBeat.i(255481);
    com.tencent.d.a.a.a.d.h localh = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage();
    if (paramcc == null) {}
    for (long l = -1L;; l = paramcc.field_msgId)
    {
      localh.oA(l);
      AppMethodBeat.o(255481);
      return;
    }
  }
  
  public void a(au.a parama, Map<String, String> paramMap, cc paramcc, com.tencent.mm.ui.chatting.d.a parama1)
  {
    AppMethodBeat.i(255559);
    kotlin.g.b.s.u(paramMap, "values");
    kotlin.g.b.s.u(parama1, "ui");
    if (parama == null) {}
    for (parama = null;; parama = (c.c)parama.bBB(aeZi))
    {
      long l1 = com.tencent.mm.ae.d.FK(Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.object_id"))));
      long l2 = com.tencent.mm.ae.d.FK(Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.live_id"))));
      String str2 = (String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.object_nonce_id"));
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      Object localObject = Util.nullAsNil(str1);
      kotlin.g.b.s.s(localObject, "nullAsNil(values[\"$xmlPr….object_nonce_id\"] ?: \"\")");
      str2 = (String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.tips_id"));
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      String str3 = Util.nullAsNil(str1);
      kotlin.g.b.s.s(str3, "nullAsNil(values[\"$xmlPr…tipsinfo.tips_id\"] ?: \"\")");
      str2 = (String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.notice_id"));
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      str1 = Util.nullAsNil(str1);
      str2 = Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.finder_username")));
      boolean bool = eMf.getBoolean(str2, false);
      kotlin.g.b.s.s(str1, "noticeId");
      a(paramMap, ".msg.appmsg.extinfo.notifymsg", parama, bool, str1, parama1, l1, l2, (String)localObject, paramcc, str2, str3);
      if (parama != null)
      {
        localObject = parama.aeZs;
        if (localObject != null) {
          ((View)localObject).setOnClickListener(new c..ExternalSyntheticLambda0(this, parama1, str2, paramcc, paramMap, ".msg.appmsg.extinfo.notifymsg", l2, parama));
        }
      }
      com.tencent.threadpool.h.ahAA.bm(new c..ExternalSyntheticLambda4(paramcc));
      if (parama != null)
      {
        parama = parama.caK;
        if (parama != null) {
          com.tencent.mm.view.f.a(parama, (e.b)new c.f(paramcc, str1, str2, l2, str3));
        }
      }
      AppMethodBeat.o(255559);
      return;
    }
  }
  
  public void a(String paramString1, long paramLong1, g paramg, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(255571);
    kotlin.g.b.s.u(paramg, "info");
    kotlin.g.b.s.u(paramString2, "tipsId");
    cf localcf = (cf)k.Doi;
    q.cg localcg = q.cg.DFv;
    String str = paramg.field_forcePushId;
    paramg = paramg.field_businessBuf;
    kotlin.g.b.s.s(paramg, "info.field_businessBuf");
    cf.a.a(localcf, localcg, paramString1, paramLong1, "", str, Long.valueOf(paramLong2), new String(paramg, kotlin.n.d.UTF_8), paramString2, null, null, 1536);
    AppMethodBeat.o(255571);
  }
  
  public final void a(Map<String, String> paramMap, String paramString1, c.c paramc, boolean paramBoolean, String paramString2, com.tencent.mm.ui.chatting.d.a parama, long paramLong1, long paramLong2, String paramString3, cc paramcc, String paramString4, String paramString5)
  {
    AppMethodBeat.i(255567);
    kotlin.g.b.s.u(paramMap, "values");
    kotlin.g.b.s.u(paramString1, "xmlPrefix");
    kotlin.g.b.s.u(paramString2, "noticeId");
    kotlin.g.b.s.u(parama, "ui");
    kotlin.g.b.s.u(paramString3, "nonceId");
    kotlin.g.b.s.u(paramString5, "tipsId");
    Object localObject1 = p.ExI;
    Object localObject2 = p.eCp();
    Object localObject3 = new com.tencent.mm.plugin.finder.loader.s(Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(paramString1, ".title.avatar"))), v.FKZ);
    Object localObject4;
    if (paramc == null)
    {
      localObject1 = null;
      kotlin.g.b.s.checkNotNull(localObject1);
      localObject4 = p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, (ImageView)localObject1, p.a(p.a.ExP));
      localObject1 = paramc.Eoo;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(paramString1, ".title.nickname"))));
      }
      localObject1 = (String)paramMap.get(kotlin.g.b.s.X(paramString1, ".title.icon_url"));
      if (localObject1 != null) {
        break label412;
      }
      localObject1 = null;
      label188:
      if (localObject1 == null)
      {
        localObject1 = paramc.aeZr;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
      }
      localObject1 = paramc.aeZx;
      if (localObject1 != null) {
        if (!paramBoolean) {
          break label536;
        }
      }
    }
    label536:
    for (int i = 0;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      localObject1 = paramc.mll;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(paramString1, ".header"))));
      }
      localObject2 = kotlin.g.b.s.X(paramString1, ".display_list.item");
      localObject3 = new LinkedList();
      localObject1 = localObject2;
      i = 1;
      while (paramMap.containsKey(localObject1))
      {
        localObject4 = Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X((String)localObject1, ".topic")));
        localObject1 = Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X((String)localObject1, ".content")));
        if ((localObject4 != null) && (localObject1 != null)) {
          ((LinkedList)localObject3).add(new c.b((String)localObject4, (String)localObject1));
        }
        localObject1 = kotlin.g.b.s.X((String)localObject2, Integer.valueOf(i));
        i += 1;
      }
      localObject1 = paramc.avatar;
      break;
      label412:
      if (((CharSequence)localObject1).length() > 0)
      {
        i = 1;
        label428:
        if (i == 0) {
          break label450;
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label456;
        }
        localObject1 = null;
        break;
        i = 0;
        break label428;
        label450:
        localObject1 = null;
      }
      label456:
      localObject2 = p.ExI;
      localObject2 = p.eCp();
      localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKZ);
      localObject3 = paramc.aeZr;
      kotlin.g.b.s.checkNotNull(localObject3);
      localObject4 = p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, p.a(p.a.ExP));
      localObject1 = paramc.aeZr;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = ah.aiuX;
      break label188;
    }
    paramc.nL((List)localObject3);
    localObject1 = paramc.aeZu;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    localObject2 = paramMap.get(kotlin.g.b.s.X(paramString1, ".live_widget.thumb_url"));
    localObject1 = paramMap.get(kotlin.g.b.s.X(paramString1, ".live_widget.status"));
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject1 = (String)localObject1;
      localObject2 = (String)localObject2;
    }
    try
    {
      localObject2 = Util.nullAsNil((String)localObject2);
      kotlin.g.b.s.s(localObject2, "nullAsNil(url)");
      paramc.iY((String)localObject2, Integer.parseInt((String)localObject1));
      paramMap = Util.nullAsNil((String)paramMap.get(kotlin.g.b.s.X(paramString1, ".tail")));
      kotlin.g.b.s.s(paramMap, "tailStr");
      if (((CharSequence)paramMap).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label809;
        }
        paramString1 = paramc.aeZw;
        if (paramString1 != null) {
          paramString1.setVisibility(0);
        }
        paramString1 = paramc.aeZv;
        if (paramString1 != null) {
          paramString1.setText((CharSequence)paramMap);
        }
        paramMap = paramc.caK;
        if (paramMap != null) {
          paramMap.setOnClickListener(new c..ExternalSyntheticLambda1(paramString2, paramcc, parama, paramLong1, paramLong2, paramString3, this, paramString4, paramString5));
        }
        paramMap = paramc.aeZs;
        if (paramMap != null) {
          paramMap.setVisibility(0);
        }
        AppMethodBeat.o(255567);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Log.i(getTAG(), localNumberFormatException.getMessage());
        continue;
        i = 0;
        continue;
        label809:
        paramMap = paramc.aeZw;
        if (paramMap != null) {
          paramMap.setVisibility(8);
        }
      }
    }
  }
  
  public final void c(com.tencent.mm.ui.widget.a.f paramf)
  {
    this.aeSY = paramf;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final com.tencent.mm.ui.widget.a.f jxF()
  {
    return this.aeSY;
  }
  
  public final int jxG()
  {
    return this.aeZn;
  }
  
  public final int jxH()
  {
    return this.aeZo;
  }
  
  public final int jxI()
  {
    return this.aeZp;
  }
  
  public final String jxJ()
  {
    return this.aeSD;
  }
  
  public final d.a jxK()
  {
    return (d.a)this.aeZq;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$1$2$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFollowNotifySetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ck<bpv>
  {
    d(c paramc, c.c paramc1, String paramString) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$filling$1$2$2$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFollowNotifySetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ck<bpv>
  {
    e(c paramc, c.c paramc1, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.c
 * JD-Core Version:    0.7.0.1
 */