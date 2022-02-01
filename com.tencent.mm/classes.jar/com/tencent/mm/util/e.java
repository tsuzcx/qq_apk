package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
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

public final class e
{
  public static czg Y(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(226001);
    czg localczg = new czg();
    int i;
    czh localczh;
    if (paramMap != null)
    {
      String str = Util.nullAsNil(paramString) + ".patMsg";
      localczg.gnh = Util.nullAsNil((String)paramMap.get(str + ".chatUser"));
      int j = Util.safeParseInt((String)paramMap.get(str + ".records.recordNum"));
      i = 0;
      if (i < j)
      {
        localczh = new czh();
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
      localczh.dRL = Util.nullAsNil((String)paramMap.get(paramString + ".fromUser"));
      localczh.MEA = Util.nullAsNil((String)paramMap.get(paramString + ".pattedUser"));
      localczh.iBd = Util.nullAsNil((String)paramMap.get(paramString + ".template"));
      if (Util.isNullOrNil(localczh.iBd)) {
        localczh.iBd = Util.nullAsNil((String)paramMap.get(paramString + ".templete"));
      }
      localczh.createTime = Util.safeParseLong((String)paramMap.get(paramString + ".createTime"));
      localczh.MEB = Util.safeParseInt((String)paramMap.get(paramString + ".readStatus"));
      localczh.oNJ = Util.safeParseLong((String)paramMap.get(paramString + ".svrId"));
      localczh.MEC = Util.safeParseInt((String)paramMap.get(paramString + ".showModifyTip"));
      localczg.yVw.add(localczh);
      i += 1;
      break;
      AppMethodBeat.o(226001);
      return localczg;
    }
  }
  
  public static String b(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(225999);
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MsgUtil", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((Util.isNullOrNil(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break;
      }
      Log.w("MicroMsg.MsgUtil", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
      AppMethodBeat.o(225999);
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
        AppMethodBeat.o(225999);
        return paramString;
      }
      paramString = paramString.replace("<msgsource>", "<msgsource>" + localStringBuffer.toString());
      AppMethodBeat.o(225999);
      return paramString;
    }
    AppMethodBeat.o(225999);
    return paramString;
  }
  
  public static czg boC(String paramString)
  {
    AppMethodBeat.i(226000);
    czg localczg = new czg();
    if (!Util.isNullOrNil(paramString))
    {
      if (!paramString.contains("appmsg"))
      {
        paramString = Y("", XmlParser.parseXml(paramString, "patMsg", null));
        AppMethodBeat.o(226000);
        return paramString;
      }
      paramString = Y(".msg.appmsg", XmlParser.parseXml(paramString, "msg", null));
      AppMethodBeat.o(226000);
      return paramString;
    }
    AppMethodBeat.o(226000);
    return localczg;
  }
  
  public static String cT(ca paramca)
  {
    AppMethodBeat.i(117353);
    if (paramca == null)
    {
      AppMethodBeat.o(117353);
      return "";
    }
    if (paramca.field_isSend == 1) {
      paramca = z.aTY();
    }
    for (;;)
    {
      AppMethodBeat.o(117353);
      return paramca;
      String str1 = paramca.field_talker;
      if (ab.Eq(str1))
      {
        String str2 = bp.Ks(paramca.field_content);
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
  
  public static String cU(ca paramca)
  {
    AppMethodBeat.i(225998);
    if (paramca == null)
    {
      AppMethodBeat.o(225998);
      return "";
    }
    String str2 = paramca.field_content;
    if (str2 == null)
    {
      AppMethodBeat.o(225998);
      return "";
    }
    if (cV(paramca))
    {
      str1 = str2;
      if (ab.Eq(paramca.field_talker))
      {
        str1 = str2;
        if (paramca.field_isSend != 1)
        {
          i = bp.Kp(str2);
          str1 = str2;
          if (i != -1) {
            str1 = str2.substring(i + 1);
          }
        }
      }
      AppMethodBeat.o(225998);
      return str1;
    }
    String str1 = str2;
    if (ab.Eq(paramca.field_talker))
    {
      str1 = str2;
      if (paramca.field_isSend != 1)
      {
        i = bp.Kp(str2);
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
    AppMethodBeat.o(225998);
    return paramca;
  }
  
  private static boolean cV(ca paramca)
  {
    boolean bool = false;
    AppMethodBeat.i(226002);
    if (paramca == null)
    {
      AppMethodBeat.o(226002);
      return false;
    }
    switch (paramca.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(226002);
      return bool;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.e
 * JD-Core Version:    0.7.0.1
 */