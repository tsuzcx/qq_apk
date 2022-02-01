package com.tencent.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.b.b;
import com.tencent.thumbplayer.utils.a;
import java.util.ArrayList;

public final class p
{
  public String Mwh;
  public ArrayList<b> Mwi;
  private a Mwj;
  public long bbs;
  public long bbt;
  public int videoCodecId;
  
  private p(a parama)
  {
    this.bbs = parama.bbs;
    this.bbt = parama.bbt;
    this.videoCodecId = parama.videoCodecId;
    this.Mwh = parama.Mwh;
    this.Mwi = parama.Mwi;
    this.Mwj = parama;
  }
  
  public static final class a
  {
    String Mwh;
    ArrayList<b> Mwi;
    long bbs;
    long bbt;
    int videoCodecId;
    
    public final a a(b paramb)
    {
      AppMethodBeat.i(194537);
      if (a.isEmpty(this.Mwi)) {
        this.Mwi = new ArrayList();
      }
      for (;;)
      {
        this.Mwi.add(paramb);
        AppMethodBeat.o(194537);
        return this;
        this.Mwi.clear();
      }
    }
    
    public final a bbm(String paramString)
    {
      this.Mwh = paramString;
      return this;
    }
    
    public final p gaX()
    {
      AppMethodBeat.i(194538);
      p localp = new p(this, (byte)0);
      AppMethodBeat.o(194538);
      return localp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.thumbplayer.b.p
 * JD-Core Version:    0.7.0.1
 */