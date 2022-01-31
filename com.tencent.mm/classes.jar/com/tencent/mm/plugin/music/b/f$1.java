package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;

final class f$1
  implements c
{
  f$1(f paramf) {}
  
  public final void Ns(String paramString)
  {
    AppMethodBeat.i(137268);
    h localh = this.oXg.UO(paramString);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
      AppMethodBeat.o(137268);
      return;
    }
    this.oXg.b(paramString, localh);
    this.oXg.f(paramString, localh);
    f.a(this.oXg);
    this.oXg.bUc();
    f.a(this.oXg, paramString);
    this.oXg.UZ(paramString);
    AppMethodBeat.o(137268);
  }
  
  public final void UF(String paramString)
  {
    AppMethodBeat.i(137267);
    h localh = this.oXg.UO(paramString);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
      AppMethodBeat.o(137267);
      return;
    }
    this.oXg.b(paramString, localh);
    this.oXg.f(paramString, localh);
    f.a(this.oXg);
    this.oXg.bUc();
    AppMethodBeat.o(137267);
  }
  
  public final void ek(String paramString)
  {
    AppMethodBeat.i(137269);
    h localh = this.oXg.UO(paramString);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
      AppMethodBeat.o(137269);
      return;
    }
    this.oXg.b(paramString, localh);
    this.oXg.f(paramString, localh);
    f.a(this.oXg);
    this.oXg.bUc();
    f.a(this.oXg, paramString);
    this.oXg.UZ(paramString);
    AppMethodBeat.o(137269);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(137270);
    h localh = this.oXg.UO(paramString);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
      AppMethodBeat.o(137270);
      return;
    }
    this.oXg.b(paramString, localh);
    f localf = this.oXg;
    int j = localh.lCs;
    if (localf.oWP.containsKey(paramString)) {}
    for (int i = ((Integer)localf.oWP.get(paramString)).intValue();; i = 0)
    {
      if (i > 0)
      {
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
        localf.oWP.remove(paramString);
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label189;
        }
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
        this.oXg.bUg();
        this.oXg.b(paramString, null);
        AppMethodBeat.o(137270);
        return;
        if (66 != j)
        {
          localf.oWP.remove(paramString);
          break;
        }
        if (!localf.UY(paramString)) {
          break;
        }
        localf.oWP.put(paramString, Integer.valueOf(i + 1));
      }
      label189:
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
      this.oXg.f(paramString, localh);
      f.a(this.oXg);
      this.oXg.bUc();
      AppMethodBeat.o(137270);
      return;
    }
  }
  
  public final void onStart(String arg1)
  {
    AppMethodBeat.i(137266);
    h localh = this.oXg.UO(???);
    if (localh == null)
    {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
      AppMethodBeat.o(137266);
      return;
    }
    this.oXg.e(???, localh);
    synchronized (this.oXg.lDc)
    {
      this.oXg.oWR = false;
      al.ae(this.oXg.oXd);
      AppMethodBeat.o(137266);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f.1
 * JD-Core Version:    0.7.0.1
 */