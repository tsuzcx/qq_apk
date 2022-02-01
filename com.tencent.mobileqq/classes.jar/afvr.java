import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

class afvr
  implements OnCompositionLoadedListener
{
  afvr(afvo paramafvo, FileInputStream paramFileInputStream) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (afvo.a(this.jdField_a_of_type_Afvo) == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "LottieComposition.Factory.fromInputStream mLottieView is null!");
      }
    }
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_JavaIoFileInputStream != null) {
          this.jdField_a_of_type_JavaIoFileInputStream.close();
        }
        if (paramLottieComposition != null)
        {
          afvo.a(this.jdField_a_of_type_Afvo).setComposition(paramLottieComposition);
          afvo.a(this.jdField_a_of_type_Afvo).loop(false);
          afvo.a(this.jdField_a_of_type_Afvo).setVisibility(0);
          afvo.a(this.jdField_a_of_type_Afvo).playAnimation();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("LottieAnimation", 2, "playNextAnim fromInputStream succ");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim fromInputStream composition null");
        }
        afvo.a(this.jdField_a_of_type_Afvo).clear();
        this.jdField_a_of_type_Afvo.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvr
 * JD-Core Version:    0.7.0.1
 */