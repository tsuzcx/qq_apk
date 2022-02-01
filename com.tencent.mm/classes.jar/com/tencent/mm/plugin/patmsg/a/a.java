package com.tencent.mm.plugin.patmsg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
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
  public ebd MHl;
  
  public a()
  {
    AppMethodBeat.i(266355);
    this.MHl = new ebd();
    AppMethodBeat.o(266355);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266366);
    paramString = this.MHl;
    paramb = new StringBuilder();
    paramb.append("<patMsg>");
    paramb.append("<chatUser>").append(Util.nullAs(paramString.ltm, "")).append("</chatUser>");
    paramb.append("<records>");
    paramb.append("<recordNum>").append(paramString.Ksg.size()).append("</recordNum>");
    paramString = paramString.Ksg.iterator();
    while (paramString.hasNext())
    {
      paramd = (ebe)paramString.next();
      paramb.append("<record>");
      paramb.append("<fromUser>").append(Util.nullAs(paramd.hQQ, "")).append("</fromUser>");
      paramb.append("<pattedUser>").append(Util.nullAs(paramd.abgI, "")).append("</pattedUser>");
      paramb.append("<template>").append(XmlParser.getCDataWrapper(paramd.nVS)).append("</template>");
      if ((paramd instanceof g.a)) {
        paramb.append("<templete>").append(XmlParser.getCDataWrapper(((g.a)paramd).agts)).append("</templete>");
      }
      paramb.append("<createTime>").append(paramd.createTime).append("</createTime>");
      paramb.append("<readStatus>").append(paramd.abgJ).append("</readStatus>");
      paramb.append("<svrId>").append(paramd.vaU).append("</svrId>");
      paramb.append("<showModifyTip>").append(paramd.abgK).append("</showModifyTip>");
      paramb.append("<isNewPatMsg>").append(paramd.abgL).append("</isNewPatMsg>");
      paramb.append("</record>");
    }
    paramb.append("</records>");
    paramb.append("</patMsg>");
    paramStringBuilder.append(paramb.toString());
    AppMethodBeat.o(266366);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(266371);
    this.MHl = g.ak(".msg.appmsg", paramMap);
    AppMethodBeat.o(266371);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(266357);
    a locala = new a();
    locala.MHl = this.MHl;
    AppMethodBeat.o(266357);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.a
 * JD-Core Version:    0.7.0.1
 */