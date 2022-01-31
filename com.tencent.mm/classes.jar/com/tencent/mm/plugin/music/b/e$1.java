package com.tencent.mm.plugin.music.b;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class e$1
  implements b
{
  e$1(e parame) {}
  
  public final void Cr(String paramString)
  {
    g localg = this.mxk.IV(paramString);
    if (localg == null)
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
      return;
    }
    this.mxk.b(paramString, localg);
    this.mxk.f(paramString, localg);
    e.a(this.mxk);
    this.mxk.bmb();
  }
  
  public final void IP(String paramString)
  {
    g localg = this.mxk.IV(paramString);
    if (localg == null)
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
      return;
    }
    this.mxk.b(paramString, localg);
    this.mxk.f(paramString, localg);
    e.a(this.mxk);
    this.mxk.bmb();
  }
  
  public final void IQ(String paramString)
  {
    g localg = this.mxk.IV(paramString);
    if (localg == null)
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
      return;
    }
    this.mxk.b(paramString, localg);
    this.mxk.f(paramString, localg);
    e.a(this.mxk);
    this.mxk.bmb();
  }
  
  public final void onError(String paramString)
  {
    g localg = this.mxk.IV(paramString);
    if (localg == null)
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
      return;
    }
    this.mxk.b(paramString, localg);
    e locale = this.mxk;
    int j = localg.jsT;
    if (locale.mwY.containsKey(paramString)) {}
    for (int i = ((Integer)locale.mwY.get(paramString)).intValue();; i = 0)
    {
      if (i > 0)
      {
        y.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
        locale.mwY.remove(paramString);
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label174;
        }
        y.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
        this.mxk.bmf();
        this.mxk.a(paramString, null);
        return;
        if (66 != j)
        {
          locale.mwY.remove(paramString);
          break;
        }
        if (!locale.Jc(paramString)) {
          break;
        }
        locale.mwY.put(paramString, Integer.valueOf(i + 1));
      }
      label174:
      y.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
      this.mxk.f(paramString, localg);
      e.a(this.mxk);
      this.mxk.bmb();
      return;
    }
  }
  
  public final void onStart(String arg1)
  {
    g localg = this.mxk.IV(???);
    if (localg == null)
    {
      y.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
      return;
    }
    this.mxk.e(???, localg);
    synchronized (this.mxk.jtD)
    {
      this.mxk.mxa = false;
      ai.S(this.mxk.mxj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.e.1
 * JD-Core Version:    0.7.0.1
 */