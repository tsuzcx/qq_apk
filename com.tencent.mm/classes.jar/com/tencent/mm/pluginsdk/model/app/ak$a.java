package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class ak$a
  implements f
{
  private static int ckO = 0;
  Queue<Long> ckH;
  Queue<Long> ckI;
  Map<Long, g.a> ckJ;
  private boolean ckK;
  private boolean ckL;
  int ckM;
  private long ckN;
  g.a ckQ;
  private ap ckR;
  private boolean running;
  private HashMap<Long, String> vLR;
  
  public ak$a()
  {
    AppMethodBeat.i(27401);
    this.vLR = new HashMap();
    this.ckH = new LinkedList();
    this.ckI = new LinkedList();
    this.ckJ = new HashMap();
    this.ckK = false;
    this.ckL = false;
    this.running = false;
    this.ckM = 0;
    this.ckN = 0L;
    this.ckQ = new g.a();
    this.ckR = new ap(aw.RO().oNc.getLooper(), new ak.a.4(this), false);
    aw.Rc().a(220, this);
    aw.Rc().a(221, this);
    aw.Rc().a(222, this);
    AppMethodBeat.o(27401);
  }
  
  public static void B(long paramLong, String paramString)
  {
    AppMethodBeat.i(27405);
    aw.Rc().a(new ae(paramLong, paramString, null), 0);
    AppMethodBeat.o(27405);
  }
  
  private void ET()
  {
    AppMethodBeat.i(27409);
    this.ckJ.clear();
    this.ckH.clear();
    this.ckI.clear();
    this.ckL = false;
    this.ckK = false;
    this.running = false;
    ab.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.ckQ.Mm());
    AppMethodBeat.o(27409);
  }
  
  public static void c(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(27406);
    aw.Rc().a(new ae(paramLong, paramString1, paramString2), 0);
    AppMethodBeat.o(27406);
  }
  
  private boolean dlI()
  {
    AppMethodBeat.i(27407);
    for (;;)
    {
      try
      {
        localObject2 = al.aUJ().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
        if (localObject2 != null) {
          continue;
        }
        localArrayList = null;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        ArrayList localArrayList;
        int j;
        int i;
        ab.printErrStackTrace("MicroMsg.SceneAppMsg", localIllegalStateException, "", new Object[0]);
        Object localObject1 = al.aUJ();
        Object localObject2 = " update appattach set status = 198 , lastModifyTime = " + bo.aox() + " where status = 101";
        ((c)localObject1).db.execSQL("appattach", (String)localObject2);
        ((c)localObject1).doNotify();
        localObject1 = null;
        continue;
        long l = System.currentTimeMillis() / 1000L;
        localObject2 = bo.nU(l);
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        b localb = (b)((Iterator)localObject1).next();
        if (!this.ckJ.containsKey(Long.valueOf(localb.systemRowid))) {
          continue;
        }
        ab.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + localb.systemRowid);
        continue;
        ab.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + localb.field_fileFullPath + " status:" + localb.field_status + " create:(" + bo.nU(localb.field_createTime) + "," + bo.nU(localb.field_createTime / 1000L) + ", last:" + bo.nU(localb.field_lastModifyTime) + " now:" + bo.nU(l) + " " + (l - localb.field_lastModifyTime));
        if (!localb.field_isUpload) {
          continue;
        }
        if ((l - localb.field_lastModifyTime <= 600L) || (localb.field_status != 101L)) {
          continue;
        }
        ab.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + localb.field_fileFullPath + " last:" + bo.nU(localb.field_lastModifyTime) + " now:" + (String)localObject2);
        l.kX(localb.systemRowid);
        continue;
        this.ckH.offer(Long.valueOf(localb.systemRowid));
        this.ckJ.put(Long.valueOf(localb.systemRowid), null);
        continue;
        ab.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.ckJ.size() + " [recv:" + this.ckI.size() + ",send:" + this.ckH.size() + "]");
        if (this.ckI.size() + this.ckH.size() != 0) {
          continue;
        }
        AppMethodBeat.o(27407);
        return false;
        AppMethodBeat.o(27407);
      }
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        continue;
      }
      AppMethodBeat.o(27407);
      return false;
      j = ((Cursor)localObject2).getCount();
      ab.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
      if (j == 0)
      {
        ((Cursor)localObject2).close();
        localArrayList = null;
      }
      else
      {
        localArrayList = new ArrayList();
        i = 0;
        if (i < j)
        {
          ((Cursor)localObject2).moveToPosition(i);
          localb = new b();
          localb.convertFrom((Cursor)localObject2);
          localArrayList.add(localb);
          i += 1;
        }
        else
        {
          ((Cursor)localObject2).close();
        }
      }
    }
    return true;
  }
  
  public static void kW(long paramLong)
  {
    AppMethodBeat.i(27404);
    aw.Rc().a(new ae(paramLong, null, null), 0);
    AppMethodBeat.o(27404);
  }
  
  public final void A(long paramLong, String paramString)
  {
    AppMethodBeat.i(27403);
    this.vLR.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(27403);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(27402);
    aw.Rc().b(220, this);
    aw.Rc().b(221, this);
    aw.Rc().b(222, this);
    this.vLR.clear();
    super.finalize();
    AppMethodBeat.o(27402);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(27408);
    ab.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    aw.RO().ac(new ak.a.2(this, paramm, paramInt1, paramInt2));
    AppMethodBeat.o(27408);
  }
  
  public final void run()
  {
    AppMethodBeat.i(27410);
    aw.RO().ac(new ak.a.3(this));
    AppMethodBeat.o(27410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak.a
 * JD-Core Version:    0.7.0.1
 */