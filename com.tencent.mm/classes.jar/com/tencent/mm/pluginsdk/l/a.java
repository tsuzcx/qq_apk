package com.tencent.mm.pluginsdk.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  public static int zuP = 480;
  public static int zuQ = 640;
  public int dYT;
  public int fps;
  public int iFw;
  public int ifN;
  public int ifO;
  public int sUA;
  public int sUz;
  public int zuR;
  public int zuS;
  public int zuT;
  public String zuU;
  public String zuV;
  public String zuW;
  public String zuX;
  public String zuY;
  public int zuZ;
  public int zva;
  
  public static a gog()
  {
    AppMethodBeat.i(31163);
    a locala = new a();
    locala.fps = 30;
    locala.dYT = 0;
    locala.ifO = 640;
    locala.ifN = 480;
    locala.sUA = 640;
    locala.sUz = 480;
    locala.zuR = 1440000;
    locala.zuS = 1;
    locala.zuT = 4;
    locala.zuU = "/sdcard/1.yuv";
    locala.zuY = "/sdcard/1.mp4";
    locala.zuV = "/sdcard/1.pcm";
    locala.zuX = "/sdcard/1.x264";
    locala.zuZ = 0;
    locala.iFw = 0;
    locala.zva = 0;
    AppMethodBeat.o(31163);
    return locala;
  }
  
  public static a goh()
  {
    AppMethodBeat.i(31164);
    a locala = new a();
    locala.fps = 30;
    locala.dYT = 0;
    locala.ifO = zuQ;
    locala.ifN = zuP;
    locala.sUA = zuQ;
    locala.sUz = zuP;
    locala.zuR = 327680;
    locala.zuS = 4;
    locala.zuT = 1;
    locala.zuU = "/sdcard/2.yuv";
    locala.zuY = "/sdcard/2.mp4";
    locala.zuV = "/sdcard/2.pcm";
    locala.zuX = "/sdcard/2.x264";
    locala.zuZ = 0;
    locala.iFw = 0;
    locala.zva = 0;
    AppMethodBeat.o(31164);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(31162);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.sUz).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.sUA).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.zuR).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.dYT).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.ifN).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.ifO).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.zuS).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.zuT).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.zuU).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.zuV).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.zuW).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.zuX).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.zuY).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.zuZ).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.iFw).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.zva).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(31162);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.a
 * JD-Core Version:    0.7.0.1
 */