import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class agfj
  extends anyz
{
  private WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  private agfj(agfg paramagfg, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
    if ((agfg.a(this.jdField_a_of_type_Agfg, paramList)) && (paramBoolean1)) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      paramList = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("MergeForwardRevokeHelper", 2, "onMsgRevokeNotice  hasMsgRevoked:" + paramBoolean2 + "; isSuccess:" + paramBoolean1);
      }
      if ((paramBoolean2) && (paramList != null))
      {
        if (!this.jdField_a_of_type_Agfg.a) {
          break;
        }
        paramList.finish();
      }
      return;
    }
    if (agfg.a() == paramList)
    {
      agfg.a(this.jdField_a_of_type_Agfg, paramList);
      return;
    }
    paramList.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfj
 * JD-Core Version:    0.7.0.1
 */