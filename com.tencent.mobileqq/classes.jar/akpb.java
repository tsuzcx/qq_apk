import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class akpb
  implements View.OnClickListener
{
  akpb(akpa paramakpa) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.a(this.a.mActivity, (String)akpa.a(this.a).selectedPhotoList.get(0), new akpc(this));
    AIOLongShotHelper.a("0X8009DEE");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpb
 * JD-Core Version:    0.7.0.1
 */