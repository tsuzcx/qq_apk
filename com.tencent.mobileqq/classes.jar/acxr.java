import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter.CloudItemHolder;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

public class acxr
  implements View.OnClickListener
{
  public acxr(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int i;
    if ((localObject instanceof QfileCloudFileBaseExpandableListAdapter.CloudItemHolder))
    {
      paramView = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
      i = paramView.c;
      paramView = (WeiYunFileInfo)paramView.a;
    }
    for (;;)
    {
      this.a.a(paramView, i);
      do
      {
        return;
      } while (!(localObject instanceof ImageHolder));
      paramView = (WeiYunFileInfo)((ImageHolder)paramView.getTag()).a;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxr
 * JD-Core Version:    0.7.0.1
 */