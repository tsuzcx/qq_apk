import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public final class aafj
  implements DialogInterface.OnClickListener
{
  public aafj(aagm paramaagm, String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aagm != null) {
      this.jdField_a_of_type_Aagm.a();
    }
    awqx.b(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, this.jdField_a_of_type_JavaLangString + "", this.jdField_a_of_type_Int + "", "1", "");
    baep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), null);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafj
 * JD-Core Version:    0.7.0.1
 */