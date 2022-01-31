import android.content.Context;
import android.util.Log;
import com.tencent.TMG.channel.AVAppChannel;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.logger.AVLoggerChooser;
import com.tencent.TMG.sdk.AVAudioCtrl;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.TMG.sdk.AVCustomSpearEngineCtrl;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam.Builder;
import com.tencent.TMG.sdk.AVRoomMulti.EventListener;
import com.tencent.qphone.base.util.QLog;

public class ajla
{
  private static ajla jdField_a_of_type_Ajla;
  private static String b = "LimixiuAVManager";
  ajlc jdField_a_of_type_Ajlc = null;
  ajld jdField_a_of_type_Ajld = null;
  ajle jdField_a_of_type_Ajle = null;
  private Context jdField_a_of_type_AndroidContentContext;
  AVContext jdField_a_of_type_ComTencentTMGSdkAVContext = null;
  private AVRoomMulti.EventListener jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener = new ajlb(this);
  String jdField_a_of_type_JavaLangString = null;
  
  private ajla(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = "user";
  }
  
  public static ajla a(Context paramContext)
  {
    if (jdField_a_of_type_Ajla == null) {}
    try
    {
      if (jdField_a_of_type_Ajla == null) {
        jdField_a_of_type_Ajla = new ajla(paramContext);
      }
      return jdField_a_of_type_Ajla;
    }
    finally {}
  }
  
  private AVContext.StartParam a()
  {
    ajkr localajkr = new ajkr();
    localajkr.sdkAppId = Integer.parseInt(this.jdField_a_of_type_Ajlc.jdField_a_of_type_JavaLangString);
    localajkr.accountType = this.jdField_a_of_type_Ajlc.b;
    localajkr.appIdAt3rd = this.jdField_a_of_type_Ajlc.jdField_a_of_type_JavaLangString;
    localajkr.identifier = this.jdField_a_of_type_Ajlc.c;
    localajkr.engineCtrlType = 2;
    localajkr.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Ajlc.f).intValue();
    localajkr.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_Ajlc.g).longValue();
    QLog.i("AVManager", 1, "getStartParams|param.sdkAppId=" + localajkr.sdkAppId + ", param.accountType=" + localajkr.accountType + ", param.appIdAt3rd=" + localajkr.appIdAt3rd + ", param.identifier=" + localajkr.identifier + ", param.engineCtrlType=" + localajkr.engineCtrlType + ", param.nGameID=" + localajkr.jdField_a_of_type_Int + ", param.lGameRoomID=" + localajkr.jdField_a_of_type_Long);
    return localajkr;
  }
  
  private AVRoomMulti.EnterParam a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    QLog.e("AVManager", 1, "getEnterRoomParam roomID=" + paramString + ", roomRoleValue=" + str + ", videoRecvMode=" + paramInt + ", screenRecMode=" + 0 + ", mic=" + paramBoolean1 + ", speaker=" + paramBoolean2);
    return new AVRoomMulti.EnterParam.Builder(Integer.parseInt(paramString)).avControlRole(str).autoCreateRoom(true).videoRecvMode(paramInt).screenRecvMode(0).isEnableMic(paramBoolean1).isEnableSpeaker(paramBoolean2).isEnableHwEnc(true).isEnableHwDec(true).build();
  }
  
  public int a()
  {
    int i = 1003;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      i = this.jdField_a_of_type_ComTencentTMGSdkAVContext.stop();
    }
    QLog.i("AVManager", 1, "stopContext|ret=" + i);
    return i;
  }
  
  public AVContext a()
  {
    return this.jdField_a_of_type_ComTencentTMGSdkAVContext;
  }
  
  public AVCustomSpearEngineCtrl a()
  {
    return a().getCustomSpearEngineCtrl();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.destroy();
    }
    this.jdField_a_of_type_ComTencentTMGSdkAVContext = null;
    QLog.e("AVManager", 1, "destroyContext");
  }
  
  public void a(long paramLong)
  {
    QLog.i("AVManager", 1, "setGameRoomID|lGameRoomID=" + paramLong);
    this.jdField_a_of_type_Ajlc.g = String.valueOf(paramLong);
  }
  
  public void a(ajlc paramajlc)
  {
    this.jdField_a_of_type_Ajlc = paramajlc;
  }
  
  public void a(ajle paramajle)
  {
    this.jdField_a_of_type_Ajle = paramajle;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(AVCallback paramAVCallback)
  {
    int i = 0;
    AVChannelManager.setIMChannelType(2);
    com.tencent.TMG.utils.SoUtil.customLibPath = ajlj.a();
    AVLoggerChooser.setUseImsdk(false);
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      this.jdField_a_of_type_ComTencentTMGSdkAVContext = AVContext.createInstance(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      if (AVContext.getSoExtractError() != 0) {
        i = AVContext.getSoExtractError();
      }
    }
    for (;;)
    {
      QLog.i("AVManager", 1, "startContext|ret=" + i);
      if (i != 0) {
        paramAVCallback.onComplete(i, "internal error.");
      }
      return;
      i = 1101;
      continue;
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.setAppVersion(this.jdField_a_of_type_Ajlc.e);
      AVChannelManager.setAppChannel(new ajlf());
      AVChannelManager.getAppChannel().loginWithParam(a());
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.start(a(), null, paramAVCallback);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, ajld paramajld)
  {
    QLog.i("AVManager", 1, "enterRoom.");
    this.jdField_a_of_type_Ajld = paramajld;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null)
    {
      Log.e("AVManager", "enterRoom| enter room faild, because of context not started.");
      if (this.jdField_a_of_type_Ajld != null) {
        this.jdField_a_of_type_Ajld.a(1101, "context not started.");
      }
      return;
    }
    AVChannelManager.getAppChannel().loginWithParam(a());
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl().startTRAEService();
    QLog.e("AVManager", 1, "enterRoom| try enter room implement!!!!!!!!!");
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.enterRoom(this.jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener, a(paramString, paramBoolean1, paramBoolean2, paramInt));
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableMicCompleteCallback paramEnableMicCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableMic(paramBoolean, paramEnableMicCompleteCallback);
    }
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableSpeaker(paramBoolean, paramEnableSpeakerCompleteCallback);
    }
  }
  
  public int b()
  {
    int i = 1003;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      i = this.jdField_a_of_type_ComTencentTMGSdkAVContext.exitRoom();
    }
    QLog.i("AVManager", 1, "exitRoom|ret=" + i);
    return i;
  }
  
  public void b()
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null)
    {
      localAVAudioCtrl.PauseAudioByUser();
      localAVAudioCtrl.stopTRAEService();
    }
  }
  
  public void b(long paramLong)
  {
    QLog.i("AVManager", 1, "setGameID|lGameID=" + paramLong);
    this.jdField_a_of_type_Ajlc.f = String.valueOf(paramLong);
  }
  
  public void c()
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null)
    {
      localAVAudioCtrl.ResumeAudioByUser();
      localAVAudioCtrl.startTRAEService();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajla
 * JD-Core Version:    0.7.0.1
 */