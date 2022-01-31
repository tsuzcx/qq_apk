import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;

public class akqi
  implements Runnable
{
  public akqi(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler) {}
  
  public void run()
  {
    this.a.a(MsfSdkUtils.insertMtype("Web", this.a.jdField_a_of_type_JavaLangString), 0);
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      this.a.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akqi
 * JD-Core Version:    0.7.0.1
 */