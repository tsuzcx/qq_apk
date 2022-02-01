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
  ITPPlayerListener.IOnPreparedListener ahIQ;
  ITPPlayerListener.IOnCompletionListener ahIR;
  ITPPlayerListener.IOnInfoListener ahIS;
  ITPPlayerListener.IOnErrorListener ahIT;
  ITPPlayerListener.IOnSeekCompleteListener ahIU;
  ITPPlayerListener.IOnVideoSizeChangedListener ahIV;
  ITPPlayerListener.IOnSubtitleDataListener ahIW;
  ITPPlayerListener.IOnSubtitleFrameOutListener ahIX;
  ITPPlayerListener.IOnVideoFrameOutListener ahIY;
  ITPPlayerListener.IOnAudioFrameOutputListener ahIZ;
  ITPPlayerListener.IOnVideoProcessFrameOutputListener ahJa;
  ITPPlayerListener.IOnAudioProcessFrameOutputListener ahJb;
  ITPPlayerListener.IOnStateChangeListener ahJc;
  ITPPlayerListener.IOnStopAsyncCompleteListener ahJd;
  a ahJe;
  private String mTag;
  
  d(String paramString)
  {
    AppMethodBeat.i(227166);
    this.mTag = "TPPlayerListenerS";
    ayz(paramString);
    this.ahJe = new a(this.mTag);
    this.ahIQ = this.ahJe;
    this.ahIR = this.ahJe;
    this.ahIS = this.ahJe;
    this.ahIT = this.ahJe;
    this.ahIU = this.ahJe;
    this.ahIV = this.ahJe;
    this.ahIW = this.ahJe;
    this.ahIX = this.ahJe;
    this.ahIY = this.ahJe;
    this.ahIZ = this.ahJe;
    this.ahJa = this.ahJe;
    this.ahJb = this.ahJe;
    this.ahJc = this.ahJe;
    this.ahJd = this.ahJe;
    AppMethodBeat.o(227166);
  }
  
  public final void ayz(String paramString)
  {
    AppMethodBeat.i(227173);
    if (TextUtils.isEmpty(paramString)) {}
    for (this.mTag = "TPPlayerListenerS";; this.mTag = paramString)
    {
      if (this.ahJe != null) {
        this.ahJe.mTag = paramString;
      }
      AppMethodBeat.o(227173);
      return;
    }
  }
  
  public final void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    AppMethodBeat.i(227233);
    this.ahIZ.onAudioFrameOut(paramITPPlayer, paramTPAudioFrameBuffer);
    AppMethodBeat.o(227233);
  }
  
  public final TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(227245);
    paramITPPlayer = this.ahJb.onAudioProcessFrameOut(paramITPPlayer, paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(227245);
    return paramITPPlayer;
  }
  
  public final void onCompletion(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(227188);
    this.ahIR.onCompletion(paramITPPlayer);
    AppMethodBeat.o(227188);
  }
  
  public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227203);
    this.ahIT.onError(paramITPPlayer, paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(227203);
  }
  
  public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(227197);
    this.ahIS.onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(227197);
  }
  
  public final void onPrepared(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(227180);
    this.ahIQ.onPrepared(paramITPPlayer);
    AppMethodBeat.o(227180);
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(227207);
    this.ahIU.onSeekComplete(paramITPPlayer);
    AppMethodBeat.o(227207);
  }
  
  public final void onStateChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227249);
    this.ahJc.onStateChange(paramInt1, paramInt2);
    AppMethodBeat.o(227249);
  }
  
  public final void onStopAsyncComplete(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(227254);
    this.ahJd.onStopAsyncComplete(paramITPPlayer);
    AppMethodBeat.o(227254);
  }
  
  public final void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
  {
    AppMethodBeat.i(227218);
    this.ahIW.onSubtitleData(paramITPPlayer, paramTPSubtitleData);
    AppMethodBeat.o(227218);
  }
  
  public final void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    AppMethodBeat.i(227222);
    this.ahIX.onSubtitleFrameOut(paramITPPlayer, paramTPSubtitleFrameBuffer);
    AppMethodBeat.o(227222);
  }
  
  public final void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    AppMethodBeat.i(227227);
    this.ahIY.onVideoFrameOut(paramITPPlayer, paramTPVideoFrameBuffer);
    AppMethodBeat.o(227227);
  }
  
  public final TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(227238);
    paramITPPlayer = this.ahJa.onVideoProcessFrameOut(paramITPPlayer, paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(227238);
    return paramITPPlayer;
  }
  
  public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227211);
    this.ahIV.onVideoSizeChanged(paramITPPlayer, paramLong1, paramLong2);
    AppMethodBeat.o(227211);
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
      AppMethodBeat.i(227206);
      g.i(this.mTag, " empty player listener , notify , onAudioFrameOut");
      AppMethodBeat.o(227206);
    }
    
    public final TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(227217);
      g.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
      AppMethodBeat.o(227217);
      return null;
    }
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(227152);
      g.i(this.mTag, " empty player listener , notify , onCompletion");
      AppMethodBeat.o(227152);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227170);
      g.i(this.mTag, " empty player listener , notify , onError");
      AppMethodBeat.o(227170);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(227162);
      g.i(this.mTag, " empty player listener , notify , onInfo");
      AppMethodBeat.o(227162);
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(227146);
      g.i(this.mTag, " empty player listener , notify , onPrepared");
      AppMethodBeat.o(227146);
    }
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(227177);
      g.i(this.mTag, " empty player listener , notify , onSeekComplete");
      AppMethodBeat.o(227177);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(227221);
      g.i(this.mTag, " empty player listener , notify , onStateChange");
      AppMethodBeat.o(227221);
    }
    
    public final void onStopAsyncComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(227225);
      g.i(this.mTag, " empty player listener , notify , onStopAsyncComplete");
      AppMethodBeat.o(227225);
    }
    
    public final void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(227190);
      g.i(this.mTag, " empty player listener , notify , onSubtitleData");
      AppMethodBeat.o(227190);
    }
    
    public final void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(227196);
      g.i(this.mTag, " empty player listener , notify , onSubtitleFrameOut");
      AppMethodBeat.o(227196);
    }
    
    public final void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(227202);
      g.i(this.mTag, " empty player listener , notify , onVideoFrameOut");
      AppMethodBeat.o(227202);
    }
    
    public final TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer paramITPPlayer, TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(227210);
      g.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
      AppMethodBeat.o(227210);
      return null;
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227184);
      g.i(this.mTag, " empty player listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(227184);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.g.d
 * JD-Core Version:    0.7.0.1
 */