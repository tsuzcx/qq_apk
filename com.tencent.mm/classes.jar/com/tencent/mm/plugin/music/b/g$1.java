package com.tencent.mm.plugin.music.b;

import com.tencent.mm.af.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;

final class g$1
  implements PlayerListenerCallback
{
  b mxB = null;
  
  g$1(g paramg) {}
  
  public final void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public final void onCompletion(BaseMediaPlayer paramBaseMediaPlayer)
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
  }
  
  public final void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    y.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.mxC.bFM });
    if (this.mxB == null) {
      y.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
    }
    do
    {
      return;
      boolean bool = aq.isNetworkConnected(ae.getContext());
      if ((paramInt2 == 80) && (bool)) {
        y.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
      }
      if (this.mxC.aRY > 0)
      {
        y.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[] { Integer.valueOf(this.mxC.aRY) });
        return;
      }
      this.mxC.mxr = false;
      paramBaseMediaPlayer = this.mxC;
      paramBaseMediaPlayer.aRY += 1;
      this.mxC.jsT = paramInt2;
      this.mxC.dEq = System.currentTimeMillis();
      g.a(this.mxC, paramInt2);
      if (this.mxC.bFM.equalsIgnoreCase(this.mxB.bFM))
      {
        this.mxC.stopPlay();
        ai.d(new g.1.2(this));
      }
      this.mxC.uv(paramInt2);
      if (this.mxC.mxt != null)
      {
        this.mxC.mxt.isStop = true;
        this.mxC.mxt = null;
      }
    } while ((paramInt1 != 91) || (paramInt2 != 55));
    y.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
    com.tencent.mm.plugin.music.cache.g.deleteFile(this.mxC.mxv);
  }
  
  public final void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
  }
  
  public final void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    this.mxC.gNQ.post(new g.1.1(this, paramInt));
  }
  
  public final void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
  }
  
  public final void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    this.mxC.gNQ.post(new g.1.3(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g.1
 * JD-Core Version:    0.7.0.1
 */