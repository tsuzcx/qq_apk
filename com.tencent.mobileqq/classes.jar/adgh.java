import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class adgh
  extends akat
{
  private WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  private adgh(adge paramadge, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramList, paramBoolean2);
    if ((adge.a(this.jdField_a_of_type_Adge, paramList)) && (paramBoolean1)) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      paramList = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("MergeForwardRevokeHelper", 2, "onMsgRevokeNotice  hasMsgRevoked:" + paramBoolean2 + "; isSuccess:" + paramBoolean1);
      }
      if ((paramBoolean2) && (paramList != null))
      {
        if (!this.jdField_a_of_type_Adge.a) {
          break;
        }
        paramList.finish();
      }
      return;
    }
    if (adge.a() == paramList)
    {
      adge.a(this.jdField_a_of_type_Adge, paramList);
      return;
    }
    paramList.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adgh
 * JD-Core Version:    0.7.0.1
 */