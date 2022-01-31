import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.ui.NativeUIManager.1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ajdy
{
  private int jdField_a_of_type_Int;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  public HashMap<String, ajdx> a;
  
  public ajdy(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public ajdx a(String paramString)
  {
    ajdq localajdq = null;
    Object localObject = null;
    if ("Dialog".equals(paramString))
    {
      localajdq = new ajdq();
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        break label38;
      }
    }
    label38:
    for (paramString = localObject;; paramString = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      localajdq.a(paramString);
      return localajdq;
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
          localObject = (ajdx)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (localObject != null) {
            ((ajdx)localObject).a();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(ajdx paramajdx)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (paramajdx != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramajdx.a());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = ajac.a(this.jdField_a_of_type_Int);
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
    ajdx localajdx;
    if (!TextUtils.isEmpty(paramString1))
    {
      localajdx = null;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localajdx = (ajdx)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      }
      if (localajdx == null) {
        break label45;
      }
      localajdx.a(paramString2, paramString4, this);
    }
    label45:
    do
    {
      do
      {
        return;
      } while ("destroy".equals(paramString3));
      localajdx = a(paramString1);
    } while (localajdx == null);
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localajdx);
    a(paramString1, paramString2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdy
 * JD-Core Version:    0.7.0.1
 */