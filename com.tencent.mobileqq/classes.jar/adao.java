import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Locale;

public class adao
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static boolean jdField_a_of_type_Boolean;
  WeakReference<adai> jdField_a_of_type_JavaLangRefWeakReference;
  LinkedList<WeakReference<adai>> jdField_a_of_type_JavaUtilLinkedList;
  
  public adao()
  {
    jdField_a_of_type_Boolean = a();
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    jdField_a_of_type_AndroidOsHandler = new adap(this, Looper.getMainLooper());
    ajzo.a().a(new adaq(this));
  }
  
  public static adao a()
  {
    return adar.a;
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(4));
  }
  
  public static void a(WeakReference<adai> paramWeakReference)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramWeakReference));
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      b("removeLast, list is empty");
      return;
    }
    int m = this.jdField_a_of_type_JavaUtilLinkedList.size();
    int i;
    label38:
    int k;
    if (paramBoolean)
    {
      i = m;
      if (i <= 0) {
        break label151;
      }
      k = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(this.jdField_a_of_type_JavaLangRefWeakReference);
      if (k > 0) {
        j = m - k;
      }
      k = i;
      if (i > j) {
        k = j;
      }
      b("removeLast, size = " + m + ", toBeRemovedCount = " + k + " , numOfInactive = " + j);
    }
    for (;;)
    {
      WeakReference localWeakReference;
      if (k > 0)
      {
        localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilLinkedList.peekLast();
        if (localWeakReference != null) {}
      }
      else
      {
        b();
        return;
        i = m - 10;
        break;
        label151:
        i = 0;
        break label38;
      }
      adai localadai = (adai)localWeakReference.get();
      if (localadai != null)
      {
        localadai.doOnEvent(2);
        adai.a(localadai);
        adai.b(localadai);
      }
      g(localWeakReference);
      k -= 1;
    }
  }
  
  private boolean a()
  {
    amax localamax = amay.b(380).a();
    if ((localamax == null) || (localamax.a() == null))
    {
      QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, "confBean.getConfig() get fail");
      return false;
    }
    return localamax.a().b;
  }
  
  private void b() {}
  
  private static void b(String paramString) {}
  
  public static void b(WeakReference<adai> paramWeakReference)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramWeakReference));
  }
  
  private void c()
  {
    b("do clear");
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
  }
  
  private static void c(String paramString)
  {
    QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, String.format(Locale.CHINA, paramString, new Object[0]));
  }
  
  public static void c(WeakReference<adai> paramWeakReference)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramWeakReference));
  }
  
  private void d(WeakReference<adai> paramWeakReference)
  {
    if (paramWeakReference == null) {}
    while (this.jdField_a_of_type_JavaLangRefWeakReference != paramWeakReference) {
      return;
    }
    int i = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(this.jdField_a_of_type_JavaLangRefWeakReference);
    int j = this.jdField_a_of_type_JavaUtilLinkedList.size();
    if ((i == -1) || (i == j - 1) || (j == 0))
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = ((WeakReference)this.jdField_a_of_type_JavaUtilLinkedList.get(i + 1));
  }
  
  private void e(WeakReference<adai> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      b("doMoveToFirst node is null");
      return;
    }
    d(paramWeakReference);
    b(String.format("doMoveToFirst: %h", new Object[] { paramWeakReference.get() }));
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.getFirst() == paramWeakReference))
    {
      b("doMoveToFirst node already in the first position");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramWeakReference)) {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramWeakReference);
    }
    this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramWeakReference);
    a(false);
  }
  
  private void f(WeakReference<adai> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      b("doMoveToFirstInActive node is null");
      return;
    }
    b(String.format("doMoveToFirstInActive: %h", new Object[] { paramWeakReference.get() }));
    if ((this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramWeakReference)))
    {
      b("doMoveToFirstInActive node not in the list");
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedList.remove(paramWeakReference);
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramWeakReference);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
      a(false);
      return;
      int i = this.jdField_a_of_type_JavaUtilLinkedList.indexOf(this.jdField_a_of_type_JavaLangRefWeakReference);
      if (i > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(i, paramWeakReference);
      }
    }
  }
  
  private void g(WeakReference<adai> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      b("doRemove node is null");
      return;
    }
    b(String.format("doRemove %h", new Object[] { paramWeakReference.get() }));
    d(paramWeakReference);
    this.jdField_a_of_type_JavaUtilLinkedList.remove(paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adao
 * JD-Core Version:    0.7.0.1
 */