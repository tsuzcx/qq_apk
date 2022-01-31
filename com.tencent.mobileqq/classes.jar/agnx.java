import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class agnx
  extends apxc
{
  agnx(agnp paramagnp) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, apyc paramapyc, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, String.format("onGetUnLimitFriendInfo() success=%s uinType=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
    if ((paramBoolean) && (paramapyc != null)) {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.7.1(this, paramInt2, paramapyc));
    }
  }
  
  protected void a(boolean paramBoolean, apyo paramapyo, int paramInt)
  {
    if ((paramBoolean) && (paramapyo != null))
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramapyo, this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.a.g, this.a.L);
      agnp.a(this.a, paramapyo.mNickName);
      this.a.e.setText(paramapyo.mNickName);
      if ((!TextUtils.isEmpty(paramapyo.mNickName)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramapyo.mNickName;
      }
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    agnp.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnx
 * JD-Core Version:    0.7.0.1
 */