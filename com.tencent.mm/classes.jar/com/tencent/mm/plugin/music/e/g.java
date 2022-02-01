package com.tencent.mm.plugin.music.e;

import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URL;
import java.util.List;

public abstract class g
  implements a
{
  protected c Ajw;
  protected f nda;
  
  public void a(f paramf, int paramInt) {}
  
  public final void a(c paramc)
  {
    this.Ajw = paramc;
  }
  
  public URL aHK(String paramString)
  {
    return new URL(paramString);
  }
  
  public String aiK(String paramString)
  {
    return paramString;
  }
  
  public f etU()
  {
    return this.nda;
  }
  
  public boolean gEZ()
  {
    return true;
  }
  
  public void i(List<f> paramList, boolean paramBoolean) {}
  
  public boolean i(f paramf)
  {
    this.nda = paramf;
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
    this.nda = paramf;
  }
  
  public void m(f paramf)
  {
    if ((this.nda != null) && (this.nda.f(paramf)))
    {
      f localf = this.nda;
      localf.jeX = paramf.jeX;
      localf.jeY = paramf.jeY;
      localf.jeZ = paramf.jeZ;
      localf.jfa = paramf.jfa;
      localf.jfe = paramf.jfe;
      localf.jff = paramf.jff;
      localf.jfg = paramf.jfg;
      localf.jfh = paramf.jfh;
      localf.jfm = paramf.jfm;
      localf.jfi = paramf.jfi;
      localf.dvv = paramf.dvv;
      localf.protocol = paramf.protocol;
      localf.iJH = paramf.iJH;
      localf.volume = paramf.volume;
      localf.jfh = paramf.jfh;
      localf.iJQ = paramf.iJP;
      localf.iJQ = paramf.iJQ;
      localf.jfs = paramf.jfs;
      localf.jft = paramf.jft;
      localf.eag = paramf.eag;
      localf.jfv = paramf.jfv;
      localf.jfu = paramf.jfu;
      localf.jfx = paramf.jfx;
      return;
    }
    this.nda = paramf;
  }
  
  public void n(f paramf) {}
  
  public void o(f paramf) {}
  
  public void p(f paramf) {}
  
  public void q(f paramf) {}
  
  public void r(f paramf) {}
  
  public f y(List<f> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      Log.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
      return null;
    }
    this.nda = ((f)paramList.get(paramInt));
    Log.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
    return this.nda;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.g
 * JD-Core Version:    0.7.0.1
 */