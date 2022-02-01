import android.view.View;
import java.lang.ref.WeakReference;

class abus
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<arhm> b;
  
  public abus(abur paramabur, View paramView, arhm paramarhm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramarhm);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public arhm a()
  {
    return (arhm)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abus
 * JD-Core Version:    0.7.0.1
 */