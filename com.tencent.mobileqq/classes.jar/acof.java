import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;

public class acof
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public acof(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    String str;
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.a.app;
      paramBitmap = QQAppInterface.getRoundFaceBitmap(paramBitmap);
      localObject = (String)AccountManageActivity.a(this.a).getTag();
      str = (String)AccountManageActivity.b(this.a).getTag();
      if (!paramString.equals(localObject)) {
        break label80;
      }
      AccountManageActivity.a(this.a).setImageBitmap(paramBitmap);
    }
    label80:
    while (!paramString.equals(str)) {
      return;
    }
    AccountManageActivity.b(this.a).setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acof
 * JD-Core Version:    0.7.0.1
 */