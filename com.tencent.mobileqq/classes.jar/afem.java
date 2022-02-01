import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

class afem
  implements OnCompositionLoadedListener
{
  afem(afej paramafej, FileInputStream paramFileInputStream) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (afej.a(this.jdField_a_of_type_Afej) == null) {
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
          afej.a(this.jdField_a_of_type_Afej).setComposition(paramLottieComposition);
          afej.a(this.jdField_a_of_type_Afej).loop(false);
          afej.a(this.jdField_a_of_type_Afej).setVisibility(0);
          afej.a(this.jdField_a_of_type_Afej).playAnimation();
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
        afej.a(this.jdField_a_of_type_Afej).clear();
        this.jdField_a_of_type_Afej.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afem
 * JD-Core Version:    0.7.0.1
 */