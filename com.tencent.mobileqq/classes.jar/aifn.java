import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aifn
  extends batl
{
  aifn(aifg paramaifg) {}
  
  public void onDone(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + parambatm.f + ", status: " + parambatm.a());
    }
  }
  
  public void onDoneFile(batm parambatm)
  {
    if (parambatm == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = parambatm.a();
    } while (localBundle == null);
    int i = localBundle.getInt(parambatm.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + parambatm.f + ", status: " + parambatm.a() + ",task.currUrl:" + parambatm.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(parambatm);
      if (parambatm.a() != 3) {
        this.a.jdField_a_of_type_Ajak.a(Boolean.valueOf(false));
      }
      this.a.b();
      bajr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception parambatm)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", parambatm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aifn
 * JD-Core Version:    0.7.0.1
 */