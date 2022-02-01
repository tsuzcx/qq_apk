package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static byl aMu(String paramString)
  {
    AppMethodBeat.i(186497);
    byl localbyl = new byl();
    Map localMap;
    int i;
    bym localbym;
    if (!bt.isNullOrNil(paramString))
    {
      localMap = bw.K(paramString, "patMsg");
      if (localMap != null)
      {
        localbyl.fkp = bt.nullAsNil((String)localMap.get(".patMsg.chatUser"));
        int j = bt.aGh((String)localMap.get(".patMsg.records.recordNum"));
        i = 0;
        if (i < j)
        {
          localbym = new bym();
          if (i <= 0) {
            break label354;
          }
        }
      }
    }
    label354:
    for (paramString = ".patMsg.records.record" + i;; paramString = ".patMsg.records.record")
    {
      localbym.dpv = bt.nullAsNil((String)localMap.get(paramString + ".fromUser"));
      localbym.DVl = bt.nullAsNil((String)localMap.get(paramString + ".pattedUser"));
      localbym.gLo = bt.nullAsNil((String)localMap.get(paramString + ".template"));
      localbym.createTime = bt.aGi((String)localMap.get(paramString + ".createTime"));
      localbym.DVm = bt.aGh((String)localMap.get(paramString + ".readStatus"));
      localbym.muT = bt.aGi((String)localMap.get(paramString + ".svrId"));
      localbyl.tdC.add(localbym);
      i += 1;
      break;
      AppMethodBeat.o(186497);
      return localbyl;
    }
  }
  
  public static String b(byl parambyl)
  {
    AppMethodBeat.i(186496);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<patMsg>");
    localStringBuilder.append("<chatUser>").append(parambyl.fkp).append("</chatUser>");
    localStringBuilder.append("<records>");
    localStringBuilder.append("<recordNum>").append(parambyl.tdC.size()).append("</recordNum>");
    parambyl = parambyl.tdC.iterator();
    while (parambyl.hasNext())
    {
      bym localbym = (bym)parambyl.next();
      localStringBuilder.append("<record>");
      localStringBuilder.append("<fromUser>").append(localbym.dpv).append("</fromUser>");
      localStringBuilder.append("<pattedUser>").append(localbym.DVl).append("</pattedUser>");
      localStringBuilder.append("<template>").append(bw.aGA(localbym.gLo)).append("</template>");
      localStringBuilder.append("<createTime>").append(localbym.createTime).append("</createTime>");
      localStringBuilder.append("<readStatus>").append(localbym.DVm).append("</readStatus>");
      localStringBuilder.append("<svrId>").append(localbym.muT).append("</svrId>");
      localStringBuilder.append("</record>");
    }
    localStringBuilder.append("</records>");
    localStringBuilder.append("</patMsg>");
    parambyl = localStringBuilder.toString();
    AppMethodBeat.o(186496);
    return parambyl;
  }
  
  public static String cs(bl parambl)
  {
    AppMethodBeat.i(117353);
    if (parambl == null)
    {
      AppMethodBeat.o(117353);
      return "";
    }
    if (parambl.field_isSend == 1) {
      parambl = u.aqG();
    }
    for (;;)
    {
      AppMethodBeat.o(117353);
      return parambl;
      String str1 = parambl.field_talker;
      if (w.pF(str1))
      {
        String str2 = bi.uf(parambl.field_content);
        if ((str1 != null) && (str2 != null))
        {
          parambl = str2;
          if (str2.length() > 0) {
            continue;
          }
        }
      }
      parambl = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.d
 * JD-Core Version:    0.7.0.1
 */