import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.CheckOfflineCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class akwz
  implements Runnable
{
  public akwz(SwiftBrowserOfflineHandler paramSwiftBrowserOfflineHandler) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)) {
      QLog.i("SwiftBrowserOfflineHandler", 2, "now post offline callback, bid is " + this.a.jdField_a_of_type_JavaLangString + ", mode: " + this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((SwiftBrowserOfflineHandler.CheckOfflineCallback)localIterator.next()).a(this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akwz
 * JD-Core Version:    0.7.0.1
 */