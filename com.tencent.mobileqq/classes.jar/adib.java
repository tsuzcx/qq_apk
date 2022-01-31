import android.content.Context;
import android.graphics.Paint;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;

public class adib
  implements adie
{
  private Paint a;
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8008C70", "0X8008C70", aezl.a(paramInt), 0, "", "", "", "");
    paramString = aqxj.a(paramString);
    if ((paramString != null) && (paramString.length() > 20))
    {
      bcql.a(paramContext, ajya.a(2131705468), 0).a();
      axqy.b(paramQQAppInterface, "dc00898", "", "", "0X800932C", "0X800932C", 0, 0, "", "", "", "");
      return false;
    }
    return true;
  }
  
  public boolean a(Context paramContext, String paramString, EditText paramEditText)
  {
    if (this.a == null) {
      this.a = new Paint();
    }
    this.a.setTypeface(paramEditText.getTypeface());
    this.a.setTextSize(paramEditText.getTextSize());
    return (paramString.length() < 200) && (!paramString.contains("\n")) && ((int)this.a.measureText(paramString) + actj.a(45.0F, paramContext.getResources()) + paramEditText.getPaddingLeft() < paramEditText.getMeasuredWidth());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adib
 * JD-Core Version:    0.7.0.1
 */