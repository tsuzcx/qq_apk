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
  ITPPlayerListener.IOnPreparedListener ZDN;
  ITPPlayerListener.IOnCompletionListener ZDO;
  ITPPlayerListener.IOnInfoListener ZDP;
  ITPPlayerListener.IOnErrorListener ZDQ;
  ITPPlayerListener.IOnSeekCompleteListener ZDR;
  ITPPlayerListener.IOnVideoSizeChangedListener ZDS;
  ITPPlayerListener.IOnSubtitleDataListener ZDT;
  ITPPlayerListener.IOnSubtitleFrameOutListener ZDU;
  ITPPlayerListener.IOnVideoFrameOutListener ZDV;
  ITPPlayerListener.IOnAudioFrameOutputListener ZDW;
  ITPPlayerListener.IOnVideoProcessFrameOutputListener ZDX;
  ITPPlayerListener.IOnAudioProcessFrameOutputListener ZDY;
  ITPPlayerListener.IOnStateChangeListener ZDZ;
  ITPPlayerListener.IOnStopAsyncCompleteListener ZEa;
  a ZEb;
  private String mTag;
  
  d(String paramString)
  {
    AppMethodBeat.i(221504);
    this.mTag = "TPPlayerListenerS";
    bDr(paramString);
    this.ZEb = new a(this.mTag);
    this.ZDN = this.ZEb;
    this.ZDO = this.ZEb;
    this.ZDP = this.ZEb;
    this.ZDQ = this.ZEb;
    this.ZDR = this.ZEb;
    this.ZDS = this.ZEb;
    this.ZDT = this.ZEb;
    this.ZDU = this.ZEb;
    this.ZDV = this.ZEb;
    this.ZDW = this.ZEb;
    this.ZDX = this.ZEb;
    this.ZDY = this.ZEb;
    this.ZDZ = this.ZEb;
    this.ZEa = this.ZEb;
    AppMethodBeat.o(221504);
  }
  
  public final void bDr(String paramString)
  {
    AppMethodBeat.i(221505);
    if (TextUtils.isEmpty(paramString)) {}
    for (this.mTag = "TPPlayerListenerS";; this.mTag = paramString)
    {
      if (this.ZEb != null) {
        this.ZEb.mTag = paramString;
      }
      AppMethodBeat.o(221505);
      return;
    }
  }
  
  public final void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    AppMethodBeat.i(221522);
    this.ZDW.onAudioFrameOut(paramITPPlayer, paramTPAudioFrameBuffer);
    AppMethodBeat.o(221522);
  }
  
  public final TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(221528);
    paramITPPlayer = this.ZDY.onAudioProcessFrameOut(paramITPPlayer, paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(221528);
    return paramITPPlayer;
  }
  
  public final void onCompletion(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(221507);
    this.ZDO.onCompletion(paramITPPlayer);
    AppMethodBeat.o(221507);
  }
  
  public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221510);
    this.ZDQ.onError(paramITPPlayer, paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(221510);
  }
  
  public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(221508);
    this.ZDP.onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(221508);
  }
  
  public final void onPrepared(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(221506);
    this.ZDN.onPrepared(paramITPPlayer);
    AppMethodBeat.o(221506);
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(221511);
    this.ZDR.onSeekComplete(paramITPPlayer);
    AppMethodBeat.o(221511);
  }
  
  public final void onStateChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221529);
    this.ZDZ.onStateChange(paramInt1, paramInt2);
    AppMethodBeat.o(221529);
  }
  
  public final void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(221530);
    this.ZEa.onStopAsyncComplete(paramITPPlayer);
    AppMethodBeat.o(221530);
  }
  
  public final void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
  {
    AppMethodBeat.i(221516);
    this.ZDT.onSubtitleData(paramITPPlayer, paramTPSubtitleData);
    AppMethodBeat.o(221516);
  }
  
  public final void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    AppMethodBeat.i(221519);
    this.ZDU.onSubtitleFrameOut(paramITPPlayer, paramTPSubtitleFrameBuffer);
    AppMethodBeat.o(221519);
  }
  
  public final void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    AppMethodBeat.i(221520);
    this.ZDV.onVideoFrameOut(paramITPPlayer, paramTPVideoFrameBuffer);
    AppMethodBeat.o(221520);
  }
  
  public final TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(221524);
    paramITPPlayer = this.ZDX.onVideoProcessFrameOut(paramITPPlayer, paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(221524);
    return paramITPPlayer;
  }
  
  public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221514);
    this.ZDS.onVideoSizeChanged(paramITPPlayer, paramLong1, paramLong2);
    AppMethodBeat.o(221514);
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
      AppMethodBeat.i(221493);
      g.i(this.mTag, " empty player listener , notify , onAudioFrameOut");
      AppMethodBeat.o(221493);
    }
    
    public final TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(221496);
      g.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
      AppMethodBeat.o(221496);
      return null;
    }
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(221479);
      g.i(this.mTag, " empty player listener , notify , onCompletion");
      AppMethodBeat.o(221479);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(221484);
      g.i(this.mTag, " empty player listener , notify , onError");
      AppMethodBeat.o(221484);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(221481);
      g.i(this.mTag, " empty player listener , notify , onInfo");
      AppMethodBeat.o(221481);
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(221476);
      g.i(this.mTag, " empty player listener , notify , onPrepared");
      AppMethodBeat.o(221476);
    }
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(221486);
      g.i(this.mTag, " empty player listener , notify , onSeekComplete");
      AppMethodBeat.o(221486);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(221497);
      g.i(this.mTag, " empty player listener , notify , onStateChange");
      AppMethodBeat.o(221497);
    }
    
    public final void onStopAsyncComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(221498);
      g.i(this.mTag, " empty player listener , notify , onStopAsyncComplete");
      AppMethodBeat.o(221498);
    }
    
    public final void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(221489);
      g.i(this.mTag, " empty player listener , notify , onSubtitleData");
      AppMethodBeat.o(221489);
    }
    
    public final void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(221490);
      g.i(this.mTag, " empty player listener , notify , onSubtitleFrameOut");
      AppMethodBeat.o(221490);
    }
    
    public final void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(221492);
      g.i(this.mTag, " empty player listener , notify , onVideoFrameOut");
      AppMethodBeat.o(221492);
    }
    
    public final TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(221495);
      g.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
      AppMethodBeat.o(221495);
      return null;
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(221488);
      g.i(this.mTag, " empty player listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(221488);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.d
 * JD-Core Version:    0.7.0.1
 */