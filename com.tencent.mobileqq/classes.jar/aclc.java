import android.content.Context;
import com.tencent.ad.tangram.settings.AdSettingsUtil.a;
import java.lang.ref.WeakReference;

class aclc
  implements AdSettingsUtil.a
{
  private aclc(aclb paramaclb) {}
  
  public void onUpdated(WeakReference<Context> paramWeakReference, boolean paramBoolean)
  {
    if (paramBoolean) {
      aclb.b(this.a, paramWeakReference);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclc
 * JD-Core Version:    0.7.0.1
 */