import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;

public class acvt
  implements View.OnClickListener
{
  public acvt(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.c(this.a, paramView);
    AIOLongShotHelper.a("0X8009DEC");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvt
 * JD-Core Version:    0.7.0.1
 */