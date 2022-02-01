import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class aays
  implements bdvw
{
  public aays(EditVideoSmartMusicPart.1 param1) {}
  
  public void onResp(bdwt parambdwt)
  {
    QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + parambdwt.c);
    if (aayr.a(this.a.this$0) == null) {
      return;
    }
    try
    {
      QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
      nmk.a(aayr.a(this.a.this$0), "/storage/emulated/0/Tencent/MobileQQ/video_story/");
      return;
    }
    catch (IOException parambdwt)
    {
      QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + parambdwt);
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aays
 * JD-Core Version:    0.7.0.1
 */