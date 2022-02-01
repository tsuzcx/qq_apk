import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aimy
  extends anqd
{
  aimy(aimx paramaimx) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramList, paramBoolean2);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.AIOUpComingMsgHelper", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    if ((paramBoolean1) && (paramList != null) && (!paramList.isEmpty())) {
      aimx.a(this.a, (MessageRecord)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimy
 * JD-Core Version:    0.7.0.1
 */