import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class alcc
  implements alin
{
  alcc(alca paramalca, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    alin localalin = alca.a(this.jdField_a_of_type_Alca, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localalin != null) {
      localalin.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    alin localalin = alca.a(this.jdField_a_of_type_Alca, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localalin != null) {
      localalin.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, alio paramalio)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramalio.c + ", url = " + paramalio.a);
    if (paramBoolean) {
      if (!alca.a(this.jdField_a_of_type_Alca, paramalio.c, paramalio.b))
      {
        alca.a(this.jdField_a_of_type_Alca, paramalio.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    alin localalin;
    do
    {
      return;
      if (this.jdField_a_of_type_Alca.a(paramalio.d, paramalio.c, paramalio.b) == 0) {}
      localalin = alca.a(this.jdField_a_of_type_Alca, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localalin == null);
    localalin.a(paramBoolean, paramalio);
  }
  
  public void b()
  {
    alin localalin = alca.a(this.jdField_a_of_type_Alca, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localalin != null) {
      localalin.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alcc
 * JD-Core Version:    0.7.0.1
 */