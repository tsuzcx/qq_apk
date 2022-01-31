import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;

class aamb
  implements EIPCResultCallback
{
  aamb(aama paramaama, WeakReference paramWeakReference, aamh paramaamh) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    aami localaami = new aami();
    boolean bool;
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      bool = true;
      localaami.jdField_a_of_type_Boolean = bool;
      if (paramEIPCResult == null) {
        break label83;
      }
    }
    label83:
    for (paramEIPCResult = paramEIPCResult.data;; paramEIPCResult = null)
    {
      localaami.jdField_a_of_type_AndroidOsBundle = paramEIPCResult;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((aamd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Aamh, localaami);
      }
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamb
 * JD-Core Version:    0.7.0.1
 */