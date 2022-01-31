import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class alcp
  implements View.OnClickListener
{
  alcp(alcm paramalcm) {}
  
  public void onClick(View paramView)
  {
    if ((alcm.a(this.a) == null) || (alcm.a(this.a).size() <= 0) || (alcm.a(this.a) >= alcm.a(this.a).size()) || (alcm.a(this.a).get(alcm.a(this.a)) == null)) {
      return;
    }
    paramView = ((adai)alcm.a(this.a).get(alcm.a(this.a))).getAppName();
    ArkAppCenter.a().post(paramView, new ArkAiAppPanel.4.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alcp
 * JD-Core Version:    0.7.0.1
 */