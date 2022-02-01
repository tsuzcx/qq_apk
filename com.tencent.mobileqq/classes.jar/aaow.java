import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aaow
  implements aang
{
  aaow(aaor paramaaor) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(anvx.a(2131703351));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    aaor localaaor;
    StringBuilder localStringBuilder;
    if (aaor.a(this.a) != null)
    {
      localaaor = this.a;
      localStringBuilder = new StringBuilder().append(anvx.a(2131703240)).append(aaor.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localaaor.a(i + "\n抽帧字节数：" + aaor.a(this.a).b() + "KB");
      aaor.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaow
 * JD-Core Version:    0.7.0.1
 */