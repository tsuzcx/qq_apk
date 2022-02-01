package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class aq
{
  public static String TAG = "MicroMsg.SnsRetryEditTipManager";
  public static long zlA = 300000L;
  public static boolean zlB = false;
  public static int zlC = 60;
  public static long zlx = -1L;
  public static long zly = -1L;
  public static int zlz = 0;
  public long zlD;
  public String zlE;
  public p zlF;
  public String zlG;
  public Runnable zlH;
  
  public aq()
  {
    AppMethodBeat.i(197855);
    this.zlD = 0L;
    this.zlE = "";
    this.zlF = null;
    this.zlG = "";
    this.zlH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197853);
        ad.i(aq.TAG, "run resetTask");
        aq.a(aq.this);
        aq.b(aq.this);
        aq.dUN();
        aq.c(aq.this);
        aq.a(aq.this, "");
        AppMethodBeat.o(197853);
      }
    };
    AppMethodBeat.o(197855);
  }
  
  public static boolean p(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = false;
    if (!zlB) {
      bool1 = bool3;
    }
    do
    {
      return bool1;
      if (zly != -1L) {
        break;
      }
      bool1 = bool2;
      if (zlx != -1L)
      {
        bool1 = bool2;
        if (zlz != 0)
        {
          bool1 = bool2;
          if (paramLong <= zlx)
          {
            bool1 = bool2;
            if (paramInt1 < zlz) {
              bool1 = true;
            }
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        zly = paramInt2;
        bool2 = bool1;
      }
      bool1 = bool2;
    } while (!bool2);
    e.ztz.zug.eoS += 1L;
    return bool2;
    if (paramInt2 == zly) {}
    for (;;)
    {
      bool2 = bool1;
      break;
      bool1 = false;
    }
  }
  
  final void dUM()
  {
    AppMethodBeat.i(197856);
    final String str = this.zlE;
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197854);
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyR, true);
        ad.i(aq.TAG, "removeDraftTmpFile clear:%s finalDraftKey:%s", new Object[] { Boolean.valueOf(bool), str });
        if (bool)
        {
          Object localObject1 = ag.dUl().aAb(str);
          if (localObject1 != null)
          {
            localObject1 = ((l)localObject1).field_draft;
            if (!bt.cC((byte[])localObject1))
            {
              Object localObject2 = Parcel.obtain();
              ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
              ((Parcel)localObject2).setDataPosition(0);
              try
              {
                localObject2 = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2);
                localObject1 = ((Intent)localObject2).getStringExtra("KSightThumbPath");
                localObject2 = ((Intent)localObject2).getStringExtra("KSightPath");
                ad.i(aq.TAG, "delete %s, %s", new Object[] { localObject1, localObject2 });
                com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.xRl;
                com.tencent.mm.plugin.recordvideo.e.b.avT((String)localObject2);
                localObject2 = com.tencent.mm.plugin.recordvideo.e.b.xRl;
                com.tencent.mm.plugin.recordvideo.e.b.avT((String)localObject1);
                AppMethodBeat.o(197854);
                return;
              }
              catch (Exception localException)
              {
                ag.dUl().b(str, null, 0);
              }
            }
          }
        }
        AppMethodBeat.o(197854);
      }
    });
    AppMethodBeat.o(197856);
  }
  
  public final void reset()
  {
    zlx = -1L;
    zlz = 0;
    zly = -1L;
    this.zlE = "";
    this.zlD = 0L;
  }
  
  public final void w(p paramp)
  {
    AppMethodBeat.i(197857);
    if ((!zlB) || (paramp == null))
    {
      AppMethodBeat.o(197857);
      return;
    }
    zly = -1L;
    zlx = paramp.field_snsId;
    zlz = paramp.field_createTime;
    this.zlD = bt.flT();
    this.zlE = "draft_retry_edit";
    Object localObject = ag.dUl();
    l locall = ((m)localObject).aAb("draft_sent_".concat(String.valueOf(paramp.zMC)));
    if (locall != null) {
      ((m)localObject).b("draft_retry_edit", locall.field_draft, 0);
    }
    com.tencent.mm.sdk.platformtools.aq.o(this.zlH, zlA);
    localObject = ak.v(paramp);
    this.zlG = e.ztz.zug.dVa;
    if (localObject != null)
    {
      this.zlF = paramp;
      e.ztz.zug.ph(q.zx(paramp.field_snsId));
      e.ztz.zug.eoO = ((SnsObject)localObject).LikeCount;
      e.ztz.zug.eoP = ((SnsObject)localObject).CommentCount;
      e.ztz.zug.pj(String.valueOf(System.currentTimeMillis()));
      e.ztz.zuh.ph(q.zx(paramp.field_snsId));
      e.ztz.zuh.eoO = ((SnsObject)localObject).LikeCount;
      e.ztz.zuh.eoP = ((SnsObject)localObject).CommentCount;
      e.ztz.zuh.pj(String.valueOf(System.currentTimeMillis()));
    }
    ad.i(TAG, "prepareRetryEditInfo draftKey:%s", new Object[] { this.zlE });
    AppMethodBeat.o(197857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq
 * JD-Core Version:    0.7.0.1
 */