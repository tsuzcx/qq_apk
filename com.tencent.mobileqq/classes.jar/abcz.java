import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class abcz
  implements abbj
{
  abcz(abcu paramabcu) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(anzj.a(2131702768));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    abcu localabcu;
    StringBuilder localStringBuilder;
    if (abcu.a(this.a) != null)
    {
      localabcu = this.a;
      localStringBuilder = new StringBuilder().append(anzj.a(2131702654)).append(abcu.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localabcu.a(i + "\n抽帧字节数：" + abcu.a(this.a).b() + "KB");
      abcu.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcz
 * JD-Core Version:    0.7.0.1
 */