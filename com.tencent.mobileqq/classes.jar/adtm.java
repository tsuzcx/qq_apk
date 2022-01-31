import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoLoadingUI;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.mobileqq.intervideo.groupvideo.PluginLoadListener;

public class adtm
  implements PluginLoadListener
{
  public adtm(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {}
    do
    {
      return;
      GroupVideoLoadingFragment.a(this.a, paramInt);
      switch (paramInt)
      {
      case 4: 
      case 8: 
      default: 
        return;
      }
    } while (!GroupVideoLoadingFragment.a(this.a));
    long l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).a("请进行更新", "当前处于移动网络环境下,是否继续？");
    GroupVideoLoadingFragment.a(this.a).a("立即更新(" + GVideoLoadingUI.a(l) + ")", new adtp(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).a("正在下载更新", "群视频体验群，可尝鲜更酷炫的多人互动");
    paramInt = paramBundle.getInt("key_progress", 0);
    l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).a(paramInt, l);
    GroupVideoLoadingFragment.a(this.a).b();
    return;
    GroupVideoLoadingFragment.a(this.a).a();
    GroupVideoLoadingFragment.a(this.a).a("正在努力加载", "群视频体验群，可尝鲜更酷炫的多人互动");
    paramBundle = Message.obtain();
    paramBundle.arg1 = 10;
    GroupVideoLoadingFragment.a(this.a).sendMessage(paramBundle);
    return;
    GroupVideoLoadingFragment.a(this.a).a("下载失败，请重试!", "请检查网络设置后重试");
    GroupVideoLoadingFragment.a(this.a).a("重新下载", new adtp(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).b();
    GroupVideoLoadingFragment.a(this.a).a("加载失败", "");
    GroupVideoLoadingFragment.a(this.a).a("重新加载", new adtp(this.a, null));
    return;
    GroupVideoLoadingFragment.b(this.a, 90);
    GroupVideoLoadingFragment.a(this.a).a(90, 0L);
    return;
    GroupVideoLoadingFragment.b(this.a, 100);
    GroupVideoLoadingFragment.a(this.a).a(100, 0L);
    GroupVideoLoadingFragment.a(this.a).postDelayed(new adtn(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtm
 * JD-Core Version:    0.7.0.1
 */