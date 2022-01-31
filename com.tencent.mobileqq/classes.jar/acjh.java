import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class acjh
  implements View.OnClickListener
{
  acjh(acjf paramacjf) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {}
    do
    {
      return;
      paramView = (akdm)paramView.getTag();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjh
 * JD-Core Version:    0.7.0.1
 */