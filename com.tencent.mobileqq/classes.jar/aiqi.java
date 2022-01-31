import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aiqi
  extends aiqf
{
  protected int a;
  protected aiqj a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private final String jdField_a_of_type_JavaLangString = "VideoPlayControllerForAIO";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private ImageView b;
  
  public aiqi()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
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
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365828));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(aiqj paramaiqj)
  {
    this.jdField_a_of_type_Aiqj = paramaiqj;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372258));
    this.b = ((ImageView)paramView.findViewById(2131372257));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372259));
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
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, mCenterPlayBtn is null.");
      }
    }
    do
    {
      do
      {
        return false;
        if (this.b.getVisibility() != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, event.getRawX() = " + paramMotionEvent.getRawX() + " , event.getRawY() = " + paramMotionEvent.getRawY() + " , mCenterPlayBtn left = " + this.b.getLeft() + " , top = " + this.b.getTop() + " , right = " + this.b.getRight() + ", bottom = " + this.b.getBottom());
        }
      } while (!new Rect(this.b.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
      if (QLog.isColorLevel()) {
        QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, playbtn contains event");
      }
      return true;
    } while (!QLog.isColorLevel());
    QLog.d("VideoPlayControllerForAIO", 2, "onItemClick, mCenterPlayBtn is not visible.");
    return false;
  }
  
  public void b(int paramInt)
  {
    if (this.b != null)
    {
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
        this.b.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.b.setVisibility(paramInt);
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqi
 * JD-Core Version:    0.7.0.1
 */