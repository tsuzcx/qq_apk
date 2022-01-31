import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;

class aijw
  implements DialogInterface.OnClickListener
{
  aijw(aijv paramaijv, Context paramContext, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StructMsgItemVideo.a(this.jdField_a_of_type_Aijv.a, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijw
 * JD-Core Version:    0.7.0.1
 */