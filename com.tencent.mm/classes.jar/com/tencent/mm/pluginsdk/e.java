package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.List;

public final class e
{
  public static final class c
  {
    public static final HashMap<Integer, Integer> XNC;
    
    static
    {
      AppMethodBeat.i(133667);
      HashMap localHashMap = new HashMap();
      XNC = localHashMap;
      localHashMap.put(Integer.valueOf(22), Integer.valueOf(64));
      XNC.put(Integer.valueOf(9), Integer.valueOf(64));
      XNC.put(Integer.valueOf(3), Integer.valueOf(64));
      XNC.put(Integer.valueOf(23), Integer.valueOf(64));
      XNC.put(Integer.valueOf(25), Integer.valueOf(64));
      XNC.put(Integer.valueOf(13), Integer.valueOf(64));
      XNC.put(Integer.valueOf(29), Integer.valueOf(256));
      XNC.put(Integer.valueOf(34), Integer.valueOf(512));
      XNC.put(Integer.valueOf(6), Integer.valueOf(512));
      XNC.put(Integer.valueOf(35), Integer.valueOf(1024));
      XNC.put(Integer.valueOf(36), Integer.valueOf(4096));
      XNC.put(Integer.valueOf(37), Integer.valueOf(32768));
      XNC.put(Integer.valueOf(38), Integer.valueOf(32768));
      XNC.put(Integer.valueOf(42), Integer.valueOf(131072));
      XNC.put(Integer.valueOf(40), Integer.valueOf(65536));
      XNC.put(Integer.valueOf(41), Integer.valueOf(65536));
      XNC.put(Integer.valueOf(46), Integer.valueOf(262144));
      XNC.put(Integer.valueOf(48), Integer.valueOf(524288));
      XNC.put(Integer.valueOf(51), Integer.valueOf(1048576));
      XNC.put(Integer.valueOf(52), Integer.valueOf(2097152));
      XNC.put(Integer.valueOf(54), Integer.valueOf(4194304));
      XNC.put(Integer.valueOf(56), Integer.valueOf(8388608));
      AppMethodBeat.o(133667);
    }
  }
  
  public static final class d
  {
    public static boolean mr(List<Integer> paramList)
    {
      AppMethodBeat.i(244525);
      if ((paramList != null) && (paramList.contains(Integer.valueOf(22))))
      {
        AppMethodBeat.o(244525);
        return true;
      }
      AppMethodBeat.o(244525);
      return false;
    }
  }
  
  public static final class e
  {
    public static boolean avx(int paramInt)
    {
      return (paramInt == 19) || (paramInt == 22);
    }
    
    public static int boP(String paramString)
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
    
    public static boolean boQ(String paramString)
    {
      AppMethodBeat.i(133669);
      if (((!Util.isNullOrNil(paramString)) && (paramString.equals("QR_CODE"))) || (paramString.equals("WX_CODE")))
      {
        AppMethodBeat.o(133669);
        return true;
      }
      AppMethodBeat.o(133669);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e
 * JD-Core Version:    0.7.0.1
 */