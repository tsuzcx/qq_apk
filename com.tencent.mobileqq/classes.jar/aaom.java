import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class aaom
  implements DialogInterface.OnClickListener
{
  public aaom(aaqb paramaaqb, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aaqa paramaaqa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Aaqb.d = false;
    this.jdField_a_of_type_Aaqb.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aaqa, this.jdField_a_of_type_Aaqb);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaom
 * JD-Core Version:    0.7.0.1
 */