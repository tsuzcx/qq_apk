import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import com.tencent.qapmsdk.dropframe.IDropFrameListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class acih
  extends achx
  implements achn, IDropFrameListener
{
  public void a(String paramString)
  {
    if (e()) {
      QAPM.beginScene(paramString, QAPM.ModeDropFrame);
    }
  }
  
  protected void b()
  {
    com.tencent.qapmsdk.dropframe.DropFrameMonitor.setDropFrameListener(this);
  }
  
  public void b(String paramString)
  {
    if (e()) {
      QAPM.endScene(paramString, QAPM.ModeDropFrame);
    }
  }
  
  public String c()
  {
    return "dropframe";
  }
  
  public void onMetaGet(DropFrameResultMeta paramDropFrameResultMeta)
  {
    com.tencent.mfsdk.collector.DropFrameMonitor.uploadDropFrameToDenta(paramDropFrameResultMeta.scene, (paramDropFrameResultMeta.duration / 1000000.0F), paramDropFrameResultMeta.dropCount, paramDropFrameResultMeta.dropIntervals);
    if (QLog.isColorLevel())
    {
      double d1 = paramDropFrameResultMeta.dropIntervals[0];
      double d2 = paramDropFrameResultMeta.dropIntervals[1];
      double d3 = paramDropFrameResultMeta.dropIntervals[2];
      double d4 = paramDropFrameResultMeta.dropIntervals[3];
      long l = (paramDropFrameResultMeta.duration / 1000000.0F);
      d1 = (16.699999999999999D * d1 + 25.049999999999997D * d2 + 50.099999999999994D * d3 + 100.19999999999999D * d4) / l;
      QLog.i("MagnifierSDK.QAPM", 2, "DropFrameQAPM " + d1 + " 时间 " + l + " 分布 " + Arrays.toString(paramDropFrameResultMeta.dropIntervals));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acih
 * JD-Core Version:    0.7.0.1
 */