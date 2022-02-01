package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"})
public final class q
{
  public static final a BbV;
  private static final String TAG = "MicroMsg.StoryTimelineHelper";
  
  static
  {
    AppMethodBeat.i(118776);
    BbV = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineHelper";
    AppMethodBeat.o(118776);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"})
  public static final class a
  {
    private static String GY(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static dkx a(dkx paramdkx)
    {
      AppMethodBeat.i(118769);
      csx localcsx = new csx();
      localcsx.GgZ = 0.0F;
      localcsx.Gha = 0.0F;
      localcsx.jfX = "";
      localcsx.Hjr = 0;
      localcsx.GGA = "";
      localcsx.Ajt = 0;
      localcsx.Ajr = "";
      localcsx.jGd = "";
      localcsx.Hjs = 1;
      localcsx.Hju = "";
      localcsx.country = "";
      paramdkx.HSx = localcsx;
      AppMethodBeat.o(118769);
      return paramdkx;
    }
    
    private static dkx a(Map<String, String> paramMap, dkx paramdkx)
    {
      AppMethodBeat.i(118770);
      if (paramdkx.HSy == null) {
        paramdkx.HSy = new djx();
      }
      paramdkx.HSy.Title = GY((String)paramMap.get("contTitle"));
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
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        str8 = q.c.elY();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        str2 = q.c.elZ();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        str4 = q.c.ema();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        str7 = q.c.emb();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        str6 = q.c.emd();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        str5 = q.c.emc();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        str3 = q.c.eme();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        str1 = q.c.emf();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        localObject3 = q.c.emg();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject1 = new StringBuilder();
        localObject2 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject2 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject2 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject2 = q.c.Bco;
        localObject2 = q.c.emh();
        localObject1 = new StringBuilder();
        localObject4 = q.d.Bcw;
        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
        localObject4 = q.b.BbX;
        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
        localObject4 = q.c.Bco;
        localObject1 = ((StringBuilder)localObject1).append(q.c.elX()).append(i);
        localObject4 = q.c.Bco;
        localObject1 = q.c.emi();
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
                        return paramdkx;
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        str8 = q.c.elY();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        str2 = q.c.elZ();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        str4 = q.c.ema();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        str7 = q.c.emb();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        str6 = q.c.emd();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        str5 = q.c.emc();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        str3 = q.c.eme();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        str1 = q.c.emf();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        localObject3 = q.c.emg();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        ((StringBuilder)localObject1).append(q.c.elX());
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject2 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject2 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject2 = q.c.Bco;
                        localObject2 = q.c.emh();
                        localObject1 = new StringBuilder();
                        localObject4 = q.d.Bcw;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.emm());
                        localObject4 = q.b.BbX;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.elW());
                        localObject4 = q.c.Bco;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.elX());
                        localObject4 = q.c.Bco;
                        localObject1 = q.c.emi();
                        break label943;
                      }
                      localObject3 = new dkg();
                      ((dkg)localObject3).Id = GY(str8);
                      ((dkg)localObject3).nJA = bu.getInt(str2, 0);
                      ((dkg)localObject3).Url = GY(str4);
                      ((dkg)localObject3).GXH = bu.getInt(str5, 0);
                      ((dkg)localObject3).Hmj = GY(str6);
                      ((dkg)localObject3).Hmk = bu.getInt(str3, 0);
                      ((dkg)localObject3).subType = bu.getInt(str1, 0);
                      ((dkg)localObject3).md5 = GY((String)localObject2);
                      ((dkg)localObject3).HmE = GY(str7);
                      if (localObject1 == null) {}
                      for (float f = 0.0F;; f = bu.getFloat((String)localObject1, 0.0F))
                      {
                        ((dkg)localObject3).HSb = f;
                        paramdkx.HSy.Gtx.add(localObject3);
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
    
    public static dkx aDg(String paramString)
    {
      AppMethodBeat.i(118772);
      p.h(paramString, "xml");
      paramString = bx.M(paramString, "StoryObject");
      if (paramString != null)
      {
        dkx localdkx = elV();
        q.d locald = q.d.Bcw;
        localdkx.Id = GY((String)paramString.get(q.d.emj()));
        locald = q.d.Bcw;
        localdkx.nIJ = GY((String)paramString.get(q.d.emk()));
        locald = q.d.Bcw;
        localdkx.CreateTime = bu.getInt((String)paramString.get(q.d.eml()), 0);
        locald = q.d.Bcw;
        localdkx.HSA = bu.getInt((String)paramString.get(q.d.emn()), 0);
        paramString = a(paramString, a(localdkx));
        AppMethodBeat.o(118772);
        return paramString;
      }
      AppMethodBeat.o(118772);
      return null;
    }
    
    public static dkx elV()
    {
      AppMethodBeat.i(118771);
      dkx localdkx = new dkx();
      djx localdjx = new djx();
      csx localcsx = new csx();
      localcsx.Gha = 0.0F;
      localcsx.GgZ = 0.0F;
      localdkx.HSx = localcsx;
      localdkx.HSy = localdjx;
      localdkx.Id = "";
      localdkx.CreateTime = 0;
      AppMethodBeat.o(118771);
      return localdkx;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$MediaObjTAG;", "", "()V", "XML_DESC", "", "getXML_DESC", "()Ljava/lang/String;", "XML_DURATION", "getXML_DURATION", "XML_PRIVATED", "getXML_PRIVATED", "XML_SIZE", "getXML_SIZE", "XML_SUBTYPE", "getXML_SUBTYPE", "XML_TAG", "getXML_TAG", "XML_THUMB", "getXML_THUMB", "XML_THUMBTYPE", "getXML_THUMBTYPE", "XML_TITLE", "getXML_TITLE", "XML_TYPE", "getXML_TYPE", "XML_URL", "getXML_URL", "XML_URLTYPE", "getXML_URLTYPE", "XML_URL_MD5", "getXML_URL_MD5", "XML_USERDATA", "getXML_USERDATA", "XML_VIDEOMD5", "getXML_VIDEOMD5", "XML_id", "getXML_id", "plugin-story_release"})
  public static final class c
  {
    private static final String BbY = ".media";
    private static final String BbZ = ".id";
    private static final String Bca = ".type";
    private static final String Bcb = ".title";
    private static final String Bcc = ".description";
    private static final String Bcd = ".url";
    private static final String Bce = ".url.$videomd5";
    private static final String Bcf = ".url.$type";
    private static final String Bcg = ".thumb";
    private static final String Bch = ".thumb.$type";
    private static final String Bci = ".private";
    private static final String Bcj = ".size";
    private static final String Bck = ".subType";
    private static final String Bcl = ".userData";
    private static final String Bcm = ".url.$md5";
    private static final String Bcn = ".duration";
    public static final c Bco;
    
    static
    {
      AppMethodBeat.i(118774);
      Bco = new c();
      BbY = ".media";
      BbZ = ".id";
      Bca = ".type";
      Bcb = ".title";
      Bcc = ".description";
      Bcd = ".url";
      Bce = ".url.$videomd5";
      Bcf = ".url.$type";
      Bcg = ".thumb";
      Bch = ".thumb.$type";
      Bci = ".private";
      Bcj = ".size";
      Bck = ".subType";
      Bcl = ".userData";
      Bcm = ".url.$md5";
      Bcn = ".duration";
      AppMethodBeat.o(118774);
    }
    
    public static String elX()
    {
      return BbY;
    }
    
    public static String elY()
    {
      return BbZ;
    }
    
    public static String elZ()
    {
      return Bca;
    }
    
    public static String ema()
    {
      return Bcd;
    }
    
    public static String emb()
    {
      return Bce;
    }
    
    public static String emc()
    {
      return Bcf;
    }
    
    public static String emd()
    {
      return Bcg;
    }
    
    public static String eme()
    {
      return Bch;
    }
    
    public static String emf()
    {
      return Bck;
    }
    
    public static String emg()
    {
      return Bcl;
    }
    
    public static String emh()
    {
      return Bcm;
    }
    
    public static String emi()
    {
      return Bcn;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"})
  public static final class d
  {
    private static final String Bcp = ".StoryObject.id";
    private static final String Bcq = ".StoryObject.username";
    private static final String Bcr = ".StoryObject.createTime";
    private static final String Bcs = ".StoryObject.contentDesc";
    private static final String Bct = ".StoryObject.location";
    private static final String Bcu = ".StoryObject.ContentObject";
    private static final String Bcv = ".StoryObject.scope";
    public static final d Bcw;
    
    static
    {
      AppMethodBeat.i(118775);
      Bcw = new d();
      Bcp = ".StoryObject.id";
      Bcq = ".StoryObject.username";
      Bcr = ".StoryObject.createTime";
      Bcs = ".StoryObject.contentDesc";
      Bct = ".StoryObject.location";
      Bcu = ".StoryObject.ContentObject";
      Bcv = ".StoryObject.scope";
      AppMethodBeat.o(118775);
    }
    
    public static String emj()
    {
      return Bcp;
    }
    
    public static String emk()
    {
      return Bcq;
    }
    
    public static String eml()
    {
      return Bcr;
    }
    
    public static String emm()
    {
      return Bcu;
    }
    
    public static String emn()
    {
      return Bcv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.q
 * JD-Core Version:    0.7.0.1
 */