import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class aaep
  implements Runnable
{
  public aaep(boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_JavaLangString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaep
 * JD-Core Version:    0.7.0.1
 */