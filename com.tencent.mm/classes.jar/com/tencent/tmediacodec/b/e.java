package com.tencent.tmediacodec.b;

import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.g.b;
import com.tencent.tmediacodec.g.d;
import java.util.ArrayList;

public final class e
{
  private boolean ZOj;
  public ArrayList<byte[]> ZOk;
  private String aMN;
  public final String aMQ;
  public int aMR;
  public int aMV;
  public int channelCount;
  public int height;
  public int maxHeight;
  public int maxWidth;
  public int sampleRate;
  private boolean wRb;
  public int width;
  
  private e(String paramString)
  {
    AppMethodBeat.i(224267);
    this.aMN = "";
    this.ZOk = new ArrayList();
    this.width = -1;
    this.height = -1;
    this.maxWidth = -1;
    this.maxHeight = -1;
    this.aMR = -1;
    this.aMQ = paramString;
    AppMethodBeat.o(224267);
  }
  
  private static String J(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224288);
    paramString = new StringBuilder(paramString);
    paramString.append(", length:");
    paramString.append(paramArrayOfByte.length);
    paramString.append("  [");
    int i = 0;
    while (i < Math.min(paramArrayOfByte.length, 20))
    {
      if (i != 0) {
        paramString.append(" ,");
      }
      paramString.append(paramArrayOfByte[i]);
      i += 1;
    }
    paramString.append("]");
    paramString = paramString.toString();
    AppMethodBeat.o(224288);
    return paramString;
  }
  
  private static int b(MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(224290);
    if (paramMediaFormat.containsKey(paramString))
    {
      int i = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(224290);
      return i;
    }
    AppMethodBeat.o(224290);
    return -1;
  }
  
  public static void bL(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(224286);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(224286);
      return;
    }
    if (b.isLogEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append(J(d.ZPL[i], (byte[])paramArrayList.get(i)));
        localStringBuilder.append("\n");
        i += 1;
      }
      new StringBuilder("csdData size:").append(paramArrayList.size()).append("    ").append(localStringBuilder.toString());
      b.bDP("FormatWrapper");
    }
    AppMethodBeat.o(224286);
  }
  
  public static e g(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(224280);
    e locale = new e(paramMediaFormat.getString("mime"));
    try
    {
      locale.sampleRate = b(paramMediaFormat, "sample-rate");
      locale.aMR = b(paramMediaFormat, "max-input-size");
      locale.ZOk = d.h(paramMediaFormat);
      if (locale.dlR())
      {
        locale.aMV = b(paramMediaFormat, "rotation-degrees");
        locale.width = b(paramMediaFormat, "width");
        locale.height = b(paramMediaFormat, "height");
        if (Build.VERSION.SDK_INT >= 19)
        {
          locale.maxWidth = b(paramMediaFormat, "max-width");
          locale.maxHeight = b(paramMediaFormat, "max-height");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(224280);
        return locale;
        locale.channelCount = b(paramMediaFormat, "channel-count");
      }
    }
    catch (Throwable paramMediaFormat)
    {
      for (;;)
      {
        b.bDU("FormatWrapper");
      }
    }
  }
  
  public final boolean dlR()
  {
    AppMethodBeat.i(224272);
    if (!this.ZOj)
    {
      this.ZOj = true;
      this.wRb = d.bJ(this.aMQ);
    }
    boolean bool = this.wRb;
    AppMethodBeat.o(224272);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.e
 * JD-Core Version:    0.7.0.1
 */