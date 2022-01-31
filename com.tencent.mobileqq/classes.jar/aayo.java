import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class aayo
  implements DialogInterface.OnClickListener
{
  aayo(aaym paramaaym, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DiscussionInfoCardActivity.a(this.jdField_a_of_type_Aaym.a).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_Aaym.a.app.a().a();
    paramDialogInterface.b(paramDialogInterface.a(this.jdField_a_of_type_JavaLangString, 3000));
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("isNeedFinish", true);
    this.jdField_a_of_type_Aaym.a.setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_Aaym.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aayo
 * JD-Core Version:    0.7.0.1
 */