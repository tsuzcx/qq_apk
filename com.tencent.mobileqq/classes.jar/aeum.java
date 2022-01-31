import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;
import com.tencent.qphone.base.util.QLog;

public class aeum
  implements Runnable
{
  public aeum(SmallVideoSendFragment paramSmallVideoSendFragment) {}
  
  public void run()
  {
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(SmallVideoSendFragment.a(this.a).b);
    boolean bool1 = localPublishVideoEntry.getBooleanExtra("is_hw_encode", false);
    boolean bool2 = localPublishVideoEntry.isLocalPublish;
    int i = localPublishVideoEntry.getIntExtra("thumb_rotation", 0);
    boolean bool3 = localPublishVideoEntry.getBooleanExtra("has_rotate", false);
    if ((!bool1) || (bool2) || (bool3) || (!TextUtils.isEmpty(localPublishVideoEntry.doodlePath))) {}
    try
    {
      localBitmap1 = BitmapFactory.decodeFile(localPublishVideoEntry.doodlePath);
      localBitmap2 = BitmapUtils.a(localBitmap1, 360 - i);
      if (BitmapUtils.a(localBitmap2, Bitmap.CompressFormat.PNG, 60, localPublishVideoEntry.doodlePath)) {
        localPublishVideoEntry.putExtra("has_rotate", Boolean.valueOf(true));
      }
      localBitmap1.recycle();
      localBitmap2.recycle();
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        Bitmap localBitmap1;
        Bitmap localBitmap2;
        QLog.e("PublishActivity", 1, "OutOfMemoryError:" + localOutOfMemoryError1);
      }
    }
    catch (NullPointerException localNullPointerException1)
    {
      for (;;)
      {
        QLog.e("PublishActivity", 1, "NullPointerException:" + localNullPointerException1);
      }
    }
    if (!TextUtils.isEmpty(localPublishVideoEntry.thumbPath)) {}
    try
    {
      localBitmap1 = BitmapFactory.decodeFile(localPublishVideoEntry.thumbPath);
      localBitmap2 = BitmapUtils.a(localBitmap1, 360 - i);
      if (BitmapUtils.a(localBitmap2, Bitmap.CompressFormat.PNG, 60, localPublishVideoEntry.thumbPath)) {
        localPublishVideoEntry.putExtra("has_rotate", Boolean.valueOf(true));
      }
      localBitmap1.recycle();
      localBitmap2.recycle();
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      for (;;)
      {
        QLog.e("PublishActivity", 1, "OutOfMemoryError:" + localOutOfMemoryError2);
      }
    }
    catch (NullPointerException localNullPointerException2)
    {
      for (;;)
      {
        QLog.e("PublishActivity", 1, "NullPointerException:" + localNullPointerException2);
      }
    }
    new VideoCompositeHelper().a(localPublishVideoEntry, SmallVideoSendFragment.a(this.a).j + ".tmp.mp4", new aeun(this, localPublishVideoEntry));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeum
 * JD-Core Version:    0.7.0.1
 */