import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class af
  implements DialogInterface.OnClickListener
{
  public af(LiteActivity paramLiteActivity, long paramLong, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getIntExtra("forward_type", -1) == 11) {
      bfhz.a().a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), "", String.valueOf(this.jdField_a_of_type_Long), "1000", "51", "0", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i(LiteActivity.a, 2, "qbShowShareResultDialog back");
    }
    if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().putExtra("MigSdkShareNotDone", false);
      asdb.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, true, "sendToMyComputer", this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      ndq.a(this.jdField_a_of_type_AndroidContentContext, 0, "", "");
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.finish();
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {}
      try
      {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity().moveTaskToBack(true);
        return;
        asdb.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, true, "shareToQQ", this.jdField_a_of_type_Long);
      }
      catch (Throwable paramDialogInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(LiteActivity.a, 2, "qbShowShareResultDialog ", paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     af
 * JD-Core Version:    0.7.0.1
 */