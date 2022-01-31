import com.tencent.mobileqq.ptt.LSRecordPanel;

public class agez
  implements Runnable
{
  public agez(LSRecordPanel paramLSRecordPanel) {}
  
  public void run()
  {
    LSRecordPanel.b(this.a, false);
    LSRecordPanel.a(this.a, "亲们，QQ没有使用麦克风权限呢");
    LSRecordPanel.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agez
 * JD-Core Version:    0.7.0.1
 */