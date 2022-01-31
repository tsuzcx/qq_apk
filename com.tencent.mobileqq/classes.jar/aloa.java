import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.4;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.5;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.6;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.9;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class aloa
  extends alpc
{
  private alol jdField_a_of_type_Alol;
  private alom jdField_a_of_type_Alom;
  private alon jdField_a_of_type_Alon;
  private bich jdField_a_of_type_Bich;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private boolean b;
  private boolean c;
  
  aloa(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    bicp.a().c();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Bich = new aloj(this);
    bicp.a().a(this.jdField_a_of_type_Bich);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new alok(this);
    paramApplication = BaseActivity.sTopActivity;
    if (paramApplication != null) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramApplication, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
  }
  
  private String a(int paramInt)
  {
    String str = "";
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {}
    switch (paramInt)
    {
    case 2: 
    default: 
      str = localBaseActivity.getString(2131690226);
      return str;
    case 1: 
      return localBaseActivity.getString(2131690224);
    }
    return localBaseActivity.getString(2131690225);
  }
  
  private JSONArray a(ArrayList<WadlResult> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (WadlResult)paramArrayList.next();
      if (localObject != null)
      {
        localObject = a((WadlResult)localObject, paramString);
        if (localObject != null) {
          localJSONArray.put(localObject);
        }
      }
    }
    return localJSONArray;
  }
  
  private JSONObject a(WadlParams paramWadlParams, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramWadlParams != null)
      {
        localJSONObject.put("actionCode", paramWadlParams.jdField_b_of_type_Int);
        localJSONObject.put("appId", paramWadlParams.jdField_a_of_type_JavaLangString);
        localJSONObject.put("apkUrl", paramWadlParams.jdField_b_of_type_JavaLangString);
        localJSONObject.put("apkSign", paramWadlParams.jdField_c_of_type_JavaLangString);
        localJSONObject.put("versionCode", paramWadlParams.f);
        localJSONObject.put("packageName", paramWadlParams.j);
        localJSONObject.put("appName", paramWadlParams.k);
        if (!paramWadlParams.jdField_a_of_type_Boolean) {
          break label238;
        }
      }
      label238:
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("delayDownload", i);
        localJSONObject.put("fromWebUrl", paramWadlParams.n);
        localJSONObject.put("apkChannel", paramWadlParams.jdField_d_of_type_JavaLangString);
        localJSONObject.put("via", paramWadlParams.m);
        localJSONObject.put("yyStartTime", paramWadlParams.jdField_a_of_type_Long);
        localJSONObject.put("yyEndTime", paramWadlParams.jdField_b_of_type_Long);
        localJSONObject.put("adtag", paramWadlParams.o);
        localJSONObject.put("from", paramWadlParams.jdField_d_of_type_Int);
        localJSONObject.put("flags", paramWadlParams.jdField_c_of_type_Int);
        localJSONObject.put("extraData", paramWadlParams.p);
        localJSONObject.put("sourceId", paramWadlParams.q);
        return localJSONObject;
      }
      return null;
    }
    catch (Exception paramWadlParams)
    {
      QLog.i("ark.download.module", 1, paramString + " parseWadlParams error::", paramWadlParams);
    }
  }
  
  private JSONObject a(WadlResult paramWadlResult, String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      if (paramWadlResult == null)
      {
        localJSONObject1.put("taskStatus", -1);
        localJSONObject1.put("progress", 0);
        return localJSONObject1;
      }
      if (paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams != null)
      {
        JSONObject localJSONObject2 = a(paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams, paramString);
        if (localJSONObject2 != null) {
          localJSONObject1.put("wadlParams", localJSONObject2.toString());
        }
      }
      localJSONObject1.put("event", paramWadlResult.jdField_a_of_type_Int);
      localJSONObject1.put("taskId", paramWadlResult.jdField_a_of_type_JavaLangString);
      localJSONObject1.put("taskStatus", paramWadlResult.jdField_b_of_type_Int);
      localJSONObject1.put("fileSize", paramWadlResult.jdField_a_of_type_Long);
      localJSONObject1.put("downloadFileSize", paramWadlResult.jdField_b_of_type_Long);
      localJSONObject1.put("downloadFilePath", paramWadlResult.jdField_b_of_type_JavaLangString);
      localJSONObject1.put("createTime", paramWadlResult.jdField_c_of_type_Long);
      localJSONObject1.put("errCode", bdpe.b(paramWadlResult.jdField_c_of_type_Int));
      localJSONObject1.put("progress", paramWadlResult.jdField_d_of_type_Int);
      return localJSONObject1;
    }
    catch (Exception paramWadlResult)
    {
      QLog.i("ark.download.module", 1, paramString + " parseWadlResult error::", paramWadlResult);
    }
    return null;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.9(this, paramString));
      return true;
    }
    catch (Exception paramString)
    {
      QLog.i("ark.download.module", 1, " showToast error::", paramString);
    }
    return false;
  }
  
  public void Destruct()
  {
    super.Destruct();
    bicp.a().b(this.jdField_a_of_type_Bich);
    this.jdField_a_of_type_Bich = null;
    this.jdField_a_of_type_Alom = null;
    this.jdField_a_of_type_Alon = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a(((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue());
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public String GetTypeName()
  {
    return "QQDownload";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("QueryPackageState")) {}
    while ((paramString.equals("QueryPackageStateVia")) || (paramString.equals("StartDownload")) || (paramString.equals("PauseDownload")) || (paramString.equals("ContinueDownload")) || (paramString.equals("InstallPackage")) || (paramString.equals("DownloadInit"))) {
      return true;
    }
    return paramString.equals("DeletePackage");
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!aloy.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.DOWNLOAD"))
    {
      QLog.i("ark.download.module", 1, "ArkAppDownloadModule.invokeFunc permission denied");
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        b(paramString.getString(2131690231));
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ark.download.module", 2, String.format("ArkAppDownloadModule.invokeFunc.%s", new Object[] { paramString }));
    }
    long l;
    if (paramString.equals("QueryPackageState"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        l = a(paramArrayOfVariantWrapper[1].Copy());
        paramArrayOfVariantWrapper = new ArrayList();
        paramArrayOfVariantWrapper.add(paramString);
        this.jdField_a_of_type_Alom = new alob(this, l);
        if (paramArrayOfVariantWrapper.size() > 0) {
          bicp.a().a(paramArrayOfVariantWrapper);
        }
        return true;
      }
      return false;
    }
    if (paramString.equals("QueryPackageStateVia"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        this.jdField_a_of_type_Alon = new aloc(this, a(paramArrayOfVariantWrapper[1].Copy()));
        if (!TextUtils.isEmpty(paramString)) {
          bicp.a().a(paramString);
        }
        return true;
      }
      return false;
    }
    if (paramString.equals("DownloadInit"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        l = a(paramArrayOfVariantWrapper[0].Copy());
        this.jdField_a_of_type_Alol = new alod(this);
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    Object localObject;
    boolean bool;
    String str1;
    String str2;
    String str3;
    if (paramString.equals("StartDownload"))
    {
      if (this.jdField_a_of_type_Alol == null)
      {
        QLog.e("ark.download.module", 2, "should DownloadInit first ");
        paramVariantWrapper.SetInt(-1);
        return true;
      }
      paramString = BaseActivity.sTopActivity;
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        localObject = paramArrayOfVariantWrapper[0].GetString();
        double d = paramArrayOfVariantWrapper[1].GetDouble();
        paramArrayOfVariantWrapper = new WadlParams((String)localObject);
        if (paramArrayOfVariantWrapper.jdField_b_of_type_Int == 12) {
          axqy.a(null, "dc00898", "", "", "0X8009E12", "0X8009E12", 0, 0, "", "", paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, "");
        }
        while (paramString != null)
        {
          bool = true;
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
          str1 = "key_download_show_not_wifi_dialog" + paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString;
          if (localObject != null) {
            bool = ((SharedPreferences)localObject).getBoolean(str1, true);
          }
          if (d > bicq.a())
          {
            ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.4(this, paramString, paramArrayOfVariantWrapper));
            paramVariantWrapper.SetInt(2);
            return true;
            if (paramArrayOfVariantWrapper.jdField_b_of_type_Int == 2) {
              axqy.a(null, "dc00898", "", "", "0X8009E11", "0X8009E11", 0, 0, "", "", paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, "");
            }
          }
          else if ((bool) && (bbfj.g(paramString)) && (bbfj.b(paramString) != 1))
          {
            str2 = String.format(paramString.getString(2131690229), new Object[] { bbdw.a(d) });
            str3 = paramString.getString(2131690228);
            ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.5(this, paramString, str2, paramArrayOfVariantWrapper, (SharedPreferences)localObject, str1, str3));
            paramVariantWrapper.SetInt(2);
            return true;
          }
        }
        bicp.a().a(paramArrayOfVariantWrapper);
        this.c = true;
        paramVariantWrapper.SetInt(1);
        return true;
      }
      paramVariantWrapper.SetInt(-2);
      return true;
    }
    int i;
    if (paramString.equals("PauseDownload"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
      {
        i = paramArrayOfVariantWrapper[0].GetInt();
        paramString = paramArrayOfVariantWrapper[1].GetString();
        bicp.a().a(i, paramString);
        paramVariantWrapper.SetBool(true);
        axqy.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "1", "", paramString, "");
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (paramString.equals("ContinueDownload"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
      {
        i = paramArrayOfVariantWrapper[0].GetInt();
        paramString = paramArrayOfVariantWrapper[1].GetString();
        paramArrayOfVariantWrapper = BaseActivity.sTopActivity;
        bool = true;
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
        str1 = "key_download_show_not_wifi_dialog" + paramString;
        if (localObject != null) {
          bool = ((SharedPreferences)localObject).getBoolean(str1, true);
        }
        if ((bool) && (paramArrayOfVariantWrapper != null) && (bbfj.g(paramArrayOfVariantWrapper)) && (bbfj.b(paramArrayOfVariantWrapper) != 1))
        {
          str2 = paramArrayOfVariantWrapper.getString(2131690222);
          str3 = paramArrayOfVariantWrapper.getString(2131690228);
          ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.6(this, paramArrayOfVariantWrapper, str2, i, paramString, (SharedPreferences)localObject, str1, str3));
          paramVariantWrapper.SetBool(true);
          return true;
        }
        bicp.a().b(i, paramString);
        this.c = true;
        axqy.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "2", "", paramString, "");
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (paramString.equals("InstallPackage"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = new WadlParams(paramArrayOfVariantWrapper[0].GetString());
        bicp.a().b(paramString);
        axqy.a(null, "dc00898", "", "", "0X8009E16", "0X8009E16", 0, 0, "", "", paramString.jdField_a_of_type_JavaLangString, "");
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (paramString.equals("DeletePackage"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
      {
        i = paramArrayOfVariantWrapper[0].GetInt();
        paramString = paramArrayOfVariantWrapper[1].GetString();
        bicp.a().c(i, paramString);
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aloa
 * JD-Core Version:    0.7.0.1
 */