import android.os.Bundle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class aisg
  extends bbwf
{
  aisg(airz paramairz) {}
  
  public void onDone(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + parambbwg.f + ", status: " + parambbwg.a());
    }
  }
  
  public void onDoneFile(bbwg parambbwg)
  {
    if (parambbwg == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = parambbwg.a();
    } while (localBundle == null);
    int i = localBundle.getInt(parambbwg.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + parambbwg.f + ", status: " + parambbwg.a() + ",task.currUrl:" + parambbwg.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(parambbwg);
      if (parambbwg.a() != 3) {
        this.a.jdField_a_of_type_Ajom.a(Boolean.valueOf(false));
      }
      this.a.b();
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception parambbwg)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", parambbwg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisg
 * JD-Core Version:    0.7.0.1
 */