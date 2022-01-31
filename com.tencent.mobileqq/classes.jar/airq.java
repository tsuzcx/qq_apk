import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

class airq
  implements View.OnClickListener
{
  airq(airm paramairm) {}
  
  public void onClick(View paramView)
  {
    if ((airm.a(this.a).d()) || (airm.b(this.a)))
    {
      airm.b(this.a, false);
      airm.a(this.a).a();
      airm.c(this.a).setVisibility(8);
      airm.b(this.a).setVisibility(8);
    }
    while (!airm.a(this.a).c()) {
      return;
    }
    airm.b(this.a, true);
    airm.a(this.a).b();
    airm.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airq
 * JD-Core Version:    0.7.0.1
 */