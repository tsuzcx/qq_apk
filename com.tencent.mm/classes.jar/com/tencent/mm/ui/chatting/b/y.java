package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.bm;
import com.tencent.mm.h.a.jd;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.b.b.ae;
import com.tencent.mm.ui.chatting.b.b.t;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.List;

@com.tencent.mm.ui.chatting.b.a.a(cFA=t.class)
public class y
  extends a
  implements t
{
  public final boolean aR(bi parambi)
  {
    if (parambi.aVM())
    {
      am.aM(parambi);
      this.byx.cCW();
      return true;
    }
    return false;
  }
  
  public final void cDC()
  {
    super.cDC();
    jd localjd = new jd();
    localjd.bRx.bRs = 2;
    com.tencent.mm.sdk.b.a.udP.m(localjd);
  }
  
  public final void cEY()
  {
    int i;
    if ((ad.aaU(this.byx.getTalkerUserName())) || (s.hb(this.byx.pSb.field_username))) {
      if ((((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).oS(this.byx.pSb.field_openImAppid) & 0x1000) == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      int j;
      label144:
      String[] arrayOfString;
      if ((!this.byx.pSb.cua()) && (!s.hR(this.byx.getTalkerUserName())) && (!ad.aaR(this.byx.getTalkerUserName())) && (!ad.aaT(this.byx.getTalkerUserName())) && (!ad.hd(this.byx.getTalkerUserName())) && (!this.byx.getTalkerUserName().equals(q.Gj())))
      {
        j = 1;
        if ((j != 0) && (i == 0)) {
          break label212;
        }
        arrayOfString = new String[1];
        arrayOfString[0] = this.byx.vtz.getMMResources().getString(R.l.location_send_poi);
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), null, arrayOfString, null, new y.1(this));
        return;
        i = 0;
        break;
        j = 0;
        break label144;
        label212:
        arrayOfString = new String[2];
        arrayOfString[0] = this.byx.vtz.getMMResources().getString(R.l.location_send_poi);
        arrayOfString[1] = this.byx.vtz.getMMResources().getString(R.l.location_send_share);
      }
      i = 0;
    }
  }
  
  public final void cEZ()
  {
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.report.service.h.nFQ.f(12809, new Object[] { Integer.valueOf(1), "" });
    localIntent.putExtra("map_view_type", 0);
    localIntent.putExtra("map_sender_name", this.byx.cFB());
    localIntent.putExtra("map_talker_name", this.byx.getTalkerUserName());
    com.tencent.mm.br.d.b(this.byx.vtz.getContext(), "location", ".ui.RedirectUI", localIntent);
  }
  
  public final void cFa()
  {
    int i = 1;
    if ((!com.tencent.mm.r.a.bk(this.byx.vtz.getContext())) && (!com.tencent.mm.r.a.bi(this.byx.vtz.getContext())))
    {
      if (((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).It(this.byx.getTalkerUserName()))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
        com.tencent.mm.ui.base.h.h(this.byx.vtz.getContext(), R.l.multitalk_exit_tip, R.l.app_tip);
      }
    }
    else {
      return;
    }
    Object localObject2 = null;
    ru localru = new ru();
    Object localObject1 = localObject2;
    if (com.tencent.mm.bf.g.eEV != null)
    {
      localru.cbq.cbs = true;
      com.tencent.mm.sdk.b.a.udP.m(localru);
      if (!bk.bl(localru.cbr.cbu)) {
        localObject1 = this.byx.vtz.getMMResources().getString(R.l.enter_track_myself_talking_err);
      }
    }
    else
    {
      if (bk.bl((String)localObject1)) {
        break label321;
      }
      if ((com.tencent.mm.bg.d.eEX == null) || (!com.tencent.mm.bg.d.eEX.nA(this.byx.pSb.field_username))) {
        break label343;
      }
      localObject2 = com.tencent.mm.bg.d.eEX.nz(this.byx.pSb.field_username);
      if ((localObject2 == null) || (!((List)localObject2).contains(this.byx.cFB()))) {
        break label343;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new c.a(this.byx.vtz.getContext());
        ((c.a)localObject2).aeA((String)localObject1);
        ((c.a)localObject2).Is(R.l.i_know_it).a(new y.2(this));
        ((c.a)localObject2).aoP().show();
        return;
        localObject1 = localObject2;
        if (!com.tencent.mm.bf.g.eEV.nx(this.byx.getTalkerUserName())) {
          break;
        }
        localObject1 = this.byx.vtz.getMMResources().getString(R.l.enter_track_other_talking_err);
        break;
      }
      label321:
      ((ae)this.byx.ac(ae.class)).adx("fromPluginLocation");
      return;
      label343:
      i = 0;
    }
  }
  
  public final void cyN()
  {
    jd localjd = new jd();
    localjd.bRx.bRs = 0;
    localjd.bRx.auI = x.cqJ();
    if (s.fn(this.byx.pSb.field_username)) {}
    for (localjd.bRx.bRz = true;; localjd.bRx.bRz = false)
    {
      com.tencent.mm.sdk.b.a.udP.m(localjd);
      return;
    }
  }
  
  public final void cyR()
  {
    bm localbm = new bm();
    com.tencent.mm.sdk.b.a.udP.m(localbm);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      if (paramInt == 67)
      {
        cEZ();
        return;
      }
      cFa();
      return;
    }
    com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.permission_location_request_again_msg), this.byx.vtz.getMMResources().getString(R.l.permission_tips_title), this.byx.vtz.getMMResources().getString(R.l.jump_to_settings), this.byx.vtz.getMMResources().getString(R.l.cancel), false, new y.3(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.y
 * JD-Core Version:    0.7.0.1
 */