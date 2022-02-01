package com.tencent.mm.plugin.voip.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipRingtoneReport;", "", "()V", "mIsIndividual", "", "mIsMuteCalled", "mPlayPersistentTime", "", "mRingtoneFinderObjectId", "", "mRingtoneInfoClick", "getMRingtoneInfoClick", "()Z", "setMRingtoneInfoClick", "(Z)V", "mRingtoneMusicSid", "mRoomId", "", "mRoomKey", "dealCalledPlayReportInfo", "", "reportInfo", "Lcom/tencent/mm/plugin/ringtone/api/PlayerReportInfo;", "roomId", "roomKey", "isVideoCall", "username", "dealCallingParam", "(Ljava/lang/Integer;Ljava/lang/Long;)V", "dealCallingPlayReportInfo", "release", "reportCalledRingtone", "mIsVibrate", "reportCallingRingtone", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private int JMX;
  private boolean OBH;
  private boolean OBQ;
  private String UGB = "0";
  private long UGt;
  public boolean UGw;
  private String UGy = "0";
  private long UHz;
  
  private void release()
  {
    this.UHz = 0L;
    this.UGw = false;
    this.UGy = "0";
    this.UGB = "0";
    this.OBH = false;
    this.JMX = 0;
    this.UGt = 0L;
  }
  
  public final void a(com.tencent.mm.plugin.ringtone.a.a parama, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(292772);
    s.u(paramString, "username");
    int m;
    long l;
    int i;
    int j;
    if ((this.UHz == 0L) && (parama != null))
    {
      this.UHz = parama.OBI;
      String str = parama.OBK;
      s.s(str, "it.mMusicSid");
      this.UGB = str;
      str = parama.OBL;
      s.s(str, "it.mFinderObjectId");
      this.UGy = str;
      this.OBH = parama.OBH;
      m = this.JMX;
      l = this.UGt;
      if (!paramBoolean) {
        break label184;
      }
      i = 2;
      if (s.p(this.UGB, "0")) {
        break label190;
      }
      j = 1;
      switch (j)
      {
      default: 
        label112:
        parama = this.UGB;
        label137:
        if (!this.OBH) {
          break;
        }
      }
    }
    for (int k = 2;; k = 1)
    {
      com.tencent.mm.plugin.ringtone.h.a.a(i, j, parama, k, this.UGw, this.UHz / 1000L, paramString, l, m);
      release();
      AppMethodBeat.o(292772);
      return;
      label184:
      i = 1;
      break;
      label190:
      if (!s.p(this.UGy, "0"))
      {
        j = 2;
        break label112;
      }
      AppMethodBeat.o(292772);
      return;
      parama = this.UGy;
      break label137;
    }
  }
  
  public final void a(Integer paramInteger, Long paramLong)
  {
    AppMethodBeat.i(292762);
    if (paramInteger == null)
    {
      AppMethodBeat.o(292762);
      return;
    }
    this.JMX = paramInteger.intValue();
    if (paramLong == null)
    {
      AppMethodBeat.o(292762);
      return;
    }
    this.UGt = paramLong.longValue();
    AppMethodBeat.o(292762);
  }
  
  public final void b(com.tencent.mm.plugin.ringtone.a.a parama, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(292784);
    s.u(paramString, "username");
    int m;
    long l;
    boolean bool;
    int j;
    int i;
    if ((this.UHz == 0L) && (this.JMX != 0) && (this.UGt != 0L) && (parama != null))
    {
      this.UHz = parama.OBI;
      String str = parama.OBK;
      s.s(str, "it.mMusicSid");
      this.UGB = str;
      str = parama.OBL;
      s.s(str, "it.mFinderObjectId");
      this.UGy = str;
      this.OBH = parama.OBH;
      this.OBQ = parama.OBQ;
      m = this.JMX;
      l = this.UGt;
      bool = parama.OBR;
      if (!paramBoolean) {
        break label220;
      }
      j = 2;
      if (s.p(this.UGB, "0")) {
        break label226;
      }
      i = 1;
      switch (i)
      {
      default: 
        label142:
        parama = "0";
        label171:
        if (!this.OBH) {
          break;
        }
      }
    }
    for (int k = 2;; k = 1)
    {
      com.tencent.mm.plugin.ringtone.h.a.a(j, i, m, l, parama, k, paramString, this.UHz / 1000L, this.OBQ, bool);
      release();
      AppMethodBeat.o(292784);
      return;
      label220:
      j = 1;
      break;
      label226:
      if (!s.p(this.UGy, "0"))
      {
        i = 2;
        break label142;
      }
      i = 3;
      break label142;
      parama = this.UGB;
      break label171;
      parama = this.UGy;
      break label171;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.h
 * JD-Core Version:    0.7.0.1
 */