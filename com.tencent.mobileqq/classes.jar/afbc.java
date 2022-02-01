import android.view.View;
import java.lang.ref.WeakReference;

class afbc
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<afbb> b;
  
  public afbc(afaz paramafaz, View paramView, afbb paramafbb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramafbb);
  }
  
  public afbb a()
  {
    return (afbb)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbc
 * JD-Core Version:    0.7.0.1
 */