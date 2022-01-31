package com.tencent.mm.plugin.music.e;

import com.tencent.mm.h.a.jy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class m$b
  implements Runnable
{
  List<String> mzj;
  
  private m$b(m paramm) {}
  
  public final void run()
  {
    Object localObject = com.tencent.mm.plugin.music.h.b.K(this.mzi.bmW());
    int j = m.a(this.mzi);
    int i = 0;
    int k = 0;
    while (i < this.mzj.size())
    {
      if (((String)this.mzj.get(i)).equals(localObject))
      {
        j = i;
        k = 1;
      }
      i += 1;
    }
    if (k == 0) {
      return;
    }
    i = j + 1;
    while (i < this.mzj.size())
    {
      m.b(this.mzi).add(this.mzj.get(i));
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      m.b(this.mzi).add(this.mzj.get(i));
      i += 1;
    }
    y.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[] { Integer.valueOf(m.b(this.mzi).size()), Integer.valueOf(m.a(this.mzi)) });
    localObject = new jy();
    ((jy)localObject).bSA.action = 5;
    a.udP.m((com.tencent.mm.sdk.b.b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m.b
 * JD-Core Version:    0.7.0.1
 */