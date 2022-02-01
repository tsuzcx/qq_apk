import android.util.SparseArray;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class alty
{
  private static long jdField_a_of_type_Long = -1L;
  private static SparseArray<Long> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static void a()
  {
    if (jdField_a_of_type_AndroidUtilSparseArray != null) {
      jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    jdField_a_of_type_AndroidUtilSparseArray = null;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameTimeReporter", 2, "[destroy]");
    }
  }
  
  public static void a(CmGameStartChecker.StartCheckParam arg0)
  {
    if (??? != null)
    {
      int i = ???.gameId;
      if (i == 0) {
        return;
      }
      try
      {
        if (jdField_a_of_type_AndroidUtilSparseArray == null) {
          jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        synchronized (jdField_a_of_type_AndroidUtilSparseArray)
        {
          long l = System.currentTimeMillis();
          jdField_a_of_type_AndroidUtilSparseArray.put(i, Long.valueOf(l));
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameTimeReporter", 2, "[reportStart] set time " + i + " # " + l);
          }
          return;
        }
        QLog.e("ApolloGameTimeReporter", 1, "[reportStart] no para");
      }
      catch (Throwable ???)
      {
        QLog.e("ApolloGameTimeReporter", 1, ???, new Object[] { "[reportStart]" });
        return;
      }
    }
  }
  
  public static void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    int i;
    if (paramStartCheckParam != null)
    {
      i = paramStartCheckParam.gameId;
      if (i == 0) {}
    }
    else
    {
      label301:
      for (;;)
      {
        try
        {
          if (jdField_a_of_type_AndroidUtilSparseArray == null) {
            break;
          }
          synchronized (jdField_a_of_type_AndroidUtilSparseArray)
          {
            int j = paramStartCheckParam.gameMode;
            long l1 = paramStartCheckParam.roomId;
            long l2 = ((Long)jdField_a_of_type_AndroidUtilSparseArray.get(i, Long.valueOf(jdField_a_of_type_Long))).longValue();
            paramStartCheckParam = alvx.a(i);
            if (paramStartCheckParam == null) {
              break label301;
            }
            paramStartCheckParam = paramStartCheckParam.a();
            if (paramStartCheckParam == null) {
              break label301;
            }
            l1 = paramStartCheckParam.mRoomId;
            if (l2 != jdField_a_of_type_Long)
            {
              long l3 = System.currentTimeMillis() - l2;
              VipUtils.a(null, "cmshow", "Apollo", "game_time", 0, 0, new String[] { i + "", String.valueOf(j), String.valueOf(l3), String.valueOf(l1) });
              jdField_a_of_type_AndroidUtilSparseArray.remove(i);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameTimeReporter", 2, new Object[] { "[reportEnd] report: id:", Integer.valueOf(i), "# roomId:", Long.valueOf(l1), "# mode:", Integer.valueOf(j), "# [", Long.valueOf(l3), "] #", Long.valueOf(l2), " => ", Long.valueOf(System.currentTimeMillis()) });
              }
            }
            return;
          }
          QLog.e("ApolloGameTimeReporter", 1, "[reportEnd] no para");
        }
        catch (Throwable paramStartCheckParam)
        {
          QLog.e("ApolloGameTimeReporter", 1, paramStartCheckParam, new Object[] { "[reportEnd]" });
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alty
 * JD-Core Version:    0.7.0.1
 */