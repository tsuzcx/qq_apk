import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public abstract class altk
  implements Runnable
{
  final WeakReference a;
  
  altk(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altk
 * JD-Core Version:    0.7.0.1
 */