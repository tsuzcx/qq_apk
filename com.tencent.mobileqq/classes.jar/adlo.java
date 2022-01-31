import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Locale;

public class adlo
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static boolean jdField_a_of_type_Boolean;
  WeakReference<adli> jdField_a_of_type_JavaLangRefWeakReference;
  LinkedList<WeakReference<adli>> jdField_a_of_type_JavaUtilLinkedList;
  
  public adlo()
  {
    jdField_a_of_type_Boolean = a();
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    jdField_a_of_type_AndroidOsHandler = new adlp(this, Looper.getMainLooper());
    aknz.a().a(new adlq(this));
  }
  
  public static adlo a()
  {
    return adlr.a;
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(4));
  }
  
  public static void a(WeakReference<adli> paramWeakReference)
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
      adli localadli = (adli)localWeakReference.get();
      if (localadli != null)
      {
        localadli.doOnEvent(2);
        adli.a(localadli);
        adli.b(localadli);
      }
      g(localWeakReference);
      k -= 1;
    }
  }
  
  private boolean a()
  {
    amqp localamqp = amqq.b(380).a();
    if ((localamqp == null) || (localamqp.a() == null))
    {
      QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, "confBean.getConfig() get fail");
      return false;
    }
    return localamqp.a().b;
  }
  
  private void b() {}
  
  private static void b(String paramString) {}
  
  public static void b(WeakReference<adli> paramWeakReference)
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
  
  public static void c(WeakReference<adli> paramWeakReference)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramWeakReference));
  }
  
  private void d(WeakReference<adli> paramWeakReference)
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
  
  private void e(WeakReference<adli> paramWeakReference)
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
  
  private void f(WeakReference<adli> paramWeakReference)
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
  
  private void g(WeakReference<adli> paramWeakReference)
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
 * Qualified Name:     adlo
 * JD-Core Version:    0.7.0.1
 */