import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class adcf
  implements adaa
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<CustomWebView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public adcf(CustomWebView paramCustomWebView, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCustomWebView);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("__nativeAPICallID__");
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.jdField_a_of_type_JavaLangString + "', 4]);");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.jdField_a_of_type_JavaLangString + "', 1, " + paramInt + "]);");
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.jdField_a_of_type_JavaLangString + "', 3, " + paramInt + ", '" + paramString + "']);");
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.jdField_a_of_type_JavaLangString + "', 2, " + paramJSONObject.toString() + "]);");
      }
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      CustomWebView localCustomWebView = (CustomWebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localCustomWebView != null) {
        localCustomWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.jdField_a_of_type_JavaLangString + "', 5, " + paramJSONObject.toString() + "]);");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcf
 * JD-Core Version:    0.7.0.1
 */