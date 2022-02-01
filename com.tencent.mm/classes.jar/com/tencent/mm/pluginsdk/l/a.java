package com.tencent.mm.pluginsdk.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  public static int vOH = 480;
  public static int vOI = 640;
  public int dGc;
  public int fps;
  public int hHQ;
  public int rmx;
  public int rmy;
  public int vOJ;
  public int vOK;
  public int vOL;
  public int vOM;
  public int vON;
  public String vOO;
  public String vOP;
  public String vOQ;
  public String vOR;
  public String vOS;
  public int vOT;
  public int vOU;
  
  public static a fbi()
  {
    AppMethodBeat.i(31163);
    a locala = new a();
    locala.fps = 30;
    locala.dGc = 0;
    locala.vOK = 640;
    locala.vOL = 480;
    locala.rmy = 640;
    locala.rmx = 480;
    locala.vOJ = 1440000;
    locala.vOM = 1;
    locala.vON = 4;
    locala.vOO = "/sdcard/1.yuv";
    locala.vOS = "/sdcard/1.mp4";
    locala.vOP = "/sdcard/1.pcm";
    locala.vOR = "/sdcard/1.x264";
    locala.vOT = 0;
    locala.hHQ = 0;
    locala.vOU = 0;
    AppMethodBeat.o(31163);
    return locala;
  }
  
  public static a fbj()
  {
    AppMethodBeat.i(31164);
    a locala = new a();
    locala.fps = 30;
    locala.dGc = 0;
    locala.vOK = vOI;
    locala.vOL = vOH;
    locala.rmy = vOI;
    locala.rmx = vOH;
    locala.vOJ = 327680;
    locala.vOM = 4;
    locala.vON = 1;
    locala.vOO = "/sdcard/2.yuv";
    locala.vOS = "/sdcard/2.mp4";
    locala.vOP = "/sdcard/2.pcm";
    locala.vOR = "/sdcard/2.x264";
    locala.vOT = 0;
    locala.hHQ = 0;
    locala.vOU = 0;
    AppMethodBeat.o(31164);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(31162);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.rmx).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.rmy).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.vOJ).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.dGc).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.vOL).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.vOK).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.vOM).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.vON).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.vOO).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.vOP).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.vOQ).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.vOR).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.vOS).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.vOT).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.hHQ).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.vOU).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(31162);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.a
 * JD-Core Version:    0.7.0.1
 */