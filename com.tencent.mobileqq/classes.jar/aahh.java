import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class aahh
  implements Runnable
{
  aahh(aagv paramaagv, String paramString1, String paramString2, long paramLong, String paramString3) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(BaseActivity.sTopActivity, 2131624515);
    localQQCustomDialog.setContentView(2130968843);
    localQQCustomDialog.setTitle(BaseActivity.sTopActivity.getString(2131438226, new Object[] { this.jdField_a_of_type_JavaLangString }));
    ((ImageView)localQQCustomDialog.findViewById(2131364017)).setImageDrawable(BaseActivity.sTopActivity.getResources().getDrawable(2130838196));
    ((TextView)localQQCustomDialog.findViewById(2131364018)).setText(this.jdField_a_of_type_JavaLangString);
    ((TextView)localQQCustomDialog.findViewById(2131362758)).setText(BaseActivity.sTopActivity.getString(2131438808));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    ArkAppCenter.a(this.b, new aahi(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(2131434657, new aahj(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(2131434655, new aahl(this, localQQCustomDialog));
    try
    {
      localQQCustomDialog.show();
      label159:
      if (ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_JavaLangString, "ark_authority_api_location", this.c) == 0) {
        ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_JavaLangString, "ark_authority_api_location", this.c, 2);
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
 * Qualified Name:     aahh
 * JD-Core Version:    0.7.0.1
 */