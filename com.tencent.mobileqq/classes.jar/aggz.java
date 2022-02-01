import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;

class aggz
  implements DialogInterface.OnClickListener
{
  aggz(aggy paramaggy, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(aggy.a(this.jdField_a_of_type_Aggy), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
    aggy.a(this.jdField_a_of_type_Aggy).startActivity(paramDialogInterface);
    VipUtils.a(aggy.a(this.jdField_a_of_type_Aggy), "cmshow", "Apollo", "activity_alert_view", ApolloUtil.b(aggy.a(this.jdField_a_of_type_Aggy).curType), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggz
 * JD-Core Version:    0.7.0.1
 */