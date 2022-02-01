package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class g
{
  public static ebd ak(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233990);
    ebd localebd = new ebd();
    int i;
    ebe localebe;
    if (paramMap != null)
    {
      String str = Util.nullAsNil(paramString) + ".patMsg";
      localebd.ltm = Util.nullAsNil((String)paramMap.get(str + ".chatUser"));
      int j = Util.safeParseInt((String)paramMap.get(str + ".records.recordNum"));
      i = 0;
      if (i < j)
      {
        localebe = new ebe();
        paramString = str + ".records.record";
        if (i <= 0) {
          break label533;
        }
        paramString = paramString + i;
      }
    }
    label533:
    for (;;)
    {
      localebe.hQQ = Util.nullAsNil((String)paramMap.get(paramString + ".fromUser"));
      localebe.abgI = Util.nullAsNil((String)paramMap.get(paramString + ".pattedUser"));
      localebe.nVS = Util.nullAsNil((String)paramMap.get(paramString + ".template"));
      if (Util.isNullOrNil(localebe.nVS)) {
        localebe.nVS = Util.nullAsNil((String)paramMap.get(paramString + ".templete"));
      }
      localebe.createTime = Util.safeParseLong((String)paramMap.get(paramString + ".createTime"));
      localebe.abgJ = Util.safeParseInt((String)paramMap.get(paramString + ".readStatus"));
      localebe.vaU = Util.safeParseLong((String)paramMap.get(paramString + ".svrId"));
      localebe.abgK = Util.safeParseInt((String)paramMap.get(paramString + ".showModifyTip"));
      localebe.abgL = Util.safeParseInt((String)paramMap.get(paramString + ".isNewPatMsg"));
      localebd.Ksg.add(localebe);
      i += 1;
      break;
      AppMethodBeat.o(233990);
      return localebd;
    }
  }
  
  public static ebd bDK(String paramString)
  {
    AppMethodBeat.i(233979);
    ebd localebd = new ebd();
    if (!Util.isNullOrNil(paramString))
    {
      if (!paramString.contains("appmsg"))
      {
        paramString = ak("", XmlParser.parseXml(paramString, "patMsg", null));
        AppMethodBeat.o(233979);
        return paramString;
      }
      paramString = ak(".msg.appmsg", XmlParser.parseXml(paramString, "msg", null));
      AppMethodBeat.o(233979);
      return paramString;
    }
    AppMethodBeat.o(233979);
    return localebd;
  }
  
  public static String c(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(233974);
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MsgUtil", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((Util.isNullOrNil(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break;
      }
      Log.w("MicroMsg.MsgUtil", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
      AppMethodBeat.o(233974);
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
        AppMethodBeat.o(233974);
        return paramString;
      }
      paramString = paramString.replace("<msgsource>", "<msgsource>" + localStringBuffer.toString());
      AppMethodBeat.o(233974);
      return paramString;
    }
    AppMethodBeat.o(233974);
    return paramString;
  }
  
  public static String dP(cc paramcc)
  {
    AppMethodBeat.i(117353);
    if (paramcc == null)
    {
      AppMethodBeat.o(117353);
      return "";
    }
    if (paramcc.field_isSend == 1) {
      paramcc = z.bAM();
    }
    for (;;)
    {
      AppMethodBeat.o(117353);
      return paramcc;
      String str1 = paramcc.field_talker;
      if (au.bwE(str1))
      {
        String str2 = br.JJ(paramcc.field_content);
        if ((str1 != null) && (str2 != null))
        {
          paramcc = str2;
          if (str2.length() > 0) {
            continue;
          }
        }
      }
      paramcc = str1;
    }
  }
  
  public static String dQ(cc paramcc)
  {
    AppMethodBeat.i(233970);
    if (paramcc == null)
    {
      AppMethodBeat.o(233970);
      return "";
    }
    String str2 = paramcc.field_content;
    if (str2 == null)
    {
      AppMethodBeat.o(233970);
      return "";
    }
    if (dR(paramcc))
    {
      str1 = str2;
      if (au.bwE(paramcc.field_talker))
      {
        str1 = str2;
        if (paramcc.field_isSend != 1)
        {
          i = br.JG(str2);
          str1 = str2;
          if (i != -1) {
            str1 = str2.substring(i + 1);
          }
        }
      }
      AppMethodBeat.o(233970);
      return str1;
    }
    String str1 = str2;
    if (au.bwE(paramcc.field_talker))
    {
      str1 = str2;
      if (paramcc.field_isSend != 1)
      {
        i = br.JG(str2);
        str1 = str2;
        if (i != -1) {
          str1 = str2.substring(i + 1);
        }
      }
    }
    int i = str1.indexOf('<');
    paramcc = str1;
    if (i > 0) {
      paramcc = str1.substring(i);
    }
    AppMethodBeat.o(233970);
    return paramcc;
  }
  
  private static boolean dR(cc paramcc)
  {
    boolean bool = false;
    AppMethodBeat.i(233995);
    if (paramcc == null)
    {
      AppMethodBeat.o(233995);
      return false;
    }
    switch (paramcc.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(233995);
      return bool;
      bool = true;
    }
  }
  
  public static final class a
    extends ebe
  {
    public String agts;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.util.g
 * JD-Core Version:    0.7.0.1
 */