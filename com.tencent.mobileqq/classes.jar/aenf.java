import android.app.Activity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

public class aenf
  implements aeng
{
  private aeob jdField_a_of_type_Aeob;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public aenf(QQAppInterface paramQQAppInterface, aeob paramaeob, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Aeob = paramaeob;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Iterator localIterator = paramQQAppInterface.a().b(paramString, 0).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.msgtype == -1026) {
        paramQQAppInterface.a().a(paramString, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = ((ajjj)paramQQAppInterface.getManager(51)).e(paramSessionInfo.jdField_a_of_type_JavaLangString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.gathtertype == 1);
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    Iterator localIterator = paramQQAppInterface.a().b(paramString, 0).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.msgtype == -1027) {
        paramQQAppInterface.a().a(paramString, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      }
    }
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    int i = ((Integer)paramVarArgs[0]).intValue();
    paramVarArgs = null;
    if (i == 1)
    {
      paramVarArgs = awbi.a(-1026);
      l = awao.a();
      paramVarArgs.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", l, -1026, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
      paramVarArgs.isread = true;
    }
    while (i != 2) {
      return paramVarArgs;
    }
    paramVarArgs = awbi.a(-1027);
    long l = awao.a();
    paramVarArgs.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", l, -1027, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aeob.a(this, new Object[] { Integer.valueOf(paramInt) }))
    {
      if (paramInt != 1) {
        break label60;
      }
      this.jdField_a_of_type_Boolean = true;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C56", "0X8004C56", 0, 0, "", "", "", "");
    }
    label60:
    while (paramInt != 2) {
      return;
    }
    this.b = true;
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C57", "0X8004C57", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 1000) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!this.jdField_a_of_type_Boolean) && (!this.b)) {
      a(1);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 1003;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1) {
      if (this.jdField_a_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    while ((paramInt != 2) || (!this.b)) {
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    this.b = false;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenf
 * JD-Core Version:    0.7.0.1
 */