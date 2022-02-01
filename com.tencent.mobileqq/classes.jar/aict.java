import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aict
  extends asgf
{
  aict(aicl paramaicl) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, ashh paramashh, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, String.format("onGetUnLimitFriendInfo() success=%s uinType=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
    if ((paramBoolean) && (paramashh != null)) {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.7.1(this, paramInt2, paramashh));
    }
  }
  
  protected void a(boolean paramBoolean, asht paramasht, int paramInt)
  {
    if ((paramBoolean) && (paramasht != null))
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramasht, this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.a.g, this.a.K);
      aicl.a(this.a, paramasht.mNickName);
      this.a.e.setText(paramasht.mNickName);
      if ((!TextUtils.isEmpty(paramasht.mNickName)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramasht.mNickName;
      }
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    aicl.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aict
 * JD-Core Version:    0.7.0.1
 */