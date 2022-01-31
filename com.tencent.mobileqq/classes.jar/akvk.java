import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.ui.NativeUIManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class akvk
{
  private int jdField_a_of_type_Int;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  public HashMap<String, akvj> a;
  
  public akvk(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public akvj a(String paramString)
  {
    akvc localakvc = null;
    Object localObject = null;
    if ("Dialog".equals(paramString))
    {
      localakvc = new akvc();
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        break label38;
      }
    }
    label38:
    for (paramString = localObject;; paramString = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      localakvc.a(paramString);
      return localakvc;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (akvj)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (localObject != null) {
            ((akvj)localObject).a();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(akvj paramakvj)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (paramakvj != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramakvj.a());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = akro.a(this.jdField_a_of_type_Int);
    if (paramString1 != null)
    {
      paramString1 = paramString1.a();
      if (paramString1 != null) {
        paramString1.runRenderTask(new NativeUIManager.1(this, paramString1, paramString2, paramString3));
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    akvj localakvj;
    if (!TextUtils.isEmpty(paramString1))
    {
      localakvj = null;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localakvj = (akvj)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      }
      if (localakvj == null) {
        break label45;
      }
      localakvj.a(paramString2, paramString4, this);
    }
    label45:
    do
    {
      do
      {
        return;
      } while ("destroy".equals(paramString3));
      localakvj = a(paramString1);
    } while (localakvj == null);
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localakvj);
    a(paramString1, paramString2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvk
 * JD-Core Version:    0.7.0.1
 */