import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;

public class aion
  implements View.OnClickListener
{
  public aion(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    paramView = this.a.a;
    boolean bool;
    String str;
    if (!this.a.a.isChecked())
    {
      bool = true;
      paramView.setChecked(bool);
      this.a.d = this.a.a.isChecked();
      this.a.i = 2;
      paramView = this.a;
      str = this.a.getCurrentAccountUin();
      if (!this.a.d) {
        break label92;
      }
    }
    for (;;)
    {
      bdne.E(paramView, str, i);
      return;
      bool = false;
      break;
      label92:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aion
 * JD-Core Version:    0.7.0.1
 */