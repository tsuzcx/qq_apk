package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"})
public final class q$a
{
  private static cic a(cic paramcic)
  {
    AppMethodBeat.i(109146);
    chj localchj = new chj();
    localchj.wDh = 0.0F;
    localchj.wDi = 0.0F;
    localchj.gwR = "";
    localchj.xpP = 0;
    localchj.xpN = "";
    localchj.rIg = 0;
    localchj.rIe = "";
    localchj.eSM = "";
    localchj.xpQ = 1;
    localchj.xpS = "";
    localchj.country = "";
    paramcic.xSJ = localchj;
    AppMethodBeat.o(109146);
    return paramcic;
  }
  
  private static cic a(Map<String, String> paramMap, cic paramcic)
  {
    AppMethodBeat.i(109147);
    if (paramcic.xSK == null) {
      paramcic.xSK = new chb();
    }
    paramcic.xSK.Title = uz((String)paramMap.get("contTitle"));
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
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      str8 = q.c.cBb();
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      str2 = q.c.cBc();
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      str4 = q.c.cBd();
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      str7 = q.c.cBe();
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      str6 = q.c.cBg();
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      str5 = q.c.cBf();
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      str3 = q.c.cBh();
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      str1 = q.c.cBi();
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      localObject3 = q.c.cBj();
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject1 = new StringBuilder();
      localObject2 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject2 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject2 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject2 = q.c.svS;
      localObject2 = q.c.cBk();
      localObject1 = new StringBuilder();
      localObject4 = q.d.swa;
      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
      localObject4 = q.b.svB;
      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
      localObject4 = q.c.svS;
      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa()).append(i);
      localObject4 = q.c.svS;
      localObject1 = q.c.cBl();
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
                      AppMethodBeat.o(109147);
                      return paramcic;
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      str8 = q.c.cBb();
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      str2 = q.c.cBc();
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      str4 = q.c.cBd();
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      str7 = q.c.cBe();
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      str6 = q.c.cBg();
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      str5 = q.c.cBf();
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      str3 = q.c.cBh();
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      str1 = q.c.cBi();
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      localObject3 = q.c.cBj();
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject1 = new StringBuilder();
                      localObject2 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject2 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject2 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject2 = q.c.svS;
                      localObject2 = q.c.cBk();
                      localObject1 = new StringBuilder();
                      localObject4 = q.d.swa;
                      localObject1 = ((StringBuilder)localObject1).append(q.d.cBp());
                      localObject4 = q.b.svB;
                      localObject1 = ((StringBuilder)localObject1).append(q.b.cAZ());
                      localObject4 = q.c.svS;
                      localObject1 = ((StringBuilder)localObject1).append(q.c.cBa());
                      localObject4 = q.c.svS;
                      localObject1 = q.c.cBl();
                      break label943;
                    }
                    localObject3 = new chl();
                    ((chl)localObject3).Id = uz(str8);
                    ((chl)localObject3).jKs = bo.getInt(str2, 0);
                    ((chl)localObject3).Url = uz(str4);
                    ((chl)localObject3).xrR = bo.getInt(str5, 0);
                    ((chl)localObject3).xrS = uz(str6);
                    ((chl)localObject3).xrT = bo.getInt(str3, 0);
                    ((chl)localObject3).subType = bo.getInt(str1, 0);
                    ((chl)localObject3).cqq = uz((String)localObject2);
                    ((chl)localObject3).xsn = uz(str7);
                    if (localObject1 == null) {}
                    for (float f = 0.0F;; f = bo.getFloat((String)localObject1, 0.0F))
                    {
                      ((chl)localObject3).duration = f;
                      paramcic.xSK.wOa.add(localObject3);
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
  
  public static cic adi(String paramString)
  {
    AppMethodBeat.i(109149);
    j.q(paramString, "xml");
    paramString = br.F(paramString, "StoryObject");
    if (paramString != null)
    {
      cic localcic = cAY();
      q.d locald = q.d.swa;
      localcic.Id = uz((String)paramString.get(q.d.cBm()));
      locald = q.d.swa;
      localcic.jJA = uz((String)paramString.get(q.d.cBn()));
      locald = q.d.swa;
      localcic.CreateTime = bo.getInt((String)paramString.get(q.d.cBo()), 0);
      locald = q.d.swa;
      localcic.xSM = bo.getInt((String)paramString.get(q.d.cBq()), 0);
      paramString = a(paramString, a(localcic));
      AppMethodBeat.o(109149);
      return paramString;
    }
    AppMethodBeat.o(109149);
    return null;
  }
  
  public static cic cAY()
  {
    AppMethodBeat.i(109148);
    cic localcic = new cic();
    chb localchb = new chb();
    chj localchj = new chj();
    localchj.wDi = 0.0F;
    localchj.wDh = 0.0F;
    localcic.xSJ = localchj;
    localcic.xSK = localchb;
    localcic.Id = "";
    localcic.CreateTime = 0;
    AppMethodBeat.o(109148);
    return localcic;
  }
  
  private static String uz(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.q.a
 * JD-Core Version:    0.7.0.1
 */