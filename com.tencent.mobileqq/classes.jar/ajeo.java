import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

class ajeo
  implements View.OnClickListener
{
  ajeo(ajek paramajek) {}
  
  public void onClick(View paramView)
  {
    if ((ajek.a(this.a).d()) || (ajek.b(this.a)))
    {
      ajek.b(this.a, false);
      ajek.a(this.a).a();
      ajek.c(this.a).setVisibility(8);
      ajek.b(this.a).setVisibility(8);
    }
    while (!ajek.a(this.a).c()) {
      return;
    }
    ajek.b(this.a, true);
    ajek.a(this.a).b();
    ajek.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajeo
 * JD-Core Version:    0.7.0.1
 */