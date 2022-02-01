package com.tencent.mm.plugin.ringtone.l;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acm;
import com.tencent.mm.autogen.a.acm.a;
import com.tencent.mm.autogen.a.ns;
import com.tencent.mm.autogen.a.ns.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/utils/FloatWindowHelper;", "", "()V", "FLOAT_RULE_ALLOW", "", "FLOAT_RULE_FORBIDDEN", "FLOAT_RULE_RESUME", "TAG", "", "isRemoveMusic", "", "doAfterRingtonePlay", "", "doCheckCurrentCanPlay", "doCheckCurrentInLive", "doCheckCurrentInMusic", "doCheckCurrentInVoIP", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a OFQ;
  private static boolean OFR;
  
  static
  {
    AppMethodBeat.i(273002);
    OFQ = new a();
    AppMethodBeat.o(273002);
  }
  
  public static int gPc()
  {
    AppMethodBeat.i(272987);
    Object localObject = new acm();
    ((acm)localObject).publish();
    if ((((acm)localObject).ifS.hzJ) || (((acm)localObject).ifS.hzK)) {
      if (((acm)localObject).ifS.ifT)
      {
        i = b.f.voipvideo_in_calling_while_click_ringtone;
        Toast.makeText(MMApplicationContext.getContext(), i, 0).show();
        Log.i("MicroMsg.FloatWindowHelper", "voip is running, can't do this");
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label126;
      }
      AppMethodBeat.o(272987);
      return 0;
      i = b.f.voipvoice_in_calling_while_click_ringtone;
      break;
      if (com.tencent.mm.n.a.aTe())
      {
        Toast.makeText(MMApplicationContext.getContext(), b.f.voipvoice_in_calling_while_click_ringtone, 0).show();
        Log.i("MicroMsg.FloatWindowHelper", "voip is running, can't do this");
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    label126:
    Context localContext;
    if (!com.tencent.mm.n.a.q(MMApplicationContext.getContext(), true))
    {
      localContext = MMApplicationContext.getContext();
      localObject = new ns();
      ((ns)localObject).publish();
      Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(((ns)localObject).hQh.isStart), Boolean.valueOf(((ns)localObject).hQh.hKC) });
      boolean bool = ((ns)localObject).hQh.isStart;
      if (bool)
      {
        if (!((ns)localObject).hQh.hKC) {
          break label246;
        }
        localObject = localContext.getString(c.h.finder_live_open_new_tip_anchor_busy);
        aa.makeText(localContext, (CharSequence)localObject, 0).show();
      }
      if (!bool) {
        break label257;
      }
    }
    label257:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label262;
      }
      AppMethodBeat.o(272987);
      return 2;
      label246:
      localObject = localContext.getString(c.h.finder_live_open_new_tip_visitor_busy);
      break;
    }
    label262:
    if (((com.tencent.mm.aw.a.a)h.ax(com.tencent.mm.aw.a.a.class)).bLw())
    {
      com.tencent.mm.aw.a.bLg();
      ((com.tencent.mm.aw.a.a)h.ax(com.tencent.mm.aw.a.a.class)).hj(false);
      OFR = true;
    }
    AppMethodBeat.o(272987);
    return 1;
  }
  
  public static void gPd()
  {
    AppMethodBeat.i(272996);
    if (OFR)
    {
      com.tencent.mm.aw.a.bLh();
      ((com.tencent.mm.aw.a.a)h.ax(com.tencent.mm.aw.a.a.class)).bLv();
    }
    OFR = false;
    AppMethodBeat.o(272996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.l.a
 * JD-Core Version:    0.7.0.1
 */