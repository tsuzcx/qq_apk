import android.os.Bundle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class alnz
  extends bgod
{
  alnz(alnr paramalnr) {}
  
  public void onDone(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + parambgoe.f + ", status: " + parambgoe.a());
    }
  }
  
  public void onDoneFile(bgoe parambgoe)
  {
    if (parambgoe == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = parambgoe.a();
    } while (localBundle == null);
    int i = localBundle.getInt(parambgoe.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + parambgoe.f + ", status: " + parambgoe.a() + ",task.currUrl:" + parambgoe.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(parambgoe);
      if (parambgoe.a() != 3) {
        this.a.jdField_a_of_type_Amki.a(Boolean.valueOf(false));
      }
      this.a.b();
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception parambgoe)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", parambgoe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnz
 * JD-Core Version:    0.7.0.1
 */