package com.tencent.mm.plugin.textstatus.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.plugin.textstatus.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Random;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusPostUtil;", "", "()V", "TAG", "", "topicPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getTopicPattern", "()Ljava/util/regex/Pattern;", "getBackgroundNameById", "id", "", "getBackgroundeResIdByName", "name", "getDefaultEditBackground", "getDefaultEditBackgroundId", "printTextStatusPostInfo", "info", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "plugin-textstatus_release"})
public final class m
{
  private static final Pattern MOW;
  public static final m MOX;
  
  static
  {
    AppMethodBeat.i(237266);
    MOX = new m();
    MOW = Pattern.compile(t.glg());
    AppMethodBeat.o(237266);
  }
  
  public static String ajo(int paramInt)
  {
    if (paramInt == b.d.Muz) {
      return "text_state_default_image_1";
    }
    if (paramInt == b.d.MuD) {
      return "text_state_default_image_2";
    }
    if (paramInt == b.d.MuE) {
      return "text_state_default_image_3";
    }
    if (paramInt == b.d.MuF) {
      return "text_state_default_image_4";
    }
    if (paramInt == b.d.MuG) {
      return "text_state_default_image_5";
    }
    if (paramInt == b.d.MuH) {
      return "text_state_default_image_6";
    }
    if (paramInt == b.d.MuI) {
      return "text_state_default_image_7";
    }
    if (paramInt == b.d.MuJ) {
      return "text_state_default_image_8";
    }
    if (paramInt == b.d.MuK) {
      return "text_state_default_image_9";
    }
    if (paramInt == b.d.MuA) {
      return "text_state_default_image_10";
    }
    if ((paramInt != b.d.MuB) && (paramInt == b.d.MuC)) {
      return "text_state_default_image_12";
    }
    return "text_state_default_image_11";
  }
  
  public static int beP(String paramString)
  {
    AppMethodBeat.i(237259);
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
                              i = b.d.MuB;
                              AppMethodBeat.o(237259);
                              return i;
                              switch (paramString.hashCode())
                              {
                              }
                            }
                          } while (!paramString.equals("text_state_default_image_10"));
                          i = b.d.MuA;
                          AppMethodBeat.o(237259);
                          return i;
                        } while (!paramString.equals("text_state_default_image_1"));
                        i = b.d.Muz;
                        AppMethodBeat.o(237259);
                        return i;
                      } while (!paramString.equals("text_state_default_image_12"));
                      i = b.d.MuC;
                      AppMethodBeat.o(237259);
                      return i;
                    } while (!paramString.equals("text_state_default_image_11"));
                    i = b.d.MuB;
                    AppMethodBeat.o(237259);
                    return i;
                  } while (!paramString.equals("text_state_default_image_5"));
                  i = b.d.MuG;
                  AppMethodBeat.o(237259);
                  return i;
                } while (!paramString.equals("text_state_default_image_4"));
                i = b.d.MuF;
                AppMethodBeat.o(237259);
                return i;
              } while (!paramString.equals("text_state_default_image_3"));
              i = b.d.MuE;
              AppMethodBeat.o(237259);
              return i;
            } while (!paramString.equals("text_state_default_image_2"));
            i = b.d.MuD;
            AppMethodBeat.o(237259);
            return i;
          } while (!paramString.equals("text_state_default_image_9"));
          i = b.d.MuK;
          AppMethodBeat.o(237259);
          return i;
        } while (!paramString.equals("text_state_default_image_8"));
        i = b.d.MuJ;
        AppMethodBeat.o(237259);
        return i;
      } while (!paramString.equals("text_state_default_image_7"));
      i = b.d.MuI;
      AppMethodBeat.o(237259);
      return i;
    } while (!paramString.equals("text_state_default_image_6"));
    int i = b.d.MuH;
    AppMethodBeat.o(237259);
    return i;
  }
  
  public static Pattern gnM()
  {
    return MOW;
  }
  
  public static int gnN()
  {
    AppMethodBeat.i(237253);
    p.j(h.aHE(), "MMKernel.account()");
    int i = b.getUin();
    int j = (int)(System.currentTimeMillis() % 12L);
    i = (new Random(i).nextInt(12) + j) % 12;
    Log.i("MicroMsg.TextStatus.TextStatusPostUtil", "getDefaultEditBackground :".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      i = b.d.MuB;
      AppMethodBeat.o(237253);
      return i;
    case 1: 
      i = b.d.Muz;
      AppMethodBeat.o(237253);
      return i;
    case 2: 
      i = b.d.MuD;
      AppMethodBeat.o(237253);
      return i;
    case 3: 
      i = b.d.MuE;
      AppMethodBeat.o(237253);
      return i;
    case 4: 
      i = b.d.MuF;
      AppMethodBeat.o(237253);
      return i;
    case 5: 
      i = b.d.MuG;
      AppMethodBeat.o(237253);
      return i;
    case 6: 
      i = b.d.MuH;
      AppMethodBeat.o(237253);
      return i;
    case 7: 
      i = b.d.MuI;
      AppMethodBeat.o(237253);
      return i;
    case 8: 
      i = b.d.MuJ;
      AppMethodBeat.o(237253);
      return i;
    case 9: 
      i = b.d.MuK;
      AppMethodBeat.o(237253);
      return i;
    case 10: 
      i = b.d.MuA;
      AppMethodBeat.o(237253);
      return i;
    case 11: 
      i = b.d.MuB;
      AppMethodBeat.o(237253);
      return i;
    }
    i = b.d.MuC;
    AppMethodBeat.o(237253);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.m
 * JD-Core Version:    0.7.0.1
 */