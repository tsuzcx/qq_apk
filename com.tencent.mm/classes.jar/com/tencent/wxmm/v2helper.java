package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;

public class v2helper
{
  public static final int AUDIO_DATA_FMT_AMR = 1;
  public static final int AUDIO_DATA_FMT_MP3 = 3;
  public static final int AUDIO_DATA_FMT_MP4 = 2;
  public static final int AUDIO_DATA_FMT_PCM = 0;
  public static final int AUDIO_PLAYER_GETPLAYBACKHEADPOSITION_EXCEPTION = 7;
  public static final int AUDIO_PLAYER_MINBUFFER_ERROR = 1;
  public static final int AUDIO_PLAYER_NEWAUDIOTRACK_ERROR = 2;
  public static final int AUDIO_PLAYER_NEWAUDIOTRACK_EXCEPTION = 6;
  public static final int AUDIO_PLAYER_PLAY_ERROR = 4;
  public static final int AUDIO_PLAYER_SECNEWAUDIOTRACK_ERROR = 3;
  public static final int AUDIO_PLAYER_SUCCESS = 0;
  public static final int AUDIO_PLAYER_WRITERET_ERROR = 5;
  public static final int AUDIO_RECORDER_DATAZERO_DISTORTION_ERROR = 8;
  public static final int AUDIO_RECORDER_DATAZERO_DISTORTION_READRET_ERROR = 11;
  public static final int AUDIO_RECORDER_DATAZERO_ERROR = 6;
  public static final int AUDIO_RECORDER_DATAZERO_READRET_ERROR = 9;
  public static final int AUDIO_RECORDER_DISTORTION_ERROR = 7;
  public static final int AUDIO_RECORDER_DISTORTION_READRET_ERROR = 10;
  public static final int AUDIO_RECORDER_MICROPHONE_MUTE_ERROR = 14;
  public static final int AUDIO_RECORDER_MINBUFFER_ERROR = 1;
  public static final int AUDIO_RECORDER_NEWAUDIORECORD_ERROR = 2;
  public static final int AUDIO_RECORDER_NEW_AUDIORECORD_EXCEPTION = 12;
  public static final int AUDIO_RECORDER_OPMARKEVENT_NEEDSHOWDLG = 13;
  public static final int AUDIO_RECORDER_READRET_ERROR = 5;
  public static final int AUDIO_RECORDER_SECNEWAUDIORECORD_ERROR = 3;
  public static final int AUDIO_RECORDER_STARTRECORDING_ERROR = 4;
  public static final int AUDIO_RECORDER_SUCCESS = 0;
  public static final int BUESINESS_TYPE_PSTN = 4;
  public static final int BUESINESS_TYPE_VOIP = 0;
  public static final int EMethodEhanceHeadsetEC = 416;
  public static final int EMethodEnableSpeakerEnhanceEC = 419;
  public static final int EMethodGetIosMicAbCheckFlag = 430;
  public static final int EMethodGraspMicAttempt = 403;
  public static final int EMethodHeadSetPlug = 425;
  public static final int EMethodInputVolumeScaleEnable = 414;
  public static final int EMethodMicDisable = 412;
  public static final int EMethodMicEnable = 413;
  public static final int EMethodMicRecDistSmall = 410;
  public static final int EMethodMicmuteSendPktCtrl = 434;
  public static final int EMethodOutputVolumeGainEnable = 422;
  public static final int EMethodOutputVolumeScaleEnable = 415;
  public static final int EMethodPcMicLevel = 427;
  public static final int EMethodSetAecmOff = 407;
  public static final int EMethodSetAecmOn = 406;
  public static final int EMethodSetAgcOff = 405;
  public static final int EMethodSetAgcOn = 404;
  public static final int EMethodSetAgcRxOn = 426;
  public static final int EMethodSetECModeLevelForHeadSet = 417;
  public static final int EMethodSetECModeLevelForSpeaker = 418;
  public static final int EMethodSetIosMicAbCheckOff = 429;
  public static final int EMethodSetIosMicAbCheckOn = 428;
  public static final int EMethodSetNgStrength = 423;
  public static final int EMethodSetNsOff = 409;
  public static final int EMethodSetNsOn = 408;
  public static final int EMethodSetPlayerPreCorrectCofOff = 421;
  public static final int EMethodSetPlayerPreCorrectCofOn = 420;
  public static final int EMethodSetSendToNetworkOff = 433;
  public static final int EMethodSetSendToNetworkOn = 432;
  public static final int EMethodSetSpeakerphoneOff = 402;
  public static final int EMethodSetSpeakerphoneOn = 401;
  public static final int EMethodSetSpkEnhance = 424;
  public static final int EMethodSetXnoiseSupFlag = 431;
  public static final int EMethodUsingRemoteIO = 411;
  public static final int ENet2G = 1;
  public static final int ENet3G = 3;
  public static final int ENet4G = 5;
  public static final int ENetNULL = 0;
  public static final int ENetNotWIFI = 2;
  public static final int ENetWIFI = 4;
  public static final int EXIT_REASON_APP_BROKEN = 7;
  public static final int EXIT_REASON_DEVICE_FAIL = 8;
  public static final int EXIT_REASON_MANUAL = 1;
  public static final int EXIT_REASON_PHONE_BROKEN = 6;
  public static final int EXIT_REASON_UNKNOWN = 0;
  public static final int HANGUP_REASON_APP_BROKEN = 7;
  public static final int HANGUP_REASON_BUSY_OTHER = 3;
  public static final int HANGUP_REASON_BUSY_PHONE = 2;
  public static final int HANGUP_REASON_DEVICE_FAIL = 8;
  public static final int HANGUP_REASON_MANUAL = 1;
  public static final int HANGUP_REASON_PHONE_BROKEN = 6;
  public static final int HANGUP_REASON_REPLY_BY_OTHER = 9;
  public static final int ROOM_TYPE_AUDIO = 2;
  public static final int ROOM_TYPE_UNKNOWN = 0;
  public static final int ROOM_TYPE_VIDEO = 1;
  public static final int SWITCHAV_CLOSE_VIDEO = 1;
  public static final int SWITCHAV_CLOSE_VIDEO_2G = 2;
  public static final int TYPE_IPCALL = 1;
  public static final int TYPE_MultiTalk = 3;
  public static final int TYPE_VOIP = 0;
  public static final int VOICE_CHANNELS = 1;
  public static final int VOICE_FRAME_BYTES = 640;
  public static final int VOICE_FRAME_DURATION = 20;
  public static final int VOICE_SAMPLERATE;
  public static final int VOIP_ENC_HEIGHT_LV1 = 360;
  public static final int VOIP_ENC_HEIGHT_LV2 = 480;
  public static final int VOIP_ENC_WIDTH_LV1 = 480;
  public static final int VOIP_ENC_WIDTH_LV2 = 640;
  public static final int WXCONF_ERR_AUTHKEY_EXPIRED = 4;
  public static final int WXCONF_ERR_FREQ_LIMITED = 3;
  public static final int WXCONF_ERR_INVALID_CALL = 1;
  public static final int WXCONF_ERR_NETWORK_FAIL = 2;
  public static final int WXCONF_ERR_NOT_FRIEND = 5;
  public static final int WXCONF_ERR_REMOTE_NOT_SUPPORT = 11;
  public static final int WXCONF_ERR_ROOM_CLOSED = 10;
  public static final int WXCONF_ERR_UNKNOWN = 0;
  public static final int WXCONF_EVENT_ACCEPT_FAIL = 13;
  public static final int WXCONF_EVENT_ACCEPT_SUCC = 12;
  public static final int WXCONF_EVENT_ACCEPT_TIMEOUT = 14;
  public static final int WXCONF_EVENT_ACK_FAIL = 11;
  public static final int WXCONF_EVENT_ACK_SUCC = 10;
  public static final int WXCONF_EVENT_ADD_FAIL = 16;
  public static final int WXCONF_EVENT_ADD_SUCC = 15;
  public static final int WXCONF_EVENT_AUTHKEY_EXPIRED = 23;
  public static final int WXCONF_EVENT_AVMEMBER_CHANGE = 18;
  public static final int WXCONF_EVENT_CALL_BROKEN = 21;
  public static final int WXCONF_EVENT_CALL_END = 22;
  public static final int WXCONF_EVENT_INVITE_FAIL = 4;
  public static final int WXCONF_EVENT_INVITE_SUCC = 3;
  public static final int WXCONF_EVENT_INVITE_TIMEOUT = 5;
  public static final int WXCONF_EVENT_JOIN_FAIL = 2;
  public static final int WXCONF_EVENT_JOIN_SUCC = 1;
  public static final int WXCONF_EVENT_MEMBER_CHANGE = 17;
  public static final int WXCONF_EVENT_RECV_INVITE = 6;
  public static final int WXCONF_EVENT_RECV_INVITE_BUSY = 7;
  public static final int WXCONF_EVENT_RECV_NOTIFY_FAIL = 9;
  public static final int WXCONF_EVENT_RECV_SIMU_CALL = 8;
  public static final int WXCONF_EVENT_TALK_FAIL = 20;
  public static final int WXCONF_EVENT_TALK_SUCC = 19;
  public static final int WXVOIP_ERR_AUTHKEY_EXPIRED = 4;
  public static final int WXVOIP_ERR_FREQ_LIMITED = 3;
  public static final int WXVOIP_ERR_INVALID_CALL = 1;
  public static final int WXVOIP_ERR_NETWORK_FAIL = 2;
  public static final int WXVOIP_ERR_NOT_FRIEND = 5;
  public static final int WXVOIP_ERR_REMOTE_NOT_SUPPORT = 11;
  public static final int WXVOIP_ERR_ROOM_CLOSED = 10;
  public static final int WXVOIP_ERR_UNKNOWN = 0;
  public static final int WXVOIP_EVENT_ACCEPT_FAIL = 12;
  public static final int WXVOIP_EVENT_ACCEPT_SUCC = 11;
  public static final int WXVOIP_EVENT_ACCEPT_TIMEOUT = 13;
  public static final int WXVOIP_EVENT_ACK_FAIL = 10;
  public static final int WXVOIP_EVENT_ACK_SUCC = 9;
  public static final int WXVOIP_EVENT_AUTHKEY_EXPIRED = 24;
  public static final int WXVOIP_EVENT_CALL_BEGIN = 1;
  public static final int WXVOIP_EVENT_CALL_BROKEN = 22;
  public static final int WXVOIP_EVENT_CALL_END = 23;
  public static final int WXVOIP_EVENT_INVITE_FAIL = 3;
  public static final int WXVOIP_EVENT_INVITE_SUCC = 2;
  public static final int WXVOIP_EVENT_INVITE_TIMEOUT = 4;
  public static final int WXVOIP_EVENT_NETWORK_POOR = 26;
  public static final int WXVOIP_EVENT_RECV_INVITE = 5;
  public static final int WXVOIP_EVENT_RECV_INVITE_BUSY = 6;
  public static final int WXVOIP_EVENT_RECV_NOTIFY_FAIL = 8;
  public static final int WXVOIP_EVENT_RECV_SIMU_CALL = 7;
  public static final int WXVOIP_EVENT_REMOTE_ACCEPT = 16;
  public static final int WXVOIP_EVENT_REMOTE_BUSY = 15;
  public static final int WXVOIP_EVENT_REMOTE_HANGUP = 18;
  public static final int WXVOIP_EVENT_REMOTE_REJECT = 17;
  public static final int WXVOIP_EVENT_REMOTE_RING = 14;
  public static final int WXVOIP_EVENT_REPLY_BY_OTHER = 19;
  public static final int WXVOIP_EVENT_SWITCH_AVCMD = 25;
  public static final int WXVOIP_EVENT_TALK_FAIL = 21;
  public static final int WXVOIP_EVENT_TALK_SUCC = 20;
  private static int cpuFlag0 = 1053;
  static BufferedOutputStream mOutputStream = null;
  
