import android.view.View;
import java.lang.ref.WeakReference;

class akir
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<akiq> b;
  
  public akir(akin paramakin, View paramView, akiq paramakiq)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramakiq);
  }
  
  public akiq a()
  {
    return (akiq)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akir
 * JD-Core Version:    0.7.0.1
 */