import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

class ackh
  extends SimpleObserver<avro>
{
  ackh(ackg paramackg, ackq paramackq) {}
  
  public void a(avro paramavro)
  {
    ackq localackq = this.jdField_a_of_type_Ackq;
    if (paramavro.c == 1) {}
    for (int i = 2;; i = 3)
    {
      localackq.a(paramavro, i);
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
      this.jdField_a_of_type_Ackq.a(null, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackh
 * JD-Core Version:    0.7.0.1
 */