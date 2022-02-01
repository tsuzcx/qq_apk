import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class ajlg
  extends asgf
{
  ajlg(ajld paramajld) {}
  
  protected void b(boolean paramBoolean)
  {
    ajky localajky = this.a.a(2);
    localajky.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localajky.c) && (paramBoolean)) {
      ajld.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localajky.jdField_a_of_type_Int), Boolean.valueOf(localajky.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlg
 * JD-Core Version:    0.7.0.1
 */