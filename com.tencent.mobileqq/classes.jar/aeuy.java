import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;

public class aeuy
  implements View.OnClickListener
{
  public aeuy(SmallVideoSendFragment paramSmallVideoSendFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = SmallVideoSendFragment.b(this.a);
    Bundle localBundle = new Bundle();
    localBundle.putString("preLoadParams", paramView);
    localBundle.putBoolean("scroll_to_comment", false);
    localBundle.putString("isLocal", "1");
    localBundle.putString("play_mode", String.valueOf(2));
    localBundle.putBoolean("is_multi_progress_bar", false);
    if (SmallVideoSendFragment.a(this.a).h == 1) {}
    for (paramView = "4";; paramView = "2")
    {
      localBundle.putString("feed_type", paramView);
      SmallVideoFragment.a(this.a.getActivity(), localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeuy
 * JD-Core Version:    0.7.0.1
 */