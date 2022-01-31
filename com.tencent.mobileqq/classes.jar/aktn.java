import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

public class aktn
  extends aktk
{
  public aktn(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(albr paramalbr, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void a(albr paramalbr, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) || (!this.c)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      this.b = true;
      localSharedPreferences = paramContext.getSharedPreferences("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", true));
    albi.a(paramalbr, alud.a(2131704999), 7, 0);
    localSharedPreferences.edit().putBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", false).commit();
    a(paramContext, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktn
 * JD-Core Version:    0.7.0.1
 */