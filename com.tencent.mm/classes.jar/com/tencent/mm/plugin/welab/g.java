package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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

public final class g
{
  private static DocumentBuilder dYM = null;
  
  public static a Uh(String paramString)
  {
    y.v("MicroMsg.Welabparser", "ABTest msg content: %s", new Object[] { paramString });
    Object localObject2 = paramString.replaceAll(">\n+\\s*<", "><");
    paramString = new a();
    Object localObject1 = jl((String)localObject2);
    if (localObject1 == null)
    {
      y.e("MicroMsg.Welabparser", "Msg parsing failed, msg: %s", new Object[] { localObject2 });
      return paramString;
    }
    localObject2 = ((Element)localObject1).getAttributes();
    if (localObject2 == null) {
      return null;
    }
    localObject2 = ((NamedNodeMap)localObject2).getNamedItem("type");
    int i = 1;
    if ((localObject2 != null) && ("newabtestlabs".equals(((Node)localObject2).getNodeValue())))
    {
      localObject2 = ((Element)localObject1).getElementsByTagName("prioritylevel");
      if (((NodeList)localObject2).getLength() > 0) {
        i = bk.getInt(((NodeList)localObject2).item(0).getTextContent(), 1);
      }
      localObject2 = ((Element)localObject1).getElementsByTagName("status");
      if (((NodeList)localObject2).getLength() > 0) {
        paramString.field_status = bk.getInt(((NodeList)localObject2).item(0).getTextContent(), 1);
      }
      paramString.field_prioritylevel = i;
      localObject1 = ((Element)localObject1).getChildNodes();
      i = 0;
      if (i >= ((NodeList)localObject1).getLength()) {
        break label1415;
      }
      localObject2 = ((NodeList)localObject1).item(i);
      if ((localObject2 == null) || (((Node)localObject2).getNodeType() != 1) || (!((Node)localObject2).getNodeName().equals("expinfo"))) {
        break label780;
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
              l3 = bk.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
              localObject3 = ((Element)localObject2).getElementsByTagName("starttime");
              if (((NodeList)localObject3).getLength() > 0)
              {
                l1 = bk.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
                if (l1 != 0L) {
                  break label1420;
                }
                l1 = System.currentTimeMillis() / 1000L;
              }
              try
              {
                paramString.field_idkey = bk.getInt(((Element)localObject2).getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent(), -1);
                paramString.field_idkeyValue = bk.getInt(((Element)localObject2).getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(1).getTextContent(), -1);
                localObject3 = ((Element)localObject2).getElementsByTagName("endtime");
                if (((NodeList)localObject3).getLength() <= 0) {
                  break label1423;
                }
                l2 = bk.getLong(((NodeList)localObject3).item(0).getTextContent(), 0L);
                if (l2 != 0L) {
                  break label1417;
                }
                break label1423;
                localObject3 = new HashMap();
                localObject2 = ((Element)localObject2).getElementsByTagName("args");
                if (((NodeList)localObject2).getLength() <= 0) {
                  break label787;
                }
                localObject2 = ((NodeList)localObject2).item(0).getChildNodes();
                int j = 0;
                if (j >= ((NodeList)localObject2).getLength()) {
                  break label787;
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
                y.i("MicroMsg.Welabparser", "recv illegal type msg");
                return paramString;
                l1 = System.currentTimeMillis() / 1000L;
                continue;
              }
              catch (Exception localException2)
              {
                y.e("MicroMsg.Welabparser", bk.j(localException2));
                continue;
              }
            }
          }
        }
        i += 1;
      }
      catch (Exception localException1)
      {
        y.e("MicroMsg.Welabparser", localException1.getMessage());
      }
      for (;;)
      {
        label780:
        break;
        label787:
        paramString.field_sequence = l3;
        paramString.field_starttime = l1;
        paramString.field_endtime = l2;
        paramString.field_AllVer = bk.ZR((String)localException2.get("AllVer"));
        paramString.field_BizType = bk.ZR((String)localException2.get("BizType"));
        paramString.field_Desc_cn = ((String)localException2.get("Desc_cn"));
        paramString.field_Desc_en = ((String)localException2.get("Desc_en"));
        paramString.field_Desc_hk = ((String)localException2.get("Desc_hk"));
        paramString.field_Desc_tw = ((String)localException2.get("Desc_tw"));
        paramString.field_DetailURL = ((String)localException2.get("DetailURL"));
        paramString.field_Introduce_cn = ((String)localException2.get("Introduce_cn"));
        paramString.field_Introduce_en = ((String)localException2.get("Introduce_en"));
        paramString.field_Introduce_hk = ((String)localException2.get("Introduce_hk"));
        paramString.field_Introduce_tw = ((String)localException2.get("Introduce_tw"));
        paramString.field_Pos = bk.ZR((String)localException2.get("Pos"));
        paramString.field_Type = bk.ZR((String)localException2.get("Type"));
        paramString.field_Switch = bk.ZR((String)localException2.get("Switch"));
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
        paramString.field_RedPoint = bk.ZR((String)localException2.get("RedPoint"));
        paramString.field_WeAppDebugMode = bk.ZR((String)localException2.get("WeAppDebugMode"));
        paramString.field_TitleKey_android = ((String)localException2.get("TitleKey_android"));
        paramString.field_Icon = ((String)localException2.get("Icon"));
      }
      label1415:
      return paramString;
      label1417:
      continue;
      label1420:
      continue;
      label1423:
      long l2 = 9223372036854775807L;
    }
  }
  
  public static List<String> Ui(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return Collections.EMPTY_LIST;
    }
    return Arrays.asList(paramString.split(";"));
  }
  
  private static String b(HashMap<String, String> paramHashMap, String paramString)
  {
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
    return localStringBuilder.toString();
    return localStringBuilder.toString();
  }
  
  private static Element jl(String paramString)
  {
    try
    {
      InputSource localInputSource = new InputSource(new ByteArrayInputStream(paramString.getBytes()));
      if (dYM != null) {
        paramString = dYM;
      }
      for (;;)
      {
        paramString = paramString.parse(localInputSource);
        paramString.normalize();
        return paramString.getDocumentElement();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        dYM = paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.Welabparser", paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.g
 * JD-Core Version:    0.7.0.1
 */