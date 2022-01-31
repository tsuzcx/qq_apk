import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgr;

public class aglm
  implements Runnable
{
  private agll jdField_a_of_type_Agll;
  
  public aglm(PresendPicMgr paramPresendPicMgr, agll paramagll)
  {
    this.jdField_a_of_type_Agll = paramagll;
  }
  
  public void run()
  {
    Logger.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.jdField_a_of_type_Agll);
    this.jdField_a_of_type_Agll.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aglm
 * JD-Core Version:    0.7.0.1
 */