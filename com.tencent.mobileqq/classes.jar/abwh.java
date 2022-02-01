import android.view.View;
import java.lang.ref.WeakReference;

public class abwh
{
  public WeakReference<View> a;
  public WeakReference<arwz> b;
  
  public abwh(abwg paramabwg, View paramView, arwz paramarwz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramarwz);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public arwz a()
  {
    return (arwz)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwh
 * JD-Core Version:    0.7.0.1
 */