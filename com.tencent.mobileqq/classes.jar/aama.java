import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class aama
{
  private static volatile aama jdField_a_of_type_Aama;
  private Map<String, aamg> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static aama a()
  {
    if (jdField_a_of_type_Aama == null) {}
    try
    {
      if (jdField_a_of_type_Aama == null) {
        jdField_a_of_type_Aama = new aama();
      }
      return jdField_a_of_type_Aama;
    }
    finally {}
  }
  
  private aamg a(String paramString)
  {
    return (aamg)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(Context arg1)
  {
    aanp.b("GdtIPCManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_Aama)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    QIPCClientHelper.getInstance().register(aamj.a());
  }
  
  public void a(Context paramContext, aamh paramaamh, WeakReference<aamd> paramWeakReference)
  {
    String str2 = null;
    String str1;
    aamg localaamg;
    if (paramaamh != null)
    {
      str1 = paramaamh.a();
      if (paramaamh != null) {
        str2 = paramaamh.b();
      }
      localaamg = a(str1);
      paramContext = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
      if ((!TextUtils.isEmpty(paramContext)) && (localaamg != null) && (paramaamh != null) && (paramaamh.a())) {
        break label97;
      }
      aanp.d("GdtIPCManager", String.format("send error action:%s from:%s to:%s", new Object[] { str1, paramContext, str2 }));
    }
    label97:
    do
    {
      return;
      str1 = null;
      break;
      aanp.b("GdtIPCManager", String.format("send action:%s from:%s to:%s", new Object[] { str1, paramContext, str2 }));
      if (!TextUtils.equals(paramContext, str2)) {
        break label169;
      }
      paramContext = localaamg.a(paramaamh);
    } while ((paramWeakReference == null) || (paramWeakReference.get() == null));
    ((aamd)paramWeakReference.get()).a(paramaamh, paramContext);
    return;
    label169:
    if (TextUtils.equals("com.tencent.mobileqq", str2))
    {
      QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_module_client_to_server", str1, paramaamh.a, new aamb(this, paramWeakReference, paramaamh));
      return;
    }
    QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_module_client_to_server", str1, paramaamh.a, new aamc(this, paramWeakReference, paramaamh));
  }
  
  public boolean a(String paramString, aamg paramaamg)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      aanp.b("GdtIPCManager", String.format("register action:%s result:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
      return bool;
      if (paramaamg == null)
      {
        bool = false;
      }
      else if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        bool = false;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramString, paramaamg);
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aama
 * JD-Core Version:    0.7.0.1
 */