package com.tencent.mm.plugin.sns.ui.a.b;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
  extends b
{
  private boolean DEBUG = false;
  private String ELj;
  private List<String> EQI = new ArrayList();
  private bk ESO;
  private int ESP = (int)(System.currentTimeMillis() / 1000L);
  private boolean ESQ = false;
  private volatile boolean ESR = false;
  private byte[] ESS = new byte[0];
  public HashMap<String, Boolean> EST = new HashMap();
  protected HashMap<String, String> ESU = new HashMap();
  private String ESV = "";
  private String ESW = "";
  protected volatile String EvF = "";
  protected volatile String EvG = "";
  protected volatile String EvH = "";
  protected volatile String EvI = "";
  private bv iFD;
  private Context mContext;
  protected volatile String sNG = "";
  
  public a(SnsInfo paramSnsInfo)
  {
    super(paramSnsInfo);
    hdm();
  }
  
  private void amZ()
  {
    synchronized (this.ESS)
    {
      Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by initData");
      if (Util.isNullOrNil(this.EvI)) {
        this.sNG = L(0L, this.sNG);
      }
      return;
    }
  }
  
  public final void a(Context paramContext, bk parambk, String paramString)
  {
    this.mContext = paramContext;
    this.ESO = parambk;
    this.ELj = paramString;
    g.aAi();
    this.iFD = ((l)g.af(l.class)).aSN();
  }
  
  public final void aRi(String paramString)
  {
    this.EvF = paramString;
  }
  
  public final void aRj(String paramString)
  {
    Log.i("MicroMsg.SnsTimeLineVendingSide", "setUnreadBottomSeq:[%s, %s]", new Object[] { paramString, Long.valueOf(r.aOw(paramString)) });
    this.EvG = paramString;
  }
  
  public final void aRk(String paramString)
  {
    Log.i("MicroMsg.SnsTimeLineVendingSide", "setUnreadTopSeq:[%s, %s]", new Object[] { paramString, Long.valueOf(r.aOw(paramString)) });
    this.EvH = paramString;
  }
  
  public final void aRl(String paramString)
  {
    synchronized (this.ESS)
    {
      this.sNG = paramString;
      return;
    }
  }
  
  public final void aRm(String paramString)
  {
    synchronized (this.ESS)
    {
      this.EvI = paramString;
      return;
    }
  }
  
  public final void axJ()
  {
    looperCheckForVending();
    Log.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", new Object[] { Boolean.valueOf(this.ESR) });
    if (this.ESR) {
      return;
    }
    synchronized (this.ESS)
    {
      Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by resetSize");
      this.sNG = L(0L, this.sNG);
      return;
    }
  }
  
  public void destroyAsynchronous()
  {
    super.destroyAsynchronous();
    c.hue.aBj();
    this.EST.clear();
    this.mContext = null;
    this.ESO = null;
    this.iFD = null;
    this.QYM = null;
  }
  
  public final void fiE()
  {
    long l2 = 0L;
    looperCheckForVending();
    int i = aj.faZ().DNF;
    long l1;
    if (i == ax.DOd)
    {
      l1 = aj.faZ().DNE;
      Log.printDebugStack("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeqWithoutFault", new Object[0]);
      Log.d("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeqWithoutFault %s %s", new Object[] { Integer.valueOf(aj.faE().fbw()), this.sNG });
      this.sNG = r.Jc(aj.faO().g(l1, aj.faE().fbw(), false));
      this.sNG = this.sNG;
      this.EvI = r.Jc(l1);
      Log.d("MicroMsg.SnsTimeLineVendingSide", "unreadTipFaultItem.end:%s, upLimitSeq:%s, downLimitSeq:%s", new Object[] { Long.valueOf(l1), Long.valueOf(r.aOw(this.EvI)), Long.valueOf(r.aOw(this.sNG)) });
      return;
    }
    label170:
    int j;
    if (i == ax.DOf)
    {
      if (this.mCount == 0)
      {
        l1 = 0L;
        this.ESR = true;
        synchronized (this.ESS)
        {
          Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by addSizeByNormal");
          this.sNG = L(l1, this.sNG);
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
        if (i != ax.DOe) {
          break;
        }
        if (this.mCount == 0)
        {
          l1 = l2;
          synchronized (this.ESS)
          {
            this.EvI = JV(l1);
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
  
  public final String fkd()
  {
    return this.EvG;
  }
  
  public final String fke()
  {
    return this.EvH;
  }
  
  public final String fkf()
  {
    return this.sNG;
  }
  
  public final String fkg()
  {
    return this.EvI;
  }
  
  public final String fkh()
  {
    return this.EvF;
  }
  
  public Cursor fki()
  {
    long l = System.currentTimeMillis();
    init();
    Object localObject4;
    Object localObject3;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (!Util.isNullOrNil(this.EvI))
    {
      localObject4 = aj.faO();
      String str2 = this.sNG;
      String str1 = this.EvI;
      localObject3 = new int[2];
      bool = n.aQw(str1);
      localObject2 = n.feT();
      localObject1 = localObject2;
      if (n.aQw(str2)) {
        localObject1 = (String)localObject2 + " AND " + ((n)localObject4).aQx(str2);
      }
      localObject2 = localObject1;
      if (bool) {
        localObject2 = (String)localObject1 + " AND " + ((n)localObject4).aQB(str1);
      }
      localObject1 = (String)localObject2 + " AND  (snsId != 0 ) ";
      localObject1 = (String)localObject1 + n.Emv;
      localObject2 = ((n)localObject4).iFy.rawQuery((String)localObject1, null, 2);
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
          Log.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", new Object[] { Integer.valueOf(this.ESP), Integer.valueOf(j), this.sNG });
          try
          {
            com.tencent.mm.plugin.sns.ad.e.a.G(this.ESP, j, this.ELj);
            this.ESP = j;
            Log.i("MicroMsg.SnsTimeLineVendingSide", "up:%s, down:%s, upCreateTime:%s, downCreateTime:%s", new Object[] { Long.valueOf(r.aOw(this.EvI)), Long.valueOf(r.aOw(this.sNG)), Integer.valueOf(i), Integer.valueOf(j) });
            localObject1 = aj.faO().q(this.sNG, this.EvI, j, i);
            Log.i("MicroMsg.SnsTimeLineVendingSide", "prepareCursorAsynchronous %s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)) });
            Log.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
            localObject2 = k.tO(500);
            if (((k)localObject2).bfG())
            {
              i = this.mCount;
              if (i == 0)
              {
                ((k)localObject2).tR(0).tR(0).tR(0);
                ((k)localObject2).bfK();
              }
            }
            else
            {
              localObject2 = aj.faZ();
              if (((aw)localObject2).DNn) {
                ((aw)localObject2).DNy.clear();
              }
              return localObject1;
              j = aj.faO().aQC(this.sNG);
              i = 0;
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.e("MicroMsg.SnsTimeLineVendingSide", "checkDeleteExpireAdByPage exp=" + localThrowable.toString());
              continue;
              localObject3 = r.v((SnsInfo)getItem(1));
              localObject4 = r.v((SnsInfo)getItem(i - 1));
              if ((!((String)localObject3).equals(this.ESV)) || (!((String)localObject4).equals(this.ESW)))
              {
                this.ESV = ((String)localObject3);
                this.ESW = ((String)localObject4);
                ((k)localObject2).tR(i).PH((String)localObject3).PH((String)localObject4);
                ((k)localObject2).bfK();
              }
            }
          }
        }
      }
    }
  }
  
  protected final void init()
  {
    if (!this.ESQ)
    {
      amZ();
      this.ESQ = true;
    }
  }
  
  public final void vD(boolean paramBoolean)
  {
    this.ESR = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.a
 * JD-Core Version:    0.7.0.1
 */