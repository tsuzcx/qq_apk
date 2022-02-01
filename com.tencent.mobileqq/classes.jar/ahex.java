import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class ahex
  implements View.OnClickListener
{
  ahex(ahew paramahew, MessageForQCircleFeed paramMessageForQCircleFeed) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = new FeedCloudMeta.StFeed();
    ((FeedCloudMeta.StFeed)localObject1).id.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleFeed.feedId);
    ((FeedCloudMeta.StFeed)localObject1).createTime.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleFeed.time);
    Object localObject2 = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject2).id.set(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleFeed.fromUin));
    ((FeedCloudMeta.StFeed)localObject1).poster.set((MessageMicro)localObject2);
    localObject2 = new uxk();
    ((uxk)localObject2).a((FeedCloudMeta.StFeed)localObject1);
    localObject1 = ((uxk)localObject2).a();
    ((QCircleInitBean)localObject1).isSingleFeed = true;
    uxo.a((QCircleInitBean)localObject1);
    bcst.b(null, "dc00898", "", this.jdField_a_of_type_Ahew.a.a, "0X800B27A", "0X800B27A", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahex
 * JD-Core Version:    0.7.0.1
 */