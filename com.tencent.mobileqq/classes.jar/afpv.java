import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;

class afpv
  implements DialogInterface.OnClickListener
{
  afpv(afpu paramafpu, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(afpu.a(this.jdField_a_of_type_Afpu), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
    afpu.a(this.jdField_a_of_type_Afpu).startActivity(paramDialogInterface);
    VipUtils.a(afpu.a(this.jdField_a_of_type_Afpu), "cmshow", "Apollo", "activity_alert_view", ApolloUtil.b(afpu.a(this.jdField_a_of_type_Afpu).curType), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpv
 * JD-Core Version:    0.7.0.1
 */