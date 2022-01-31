import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import java.util.ArrayList;

class aiox
  implements View.OnClickListener
{
  aiox(aiow paramaiow) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.a(this.a.mActivity, (String)aiow.a(this.a).selectedPhotoList.get(0), new aioy(this));
    AIOLongShotHelper.a("0X8009DEE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiox
 * JD-Core Version:    0.7.0.1
 */