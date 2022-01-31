import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class acgw
  implements Runnable
{
  public acgw(PokeResHandler paramPokeResHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      String str = this.jdField_a_of_type_JavaLangString + "/poke";
      FileUtils.a(str, false);
      FileUtils.a(this.b, str, false);
      PokeItemHelper.b(this.jdField_a_of_type_JavaLangString + "/poke/");
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PokeResHandler_1228", 2, localIOException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acgw
 * JD-Core Version:    0.7.0.1
 */