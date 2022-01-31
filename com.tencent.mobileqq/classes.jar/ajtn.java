import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ajtn
  implements mgp
{
  private final azrn jdField_a_of_type_Azrn;
  private final WeakReference<ajtg> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  ajtn(ajtg paramajtg, azrn paramazrn, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajtg);
    this.jdField_a_of_type_Azrn = paramazrn;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, mgr parammgr, int paramInt2)
  {
    parammgr = (ajtg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parammgr != null) && (parammgr.app != null))
    {
      if (paramInt1 == 0) {
        parammgr.app.a().a(1, this.jdField_a_of_type_Azrn.a, this.jdField_a_of_type_Azrn.b, this.jdField_a_of_type_ArrayOfLong, 2);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + parammgr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajtn
 * JD-Core Version:    0.7.0.1
 */