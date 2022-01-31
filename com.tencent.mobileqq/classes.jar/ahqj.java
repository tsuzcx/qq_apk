import android.view.View;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResCallback;
import java.lang.ref.WeakReference;

public class ahqj
{
  int jdField_a_of_type_Int;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  int b;
  public WeakReference b;
  
  public ahqj(ScribbleResMgr paramScribbleResMgr, int paramInt1, int paramInt2, View paramView, ScribbleResMgr.ResCallback paramResCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramResCallback);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ScribbleResMgr.ResCallback a()
  {
    return (ScribbleResMgr.ResCallback)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqj
 * JD-Core Version:    0.7.0.1
 */