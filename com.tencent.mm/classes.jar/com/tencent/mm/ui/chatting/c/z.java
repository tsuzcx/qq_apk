package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.u;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=u.class)
public class z
  extends a
  implements u
{
  public final boolean bc(bi parambi)
  {
    AppMethodBeat.i(31572);
    if (parambi.bCp())
    {
      aj.aW(parambi);
      this.caz.qT(true);
      AppMethodBeat.o(31572);
      return true;
    }
    AppMethodBeat.o(31572);
    return false;
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31578);
    jm localjm = new jm();
    localjm.cyZ.cyU = 0;
    localjm.cyZ.axa = aa.dsG();
    if (t.lA(this.caz.txj.field_username)) {}
    for (localjm.cyZ.czb = true;; localjm.cyZ.czb = false)
    {
      com.tencent.mm.sdk.b.a.ymk.l(localjm);
      AppMethodBeat.o(31578);
      return;
    }
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31579);
    com.tencent.mm.g.a.bo localbo = new com.tencent.mm.g.a.bo();
    com.tencent.mm.sdk.b.a.ymk.l(localbo);
    AppMethodBeat.o(31579);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31577);
    super.dHq();
    jm localjm = new jm();
    localjm.cyZ.cyU = 2;
    com.tencent.mm.sdk.b.a.ymk.l(localjm);
    AppMethodBeat.o(31577);
  }
  
  public final void dIQ()
  {
    AppMethodBeat.i(31573);
    int i;
    if ((ad.arf(this.caz.getTalkerUserName())) || (t.nK(this.caz.txj.field_username))) {
      if ((((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).wk(this.caz.txj.field_openImAppid) & 0x1000) == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      int j;
      label150:
      String[] arrayOfString;
      if ((!this.caz.txj.dwz()) && (!t.oA(this.caz.getTalkerUserName())) && (!ad.arc(this.caz.getTalkerUserName())) && (!ad.are(this.caz.getTalkerUserName())) && (!ad.nM(this.caz.getTalkerUserName())) && (!this.caz.getTalkerUserName().equals(r.Zn())))
      {
        j = 1;
        if ((j != 0) && (i == 0)) {
          break label223;
        }
        arrayOfString = new String[1];
        arrayOfString[0] = this.caz.zJz.getMMResources().getString(2131301108);
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), null, arrayOfString, null, new z.1(this));
        AppMethodBeat.o(31573);
        return;
        i = 0;
        break;
        j = 0;
        break label150;
        label223:
        arrayOfString = new String[2];
        arrayOfString[0] = this.caz.zJz.getMMResources().getString(2131301108);
        arrayOfString[1] = this.caz.zJz.getMMResources().getString(2131301109);
      }
      i = 0;
    }
  }
  
  public final void dIR()
  {
    AppMethodBeat.i(31574);
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.report.service.h.qsU.e(12809, new Object[] { Integer.valueOf(1), "" });
    localIntent.putExtra("map_view_type", 0);
    localIntent.putExtra("map_sender_name", this.caz.dJD());
    localIntent.putExtra("map_talker_name", this.caz.getTalkerUserName());
    com.tencent.mm.bq.d.b(this.caz.zJz.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(31574);
  }
  
  public final void dIS()
  {
    int i = 1;
    AppMethodBeat.i(31575);
    Object localObject2;
    Object localObject1;
    if ((!com.tencent.mm.r.a.bO(this.caz.zJz.getContext())) && (!com.tencent.mm.r.a.bM(this.caz.zJz.getContext())))
    {
      if (((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Ui(this.caz.getTalkerUserName()))
      {
        ab.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
        com.tencent.mm.ui.base.h.h(this.caz.zJz.getContext(), 2131301676, 2131297087);
        AppMethodBeat.o(31575);
        return;
      }
      localObject2 = null;
      tl localtl = new tl();
      localObject1 = localObject2;
      if (com.tencent.mm.bg.g.fUM != null)
      {
        localtl.cJT.cJV = true;
        com.tencent.mm.sdk.b.a.ymk.l(localtl);
        if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(localtl.cJU.cJX)) {
          localObject1 = this.caz.zJz.getMMResources().getString(2131299298);
        }
      }
      else
      {
        if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil((String)localObject1)) {
          break label341;
        }
        if ((com.tencent.mm.bh.d.fUO == null) || (!com.tencent.mm.bh.d.fUO.uO(this.caz.txj.field_username))) {
          break label369;
        }
        localObject2 = com.tencent.mm.bh.d.fUO.uN(this.caz.txj.field_username);
        if ((localObject2 == null) || (!((List)localObject2).contains(this.caz.dJD()))) {
          break label369;
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new c.a(this.caz.zJz.getContext());
        ((c.a)localObject2).avn((String)localObject1);
        ((c.a)localObject2).Ri(2131300718).a(new z.2(this));
        ((c.a)localObject2).aLZ().show();
        AppMethodBeat.o(31575);
        return;
        localObject1 = localObject2;
        if (!com.tencent.mm.bg.g.fUM.uL(this.caz.getTalkerUserName())) {
          break;
        }
        localObject1 = this.caz.zJz.getMMResources().getString(2131299299);
        break;
      }
      label341:
      ((af)this.caz.ay(af.class)).atZ("fromPluginLocation");
      AppMethodBeat.o(31575);
      return;
      label369:
      i = 0;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(31576);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31576);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        if (paramInt == 67)
        {
          dIR();
          AppMethodBeat.o(31576);
          return;
        }
        dIS();
        AppMethodBeat.o(31576);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302073), this.caz.zJz.getMMResources().getString(2131302083), this.caz.zJz.getMMResources().getString(2131300996), this.caz.zJz.getMMResources().getString(2131297837), false, new z.3(this), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.z
 * JD-Core Version:    0.7.0.1
 */