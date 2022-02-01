package com.tencent.mm.plugin.textstatus.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import java.util.HashSet;
import java.util.Set;

public final class a
{
  public static Set<String> Mzr;
  public static Set<String> Mzs;
  
  static
  {
    AppMethodBeat.i(243605);
    Mzr = new HashSet() {};
    Mzs = new HashSet() {};
    AppMethodBeat.o(243605);
  }
  
  public static int is(Context paramContext)
  {
    AppMethodBeat.i(243601);
    int i = (int)(ak.kU(paramContext).width * Math.abs(0.7777778F));
    AppMethodBeat.o(243601);
    return i;
  }
  
  public static int[] it(Context paramContext)
  {
    AppMethodBeat.i(243602);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = ak.kU(paramContext).width;
    arrayOfInt[1] = ((int)(arrayOfInt[0] * 1.777778F));
    AppMethodBeat.o(243602);
    return arrayOfInt;
  }
  
  public static int[] iu(Context paramContext)
  {
    AppMethodBeat.i(243603);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = ak.kU(paramContext).width;
    arrayOfInt[1] = ((int)(arrayOfInt[0] * 1.0F));
    AppMethodBeat.o(243603);
    return arrayOfInt;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(243588);
      Mzz = new b("CONVERSATION_LIST", 0);
      MzA = new b("CONTACT_LIST", 1);
      MzB = new b("GROUP_CHAT", 2);
      MzC = new b("SNS_FEED", 3);
      MzD = new b("SNS_COMMENT", 4);
      MzE = new b("SNS_NOTIFICATION", 5);
      MzF = new b("PLANET", 6);
      MzG = new b[] { Mzz, MzA, MzB, MzC, MzD, MzE, MzF };
      AppMethodBeat.o(243588);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.a
 * JD-Core Version:    0.7.0.1
 */