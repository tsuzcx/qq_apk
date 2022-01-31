import android.os.Bundle;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

class ahjf
  extends alox
{
  ahjf(ahjd paramahjd) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "onCancelMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(false);
    }
  }
  
  public void onGetConnectionsPerson(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == ahjd.a(this.a)) {
      this.a.a(false);
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (ahjd.a(this.a) == 23)) {
      this.a.a(false);
    }
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "onMayKnowListPushAdd isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(false);
    }
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "onMayKnowListPushDel isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(false);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "onMayknowStateChanged isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.a.notifyDataSetChanged();
      if (ahjd.a(this.a) != null)
      {
        ahjd.a(this.a).removeCallbacks(this.a.a);
        ahjd.a(this.a).postDelayed(this.a.a, 1600L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjf
 * JD-Core Version:    0.7.0.1
 */