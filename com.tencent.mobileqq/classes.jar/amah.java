import android.view.View;
import java.lang.ref.WeakReference;

class amah
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<amag> b;
  
  public amah(amad paramamad, View paramView, amag paramamag)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramamag);
  }
  
  public amag a()
  {
    return (amag)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amah
 * JD-Core Version:    0.7.0.1
 */