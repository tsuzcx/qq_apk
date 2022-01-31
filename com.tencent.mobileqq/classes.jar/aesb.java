import android.view.View;
import java.lang.ref.WeakReference;

class aesb
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aesa> b;
  
  public aesb(aery paramaery, View paramView, aesa paramaesa)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaesa);
  }
  
  public aesa a()
  {
    return (aesa)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesb
 * JD-Core Version:    0.7.0.1
 */