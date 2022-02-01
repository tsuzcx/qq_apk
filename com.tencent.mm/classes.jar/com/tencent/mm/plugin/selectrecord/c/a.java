package com.tencent.mm.plugin.selectrecord.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.f.a.tw;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements s
{
  public static final Pattern iWW;
  
  static
  {
    AppMethodBeat.i(255207);
    iWW = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(255207);
  }
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(255206);
    Log.d("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { Util.nullAs(paramString, "") });
    if ((Util.nullAsNil(paramString).equals("revokehistoryinjoinroommsg")) && (paramMap != null)) {}
    try
    {
      if (!paramMap.containsKey(".sysmsg.revokehistoryinjoinroommsg.historyid")) {
        break label575;
      }
      str1 = Util.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.historyid")).trim();
      str2 = Util.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.roomname")).trim();
      parama = Util.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.template")).trim();
      str3 = Util.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.inviterusername")).trim();
      i = Util.getInt((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.oper"), 0);
      if ((i != 1) && ((i != 2) || (Util.isEqual(str3, z.bcZ())))) {
        break label624;
      }
      paramString = ((PluginSelectRecord)h.ag(PluginSelectRecord.class)).getSelectRecordStorage().aXL(str1);
      paramString.pp(paramString.hxx | 0x1000);
      ((n)h.ae(n.class)).eSe().a(paramString.field_msgId, paramString);
      paramMap = new tw();
      paramMap.fTh.msgId = paramString.field_msgId;
      EventCenter.instance.asyncPublish(paramMap, Looper.myLooper());
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
        as localas;
        Log.e("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
        paramString = parama;
        continue;
        boolean bool = false;
      }
    }
    paramString = iWW.matcher(parama);
    if (paramString.find())
    {
      str4 = paramString.group(0);
      if ((!Util.isNullOrNil(str4)) && (str4.length() > 3))
      {
        paramString = str4.substring(2, str4.length() - 1);
        h.aHH();
        localas = ((n)h.ae(n.class)).bbL().RG(paramString);
        if (!Util.isNullOrNil(localas.field_conRemark))
        {
          paramString = localas.field_conRemark;
          paramMap = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramMap = localas.field_conRemark;
          }
          paramString = paramMap;
          if (Util.isNullOrNil(paramMap)) {
            paramString = localas.ayr();
          }
          paramMap = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramMap = localas.field_username;
          }
          paramString = parama.replace(str4, l.c(MMApplicationContext.getContext(), paramMap));
          paramMap = new ca();
          paramMap.pJ(0);
          paramMap.Jm(str2);
          paramMap.setStatus(3);
          paramMap.setContent(paramString);
          paramMap.setCreateTime(bq.z(str2, System.currentTimeMillis() / 1000L));
          paramMap.setType(10000);
          paramMap.setFlag(paramMap.field_flag | 0x8);
          Log.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml roomName:%s oper:%s historyId:%s template msgId:%s inviterUsername:%s revokeHistroy:%s", new Object[] { str2, Integer.valueOf(i), str1, Long.valueOf(bq.z(paramMap)), str3, Boolean.valueOf(bool) });
        }
        for (;;)
        {
          AppMethodBeat.o(255206);
          return null;
          paramString = localas.field_username;
          paramMap = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(str2);
          if (paramMap == null)
          {
            paramString = null;
            break;
          }
          paramString = paramMap.PJ(paramString);
          break;
          label575:
          Log.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "no contains historyid");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.c.a
 * JD-Core Version:    0.7.0.1
 */