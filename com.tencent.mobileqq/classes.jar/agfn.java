import android.media.AudioManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class agfn
{
  private volatile agfo jdField_a_of_type_Agfo;
  private boolean jdField_a_of_type_Boolean = true;
  bhkl[] jdField_a_of_type_ArrayOfBhkl;
  private volatile boolean b;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  private boolean f;
  
  private bhkl a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfBhkl == null) {
      this.jdField_a_of_type_ArrayOfBhkl = AudioHelper.a();
    }
    bhkl localbhkl2 = this.jdField_a_of_type_ArrayOfBhkl[0];
    bhkl localbhkl1 = localbhkl2;
    if (paramInt >= 0)
    {
      localbhkl1 = localbhkl2;
      if (paramInt < this.jdField_a_of_type_ArrayOfBhkl.length) {
        localbhkl1 = this.jdField_a_of_type_ArrayOfBhkl[paramInt];
      }
    }
    return localbhkl1;
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    awli.a().a(paramBoolean);
    c();
  }
  
  private void c()
  {
    agfo localagfo1 = a();
    int i = 0;
    if ((AudioPlayerBase.jdField_a_of_type_Boolean) && (this.e)) {
      i = 4;
    }
    for (;;)
    {
      agfo localagfo2 = new agfo(a(i), i, true);
      if (!localagfo1.a(localagfo2)) {
        this.jdField_a_of_type_Agfo = localagfo2;
      }
      a("updateCurrentStatus end nextStatusType = " + i);
      return;
      if (this.b) {
        i = 2;
      } else if (this.c) {
        i = 3;
      } else if ((!this.jdField_a_of_type_Boolean) || (this.d)) {
        i = 1;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.d != paramBoolean) {
      this.d = paramBoolean;
    }
    c();
  }
  
  private void d(boolean paramBoolean)
  {
    this.b = paramBoolean;
    c();
  }
  
  private void e(boolean paramBoolean)
  {
    this.c = AudioHelper.a(BaseApplicationImpl.getContext());
    this.e = AudioHelper.c(BaseApplicationImpl.getContext());
    c();
  }
  
  public int a()
  {
    return 31;
  }
  
  public agfo a()
  {
    if (this.jdField_a_of_type_Agfo == null) {
      new agfo(a(0), 0);
    }
    return this.jdField_a_of_type_Agfo;
  }
  
  public agfo a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      a("onAudioDeviceStatusChanged changeType = " + paramInt + "|" + paramBoolean);
      return this.jdField_a_of_type_Agfo;
      b(paramBoolean);
      continue;
      c(paramBoolean);
      continue;
      d(paramBoolean);
      continue;
      e(paramBoolean);
    }
  }
  
  public bhkl a()
  {
    if ((this.jdField_a_of_type_Agfo == null) || (this.jdField_a_of_type_Agfo.a() == null)) {
      return a(0);
    }
    a("getCurrentProperParam");
    return this.jdField_a_of_type_Agfo.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Agfo = new agfo(a(0), 0);
    this.b = lfm.a(BaseApplicationImpl.getContext());
    this.c = AudioHelper.a(BaseApplicationImpl.getContext());
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Boolean = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).z();
    }
    this.e = AudioHelper.c(BaseApplicationImpl.getContext());
    c();
    a("init ");
  }
  
  public void a(AudioManager paramAudioManager)
  {
    a("doOnBluetoothSCODisconnected isBluetoothA2dpOn = " + paramAudioManager.isBluetoothA2dpOn());
    if ((this.c) && (!paramAudioManager.isBluetoothA2dpOn())) {
      this.c = false;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (!bhsr.a(paramString)) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append("\n mCurDeviceStatus = " + this.jdField_a_of_type_Agfo.a);
      localStringBuilder.append("\n  userLoudSpeakerStatus = " + this.jdField_a_of_type_Boolean);
      localStringBuilder.append("\n  mNearToEar = " + this.d);
      localStringBuilder.append("\n  wiredHeadsetConnect = " + this.b);
      localStringBuilder.append("\n  blueHeadsetConnect = " + this.c);
      localStringBuilder.append("\n  mblueHeadsetSCOConnect = " + this.e);
      QLog.d("AudioPlayer_DeviceStatus", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (!this.f)
    {
      a(AudioHelper.c(BaseApplicationImpl.getContext()));
      this.f = true;
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfn
 * JD-Core Version:    0.7.0.1
 */