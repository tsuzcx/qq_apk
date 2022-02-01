import android.view.View;
import java.lang.ref.WeakReference;

class aavf
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aqqx> b;
  
  public aavf(aave paramaave, View paramView, aqqx paramaqqx)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaqqx);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public aqqx a()
  {
    return (aqqx)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aavf
 * JD-Core Version:    0.7.0.1
 */