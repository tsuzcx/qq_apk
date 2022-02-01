import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;

class agua
  implements DialogInterface.OnClickListener
{
  agua(agtz paramagtz, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(agtz.a(this.jdField_a_of_type_Agtz), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
    agtz.a(this.jdField_a_of_type_Agtz).startActivity(paramDialogInterface);
    VipUtils.a(agtz.a(this.jdField_a_of_type_Agtz), "cmshow", "Apollo", "activity_alert_view", ApolloUtil.b(agtz.a(this.jdField_a_of_type_Agtz).jdField_a_of_type_Int), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agua
 * JD-Core Version:    0.7.0.1
 */