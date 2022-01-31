import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.newfriend.connections.OverlappingImgLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.List;

public class ahoc
  implements bdbc
{
  public ahoc(OverlappingImgLayout paramOverlappingImgLayout) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    do
    {
      return;
      paramInt1 = 0;
      while (paramInt1 < OverlappingImgLayout.a(this.a).length)
      {
        if ((paramInt1 < 3) && (paramString.equals(OverlappingImgLayout.a(this.a)[paramInt1])))
        {
          ((ThemeImageView)OverlappingImgLayout.a(this.a).get(paramInt1)).setImageBitmap(paramBitmap);
          if (QLog.isColorLevel()) {
            QLog.d("OverlappingImgLayout", 2, "mDecodeTaskCompletionListener update");
          }
        }
        paramInt1 += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OverlappingImgLayout", 2, "onDecodeTaskCompleted, uin: " + paramString + ", type: " + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahoc
 * JD-Core Version:    0.7.0.1
 */