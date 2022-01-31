package com.tencent.mm.plugin.music.b;

import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class f$4
  implements MessageQueue.IdleHandler
{
  f$4(f paramf, String paramString) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(137273);
    com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.oXg.oWM.get(this.oXh);
    if (localb == null) {
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null");
    }
    long l1;
    long l2;
    c localc;
    int i;
    int j;
    if ((!TextUtils.isEmpty(localb.filePath)) && (!this.oXg.oWZ.eA(localb.filePath)))
    {
      l1 = com.tencent.mm.audio.mix.h.a.eG(localb.filePath);
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d", new Object[] { localb.filePath, Long.valueOf(l1) });
      l2 = com.tencent.mm.audio.mix.b.d.De().Df();
      localc = this.oXg.oWZ;
      long l3 = com.tencent.mm.audio.mix.b.d.De().Df();
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", new Object[] { Long.valueOf(l3), localc.appId });
      if (l3 >= 50000000L)
      {
        i = 1;
        if (i != 0) {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", new Object[] { localc.appId });
        }
        j = 0;
        if (this.oXg.oWY.containsKey(localb.filePath)) {
          j = ((Integer)this.oXg.oWY.get(localb.filePath)).intValue();
        }
        if (i == 0) {
          break label288;
        }
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
        if (this.oXg.oWV != null) {
          this.oXg.oWV.zS(713);
        }
        this.oXg.oWZ.ey("");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(137273);
      return false;
      i = 0;
      break;
      label288:
      if (l2 + l1 > 50000000L)
      {
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
        if (this.oXg.oWV != null) {
          this.oXg.oWV.zS(714);
        }
        this.oXg.oWZ.ey("");
      }
      else if (j >= 30)
      {
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
      }
      else if (!com.tencent.mm.audio.mix.h.a.eF(localb.filePath))
      {
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
      }
      else
      {
        localc = this.oXg.oWZ;
        String str = localb.filePath;
        if (!localc.chg.dX(str))
        {
          localb.frk = true;
          localb.fileSize = l1;
          this.oXg.oWZ.a(localb);
        }
        else
        {
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
          continue;
          if (!TextUtils.isEmpty(localb.filePath))
          {
            localb.frk = false;
            if (!this.oXg.oWZ.en(this.oXh)) {
              this.oXg.oWZ.b(localb);
            }
            localb.fileSize = com.tencent.mm.audio.mix.h.a.eG(localb.filePath);
          }
          else
          {
            localb.frk = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f.4
 * JD-Core Version:    0.7.0.1
 */