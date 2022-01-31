import NS_QQ_STORY_META.META.StStoryFeed;
import NS_QQ_STORY_META.META.StUser;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.StStoryFeedUtil;
import java.io.Serializable;
import java.util.ArrayList;

class aczm
  implements View.OnClickListener
{
  aczm(aczl paramaczl, MessageForAIOStoryVideo paramMessageForAIOStoryVideo) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    paramView = (acjz)this.jdField_a_of_type_Aczl.a.getManager(282);
    if (paramView != null) {
      paramView.a(4, 7);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForAIOStoryVideo.mStStoryFeed;
    if ((localObject != null) && (((META.StStoryFeed)localObject).postUser != null))
    {
      paramView = new Bundle();
      paramView.putLong("key_launch_time", l);
      paramView.putLong("key_current_feeduin", ((META.StStoryFeed)localObject).postUser.uin.get());
      paramView.putInt("key_request_from", 3);
      paramView.putInt("key_weishi_entrance_type", 19);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      localObject = StStoryFeedUtil.getConvertDataList(localArrayList);
      paramView.putInt("key_video_story_jump_position", 0);
      paramView.putSerializable("key_video_story_tranparent_story_feed", (Serializable)localObject);
      paramView.putInt("key_request_business_type", 7);
      bacn.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aczm
 * JD-Core Version:    0.7.0.1
 */