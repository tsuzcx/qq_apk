import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class acnw
  implements View.OnClickListener
{
  acnw(acnu paramacnu) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {}
    do
    {
      return;
      paramView = (akib)paramView.getTag();
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
 * Qualified Name:     acnw
 * JD-Core Version:    0.7.0.1
 */