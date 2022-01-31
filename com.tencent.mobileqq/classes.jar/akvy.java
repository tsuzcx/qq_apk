import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

class akvy
  implements View.OnClickListener
{
  akvy(akvu paramakvu) {}
  
  public void onClick(View paramView)
  {
    if ((akvu.a(this.a).d()) || (akvu.b(this.a)))
    {
      akvu.b(this.a, false);
      akvu.a(this.a).a();
      akvu.c(this.a).setVisibility(8);
      akvu.b(this.a).setVisibility(8);
    }
    while (!akvu.a(this.a).c()) {
      return;
    }
    akvu.b(this.a, true);
    akvu.a(this.a).b();
    akvu.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvy
 * JD-Core Version:    0.7.0.1
 */