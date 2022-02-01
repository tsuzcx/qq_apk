import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class akvt
  implements View.OnClickListener
{
  akvt(akvs paramakvs) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.a(this.a.mActivity, (String)akvs.a(this.a).selectedPhotoList.get(0), new akvu(this));
    AIOLongShotHelper.a("0X8009DEE");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvt
 * JD-Core Version:    0.7.0.1
 */