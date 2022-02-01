package com.tencent.mm.plugin.sns.cover.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nq;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/report/SnsCoverReporter;", "", "()V", "commitTimeStamp", "", "value", "", "localId", "getLocalId", "()I", "setLocalId", "(I)V", "snsCoverReport", "Lcom/tencent/mm/autogen/mmdata/rpt/SnsCoverReportStruct;", "markPageIn", "", "markPageOut", "cancel", "", "markPostFinish", "errorCode", "markType", "type", "reportCoverBlock", "snsCover", "Lcom/tencent/mm/plugin/sns/storage/SnsCover;", "reportGetFeedDetail", "snsObject", "Lcom/tencent/mm/protocal/protobuf/SnsObject;", "reportGetFeedDetailError", "snsObjId", "errorMsg", "", "selectCoverType", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static nq Qml;
  public static final b Qmn;
  private static long Qmo;
  private static int icg;
  
  static
  {
    AppMethodBeat.i(307358);
    Qmn = new b();
    icg = -1;
    AppMethodBeat.o(307358);
  }
  
  public static void akk(int paramInt)
  {
    AppMethodBeat.i(307323);
    icg = paramInt;
    Qmo = System.currentTimeMillis();
    AppMethodBeat.o(307323);
  }
  
  public static void akl(int paramInt)
  {
    nq localnq = Qml;
    if (localnq != null) {
      localnq.jfy = paramInt;
    }
    localnq = Qml;
    if (localnq != null) {
      localnq.jfw = 4;
    }
  }
  
  public static void b(q paramq)
  {
    AppMethodBeat.i(307346);
    s.u(paramq, "snsCover");
    nq localnq = new nq();
    localnq.vK(paramq.field_userName);
    localnq.jfw = 5;
    paramq = paramq.toString();
    s.s(paramq, "snsCover.toString()");
    localnq.vL(n.m(paramq, ",", ";", false));
    localnq.bMH();
    AppMethodBeat.o(307346);
  }
  
  public static void b(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(307349);
    if (paramSnsObject == null)
    {
      AppMethodBeat.o(307349);
      return;
    }
    nq localnq = new nq();
    String str = w.b(paramSnsObject.ObjectDesc);
    localnq.jfw = 6;
    localnq.vK(paramSnsObject.Username);
    localnq.vL(n.m(s.X("xmlString:", str), ",", ";", false));
    localnq.jfE = 0;
    localnq.bMH();
    AppMethodBeat.o(307349);
  }
  
  public static void heG()
  {
    AppMethodBeat.i(307326);
    Qml = new nq();
    AppMethodBeat.o(307326);
  }
  
  public static void heH()
  {
    AppMethodBeat.i(307329);
    nq localnq = Qml;
    if (localnq != null) {
      localnq.jfw = 3;
    }
    localnq = Qml;
    if (localnq != null) {
      localnq.bMH();
    }
    Qml = null;
    AppMethodBeat.o(307329);
  }
  
  public static void i(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(307354);
    nq localnq = new nq();
    localnq.jfw = 6;
    localnq.vL(n.bV("snsObjId:" + t.uA(paramLong) + ";errorMsg:" + paramString, ",", ";"));
    localnq.jfE = paramInt;
    localnq.bMH();
    AppMethodBeat.o(307354);
  }
  
  public static void lm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(307340);
    if (paramInt1 == icg)
    {
      nq localnq = Qml;
      if (localnq != null) {
        localnq.jfF = ((int)(System.currentTimeMillis() - Qmo));
      }
      localnq = Qml;
      if (localnq != null) {
        localnq.jfE = paramInt2;
      }
      localnq = Qml;
      if (localnq != null) {
        localnq.bMH();
      }
      Qml = null;
    }
    AppMethodBeat.o(307340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.c.b
 * JD-Core Version:    0.7.0.1
 */