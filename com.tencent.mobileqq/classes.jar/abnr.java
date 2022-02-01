import android.arch.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import rx.Subscription;
import rx.functions.Action1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"}, k=3, mv={1, 1, 16})
final class abnr<T>
  implements Action1<Long>
{
  abnr(abno paramabno) {}
  
  public final void a(Long paramLong)
  {
    paramLong = this.a;
    abno.a(paramLong, abno.a(paramLong) - 1);
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown subscribe value : " + abno.a(this.a));
    }
    if (abno.a(this.a) <= 0)
    {
      abno.a(this.a, abno.a(this.a));
      abno.b(this.a, (Subscription)null);
    }
    this.a.a().setValue(new abns(1, null, abno.a(this.a), 2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abnr
 * JD-Core Version:    0.7.0.1
 */