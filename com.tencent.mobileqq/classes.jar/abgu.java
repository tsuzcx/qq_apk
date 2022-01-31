import android.os.Bundle;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;

class abgu
  extends mmn
{
  abgu(abgt paramabgt, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = 0;
    boolean bool;
    if (paramInt != 0)
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      paramArrayOfByte = this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
      if (!this.b)
      {
        bool = true;
        paramArrayOfByte.setChecked(bool);
        this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(this.a.a.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramArrayOfByte = (ajjj)this.a.a.app.getManager(51);
      paramBundle = paramArrayOfByte.e(this.a.a.app.getCurrentAccountUin());
    } while (paramBundle == null);
    if (this.b) {}
    for (paramInt = i;; paramInt = 1)
    {
      paramBundle.isHideBigClub = paramInt;
      paramArrayOfByte.a(paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgu
 * JD-Core Version:    0.7.0.1
 */