import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

public class adlt
  implements Runnable
{
  public adlt(ForwardSdkShareOption paramForwardSdkShareOption, AbsStructMsg paramAbsStructMsg, String paramString, int paramInt) {}
  
  public void run()
  {
    StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkShareOption.a, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adlt
 * JD-Core Version:    0.7.0.1
 */