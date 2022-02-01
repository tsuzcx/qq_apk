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

public abstract class adad
{
  public int a;
  private addc jdField_a_of_type_Addc;
  protected final Object a;
  public String a;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  protected List<Object[]> a;
  protected Map<String, adab> a;
  protected boolean a;
  protected int b;
  public String b;
  protected Map<Class<? extends adae>, adae> b;
  private int c = -1;
  
  public adad(Activity paramActivity, int paramInt, String paramString)
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
  private void b(adab paramadab, JSONObject paramJSONObject, adaa paramadaa)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    adae localadae;
    do
    {
      return;
      localadae = a(paramadab.jdField_a_of_type_JavaLangClass, true);
      if (localadae == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.apiMgr", 2, "module load failed");
        }
        addh.a(paramadaa, 2);
        return;
      }
      adcu.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramadab.jdField_a_of_type_JavaLangString);
    } while (localadae.a(paramadab.jdField_a_of_type_Int, paramadab.jdField_a_of_type_JavaLangString, paramJSONObject, paramadaa));
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "module not handled this api");
    }
    addh.a(paramadaa, 1);
  }
  
  @UiThread
  private void b(String paramString, JSONObject paramJSONObject, @NonNull adaa paramadaa)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    while (this.jdField_b_of_type_Int != 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "call api=" + paramString + ", param=" + paramJSONObject + ", cb=" + paramadaa);
    }
    if (!a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "app has no permission");
      }
      addh.a(paramadaa, 3);
      return;
    }
    adab localadab = (adab)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localadab == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "no such api");
      }
      addh.a(paramadaa, 1);
      return;
    }
    if (!adcu.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "frequence restricted");
      }
      addh.a(paramadaa, 8);
      return;
    }
    paramString = paramJSONObject;
    if (paramJSONObject == null) {
      paramString = new JSONObject();
    }
    a(localadab, paramString, paramadaa);
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((adae)localIterator.next()).b();
    }
  }
  
  public <T extends adae> T a(Class<T> paramClass, boolean paramBoolean)
  {
    Object localObject = (adae)this.jdField_b_of_type_JavaUtilMap.get(paramClass);
    if ((localObject == null) && (paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          adae localadae = (adae)this.jdField_b_of_type_JavaUtilMap.get(paramClass);
          localObject = localadae;
          if (localadae == null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("DoraemonOpenAPI.apiMgr", 2, "create module " + paramClass.getSimpleName());
            }
            localadae = adaf.a(paramClass, this);
            localObject = localadae;
            if (localadae != null)
            {
              this.jdField_b_of_type_JavaUtilMap.put(paramClass, localadae);
              localObject = localadae;
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
  
  public abstract awxt a();
  
  protected abstract Map<String, adab> a();
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap = a();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Int = 1;
      c();
      adcu.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      if (BaseApplicationImpl.sProcessId != 1) {
        aady.a().a();
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
        addh.a((adaa)arrayOfObject[2], addh.a(paramInt));
      }
    }
  }
  
  protected void a(int paramInt, adab paramadab, JSONObject paramJSONObject, adaa paramadaa)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "onHandleAPIAuthorize " + paramInt);
    }
    if (paramInt == 0)
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b(paramadab, paramJSONObject, paramadaa);
        return;
      }
      ThreadManager.getUIHandler().post(new DoraemonAPIManager.4(this, paramadab, paramJSONObject, paramadaa));
      return;
    }
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "auth not pass " + paramInt);
    addh.a(paramadaa, paramInt);
  }
  
  protected abstract void a(adab paramadab, JSONObject paramJSONObject, adaa paramadaa);
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, String paramString6, View.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramString3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramString3 == null) || (paramString3.isFinishing()))
    {
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "showDialog activity is not valid");
      return;
    }
    this.jdField_a_of_type_Addc = new addc(paramString3);
    this.jdField_a_of_type_Addc.c(anvx.a(2131702908));
    this.jdField_a_of_type_Addc.b(paramString1);
    this.jdField_a_of_type_Addc.d(paramString4);
    this.jdField_a_of_type_Addc.f(paramString6);
    this.jdField_a_of_type_Addc.e(paramString5);
    this.jdField_a_of_type_Addc.a(paramOnClickListener1);
    this.jdField_a_of_type_Addc.b(paramOnClickListener2);
    this.jdField_a_of_type_Addc.a(paramOnCancelListener);
    this.jdField_a_of_type_Addc.a(paramString2);
    this.jdField_a_of_type_Addc.show();
    bdla.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "", "", "", "");
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, @NonNull adaa paramadaa)
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
            addh.a(paramadaa, addh.a(this.jdField_b_of_type_Int));
            return;
          }
          this.jdField_a_of_type_JavaUtilList.add(new Object[] { paramString, paramJSONObject, paramadaa });
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
      b(paramString, paramJSONObject, paramadaa);
      return;
    }
    ThreadManager.getUIHandler().post(new DoraemonAPIManager.3(this, paramString, paramJSONObject, paramadaa));
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
        Toast.makeText(BaseApplicationImpl.getContext(), anvx.a(2131702900) + paramString + anvx.a(2131702898), 0).show();
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
            aady.a().b();
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
    this.jdField_a_of_type_Addc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adad
 * JD-Core Version:    0.7.0.1
 */