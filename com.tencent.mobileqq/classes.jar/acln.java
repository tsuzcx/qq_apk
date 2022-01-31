import android.view.View;
import java.lang.ref.WeakReference;

class acln
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aclm> b;
  
  public acln(aclk paramaclk, View paramView, aclm paramaclm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaclm);
  }
  
  public aclm a()
  {
    return (aclm)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acln
 * JD-Core Version:    0.7.0.1
 */