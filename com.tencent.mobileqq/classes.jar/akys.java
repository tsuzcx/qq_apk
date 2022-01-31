import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class akys
  implements bbjy
{
  akys(akyr paramakyr, AppInterface paramAppInterface, String paramString, akyt paramakyt) {}
  
  public void a(boolean paramBoolean, ArrayList<bbjx> paramArrayList)
  {
    paramArrayList = (akyz)paramArrayList.get(0);
    if ((akyr.a(this.jdField_a_of_type_Akyr) != null) && (akyr.a(this.jdField_a_of_type_Akyr) == paramArrayList))
    {
      QLog.w(this.jdField_a_of_type_Akyr.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + akyq.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Akyr.a(paramArrayList.a);
        this.jdField_a_of_type_Akyr.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      akyr.a(this.jdField_a_of_type_Akyr, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Akyt != null) {
        this.jdField_a_of_type_Akyt.a(this.jdField_a_of_type_Akyr.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Akyr.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akys
 * JD-Core Version:    0.7.0.1
 */