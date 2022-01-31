import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class aarr
  implements View.OnClickListener
{
  public aarr(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public void onClick(View paramView)
  {
    ArkAppCenter.a().post(new aars(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarr
 * JD-Core Version:    0.7.0.1
 */