package com.tencent.mm.plugin.patmsg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.util.e;
import com.tencent.mm.util.e.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class a
  extends f
{
  public cif wFH;
  
  public a()
  {
    AppMethodBeat.i(215706);
    this.wFH = new cif();
    AppMethodBeat.o(215706);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215708);
    paramString = this.wFH;
    paramb = new StringBuilder();
    paramb.append("<patMsg>");
    paramb.append("<chatUser>").append(paramString.fFR).append("</chatUser>");
    paramb.append("<records>");
    paramb.append("<recordNum>").append(paramString.vox.size()).append("</recordNum>");
    paramString = paramString.vox.iterator();
    while (paramString.hasNext())
    {
      paramd = (cig)paramString.next();
      paramb.append("<record>");
      paramb.append("<fromUser>").append(paramd.dyU).append("</fromUser>");
      paramb.append("<pattedUser>").append(paramd.Hcd).append("</pattedUser>");
      paramb.append("<template>").append(bw.aRy(paramd.hEb)).append("</template>");
      if ((paramd instanceof e.a)) {
        paramb.append("<templete>").append(bw.aRy(((e.a)paramd).LgL)).append("</templete>");
      }
      paramb.append("<createTime>").append(paramd.createTime).append("</createTime>");
      paramb.append("<readStatus>").append(paramd.Hce).append("</readStatus>");
      paramb.append("<svrId>").append(paramd.nxr).append("</svrId>");
      paramb.append("</record>");
    }
    paramb.append("</records>");
    paramb.append("</patMsg>");
    paramStringBuilder.append(paramb.toString());
    AppMethodBeat.o(215708);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(215709);
    this.wFH = e.Q(".msg.appmsg", paramMap);
    AppMethodBeat.o(215709);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(215707);
    a locala = new a();
    locala.wFH = this.wFH;
    AppMethodBeat.o(215707);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.a
 * JD-Core Version:    0.7.0.1
 */