import com.tencent.qphone.base.util.QLog;

class aknq
  implements akuc
{
  aknq(aknp paramaknp, String paramString, akuc paramakuc) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Akuc != null) {
      this.jdField_a_of_type_Akuc.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Akuc != null) {
      this.jdField_a_of_type_Akuc.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, akud paramakud)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramakud.d + ", filename = " + paramakud.c + ", url = " + paramakud.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!aknp.a(this.jdField_a_of_type_Aknp, paramakud.c, paramakud.b))
      {
        aknp.a(this.jdField_a_of_type_Aknp, paramakud.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_Akuc == null)
    {
      return;
      if ((!paramakud.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Aknp.a(paramakud.d, paramakud.c, paramakud.b) != 0)) {}
    }
    this.jdField_a_of_type_Akuc.a(paramBoolean, paramakud);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Akuc != null) {
      this.jdField_a_of_type_Akuc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aknq
 * JD-Core Version:    0.7.0.1
 */