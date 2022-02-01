import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class allz
  implements allu
{
  @Nullable
  private allw jdField_a_of_type_Allw;
  @NonNull
  private final PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  @NonNull
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public allz(@NonNull PendingIntent paramPendingIntent, @NonNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidAppPendingIntent = paramPendingIntent;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a(@Nullable allw paramallw)
  {
    this.jdField_a_of_type_Allw = paramallw;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_Allw == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    aljw.a(localQQAppInterface, this.jdField_a_of_type_Allw);
  }
  
  public void onEnter()
  {
    if (this.jdField_a_of_type_Allw == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    try
    {
      this.jdField_a_of_type_AndroidAppPendingIntent.send();
      aljw.a(localQQAppInterface, this.jdField_a_of_type_Allw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allz
 * JD-Core Version:    0.7.0.1
 */