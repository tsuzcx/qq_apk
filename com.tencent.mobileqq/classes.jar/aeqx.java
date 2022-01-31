import android.widget.TextView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aeqx
  extends aoez
{
  aeqx(aeqs paramaeqs) {}
  
  protected void a(boolean paramBoolean, aogm paramaogm, int paramInt)
  {
    if ((paramBoolean) && (paramaogm != null))
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaogm, this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.a.g, this.a.L);
      aeqs.a(this.a, paramaogm.mNickName);
      this.a.e.setText(paramaogm.mNickName);
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    aeqs.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqx
 * JD-Core Version:    0.7.0.1
 */