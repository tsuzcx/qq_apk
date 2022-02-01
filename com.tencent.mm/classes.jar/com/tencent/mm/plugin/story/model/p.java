package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final a Sku;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118776);
    Sku = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineHelper";
    AppMethodBeat.o(118776);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static String Pl(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static fjj a(fjj paramfjj)
    {
      AppMethodBeat.i(118769);
      enw localenw = new enw();
      localenw.ZaG = 0.0F;
      localenw.ZaH = 0.0F;
      localenw.pSh = "";
      localenw.aaPN = 0;
      localenw.ZWG = "";
      localenw.ReW = 0;
      localenw.ReU = "";
      localenw.poiName = "";
      localenw.aaPO = 1;
      localenw.aaPQ = "";
      localenw.country = "";
      paramfjj.abJY = localenw;
      AppMethodBeat.o(118769);
      return paramfjj;
    }
    
    private static fjj a(Map<String, String> paramMap, fjj paramfjj)
    {
      AppMethodBeat.i(118770);
      if (paramfjj.abJZ == null) {
        paramfjj.abJZ = new fij();
      }
      paramfjj.abJZ.hAP = Pl((String)paramMap.get("contTitle"));
      int i = 0;
      Object localObject1;
      Object localObject2;
      String str8;
      String str2;
      String str4;
      String str7;
      String str6;
      String str5;
      String str3;
      String str1;
      Object localObject3;
      Object localObject4;
      if (i != 0)
      {
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        str8 = p.c.hwo();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        str2 = p.c.hwp();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        str4 = p.c.hwq();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        str7 = p.c.hwr();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        str6 = p.c.hwt();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        str5 = p.c.hws();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        str3 = p.c.hwu();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        str1 = p.c.hwv();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        localObject3 = p.c.hww();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject2 = p.c.Skx;
        localObject2 = p.c.hwx();
        localObject1 = new StringBuilder();
        localObject4 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject4 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject4 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn()).append(i);
        localObject4 = p.c.Skx;
        localObject1 = p.c.hwy();
        label943:
        str8 = (String)paramMap.get(str8);
        str2 = (String)paramMap.get(str2);
        if (str2 != null) {
          break label2156;
        }
        str2 = "";
        label978:
        str4 = (String)paramMap.get(str4);
        if (str4 != null) {
          break label2159;
        }
        str4 = "";
        label1000:
        str6 = (String)paramMap.get(str6);
        if (str6 != null) {
          break label2162;
        }
        str6 = "";
        label1022:
        str7 = (String)paramMap.get(str7);
        if (str7 != null) {
          break label2165;
        }
        str7 = "";
        label1044:
        str5 = (String)paramMap.get(str5);
        if (str5 != null) {
          break label2168;
        }
        str5 = "";
        label1066:
        str3 = (String)paramMap.get(str3);
        if (str3 != null) {
          break label2171;
        }
        str3 = "";
        label1088:
        str1 = (String)paramMap.get(str1);
        if (str1 != null) {
          break label2174;
        }
        str1 = "";
        label1110:
        paramMap.get(localObject3);
        localObject2 = (String)paramMap.get(localObject2);
        if (localObject2 != null) {
          break label2177;
        }
        localObject2 = "";
        label1141:
        localObject3 = (String)paramMap.get(localObject1);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        if (str8 == null) {
          break label2190;
        }
        localObject3 = new fis();
        ((fis)localObject3).Id = Pl(str8);
        ((fis)localObject3).vhJ = Util.getInt(str2, 0);
        ((fis)localObject3).Url = Pl(str4);
        ((fis)localObject3).aazR = Util.getInt(str5, 0);
        ((fis)localObject3).aaTl = Pl(str6);
        ((fis)localObject3).aaTm = Util.getInt(str3, 0);
        ((fis)localObject3).subType = Util.getInt(str1, 0);
        ((fis)localObject3).md5 = Pl((String)localObject2);
        ((fis)localObject3).aaTE = Pl(str7);
        if (localObject1 != null) {
          break label2180;
        }
      }
      label2177:
      label2180:
      for (float f = 0.0F;; f = Util.getFloat((String)localObject1, 0.0F))
      {
        ((fis)localObject3).abJB = f;
        paramfjj.abJZ.Zpr.add(localObject3);
        i += 1;
        break;
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        str8 = p.c.hwo();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        str2 = p.c.hwp();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        str4 = p.c.hwq();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        str7 = p.c.hwr();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        str6 = p.c.hwt();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        str5 = p.c.hws();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        str3 = p.c.hwu();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        str1 = p.c.hwv();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        localObject3 = p.c.hww();
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        ((StringBuilder)localObject1).append(p.c.hwn());
        localObject1 = new StringBuilder();
        localObject2 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject2 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject2 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject2 = p.c.Skx;
        localObject2 = p.c.hwx();
        localObject1 = new StringBuilder();
        localObject4 = p.d.SkN;
        localObject1 = ((StringBuilder)localObject1).append(p.d.hwC());
        localObject4 = p.b.Skv;
        localObject1 = ((StringBuilder)localObject1).append(p.b.hwm());
        localObject4 = p.c.Skx;
        localObject1 = ((StringBuilder)localObject1).append(p.c.hwn());
        localObject4 = p.c.Skx;
        localObject1 = p.c.hwy();
        break label943;
        label2156:
        break label978;
        label2159:
        break label1000;
        label2162:
        break label1022;
        label2165:
        break label1044;
        label2168:
        break label1066;
        label2171:
        break label1088;
        label2174:
        break label1110;
        break label1141;
      }
      label2190:
      AppMethodBeat.o(118770);
      return paramfjj;
    }
    
    public static fjj bbS(String paramString)
    {
      AppMethodBeat.i(118772);
      s.u(paramString, "xml");
      paramString = XmlParser.parseXml(paramString, "StoryObject", null);
      if (paramString != null)
      {
        fjj localfjj = hwl();
        p.d locald = p.d.SkN;
        localfjj.Id = Pl((String)paramString.get(p.d.hwz()));
        locald = p.d.SkN;
        localfjj.UserName = Pl((String)paramString.get(p.d.hwA()));
        locald = p.d.SkN;
        localfjj.CreateTime = Util.getInt((String)paramString.get(p.d.hwB()), 0);
        locald = p.d.SkN;
        localfjj.abKb = Util.getInt((String)paramString.get(p.d.hwD()), 0);
        paramString = a(paramString, a(localfjj));
        AppMethodBeat.o(118772);
        return paramString;
      }
      AppMethodBeat.o(118772);
      return null;
    }
    
    public static fjj hwl()
    {
      AppMethodBeat.i(118771);
      fjj localfjj = new fjj();
      fij localfij = new fij();
      enw localenw = new enw();
      localenw.ZaH = 0.0F;
      localenw.ZaG = 0.0F;
      localfjj.abJY = localenw;
      localfjj.abJZ = localfij;
      localfjj.Id = "";
      localfjj.CreateTime = 0;
      AppMethodBeat.o(118771);
      return localfjj;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$MediaObjTAG;", "", "()V", "XML_DESC", "", "getXML_DESC", "()Ljava/lang/String;", "XML_DURATION", "getXML_DURATION", "XML_PRIVATED", "getXML_PRIVATED", "XML_SIZE", "getXML_SIZE", "XML_SUBTYPE", "getXML_SUBTYPE", "XML_TAG", "getXML_TAG", "XML_THUMB", "getXML_THUMB", "XML_THUMBTYPE", "getXML_THUMBTYPE", "XML_TITLE", "getXML_TITLE", "XML_TYPE", "getXML_TYPE", "XML_URL", "getXML_URL", "XML_URLTYPE", "getXML_URLTYPE", "XML_URL_MD5", "getXML_URL_MD5", "XML_USERDATA", "getXML_USERDATA", "XML_VIDEOMD5", "getXML_VIDEOMD5", "XML_id", "getXML_id", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    private static final String SkA;
    private static final String SkB;
    private static final String SkC;
    private static final String SkD;
    private static final String SkE;
    private static final String SkF;
    private static final String SkG;
    private static final String SkH;
    private static final String SkI;
    private static final String SkJ;
    private static final String SkK;
    private static final String SkL;
    private static final String SkM;
    public static final c Skx;
    private static final String Sky;
    private static final String Skz;
    private static final String pqK;
    
    static
    {
      AppMethodBeat.i(118774);
      Skx = new c();
      Sky = ".media";
      Skz = ".id";
      pqK = ".type";
      SkA = ".title";
      SkB = ".description";
      SkC = ".url";
      SkD = ".url.$videomd5";
      SkE = ".url.$type";
      SkF = ".thumb";
      SkG = ".thumb.$type";
      SkH = ".private";
      SkI = ".size";
      SkJ = ".subType";
      SkK = ".userData";
      SkL = ".url.$md5";
      SkM = ".duration";
      AppMethodBeat.o(118774);
    }
    
    public static String hwn()
    {
      return Sky;
    }
    
    public static String hwo()
    {
      return Skz;
    }
    
    public static String hwp()
    {
      return pqK;
    }
    
    public static String hwq()
    {
      return SkC;
    }
    
    public static String hwr()
    {
      return SkD;
    }
    
    public static String hws()
    {
      return SkE;
    }
    
    public static String hwt()
    {
      return SkF;
    }
    
    public static String hwu()
    {
      return SkG;
    }
    
    public static String hwv()
    {
      return SkJ;
    }
    
    public static String hww()
    {
      return SkK;
    }
    
    public static String hwx()
    {
      return SkL;
    }
    
    public static String hwy()
    {
      return SkM;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    public static final d SkN;
    private static final String SkO;
    private static final String SkP;
    private static final String SkQ;
    private static final String SkR;
    private static final String SkS;
    private static final String SkT;
    private static final String SkU;
    
    static
    {
      AppMethodBeat.i(118775);
      SkN = new d();
      SkO = ".StoryObject.id";
      SkP = ".StoryObject.username";
      SkQ = ".StoryObject.createTime";
      SkR = ".StoryObject.contentDesc";
      SkS = ".StoryObject.location";
      SkT = ".StoryObject.ContentObject";
      SkU = ".StoryObject.scope";
      AppMethodBeat.o(118775);
    }
    
    public static String hwA()
    {
      return SkP;
    }
    
    public static String hwB()
    {
      return SkQ;
    }
    
    public static String hwC()
    {
      return SkT;
    }
    
    public static String hwD()
    {
      return SkU;
    }
    
    public static String hwz()
    {
      return SkO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.p
 * JD-Core Version:    0.7.0.1
 */