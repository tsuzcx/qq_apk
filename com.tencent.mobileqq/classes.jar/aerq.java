import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class aerq
  extends ajuc
{
  aerq(aero paramaero) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    aero.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_Bbms == null) || (!this.a.jdField_a_of_type_Bbms.isShowing()))
    {
      QLog.e("SeparateForward", 1, new Object[] { "onBatchTroopCardDefaultNick timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
      return;
    }
    if (this.a.jdField_a_of_type_Bbms != null) {
      this.a.jdField_a_of_type_Bbms.dismiss();
    }
    arxu.a().b.clear();
    if ((paramBoolean) && (paramObject != null))
    {
      arxu.a().b.putAll((Map)paramObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + paramObject);
      }
    }
    for (;;)
    {
      if (arxu.a().b.size() != 0) {
        break label201;
      }
      paramObject = (BaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramObject == null) {
        break;
      }
      bbmy.a(paramObject, 2131632732, 0).b(paramObject.getTitleBarHeight());
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
      }
    }
    label201:
    this.a.a((Map)paramObject, arxu.a().a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aerq
 * JD-Core Version:    0.7.0.1
 */