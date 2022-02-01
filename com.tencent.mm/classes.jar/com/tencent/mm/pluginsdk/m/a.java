package com.tencent.mm.pluginsdk.m;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  public static int Fao = 480;
  public static int Fap = 640;
  public int Faq;
  public int Far;
  public int Fas;
  public String Fat;
  public String Fau;
  public String Fav;
  public String Faw;
  public String Fax;
  public int Fay;
  public int Faz;
  public int fSM;
  public int fps;
  public int kUB;
  public int kUC;
  public int lvw;
  public int wAw;
  public int wAx;
  
  public static a hiQ()
  {
    AppMethodBeat.i(31163);
    a locala = new a();
    locala.fps = 30;
    locala.fSM = 0;
    locala.kUC = 640;
    locala.kUB = 480;
    locala.wAx = 640;
    locala.wAw = 480;
    locala.Faq = 1440000;
    locala.Far = 1;
    locala.Fas = 4;
    locala.Fat = "/sdcard/1.yuv";
    locala.Fax = "/sdcard/1.mp4";
    locala.Fau = "/sdcard/1.pcm";
    locala.Faw = "/sdcard/1.x264";
    locala.Fay = 0;
    locala.lvw = 0;
    locala.Faz = 0;
    AppMethodBeat.o(31163);
    return locala;
  }
  
  public static a hiR()
  {
    AppMethodBeat.i(31164);
    a locala = new a();
    locala.fps = 30;
    locala.fSM = 0;
    locala.kUC = Fap;
    locala.kUB = Fao;
    locala.wAx = Fap;
    locala.wAw = Fao;
    locala.Faq = 327680;
    locala.Far = 4;
    locala.Fas = 1;
    locala.Fat = "/sdcard/2.yuv";
    locala.Fax = "/sdcard/2.mp4";
    locala.Fau = "/sdcard/2.pcm";
    locala.Faw = "/sdcard/2.x264";
    locala.Fay = 0;
    locala.lvw = 0;
    locala.Faz = 0;
    AppMethodBeat.o(31164);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(31162);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.wAw).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.wAx).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.Faq).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.fSM).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.kUB).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.kUC).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.Far).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.Fas).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.Fat).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.Fau).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.Fav).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.Faw).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.Fax).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.Fay).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.lvw).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.Faz).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(31162);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.m.a
 * JD-Core Version:    0.7.0.1
 */