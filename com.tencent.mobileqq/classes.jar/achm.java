import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;

public class achm
  implements View.OnClickListener
{
  public achm(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    paramView = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
    FileInfo localFileInfo = (FileInfo)paramView.a;
    switch (paramView.c)
    {
    }
    for (;;)
    {
      this.a.i();
      return;
      this.a.a.a().ab();
      this.a.c(localFileInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achm
 * JD-Core Version:    0.7.0.1
 */