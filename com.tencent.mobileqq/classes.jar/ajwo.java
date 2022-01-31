import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ajwo
  implements Runnable
{
  public ajwo(TroopOnlineMemberBar paramTroopOnlineMemberBar) {}
  
  public void run()
  {
    if (TroopOnlineMemberBar.a(this.a) != 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((TroopOnlineMemberBar.a(this.a) != 2) && (NetworkUtil.g(this.a.jdField_a_of_type_AndroidContentContext))) {
        break label118;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131429900);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((this.a.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) && (this.a.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning())) {
        this.a.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
      }
      TroopOnlineMemberBar.a(this.a, 2);
    }
    label118:
    while (TroopOnlineMemberBar.a(this.a) != 1) {
      return;
    }
    if (this.a.jdField_a_of_type_AndroidGraphicsDrawableAnimatable == null) {
      this.a.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838596));
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.a.jdField_a_of_type_AndroidGraphicsDrawableAnimatable, null, null, null);
    this.a.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwo
 * JD-Core Version:    0.7.0.1
 */