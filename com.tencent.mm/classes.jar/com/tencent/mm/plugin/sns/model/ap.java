package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

public final class ap
{
  public static String TAG = "MicroMsg.SnsRetryEditTipManager";
  public static long xVB = -1L;
  public static long xVC = -1L;
  public static int xVD = 0;
  public static long xVE = 300000L;
  public static boolean xVF = false;
  public static int xVG = 60;
  public long xVH;
  public String xVI;
  public Runnable xVJ;
  
  public ap()
  {
    AppMethodBeat.i(200119);
    this.xVH = 0L;
    this.xVI = "";
    this.xVJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200117);
        ac.i(ap.TAG, "run resetTask");
        ap.a(ap.this);
        ap.b(ap.this);
        ap.dIA();
        AppMethodBeat.o(200117);
      }
    };
    AppMethodBeat.o(200119);
  }
  
  public static boolean o(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (!xVF) {
      return false;
    }
    if (xVC == -1L) {
      if ((xVB != -1L) && (xVD != 0) && (paramLong <= xVB) && (paramInt1 < xVD))
      {
        bool2 = bool1;
        if (bool1)
        {
          xVC = paramInt2;
          bool2 = bool1;
        }
      }
    }
    for (;;)
    {
      return bool2;
      bool1 = false;
      break;
      if (paramInt2 != xVC) {
        bool2 = false;
      }
    }
  }
  
  final void dIz()
  {
    AppMethodBeat.i(200120);
    final String str = this.xVI;
    af.dvq().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200118);
        boolean bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUl, true);
        ac.i(ap.TAG, "removeDraftTmpFile clear:%s finalDraftKey:%s", new Object[] { Boolean.valueOf(bool), str });
        if (bool)
        {
          Object localObject1 = af.dHY().auU(str);
          if (localObject1 != null)
          {
            localObject1 = ((l)localObject1).field_draft;
            if (!bs.cv((byte[])localObject1))
            {
              Object localObject2 = Parcel.obtain();
              ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
              ((Parcel)localObject2).setDataPosition(0);
              try
              {
                localObject2 = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2);
                localObject1 = ((Intent)localObject2).getStringExtra("KSightThumbPath");
                localObject2 = ((Intent)localObject2).getStringExtra("KSightPath");
                ac.i(ap.TAG, "delete %s, %s", new Object[] { localObject1, localObject2 });
                com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.wDE;
                com.tencent.mm.plugin.recordvideo.e.b.aqT((String)localObject2);
                localObject2 = com.tencent.mm.plugin.recordvideo.e.b.wDE;
                com.tencent.mm.plugin.recordvideo.e.b.aqT((String)localObject1);
                AppMethodBeat.o(200118);
                return;
              }
              catch (Exception localException)
              {
                af.dHY().b(str, null, 0);
              }
            }
          }
        }
        AppMethodBeat.o(200118);
      }
    });
    AppMethodBeat.o(200120);
  }
  
  public final void reset()
  {
    xVB = -1L;
    xVD = 0;
    xVC = -1L;
    this.xVI = "";
    this.xVH = 0L;
  }
  
  public final void u(p paramp)
  {
    AppMethodBeat.i(200121);
    if (!xVF)
    {
      AppMethodBeat.o(200121);
      return;
    }
    xVC = -1L;
    xVB = paramp.field_snsId;
    xVD = paramp.field_createTime;
    this.xVH = bs.eWj();
    this.xVI = "draft_retry_edit";
    m localm = af.dHY();
    paramp = localm.auU("draft_sent_".concat(String.valueOf(paramp.yvp)));
    if (paramp != null) {
      localm.b("draft_retry_edit", paramp.field_draft, 0);
    }
    com.tencent.mm.sdk.platformtools.ap.n(this.xVJ, xVE);
    ac.i(TAG, "prepareRetryEditInfo draftKey:%s", new Object[] { this.xVI });
    AppMethodBeat.o(200121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap
 * JD-Core Version:    0.7.0.1
 */