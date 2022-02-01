import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;

class agiu
  extends anyu
{
  agiu(agiq paramagiq) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      paramString = this.a.a.a(this.a.a.getCurrentAccountUin(), (byte)3, false);
      if ((paramString != null) && (agiq.a(this.a) != null)) {
        agiq.a(this.a).setImageBitmap(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agiu
 * JD-Core Version:    0.7.0.1
 */