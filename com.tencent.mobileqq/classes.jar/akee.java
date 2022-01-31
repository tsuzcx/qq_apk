import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.tencent.qphone.base.util.QLog;

public class akee
  extends Resources
{
  private akei a;
  
  public akee(akei paramakei)
  {
    super(paramakei.b().getAssets(), paramakei.b().getDisplayMetrics(), paramakei.b().getConfiguration());
    this.a = paramakei;
  }
  
  public CharSequence getText(int paramInt)
  {
    int i = this.a.a(paramInt);
    try
    {
      CharSequence localCharSequence = this.a.a().getText(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiLanguageEngine", 4, new Object[] { "getText delegate:", Integer.valueOf(paramInt), " ,langId:", Integer.valueOf(i), " ,content:" + localCharSequence });
      }
      return localCharSequence;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return this.a.b().getText(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akee
 * JD-Core Version:    0.7.0.1
 */