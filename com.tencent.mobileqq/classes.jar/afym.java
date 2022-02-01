import android.view.View;
import java.lang.ref.WeakReference;

class afym
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<afyl> b;
  
  public afym(afyj paramafyj, View paramView, afyl paramafyl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramafyl);
  }
  
  public afyl a()
  {
    return (afyl)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afym
 * JD-Core Version:    0.7.0.1
 */