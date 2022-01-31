import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.sveffects.SLog;
import java.util.HashMap;

public class ahnr
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  
  public ahnr(GestureMgrRecognize paramGestureMgrRecognize, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    Thread localThread = Thread.currentThread();
    int i;
    int j;
    int k;
    for (;;)
    {
      HashMap localHashMap;
      ahnq[] arrayOfahnq;
      try
      {
        long[] arrayOfLong = new long[15];
        localHashMap = new HashMap();
        arrayOfahnq = new ahnq[5];
        i = 0;
        if (i < 5)
        {
          arrayOfahnq[i] = new ahnq(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize);
          i += 1;
          continue;
        }
        SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable, ThreadId[%s], token[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.jdField_a_of_type_Int) }));
        j = 0;
        i = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.a()) {
          continue;
        }
        SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable load so fail, ThreadId[%s], token[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.jdField_a_of_type_Int) }));
        GestureMgrRecognize.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize, localHashMap);
        GestureMgrRecognize.a(arrayOfLong, i);
      }
      catch (Exception localException1)
      {
        SLog.a("GestureMgrRecognize", String.format("RecognizeRunnable occured exception[%s]", new Object[] { localException1.getClass().getName() }), localException1);
        continue;
        localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.jdField_a_of_type_Ahnp;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.jdField_a_of_type_Ahnp = null;
        if (localObject == null) {
          break label538;
        }
      }
      SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable, finaly exit, ThreadId[%s], token[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.jdField_a_of_type_Int) }));
      return;
      if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.c)
      {
        SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable exit1, ThreadId[%s], token[%s], curToken[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.c) }));
      }
      else
      {
        ahnq localahnq = arrayOfahnq[j];
        this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.jdField_a_of_type_Ahnq.a(localahnq);
        Object localObject = GestureMgrRecognize.a(this.jdField_a_of_type_Int, (ahnp)localObject, localahnq.a, localException1, i);
        if (localHashMap.containsKey(((GestureKeyInfo)localObject).a))
        {
          k = ((Integer)localHashMap.get(((GestureKeyInfo)localObject).a)).intValue();
          label377:
          localHashMap.put(((GestureKeyInfo)localObject).a, Integer.valueOf(k + 1));
          if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.c)
          {
            SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable exit2, ThreadId[%s], token[%s], curToken[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.c) }));
            continue;
          }
          GestureMgrRecognize.a(this.jdField_a_of_type_Int, localahnq, (GestureKeyInfo)localObject);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.jdField_a_of_type_Ahnq = localahnq;
          k = (j + 1) % 5;
          i += 1;
          if (i == 15) {
            GestureMgrRecognize.a(localException1, i);
          }
          j = i % 15;
          i = k;
        }
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.jdField_a_of_type_Long);
        k = j;
        j = i;
        i = k;
      }
      catch (Exception localException2)
      {
        continue;
      }
      k = 0;
      break label377;
      label538:
      k = i;
      i = j;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnr
 * JD-Core Version:    0.7.0.1
 */