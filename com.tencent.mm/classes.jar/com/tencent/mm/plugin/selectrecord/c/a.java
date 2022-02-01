package com.tencent.mm.plugin.selectrecord.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.plugin.selectrecord.d.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements p
{
  public static final Pattern fNz;
  
  static
  {
    AppMethodBeat.i(194000);
    fNz = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(194000);
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(193999);
    ae.d("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { bu.bI(paramString, "") });
    if ((bu.nullAsNil(paramString).equals("revokehistoryinjoinroommsg")) && (paramMap != null)) {}
    try
    {
      if (!paramMap.containsKey(".sysmsg.revokehistoryinjoinroommsg.historyid")) {
        break label575;
      }
      str1 = bu.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.historyid")).trim();
      str2 = bu.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.roomname")).trim();
      parama = bu.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.template")).trim();
      str3 = bu.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.inviterusername")).trim();
      i = bu.getInt((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.oper"), 0);
      if ((i != 1) && ((i != 2) || (bu.lX(str3, v.aAC())))) {
        break label624;
      }
      paramString = ((PluginSelectRecord)g.ad(PluginSelectRecord.class)).getSelectRecordStorage().ayr(str1);
      paramString.ka(paramString.eNc | 0x1000);
      ((l)g.ab(l.class)).doJ().a(paramString.field_msgId, paramString);
      paramMap = new rz();
      paramMap.dHD.msgId = paramString.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.a(paramMap, Looper.myLooper());
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
        an localan;
        ae.e("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
        paramString = parama;
        continue;
        boolean bool = false;
      }
    }
    paramString = fNz.matcher(parama);
    if (paramString.find())
    {
      str4 = paramString.group(0);
      if ((!bu.isNullOrNil(str4)) && (str4.length() > 3))
      {
        paramString = str4.substring(2, str4.length() - 1);
        g.ajS();
        localan = ((l)g.ab(l.class)).azF().BH(paramString);
        if (!bu.isNullOrNil(localan.field_conRemark))
        {
          paramString = localan.field_conRemark;
          paramMap = paramString;
          if (bu.isNullOrNil(paramString)) {
            paramMap = localan.field_conRemark;
          }
          paramString = paramMap;
          if (bu.isNullOrNil(paramMap)) {
            paramString = localan.adF();
          }
          paramMap = paramString;
          if (bu.isNullOrNil(paramString)) {
            paramMap = localan.field_username;
          }
          paramString = parama.replace(str4, k.c(ak.getContext(), paramMap));
          paramMap = new bv();
          paramMap.kt(0);
          paramMap.ui(str2);
          paramMap.setStatus(3);
          paramMap.setContent(paramString);
          paramMap.qN(bl.B(str2, System.currentTimeMillis() / 1000L));
          paramMap.setType(10000);
          paramMap.setFlag(paramMap.field_flag | 0x8);
          ae.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml roomName:%s oper:%s historyId:%s template msgId:%s inviterUsername:%s revokeHistroy:%s", new Object[] { str2, Integer.valueOf(i), str1, Long.valueOf(bl.v(paramMap)), str3, Boolean.valueOf(bool) });
        }
        for (;;)
        {
          AppMethodBeat.o(193999);
          return null;
          paramString = localan.field_username;
          paramMap = ((c)g.ab(c.class)).azP().Bx(str2);
          if (paramMap == null)
          {
            paramString = null;
            break;
          }
          paramString = paramMap.zP(paramString);
          break;
          label575:
          ae.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "no contains historyid");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.c.a
 * JD-Core Version:    0.7.0.1
 */