import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;
import java.util.Hashtable;

public class aadv
{
  private static final Hashtable<String, Typeface> a = new Hashtable();
  
  public static void a(Paint paramPaint, String paramString)
  {
    synchronized (a)
    {
      if (!a.containsKey(paramString))
      {
        aaae.a(uyk.a()).a(paramString, new aadx(paramString, paramPaint));
        return;
      }
      paramPaint.setTypeface((Typeface)a.get(paramString));
    }
  }
  
  public static void a(Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramPaint, "https://downv6.qq.com/video_story/qcircle/ttf/qcircle_number_bold_italic.ttf");
      return;
    }
    a(paramPaint, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf");
  }
  
  public static void a(TextView paramTextView, String paramString)
  {
    synchronized (a)
    {
      if (!a.containsKey(paramString))
      {
        aaae.a(uyk.a()).a(paramString, new aadw(paramString, paramTextView));
        return;
      }
      paramTextView.setTypeface((Typeface)a.get(paramString));
    }
  }
  
  public static void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramTextView, "https://downv6.qq.com/video_story/qcircle/ttf/qcircle_number_bold_italic.ttf");
      return;
    }
    a(paramTextView, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf");
  }
  
  public static void a(String paramString)
  {
    synchronized (a)
    {
      if (!a.containsKey(paramString)) {
        aaae.a(uyk.a()).a(paramString, new aady(paramString));
      }
      return;
    }
  }
  
  public static void b(Paint paramPaint, String paramString)
  {
    a(paramPaint, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadv
 * JD-Core Version:    0.7.0.1
 */