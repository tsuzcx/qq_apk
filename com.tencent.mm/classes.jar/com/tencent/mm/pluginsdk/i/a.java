package com.tencent.mm.pluginsdk.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  public static int oHW = 480;
  public static int oHX = 640;
  public int fXx;
  public int fps;
  public int mnr;
  public int mns;
  public int oHY;
  public int oHZ;
  public int oIa;
  public int oIb;
  public int oIc;
  public String oId;
  public String oIe;
  public String oIf;
  public String oIg;
  public String oIh;
  public int oIi;
  public int oIj;
  public int rotate;
  
  public static a dmF()
  {
    AppMethodBeat.i(27461);
    a locala = new a();
    locala.fps = 30;
    locala.rotate = 0;
    locala.oHZ = 640;
    locala.oIa = 480;
    locala.mns = 640;
    locala.mnr = 480;
    locala.oHY = 1440000;
    locala.oIb = 1;
    locala.oIc = 4;
    locala.oId = "/sdcard/1.yuv";
    locala.oIh = "/sdcard/1.mp4";
    locala.oIe = "/sdcard/1.pcm";
    locala.oIg = "/sdcard/1.x264";
    locala.oIi = 0;
    locala.fXx = 0;
    locala.oIj = 0;
    AppMethodBeat.o(27461);
    return locala;
  }
  
  public static a dmG()
  {
    AppMethodBeat.i(27462);
    a locala = new a();
    locala.fps = 30;
    locala.rotate = 0;
    locala.oHZ = oHX;
    locala.oIa = oHW;
    locala.mns = oHX;
    locala.mnr = oHW;
    locala.oHY = 327680;
    locala.oIb = 4;
    locala.oIc = 1;
    locala.oId = "/sdcard/2.yuv";
    locala.oIh = "/sdcard/2.mp4";
    locala.oIe = "/sdcard/2.pcm";
    locala.oIg = "/sdcard/2.x264";
    locala.oIi = 0;
    locala.fXx = 0;
    locala.oIj = 0;
    AppMethodBeat.o(27462);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(27460);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.mnr).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.mns).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.oHY).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.rotate).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.oIa).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.oHZ).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.oIb).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.oIc).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.oId).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.oIe).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.oIf).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.oIg).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.oIh).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.oIi).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.fXx).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.oIj).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(27460);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.a
 * JD-Core Version:    0.7.0.1
 */