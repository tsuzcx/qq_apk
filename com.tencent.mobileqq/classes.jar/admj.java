import android.app.Activity;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;

public class admj
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public admj(MediaApiPlugin paramMediaApiPlugin, String paramString, int paramInt, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public void run()
  {
    int i = 0;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      if (i < j) {
        if (isInterrupted()) {
          throw new InterruptedException();
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        System.gc();
        this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "3", "[]" });
        return;
        localOutOfMemoryError.put(MediaApiPlugin.a(this.jdField_a_of_type_ArrayOfJavaLangString[i], this.jdField_a_of_type_Int));
        i += 1;
      }
      if (isInterrupted()) {
        throw new InterruptedException();
      }
    }
    catch (IOException localIOException)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "[]" });
      return;
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", localIOException.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "[]" });
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.mRuntime.a();
      if ((localActivity != null) && (!localActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "1", "[]" });
      }
      return;
    }
    finally
    {
      if (this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.a.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     admj
 * JD-Core Version:    0.7.0.1
 */