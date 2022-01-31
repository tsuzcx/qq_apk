import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3.1.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agkg
  implements OnCompositionLoadedListener
{
  public agkg(ConfessChatPie.3 param3) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = aekt.a(30.0F, this.a.this$0.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aekt.a(30.0F, this.a.this$0.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramLottieComposition == null)
    {
      QLog.e(this.a.this$0.jdField_a_of_type_JavaLangString, 1, "onCompositionLoaded lottieComposition is null");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).loop(false);
    agkd.a(this.a.this$0, (LottieDrawable)localObject);
    agkd.a(this.a.this$0).addAnimatorListener(new agkh(this));
    ThreadManager.getUIHandler().post(new ConfessChatPie.3.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkg
 * JD-Core Version:    0.7.0.1
 */