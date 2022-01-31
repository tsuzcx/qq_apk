import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class afei
  implements View.OnClickListener
{
  public afei(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onClick(View paramView)
  {
    this.a.f(paramView);
    new NowVideoReporter().h("video").i("playpage_fw_click").a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afei
 * JD-Core Version:    0.7.0.1
 */