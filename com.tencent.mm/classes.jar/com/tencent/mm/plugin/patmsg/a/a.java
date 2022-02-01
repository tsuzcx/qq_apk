package com.tencent.mm.plugin.patmsg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.util.e;
import com.tencent.mm.util.e.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class a
  extends f
{
  public ciz wVs;
  
  public a()
  {
    AppMethodBeat.i(220340);
    this.wVs = new ciz();
    AppMethodBeat.o(220340);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220342);
    paramString = this.wVs;
    paramb = new StringBuilder();
    paramb.append("<patMsg>");
    paramb.append("<chatUser>").append(paramString.fHV).append("</chatUser>");
    paramb.append("<records>");
    paramb.append("<recordNum>").append(paramString.vAC.size()).append("</recordNum>");
    paramString = paramString.vAC.iterator();
    while (paramString.hasNext())
    {
      paramd = (cja)paramString.next();
      paramb.append("<record>");
      paramb.append("<fromUser>").append(paramd.dzZ).append("</fromUser>");
      paramb.append("<pattedUser>").append(paramd.HvD).append("</pattedUser>");
      paramb.append("<template>").append(bx.aSV(paramd.hGT)).append("</template>");
      if ((paramd instanceof e.a)) {
        paramb.append("<templete>").append(bx.aSV(((e.a)paramd).LDn)).append("</templete>");
      }
      paramb.append("<createTime>").append(paramd.createTime).append("</createTime>");
      paramb.append("<readStatus>").append(paramd.HvE).append("</readStatus>");
      paramb.append("<svrId>").append(paramd.nCM).append("</svrId>");
      paramb.append("</record>");
    }
    paramb.append("</records>");
    paramb.append("</patMsg>");
    paramStringBuilder.append(paramb.toString());
    AppMethodBeat.o(220342);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(220343);
    this.wVs = e.R(".msg.appmsg", paramMap);
    AppMethodBeat.o(220343);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(220341);
    a locala = new a();
    locala.wVs = this.wVs;
    AppMethodBeat.o(220341);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.a
 * JD-Core Version:    0.7.0.1
 */