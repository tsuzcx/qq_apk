import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class adrn
  implements View.OnClickListener
{
  public adrn(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.l)
    {
      this.a.w();
      return;
    }
    if ("group_activity".equals(this.a.o))
    {
      this.a.k();
      return;
    }
    this.a.setResult(-1, this.a.a());
    this.a.finish();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrn
 * JD-Core Version:    0.7.0.1
 */