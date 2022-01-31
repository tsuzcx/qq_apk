import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class alil
  implements alie
{
  public static int a;
  private static int jdField_b_of_type_Int = 3;
  private static int c = 10000;
  private long jdField_a_of_type_Long;
  private alhq jdField_a_of_type_Alhq;
  private List<TraceData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long = System.currentTimeMillis() - 540000L;
  private boolean jdField_b_of_type_Boolean = true;
  private int d;
  private int e;
  
  static
  {
    jdField_a_of_type_Int = 30000;
  }
  
  private void a(TraceData paramTraceData)
  {
    if ((paramTraceData == null) || (paramTraceData.result == null)) {}
    do
    {
      return;
      l1 = System.currentTimeMillis();
      if (l1 - this.jdField_b_of_type_Long < 1000L)
      {
        paramTraceData.result.c = this.d;
        paramTraceData.result.d = this.e;
        return;
      }
    } while ((l1 - this.jdField_b_of_type_Long <= 600000L) && ((!paramTraceData.isSampleFocus) || (l1 - this.jdField_b_of_type_Long <= 300000L)));
    this.jdField_b_of_type_Long = l1;
    long l1 = System.currentTimeMillis();
    this.d = alhz.b();
    this.e = alhz.a();
    long l2 = System.currentTimeMillis();
    QLog.i("TraceReport", 1, "samplingCpuAndMemory cpu:" + this.e + ",memory:" + this.d + ",isSampleFocus:" + paramTraceData.isSampleFocus + ",cost:" + (l2 - l1));
    paramTraceData.result.c = this.d;
    paramTraceData.result.d = this.e;
  }
  
  private void c(List<TraceData> paramList)
  {
    alif localalif = this.jdField_a_of_type_Alhq.a();
    if (localalif != null) {
      localalif.b(paramList);
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_Alhq.a();
    if (localObject != null)
    {
      localObject = ((alif)localObject).a();
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraceReport", 2, new Object[] { "onReportStrategyChange reportInterval:", Integer.valueOf(paramInt1), ",reportNum:", Integer.valueOf(paramInt2), ", isFailReport:", Boolean.valueOf(paramBoolean) });
    }
    if (paramInt1 > 0) {
      jdField_a_of_type_Int = paramInt1 * 1000;
    }
    if (paramInt2 > 0) {
      jdField_b_of_type_Int = paramInt2;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(alhq paramalhq)
  {
    this.jdField_a_of_type_Alhq = paramalhq;
    paramalhq = this.jdField_a_of_type_Alhq.a();
    if (paramalhq != null) {
      paramalhq.a(this);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(List<TraceData> paramList)
  {
    alid localalid = this.jdField_a_of_type_Alhq.a();
    if (localalid != null)
    {
      localalid.a(paramList);
      localalid.b(paramList);
    }
  }
  
  public boolean a(TraceData paramTraceData)
  {
    long l1 = System.currentTimeMillis();
    a(paramTraceData);
    this.jdField_a_of_type_JavaUtilList.add(paramTraceData);
    if (this.jdField_b_of_type_Boolean)
    {
      boolean bool2 = bdin.g(null);
      long l2 = l1 - this.jdField_a_of_type_Long;
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if ((paramTraceData.result != null) && (paramTraceData.result.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Boolean))
      {
        bool1 = true;
        if (((i < jdField_b_of_type_Int) || (l2 <= c)) && (((l2 <= jdField_a_of_type_Int) && (!bool1)) || (!bool2))) {
          break label254;
        }
        a(this.jdField_a_of_type_JavaUtilList);
        c(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_JavaUtilList.clear();
        long l3 = System.currentTimeMillis();
        this.jdField_a_of_type_Long = l3;
        if (QLog.isColorLevel()) {
          QLog.d("TraceReport", 2, new Object[] { "handleAddTraceReporting interval:", Long.valueOf(l2), ",reportSize:", Integer.valueOf(i), ",report all cost:", Long.valueOf(l3 - l1), ",isFailReport:", Boolean.valueOf(bool1) });
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        if ((!bool2) && (QLog.isColorLevel())) {
          QLog.d("TraceReport", 2, "handleAddTraceReporting not network and save");
        }
        return bool1;
        bool1 = false;
        break;
        label254:
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramTraceData);
        b(localArrayList);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TraceReport", 2, "handleAddTraceReporting not active and save");
    }
    b(this.jdField_a_of_type_JavaUtilList);
    return false;
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    boolean bool = bdin.g(null);
    if ((i <= 0) || (!bool) || (!this.jdField_b_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.d("TraceReport", 2, new Object[] { "flushDelayReport reportSize:", Integer.valueOf(i), ", net:", Boolean.valueOf(bool), ",mActive:", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
    }
    do
    {
      return;
      a(this.jdField_a_of_type_JavaUtilList);
      c(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("TraceReport", 2, new Object[] { "handleAddTraceReporting flushDelayReport reportSize:", Integer.valueOf(i) });
  }
  
  public void b(List<TraceData> paramList)
  {
    alif localalif = this.jdField_a_of_type_Alhq.a();
    if (localalif != null) {
      localalif.a(paramList);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    b(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alil
 * JD-Core Version:    0.7.0.1
 */