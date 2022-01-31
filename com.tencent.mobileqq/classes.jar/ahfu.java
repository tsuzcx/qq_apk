import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean;
import com.tencent.qphone.base.util.QLog;

public class ahfu
  extends ahfm<SpringFestivalRedpakcetPreviewConfBean>
{
  public int a()
  {
    return 548;
  }
  
  @NonNull
  public SpringFestivalRedpakcetPreviewConfBean a(int paramInt)
  {
    return new SpringFestivalRedpakcetPreviewConfBean();
  }
  
  protected SpringFestivalRedpakcetPreviewConfBean a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      paramArrayOfamph = paramArrayOfamph[0].a;
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringFestivalRedpacketPreviewProcessor", 2, "onParsed " + paramArrayOfamph);
      }
      return SpringFestivalRedpakcetPreviewConfBean.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<SpringFestivalRedpakcetPreviewConfBean> a()
  {
    return SpringFestivalRedpakcetPreviewConfBean.class;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(SpringFestivalRedpakcetPreviewConfBean paramSpringFestivalRedpakcetPreviewConfBean)
  {
    super.a(paramSpringFestivalRedpakcetPreviewConfBean);
  }
  
  public int b()
  {
    return 0;
  }
  
  @Nullable
  public SpringFestivalRedpakcetPreviewConfBean b(amph[] paramArrayOfamph)
  {
    return (SpringFestivalRedpakcetPreviewConfBean)super.b(paramArrayOfamph);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfu
 * JD-Core Version:    0.7.0.1
 */