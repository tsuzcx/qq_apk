import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.Properties;

public class ahuz
{
  public static void a(String paramString, Properties paramProperties)
  {
    bcdu.a(VideoEnvironment.getContext()).reportKVEvent(paramString, paramProperties);
  }
  
  public static void a(String paramString, Properties paramProperties, int paramInt)
  {
    bcdu.a(VideoEnvironment.getContext()).reportTimeKVEvent(paramString, paramProperties, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuz
 * JD-Core Version:    0.7.0.1
 */