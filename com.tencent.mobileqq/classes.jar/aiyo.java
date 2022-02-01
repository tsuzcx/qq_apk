import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiyo
  implements View.OnClickListener
{
  aiyo(aiym paramaiym) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyo
 * JD-Core Version:    0.7.0.1
 */