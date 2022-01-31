import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class aczv
  extends AsyncTask<String, Void, Bitmap>
{
  public aczv(VoicePrintUtils.VoicePrintView paramVoicePrintView) {}
  
  protected Bitmap a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (BaseApplicationImpl.sImageCache.get(paramVarArgs) == null)
    {
      Bitmap localBitmap = BubbleManager.a(paramVarArgs, this.a.a);
      if (QLog.isColorLevel()) {
        QLog.d("VoicePrintUtils.DecodePngTask", 2, "decode " + paramVarArgs + "in background.");
      }
      BaseApplicationImpl.sImageCache.put(paramVarArgs, localBitmap);
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    VoicePrintUtils.VoicePrintView.a(this.a);
    this.a.setImageDrawable(VoicePrintUtils.VoicePrintView.a(this.a));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aczv
 * JD-Core Version:    0.7.0.1
 */