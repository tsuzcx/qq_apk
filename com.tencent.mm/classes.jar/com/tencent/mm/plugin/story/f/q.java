package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"})
public final class q
{
  private static final String TAG = "MicroMsg.StoryTimelineHelper";
  public static final a yfy;
  
  static
  {
    AppMethodBeat.i(118776);
    yfy = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineHelper";
    AppMethodBeat.o(118776);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"})
  public static final class a
  {
    private static czd a(czd paramczd)
    {
      AppMethodBeat.i(118769);
      chx localchx = new chx();
      localchx.COI = 0.0F;
      localchx.COJ = 0.0F;
      localchx.ijO = "";
      localchx.DJY = 0;
      localchx.DlE = "";
      localchx.xog = 0;
      localchx.xoe = "";
      localchx.goQ = "";
      localchx.DJZ = 1;
      localchx.DKb = "";
      localchx.country = "";
      paramczd.EqZ = localchx;
      AppMethodBeat.o(118769);
      return paramczd;
    }
    
    private static czd a(Map<String, String> paramMap, czd paramczd)
    {
      AppMethodBeat.i(118770);
      if (paramczd.Era == null) {
        paramczd.Era = new cyd();
      }
      paramczd.Era.Title = zm((String)paramMap.get("contTitle"));
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
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        str8 = q.c.dHA();
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        str2 = q.c.dHB();
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        str4 = q.c.dHC();
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        str7 = q.c.dHD();
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        str6 = q.c.dHF();
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        str5 = q.c.dHE();
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        str3 = q.c.dHG();
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        str1 = q.c.dHH();
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        localObject3 = q.c.dHI();
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject1 = new StringBuilder();
        localObject2 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject2 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject2 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject2 = q.c.yfR;
        localObject2 = q.c.dHJ();
        localObject1 = new StringBuilder();
        localObject4 = q.d.yfZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
        localObject4 = q.b.yfA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
        localObject4 = q.c.yfR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz()).append(i);
        localObject4 = q.c.yfR;
        localObject1 = q.c.dHK();
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
                        return paramczd;
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        str8 = q.c.dHA();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        str2 = q.c.dHB();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        str4 = q.c.dHC();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        str7 = q.c.dHD();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        str6 = q.c.dHF();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        str5 = q.c.dHE();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        str3 = q.c.dHG();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        str1 = q.c.dHH();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        localObject3 = q.c.dHI();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject2 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject2 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject2 = q.c.yfR;
                        localObject2 = q.c.dHJ();
                        localObject1 = new StringBuilder();
                        localObject4 = q.d.yfZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dHO());
                        localObject4 = q.b.yfA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dHy());
                        localObject4 = q.c.yfR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dHz());
                        localObject4 = q.c.yfR;
                        localObject1 = q.c.dHK();
                        break label943;
                      }
                      localObject3 = new cym();
                      ((cym)localObject3).Id = zm(str8);
                      ((cym)localObject3).mBH = bt.getInt(str2, 0);
                      ((cym)localObject3).Url = zm(str4);
                      ((cym)localObject3).Dzl = bt.getInt(str5, 0);
                      ((cym)localObject3).DMQ = zm(str6);
                      ((cym)localObject3).DMR = bt.getInt(str3, 0);
                      ((cym)localObject3).subType = bt.getInt(str1, 0);
                      ((cym)localObject3).md5 = zm((String)localObject2);
                      ((cym)localObject3).DNl = zm(str7);
                      if (localObject1 == null) {}
                      for (float f = 0.0F;; f = bt.getFloat((String)localObject1, 0.0F))
                      {
                        ((cym)localObject3).EqD = f;
                        paramczd.Era.DaC.add(localObject3);
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
    
    public static czd arA(String paramString)
    {
      AppMethodBeat.i(118772);
      k.h(paramString, "xml");
      paramString = bw.K(paramString, "StoryObject");
      if (paramString != null)
      {
        czd localczd = dHx();
        q.d locald = q.d.yfZ;
        localczd.Id = zm((String)paramString.get(q.d.dHL()));
        locald = q.d.yfZ;
        localczd.mAQ = zm((String)paramString.get(q.d.dHM()));
        locald = q.d.yfZ;
        localczd.CreateTime = bt.getInt((String)paramString.get(q.d.dHN()), 0);
        locald = q.d.yfZ;
        localczd.Erc = bt.getInt((String)paramString.get(q.d.dHP()), 0);
        paramString = a(paramString, a(localczd));
        AppMethodBeat.o(118772);
        return paramString;
      }
      AppMethodBeat.o(118772);
      return null;
    }
    
    public static czd dHx()
    {
      AppMethodBeat.i(118771);
      czd localczd = new czd();
      cyd localcyd = new cyd();
      chx localchx = new chx();
      localchx.COJ = 0.0F;
      localchx.COI = 0.0F;
      localczd.EqZ = localchx;
      localczd.Era = localcyd;
      localczd.Id = "";
      localczd.CreateTime = 0;
      AppMethodBeat.o(118771);
      return localczd;
    }
    
    private static String zm(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$MediaObjTAG;", "", "()V", "XML_DESC", "", "getXML_DESC", "()Ljava/lang/String;", "XML_DURATION", "getXML_DURATION", "XML_PRIVATED", "getXML_PRIVATED", "XML_SIZE", "getXML_SIZE", "XML_SUBTYPE", "getXML_SUBTYPE", "XML_TAG", "getXML_TAG", "XML_THUMB", "getXML_THUMB", "XML_THUMBTYPE", "getXML_THUMBTYPE", "XML_TITLE", "getXML_TITLE", "XML_TYPE", "getXML_TYPE", "XML_URL", "getXML_URL", "XML_URLTYPE", "getXML_URLTYPE", "XML_URL_MD5", "getXML_URL_MD5", "XML_USERDATA", "getXML_USERDATA", "XML_VIDEOMD5", "getXML_VIDEOMD5", "XML_id", "getXML_id", "plugin-story_release"})
  public static final class c
  {
    private static final String yfB = ".media";
    private static final String yfC = ".id";
    private static final String yfD = ".type";
    private static final String yfE = ".title";
    private static final String yfF = ".description";
    private static final String yfG = ".url";
    private static final String yfH = ".url.$videomd5";
    private static final String yfI = ".url.$type";
    private static final String yfJ = ".thumb";
    private static final String yfK = ".thumb.$type";
    private static final String yfL = ".private";
    private static final String yfM = ".size";
    private static final String yfN = ".subType";
    private static final String yfO = ".userData";
    private static final String yfP = ".url.$md5";
    private static final String yfQ = ".duration";
    public static final c yfR;
    
    static
    {
      AppMethodBeat.i(118774);
      yfR = new c();
      yfB = ".media";
      yfC = ".id";
      yfD = ".type";
      yfE = ".title";
      yfF = ".description";
      yfG = ".url";
      yfH = ".url.$videomd5";
      yfI = ".url.$type";
      yfJ = ".thumb";
      yfK = ".thumb.$type";
      yfL = ".private";
      yfM = ".size";
      yfN = ".subType";
      yfO = ".userData";
      yfP = ".url.$md5";
      yfQ = ".duration";
      AppMethodBeat.o(118774);
    }
    
    public static String dHA()
    {
      return yfC;
    }
    
    public static String dHB()
    {
      return yfD;
    }
    
    public static String dHC()
    {
      return yfG;
    }
    
    public static String dHD()
    {
      return yfH;
    }
    
    public static String dHE()
    {
      return yfI;
    }
    
    public static String dHF()
    {
      return yfJ;
    }
    
    public static String dHG()
    {
      return yfK;
    }
    
    public static String dHH()
    {
      return yfN;
    }
    
    public static String dHI()
    {
      return yfO;
    }
    
    public static String dHJ()
    {
      return yfP;
    }
    
    public static String dHK()
    {
      return yfQ;
    }
    
    public static String dHz()
    {
      return yfB;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"})
  public static final class d
  {
    private static final String yfS = ".StoryObject.id";
    private static final String yfT = ".StoryObject.username";
    private static final String yfU = ".StoryObject.createTime";
    private static final String yfV = ".StoryObject.contentDesc";
    private static final String yfW = ".StoryObject.location";
    private static final String yfX = ".StoryObject.ContentObject";
    private static final String yfY = ".StoryObject.scope";
    public static final d yfZ;
    
    static
    {
      AppMethodBeat.i(118775);
      yfZ = new d();
      yfS = ".StoryObject.id";
      yfT = ".StoryObject.username";
      yfU = ".StoryObject.createTime";
      yfV = ".StoryObject.contentDesc";
      yfW = ".StoryObject.location";
      yfX = ".StoryObject.ContentObject";
      yfY = ".StoryObject.scope";
      AppMethodBeat.o(118775);
    }
    
    public static String dHL()
    {
      return yfS;
    }
    
    public static String dHM()
    {
      return yfT;
    }
    
    public static String dHN()
    {
      return yfU;
    }
    
    public static String dHO()
    {
      return yfX;
    }
    
    public static String dHP()
    {
      return yfY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.q
 * JD-Core Version:    0.7.0.1
 */