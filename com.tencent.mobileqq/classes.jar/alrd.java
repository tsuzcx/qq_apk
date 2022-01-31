import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class alrd
  implements View.OnClickListener
{
  alrd(alra paramalra) {}
  
  public void onClick(View paramView)
  {
    if ((alra.a(this.a) == null) || (alra.a(this.a).size() <= 0) || (alra.a(this.a) >= alra.a(this.a).size()) || (alra.a(this.a).get(alra.a(this.a)) == null)) {
      return;
    }
    paramView = ((adlk)alra.a(this.a).get(alra.a(this.a))).getAppName();
    ArkAppCenter.a().post(paramView, new ArkAiAppPanel.4.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alrd
 * JD-Core Version:    0.7.0.1
 */