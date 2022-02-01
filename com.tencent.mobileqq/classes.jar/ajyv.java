import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajyv
  implements View.OnClickListener
{
  ajyv(ajyr paramajyr) {}
  
  public void onClick(View paramView)
  {
    ajyr.a(this.a).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyv
 * JD-Core Version:    0.7.0.1
 */