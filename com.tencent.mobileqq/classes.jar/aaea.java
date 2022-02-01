import android.os.Handler;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.biz.richframework.widget.BaseVideoView.1.1;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

public class aaea
  implements SDKInitListener
{
  public aaea(BaseVideoView paramBaseVideoView) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    this.a.a().post(new BaseVideoView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaea
 * JD-Core Version:    0.7.0.1
 */