import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class acsg
  implements OnCompositionLoadedListener
{
  public acsg(ExtendFriendVoiceView paramExtendFriendVoiceView) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int m = AIOUtils.a(19.0F, this.a.getResources());
    int k = AIOUtils.a(19.0F, this.a.getResources());
    int j = k;
    int i = m;
    if (ExtendFriendVoiceView.a(this.a) == 2)
    {
      i = (int)(m * 0.8F);
      j = (int)(k * 0.8F);
    }
    if (paramLottieComposition == null)
    {
      QLog.e("ExtendFriendVoiceView", 1, "onCompositionLoaded lottieComposition is null");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).loop(true);
    ExtendFriendVoiceView.a(this.a, (LottieDrawable)localObject);
    ThreadManager.getUIHandler().post(new acsh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsg
 * JD-Core Version:    0.7.0.1
 */