import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;

class adhm
  implements DialogInterface.OnClickListener
{
  adhm(adhl paramadhl, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(adhl.a(this.jdField_a_of_type_Adhl), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
    adhl.a(this.jdField_a_of_type_Adhl).startActivity(paramDialogInterface);
    VipUtils.a(adhl.a(this.jdField_a_of_type_Adhl), "cmshow", "Apollo", "activity_alert_view", ApolloUtil.b(adhl.a(this.jdField_a_of_type_Adhl).jdField_a_of_type_Int), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhm
 * JD-Core Version:    0.7.0.1
 */