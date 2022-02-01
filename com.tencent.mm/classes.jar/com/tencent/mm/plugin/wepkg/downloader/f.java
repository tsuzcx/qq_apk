package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  String EWG;
  public String EWH;
  String EWI;
  public String EWJ;
  public long EWK;
  boolean EWL;
  int EWM;
  int EWN;
  boolean EWO;
  a EWP;
  public String EWQ;
  String kwh;
  String mFilePath;
  public long mStartTime;
  public String mUrl;
  public int ptc;
  int qgQ;
  
  public f(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong, String paramString8, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(110619);
    this.EWG = paramString1;
    this.ptc = paramInt;
    this.EWH = paramString2;
    this.EWI = paramString3;
    this.EWJ = paramString4;
    this.mUrl = paramString6;
    this.mFilePath = paramString7;
    this.EWK = paramLong;
    this.kwh = paramString8;
    this.EWL = paramBoolean;
    this.EWP = parama;
    this.EWM = 20000;
    this.EWN = 20000;
    this.qgQ = 3;
    this.EWO = true;
    this.mStartTime = System.currentTimeMillis();
    this.EWQ = paramString5;
    AppMethodBeat.o(110619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.f
 * JD-Core Version:    0.7.0.1
 */