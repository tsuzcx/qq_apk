import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class ahqu
  implements Runnable
{
  ahqu(ahqt paramahqt, String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_JavaLangString + "泄漏，正在生成dump文件", 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahqu
 * JD-Core Version:    0.7.0.1
 */