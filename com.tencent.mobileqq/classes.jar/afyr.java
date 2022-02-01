import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.TroopTransferActivity;

public class afyr
  implements Animation.AnimationListener
{
  public afyr(TroopTransferActivity paramTroopTransferActivity, TranslateAnimation paramTranslateAnimation1, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  /* Error */
  public void onAnimationEnd(Animation paramAnimation)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 17	afyr:jdField_a_of_type_AndroidViewAnimationTranslateAnimation	Landroid/view/animation/TranslateAnimation;
    //   5: if_acmpne +49 -> 54
    //   8: aload_0
    //   9: getfield 15	afyr:jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity	Lcom/tencent/mobileqq/activity/TroopTransferActivity;
    //   12: getfield 34	com/tencent/mobileqq/activity/TroopTransferActivity:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +91 -> 108
    //   20: aload_0
    //   21: getfield 15	afyr:jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity	Lcom/tencent/mobileqq/activity/TroopTransferActivity;
    //   24: getfield 34	com/tencent/mobileqq/activity/TroopTransferActivity:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   27: invokevirtual 39	android/app/Dialog:show	()V
    //   30: aload_0
    //   31: getfield 15	afyr:jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity	Lcom/tencent/mobileqq/activity/TroopTransferActivity;
    //   34: getfield 42	com/tencent/mobileqq/activity/TroopTransferActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   37: aconst_null
    //   38: invokevirtual 47	android/widget/LinearLayout:setAnimation	(Landroid/view/animation/Animation;)V
    //   41: aload_0
    //   42: getfield 15	afyr:jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity	Lcom/tencent/mobileqq/activity/TroopTransferActivity;
    //   45: getfield 50	com/tencent/mobileqq/activity/TroopTransferActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   48: bipush 8
    //   50: invokevirtual 56	android/view/View:setVisibility	(I)V
    //   53: return
    //   54: aload_1
    //   55: aload_0
    //   56: getfield 19	afyr:b	Landroid/view/animation/TranslateAnimation;
    //   59: if_acmpne +49 -> 108
    //   62: aload_0
    //   63: getfield 15	afyr:jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity	Lcom/tencent/mobileqq/activity/TroopTransferActivity;
    //   66: getfield 42	com/tencent/mobileqq/activity/TroopTransferActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   69: aconst_null
    //   70: invokevirtual 47	android/widget/LinearLayout:setAnimation	(Landroid/view/animation/Animation;)V
    //   73: aload_0
    //   74: getfield 15	afyr:jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity	Lcom/tencent/mobileqq/activity/TroopTransferActivity;
    //   77: getfield 42	com/tencent/mobileqq/activity/TroopTransferActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   80: aload_0
    //   81: getfield 21	afyr:jdField_a_of_type_Int	I
    //   84: invokevirtual 59	android/widget/LinearLayout:offsetTopAndBottom	(I)V
    //   87: aload_0
    //   88: getfield 15	afyr:jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity	Lcom/tencent/mobileqq/activity/TroopTransferActivity;
    //   91: getfield 42	com/tencent/mobileqq/activity/TroopTransferActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   94: invokevirtual 62	android/widget/LinearLayout:requestLayout	()V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   103: return
    //   104: astore_1
    //   105: goto -75 -> 30
    //   108: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	afyr
    //   0	109	1	paramAnimation	Animation
    // Exception table:
    //   from	to	target	type
    //   0	16	98	java/lang/Exception
    //   30	53	98	java/lang/Exception
    //   54	97	98	java/lang/Exception
    //   20	30	104	java/lang/Exception
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyr
 * JD-Core Version:    0.7.0.1
 */