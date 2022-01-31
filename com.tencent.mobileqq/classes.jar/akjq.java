import android.os.Bundle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class akjq
  extends bdvu
{
  akjq(akji paramakji) {}
  
  public void onDone(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + parambdvv.f + ", status: " + parambdvv.a());
    }
  }
  
  public void onDoneFile(bdvv parambdvv)
  {
    if (parambdvv == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = parambdvv.a();
    } while (localBundle == null);
    int i = localBundle.getInt(parambdvv.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + parambdvv.f + ", status: " + parambdvv.a() + ",task.currUrl:" + parambdvv.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(parambdvv);
      if (parambdvv.a() != 3) {
        this.a.jdField_a_of_type_Alfx.a(Boolean.valueOf(false));
      }
      this.a.b();
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception parambdvv)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", parambdvv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjq
 * JD-Core Version:    0.7.0.1
 */