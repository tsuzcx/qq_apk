import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class ajfy
  implements Runnable
{
  private final WeakReference a;
  
  public ajfy(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void run()
  {
    int j = 0;
    TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.a.get();
    if (localTroopMoreDetailView == null) {}
    Activity localActivity;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localActivity = TroopMoreDetailView.a(localTroopMoreDetailView);
      } while (localActivity == null);
      localQQAppInterface = TroopMoreDetailView.a(localTroopMoreDetailView);
    } while (localQQAppInterface == null);
    Object localObject1 = Long.toString(localTroopMoreDetailView.a.dwGroupClassExt);
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(localActivity).a(localActivity, (String)localObject1);
    List localList = localTroopMoreDetailView.a.troopTags;
    Intent localIntent = new Intent(localActivity, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", localTroopMoreDetailView.a.troopUin);
    localIntent.putExtra("isAdmin", false);
    Object localObject2 = "";
    int i;
    if (!TextUtils.isEmpty(localTroopMoreDetailView.a.mTroopClassExtText))
    {
      localObject1 = localTroopMoreDetailView.a.mTroopClassExtText;
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        localIntent.putExtra("subclass", (String)localObject1);
      }
      if ((localList == null) || (localList.size() <= 0)) {
        break label302;
      }
      localObject1 = new StringBuilder();
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append("\n");
      }
      localObject1 = localObject2;
      i = j;
      if (localGroupCatalogBean != null)
      {
        localObject1 = localObject2;
        i = j;
        if (!TextUtils.isEmpty(localGroupCatalogBean.a))
        {
          localObject1 = localObject2;
          i = j;
          if (!"其他".equals(localGroupCatalogBean.a))
          {
            localObject1 = localGroupCatalogBean.a;
            i = 1;
          }
        }
      }
    }
    ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
    localIntent.putExtra("tags", ((StringBuilder)localObject1).toString());
    label302:
    localIntent.putExtra("act_type", 1);
    localIntent.putExtra("uin", localQQAppInterface.getCurrentAccountUin());
    if (localTroopMoreDetailView.a.isOwnerOrAdim())
    {
      localActivity.startActivityForResult(localIntent, 98);
      return;
    }
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajfy
 * JD-Core Version:    0.7.0.1
 */