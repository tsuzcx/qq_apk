package com.tencent.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.b.b;
import com.tencent.thumbplayer.utils.a;
import java.util.ArrayList;

public final class p
{
  public String LZm;
  public ArrayList<b> LZn;
  private a LZo;
  public long bbs;
  public long bbt;
  public int videoCodecId;
  
  private p(a parama)
  {
    this.bbs = parama.bbs;
    this.bbt = parama.bbt;
    this.videoCodecId = parama.videoCodecId;
    this.LZm = parama.LZm;
    this.LZn = parama.LZn;
    this.LZo = parama;
  }
  
  public static final class a
  {
    String LZm;
    ArrayList<b> LZn;
    long bbs;
    long bbt;
    int videoCodecId;
    
    public final a a(b paramb)
    {
      AppMethodBeat.i(191859);
      if (a.isEmpty(this.LZn)) {
        this.LZn = new ArrayList();
      }
      for (;;)
      {
        this.LZn.add(paramb);
        AppMethodBeat.o(191859);
        return this;
        this.LZn.clear();
      }
    }
    
    public final a aZJ(String paramString)
    {
      this.LZm = paramString;
      return this;
    }
    
    public final p fWy()
    {
      AppMethodBeat.i(191860);
      p localp = new p(this, (byte)0);
      AppMethodBeat.o(191860);
      return localp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.b.p
 * JD-Core Version:    0.7.0.1
 */