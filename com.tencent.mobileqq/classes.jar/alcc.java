import com.tencent.qphone.base.util.QLog;

class alcc
  implements alio
{
  alcc(alcb paramalcb, String paramString, alio paramalio) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Alio != null) {
      this.jdField_a_of_type_Alio.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Alio != null) {
      this.jdField_a_of_type_Alio.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, alip paramalip)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramalip.d + ", filename = " + paramalip.c + ", url = " + paramalip.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!alcb.a(this.jdField_a_of_type_Alcb, paramalip.c, paramalip.b))
      {
        alcb.a(this.jdField_a_of_type_Alcb, paramalip.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_Alio == null)
    {
      return;
      if ((!paramalip.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Alcb.a(paramalip.d, paramalip.c, paramalip.b) != 0)) {}
    }
    this.jdField_a_of_type_Alio.a(paramBoolean, paramalip);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alio != null) {
      this.jdField_a_of_type_Alio.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alcc
 * JD-Core Version:    0.7.0.1
 */