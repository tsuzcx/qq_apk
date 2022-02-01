import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3.1.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ahzt
  implements OnCompositionLoadedListener
{
  public ahzt(ConfessChatPie.3 param3) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = AIOUtils.dp2px(30.0F, this.a.this$0.mContext.getResources());
    int j = AIOUtils.dp2px(30.0F, this.a.this$0.mContext.getResources());
    if (paramLottieComposition == null)
    {
      QLog.e(this.a.this$0.tag, 1, "onCompositionLoaded lottieComposition is null");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).loop(false);
    ahzq.a(this.a.this$0, (LottieDrawable)localObject);
    ahzq.a(this.a.this$0).addAnimatorListener(new ahzu(this));
    ThreadManager.getUIHandler().post(new ConfessChatPie.3.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzt
 * JD-Core Version:    0.7.0.1
 */