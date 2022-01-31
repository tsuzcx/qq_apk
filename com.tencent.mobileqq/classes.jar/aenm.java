import android.view.View;
import java.lang.ref.WeakReference;

class aenm
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aenl> b;
  
  public aenm(aenj paramaenj, View paramView, aenl paramaenl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaenl);
  }
  
  public aenl a()
  {
    return (aenl)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenm
 * JD-Core Version:    0.7.0.1
 */