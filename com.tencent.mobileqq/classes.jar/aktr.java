import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.CustomedTabWidget;

public class aktr
  implements View.OnClickListener
{
  public aktr(CustomedTabWidget paramCustomedTabWidget) {}
  
  public void onClick(View paramView)
  {
    this.a.setCurrentTab(this.a.indexOfChild(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aktr
 * JD-Core Version:    0.7.0.1
 */