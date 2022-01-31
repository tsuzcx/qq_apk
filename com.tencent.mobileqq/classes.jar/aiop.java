import android.os.Bundle;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

class aiop
  extends ajxj
{
  aiop(aion paramaion) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onCancelMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_Aiob != null) && ((this.a.jdField_a_of_type_Aiob instanceof aioc))) {
        ((aioc)this.a.jdField_a_of_type_Aiob).a(paramString);
      }
      aion.a(this.a);
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      aion.a(this.a);
    }
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onMayKnowListPushAdd isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      aion.a(this.a);
    }
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onMayKnowListPushDel isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      aion.a(this.a);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onMayknowStateChanged isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.a.notifyDataSetChanged();
      if (aion.a(this.a) != null)
      {
        aion.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        aion.a(this.a).postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiop
 * JD-Core Version:    0.7.0.1
 */