package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.py;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class au
{
  public static long Qxa = -1L;
  public static long Qxb = -1L;
  public static int Qxc = 0;
  public static long Qxd = 300000L;
  public static boolean Qxe = false;
  public static int Qxf = 60;
  public static String TAG = "MicroMsg.SnsRetryEditTipManager";
  public long Qxg;
  private String Qxh;
  public SnsInfo Qxi;
  public String Qxj;
  public Runnable Qxk;
  
  public au()
  {
    AppMethodBeat.i(309433);
    this.Qxg = 0L;
    this.Qxh = "";
    this.Qxi = null;
    this.Qxj = "";
    this.Qxk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309482);
        Log.i(au.TAG, "run resetTask");
        au.a(au.this);
        au.b(au.this);
        au.hhn();
        au.c(au.this);
        au.a(au.this, "");
        AppMethodBeat.o(309482);
      }
    };
    AppMethodBeat.o(309433);
  }
  
  public static boolean x(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = false;
    if (!Qxe) {
      bool1 = bool3;
    }
    do
    {
      return bool1;
      if (Qxb != -1L) {
        break;
      }
      bool1 = bool2;
      if (Qxa != -1L)
      {
        bool1 = bool2;
        if (Qxc != 0)
        {
          bool1 = bool2;
          if (paramLong <= Qxa)
          {
            bool1 = bool2;
            if (paramInt1 < Qxc) {
              bool1 = true;
            }
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        Qxb = paramInt2;
        bool2 = bool1;
      }
      bool1 = bool2;
    } while (!bool2);
    j.QFS.QGD.jpS += 1L;
    return bool2;
    if (paramInt2 == Qxb) {}
    for (;;)
    {
      bool2 = bool1;
      break;
      bool1 = false;
    }
  }
  
  public final void F(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309463);
    if ((!Qxe) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(309463);
      return;
    }
    Qxb = -1L;
    Qxa = paramSnsInfo.field_snsId;
    Qxc = paramSnsInfo.field_createTime;
    this.Qxg = Util.nowMilliSecond();
    this.Qxh = "draft_retry_edit";
    Object localObject = al.hgJ();
    s locals = ((com.tencent.mm.plugin.sns.storage.t)localObject).aZP("draft_sent_".concat(String.valueOf(paramSnsInfo.localid)));
    if (locals != null) {
      ((com.tencent.mm.plugin.sns.storage.t)localObject).b("draft_retry_edit", locals.field_draft, 0);
    }
    MMHandlerThread.postToMainThreadDelayed(this.Qxk, Qxd);
    localObject = ap.E(paramSnsInfo);
    this.Qxj = j.QFS.QGD.ixm;
    if (localObject != null)
    {
      this.Qxi = paramSnsInfo;
      j.QFS.QGD.xd(com.tencent.mm.plugin.sns.data.t.uB(paramSnsInfo.field_snsId));
      j.QFS.QGD.jpO = ((SnsObject)localObject).LikeCount;
      j.QFS.QGD.jpP = ((SnsObject)localObject).CommentCount;
      j.QFS.QGD.xf(String.valueOf(System.currentTimeMillis()));
      j.QFS.QGE.xd(com.tencent.mm.plugin.sns.data.t.uB(paramSnsInfo.field_snsId));
      j.QFS.QGE.jpO = ((SnsObject)localObject).LikeCount;
      j.QFS.QGE.jpP = ((SnsObject)localObject).CommentCount;
      j.QFS.QGE.xf(String.valueOf(System.currentTimeMillis()));
    }
    Log.i(TAG, "prepareRetryEditInfo draftKey:%s", new Object[] { this.Qxh });
    AppMethodBeat.o(309463);
  }
  
  public final void d(Context paramContext, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309466);
    if (!Qxe)
    {
      AppMethodBeat.o(309466);
      return;
    }
    this.Qxi = null;
    this.Qxj = "";
    Log.i(TAG, "goRetryEdit draftKey:%s", new Object[] { this.Qxh });
    Object localObject1 = al.hgJ().aZP(this.Qxh);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((s)localObject1).field_draft;
      if (!Util.isNullOrNil((byte[])localObject1))
      {
        localObject2 = Parcel.obtain();
        ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
        ((Parcel)localObject2).setDataPosition(0);
      }
    }
    for (;;)
    {
      StringBuffer localStringBuffer;
      int i;
      try
      {
        localObject1 = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2);
        localObject2 = ((Intent)localObject1).getStringExtra("Select_Contact");
        if (localObject2 == null) {
          break label292;
        }
        localObject2 = ((String)localObject2).split(",");
        localStringBuffer = new StringBuffer();
        int k = localObject2.length;
        i = 0;
        if (i >= k) {
          break label278;
        }
        String str = localObject2[i];
        Iterator localIterator = paramSnsInfo.getPostInfo().aaUa.iterator();
        if (!localIterator.hasNext()) {
          break label392;
        }
        if (!str.equals(((etl)localIterator.next()).toString())) {
          continue;
        }
        j = 1;
        if (j != 0) {
          break label398;
        }
        if (localStringBuffer.length() == 0)
        {
          localStringBuffer.append(str);
        }
        else
        {
          localStringBuffer.append(",");
          localStringBuffer.append(str);
        }
      }
      catch (Exception paramContext)
      {
        al.hgJ().b(this.Qxh, null, 0);
      }
      AppMethodBeat.o(309466);
      return;
      label278:
      ((Intent)localObject1).putExtra("Select_Contact", localStringBuffer.toString());
      label292:
      ((Intent)localObject1).putExtra("Kis_retry_edit", true);
      paramSnsInfo = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramSnsInfo.aYi(), "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramSnsInfo.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/sns/model/SnsRetryEditTipManager", "goRetryEdit", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      reset();
      MMHandlerThread.removeRunnable(this.Qxk);
      AppMethodBeat.o(309466);
      return;
      label392:
      int j = 0;
      continue;
      label398:
      i += 1;
    }
  }
  
  final void hhm()
  {
    AppMethodBeat.i(309455);
    final String str = this.Qxh;
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309483);
        boolean bool = ((c)h.ax(c.class)).a(c.a.yVQ, true);
        Log.i(au.TAG, "removeDraftTmpFile clear:%s finalDraftKey:%s", new Object[] { Boolean.valueOf(bool), str });
        if (bool)
        {
          Object localObject1 = al.hgJ().aZP(str);
          if (localObject1 != null)
          {
            localObject1 = ((s)localObject1).field_draft;
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
                Log.i(au.TAG, "delete %s, %s", new Object[] { localObject1, localObject2 });
                f localf = f.Obq;
                f.aTt((String)localObject2);
                localObject2 = f.Obq;
                f.aTt((String)localObject1);
                AppMethodBeat.o(309483);
                return;
              }
              catch (Exception localException)
              {
                al.hgJ().b(str, null, 0);
              }
            }
          }
        }
        AppMethodBeat.o(309483);
      }
    });
    AppMethodBeat.o(309455);
  }
  
  final void reset()
  {
    Qxa = -1L;
    Qxc = 0;
    Qxb = -1L;
    this.Qxh = "";
    this.Qxg = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.au
 * JD-Core Version:    0.7.0.1
 */