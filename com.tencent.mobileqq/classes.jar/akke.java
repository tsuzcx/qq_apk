import BOSSStrategyCenter.tAdvDesc;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.QbossReportManager;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class akke
{
  public int a;
  public tAdvDesc a;
  public SparseArray<akkf> a;
  public TianShuAccess.AdItem a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  private int d;
  public String d;
  
  public akke(tAdvDesc paramtAdvDesc)
  {
    this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc = paramtAdvDesc;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    a();
  }
  
  public akke(TianShuAccess.AdItem paramAdItem)
  {
    this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = paramAdItem;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    b();
  }
  
  public static akke a(tAdvDesc paramtAdvDesc)
  {
    if ((paramtAdvDesc == null) || (TextUtils.isEmpty(paramtAdvDesc.res_data))) {
      return null;
    }
    switch (paramtAdvDesc.pattern_id)
    {
    default: 
      return null;
    case 1012: 
      return new akke(paramtAdvDesc);
    case 1108: 
      return new blbn(paramtAdvDesc);
    }
    return new blbp(paramtAdvDesc);
  }
  
  public static akke a(TianShuAccess.AdItem paramAdItem, String paramString)
  {
    if (paramAdItem == null) {
      return null;
    }
    if ("2".equals(paramString)) {
      return new blbn(paramAdItem);
    }
    if ("1".equals(paramString)) {
      return new blbp(paramAdItem);
    }
    return new akke(paramAdItem);
  }
  
  public akki a()
  {
    if ((this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc == null) || (TextUtils.isEmpty(this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data))) {
      return null;
    }
    switch (this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.pattern_id)
    {
    default: 
      return null;
    case 1012: 
      return new akki();
    case 1108: 
      return new blbo();
    }
    return new blbs();
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
      this.jdField_d_of_type_Int = k;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_traceinfo;
      this.jdField_c_of_type_Int = this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.task_id;
      localObject = new akkf();
      ((akkf)localObject).jdField_a_of_type_JavaLangString = str2;
      ((akkf)localObject).jdField_b_of_type_JavaLangString = str3;
      ((akkf)localObject).jdField_c_of_type_JavaLangString = akkg.a().a(str2);
      this.jdField_d_of_type_JavaLangString = ((akkf)localObject).jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1, localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
      QbossReportManager.getInstance().sendErrorReport(2741, this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.task_id, 102, "json parseError exception = " + localException.getMessage() + " json string = " + str1);
    }
  }
  
  public void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ((paramSharedPreferences == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Int = paramSharedPreferences.getInt("splash_union_banner_type_res_type" + paramString, 0);
      this.jdField_a_of_type_JavaLangString = paramSharedPreferences.getString("splash_union_banner_jump_url_" + paramString, "");
      this.jdField_b_of_type_Int = paramSharedPreferences.getInt("splash_union_banner_jump_type_" + paramString, -1);
      this.jdField_b_of_type_JavaLangString = paramSharedPreferences.getString("splash_union_banner_traceinfo_" + paramString, "");
      this.jdField_c_of_type_Int = paramSharedPreferences.getInt("splash_union_banner_adid_" + paramString, -1);
      this.jdField_d_of_type_JavaLangString = paramSharedPreferences.getString("splash_union_banner_res_path_" + paramString, "");
      this.jdField_c_of_type_JavaLangString = paramSharedPreferences.getString("splash_union_banner_type_" + paramString, "-1");
      paramSharedPreferences = new akkf();
      paramSharedPreferences.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1, paramSharedPreferences);
      return;
    }
    catch (Exception paramSharedPreferences)
    {
      paramSharedPreferences.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "buildUnionBannerFromSP error msg = " + paramSharedPreferences.getMessage());
    }
  }
  
  public void a(String paramString, SharedPreferences paramSharedPreferences)
  {
    if ((paramSharedPreferences == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramString = paramSharedPreferences.edit();
    paramString.putInt("splash_union_banner_type_res_type" + this.jdField_c_of_type_Int, this.jdField_a_of_type_Int);
    paramString.putString("splash_union_banner_jump_url_" + this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
    paramString.putInt("splash_union_banner_jump_type_" + this.jdField_c_of_type_Int, this.jdField_b_of_type_Int);
    paramString.putString("splash_union_banner_traceinfo_" + this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString);
    paramString.putInt("splash_union_banner_adid_" + this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
    paramString.putString("splash_union_banner_type_" + this.jdField_c_of_type_Int, this.jdField_c_of_type_JavaLangString);
    paramString.putString("splash_union_banner_res_path_" + this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString);
    paramString.apply();
  }
  
  boolean a()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  public akki b()
  {
    if (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem == null) {
      return null;
    }
    if ("2".equals(this.jdField_c_of_type_JavaLangString)) {
      return new blbo();
    }
    if ("1".equals(this.jdField_c_of_type_JavaLangString)) {
      return new blbs();
    }
    return new akki();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem == null)
    {
      QLog.e("QbossADBannerConfigInfo", 1, "fillDataFromUnionSplashItem error with mSplashItem = null");
      return;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.argList.get().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
      ((HashMap)localObject1).put(((TianShuAccess.MapEntry)localObject3).key.get(), ((TianShuAccess.MapEntry)localObject3).value.get());
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)((HashMap)localObject1).get("res_type"))) {
        this.jdField_a_of_type_Int = Integer.parseInt((String)((HashMap)localObject1).get("res_type"));
      }
      if (!TextUtils.isEmpty((CharSequence)((HashMap)localObject1).get("jump_type"))) {
        this.jdField_b_of_type_Int = Integer.parseInt((String)((HashMap)localObject1).get("jump_type"));
      }
      this.jdField_a_of_type_JavaLangString = ((String)((HashMap)localObject1).get("jump_url"));
      this.jdField_d_of_type_Int = 1;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.traceinfo.get();
      this.jdField_c_of_type_Int = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get();
      localObject2 = (String)((HashMap)localObject1).get("res_url");
      localObject3 = (String)((HashMap)localObject1).get("res_url_md5");
      this.jdField_c_of_type_JavaLangString = ((String)((HashMap)localObject1).get("bannertype"));
      localObject1 = new akkf();
      ((akkf)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
      ((akkf)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject3);
      ((akkf)localObject1).jdField_c_of_type_JavaLangString = akkg.a().a((String)localObject2);
      this.jdField_d_of_type_JavaLangString = ((akkf)localObject1).jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1, localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "fillDataFromUnionSplashItem error msg = " + localException.getMessage());
    }
  }
  
  public boolean b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      akkf localakkf = (akkf)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localakkf == null) || (TextUtils.isEmpty(localakkf.jdField_c_of_type_JavaLangString)) || (!localakkf.a())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akke
 * JD-Core Version:    0.7.0.1
 */