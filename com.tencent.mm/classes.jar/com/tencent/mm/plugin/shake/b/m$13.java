package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class m$13
  implements bz.a
{
  m$13(m paramm) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(24489);
    m.clu();
    if (m.clr() != null)
    {
      m.clu();
      m.clr();
      Object localObject = aa.a(parama.eyJ.woR);
      ab.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(localObject)));
      if (bo.isNullOrNil((String)localObject))
      {
        ab.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
        AppMethodBeat.o(24489);
        return;
      }
      localObject = br.F((String)localObject, "sysmsg");
      int i = bo.getInt((String)((Map)localObject).get(".sysmsg.shake.$type"), 0);
      switch (i)
      {
      default: 
        ab.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :".concat(String.valueOf(i)));
        AppMethodBeat.o(24489);
        return;
      }
      f localf = new f();
      i = bo.getInt((String)((Map)localObject).get(".sysmsg.shake.shaketv.msgtype"), 0);
      if (i == 0)
      {
        localf.field_type = 1;
        localf.field_subtype = i;
        localf.field_svrid = parama.eyJ.pIG;
        localf.field_createtime = bo.aox();
        localf.field_tag = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.jumpurl"));
        localf.field_status = 0;
        localf.field_title = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.title"));
        localf.field_thumburl = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.iconurl"));
        localf.field_desc = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.desc"));
        localf.field_reserved1 = bo.nullAsNil((String)((Map)localObject).get(".sysmsg.shake.shaketv.pid"));
        m.clo().a(localf);
        AppMethodBeat.o(24489);
        return;
      }
      ab.w("MicroMsg.ShakeMsgMgr", "Unknown subType:".concat(String.valueOf(i)));
      AppMethodBeat.o(24489);
      return;
    }
    ab.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
    AppMethodBeat.o(24489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m.13
 * JD-Core Version:    0.7.0.1
 */