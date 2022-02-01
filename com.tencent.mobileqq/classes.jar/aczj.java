import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aczj
  implements View.OnClickListener
{
  aczj(aczh paramaczh) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = (alih)paramView.getTag();
      if ((((alih)localObject).a instanceof FileManagerEntity))
      {
        localObject = (FileManagerEntity)((alih)localObject).a;
        this.a.a((FileManagerEntity)localObject);
      }
      else if ((((alih)localObject).a instanceof TencentDocData))
      {
        localObject = (TencentDocData)((alih)localObject).a;
        this.a.a((TencentDocData)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczj
 * JD-Core Version:    0.7.0.1
 */