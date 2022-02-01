package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import java.util.Map;

public final class e
{
  public static ciz R(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(213457);
    ciz localciz = new ciz();
    int i;
    cja localcja;
    if (paramMap != null)
    {
      String str = bu.nullAsNil(paramString) + ".patMsg";
      localciz.fHV = bu.nullAsNil((String)paramMap.get(str + ".chatUser"));
      int j = bu.aSB((String)paramMap.get(str + ".records.recordNum"));
      i = 0;
      if (i < j)
      {
        localcja = new cja();
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
      localcja.dzZ = bu.nullAsNil((String)paramMap.get(paramString + ".fromUser"));
      localcja.HvD = bu.nullAsNil((String)paramMap.get(paramString + ".pattedUser"));
      localcja.hGT = bu.nullAsNil((String)paramMap.get(paramString + ".template"));
      if (bu.isNullOrNil(localcja.hGT)) {
        localcja.hGT = bu.nullAsNil((String)paramMap.get(paramString + ".templete"));
      }
      localcja.createTime = bu.aSC((String)paramMap.get(paramString + ".createTime"));
      localcja.HvE = bu.aSB((String)paramMap.get(paramString + ".readStatus"));
      localcja.nCM = bu.aSC((String)paramMap.get(paramString + ".svrId"));
      localciz.vAC.add(localcja);
      i += 1;
      break;
      AppMethodBeat.o(213457);
      return localciz;
    }
  }
  
  public static ciz aZx(String paramString)
  {
    AppMethodBeat.i(213456);
    ciz localciz = new ciz();
    if (!bu.isNullOrNil(paramString))
    {
      if (!paramString.contains("appmsg"))
      {
        paramString = R("", bx.M(paramString, "patMsg"));
        AppMethodBeat.o(213456);
        return paramString;
      }
      paramString = R(".msg.appmsg", bx.M(paramString, "msg"));
      AppMethodBeat.o(213456);
      return paramString;
    }
    AppMethodBeat.o(213456);
    return localciz;
  }
  
  public static String cA(bv parambv)
  {
    AppMethodBeat.i(117353);
    if (parambv == null)
    {
      AppMethodBeat.o(117353);
      return "";
    }
    if (parambv.field_isSend == 1) {
      parambv = v.aAC();
    }
    for (;;)
    {
      AppMethodBeat.o(117353);
      return parambv;
      String str1 = parambv.field_talker;
      if (x.wb(str1))
      {
        String str2 = bl.BM(parambv.field_content);
        if ((str1 != null) && (str2 != null))
        {
          parambv = str2;
          if (str2.length() > 0) {
            continue;
          }
        }
      }
      parambv = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.e
 * JD-Core Version:    0.7.0.1
 */