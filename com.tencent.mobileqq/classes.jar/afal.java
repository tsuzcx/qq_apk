import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.nearby.now.ProgressControler;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel.OnDataComeListener;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class afal
  implements BasePlayListDataModel.OnDataComeListener
{
  public afal(StoryPlayController paramStoryPlayController) {}
  
  public void a()
  {
    if ((NetworkUtil.a(this.a.a())) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.a();
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnRetryClickListener(new afam(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onDataCome ! type is: " + paramInt1 + " errorCode is " + paramInt2);
    }
    if ((paramInt2 > 0) || (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a().size() == 0))
    {
      QLog.e("VideoPlayController", 1, "onDataCome errorCode > 0, errorCode=" + paramInt2 + " mPlayListDataModel.getDataList().size() is : " + this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a().size());
      if (paramInt2 == 1000730) {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "onDataCome error! errorCode is: " + paramInt2);
        }
      }
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayController", 2, "onDataCome error! pass it! errorCode is: " + paramInt2);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.b(false);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.a(paramInt2);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a());
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a());
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_Boolean) {
      if (StoryPlayController.a(this.a))
      {
        paramInt2 = 0;
        if (paramInt2 >= this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a().size()) {
          break label661;
        }
        if (!((VideoData)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a().get(paramInt2)).jdField_a_of_type_JavaLangString.equals(StoryPlayController.a(this.a))) {}
      }
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == -1) {
        i = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a().size() / 2 - 1;
      }
      this.a.c = i;
      if (i != -1)
      {
        this.a.jdField_a_of_type_Int = i;
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      }
      QualityReporter.b();
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt1, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a());
        this.a.a();
        if (StoryPlayController.a(this.a))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(this.a.jdField_a_of_type_Int, false);
          StoryPlayController.a(this.a, false);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.notifyDataSetChanged();
        StoryPlayController.b(this.a, this.a.jdField_a_of_type_Int);
        return;
        paramInt2 += 1;
        break;
        if (paramInt1 == 0)
        {
          paramInt2 = this.a.jdField_a_of_type_Int;
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a().size();
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_Boolean) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt1, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a());
      this.a.a();
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(this.a.jdField_a_of_type_Int, false);
      return;
      label661:
      paramInt2 = -1;
    }
  }
  
  public void a(VideoData paramVideoData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onFillData ! data is: " + paramVideoData.toString() + " " + paramVideoData.c);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.size() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.b.size() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "onFillData ! suc");
      }
      paramVideoData.c = ((VideoData)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(0)).c;
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.set(0, paramVideoData);
      ((VideoPlayerPagerAdapter.VideoViewHolder)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(0)).jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(0);
      ShortVideoCommentsView localShortVideoCommentsView = (ShortVideoCommentsView)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.b.get(0);
      localShortVideoCommentsView.setVideoData(paramVideoData);
      localShortVideoCommentsView.d();
      localShortVideoCommentsView.h();
      localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setCurrentAnchorUin(paramVideoData.jdField_a_of_type_Long);
      this.a.a(localVideoViewHolder, paramVideoData, false, localShortVideoCommentsView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afal
 * JD-Core Version:    0.7.0.1
 */