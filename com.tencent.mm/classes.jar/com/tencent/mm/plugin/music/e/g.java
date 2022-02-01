package com.tencent.mm.plugin.music.e;

import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.net.URL;
import java.util.List;

public abstract class g
  implements a
{
  protected f lVz;
  protected c wzO;
  
  public boolean LP(int paramInt)
  {
    return true;
  }
  
  public String YI(String paramString)
  {
    return paramString;
  }
  
  public void a(f paramf, int paramInt) {}
  
  public final void a(c paramc)
  {
    this.wzO = paramc;
  }
  
  public URL atO(String paramString)
  {
    return new URL(paramString);
  }
  
  public f dwa()
  {
    return this.lVz;
  }
  
  public void e(List<f> paramList, boolean paramBoolean) {}
  
  public boolean i(f paramf)
  {
    this.lVz = paramf;
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
    this.lVz = paramf;
  }
  
  public void m(f paramf)
  {
    if ((this.lVz != null) && (this.lVz.f(paramf)))
    {
      f localf = this.lVz;
      localf.ikb = paramf.ikb;
      localf.ikc = paramf.ikc;
      localf.ikd = paramf.ikd;
      localf.ike = paramf.ike;
      localf.iki = paramf.iki;
      localf.ikj = paramf.ikj;
      localf.ikk = paramf.ikk;
      localf.ikl = paramf.ikl;
      localf.ikq = paramf.ikq;
      localf.ikm = paramf.ikm;
      localf.dez = paramf.dez;
      localf.protocol = paramf.protocol;
      localf.hOB = paramf.hOB;
      localf.volume = paramf.volume;
      localf.ikl = paramf.ikl;
      localf.hOK = paramf.hOJ;
      localf.hOK = paramf.hOK;
      localf.ikw = paramf.ikw;
      localf.ikx = paramf.ikx;
      localf.dIt = paramf.dIt;
      localf.ikz = paramf.ikz;
      localf.iky = paramf.iky;
      return;
    }
    this.lVz = paramf;
  }
  
  public void n(f paramf) {}
  
  public void o(f paramf) {}
  
  public void p(f paramf) {}
  
  public void q(f paramf) {}
  
  public void r(f paramf) {}
  
  public f u(List<f> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      ae.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
      return null;
    }
    this.lVz = ((f)paramList.get(paramInt));
    ae.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
    return this.lVz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.g
 * JD-Core Version:    0.7.0.1
 */