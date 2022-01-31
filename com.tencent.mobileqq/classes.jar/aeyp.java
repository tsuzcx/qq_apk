import android.app.Activity;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.MagazinePlayerView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aeyp
  implements Runnable
{
  public aeyp(VideoInfoListenerImpl paramVideoInfoListenerImpl) {}
  
  public void run()
  {
    if (((VideoInfoListenerImpl.a(this.a).jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)VideoInfoListenerImpl.a(this.a).jdField_a_of_type_AndroidContentContext).isFinishing())) {}
    label35:
    label246:
    do
    {
      do
      {
        do
        {
          do
          {
            break label35;
            break label35;
            do
            {
              return;
            } while ((VideoInfoListenerImpl.a(this.a).jdField_a_of_type_Int < 0) || (VideoInfoListenerImpl.a(this.a).jdField_a_of_type_Int >= VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size()));
            if (VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a == null) {
              break label246;
            }
            if (!VideoInfoListenerImpl.a(this.a).b) {
              break;
            }
            VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.b();
          } while (!QLog.isColorLevel());
          QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
          return;
          if (VideoInfoListenerImpl.a(this.a).b()) {
            break;
          }
          VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.b();
        } while (!QLog.isColorLevel());
        QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
        return;
        if (VideoInfoListenerImpl.a(this.a).jdField_a_of_type_Int != VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size() - 1) {
          break;
        }
      } while (!(VideoInfoListenerImpl.a(this.a).a() instanceof Activity));
      ((Activity)VideoInfoListenerImpl.a(this.a).a()).finish();
      return;
      Object localObject = (VideoData)VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(VideoInfoListenerImpl.a(this.a).jdField_a_of_type_Int);
      ((VideoData)localObject).f = 0;
      ((VideoData)localObject).c = false;
      localObject = VideoInfoListenerImpl.a(this.a);
      ((StoryPlayController)localObject).jdField_a_of_type_Int += 1;
      if (VideoInfoListenerImpl.a(this.a).jdField_a_of_type_Int < VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size())
      {
        VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(VideoInfoListenerImpl.a(this.a).jdField_a_of_type_Int, true);
        return;
      }
    } while (!VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a());
    VideoInfoListenerImpl.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeyp
 * JD-Core Version:    0.7.0.1
 */