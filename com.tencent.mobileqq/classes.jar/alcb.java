import com.tencent.qphone.base.util.QLog;

class alcb
  implements alin
{
  alcb(alca paramalca, String paramString, alin paramalin) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Alin != null) {
      this.jdField_a_of_type_Alin.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Alin != null) {
      this.jdField_a_of_type_Alin.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, alio paramalio)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramalio.d + ", filename = " + paramalio.c + ", url = " + paramalio.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!alca.a(this.jdField_a_of_type_Alca, paramalio.c, paramalio.b))
      {
        alca.a(this.jdField_a_of_type_Alca, paramalio.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_Alin == null)
    {
      return;
      if ((!paramalio.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Alca.a(paramalio.d, paramalio.c, paramalio.b) != 0)) {}
    }
    this.jdField_a_of_type_Alin.a(paramBoolean, paramalio);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alin != null) {
      this.jdField_a_of_type_Alin.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alcb
 * JD-Core Version:    0.7.0.1
 */