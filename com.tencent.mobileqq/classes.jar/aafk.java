import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.ARRecord.worldcup.ARWorldCupRecordController;
import com.tencent.mobileqq.ar.ARRecord.worldcup.VideoProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

public class aafk
  implements Handler.Callback
{
  public aafk(ARWorldCupRecordController paramARWorldCupRecordController) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 2: 
    case 3: 
    case 1: 
      int i;
      label470:
      do
      {
        boolean bool1;
        do
        {
          do
          {
            for (;;)
            {
              return false;
              i = paramMessage.arg1;
              j = paramMessage.arg2;
              if (ARWorldCupRecordController.a(this.a).b())
              {
                bool1 = ARWorldCupRecordController.a(this.a).a(false, false);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.worldcup.record", 2, String.format("start record, but is recording， stop video record first, stop isSuc: %s", new Object[] { Boolean.valueOf(bool1) }));
                }
                while (ARWorldCupRecordController.a(this.a).b()) {
                  try
                  {
                    Thread.sleep(20L);
                  }
                  catch (InterruptedException paramMessage)
                  {
                    paramMessage.printStackTrace();
                  }
                }
              }
              try
              {
                Thread.sleep(200L);
                ARWorldCupRecordController.a(this.a, i);
                if (i == 1)
                {
                  ARWorldCupRecordController.a(this.a, 0);
                  ARWorldCupRecordController.a(this.a).clear();
                  ARWorldCupRecordController.b(this.a, -1);
                }
                QLog.d("Q.worldcup.record", 2, String.format("do start record", new Object[0]));
                ARWorldCupRecordController.a(this.a).a(ARWorldCupRecordController.a(this.a, i));
                if (ARWorldCupRecordController.a(this.a).a(true, null)) {
                  if (ARWorldCupRecordController.a(this.a))
                  {
                    ARWorldCupRecordController.b(this.a, j, ARWorldCupRecordController.a(this.a, i));
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("Q.worldcup.record", 2, String.format("start record state:%s, nextState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
                    return false;
                  }
                }
              }
              catch (InterruptedException paramMessage)
              {
                for (;;)
                {
                  paramMessage.printStackTrace();
                  continue;
                  ARWorldCupRecordController.c(this.a, j, ARWorldCupRecordController.a(this.a, i));
                  continue;
                  QLog.e("Q.worldcup.record", 1, String.format("start record fail! state: %s", new Object[] { Integer.valueOf(i) }));
                }
              }
            }
            i = paramMessage.arg1;
            bool1 = ARWorldCupRecordController.a(this.a).c();
            ARWorldCupRecordController.a(this.a, i);
            if (i == 2) {
              ARWorldCupRecordController.b(this.a, System.currentTimeMillis() - ARWorldCupRecordController.a(this.a));
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.worldcup.record", 2, String.format("pause record state:%s, isSuc: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) }));
          return false;
          i = paramMessage.arg1;
          int j = paramMessage.arg2;
          if (ARWorldCupRecordController.a(this.a).b())
          {
            bool1 = ARWorldCupRecordController.a(this.a).d();
            if (j != 5) {
              break label583;
            }
            ARWorldCupRecordController.b(this.a, j, ARWorldCupRecordController.a(this.a, i));
          }
          for (;;)
          {
            ARWorldCupRecordController.a(this.a, i);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.worldcup.record", 2, String.format("continue record %s, isSuc:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) }));
            return false;
            QLog.e("Q.worldcup.record", 1, "continue record but is not recording");
            boolean bool2 = ARWorldCupRecordController.a(this.a).a(true, null);
            bool1 = bool2;
            if (bool2) {
              break label470;
            }
            QLog.e("Q.worldcup.record", 1, "start video record fail");
            bool1 = bool2;
            break label470;
            ARWorldCupRecordController.c(this.a, j, ARWorldCupRecordController.a(this.a, i));
          }
          i = paramMessage.arg1;
          if (!ARWorldCupRecordController.a(this.a).a()) {
            break;
          }
          bool1 = ARWorldCupRecordController.a(this.a).a(true, true);
          ARWorldCupRecordController.a(this.a, i);
          ARWorldCupRecordController.a(this.a, true);
        } while (!QLog.isColorLevel());
        QLog.d("Q.worldcup.record", 2, String.format("stop record, isSuc: %s", new Object[] { Boolean.valueOf(bool1) }));
        return false;
        ARWorldCupRecordController.a(this.a, i);
      } while (i != 15);
      label583:
      ARWorldCupRecordController.a(this.a, -1, 0L);
      return false;
    }
    Object localObject1;
    VideoProcessor localVideoProcessor;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      if (ARWorldCupRecordController.a(this.a) != null)
      {
        localObject1 = Arrays.asList(new ArrayList[] { ARWorldCupRecordController.a(this.a) });
        QLog.d("Q.worldcup.record", 2, String.format("merge video list: %s", new Object[] { localObject1 }));
      }
    }
    else
    {
      localObject1 = VideoProcessor.a(paramMessage.arg1);
      localVideoProcessor = ARWorldCupRecordController.a(this.a);
      localArrayList = ARWorldCupRecordController.a(this.a);
      if (!ARWorldCupRecordController.b(this.a)) {
        break label829;
      }
    }
    label829:
    for (paramMessage = localObject2;; paramMessage = ARWorldCupRecordController.a)
    {
      paramMessage = localVideoProcessor.a(localArrayList, paramMessage, (String)localObject1);
      ARWorldCupRecordController.a(this.a, paramMessage);
      return false;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafk
 * JD-Core Version:    0.7.0.1
 */