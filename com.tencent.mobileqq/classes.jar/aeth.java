import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.musicgene.BitmapOptionUtil;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class aeth
  implements DownloadParams.DecodeHandler
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  
  public aeth(MusicPlayerActivity paramMusicPlayerActivity, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMusicPlayerActivity);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    Object localObject = (MusicPlayerActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramBitmap != null) && (localObject != null))
    {
      paramDownloadParams = BitmapOptionUtil.a(Bitmap.createBitmap(paramBitmap, 0, paramBitmap.getHeight() / 2, paramBitmap.getWidth(), paramBitmap.getHeight() / 2));
      localObject = Message.obtain(MusicPlayerActivity.a((MusicPlayerActivity)localObject), 49);
      Bundle localBundle = new Bundle();
      localBundle.putIntArray("KEY_COLOR_LIST", paramDownloadParams);
      localBundle.putBoolean("KEY_MATCH_SONG", this.jdField_a_of_type_Boolean);
      ((Message)localObject).setData(localBundle);
      ((Message)localObject).sendToTarget();
      if ((paramDownloadParams != null) && (paramDownloadParams.length >= 2))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(Integer.valueOf(paramDownloadParams[0]));
        ((ArrayList)localObject).add(Integer.valueOf(paramDownloadParams[1]));
        MusicPlayerActivity.c().put(this.jdField_a_of_type_JavaLangString, localObject);
      }
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeth
 * JD-Core Version:    0.7.0.1
 */