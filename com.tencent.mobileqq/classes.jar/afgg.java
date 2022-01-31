import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class afgg
  extends anoj
{
  afgg(afgd paramafgd) {}
  
  protected void b(boolean paramBoolean)
  {
    affz localaffz = this.a.a(2);
    localaffz.jdField_a_of_type_JavaLangObject = Boolean.valueOf(paramBoolean);
    if ((localaffz.c) && (paramBoolean)) {
      afgd.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localaffz.jdField_a_of_type_Int), Boolean.valueOf(localaffz.c), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afgg
 * JD-Core Version:    0.7.0.1
 */