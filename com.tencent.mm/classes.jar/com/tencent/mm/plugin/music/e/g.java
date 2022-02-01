package com.tencent.mm.plugin.music.e;

import com.tencent.mm.bb.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URL;
import java.util.List;

public abstract class g
  implements a
{
  protected c FQu;
  protected f qdp;
  
  public void a(f paramf, int paramInt) {}
  
  public final void a(c paramc)
  {
    this.FQu = paramc;
  }
  
  public URL aRZ(String paramString)
  {
    return new URL(paramString);
  }
  
  public String aqw(String paramString)
  {
    return paramString;
  }
  
  public f fed()
  {
    return this.qdp;
  }
  
  public boolean fee()
  {
    return true;
  }
  
  public boolean i(f paramf)
  {
    this.qdp = paramf;
    return true;
  }
  
  public void init() {}
  
  public f j(f paramf)
  {
    return paramf;
  }
  
  public void j(List<f> paramList, boolean paramBoolean) {}
  
  public f k(f paramf)
  {
    return paramf;
  }
  
  public void l(f paramf)
  {
    this.qdp = paramf;
  }
  
  public void m(f paramf)
  {
    if ((this.qdp != null) && (this.qdp.f(paramf)))
    {
      f localf = this.qdp;
      localf.lVv = paramf.lVv;
      localf.lVw = paramf.lVw;
      localf.lVx = paramf.lVx;
      localf.lVy = paramf.lVy;
      localf.lVC = paramf.lVC;
      localf.lVD = paramf.lVD;
      localf.lVE = paramf.lVE;
      localf.lVF = paramf.lVF;
      localf.lVK = paramf.lVK;
      localf.lVG = paramf.lVG;
      localf.fod = paramf.fod;
      localf.protocol = paramf.protocol;
      localf.lzL = paramf.lzL;
      localf.volume = paramf.volume;
      localf.lVF = paramf.lVF;
      localf.lzU = paramf.lzT;
      localf.lzU = paramf.lzU;
      localf.lVQ = paramf.lVQ;
      localf.lVR = paramf.lVR;
      localf.fUd = paramf.fUd;
      localf.lVT = paramf.lVT;
      localf.lVS = paramf.lVS;
      localf.lVX = paramf.lVX;
      localf.lVV = paramf.lVV;
      return;
    }
    this.qdp = paramf;
  }
  
  public void n(f paramf) {}
  
  public void o(f paramf) {}
  
  public void p(f paramf) {}
  
  public void q(f paramf) {}
  
  public void r(f paramf) {}
  
  public f z(List<f> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      Log.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
      return null;
    }
    this.qdp = ((f)paramList.get(paramInt));
    Log.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
    return this.qdp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.g
 * JD-Core Version:    0.7.0.1
 */