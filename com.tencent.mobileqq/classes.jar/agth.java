import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean;
import com.tencent.qphone.base.util.QLog;

public class agth
  extends agsz<SpringFestivalRedpakcetPreviewConfBean>
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
  
  protected SpringFestivalRedpakcetPreviewConfBean a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      paramArrayOfalzs = paramArrayOfalzs[0].a;
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringFestivalRedpacketPreviewProcessor", 2, "onParsed " + paramArrayOfalzs);
      }
      return SpringFestivalRedpakcetPreviewConfBean.a(paramArrayOfalzs);
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
  public SpringFestivalRedpakcetPreviewConfBean b(alzs[] paramArrayOfalzs)
  {
    return (SpringFestivalRedpakcetPreviewConfBean)super.b(paramArrayOfalzs);
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
 * Qualified Name:     agth
 * JD-Core Version:    0.7.0.1
 */