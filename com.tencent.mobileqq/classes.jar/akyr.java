import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class akyr
  implements bbkm
{
  akyr(akyq paramakyq, AppInterface paramAppInterface, String paramString, akys paramakys) {}
  
  public void a(boolean paramBoolean, ArrayList<bbkl> paramArrayList)
  {
    paramArrayList = (akyy)paramArrayList.get(0);
    if ((akyq.a(this.jdField_a_of_type_Akyq) != null) && (akyq.a(this.jdField_a_of_type_Akyq) == paramArrayList))
    {
      QLog.w(this.jdField_a_of_type_Akyq.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + akyp.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Akyq.a(paramArrayList.a);
        this.jdField_a_of_type_Akyq.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      akyq.a(this.jdField_a_of_type_Akyq, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Akys != null) {
        this.jdField_a_of_type_Akys.a(this.jdField_a_of_type_Akyq.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Akyq.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyr
 * JD-Core Version:    0.7.0.1
 */