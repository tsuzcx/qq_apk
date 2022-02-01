import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.qphone.base.util.QLog;

class aeye
  extends BroadcastReceiver
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  long b = 0L;
  
  private aeye(aeyc paramaeyc, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = SystemClock.uptimeMillis();
    int i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_SCOHelper", 2, "onReceive ACTION_SCO_AUDIO_STATE_UPDATED = " + i + " " + this.jdField_a_of_type_JavaLangString + ", time=" + l);
    }
    paramContext = aeyc.a(this.jdField_a_of_type_Aeyc);
    if (1 == i) {
      if (this.b == 0L)
      {
        this.b = l;
        if (paramContext != null)
        {
          paramIntent = paramContext.a();
          if (paramIntent != null)
          {
            paramIntent.setBluetoothScoOn(true);
            AudioPlayerBase.c = true;
          }
          paramContext.h();
          if (!paramContext.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("AudioPlayer_SCOHelper", 2, "onReceive SCO_AUDIO_STATE_CONNECTED need replay time=" + l);
            }
            paramContext.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (2 == i)
          {
            this.jdField_a_of_type_Boolean = true;
            return;
          }
        } while (i != 0);
        if (this.jdField_a_of_type_Long == 0L)
        {
          this.jdField_a_of_type_Long = l;
          return;
        }
        if ((this.jdField_a_of_type_Boolean) && (paramContext != null)) {
          paramContext.j();
        }
        if (paramContext != null) {
          paramContext.i();
        }
        if (((this.b == 0L) || (l - this.b > 2000L)) && (l - this.jdField_a_of_type_Long > 1000L)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AudioPlayer_SCOHelper", 2, "sco disconnected quickly.");
        }
        AudioPlayerBase.b = true;
      } while (paramContext == null);
      paramContext.b();
      if (paramContext.a())
      {
        paramContext.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        return;
      }
      paramContext.c(0);
      return;
    } while ((paramContext == null) || (!paramContext.a()));
    paramContext.c(paramContext.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeye
 * JD-Core Version:    0.7.0.1
 */