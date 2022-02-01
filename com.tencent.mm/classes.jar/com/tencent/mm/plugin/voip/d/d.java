package com.tencent.mm.plugin.voip.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.qx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipFloatCardReportManager;", "", "()V", "ACTION_ACCEPT", "", "ACTION_AVATAR", "ACTION_FLING", "ACTION_REJECT", "CALL_TYPE_AUDIO", "CALL_TYPE_MISS", "CALL_TYPE_MULTITALK", "CALL_TYPE_REJECT", "CALL_TYPE_VIDEO", "KEY_DISMISS_CALLED", "", "KEY_PERMISSION_STATUS", "KEY_SHOWED_CALL_TYPE", "KEY_SHOWING_DURATION", "KEY_VIEW_REMOVED", "PERMISSION_TYPE_NO_FLOAT_WINDOW", "PERMISSION_TYPE_NO_VA", "PERMISSION_TYPE_OK", "PERMISSION_TYPE_UNKNOWN", "TYPE_MULTITALK", "TYPE_VIDEO", "TYPE_VOICE", "reportInfo", "Lcom/tencent/mm/plugin/voip/report/VoipFloatCardReportManager$FloatCardReportData;", "showTime", "", "markDismissCalled", "", "markNoPermission", "showType", "hasFloatWindowPermission", "", "hasAudioVideoPermission", "markShow", "markViewRemoved", "report", "rRoomKey", "rAction", "rType", "reportAccept", "reportAvatar", "reportFling", "reportJson", "reportReject", "FloatCardReportData", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d UGN;
  private static long UGO;
  private static d.a UGP;
  
  static
  {
    AppMethodBeat.i(292810);
    UGN = new d();
    UGP = new d.a((byte)0);
    AppMethodBeat.o(292810);
  }
  
  public static void aqG(int paramInt)
  {
    AppMethodBeat.i(292778);
    d.a locala = UGP;
    locala.UGT = 1;
    locala.UGS = paramInt;
    UGO = System.currentTimeMillis();
    AppMethodBeat.o(292778);
  }
  
  public static void hZO()
  {
    AppMethodBeat.i(292791);
    d.a locala = UGP;
    if (locala.UGT == 1)
    {
      locala.UGQ = 1;
      locala.duration = (System.currentTimeMillis() - UGO);
    }
    AppMethodBeat.o(292791);
  }
  
  public static void hZP()
  {
    d.a locala = UGP;
    if (locala.UGT == 1) {
      locala.UGR = 1;
    }
  }
  
  public static String hZQ()
  {
    AppMethodBeat.i(292804);
    Object localObject = UGP;
    i locali = new i();
    locali.au("permission_status", ((d.a)localObject).UGT);
    locali.au("dismiss_called", ((d.a)localObject).UGQ);
    locali.au("showed_call_type", ((d.a)localObject).UGS);
    locali.t("showing_duration", ((d.a)localObject).duration);
    locali.au("view_removed", ((d.a)localObject).UGR);
    localObject = locali.toString();
    s.s(localObject, "reportInfo.let {\n       …   }.toString()\n        }");
    UGP = new d.a((byte)0);
    AppMethodBeat.o(292804);
    return localObject;
  }
  
  public static void r(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    d.a locala = UGP;
    locala.UGS = paramInt;
    if (!paramBoolean2) {
      paramInt = 3;
    }
    for (;;)
    {
      locala.UGT = paramInt;
      return;
      if (!paramBoolean1) {
        paramInt = 2;
      } else {
        paramInt = -1;
      }
    }
  }
  
  public static void z(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292770);
    qx localqx = new qx();
    localqx.ila = paramInt1;
    localqx.iWR = paramLong;
    localqx.ixD = paramInt2;
    localqx.bMH();
    AppMethodBeat.o(292770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.d
 * JD-Core Version:    0.7.0.1
 */