import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import java.lang.ref.WeakReference;

public class ajnv
  extends AsyncTask
{
  private WeakReference a;
  
  public ajnv(RollangleImageView paramRollangleImageView)
  {
    this.a = new WeakReference(paramRollangleImageView);
  }
  
  protected Bitmap a(Boolean... paramVarArgs)
  {
    RollangleImageView localRollangleImageView = (RollangleImageView)this.a.get();
    if (localRollangleImageView != null) {
      return RollangleImageView.a(localRollangleImageView, paramVarArgs[0].booleanValue());
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    RollangleImageView localRollangleImageView = (RollangleImageView)this.a.get();
    if (localRollangleImageView != null)
    {
      if (paramBitmap != null) {
        localRollangleImageView.setImageBitmap(paramBitmap);
      }
    }
    else {
      return;
    }
    localRollangleImageView.setImageResource(FileManagerUtil.b(localRollangleImageView.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnv
 * JD-Core Version:    0.7.0.1
 */