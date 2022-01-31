package com.tencent.mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Map;

public enum f
  implements d
{
  d nEH = new a((byte)0);
  
  private f() {}
  
  public static Object a(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    int i = 0;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0) || (paramInt3 <= paramInt2) || (paramInt3 > 255) || (paramArrayOfInt.length != paramInt3 - paramInt2)) {
      return null;
    }
    if (paramInt1 <= paramArrayOfInt[0]) {
      return Integer.valueOf(paramInt2);
    }
    do
    {
      i += 1;
      if (i >= paramArrayOfInt.length - 1) {
        break;
      }
      if (paramArrayOfInt[i] >= paramArrayOfInt[(i + 1)]) {
        return null;
      }
    } while ((paramInt1 <= paramArrayOfInt[i]) || (paramInt1 > paramArrayOfInt[(i + 1)]));
    return Integer.valueOf(i + (paramInt2 + 1));
    return Integer.valueOf(paramInt3);
  }
  
  public static Object a(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    int i = 0;
    if ((paramArrayOfInt.length <= 0) || (paramArrayOfInt.length + 1 != paramArrayOfObject.length)) {
      return null;
    }
    if (paramInt <= paramArrayOfInt[0]) {
      return paramArrayOfObject[0];
    }
    do
    {
      i += 1;
      if (i >= paramArrayOfInt.length - 1) {
        break;
      }
      if (paramArrayOfInt[i] >= paramArrayOfInt[(i + 1)]) {
        return null;
      }
    } while ((paramInt <= paramArrayOfInt[i]) || (paramInt > paramArrayOfInt[(i + 1)]));
    return paramArrayOfObject[(i + 1)];
    return paramArrayOfObject[(paramArrayOfObject.length - 1)];
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    y.d("MicroMsg.ReportService", "idkeyGroupForPair [%d, %d] -> %d / [%d, %d] -> %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt6) });
    this.nEH.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
  }
  
  public final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.nEH.a(paramInt, paramString, paramBoolean1, paramBoolean2);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs)
  {
    this.nEH.a(paramInt, paramBoolean1, paramBoolean2, paramVarArgs);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    y.d("MicroMsg.ReportService", "idkeyStat [%d, %d] -> %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    this.nEH.a(paramLong1, paramLong2, paramLong3, paramBoolean);
  }
  
  public final void aC(int paramInt, String paramString)
  {
    this.nEH.aC(paramInt, paramString);
  }
  
  public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    this.nEH.b(paramArrayList, paramBoolean);
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    y.d("MicroMsg.ReportService", "idkeyGroupForPairAverger [%d, %d] -> %d / [%d, %d] -> 1", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    this.nEH.d(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  public final void d(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    this.nEH.d(paramString1, paramString2, paramMap);
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    this.nEH.f(paramInt, paramVarArgs);
  }
  
  public final void fn(int paramInt)
  {
    this.nEH.fn(paramInt);
  }
  
  private static final class a
    implements d
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
    
    public final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
    
    public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
    
    public final void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
    
    public final void aC(int paramInt, String paramString)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
    
    public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
    
    public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
    
    public final void d(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
    
    public final void f(int paramInt, Object... paramVarArgs)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
    
    public final void fn(int paramInt)
    {
      y.i("MicroMsg.ReportService", "this is DummyReportService");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.f
 * JD-Core Version:    0.7.0.1
 */