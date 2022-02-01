package com.tencent.mm.plugin.patmsg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.util.g;
import com.tencent.mm.util.g.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class a
  extends f
{
  public dit GKw;
  
  public a()
  {
    AppMethodBeat.i(186669);
    this.GKw = new dit();
    AppMethodBeat.o(186669);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186677);
    paramString = this.GKw;
    paramb = new StringBuilder();
    paramb.append("<patMsg>");
    paramb.append("<chatUser>").append(Util.nullAs(paramString.iRq, "")).append("</chatUser>");
    paramb.append("<records>");
    paramb.append("<recordNum>").append(paramString.Ezu.size()).append("</recordNum>");
    paramString = paramString.Ezu.iterator();
    while (paramString.hasNext())
    {
      paramd = (diu)paramString.next();
      paramb.append("<record>");
      paramb.append("<fromUser>").append(Util.nullAs(paramd.fLi, "")).append("</fromUser>");
      paramb.append("<pattedUser>").append(Util.nullAs(paramd.TQk, "")).append("</pattedUser>");
      paramb.append("<template>").append(XmlParser.getCDataWrapper(paramd.lqH)).append("</template>");
      if ((paramd instanceof g.a)) {
        paramb.append("<templete>").append(XmlParser.getCDataWrapper(((g.a)paramd).YyU)).append("</templete>");
      }
      paramb.append("<createTime>").append(paramd.createTime).append("</createTime>");
      paramb.append("<readStatus>").append(paramd.TQl).append("</readStatus>");
      paramb.append("<svrId>").append(paramd.rPF).append("</svrId>");
      paramb.append("<showModifyTip>").append(paramd.TQm).append("</showModifyTip>");
      paramb.append("</record>");
    }
    paramb.append("</records>");
    paramb.append("</patMsg>");
    paramStringBuilder.append(paramb.toString());
    AppMethodBeat.o(186677);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(186680);
    this.GKw = g.ab(".msg.appmsg", paramMap);
    AppMethodBeat.o(186680);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(186675);
    a locala = new a();
    locala.GKw = this.GKw;
    AppMethodBeat.o(186675);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.a
 * JD-Core Version:    0.7.0.1
 */