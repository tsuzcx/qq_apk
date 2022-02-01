import android.view.View;
import java.lang.ref.WeakReference;

class abkr
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<arui> b;
  
  public abkr(abkq paramabkq, View paramView, arui paramarui)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramarui);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public arui a()
  {
    return (arui)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkr
 * JD-Core Version:    0.7.0.1
 */