package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hi;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/ForwardReporter;", "", "()V", "CLICK_ZONE_DEFAULT", "", "CLICK_ZONE_RECENT_CHATTING", "TAG", "", "report23009", "", "msgTypeList", "receiverType", "", "userListSeq", "recentListSeq", "createNew", "isMultiSelect", "scene", "clickZone", "toUser", "appMsgInnerTypeList", "topSessionCount", "costTime", "delListString", "delCount", "logVersion", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m afdY;
  
  static
  {
    AppMethodBeat.i(252904);
    afdY = new m();
    AppMethodBeat.o(252904);
  }
  
  public static final void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, String paramString2, String paramString3, long paramLong8, long paramLong9, String paramString4, int paramInt, long paramLong10)
  {
    AppMethodBeat.i(252898);
    s.u(paramString1, "msgTypeList");
    s.u(paramString3, "appMsgInnerTypeList");
    s.u(paramString4, "delListString");
    hi localhi = new hi();
    localhi.iNS = localhi.F("MsgTypeList", paramString1, true);
    localhi.iNT = paramLong1;
    localhi.iNU = paramLong2;
    localhi.iNV = paramLong3;
    localhi.iNW = paramLong4;
    localhi.iNX = paramLong5;
    localhi.iqr = paramLong6;
    localhi.iNY = paramLong7;
    if (paramString2 == null)
    {
      paramString1 = "";
      localhi.iNR = localhi.F("ToUser", paramString1, true);
      localhi.iOb = localhi.F("InnerAppMsgTypeList", paramString3, true);
      localhi.iOa = paramLong8;
      localhi.ijA = paramLong9;
      localhi.iNL = localhi.F("Del_list", paramString4, true);
      localhi.iNK = paramInt;
      localhi.iNN = 0L;
      localhi.iNQ = paramLong10;
      if (!v.Iv(paramString2)) {
        break label277;
      }
    }
    label277:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localhi.iOc = paramLong1;
      localhi.bMH();
      s.s(localhi, "it");
      paramString1 = (a)localhi;
      paramInt = paramString1.getId();
      paramString1 = paramString1.aIF();
      s.s(paramString1, "struct.toShowString()");
      Log.i("ForwardReporter", "report%s %s", new Object[] { Integer.valueOf(paramInt), n.m(paramString1, "\r\n", " ", false) });
      AppMethodBeat.o(252898);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.contact.m
 * JD-Core Version:    0.7.0.1
 */