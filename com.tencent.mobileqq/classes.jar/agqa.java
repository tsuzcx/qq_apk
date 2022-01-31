import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgr;

public class agqa
  implements Runnable
{
  private agpz jdField_a_of_type_Agpz;
  
  public agqa(PresendPicMgr paramPresendPicMgr, agpz paramagpz)
  {
    this.jdField_a_of_type_Agpz = paramagpz;
  }
  
  public void run()
  {
    Logger.a("PresendPicMgr", "PresendRunnable.run", "PresendReq is " + this.jdField_a_of_type_Agpz);
    this.jdField_a_of_type_Agpz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agqa
 * JD-Core Version:    0.7.0.1
 */