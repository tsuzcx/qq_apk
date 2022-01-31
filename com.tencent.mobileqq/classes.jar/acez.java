import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class acez
  implements DialogInterface.OnClickListener
{
  public acez(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.n();
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Boolean = false;
      this.a.e();
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
      this.a.f();
    }
    if (!TextUtils.isEmpty(this.a.a())) {}
    for (paramDialogInterface = "1";; paramDialogInterface = "0")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, mpl.a(), paramDialogInterface, "1");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acez
 * JD-Core Version:    0.7.0.1
 */