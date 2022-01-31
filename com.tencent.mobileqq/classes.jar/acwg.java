import android.view.View;
import java.lang.ref.WeakReference;

class acwg
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<acwf> b;
  
  public acwg(acwd paramacwd, View paramView, acwf paramacwf)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramacwf);
  }
  
  public acwf a()
  {
    return (acwf)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwg
 * JD-Core Version:    0.7.0.1
 */