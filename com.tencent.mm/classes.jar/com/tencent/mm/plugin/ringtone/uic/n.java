package com.tencent.mm.plugin.ringtone.uic;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.h.a;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneSettingKVReportUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "reportSessionId", "", "getReportSessionId", "()J", "setReportSessionId", "(J)V", "doReportProfilePageClickDelete", "", "desc", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "username", "", "canVibrate", "", "doReportProfilePageClickPlay", "isVibrate", "doReportProfilePageClickReplace", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends UIComponent
{
  public static final n.a OFP;
  
  static
  {
    AppMethodBeat.i(273357);
    OFP = new n.a((byte)0);
    AppMethodBeat.o(273357);
  }
  
  public n(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273313);
    AppMethodBeat.o(273313);
  }
  
  public static void a(com.tencent.mm.plugin.ringtone.g.d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(273320);
    s.u(paramd, "desc");
    int i;
    if (paramd.ODC != 0)
    {
      paramd = String.valueOf(paramd.ODC);
      i = 1;
    }
    for (;;)
    {
      a.e(paramd, i, paramString, paramBoolean);
      AppMethodBeat.o(273320);
      return;
      if (paramd.mIH != 0L)
      {
        paramd = com.tencent.mm.ae.d.hF(paramd.mIH);
        i = 2;
      }
      else
      {
        paramd = "0";
        i = 3;
      }
    }
  }
  
  public static void b(com.tencent.mm.plugin.ringtone.g.d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(273328);
    s.u(paramd, "desc");
    int i;
    if (paramd.mIH != 0L)
    {
      i = 2;
      switch (i)
      {
      }
    }
    for (String str = com.tencent.mm.ae.d.hF(paramd.mIH);; str = String.valueOf(paramd.ODC))
    {
      a.a(2L, str, i, paramString, paramd.OBU, paramBoolean);
      AppMethodBeat.o(273328);
      return;
      if (paramd.ODC != 0)
      {
        i = 1;
        break;
      }
      AppMethodBeat.o(273328);
      return;
    }
  }
  
  public static void c(com.tencent.mm.plugin.ringtone.g.d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(273341);
    if (paramd == null)
    {
      AppMethodBeat.o(273341);
      return;
    }
    int i;
    if (paramd.mIH != 0L)
    {
      i = 2;
      switch (i)
      {
      }
    }
    for (String str = com.tencent.mm.ae.d.hF(paramd.mIH);; str = String.valueOf(paramd.ODC))
    {
      a.a(3L, str, i, paramString, paramd.OBU, paramBoolean);
      AppMethodBeat.o(273341);
      return;
      if (paramd.ODC != 0)
      {
        i = 1;
        break;
      }
      AppMethodBeat.o(273341);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.n
 * JD-Core Version:    0.7.0.1
 */