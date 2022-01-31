import android.os.Bundle;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import mqq.util.WeakReference;

final class aioc
  extends ajxl
{
  WeakReference<ainv> a;
  
  aioc(ainv paramainv)
  {
    this.a = new WeakReference(paramainv);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    ainv localainv;
    if (paramBoolean)
    {
      localainv = (ainv)this.a.get();
      if (localainv == null) {
        break label71;
      }
      paramString = ainv.a(localainv, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "onCancelMayKnowRecommend target：" + paramString);
      }
      if (paramString != null) {
        ainv.a(localainv, paramString);
      }
    }
    else
    {
      return;
    }
    ainv.a(localainv);
    return;
    label71:
    QLog.d("MayKnowAdapter", 1, "onCancelMayKnowRecommend  adapter is null!");
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (ainv)this.a.get();
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onGetMayKnowRecommend ");
        }
        ainv.a(paramBundle);
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
      paramList = (ainv)this.a.get();
      if (paramList != null) {
        ainv.a(paramList);
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
      paramList = (ainv)this.a.get();
      if (paramList != null) {
        ainv.a(paramList);
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
      ainv localainv = (ainv)this.a.get();
      if (localainv == null) {
        break label60;
      }
      if (ainv.a(localainv) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onMayknowStateChanged");
        }
        localainv.notifyDataSetChanged();
        ainv.a(localainv).postDelayed(localainv.a, 1600L);
      }
    }
    return;
    label60:
    QLog.d("MayKnowAdapter", 1, "onMayknowStateChanged adapter is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aioc
 * JD-Core Version:    0.7.0.1
 */