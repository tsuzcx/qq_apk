import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class addz
  extends QIPCModule
{
  private static addz a;
  
  public addz(String paramString)
  {
    super(paramString);
  }
  
  public static addz a()
  {
    if (a == null) {}
    try
    {
      a = new addz("HardCoderModule");
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    EIPCResult localEIPCResult = null;
    if (QLog.isColorLevel()) {
      QLog.d("HardCoder.QQManager", 2, "onCall action = " + paramString);
    }
    if (paramString.equals("start"))
    {
      paramInt = paramBundle.getInt("key_delay");
      i = paramBundle.getInt("key_cpu");
      j = paramBundle.getInt("key_io");
      k = paramBundle.getInt("key_bind");
      m = paramBundle.getInt("key_timeout");
      n = paramBundle.getInt("key_scene");
      l = paramBundle.getLong("key_action");
      paramString = paramBundle.getString("key_tag");
      localEIPCResult = EIPCResult.createResult(addu.a().a(paramInt, i, j, k, m, n, l, Process.myTid(), paramString), null);
    }
    while (!paramString.equals("stop"))
    {
      int i;
      int j;
      int k;
      int m;
      int n;
      long l;
      return localEIPCResult;
    }
    paramInt = paramBundle.getInt("key_code");
    addu.a().a(paramInt);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addz
 * JD-Core Version:    0.7.0.1
 */