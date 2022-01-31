import android.view.View;
import android.view.View.OnClickListener;

class aico
  implements View.OnClickListener
{
  aico(aicm paramaicm) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof aylx)) {
      return;
    }
    paramView = (aylx)paramView;
    this.a.a.a(paramView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aico
 * JD-Core Version:    0.7.0.1
 */