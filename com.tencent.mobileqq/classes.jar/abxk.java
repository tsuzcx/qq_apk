import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

class abxk
  extends SimpleObserver<auef>
{
  abxk(abxj paramabxj, abxt paramabxt) {}
  
  public void a(auef paramauef)
  {
    abxt localabxt = this.jdField_a_of_type_Abxt;
    if (paramauef.c == 1) {}
    for (int i = 2;; i = 3)
    {
      localabxt.a(paramauef, i);
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
      this.jdField_a_of_type_Abxt.a(null, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxk
 * JD-Core Version:    0.7.0.1
 */