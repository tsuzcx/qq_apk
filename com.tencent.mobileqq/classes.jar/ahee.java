import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class ahee
  extends ameq
{
  ahee(ahec paramahec) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    ahec.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_Bety == null) || (!this.a.jdField_a_of_type_Bety.isShowing()))
    {
      QLog.e("SeparateForward", 1, new Object[] { "onBatchTroopCardDefaultNick timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
      return;
    }
    if (this.a.jdField_a_of_type_Bety != null) {
      this.a.jdField_a_of_type_Bety.dismiss();
    }
    aupg.a().b.clear();
    if ((paramBoolean) && (paramObject != null))
    {
      aupg.a().b.putAll((Map)paramObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + paramObject);
      }
    }
    for (;;)
    {
      if (aupg.a().b.size() != 0) {
        break label201;
      }
      paramObject = (BaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramObject == null) {
        break;
      }
      QQToast.a(paramObject, 2131698785, 0).b(paramObject.getTitleBarHeight());
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
      }
    }
    label201:
    this.a.a((Map)paramObject, aupg.a().a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahee
 * JD-Core Version:    0.7.0.1
 */