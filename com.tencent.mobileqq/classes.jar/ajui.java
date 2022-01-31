import android.view.View;
import java.lang.ref.WeakReference;

class ajui
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<ajuh> b;
  
  public ajui(ajue paramajue, View paramView, ajuh paramajuh)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramajuh);
  }
  
  public ajuh a()
  {
    return (ajuh)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajui
 * JD-Core Version:    0.7.0.1
 */