import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class ajmh
  implements Runnable
{
  ajmh(ajmf paramajmf, Exception paramException) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ajmf.a.dismiss();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "safetyReport exception1" + this.jdField_a_of_type_JavaLangException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajmh
 * JD-Core Version:    0.7.0.1
 */