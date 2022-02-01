package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class ar
{
  public static String TAG = "MicroMsg.SnsRetryEditTipManager";
  public static long zCM = -1L;
  public static long zCN = -1L;
  public static int zCO = 0;
  public static long zCP = 300000L;
  public static boolean zCQ = false;
  public static int zCR = 60;
  public long zCS;
  public String zCT;
  public p zCU;
  public String zCV;
  public Runnable zCW;
  
  public ar()
  {
    AppMethodBeat.i(219348);
    this.zCS = 0L;
    this.zCT = "";
    this.zCU = null;
    this.zCV = "";
    this.zCW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219346);
        ae.i(ar.TAG, "run resetTask");
        ar.a(ar.this);
        ar.b(ar.this);
        ar.dYn();
        ar.c(ar.this);
        ar.a(ar.this, "");
        AppMethodBeat.o(219346);
      }
    };
    AppMethodBeat.o(219348);
  }
  
  public static boolean p(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = false;
    if (!zCQ) {
      bool1 = bool3;
    }
    do
    {
      return bool1;
      if (zCN != -1L) {
        break;
      }
      bool1 = bool2;
      if (zCM != -1L)
      {
        bool1 = bool2;
        if (zCO != 0)
        {
          bool1 = bool2;
          if (paramLong <= zCM)
          {
            bool1 = bool2;
            if (paramInt1 < zCO) {
              bool1 = true;
            }
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        zCN = paramInt2;
        bool2 = bool1;
      }
      bool1 = bool2;
    } while (!bool2);
    e.zKO.zLx.eqz += 1L;
    return bool2;
    if (paramInt2 == zCN) {}
    for (;;)
    {
      bool2 = bool1;
      break;
      bool1 = false;
    }
  }
  
  final void dYm()
  {
    AppMethodBeat.i(219349);
    final String str = this.zCT;
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219347);
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFX, true);
        ae.i(ar.TAG, "removeDraftTmpFile clear:%s finalDraftKey:%s", new Object[] { Boolean.valueOf(bool), str });
        if (bool)
        {
          Object localObject1 = ah.dXL().aBs(str);
          if (localObject1 != null)
          {
            localObject1 = ((l)localObject1).field_draft;
            if (!bu.cF((byte[])localObject1))
            {
              Object localObject2 = Parcel.obtain();
              ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
              ((Parcel)localObject2).setDataPosition(0);
              try
              {
                localObject2 = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2);
                localObject1 = ((Intent)localObject2).getStringExtra("KSightThumbPath");
                localObject2 = ((Intent)localObject2).getStringExtra("KSightPath");
                ae.i(ar.TAG, "delete %s, %s", new Object[] { localObject1, localObject2 });
                com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.yhe;
                com.tencent.mm.plugin.recordvideo.e.b.axi((String)localObject2);
                localObject2 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
                com.tencent.mm.plugin.recordvideo.e.b.axi((String)localObject1);
                AppMethodBeat.o(219347);
                return;
              }
              catch (Exception localException)
              {
                ah.dXL().b(str, null, 0);
              }
            }
          }
        }
        AppMethodBeat.o(219347);
      }
    });
    AppMethodBeat.o(219349);
  }
  
  public final void reset()
  {
    zCM = -1L;
    zCO = 0;
    zCN = -1L;
    this.zCT = "";
    this.zCS = 0L;
  }
  
  public final void w(p paramp)
  {
    AppMethodBeat.i(219350);
    if ((!zCQ) || (paramp == null))
    {
      AppMethodBeat.o(219350);
      return;
    }
    zCN = -1L;
    zCM = paramp.field_snsId;
    zCO = paramp.field_createTime;
    this.zCS = bu.fpO();
    this.zCT = "draft_retry_edit";
    Object localObject = ah.dXL();
    l locall = ((m)localObject).aBs("draft_sent_".concat(String.valueOf(paramp.AdJ)));
    if (locall != null) {
      ((m)localObject).b("draft_retry_edit", locall.field_draft, 0);
    }
    com.tencent.mm.sdk.platformtools.ar.o(this.zCW, zCP);
    localObject = al.v(paramp);
    this.zCV = e.zKO.zLx.dWq;
    if (localObject != null)
    {
      this.zCU = paramp;
      e.zKO.zLx.pD(r.zW(paramp.field_snsId));
      e.zKO.zLx.eqv = ((SnsObject)localObject).LikeCount;
      e.zKO.zLx.eqw = ((SnsObject)localObject).CommentCount;
      e.zKO.zLx.pF(String.valueOf(System.currentTimeMillis()));
      e.zKO.zLy.pD(r.zW(paramp.field_snsId));
      e.zKO.zLy.eqv = ((SnsObject)localObject).LikeCount;
      e.zKO.zLy.eqw = ((SnsObject)localObject).CommentCount;
      e.zKO.zLy.pF(String.valueOf(System.currentTimeMillis()));
    }
    ae.i(TAG, "prepareRetryEditInfo draftKey:%s", new Object[] { this.zCT });
    AppMethodBeat.o(219350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar
 * JD-Core Version:    0.7.0.1
 */