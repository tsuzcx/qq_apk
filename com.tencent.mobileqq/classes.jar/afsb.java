import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class afsb
  extends aoez
{
  afsb(afry paramafry) {}
  
  protected void c(boolean paramBoolean)
  {
    afru localafru = this.a.a(2);
    localafru.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localafru.c) && (paramBoolean)) {
      afry.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localafru.jdField_a_of_type_Int), Boolean.valueOf(localafru.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsb
 * JD-Core Version:    0.7.0.1
 */