import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

public class agcl
  implements View.OnClickListener
{
  public agcl(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.y)
    {
      PhotoPreviewActivity.a(this.a);
      return;
    }
    this.a.a.toggle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcl
 * JD-Core Version:    0.7.0.1
 */