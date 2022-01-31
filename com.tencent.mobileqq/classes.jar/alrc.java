import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class alrc
  implements View.OnClickListener
{
  alrc(alqz paramalqz) {}
  
  public void onClick(View paramView)
  {
    if ((alqz.a(this.a) == null) || (alqz.a(this.a).size() <= 0) || (alqz.a(this.a) >= alqz.a(this.a).size()) || (alqz.a(this.a).get(alqz.a(this.a)) == null)) {
      return;
    }
    paramView = ((adli)alqz.a(this.a).get(alqz.a(this.a))).getAppName();
    ArkAppCenter.a().post(paramView, new ArkAiAppPanel.4.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alrc
 * JD-Core Version:    0.7.0.1
 */