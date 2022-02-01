import android.view.View;
import java.lang.ref.WeakReference;

class agig
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<agif> b;
  
  public agig(agid paramagid, View paramView, agif paramagif)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramagif);
  }
  
  public agif a()
  {
    return (agif)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agig
 * JD-Core Version:    0.7.0.1
 */