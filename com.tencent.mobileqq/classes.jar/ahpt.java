import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class ahpt
  extends apxc
{
  ahpt(ahpq paramahpq) {}
  
  protected void c(boolean paramBoolean)
  {
    ahpl localahpl = this.a.a(2);
    localahpl.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localahpl.c) && (paramBoolean)) {
      ahpq.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localahpl.jdField_a_of_type_Int), Boolean.valueOf(localahpl.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpt
 * JD-Core Version:    0.7.0.1
 */