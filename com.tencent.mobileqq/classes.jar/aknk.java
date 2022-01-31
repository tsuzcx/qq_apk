import com.tencent.mobileqq.utils.RandomAccessFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class aknk
  implements Runnable
{
  public aknk(RandomAccessFileManager paramRandomAccessFileManager) {}
  
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
            localaknl2 = (aknl)RandomAccessFileManager.a(this.a).get(arrayOfString[j]);
            aknl localaknl1;
            for (??? = localaknl2.jdField_b_of_type_Aknl;; localObject3 = localaknl1)
            {
              localaknl1 = ((aknl)???).jdField_b_of_type_Aknl;
              if (((aknl)???).jdField_a_of_type_Int != 0) {
                break;
              }
              long l1 = System.currentTimeMillis();
              long l2 = ((aknl)???).jdField_b_of_type_Long;
              if (l1 - l2 <= 1000L) {
                break;
              }
              try
              {
                ((aknl)???).jdField_a_of_type_JavaIoRandomAccessFile.close();
                if (QLog.isColorLevel()) {
                  QLog.d("AppleMojiHandler", 2, "file " + arrayOfString[j] + "[" + ((aknl)???).jdField_a_of_type_Long + "]" + " close by Thread:" + Thread.currentThread().getId());
                }
                RandomAccessFileManager.a(this.a, localaknl2, (aknl)???, arrayOfString[j], RandomAccessFileManager.a(this.a));
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
        aknl localaknl2;
        continue;
        int j = 0;
        continue;
        if (localaknl2 == localInterruptedException) {
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aknk
 * JD-Core Version:    0.7.0.1
 */