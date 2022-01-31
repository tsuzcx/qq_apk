import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class adgk
  extends akav
{
  private WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  private adgk(adgh paramadgh, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramList, paramBoolean2);
    if ((adgh.a(this.jdField_a_of_type_Adgh, paramList)) && (paramBoolean1)) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      paramList = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("MergeForwardRevokeHelper", 2, "onMsgRevokeNotice  hasMsgRevoked:" + paramBoolean2 + "; isSuccess:" + paramBoolean1);
      }
      if ((paramBoolean2) && (paramList != null))
      {
        if (!this.jdField_a_of_type_Adgh.a) {
          break;
        }
        paramList.finish();
      }
      return;
    }
    if (adgh.a() == paramList)
    {
      adgh.a(this.jdField_a_of_type_Adgh, paramList);
      return;
    }
    paramList.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adgk
 * JD-Core Version:    0.7.0.1
 */