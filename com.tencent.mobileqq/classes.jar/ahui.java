import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class ahui
  extends aqbl
{
  ahui(ahuf paramahuf) {}
  
  protected void c(boolean paramBoolean)
  {
    ahua localahua = this.a.a(2);
    localahua.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localahua.c) && (paramBoolean)) {
      ahuf.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localahua.jdField_a_of_type_Int), Boolean.valueOf(localahua.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahui
 * JD-Core Version:    0.7.0.1
 */