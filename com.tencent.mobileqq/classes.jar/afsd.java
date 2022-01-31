import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class afsd
  extends aoeu
{
  afsd(afsa paramafsa) {}
  
  protected void c(boolean paramBoolean)
  {
    afrw localafrw = this.a.a(2);
    localafrw.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localafrw.c) && (paramBoolean)) {
      afsa.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localafrw.jdField_a_of_type_Int), Boolean.valueOf(localafrw.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsd
 * JD-Core Version:    0.7.0.1
 */