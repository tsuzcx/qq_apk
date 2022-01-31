import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aaiu
  implements Runnable
{
  public aaiu(ArkAppModuleReg.ModuleQQ paramModuleQQ, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(BaseActivity.sTopActivity, 2131624515);
    localQQCustomDialog.setContentView(2130968843);
    localQQCustomDialog.setTitle(BaseActivity.sTopActivity.getString(2131438226, new Object[] { this.jdField_a_of_type_JavaLangString }));
    ((ImageView)localQQCustomDialog.findViewById(2131364017)).setImageDrawable(BaseActivity.sTopActivity.getResources().getDrawable(2130838196));
    ((TextView)localQQCustomDialog.findViewById(2131364018)).setText(this.jdField_a_of_type_JavaLangString);
    ((TextView)localQQCustomDialog.findViewById(2131362758)).setText(BaseActivity.sTopActivity.getString(2131438810));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    ArkAppCenter.a(this.jdField_b_of_type_JavaLangString, new aaiv(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(2131434657, new aaiw(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(2131434655, new aaiy(this, localQQCustomDialog));
    try
    {
      localQQCustomDialog.show();
      label159:
      if (ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_JavaLangString, "ark_authority_api_login", this.c) == 0) {
        ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_JavaLangString, "ark_authority_api_login", this.c, 2);
      }
      return;
    }
    catch (Exception localException)
    {
      break label159;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaiu
 * JD-Core Version:    0.7.0.1
 */