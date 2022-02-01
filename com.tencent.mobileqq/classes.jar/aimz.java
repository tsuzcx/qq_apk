import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController.2;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aimz
  implements aine
{
  private int jdField_a_of_type_Int;
  private ainb jdField_a_of_type_Ainb;
  private aini jdField_a_of_type_Aini;
  private ainr jdField_a_of_type_Ainr;
  private ainw jdField_a_of_type_Ainw;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private VoiceTextPanel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new aina(this);
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public aimz(aini paramaini, QQAppInterface paramQQAppInterface, VoiceTextPanel paramVoiceTextPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel = paramVoiceTextPanel;
    this.jdField_a_of_type_Aini = paramaini;
    this.jdField_a_of_type_Ainw = new ainw(paramaini, paramQQAppInterface, paramQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Ainr = new ainr(paramaini, paramQQAppInterface, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ainb = new ainb();
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ainw.a(paramBoolean);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Aini.a().b())
    {
      aioe.a("0X800A1DA", 3, 0);
      return;
    }
    aioe.a("0X800A1DA", 2, 0);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Aini.a().d())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aini.a().b();
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString.length() > 150)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString.substring(0, 150);
      }
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_Aini.a().a()) || (this.jdField_a_of_type_Aini.a().b()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), anvx.a(2131716216), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299080));
      f();
      this.jdField_a_of_type_Ainr.h();
      this.jdField_a_of_type_Ainb.c();
      this.jdField_a_of_type_Ainr.a(this.jdField_a_of_type_Aini.a().b());
      this.jdField_a_of_type_Aini.a().a(5);
    }
  }
  
  private void o()
  {
    if (!StringUtil.isEmpty(this.jdField_a_of_type_Aini.a().b()))
    {
      this.jdField_a_of_type_Aini.a().a(2);
      if (!this.jdField_a_of_type_Ainw.a()) {
        a(true);
      }
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextSttProcessController", 2, "sendRequest  net unAvailable");
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), anvx.a(2131716215), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299080));
    f();
    this.jdField_a_of_type_Aini.a().a(5);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ainw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel);
    this.jdField_a_of_type_Ainr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel);
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), anvx.a(2131716214), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299080));
    f();
    this.jdField_a_of_type_Ainr.h();
    this.jdField_a_of_type_Ainb.c();
    this.jdField_a_of_type_Ainr.a(this.jdField_a_of_type_Aini.a().b());
    this.jdField_a_of_type_Aini.a().a(5);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, QQRecorder.RecorderParam paramRecorderParam, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ainw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_Ainr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_Ainb.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramBaseChatPie.getCurType(), paramBaseChatPie.getCurFriendUin());
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Aini.a().c()) || (this.jdField_a_of_type_Aini.a().f()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextSttProcessController", 2, "updateText has finish");
      }
      return;
    }
    this.jdField_a_of_type_Aini.a().b(paramString);
    o();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ainr.e();
  }
  
  public void b(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ainw.a();
      return;
      a(true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aini.a().a(3);
    this.jdField_a_of_type_Ainr.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new VoiceTextSttProcessController.2(this));
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aini.a().a(4);
  }
  
  public void e()
  {
    if (this.b == null) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext()))
    {
      p();
      return;
    }
    ahdg.b = true;
    aioe.a("0X800A1D7", 0, 0);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Aini.a().a(1);
    this.jdField_a_of_type_Ainb.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Ainr.g();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Ainw.d();
    this.jdField_a_of_type_Ainr.a().setFocusableInTouchMode(true);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Ainr.d();
    this.jdField_a_of_type_Ainb.b();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    }
    g();
    this.jdField_a_of_type_Ainr.h();
  }
  
  public void i()
  {
    g();
    this.jdField_a_of_type_Ainr.c();
    this.jdField_a_of_type_Ainw.c();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Aini.a().d()) && (this.jdField_a_of_type_Aini.a().c()))
    {
      m();
      if (this.jdField_a_of_type_Aini.a().d()) {}
      for (int i = 2;; i = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sendPtt(this.jdField_a_of_type_JavaLangString, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, false, i);
        aioe.a("0X800A1DA", 1, 0);
        return;
      }
    }
    admo localadmo = new admo();
    ArrayList localArrayList = new ArrayList();
    admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aini.a(), localArrayList, localadmo);
    l();
  }
  
  public void k()
  {
    this.jdField_a_of_type_Ainw.b();
    this.jdField_a_of_type_Ainr.b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    this.jdField_a_of_type_Ainb.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimz
 * JD-Core Version:    0.7.0.1
 */