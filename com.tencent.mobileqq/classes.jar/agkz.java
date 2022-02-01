import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;

class agkz
  implements DialogInterface.OnClickListener
{
  agkz(agky paramagky, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(agky.a(this.jdField_a_of_type_Agky), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
    agky.a(this.jdField_a_of_type_Agky).startActivity(paramDialogInterface);
    VipUtils.a(agky.a(this.jdField_a_of_type_Agky), "cmshow", "Apollo", "activity_alert_view", ApolloUtil.b(agky.a(this.jdField_a_of_type_Agky).jdField_a_of_type_Int), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkz
 * JD-Core Version:    0.7.0.1
 */