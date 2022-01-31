import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import java.util.ArrayList;

class aitm
  implements View.OnClickListener
{
  aitm(aitl paramaitl) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.a(this.a.mActivity, (String)aitl.a(this.a).selectedPhotoList.get(0), new aitn(this));
    AIOLongShotHelper.a("0X8009DEE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitm
 * JD-Core Version:    0.7.0.1
 */