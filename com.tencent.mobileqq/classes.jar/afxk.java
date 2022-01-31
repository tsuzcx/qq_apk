import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgr;

public class afxk
  implements Runnable
{
  private afxj jdField_a_of_type_Afxj;
  
  public afxk(PresendPicMgr paramPresendPicMgr, afxj paramafxj)
  {
    this.jdField_a_of_type_Afxj = paramafxj;
  }
  
  public void run()
  {
    Logger.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.jdField_a_of_type_Afxj);
    this.jdField_a_of_type_Afxj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afxk
 * JD-Core Version:    0.7.0.1
 */