package com.tencent.mm.plugin.textstatus.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Random;
import java.util.regex.Pattern;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusPostUtil;", "", "()V", "TAG", "", "topicPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getTopicPattern", "()Ljava/util/regex/Pattern;", "getBackgroundNameById", "id", "", "getBackgroundNameByName", "name", "getDefaultEditBackground", "getDefaultEditBackgroundId", "printTextStatusPostInfo", "info", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "plugin-textstatus_release"})
public final class e
{
  private static final Pattern Ggi;
  public static final e Ggj;
  
  static
  {
    AppMethodBeat.i(216700);
    Ggj = new e();
    Ggi = Pattern.compile(com.tencent.mm.plugin.textstatus.a.p.fvG());
    AppMethodBeat.o(216700);
  }
  
  public static int aTr(String paramString)
  {
    AppMethodBeat.i(216699);
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            for (;;)
                            {
                              AppMethodBeat.o(216699);
                              return 2131235263;
                              switch (paramString.hashCode())
                              {
                              }
                            }
                          } while (!paramString.equals("text_state_default_image_10"));
                          AppMethodBeat.o(216699);
                          return 2131235262;
                        } while (!paramString.equals("text_state_default_image_1"));
                        AppMethodBeat.o(216699);
                        return 2131235261;
                      } while (!paramString.equals("text_state_default_image_12"));
                      AppMethodBeat.o(216699);
                      return 2131235264;
                    } while (!paramString.equals("text_state_default_image_11"));
                    AppMethodBeat.o(216699);
                    return 2131235263;
                  } while (!paramString.equals("text_state_default_image_5"));
                  AppMethodBeat.o(216699);
                  return 2131235268;
                } while (!paramString.equals("text_state_default_image_4"));
                AppMethodBeat.o(216699);
                return 2131235267;
              } while (!paramString.equals("text_state_default_image_3"));
              AppMethodBeat.o(216699);
              return 2131235266;
            } while (!paramString.equals("text_state_default_image_2"));
            AppMethodBeat.o(216699);
            return 2131235265;
          } while (!paramString.equals("text_state_default_image_9"));
          AppMethodBeat.o(216699);
          return 2131235272;
        } while (!paramString.equals("text_state_default_image_8"));
        AppMethodBeat.o(216699);
        return 2131235271;
      } while (!paramString.equals("text_state_default_image_7"));
      AppMethodBeat.o(216699);
      return 2131235270;
    } while (!paramString.equals("text_state_default_image_6"));
    AppMethodBeat.o(216699);
    return 2131235269;
  }
  
  public static String abN(int paramInt)
  {
    if (paramInt == 2131235261) {
      return "text_state_default_image_1";
    }
    if (paramInt == 2131235265) {
      return "text_state_default_image_2";
    }
    if (paramInt == 2131235266) {
      return "text_state_default_image_3";
    }
    if (paramInt == 2131235267) {
      return "text_state_default_image_4";
    }
    if (paramInt == 2131235268) {
      return "text_state_default_image_5";
    }
    if (paramInt == 2131235269) {
      return "text_state_default_image_6";
    }
    if (paramInt == 2131235270) {
      return "text_state_default_image_7";
    }
    if (paramInt == 2131235271) {
      return "text_state_default_image_8";
    }
    if (paramInt == 2131235272) {
      return "text_state_default_image_9";
    }
    if (paramInt == 2131235262) {
      return "text_state_default_image_10";
    }
    if ((paramInt != 2131235263) && (paramInt == 2131235264)) {
      return "text_state_default_image_12";
    }
    return "text_state_default_image_11";
  }
  
  public static String c(v paramv)
  {
    AppMethodBeat.i(258459);
    kotlin.g.b.p.h(paramv, "info");
    Object localObject1 = "";
    Object localObject2 = paramv.GaU;
    if (localObject2 != null)
    {
      String str = "media_type:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).Gat + ",longitude:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).longitude + ",latitude:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).latitude + ",media_url:" + Util.secPrint(((com.tencent.mm.plugin.textstatus.g.g)localObject2).Gav) + ",media_thumb_url:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).Gax + ",visibility:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).visibility + ",create_time:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).Gaz + ",expire_time:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).pRN + ",poi_id:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).GaA + ",option:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).GaB + ",background_id:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).GaC + ",media_width:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).zGN + ",media_height:" + ((com.tencent.mm.plugin.textstatus.g.g)localObject2).zGO;
      localObject2 = ((com.tencent.mm.plugin.textstatus.g.g)localObject2).Gau;
      localObject1 = str;
      if (localObject2 != null) {
        localObject1 = str + ",topic_info:[topic_id:" + ((w)localObject2).GaI + ",source_id:" + ((w)localObject2).Gao + ",activity_id:" + ((w)localObject2).Gap + ",name:" + Util.secPrint(((w)localObject2).Gal) + ",icon:" + Util.secPrint(((w)localObject2).Gam) + ",id:" + ((w)localObject2).Gan + ",topics:" + ((w)localObject2).Gbc.size() + ",verify_info:" + Util.secPrint(((w)localObject2).Gbf) + ",jump_infos:" + ((w)localObject2).Gbe.size() + ']';
      }
    }
    paramv = "TextStatusPostInfo[useDefaultBackground:" + paramv.GaW + ",uploadFilePath:" + paramv.GaX + ",thumbPath:" + paramv.thumbPath + ",excludeUserNames:" + paramv.GaV + ",textStatusExtInfo:[" + (String)localObject1 + "]]";
    AppMethodBeat.o(258459);
    return paramv;
  }
  
  public static Pattern fwK()
  {
    return Ggi;
  }
  
  public static int fwL()
  {
    AppMethodBeat.i(216698);
    kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    int i = a.getUin();
    int j = (int)(System.currentTimeMillis() % 12L);
    i = (new Random(i).nextInt(12) + j) % 12;
    Log.i("MicroMsg.TxtStatus.TextStatusPostUtil", "getDefaultEditBackground :".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      AppMethodBeat.o(216698);
      return 2131235263;
    case 1: 
      AppMethodBeat.o(216698);
      return 2131235261;
    case 2: 
      AppMethodBeat.o(216698);
      return 2131235265;
    case 3: 
      AppMethodBeat.o(216698);
      return 2131235266;
    case 4: 
      AppMethodBeat.o(216698);
      return 2131235267;
    case 5: 
      AppMethodBeat.o(216698);
      return 2131235268;
    case 6: 
      AppMethodBeat.o(216698);
      return 2131235269;
    case 7: 
      AppMethodBeat.o(216698);
      return 2131235270;
    case 8: 
      AppMethodBeat.o(216698);
      return 2131235271;
    case 9: 
      AppMethodBeat.o(216698);
      return 2131235272;
    case 10: 
      AppMethodBeat.o(216698);
      return 2131235262;
    case 11: 
      AppMethodBeat.o(216698);
      return 2131235263;
    }
    AppMethodBeat.o(216698);
    return 2131235264;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.e
 * JD-Core Version:    0.7.0.1
 */