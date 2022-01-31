import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class ajfb
  extends TroopFeedViewFactory.ViewProvider
{
  public TroopAioTopADInfo a;
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    paramTroopFeedItem = paramView;
    if (paramView == null) {
      paramTroopFeedItem = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext).inflate(2130969842, null);
    }
    Object localObject = (ajfc)paramTroopFeedItem.getTag();
    paramView = (View)localObject;
    if (localObject == null)
    {
      paramView = new ajfc(this);
      paramView.a = ((URLImageView)paramTroopFeedItem.findViewById(2131368223));
      paramTroopFeedItem.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory);
      paramTroopFeedItem.setTag(paramView);
    }
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_AndroidContentContext)) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.c();
      }
    }
    do
    {
      return paramTroopFeedItem;
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        EmptyDrawable localEmptyDrawable = new EmptyDrawable(1, 1);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localEmptyDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localEmptyDrawable;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTopADInfo.uiUrl, (URLDrawable.URLDrawableOptions)localObject);
        paramView.a.setBackgroundDrawable((Drawable)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioADManager", 2, "URLDrawable: " + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTopADInfo.uiUrl);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Exp_Promote", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTopADInfo.adId + "", "", "");
        return paramTroopFeedItem;
      }
      catch (IllegalArgumentException paramView) {}
    } while (!QLog.isColorLevel());
    QLog.e("TroopAioADManager", 2, "IllegalArgumentException");
    return paramTroopFeedItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajfb
 * JD-Core Version:    0.7.0.1
 */