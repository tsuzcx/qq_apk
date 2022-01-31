import android.text.TextUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;

class ajyu
  extends ajxj
{
  ajyu(ajyt paramajyt) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "onGetFriendDateNick.isSuccess=" + paramBoolean + ",uin=" + paramString1 + ",nick=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin)) || (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        this.a.jdField_a_of_type_JavaLangString = paramString2;
      }
      if ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing()))
      {
        if (this.a.jdField_a_of_type_Int == 0) {
          this.a.jdField_a_of_type_Int = 1;
        }
        while (this.a.jdField_a_of_type_Int == 3)
        {
          this.a.c();
          ajyt.a(this.a);
          return;
          if (this.a.jdField_a_of_type_Int == 2) {
            this.a.jdField_a_of_type_Int = 3;
          }
        }
      }
    }
  }
  
  protected void onStrangerHeadReady(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "onStrangerHeadReady.isSuccess=" + paramBoolean + ",id=" + paramString1 + ",idType=" + paramInt + ",downloadUrl=" + paramString2);
    }
    if ((paramInt != 200) || (TextUtils.isEmpty(paramString1)) || (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin))) {}
    for (;;)
    {
      return;
      this.a.b = paramString2;
      if ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing()))
      {
        if (this.a.jdField_a_of_type_Int == 0) {
          this.a.jdField_a_of_type_Int = 2;
        }
        while (this.a.jdField_a_of_type_Int == 3)
        {
          this.a.c();
          ajyt.a(this.a);
          return;
          if (this.a.jdField_a_of_type_Int == 1) {
            this.a.jdField_a_of_type_Int = 3;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajyu
 * JD-Core Version:    0.7.0.1
 */