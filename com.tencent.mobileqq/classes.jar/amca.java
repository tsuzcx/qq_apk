import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class amca
{
  public float a;
  public int a;
  private amcg jdField_a_of_type_Amcg;
  public SharedPreferences a;
  public String a;
  public WeakReference<BaseChatPie> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  public AtomicBoolean a;
  public boolean a;
  public int b;
  public String b;
  public WeakReference<alqu> b;
  public AtomicBoolean b;
  public boolean b;
  public int c;
  private WeakReference<ambf> jdField_c_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int d = -1;
  public int e = 3;
  private int f;
  
  public amca()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaLangString = ApolloUtil.a();
    a();
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    b();
  }
  
  public int a()
  {
    return this.f;
  }
  
  public alqu a()
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (alqu)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  public ambf a()
  {
    if (this.jdField_c_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (ambf)this.jdField_c_of_type_JavaLangRefWeakReference.get();
  }
  
  public BaseChatPie a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public IPCSpriteContext a()
  {
    IPCSpriteContext localIPCSpriteContext = new IPCSpriteContext();
    localIPCSpriteContext.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localIPCSpriteContext.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localIPCSpriteContext.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localIPCSpriteContext.jdField_b_of_type_Int = this.e;
    localIPCSpriteContext.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localIPCSpriteContext.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    return localIPCSpriteContext;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    alqu localalqu = a();
    if (localalqu != null) {
      localalqu.setBubbleType(paramInt);
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
  
  public void a(alqu paramalqu)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramalqu);
  }
  
  public void a(amcg paramamcg)
  {
    this.jdField_a_of_type_Amcg = paramamcg;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.d = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sprite_hide_key" + this.jdField_b_of_type_JavaLangString, -1);
    }
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
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
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amca
 * JD-Core Version:    0.7.0.1
 */