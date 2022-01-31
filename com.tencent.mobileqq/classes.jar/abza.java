import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class abza
  implements DialogInterface.OnClickListener
{
  public abza(EmoAddedAuthCallback paramEmoAddedAuthCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      VasH5PayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, "mvip.n.a.bqsc_aio", 3, "1450000516", "CJCLUBT", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131436943), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abza
 * JD-Core Version:    0.7.0.1
 */