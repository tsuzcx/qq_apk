package com.tencent.mm.plugin.music.e;

import com.tencent.mm.az.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.net.URL;
import java.util.List;

public abstract class g
  implements a
{
  protected f lQY;
  protected c wkj;
  
  public boolean Lk(int paramInt)
  {
    return true;
  }
  
  public void a(f paramf, int paramInt) {}
  
  public final void a(c paramc)
  {
    this.wkj = paramc;
  }
  
  public String asA(String paramString)
  {
    return paramString;
  }
  
  public URL asB(String paramString)
  {
    return new URL(paramString);
  }
  
  public f dsL()
  {
    return this.lQY;
  }
  
  public void e(List<f> paramList, boolean paramBoolean) {}
  
  public boolean i(f paramf)
  {
    this.lQY = paramf;
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
    this.lQY = paramf;
  }
  
  public void m(f paramf)
  {
    if ((this.lQY != null) && (this.lQY.f(paramf)))
    {
      f localf = this.lQY;
      localf.ihi = paramf.ihi;
      localf.ihj = paramf.ihj;
      localf.ihk = paramf.ihk;
      localf.ihl = paramf.ihl;
      localf.ihp = paramf.ihp;
      localf.ihq = paramf.ihq;
      localf.ihr = paramf.ihr;
      localf.ihs = paramf.ihs;
      localf.ihx = paramf.ihx;
      localf.iht = paramf.iht;
      localf.ddx = paramf.ddx;
      localf.protocol = paramf.protocol;
      localf.hLI = paramf.hLI;
      localf.volume = paramf.volume;
      localf.ihs = paramf.ihs;
      localf.hLR = paramf.hLQ;
      localf.hLR = paramf.hLR;
      localf.ihD = paramf.ihD;
      localf.ihE = paramf.ihE;
      localf.dHo = paramf.dHo;
      localf.ihG = paramf.ihG;
      localf.ihF = paramf.ihF;
      return;
    }
    this.lQY = paramf;
  }
  
  public void n(f paramf) {}
  
  public void o(f paramf) {}
  
  public void p(f paramf) {}
  
  public void q(f paramf) {}
  
  public void r(f paramf) {}
  
  public f t(List<f> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      ad.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
      return null;
    }
    this.lQY = ((f)paramList.get(paramInt));
    ad.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
    return this.lQY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.g
 * JD-Core Version:    0.7.0.1
 */