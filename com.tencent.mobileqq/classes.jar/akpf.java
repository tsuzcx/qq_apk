import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class akpf
  extends akpg
{
  public akpf(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    this.jdField_a_of_type_JavaLangString = ajsf.A;
    this.jdField_a_of_type_Int = 6003;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord != null)
    {
      paramDataLineMsgRecord.selfuin = this.jdField_a_of_type_JavaLangString;
      paramDataLineMsgRecord.frienduin = paramDataLineMsgRecord.selfuin;
      paramDataLineMsgRecord.senderuin = paramDataLineMsgRecord.selfuin;
      paramDataLineMsgRecord.istroop = this.jdField_a_of_type_Int;
      paramDataLineMsgRecord.dataline_type = 1;
    }
    return super.a(paramDataLineMsgRecord, paramBoolean);
  }
  
  protected aksz a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
  }
  
  protected void a()
  {
    ((ajuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akpf
 * JD-Core Version:    0.7.0.1
 */