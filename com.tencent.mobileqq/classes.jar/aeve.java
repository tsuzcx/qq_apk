import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aeve
  extends ClickableSpan
{
  private final QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<FragmentActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aeve(String paramString, QQCustomDialog paramQQCustomDialog, WeakReference<FragmentActivity> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = paramQQCustomDialog;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangRefWeakReference == null))
    {
      QLog.e("RiskHintDlgFragment", 1, "RiskLinkClickableSpan onClick: params invalid");
      return;
    }
    paramView = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramView == null)
    {
      QLog.e("RiskHintDlgFragment", 1, "RiskLinkClickableSpan error: activity == null");
      return;
    }
    bcpn.a().a(paramView.app.getCurrentAccountUin());
    if (this.jdField_a_of_type_JavaLangString.contains("1108149324")) {
      bdla.b(paramView.app, "dc00898", "", "", "0X800B259", "0X800B259", 0, 0, "", "", "", "");
    }
    QLog.d("RiskHintDlgFragment", 1, "RiskLinkClickableSpan onClick: startMiniApp");
    MiniAppLauncher.startMiniApp(paramView, this.jdField_a_of_type_JavaLangString, 4010, null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeve
 * JD-Core Version:    0.7.0.1
 */