import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class airm
  extends arht
{
  airm(airj paramairj) {}
  
  protected void a(boolean paramBoolean)
  {
    aire localaire = this.a.a(2);
    localaire.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localaire.c) && (paramBoolean)) {
      airj.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localaire.jdField_a_of_type_Int), Boolean.valueOf(localaire.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airm
 * JD-Core Version:    0.7.0.1
 */