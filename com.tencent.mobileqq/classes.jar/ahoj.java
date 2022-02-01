import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class ahoj
  implements View.OnClickListener
{
  ahoj(ahoi paramahoi, MessageForQCircleFeed paramMessageForQCircleFeed) {}
  
  public void onClick(View paramView)
  {
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleFeed.feedId);
    localStFeed.createTime.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleFeed.time);
    Object localObject = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject).id.set(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleFeed.fromUin));
    localStFeed.poster.set((MessageMicro)localObject);
    localObject = new QCircleInitBean();
    ((QCircleInitBean)localObject).setFeed(localStFeed);
    ((QCircleInitBean)localObject).setSingleFeed(true);
    uyx.a(this.jdField_a_of_type_Ahoi.jdField_a_of_type_AndroidContentContext, (QCircleInitBean)localObject);
    bdll.b(null, "dc00898", "", this.jdField_a_of_type_Ahoi.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X800B27A", "0X800B27A", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahoj
 * JD-Core Version:    0.7.0.1
 */