package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;
import java.util.Map;

public final class e
{
  public static cif Q(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(192581);
    cif localcif = new cif();
    int i;
    cig localcig;
    if (paramMap != null)
    {
      String str = bt.nullAsNil(paramString) + ".patMsg";
      localcif.fFR = bt.nullAsNil((String)paramMap.get(str + ".chatUser"));
      int j = bt.aRe((String)paramMap.get(str + ".records.recordNum"));
      i = 0;
      if (i < j)
      {
        localcig = new cig();
        paramString = str + ".records.record";
        if (i <= 0) {
          break label461;
        }
        paramString = paramString + i;
      }
    }
    label461:
    for (;;)
    {
      localcig.dyU = bt.nullAsNil((String)paramMap.get(paramString + ".fromUser"));
      localcig.Hcd = bt.nullAsNil((String)paramMap.get(paramString + ".pattedUser"));
      localcig.hEb = bt.nullAsNil((String)paramMap.get(paramString + ".template"));
      if (bt.isNullOrNil(localcig.hEb)) {
        localcig.hEb = bt.nullAsNil((String)paramMap.get(paramString + ".templete"));
      }
      localcig.createTime = bt.aRf((String)paramMap.get(paramString + ".createTime"));
      localcig.Hce = bt.aRe((String)paramMap.get(paramString + ".readStatus"));
      localcig.nxr = bt.aRf((String)paramMap.get(paramString + ".svrId"));
      localcif.vox.add(localcig);
      i += 1;
      break;
      AppMethodBeat.o(192581);
      return localcif;
    }
  }
  
  public static cif aXV(String paramString)
  {
    AppMethodBeat.i(192580);
    cif localcif = new cif();
    if (!bt.isNullOrNil(paramString))
    {
      if (!paramString.contains("appmsg"))
      {
        paramString = Q("", bw.M(paramString, "patMsg"));
        AppMethodBeat.o(192580);
        return paramString;
      }
      paramString = Q(".msg.appmsg", bw.M(paramString, "msg"));
      AppMethodBeat.o(192580);
      return paramString;
    }
    AppMethodBeat.o(192580);
    return localcif;
  }
  
  public static String cB(bu parambu)
  {
    AppMethodBeat.i(117353);
    if (parambu == null)
    {
      AppMethodBeat.o(117353);
      return "";
    }
    if (parambu.field_isSend == 1) {
      parambu = u.aAm();
    }
    for (;;)
    {
      AppMethodBeat.o(117353);
      return parambu;
      String str1 = parambu.field_talker;
      if (w.vF(str1))
      {
        String str2 = bj.Bk(parambu.field_content);
        if ((str1 != null) && (str2 != null))
        {
          parambu = str2;
          if (str2.length() > 0) {
            continue;
          }
        }
      }
      parambu = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.e
 * JD-Core Version:    0.7.0.1
 */