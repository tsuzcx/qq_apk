import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajdl
  implements View.OnClickListener
{
  private ajdj jdField_a_of_type_Ajdj;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  ajdl(ajdj paramajdj, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Ajdj = paramajdj;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_Ajdj.jdField_a_of_type_JavaLangString + " on enter");
    }
    this.jdField_a_of_type_Ajdj.jdField_a_of_type_Ajdh.onEnter();
    azmj.a(null, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdl
 * JD-Core Version:    0.7.0.1
 */