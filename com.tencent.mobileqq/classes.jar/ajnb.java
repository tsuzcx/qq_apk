import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class ajnb
  extends aslz
{
  ajnb(ajmy paramajmy) {}
  
  protected void a(boolean paramBoolean)
  {
    ajmt localajmt = this.a.a(2);
    localajmt.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localajmt.c) && (paramBoolean)) {
      ajmy.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localajmt.jdField_a_of_type_Int), Boolean.valueOf(localajmt.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnb
 * JD-Core Version:    0.7.0.1
 */