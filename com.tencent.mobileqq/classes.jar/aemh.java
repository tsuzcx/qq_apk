import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.onDoVoteListener;

public class aemh
  implements DialogInterface.OnClickListener
{
  public aemh(NearbyLikeLimitManager paramNearbyLikeLimitManager, boolean paramBoolean, String paramString1, NearbyLikeLimitManager.onDoVoteListener paramonDoVoteListener, QQAppInterface paramQQAppInterface, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.b();
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.a()) {
        break label104;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0, 1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager$onDoVoteListener.a(this.jdField_a_of_type_JavaLangString, false);
      NearbyLikeLimitManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "pay_like", this.jdField_a_of_type_JavaLangString, this.b, "", "", "");
    }
    for (;;)
    {
      NearbyLikeLimitManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_no_warm", this.b);
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.c();
      break;
      label104:
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.a(this.jdField_a_of_type_AndroidAppActivity, this.b);
      NearbyLikeLimitManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "exp_pay", this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemh
 * JD-Core Version:    0.7.0.1
 */