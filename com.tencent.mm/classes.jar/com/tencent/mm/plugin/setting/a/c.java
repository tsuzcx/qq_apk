package com.tencent.mm.plugin.setting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.model.q;
import com.tencent.mm.protocal.protobuf.fun;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/report/SettingsUserPrivacyReporter;", "", "()V", "TAG", "", "reportUserAppAuthAction", "", "action", "", "userAuthApp", "Lcom/tencent/mm/protocal/protobuf/UserAuthApp;", "Action", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c Pos;
  
  static
  {
    AppMethodBeat.i(298508);
    Pos = new c();
    AppMethodBeat.o(298508);
  }
  
  public static void a(int paramInt, fun paramfun)
  {
    AppMethodBeat.i(298504);
    s.u(paramfun, "userAuthApp");
    h.OAn.b(24370, new Object[] { Integer.valueOf(paramInt), paramfun.appid, paramfun.nSt, String.valueOf(paramfun.apptype), q.H(";", (List)paramfun.abSJ) });
    AppMethodBeat.o(298504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.a.c
 * JD-Core Version:    0.7.0.1
 */