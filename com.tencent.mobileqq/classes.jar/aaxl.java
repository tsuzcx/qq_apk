import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aaxl
  implements Runnable
{
  public aaxl(ArkAppSchemeCenter.TelSchemeHandler paramTelSchemeHandler, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(BaseActivity.sTopActivity, this.jdField_a_of_type_JavaLangString);
    TextView localTextView = (TextView)localQQCustomDialog.findViewById(2131362781);
    localTextView.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localQQCustomDialog.setPositiveButton(2131435108, new aaxm(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(2131433029, new aaxn(this, localQQCustomDialog));
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxl
 * JD-Core Version:    0.7.0.1
 */