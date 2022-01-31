import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.groupvideo.PluginLoadListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aeca
  implements PluginLoadListener
{
  public aeca(GroupVideoManager paramGroupVideoManager) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    case 6: 
    case 8: 
    default: 
    case 5: 
    case 7: 
    case 10: 
      do
      {
        return;
        GroupVideoManager.a(this.a);
        if (GroupVideoManager.a(this.a) != null) {
          QQToast.a(GroupVideoManager.a(this.a).getApplication(), "加载失败，请重试", 1).b(GroupVideoManager.a(this.a).getApp().getResources().getDimensionPixelSize(2131558448));
        }
      } while (!QLog.isColorLevel());
      QLog.d("GroupVideoManager", 2, "GroupVideoPlugin loadFailed state:" + paramInt);
      return;
    }
    GroupVideoManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeca
 * JD-Core Version:    0.7.0.1
 */