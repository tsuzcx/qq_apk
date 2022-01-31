import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView.2;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

public class ahrf
  implements OnCompositionLoadedListener
{
  public ahrf(LoginAnimBtnView.2 param2) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if ((paramLottieComposition == null) || (LoginAnimBtnView.a(this.a.this$0))) {
      QLog.e("LoginAnimBtnView", 1, "onCompositionLoaded lottieComposition is null or mIsDestroyed:" + LoginAnimBtnView.a(this.a.this$0));
    }
    do
    {
      return;
      int i = actj.a(70.0F, this.a.this$0.getResources());
      int j = actj.a(70.0F, this.a.this$0.getResources());
      Object localObject = paramLottieComposition.getBounds();
      float f1 = i / ((Rect)localObject).width();
      float f2 = j / ((Rect)localObject).height();
      if (QLog.isColorLevel()) {
        QLog.i("LoginAnimBtnView", 2, "onCompositionLoaded iw:" + i + ", ih:" + j + ": : rw:" + ((Rect)localObject).width() + ", rh:" + ((Rect)localObject).height());
      }
      localObject = new LottieDrawable();
      ((LottieDrawable)localObject).setImageAssetDelegate(new ahrg(this.a.this$0.getContext().getApplicationContext()));
      ((LottieDrawable)localObject).setComposition(paramLottieComposition);
      ((LottieDrawable)localObject).setScale(f1, f2);
      ((LottieDrawable)localObject).loop(true);
      paramLottieComposition = ((LottieDrawable)localObject).getBounds();
      if (QLog.isColorLevel()) {
        QLog.i("LoginAnimBtnView", 2, "onCompositionLoaded rw:" + paramLottieComposition.width() + ", rh:" + paramLottieComposition.height() + " mIsDestroyed:" + LoginAnimBtnView.a(this.a.this$0));
      }
      LoginAnimBtnView.a(this.a.this$0, (LottieDrawable)localObject);
      if (LoginAnimBtnView.a(this.a.this$0))
      {
        ((LottieDrawable)localObject).cancelAnimation();
        ((LottieDrawable)localObject).recycleBitmaps();
        ((LottieDrawable)localObject).clearComposition();
        ((LottieDrawable)localObject).setImageAssetDelegate(null);
        LoginAnimBtnView.a(this.a.this$0, null);
        return;
      }
    } while (!this.a.this$0.isEnabled());
    this.a.this$0.removeCallbacks(LoginAnimBtnView.a(this.a.this$0));
    this.a.this$0.post(LoginAnimBtnView.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahrf
 * JD-Core Version:    0.7.0.1
 */