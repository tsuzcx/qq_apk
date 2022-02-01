package com.tencent.mm.ui.chatting.viewitems.a;

import android.view.View;
import com.tencent.d.a.a.a.d.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.au.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveGameTeamUpRefundTmpl;", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "filling", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl$FinderLiveNotifyHolder;", "values", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "reportLiveNotify", "finderUserName", "liveId", "", "info", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "noticeType", "tipsId", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c
{
  private static final String aeZi;
  public static final b.a aeZl;
  private final String TAG = "FinderLiveGameTeamUpNotifyTmpl";
  
  static
  {
    AppMethodBeat.i(255432);
    aeZl = new b.a((byte)0);
    aeZi = "TipsTempl_GamePurchaseRefund_Success";
    AppMethodBeat.o(255432);
  }
  
  public final void a(au.a parama, Map<String, String> paramMap, cc paramcc, a parama1)
  {
    AppMethodBeat.i(255441);
    s.u(paramMap, "values");
    s.u(parama1, "ui");
    if (parama == null)
    {
      parama = null;
      long l1 = d.FK(Util.nullAsNil((String)paramMap.get(s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.object_id"))));
      long l2 = d.FK(Util.nullAsNil((String)paramMap.get(s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.live_id"))));
      String str2 = (String)paramMap.get(s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.object_nonce_id"));
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      String str3 = Util.nullAsNil(str1);
      s.s(str3, "nullAsNil(values[\"$xmlPr….object_nonce_id\"] ?: \"\")");
      str2 = (String)paramMap.get(s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.tips_id"));
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      String str4 = Util.nullAsNil(str1);
      s.s(str4, "nullAsNil(values[\"$xmlPr…tipsinfo.tips_id\"] ?: \"\")");
      str2 = (String)paramMap.get(s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.notice_id"));
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      str1 = Util.nullAsNil(str1);
      str2 = Util.nullAsNil((String)paramMap.get(s.X(".msg.appmsg.extinfo.notifymsg", ".tipsinfo.finder_username")));
      s.s(str1, "noticeId");
      a(paramMap, ".msg.appmsg.extinfo.notifymsg", parama, false, str1, parama1, l1, l2, str3, paramcc, str2, str4);
      if (parama != null) {
        break label338;
      }
      paramMap = null;
      label258:
      if (paramMap != null) {
        paramMap.setVisibility(8);
      }
      if (parama != null)
      {
        paramMap = parama.caK;
        if (paramMap != null) {
          paramMap.setOnClickListener(null);
        }
      }
      if (parama != null) {
        break label346;
      }
      paramMap = null;
      label292:
      if (paramMap != null) {
        paramMap.setVisibility(8);
      }
      if (parama != null) {
        break label354;
      }
    }
    label338:
    label346:
    label354:
    for (parama = null;; parama = parama.aeZu)
    {
      if (parama != null) {
        parama.setVisibility(8);
      }
      AppMethodBeat.o(255441);
      return;
      parama = (c.c)parama.bBB(aeZi);
      break;
      paramMap = parama.aeZs;
      break label258;
      paramMap = parama.aeZw;
      break label292;
    }
  }
  
  public final void a(String paramString1, long paramLong1, g paramg, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(255446);
    s.u(paramg, "info");
    s.u(paramString2, "tipsId");
    AppMethodBeat.o(255446);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.b
 * JD-Core Version:    0.7.0.1
 */