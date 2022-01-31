import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.CheckListener;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.utils.NetworkUtil;

public class adjm
  implements GroupVideoManager.CheckListener
{
  public adjm(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GroupVideoLoadingFragment.a(this.a, false);
      return;
    }
    if (!NetworkUtil.a(GroupVideoLoadingFragment.a(this.a))) {
      GroupVideoLoadingFragment.a(this.a, true);
    }
    for (;;)
    {
      Monitor.b("2880338");
      return;
      GroupVideoLoadingFragment.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adjm
 * JD-Core Version:    0.7.0.1
 */