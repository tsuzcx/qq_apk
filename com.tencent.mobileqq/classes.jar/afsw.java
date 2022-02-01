import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView;
import com.tencent.mobileqq.app.QQAppInterface;

class afsw
  extends anvi
{
  afsw(afsv paramafsv) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      Bitmap localBitmap = this.a.a.getFaceBitmap(this.a.a.getCurrentAccountUin(), (byte)3, false);
      if (localBitmap != null) {
        afsv.a(this.a).a(localBitmap, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsw
 * JD-Core Version:    0.7.0.1
 */