import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ShoppingPhotoItemInfo;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping.StylePagerAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.Reference;
import java.util.List;

public class agcv
  implements View.OnClickListener
{
  public agcv(PhotoViewForShopping.StylePagerAdapter paramStylePagerAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (PhotoViewForShopping.a(this.a.a).get() != null)
    {
      paramView = new Intent((Context)PhotoViewForShopping.a(this.a.a).get(), QQBrowserActivity.class);
      paramView.putExtra("url", ((ShoppingPhotoItemInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(i)).b);
      ((Activity)PhotoViewForShopping.a(this.a.a).get()).startActivity(paramView);
      if (PhotoViewForShopping.a(this.a.a).a.a.equals(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        ReportController.b(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_Mtemplatewindowclk", "0X8005B94", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    ReportController.b(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_Ftemplatewindowclk", "0X8005B98", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcv
 * JD-Core Version:    0.7.0.1
 */