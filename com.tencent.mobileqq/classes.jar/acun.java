import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorView;

public class acun
  implements View.OnClickListener
{
  public acun(ColorView paramColorView) {}
  
  public void onClick(View paramView)
  {
    if (ColorView.a(this.a) != null) {
      ColorView.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acun
 * JD-Core Version:    0.7.0.1
 */