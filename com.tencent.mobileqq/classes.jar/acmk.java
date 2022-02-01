import android.content.Context;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;
import java.lang.ref.WeakReference;

final class acmk
  implements ArkViewImplement.LoadCallback
{
  acmk(long paramLong, String paramString, WeakReference paramWeakReference1, WeakReference paramWeakReference2, GdtInterstitialParams paramGdtInterstitialParams) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    int i = aclx.a(paramInt2);
    if (i == 0) {
      i = 1;
    }
    for (;;)
    {
      acqy.b("GdtInterstitialView", String.format("onLoadFailed state:%d duration:%d errCode:%d msg:%s canRetry:%b error:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(i) }));
      acmj.a(i, paramInt2, this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d))
      {
        ((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d = true;
        acrl.b((Context)this.b.get(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, (GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get(), i, paramInt2);
      }
      return;
    }
  }
  
  public void onLoadState(int paramInt)
  {
    acqy.b("GdtInterstitialView", String.format("onLoadState state:%d duration:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) }));
    if (paramInt == 1) {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d))
      {
        ((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d = true;
        ((GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c = true;
        acrl.b((Context)this.b.get(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, (GdtInterstitialStatus)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0, -2147483648);
      }
    }
    while (paramInt != -1) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmk
 * JD-Core Version:    0.7.0.1
 */