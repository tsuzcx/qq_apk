import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.CheckListener;

class aecc
  implements GroupVideoManager.CheckListener
{
  aecc(aecb paramaecb) {}
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!GroupVideoLoadingFragment.a) && (GroupVideoManager.a(this.a.a) != null)) {
      this.a.a.a(GroupVideoManager.a(this.a.a).getApp(), "", GroupVideoManager.a(this.a.a).getCurrentAccountUin(), 0, "slientDownload", "", "", null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecc
 * JD-Core Version:    0.7.0.1
 */