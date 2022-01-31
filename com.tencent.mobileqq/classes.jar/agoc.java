import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

public class agoc
  implements View.OnClickListener
{
  public agoc(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewActivity.f(this.a))
    {
      this.a.j();
      return;
    }
    if (this.a.L) {
      axqw.b(null, "CliOper", "", "", "0X8004D94", "0X8004D94", 0, 0, "", "", "", "");
    }
    if (("FROM_PHOTO_LIST_FLOW".equals(this.a.e)) && (this.a.J)) {
      this.a.setResult(-1);
    }
    this.a.finish();
    bbbj.a(this.a, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agoc
 * JD-Core Version:    0.7.0.1
 */