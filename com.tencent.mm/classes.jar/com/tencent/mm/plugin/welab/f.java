package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.b.c;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static DocumentBuilder hMb = null;
  
  private static Element Cu(String paramString)
  {
    AppMethodBeat.i(146232);
    try
    {
      InputSource localInputSource = new InputSource(new ByteArrayInputStream(paramString.getBytes()));
      if (hMb != null) {
        paramString = hMb;
      }
      for (;;)
      {
        paramString = paramString.parse(localInputSource);
        paramString.normalize();
        paramString = paramString.getDocumentElement();
        AppMethodBeat.o(146232);
        return paramString;
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        hMb = paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.Welabparser", paramString.toString());
      AppMethodBeat.o(146232);
    }
  }
  
  public static a a(c paramc)
  {
    AppMethodBeat.i(146233);
    a locala = new a();
    locala.field_expId = String.valueOf(paramc.rjD);
    locala.field_sequence = paramc.rjE;
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
      String str = "xlab_" + paramc.rjD;
      paramc = paramc.cEm;
      locala.field_AllVer = bu.aSB((String)paramc.get(gL(str, "AllVer")));
      locala.field_BizType = bu.aSB((String)paramc.get(gL(str, "BizType")));
      locala.field_Desc_cn = ((String)paramc.get(gL(str, "Desc_cn")));
      locala.field_Desc_en = ((String)paramc.get(gL(str, "Desc_en")));
      locala.field_Desc_hk = ((String)paramc.get(gL(str, "Desc_hk")));
      locala.field_Desc_tw = ((String)paramc.get(gL(str, "Desc_tw")));
      locala.field_DetailURL = ((String)paramc.get(gL(str, "DetailURL")));
      locala.field_Introduce_cn = ((String)paramc.get(gL(str, "Introduce_cn")));
      locala.field_Introduce_en = ((String)paramc.get(gL(str, "Introduce_en")));
      locala.field_Introduce_hk = ((String)paramc.get(gL(str, "Introduce_hk")));
      locala.field_Introduce_tw = ((String)paramc.get(gL(str, "Introduce_tw")));
      locala.field_Pos = bu.aSB((String)paramc.get(gL(str, "Pos")));
      locala.field_Type = bu.aSB((String)paramc.get(gL(str, "Type")));
      locala.field_Switch = bu.aSB((String)paramc.get(gL(str, "Switch")));
      locala.field_WeAppPath = ((String)paramc.get(gL(str, "WeAppPath")));
      locala.field_WeAppUser = ((String)paramc.get(gL(str, "WeAppUser")));
      locala.field_LabsAppId = ((String)paramc.get(gL(str, "LabsAppId")));
      locala.field_TitleKey_android = ((String)paramc.get(gL(str, "TitleKey_android")));
      locala.field_Title_cn = ((String)paramc.get(gL(str, "Title_cn")));
      locala.field_Title_en = ((String)paramc.get(gL(str, "Title_en")));
      locala.field_Title_hk = ((String)paramc.get(gL(str, "Title_hk")));
      locala.field_Title_tw = ((String)paramc.get(gL(str, "Title_tw")));
      locala.field_ThumbUrl_cn = ((String)paramc.get(gL(str, "ThumbUrl_cn")));
      locala.field_ThumbUrl_en = ((String)paramc.get(gL(str, "ThumbUrl_en")));
      locala.field_ThumbUrl_hk = ((String)paramc.get(gL(str, "ThumbUrl_hk")));
      locala.field_ThumbUrl_tw = ((String)paramc.get(gL(str, "ThumbUrl_tw")));
      locala.field_ImgUrl_android_cn = b(paramc, gL(str, "ImgUrl_android_cn")).replace(',', ';');
      locala.field_ImgUrl_android_tw = b(paramc, gL(str, "ImgUrl_android_tw")).replace(',', ';');
      locala.field_ImgUrl_android_en = b(paramc, gL(str, "ImgUrl_android_en")).replace(',', ';');
      locala.field_ImgUrl_android_hk = b(paramc, gL(str, "ImgUrl_android_hk")).replace(',', ';');
      if (TextUtils.isEmpty(locala.field_ImgUrl_android_cn)) {
        locala.field_ImgUrl_android_cn = ((String)paramc.get(gL(str, "ImgUrl_cn")));
      }
      if (TextUtils.isEmpty(locala.field_ImgUrl_android_en)) {
        locala.field_ImgUrl_android_en = ((String)paramc.get(gL(str, "ImgUrl_en")));
      }
      if (TextUtils.isEmpty(locala.field_ImgUrl_android_hk)) {
        locala.field_ImgUrl_android_hk = ((String)paramc.get(gL(str, "ImgUrl_hk")));
      }
      if (TextUtils.isEmpty(locala.field_ImgUrl_android_tw)) {
        locala.field_ImgUrl_android_tw = ((String)paramc.get(gL(str, "ImgUrl_tw")));
      }
      locala.field_RedPoint = bu.aSB((String)paramc.get(gL(str, "RedPoint")));
      locala.field_WeAppDebugMode = bu.aSB((String)paramc.get(gL(str, "WeAppDebugMode")));
      locala.field_TitleKey_android = ((String)paramc.get(gL(str, "TitleKey_android")));
      locala.field_Icon = ((String)paramc.get(gL(str, "Icon")));
      locala.field_bItemFromXExpt = 1;
      locala.field_status = bu.aSB((String)paramc.get(gL(str, "status")));
      locala.field_idkey = bu.aSB((String)paramc.get(gL(str, "idkey")));
      locala.field_idkeyValue = bu.aSB((String)paramc.get(gL(str, "idkeyValue")));
      AppMethodBeat.o(146233);
      return locala;
      l = System.currentTimeMillis() / 1000L;
      break;
    }
  }
  
  public static a aLl(String paramString)
  {
    AppMethodBeat.i(146229);
    ae.v("MicroMsg.Welabparser", "ABTest msg content: %s", new Object[] { paramString });
    Object localObject2 = paramString.replaceAll(">\n+\\s*<", "><");
    paramString = new a();
    Object localObject1 = Cu((String)localObject2);
    if (localObject1 == null)
    {
      ae.e("MicroMsg.Welabparser", "Msg parsing failed, msg: %s", new Object[] { localObject2 });
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
        i = bu.getInt(((NodeList)localObject2).item(0).getTextContent(), 1);
      }
      localObject2 = ((Element)localObject1).getElementsByTagName("status");
      if (((NodeList)localObject2).getLength() > 0) {
        paramString.field_status = bu.getInt(((NodeList)localObject2).item(0).getTextContent(), 1);
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
              l3 = bu.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
              localObject3 = ((Element)localObject2).getElementsByTagName("starttime");
              if (((NodeList)localObject3).getLength() > 0)
              {
                l1 = bu.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
                if (l1 != 0L) {
                  break label1459;
                }
                l1 = System.currentTimeMillis() / 1000L;
              }
              try
              {
                paramString.field_idkey = bu.getInt(((Element)localObject2).getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent(), -1);
                paramString.field_idkeyValue = bu.getInt(((Element)localObject2).getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(1).getTextContent(), -1);
                localObject3 = ((Element)localObject2).getElementsByTagName("endtime");
                if (((NodeList)localObject3).getLength() <= 0) {
                  break label1462;
                }
                l2 = bu.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
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
                ae.i("MicroMsg.Welabparser", "recv illegal type msg");
                AppMethodBeat.o(146229);
                return paramString;
                l1 = System.currentTimeMillis() / 1000L;
                continue;
              }
              catch (Exception localException2)
              {
                ae.e("MicroMsg.Welabparser", bu.o(localException2));
                continue;
              }
            }
          }
        }
        i += 1;
      }
      catch (Exception localException1)
      {
        ae.e("MicroMsg.Welabparser", localException1.getMessage());
      }
      for (;;)
      {
        label824:
        break;
        label831:
        paramString.field_sequence = l3;
        paramString.field_starttime = l1;
        paramString.field_endtime = l2;
        paramString.field_AllVer = bu.aSB((String)localException2.get("AllVer"));
        paramString.field_BizType = bu.aSB((String)localException2.get("BizType"));
        paramString.field_Desc_cn = ((String)localException2.get("Desc_cn"));
        paramString.field_Desc_en = ((String)localException2.get("Desc_en"));
        paramString.field_Desc_hk = ((String)localException2.get("Desc_hk"));
        paramString.field_Desc_tw = ((String)localException2.get("Desc_tw"));
        paramString.field_DetailURL = ((String)localException2.get("DetailURL"));
        paramString.field_Introduce_cn = ((String)localException2.get("Introduce_cn"));
        paramString.field_Introduce_en = ((String)localException2.get("Introduce_en"));
        paramString.field_Introduce_hk = ((String)localException2.get("Introduce_hk"));
        paramString.field_Introduce_tw = ((String)localException2.get("Introduce_tw"));
        paramString.field_Pos = bu.aSB((String)localException2.get("Pos"));
        paramString.field_Type = bu.aSB((String)localException2.get("Type"));
        paramString.field_Switch = bu.aSB((String)localException2.get("Switch"));
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
        paramString.field_ImgUrl_android_cn = b(localException2, "ImgUrl_android_cn");
        paramString.field_ImgUrl_android_tw = b(localException2, "ImgUrl_android_tw");
        paramString.field_ImgUrl_android_en = b(localException2, "ImgUrl_android_en");
        paramString.field_ImgUrl_android_hk = b(localException2, "ImgUrl_android_hk");
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
        paramString.field_RedPoint = bu.aSB((String)localException2.get("RedPoint"));
        paramString.field_WeAppDebugMode = bu.aSB((String)localException2.get("WeAppDebugMode"));
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
  
  public static List<String> aLm(String paramString)
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
  
  private static String b(HashMap<String, String> paramHashMap, String paramString)
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
  
  private static String gL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146234);
    paramString1 = (paramString1 + "_" + paramString2).toLowerCase();
    AppMethodBeat.o(146234);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.f
 * JD-Core Version:    0.7.0.1
 */