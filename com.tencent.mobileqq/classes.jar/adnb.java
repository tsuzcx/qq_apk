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

public abstract class adnb
{
  public int a;
  private adqa jdField_a_of_type_Adqa;
  protected final Object a;
  public String a;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  protected List<Object[]> a;
  protected Map<String, admz> a;
  protected boolean a;
  protected int b;
  public String b;
  protected Map<Class<? extends adnc>, adnc> b;
  private int c = -1;
  
  public adnb(Activity paramActivity, int paramInt, String paramString)
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
  private void b(admz paramadmz, JSONObject paramJSONObject, admy paramadmy)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    adnc localadnc;
    do
    {
      return;
      localadnc = a(paramadmz.jdField_a_of_type_JavaLangClass, true);
      if (localadnc == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.apiMgr", 2, "module load failed");
        }
        adqf.a(paramadmy, 2);
        return;
      }
      adps.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramadmz.jdField_a_of_type_JavaLangString);
    } while (localadnc.a(paramadmz.jdField_a_of_type_Int, paramadmz.jdField_a_of_type_JavaLangString, paramJSONObject, paramadmy));
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "module not handled this api");
    }
    adqf.a(paramadmy, 1);
  }
  
  @UiThread
  private void b(String paramString, JSONObject paramJSONObject, @NonNull admy paramadmy)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    while (this.jdField_b_of_type_Int != 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "call api=" + paramString + ", param=" + paramJSONObject + ", cb=" + paramadmy);
    }
    if (!a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "app has no permission");
      }
      adqf.a(paramadmy, 3);
      return;
    }
    admz localadmz = (admz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localadmz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "no such api");
      }
      adqf.a(paramadmy, 1);
      return;
    }
    if (!adps.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "frequence restricted");
      }
      adqf.a(paramadmy, 8);
      return;
    }
    paramString = paramJSONObject;
    if (paramJSONObject == null) {
      paramString = new JSONObject();
    }
    a(localadmz, paramString, paramadmy);
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((adnc)localIterator.next()).b();
    }
  }
  
  public <T extends adnc> T a(Class<T> paramClass, boolean paramBoolean)
  {
    Object localObject = (adnc)this.jdField_b_of_type_JavaUtilMap.get(paramClass);
    if ((localObject == null) && (paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          adnc localadnc = (adnc)this.jdField_b_of_type_JavaUtilMap.get(paramClass);
          localObject = localadnc;
          if (localadnc == null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("DoraemonOpenAPI.apiMgr", 2, "create module " + paramClass.getSimpleName());
            }
            localadnc = adnd.a(paramClass, this);
            localObject = localadnc;
            if (localadnc != null)
            {
              this.jdField_b_of_type_JavaUtilMap.put(paramClass, localadnc);
              localObject = localadnc;
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
  
  public abstract axeh a();
  
  protected abstract Map<String, admz> a();
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap = a();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Int = 1;
      c();
      adps.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      if (BaseApplicationImpl.sProcessId != 1) {
        aasb.a().a();
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
        adqf.a((admy)arrayOfObject[2], adqf.a(paramInt));
      }
    }
  }
  
  protected void a(int paramInt, admz paramadmz, JSONObject paramJSONObject, admy paramadmy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "onHandleAPIAuthorize " + paramInt);
    }
    if (paramInt == 0)
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b(paramadmz, paramJSONObject, paramadmy);
        return;
      }
      ThreadManager.getUIHandler().post(new DoraemonAPIManager.4(this, paramadmz, paramJSONObject, paramadmy));
      return;
    }
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "auth not pass " + paramInt);
    adqf.a(paramadmy, paramInt);
  }
  
  protected abstract void a(admz paramadmz, JSONObject paramJSONObject, admy paramadmy);
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, String paramString6, View.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramString3 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramString3 == null) || (paramString3.isFinishing()))
    {
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "showDialog activity is not valid");
      return;
    }
    this.jdField_a_of_type_Adqa = new adqa(paramString3);
    this.jdField_a_of_type_Adqa.c(anzj.a(2131702322));
    this.jdField_a_of_type_Adqa.b(paramString1);
    this.jdField_a_of_type_Adqa.d(paramString4);
    this.jdField_a_of_type_Adqa.f(paramString6);
    this.jdField_a_of_type_Adqa.e(paramString5);
    this.jdField_a_of_type_Adqa.a(paramOnClickListener1);
    this.jdField_a_of_type_Adqa.b(paramOnClickListener2);
    this.jdField_a_of_type_Adqa.a(paramOnCancelListener);
    this.jdField_a_of_type_Adqa.a(paramString2);
    this.jdField_a_of_type_Adqa.show();
    bdll.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "", "", "", "");
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, @NonNull admy paramadmy)
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
            adqf.a(paramadmy, adqf.a(this.jdField_b_of_type_Int));
            return;
          }
          this.jdField_a_of_type_JavaUtilList.add(new Object[] { paramString, paramJSONObject, paramadmy });
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
      b(paramString, paramJSONObject, paramadmy);
      return;
    }
    ThreadManager.getUIHandler().post(new DoraemonAPIManager.3(this, paramString, paramJSONObject, paramadmy));
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
        Toast.makeText(BaseApplicationImpl.getContext(), anzj.a(2131702314) + paramString + anzj.a(2131702312), 0).show();
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
            aasb.a().b();
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
    this.jdField_a_of_type_Adqa.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnb
 * JD-Core Version:    0.7.0.1
 */