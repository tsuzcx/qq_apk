import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.NowSmallVideoObserver;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class afen
  extends NowSmallVideoObserver
{
  public afen(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(PlayOperationViewModel.b(this.a) + ""))) {
      this.a.h(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afen
 * JD-Core Version:    0.7.0.1
 */