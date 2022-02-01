package com.tencent.mm.plugin.patmsg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.util.e;
import com.tencent.mm.util.e.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class a
  extends f
{
  public czg ARl;
  
  public a()
  {
    AppMethodBeat.i(206962);
    this.ARl = new czg();
    AppMethodBeat.o(206962);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206964);
    paramString = this.ARl;
    paramb = new StringBuilder();
    paramb.append("<patMsg>");
    paramb.append("<chatUser>").append(paramString.gnh).append("</chatUser>");
    paramb.append("<records>");
    paramb.append("<recordNum>").append(paramString.yVw.size()).append("</recordNum>");
    paramString = paramString.yVw.iterator();
    while (paramString.hasNext())
    {
      paramd = (czh)paramString.next();
      paramb.append("<record>");
      paramb.append("<fromUser>").append(paramd.dRL).append("</fromUser>");
      paramb.append("<pattedUser>").append(paramd.MEA).append("</pattedUser>");
      paramb.append("<template>").append(XmlParser.getCDataWrapper(paramd.iBd)).append("</template>");
      if ((paramd instanceof e.a)) {
        paramb.append("<templete>").append(XmlParser.getCDataWrapper(((e.a)paramd).QYI)).append("</templete>");
      }
      paramb.append("<createTime>").append(paramd.createTime).append("</createTime>");
      paramb.append("<readStatus>").append(paramd.MEB).append("</readStatus>");
      paramb.append("<svrId>").append(paramd.oNJ).append("</svrId>");
      paramb.append("<showModifyTip>").append(paramd.MEC).append("</showModifyTip>");
      paramb.append("</record>");
    }
    paramb.append("</records>");
    paramb.append("</patMsg>");
    paramStringBuilder.append(paramb.toString());
    AppMethodBeat.o(206964);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(206965);
    this.ARl = e.Y(".msg.appmsg", paramMap);
    AppMethodBeat.o(206965);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(206963);
    a locala = new a();
    locala.ARl = this.ARl;
    AppMethodBeat.o(206963);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.a
 * JD-Core Version:    0.7.0.1
 */