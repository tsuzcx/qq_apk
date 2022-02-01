package com.tencent.tmediacodec.b;

import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.g.b;
import com.tencent.tmediacodec.g.d;
import java.util.ArrayList;

public final class e
{
  private boolean Sly;
  public ArrayList<byte[]> Slz;
  private String bdn;
  public final String bdq;
  public int bdr;
  public int bdv;
  public int channelCount;
  public int height;
  public int maxHeight;
  public int maxWidth;
  public int sampleRate;
  private boolean tkD;
  public int width;
  
  private e(String paramString)
  {
    AppMethodBeat.i(190114);
    this.bdn = "";
    this.Slz = new ArrayList();
    this.width = -1;
    this.height = -1;
    this.maxWidth = -1;
    this.maxHeight = -1;
    this.bdr = -1;
    this.bdq = paramString;
    AppMethodBeat.o(190114);
  }
  
  private static String E(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190118);
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
    AppMethodBeat.o(190118);
    return paramString;
  }
  
  private static int a(MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(190119);
    if (paramMediaFormat.containsKey(paramString))
    {
      int i = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(190119);
      return i;
    }
    AppMethodBeat.o(190119);
    return -1;
  }
  
  public static void bA(ArrayList<byte[]> paramArrayList)
  {
    AppMethodBeat.i(190117);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(190117);
      return;
    }
    if (b.isLogEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append(E(d.Sna[i], (byte[])paramArrayList.get(i)));
        localStringBuilder.append("\n");
        i += 1;
      }
      new StringBuilder("csdData size:").append(paramArrayList.size()).append("    ").append(localStringBuilder.toString());
      b.bqQ("FormatWrapper");
    }
    AppMethodBeat.o(190117);
  }
  
  public static e i(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(190116);
    e locale = new e(paramMediaFormat.getString("mime"));
    try
    {
      locale.sampleRate = a(paramMediaFormat, "sample-rate");
      locale.bdr = a(paramMediaFormat, "max-input-size");
      locale.Slz = d.j(paramMediaFormat);
      if (locale.cWJ())
      {
        locale.bdv = a(paramMediaFormat, "rotation-degrees");
        locale.width = a(paramMediaFormat, "width");
        locale.height = a(paramMediaFormat, "height");
        if (Build.VERSION.SDK_INT >= 19)
        {
          locale.maxWidth = a(paramMediaFormat, "max-width");
          locale.maxHeight = a(paramMediaFormat, "max-height");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(190116);
        return locale;
        locale.channelCount = a(paramMediaFormat, "channel-count");
      }
    }
    catch (Throwable paramMediaFormat)
    {
      for (;;)
      {
        b.bqV("FormatWrapper");
      }
    }
  }
  
  public final boolean cWJ()
  {
    AppMethodBeat.i(190115);
    if (!this.Sly)
    {
      this.Sly = true;
      this.tkD = d.by(this.bdq);
    }
    boolean bool = this.tkD;
    AppMethodBeat.o(190115);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.b.e
 * JD-Core Version:    0.7.0.1
 */