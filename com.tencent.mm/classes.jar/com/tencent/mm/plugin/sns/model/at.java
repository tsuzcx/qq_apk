package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ke;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class at
{
  public static long DMP = -1L;
  public static long DMQ = -1L;
  public static int DMR = 0;
  public static long DMS = 300000L;
  public static boolean DMT = false;
  public static int DMU = 60;
  public static String TAG = "MicroMsg.SnsRetryEditTipManager";
  public long DMV;
  public String DMW;
  public SnsInfo DMX;
  public String DMY;
  public Runnable DMZ;
  
  public at()
  {
    AppMethodBeat.i(202781);
    this.DMV = 0L;
    this.DMW = "";
    this.DMX = null;
    this.DMY = "";
    this.DMZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202779);
        Log.i(at.TAG, "run resetTask");
        at.a(at.this);
        at.b(at.this);
        at.fbB();
        at.c(at.this);
        at.a(at.this, "");
        AppMethodBeat.o(202779);
      }
    };
    AppMethodBeat.o(202781);
  }
  
  public static boolean o(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = false;
    if (!DMT) {
      bool1 = bool3;
    }
    do
    {
      return bool1;
      if (DMQ != -1L) {
        break;
      }
      bool1 = bool2;
      if (DMP != -1L)
      {
        bool1 = bool2;
        if (DMR != 0)
        {
          bool1 = bool2;
          if (paramLong <= DMP)
          {
            bool1 = bool2;
            if (paramInt1 < DMR) {
              bool1 = true;
            }
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        DMQ = paramInt2;
        bool2 = bool1;
      }
      bool1 = bool2;
    } while (!bool2);
    e.DUQ.DVz.eUc += 1L;
    return bool2;
    if (paramInt2 == DMQ) {}
    for (;;)
    {
      bool2 = bool1;
      break;
      bool1 = false;
    }
  }
  
  public final void D(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202783);
    if ((!DMT) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(202783);
      return;
    }
    DMQ = -1L;
    DMP = paramSnsInfo.field_snsId;
    DMR = paramSnsInfo.field_createTime;
    this.DMV = Util.nowMilliSecond();
    this.DMW = "draft_retry_edit";
    Object localObject = aj.faV();
    j localj = ((k)localObject).aQn("draft_sent_".concat(String.valueOf(paramSnsInfo.localid)));
    if (localj != null) {
      ((k)localObject).b("draft_retry_edit", localj.field_draft, 0);
    }
    MMHandlerThread.postToMainThreadDelayed(this.DMZ, DMS);
    localObject = an.C(paramSnsInfo);
    this.DMY = e.DUQ.DVz.erU;
    if (localObject != null)
    {
      this.DMX = paramSnsInfo;
      e.DUQ.DVz.xl(r.Jc(paramSnsInfo.field_snsId));
      e.DUQ.DVz.eTY = ((SnsObject)localObject).LikeCount;
      e.DUQ.DVz.eTZ = ((SnsObject)localObject).CommentCount;
      e.DUQ.DVz.xn(String.valueOf(System.currentTimeMillis()));
      e.DUQ.DVA.xl(r.Jc(paramSnsInfo.field_snsId));
      e.DUQ.DVA.eTY = ((SnsObject)localObject).LikeCount;
      e.DUQ.DVA.eTZ = ((SnsObject)localObject).CommentCount;
      e.DUQ.DVA.xn(String.valueOf(System.currentTimeMillis()));
    }
    Log.i(TAG, "prepareRetryEditInfo draftKey:%s", new Object[] { this.DMW });
    AppMethodBeat.o(202783);
  }
  
  final void fbA()
  {
    AppMethodBeat.i(202782);
    final String str = this.DMW;
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202780);
        boolean bool = ((b)g.af(b.class)).a(b.a.rZk, true);
        Log.i(at.TAG, "removeDraftTmpFile clear:%s finalDraftKey:%s", new Object[] { Boolean.valueOf(bool), str });
        if (bool)
        {
          Object localObject1 = aj.faV().aQn(str);
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
                Log.i(at.TAG, "delete %s, %s", new Object[] { localObject1, localObject2 });
                c localc = c.Cic;
                c.aLG((String)localObject2);
                localObject2 = c.Cic;
                c.aLG((String)localObject1);
                AppMethodBeat.o(202780);
                return;
              }
              catch (Exception localException)
              {
                aj.faV().b(str, null, 0);
              }
            }
          }
        }
        AppMethodBeat.o(202780);
      }
    });
    AppMethodBeat.o(202782);
  }
  
  public final void reset()
  {
    DMP = -1L;
    DMR = 0;
    DMQ = -1L;
    this.DMW = "";
    this.DMV = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.at
 * JD-Core Version:    0.7.0.1
 */