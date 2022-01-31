import com.tencent.mobileqq.ptt.LSRecordPanel;

public class agta
  implements Runnable
{
  public agta(LSRecordPanel paramLSRecordPanel) {}
  
  public void run()
  {
    LSRecordPanel.a(this.a, "亲们，QQ没有使用麦克风权限呢");
    LSRecordPanel.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agta
 * JD-Core Version:    0.7.0.1
 */