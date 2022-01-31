import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.qqstory.storyHome.QQStoryHomeJumpHelper.JumpListener;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.utils.JumpAction;

public class akka
  implements QQStoryHomeJumpHelper.JumpListener
{
  public akka(JumpAction paramJumpAction) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramString = StoryPublishLauncher.a();
    if (paramString.a())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("entrance_type", 15);
      paramString.a((Activity)this.a.a, localBundle, 20000);
      return;
    }
    paramString = new QQStoryTakeVideoActivityLauncher(JumpAction.a(this.a)).a(this.a.a, 15);
    ((Activity)this.a.a).startActivityForResult(paramString, 20000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akka
 * JD-Core Version:    0.7.0.1
 */