import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ajqz
  extends akfx
{
  ajqz(ajqy paramajqy, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QLog.d("RedpointHandler", 1, "onLocationFinish errCode:" + paramInt + ",info:" + paramSosoLbsInfo);
    ajqy.a(this.a, paramInt, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqz
 * JD-Core Version:    0.7.0.1
 */