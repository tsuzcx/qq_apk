import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;

public class akjx
  implements Runnable
{
  public akjx(MSFIntChkStrike paramMSFIntChkStrike, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, String paramString3, String paramString4, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    try
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(BaseActivity.sTopActivity, 230, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      if (localQQCustomDialog == null) {
        return;
      }
      localQQCustomDialog.setNegativeButton(this.c, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      localQQCustomDialog.setPositiveButton(this.d, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      localQQCustomDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.show();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    MSFIntChkStrike.a(this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFIntChkStrike, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akjx
 * JD-Core Version:    0.7.0.1
 */