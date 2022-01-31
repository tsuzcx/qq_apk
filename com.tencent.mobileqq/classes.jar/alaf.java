import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;

public class alaf
  implements ValueAnimator.AnimatorUpdateListener
{
  public alaf(ApolloCardWindow paramApolloCardWindow, TextView paramTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != ApolloCardWindow.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow)) {
        break label42;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alac.c(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
    }
    label42:
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView == ApolloCardWindow.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alac.b(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
        return;
      }
    } while (this.jdField_a_of_type_AndroidWidgetTextView != ApolloCardWindow.c(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alac.a(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alaf
 * JD-Core Version:    0.7.0.1
 */