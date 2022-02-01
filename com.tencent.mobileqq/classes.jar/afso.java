import android.view.View;
import java.lang.ref.WeakReference;

class afso
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<afsn> b;
  
  public afso(afsl paramafsl, View paramView, afsn paramafsn)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramafsn);
  }
  
  public afsn a()
  {
    return (afsn)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afso
 * JD-Core Version:    0.7.0.1
 */