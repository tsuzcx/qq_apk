import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class alcd
  implements alio
{
  alcd(alcb paramalcb, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    alio localalio = alcb.a(this.jdField_a_of_type_Alcb, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localalio != null) {
      localalio.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    alio localalio = alcb.a(this.jdField_a_of_type_Alcb, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localalio != null) {
      localalio.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, alip paramalip)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramalip.c + ", url = " + paramalip.a);
    if (paramBoolean) {
      if (!alcb.a(this.jdField_a_of_type_Alcb, paramalip.c, paramalip.b))
      {
        alcb.a(this.jdField_a_of_type_Alcb, paramalip.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    alio localalio;
    do
    {
      return;
      if (this.jdField_a_of_type_Alcb.a(paramalip.d, paramalip.c, paramalip.b) == 0) {}
      localalio = alcb.a(this.jdField_a_of_type_Alcb, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localalio == null);
    localalio.a(paramBoolean, paramalip);
  }
  
  public void b()
  {
    alio localalio = alcb.a(this.jdField_a_of_type_Alcb, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localalio != null) {
      localalio.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alcd
 * JD-Core Version:    0.7.0.1
 */