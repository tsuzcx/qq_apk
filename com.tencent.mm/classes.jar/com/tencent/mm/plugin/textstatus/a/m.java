package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.a;
import com.tencent.mm.plugin.textstatus.g.r;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends a
{
  private String TAG = "MicroMsg.SetStatusParam";
  
  public m()
  {
    this.Gah = null;
    this.mediaType = 1;
  }
  
  public static final class a
  {
    m FXr;
    
    public a()
    {
      AppMethodBeat.i(222801);
      this.FXr = new m();
      AppMethodBeat.o(222801);
    }
    
    public final a Rj(long paramLong)
    {
      this.FXr.enterTime = paramLong;
      return this;
    }
    
    public final a aSY(String paramString)
    {
      this.FXr.Gae = paramString;
      return this;
    }
    
    public final a aSZ(String paramString)
    {
      this.FXr.FZB = paramString;
      return this;
    }
    
    public final a aTa(String paramString)
    {
      this.FXr.thumbUrl = paramString;
      return this;
    }
    
    public final a aTb(String paramString)
    {
      this.FXr.Gah = paramString;
      return this;
    }
    
    public final a aTc(String paramString)
    {
      this.FXr.Gai = paramString;
      return this;
    }
    
    public final a aTd(String paramString)
    {
      this.FXr.fuN = paramString;
      return this;
    }
    
    public final a aTe(String paramString)
    {
      this.FXr.iFo = paramString;
      return this;
    }
    
    public final a abL(int paramInt)
    {
      this.FXr.Gag = paramInt;
      return this;
    }
    
    public final a fvy()
    {
      this.FXr.Gaf = false;
      return this;
    }
    
    public final m fvz()
    {
      return this.FXr;
    }
    
    public final a hE(List<r> paramList)
    {
      AppMethodBeat.i(222802);
      this.FXr.Gak.clear();
      this.FXr.Gak.addAll(paramList);
      AppMethodBeat.o(222802);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.m
 * JD-Core Version:    0.7.0.1
 */