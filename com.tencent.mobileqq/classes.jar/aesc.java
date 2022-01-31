import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import com.tencent.mobileqq.music.IQQPlayerCallback;
import com.tencent.mobileqq.music.IQQPlayerService.Stub;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;

public class aesc
  extends IQQPlayerService.Stub
{
  public aesc(QQPlayerService paramQQPlayerService) {}
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayState");
    }
    return QQPlayerService.a();
  }
  
  public Intent a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayBarIntent ");
    }
    return QQPlayerService.a();
  }
  
  public Bundle a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getExtras ");
    }
    return QQPlayerService.a();
  }
  
  public SongInfo a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSong");
    }
    return QQPlayerService.a();
  }
  
  public String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getToken=" + QQPlayerService.a());
    }
    return QQPlayerService.a();
  }
  
  public String a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : generateToken : callerType=" + paramInt + ",id=" + paramString);
    }
    return QQPlayerService.a(paramInt, paramString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : pause");
    }
    QQPlayerService.a(this.a);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : setPlayMode");
    }
    QQPlayerService.a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : setPlayBarIntent: " + paramIntent.toString());
    }
    QQPlayerService.a(paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : setExtras ");
    }
    QQPlayerService.a(paramBundle);
  }
  
  public void a(IQQPlayerCallback paramIQQPlayerCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : registerCallback");
    }
    if (paramIQQPlayerCallback == null) {
      return;
    }
    if (QQPlayerService.a(this.a) == null) {}
    try
    {
      if (QQPlayerService.a(this.a) == null) {
        QQPlayerService.a(this.a, new RemoteCallbackList());
      }
      QQPlayerService.a(this.a).register(paramIQQPlayerCallback);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : startPlay sCallback = " + QQPlayerService.a() + ",startIndex" + paramInt);
    }
    if (QQPlayerService.a() != null)
    {
      QQPlayerService.a(QQPlayerService.a());
      QQPlayerService.b(null);
    }
    QQPlayerService.a(this.a, paramString, paramArrayOfSongInfo, paramInt);
  }
  
  public boolean a()
  {
    return QQPlayerService.a();
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : isPlayingMySong : token=" + paramString);
    }
    return QQPlayerService.a(paramString);
  }
  
  public SongInfo[] a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayList");
    }
    return QQPlayerService.a();
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayMode");
    }
    return QQPlayerService.b();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : resume");
    }
    QQPlayerService.b(this.a);
  }
  
  public void b(IQQPlayerCallback paramIQQPlayerCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : unRegisterCallback");
    }
    if ((paramIQQPlayerCallback != null) && (QQPlayerService.a(this.a) != null)) {
      QQPlayerService.a(this.a).unregister(paramIQQPlayerCallback);
    }
  }
  
  public int c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getDuration");
    }
    return QQPlayerService.d();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : stop");
    }
    QQPlayerService.c(this.a);
  }
  
  public int d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSongPosition");
    }
    return QQPlayerService.e();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : playNext");
    }
    QQPlayerService.b(this.a);
  }
  
  public int e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentSongIndex");
    }
    return QQPlayerService.g();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : playPrev");
    }
    QQPlayerService.a(this.a);
  }
  
  public int f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getPlayListCount");
    }
    return QQPlayerService.c();
  }
  
  public int g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "AIDL : getCurrentPlayPosition");
    }
    return QQPlayerService.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesc
 * JD-Core Version:    0.7.0.1
 */