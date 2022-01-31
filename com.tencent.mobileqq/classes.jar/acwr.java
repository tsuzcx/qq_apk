import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;

class acwr
  implements DialogInterface.OnClickListener
{
  acwr(acwp paramacwp, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(acwp.a(this.jdField_a_of_type_Acwp), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
    acwp.a(this.jdField_a_of_type_Acwp).startActivity(paramDialogInterface);
    bajr.a(acwp.a(this.jdField_a_of_type_Acwp), "cmshow", "Apollo", "activity_alert_view", ApolloUtil.b(acwp.a(this.jdField_a_of_type_Acwp).jdField_a_of_type_Int), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwr
 * JD-Core Version:    0.7.0.1
 */