package com.tencent.mm.plugin.music.e;

import com.tencent.mm.aw.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URL;
import java.util.List;

public abstract class g
  implements a
{
  protected c oYX;
  protected e oYY;
  
  public boolean Af(int paramInt)
  {
    return true;
  }
  
  public String Vu(String paramString)
  {
    return paramString;
  }
  
  public URL Vv(String paramString)
  {
    return new URL(paramString);
  }
  
  public void a(e parame, int paramInt) {}
  
  public final void a(c paramc)
  {
    this.oYX = paramc;
  }
  
  public e bVs()
  {
    return this.oYY;
  }
  
  public void d(List<e> paramList, boolean paramBoolean) {}
  
  public boolean g(e parame)
  {
    this.oYY = parame;
    return true;
  }
  
  public e h(e parame)
  {
    return parame;
  }
  
  public e i(e parame)
  {
    return parame;
  }
  
  public void init() {}
  
  public void j(e parame)
  {
    this.oYY = parame;
  }
  
  public void k(e parame) {}
  
  public void l(e parame) {}
  
  public e m(List<e> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      ab.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
      return null;
    }
    this.oYY = ((e)paramList.get(paramInt));
    ab.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
    return this.oYY;
  }
  
  public void m(e parame) {}
  
  public void n(e parame) {}
  
  public void o(e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.g
 * JD-Core Version:    0.7.0.1
 */