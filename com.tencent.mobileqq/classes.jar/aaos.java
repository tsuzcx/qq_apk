import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public final class aaos
  implements DialogInterface.OnClickListener
{
  public aaos(aaqf paramaaqf, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aaqe paramaaqe) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = muf.b(this.jdField_a_of_type_Aaqf.jdField_a_of_type_Int);
    String str;
    if ((this.jdField_a_of_type_Aaqf.jdField_a_of_type_JavaUtilMap != null) && (i == 1))
    {
      str = (String)this.jdField_a_of_type_Aaqf.jdField_a_of_type_JavaUtilMap.get("MultiAVType");
      if (str == null) {}
    }
    for (paramInt = Integer.valueOf(str).intValue();; paramInt = 0)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i, paramInt);
      this.jdField_a_of_type_Aaqf.d = false;
      this.jdField_a_of_type_Aaqf.e = false;
      ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aaqe, this.jdField_a_of_type_Aaqf);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaos
 * JD-Core Version:    0.7.0.1
 */