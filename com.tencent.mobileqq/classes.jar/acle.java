import com.tencent.gdtad.web.GdtLandingPageReport.2;
import com.tencent.smtt.sdk.ValueCallback;

public class acle
  implements ValueCallback<String>
{
  public acle(GdtLandingPageReport.2 param2) {}
  
  public void a(String paramString)
  {
    acho.a("GdtLandingPageReport", " injectScript scene: " + this.a.jdField_a_of_type_Int + " 回调耗时: " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long) + " 回调. resp: " + paramString);
    if (this.a.jdField_a_of_type_Acli != null) {
      this.a.jdField_a_of_type_Acli.a(paramString);
    }
    if (paramString.equals("true"))
    {
      this.a.this$0.a(1501001);
      return;
    }
    this.a.this$0.a(1501002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acle
 * JD-Core Version:    0.7.0.1
 */