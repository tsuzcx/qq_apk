package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  String QLQ;
  public String QLR;
  String QLS;
  public String QLT;
  public long QLU;
  boolean QLV;
  int QLW;
  int QLX;
  boolean QLY;
  a QLZ;
  public String QMa;
  String mFilePath;
  public long mStartTime;
  public String mUrl;
  String ovC;
  public int uhG;
  int vds;
  
  public f(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong, String paramString8, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(110619);
    this.QLQ = paramString1;
    this.uhG = paramInt;
    this.QLR = paramString2;
    this.QLS = paramString3;
    this.QLT = paramString4;
    this.mUrl = paramString6;
    this.mFilePath = paramString7;
    this.QLU = paramLong;
    this.ovC = paramString8;
    this.QLV = paramBoolean;
    this.QLZ = parama;
    this.QLW = 20000;
    this.QLX = 20000;
    this.vds = 3;
    this.QLY = true;
    this.mStartTime = System.currentTimeMillis();
    this.QMa = paramString5;
    AppMethodBeat.o(110619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.f
 * JD-Core Version:    0.7.0.1
 */