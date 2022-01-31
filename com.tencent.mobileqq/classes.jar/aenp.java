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

public class aenp
  implements OnCompositionLoadedListener
{
  public aenp(ConfessChatPie.3 param3) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = actj.a(30.0F, this.a.this$0.jdField_a_of_type_AndroidContentContext.getResources());
    int j = actj.a(30.0F, this.a.this$0.jdField_a_of_type_AndroidContentContext.getResources());
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
    aenm.a(this.a.this$0, (LottieDrawable)localObject);
    aenm.a(this.a.this$0).addAnimatorListener(new aenq(this));
    ThreadManager.getUIHandler().post(new ConfessChatPie.3.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenp
 * JD-Core Version:    0.7.0.1
 */