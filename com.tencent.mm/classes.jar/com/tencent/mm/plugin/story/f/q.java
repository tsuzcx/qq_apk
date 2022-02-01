package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"})
public final class q
{
  public static final a FmO;
  private static final String TAG = "MicroMsg.StoryTimelineHelper";
  
  static
  {
    AppMethodBeat.i(118776);
    FmO = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineHelper";
    AppMethodBeat.o(118776);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"})
  public static final class a
  {
    private static String PL(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static eek a(eek parameek)
    {
      AppMethodBeat.i(118769);
      dlg localdlg = new dlg();
      localdlg.LbC = 0.0F;
      localdlg.LbD = 0.0F;
      localdlg.kea = "";
      localdlg.Mpu = 0;
      localdlg.LIb = "";
      localdlg.Esb = 0;
      localdlg.ErZ = "";
      localdlg.kHV = "";
      localdlg.Mpv = 1;
      localdlg.Mpx = "";
      localdlg.country = "";
      parameek.NeA = localdlg;
      AppMethodBeat.o(118769);
      return parameek;
    }
    
    private static eek a(Map<String, String> paramMap, eek parameek)
    {
      AppMethodBeat.i(118770);
      if (parameek.NeB == null) {
        parameek.NeB = new edk();
      }
      parameek.NeB.Title = PL((String)paramMap.get("contTitle"));
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
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        str8 = q.c.foA();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        str2 = q.c.foB();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        str4 = q.c.foC();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        str7 = q.c.foD();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        str6 = q.c.foF();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        str5 = q.c.foE();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        str3 = q.c.foG();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        str1 = q.c.foH();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        localObject3 = q.c.foI();
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject1 = new StringBuilder();
        localObject2 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject2 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject2 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject2 = q.c.Fnh;
        localObject2 = q.c.foJ();
        localObject1 = new StringBuilder();
        localObject4 = q.d.Fnp;
        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
        localObject4 = q.b.FmQ;
        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
        localObject4 = q.c.Fnh;
        localObject1 = ((StringBuilder)localObject1).append(q.c.foz()).append(i);
        localObject4 = q.c.Fnh;
        localObject1 = q.c.foK();
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
                        return parameek;
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        str8 = q.c.foA();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        str2 = q.c.foB();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        str4 = q.c.foC();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        str7 = q.c.foD();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        str6 = q.c.foF();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        str5 = q.c.foE();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        str3 = q.c.foG();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        str1 = q.c.foH();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        localObject3 = q.c.foI();
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        ((StringBuilder)localObject1).append(q.c.foz());
                        localObject1 = new StringBuilder();
                        localObject2 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject2 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject2 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject2 = q.c.Fnh;
                        localObject2 = q.c.foJ();
                        localObject1 = new StringBuilder();
                        localObject4 = q.d.Fnp;
                        localObject1 = ((StringBuilder)localObject1).append(q.d.foO());
                        localObject4 = q.b.FmQ;
                        localObject1 = ((StringBuilder)localObject1).append(q.b.foy());
                        localObject4 = q.c.Fnh;
                        localObject1 = ((StringBuilder)localObject1).append(q.c.foz());
                        localObject4 = q.c.Fnh;
                        localObject1 = q.c.foK();
                        break label943;
                      }
                      localObject3 = new edt();
                      ((edt)localObject3).Id = PL(str8);
                      ((edt)localObject3).oUv = Util.getInt(str2, 0);
                      ((edt)localObject3).Url = PL(str4);
                      ((edt)localObject3).Mcw = Util.getInt(str5, 0);
                      ((edt)localObject3).Msz = PL(str6);
                      ((edt)localObject3).MsA = Util.getInt(str3, 0);
                      ((edt)localObject3).subType = Util.getInt(str1, 0);
                      ((edt)localObject3).md5 = PL((String)localObject2);
                      ((edt)localObject3).MsS = PL(str7);
                      if (localObject1 == null) {}
                      for (float f = 0.0F;; f = Util.getFloat((String)localObject1, 0.0F))
                      {
                        ((edt)localObject3).Ned = f;
                        parameek.NeB.LoV.add(localObject3);
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
    
    public static eek aSb(String paramString)
    {
      AppMethodBeat.i(118772);
      p.h(paramString, "xml");
      paramString = XmlParser.parseXml(paramString, "StoryObject", null);
      if (paramString != null)
      {
        eek localeek = fox();
        q.d locald = q.d.Fnp;
        localeek.Id = PL((String)paramString.get(q.d.foL()));
        locald = q.d.Fnp;
        localeek.UserName = PL((String)paramString.get(q.d.foM()));
        locald = q.d.Fnp;
        localeek.CreateTime = Util.getInt((String)paramString.get(q.d.foN()), 0);
        locald = q.d.Fnp;
        localeek.NeD = Util.getInt((String)paramString.get(q.d.foP()), 0);
        paramString = a(paramString, a(localeek));
        AppMethodBeat.o(118772);
        return paramString;
      }
      AppMethodBeat.o(118772);
      return null;
    }
    
    public static eek fox()
    {
      AppMethodBeat.i(118771);
      eek localeek = new eek();
      edk localedk = new edk();
      dlg localdlg = new dlg();
      localdlg.LbD = 0.0F;
      localdlg.LbC = 0.0F;
      localeek.NeA = localdlg;
      localeek.NeB = localedk;
      localeek.Id = "";
      localeek.CreateTime = 0;
      AppMethodBeat.o(118771);
      return localeek;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$ContentObjTAG;", "", "()V", "XML_MEDIALIST", "", "getXML_MEDIALIST", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class b
  {
    private static final String FmP = ".mediaList";
    public static final b FmQ;
    
    static
    {
      AppMethodBeat.i(118773);
      FmQ = new b();
      FmP = ".mediaList";
      AppMethodBeat.o(118773);
    }
    
    public static String foy()
    {
      return FmP;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$MediaObjTAG;", "", "()V", "XML_DESC", "", "getXML_DESC", "()Ljava/lang/String;", "XML_DURATION", "getXML_DURATION", "XML_PRIVATED", "getXML_PRIVATED", "XML_SIZE", "getXML_SIZE", "XML_SUBTYPE", "getXML_SUBTYPE", "XML_TAG", "getXML_TAG", "XML_THUMB", "getXML_THUMB", "XML_THUMBTYPE", "getXML_THUMBTYPE", "XML_TITLE", "getXML_TITLE", "XML_TYPE", "getXML_TYPE", "XML_URL", "getXML_URL", "XML_URLTYPE", "getXML_URLTYPE", "XML_URL_MD5", "getXML_URL_MD5", "XML_USERDATA", "getXML_USERDATA", "XML_VIDEOMD5", "getXML_VIDEOMD5", "XML_id", "getXML_id", "plugin-story_release"})
  public static final class c
  {
    private static final String FmR = ".media";
    private static final String FmS = ".id";
    private static final String FmT = ".type";
    private static final String FmU = ".title";
    private static final String FmV = ".description";
    private static final String FmW = ".url";
    private static final String FmX = ".url.$videomd5";
    private static final String FmY = ".url.$type";
    private static final String FmZ = ".thumb";
    private static final String Fna = ".thumb.$type";
    private static final String Fnb = ".private";
    private static final String Fnc = ".size";
    private static final String Fnd = ".subType";
    private static final String Fne = ".userData";
    private static final String Fnf = ".url.$md5";
    private static final String Fng = ".duration";
    public static final c Fnh;
    
    static
    {
      AppMethodBeat.i(118774);
      Fnh = new c();
      FmR = ".media";
      FmS = ".id";
      FmT = ".type";
      FmU = ".title";
      FmV = ".description";
      FmW = ".url";
      FmX = ".url.$videomd5";
      FmY = ".url.$type";
      FmZ = ".thumb";
      Fna = ".thumb.$type";
      Fnb = ".private";
      Fnc = ".size";
      Fnd = ".subType";
      Fne = ".userData";
      Fnf = ".url.$md5";
      Fng = ".duration";
      AppMethodBeat.o(118774);
    }
    
    public static String foA()
    {
      return FmS;
    }
    
    public static String foB()
    {
      return FmT;
    }
    
    public static String foC()
    {
      return FmW;
    }
    
    public static String foD()
    {
      return FmX;
    }
    
    public static String foE()
    {
      return FmY;
    }
    
    public static String foF()
    {
      return FmZ;
    }
    
    public static String foG()
    {
      return Fna;
    }
    
    public static String foH()
    {
      return Fnd;
    }
    
    public static String foI()
    {
      return Fne;
    }
    
    public static String foJ()
    {
      return Fnf;
    }
    
    public static String foK()
    {
      return Fng;
    }
    
    public static String foz()
    {
      return FmR;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"})
  public static final class d
  {
    private static final String Fni = ".StoryObject.id";
    private static final String Fnj = ".StoryObject.username";
    private static final String Fnk = ".StoryObject.createTime";
    private static final String Fnl = ".StoryObject.contentDesc";
    private static final String Fnm = ".StoryObject.location";
    private static final String Fnn = ".StoryObject.ContentObject";
    private static final String Fno = ".StoryObject.scope";
    public static final d Fnp;
    
    static
    {
      AppMethodBeat.i(118775);
      Fnp = new d();
      Fni = ".StoryObject.id";
      Fnj = ".StoryObject.username";
      Fnk = ".StoryObject.createTime";
      Fnl = ".StoryObject.contentDesc";
      Fnm = ".StoryObject.location";
      Fnn = ".StoryObject.ContentObject";
      Fno = ".StoryObject.scope";
      AppMethodBeat.o(118775);
    }
    
    public static String foL()
    {
      return Fni;
    }
    
    public static String foM()
    {
      return Fnj;
    }
    
    public static String foN()
    {
      return Fnk;
    }
    
    public static String foO()
    {
      return Fnn;
    }
    
    public static String foP()
    {
      return Fno;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.q
 * JD-Core Version:    0.7.0.1
 */