import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aasj
  implements View.OnClickListener
{
  aasj(aash paramaash) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {}
    do
    {
      return;
      paramView = (aimb)paramView.getTag();
      if ((paramView.a instanceof FileManagerEntity))
      {
        paramView = (FileManagerEntity)paramView.a;
        this.a.a(paramView);
        return;
      }
    } while (!(paramView.a instanceof TencentDocData));
    paramView = (TencentDocData)paramView.a;
    this.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aasj
 * JD-Core Version:    0.7.0.1
 */