package com.tencent.mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Map;

public enum e
  implements d
{
  d ygJ;
  
  static
  {
    AppMethodBeat.i(125145);
    ygI = new e("INSTANCE");
    ygK = new e[] { ygI };
    AppMethodBeat.o(125145);
  }
  
  private e()
  {
    AppMethodBeat.i(125133);
    this.ygJ = new a((byte)0);
    AppMethodBeat.o(125133);
  }
  
  public static Object a(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(125143);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0) || (paramInt3 <= paramInt2) || (paramInt3 > 255) || (paramArrayOfInt.length != paramInt3 - paramInt2))
    {
      AppMethodBeat.o(125143);
      return null;
    }
    if (paramInt1 <= paramArrayOfInt[0])
    {
      AppMethodBeat.o(125143);
      return Integer.valueOf(paramInt2);
    }
    do
    {
      i += 1;
      if (i >= paramArrayOfInt.length - 1) {
        break;
      }
      if (paramArrayOfInt[i] >= paramArrayOfInt[(i + 1)])
      {
        AppMethodBeat.o(125143);
        return null;
      }
    } while ((paramInt1 <= paramArrayOfInt[i]) || (paramInt1 > paramArrayOfInt[(i + 1)]));
    AppMethodBeat.o(125143);
    return Integer.valueOf(i + (paramInt2 + 1));
    AppMethodBeat.o(125143);
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
    AppMethodBeat.i(125140);
    ad.d("MicroMsg.ReportService", "idkeyGroupForPair [%d, %d] -> %d / [%d, %d] -> %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt6) });
    this.ygJ.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
    AppMethodBeat.o(125140);
  }
  
  public final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(125136);
    this.ygJ.a(paramInt, paramString, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(125136);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object... paramVarArgs)
  {
    AppMethodBeat.i(207446);
    this.ygJ.a(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramVarArgs);
    AppMethodBeat.o(207446);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs)
  {
    AppMethodBeat.i(125137);
    this.ygJ.a(paramInt, paramBoolean1, paramBoolean2, paramVarArgs);
    AppMethodBeat.o(125137);
  }
  
  public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(125139);
    this.ygJ.b(paramArrayList, paramBoolean);
    AppMethodBeat.o(125139);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(125141);
    ad.d("MicroMsg.ReportService", "idkeyGroupForPairAverger [%d, %d] -> %d / [%d, %d] -> 1", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    this.ygJ.c(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    AppMethodBeat.o(125141);
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125134);
    this.ygJ.f(paramInt, paramVarArgs);
    AppMethodBeat.o(125134);
  }
  
  public final void g(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(125144);
    this.ygJ.g(paramString1, paramString2, paramMap);
    AppMethodBeat.o(125144);
  }
  
  public final void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(125138);
    ad.d("MicroMsg.ReportService", "idkeyStat [%d, %d] -> %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    this.ygJ.idkeyStat(paramLong1, paramLong2, paramLong3, paramBoolean);
    AppMethodBeat.o(125138);
  }
  
  public final void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(125135);
    this.ygJ.kvStat(paramInt, paramString);
    AppMethodBeat.o(125135);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(125142);
    this.ygJ.setUin(paramInt);
    AppMethodBeat.o(125142);
  }
  
  static final class a
    implements d
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
    {
      AppMethodBeat.i(125127);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125127);
    }
    
    public final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(125125);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125125);
    }
    
    public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object... paramVarArgs)
    {
      AppMethodBeat.i(207445);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(207445);
    }
    
    public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs)
    {
      AppMethodBeat.i(125126);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125126);
    }
    
    public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
    {
      AppMethodBeat.i(125130);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125130);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      AppMethodBeat.i(125128);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125128);
    }
    
    public final void f(int paramInt, Object... paramVarArgs)
    {
      AppMethodBeat.i(125123);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125123);
    }
    
    public final void g(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(125129);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125129);
    }
    
    public final void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
    {
      AppMethodBeat.i(125121);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125121);
    }
    
    public final void kvStat(int paramInt, String paramString)
    {
      AppMethodBeat.i(125124);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125124);
    }
    
    public final void setUin(int paramInt)
    {
      AppMethodBeat.i(125122);
      ad.i("MicroMsg.ReportService", "this is DummyReportService");
      AppMethodBeat.o(125122);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.e
 * JD-Core Version:    0.7.0.1
 */