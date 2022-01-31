import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

public class aily
  extends ailq
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private ImageView b;
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.b = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      b(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(paramInt);
      ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365826)).setText(paramString);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372238));
    this.b = ((ImageView)paramView.findViewById(2131372237));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372239));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if (this.b != null) {
      this.b.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aily
 * JD-Core Version:    0.7.0.1
 */