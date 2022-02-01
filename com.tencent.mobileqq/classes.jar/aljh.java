import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class aljh
  implements WtTicketPromise
{
  aljh(aljb paramaljb, alji paramalji) {}
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._sig != null) && (paramTicket._sig.length != 0))
    {
      paramTicket = new String(paramTicket._sig);
      this.jdField_a_of_type_Alji.a(paramTicket);
      return;
    }
    this.jdField_a_of_type_Aljb.c("get skey is null");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    this.jdField_a_of_type_Aljb.c("get skey failed");
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    this.jdField_a_of_type_Aljb.c("get skey time out");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljh
 * JD-Core Version:    0.7.0.1
 */