import android.view.View;
import java.lang.ref.WeakReference;

class abwb
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<abwc> b;
  
  public abwb(abvz paramabvz, View paramView, abwc paramabwc)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramabwc);
  }
  
  public abwc a()
  {
    return (abwc)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwb
 * JD-Core Version:    0.7.0.1
 */