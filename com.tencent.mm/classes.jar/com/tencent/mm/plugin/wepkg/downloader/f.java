package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public String IkN;
  String XFp;
  public String XFq;
  String XFr;
  public long XFs;
  boolean XFt;
  int XFu;
  int XFv;
  boolean XFw;
  a XFx;
  public String XFy;
  String mFilePath;
  public long mStartTime;
  public String mUrl;
  String ryW;
  public int xnM;
  int ypf;
  
  public f(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong, String paramString8, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(110619);
    this.XFp = paramString1;
    this.xnM = paramInt;
    this.XFq = paramString2;
    this.XFr = paramString3;
    this.IkN = paramString4;
    this.mUrl = paramString6;
    this.mFilePath = paramString7;
    this.XFs = paramLong;
    this.ryW = paramString8;
    this.XFt = paramBoolean;
    this.XFx = parama;
    this.XFu = 20000;
    this.XFv = 20000;
    this.ypf = 3;
    this.XFw = true;
    this.mStartTime = System.currentTimeMillis();
    this.XFy = paramString5;
    AppMethodBeat.o(110619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.f
 * JD-Core Version:    0.7.0.1
 */