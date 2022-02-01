package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"})
public final class q
{
  public static final a AKs;
  private static final String TAG = "MicroMsg.StoryTimelineHelper";
  
  static
  {
    AppMethodBeat.i(118776);
    AKs = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineHelper";
    AppMethodBeat.o(118776);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"})
  public static final class a
  {
    private static String Gw(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static dkc a(dkc paramdkc)
    {
      AppMethodBeat.i(118769);
      csd localcsd = new csd();
      localcsd.FOA = 0.0F;
      localcsd.FOB = 0.0F;
      localcsd.jde = "";
      localcsd.GPP = 0;
      localcsd.Gnu = "";
      localcsd.zSm = 0;
      localcsd.zSk = "";
      localcsd.jDf = "";
      localcsd.GPQ = 1;
      localcsd.GPT = "";
      localcsd.country = "";
      paramdkc.HyM = localcsd;
      AppMethodBeat.o(118769);
      return paramdkc;
    }
    
    private static dkc a(Map<String, String> paramMap, dkc paramdkc)
    {
      AppMethodBeat.i(118770);
      if (paramdkc.HyN == null) {
        paramdkc.HyN = new djc();
      }
      paramdkc.HyN.Title = Gw((String)paramMap.get("contTitle"));
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
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        str8 = q.c.eiq();
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        str2 = q.c.eir();
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        str4 = q.c.eis();
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        str7 = q.c.eit();
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        str6 = q.c.eiv();
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        str5 = q.c.eiu();
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        str3 = q.c.eiw();
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        str1 = q.c.eix();
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        localObject3 = q.c.eiy();
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject1 = new StringBuilder();
        localObject2 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject2 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject2 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject2 = q.c.AKL;
        localObject2 = q.c.eiz();
        localObject1 = new StringBuilder();
        localObject4 = q.d.AKT;
        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
        localObject4 = q.b.AKu;
        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
        localObject4 = q.c.AKL;
        localObject1 = ((StringBuilder)localObject1).append(q.c.eip()).append(i);
        localObject4 = q.c.AKL;
        localObject1 = q.c.eiA();
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
                        return paramdkc;
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        str8 = q.c.eiq();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        str2 = q.c.eir();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        str4 = q.c.eis();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        str7 = q.c.eit();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        str6 = q.c.eiv();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        str5 = q.c.eiu();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        str3 = q.c.eiw();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        str1 = q.c.eix();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        localObject3 = q.c.eiy();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        ((StringBuilder)localObject1).append(q.c.eip());
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject2 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject2 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject2 = q.c.AKL;
                        localObject2 = q.c.eiz();
                        localObject1 = new StringBuilder();
                        localObject4 = q.d.AKT;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.eiE());
                        localObject4 = q.b.AKu;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.eio());
                        localObject4 = q.c.AKL;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.eip());
                        localObject4 = q.c.AKL;
                        localObject1 = q.c.eiA();
                        break label943;
                      }
                      localObject3 = new djl();
                      ((djl)localObject3).Id = Gw(str8);
                      ((djl)localObject3).nEf = bt.getInt(str2, 0);
                      ((djl)localObject3).Url = Gw(str4);
                      ((djl)localObject3).GEe = bt.getInt(str5, 0);
                      ((djl)localObject3).GSI = Gw(str6);
                      ((djl)localObject3).GSJ = bt.getInt(str3, 0);
                      ((djl)localObject3).subType = bt.getInt(str1, 0);
                      ((djl)localObject3).md5 = Gw((String)localObject2);
                      ((djl)localObject3).GTd = Gw(str7);
                      if (localObject1 == null) {}
                      for (float f = 0.0F;; f = bt.getFloat((String)localObject1, 0.0F))
                      {
                        ((djl)localObject3).Hyq = f;
                        paramdkc.HyN.GaQ.add(localObject3);
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
    
    public static dkc aBN(String paramString)
    {
      AppMethodBeat.i(118772);
      p.h(paramString, "xml");
      paramString = bw.M(paramString, "StoryObject");
      if (paramString != null)
      {
        dkc localdkc = ein();
        q.d locald = q.d.AKT;
        localdkc.Id = Gw((String)paramString.get(q.d.eiB()));
        locald = q.d.AKT;
        localdkc.nDo = Gw((String)paramString.get(q.d.eiC()));
        locald = q.d.AKT;
        localdkc.CreateTime = bt.getInt((String)paramString.get(q.d.eiD()), 0);
        locald = q.d.AKT;
        localdkc.HyP = bt.getInt((String)paramString.get(q.d.eiF()), 0);
        paramString = a(paramString, a(localdkc));
        AppMethodBeat.o(118772);
        return paramString;
      }
      AppMethodBeat.o(118772);
      return null;
    }
    
    public static dkc ein()
    {
      AppMethodBeat.i(118771);
      dkc localdkc = new dkc();
      djc localdjc = new djc();
      csd localcsd = new csd();
      localcsd.FOB = 0.0F;
      localcsd.FOA = 0.0F;
      localdkc.HyM = localcsd;
      localdkc.HyN = localdjc;
      localdkc.Id = "";
      localdkc.CreateTime = 0;
      AppMethodBeat.o(118771);
      return localdkc;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$MediaObjTAG;", "", "()V", "XML_DESC", "", "getXML_DESC", "()Ljava/lang/String;", "XML_DURATION", "getXML_DURATION", "XML_PRIVATED", "getXML_PRIVATED", "XML_SIZE", "getXML_SIZE", "XML_SUBTYPE", "getXML_SUBTYPE", "XML_TAG", "getXML_TAG", "XML_THUMB", "getXML_THUMB", "XML_THUMBTYPE", "getXML_THUMBTYPE", "XML_TITLE", "getXML_TITLE", "XML_TYPE", "getXML_TYPE", "XML_URL", "getXML_URL", "XML_URLTYPE", "getXML_URLTYPE", "XML_URL_MD5", "getXML_URL_MD5", "XML_USERDATA", "getXML_USERDATA", "XML_VIDEOMD5", "getXML_VIDEOMD5", "XML_id", "getXML_id", "plugin-story_release"})
  public static final class c
  {
    private static final String AKA = ".url";
    private static final String AKB = ".url.$videomd5";
    private static final String AKC = ".url.$type";
    private static final String AKD = ".thumb";
    private static final String AKE = ".thumb.$type";
    private static final String AKF = ".private";
    private static final String AKG = ".size";
    private static final String AKH = ".subType";
    private static final String AKI = ".userData";
    private static final String AKJ = ".url.$md5";
    private static final String AKK = ".duration";
    public static final c AKL;
    private static final String AKv = ".media";
    private static final String AKw = ".id";
    private static final String AKx = ".type";
    private static final String AKy = ".title";
    private static final String AKz = ".description";
    
    static
    {
      AppMethodBeat.i(118774);
      AKL = new c();
      AKv = ".media";
      AKw = ".id";
      AKx = ".type";
      AKy = ".title";
      AKz = ".description";
      AKA = ".url";
      AKB = ".url.$videomd5";
      AKC = ".url.$type";
      AKD = ".thumb";
      AKE = ".thumb.$type";
      AKF = ".private";
      AKG = ".size";
      AKH = ".subType";
      AKI = ".userData";
      AKJ = ".url.$md5";
      AKK = ".duration";
      AppMethodBeat.o(118774);
    }
    
    public static String eiA()
    {
      return AKK;
    }
    
    public static String eip()
    {
      return AKv;
    }
    
    public static String eiq()
    {
      return AKw;
    }
    
    public static String eir()
    {
      return AKx;
    }
    
    public static String eis()
    {
      return AKA;
    }
    
    public static String eit()
    {
      return AKB;
    }
    
    public static String eiu()
    {
      return AKC;
    }
    
    public static String eiv()
    {
      return AKD;
    }
    
    public static String eiw()
    {
      return AKE;
    }
    
    public static String eix()
    {
      return AKH;
    }
    
    public static String eiy()
    {
      return AKI;
    }
    
    public static String eiz()
    {
      return AKJ;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"})
  public static final class d
  {
    private static final String AKM = ".StoryObject.id";
    private static final String AKN = ".StoryObject.username";
    private static final String AKO = ".StoryObject.createTime";
    private static final String AKP = ".StoryObject.contentDesc";
    private static final String AKQ = ".StoryObject.location";
    private static final String AKR = ".StoryObject.ContentObject";
    private static final String AKS = ".StoryObject.scope";
    public static final d AKT;
    
    static
    {
      AppMethodBeat.i(118775);
      AKT = new d();
      AKM = ".StoryObject.id";
      AKN = ".StoryObject.username";
      AKO = ".StoryObject.createTime";
      AKP = ".StoryObject.contentDesc";
      AKQ = ".StoryObject.location";
      AKR = ".StoryObject.ContentObject";
      AKS = ".StoryObject.scope";
      AppMethodBeat.o(118775);
    }
    
    public static String eiB()
    {
      return AKM;
    }
    
    public static String eiC()
    {
      return AKN;
    }
    
    public static String eiD()
    {
      return AKO;
    }
    
    public static String eiE()
    {
      return AKR;
    }
    
    public static String eiF()
    {
      return AKS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.q
 * JD-Core Version:    0.7.0.1
 */