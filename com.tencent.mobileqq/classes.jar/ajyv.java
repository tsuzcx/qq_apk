import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatShare.2;
import com.tencent.mobileqq.app.HotChatShare.3;
import com.tencent.mobileqq.app.HotChatShare.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;

public class ajyv
{
  public int a;
  private ajxl jdField_a_of_type_Ajxl = new ajyw(this);
  public bcpq a;
  public BaseActivity a;
  public QQAppInterface a;
  public HotChatInfo a;
  String jdField_a_of_type_JavaLangString = null;
  public String b = null;
  
  public ajyv(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramHotChatInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
    ThreadManager.post(new HotChatShare.2(this, paramQQAppInterface), 8, null, true);
  }
  
  private void d()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.joinUrl != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.joinUrl.indexOf("hotnamecode=");
      if (i == -1) {}
    }
    for (String str1 = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.joinUrl.substring(i + 12);; str1 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatShare", 2, "handleHotChatShare.mTroop.joinUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.joinUrl + ",hotnamecode=" + str1);
      }
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      String str3 = ajyk.a(str1, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate);
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate != 1)
      {
        ajyk.a(2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, str3, str1, ajyc.a(2131705593) + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name + ajyc.a(2131705588), ajyc.a(2131705590), null, null);
        return;
      }
      String str2 = ajyc.a(2131705587);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        str2 = ajyc.a(2131705591) + this.jdField_a_of_type_JavaLangString + ajyc.a(2131705592);
      }
      String str4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin, 200);
      ajyk.a(2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, str3, str1, ajyc.a(2131705586) + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name + ajyc.a(2131705589), str2, this.b, str4);
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramHotChatInfo;
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.info=" + paramHotChatInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate != 1)
    {
      d();
      return;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = bbcl.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Int = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.ownerNickname=" + this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.b))
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label193;
      }
      this.jdField_a_of_type_Int = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatShare", 2, "handleShare.ownerHeadUrl=" + this.b);
      }
      if (this.jdField_a_of_type_Int != 3) {
        break;
      }
      d();
      return;
      label193:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Int = 3;
      }
    }
    b();
    ThreadManager.post(new HotChatShare.3(this), 8, null, false);
    new Handler().postDelayed(new HotChatShare.4(this), 30000L);
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Bcpq == null)
      {
        this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_Bcpq.c(2131694930);
      }
      this.jdField_a_of_type_Bcpq.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("HotChatShare", 2, localException.toString());
    }
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
        this.jdField_a_of_type_Bcpq.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("HotChatShare", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajyv
 * JD-Core Version:    0.7.0.1
 */