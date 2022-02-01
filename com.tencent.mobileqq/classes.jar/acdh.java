import android.arch.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import rx.Subscription;
import rx.functions.Action1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"}, k=3, mv={1, 1, 16})
final class acdh<T>
  implements Action1<Long>
{
  acdh(acde paramacde) {}
  
  public final void a(Long paramLong)
  {
    paramLong = this.a;
    acde.a(paramLong, acde.a(paramLong) - 1);
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown subscribe value : " + acde.a(this.a));
    }
    if (acde.a(this.a) <= 0)
    {
      acde.a(this.a, acde.a(this.a));
      acde.b(this.a, (Subscription)null);
    }
    this.a.a().setValue(new acdi(1, null, acde.a(this.a), 2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdh
 * JD-Core Version:    0.7.0.1
 */