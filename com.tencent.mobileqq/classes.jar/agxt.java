import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;

class agxt
  extends anyu
{
  agxt(agxr paramagxr) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      paramString = this.a.a.a(this.a.a.getCurrentAccountUin(), (byte)3, false);
      if ((paramString != null) && (agxr.a(this.a) != null)) {
        agxr.a(this.a).setImageBitmap(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxt
 * JD-Core Version:    0.7.0.1
 */