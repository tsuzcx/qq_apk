import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class akwl
{
  public int a;
  public akob a;
  private akwm jdField_a_of_type_Akwm;
  public SharedPreferences a;
  public String a;
  public WeakReference<BaseChatPie> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  public AtomicBoolean a;
  public boolean a;
  public int b;
  public String b;
  public WeakReference<QQAppInterface> b;
  public AtomicBoolean b;
  public boolean b;
  public int c;
  public WeakReference<akml> c;
  private AtomicBoolean c;
  public int d;
  private WeakReference<akww> jdField_d_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public int e = 0;
  private int f;
  
  public akwl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_d_of_type_Int = -1;
    if (paramQQAppInterface == null)
    {
      QLog.e("cmshow_scripted_SpriteContext", 1, "[SpriteContext], app is null.");
      return;
    }
    a(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    a();
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    b();
  }
  
  public int a()
  {
    return this.f;
  }
  
  public akml a()
  {
    if (this.jdField_c_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (akml)this.jdField_c_of_type_JavaLangRefWeakReference.get();
  }
  
  public akwm a()
  {
    return this.jdField_a_of_type_Akwm;
  }
  
  public akww a()
  {
    if (this.jdField_d_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (akww)this.jdField_d_of_type_JavaLangRefWeakReference.get();
  }
  
  public BaseChatPie a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = akji.a(a());
  }
  
  public void a(int paramInt)
  {
    akml localakml = a();
    if (localakml != null) {
      localakml.setBubbleType(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.e = paramInt2;
    if (this.e == 0)
    {
      if ((1 != paramInt1) && (3000 != paramInt1)) {
        break label43;
      }
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      a(this.jdField_c_of_type_Int);
      return;
      label43:
      if (paramInt1 == 0) {
        this.jdField_c_of_type_Int = 0;
      }
    }
  }
  
  public void a(akml paramakml)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramakml);
  }
  
  public void a(akob paramakob)
  {
    this.jdField_a_of_type_Akob = paramakob;
  }
  
  public void a(akwm paramakwm)
  {
    this.jdField_a_of_type_Akwm = paramakwm;
  }
  
  public void a(akww paramakww)
  {
    this.jdField_d_of_type_JavaLangRefWeakReference = new WeakReference(paramakww);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Int = i;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sprite_hide_key" + this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Int).commit();
      }
      return;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000);
  }
  
  protected boolean a(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sprite_hide_key" + this.jdField_b_of_type_JavaLangString, -1);
    }
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  protected boolean b()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        QLog.i("cmshow_scripted_SpriteContext", 1, "cmshow should hide from:" + str);
        alda.a(this.f, 10, 104, new Object[] { "cmshow should hide from:", str });
      }
      i = this.jdField_a_of_type_JavaUtilSet.size();
    }
    finally {}
    int i;
    if (i > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean e()
  {
    if (!f()) {
      return true;
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      return false;
    }
    return this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean f()
  {
    if (this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null)
    {
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(akji.e());
    }
    return this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwl
 * JD-Core Version:    0.7.0.1
 */