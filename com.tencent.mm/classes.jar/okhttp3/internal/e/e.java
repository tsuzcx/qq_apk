package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.i;
import java.io.IOException;
import okhttp3.internal.c;

public final class e
{
  static final i ajQG;
  private static final String[] ajQH;
  static final String[] ajQI;
  static final String[] ajQJ;
  
  static
  {
    int k = 0;
    AppMethodBeat.i(186958);
    ajQG = i.bKT("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    ajQH = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    ajQI = new String[64];
    ajQJ = new String[256];
    int i = 0;
    while (i < ajQJ.length)
    {
      ajQJ[i] = c.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    ajQI[0] = "";
    ajQI[1] = "END_STREAM";
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 1;
    ajQI[8] = "PADDED";
    i = 0;
    int j;
    while (i <= 0)
    {
      j = arrayOfInt[i];
      ajQI[(j | 0x8)] = (ajQI[j] + "|PADDED");
      i += 1;
    }
    ajQI[4] = "END_HEADERS";
    ajQI[32] = "PRIORITY";
    ajQI[36] = "END_HEADERS|PRIORITY";
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= 3) {
        break;
      }
      int m = new int[] { 4, 32, 36 }[i];
      j = 0;
      while (j <= 0)
      {
        int n = arrayOfInt[j];
        ajQI[(n | m)] = (ajQI[n] + '|' + ajQI[m]);
        ajQI[(n | m | 0x8)] = (ajQI[n] + '|' + ajQI[m] + "|PADDED");
        j += 1;
      }
      i += 1;
    }
    while (j < ajQI.length)
    {
      if (ajQI[j] == null) {
        ajQI[j] = ajQJ[j];
      }
      j += 1;
    }
    AppMethodBeat.o(186958);
  }
  
  static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    AppMethodBeat.i(186929);
    String str2;
    Object localObject;
    if (paramByte1 < ajQH.length)
    {
      str2 = ajQH[paramByte1];
      if (paramByte2 != 0) {
        break label106;
      }
      localObject = "";
      label29:
      if (!paramBoolean) {
        break label271;
      }
    }
    label271:
    for (String str1 = "<<";; str1 = ">>")
    {
      localObject = c.format("%s 0x%08x %5d %-13s %s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, localObject });
      AppMethodBeat.o(186929);
      return localObject;
      str2 = c.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
      break;
      switch (paramByte1)
      {
      case 5: 
      default: 
        label106:
        if (paramByte2 >= ajQI.length) {
          break;
        }
      }
      for (str1 = ajQI[paramByte2];; str1 = ajQJ[paramByte2])
      {
        if ((paramByte1 != 5) || ((paramByte2 & 0x4) == 0)) {
          break label237;
        }
        localObject = str1.replace("HEADERS", "PUSH_PROMISE");
        break;
        if (paramByte2 == 1)
        {
          localObject = "ACK";
          break;
        }
        localObject = ajQJ[paramByte2];
        break;
        localObject = ajQJ[paramByte2];
        break;
      }
      label237:
      localObject = str1;
      if (paramByte1 != 0) {
        break label29;
      }
      localObject = str1;
      if ((paramByte2 & 0x20) == 0) {
        break label29;
      }
      localObject = str1.replace("PRIORITY", "COMPRESSED");
      break label29;
    }
  }
  
  static IllegalArgumentException t(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(186903);
    paramString = new IllegalArgumentException(c.format(paramString, paramVarArgs));
    AppMethodBeat.o(186903);
    throw paramString;
  }
  
  static IOException u(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(186911);
    paramString = new IOException(c.format(paramString, paramVarArgs));
    AppMethodBeat.o(186911);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.e
 * JD-Core Version:    0.7.0.1
 */