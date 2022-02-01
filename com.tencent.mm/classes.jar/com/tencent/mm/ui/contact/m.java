package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.fn;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/ForwardReporter;", "", "()V", "TAG", "", "report23009", "", "msgTypeList", "receiverType", "", "userListSeq", "recentListSeq", "createNew", "isMultiSelect", "scene", "clickZone", "toUser", "appMsgInnerTypeList", "topSessionCount", "costTime", "logVersion", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "ui-selectcontact_release"})
public final class m
{
  public static final m Xsx;
  
  static
  {
    AppMethodBeat.i(186354);
    Xsx = new m();
    AppMethodBeat.o(186354);
  }
  
  public static final void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, String paramString2, String paramString3, long paramLong8, long paramLong9, long paramLong10)
  {
    AppMethodBeat.i(293067);
    p.k(paramString1, "msgTypeList");
    p.k(paramString2, "toUser");
    p.k(paramString3, "appMsgInnerTypeList");
    paramString1 = new fn().uR(paramString1).oh(paramLong1).oi(paramLong2).oj(paramLong3).ok(paramLong4).ol(paramLong5).om(paramLong6).on(paramLong7).uS(paramString2).uT(paramString3).oo(paramLong8).LM(paramLong9).SE(paramLong10);
    paramString1.bpa();
    p.j(paramString1, "it");
    paramString1 = (a)paramString1;
    int i = paramString1.getId();
    paramString1 = paramString1.agI();
    p.j(paramString1, "struct.toShowString()");
    Log.i("ForwardReporter", "report%s %s", new Object[] { Integer.valueOf(i), n.l(paramString1, "\r\n", " ", false) });
    AppMethodBeat.o(293067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.m
 * JD-Core Version:    0.7.0.1
 */