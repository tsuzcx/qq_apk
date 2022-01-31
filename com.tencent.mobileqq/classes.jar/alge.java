import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class alge
  implements View.OnClickListener
{
  alge(algb paramalgb) {}
  
  public void onClick(View paramView)
  {
    zva.a(algb.a(this.a), -3, "user canceled");
    algb.a(this.a).a();
    algb.a(this.a).dismiss();
    algb.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alge
 * JD-Core Version:    0.7.0.1
 */