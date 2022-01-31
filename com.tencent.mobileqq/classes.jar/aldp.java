import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.downloadnew.MyAppDialog;

public class aldp
  implements Runnable
{
  public aldp(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity.getResources();
    MyAppDialog localMyAppDialog = new MyAppDialog(this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity);
    localMyAppDialog.a(2131428541, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, true);
    localMyAppDialog.b(2131428542, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, true);
    localMyAppDialog.a(localResources.getString(2131428532));
    localMyAppDialog.b(localResources.getString(2131428543));
    localMyAppDialog.setCancelable(false);
    localMyAppDialog.setOnDismissListener(new aldq(this));
    if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity != null) && (!this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.activity.isFinishing())) {
      localMyAppDialog.show();
    }
    this.jdField_a_of_type_ComTencentOpenAppcommonJsAppInterface.tipDialog = localMyAppDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aldp
 * JD-Core Version:    0.7.0.1
 */