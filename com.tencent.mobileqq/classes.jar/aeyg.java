import android.media.AudioManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class aeyg
{
  private volatile aeyh jdField_a_of_type_Aeyh;
  private boolean jdField_a_of_type_Boolean = true;
  bfts[] jdField_a_of_type_ArrayOfBfts;
  private volatile boolean b;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  private boolean f;
  
  private bfts a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfBfts == null) {
      this.jdField_a_of_type_ArrayOfBfts = AudioHelper.a();
    }
    bfts localbfts2 = this.jdField_a_of_type_ArrayOfBfts[0];
    bfts localbfts1 = localbfts2;
    if (paramInt >= 0)
    {
      localbfts1 = localbfts2;
      if (paramInt < this.jdField_a_of_type_ArrayOfBfts.length) {
        localbfts1 = this.jdField_a_of_type_ArrayOfBfts[paramInt];
      }
    }
    return localbfts1;
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    auyl.a().a(paramBoolean);
    c();
  }
  
  private void c()
  {
    aeyh localaeyh1 = a();
    int i = 0;
    if ((AudioPlayerBase.jdField_a_of_type_Boolean) && (this.e)) {
      i = 4;
    }
    while (localaeyh1 == null)
    {
      return;
      if (this.b) {
        i = 2;
      } else if (this.c) {
        i = 3;
      } else if ((!this.jdField_a_of_type_Boolean) || (this.d)) {
        i = 1;
      }
    }
    aeyh localaeyh2 = new aeyh(a(i), i, true);
    if (!localaeyh1.a(localaeyh2)) {
      this.jdField_a_of_type_Aeyh = localaeyh2;
    }
    a("updateCurrentStatus end nextStatusType = " + i);
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
  
  public aeyh a()
  {
    if (this.jdField_a_of_type_Aeyh == null) {
      new aeyh(a(0), 0);
    }
    return this.jdField_a_of_type_Aeyh;
  }
  
  public aeyh a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      a("onAudioDeviceStatusChanged changeType = " + paramInt + "|" + paramBoolean);
      return this.jdField_a_of_type_Aeyh;
      b(paramBoolean);
      continue;
      c(paramBoolean);
      continue;
      d(paramBoolean);
      continue;
      e(paramBoolean);
    }
  }
  
  public bfts a()
  {
    if ((this.jdField_a_of_type_Aeyh == null) || (this.jdField_a_of_type_Aeyh.a() == null)) {
      return a(0);
    }
    a("getCurrentProperParam");
    return this.jdField_a_of_type_Aeyh.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aeyh = new aeyh(a(0), 0);
    this.b = lfg.a(BaseApplicationImpl.getContext());
    this.c = AudioHelper.a(BaseApplicationImpl.getContext());
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Boolean = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getLoudSpeakerState();
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
      if (!StringUtil.isEmpty(paramString)) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append("\n mCurDeviceStatus = " + this.jdField_a_of_type_Aeyh.a);
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
 * Qualified Name:     aeyg
 * JD-Core Version:    0.7.0.1
 */