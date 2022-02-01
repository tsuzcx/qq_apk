package com.tencent.mm.plugin.selectrecord.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.a.vl;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements s
{
  public static final Pattern lyZ;
  
  static
  {
    AppMethodBeat.i(266674);
    lyZ = Pattern.compile("\\$\\{(.+)\\}");
    AppMethodBeat.o(266674);
  }
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(266695);
    Log.d("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml subType:%s", new Object[] { Util.nullAs(paramString, "") });
    if ((Util.nullAsNil(paramString).equals("revokehistoryinjoinroommsg")) && (paramMap != null)) {}
    try
    {
      if (!paramMap.containsKey(".sysmsg.revokehistoryinjoinroommsg.historyid")) {
        break label610;
      }
      str1 = Util.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.historyid")).trim();
      str2 = Util.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.roomname")).trim();
      parama = Util.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.template")).trim();
      str3 = Util.nullAsNil((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.inviterusername")).trim();
      i = Util.getInt((String)paramMap.get(".sysmsg.revokehistoryinjoinroommsg.oper"), 0);
      if ((i != 1) && ((i != 2) || (Util.isEqual(str3, z.bAM())))) {
        break label659;
      }
      paramString = ((PluginSelectRecord)h.az(PluginSelectRecord.class)).getSelectRecordStorage().aVw(str1);
      Log.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "historyId:%s deleteRelatedMsgs res:%s", new Object[] { str1, Boolean.valueOf(((PluginSelectRecord)h.az(PluginSelectRecord.class)).getSelectRecordStorage().aVu(str1)) });
      paramString.po(paramString.jUq | 0x1000);
      ((n)h.ax(n.class)).gaZ().a(paramString.field_msgId, paramString);
      paramMap = new vl();
      paramMap.hZf.msgId = paramString.field_msgId;
      paramMap.asyncPublish(Looper.myLooper());
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
        au localau;
        Log.e("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
        paramString = parama;
        continue;
        boolean bool = false;
      }
    }
    paramString = lyZ.matcher(parama);
    if (paramString.find())
    {
      str4 = paramString.group(0);
      if ((!Util.isNullOrNil(str4)) && (str4.length() > 3))
      {
        paramString = str4.substring(2, str4.length() - 1);
        h.baF();
        localau = ((n)h.ax(n.class)).bzA().JE(paramString);
        if (!Util.isNullOrNil(localau.field_conRemark))
        {
          paramString = localau.field_conRemark;
          paramMap = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramMap = localau.field_conRemark;
          }
          paramString = paramMap;
          if (Util.isNullOrNil(paramMap)) {
            paramString = localau.aSU();
          }
          paramMap = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramMap = localau.field_username;
          }
          paramString = parama.replace(str4, p.b(MMApplicationContext.getContext(), paramMap));
          paramMap = new cc();
          paramMap.pI(0);
          paramMap.BS(str2);
          paramMap.setStatus(3);
          paramMap.setContent(paramString);
          paramMap.setCreateTime(br.D(str2, System.currentTimeMillis() / 1000L));
          paramMap.setType(10000);
          paramMap.setFlag(paramMap.field_flag | 0x8);
          Log.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "consumeNewXml roomName:%s oper:%s historyId:%s template msgId:%s inviterUsername:%s revokeHistroy:%s", new Object[] { str2, Integer.valueOf(i), str1, Long.valueOf(br.B(paramMap)), str3, Boolean.valueOf(bool) });
        }
        for (;;)
        {
          AppMethodBeat.o(266695);
          return null;
          paramString = localau.field_username;
          paramMap = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(str2);
          if (paramMap == null)
          {
            paramString = null;
            break;
          }
          paramString = paramMap.getDisplayName(paramString);
          break;
          label610:
          Log.i("MicroMsg.recordSelect.RevokeHistoryInjoinRoomMsgNewXmlConsumer", "no contains historyid");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.c.a
 * JD-Core Version:    0.7.0.1
 */