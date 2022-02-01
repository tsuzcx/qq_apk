package com.tencent.mm.pluginsdk.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  public static int uLB = 480;
  public static int uLC = 640;
  public int duc;
  public int fps;
  public int hpy;
  public int qCH;
  public int qCI;
  public int uLD;
  public int uLE;
  public int uLF;
  public int uLG;
  public int uLH;
  public String uLI;
  public String uLJ;
  public String uLK;
  public String uLL;
  public String uLM;
  public int uLN;
  public int uLO;
  
  public static a eMl()
  {
    AppMethodBeat.i(31163);
    a locala = new a();
    locala.fps = 30;
    locala.duc = 0;
    locala.uLE = 640;
    locala.uLF = 480;
    locala.qCI = 640;
    locala.qCH = 480;
    locala.uLD = 1440000;
    locala.uLG = 1;
    locala.uLH = 4;
    locala.uLI = "/sdcard/1.yuv";
    locala.uLM = "/sdcard/1.mp4";
    locala.uLJ = "/sdcard/1.pcm";
    locala.uLL = "/sdcard/1.x264";
    locala.uLN = 0;
    locala.hpy = 0;
    locala.uLO = 0;
    AppMethodBeat.o(31163);
    return locala;
  }
  
  public static a eMm()
  {
    AppMethodBeat.i(31164);
    a locala = new a();
    locala.fps = 30;
    locala.duc = 0;
    locala.uLE = uLC;
    locala.uLF = uLB;
    locala.qCI = uLC;
    locala.qCH = uLB;
    locala.uLD = 327680;
    locala.uLG = 4;
    locala.uLH = 1;
    locala.uLI = "/sdcard/2.yuv";
    locala.uLM = "/sdcard/2.mp4";
    locala.uLJ = "/sdcard/2.pcm";
    locala.uLL = "/sdcard/2.x264";
    locala.uLN = 0;
    locala.hpy = 0;
    locala.uLO = 0;
    AppMethodBeat.o(31164);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(31162);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.qCH).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.qCI).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.uLD).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.duc).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.uLF).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.uLE).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.uLG).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.uLH).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.uLI).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.uLJ).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.uLK).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.uLL).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.uLM).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.uLN).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.hpy).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.uLO).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(31162);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a
 * JD-Core Version:    0.7.0.1
 */