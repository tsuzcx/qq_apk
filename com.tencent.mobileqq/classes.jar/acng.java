import android.arch.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import rx.Subscription;
import rx.functions.Action1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"}, k=3, mv={1, 1, 16})
final class acng<T>
  implements Action1<Long>
{
  acng(acnd paramacnd) {}
  
  public final void a(Long paramLong)
  {
    paramLong = this.a;
    acnd.a(paramLong, acnd.a(paramLong) - 1);
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown subscribe value : " + acnd.a(this.a));
    }
    if (acnd.a(this.a) <= 0)
    {
      acnd.a(this.a, acnd.a(this.a));
      acnd.b(this.a, (Subscription)null);
    }
    this.a.a().setValue(new acnh(1, null, acnd.a(this.a), 2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acng
 * JD-Core Version:    0.7.0.1
 */