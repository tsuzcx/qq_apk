import BOSSStrategyCenter.tAdvDesc;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajdy
{
  public int a;
  public tAdvDesc a;
  public SparseArray<ajdz> a;
  public String a;
  public int b;
  public String b;
  public int c;
  private int d;
  
  public ajdy(tAdvDesc paramtAdvDesc)
  {
    this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc = paramtAdvDesc;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    a();
  }
  
  public static ajdy a(tAdvDesc paramtAdvDesc)
  {
    if ((paramtAdvDesc == null) || (TextUtils.isEmpty(paramtAdvDesc.res_data))) {
      return null;
    }
    switch (paramtAdvDesc.pattern_id)
    {
    default: 
      return null;
    case 1012: 
      return new ajdy(paramtAdvDesc);
    case 1108: 
      return new bkca(paramtAdvDesc);
    }
    return new bkcc(paramtAdvDesc);
  }
  
  public ajec a()
  {
    if ((this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc == null) || (TextUtils.isEmpty(this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data))) {
      return null;
    }
    switch (this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.pattern_id)
    {
    default: 
      return null;
    case 1012: 
      return new ajec();
    case 1108: 
      return new bkcb();
    }
    return new bkcf();
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc == null) || (TextUtils.isEmpty(this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data)))
    {
      QLog.e("QbossADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    String str1 = this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data;
    try
    {
      Object localObject = new JSONObject(str1);
      int i = ((JSONObject)localObject).optInt("res_type");
      String str2 = ((JSONObject)localObject).optString("res_url");
      String str3 = ((JSONObject)localObject).optString("res_url_md5");
      int j = ((JSONObject)localObject).optInt("jump_type");
      String str4 = ((JSONObject)localObject).optString("jump_url");
      int k = ((JSONObject)localObject).optInt("WebViewPreloadFlag");
      if (QLog.isColorLevel()) {
        QLog.d("QbossADBannerManager", 2, "webViewPreloadFlag: " + k);
      }
      this.jdField_a_of_type_Int = i;
      this.jdField_b_of_type_Int = j;
      this.jdField_a_of_type_JavaLangString = str4;
      this.d = k;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_traceinfo;
      this.c = this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.task_id;
      localObject = new ajdz();
      ((ajdz)localObject).jdField_a_of_type_JavaLangString = str2;
      ((ajdz)localObject).jdField_b_of_type_JavaLangString = str3;
      ((ajdz)localObject).c = ajea.a().a(str2);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1, localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
      bjmf.a().a(2741, this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.task_id, 102, "json parseError exception = " + localException.getMessage() + " json string = " + str1);
    }
  }
  
  boolean a()
  {
    return this.d == 1;
  }
  
  public boolean b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ajdz localajdz = (ajdz)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localajdz == null) || (TextUtils.isEmpty(localajdz.c)) || (!localajdz.a())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdy
 * JD-Core Version:    0.7.0.1
 */