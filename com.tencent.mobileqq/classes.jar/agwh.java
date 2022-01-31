import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class agwh
{
  private static volatile agwh jdField_a_of_type_Agwh;
  private List<agwi> jdField_a_of_type_JavaUtilList;
  
  private agwh()
  {
    a(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() + "");
  }
  
  public static agwh a()
  {
    if (jdField_a_of_type_Agwh == null) {}
    try
    {
      if (jdField_a_of_type_Agwh == null) {
        jdField_a_of_type_Agwh = new agwh();
      }
      return jdField_a_of_type_Agwh;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getSharedPreferences("qwallet_intercept", 4);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((SharedPreferences)localObject3).getString("InterceptAppOpenConfig" + paramString, null);
      }
    }
    return localObject1;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        paramString2 = new X509EncodedKeySpec(Base64.decode(paramString2, 0));
        paramString2 = KeyFactory.getInstance("RSA").generatePublic(paramString2);
        paramString1 = Base64.decode(paramString1, 0);
        Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(2, paramString2);
        paramString1 = new String(localCipher.doFinal(paramString1));
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("qwallet_intercept", 4);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("InterceptAppOpenConfig" + paramString2, paramString1).commit();
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilList = agwi.a(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PayInterceptHelper", 2, "loadConfigFromSP|" + this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(JSONArray paramJSONArray, String paramString)
  {
    if (paramJSONArray != null) {
      a(paramJSONArray.toString(), paramString);
    }
    a(paramString);
  }
  
  public boolean a(String paramString, WebViewFragment paramWebViewFragment)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (TextUtils.isEmpty(paramString)) || (paramWebViewFragment == null)) {}
    CustomWebView localCustomWebView;
    agwi localagwi;
    do
    {
      do
      {
        while (!((Iterator)localObject1).hasNext())
        {
          do
          {
            do
            {
              return false;
              if (QLog.isColorLevel()) {
                QLog.d("PayInterceptHelper", 2, "handleIntercept:" + paramString);
              }
              localCustomWebView = paramWebViewFragment.getWebView();
            } while (localCustomWebView == null);
            localObject1 = localCustomWebView.copyBackForwardList();
          } while ((localObject1 == null) || (((WebBackForwardList)localObject1).getCurrentIndex() != ((WebBackForwardList)localObject1).getSize() - 1));
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        localagwi = (agwi)((Iterator)localObject1).next();
      } while (TextUtils.isEmpty(localagwi.jdField_b_of_type_JavaLangString));
      if (localagwi.jdField_a_of_type_JavaUtilRegexPattern == null) {
        localagwi.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(localagwi.jdField_b_of_type_JavaLangString);
      }
    } while (!localagwi.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString).matches());
    Object localObject1 = "";
    Object localObject2 = paramWebViewFragment.a;
    paramWebViewFragment = (WebViewFragment)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((bcfo)localObject2).jdField_a_of_type_JavaUtilList;
      paramWebViewFragment = (WebViewFragment)localObject1;
      if (localObject2 != null)
      {
        paramWebViewFragment = (WebViewFragment)localObject1;
        if (((List)localObject2).size() > 0) {
          paramWebViewFragment = (String)((List)localObject2).get(0);
        }
      }
    }
    boolean bool;
    if (TextUtils.isEmpty(localagwi.jdField_a_of_type_JavaLangString)) {
      bool = true;
    }
    while (bool)
    {
      if (localagwi.jdField_a_of_type_Boolean) {
        VACDReportUtil.a("originURL=" + paramWebViewFragment + "|interceptURL=" + paramString, "qqwallet", "InterceptOpenOtherApp", null, null, 0, null);
      }
      if (!localagwi.jdField_b_of_type_Boolean) {
        break;
      }
      if (!TextUtils.isEmpty(localagwi.c))
      {
        if (TextUtils.isEmpty(localagwi.d)) {
          localagwi.d = a(localagwi.c, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDsE3WI7sDFUi6QWV/oK8qozDvS\nTlxmu1a3NSFxeOrjlVEVtOx8yIMVFYIixq/Fv1XgUlyvL7bGJbaLLKaqlYruGd2z\nNbaIz90Zm4H0pMFHx4vCYhsRP1HXbVMo2ZDiHEDbnSm/99uzFPPiXqLi8jE9t4if\n0GuYdSZfe5o+SIKT5QIDAQAB");
        }
        paramWebViewFragment = localagwi.d;
        if (QLog.isColorLevel()) {
          QLog.d("PayInterceptHelper", 2, "jumpUrl:" + paramWebViewFragment);
        }
        if (TextUtils.isEmpty(paramWebViewFragment)) {
          break;
        }
        if (!paramWebViewFragment.contains("?")) {
          break label515;
        }
        paramWebViewFragment = paramWebViewFragment + "&j=";
      }
      try
      {
        for (;;)
        {
          paramString = paramWebViewFragment + URLEncoder.encode(paramString, "UTF-8");
          if (QLog.isColorLevel()) {
            QLog.d("PayInterceptHelper", 2, "jumpUrl with params:" + paramString);
          }
          localCustomWebView.loadUrl(paramString);
          return true;
          if (localagwi.jdField_b_of_type_JavaUtilRegexPattern == null) {
            localagwi.jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile(localagwi.jdField_a_of_type_JavaLangString);
          }
          bool = localagwi.jdField_b_of_type_JavaUtilRegexPattern.matcher(paramWebViewFragment).matches();
          break;
          label515:
          paramWebViewFragment = paramWebViewFragment + "?j=";
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = paramWebViewFragment;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agwh
 * JD-Core Version:    0.7.0.1
 */