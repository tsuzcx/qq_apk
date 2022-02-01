import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URL;

public abstract interface aiit
  extends aiis
{
  public abstract URLDrawable.URLDrawableOptions a();
  
  public abstract URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions);
  
  public abstract String a();
  
  public abstract URL a();
  
  public abstract void a(QQAppInterface paramQQAppInterface, int paramInt);
  
  public abstract void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo);
  
  public abstract boolean a();
  
  public abstract String b();
  
  public abstract boolean b();
  
  public abstract String c();
  
  public abstract boolean c();
  
  public abstract String d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiit
 * JD-Core Version:    0.7.0.1
 */