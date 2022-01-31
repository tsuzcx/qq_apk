import com.tencent.qphone.base.util.QLog;

class aljg
  extends bdvu
{
  aljg(aljf paramaljf, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (3 == parambdvv.a()) {
      this.jdField_a_of_type_Aljf.a(true, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleFrameZipDecoder", 2, "downloadZip onDone task.getStatus()->" + parambdvv.a());
      }
      return;
      this.jdField_a_of_type_Aljf.a = 2;
      this.jdField_a_of_type_Aljf.a(false, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljg
 * JD-Core Version:    0.7.0.1
 */