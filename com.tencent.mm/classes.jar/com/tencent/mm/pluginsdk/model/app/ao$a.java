package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class ao$a
  implements f
{
  private static int bEa = 0;
  Queue<Long> bDS = new LinkedList();
  Queue<Long> bDT = new LinkedList();
  Map<Long, g.a> bDU = new HashMap();
  private boolean bDV = false;
  private boolean bDW = false;
  private boolean bDX = false;
  int bDY = 0;
  private long bDZ = 0L;
  g.a bEc = new g.a();
  private am bEd = new am(au.DS().mnU.getLooper(), new ao.a.4(this), false);
  private HashMap<Long, String> rVe = new HashMap();
  
  public ao$a()
  {
    au.Dk().a(220, this);
    au.Dk().a(221, this);
    au.Dk().a(222, this);
  }
  
  public static void C(long paramLong, String paramString)
  {
    au.Dk().a(new ai(paramLong, paramString, null), 0);
  }
  
  public static void b(long paramLong, String paramString1, String paramString2)
  {
    au.Dk().a(new ai(paramLong, paramString1, paramString2), 0);
  }
  
  private boolean ckZ()
  {
    for (;;)
    {
      try
      {
        localObject2 = ap.avh().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
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
        y.printErrStackTrace("MicroMsg.SceneAppMsg", localIllegalStateException, "", new Object[0]);
        Object localObject1 = ap.avh();
        Object localObject2 = " update appattach set status = 198 , lastModifyTime = " + bk.UX() + " where status = 101";
        ((c)localObject1).dXw.gk("appattach", (String)localObject2);
        ((c)localObject1).doNotify();
        localObject1 = null;
        continue;
        long l = System.currentTimeMillis() / 1000L;
        localObject2 = bk.hs(l);
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        b localb = (b)((Iterator)localObject1).next();
        if (!this.bDU.containsKey(Long.valueOf(localb.ujK))) {
          continue;
        }
        y.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + localb.ujK);
        continue;
        y.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + localb.field_fileFullPath + " status:" + localb.field_status + " create:(" + bk.hs(localb.field_createTime) + "," + bk.hs(localb.field_createTime / 1000L) + ", last:" + bk.hs(localb.field_lastModifyTime) + " now:" + bk.hs(l) + " " + (l - localb.field_lastModifyTime));
        if (!localb.field_isUpload) {
          continue;
        }
        if ((l - localb.field_lastModifyTime <= 600L) || (localb.field_status != 101L)) {
          continue;
        }
        y.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + localb.field_fileFullPath + " last:" + bk.hs(localb.field_lastModifyTime) + " now:" + (String)localObject2);
        l.hb(localb.ujK);
        continue;
        this.bDS.offer(Long.valueOf(localb.ujK));
        this.bDU.put(Long.valueOf(localb.ujK), null);
        continue;
        y.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.bDU.size() + " [recv:" + this.bDT.size() + ",send:" + this.bDS.size() + "]");
        if (this.bDT.size() + this.bDS.size() != 0) {
          break label677;
        }
        return false;
      }
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        continue;
      }
      return false;
      j = ((Cursor)localObject2).getCount();
      y.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:" + j);
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
          localb.d((Cursor)localObject2);
          localArrayList.add(localb);
          i += 1;
        }
        else
        {
          ((Cursor)localObject2).close();
        }
      }
    }
    label677:
    return true;
  }
  
  public static void hd(long paramLong)
  {
    au.Dk().a(new ai(paramLong, null, null), 0);
  }
  
  private void uB()
  {
    this.bDU.clear();
    this.bDS.clear();
    this.bDT.clear();
    this.bDW = false;
    this.bDV = false;
    this.bDX = false;
    y.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.bEc.zJ());
  }
  
  public final void B(long paramLong, String paramString)
  {
    this.rVe.put(Long.valueOf(paramLong), paramString);
  }
  
  protected final void finalize()
  {
    au.Dk().b(220, this);
    au.Dk().b(221, this);
    au.Dk().b(222, this);
    this.rVe.clear();
    super.finalize();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    au.DS().O(new ao.a.2(this, paramm, paramInt1, paramInt2));
  }
  
  public final void run()
  {
    au.DS().O(new ao.a.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao.a
 * JD-Core Version:    0.7.0.1
 */