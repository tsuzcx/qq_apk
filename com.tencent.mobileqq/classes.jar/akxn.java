import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class akxn
  implements akrq
{
  public static int a;
  private SparseArray<akxo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public WeakReference<akyg> a;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public int b;
  
  static
  {
    jdField_a_of_type_Int = -2147483648;
  }
  
  public akxn()
  {
    a(new akxa());
  }
  
  public akxn(akyg paramakyg)
  {
    a(new akxa());
    if (paramakyg != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramakyg);
      this.b = paramakyg.a();
    }
  }
  
  private JSONObject a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("message", paramString);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("CmGameNetiveMethodHandler", 1, paramString, new Object[0]);
      }
    }
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (paramString2 != null)) {
      akwd.a().callbackFromRequest(paramLong, 0, paramString1, paramString2);
    }
  }
  
  private void a(String paramString)
  {
    a(0L, "cs.native_method_state.local", a(paramString).toString());
  }
  
  public int a()
  {
    return 0;
  }
  
  public akrw a(long paramLong, String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          break label325;
        }
        Object localObject = (akyg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          localObject = ((akyg)localObject).a();
          if ((localObject != null) && (((ApolloSurfaceView)localObject).getLuaState() == paramLong))
          {
            paramString2 = new JSONObject(paramString2);
            i = paramString2.optInt("N_R_OBJ");
            if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
            {
              localObject = (akxo)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
              paramString2.put("N_R_CMD", paramString1);
              paramString2.put("N_R_STATE", paramLong);
              if (localObject != null)
              {
                paramString1 = ((akxo)localObject).a(this, paramString2);
                if (paramString2.optBoolean("N_R_SYNC"))
                {
                  if (paramString1 != null) {
                    paramString1.put("code", 0);
                  }
                  localObject = new akrw();
                  ((akrw)localObject).b = true;
                  if (paramString1 == null)
                  {
                    paramString1 = paramString2.toString();
                    ((akrw)localObject).a = paramString1;
                    return localObject;
                  }
                  paramString1 = paramString1.toString();
                  continue;
                }
                a(paramString1);
              }
              else
              {
                int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
                i = 0;
                if (i < j)
                {
                  int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
                  paramString1 = (akxo)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
                  if (paramString1 == null) {
                    break label327;
                  }
                  paramString1 = paramString1.a(this, paramString2);
                  if (paramString1 == null) {
                    break label327;
                  }
                  a(paramString1);
                  break label327;
                }
              }
            }
          }
          else
          {
            QLog.e("CmGameNetiveMethodHandler", 1, "view is null");
          }
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("CmGameNetiveMethodHandler", 1, paramString1, new Object[0]);
        a("handleCmd " + paramString1.getMessage());
      }
      QLog.e("CmGameNetiveMethodHandler", 1, "launcher is null");
      label325:
      return null;
      label327:
      i += 1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        akxo localakxo = (akxo)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
        if (localakxo != null) {
          localakxo.a();
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      this.jdField_a_of_type_AndroidUtilSparseArray = null;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    this.jdField_a_of_type_OrgJsonJSONObject = null;
  }
  
  public void a(akxo paramakxo)
  {
    if (paramakxo != null)
    {
      int i = paramakxo.c();
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      }
      if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramakxo);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        int i = paramJSONObject.optInt("N_R_SE", -1);
        int j = paramJSONObject.optInt("N_R_OBJ", -1);
        long l = paramJSONObject.optLong("N_R_STATE");
        String str = paramJSONObject.optString("N_R_CMD", null);
        if ((i != -1) && (j != -1) && (!TextUtils.isEmpty(str)))
        {
          akwd.a().callbackFromRequest(l, 0, str, paramJSONObject.toString());
          return;
        }
        QLog.e("CmGameNetiveMethodHandler", 1, "response invalid " + str);
        a("invalid response " + i + " # " + j + " # " + str);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("CmGameNetiveMethodHandler", 1, paramJSONObject, new Object[0]);
      }
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
  
  public void b(akxo paramakxo)
  {
    if (paramakxo != null)
    {
      int i = paramakxo.c();
      paramakxo.a();
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxn
 * JD-Core Version:    0.7.0.1
 */