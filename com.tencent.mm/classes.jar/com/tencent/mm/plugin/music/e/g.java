package com.tencent.mm.plugin.music.e;

import com.tencent.mm.av.e;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URL;
import java.util.List;

public abstract class g
  implements a
{
  protected c myR;
  protected e myS;
  
  public String Jw(String paramString)
  {
    return paramString;
  }
  
  public URL Jx(String paramString)
  {
    return new URL(paramString);
  }
  
  public void a(e parame, int paramInt) {}
  
  public final void a(c paramc)
  {
    this.myR = paramc;
  }
  
  public e bmW()
  {
    return this.myS;
  }
  
  public void d(List<e> paramList, boolean paramBoolean) {}
  
  public boolean g(e parame)
  {
    this.myS = parame;
    return true;
  }
  
  public e h(e parame)
  {
    return parame;
  }
  
  public e h(List<e> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      y.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
      return null;
    }
    this.myS = ((e)paramList.get(paramInt));
    y.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
    return this.myS;
  }
  
  public e i(e parame)
  {
    return parame;
  }
  
  public void init() {}
  
  public void j(e parame)
  {
    this.myS = parame;
  }
  
  public void k(e parame) {}
  
  public void l(e parame) {}
  
  public void m(e parame) {}
  
  public void n(e parame) {}
  
  public void o(e parame) {}
  
  public boolean uJ(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.g
 * JD-Core Version:    0.7.0.1
 */