import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class acwr
{
  public View a;
  private WeakReference<acws> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<acws>> jdField_a_of_type_JavaUtilList;
  
  private int a(WeakReference<acws> paramWeakReference)
  {
    int j;
    if ((paramWeakReference == null) || (paramWeakReference.get() == null))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label71;
      }
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localWeakReference != null)
      {
        j = i;
        if (localWeakReference.get() == paramWeakReference.get()) {
          break;
        }
      }
      i += 1;
    }
    label71:
    return -1;
  }
  
  private acws a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (acws)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  private void a()
  {
    if (a() != null) {
      a().b();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  private boolean b(WeakReference<acws> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {}
    while (a(paramWeakReference) != -1) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramWeakReference);
    return true;
  }
  
  private boolean c(WeakReference<acws> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {}
    int i;
    do
    {
      return false;
      i = a(paramWeakReference);
    } while (i == -1);
    this.jdField_a_of_type_JavaUtilList.remove(i);
    return true;
  }
  
  public void a(WeakReference<acws> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == a()))
    {
      acvc.a("GdtVideoCommonView", "MutiVideoManager play return: " + paramWeakReference);
      return;
    }
    a();
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    b(paramWeakReference);
  }
  
  public boolean a(WeakReference<acws> paramWeakReference)
  {
    if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {}
    do
    {
      return false;
      c(paramWeakReference);
    } while (this.jdField_a_of_type_JavaUtilList.size() <= 0);
    paramWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.iterator().next();
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      ((acws)paramWeakReference.get()).a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwr
 * JD-Core Version:    0.7.0.1
 */