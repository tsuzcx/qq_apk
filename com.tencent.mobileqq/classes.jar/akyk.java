import android.view.View;
import com.tencent.mobileqq.arcard.ARCardLoadingProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class akyk
  implements Runnable
{
  public akyk(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void run()
  {
    if (((ARCardLoadingProgressView)this.a.getView().findViewById(2131375511)).getVisibility() == 0)
    {
      WorldCupShareFragment.b(this.a);
      QQToast.a(BaseApplication.getContext(), 1, 2131439375, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyk
 * JD-Core Version:    0.7.0.1
 */