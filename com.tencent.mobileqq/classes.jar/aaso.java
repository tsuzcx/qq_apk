import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import java.lang.ref.WeakReference;

class aaso
  implements Runnable
{
  aaso(aasn paramaasn, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aasn.a.jdField_a_of_type_Aass.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "downloadDictFile, weakPreDownloadCtrl is null, return");
      return;
    }
    PreDownloadController localPreDownloadController = (PreDownloadController)this.jdField_a_of_type_Aasn.a.jdField_a_of_type_Aass.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localPreDownloadController == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "downloadDictFile, preDownloadController is null, return");
      return;
    }
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    long l;
    if (this.jdField_a_of_type_Aasn.a.jdField_a_of_type_Aass.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Boolean)
      {
        String str = this.jdField_a_of_type_Aasn.a.jdField_a_of_type_JavaLangString;
        if (arrayOfByte == null)
        {
          l = 0L;
          localPreDownloadController.a(str, l);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aasn.a.jdField_a_of_type_Aasq.a(arrayOfByte);
      return;
      l = arrayOfByte.length;
      break;
      localPreDownloadController.a(this.jdField_a_of_type_Aasn.a.jdField_a_of_type_JavaLangString, -1L);
      arrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaso
 * JD-Core Version:    0.7.0.1
 */