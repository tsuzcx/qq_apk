package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class m$13
  implements bx.a
{
  m$13(m paramm) {}
  
  public final void a(e.a parama)
  {
    m.bAb();
    if (m.bzY() != null)
    {
      m.bAb();
      m.bzY();
      Object localObject = aa.a(parama.dBs.svH);
      y.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:" + (String)localObject);
      if (bk.bl((String)localObject))
      {
        y.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
        return;
      }
      localObject = bn.s((String)localObject, "sysmsg");
      int i = bk.getInt((String)((Map)localObject).get(".sysmsg.shake.$type"), 0);
      switch (i)
      {
      default: 
        y.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :" + i);
        return;
      }
      f localf = new f();
      i = bk.getInt((String)((Map)localObject).get(".sysmsg.shake.shaketv.msgtype"), 0);
      if (i == 0)
      {
        localf.field_type = 1;
        localf.field_subtype = i;
        localf.field_svrid = parama.dBs.ndp;
        localf.field_createtime = bk.UX();
        localf.field_tag = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.jumpurl"));
        localf.field_status = 0;
        localf.field_title = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.title"));
        localf.field_thumburl = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.iconurl"));
        localf.field_desc = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.desc"));
        localf.field_reserved1 = bk.pm((String)((Map)localObject).get(".sysmsg.shake.shaketv.pid"));
        m.bzV().a(localf);
        return;
      }
      y.w("MicroMsg.ShakeMsgMgr", "Unknown subType:" + i);
      return;
    }
    y.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m.13
 * JD-Core Version:    0.7.0.1
 */