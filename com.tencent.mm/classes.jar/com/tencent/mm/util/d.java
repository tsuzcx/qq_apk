package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static cdh aRW(String paramString)
  {
    AppMethodBeat.i(194060);
    cdh localcdh = new cdh();
    Map localMap;
    int i;
    cdi localcdi;
    if (!bs.isNullOrNil(paramString))
    {
      localMap = bv.L(paramString, "patMsg");
      if (localMap != null)
      {
        localcdh.fnJ = bs.nullAsNil((String)localMap.get(".patMsg.chatUser"));
        int j = bs.aLy((String)localMap.get(".patMsg.records.recordNum"));
        i = 0;
        if (i < j)
        {
          localcdi = new cdi();
          if (i <= 0) {
            break label354;
          }
        }
      }
    }
    label354:
    for (paramString = ".patMsg.records.record" + i;; paramString = ".patMsg.records.record")
    {
      localcdi.dng = bs.nullAsNil((String)localMap.get(paramString + ".fromUser"));
      localcdi.FrZ = bs.nullAsNil((String)localMap.get(paramString + ".pattedUser"));
      localcdi.hlO = bs.nullAsNil((String)localMap.get(paramString + ".template"));
      localcdi.createTime = bs.aLz((String)localMap.get(paramString + ".createTime"));
      localcdi.Fsa = bs.aLy((String)localMap.get(paramString + ".readStatus"));
      localcdi.mWU = bs.aLz((String)localMap.get(paramString + ".svrId"));
      localcdh.ulR.add(localcdi);
      i += 1;
      break;
      AppMethodBeat.o(194060);
      return localcdh;
    }
  }
  
  public static String b(cdh paramcdh)
  {
    AppMethodBeat.i(194059);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<patMsg>");
    localStringBuilder.append("<chatUser>").append(paramcdh.fnJ).append("</chatUser>");
    localStringBuilder.append("<records>");
    localStringBuilder.append("<recordNum>").append(paramcdh.ulR.size()).append("</recordNum>");
    paramcdh = paramcdh.ulR.iterator();
    while (paramcdh.hasNext())
    {
      cdi localcdi = (cdi)paramcdh.next();
      localStringBuilder.append("<record>");
      localStringBuilder.append("<fromUser>").append(localcdi.dng).append("</fromUser>");
      localStringBuilder.append("<pattedUser>").append(localcdi.FrZ).append("</pattedUser>");
      localStringBuilder.append("<template>").append(bv.aLR(localcdi.hlO)).append("</template>");
      localStringBuilder.append("<createTime>").append(localcdi.createTime).append("</createTime>");
      localStringBuilder.append("<readStatus>").append(localcdi.Fsa).append("</readStatus>");
      localStringBuilder.append("<svrId>").append(localcdi.mWU).append("</svrId>");
      localStringBuilder.append("</record>");
    }
    localStringBuilder.append("</records>");
    localStringBuilder.append("</patMsg>");
    paramcdh = localStringBuilder.toString();
    AppMethodBeat.o(194059);
    return paramcdh;
  }
  
  public static String cv(bo parambo)
  {
    AppMethodBeat.i(117353);
    if (parambo == null)
    {
      AppMethodBeat.o(117353);
      return "";
    }
    if (parambo.field_isSend == 1) {
      parambo = u.axw();
    }
    for (;;)
    {
      AppMethodBeat.o(117353);
      return parambo;
      String str1 = parambo.field_talker;
      if (w.sQ(str1))
      {
        String str2 = bi.yl(parambo.field_content);
        if ((str1 != null) && (str2 != null))
        {
          parambo = str2;
          if (str2.length() > 0) {
            continue;
          }
        }
      }
      parambo = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.d
 * JD-Core Version:    0.7.0.1
 */