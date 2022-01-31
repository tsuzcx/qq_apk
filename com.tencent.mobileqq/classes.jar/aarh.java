import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import java.lang.ref.WeakReference;

public class aarh
  extends aark
{
  WorldCupConfigInfo jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  
  public aarh(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    super(paramString1);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = null;
  }
  
  boolean a(Resources paramResources)
  {
    this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = WorldCupConfigInfo.a(this.jdField_a_of_type_JavaLangString, null);
    WorldCup.b();
    if (AudioHelper.e()) {
      AudioHelper.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarh
 * JD-Core Version:    0.7.0.1
 */