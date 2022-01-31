import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoLoadingUI;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;

public class aeby
  implements View.OnClickListener
{
  private aeby(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void onClick(View paramView)
  {
    GroupVideoLoadingFragment.a(this.a).a("正在检查环境", "群视频体验群，可尝鲜更酷炫的多人互动");
    GroupVideoLoadingFragment.a(this.a).c();
    GroupVideoLoadingFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeby
 * JD-Core Version:    0.7.0.1
 */