import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class acjc
  implements View.OnClickListener
{
  public acjc(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    FileManagerEntity localFileManagerEntity = null;
    if ((localObject instanceof QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)) {
      localFileManagerEntity = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag()).a;
    }
    for (;;)
    {
      if (localFileManagerEntity != null) {
        this.a.c(localFileManagerEntity);
      }
      return;
      if ((localObject instanceof ImageHolder)) {
        localFileManagerEntity = (FileManagerEntity)((ImageHolder)paramView.getTag()).a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acjc
 * JD-Core Version:    0.7.0.1
 */