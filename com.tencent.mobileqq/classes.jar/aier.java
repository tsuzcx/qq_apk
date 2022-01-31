import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

public final class aier
  extends SimpleObserver
{
  public aier(aies paramaies) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    QLog.d("tribe_publish_TakeVideoHelper", 4, "generate video manifest success.");
    this.a.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    QLog.d("tribe_publish_TakeVideoHelper", 4, "generate video manifest failed.");
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aier
 * JD-Core Version:    0.7.0.1
 */