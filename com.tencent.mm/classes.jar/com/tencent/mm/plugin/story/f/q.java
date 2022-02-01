package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"})
public final class q
{
  private static final String TAG = "MicroMsg.StoryTimelineHelper";
  public static final a zsy;
  
  static
  {
    AppMethodBeat.i(118776);
    zsy = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineHelper";
    AppMethodBeat.o(118776);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"})
  public static final class a
  {
    private static String Dr(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static dep a(dep paramdep)
    {
      AppMethodBeat.i(118769);
      cna localcna = new cna();
      localcna.Eht = 0.0F;
      localcna.Ehu = 0.0F;
      localcna.iJV = "";
      localcna.Fgn = 0;
      localcna.EFm = "";
      localcna.yAX = 0;
      localcna.yAV = "";
      localcna.gPy = "";
      localcna.Fgo = 1;
      localcna.Fgq = "";
      localcna.country = "";
      paramdep.FOb = localcna;
      AppMethodBeat.o(118769);
      return paramdep;
    }
    
    private static dep a(Map<String, String> paramMap, dep paramdep)
    {
      AppMethodBeat.i(118770);
      if (paramdep.FOc == null) {
        paramdep.FOc = new ddp();
      }
      paramdep.FOc.Title = Dr((String)paramMap.get("contTitle"));
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
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        str8 = q.c.dWb();
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        str2 = q.c.dWc();
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        str4 = q.c.dWd();
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        str7 = q.c.dWe();
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        str6 = q.c.dWg();
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        str5 = q.c.dWf();
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        str3 = q.c.dWh();
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        str1 = q.c.dWi();
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        localObject3 = q.c.dWj();
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject1 = new StringBuilder();
        localObject2 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject2 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject2 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject2 = q.c.zsR;
        localObject2 = q.c.dWk();
        localObject1 = new StringBuilder();
        localObject4 = q.d.zsZ;
        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
        localObject4 = q.b.zsA;
        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
        localObject4 = q.c.zsR;
        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa()).append(i);
        localObject4 = q.c.zsR;
        localObject1 = q.c.dWl();
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
                        return paramdep;
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        str8 = q.c.dWb();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        str2 = q.c.dWc();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        str4 = q.c.dWd();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        str7 = q.c.dWe();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        str6 = q.c.dWg();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        str5 = q.c.dWf();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        str3 = q.c.dWh();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        str1 = q.c.dWi();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        localObject3 = q.c.dWj();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject2 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject2 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject2 = q.c.zsR;
                        localObject2 = q.c.dWk();
                        localObject1 = new StringBuilder();
                        localObject4 = q.d.zsZ;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.dWp());
                        localObject4 = q.b.zsA;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.dVZ());
                        localObject4 = q.c.zsR;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.dWa());
                        localObject4 = q.c.zsR;
                        localObject1 = q.c.dWl();
                        break label943;
                      }
                      localObject3 = new ddy();
                      ((ddy)localObject3).Id = Dr(str8);
                      ((ddy)localObject3).ndI = bs.getInt(str2, 0);
                      ((ddy)localObject3).Url = Dr(str4);
                      ((ddy)localObject3).EUH = bs.getInt(str5, 0);
                      ((ddy)localObject3).Fjh = Dr(str6);
                      ((ddy)localObject3).Fji = bs.getInt(str3, 0);
                      ((ddy)localObject3).subType = bs.getInt(str1, 0);
                      ((ddy)localObject3).md5 = Dr((String)localObject2);
                      ((ddy)localObject3).FjC = Dr(str7);
                      if (localObject1 == null) {}
                      for (float f = 0.0F;; f = bs.getFloat((String)localObject1, 0.0F))
                      {
                        ((ddy)localObject3).FNF = f;
                        paramdep.FOc.Etz.add(localObject3);
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
    
    public static dep awJ(String paramString)
    {
      AppMethodBeat.i(118772);
      k.h(paramString, "xml");
      paramString = bv.L(paramString, "StoryObject");
      if (paramString != null)
      {
        dep localdep = dVY();
        q.d locald = q.d.zsZ;
        localdep.Id = Dr((String)paramString.get(q.d.dWm()));
        locald = q.d.zsZ;
        localdep.ncR = Dr((String)paramString.get(q.d.dWn()));
        locald = q.d.zsZ;
        localdep.CreateTime = bs.getInt((String)paramString.get(q.d.dWo()), 0);
        locald = q.d.zsZ;
        localdep.FOe = bs.getInt((String)paramString.get(q.d.dWq()), 0);
        paramString = a(paramString, a(localdep));
        AppMethodBeat.o(118772);
        return paramString;
      }
      AppMethodBeat.o(118772);
      return null;
    }
    
    public static dep dVY()
    {
      AppMethodBeat.i(118771);
      dep localdep = new dep();
      ddp localddp = new ddp();
      cna localcna = new cna();
      localcna.Ehu = 0.0F;
      localcna.Eht = 0.0F;
      localdep.FOb = localcna;
      localdep.FOc = localddp;
      localdep.Id = "";
      localdep.CreateTime = 0;
      AppMethodBeat.o(118771);
      return localdep;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$MediaObjTAG;", "", "()V", "XML_DESC", "", "getXML_DESC", "()Ljava/lang/String;", "XML_DURATION", "getXML_DURATION", "XML_PRIVATED", "getXML_PRIVATED", "XML_SIZE", "getXML_SIZE", "XML_SUBTYPE", "getXML_SUBTYPE", "XML_TAG", "getXML_TAG", "XML_THUMB", "getXML_THUMB", "XML_THUMBTYPE", "getXML_THUMBTYPE", "XML_TITLE", "getXML_TITLE", "XML_TYPE", "getXML_TYPE", "XML_URL", "getXML_URL", "XML_URLTYPE", "getXML_URLTYPE", "XML_URL_MD5", "getXML_URL_MD5", "XML_USERDATA", "getXML_USERDATA", "XML_VIDEOMD5", "getXML_VIDEOMD5", "XML_id", "getXML_id", "plugin-story_release"})
  public static final class c
  {
    private static final String zsB = ".media";
    private static final String zsC = ".id";
    private static final String zsD = ".type";
    private static final String zsE = ".title";
    private static final String zsF = ".description";
    private static final String zsG = ".url";
    private static final String zsH = ".url.$videomd5";
    private static final String zsI = ".url.$type";
    private static final String zsJ = ".thumb";
    private static final String zsK = ".thumb.$type";
    private static final String zsL = ".private";
    private static final String zsM = ".size";
    private static final String zsN = ".subType";
    private static final String zsO = ".userData";
    private static final String zsP = ".url.$md5";
    private static final String zsQ = ".duration";
    public static final c zsR;
    
    static
    {
      AppMethodBeat.i(118774);
      zsR = new c();
      zsB = ".media";
      zsC = ".id";
      zsD = ".type";
      zsE = ".title";
      zsF = ".description";
      zsG = ".url";
      zsH = ".url.$videomd5";
      zsI = ".url.$type";
      zsJ = ".thumb";
      zsK = ".thumb.$type";
      zsL = ".private";
      zsM = ".size";
      zsN = ".subType";
      zsO = ".userData";
      zsP = ".url.$md5";
      zsQ = ".duration";
      AppMethodBeat.o(118774);
    }
    
    public static String dWa()
    {
      return zsB;
    }
    
    public static String dWb()
    {
      return zsC;
    }
    
    public static String dWc()
    {
      return zsD;
    }
    
    public static String dWd()
    {
      return zsG;
    }
    
    public static String dWe()
    {
      return zsH;
    }
    
    public static String dWf()
    {
      return zsI;
    }
    
    public static String dWg()
    {
      return zsJ;
    }
    
    public static String dWh()
    {
      return zsK;
    }
    
    public static String dWi()
    {
      return zsN;
    }
    
    public static String dWj()
    {
      return zsO;
    }
    
    public static String dWk()
    {
      return zsP;
    }
    
    public static String dWl()
    {
      return zsQ;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"})
  public static final class d
  {
    private static final String zsS = ".StoryObject.id";
    private static final String zsT = ".StoryObject.username";
    private static final String zsU = ".StoryObject.createTime";
    private static final String zsV = ".StoryObject.contentDesc";
    private static final String zsW = ".StoryObject.location";
    private static final String zsX = ".StoryObject.ContentObject";
    private static final String zsY = ".StoryObject.scope";
    public static final d zsZ;
    
    static
    {
      AppMethodBeat.i(118775);
      zsZ = new d();
      zsS = ".StoryObject.id";
      zsT = ".StoryObject.username";
      zsU = ".StoryObject.createTime";
      zsV = ".StoryObject.contentDesc";
      zsW = ".StoryObject.location";
      zsX = ".StoryObject.ContentObject";
      zsY = ".StoryObject.scope";
      AppMethodBeat.o(118775);
    }
    
    public static String dWm()
    {
      return zsS;
    }
    
    public static String dWn()
    {
      return zsT;
    }
    
    public static String dWo()
    {
      return zsU;
    }
    
    public static String dWp()
    {
      return zsX;
    }
    
    public static String dWq()
    {
      return zsY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.q
 * JD-Core Version:    0.7.0.1
 */