import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;

class afec
  implements DialogInterface.OnClickListener
{
  afec(afeb paramafeb, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(afeb.a(this.jdField_a_of_type_Afeb), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
    afeb.a(this.jdField_a_of_type_Afeb).startActivity(paramDialogInterface);
    VipUtils.a(afeb.a(this.jdField_a_of_type_Afeb), "cmshow", "Apollo", "activity_alert_view", ApolloUtil.b(afeb.a(this.jdField_a_of_type_Afeb).jdField_a_of_type_Int), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afec
 * JD-Core Version:    0.7.0.1
 */