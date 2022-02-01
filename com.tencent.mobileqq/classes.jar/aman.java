import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher;
import java.util.concurrent.ConcurrentHashMap;

public class aman
  implements Comparable<aman>
{
  public int a;
  public long a;
  public int b;
  
  public aman(VideoFramesFetcher paramVideoFramesFetcher, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = Math.min(paramInt2, VideoFramesFetcher.a(paramVideoFramesFetcher));
    VideoFramesFetcher.a(paramVideoFramesFetcher).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(aman paramaman)
  {
    return -(int)(this.jdField_a_of_type_Long - paramaman.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aman
 * JD-Core Version:    0.7.0.1
 */