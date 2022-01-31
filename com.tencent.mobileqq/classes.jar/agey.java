import com.tencent.mobileqq.ptt.LSRecordPanel;

public class agey
  implements Runnable
{
  public agey(LSRecordPanel paramLSRecordPanel) {}
  
  public void run()
  {
    LSRecordPanel.a(this.a, "亲们，QQ没有使用麦克风权限呢");
    LSRecordPanel.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agey
 * JD-Core Version:    0.7.0.1
 */