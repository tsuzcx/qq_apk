package com.tencent.mm.plugin.textstatus.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Random;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusPostUtil;", "", "()V", "TAG", "", "topicPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getTopicPattern", "()Ljava/util/regex/Pattern;", "getBackgroundNameById", "id", "", "getBackgroundeResIdByName", "name", "getDefaultEditBackground", "getDefaultEditBackgroundId", "printTextStatusPostInfo", "info", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k TBx;
  private static final Pattern TBy;
  
  static
  {
    AppMethodBeat.i(290414);
    TBx = new k();
    TBy = Pattern.compile(ac.hGa());
    AppMethodBeat.o(290414);
  }
  
  public static String aoC(int paramInt)
  {
    if (paramInt == a.d.TbK) {
      return "text_state_default_image_1";
    }
    if (paramInt == a.d.TbO) {
      return "text_state_default_image_2";
    }
    if (paramInt == a.d.TbP) {
      return "text_state_default_image_3";
    }
    if (paramInt == a.d.TbQ) {
      return "text_state_default_image_4";
    }
    if (paramInt == a.d.TbR) {
      return "text_state_default_image_5";
    }
    if (paramInt == a.d.TbS) {
      return "text_state_default_image_6";
    }
    if (paramInt == a.d.TbT) {
      return "text_state_default_image_7";
    }
    if (paramInt == a.d.TbU) {
      return "text_state_default_image_8";
    }
    if (paramInt == a.d.TbV) {
      return "text_state_default_image_9";
    }
    if (paramInt == a.d.TbL) {
      return "text_state_default_image_10";
    }
    if ((paramInt != a.d.TbM) && (paramInt == a.d.TbN)) {
      return "text_state_default_image_12";
    }
    return "text_state_default_image_11";
  }
  
  public static int bep(String paramString)
  {
    AppMethodBeat.i(290405);
    if (paramString != null) {
      switch (paramString.hashCode())
      {
      }
    }
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
                            i = a.d.TbM;
                            AppMethodBeat.o(290405);
                            return i;
                          } while (!paramString.equals("text_state_default_image_1"));
                          i = a.d.TbK;
                          AppMethodBeat.o(290405);
                          return i;
                        } while (!paramString.equals("text_state_default_image_10"));
                        i = a.d.TbL;
                        AppMethodBeat.o(290405);
                        return i;
                      } while (!paramString.equals("text_state_default_image_12"));
                      i = a.d.TbN;
                      AppMethodBeat.o(290405);
                      return i;
                    } while (!paramString.equals("text_state_default_image_11"));
                    i = a.d.TbM;
                    AppMethodBeat.o(290405);
                    return i;
                  } while (!paramString.equals("text_state_default_image_5"));
                  i = a.d.TbR;
                  AppMethodBeat.o(290405);
                  return i;
                } while (!paramString.equals("text_state_default_image_4"));
                i = a.d.TbQ;
                AppMethodBeat.o(290405);
                return i;
              } while (!paramString.equals("text_state_default_image_3"));
              i = a.d.TbP;
              AppMethodBeat.o(290405);
              return i;
            } while (!paramString.equals("text_state_default_image_2"));
            i = a.d.TbO;
            AppMethodBeat.o(290405);
            return i;
          } while (!paramString.equals("text_state_default_image_9"));
          i = a.d.TbV;
          AppMethodBeat.o(290405);
          return i;
        } while (!paramString.equals("text_state_default_image_8"));
        i = a.d.TbU;
        AppMethodBeat.o(290405);
        return i;
      } while (!paramString.equals("text_state_default_image_7"));
      i = a.d.TbT;
      AppMethodBeat.o(290405);
      return i;
    } while (!paramString.equals("text_state_default_image_6"));
    int i = a.d.TbS;
    AppMethodBeat.o(290405);
    return i;
  }
  
  public static int hKA()
  {
    AppMethodBeat.i(290389);
    h.baC();
    int i = b.getUin();
    int j = (int)(System.currentTimeMillis() % 12L);
    i = (new Random(i).nextInt(12) + j) % 12;
    Log.i("MicroMsg.TextStatus.TextStatusPostUtil", s.X("getDefaultEditBackground :", Integer.valueOf(i)));
    switch (i)
    {
    default: 
      i = a.d.TbM;
      AppMethodBeat.o(290389);
      return i;
    case 1: 
      i = a.d.TbK;
      AppMethodBeat.o(290389);
      return i;
    case 2: 
      i = a.d.TbO;
      AppMethodBeat.o(290389);
      return i;
    case 3: 
      i = a.d.TbP;
      AppMethodBeat.o(290389);
      return i;
    case 4: 
      i = a.d.TbQ;
      AppMethodBeat.o(290389);
      return i;
    case 5: 
      i = a.d.TbR;
      AppMethodBeat.o(290389);
      return i;
    case 6: 
      i = a.d.TbS;
      AppMethodBeat.o(290389);
      return i;
    case 7: 
      i = a.d.TbT;
      AppMethodBeat.o(290389);
      return i;
    case 8: 
      i = a.d.TbU;
      AppMethodBeat.o(290389);
      return i;
    case 9: 
      i = a.d.TbV;
      AppMethodBeat.o(290389);
      return i;
    case 10: 
      i = a.d.TbL;
      AppMethodBeat.o(290389);
      return i;
    case 11: 
      i = a.d.TbM;
      AppMethodBeat.o(290389);
      return i;
    }
    i = a.d.TbN;
    AppMethodBeat.o(290389);
    return i;
  }
  
  public static Pattern hKz()
  {
    return TBy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.k
 * JD-Core Version:    0.7.0.1
 */