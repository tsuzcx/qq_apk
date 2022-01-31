import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

public class aixo
  extends aixl
{
  public aixo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(ajfs paramajfs, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void a(ajfs paramajfs, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) || (!this.c)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      this.b = true;
      localSharedPreferences = paramContext.getSharedPreferences("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", true));
    ajfj.a(paramajfs, ajyc.a(2131704604), 7, 0);
    localSharedPreferences.edit().putBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", false).commit();
    a(paramContext, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixo
 * JD-Core Version:    0.7.0.1
 */