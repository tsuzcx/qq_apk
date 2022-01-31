import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;

class acwo
  extends ajxj
{
  acwo(acwl paramacwl) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      paramString = this.a.a.a(this.a.a.getCurrentAccountUin(), (byte)3, false);
      if ((paramString != null) && (acwl.a(this.a) != null)) {
        acwl.a(this.a).setImageBitmap(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwo
 * JD-Core Version:    0.7.0.1
 */