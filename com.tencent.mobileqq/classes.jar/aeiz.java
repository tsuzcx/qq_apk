import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class aeiz
  extends ajmm
{
  aeiz(aeiv paramaeiv) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2);
    }
    if (paramInt1 == 1005) {
      switch (paramInt2)
      {
      default: 
        bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131655005), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
    }
    for (;;)
    {
      this.a.e(196608);
      return;
      bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131655004), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      continue;
      if (paramInt1 == 1004)
      {
        switch (paramInt2)
        {
        default: 
          break;
        case 102: 
        case 103: 
        case 104: 
          paramString1 = String.format(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131626242), new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString1, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          break;
        }
      }
      else if (paramInt1 == 1000)
      {
        paramSendMessageHandler = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramSendMessageHandler = String.format(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131627579), new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        }
        switch (paramInt2)
        {
        default: 
          if (paramInt2 <= 100) {
            continue;
          }
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramSendMessageHandler, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          break;
        case 102: 
        case 103: 
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramSendMessageHandler, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "Grp_data", "forbid_temp", 0, 0, paramString1, "", "", "");
          break;
        case 104: 
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramSendMessageHandler, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          break;
        }
      }
      else if (paramInt1 == 1020)
      {
        switch (paramInt2)
        {
        default: 
          break;
        case 40: 
        case 102: 
        case 103: 
        case 104: 
          paramString1 = (HotChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
          paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131632257);
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString1, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          break;
        }
      }
      else if (paramInt1 == 1006)
      {
        switch (paramInt2)
        {
        default: 
          break;
        case 1600: 
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131626609), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          break;
        case 1601: 
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131626609), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          break;
        case 1602: 
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131626608), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          break;
        }
      }
      else if (paramInt1 == 1022)
      {
        switch (paramInt2)
        {
        default: 
          break;
        case 16: 
          aael.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          break;
        }
      }
      else if (paramInt1 == 1023)
      {
        bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "errorCode" + paramInt2, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      else if (paramInt1 == 1025)
      {
        switch (paramInt2)
        {
        default: 
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = "" + paramInt2;
          }
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString1, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          break;
        case 55: 
          bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ajjy.a(2131648776), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.m();
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.u = true;
    this.a.a(262144, null, paramLong);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.m();
      }
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.e(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeiz
 * JD-Core Version:    0.7.0.1
 */