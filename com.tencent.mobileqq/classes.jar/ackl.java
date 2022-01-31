import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ackl
  implements DialogInterface.OnClickListener
{
  public ackl(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, boolean paramBoolean1, acln paramacln, Bundle paramBundle, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    paramDialogInterface = ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentContext);
    if (paramInt == 1)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDialogInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Acln, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    if (!this.b) {
      bool = true;
    }
    ChatActivityUtils.a(paramDialogInterface, bool, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackl
 * JD-Core Version:    0.7.0.1
 */