  static
  {
    VOICE_SAMPLERATE = 16000;
  }
  
  public static void Logd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40797);
    new StringBuilder("[").append(Thread.currentThread().getId()).append("]").append(paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(40797);
  }
  
  public static void Loge(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40795);
    new StringBuilder("[").append(Thread.currentThread().getId()).append("]").append(paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(40795);
  }
  
  public static void Logi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40796);
    new StringBuilder("[").append(Thread.currentThread().getId()).append("]").append(paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(40796);
  }
  
  public static void Logw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40798);
    new StringBuilder("[").append(Thread.currentThread().getId()).append("]").append(paramString2);
    writeLogToFile(paramString1 + ":" + paramString2 + " \n");
    AppMethodBeat.o(40798);
  }
  
  public static void closeLogFile()
  {
    AppMethodBeat.i(40794);
    if (mOutputStream != null) {}
    try
    {
      mOutputStream.close();
      label18:
      mOutputStream = null;
      AppMethodBeat.o(40794);
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public static void flushLogFile()
  {
    AppMethodBeat.i(40793);
    if (mOutputStream == null)
    {
      AppMethodBeat.o(40793);
      return;
    }
    try
    {
      mOutputStream.flush();
      AppMethodBeat.o(40793);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(40793);
    }
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(40799);
    paramArrayOfByte = new String(paramArrayOfByte);
    if (!paramString.equals("MicroMsg.v2Core"))
    {
      writeLogToFile(paramString + ":" + paramArrayOfByte + " \n");
      AppMethodBeat.o(40799);
      return;
    }
    writeLogToFile(paramString + ":" + paramArrayOfByte);
    AppMethodBeat.o(40799);
  }
  
  public static void writeLogToFile(String paramString)
  {
    AppMethodBeat.i(40792);
    if (mOutputStream == null)
    {
      AppMethodBeat.o(40792);
      return;
    }
    try
    {
      mOutputStream.write(paramString.getBytes());
      AppMethodBeat.o(40792);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(40792);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wxmm.v2helper
 * JD-Core Version:    0.7.0.1
 */