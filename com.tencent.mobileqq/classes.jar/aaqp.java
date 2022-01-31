import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class aaqp
{
  private static volatile aaqp jdField_a_of_type_Aaqp;
  private Map<String, aaqv> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static aaqp a()
  {
    if (jdField_a_of_type_Aaqp == null) {}
    try
    {
      if (jdField_a_of_type_Aaqp == null) {
        jdField_a_of_type_Aaqp = new aaqp();
      }
      return jdField_a_of_type_Aaqp;
    }
    finally {}
  }
  
  private aaqv a(String paramString)
  {
    return (aaqv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(Context arg1)
  {
    aase.b("GdtIPCManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_Aaqp)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    QIPCClientHelper.getInstance().register(aaqy.a());
  }
  
  public void a(Context paramContext, aaqw paramaaqw, WeakReference<aaqs> paramWeakReference)
  {
    String str2 = null;
    String str1;
    aaqv localaaqv;
    if (paramaaqw != null)
    {
      str1 = paramaaqw.a();
      if (paramaaqw != null) {
        str2 = paramaaqw.b();
      }
      localaaqv = a(str1);
      paramContext = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
      if ((!TextUtils.isEmpty(paramContext)) && (localaaqv != null) && (paramaaqw != null) && (paramaaqw.a())) {
        break label97;
      }
      aase.d("GdtIPCManager", String.format("send error action:%s from:%s to:%s", new Object[] { str1, paramContext, str2 }));
    }
    label97:
    do
    {
      return;
      str1 = null;
      break;
      aase.b("GdtIPCManager", String.format("send action:%s from:%s to:%s", new Object[] { str1, paramContext, str2 }));
      if (!TextUtils.equals(paramContext, str2)) {
        break label169;
      }
      paramContext = localaaqv.a(paramaaqw);
    } while ((paramWeakReference == null) || (paramWeakReference.get() == null));
    ((aaqs)paramWeakReference.get()).a(paramaaqw, paramContext);
    return;
    label169:
    if (TextUtils.equals("com.tencent.mobileqq", str2))
    {
      QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_module_client_to_server", str1, paramaaqw.a, new aaqq(this, paramWeakReference, paramaaqw));
      return;
    }
    QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_module_client_to_server", str1, paramaaqw.a, new aaqr(this, paramWeakReference, paramaaqw));
  }
  
  public boolean a(String paramString, aaqv paramaaqv)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      aase.b("GdtIPCManager", String.format("register action:%s result:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
      return bool;
      if (paramaaqv == null)
      {
        bool = false;
      }
      else if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        bool = false;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramString, paramaaqv);
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqp
 * JD-Core Version:    0.7.0.1
 */