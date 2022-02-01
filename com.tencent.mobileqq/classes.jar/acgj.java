import com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment;
import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

class acgj
  extends LbsManagerService.OnLocationChangeListener
{
  acgj(acgi paramacgi, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    paramSosoLbsInfo = GdtDeviceDemoFragment.a(paramSosoLbsInfo);
    GdtDeviceDemoFragment.a(this.a.a, String.format("LbsManagerService.startLocation end errCode:%d %s", new Object[] { Integer.valueOf(paramInt), paramSosoLbsInfo }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgj
 * JD-Core Version:    0.7.0.1
 */