import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class abcv
  implements beuq
{
  public abcv(EditVideoSmartMusicPart.1 param1) {}
  
  public void onResp(bevm parambevm)
  {
    QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + parambevm.c);
    if (abcu.a(this.a.this$0) == null) {
      return;
    }
    try
    {
      QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
      nof.a(abcu.a(this.a.this$0), "/storage/emulated/0/Tencent/MobileQQ/video_story/");
      return;
    }
    catch (IOException parambevm)
    {
      QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + parambevm);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcv
 * JD-Core Version:    0.7.0.1
 */