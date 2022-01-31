import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;

class aaqq
  implements EIPCResultCallback
{
  aaqq(aaqp paramaaqp, WeakReference paramWeakReference, aaqw paramaaqw) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    aaqx localaaqx = new aaqx();
    boolean bool;
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      bool = true;
      localaaqx.jdField_a_of_type_Boolean = bool;
      if (paramEIPCResult == null) {
        break label83;
      }
    }
    label83:
    for (paramEIPCResult = paramEIPCResult.data;; paramEIPCResult = null)
    {
      localaaqx.jdField_a_of_type_AndroidOsBundle = paramEIPCResult;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((aaqs)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Aaqw, localaaqx);
      }
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqq
 * JD-Core Version:    0.7.0.1
 */