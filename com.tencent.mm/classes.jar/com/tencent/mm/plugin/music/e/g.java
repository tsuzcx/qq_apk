package com.tencent.mm.plugin.music.e;

import com.tencent.mm.az.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.net.URL;
import java.util.List;

public abstract class g
  implements a
{
  protected f kQp;
  protected c tWe;
  
  public boolean HJ(int paramInt)
  {
    return true;
  }
  
  public void a(f paramf, int paramInt) {}
  
  public final void a(c paramc)
  {
    this.tWe = paramc;
  }
  
  public String aiG(String paramString)
  {
    return paramString;
  }
  
  public URL aiH(String paramString)
  {
    return new URL(paramString);
  }
  
  public f cUT()
  {
    return this.kQp;
  }
  
  public void e(List<f> paramList, boolean paramBoolean) {}
  
  public boolean i(f paramf)
  {
    this.kQp = paramf;
    return true;
  }
  
  public void init() {}
  
  public f j(f paramf)
  {
    return paramf;
  }
  
  public f k(f paramf)
  {
    return paramf;
  }
  
  public void l(f paramf)
  {
    this.kQp = paramf;
  }
  
  public final void m(f paramf)
  {
    if ((this.kQp != null) && (this.kQp.f(paramf)))
    {
      f localf = this.kQp;
      localf.hnr = paramf.hnr;
      localf.hns = paramf.hns;
      localf.hnt = paramf.hnt;
      localf.hnu = paramf.hnu;
      localf.hny = paramf.hny;
      localf.hnz = paramf.hnz;
      localf.hnA = paramf.hnA;
      localf.hnB = paramf.hnB;
      localf.hnG = paramf.hnG;
      localf.hnC = paramf.hnC;
      localf.cUL = paramf.cUL;
      localf.protocol = paramf.protocol;
      localf.gSR = paramf.gSR;
      localf.volume = paramf.volume;
      localf.hnB = paramf.hnB;
      localf.gTa = paramf.gSZ;
      localf.gTa = paramf.gTa;
      localf.hnM = paramf.hnM;
      localf.hnN = paramf.hnN;
      localf.dxz = paramf.dxz;
      localf.hnP = paramf.hnP;
      localf.hnO = paramf.hnO;
      return;
    }
    this.kQp = paramf;
  }
  
  public void n(f paramf) {}
  
  public void o(f paramf) {}
  
  public void p(f paramf) {}
  
  public void q(f paramf) {}
  
  public f r(List<f> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      ad.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
      return null;
    }
    this.kQp = ((f)paramList.get(paramInt));
    ad.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
    return this.kQp;
  }
  
  public void r(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.g
 * JD-Core Version:    0.7.0.1
 */