package com.tencent.mm.plugin.music.f;

import com.tencent.mm.av.e;
import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.h.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  implements b.b
{
  d$2(d paramd) {}
  
  public final void uH(int paramInt)
  {
    Object localObject;
    if (paramInt == 1) {
      if ((this.mAH.mAi != null) && (!this.mAH.mxr) && (this.mAH.mAC != null))
      {
        localObject = com.tencent.mm.plugin.music.h.b.aN(this.mAH.mAi.myu.eux, this.mAH.mAi.kaC);
        this.mAH.mAC.JG((String)localObject);
        localObject = this.mAH;
        if (!k.bnn().requestFocus()) {
          break label135;
        }
        y.i("MicroMsg.Music.MusicPlayer", "startPlay");
      }
    }
    label135:
    do
    {
      try
      {
        if (((d)localObject).mAC != null) {
          ((d)localObject).mAC.play();
        }
        ((d)localObject).mxr = true;
        ((d)localObject).mAD = false;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "startPlay", new Object[0]);
        }
      }
      y.e("MicroMsg.Music.MusicPlayer", "request focus error");
      return;
      if ((paramInt == -2) || (paramInt == 5) || (paramInt == 19))
      {
        ai.d(new d.2.1(this, paramInt));
        return;
      }
    } while ((paramInt != -1) && (paramInt != 6) && (paramInt != 4));
    ai.d(new d.2.2(this));
    d.a(this.mAH, this.mAH.myB, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.2
 * JD-Core Version:    0.7.0.1
 */