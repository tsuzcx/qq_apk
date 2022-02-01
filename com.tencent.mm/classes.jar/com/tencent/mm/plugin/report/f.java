package com.tencent.mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Map;

public enum f
  implements d
{
  d Ozd;
  
  static
  {
    AppMethodBeat.i(125145);
    Ozc = new f("INSTANCE");
    Oze = new f[] { Ozc };
    AppMethodBeat.o(125145);
  }
  
  private f()
  {
    AppMethodBeat.i(125133);
    this.Ozd = new f.a((byte)0);
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
    Log.d("MicroMsg.ReportService", "idkeyGroupForPair [%d, %d] -> %d / [%d, %d] -> %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt6) });
    this.Ozd.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
    AppMethodBeat.o(125140);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(261790);
    this.Ozd.a(paramInt1, paramInt2, paramString, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(261790);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object... paramVarArgs)
  {
    AppMethodBeat.i(261785);
    this.Ozd.a(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramVarArgs);
    AppMethodBeat.o(261785);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs)
  {
    AppMethodBeat.i(125137);
    this.Ozd.a(paramInt, paramBoolean1, paramBoolean2, paramVarArgs);
    AppMethodBeat.o(125137);
  }
  
  public final void b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(125136);
    this.Ozd.b(paramInt, paramString, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(125136);
  }
  
  public final void b(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125134);
    this.Ozd.b(paramInt, paramVarArgs);
    AppMethodBeat.o(125134);
  }
  
  public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(125139);
    this.Ozd.b(paramArrayList, paramBoolean);
    AppMethodBeat.o(125139);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(125141);
    Log.d("MicroMsg.ReportService", "idkeyGroupForPairAverger [%d, %d] -> %d / [%d, %d] -> 1", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
    this.Ozd.c(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    AppMethodBeat.o(125141);
  }
  
  public final boolean cH(int paramInt, String paramString)
  {
    AppMethodBeat.i(261779);
    boolean bool = this.Ozd.cH(paramInt, paramString);
    AppMethodBeat.o(261779);
    return bool;
  }
  
  public final void e(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(125144);
    this.Ozd.e(paramString1, paramString2, paramMap);
    AppMethodBeat.o(125144);
  }
  
  public final void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(125138);
    Log.d("MicroMsg.ReportService", "idkeyStat [%d, %d] -> %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    this.Ozd.idkeyStat(paramLong1, paramLong2, paramLong3, paramBoolean);
    AppMethodBeat.o(125138);
  }
  
  public final void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(125135);
    this.Ozd.kvStat(paramInt, paramString);
    AppMethodBeat.o(125135);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(125142);
    this.Ozd.setUin(paramInt);
    AppMethodBeat.o(125142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.f
 * JD-Core Version:    0.7.0.1
 */