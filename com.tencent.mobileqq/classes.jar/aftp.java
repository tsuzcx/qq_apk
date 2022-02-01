import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aftp
  implements afrc, Handler.Callback, azfx, azgb, azgd
{
  private volatile int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private azfg jdField_a_of_type_Azfg;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 120;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  
  public aftp(BaseChatPie paramBaseChatPie)
  {
    if (azhh.a().b())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
      if ((paramBaseChatPie != null) && (paramBaseChatPie.app != null)) {
        this.jdField_a_of_type_Azfg = ((azfg)paramBaseChatPie.app.getManager(387));
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131719586);
      this.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131719566);
      this.jdField_c_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131719589);
      if ((paramBaseChatPie != null) && (paramBaseChatPie.app != null))
      {
        if (!VipUtils.b(paramBaseChatPie.app)) {
          break label132;
        }
        this.jdField_b_of_type_Int = 300;
      }
    }
    label132:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!VipUtils.c(paramBaseChatPie.app));
      this.jdField_b_of_type_Int = 180;
      return;
    }
    QLog.d("VoiceMessageHelper", 2, "VoiceMessageHelper not allow");
  }
  
  private String a(int paramInt)
  {
    int i = paramInt / 60;
    StringBuffer localStringBuffer = new StringBuffer();
    if (i > 0) {
      localStringBuffer.append(i).append("'");
    }
    localStringBuffer.append(paramInt % 60).append("\"");
    return localStringBuffer.toString();
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  private void a(azfx paramazfx)
  {
    if (this.jdField_a_of_type_Azfg != null) {
      this.jdField_a_of_type_Azfg.a(paramazfx);
    }
  }
  
  private void a(azgb paramazgb)
  {
    if (this.jdField_a_of_type_Azfg != null) {
      this.jdField_a_of_type_Azfg.a(paramazgb);
    }
  }
  
  private void a(azgd paramazgd)
  {
    if (this.jdField_a_of_type_Azfg != null) {
      this.jdField_a_of_type_Azfg.a(paramazgd);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Azfg != null)
    {
      this.jdField_a_of_type_Azfg.a(3, null);
      i();
      j();
      a(null);
      this.jdField_a_of_type_Azfg.a(azgj.b());
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Azfg == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)) {}
    azdu localazdu;
    File localFile;
    do
    {
      return;
      localazdu = this.jdField_a_of_type_Azfg.a().a();
      localFile = new File(localazdu.jdField_a_of_type_JavaLangString);
    } while ((TextUtils.isEmpty(localazdu.jdField_a_of_type_JavaLangString)) || (!localFile.exists()));
    double d = QQRecorder.a(localFile.length(), 16000);
    azeu.a("VoiceMessageHelper", String.format("send ptt, voice path:%s, \nvoice len:%s, duration:%s, f duration:%s", new Object[] { localazdu.jdField_a_of_type_JavaLangString, Long.valueOf(localFile.length()), Long.valueOf(localazdu.jdField_a_of_type_Long), Double.valueOf(d) }));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sendPtt(localazdu.jdField_a_of_type_JavaLangString, 6, (int)localazdu.jdField_a_of_type_Long, localazdu.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, true, 0);
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Boolean = true;
    j();
    if (this.jdField_a_of_type_Azfg != null)
    {
      if (!this.jdField_a_of_type_Azfg.b()) {
        break label56;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMessageHelper", 2, "dealCreate PanelShow");
      }
      a(this);
      a(this);
    }
    for (;;)
    {
      a(this);
      return;
      label56:
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMessageHelper", 2, "dealCreate Panel not show");
      }
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceMessageHelper", 2, "dealDestroy");
    }
    this.jdField_a_of_type_Boolean = false;
    j();
    a(null);
    a(null);
    a(null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMessageHelper", 2, "onEnterPanel");
      }
      j();
      a(this);
    }
  }
  
  public void a(int paramInt)
  {
    if (azhh.a().b()) {}
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      k();
      return;
    }
    l();
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Boolean)
    {
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = true;
      }
    }
    this.jdField_b_of_type_Boolean = bool1;
  }
  
  public int[] a()
  {
    return new int[] { 3, 13 };
  }
  
  public void b()
  {
    j();
    a(null);
    a(null);
  }
  
  public void c()
  {
    j();
    a(null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceMessageHelper", 2, "onResendRecord");
    }
    j();
    a(this);
    a(this);
    g();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceMessageHelper", 2, "onSureSend");
    }
    i();
    j();
    a(null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Azfg != null)
    {
      String str2 = "";
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTitleText != null) {
          str1 = String.format(BaseApplicationImpl.getContext().getString(2131718125), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTitleText.getText().toString() });
        }
      }
      this.jdField_a_of_type_Azfg.a(azgj.b(str1));
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Azfg != null) && (this.jdField_a_of_type_Azfg.b()))
    {
      j();
      a(1, 1000L);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((this.jdField_a_of_type_Azfg == null) || (!this.jdField_a_of_type_Azfg.b()));
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int)
      {
        h();
        return false;
      }
      if (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int > 10) {
        break label282;
      }
      this.jdField_a_of_type_Azfg.a(azgj.a(a(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_Azfg.b();
    }
    label282:
    for (int i = 1;; i = 0)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_c_of_type_Int += 1;
        if (this.jdField_c_of_type_Int > 3)
        {
          h();
          return false;
        }
      }
      else
      {
        this.jdField_c_of_type_Int = 0;
      }
      if (i == 0) {
        this.jdField_a_of_type_Azfg.a(azgj.a(a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        a(1, 1000L);
        return false;
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_Azfg.a(1, null);
          this.jdField_a_of_type_Azfg.a(azgj.a(a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftp
 * JD-Core Version:    0.7.0.1
 */