package com.tencent.mm.pluginsdk.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  public static int KVY = 480;
  public static int KVZ = 640;
  public int KWa;
  public int KWb;
  public int KWc;
  public String KWd;
  public String KWe;
  public String KWf;
  public String KWg;
  public String KWh;
  public int KWi;
  public int fps;
  public int hYK;
  public int nAg;
  public int nAh;
  public int nvv;
  public int omT;
  public int zWH;
  public int zWI;
  
  public static a iJQ()
  {
    AppMethodBeat.i(31163);
    a locala = new a();
    locala.fps = 30;
    locala.hYK = 0;
    locala.nAh = 640;
    locala.nAg = 480;
    locala.zWI = 640;
    locala.zWH = 480;
    locala.KWa = 1440000;
    locala.KWb = 1;
    locala.KWc = 4;
    locala.KWd = "/sdcard/1.yuv";
    locala.KWh = "/sdcard/1.mp4";
    locala.KWe = "/sdcard/1.pcm";
    locala.KWg = "/sdcard/1.x264";
    locala.KWi = 0;
    locala.omT = 0;
    locala.nvv = 0;
    AppMethodBeat.o(31163);
    return locala;
  }
  
  public static a iJR()
  {
    AppMethodBeat.i(31164);
    a locala = new a();
    locala.fps = 30;
    locala.hYK = 0;
    locala.nAh = KVZ;
    locala.nAg = KVY;
    locala.zWI = KVZ;
    locala.zWH = KVY;
    locala.KWa = 327680;
    locala.KWb = 4;
    locala.KWc = 1;
    locala.KWd = "/sdcard/2.yuv";
    locala.KWh = "/sdcard/2.mp4";
    locala.KWe = "/sdcard/2.pcm";
    locala.KWg = "/sdcard/2.x264";
    locala.KWi = 0;
    locala.omT = 0;
    locala.nvv = 0;
    AppMethodBeat.o(31164);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(31162);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.zWH).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.zWI).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.KWa).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.hYK).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.nAg).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.nAh).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.KWb).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.KWc).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.KWd).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.KWe).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.KWf).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.KWg).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.KWh).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.KWi).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.omT).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.nvv).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(31162);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.a
 * JD-Core Version:    0.7.0.1
 */