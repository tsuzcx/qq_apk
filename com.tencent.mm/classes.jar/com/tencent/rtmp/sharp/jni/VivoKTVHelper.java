package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
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
    AppMethodBeat.i(146913);
    this.mParamLock = new Object();
    this.mContext = paramContext;
    this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    AppMethodBeat.o(146913);
  }
  
  public static VivoKTVHelper getInstance(Context paramContext)
  {
    AppMethodBeat.i(146914);
    if (mVivoKTVHelper == null) {
      mVivoKTVHelper = new VivoKTVHelper(paramContext);
    }
    paramContext = mVivoKTVHelper;
    AppMethodBeat.o(146914);
    return paramContext;
  }
  
  private int getKTVParam(String paramString)
  {
    AppMethodBeat.i(146929);
    if (Build.MODEL.trim().contains("vivo"))
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(this.mAudioManager.getParameters(paramString), "=");
      if ((localStringTokenizer.countTokens() == 2) && (paramString.equals(localStringTokenizer.nextToken())))
      {
        int i = Integer.parseInt(localStringTokenizer.nextToken().trim());
        AppMethodBeat.o(146929);
        return i;
      }
    }
    AppMethodBeat.o(146929);
    return 0;
  }
  
  public void closeKTVDevice()
  {
    AppMethodBeat.i(146917);
    this.mAudioManager.setParameters("vivo_ktv_mode=0");
    AppMethodBeat.o(146917);
  }
  
  public int getExtSpeakerParam()
  {
    AppMethodBeat.i(146923);
    int i = getKTVParam("vivo_ktv_ext_speaker");
    AppMethodBeat.o(146923);
    return i;
  }
  
  public int getMicTypeParam()
  {
    AppMethodBeat.i(146926);
    int i = getKTVParam("vivo_ktv_mic_type");
    AppMethodBeat.o(146926);
    return i;
  }
  
  public int getMicVolParam()
  {
    AppMethodBeat.i(146928);
    int i = getKTVParam("vivo_ktv_volume_mic");
    AppMethodBeat.o(146928);
    return i;
  }
  
  public int getPlayFeedbackParam()
  {
    AppMethodBeat.i(146924);
    int i = getKTVParam("vivo_ktv_play_source");
    AppMethodBeat.o(146924);
    return i;
  }
  
  public int getPreModeParam()
  {
    AppMethodBeat.i(146925);
    int i = getKTVParam("vivo_ktv_preset_effect");
    AppMethodBeat.o(146925);
    return i;
  }
  
  public int getVoiceOutParam()
  {
    AppMethodBeat.i(146927);
    int i = getKTVParam("vivo_ktv_rec_source");
    AppMethodBeat.o(146927);
    return i;
  }
  
  public boolean isDeviceSupportKaraoke()
  {
    AppMethodBeat.i(146915);
    if (Build.MODEL.trim().contains("vivo"))
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(this.mAudioManager.getParameters("vivo_ktv_mic_type"), "=");
      if (localStringTokenizer.countTokens() != 2)
      {
        AppMethodBeat.o(146915);
        return false;
      }
      if (localStringTokenizer.nextToken().equals("vivo_ktv_mic_type"))
      {
        int i = Integer.parseInt(localStringTokenizer.nextToken());
        if ((i == 1) || (i == 0))
        {
          AppMethodBeat.o(146915);
          return true;
        }
      }
    }
    AppMethodBeat.o(146915);
    return false;
  }
  
  public void openKTVDevice()
  {
    AppMethodBeat.i(146916);
    this.mAudioManager.setParameters("vivo_ktv_mode=1");
    isDeviceSupportKaraoke();
    AppMethodBeat.o(146916);
  }
  
  public void setExtSpeakerParam(int paramInt)
  {
    AppMethodBeat.i(146922);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vivo_ktv_ext_speaker=").append(paramInt);
        this.mAudioManager.setParameters(localStringBuilder.toString());
      }
      AppMethodBeat.o(146922);
      return;
    }
  }
  
  public void setMicVolParam(int paramInt)
  {
    AppMethodBeat.i(146918);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vivo_ktv_volume_mic=").append(paramInt);
        this.mAudioManager.setParameters(localStringBuilder.toString());
      }
      AppMethodBeat.o(146918);
      return;
    }
  }
  
  public void setPlayFeedbackParam(int paramInt)
  {
    AppMethodBeat.i(146921);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null) {
        this.mAudioManager.setParameters("vivo_ktv_play_source=".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(146921);
      return;
    }
  }
  
  public void setPreModeParam(int paramInt)
  {
    AppMethodBeat.i(146920);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null) {
        this.mAudioManager.setParameters("vivo_ktv_preset_effect=".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(146920);
      return;
    }
  }
  
  public void setVoiceOutParam(int paramInt)
  {
    AppMethodBeat.i(146919);
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null) {
        this.mAudioManager.setParameters("vivo_ktv_rec_source=".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(146919);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.VivoKTVHelper
 * JD-Core Version:    0.7.0.1
 */