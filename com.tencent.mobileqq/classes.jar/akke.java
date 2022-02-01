import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akke
  implements View.OnClickListener
{
  akke(akka paramakka) {}
  
  public void onClick(View paramView)
  {
    akka.a(this.a).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akke
 * JD-Core Version:    0.7.0.1
 */