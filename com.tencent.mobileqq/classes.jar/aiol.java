import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;

public class aiol
  implements View.OnClickListener
{
  public aiol(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent();
    String str = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    int i = paramView.getIntExtra("PhotoConst.CLIP_WIDTH", 0);
    PhotoUtils.a(paramView, this.a, str, i, i, 1080, 1080, bddf.a());
    azqs.b(this.a.app, "dc00898", "", "", "0X800723F", "0X800723F", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiol
 * JD-Core Version:    0.7.0.1
 */