import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afyt
  implements View.OnClickListener
{
  public afyt(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyt
 * JD-Core Version:    0.7.0.1
 */