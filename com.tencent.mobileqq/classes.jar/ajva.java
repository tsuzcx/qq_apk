import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;

public class ajva
  implements DialogInterface.OnClickListener
{
  public ajva(VideoBroadcastReceiver paramVideoBroadcastReceiver, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mga.e(false, false);
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, false, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, false, null, true, new Object[0]);
    VideoBroadcastReceiver.a(this.jdField_a_of_type_ComTencentMobileqqAppVideoBroadcastReceiver, 3, this.jdField_a_of_type_JavaLangString, this.c, this.d);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mga.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajva
 * JD-Core Version:    0.7.0.1
 */