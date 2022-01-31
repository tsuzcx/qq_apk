import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class akhw
  implements mrl
{
  private final batf jdField_a_of_type_Batf;
  private final WeakReference<akhp> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  akhw(akhp paramakhp, batf parambatf, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramakhp);
    this.jdField_a_of_type_Batf = parambatf;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, mrn parammrn, int paramInt2)
  {
    parammrn = (akhp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parammrn != null) && (parammrn.app != null))
    {
      if (paramInt1 == 0) {
        parammrn.app.a().a(1, this.jdField_a_of_type_Batf.a, this.jdField_a_of_type_Batf.b, this.jdField_a_of_type_ArrayOfLong, 2, 0, 0);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + parammrn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akhw
 * JD-Core Version:    0.7.0.1
 */