package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.b.c;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class f
{
  private static DocumentBuilder ooF = null;
  
  private static Element KA(String paramString)
  {
    AppMethodBeat.i(146232);
    try
    {
      InputSource localInputSource = new InputSource(new ByteArrayInputStream(paramString.getBytes()));
      if (ooF != null) {
        paramString = ooF;
      }
      for (;;)
      {
        paramString = paramString.parse(localInputSource);
        paramString.normalize();
        paramString = paramString.getDocumentElement();
        AppMethodBeat.o(146232);
        return paramString;
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        ooF = paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.Welabparser", paramString.toString());
      AppMethodBeat.o(146232);
    }
  }
  
  public static a a(c paramc)
  {
    AppMethodBeat.i(146233);
    a locala = new a();
    locala.field_expId = String.valueOf(paramc.zNd);
    locala.field_sequence = paramc.zNe;
    if (paramc.startTime > 0L)
    {
      l = paramc.startTime;
      locala.field_starttime = l;
      if (paramc.endTime <= 0L) {
        break label963;
      }
    }
    label963:
    for (long l = paramc.endTime;; l = 9223372036854775807L)
    {
      locala.field_endtime = l;
      String str = "xlab_" + paramc.zNd;
      paramc = paramc.map;
      locala.field_AllVer = Util.safeParseInt((String)paramc.get(oF(str, "AllVer")));
      locala.field_BizType = Util.safeParseInt((String)paramc.get(oF(str, "BizType")));
      locala.field_Desc_cn = ((String)paramc.get(oF(str, "Desc_cn")));
      locala.field_Desc_en = ((String)paramc.get(oF(str, "Desc_en")));
      locala.field_Desc_hk = ((String)paramc.get(oF(str, "Desc_hk")));
      locala.field_Desc_tw = ((String)paramc.get(oF(str, "Desc_tw")));
      locala.field_DetailURL = ((String)paramc.get(oF(str, "DetailURL")));
      locala.field_Introduce_cn = ((String)paramc.get(oF(str, "Introduce_cn")));
      locala.field_Introduce_en = ((String)paramc.get(oF(str, "Introduce_en")));
      locala.field_Introduce_hk = ((String)paramc.get(oF(str, "Introduce_hk")));
      locala.field_Introduce_tw = ((String)paramc.get(oF(str, "Introduce_tw")));
      locala.field_Pos = Util.safeParseInt((String)paramc.get(oF(str, "Pos")));
      locala.field_Type = Util.safeParseInt((String)paramc.get(oF(str, "Type")));
      locala.field_Switch = Util.safeParseInt((String)paramc.get(oF(str, "Switch")));
      locala.field_WeAppPath = ((String)paramc.get(oF(str, "WeAppPath")));
      locala.field_WeAppUser = ((String)paramc.get(oF(str, "WeAppUser")));
      locala.field_LabsAppId = ((String)paramc.get(oF(str, "LabsAppId")));
      locala.field_TitleKey_android = ((String)paramc.get(oF(str, "TitleKey_android")));
      locala.field_Title_cn = ((String)paramc.get(oF(str, "Title_cn")));
      locala.field_Title_en = ((String)paramc.get(oF(str, "Title_en")));
      locala.field_Title_hk = ((String)paramc.get(oF(str, "Title_hk")));
      locala.field_Title_tw = ((String)paramc.get(oF(str, "Title_tw")));
      locala.field_ThumbUrl_cn = ((String)paramc.get(oF(str, "ThumbUrl_cn")));
      locala.field_ThumbUrl_en = ((String)paramc.get(oF(str, "ThumbUrl_en")));
      locala.field_ThumbUrl_hk = ((String)paramc.get(oF(str, "ThumbUrl_hk")));
      locala.field_ThumbUrl_tw = ((String)paramc.get(oF(str, "ThumbUrl_tw")));
      locala.field_ImgUrl_android_cn = c(paramc, oF(str, "ImgUrl_android_cn")).replace(',', ';');
      locala.field_ImgUrl_android_tw = c(paramc, oF(str, "ImgUrl_android_tw")).replace(',', ';');
      locala.field_ImgUrl_android_en = c(paramc, oF(str, "ImgUrl_android_en")).replace(',', ';');
      locala.field_ImgUrl_android_hk = c(paramc, oF(str, "ImgUrl_android_hk")).replace(',', ';');
      if (TextUtils.isEmpty(locala.field_ImgUrl_android_cn)) {
        locala.field_ImgUrl_android_cn = ((String)paramc.get(oF(str, "ImgUrl_cn")));
      }
      if (TextUtils.isEmpty(locala.field_ImgUrl_android_en)) {
        locala.field_ImgUrl_android_en = ((String)paramc.get(oF(str, "ImgUrl_en")));
      }
      if (TextUtils.isEmpty(locala.field_ImgUrl_android_hk)) {
        locala.field_ImgUrl_android_hk = ((String)paramc.get(oF(str, "ImgUrl_hk")));
      }
      if (TextUtils.isEmpty(locala.field_ImgUrl_android_tw)) {
        locala.field_ImgUrl_android_tw = ((String)paramc.get(oF(str, "ImgUrl_tw")));
      }
      locala.field_RedPoint = Util.safeParseInt((String)paramc.get(oF(str, "RedPoint")));
      locala.field_WeAppDebugMode = Util.safeParseInt((String)paramc.get(oF(str, "WeAppDebugMode")));
      locala.field_TitleKey_android = ((String)paramc.get(oF(str, "TitleKey_android")));
      locala.field_Icon = ((String)paramc.get(oF(str, "Icon")));
      locala.field_bItemFromXExpt = 1;
      locala.field_status = Util.safeParseInt((String)paramc.get(oF(str, "status")));
      locala.field_idkey = Util.safeParseInt((String)paramc.get(oF(str, "idkey")));
      locala.field_idkeyValue = Util.safeParseInt((String)paramc.get(oF(str, "idkeyValue")));
      AppMethodBeat.o(146233);
      return locala;
      l = System.currentTimeMillis() / 1000L;
      break;
    }
  }
  
  public static a bnp(String paramString)
  {
    AppMethodBeat.i(146229);
    Log.v("MicroMsg.Welabparser", "ABTest msg content: %s", new Object[] { paramString });
    Object localObject2 = paramString.replaceAll(">\n+\\s*<", "><");
    paramString = new a();
    Object localObject1 = KA((String)localObject2);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.Welabparser", "Msg parsing failed, msg: %s", new Object[] { localObject2 });
      AppMethodBeat.o(146229);
      return paramString;
    }
    localObject2 = ((Element)localObject1).getAttributes();
    if (localObject2 == null)
    {
      AppMethodBeat.o(146229);
      return null;
    }
    localObject2 = ((NamedNodeMap)localObject2).getNamedItem("type");
    int i = 1;
    if ((localObject2 != null) && ("newabtestlabs".equals(((Node)localObject2).getNodeValue())))
    {
      localObject2 = ((Element)localObject1).getElementsByTagName("prioritylevel");
      if (((NodeList)localObject2).getLength() > 0) {
        i = Util.getInt(((NodeList)localObject2).item(0).getTextContent(), 1);
      }
      localObject2 = ((Element)localObject1).getElementsByTagName("status");
      if (((NodeList)localObject2).getLength() > 0) {
        paramString.field_status = Util.getInt(((NodeList)localObject2).item(0).getTextContent(), 1);
      }
      paramString.field_prioritylevel = i;
      localObject1 = ((Element)localObject1).getChildNodes();
      i = 0;
      if (i >= ((NodeList)localObject1).getLength()) {
        break label1448;
      }
      localObject2 = ((NodeList)localObject1).item(i);
      if ((localObject2 == null) || (((Node)localObject2).getNodeType() != 1) || (!((Node)localObject2).getNodeName().equals("expinfo"))) {
        break label824;
      }
    }
    for (;;)
    {
      long l3;
      long l1;
      try
      {
        localObject2 = (Element)localObject2;
        Object localObject3 = ((Element)localObject2).getAttributes();
        if (localObject3 != null)
        {
          localObject3 = ((NamedNodeMap)localObject3).getNamedItem("id");
          if (localObject3 != null)
          {
            paramString.field_expId = ((Node)localObject3).getNodeValue();
            localObject3 = ((Element)localObject2).getElementsByTagName("sequence");
            if (((NodeList)localObject3).getLength() != 0)
            {
              l3 = Util.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
              localObject3 = ((Element)localObject2).getElementsByTagName("starttime");
              if (((NodeList)localObject3).getLength() > 0)
              {
                l1 = Util.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
                if (l1 != 0L) {
                  break label1459;
                }
                l1 = System.currentTimeMillis() / 1000L;
              }
              try
              {
                paramString.field_idkey = Util.getInt(((Element)localObject2).getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent(), -1);
                paramString.field_idkeyValue = Util.getInt(((Element)localObject2).getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(1).getTextContent(), -1);
                localObject3 = ((Element)localObject2).getElementsByTagName("endtime");
                if (((NodeList)localObject3).getLength() <= 0) {
                  break label1462;
                }
                l2 = Util.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
                if (l2 != 0L) {
                  break label1456;
                }
                break label1462;
                localObject3 = new HashMap();
                localObject2 = ((Element)localObject2).getElementsByTagName("args");
                if (((NodeList)localObject2).getLength() <= 0) {
                  break label831;
                }
                localObject2 = ((NodeList)localObject2).item(0).getChildNodes();
                int j = 0;
                if (j >= ((NodeList)localObject2).getLength()) {
                  break label831;
                }
                Object localObject4 = ((NodeList)localObject2).item(j);
                if ((((Node)localObject4).getNodeType() == 1) && (((Node)localObject4).getNodeName().equals("arg")))
                {
                  NodeList localNodeList = ((Element)localObject4).getElementsByTagName("key");
                  localObject4 = ((Element)localObject4).getElementsByTagName("value");
                  if ((localNodeList.getLength() != 0) && (((NodeList)localObject4).getLength() != 0)) {
                    ((HashMap)localObject3).put(localNodeList.item(0).getTextContent(), ((NodeList)localObject4).item(0).getTextContent());
                  }
                }
                j += 1;
                continue;
                Log.i("MicroMsg.Welabparser", "recv illegal type msg");
                AppMethodBeat.o(146229);
                return paramString;
                l1 = System.currentTimeMillis() / 1000L;
                continue;
              }
              catch (Exception localException2)
              {
                Log.e("MicroMsg.Welabparser", Util.stackTraceToString(localException2));
                continue;
              }
            }
          }
        }
        i += 1;
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.Welabparser", localException1.getMessage());
      }
      for (;;)
      {
        label824:
        break;
        label831:
        paramString.field_sequence = l3;
        paramString.field_starttime = l1;
        paramString.field_endtime = l2;
        paramString.field_AllVer = Util.safeParseInt((String)localException2.get("AllVer"));
        paramString.field_BizType = Util.safeParseInt((String)localException2.get("BizType"));
        paramString.field_Desc_cn = ((String)localException2.get("Desc_cn"));
        paramString.field_Desc_en = ((String)localException2.get("Desc_en"));
        paramString.field_Desc_hk = ((String)localException2.get("Desc_hk"));
        paramString.field_Desc_tw = ((String)localException2.get("Desc_tw"));
        paramString.field_DetailURL = ((String)localException2.get("DetailURL"));
        paramString.field_Introduce_cn = ((String)localException2.get("Introduce_cn"));
        paramString.field_Introduce_en = ((String)localException2.get("Introduce_en"));
        paramString.field_Introduce_hk = ((String)localException2.get("Introduce_hk"));
        paramString.field_Introduce_tw = ((String)localException2.get("Introduce_tw"));
        paramString.field_Pos = Util.safeParseInt((String)localException2.get("Pos"));
        paramString.field_Type = Util.safeParseInt((String)localException2.get("Type"));
        paramString.field_Switch = Util.safeParseInt((String)localException2.get("Switch"));
        paramString.field_WeAppPath = ((String)localException2.get("WeAppPath"));
        paramString.field_WeAppUser = ((String)localException2.get("WeAppUser"));
        paramString.field_LabsAppId = ((String)localException2.get("LabsAppId"));
        paramString.field_TitleKey_android = ((String)localException2.get("TitleKey_android"));
        paramString.field_Title_cn = ((String)localException2.get("Title_cn"));
        paramString.field_Title_en = ((String)localException2.get("Title_en"));
        paramString.field_Title_hk = ((String)localException2.get("Title_hk"));
        paramString.field_Title_tw = ((String)localException2.get("Title_tw"));
        paramString.field_ThumbUrl_cn = ((String)localException2.get("ThumbUrl_cn"));
        paramString.field_ThumbUrl_en = ((String)localException2.get("ThumbUrl_en"));
        paramString.field_ThumbUrl_hk = ((String)localException2.get("ThumbUrl_hk"));
        paramString.field_ThumbUrl_tw = ((String)localException2.get("ThumbUrl_tw"));
        paramString.field_ImgUrl_android_cn = c(localException2, "ImgUrl_android_cn");
        paramString.field_ImgUrl_android_tw = c(localException2, "ImgUrl_android_tw");
        paramString.field_ImgUrl_android_en = c(localException2, "ImgUrl_android_en");
        paramString.field_ImgUrl_android_hk = c(localException2, "ImgUrl_android_hk");
        if (TextUtils.isEmpty(paramString.field_ImgUrl_android_cn)) {
          paramString.field_ImgUrl_android_cn = ((String)localException2.get("ImgUrl_cn"));
        }
        if (TextUtils.isEmpty(paramString.field_ImgUrl_android_en)) {
          paramString.field_ImgUrl_android_en = ((String)localException2.get("ImgUrl_en"));
        }
        if (TextUtils.isEmpty(paramString.field_ImgUrl_android_hk)) {
          paramString.field_ImgUrl_android_hk = ((String)localException2.get("ImgUrl_hk"));
        }
        if (TextUtils.isEmpty(paramString.field_ImgUrl_android_tw)) {
          paramString.field_ImgUrl_android_tw = ((String)localException2.get("ImgUrl_tw"));
        }
        paramString.field_RedPoint = Util.safeParseInt((String)localException2.get("RedPoint"));
        paramString.field_WeAppDebugMode = Util.safeParseInt((String)localException2.get("WeAppDebugMode"));
        paramString.field_TitleKey_android = ((String)localException2.get("TitleKey_android"));
        paramString.field_Icon = ((String)localException2.get("Icon"));
      }
      label1448:
      AppMethodBeat.o(146229);
      return paramString;
      label1456:
      continue;
      label1459:
      continue;
      label1462:
      long l2 = 9223372036854775807L;
    }
  }
  
  public static List<String> bnq(String paramString)
  {
    AppMethodBeat.i(146231);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = Collections.EMPTY_LIST;
      AppMethodBeat.o(146231);
      return paramString;
    }
    paramString = Arrays.asList(paramString.split(";"));
    AppMethodBeat.o(146231);
    return paramString;
  }
  
  private static String c(HashMap<String, String> paramHashMap, String paramString)
  {
    AppMethodBeat.i(146230);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramHashMap.containsKey(paramString))
    {
      localStringBuilder.append((String)paramHashMap.get(paramString)).append(";");
      int i = 1;
      for (;;)
      {
        String str = paramString + "_" + i;
        if (!paramHashMap.containsKey(str)) {
          break;
        }
        localStringBuilder.append((String)paramHashMap.get(str)).append(";");
        i += 1;
      }
    }
    paramHashMap = localStringBuilder.toString();
    AppMethodBeat.o(146230);
    return paramHashMap;
    paramHashMap = localStringBuilder.toString();
    AppMethodBeat.o(146230);
    return paramHashMap;
  }
  
  private static String oF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146234);
    paramString1 = (paramString1 + "_" + paramString2).toLowerCase();
    AppMethodBeat.o(146234);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.f
 * JD-Core Version:    0.7.0.1
 */