import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;

public class adaw
  extends acju
{
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public ArkAppLoadLayout a;
  public ArkAppView a;
  public TextView b;
  public String b;
  
  public void a(adaw paramadaw, alcj paramalcj)
  {
    Object localObject2 = paramalcj.getArkAppNameAndPath();
    String str = localObject2[0];
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    paramalcj.clickTail(null, paramadaw, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getContext());
    if (localObject1 != null)
    {
      ArkAppCacheMgr.getAppIcon(str, new adax(this, paramadaw));
      paramalcj = ArkAppCacheMgr.getApplicationDesc(str);
      if (paramalcj != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramadaw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramadaw.jdField_a_of_type_AndroidWidgetTextView.setText(paramalcj);
      }
    }
    while ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return;
    }
    ArkAppMgr.getInstance().getAppPathByName(str, (String)localObject2, "0.0.0.1", null, new aday(this, str, paramadaw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adaw
 * JD-Core Version:    0.7.0.1
 */