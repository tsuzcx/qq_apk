import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever;
import java.util.concurrent.ConcurrentHashMap;

public class amao
  implements Comparable<amao>
{
  public int a;
  public long a;
  public int b;
  
  public amao(VideoFramesRetriever paramVideoFramesRetriever, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = Math.min(paramInt2, VideoFramesRetriever.a(paramVideoFramesRetriever));
    VideoFramesRetriever.a(paramVideoFramesRetriever).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(amao paramamao)
  {
    return -(int)(this.jdField_a_of_type_Long - paramamao.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amao
 * JD-Core Version:    0.7.0.1
 */