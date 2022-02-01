import com.tencent.common.app.BaseApplicationImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class alkk
  implements alkj
{
  public long a(String paramString)
  {
    return ((Long)bhhr.b(BaseApplicationImpl.getContext(), paramString, "key_newer_guide_banner_close_time", Long.valueOf(0L))).longValue();
  }
  
  public String a(String paramString)
  {
    return (String)bhhr.b(BaseApplicationImpl.getContext(), paramString, "newer_guide_banner_last_preload_time", "");
  }
  
  public void a(String paramString)
  {
    bhhr.a(BaseApplicationImpl.getContext(), paramString, true, "key_newer_guide_banner_close_time", Long.valueOf(0L));
  }
  
  public void b(String paramString)
  {
    bhhr.a(BaseApplicationImpl.getContext(), paramString, true, "key_newer_guide_banner_close_time", Long.valueOf(System.currentTimeMillis()));
  }
  
  public void c(String paramString)
  {
    bhhr.a(BaseApplicationImpl.getContext(), paramString, true, "newer_guide_banner_last_preload_time", new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).format(new Date()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkk
 * JD-Core Version:    0.7.0.1
 */