import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;

class adkg
  extends ajxj
{
  adkg(adke paramadke) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      paramString = this.a.a.a(this.a.a.getCurrentAccountUin(), (byte)3, false);
      if ((paramString != null) && (adke.a(this.a) != null)) {
        adke.a(this.a).setImageBitmap(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkg
 * JD-Core Version:    0.7.0.1
 */