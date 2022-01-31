package com.tencent.mm.plugin.sns.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class a
  extends com.tencent.mm.vending.app.a
  implements f
{
  String ikj;
  boolean rHl;
  String rXD;
  boolean rXE;
  int rXF;
  protected volatile an.a sbY;
  public volatile com.tencent.mm.plugin.sns.ui.a.b.b sds;
  private h.a sns;
  
  static c.b cxP()
  {
    AppMethodBeat.i(40535);
    c.b localb = new c.b();
    Object localObject4 = ag.cpk().css();
    int j = ((Cursor)localObject4).getCount();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (j > 0)
    {
      ((Cursor)localObject4).moveToFirst();
      localObject1 = new j();
      ((j)localObject1).convertFrom((Cursor)localObject4);
    }
    Object localObject2;
    try
    {
      localObject1 = ((cdm)new cdm().parseFrom(((j)localObject1).field_curActionBuf)).xCG;
      ((Cursor)localObject4).close();
      localObject3 = ((String)g.RL().Ru().get(ac.a.yKm, "")).split("&");
      localObject4 = new ArrayList();
      int i = 2;
      while (i < localObject3.length)
      {
        long l = bo.getLong(localObject3[i], 0L);
        if (l != 0L) {
          ((List)localObject4).add(Long.valueOf(l));
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SnsTimelineInteractor", localException, "", new Object[0]);
        localObject2 = localObject3;
      }
      Collections.reverse((List)localObject4);
      if (((List)localObject4).size() <= 0) {}
    }
    for (localObject3 = (Long)((List)localObject4).get(0);; localObject3 = null)
    {
      i.h((Long)localObject3);
      localb.snz = j;
      localb.sny = localObject2;
      localb.snA = ((List)localObject4);
      AppMethodBeat.o(40535);
      return localb;
    }
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(40532);
    this.sbY = ag.coV();
    c.a locala = (c.a)m(c.a.class);
    this.sns = parama;
    this.sbY.a(1, locala.ikj, this.sns);
    AppMethodBeat.o(40532);
  }
  
  public final an.a coV()
  {
    return this.sbY;
  }
  
  public final void g(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(40537);
    this.sbY.a(1, paramString, paramBoolean, paramInt);
    AppMethodBeat.o(40537);
  }
  
  public final void h(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(40538);
    this.sbY.b(1, paramString, paramBoolean, paramInt);
    AppMethodBeat.o(40538);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(40533);
    super.onCreate();
    a(c.b.class, new a.1(this));
    a(c.a.class, new a.2(this));
    ab.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", new Object[] { this });
    com.tencent.mm.plugin.sns.model.b localb = ag.cpa();
    synchronized (localb.eFQ)
    {
      localb.rdb.clear();
      ag.cpa();
      AppMethodBeat.o(40533);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(40534);
    ab.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", new Object[] { this });
    g.RM();
    if ((g.RJ().QU()) && (this.sbY != null) && (this.sns != null)) {
      this.sbY.a(this.sns, 1);
    }
    super.onDestroy();
    AppMethodBeat.o(40534);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40536);
    ab.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm.toString() });
    AppMethodBeat.o(40536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.a
 * JD-Core Version:    0.7.0.1
 */