package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.StringTokenizer;

public class VivoKTVHelper
{
  private static final String KEY_EXT_SPKR = "vivo_ktv_ext_speaker";
  private static final String KEY_KTV_MODE = "vivo_ktv_mode";
  private static final String KEY_MIC_SRC = "vivo_ktv_rec_source";
  private static final String KEY_MIC_TYPE = "vivo_ktv_mic_type";
  private static final String KEY_PLAY_SRC = "vivo_ktv_play_source";
  private static final String KEY_PRESET = "vivo_ktv_preset_effect";
  private static final String KEY_VOL_MIC = "vivo_ktv_volume_mic";
  private static final String TAG = "VivoKTVHelper";
  private static VivoKTVHelper mVivoKTVHelper;
  private AudioManager mAudioManager;
  private Context mContext;
  private final Object mParamLock;
  
  public VivoKTVHelper(Context paramContext)
  {
    AppMethodBeat.i(13762);
    this.mParamLock = new Object();
    this.mContext = paramContext;
    this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    AppMethodBeat.o(13762);
  }
  
  public static VivoKTVHelper getInstance(Context paramContext)
  {
    AppMethodBeat.i(13763);
    if (mVivoKTVHelper == null) {
      mVivoKTVHelper = new VivoKTVHelper(paramContext);
    }
    paramContext = mVivoKTVHelper;
    AppMethodBeat.o(13763);
    return paramContext;
  }
  
  private int getKTVParam(String paramString)
  {
    AppMethodBeat.i(13778);
    if (TXCBuild.Model().trim().contains("vivo"))
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(this.mAudioManager.getParameters(paramString), "=");
      if ((localStringTokenizer.countTokens() == 2) && (paramString.equals(localStringTokenizer.nextToken())))
      {
        int i = Integer.parseInt(localStringTokenizer.nextToken().trim());
        AppMethodBeat.o(13778);
        return i;
      }
    }
    AppMethodBeat.o(13778);
    return 0;
  }
  
  public void closeKTVDevice()
  {
    AppMethodBeat.i(13766);
    this.mAudioManager.setParameters("vivo_ktv_mode=0");
    AppMethodBeat.o(13766);
  }
  
  public int getExtSpeakerParam()
  {
    AppMethodBeat.i(13772);
    int i = getKTVParam("vivo_ktv_ext_speaker");
    AppMethodBeat.o(13772);
    return i;
  }
  
  public int getMicTypeParam()
  {
    AppMethodBeat.i(13775);
    int i = getKTVParam("vivo_ktv_mic_type");
    AppMethodBeat.o(13775);
    return i;
  }
  
  public int getMicVolParam()
  {
    AppMethodBeat.i(13777);
    int i = getKTVParam("vivo_ktv_volume_mic");
    AppMethodBeat.o(13777);
    return i;
  }
  
  public int getPlayFeedbackParam()
  {
    AppMethodBeat.i(13773);
    int i = getKTVParam("vivo_ktv_play_source");
    AppMethodBeat.o(13773);
    return i;
  }
  
  public int getPreModeParam()
  {
    AppMethodBeat.i(13774);
    int i = getKTVParam("vivo_ktv_preset_effect");
    AppMethodBeat.o(13774);
    return i;
  }
  
  public int getVoiceOutParam()
  {
    AppMethodBeat.i(13776);
    int i = getKTVParam("vivo_ktv_rec_source");
    AppMethodBeat.o(13776);
    return i;
  }
  
  public boolean isDeviceSupportKaraoke()
  {
    AppMethodBeat.i(13764);
    if (TXCBuild.Model().trim().contains("vivo"))
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(this.mAudioManager.getParameters("vivo_ktv_mic_type"), "=");
      if (localStringTokenizer.countTokens() != 2)
      {
        AppMethodBeat.o(13764);
        return false;
      }
      if (localStringTokenizer.nextToken().equals("vivo_ktv_mic_type"))
      {
        int i = Integer.parseInt(localStringTokenizer.nextToken());
        if ((i == 1) || (i == 0))
        {
          AppMethodBeat.o(13764);
          return true;
        }
      }
    }
    AppMethodBeat.o(13764);
    return false;
  }
  
  public void openKTVDevice()
  {
    AppMethodBeat.i(13765);
    this.mAudioManager.setParameters("vivo_ktv_mode=1");
    isDeviceSupportKaraoke();
    AppMethodBeat.o(13765);
  }
  
  public void setExtSpeakerParam(int paramInt)
  {
    AppMethodBeat.i(13771);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vivo_ktv_ext_speaker=").append(paramInt);
        this.mAudioManager.setParameters(localStringBuilder.toString());
      }
      AppMethodBeat.o(13771);
      return;
    }
  }
  
  public void setMicVolParam(int paramInt)
  {
    AppMethodBeat.i(13767);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vivo_ktv_volume_mic=").append(paramInt);
        this.mAudioManager.setParameters(localStringBuilder.toString());
      }
      AppMethodBeat.o(13767);
      return;
    }
  }
  
  public void setPlayFeedbackParam(int paramInt)
  {
    AppMethodBeat.i(13770);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null) {
        this.mAudioManager.setParameters("vivo_ktv_play_source=".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(13770);
      return;
    }
  }
  
  public void setPreModeParam(int paramInt)
  {
    AppMethodBeat.i(13769);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null) {
        this.mAudioManager.setParameters("vivo_ktv_preset_effect=".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(13769);
      return;
    }
  }
  
  public void setVoiceOutParam(int paramInt)
  {
    AppMethodBeat.i(13768);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null) {
        this.mAudioManager.setParameters("vivo_ktv_rec_source=".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(13768);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.VivoKTVHelper
 * JD-Core Version:    0.7.0.1
 */