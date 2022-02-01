import android.view.View;
import java.lang.ref.WeakReference;

class abhw
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<abhx> b;
  
  public abhw(abhu paramabhu, View paramView, abhx paramabhx)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramabhx);
  }
  
  public abhx a()
  {
    return (abhx)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abhw
 * JD-Core Version:    0.7.0.1
 */