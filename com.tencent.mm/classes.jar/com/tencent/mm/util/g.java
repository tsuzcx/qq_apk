package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class g
{
  public static dit ab(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(240454);
    dit localdit = new dit();
    int i;
    diu localdiu;
    if (paramMap != null)
    {
      String str = Util.nullAsNil(paramString) + ".patMsg";
      localdit.iRq = Util.nullAsNil((String)paramMap.get(str + ".chatUser"));
      int j = Util.safeParseInt((String)paramMap.get(str + ".records.recordNum"));
      i = 0;
      if (i < j)
      {
        localdiu = new diu();
        paramString = str + ".records.record";
        if (i <= 0) {
          break label497;
        }
        paramString = paramString + i;
      }
    }
    label497:
    for (;;)
    {
      localdiu.fLi = Util.nullAsNil((String)paramMap.get(paramString + ".fromUser"));
      localdiu.TQk = Util.nullAsNil((String)paramMap.get(paramString + ".pattedUser"));
      localdiu.lqH = Util.nullAsNil((String)paramMap.get(paramString + ".template"));
      if (Util.isNullOrNil(localdiu.lqH)) {
        localdiu.lqH = Util.nullAsNil((String)paramMap.get(paramString + ".templete"));
      }
      localdiu.createTime = Util.safeParseLong((String)paramMap.get(paramString + ".createTime"));
      localdiu.TQl = Util.safeParseInt((String)paramMap.get(paramString + ".readStatus"));
      localdiu.rPF = Util.safeParseLong((String)paramMap.get(paramString + ".svrId"));
      localdiu.TQm = Util.safeParseInt((String)paramMap.get(paramString + ".showModifyTip"));
      localdit.Ezu.add(localdiu);
      i += 1;
      break;
      AppMethodBeat.o(240454);
      return localdit;
    }
  }
  
  public static dit bBr(String paramString)
  {
    AppMethodBeat.i(240447);
    dit localdit = new dit();
    if (!Util.isNullOrNil(paramString))
    {
      if (!paramString.contains("appmsg"))
      {
        paramString = ab("", XmlParser.parseXml(paramString, "patMsg", null));
        AppMethodBeat.o(240447);
        return paramString;
      }
      paramString = ab(".msg.appmsg", XmlParser.parseXml(paramString, "msg", null));
      AppMethodBeat.o(240447);
      return paramString;
    }
    AppMethodBeat.o(240447);
    return localdit;
  }
  
  public static String c(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(240441);
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MsgUtil", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((Util.isNullOrNil(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break;
      }
      Log.w("MicroMsg.MsgUtil", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
      AppMethodBeat.o(240441);
      return paramString;
    }
    if (((paramInt & 0x1) != 0) && ((paramObject instanceof HashMap)))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (Util.isNullOrNil(paramString)) {
        localStringBuffer.append("<msgsource>");
      }
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      while (paramObject.hasNext())
      {
        Object localObject = (Map.Entry)paramObject.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject)))
        {
          Log.w("MicroMsg.MsgUtil", "%s %s", new Object[] { localObject, str });
        }
        else
        {
          localStringBuffer.append("<").append((String)localObject).append(">");
          localStringBuffer.append(str);
          localStringBuffer.append("</").append((String)localObject).append(">");
        }
      }
      if (Util.isNullOrNil(paramString))
      {
        localStringBuffer.append("</msgsource>");
        paramString = localStringBuffer.toString();
        AppMethodBeat.o(240441);
        return paramString;
      }
      paramString = paramString.replace("<msgsource>", "<msgsource>" + localStringBuffer.toString());
      AppMethodBeat.o(240441);
      return paramString;
    }
    AppMethodBeat.o(240441);
    return paramString;
  }
  
  public static String dn(ca paramca)
  {
    AppMethodBeat.i(117353);
    if (paramca == null)
    {
      AppMethodBeat.o(117353);
      return "";
    }
    if (paramca.field_isSend == 1) {
      paramca = z.bcZ();
    }
    for (;;)
    {
      AppMethodBeat.o(117353);
      return paramca;
      String str1 = paramca.field_talker;
      if (ab.Lj(str1))
      {
        String str2 = bq.RL(paramca.field_content);
        if ((str1 != null) && (str2 != null))
        {
          paramca = str2;
          if (str2.length() > 0) {
            continue;
          }
        }
      }
      paramca = str1;
    }
  }
  
  public static String jdMethod_do(ca paramca)
  {
    AppMethodBeat.i(240439);
    if (paramca == null)
    {
      AppMethodBeat.o(240439);
      return "";
    }
    String str2 = paramca.field_content;
    if (str2 == null)
    {
      AppMethodBeat.o(240439);
      return "";
    }
    if (dp(paramca))
    {
      str1 = str2;
      if (ab.Lj(paramca.field_talker))
      {
        str1 = str2;
        if (paramca.field_isSend != 1)
        {
          i = bq.RI(str2);
          str1 = str2;
          if (i != -1) {
            str1 = str2.substring(i + 1);
          }
        }
      }
      AppMethodBeat.o(240439);
      return str1;
    }
    String str1 = str2;
    if (ab.Lj(paramca.field_talker))
    {
      str1 = str2;
      if (paramca.field_isSend != 1)
      {
        i = bq.RI(str2);
        str1 = str2;
        if (i != -1) {
          str1 = str2.substring(i + 1);
        }
      }
    }
    int i = str1.indexOf('<');
    paramca = str1;
    if (i > 0) {
      paramca = str1.substring(i);
    }
    AppMethodBeat.o(240439);
    return paramca;
  }
  
  private static boolean dp(ca paramca)
  {
    boolean bool = false;
    AppMethodBeat.i(240459);
    if (paramca == null)
    {
      AppMethodBeat.o(240459);
      return false;
    }
    switch (paramca.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(240459);
      return bool;
      bool = true;
    }
  }
  
  public static final class a
    extends diu
  {
    public String YyU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.util.g
 * JD-Core Version:    0.7.0.1
 */