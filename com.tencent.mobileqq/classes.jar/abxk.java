import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class abxk
  implements abws
{
  private final abwe a;
  
  public abxk(abwe paramabwe)
  {
    this.a = paramabwe;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).f(paramString, paramInt1);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.resultMsgList = null;
      this.a.a(paramRefreshMessageContext, paramInt1);
    }
    long l;
    do
    {
      return;
      if (localObject != null) {
        this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.dumpmsgs("current Aio", ((List)localObject).subList(0, Math.min(15, ((List)localObject).size())));
      }
      l = ((MessageRecord)((List)localObject).get(0)).uniseq;
      localObject = new ArrayList();
      paramRefreshMessageContext.isLocalOnly = true;
    } while (!paramRefreshMessageContext.isLocalOnly);
    this.a.a(paramString, paramInt1, l, paramInt2, paramRefreshMessageContext, (ArrayList)localObject);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1, (List)localObject);
    paramRefreshMessageContext.resultMsgList = ((List)localObject);
    if (ugf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))
    {
      if ((paramRefreshMessageContext.resultMsgList == null) || (paramRefreshMessageContext.resultMsgList.size() == 0))
      {
        l = ocw.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        ((PublicAccountHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(11)).a(paramString, l, 1);
        bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X8005C99", "0X8005C99", 0, 1, 0, "new", "2", "", "");
        return;
      }
      paramRefreshMessageContext.isComplete = false;
      paramRefreshMessageContext.isSuccess = false;
    }
    paramString = this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
    StringBuilder localStringBuilder = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramRefreshMessageContext).append(", size = ");
    if (localObject == null) {}
    for (paramInt1 = -1;; paramInt1 = ((ArrayList)localObject).size())
    {
      paramString.qLogColor(paramInt1, ", timestamp = " + System.currentTimeMillis());
      this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxk
 * JD-Core Version:    0.7.0.1
 */