import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;

class afbn
  extends amsu
{
  afbn(afbj paramafbj) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      paramString = this.a.a.getFaceBitmap(this.a.a.getCurrentAccountUin(), (byte)3, false);
      if ((paramString != null) && (afbj.a(this.a) != null)) {
        afbj.a(this.a).setImageBitmap(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbn
 * JD-Core Version:    0.7.0.1
 */