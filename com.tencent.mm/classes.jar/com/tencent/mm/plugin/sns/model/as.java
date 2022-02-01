package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.mw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class as
{
  public static long JZR = -1L;
  public static long JZS = -1L;
  public static int JZT = 0;
  public static long JZU = 300000L;
  public static boolean JZV = false;
  public static int JZW = 60;
  public static String TAG = "MicroMsg.SnsRetryEditTipManager";
  public long JZX;
  public String JZY;
  public SnsInfo JZZ;
  public String Kaa;
  public Runnable Kab;
  
  public as()
  {
    AppMethodBeat.i(220649);
    this.JZX = 0L;
    this.JZY = "";
    this.JZZ = null;
    this.Kaa = "";
    this.Kab = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202363);
        Log.i(as.TAG, "run resetTask");
        as.a(as.this);
        as.b(as.this);
        as.fPu();
        as.c(as.this);
        as.a(as.this, "");
        AppMethodBeat.o(202363);
      }
    };
    AppMethodBeat.o(220649);
  }
  
  public static boolean p(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = false;
    if (!JZV) {
      bool1 = bool3;
    }
    do
    {
      return bool1;
      if (JZS != -1L) {
        break;
      }
      bool1 = bool2;
      if (JZR != -1L)
      {
        bool1 = bool2;
        if (JZT != 0)
        {
          bool1 = bool2;
          if (paramLong <= JZR)
          {
            bool1 = bool2;
            if (paramInt1 < JZT) {
              bool1 = true;
            }
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        JZS = paramInt2;
        bool2 = bool1;
      }
      bool1 = bool2;
    } while (!bool2);
    g.Kia.KiJ.gWw += 1L;
    return bool2;
    if (paramInt2 == JZS) {}
    for (;;)
    {
      bool2 = bool1;
      break;
      bool1 = false;
    }
  }
  
  public final void E(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(220666);
    if ((!JZV) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(220666);
      return;
    }
    JZS = -1L;
    JZR = paramSnsInfo.field_snsId;
    JZT = paramSnsInfo.field_createTime;
    this.JZX = Util.nowMilliSecond();
    this.JZY = "draft_retry_edit";
    Object localObject = aj.fOP();
    j localj = ((k)localObject).bbm("draft_sent_".concat(String.valueOf(paramSnsInfo.localid)));
    if (localj != null) {
      ((k)localObject).b("draft_retry_edit", localj.field_draft, 0);
    }
    MMHandlerThread.postToMainThreadDelayed(this.Kab, JZU);
    localObject = an.D(paramSnsInfo);
    this.Kaa = g.Kia.KiJ.gnO;
    if (localObject != null)
    {
      this.JZZ = paramSnsInfo;
      g.Kia.KiJ.Dx(t.Qv(paramSnsInfo.field_snsId));
      g.Kia.KiJ.gWs = ((SnsObject)localObject).LikeCount;
      g.Kia.KiJ.gWt = ((SnsObject)localObject).CommentCount;
      g.Kia.KiJ.Dz(String.valueOf(System.currentTimeMillis()));
      g.Kia.KiK.Dx(t.Qv(paramSnsInfo.field_snsId));
      g.Kia.KiK.gWs = ((SnsObject)localObject).LikeCount;
      g.Kia.KiK.gWt = ((SnsObject)localObject).CommentCount;
      g.Kia.KiK.Dz(String.valueOf(System.currentTimeMillis()));
    }
    Log.i(TAG, "prepareRetryEditInfo draftKey:%s", new Object[] { this.JZY });
    AppMethodBeat.o(220666);
  }
  
  final void fPt()
  {
    AppMethodBeat.i(220651);
    final String str = this.JZY;
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266325);
        boolean bool = ((b)h.ae(b.class)).a(b.a.vGi, true);
        Log.i(as.TAG, "removeDraftTmpFile clear:%s finalDraftKey:%s", new Object[] { Boolean.valueOf(bool), str });
        if (bool)
        {
          Object localObject1 = aj.fOP().bbm(str);
          if (localObject1 != null)
          {
            localObject1 = ((j)localObject1).field_draft;
            if (!Util.isNullOrNil((byte[])localObject1))
            {
              Object localObject2 = Parcel.obtain();
              ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
              ((Parcel)localObject2).setDataPosition(0);
              try
              {
                localObject2 = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2);
                localObject1 = ((Intent)localObject2).getStringExtra("KSightThumbPath");
                localObject2 = ((Intent)localObject2).getStringExtra("KSightPath");
                Log.i(as.TAG, "delete %s, %s", new Object[] { localObject1, localObject2 });
                d locald = d.IeU;
                d.aWk((String)localObject2);
                localObject2 = d.IeU;
                d.aWk((String)localObject1);
                AppMethodBeat.o(266325);
                return;
              }
              catch (Exception localException)
              {
                aj.fOP().b(str, null, 0);
              }
            }
          }
        }
        AppMethodBeat.o(266325);
      }
    });
    AppMethodBeat.o(220651);
  }
  
  public final void reset()
  {
    JZR = -1L;
    JZT = 0;
    JZS = -1L;
    this.JZY = "";
    this.JZX = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as
 * JD-Core Version:    0.7.0.1
 */