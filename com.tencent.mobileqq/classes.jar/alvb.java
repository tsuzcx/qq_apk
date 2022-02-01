import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.widget.QQToast;

public class alvb
  implements alwc
{
  public alvb(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (this.a.r == 10011)
    {
      NewFlowCameraActivity.a(this.a, paramString1);
      return;
    }
    if (paramBoolean)
    {
      NewFlowCameraActivity.b(this.a, paramString1);
      return;
    }
    this.a.i(true);
    QQToast.a(this.a, anzj.a(2131706370), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvb
 * JD-Core Version:    0.7.0.1
 */