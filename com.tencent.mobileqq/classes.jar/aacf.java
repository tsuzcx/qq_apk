import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment.UrlNotauthorizedError;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

class aacf
  extends SimpleObserver<asiu>
{
  aacf(aacb paramaacb, aacl paramaacl) {}
  
  public void a(asiu paramasiu)
  {
    aacl localaacl = this.jdField_a_of_type_Aacl;
    if (paramasiu.c == 1) {}
    for (int i = 2;; i = 3)
    {
      localaacl.a(paramasiu, i);
      return;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.permissionHelper", 2, "onError: " + paramError.getMessage());
    }
    int i;
    if ((paramError instanceof VerifyUrlJobSegment.UrlNotauthorizedError)) {
      i = 4;
    }
    for (;;)
    {
      this.jdField_a_of_type_Aacl.a(null, i);
      return;
      if ((paramError instanceof AppInfoError)) {
        i = ((AppInfoError)paramError).type;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacf
 * JD-Core Version:    0.7.0.1
 */