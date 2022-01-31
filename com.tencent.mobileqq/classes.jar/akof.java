import android.os.Bundle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class akof
  extends bead
{
  akof(aknx paramaknx) {}
  
  public void onDone(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + parambeae.f + ", status: " + parambeae.a());
    }
  }
  
  public void onDoneFile(beae parambeae)
  {
    if (parambeae == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = parambeae.a();
    } while (localBundle == null);
    int i = localBundle.getInt(parambeae.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + parambeae.f + ", status: " + parambeae.a() + ",task.currUrl:" + parambeae.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(parambeae);
      if (parambeae.a() != 3) {
        this.a.jdField_a_of_type_Alkm.a(Boolean.valueOf(false));
      }
      this.a.b();
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception parambeae)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", parambeae);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akof
 * JD-Core Version:    0.7.0.1
 */