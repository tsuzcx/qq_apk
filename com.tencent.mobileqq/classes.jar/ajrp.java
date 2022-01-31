import com.tencent.mobileqq.utils.RandomAccessFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ajrp
  implements Runnable
{
  public ajrp(RandomAccessFileManager paramRandomAccessFileManager) {}
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Thread.sleep(1000L);
        synchronized (RandomAccessFileManager.a(this.a))
        {
          if (!RandomAccessFileManager.a(this.a).isEmpty()) {}
        }
        Object localObject3;
        synchronized (RandomAccessFileManager.b(this.a))
        {
          RandomAccessFileManager.a(this.a, null);
          return;
          String[] arrayOfString = new String[RandomAccessFileManager.a(this.a).size()];
          ??? = RandomAccessFileManager.a(this.a).keySet().iterator();
          int i = 0;
          while (((Iterator)???).hasNext())
          {
            arrayOfString[i] = ((String)((Iterator)???).next());
            i += 1;
          }
          if (j < i)
          {
            localajrq2 = (ajrq)RandomAccessFileManager.a(this.a).get(arrayOfString[j]);
            ajrq localajrq1;
            for (??? = localajrq2.jdField_b_of_type_Ajrq;; localObject3 = localajrq1)
            {
              localajrq1 = ((ajrq)???).jdField_b_of_type_Ajrq;
              if (((ajrq)???).jdField_a_of_type_Int != 0) {
                break;
              }
              long l1 = System.currentTimeMillis();
              long l2 = ((ajrq)???).jdField_b_of_type_Long;
              if (l1 - l2 <= 1000L) {
                break;
              }
              try
              {
                ((ajrq)???).jdField_a_of_type_JavaIoRandomAccessFile.close();
                if (QLog.isColorLevel()) {
                  QLog.d("AppleMojiHandler", 2, "file " + arrayOfString[j] + "[" + ((ajrq)???).jdField_a_of_type_Long + "]" + " close by Thread:" + Thread.currentThread().getId());
                }
                RandomAccessFileManager.a(this.a, localajrq2, (ajrq)???, arrayOfString[j], RandomAccessFileManager.a(this.a));
              }
              catch (IOException localIOException)
              {
                for (;;)
                {
                  localIOException.printStackTrace();
                }
              }
              localObject2 = finally;
              throw localObject2;
            }
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ajrq localajrq2;
        continue;
        int j = 0;
        continue;
        if (localajrq2 == localInterruptedException) {
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajrp
 * JD-Core Version:    0.7.0.1
 */