import android.content.Context;
import android.graphics.Paint;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class afew
  implements afez
{
  private Paint a;
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    azqs.b(paramQQAppInterface, "dc00898", "", "", "0X8008C70", "0X8008C70", ahbf.a(paramInt), 0, "", "", "", "");
    paramString = assg.a(paramString);
    if ((paramString != null) && (paramString.length() > 20))
    {
      QQToast.a(paramContext, alud.a(2131705852), 0).a();
      azqs.b(paramQQAppInterface, "dc00898", "", "", "0X800932C", "0X800932C", 0, 0, "", "", "", "");
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
    return (paramString.length() < 200) && (!paramString.contains("\n")) && ((int)this.a.measureText(paramString) + aepi.a(45.0F, paramContext.getResources()) + paramEditText.getPaddingLeft() < paramEditText.getMeasuredWidth());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afew
 * JD-Core Version:    0.7.0.1
 */