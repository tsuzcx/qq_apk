package com.tencent.mm.pluginsdk.i;

@Deprecated
public final class a
{
  public static int mhQ = 480;
  public static int mhR = 640;
  public int eHH;
  public int fps;
  public int jSV;
  public int jSW;
  public int jlS;
  public int mhS;
  public int mhT;
  public int mhU;
  public int mhV;
  public int mhW;
  public String mhX;
  public String mhY;
  public String mhZ;
  public String mia;
  public String mib;
  public int mic;
  public int rotate;
  
  public static a clR()
  {
    a locala = new a();
    locala.fps = 30;
    locala.rotate = 0;
    locala.mhT = 640;
    locala.mhU = 480;
    locala.jSW = 640;
    locala.jSV = 480;
    locala.mhS = 1440000;
    locala.mhV = 1;
    locala.mhW = 4;
    locala.mhX = "/sdcard/1.yuv";
    locala.mib = "/sdcard/1.mp4";
    locala.mhY = "/sdcard/1.pcm";
    locala.mia = "/sdcard/1.x264";
    locala.mic = 0;
    locala.eHH = 0;
    locala.jlS = 0;
    return locala;
  }
  
  public static a clS()
  {
    a locala = new a();
    locala.fps = 30;
    locala.rotate = 0;
    locala.mhT = mhR;
    locala.mhU = mhQ;
    locala.jSW = mhR;
    locala.jSV = mhQ;
    locala.mhS = 327680;
    locala.mhV = 4;
    locala.mhW = 1;
    locala.mhX = "/sdcard/2.yuv";
    locala.mib = "/sdcard/2.mp4";
    locala.mhY = "/sdcard/2.pcm";
    locala.mia = "/sdcard/2.x264";
    locala.mic = 0;
    locala.eHH = 0;
    locala.jlS = 0;
    return locala;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fps=").append(this.fps).append('\n');
    localStringBuilder.append("width=").append(this.jSV).append('\n');
    localStringBuilder.append("height=").append(this.jSW).append('\n');
    localStringBuilder.append("bitrate=").append(this.mhS).append('\n');
    localStringBuilder.append("rotate=").append(this.rotate).append('\n');
    localStringBuilder.append("yuvWidth=").append(this.mhU).append('\n');
    localStringBuilder.append("yuvHeight=").append(this.mhT).append('\n');
    localStringBuilder.append("x264Speed=").append(this.mhV).append('\n');
    localStringBuilder.append("x264Quality=").append(this.mhW).append('\n');
    localStringBuilder.append("yuvFile=").append(this.mhX).append('\n');
    localStringBuilder.append("pcmFile=").append(this.mhY).append('\n');
    localStringBuilder.append("thuFile=").append(this.mhZ).append('\n');
    localStringBuilder.append("x264File=").append(this.mia).append('\n');
    localStringBuilder.append("mp4File=").append(this.mib).append('\n');
    localStringBuilder.append("videoFrameCnt=").append(this.mic).append('\n');
    localStringBuilder.append("videoLength=").append(this.eHH).append('\n');
    localStringBuilder.append("cameraCount=").append(this.jlS).append('\n');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.a
 * JD-Core Version:    0.7.0.1
 */