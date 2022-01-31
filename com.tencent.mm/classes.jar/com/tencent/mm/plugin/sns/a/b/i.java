package com.tencent.mm.plugin.sns.a.b;

import android.database.Cursor;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.btm;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class i
  implements f
{
  public static int olB = 20480;
  public static int olC = 30720;
  public static int olD = 51200;
  public static int olE = 60;
  public static int olF = 1800;
  public static int olG = 43200;
  private int olA = 0;
  private long olH = 0L;
  private btm olI = new btm();
  private boolean olJ = false;
  private long olK = 0L;
  private int olL = 0;
  private Random random = new Random(System.currentTimeMillis());
  
  private void bCi()
  {
    af.bDs().post(new i.3(this));
  }
  
  private void bCj()
  {
    af.bDs().post(new i.4(this));
  }
  
  public static String o(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      y.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length - 1;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    return localStringBuilder.toString();
  }
  
  public final void bCh()
  {
    if (!af.ort) {
      return;
    }
    g.DQ();
    int k = ((Integer)g.DP().Dz().get(ac.a.upS, Integer.valueOf(0))).intValue();
    g.DQ();
    int j = ((Integer)g.DP().Dz().get(ac.a.upR, Integer.valueOf(-1))).intValue();
    if (j <= olG)
    {
      i = j;
      if (j >= 0) {}
    }
    else
    {
      i = olF;
      j = olE;
      i = this.random.nextInt(i - j + 1) + olE;
    }
    if (System.currentTimeMillis() / 1000L - k > i) {}
    for (int i = 1; i == 0; i = 0)
    {
      bCi();
      y.d("MicroMsg.SnsLogMgr", "pass report ");
      return;
    }
    Object localObject = af.bDy();
    y.i("MicroMsg.SnsKvReportStg", " getLast " + "select rowid from SnsReportKv order by rowid desc  limit 1");
    localObject = ((q)localObject).dXo.a("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.olA = i;
      bCj();
      bCi();
      return;
    }
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    af.bDs().post(new i.1(this, paramInt, paramVarArgs));
    if (this.olJ) {
      return;
    }
    this.olJ = true;
    af.bDs().postDelayed(new i.2(this), 2000L);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm.getType() == 1802) && ((paramm instanceof e)))
    {
      paramString = (e)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        g.DQ();
        g.DP().Dz().c(ac.a.upS, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        bCj();
      }
    }
    else
    {
      return;
    }
    Object localObject = paramString.hfb;
    paramString = af.bDy();
    paramm = new btm();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      asw localasw = (asw)((Iterator)localObject).next();
      paramm.sve.add(localasw);
    }
    paramString.a(paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.i
 * JD-Core Version:    0.7.0.1
 */