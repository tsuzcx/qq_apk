import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.Manager;

public class adyt
  implements Manager
{
  public int a;
  public Set<String> a;
  boolean a;
  public int b;
  
  public adyt()
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("PhotoListConfig" + paramString, 0).getInt("k_version", 0);
  }
  
  public static adyt a(QQAppInterface paramQQAppInterface)
  {
    adyt localadyt = (adyt)paramQQAppInterface.getManager(215);
    localadyt.a(paramQQAppInterface);
    return localadyt;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences("PhotoListConfig" + paramString, 0).edit().putInt("k_version", paramInt).apply();
  }
  
  @TargetApi(14)
  private void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("PhotoListConfig" + paramQQAppInterface.getCurrentAccountUin(), 0);
        this.jdField_a_of_type_Int = paramQQAppInterface.getInt("k_s", 0);
        this.b = paramQQAppInterface.getInt("k_w", 0);
        this.jdField_a_of_type_JavaUtilSet = paramQQAppInterface.getStringSet("k_b_l", null);
        paramQQAppInterface = new StringBuilder("init ");
        paramQQAppInterface.append("size:").append(this.jdField_a_of_type_Int).append(" width:").append(this.b).append(" black:").append(this.jdField_a_of_type_JavaUtilSet);
        QLog.i("PhotoListConfig", 1, paramQQAppInterface.toString());
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  @TargetApi(14)
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    try
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      this.jdField_a_of_type_JavaUtilSet = paramSet;
      paramQQAppInterface.getApp().getSharedPreferences("PhotoListConfig" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("k_s", paramInt1).putInt("k_w", paramInt2).putStringSet("k_b_l", paramSet).apply();
      paramQQAppInterface = new StringBuilder("updateConfig ");
      paramQQAppInterface.append("size:").append(this.jdField_a_of_type_Int).append(" width:").append(this.b).append(" black:").append(paramSet);
      QLog.i("PhotoListConfig", 1, paramQQAppInterface.toString());
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adyt
 * JD-Core Version:    0.7.0.1
 */