import android.view.View;
import java.lang.ref.WeakReference;

public class aasq
{
  public WeakReference<View> a;
  public WeakReference<aqqv> b;
  
  public aasq(aasp paramaasp, View paramView, aqqv paramaqqv)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaqqv);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public aqqv a()
  {
    return (aqqv)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasq
 * JD-Core Version:    0.7.0.1
 */