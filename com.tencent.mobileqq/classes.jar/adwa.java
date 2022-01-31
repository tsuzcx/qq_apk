import android.app.Activity;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.jsp.DataApiPlugin;

class adwa
  implements Runnable
{
  adwa(advz paramadvz, Activity paramActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_Advz.a.callJs(this.jdField_a_of_type_Advz.c, new String[] { "null", Integer.toString(this.jdField_a_of_type_Int) });
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Advz.a.callJs(this.jdField_a_of_type_Advz.c, new String[] { Util.a(this.jdField_a_of_type_JavaLangString), Integer.toString(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwa
 * JD-Core Version:    0.7.0.1
 */