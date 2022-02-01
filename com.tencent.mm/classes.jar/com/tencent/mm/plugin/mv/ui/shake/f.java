package com.tencent.mm.plugin.mv.ui.shake;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.my;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/shake/ShakeReporter;", "", "()V", "shakeActionReport2Struct", "Lcom/tencent/mm/autogen/mmdata/rpt/ShakeActionReport2Struct;", "getShakeActionReport2Struct", "()Lcom/tencent/mm/autogen/mmdata/rpt/ShakeActionReport2Struct;", "setShakeActionReport2Struct", "(Lcom/tencent/mm/autogen/mmdata/rpt/ShakeActionReport2Struct;)V", "doReport", "", "action", "", "init", "sessionId", "", "shakeSessionId", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "copyright", "isFromHistory", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelmusic/MusicWrapper;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f McU;
  private static my McV;
  
  static
  {
    AppMethodBeat.i(287361);
    McU = new f();
    McV = new my();
    AppMethodBeat.o(287361);
  }
  
  public static void BI(int paramInt)
  {
    AppMethodBeat.i(287351);
    h.ahAA.r(new f..ExternalSyntheticLambda0(paramInt), 100L);
    AppMethodBeat.o(287351);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.aw.f paramf, Integer paramInteger, Boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(287345);
    McV.vq(paramString1);
    paramString1 = McV;
    paramString1.jcM = paramString1.F("SharkSessionID", paramString2, true);
    paramString2 = McV;
    label58:
    label74:
    label90:
    long l;
    if (paramf == null)
    {
      paramString1 = null;
      paramString2.vr(paramString1);
      paramString2 = McV;
      if (paramf != null) {
        break label175;
      }
      paramString1 = null;
      paramString2.vs(paramString1);
      paramString2 = McV;
      if (paramf != null) {
        break label183;
      }
      paramString1 = null;
      paramString2.vu(paramString1);
      paramString2 = McV;
      if (paramf != null) {
        break label191;
      }
      paramString1 = null;
      paramString2.vt(paramString1);
      paramString1 = McV;
      if (paramInteger != null) {
        break label199;
      }
      l = 0L;
      label107:
      paramString1.jcT = l;
      paramString1 = McV;
      if (!s.p(paramBoolean, Boolean.TRUE)) {
        break label209;
      }
      l = 1L;
      label131:
      paramString1.jcU = l;
      paramString2 = McV;
      if (paramf != null) {
        break label217;
      }
    }
    label175:
    label183:
    label191:
    label199:
    label209:
    label217:
    for (paramString1 = localObject;; paramString1 = paramf.oOv)
    {
      paramString2.vp(paramString1);
      McV.jcK = 2;
      AppMethodBeat.o(287345);
      return;
      paramString1 = paramf.oOx;
      break;
      paramString1 = paramf.oOy;
      break label58;
      paramString1 = paramf.playUrl;
      break label74;
      paramString1 = paramf.playUrl;
      break label90;
      l = paramInteger.intValue();
      break label107;
      l = 2L;
      break label131;
    }
  }
  
  private static final void aec(int paramInt)
  {
    AppMethodBeat.i(287355);
    McV.ilm = paramInt;
    my localmy = McV;
    if (localmy != null) {
      localmy.bMH();
    }
    AppMethodBeat.o(287355);
  }
  
  public static my gqu()
  {
    return McV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.f
 * JD-Core Version:    0.7.0.1
 */