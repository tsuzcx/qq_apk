import android.os.Bundle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class aise
  extends bbwt
{
  aise(airx paramairx) {}
  
  public void onDone(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + parambbwu.f + ", status: " + parambbwu.a());
    }
  }
  
  public void onDoneFile(bbwu parambbwu)
  {
    if (parambbwu == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = parambbwu.a();
    } while (localBundle == null);
    int i = localBundle.getInt(parambbwu.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + parambbwu.f + ", status: " + parambbwu.a() + ",task.currUrl:" + parambbwu.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(parambbwu);
      if (parambbwu.a() != 3) {
        this.a.jdField_a_of_type_Ajok.a(Boolean.valueOf(false));
      }
      this.a.b();
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception parambbwu)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", parambbwu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aise
 * JD-Core Version:    0.7.0.1
 */