import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc.1;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc.2;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class ajfa
{
  private static final Set<String> a = new SpriteCommFunc.1();
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[stopTaskByMsg], msgId", Long.valueOf(paramLong), ",from:", paramString });
    }
    if (!ajfj.c(paramQQAppInterface)) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = ajfj.a(paramQQAppInterface);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramString = paramQQAppInterface.a(paramLong);
    if (paramString == null)
    {
      QLog.w("cmshow_scripted_SpriteCommFunc", 2, "task NOT exist, msgId:" + paramLong);
      return;
    }
    ThreadManager.post(new SpriteCommFunc.2(paramQQAppInterface, paramString), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[stopAllTask]", ",from:", paramString });
    }
    if (!ajfj.c(paramQQAppInterface)) {
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("type", 0);
      paramQQAppInterface = ajfj.a(paramQQAppInterface);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null))
      {
        QLog.e("cmshow_scripted_SpriteCommFunc", 1, "[stopAllTask], spriteContext or getSurfaceView is null.");
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("cmshow_scripted_SpriteCommFunc", 1, "[stopAllTask],", paramQQAppInterface);
      return;
    }
    ApolloCmdChannel.getChannel(paramQQAppInterface.a()).callbackFromRequest(paramQQAppInterface.a().getLuaState(), 0, "sc.stop_all_task.local", paramString.toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[showOrHideSprite]", ",from:", paramString });
    }
    if (!ajfj.c(paramQQAppInterface)) {}
    do
    {
      ajfg localajfg;
      do
      {
        do
        {
          return;
        } while (!a.contains(paramString));
        localajfg = ajfj.a(paramQQAppInterface);
      } while (localajfg == null);
      ajfb localajfb = ajfj.a(paramQQAppInterface);
      if (localajfb != null) {
        localajfb.a(paramString, paramBoolean);
      }
      if (ajfj.a(paramQQAppInterface))
      {
        QLog.i("cmshow_scripted_SpriteCommFunc", 1, "showOrHideSprite double should hide");
        return;
      }
      paramQQAppInterface = localajfg.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramBoolean, false, paramString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = ajfj.b(paramQQAppInterface);
    boolean bool2 = ajfj.a(paramQQAppInterface);
    return (bool1) || (bool2);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[isSpriteActive]", ",from:", paramString });
    }
    if (!ajfj.c(paramQQAppInterface)) {}
    do
    {
      do
      {
        return false;
        paramQQAppInterface = ajfj.a(paramQQAppInterface);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.a();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    do
    {
      return false;
      paramQQAppInterface = ajfj.a(paramQQAppInterface);
    } while ((paramQQAppInterface == null) || (!paramQQAppInterface.a(paramString)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfa
 * JD-Core Version:    0.7.0.1
 */