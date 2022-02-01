import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class ajwp
  extends asvt
{
  ajwp(ajwm paramajwm) {}
  
  protected void b(boolean paramBoolean)
  {
    ajwh localajwh = this.a.a(2);
    localajwh.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localajwh.c) && (paramBoolean)) {
      ajwm.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localajwh.jdField_a_of_type_Int), Boolean.valueOf(localajwh.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwp
 * JD-Core Version:    0.7.0.1
 */