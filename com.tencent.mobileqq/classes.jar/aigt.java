import android.media.AudioRecord;
import android.os.Process;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.Lock;
import com.tencent.qphone.base.util.QLog;

public class aigt
  extends Thread
{
  public aigt(AudioCapture paramAudioCapture) {}
  
  public void run()
  {
    this.a.b();
    int i = 0;
    int j;
    label86:
    int m;
    if (this.a.jdField_a_of_type_Boolean)
    {
      for (;;)
      {
        synchronized (this.a.jdField_a_of_type_JavaLangObject)
        {
          try
          {
            this.a.jdField_a_of_type_JavaLangObject.wait();
            if (!this.a.jdField_a_of_type_Boolean) {
              break;
            }
            this.a.jdField_a_of_type_Long = System.currentTimeMillis();
            this.a.jdField_b_of_type_Long = System.currentTimeMillis();
            Process.setThreadPriority(-19);
            k = 1;
            j = i;
            i = k;
            if (!Lock.jdField_a_of_type_Boolean) {
              break label542;
            }
            if ((this.a.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.a.jdField_a_of_type_ArrayOfByte == null) || (this.a.jdField_b_of_type_ArrayOfByte == null)) {
              continue;
            }
            this.a.jdField_b_of_type_Long = System.currentTimeMillis();
            if (this.a.e < this.a.f) {
              break label273;
            }
            m = 0;
            k = m;
            if (this.a.jdField_a_of_type_AndroidMediaAudioRecord != null)
            {
              k = m;
              if (this.a.jdField_a_of_type_ArrayOfByte != null) {
                k = this.a.jdField_a_of_type_AndroidMediaAudioRecord.read(this.a.jdField_a_of_type_ArrayOfByte, 0, this.a.f);
              }
            }
            this.a.b(k);
            if (i != 0)
            {
              i = 0;
              continue;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        this.a.c(this.a.jdField_a_of_type_ArrayOfByte, k, System.currentTimeMillis() - this.a.jdField_a_of_type_Long, true, 4);
      }
      label273:
      if ((this.a.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.a.jdField_a_of_type_ArrayOfByte == null)) {
        break label662;
      }
    }
    label662:
    for (int k = this.a.jdField_a_of_type_AndroidMediaAudioRecord.read(this.a.jdField_a_of_type_ArrayOfByte, 0, this.a.e);; k = 0)
    {
      this.a.b(k);
      if (k <= 0) {
        break label86;
      }
      if (i != 0)
      {
        i = 0;
        break label86;
      }
      if (j + k > this.a.f)
      {
        System.arraycopy(this.a.jdField_a_of_type_ArrayOfByte, 0, this.a.jdField_b_of_type_ArrayOfByte, j, this.a.f - j);
        m = AudioCapture.a(this.a, this.a.jdField_b_of_type_ArrayOfByte, this.a.f);
        int n = this.a.f - m;
        this.a.c(this.a.jdField_b_of_type_ArrayOfByte, n, System.currentTimeMillis() - this.a.jdField_a_of_type_Long, true, 4);
        if (m > 0) {
          System.arraycopy(this.a.jdField_b_of_type_ArrayOfByte, n, this.a.jdField_b_of_type_ArrayOfByte, 0, m);
        }
        j = this.a.f - j;
        k -= j;
        System.arraycopy(this.a.jdField_a_of_type_ArrayOfByte, j, this.a.jdField_b_of_type_ArrayOfByte, m, k);
        j = m + k;
      }
      for (;;)
      {
        break;
        System.arraycopy(this.a.jdField_a_of_type_ArrayOfByte, 0, this.a.jdField_b_of_type_ArrayOfByte, j, k);
        j += k;
      }
      label542:
      i = AudioCapture.a(this.a, this.a.jdField_b_of_type_ArrayOfByte, j);
      j -= i;
      this.a.c(this.a.jdField_b_of_type_ArrayOfByte, j, System.currentTimeMillis() - this.a.jdField_a_of_type_Long, false, 9);
      if (i > 0)
      {
        System.arraycopy(this.a.jdField_b_of_type_ArrayOfByte, j, this.a.jdField_b_of_type_ArrayOfByte, 0, i);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioNoiseSuppression[QQ]: leftLen=" + i);
      }
      i = 0;
      break;
      this.a.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aigt
 * JD-Core Version:    0.7.0.1
 */