import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager.1;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager.2;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager.3;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class absi
{
  public int a;
  private abvh jdField_a_of_type_Abvh;
  protected final Object a;
  public String a;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  protected List<Object[]> a;
  protected Map<String, absg> a;
  protected boolean a;
  protected int b;
  public String b;
  protected Map<Class<? extends absj>, absj> b;
  private int c = -1;
  
  public absi(Activity paramActivity, int paramInt, String paramString)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = (paramInt + "_" + paramString);
  }
  
  @UiThread
  private void b(absg paramabsg, JSONObject paramJSONObject, absf paramabsf)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    absj localabsj;
    do
    {
      return;
      localabsj = a(paramabsg.jdField_a_of_type_JavaLangClass, true);
      if (localabsj == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.apiMgr", 2, "module load failed");
        }
        abvm.a(paramabsf, 2);
        return;
      }
      abuz.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramabsg.jdField_a_of_type_JavaLangString);
    } while (localabsj.a(paramabsg.jdField_a_of_type_Int, paramabsg.jdField_a_of_type_JavaLangString, paramJSONObject, paramabsf));
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "module not handled this api");
    }
    abvm.a(paramabsf, 1);
  }
  
  @UiThread
  private void b(String paramString, JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    while (this.jdField_b_of_type_Int != 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "call api=" + paramString + ", param=" + paramJSONObject + ", cb=" + paramabsf);
    }
    if (!a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "app has no permission");
      }
      abvm.a(paramabsf, 3);
      return;
    }
    absg localabsg = (absg)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localabsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "no such api");
      }
      abvm.a(paramabsf, 1);
      return;
    }
    if (!abuz.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "frequence restricted");
      }
      abvm.a(paramabsf, 8);
      return;
    }
    paramString = paramJSONObject;
    if (paramJSONObject == null) {
      paramString = new JSONObject();
    }
    a(localabsg, paramString, paramabsf);
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((absj)localIterator.next()).b();
    }
  }
  
  public <T extends absj> T a(Class<T> paramClass, boolean paramBoolean)
  {
    Object localObject = (absj)this.jdField_b_of_type_JavaUtilMap.get(paramClass);
    if ((localObject == null) && (paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          absj localabsj = (absj)this.jdField_b_of_type_JavaUtilMap.get(paramClass);
          localObject = localabsj;
          if (localabsj == null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("DoraemonOpenAPI.apiMgr", 2, "create module " + paramClass.getSimpleName());
            }
            localabsj = absk.a(paramClass, this);
            localObject = localabsj;
            if (localabsj != null)
            {
              this.jdField_b_of_type_JavaUtilMap.put(paramClass, localabsj);
              localObject = localabsj;
            }
          }
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
  
  public Activity a()
  {
    return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public abstract atzw a();
  
  protected abstract Map<String, absg> a();
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap = a();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Int = 1;
      c();
      abuz.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      if (BaseApplicationImpl.sProcessId != 1) {
        ymk.a().a();
      }
      return;
    }
  }
  
  protected void a(int paramInt)
  {
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "onLoadAppInfo " + paramInt);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Int = paramInt;
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_JavaUtilList.clear();
        if (localArrayList.size() > 0)
        {
          if (paramInt == 2) {
            ThreadManager.getUIHandler().post(new DoraemonAPIManager.2(this, localArrayList));
          }
        }
        else {
          return;
        }
      }
      ??? = localObject2.iterator();
      while (((Iterator)???).hasNext())
      {
        Object[] arrayOfObject = (Object[])((Iterator)???).next();
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "load app info error, api=" + arrayOfObject[0]);
        abvm.a((absf)arrayOfObject[2], abvm.a(paramInt));
      }
    }
  }
  
  protected void a(int paramInt, absg paramabsg, JSONObject paramJSONObject, absf paramabsf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "onHandleAPIAuthorize " + paramInt);
    }
    if (paramInt == 0)
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b(paramabsg, paramJSONObject, paramabsf);
        return;
      }
      ThreadManager.getUIHandler().post(new DoraemonAPIManager.4(this, paramabsg, paramJSONObject, paramabsf));
      return;
    }
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "auth not pass " + paramInt);
    abvm.a(paramabsf, paramInt);
  }
  
  protected abstract void a(absg paramabsg, JSONObject paramJSONObject, absf paramabsf);
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, String paramString6, View.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramString3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramString3 == null) || (paramString3.isFinishing()))
    {
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "showDialog activity is not valid");
      return;
    }
    this.jdField_a_of_type_Abvh = new abvh(paramString3);
    this.jdField_a_of_type_Abvh.c(alpo.a(2131703806));
    this.jdField_a_of_type_Abvh.b(paramString1);
    this.jdField_a_of_type_Abvh.d(paramString4);
    this.jdField_a_of_type_Abvh.f(paramString6);
    this.jdField_a_of_type_Abvh.e(paramString5);
    this.jdField_a_of_type_Abvh.a(paramOnClickListener1);
    this.jdField_a_of_type_Abvh.b(paramOnClickListener2);
    this.jdField_a_of_type_Abvh.a(paramOnCancelListener);
    this.jdField_a_of_type_Abvh.a(paramString2);
    this.jdField_a_of_type_Abvh.show();
    azmj.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "", "", "", "");
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    if (this.jdField_b_of_type_Int != 2) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_Int != 2)
        {
          if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DoraemonOpenAPI.apiMgr", 2, "appinfo error and can not retry");
            }
            abvm.a(paramabsf, abvm.a(this.jdField_b_of_type_Int));
            return;
          }
          this.jdField_a_of_type_JavaUtilList.add(new Object[] { paramString, paramJSONObject, paramabsf });
          if (QLog.isColorLevel()) {
            QLog.i("DoraemonOpenAPI.apiMgr", 2, "permission not ready, add to queue api=" + paramString);
          }
          if (this.jdField_b_of_type_Int != 1)
          {
            this.jdField_b_of_type_Int = 1;
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "retry loadAppInfo");
            c();
          }
          return;
        }
      }
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b(paramString, paramJSONObject, paramabsf);
      return;
    }
    ThreadManager.getUIHandler().post(new DoraemonAPIManager.3(this, paramString, paramJSONObject, paramabsf));
  }
  
  protected boolean a()
  {
    if (this.c == -1) {
      this.c = 0;
    }
    return this.c == 1;
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = a().a.contains(paramString);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (a())
      {
        Toast.makeText(BaseApplicationImpl.getContext(), alpo.a(2131703798) + paramString + alpo.a(2131703796), 0).show();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = true;
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          e();
          if (BaseApplicationImpl.sProcessId != 1) {
            ymk.a().b();
          }
          return;
        }
      }
      finally {}
      ThreadManager.getUIHandler().post(new DoraemonAPIManager.1(this));
    }
  }
  
  protected abstract void c();
  
  public void d()
  {
    this.jdField_a_of_type_Abvh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absi
 * JD-Core Version:    0.7.0.1
 */