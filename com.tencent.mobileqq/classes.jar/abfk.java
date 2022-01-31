import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.ColorScreenLoader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

public class abfk
  implements OnCompositionLoadedListener
{
  public abfk(FriendProfileCardActivity.ColorScreenLoader paramColorScreenLoader) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if ((QLog.isColorLevel()) || (paramLottieComposition == null)) {
      QLog.d("ColorScreenManager", 1, "onCompositionLoaded: composition= " + paramLottieComposition);
    }
    if (paramLottieComposition == null)
    {
      bbrq.a(this.a.this$0.app, "individual_v2_colorscreen_parse_fail", "0", "", Integer.toString(this.a.jdField_a_of_type_Int), null, null, 0.0F, 0.0F);
      bbrp.a("individual_v2_colorscreen_parse_fail", "id:" + this.a.jdField_a_of_type_Int);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition = paramLottieComposition;
    this.a.this$0.b.postDelayed(this.a, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfk
 * JD-Core Version:    0.7.0.1
 */