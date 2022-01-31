import android.content.Intent;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.RegisterGuideView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahrc
{
  public static final String[] a = { "H60-L02", "H60-L01" };
  
  private static int a(Intent paramIntent)
  {
    boolean bool1 = paramIntent.getBooleanExtra("from_register_guide", false);
    boolean bool2 = paramIntent.getBooleanExtra("isActionSend", false);
    boolean bool3 = paramIntent.getBooleanExtra("from_register_choose", false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      paramIntent = BaseApplicationImpl.sApplication.getAllAccounts();
      if ((paramIntent == null) || (paramIntent.isEmpty())) {
        return 101;
      }
    }
    return 102;
  }
  
  public static GuideBaseFragment a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    switch (a(paramBaseActivity.getIntent()))
    {
    default: 
      return new LoginView(paramQQAppInterface);
    case 102: 
      return new LoginView(paramQQAppInterface);
    }
    return new RegisterGuideView(paramQQAppInterface);
  }
  
  public static boolean a(String[] paramArrayOfString)
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("GuideHandler", 2, "isKeyBoardBlackList model=" + str);
    }
    boolean bool1 = bool2;
    int j;
    int i;
    if (str != null)
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (str.equals(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahrc
 * JD-Core Version:    0.7.0.1
 */