import android.view.View;
import com.tencent.mobileqq.arcard.ARCardLoadingProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class algc
  implements Runnable
{
  public algc(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void run()
  {
    if (((ARCardLoadingProgressView)this.a.getView().findViewById(2131375575)).getVisibility() == 0)
    {
      WorldCupShareFragment.b(this.a);
      QQToast.a(BaseApplication.getContext(), 1, 2131439414, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algc
 * JD-Core Version:    0.7.0.1
 */