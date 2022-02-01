import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiyp
  implements View.OnClickListener
{
  aiyp(aiym paramaiym) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyp
 * JD-Core Version:    0.7.0.1
 */