import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import java.lang.ref.WeakReference;

public class acwc
  implements TVK_IMediaPlayer.OnErrorListener
{
  public acwc(FileVideoManager.VideoControl paramVideoControl) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.e("FileVideoManager<FileAssistant>", 1, "mediaPlayer onError:errorType[" + paramInt1 + "], errorCode[" + paramInt2 + "],extra[" + paramInt3 + "],detailInfo[" + paramString + "]");
    paramTVK_IMediaPlayer = (FileVideoManager.FileVideoManagerCallback)this.a.a.get();
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.a(paramInt2, "视频文件不存在或已损坏");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwc
 * JD-Core Version:    0.7.0.1
 */