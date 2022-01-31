import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

class alan
  implements View.OnClickListener
{
  alan(alaj paramalaj) {}
  
  public void onClick(View paramView)
  {
    if ((alaj.a(this.a).d()) || (alaj.b(this.a)))
    {
      alaj.b(this.a, false);
      alaj.a(this.a).a();
      alaj.c(this.a).setVisibility(8);
      alaj.b(this.a).setVisibility(8);
    }
    while (!alaj.a(this.a).c()) {
      return;
    }
    alaj.b(this.a, true);
    alaj.a(this.a).b();
    alaj.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alan
 * JD-Core Version:    0.7.0.1
 */