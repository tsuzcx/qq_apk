import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class akkg
  implements bair
{
  akkg(akkf paramakkf, AppInterface paramAppInterface, String paramString, akkh paramakkh) {}
  
  public void a(boolean paramBoolean, ArrayList<baiq> paramArrayList)
  {
    paramArrayList = (akkn)paramArrayList.get(0);
    if ((akkf.a(this.jdField_a_of_type_Akkf) != null) && (akkf.a(this.jdField_a_of_type_Akkf) == paramArrayList))
    {
      QLog.w(this.jdField_a_of_type_Akkf.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + akke.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Akkf.a(paramArrayList.a);
        this.jdField_a_of_type_Akkf.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      akkf.a(this.jdField_a_of_type_Akkf, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Akkh != null) {
        this.jdField_a_of_type_Akkh.a(this.jdField_a_of_type_Akkf.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Akkf.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akkg
 * JD-Core Version:    0.7.0.1
 */