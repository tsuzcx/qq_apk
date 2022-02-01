import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adpv
  implements View.OnClickListener
{
  adpv(adpt paramadpt) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = (amgh)paramView.getTag();
      if ((((amgh)localObject).a instanceof FileManagerEntity))
      {
        localObject = (FileManagerEntity)((amgh)localObject).a;
        this.a.a((FileManagerEntity)localObject);
      }
      else if ((((amgh)localObject).a instanceof TencentDocData))
      {
        localObject = (TencentDocData)((amgh)localObject).a;
        this.a.a((TencentDocData)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpv
 * JD-Core Version:    0.7.0.1
 */