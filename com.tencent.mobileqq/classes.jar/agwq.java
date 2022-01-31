import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class agwq
{
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((!paramActivity.getBooleanExtra("showFirstStructMsg", false)) || (!paramBoolean));
        if (QLog.isColorLevel()) {
          QLog.d("send3rdAppStructMsg", 2, "send first struct msg");
        }
        paramActivity = paramActivity.getByteArrayExtra("stuctmsg_bytes");
      } while (paramActivity == null);
      paramActivity = azvd.a(paramActivity);
    } while (paramActivity == null);
    bdna.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramActivity, null);
    azqs.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "0X8004B51", "0X8004B51", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (0 != 0) {
      throw new NullPointerException();
    }
    zhe localzhe = new zhe(paramFragmentActivity);
    String str = paramFragmentActivity.getString(2131719921);
    if (paramString != null) {}
    for (paramString = str + paramString;; paramString = str)
    {
      paramAbsShareMsg = new agwr(paramAbsShareMsg, paramFragmentActivity, paramFragmentActivity, paramQQAppInterface, paramSessionInfo);
      localzhe.a(paramString, paramAbsShareMsg);
      localzhe.a(paramFragmentActivity.getResources().getString(2131719928));
      localzhe.a(paramAbsShareMsg);
      localzhe.a(false);
      localzhe.show();
      azqs.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "0X8004B54", "0X8004B54", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, SessionInfo paramSessionInfo)
  {
    boolean bool = false;
    azqs.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "0X8004B53", "0X8004B53", 0, 0, "", "", "", "");
    Object localObject = paramFragmentActivity.getIntent().getByteArrayExtra("stuctmsg_bytes");
    String str = paramFragmentActivity.getIntent().getStringExtra("thirdAppDisplayName");
    localObject = azvd.a((byte[])localObject);
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {}
    for (localObject = (AbsShareMsg)localObject;; localObject = null)
    {
      if ("webview".equals(paramFragmentActivity.getIntent().getStringExtra("from")))
      {
        bdhk.jdField_a_of_type_Int -= 1;
        if (!(paramFragmentActivity instanceof SplashActivity))
        {
          paramFragmentActivity.finish();
          bool = true;
        }
        return bool;
      }
      a(paramQQAppInterface, paramFragmentActivity, paramSessionInfo, (AbsShareMsg)localObject, str);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent.getBooleanExtra("from3rdApp", false))
    {
      bool1 = bool2;
      if (paramIntent.getBooleanExtra("showFirstStructMsg", false))
      {
        paramIntent = paramIntent.getByteArrayExtra("stuctmsg_bytes");
        bool1 = bool2;
        if (paramIntent != null)
        {
          paramIntent = azvd.a(paramIntent);
          long l = ayxz.jdField_a_of_type_Int;
          paramSessionInfo = azaf.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, l, paramIntent);
          paramIntent = new ArrayList();
          paramIntent.add(paramSessionInfo);
          paramQQAppInterface.a().b(paramIntent, paramQQAppInterface.getCurrentAccountUin());
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwq
 * JD-Core Version:    0.7.0.1
 */