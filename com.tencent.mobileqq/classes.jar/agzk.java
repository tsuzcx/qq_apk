import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;

public class agzk
  extends aggl
{
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public ArkAppLoadLayout a;
  public ArkAppView a;
  public TextView b;
  public String b;
  public View c;
  
  public void a(agzk paramagzk, apzt paramapzt)
  {
    Object localObject2 = paramapzt.getArkAppNameAndPath();
    String str = localObject2[0];
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    paramapzt.clickTail(null, paramagzk, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getContext());
    if (localObject1 != null)
    {
      ArkAppCacheMgr.getAppIcon(str, new agzl(this, paramagzk));
      paramapzt = ArkAppCacheMgr.getApplicationDesc(str);
      if (paramapzt != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramagzk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramagzk.jdField_a_of_type_AndroidWidgetTextView.setText(paramapzt);
      }
    }
    while ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return;
    }
    ArkAppMgr.getInstance().getAppPathByName(str, (String)localObject2, "0.0.0.1", null, new agzm(this, str, paramagzk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzk
 * JD-Core Version:    0.7.0.1
 */