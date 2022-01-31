import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class akhx
  implements mro
{
  private final basr jdField_a_of_type_Basr;
  private final WeakReference<akhq> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  akhx(akhq paramakhq, basr parambasr, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramakhq);
    this.jdField_a_of_type_Basr = parambasr;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, mrq parammrq, int paramInt2)
  {
    parammrq = (akhq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parammrq != null) && (parammrq.app != null))
    {
      if (paramInt1 == 0) {
        parammrq.app.a().a(1, this.jdField_a_of_type_Basr.a, this.jdField_a_of_type_Basr.b, this.jdField_a_of_type_ArrayOfLong, 2, 0, 0);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + parammrq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akhx
 * JD-Core Version:    0.7.0.1
 */