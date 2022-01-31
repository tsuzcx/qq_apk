import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aapv
  implements Runnable
{
  public aapv(ArkAppModuleReg.ModuleQQ paramModuleQQ, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(BaseActivity.sTopActivity, 2131624516);
    localQQCustomDialog.setContentView(2130968843);
    localQQCustomDialog.setTitle(BaseActivity.sTopActivity.getString(2131438244, new Object[] { this.jdField_a_of_type_JavaLangString }));
    ((ImageView)localQQCustomDialog.findViewById(2131364041)).setImageDrawable(BaseActivity.sTopActivity.getResources().getDrawable(2130838200));
    ((TextView)localQQCustomDialog.findViewById(2131364042)).setText(this.jdField_a_of_type_JavaLangString);
    ((TextView)localQQCustomDialog.findViewById(2131362776)).setText(BaseActivity.sTopActivity.getString(2131438828));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    ArkAppCenter.a(this.jdField_b_of_type_JavaLangString, new aapw(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(2131434674, new aapx(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(2131434672, new aapz(this, localQQCustomDialog));
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
 * Qualified Name:     aapv
 * JD-Core Version:    0.7.0.1
 */