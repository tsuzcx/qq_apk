import android.view.View;
import java.lang.ref.WeakReference;

class abyw
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<arxb> b;
  
  public abyw(abyv paramabyv, View paramView, arxb paramarxb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramarxb);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public arxb a()
  {
    return (arxb)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyw
 * JD-Core Version:    0.7.0.1
 */