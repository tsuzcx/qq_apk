import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import mqq.app.QQPermissionCallback;

public class aetk
  implements QQPermissionCallback
{
  public aetk(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetk
 * JD-Core Version:    0.7.0.1
 */