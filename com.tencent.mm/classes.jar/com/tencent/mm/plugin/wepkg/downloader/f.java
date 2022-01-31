package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  String hyD;
  public int kYE;
  int lCJ;
  String mFilePath;
  public long mStartTime;
  public String mUrl;
  a vFA;
  public String vFB;
  String vFr;
  public String vFs;
  String vFt;
  public String vFu;
  public long vFv;
  boolean vFw;
  int vFx;
  int vFy;
  boolean vFz;
  
  public f(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong, String paramString8, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(63448);
    this.vFr = paramString1;
    this.kYE = paramInt;
    this.vFs = paramString2;
    this.vFt = paramString3;
    this.vFu = paramString4;
    this.mUrl = paramString6;
    this.mFilePath = paramString7;
    this.vFv = paramLong;
    this.hyD = paramString8;
    this.vFw = paramBoolean;
    this.vFA = parama;
    this.vFx = 20000;
    this.vFy = 20000;
    this.lCJ = 3;
    this.vFz = true;
    this.mStartTime = System.currentTimeMillis();
    this.vFB = paramString5;
    AppMethodBeat.o(63448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.f
 * JD-Core Version:    0.7.0.1
 */