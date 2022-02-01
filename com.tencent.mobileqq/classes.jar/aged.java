import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.1;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;

public class aged
  implements OnCompositionLoadedListener
{
  public aged(AudioTransitionAnimManager.1 param1) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      QLog.e("AudioTransitionAnimManager", 2, "getDrawable onCompositionLoaded lottieComposition is null or mIsDestroyed:");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable finish type" + this.a.jdField_a_of_type_Int);
    }
    agec.a(this.a.this$0).remove(Integer.valueOf(this.a.jdField_a_of_type_Int));
    LottieDrawable localLottieDrawable = new LottieDrawable();
    agei localagei = new agei(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_JavaLangString);
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.setImageAssetDelegate(localagei);
    agec.a(this.a.this$0).put(this.a.jdField_a_of_type_JavaLangString, localLottieDrawable);
    agec.a(this.a.this$0, localLottieDrawable, this.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aged
 * JD-Core Version:    0.7.0.1
 */