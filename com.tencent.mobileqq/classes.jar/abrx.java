import android.view.View;
import java.lang.ref.WeakReference;

class abrx
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<abry> b;
  
  public abrx(abrv paramabrv, View paramView, abry paramabry)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramabry);
  }
  
  public abry a()
  {
    return (abry)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrx
 * JD-Core Version:    0.7.0.1
 */