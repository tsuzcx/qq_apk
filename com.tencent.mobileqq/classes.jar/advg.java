import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class advg
  implements View.OnClickListener
{
  advg(adve paramadve) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = (ambt)paramView.getTag();
      if ((((ambt)localObject).a instanceof FileManagerEntity))
      {
        localObject = (FileManagerEntity)((ambt)localObject).a;
        this.a.a((FileManagerEntity)localObject);
      }
      else if ((((ambt)localObject).a instanceof TencentDocData))
      {
        localObject = (TencentDocData)((ambt)localObject).a;
        this.a.a((TencentDocData)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advg
 * JD-Core Version:    0.7.0.1
 */