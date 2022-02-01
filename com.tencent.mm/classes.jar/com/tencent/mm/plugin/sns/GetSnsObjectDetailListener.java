package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.lw;
import com.tencent.mm.autogen.a.lw.a;
import com.tencent.mm.autogen.a.vk;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.fek;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.LinkedList;

public class GetSnsObjectDetailListener
  extends IListener<lw>
  implements com.tencent.mm.am.h
{
  private int PJO;
  private SnsObject PJP;
  private SnsInfo PJQ;
  private MTimerHandler PJR;
  
  public GetSnsObjectDetailListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160632);
    this.__eventId = lw.class.getName().hashCode();
    AppMethodBeat.o(160632);
  }
  
  private boolean a(lw paramlw)
  {
    AppMethodBeat.i(94890);
    if (!(paramlw instanceof lw))
    {
      Log.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
      AppMethodBeat.o(94890);
      return false;
    }
    this.PJO = paramlw.hNL.hGM;
    this.PJQ = al.hgB().alB(this.PJO);
    this.PJP = ap.D(this.PJQ);
    if ((this.PJP != null) && (((this.PJP.ExtFlag == 3) && (this.PJP.BlackList != null) && (this.PJP.BlackList.size() > 0)) || ((this.PJP.ExtFlag == 5) && (this.PJP.GroupUser != null) && (this.PJP.GroupUser.size() > 0))))
    {
      paramlw.hNM.hNN = this.PJP;
      AppMethodBeat.o(94890);
      return true;
    }
    paramlw = new r(this.PJQ.field_snsId);
    ((fek)c.b.b(paramlw.rr.otB)).abDS = 1;
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(210, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramlw, 0);
    this.PJR = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94889);
        vk localvk = new vk();
        localvk.hZe.hNN = null;
        localvk.publish();
        AppMethodBeat.o(94889);
        return false;
      }
    }, false);
    this.PJR.startTimer(10000L);
    AppMethodBeat.o(94890);
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(94891);
    Log.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.PJR.stopTimer();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = al.hgB().vj(this.PJQ.field_snsId);
      paramp = new vk();
      paramp.hZe.hNN = ap.D(paramString);
      paramp.publish();
      AppMethodBeat.o(94891);
      return;
    }
    paramString = new vk();
    paramString.hZe.hNN = null;
    paramString.publish();
    AppMethodBeat.o(94891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.GetSnsObjectDetailListener
 * JD-Core Version:    0.7.0.1
 */