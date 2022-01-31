import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class aknr
  implements akuc
{
  aknr(aknp paramaknp, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    akuc localakuc = aknp.a(this.jdField_a_of_type_Aknp, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localakuc != null) {
      localakuc.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    akuc localakuc = aknp.a(this.jdField_a_of_type_Aknp, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localakuc != null) {
      localakuc.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, akud paramakud)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramakud.c + ", url = " + paramakud.a);
    if (paramBoolean) {
      if (!aknp.a(this.jdField_a_of_type_Aknp, paramakud.c, paramakud.b))
      {
        aknp.a(this.jdField_a_of_type_Aknp, paramakud.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    akuc localakuc;
    do
    {
      return;
      if (this.jdField_a_of_type_Aknp.a(paramakud.d, paramakud.c, paramakud.b) == 0) {}
      localakuc = aknp.a(this.jdField_a_of_type_Aknp, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localakuc == null);
    localakuc.a(paramBoolean, paramakud);
  }
  
  public void b()
  {
    akuc localakuc = aknp.a(this.jdField_a_of_type_Aknp, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localakuc != null) {
      localakuc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aknr
 * JD-Core Version:    0.7.0.1
 */