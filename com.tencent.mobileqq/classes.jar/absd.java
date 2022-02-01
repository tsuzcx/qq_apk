import android.view.View;
import java.lang.ref.WeakReference;

public class absd
{
  public WeakReference<View> a;
  public WeakReference<arhk> b;
  
  public absd(absc paramabsc, View paramView, arhk paramarhk)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramarhk);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public arhk a()
  {
    return (arhk)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absd
 * JD-Core Version:    0.7.0.1
 */