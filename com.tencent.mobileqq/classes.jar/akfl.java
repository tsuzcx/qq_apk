import android.os.Bundle;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import mqq.util.WeakReference;

final class akfl
  extends alox
{
  WeakReference<akfe> a;
  
  akfl(akfe paramakfe)
  {
    this.a = new WeakReference(paramakfe);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    akfe localakfe;
    if (paramBoolean)
    {
      localakfe = (akfe)this.a.get();
      if (localakfe == null) {
        break label71;
      }
      paramString = akfe.a(localakfe, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "onCancelMayKnowRecommend target：" + paramString);
      }
      if (paramString != null) {
        akfe.a(localakfe, paramString);
      }
    }
    else
    {
      return;
    }
    akfe.a(localakfe);
    return;
    label71:
    QLog.d("MayKnowAdapter", 1, "onCancelMayKnowRecommend  adapter is null!");
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (akfe)this.a.get();
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onGetMayKnowRecommend ");
        }
        akfe.a(paramBundle);
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
      paramList = (akfe)this.a.get();
      if (paramList != null) {
        akfe.a(paramList);
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
      paramList = (akfe)this.a.get();
      if (paramList != null) {
        akfe.a(paramList);
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
      akfe localakfe = (akfe)this.a.get();
      if (localakfe == null) {
        break label60;
      }
      if (akfe.a(localakfe) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onMayknowStateChanged");
        }
        localakfe.notifyDataSetChanged();
        akfe.a(localakfe).postDelayed(localakfe.a, 1600L);
      }
    }
    return;
    label60:
    QLog.d("MayKnowAdapter", 1, "onMayknowStateChanged adapter is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfl
 * JD-Core Version:    0.7.0.1
 */