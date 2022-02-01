import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class agkw
  implements View.OnClickListener
{
  agkw(agkv paramagkv, MessageForQCircleFeed paramMessageForQCircleFeed) {}
  
  public void onClick(View paramView)
  {
    bcef.b(null, "dc00898", "", this.jdField_a_of_type_Agkv.a.curFriendUin, "0X800B27A", "0X800B27A", 0, 0, "", "", "", "");
    HashMap localHashMap = new HashMap();
    localHashMap.put("feedid", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleFeed.feedId);
    localHashMap.put("createtime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleFeed.time));
    localHashMap.put("uin", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQCircleFeed.fromUin));
    localHashMap.put("issinglefeed", "1");
    localHashMap.put("is_feed_detail", "1");
    localHashMap.put("key_jump_from", "20");
    vgn.a(BaseApplication.getContext(), "opendetail", localHashMap);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkw
 * JD-Core Version:    0.7.0.1
 */