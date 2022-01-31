import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.QQMovieFilter;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.sveffects.SLog;

public class aibj
  extends Handler
{
  public aibj(QQMovieFilter paramQQMovieFilter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    SLog.c("QQMovieFilter", "handle movie filter msg, what = " + paramMessage.what);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((QQMovieFilter.a(this.a) != null) && (QQMovieFilter.a(this.a).a() == 1))
            {
              SLog.c("QQMovieFilter", "DecodePlayer is preparing");
              return;
            }
            Object localObject = (Object[])paramMessage.obj;
            QQMovieFilter.a(this.a, (String)localObject[0]);
            paramMessage = (String)localObject[1];
            boolean bool = ((Boolean)localObject[2]).booleanValue();
            QQMovieFilter.a(this.a, ((Float)localObject[3]).floatValue());
            QQMovieFilter.b(this.a, ((Float)localObject[4]).floatValue());
            localObject = (HWDecodeListener)localObject[5];
            if (QQMovieFilter.a(this.a) == null) {
              QQMovieFilter.a(this.a, new DecodePlayer());
            }
            if (QQMovieFilter.a(this.a) != null) {
              QQMovieFilter.a(this.a).a();
            }
            if (!FileUtil.b(QQMovieFilter.a(this.a))) {
              break;
            }
            QQMovieFilter.a(this.a).a(QQMovieFilter.a(this.a), paramMessage);
            QQMovieFilter.a(this.a).a(bool);
            QQMovieFilter.a(this.a).a((HWDecodeListener)localObject);
            QQMovieFilter.a(this.a, new aibk(this.a));
            QQMovieFilter.a(this.a).a(QQMovieFilter.a(this.a), QQMovieFilter.a(this.a));
            QQMovieFilter.a(this.a, null);
            QQMovieFilter.a(this.a).a(0);
          } while (QQMovieFilter.a(this.a) == null);
          QQMovieFilter.a(this.a).a(VideoUtil.a(QQMovieFilter.a(this.a)), QQMovieFilter.a(this.a), QQMovieFilter.b(this.a));
          return;
          QQMovieFilter.a(this.a);
          QQMovieFilter.a(this.a).a("", "");
          return;
        } while (QQMovieFilter.a(this.a) == null);
        QQMovieFilter.a(this.a).c();
        return;
        QQMovieFilter.a(this.a);
      } while (QQMovieFilter.a(this.a) == null);
      QQMovieFilter.a(this.a).a("", "");
      return;
    } while (QQMovieFilter.a(this.a) == null);
    QQMovieFilter.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aibj
 * JD-Core Version:    0.7.0.1
 */