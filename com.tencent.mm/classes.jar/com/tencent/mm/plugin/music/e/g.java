package com.tencent.mm.plugin.music.e;

import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.platformtools.ac;
import java.net.URL;
import java.util.List;

public abstract class g
  implements a
{
  protected f lrO;
  protected c veO;
  
  public boolean JI(int paramInt)
  {
    return true;
  }
  
  public void a(f paramf, int paramInt) {}
  
  public final void a(c paramc)
  {
    this.veO = paramc;
  }
  
  public String anB(String paramString)
  {
    return paramString;
  }
  
  public URL anC(String paramString)
  {
    return new URL(paramString);
  }
  
  public f diz()
  {
    return this.lrO;
  }
  
  public void e(List<f> paramList, boolean paramBoolean) {}
  
  public boolean i(f paramf)
  {
    this.lrO = paramf;
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
    this.lrO = paramf;
  }
  
  public final void m(f paramf)
  {
    if ((this.lrO != null) && (this.lrO.f(paramf)))
    {
      f localf = this.lrO;
      localf.hNU = paramf.hNU;
      localf.hNV = paramf.hNV;
      localf.hNW = paramf.hNW;
      localf.hNX = paramf.hNX;
      localf.hOb = paramf.hOb;
      localf.hOc = paramf.hOc;
      localf.hOd = paramf.hOd;
      localf.hOe = paramf.hOe;
      localf.hOj = paramf.hOj;
      localf.hOf = paramf.hOf;
      localf.cSh = paramf.cSh;
      localf.protocol = paramf.protocol;
      localf.htq = paramf.htq;
      localf.volume = paramf.volume;
      localf.hOe = paramf.hOe;
      localf.htz = paramf.hty;
      localf.htz = paramf.htz;
      localf.hOp = paramf.hOp;
      localf.hOq = paramf.hOq;
      localf.dvl = paramf.dvl;
      localf.hOs = paramf.hOs;
      localf.hOr = paramf.hOr;
      return;
    }
    this.lrO = paramf;
  }
  
  public void n(f paramf) {}
  
  public void o(f paramf) {}
  
  public void p(f paramf) {}
  
  public void q(f paramf) {}
  
  public f r(List<f> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      ac.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
      return null;
    }
    this.lrO = ((f)paramList.get(paramInt));
    ac.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
    return this.lrO;
  }
  
  public void r(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.g
 * JD-Core Version:    0.7.0.1
 */