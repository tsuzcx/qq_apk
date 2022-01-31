import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class alzm
  implements muf
{
  private final bcrz jdField_a_of_type_Bcrz;
  private final WeakReference<alzf> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  alzm(alzf paramalzf, bcrz parambcrz, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramalzf);
    this.jdField_a_of_type_Bcrz = parambcrz;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, muh parammuh, int paramInt2)
  {
    parammuh = (alzf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parammuh != null) && (parammuh.app != null))
    {
      if (paramInt1 == 0) {
        parammuh.app.a().a(1, this.jdField_a_of_type_Bcrz.a, this.jdField_a_of_type_Bcrz.b, this.jdField_a_of_type_ArrayOfLong, 2, 0, 0, -1);
      }
      return;
    }
    QLog.e("TroopHandler", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference " + parammuh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzm
 * JD-Core Version:    0.7.0.1
 */