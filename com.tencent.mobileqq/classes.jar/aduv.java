import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;

class aduv
  implements DialogInterface.OnClickListener
{
  aduv(adut paramadut, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DiscussionInfoCardActivity.a(this.jdField_a_of_type_Adut.a).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_Adut.a.app.getProxyManager().a();
    paramDialogInterface.delRecentUser((RecentUser)paramDialogInterface.findRecentUserByUin(this.jdField_a_of_type_JavaLangString, 3000));
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("isNeedFinish", true);
    this.jdField_a_of_type_Adut.a.setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_Adut.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduv
 * JD-Core Version:    0.7.0.1
 */