package com.tencent.thumbplayer.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.g;

public final class d
  implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener
{
  ITPPlayerListener.IOnPreparedListener Sbc;
  ITPPlayerListener.IOnCompletionListener Sbd;
  ITPPlayerListener.IOnInfoListener Sbe;
  ITPPlayerListener.IOnErrorListener Sbf;
  ITPPlayerListener.IOnSeekCompleteListener Sbg;
  ITPPlayerListener.IOnVideoSizeChangedListener Sbh;
  ITPPlayerListener.IOnSubtitleDataListener Sbi;
  ITPPlayerListener.IOnSubtitleFrameOutListener Sbj;
  ITPPlayerListener.IOnVideoFrameOutListener Sbk;
  ITPPlayerListener.IOnAudioFrameOutputListener Sbl;
  ITPPlayerListener.IOnVideoProcessFrameOutputListener Sbm;
  ITPPlayerListener.IOnAudioProcessFrameOutputListener Sbn;
  ITPPlayerListener.IOnStateChangeListener Sbo;
  ITPPlayerListener.IOnStopAsyncCompleteListener Sbp;
  a Sbq;
  private String mTag;
  
  d(String paramString)
  {
    AppMethodBeat.i(189499);
    this.mTag = "TPPlayerListenerS";
    bqx(paramString);
    this.Sbq = new a(this.mTag);
    this.Sbc = this.Sbq;
    this.Sbd = this.Sbq;
    this.Sbe = this.Sbq;
    this.Sbf = this.Sbq;
    this.Sbg = this.Sbq;
    this.Sbh = this.Sbq;
    this.Sbi = this.Sbq;
    this.Sbj = this.Sbq;
    this.Sbk = this.Sbq;
    this.Sbl = this.Sbq;
    this.Sbm = this.Sbq;
    this.Sbn = this.Sbq;
    this.Sbo = this.Sbq;
    this.Sbp = this.Sbq;
    AppMethodBeat.o(189499);
  }
  
  public final void bqx(String paramString)
  {
    AppMethodBeat.i(189500);
    if (TextUtils.isEmpty(paramString)) {}
    for (this.mTag = "TPPlayerListenerS";; this.mTag = paramString)
    {
      if (this.Sbq != null) {
        this.Sbq.mTag = paramString;
      }
      AppMethodBeat.o(189500);
      return;
    }
  }
  
  public final void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    AppMethodBeat.i(189510);
    this.Sbl.onAudioFrameOut(paramITPPlayer, paramTPAudioFrameBuffer);
    AppMethodBeat.o(189510);
  }
  
  public final TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(189512);
    paramITPPlayer = this.Sbn.onAudioProcessFrameOut(paramITPPlayer, paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(189512);
    return paramITPPlayer;
  }
  
  public final void onCompletion(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(189502);
    this.Sbd.onCompletion(paramITPPlayer);
    AppMethodBeat.o(189502);
  }
  
  public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189504);
    this.Sbf.onError(paramITPPlayer, paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(189504);
  }
  
  public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(189503);
    this.Sbe.onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(189503);
  }
  
  public final void onPrepared(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(189501);
    this.Sbc.onPrepared(paramITPPlayer);
    AppMethodBeat.o(189501);
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(189505);
    this.Sbg.onSeekComplete(paramITPPlayer);
    AppMethodBeat.o(189505);
  }
  
  public final void onStateChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189513);
    this.Sbo.onStateChange(paramInt1, paramInt2);
    AppMethodBeat.o(189513);
  }
  
  public final void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(189514);
    this.Sbp.onStopAsyncComplete(paramITPPlayer);
    AppMethodBeat.o(189514);
  }
  
  public final void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
  {
    AppMethodBeat.i(189507);
    this.Sbi.onSubtitleData(paramITPPlayer, paramTPSubtitleData);
    AppMethodBeat.o(189507);
  }
  
  public final void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    AppMethodBeat.i(189508);
    this.Sbj.onSubtitleFrameOut(paramITPPlayer, paramTPSubtitleFrameBuffer);
    AppMethodBeat.o(189508);
  }
  
  public final void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    AppMethodBeat.i(189509);
    this.Sbk.onVideoFrameOut(paramITPPlayer, paramTPVideoFrameBuffer);
    AppMethodBeat.o(189509);
  }
  
  public final TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(189511);
    paramITPPlayer = this.Sbm.onVideoProcessFrameOut(paramITPPlayer, paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(189511);
    return paramITPPlayer;
  }
  
  public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189506);
    this.Sbh.onVideoSizeChanged(paramITPPlayer, paramLong1, paramLong2);
    AppMethodBeat.o(189506);
  }
  
  static final class a
    implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    String mTag;
    
    public a(String paramString)
    {
      this.mTag = paramString;
    }
    
    public final void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(189494);
      g.i(this.mTag, " empty player listener , notify , onAudioFrameOut");
      AppMethodBeat.o(189494);
    }
    
    public final TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(189496);
      g.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
      AppMethodBeat.o(189496);
      return null;
    }
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(189486);
      g.i(this.mTag, " empty player listener , notify , onCompletion");
      AppMethodBeat.o(189486);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189488);
      g.i(this.mTag, " empty player listener , notify , onError");
      AppMethodBeat.o(189488);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(189487);
      g.i(this.mTag, " empty player listener , notify , onInfo");
      AppMethodBeat.o(189487);
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(189485);
      g.i(this.mTag, " empty player listener , notify , onPrepared");
      AppMethodBeat.o(189485);
    }
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(189489);
      g.i(this.mTag, " empty player listener , notify , onSeekComplete");
      AppMethodBeat.o(189489);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189497);
      g.i(this.mTag, " empty player listener , notify , onStateChange");
      AppMethodBeat.o(189497);
    }
    
    public final void onStopAsyncComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(189498);
      g.i(this.mTag, " empty player listener , notify , onStopAsyncComplete");
      AppMethodBeat.o(189498);
    }
    
    public final void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(189491);
      g.i(this.mTag, " empty player listener , notify , onSubtitleData");
      AppMethodBeat.o(189491);
    }
    
    public final void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(189492);
      g.i(this.mTag, " empty player listener , notify , onSubtitleFrameOut");
      AppMethodBeat.o(189492);
    }
    
    public final void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(189493);
      g.i(this.mTag, " empty player listener , notify , onVideoFrameOut");
      AppMethodBeat.o(189493);
    }
    
    public final TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(189495);
      g.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
      AppMethodBeat.o(189495);
      return null;
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189490);
      g.i(this.mTag, " empty player listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(189490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.d
 * JD-Core Version:    0.7.0.1
 */