package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class d$d
{
  public static boolean Wn(int paramInt)
  {
    return (paramInt == 19) || (paramInt == 22);
  }
  
  public static int aFG(String paramString)
  {
    AppMethodBeat.i(133668);
    if (paramString == null)
    {
      AppMethodBeat.o(133668);
      return 0;
    }
    if (("EAN-13".equals(paramString)) || ("EAN_13".equals(paramString)))
    {
      AppMethodBeat.o(133668);
      return 4;
    }
    if (("EAN-8".equals(paramString)) || ("EAN_8".equals(paramString)))
    {
      AppMethodBeat.o(133668);
      return 3;
    }
    if ("EAN-2".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 1;
    }
    if ("EAN-5".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 2;
    }
    if (("UPC-A".equals(paramString)) || ("UPC_A".equals(paramString)))
    {
      AppMethodBeat.o(133668);
      return 5;
    }
    if (("UPC-E".equals(paramString)) || ("UPC_E".equals(paramString)))
    {
      AppMethodBeat.o(133668);
      return 6;
    }
    if (("CODE-39".equals(paramString)) || ("CODE_39".equals(paramString)))
    {
      AppMethodBeat.o(133668);
      return 9;
    }
    if (("CODE-93".equals(paramString)) || ("CODE_93".equals(paramString)))
    {
      AppMethodBeat.o(133668);
      return 10;
    }
    if (("CODE-128".equals(paramString)) || ("CODE_128".equals(paramString)))
    {
      AppMethodBeat.o(133668);
      return 11;
    }
    if ("COMPOSITE".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 12;
    }
    if (("I/25".equals(paramString)) || ("ITF".equals(paramString)))
    {
      AppMethodBeat.o(133668);
      return 13;
    }
    if ("DATABAR".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 7;
    }
    if ("DATABAR-EXP".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 8;
    }
    if ("RSS_14".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 15;
    }
    if ("RSS_EXPANDED".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 16;
    }
    if ("MAXICODE".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 18;
    }
    if ("PDF_417".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 20;
    }
    if ("QR_CODE".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 19;
    }
    if ("CODABAR".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 17;
    }
    if ("ISBN10".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 14;
    }
    if ("DATA_MATRIX".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 21;
    }
    if ("WX_CODE".equals(paramString))
    {
      AppMethodBeat.o(133668);
      return 22;
    }
    AppMethodBeat.o(133668);
    return 0;
  }
  
  public static boolean aFH(String paramString)
  {
    AppMethodBeat.i(133669);
    if (((!bs.isNullOrNil(paramString)) && (paramString.equals("QR_CODE"))) || (paramString.equals("WX_CODE")))
    {
      AppMethodBeat.o(133669);
      return true;
    }
    AppMethodBeat.o(133669);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.d
 * JD-Core Version:    0.7.0.1
 */