import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.sveffects.SLog;
import java.util.HashMap;

public class aibt
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  
  public aibt(GestureMgrRecognize paramGestureMgrRecognize, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    Thread localThread = Thread.currentThread();
    Object localObject2;
    aibs localaibs;
    for (;;)
    {
      HashMap localHashMap;
      aibs[] arrayOfaibs;
      try
      {
        long[] arrayOfLong1 = new long[15];
        localHashMap = new HashMap();
        arrayOfaibs = new aibs[5];
        i = 0;
        if (i < 5)
        {
          arrayOfaibs[i] = new aibs(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize);
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
        GestureMgrRecognize.a(arrayOfLong1, i);
      }
      catch (Exception localException1)
      {
        SLog.a("GestureMgrRecognize", String.format("RecognizeRunnable occured exception[%s]", new Object[] { localException1.getClass().getName() }), localException1);
        continue;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.jdField_a_of_type_Aibr;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.jdField_a_of_type_Aibr = null;
        if (localObject2 == null) {
          break label557;
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
        localaibs = arrayOfaibs[j];
        this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.jdField_a_of_type_Aibs.a(localaibs);
        synchronized (GestureMgrRecognize.jdField_a_of_type_JavaLangObject)
        {
          localObject2 = GestureMgrRecognize.a(this.jdField_a_of_type_Int, (aibr)localObject2, localaibs.a, localException1, i);
          if (!localHashMap.containsKey(((GestureKeyInfo)localObject2).a)) {
            break label552;
          }
          k = ((Integer)localHashMap.get(((GestureKeyInfo)localObject2).a)).intValue();
          label388:
          localHashMap.put(((GestureKeyInfo)localObject2).a, Integer.valueOf(k + 1));
          if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.c) {
            SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable exit2, ThreadId[%s], token[%s], curToken[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.c) }));
          }
        }
      }
    }
    GestureMgrRecognize.a(this.jdField_a_of_type_Int, localaibs, (GestureKeyInfo)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrRecognize.jdField_a_of_type_Aibs = localaibs;
    int k = (j + 1) % 5;
    i += 1;
    if (i == 15) {
      GestureMgrRecognize.a(arrayOfLong2, i);
    }
    int j = i % 15;
    int i = k;
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
      label552:
      k = 0;
      break label388;
      label557:
      k = i;
      i = j;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aibt
 * JD-Core Version:    0.7.0.1
 */