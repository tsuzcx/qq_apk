import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

final class adrb
  implements DialogInterface.OnClickListener
{
  adrb(adsy paramadsy, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adsx paramadsx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = mue.b(this.jdField_a_of_type_Adsy.jdField_a_of_type_Int);
    String str;
    if ((this.jdField_a_of_type_Adsy.jdField_a_of_type_JavaUtilMap != null) && (i == 1))
    {
      str = (String)this.jdField_a_of_type_Adsy.jdField_a_of_type_JavaUtilMap.get("MultiAVType");
      if (str == null) {}
    }
    for (paramInt = Integer.valueOf(str).intValue();; paramInt = 0)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i, paramInt);
      this.jdField_a_of_type_Adsy.d = false;
      this.jdField_a_of_type_Adsy.e = false;
      ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Adsx, this.jdField_a_of_type_Adsy);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrb
 * JD-Core Version:    0.7.0.1
 */