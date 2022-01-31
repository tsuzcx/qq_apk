import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import java.util.Arrays;

public class aaku
  implements View.OnClickListener
{
  public aaku(AuthDevActivity paramAuthDevActivity, RelativeLayout paramRelativeLayout, int paramInt) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    paramView = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramView.stDeviceItemDes);
    if (Arrays.equals(NetConnInfoCenter.GUID, paramView.vecGuid)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      AuthDevActivity localAuthDevActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity;
      String str1 = paramView.strDeviceName;
      String str2 = AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
      int i = this.jdField_a_of_type_Int;
      if (paramView.iLoginPlatform == 3L) {}
      for (;;)
      {
        AuthDevActivity.a(localAuthDevActivity, str1, localArrayList, str2, i, bool2, bool1, paramView.iAppId);
        return;
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaku
 * JD-Core Version:    0.7.0.1
 */