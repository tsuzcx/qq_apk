import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class acgh
  implements View.OnClickListener
{
  public acgh(AuthDevActivity paramAuthDevActivity, List paramList, RelativeLayout paramRelativeLayout, int paramInt, SvcDevLoginInfo paramSvcDevLoginInfo) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = this.jdField_a_of_type_JavaUtilList.equals(AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity));
    ArrayList localArrayList;
    Object localObject;
    boolean bool1;
    String str1;
    String str2;
    int i;
    if (bool3)
    {
      paramView = "0X800AC55";
      azqs.b(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
      paramView = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag();
      localArrayList = new ArrayList();
      localArrayList.add(paramView.stDeviceItemDes);
      localObject = NetConnInfoCenter.GUID;
      bool1 = false;
      if (Arrays.equals((byte[])localObject, paramView.vecGuid)) {
        bool1 = true;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity;
      str1 = paramView.strDeviceName;
      str2 = AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
      i = this.jdField_a_of_type_Int;
      if (paramView.iLoginPlatform != 3L) {
        break label179;
      }
    }
    label179:
    for (boolean bool2 = true;; bool2 = false)
    {
      AuthDevActivity.a((AuthDevActivity)localObject, str1, localArrayList, str2, i, bool2, bool1, paramView.iAppId, paramView.iLoginTime, this.jdField_a_of_type_QQServiceSvcDevLoginInfo.vecGuid, bool3, paramView);
      return;
      paramView = "0X800AC57";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgh
 * JD-Core Version:    0.7.0.1
 */