import android.widget.TextView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aeqz
  extends aoeu
{
  aeqz(aequ paramaequ) {}
  
  protected void a(boolean paramBoolean, aogh paramaogh, int paramInt)
  {
    if ((paramBoolean) && (paramaogh != null))
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaogh, this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.a.g, this.a.L);
      aequ.a(this.a, paramaogh.mNickName);
      this.a.e.setText(paramaogh.mNickName);
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    aequ.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqz
 * JD-Core Version:    0.7.0.1
 */