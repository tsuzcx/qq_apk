import android.media.AudioManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class afvv
{
  private volatile afvw jdField_a_of_type_Afvw;
  private boolean jdField_a_of_type_Boolean = true;
  bgkk[] jdField_a_of_type_ArrayOfBgkk;
  private volatile boolean b;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  private boolean f;
  
  private bgkk a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfBgkk == null) {
      this.jdField_a_of_type_ArrayOfBgkk = AudioHelper.a();
    }
    bgkk localbgkk2 = this.jdField_a_of_type_ArrayOfBgkk[0];
    bgkk localbgkk1 = localbgkk2;
    if (paramInt >= 0)
    {
      localbgkk1 = localbgkk2;
      if (paramInt < this.jdField_a_of_type_ArrayOfBgkk.length) {
        localbgkk1 = this.jdField_a_of_type_ArrayOfBgkk[paramInt];
      }
    }
    return localbgkk1;
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    avsn.a().a(paramBoolean);
    c();
  }
  
  private void c()
  {
    afvw localafvw1 = a();
    int i = 0;
    if ((AudioPlayerBase.jdField_a_of_type_Boolean) && (this.e)) {
      i = 4;
    }
    for (;;)
    {
      afvw localafvw2 = new afvw(a(i), i, true);
      if (!localafvw1.a(localafvw2)) {
        this.jdField_a_of_type_Afvw = localafvw2;
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
  
  public afvw a()
  {
    if (this.jdField_a_of_type_Afvw == null) {
      new afvw(a(0), 0);
    }
    return this.jdField_a_of_type_Afvw;
  }
  
  public afvw a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      a("onAudioDeviceStatusChanged changeType = " + paramInt + "|" + paramBoolean);
      return this.jdField_a_of_type_Afvw;
      b(paramBoolean);
      continue;
      c(paramBoolean);
      continue;
      d(paramBoolean);
      continue;
      e(paramBoolean);
    }
  }
  
  public bgkk a()
  {
    if ((this.jdField_a_of_type_Afvw == null) || (this.jdField_a_of_type_Afvw.a() == null)) {
      return a(0);
    }
    a("getCurrentProperParam");
    return this.jdField_a_of_type_Afvw.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Afvw = new afvw(a(0), 0);
    this.b = lff.a(BaseApplicationImpl.getContext());
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
      if (!bgsp.a(paramString)) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append("\n mCurDeviceStatus = " + this.jdField_a_of_type_Afvw.a);
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
 * Qualified Name:     afvv
 * JD-Core Version:    0.7.0.1
 */