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

public class ahsa
  implements ahsf
{
  private int jdField_a_of_type_Int;
  private ahsc jdField_a_of_type_Ahsc;
  private ahsj jdField_a_of_type_Ahsj;
  private ahss jdField_a_of_type_Ahss;
  private ahsx jdField_a_of_type_Ahsx;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private VoiceTextPanel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ahsb(this);
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public ahsa(ahsj paramahsj, QQAppInterface paramQQAppInterface, VoiceTextPanel paramVoiceTextPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel = paramVoiceTextPanel;
    this.jdField_a_of_type_Ahsj = paramahsj;
    this.jdField_a_of_type_Ahsx = new ahsx(paramahsj, paramQQAppInterface, paramQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Ahss = new ahss(paramahsj, paramQQAppInterface, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ahsc = new ahsc();
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ahsx.a(paramBoolean);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Ahsj.a().b())
    {
      ahtf.a("0X800A1DA", 3, 0);
      return;
    }
    ahtf.a("0X800A1DA", 2, 0);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Ahsj.a().d())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ahsj.a().b();
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString.length() > 150)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_JavaLangString.substring(0, 150);
      }
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_Ahsj.a().a()) || (this.jdField_a_of_type_Ahsj.a().b()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), amtj.a(2131715868), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299076));
      f();
      this.jdField_a_of_type_Ahss.h();
      this.jdField_a_of_type_Ahsc.c();
      this.jdField_a_of_type_Ahss.a(this.jdField_a_of_type_Ahsj.a().b());
      this.jdField_a_of_type_Ahsj.a().a(5);
    }
  }
  
  private void o()
  {
    if (!StringUtil.isEmpty(this.jdField_a_of_type_Ahsj.a().b()))
    {
      this.jdField_a_of_type_Ahsj.a().a(2);
      if (!this.jdField_a_of_type_Ahsx.a()) {
        a(true);
      }
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextSttProcessController", 2, "sendRequest  net unAvailable");
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), amtj.a(2131715867), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299076));
    f();
    this.jdField_a_of_type_Ahsj.a().a(5);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ahsx.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel);
    this.jdField_a_of_type_Ahss.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel);
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), amtj.a(2131715866), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDimensionPixelSize(2131299076));
    f();
    this.jdField_a_of_type_Ahss.h();
    this.jdField_a_of_type_Ahsc.c();
    this.jdField_a_of_type_Ahss.a(this.jdField_a_of_type_Ahsj.a().b());
    this.jdField_a_of_type_Ahsj.a().a(5);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, QQRecorder.RecorderParam paramRecorderParam, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ahsx.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_Ahss.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
    this.jdField_a_of_type_Ahsc.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramBaseChatPie.getCurType(), paramBaseChatPie.getCurFriendUin());
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Ahsj.a().c()) || (this.jdField_a_of_type_Ahsj.a().f()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextSttProcessController", 2, "updateText has finish");
      }
      return;
    }
    this.jdField_a_of_type_Ahsj.a().b(paramString);
    o();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ahss.e();
  }
  
  public void b(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahsx.a();
      return;
      a(true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ahsj.a().a(3);
    this.jdField_a_of_type_Ahss.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new VoiceTextSttProcessController.2(this));
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ahsj.a().a(4);
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
    agkq.b = true;
    ahtf.a("0X800A1D7", 0, 0);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Ahsj.a().a(1);
    this.jdField_a_of_type_Ahsc.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Ahss.g();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Ahsx.d();
    this.jdField_a_of_type_Ahss.a().setFocusableInTouchMode(true);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Ahss.d();
    this.jdField_a_of_type_Ahsc.b();
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
    this.jdField_a_of_type_Ahss.h();
  }
  
  public void i()
  {
    g();
    this.jdField_a_of_type_Ahss.c();
    this.jdField_a_of_type_Ahsx.c();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Ahsj.a().d()) && (this.jdField_a_of_type_Ahsj.a().c()))
    {
      m();
      if (this.jdField_a_of_type_Ahsj.a().d()) {}
      for (int i = 2;; i = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sendPtt(this.jdField_a_of_type_JavaLangString, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, false, i);
        ahtf.a("0X800A1DA", 1, 0);
        return;
      }
    }
    acwc localacwc = new acwc();
    ArrayList localArrayList = new ArrayList();
    acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Ahsj.a(), localArrayList, localacwc);
    l();
  }
  
  public void k()
  {
    this.jdField_a_of_type_Ahsx.b();
    this.jdField_a_of_type_Ahss.b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    this.jdField_a_of_type_Ahsc.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsa
 * JD-Core Version:    0.7.0.1
 */