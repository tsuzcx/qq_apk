import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import cooperation.weiyun.WeiyunAIOUtils;

public class aerm
  implements DialogInterface.OnClickListener
{
  public aerm(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (WeiyunAIOUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AIOShareActionSheet.a(this.a), AIOShareActionSheet.a(this.a).a(), this.a.jdField_a_of_type_MqqOsMqqHandler)) {
      AIOShareActionSheet.a(this.a).a(false, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerm
 * JD-Core Version:    0.7.0.1
 */