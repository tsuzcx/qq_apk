import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class adin
  implements aobv
{
  public adin(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    String str2;
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramBitmap = this.a.app.a(paramBitmap);
      String str1 = (String)AccountManageActivity.a(this.a).getTag();
      str2 = (String)AccountManageActivity.b(this.a).getTag();
      if (!paramString.equals(str1)) {
        break label78;
      }
      AccountManageActivity.a(this.a).setImageBitmap(paramBitmap);
    }
    label78:
    while (!paramString.equals(str2)) {
      return;
    }
    AccountManageActivity.b(this.a).setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adin
 * JD-Core Version:    0.7.0.1
 */