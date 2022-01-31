import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingCardRender;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aahg
  implements Runnable
{
  public aahg(GreetingCardRender paramGreetingCardRender, String paramString) {}
  
  public void run()
  {
    if (new File(this.jdField_a_of_type_JavaLangString).exists())
    {
      GreetingCardRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardRender).native_setARCardVideoCover(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.e("GreetingCardRender", 1, String.format("setARCardVideoCover file not exist! videoCoverPath=%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahg
 * JD-Core Version:    0.7.0.1
 */