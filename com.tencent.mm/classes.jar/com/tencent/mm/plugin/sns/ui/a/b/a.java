package com.tencent.mm.plugin.sns.ui.a.b;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
  extends b
{
  private boolean DEBUG = false;
  protected volatile String KJw = "";
  protected volatile String KJx = "";
  protected volatile String KJy = "";
  protected volatile String KJz = "";
  private String KZk;
  private List<String> LeH = new ArrayList();
  private bm LgP;
  private int LgQ = (int)(System.currentTimeMillis() / 1000L);
  private boolean LgR = false;
  private volatile boolean LgS = false;
  private byte[] LgT = new byte[0];
  public HashMap<String, Boolean> LgU = new HashMap();
  protected HashMap<String, String> LgV = new HashMap();
  private String LgW = "";
  private String LgX = "";
  private bv lvF;
  private Context mContext;
  protected volatile String wtB = "";
  
  public a(SnsInfo paramSnsInfo)
  {
    super(paramSnsInfo);
    iet();
  }
  
  private void ata()
  {
    synchronized (this.LgT)
    {
      Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by initData");
      if (Util.isNullOrNil(this.KJz)) {
        this.wtB = T(0L, this.wtB);
      }
      return;
    }
  }
  
  public final void a(Context paramContext, bm parambm, String paramString)
  {
    this.mContext = paramContext;
    this.LgP = parambm;
    this.KZk = paramString;
    com.tencent.mm.kernel.h.aHH();
    this.lvF = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL();
  }
  
  public final void aFa()
  {
    looperCheckForVending();
    Log.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", new Object[] { Boolean.valueOf(this.LgS) });
    if (this.LgS) {
      return;
    }
    synchronized (this.LgT)
    {
      Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by resetSize");
      this.wtB = T(0L, this.wtB);
      return;
    }
  }
  
  public final void bck(String paramString)
  {
    this.KJw = paramString;
  }
  
  public final void bcl(String paramString)
  {
    Log.i("MicroMsg.SnsTimeLineVendingSide", "setUnreadBottomSeq:[%s, %s]", new Object[] { paramString, Long.valueOf(t.aZs(paramString)) });
    this.KJx = paramString;
  }
  
  public final void bcm(String paramString)
  {
    Log.i("MicroMsg.SnsTimeLineVendingSide", "setUnreadTopSeq:[%s, %s]", new Object[] { paramString, Long.valueOf(t.aZs(paramString)) });
    this.KJy = paramString;
  }
  
  public final void bcn(String paramString)
  {
    synchronized (this.LgT)
    {
      this.wtB = paramString;
      return;
    }
  }
  
  public final void bco(String paramString)
  {
    synchronized (this.LgT)
    {
      this.KJz = paramString;
      return;
    }
  }
  
  public void destroyAsynchronous()
  {
    super.destroyAsynchronous();
    com.tencent.mm.kiss.widget.textview.c.kfZ.aIM();
    this.LgU.clear();
    this.mContext = null;
    this.LgP = null;
    this.lvF = null;
    this.Yzc = null;
  }
  
  public final void fWS()
  {
    long l2 = 0L;
    looperCheckForVending();
    int i = aj.fOT().KaH;
    long l1;
    if (i == aw.Kbj)
    {
      l1 = aj.fOT().KaG;
      Log.printDebugStack("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeqWithoutFault", new Object[0]);
      Log.d("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeqWithoutFault %s %s", new Object[] { Integer.valueOf(aj.fOy().fPp()), this.wtB });
      this.wtB = t.Qv(aj.fOI().g(l1, aj.fOy().fPp(), false));
      this.wtB = this.wtB;
      this.KJz = t.Qv(l1);
      Log.d("MicroMsg.SnsTimeLineVendingSide", "unreadTipFaultItem.end:%s, upLimitSeq:%s, downLimitSeq:%s", new Object[] { Long.valueOf(l1), Long.valueOf(t.aZs(this.KJz)), Long.valueOf(t.aZs(this.wtB)) });
      return;
    }
    label170:
    int j;
    if (i == aw.Kbl)
    {
      if (this.mCount == 0)
      {
        l1 = 0L;
        this.LgS = true;
        synchronized (this.LgT)
        {
          Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by addSizeByNormal");
          this.wtB = T(l1, this.wtB);
          return;
        }
      }
      i = this.mCount - 1;
      j = 0;
    }
    for (;;)
    {
      ??? = (SnsInfo)getItem(i);
      if ((??? != null) && (!((SnsInfo)???).isSourceExist(32)) && (((SnsInfo)???).field_snsId != 0L))
      {
        l1 = ((SnsInfo)???).field_snsId;
        Log.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", new Object[] { Long.valueOf(l1), ((SnsInfo)???).getStringSeq() });
        break label170;
      }
      j += 1;
      i -= 1;
      if ((i < 0) || (j > 500))
      {
        l1 = 0L;
        break label170;
        if (i != aw.Kbk) {
          break;
        }
        if (this.mCount == 0)
        {
          l1 = l2;
          synchronized (this.LgT)
          {
            this.KJz = Rp(l1);
            return;
          }
        }
        i = 0;
        j = 0;
        for (;;)
        {
          ??? = (SnsInfo)getItem(i);
          if ((??? != null) && (!((SnsInfo)???).isSourceExist(32)) && (((SnsInfo)???).field_snsId != 0L))
          {
            l1 = ((SnsInfo)???).field_snsId;
            Log.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", new Object[] { Long.valueOf(l1), ((SnsInfo)???).getStringSeq() });
            break;
          }
          j += 1;
          i += 1;
          l1 = l2;
          if (i >= this.mCount) {
            break;
          }
          l1 = l2;
          if (j > 500) {
            break;
          }
        }
      }
    }
  }
  
  public final String fYm()
  {
    return this.KJx;
  }
  
  public final String fYn()
  {
    return this.KJy;
  }
  
  public final String fYo()
  {
    return this.wtB;
  }
  
  public final String fYp()
  {
    return this.KJz;
  }
  
  public final String fYq()
  {
    return this.KJw;
  }
  
  public Cursor fYr()
  {
    long l = System.currentTimeMillis();
    init();
    Object localObject4;
    Object localObject3;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (!Util.isNullOrNil(this.KJz))
    {
      localObject4 = aj.fOI();
      String str2 = this.wtB;
      String str1 = this.KJz;
      localObject3 = new int[2];
      bool = com.tencent.mm.plugin.sns.storage.n.bbw(str1);
      localObject2 = com.tencent.mm.plugin.sns.storage.n.fSO();
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.storage.n.bbw(str2)) {
        localObject1 = (String)localObject2 + " AND " + ((com.tencent.mm.plugin.sns.storage.n)localObject4).bbx(str2);
      }
      localObject2 = localObject1;
      if (bool) {
        localObject2 = (String)localObject1 + " AND " + ((com.tencent.mm.plugin.sns.storage.n)localObject4).bbB(str1);
      }
      localObject1 = (String)localObject2 + " AND  (snsId != 0 ) ";
      localObject1 = (String)localObject1 + com.tencent.mm.plugin.sns.storage.n.KzE;
      localObject2 = ((com.tencent.mm.plugin.sns.storage.n)localObject4).lvy.rawQuery((String)localObject1, null, 2);
      if (!((Cursor)localObject2).moveToFirst()) {
        break label706;
      }
      localObject4 = new SnsInfo();
      ((SnsInfo)localObject4).convertFrom((Cursor)localObject2);
    }
    label706:
    for (int i = ((SnsInfo)localObject4).field_createTime;; i = 0)
    {
      if ((bool) && (((Cursor)localObject2).moveToLast()))
      {
        localObject4 = new SnsInfo();
        ((SnsInfo)localObject4).convertFrom((Cursor)localObject2);
      }
      for (int j = ((SnsInfo)localObject4).field_createTime;; j = 0)
      {
        ((Cursor)localObject2).close();
        Log.i("MicroMsg.SnsInfoStorage", "getLastAndFirstTime " + (String)localObject1 + " downCreatetime " + i + " upCreatetime " + j);
        localObject3[0] = i;
        localObject3[1] = j;
        j = localObject3[0];
        i = localObject3[1];
        for (;;)
        {
          Log.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", new Object[] { Integer.valueOf(this.LgQ), Integer.valueOf(j), this.wtB });
          try
          {
            com.tencent.mm.plugin.sns.ad.d.c.H(this.LgQ, j, this.KZk);
            this.LgQ = j;
            Log.i("MicroMsg.SnsTimeLineVendingSide", "up:%s, down:%s, upCreateTime:%s, downCreateTime:%s", new Object[] { Long.valueOf(t.aZs(this.KJz)), Long.valueOf(t.aZs(this.wtB)), Integer.valueOf(i), Integer.valueOf(j) });
            localObject1 = aj.fOI().q(this.wtB, this.KJz, j, i);
            Log.i("MicroMsg.SnsTimeLineVendingSide", "prepareCursorAsynchronous %s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)) });
            Log.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
            localObject2 = l.wO(500);
            if (((l)localObject2).boW())
            {
              i = this.mCount;
              if (i == 0)
              {
                ((l)localObject2).wR(0).wR(0).wR(0);
                ((l)localObject2).bpa();
              }
            }
            else
            {
              localObject2 = aj.fOT();
              if (((av)localObject2).Kap) {
                ((av)localObject2).KaA.clear();
              }
              return localObject1;
              j = aj.fOI().bbC(this.wtB);
              i = 0;
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.e("MicroMsg.SnsTimeLineVendingSide", "checkDeleteExpireAdByPage exp=" + localThrowable.toString());
              continue;
              localObject3 = t.w((SnsInfo)getItem(1));
              localObject4 = t.w((SnsInfo)getItem(i - 1));
              if ((!((String)localObject3).equals(this.LgW)) || (!((String)localObject4).equals(this.LgX)))
              {
                this.LgW = ((String)localObject3);
                this.LgX = ((String)localObject4);
                ((l)localObject2).wR(i).Xf((String)localObject3).Xf((String)localObject4);
                ((l)localObject2).bpa();
              }
            }
          }
        }
      }
    }
  }
  
  protected final void init()
  {
    if (!this.LgR)
    {
      ata();
      this.LgR = true;
    }
  }
  
  public final void zh(boolean paramBoolean)
  {
    this.LgS = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.a
 * JD-Core Version:    0.7.0.1
 */