package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"})
public final class q
{
  public static final a LGQ;
  private static final String TAG = "MicroMsg.StoryTimelineHelper";
  
  static
  {
    AppMethodBeat.i(118776);
    LGQ = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineHelper";
    AppMethodBeat.o(118776);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"})
  public static final class a
  {
    private static String Xj(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static eol a(eol parameol)
    {
      AppMethodBeat.i(118769);
      duy localduy = new duy();
      localduy.ScO = 0.0F;
      localduy.ScP = 0.0F;
      localduy.mVA = "";
      localduy.TAz = 0;
      localduy.SOz = "";
      localduy.KFw = 0;
      localduy.KFu = "";
      localduy.poiName = "";
      localduy.TAA = 1;
      localduy.TAC = "";
      localduy.country = "";
      parameol.UqZ = localduy;
      AppMethodBeat.o(118769);
      return parameol;
    }
    
    private static eol a(Map<String, String> paramMap, eol parameol)
    {
      AppMethodBeat.i(118770);
      if (parameol.Ura == null) {
        parameol.Ura = new enl();
      }
      parameol.Ura.fwr = Xj((String)paramMap.get("contTitle"));
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
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        str8 = q.c.gcU();
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        str2 = q.c.gcV();
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        str4 = q.c.gcW();
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        str7 = q.c.gcX();
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        str6 = q.c.gcZ();
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        str5 = q.c.gcY();
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        str3 = q.c.gda();
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        str1 = q.c.gdb();
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        localObject3 = q.c.gdc();
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject1 = new StringBuilder();
        localObject2 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject2 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject2 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject2 = q.c.LHj;
        localObject2 = q.c.gdd();
        localObject1 = new StringBuilder();
        localObject4 = q.d.LHr;
        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
        localObject4 = q.b.LGS;
        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
        localObject4 = q.c.LHj;
        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT()).append(i);
        localObject4 = q.c.LHj;
        localObject1 = q.c.gde();
        label943:
        str8 = (String)paramMap.get(str8);
        str2 = (String)paramMap.get(str2);
        if (str2 != null) {
          break label2199;
        }
        str2 = "";
      }
      label2199:
      for (;;)
      {
        str4 = (String)paramMap.get(str4);
        if (str4 == null) {
          str4 = "";
        }
        for (;;)
        {
          str6 = (String)paramMap.get(str6);
          if (str6 == null) {
            str6 = "";
          }
          for (;;)
          {
            str7 = (String)paramMap.get(str7);
            if (str7 == null) {
              str7 = "";
            }
            for (;;)
            {
              str5 = (String)paramMap.get(str5);
              if (str5 == null) {
                str5 = "";
              }
              for (;;)
              {
                str3 = (String)paramMap.get(str3);
                if (str3 == null) {
                  str3 = "";
                }
                for (;;)
                {
                  str1 = (String)paramMap.get(str1);
                  if (str1 == null) {
                    str1 = "";
                  }
                  for (;;)
                  {
                    paramMap.get(localObject3);
                    localObject2 = (String)paramMap.get(localObject2);
                    if (localObject2 == null) {
                      localObject2 = "";
                    }
                    for (;;)
                    {
                      localObject3 = (String)paramMap.get(localObject1);
                      localObject1 = localObject3;
                      if (localObject3 == null) {
                        localObject1 = "";
                      }
                      if ((str2 == null) || (str8 == null))
                      {
                        AppMethodBeat.o(118770);
                        return parameol;
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        str8 = q.c.gcU();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        str2 = q.c.gcV();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        str4 = q.c.gcW();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        str7 = q.c.gcX();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        str6 = q.c.gcZ();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        str5 = q.c.gcY();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        str3 = q.c.gda();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        str1 = q.c.gdb();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        localObject3 = q.c.gdc();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject2 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject2 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject2 = q.c.LHj;
                        localObject2 = q.c.gdd();
                        localObject1 = new StringBuilder();
                        localObject4 = q.d.LHr;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.gdi());
                        localObject4 = q.b.LGS;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.gcS());
                        localObject4 = q.c.LHj;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.gcT());
                        localObject4 = q.c.LHj;
                        localObject1 = q.c.gde();
                        break label943;
                      }
                      localObject3 = new enu();
                      ((enu)localObject3).Id = Xj(str8);
                      ((enu)localObject3).rWu = Util.getInt(str2, 0);
                      ((enu)localObject3).Url = Xj(str4);
                      ((enu)localObject3).TlV = Util.getInt(str5, 0);
                      ((enu)localObject3).TDF = Xj(str6);
                      ((enu)localObject3).TDG = Util.getInt(str3, 0);
                      ((enu)localObject3).subType = Util.getInt(str1, 0);
                      ((enu)localObject3).md5 = Xj((String)localObject2);
                      ((enu)localObject3).TDY = Xj(str7);
                      if (localObject1 == null) {}
                      for (float f = 0.0F;; f = Util.getFloat((String)localObject1, 0.0F))
                      {
                        ((enu)localObject3).UqC = f;
                        parameol.Ura.Sqr.add(localObject3);
                        i += 1;
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public static eol bdf(String paramString)
    {
      AppMethodBeat.i(118772);
      p.k(paramString, "xml");
      paramString = XmlParser.parseXml(paramString, "StoryObject", null);
      if (paramString != null)
      {
        eol localeol = gcR();
        q.d locald = q.d.LHr;
        localeol.Id = Xj((String)paramString.get(q.d.gdf()));
        locald = q.d.LHr;
        localeol.UserName = Xj((String)paramString.get(q.d.gdg()));
        locald = q.d.LHr;
        localeol.CreateTime = Util.getInt((String)paramString.get(q.d.gdh()), 0);
        locald = q.d.LHr;
        localeol.Urc = Util.getInt((String)paramString.get(q.d.gdj()), 0);
        paramString = a(paramString, a(localeol));
        AppMethodBeat.o(118772);
        return paramString;
      }
      AppMethodBeat.o(118772);
      return null;
    }
    
    public static eol gcR()
    {
      AppMethodBeat.i(118771);
      eol localeol = new eol();
      enl localenl = new enl();
      duy localduy = new duy();
      localduy.ScP = 0.0F;
      localduy.ScO = 0.0F;
      localeol.UqZ = localduy;
      localeol.Ura = localenl;
      localeol.Id = "";
      localeol.CreateTime = 0;
      AppMethodBeat.o(118771);
      return localeol;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$ContentObjTAG;", "", "()V", "XML_MEDIALIST", "", "getXML_MEDIALIST", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class b
  {
    private static final String LGR = ".mediaList";
    public static final b LGS;
    
    static
    {
      AppMethodBeat.i(118773);
      LGS = new b();
      LGR = ".mediaList";
      AppMethodBeat.o(118773);
    }
    
    public static String gcS()
    {
      return LGR;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$MediaObjTAG;", "", "()V", "XML_DESC", "", "getXML_DESC", "()Ljava/lang/String;", "XML_DURATION", "getXML_DURATION", "XML_PRIVATED", "getXML_PRIVATED", "XML_SIZE", "getXML_SIZE", "XML_SUBTYPE", "getXML_SUBTYPE", "XML_TAG", "getXML_TAG", "XML_THUMB", "getXML_THUMB", "XML_THUMBTYPE", "getXML_THUMBTYPE", "XML_TITLE", "getXML_TITLE", "XML_TYPE", "getXML_TYPE", "XML_URL", "getXML_URL", "XML_URLTYPE", "getXML_URLTYPE", "XML_URL_MD5", "getXML_URL_MD5", "XML_USERDATA", "getXML_USERDATA", "XML_VIDEOMD5", "getXML_VIDEOMD5", "XML_id", "getXML_id", "plugin-story_release"})
  public static final class c
  {
    private static final String LGT = ".media";
    private static final String LGU = ".id";
    private static final String LGV = ".type";
    private static final String LGW = ".title";
    private static final String LGX = ".description";
    private static final String LGY = ".url";
    private static final String LGZ = ".url.$videomd5";
    private static final String LHa = ".url.$type";
    private static final String LHb = ".thumb";
    private static final String LHc = ".thumb.$type";
    private static final String LHd = ".private";
    private static final String LHe = ".size";
    private static final String LHf = ".subType";
    private static final String LHg = ".userData";
    private static final String LHh = ".url.$md5";
    private static final String LHi = ".duration";
    public static final c LHj;
    
    static
    {
      AppMethodBeat.i(118774);
      LHj = new c();
      LGT = ".media";
      LGU = ".id";
      LGV = ".type";
      LGW = ".title";
      LGX = ".description";
      LGY = ".url";
      LGZ = ".url.$videomd5";
      LHa = ".url.$type";
      LHb = ".thumb";
      LHc = ".thumb.$type";
      LHd = ".private";
      LHe = ".size";
      LHf = ".subType";
      LHg = ".userData";
      LHh = ".url.$md5";
      LHi = ".duration";
      AppMethodBeat.o(118774);
    }
    
    public static String gcT()
    {
      return LGT;
    }
    
    public static String gcU()
    {
      return LGU;
    }
    
    public static String gcV()
    {
      return LGV;
    }
    
    public static String gcW()
    {
      return LGY;
    }
    
    public static String gcX()
    {
      return LGZ;
    }
    
    public static String gcY()
    {
      return LHa;
    }
    
    public static String gcZ()
    {
      return LHb;
    }
    
    public static String gda()
    {
      return LHc;
    }
    
    public static String gdb()
    {
      return LHf;
    }
    
    public static String gdc()
    {
      return LHg;
    }
    
    public static String gdd()
    {
      return LHh;
    }
    
    public static String gde()
    {
      return LHi;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"})
  public static final class d
  {
    private static final String LHk = ".StoryObject.id";
    private static final String LHl = ".StoryObject.username";
    private static final String LHm = ".StoryObject.createTime";
    private static final String LHn = ".StoryObject.contentDesc";
    private static final String LHo = ".StoryObject.location";
    private static final String LHp = ".StoryObject.ContentObject";
    private static final String LHq = ".StoryObject.scope";
    public static final d LHr;
    
    static
    {
      AppMethodBeat.i(118775);
      LHr = new d();
      LHk = ".StoryObject.id";
      LHl = ".StoryObject.username";
      LHm = ".StoryObject.createTime";
      LHn = ".StoryObject.contentDesc";
      LHo = ".StoryObject.location";
      LHp = ".StoryObject.ContentObject";
      LHq = ".StoryObject.scope";
      AppMethodBeat.o(118775);
    }
    
    public static String gdf()
    {
      return LHk;
    }
    
    public static String gdg()
    {
      return LHl;
    }
    
    public static String gdh()
    {
      return LHm;
    }
    
    public static String gdi()
    {
      return LHp;
    }
    
    public static String gdj()
    {
      return LHq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.q
 * JD-Core Version:    0.7.0.1
 */