import android.view.View;
import java.lang.ref.WeakReference;

class acwc
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<acwb> b;
  
  public acwc(acvz paramacvz, View paramView, acwb paramacwb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramacwb);
  }
  
  public acwb a()
  {
    return (acwb)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwc
 * JD-Core Version:    0.7.0.1
 */