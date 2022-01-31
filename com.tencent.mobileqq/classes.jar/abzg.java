import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.vas.VasH5PayUtil;

public class abzg
  implements DialogInterface.OnClickListener
{
  public abzg(EmoticonFromGroupManager paramEmoticonFromGroupManager, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      VasH5PayUtil.a(EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager).getString(2131436943), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abzg
 * JD-Core Version:    0.7.0.1
 */