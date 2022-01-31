import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import cooperation.qqfav.ipc.FavoritesRemoteCommand.IRemoteCommandHandler;

public class acyu
  implements FavoritesRemoteCommand.IRemoteCommandHandler
{
  public acyu(QfavFilePreviewController paramQfavFilePreviewController) {}
  
  public boolean a(int paramInt, Bundle paramBundle)
  {
    new Handler(Looper.getMainLooper()).post(new acyv(this, paramBundle));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyu
 * JD-Core Version:    0.7.0.1
 */