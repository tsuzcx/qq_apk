import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.HashMap;
import java.util.Map;

public class aklp
  implements Runnable
{
  public aklp(WebAccelerateHelper paramWebAccelerateHelper, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      localHashMap = new HashMap();
      localHashMap.put("User-Agent", SwiftWebViewUtils.a(SwiftWebViewUtils.b("x5prefetch_1.0"), "", false));
      WebAccelerator.prefetchResource(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, localHashMap, true);
      QLog.i("WebAccelerateHelper", 1, "now prefetchResource " + Util.c(this.jdField_a_of_type_JavaLangString, new String[0]));
    }
    while (!this.b)
    {
      HashMap localHashMap;
      return;
    }
    WebAccelerator.preConnect(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, 1, true);
    QLog.i("WebAccelerateHelper", 1, "now preconnect " + Util.c(this.jdField_a_of_type_JavaLangString, new String[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aklp
 * JD-Core Version:    0.7.0.1
 */