import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

class aacc
  extends SimpleObserver<asiu>
{
  aacc(aacb paramaacb, aacl paramaacl) {}
  
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
    if ((paramError instanceof AppInfoError)) {}
    for (int i = ((AppInfoError)paramError).type;; i = 0)
    {
      this.jdField_a_of_type_Aacl.a(null, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacc
 * JD-Core Version:    0.7.0.1
 */