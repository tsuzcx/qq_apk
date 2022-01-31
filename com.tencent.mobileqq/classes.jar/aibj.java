import android.os.Bundle;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import mqq.util.WeakReference;

final class aibj
  extends ajjh
{
  WeakReference<aibc> a;
  
  aibj(aibc paramaibc)
  {
    this.a = new WeakReference(paramaibc);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    aibc localaibc;
    if (paramBoolean)
    {
      localaibc = (aibc)this.a.get();
      if (localaibc == null) {
        break label71;
      }
      paramString = aibc.a(localaibc, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "onCancelMayKnowRecommend target：" + paramString);
      }
      if (paramString != null) {
        aibc.a(localaibc, paramString);
      }
    }
    else
    {
      return;
    }
    aibc.a(localaibc);
    return;
    label71:
    QLog.d("MayKnowAdapter", 1, "onCancelMayKnowRecommend  adapter is null!");
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (aibc)this.a.get();
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onGetMayKnowRecommend ");
        }
        aibc.a(paramBundle);
      }
    }
    else
    {
      return;
    }
    QLog.d("MayKnowAdapter", 1, "onGetMayKnowRecommend adapter is null!");
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onMayKnowListPushAdd");
    }
    if (paramBoolean)
    {
      paramList = (aibc)this.a.get();
      if (paramList != null) {
        aibc.a(paramList);
      }
    }
    else
    {
      return;
    }
    QLog.d("MayKnowAdapter", 1, "onMayKnowListPushAdd adapter is null!");
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onMayKnowListPushDel");
    }
    if (paramBoolean)
    {
      paramList = (aibc)this.a.get();
      if (paramList != null) {
        aibc.a(paramList);
      }
    }
    else
    {
      return;
    }
    QLog.d("MayKnowAdapter", 1, "onMayKnowListPushDel adapter is null!");
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aibc localaibc = (aibc)this.a.get();
      if (localaibc == null) {
        break label60;
      }
      if (aibc.a(localaibc) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onMayknowStateChanged");
        }
        localaibc.notifyDataSetChanged();
        aibc.a(localaibc).postDelayed(localaibc.a, 1600L);
      }
    }
    return;
    label60:
    QLog.d("MayKnowAdapter", 1, "onMayknowStateChanged adapter is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aibj
 * JD-Core Version:    0.7.0.1
 */