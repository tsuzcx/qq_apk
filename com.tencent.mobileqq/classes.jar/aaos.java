import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class aaos
  implements INetEngine.INetEngineListener
{
  public aaos(EditVideoSmartMusicPart.1 param1) {}
  
  public void onResp(NetResp paramNetResp)
  {
    QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + paramNetResp.mHttpCode);
    if (aaor.a(this.a.this$0) == null) {
      return;
    }
    try
    {
      QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
      nwp.a(aaor.a(this.a.this$0), "/storage/emulated/0/Tencent/MobileQQ/video_story/");
      return;
    }
    catch (IOException paramNetResp)
    {
      QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaos
 * JD-Core Version:    0.7.0.1
 */