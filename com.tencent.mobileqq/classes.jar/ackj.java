import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ackj
  implements DialogInterface.OnClickListener
{
  public ackj(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, String paramString, int paramInt3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.b);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(paramDialogInterface, paramInt);
    azqs.b(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, this.jdField_a_of_type_JavaLangString + "", this.c + "", "0", "");
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackj
 * JD-Core Version:    0.7.0.1
 */