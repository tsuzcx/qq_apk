package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.cc;
import com.tencent.mm.f.a.mp;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=ad.class)
public class al
  extends a
  implements ad
{
  public final boolean co(ca paramca)
  {
    AppMethodBeat.i(35467);
    if (paramca.erm())
    {
      ak.cf(paramca);
      this.fgR.Gi(true);
      AppMethodBeat.o(35467);
      return true;
    }
    AppMethodBeat.o(35467);
    return false;
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35473);
    mp localmp = new mp();
    localmp.fKL.fKG = 0;
    localmp.fKL.language = LocaleUtil.getApplicationLanguage();
    if (ab.Lj(this.fgR.NKq.field_username)) {}
    for (localmp.fKL.fKN = true;; localmp.fKL.fKN = false)
    {
      EventCenter.instance.publish(localmp);
      AppMethodBeat.o(35473);
      return;
    }
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35474);
    cc localcc = new cc();
    EventCenter.instance.publish(localcc);
    AppMethodBeat.o(35474);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35472);
    super.hNZ();
    mp localmp = new mp();
    localmp.fKL.fKG = 2;
    EventCenter.instance.publish(localmp);
    AppMethodBeat.o(35472);
  }
  
  public final void hQf()
  {
    AppMethodBeat.i(35468);
    boolean bool1;
    if ((as.bvK(this.fgR.getTalkerUserName())) || (ab.PQ(this.fgR.NKq.field_username))) {
      if ((((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).ZB(this.fgR.NKq.field_openImAppid) & 0x1000) == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((ab.PT(this.fgR.NKq.field_username)) && ((z.bdV() & 0x8) != 0)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        e locale = new e(this.fgR.WQv.getContext(), 1, false);
        locale.ODT = new al.1(this, bool2, bool1);
        locale.ODU = new al.2(this);
        locale.eik();
        AppMethodBeat.o(35468);
        return;
        bool1 = false;
        break;
      }
      bool1 = false;
    }
  }
  
  public final void hQg()
  {
    AppMethodBeat.i(35469);
    com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(1), "" });
    Intent localIntent = new Intent();
    if (this.fgR.hRi()) {
      localIntent.putExtra("type_tag", 2);
    }
    for (;;)
    {
      localIntent.putExtra("map_view_type", 0);
      localIntent.putExtra("map_sender_name", this.fgR.getSelfUserName());
      localIntent.putExtra("map_talker_name", this.fgR.getTalkerUserName());
      c.b(this.fgR.WQv.getContext(), "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(35469);
      return;
      localIntent.putExtra("type_tag", 1);
    }
  }
  
  public final void hQh()
  {
    AppMethodBeat.i(35470);
    if ((!com.tencent.mm.q.a.cy(this.fgR.WQv.getContext())) && (!com.tencent.mm.q.a.cw(this.fgR.WQv.getContext())) && (!com.tencent.mm.q.a.cB(this.fgR.WQv.getContext())))
    {
      if (((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPT(this.fgR.getTalkerUserName()))
      {
        Log.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
        com.tencent.mm.ui.base.h.p(this.fgR.WQv.getContext(), R.l.multitalk_exit_tip, R.l.app_tip);
        AppMethodBeat.o(35470);
        return;
      }
      if (!Util.isNullOrNil(null))
      {
        int j = 0;
        int i = j;
        Object localObject;
        if (com.tencent.mm.bk.d.meV != null)
        {
          i = j;
          if (com.tencent.mm.bk.d.meV.Xw(this.fgR.NKq.field_username))
          {
            localObject = com.tencent.mm.bk.d.meV.Xv(this.fgR.NKq.field_username);
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((List)localObject).contains(this.fgR.getSelfUserName())) {
                i = 1;
              }
            }
          }
        }
        if (i == 0)
        {
          localObject = new d.a(this.fgR.WQv.getContext());
          ((d.a)localObject).bBd(null);
          ((d.a)localObject).ayj(R.l.i_know_it).c(new al.3(this));
          ((d.a)localObject).icu().show();
          AppMethodBeat.o(35470);
          return;
        }
      }
      ((at)this.fgR.bC(at.class)).bzq("fromPluginLocation");
    }
    AppMethodBeat.o(35470);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(35471);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35471);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        if (paramInt == 67)
        {
          hQg();
          AppMethodBeat.o(35471);
          return;
        }
        hQh();
        AppMethodBeat.o(35471);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.permission_location_request_again_msg), this.fgR.WQv.getMMResources().getString(R.l.permission_tips_title), this.fgR.WQv.getMMResources().getString(R.l.jump_to_settings), this.fgR.WQv.getMMResources().getString(R.l.cancel), false, new al.4(this), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.al
 * JD-Core Version:    0.7.0.1
 */