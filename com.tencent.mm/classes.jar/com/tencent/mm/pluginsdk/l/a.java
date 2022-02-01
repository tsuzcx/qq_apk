package com.tencent.mm.pluginsdk.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  public static int waK = 480;
  public static int waL = 640;
  public int dHi;
  public int fps;
  public int hKI;
  public int ruC;
  public int ruD;
  public int waM;
  public int waN;
  public int waO;
  public int waP;
  public int waQ;
  public String waR;
  public String waS;
  public String waT;
  public String waU;
  public String waV;
  public int waW;
  public int waX;
  
  public static a feW()
  {
    AppMethodBeat.i(31163);
    a locala = new a();
    locala.fps = 30;
    locala.dHi = 0;
    locala.waN = 640;
    locala.waO = 480;
    locala.ruD = 640;
    locala.ruC = 480;
    locala.waM = 1440000;
    locala.waP = 1;
    locala.waQ = 4;
    locala.waR = "/sdcard/1.yuv";
    locala.waV = "/sdcard/1.mp4";
    locala.waS = "/sdcard/1.pcm";
    locala.waU = "/sdcard/1.x264";
    locala.waW = 0;
    locala.hKI = 0;
    locala.waX = 0;
    AppMethodBeat.o(31163);
    return locala;
  }
  
  public static a feX()
  {
    AppMethodBeat.i(31164);
    a locala = new a();
    locala.fps = 30;
    locala.dHi = 0;
    locala.waN = waL;
    locala.waO = waK;
    locala.ruD = waL;
    locala.ruC = waK;
    locala.waM = 327680;
    locala.waP = 4;
    locala.waQ = 1;
    locala.waR = "/sdcard/2.yuv";
    locala.waV = "/sdcard/2.mp4";
    locala.waS = "/sdcard/2.pcm";
    locala.waU = "/sdcard/2.x264";
    locala.waW = 0;
    locala.hKI = 0;
    locala.waX = 0;
    AppMethodBeat.o(31164);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(31162);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.ruC).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.ruD).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.waM).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.dHi).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.waO).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.waN).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.waP).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.waQ).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.waR).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.waS).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.waT).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.waU).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.waV).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.waW).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.hKI).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.waX).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(31162);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.a
 * JD-Core Version:    0.7.0.1
 */