import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;

class aftd
  implements FaceDecoder.DecodeTaskCompletionListener
{
  aftd(afsv paramafsv) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    do
    {
      return;
      afsv.a(this.a).a(paramBitmap, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, "onDecodeTaskCompleted, uin: " + paramString + ", type: " + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftd
 * JD-Core Version:    0.7.0.1
 */