import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ahmd
  implements ahly
{
  @Nullable
  private ahma jdField_a_of_type_Ahma;
  @NonNull
  private final PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  @NonNull
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ahmd(@NonNull PendingIntent paramPendingIntent, @NonNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidAppPendingIntent = paramPendingIntent;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a(@Nullable ahma paramahma)
  {
    this.jdField_a_of_type_Ahma = paramahma;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_Ahma == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    ahkd.a(localQQAppInterface, this.jdField_a_of_type_Ahma);
  }
  
  public void onEnter()
  {
    if (this.jdField_a_of_type_Ahma == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    try
    {
      this.jdField_a_of_type_AndroidAppPendingIntent.send();
      ahkd.a(localQQAppInterface, this.jdField_a_of_type_Ahma);
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;)
      {
        QLog.e("Q.recent.banner", 1, "send pending intent fail with " + this.jdField_a_of_type_AndroidAppPendingIntent + "\r\n" + localCanceledException);
      }
    }
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmd
 * JD-Core Version:    0.7.0.1
 */