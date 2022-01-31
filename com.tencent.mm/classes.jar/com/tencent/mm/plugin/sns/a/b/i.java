package com.tencent.mm.plugin.sns.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class i
  implements f
{
  public static int qZN = 20480;
  public static int qZO = 30720;
  public static int qZP = 51200;
  public static int qZQ = 60;
  public static int qZR = 1800;
  public static int qZS = 43200;
  private int qZM;
  private long qZT;
  private cec qZU;
  private boolean qZV;
  private long qZW;
  private int qZX;
  private Random random;
  
  public i()
  {
    AppMethodBeat.i(35755);
    this.qZM = 0;
    this.qZT = 0L;
    this.random = new Random(System.currentTimeMillis());
    this.qZU = new cec();
    this.qZV = false;
    this.qZW = 0L;
    this.qZX = 0;
    AppMethodBeat.o(35755);
  }
  
  private void cnI()
  {
    AppMethodBeat.i(35759);
    ag.coS().execute(new i.3(this));
    AppMethodBeat.o(35759);
  }
  
  private void cnJ()
  {
    AppMethodBeat.i(35760);
    ag.coS().execute(new i.4(this));
    AppMethodBeat.o(35760);
  }
  
  public static String t(Object... paramVarArgs)
  {
    AppMethodBeat.i(35761);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      ab.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramVarArgs = "";; paramVarArgs = localStringBuilder.toString())
    {
      AppMethodBeat.o(35761);
      return paramVarArgs;
      localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length - 1;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
        i += 1;
      }
      localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    }
  }
  
  public final void cnH()
  {
    AppMethodBeat.i(35758);
    if (!ag.rgi)
    {
      AppMethodBeat.o(35758);
      return;
    }
    g.RM();
    int k = ((Integer)g.RL().Ru().get(ac.a.yzS, Integer.valueOf(0))).intValue();
    g.RM();
    int j = ((Integer)g.RL().Ru().get(ac.a.yzR, Integer.valueOf(-1))).intValue();
    if (j <= qZS)
    {
      i = j;
      if (j >= 0) {}
    }
    else
    {
      i = qZR;
      j = qZQ;
      i = this.random.nextInt(i - j + 1) + qZQ;
    }
    if (System.currentTimeMillis() / 1000L - k > i) {}
    for (int i = 1; i == 0; i = 0)
    {
      cnI();
      ab.d("MicroMsg.SnsLogMgr", "pass report ");
      AppMethodBeat.o(35758);
      return;
    }
    Object localObject = ag.coY();
    ab.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf("select rowid from SnsReportKv order by rowid desc  limit 1")));
    localObject = ((q)localObject).fnw.a("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.qZM = i;
      cnJ();
      cnI();
      AppMethodBeat.o(35758);
      return;
    }
  }
  
  public final void e(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35757);
    ag.coS().execute(new i.1(this, paramInt, paramVarArgs));
    if (this.qZV)
    {
      AppMethodBeat.o(35757);
      return;
    }
    this.qZV = true;
    ag.coS().r(new i.2(this), 2000L);
    AppMethodBeat.o(35757);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(35762);
    if ((paramm.getType() == 1802) && ((paramm instanceof e)))
    {
      paramString = (e)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        g.RM();
        g.RL().Ru().set(ac.a.yzS, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        cnJ();
        AppMethodBeat.o(35762);
        return;
      }
      Object localObject = paramString.iQp;
      paramString = ag.coY();
      paramm = new cec();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ayx localayx = (ayx)((Iterator)localObject).next();
        paramm.wok.add(localayx);
      }
      paramString.a(paramm);
    }
    AppMethodBeat.o(35762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.i
 * JD-Core Version:    0.7.0.1
 */