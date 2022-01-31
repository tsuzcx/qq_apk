import android.view.View;
import java.lang.ref.WeakReference;

class akis
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<akir> b;
  
  public akis(akio paramakio, View paramView, akir paramakir)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramakir);
  }
  
  public akir a()
  {
    return (akir)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akis
 * JD-Core Version:    0.7.0.1
 */