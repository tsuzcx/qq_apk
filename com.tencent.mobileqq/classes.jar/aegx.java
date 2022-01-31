import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.now.send.EditVideoUi;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView.IAddTopicClickListener;

public class aegx
  implements StartLiveTopicLabelListView.IAddTopicClickListener
{
  public aegx(PublishManager paramPublishManager) {}
  
  public void a()
  {
    int i = 1;
    if (System.currentTimeMillis() - PublishManager.a(this.a) < 1000L) {
      return;
    }
    PublishManager.a(this.a, System.currentTimeMillis());
    Object localObject1 = new StringBuilder("https://now.qq.com/mobile/topic/add.html?_wv=16778245&from=mqq");
    ((StringBuilder)localObject1).append("&type=");
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.h != 0) {
      ((StringBuilder)localObject1).append("4");
    }
    for (;;)
    {
      Object localObject2 = PublishManager.a(this.a);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((StringBuilder)localObject1).append("&labels=");
        ((StringBuilder)localObject1).append((String)localObject2);
      }
      localObject2 = new Intent(PublishManager.a(this.a), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", ((StringBuilder)localObject1).toString());
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().startActivityForResult((Intent)localObject2, 1);
      localObject1 = new NowVideoReporter().h("video_public").i("clk_label");
      if (this.a.b) {
        i = 2;
      }
      ((NowVideoReporter)localObject1).a(i).d(PublishManager.b(this.a)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((StringBuilder)localObject1).append("3");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aegx
 * JD-Core Version:    0.7.0.1
 */