package com.tencent.tmediacodec.b;

import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.g.b;
import com.tencent.tmediacodec.g.d;
import java.util.ArrayList;

public final class e
{
  private boolean AnF;
  public int Gj;
  private boolean ahTk;
  public ArrayList<byte[]> ahTl;
  private String cGK;
  public final String cGN;
  public int cGO;
  public int channelCount;
  public int height;
  public int maxHeight;
  public int maxWidth;
  public int sampleRate;
  public int width;
  
  private e(String paramString)
  {
    AppMethodBeat.i(210791);
    this.cGK = "";
    this.ahTl = new ArrayList();
    this.width = -1;
    this.height = -1;
    this.maxWidth = -1;
    this.maxHeight = -1;
    this.cGO = -1;
    this.cGN = paramString;
    AppMethodBeat.o(210791);
  }
  
  private static String M(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210809);
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
    AppMethodBeat.o(210809);
    return paramString;
  }
  
  public static void cl(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(210804);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(210804);
      return;
    }
    if (b.isLogEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append(M(d.ahUM[i], (byte[])paramArrayList.get(i)));
        localStringBuilder.append("\n");
        i += 1;
      }
      new StringBuilder("csdData size:").append(paramArrayList.size()).append("    ").append(localStringBuilder.toString());
      b.O("FormatWrapper");
    }
    AppMethodBeat.o(210804);
  }
  
  private static int d(MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(210816);
    if (paramMediaFormat.containsKey(paramString))
    {
      int i = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(210816);
      return i;
    }
    AppMethodBeat.o(210816);
    return -1;
  }
  
  public static e g(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(210801);
    e locale = new e(paramMediaFormat.getString("mime"));
    try
    {
      locale.sampleRate = d(paramMediaFormat, "sample-rate");
      locale.cGO = d(paramMediaFormat, "max-input-size");
      locale.ahTl = d.h(paramMediaFormat);
      if (locale.dSH())
      {
        locale.Gj = d(paramMediaFormat, "rotation-degrees");
        locale.width = d(paramMediaFormat, "width");
        locale.height = d(paramMediaFormat, "height");
        if (Build.VERSION.SDK_INT >= 19)
        {
          locale.maxWidth = d(paramMediaFormat, "max-width");
          locale.maxHeight = d(paramMediaFormat, "max-height");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(210801);
        return locale;
        locale.channelCount = d(paramMediaFormat, "channel-count");
      }
    }
    finally
    {
      for (;;)
      {
        b.U("FormatWrapper");
      }
    }
  }
  
  public final boolean dSH()
  {
    AppMethodBeat.i(210823);
    if (!this.ahTk)
    {
      this.ahTk = true;
      this.AnF = d.isVideo(this.cGN);
    }
    boolean bool = this.AnF;
    AppMethodBeat.o(210823);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.e
 * JD-Core Version:    0.7.0.1
 */