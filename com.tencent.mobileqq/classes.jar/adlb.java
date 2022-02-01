import android.content.Intent;
import android.os.Handler;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AutoLoginHelper.1;
import com.tencent.mobileqq.activity.AutoLoginHelper.5;
import com.tencent.mobileqq.activity.AutoLoginHelper.6;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class adlb
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  azip jdField_a_of_type_Azip = new adld(this);
  private biaj jdField_a_of_type_Biaj;
  private bisl jdField_a_of_type_Bisl;
  private RegisterNewBaseActivity jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new adle(this);
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new adlc(this);
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public String b;
  public boolean b;
  private byte[] b;
  public String c;
  public boolean c;
  private byte[] c;
  private String d;
  public boolean d;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h = true;
  private boolean i = true;
  private boolean j;
  private boolean k;
  private boolean l;
  
  public adlb(QQAppInterface paramQQAppInterface, RegisterNewBaseActivity paramRegisterNewBaseActivity, Intent paramIntent)
  {
    this.jdField_b_of_type_JavaLangString = "86";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity = paramRegisterNewBaseActivity;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity == null) {}
    Object localObject;
    do
    {
      return;
      this.jdField_d_of_type_Boolean = true;
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.b);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("afterRegAndAutoLogin", true);
      ((Intent)localObject).addFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(LoginActivity.class);
    } while (localObject == null);
    ((MqqHandler)localObject).sendEmptyMessage(20140325);
  }
  
  private void i()
  {
    azit.a().a(true);
    azit.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a.post(new AutoLoginHelper.5(this));
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a.post(new AutoLoginHelper.6(this));
  }
  
  public Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      biaf.a(getClass().getSimpleName(), a());
    }
    this.g = a().getBooleanExtra("key_register_from_quick_register", false);
    if (this.g) {
      this.jdField_e_of_type_JavaLangString = a().getStringExtra("key_register_secret_phone");
    }
    this.jdField_a_of_type_JavaLangString = a().getStringExtra("phonenum");
    this.jdField_c_of_type_JavaLangString = a().getStringExtra("invite_code");
    this.jdField_b_of_type_JavaLangString = a().getStringExtra("key");
    this.jdField_a_of_type_Boolean = a().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_b_of_type_Boolean = a().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_d_of_type_JavaLangString = a().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = a().getByteArrayExtra("key_register_sign");
    this.jdField_c_of_type_ArrayOfByte = a().getByteArrayExtra("resp_register_supersig");
    Locale localLocale;
    String str2;
    String str3;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      str2 = this.jdField_d_of_type_JavaLangString;
      str3 = com.tencent.qphone.base.util.MD5.toMD5(this.jdField_a_of_type_ArrayOfByte);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label323;
      }
    }
    label323:
    for (String str1 = "";; str1 = this.jdField_c_of_type_JavaLangString)
    {
      QLog.d("AutoLoginHelper", 4, String.format(localLocale, "onCreate  uin: %s, sign: %s inviteCode: %s", new Object[] { str2, str3, str1 }));
      str1 = a().getStringExtra("key_register_password");
      if (str1 != null) {
        this.jdField_b_of_type_ArrayOfByte = com.tencent.mobileqq.mqsafeedit.MD5.toMD5Byte(str1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "onCreate ,pwd = " + str1 + ",mPassByte = " + this.jdField_b_of_type_ArrayOfByte);
      }
      this.f = a().getBooleanExtra("key_register_unbind", false);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break;
      }
      QLog.d("AutoLoginHelper", 2, "onCreate app is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azip);
    this.h = a().getBooleanExtra("key_register_result", true);
    this.i = a().getBooleanExtra("key_register_is_lh", false);
    if ((this.h) && (this.i))
    {
      this.k = false;
      this.l = true;
      this.jdField_a_of_type_Biaj = new biaj(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, null);
      this.jdField_a_of_type_Biaj.a(this.jdField_d_of_type_JavaLangString, new adlf(this));
    }
    this.jdField_d_of_type_Boolean = false;
    b();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_d_of_type_JavaLangString))) {
      return;
    }
    this.j = paramBoolean;
    if ((!this.j) && (this.k))
    {
      k();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131716452, 0);
    }
    for (;;)
    {
      this.k = false;
      this.l = false;
      return;
      if ((this.j) && (this.k)) {
        if (this.f) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime().login(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
        } else {
          azir.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void b()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(RegisterPhoneNumActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(103);
    }
    localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(RegisterPersonalInfoActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(109);
    }
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterSendUpSms))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(RegisterSendUpSms.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(107);
      }
    }
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterVerifyCodeActivity))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(RegisterVerifyCodeActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(106);
      }
    }
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterByNicknameAndPwdActivity))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(RegisterByNicknameAndPwdActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(110);
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onAccountChanged success");
    }
    if (this.f)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azip);
      if (this.g)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime());
        LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      }
      j();
      h();
    }
    do
    {
      return;
      if (azit.a().a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AutoLoginHelper", 2, "onAccountChanged not phonenum login");
    return;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azip);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azip);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new AutoLoginHelper.1(this));
      QQToast.a(BaseApplicationImpl.sApplication, anvx.a(2131700338), 0).a();
    }
    j();
    LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    h();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azip);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.c();
    k();
  }
  
  public void e()
  {
    if (!this.h) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
      }
    }
    do
    {
      return;
      if (this.g) {
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072FC", "0X80072FC", 0, 0, "", "", "", "");
      }
      if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131692125, 0);
    return;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    if ((this.i) && (!this.j))
    {
      if (!this.l)
      {
        this.l = true;
        if (this.jdField_a_of_type_Biaj == null) {
          this.jdField_a_of_type_Biaj = new biaj(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, null);
        }
        this.jdField_a_of_type_Biaj.a(this.jdField_d_of_type_JavaLangString, new adlf(this));
      }
      this.k = true;
      j();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
    }
    j();
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        break label279;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "swz mSign = " + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      }
    }
    while (this.f)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime().login(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
      label279:
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "swz mSign = null");
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AutoLoginHelper", 4, String.format(Locale.getDefault(), "onClick  uin: %s, sign: %s", new Object[] { this.jdField_d_of_type_JavaLangString, com.tencent.qphone.base.util.MD5.toMD5(this.jdField_a_of_type_ArrayOfByte) }));
    }
    azir.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_JavaLangString);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoLoginHelper", 2, "onResume， isStartingMain=" + this.jdField_d_of_type_Boolean);
    }
    if (!this.jdField_d_of_type_Boolean) {
      k();
    }
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlb
 * JD-Core Version:    0.7.0.1
 */