package com.tencent.mm.plugin.ringtone.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.md;
import com.tencent.mm.autogen.mmdata.rpt.me;
import com.tencent.mm.autogen.mmdata.rpt.mf;
import com.tencent.mm.autogen.mmdata.rpt.mg;
import com.tencent.mm.autogen.mmdata.rpt.mh;
import com.tencent.mm.autogen.mmdata.rpt.uv;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/report/RingtoneKVReport;", "", "()V", "RINGTONE_INVAILD", "", "RINGTONE_SOURCE_EXCLUSIVE", "", "RINGTONE_SOURCE_GLOBAL", "RINGTONE_TYPE_DEFAULT", "RINGTONE_TYPE_FINDER", "RINGTONE_TYPE_MUSIC", "RINGTONE_VAILD", "TAG", "", "doReportChoiceRingtone", "", "sessionId", "feedId", "feedType", "scene", "previewTimeMs", "isIndividual", "toUserName", "setType", "channel", "searchKeyword", "doReportClickProfile", "action", "username", "unAvailable", "", "isVibrate", "doReportClickRingtone", "doReportQuickSetRingtone", "doReportQuickSetRingtoneExposure", "wordingType", "wording", "doReportRecommendExposure", "listSize", "chooseTimMs", "setRingType", "doReportVoipRingtoneCalled", "voipType", "roomId", "roomKey", "playDuration", "isMute", "doReportVoipRingtoneCalling", "logoClick", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ODG;
  
  static
  {
    AppMethodBeat.i(272832);
    ODG = new a();
    AppMethodBeat.o(272832);
  }
  
  public static final void L(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(272828);
    s.u(paramString, "wording");
    mh localmh = new mh();
    localmh.ime = paramInt2;
    localmh.jby = localmh.F("wording", paramString, true);
    localmh.jbx = paramInt1;
    localmh.bMH();
    AppMethodBeat.o(272828);
  }
  
  public static final void P(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272824);
    s.u(paramString, "feedId");
    mf localmf = new mf();
    localmf.ipW = localmf.F("feedid", paramString, true);
    localmf.iLB = paramLong1;
    localmf.iuA = paramLong2;
    localmf.bMH();
    AppMethodBeat.o(272824);
  }
  
  public static final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString1, int paramInt4, String paramString2, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(272819);
    s.u(paramString1, "feedId");
    s.u(paramString2, "username");
    me localme = new me();
    localme.ixD = paramInt1;
    localme.iLB = paramInt2;
    localme.iWQ = paramInt3;
    localme.jbo = paramLong1;
    localme.ipW = localme.F("feedid", paramString1, true);
    localme.jbk = paramInt4;
    localme.jbg = localme.F("tousername", paramString2, true);
    localme.jbn = paramLong2;
    if (paramBoolean1)
    {
      paramInt1 = 1;
      localme.jbp = paramInt1;
      if (!paramBoolean2) {
        break label143;
      }
    }
    label143:
    for (paramLong1 = 1L;; paramLong1 = 2L)
    {
      localme.jbj = paramLong1;
      localme.bMH();
      AppMethodBeat.o(272819);
      return;
      paramInt1 = 2;
      break;
    }
  }
  
  public static final void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, boolean paramBoolean, long paramLong1, String paramString2, long paramLong2, int paramInt4)
  {
    AppMethodBeat.i(272811);
    s.u(paramString1, "feedId");
    s.u(paramString2, "username");
    mg localmg = new mg();
    localmg.jbs = localmg.F("feedId", paramString1, true);
    localmg.jbt = paramInt2;
    localmg.jbu = paramInt3;
    if (paramBoolean) {}
    for (long l = 1L;; l = 2L)
    {
      localmg.jbw = l;
      localmg.jbn = paramLong1;
      localmg.jbv = localmg.F("toUserName", paramString2, true);
      localmg.jbq = paramInt4;
      localmg.jbr = paramLong2;
      localmg.ixD = paramInt1;
      localmg.bMH();
      AppMethodBeat.o(272811);
      return;
    }
  }
  
  public static final void a(long paramLong, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 1L;
    AppMethodBeat.i(272792);
    s.u(paramString1, "feedId");
    md localmd = new md();
    localmd.ila = paramLong;
    localmd.ipW = localmd.F("feedid", paramString1, true);
    localmd.iLB = paramInt;
    localmd.jbg = localmd.F("tousername", paramString2, true);
    if (paramBoolean1)
    {
      paramLong = 1L;
      localmd.jbi = paramLong;
      if (!paramBoolean2) {
        break label111;
      }
    }
    label111:
    for (paramLong = l;; paramLong = 2L)
    {
      localmd.jbj = paramLong;
      localmd.bMH();
      AppMethodBeat.o(272792);
      return;
      paramLong = 2L;
      break;
    }
  }
  
  public static final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2, int paramInt4, int paramInt5, String paramString3)
  {
    AppMethodBeat.i(272787);
    s.u(paramString1, "sessionId");
    s.u(paramString2, "toUserName");
    uv localuv = new uv();
    localuv.Ay(paramString1);
    localuv.jIb = paramInt1;
    localuv.iSo = 1L;
    localuv.iuA = paramInt2;
    localuv.gL(paramLong);
    localuv.jbk = paramInt3;
    localuv.Aw(paramString3);
    localuv.jIf = paramInt4;
    localuv.jxf = paramInt5;
    if (paramInt3 == 2) {
      localuv.Ax(paramString2);
    }
    localuv.bMH();
    AppMethodBeat.o(272787);
  }
  
  public static final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, int paramInt5, int paramInt6, String paramString4)
  {
    AppMethodBeat.i(272782);
    s.u(paramString1, "sessionId");
    s.u(paramString2, "feedId");
    s.u(paramString3, "toUserName");
    uv localuv = new uv();
    localuv.jIb = 1L;
    localuv.Ay(paramString1);
    localuv.iwe = paramInt1;
    localuv.Av(paramString2);
    localuv.iSo = 3L;
    localuv.iuA = paramInt2;
    localuv.gK(paramInt3);
    localuv.jbk = paramInt4;
    localuv.Aw(paramString4);
    localuv.jxf = paramInt6;
    if (paramInt4 == 2) {
      localuv.Ax(paramString3);
    }
    localuv.jIf = paramInt5;
    localuv.bMH();
    AppMethodBeat.o(272782);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, int paramInt5, int paramInt6, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(272784);
    s.u(paramString1, "sessionId");
    s.u(paramString2, "feedId");
    s.u(paramString3, "toUserName");
    uv localuv = new uv();
    localuv.jIb = 1L;
    localuv.Ay(paramString1);
    localuv.iwe = paramInt1;
    localuv.Av(paramString2);
    localuv.iSo = 2L;
    localuv.iuA = paramInt2;
    localuv.gK(paramInt3);
    localuv.jbk = paramInt4;
    localuv.Aw(paramString4);
    localuv.jxf = paramInt6;
    if (paramInt4 == 2) {
      localuv.Ax(paramString3);
    }
    localuv.jIf = paramInt5;
    if (paramBoolean) {}
    for (long l = 1L;; l = 2L)
    {
      localuv.jbj = l;
      localuv.bMH();
      AppMethodBeat.o(272784);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.h.a
 * JD-Core Version:    0.7.0.1
 */