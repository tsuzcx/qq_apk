import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

public class agce
  implements View.OnClickListener
{
  public agce(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewActivity.f(this.a))
    {
      this.a.j();
      return;
    }
    if (this.a.L) {
      awqx.b(null, "CliOper", "", "", "0X8004D94", "0X8004D94", 0, 0, "", "", "", "");
    }
    if (("FROM_PHOTO_LIST_FLOW".equals(this.a.e)) && (this.a.J)) {
      this.a.setResult(-1);
    }
    this.a.finish();
    baaf.a(this.a, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agce
 * JD-Core Version:    0.7.0.1
 */