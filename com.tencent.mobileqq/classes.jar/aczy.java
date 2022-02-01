import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mm.hardcoder.HardCoderManager.1;
import com.tencent.mm.hardcoder.HardCoderManager.2;
import com.tencent.mm.hardcoder.HardCoderManager.3;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aczy
  implements Handler.Callback
{
  private static aczy jdField_a_of_type_Aczy;
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  private static final String jdField_a_of_type_JavaLangString;
  private static Random jdField_a_of_type_JavaUtilRandom;
  public static final boolean a;
  private static Bundle jdField_b_of_type_AndroidOsBundle;
  private int jdField_a_of_type_Int = 0;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_hardcoder", 4);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HashMap<Integer, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    if ((QLog.isColorLevel()) && (new File("/sdcard/debug_hc").exists())) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaLangString = AppSetting.g() + "key_crash_cnt";
      jdField_a_of_type_AndroidOsBundle = new Bundle(8);
      jdField_b_of_type_AndroidOsBundle = new Bundle(2);
      jdField_a_of_type_JavaUtilRandom = new Random();
      return;
    }
  }
  
  public static aczy a()
  {
    if (jdField_a_of_type_Aczy == null) {}
    try
    {
      if (jdField_a_of_type_Aczy == null)
      {
        jdField_a_of_type_Aczy = new aczy();
        new HardCoderManager.1().start();
      }
      return jdField_a_of_type_Aczy;
    }
    finally {}
  }
  
  private void c()
  {
    if ((jdField_a_of_type_Boolean) && (new File("/sdcard/disable_hc").exists()))
    {
      QLog.d("HardCoder.QQManager", 1, "disable by file cfg");
      this.jdField_a_of_type_Int = 2;
      return;
    }
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_cfg_flag", 0);
    if (i == 2)
    {
      QLog.d("HardCoder.QQManager", 1, "disable by server cfg");
      this.jdField_a_of_type_Int = 3;
      return;
    }
    Object localObject = Build.MANUFACTURER;
    if ((localObject != null) && (((String)localObject).toUpperCase().contains("VIVO")))
    {
      QLog.d("HardCoder.QQManager", 1, "disable vivo");
      this.jdField_a_of_type_Int = 3;
      return;
    }
    int j;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      j = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(jdField_a_of_type_JavaLangString, 0);
      if (j > 2)
      {
        this.jdField_a_of_type_Int = 9;
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putInt("key_state", this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Int != 10) {
          break label307;
        }
        ((SharedPreferences.Editor)localObject).putInt(jdField_a_of_type_JavaLangString, j + 1);
        ThreadManager.getSubThreadHandler().postDelayed(new HardCoderManager.2(this), 10000L);
        label196:
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    for (;;)
    {
      QLog.d("HardCoder.QQManager", 1, "hc init " + this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(jdField_a_of_type_JavaLangString, j + 1).commit();
      this.jdField_a_of_type_Int = aczu.a().a();
      if ((this.jdField_a_of_type_Int != 10) || (i != 1) || (Math.random() >= 0.5D)) {
        break;
      }
      this.jdField_a_of_type_Int = 8;
      aczu.a().a();
      break;
      label307:
      ((SharedPreferences.Editor)localObject).putInt(jdField_a_of_type_JavaLangString, j);
      break label196;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_state", 1);
      if (this.jdField_a_of_type_Int == 10) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramString, true);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int != 10) {
      return 0;
    }
    if (BaseApplicationImpl.sProcessId == 1) {
      return aczu.a().a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramString);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    aczv localaczv = (aczv)aczu.a.obtain(aczv.class);
    localaczv.jdField_a_of_type_Int = paramInt1;
    localaczv.c = paramInt2;
    localaczv.d = paramInt3;
    localaczv.e = paramInt4;
    localaczv.b = paramInt5;
    localaczv.f = paramInt6;
    localaczv.jdField_a_of_type_Long = paramLong;
    localaczv.jdField_a_of_type_JavaLangString = paramString;
    localMessage.obj = localaczv;
    localMessage.sendToTarget();
    if (paramBoolean)
    {
      paramInt1 = jdField_a_of_type_JavaUtilRandom.nextInt();
      localMessage.arg1 = paramInt1;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(0));
    }
    for (;;)
    {
      return localMessage.arg1;
      localMessage.arg1 = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      this.jdField_a_of_type_Int = 1;
      QLog.d("HardCoder.QQManager", 1, "onDisconnect");
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_state", this.jdField_a_of_type_Int).commit();
      aczu.a().a();
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {}
    do
    {
      do
      {
        return;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          aczu.a().a(paramInt);
          return;
        }
      } while (this.jdField_a_of_type_AndroidOsHandler == null);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        localMessage.arg1 = ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt))).intValue();
        localMessage.sendToTarget();
        return;
      }
    } while (!paramBoolean);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      Object localObject;
      if (this.jdField_a_of_type_Int != 1)
      {
        localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.batteryCfg.name());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("#");
          if (localObject.length >= 4)
          {
            localObject = localObject[3];
            QLog.d("HardCoder.QQManager", 1, "hcConfig = " + (String)localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localObject = localObject.split("\\|")[0];
            }
          }
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_cfg_flag", Integer.valueOf((String)localObject).intValue()).commit();
        QLog.d("HardCoder.QQManager", 1, "svc flag = " + (String)localObject);
        if (this.jdField_a_of_type_Int != 4) {
          continue;
        }
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_last_down_time", 0L);
        if ((Math.abs(System.currentTimeMillis() - l) <= 86400000L) || (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))) {
          continue;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_down_time", System.currentTimeMillis()).apply();
        paramQQAppInterface.execute(new HardCoderManager.3(this, paramQQAppInterface));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HardCoder.QQManager", 1, "", localException);
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 8);
  }
  
  public void b()
  {
    QLog.d("HardCoder.QQManager", 1, "crash count = " + this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(jdField_a_of_type_JavaLangString, 0));
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(jdField_a_of_type_JavaLangString, 0).commit();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      Object localObject = (aczv)paramMessage.obj;
      jdField_a_of_type_AndroidOsBundle.putInt("key_delay", ((aczv)localObject).jdField_a_of_type_Int);
      jdField_a_of_type_AndroidOsBundle.putInt("key_cpu", ((aczv)localObject).c);
      jdField_a_of_type_AndroidOsBundle.putInt("key_io", ((aczv)localObject).d);
      jdField_a_of_type_AndroidOsBundle.putInt("key_bind", ((aczv)localObject).e);
      jdField_a_of_type_AndroidOsBundle.putInt("key_timeout", ((aczv)localObject).b);
      jdField_a_of_type_AndroidOsBundle.putInt("key_scene", ((aczv)localObject).f);
      jdField_a_of_type_AndroidOsBundle.putLong("key_action", ((aczv)localObject).jdField_a_of_type_Long);
      jdField_a_of_type_AndroidOsBundle.putString("key_tag", ((aczv)localObject).jdField_a_of_type_JavaLangString);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("HardCoderModule", "start", jdField_a_of_type_AndroidOsBundle);
      if ((paramMessage.arg1 != 0) && (localObject != null) && (((EIPCResult)localObject).code != 0)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramMessage.arg1), Integer.valueOf(((EIPCResult)localObject).code));
      }
    }
    for (;;)
    {
      return false;
      if (paramMessage.what == 1)
      {
        jdField_b_of_type_AndroidOsBundle.putInt("key_code", paramMessage.arg1);
        QIPCClientHelper.getInstance().getClient().callServer("HardCoderModule", "stop", jdField_b_of_type_AndroidOsBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczy
 * JD-Core Version:    0.7.0.1
 */