import android.os.Bundle;
import com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class ajuz
  extends anyu
{
  public ajuz(RecommendFriendFragment paramRecommendFriendFragment) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onCancelMayKnowRecommend isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onGetMayKnowRecommend isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onMayKnowListPushAdd isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onMayKnowListPushDel isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onMayknowStateChanged isSuccess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Ajva != null) {
        this.a.jdField_a_of_type_Ajva.notifyDataSetChanged();
      }
      if (this.a.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        this.a.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuz
 * JD-Core Version:    0.7.0.1
 */