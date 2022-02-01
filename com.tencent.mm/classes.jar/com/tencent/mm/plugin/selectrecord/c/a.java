package com.tencent.mm.plugin.selectrecord.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.plugin.selectrecord.e.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements p
{
  public static final Pattern fLv;
  
  static
  {
    AppMethodBeat.i(207398);
    fLv = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(207398);
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(207397);
    ad.d("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { bt.bI(paramString, "") });
    if ((bt.nullAsNil(paramString).equals("revokehistoryinjoinroommsg")) && (paramMap != null)) {}
    try
    {
      if (!paramMap.containsKey(".sysmsg.revokehistoryinjoinroommsg.historyid")) {
        break label575;
      }
      str1 = bt.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.historyid")).trim();
      str2 = bt.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.roomname")).trim();
      parama = bt.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.template")).trim();
      str3 = bt.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.inviterusername")).trim();
      i = bt.getInt((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.oper"), 0);
      if ((i != 1) && ((i != 2) || (bt.lQ(str3, u.aAm())))) {
        break label624;
      }
      paramString = ((PluginSelectRecord)g.ad(PluginSelectRecord.class)).getSelectRecordStorage().aHp(str1);
      paramString.jY(paramString.eLr | 0x1000);
      ((l)g.ab(l.class)).dlK().a(paramString.field_msgId, paramString);
      paramMap = new ry();
      paramMap.dGx.msgId = paramString.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.a(paramMap, Looper.myLooper());
      bool = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        int i;
        String str4;
        am localam;
        ad.e("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
        paramString = parama;
        continue;
        boolean bool = false;
      }
    }
    paramString = fLv.matcher(parama);
    if (paramString.find())
    {
      str4 = paramString.group(0);
      if ((!bt.isNullOrNil(str4)) && (str4.length() > 3))
      {
        paramString = str4.substring(2, str4.length() - 1);
        g.ajD();
        localam = ((l)g.ab(l.class)).azp().Bf(paramString);
        if (!bt.isNullOrNil(localam.field_conRemark))
        {
          paramString = localam.field_conRemark;
          paramMap = paramString;
          if (bt.isNullOrNil(paramString)) {
            paramMap = localam.field_conRemark;
          }
          paramString = paramMap;
          if (bt.isNullOrNil(paramMap)) {
            paramString = localam.adu();
          }
          paramMap = paramString;
          if (bt.isNullOrNil(paramString)) {
            paramMap = localam.field_username;
          }
          paramString = parama.replace(str4, k.c(aj.getContext(), paramMap));
          paramMap = new bu();
          paramMap.kr(0);
          paramMap.tN(str2);
          paramMap.setStatus(3);
          paramMap.setContent(paramString);
          paramMap.qA(bj.B(str2, System.currentTimeMillis() / 1000L));
          paramMap.setType(10000);
          paramMap.setFlag(paramMap.field_flag | 0x8);
          ad.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml roomName:%s oper:%s historyId:%s template msgId:%s inviterUsername:%s revokeHistroy:%s", new Object[] { str2, Integer.valueOf(i), str1, Long.valueOf(bj.v(paramMap)), str3, Boolean.valueOf(bool) });
        }
        for (;;)
        {
          AppMethodBeat.o(207397);
          return null;
          paramString = localam.field_username;
          paramMap = ((c)g.ab(c.class)).azz().AN(str2);
          if (paramMap == null)
          {
            paramString = null;
            break;
          }
          paramString = paramMap.zf(paramString);
          break;
          label575:
          ad.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "no contains historyid");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.c.a
 * JD-Core Version:    0.7.0.1
 */