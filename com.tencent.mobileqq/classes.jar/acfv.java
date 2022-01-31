import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public final class acfv
  implements DialogInterface.OnClickListener
{
  public acfv(acgy paramacgy, String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Acgy != null) {
      this.jdField_a_of_type_Acgy.a();
    }
    azmj.b(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, this.jdField_a_of_type_JavaLangString + "", this.jdField_a_of_type_Int + "", "1", "");
    bdfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), null);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfv
 * JD-Core Version:    0.7.0.1
 */