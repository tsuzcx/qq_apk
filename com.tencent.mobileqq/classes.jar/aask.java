import android.view.View;
import java.lang.ref.WeakReference;

class aask
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aasl> b;
  
  public aask(aasi paramaasi, View paramView, aasl paramaasl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaasl);
  }
  
  public aasl a()
  {
    return (aasl)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aask
 * JD-Core Version:    0.7.0.1
 */