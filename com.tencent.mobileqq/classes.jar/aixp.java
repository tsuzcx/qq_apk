import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController.2;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aixp
  implements aixu
{
  private int jdField_a_of_type_Int;
  private aixr jdField_a_of_type_Aixr;
  private aixy jdField_a_of_type_Aixy;
  private aiyh jdField_a_of_type_Aiyh;
  private aiym jdField_a_of_type_Aiym;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private VoiceTextPanel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new aixq(this);
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public aixp(aixy paramaixy, QQAppInterface paramQQAppInterface, VoiceTextPanel paramVoiceTextPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel = paramVoiceTextPanel;
    this.jdField_a_of_type_Aixy = paramaixy;
    this.jdField_a_of_type_Aiym = new aiym(paramaixy, paramQQAppInterface, paramQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Aiyh = new aiyh(paramaixy, paramQQAppInterface, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Aixr = new aixr();
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aiym.a(paramBoolean);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Aixy.a().b())
    {
      aiyu.a("0X800A1DA", 3, 0);
      return;
    }
    aiyu.a("0X800A1DA", 2, 0);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Aixy.a().d())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aixy.a().b();
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString.length() > 150)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString.substring(0, 150);
      }
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_Aixy.a().a()) || (this.jdField_a_of_type_Aixy.a().b()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), anzj.a(2131715634), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299011));
      f();
      this.jdField_a_of_type_Aiyh.h();
      this.jdField_a_of_type_Aixr.c();
      this.jdField_a_of_type_Aiyh.a(this.jdField_a_of_type_Aixy.a().b());
      this.jdField_a_of_type_Aixy.a().a(5);
    }
  }
  
  private void o()
  {
    if (!bhsr.a(this.jdField_a_of_type_Aixy.a().b()))
    {
      this.jdField_a_of_type_Aixy.a().a(2);
      if (!this.jdField_a_of_type_Aiym.a()) {
        a(true);
      }
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextSttProcessController", 2, "sendRequest  net unAvailable");
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), anzj.a(2131715633), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299011));
    f();
    this.jdField_a_of_type_Aixy.a().a(5);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aiym.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel);
    this.jdField_a_of_type_Aiyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel);
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), anzj.a(2131715632), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299011));
    f();
    this.jdField_a_of_type_Aiyh.h();
    this.jdField_a_of_type_Aixr.c();
    this.jdField_a_of_type_Aiyh.a(this.jdField_a_of_type_Aixy.a().b());
    this.jdField_a_of_type_Aixy.a().a(5);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, QQRecorder.RecorderParam paramRecorderParam, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aiym.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_Aiyh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_Aixr.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramBaseChatPie.b(), paramBaseChatPie.a());
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Aixy.a().c()) || (this.jdField_a_of_type_Aixy.a().f()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextSttProcessController", 2, "updateText has finish");
      }
      return;
    }
    this.jdField_a_of_type_Aixy.a().b(paramString);
    o();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aiyh.e();
  }
  
  public void b(String paramString)
  {
    if (bhsr.a(paramString)) {
      a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aiym.a();
      return;
      a(true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aixy.a().a(3);
    this.jdField_a_of_type_Aiyh.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new VoiceTextSttProcessController.2(this));
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aixy.a().a(4);
  }
  
  public void e()
  {
    if (this.b == null) {
      return;
    }
    if (!bhnv.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext()))
    {
      p();
      return;
    }
    ahod.b = true;
    aiyu.a("0X800A1D7", 0, 0);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Aixy.a().a(1);
    this.jdField_a_of_type_Aixr.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Aiyh.g();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aiym.d();
    this.jdField_a_of_type_Aiyh.a().setFocusableInTouchMode(true);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Aiyh.d();
    this.jdField_a_of_type_Aixr.b();
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
    this.jdField_a_of_type_Aiyh.h();
  }
  
  public void i()
  {
    g();
    this.jdField_a_of_type_Aiyh.c();
    this.jdField_a_of_type_Aiym.c();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Aixy.a().d()) && (this.jdField_a_of_type_Aixy.a().c()))
    {
      m();
      if (this.jdField_a_of_type_Aixy.a().d()) {}
      for (int i = 2;; i = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_a_of_type_JavaLangString, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, false, i);
        aiyu.a("0X800A1DA", 1, 0);
        return;
      }
    }
    aeau localaeau = new aeau();
    ArrayList localArrayList = new ArrayList();
    aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aixy.a(), localArrayList, localaeau);
    l();
  }
  
  public void k()
  {
    this.jdField_a_of_type_Aiym.b();
    this.jdField_a_of_type_Aiyh.b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    this.jdField_a_of_type_Aixr.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixp
 * JD-Core Version:    0.7.0.1
 */