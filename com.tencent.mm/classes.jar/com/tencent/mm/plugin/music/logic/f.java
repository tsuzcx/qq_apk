package com.tencent.mm.plugin.music.logic;

import com.tencent.mm.sdk.platformtools.Log;
import java.net.URL;
import java.util.List;

public abstract class f
  implements a
{
  protected c LLq;
  protected com.tencent.mm.aw.f tie;
  
  public com.tencent.mm.aw.f S(List<com.tencent.mm.aw.f> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      Log.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
      return null;
    }
    this.tie = ((com.tencent.mm.aw.f)paramList.get(paramInt));
    Log.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
    return this.tie;
  }
  
  public void a(com.tencent.mm.aw.f paramf, int paramInt) {}
  
  public final void a(c paramc)
  {
    this.LLq = paramc;
  }
  
  public URL aOR(String paramString)
  {
    return new URL(paramString);
  }
  
  public boolean adu(int paramInt)
  {
    return false;
  }
  
  public String ajV(String paramString)
  {
    return paramString;
  }
  
  public com.tencent.mm.aw.f gng()
  {
    return this.tie;
  }
  
  public boolean gnh()
  {
    return true;
  }
  
  public boolean i(com.tencent.mm.aw.f paramf)
  {
    this.tie = paramf;
    return true;
  }
  
  public void init() {}
  
  public com.tencent.mm.aw.f j(com.tencent.mm.aw.f paramf)
  {
    return paramf;
  }
  
  public com.tencent.mm.aw.f k(com.tencent.mm.aw.f paramf)
  {
    return paramf;
  }
  
  public void l(com.tencent.mm.aw.f paramf)
  {
    this.tie = paramf;
  }
  
  public void m(com.tencent.mm.aw.f paramf)
  {
    if ((this.tie != null) && (this.tie.f(paramf)))
    {
      com.tencent.mm.aw.f localf = this.tie;
      localf.oOx = paramf.oOx;
      localf.oOy = paramf.oOy;
      localf.oOz = paramf.oOz;
      localf.oOA = paramf.oOA;
      localf.oOE = paramf.oOE;
      localf.oOF = paramf.oOF;
      localf.oOG = paramf.oOG;
      localf.oOH = paramf.oOH;
      localf.oOM = paramf.oOM;
      localf.oOI = paramf.oOI;
      localf.startTime = paramf.startTime;
      localf.protocol = paramf.protocol;
      localf.orm = paramf.orm;
      localf.volume = paramf.volume;
      localf.oOH = paramf.oOH;
      localf.orv = paramf.oru;
      localf.orv = paramf.orv;
      localf.oOS = paramf.oOS;
      localf.oOT = paramf.oOT;
      localf.iaa = paramf.iaa;
      localf.oOV = paramf.oOV;
      localf.oOU = paramf.oOU;
      localf.oPa = paramf.oPa;
      localf.oOX = paramf.oOX;
      return;
    }
    this.tie = paramf;
  }
  
  public void n(com.tencent.mm.aw.f paramf) {}
  
  public void o(com.tencent.mm.aw.f paramf) {}
  
  public void p(com.tencent.mm.aw.f paramf) {}
  
  public void q(com.tencent.mm.aw.f paramf) {}
  
  public void r(com.tencent.mm.aw.f paramf) {}
  
  public void s(com.tencent.mm.aw.f paramf) {}
  
  public void t(com.tencent.mm.aw.f paramf) {}
  
  public void u(com.tencent.mm.aw.f paramf) {}
  
  public void v(com.tencent.mm.aw.f paramf) {}
  
  public void w(List<com.tencent.mm.aw.f> paramList, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.logic.f
 * JD-Core Version:    0.7.0.1
 */