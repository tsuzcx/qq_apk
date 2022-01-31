import android.media.AudioRecord;
import android.os.Process;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.AudioCaptureListener;
import com.tencent.mobileqq.richmedia.capture.audio.AudioDataCache;
import com.tencent.qphone.base.util.QLog;

public class ahha
  implements Runnable
{
  public Object a;
  public boolean a;
  public boolean b;
  public boolean c = false;
  public boolean d = true;
  
  private ahha(AudioCapture paramAudioCapture)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "RecordRunnable run");
    }
    this.b = false;
    AudioCapture.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    Process.setThreadPriority(-19);
    if (!this.c)
    {
      if (this.b) {
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "RecordRunnable exit before record");
        }
      }
      do
      {
        for (;;)
        {
          return;
          if (this.d)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AudioCapture", 2, "RecordRunnable pause");
            }
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              try
              {
                if (this.d) {
                  this.jdField_a_of_type_JavaLangObject.wait();
                }
                while (QLog.isColorLevel())
                {
                  QLog.d("AudioCapture", 2, "RecordRunnable resume, startrecord:" + this.c + " interrupt:" + this.b + " pause:" + this.d);
                  break;
                  QLog.d("AudioCapture", 2, "is not pause now:");
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  QLog.d("AudioCapture", 2, "RecordRunnable wait exception:" + localException2);
                }
              }
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte != null))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_AndroidMediaAudioRecord.read(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e);
          if (AudioCapture.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture) == null) {
            break;
          }
          AudioCapture.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte, 0, i);
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AudioCapture", 2, "Error param, RecordRunnable exit");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "RecordRunnable record run");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioDataCache = new AudioDataCache(AudioCapture.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioDataCache.a();
    int i = 0;
    label768:
    for (;;)
    {
      try
      {
        if ((!this.jdField_a_of_type_Boolean) || (this.b)) {
          break label700;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b == null)) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e >= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte == null)) {
            break label763;
          }
          j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_AndroidMediaAudioRecord.read(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(j);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte, j);
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_AndroidMediaAudioRecord == null) {
          break label758;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioDataCache.a();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte != null) {}
      label700:
      label758:
      for (int j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_AndroidMediaAudioRecord.read(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e);; j = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(j);
        if (j <= 0) {
          break;
        }
        if (i + j > this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f)
        {
          System.arraycopy(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b, i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f - i);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f);
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f - i;
          j -= i;
          System.arraycopy(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte, i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b, 0, j);
          i = j + 0;
          break label768;
        }
        System.arraycopy(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b, i, j);
        i = j + i;
        break label768;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioDataCache.a();
        if ((!this.jdField_a_of_type_Boolean) && (AudioCapture.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture) != null)) {
          AudioCapture.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture).b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioDataCache.b());
        }
        AudioCapture.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
        return;
      }
      label763:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahha
 * JD-Core Version:    0.7.0.1
 */