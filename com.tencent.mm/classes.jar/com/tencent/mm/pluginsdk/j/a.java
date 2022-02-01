package com.tencent.mm.pluginsdk.j;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  public static int tDe = 480;
  public static int tDf = 640;
  public int dwp;
  public int fps;
  public int gOY;
  public int pUc;
  public int pUd;
  public int tDg;
  public int tDh;
  public int tDi;
  public int tDj;
  public int tDk;
  public String tDl;
  public String tDm;
  public String tDn;
  public String tDo;
  public String tDp;
  public int tDq;
  public int tDr;
  
  public static a ewR()
  {
    AppMethodBeat.i(31163);
    a locala = new a();
    locala.fps = 30;
    locala.dwp = 0;
    locala.tDh = 640;
    locala.tDi = 480;
    locala.pUd = 640;
    locala.pUc = 480;
    locala.tDg = 1440000;
    locala.tDj = 1;
    locala.tDk = 4;
    locala.tDl = "/sdcard/1.yuv";
    locala.tDp = "/sdcard/1.mp4";
    locala.tDm = "/sdcard/1.pcm";
    locala.tDo = "/sdcard/1.x264";
    locala.tDq = 0;
    locala.gOY = 0;
    locala.tDr = 0;
    AppMethodBeat.o(31163);
    return locala;
  }
  
  public static a ewS()
  {
    AppMethodBeat.i(31164);
    a locala = new a();
    locala.fps = 30;
    locala.dwp = 0;
    locala.tDh = tDf;
    locala.tDi = tDe;
    locala.pUd = tDf;
    locala.pUc = tDe;
    locala.tDg = 327680;
    locala.tDj = 4;
    locala.tDk = 1;
    locala.tDl = "/sdcard/2.yuv";
    locala.tDp = "/sdcard/2.mp4";
    locala.tDm = "/sdcard/2.pcm";
    locala.tDo = "/sdcard/2.x264";
    locala.tDq = 0;
    locala.gOY = 0;
    locala.tDr = 0;
    AppMethodBeat.o(31164);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(31162);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.pUc).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.pUd).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.tDg).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.dwp).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.tDi).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.tDh).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.tDj).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.tDk).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.tDl).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.tDm).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.tDn).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.tDo).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.tDp).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.tDq).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.gOY).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.tDr).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(31162);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a
 * JD-Core Version:    0.7.0.1
 */