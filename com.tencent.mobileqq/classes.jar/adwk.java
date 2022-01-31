import android.app.Activity;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class adwk
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public adwk(MediaApiPlugin paramMediaApiPlugin, String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
  }
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = MediaApiPlugin.a(this.b, this.jdField_a_of_type_Int);
      if (isInterrupted()) {
        throw new InterruptedException();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      System.gc();
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "3", "[]" });
      return;
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", localOutOfMemoryError.toString() });
      return;
    }
    catch (IOException localIOException)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "[]" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwk
 * JD-Core Version:    0.7.0.1
 */