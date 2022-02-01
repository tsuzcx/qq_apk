package com.tencent.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class p
{
  public String Kfs;
  public ArrayList<com.tencent.thumbplayer.b.b.b> Kft;
  private a Kfu;
  public long aQX;
  public long aQY;
  public int videoCodecId;
  
  private p(a parama)
  {
    this.aQX = parama.aQX;
    this.aQY = parama.aQY;
    this.videoCodecId = parama.videoCodecId;
    this.Kfs = parama.Kfs;
    this.Kft = parama.Kft;
    this.Kfu = parama;
  }
  
  public static final class a
  {
    String Kfs;
    ArrayList<com.tencent.thumbplayer.b.b.b> Kft;
    long aQX;
    long aQY;
    int videoCodecId;
    
    public final a a(com.tencent.thumbplayer.b.b.b paramb)
    {
      AppMethodBeat.i(187838);
      if (com.tencent.thumbplayer.utils.b.isEmpty(this.Kft)) {
        this.Kft = new ArrayList();
      }
      for (;;)
      {
        this.Kft.add(paramb);
        AppMethodBeat.o(187838);
        return this;
        this.Kft.clear();
      }
    }
    
    public final a aTJ(String paramString)
    {
      this.Kfs = paramString;
      return this;
    }
    
    public final p fFh()
    {
      AppMethodBeat.i(187839);
      p localp = new p(this, (byte)0);
      AppMethodBeat.o(187839);
      return localp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.b.p
 * JD-Core Version:    0.7.0.1
 */