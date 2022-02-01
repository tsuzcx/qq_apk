import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aayw
  implements aaxg
{
  aayw(aayr paramaayr) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(anni.a(2131702661));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    aayr localaayr;
    StringBuilder localStringBuilder;
    if (aayr.a(this.a) != null)
    {
      localaayr = this.a;
      localStringBuilder = new StringBuilder().append(anni.a(2131702547)).append(aayr.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localaayr.a(i + "\n抽帧字节数：" + aayr.a(this.a).b() + "KB");
      aayr.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aayw
 * JD-Core Version:    0.7.0.1
 */