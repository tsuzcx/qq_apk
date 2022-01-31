import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import java.lang.ref.WeakReference;

class accn
  implements Runnable
{
  accn(accm paramaccm, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_Accm.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    ((TroopHandler)localQQAppInterface.a(20)).a(Long.parseLong(this.jdField_a_of_type_Accm.jdField_a_of_type_JavaLangString), Long.parseLong(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accn
 * JD-Core Version:    0.7.0.1
 */