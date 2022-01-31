import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.DeleteFeedCallback;
import com.tencent.mobileqq.widget.QQToast;

class aezx
  implements NearbyMomentManager.DeleteFeedCallback
{
  aezx(aezw paramaezw) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      NearbyMomentManager localNearbyMomentManager = (NearbyMomentManager)this.a.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262);
      if (localNearbyMomentManager != null) {
        localNearbyMomentManager.e(paramString);
      }
      PlayOperationViewModel.a(this.a.a.a, paramString);
      if ((this.a.a.a.jdField_a_of_type_AndroidViewView.getContext() instanceof Activity)) {
        ((BaseActivity)this.a.a.a.jdField_a_of_type_AndroidViewView.getContext()).finish();
      }
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, "删除失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aezx
 * JD-Core Version:    0.7.0.1
 */