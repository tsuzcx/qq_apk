package com.tencent.thumbplayer.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.a;
import com.tencent.thumbplayer.a.a.c.b;
import com.tencent.thumbplayer.a.a.c.c;
import com.tencent.thumbplayer.a.a.c.d;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.g;
import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.a.a.c.k;
import com.tencent.thumbplayer.a.a.c.l;
import com.tencent.thumbplayer.a.a.c.m;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCommonEnum.TPErrorType;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.g;

public final class e
  implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m
{
  private c.f ahDM;
  private c.c ahDN;
  private c.e ahDO;
  private c.d ahDP;
  private c.g ahDQ;
  private c.m ahDR;
  private c.i ahDS;
  private c.k ahDT;
  private c.a ahDU;
  private c.j ahDV;
  private c.l ahDW;
  private c.b ahDX;
  c.h ahDY;
  a ahDZ;
  private String mTag;
  
  public e(String paramString)
  {
    AppMethodBeat.i(228472);
    this.mTag = "TPPlayerListenerS";
    ayz(paramString);
    this.ahDZ = new a(this.mTag);
    this.ahDM = this.ahDZ;
    this.ahDN = this.ahDZ;
    this.ahDO = this.ahDZ;
    this.ahDP = this.ahDZ;
    this.ahDQ = this.ahDZ;
    this.ahDR = this.ahDZ;
    this.ahDS = this.ahDZ;
    this.ahDT = this.ahDZ;
    this.ahDU = this.ahDZ;
    this.ahDV = this.ahDZ;
    this.ahDW = this.ahDZ;
    this.ahDX = this.ahDZ;
    AppMethodBeat.o(228472);
  }
  
  public final void Qz()
  {
    AppMethodBeat.i(228484);
    this.ahDM.Qz();
    AppMethodBeat.o(228484);
  }
  
  public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(228565);
    paramTPPostProcessFrameBuffer = this.ahDW.a(paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(228565);
    return paramTPPostProcessFrameBuffer;
  }
  
  public final void a(@TPCommonEnum.TPErrorType int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228517);
    this.ahDP.a(paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(228517);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(228496);
    this.ahDO.a(paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(228496);
  }
  
  public final void a(c.c paramc)
  {
    Object localObject = paramc;
    if (paramc == null) {
      localObject = this.ahDZ;
    }
    this.ahDN = ((c.c)localObject);
  }
  
  public final void a(c.d paramd)
  {
    Object localObject = paramd;
    if (paramd == null) {
      localObject = this.ahDZ;
    }
    this.ahDP = ((c.d)localObject);
  }
  
  public final void a(c.e parame)
  {
    Object localObject = parame;
    if (parame == null) {
      localObject = this.ahDZ;
    }
    this.ahDO = ((c.e)localObject);
  }
  
  public final void a(c.f paramf)
  {
    Object localObject = paramf;
    if (paramf == null) {
      localObject = this.ahDZ;
    }
    this.ahDM = ((c.f)localObject);
  }
  
  public final void a(c.g paramg)
  {
    Object localObject = paramg;
    if (paramg == null) {
      localObject = this.ahDZ;
    }
    this.ahDQ = ((c.g)localObject);
  }
  
  public final void a(c.i parami)
  {
    Object localObject = parami;
    if (parami == null) {
      localObject = this.ahDZ;
    }
    this.ahDS = ((c.i)localObject);
  }
  
  public final void a(c.j paramj)
  {
    Object localObject = paramj;
    if (paramj == null) {
      localObject = this.ahDZ;
    }
    this.ahDV = ((c.j)localObject);
  }
  
  public final void a(c.k paramk)
  {
    Object localObject = paramk;
    if (paramk == null) {
      localObject = this.ahDZ;
    }
    this.ahDT = ((c.k)localObject);
  }
  
  public final void a(c.m paramm)
  {
    Object localObject = paramm;
    if (paramm == null) {
      localObject = this.ahDZ;
    }
    this.ahDR = ((c.m)localObject);
  }
  
  public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    AppMethodBeat.i(228555);
    this.ahDU.a(paramTPAudioFrameBuffer);
    AppMethodBeat.o(228555);
  }
  
  public final void a(TPSubtitleData paramTPSubtitleData)
  {
    AppMethodBeat.i(228536);
    this.ahDS.a(paramTPSubtitleData);
    AppMethodBeat.o(228536);
  }
  
  public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    AppMethodBeat.i(228543);
    this.ahDV.a(paramTPSubtitleFrameBuffer);
    AppMethodBeat.o(228543);
  }
  
  public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    AppMethodBeat.i(228548);
    this.ahDT.a(paramTPVideoFrameBuffer);
    AppMethodBeat.o(228548);
  }
  
  public final void ayz(String paramString)
  {
    AppMethodBeat.i(228479);
    if (TextUtils.isEmpty(paramString)) {}
    for (this.mTag = "TPPlayerListenerS";; this.mTag = paramString)
    {
      if (this.ahDZ != null) {
        this.ahDZ.mTag = this.mTag;
      }
      AppMethodBeat.o(228479);
      return;
    }
  }
  
  public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(228571);
    paramTPPostProcessFrameBuffer = this.ahDX.b(paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(228571);
    return paramTPPostProcessFrameBuffer;
  }
  
  public final void b(c.a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = this.ahDZ;
    }
    this.ahDU = ((c.a)localObject);
  }
  
  public final void b(c.b paramb)
  {
    Object localObject = paramb;
    if (paramb == null) {
      localObject = this.ahDZ;
    }
    this.ahDX = ((c.b)localObject);
  }
  
  public final void b(c.l paraml)
  {
    Object localObject = paraml;
    if (paraml == null) {
      localObject = this.ahDZ;
    }
    this.ahDW = ((c.l)localObject);
  }
  
  public final void bN(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228530);
    this.ahDR.bN(paramLong1, paramLong2);
    AppMethodBeat.o(228530);
  }
  
  public final void clear()
  {
    this.ahDM = this.ahDZ;
    this.ahDN = this.ahDZ;
    this.ahDO = this.ahDZ;
    this.ahDP = this.ahDZ;
    this.ahDQ = this.ahDZ;
    this.ahDR = this.ahDZ;
    this.ahDS = this.ahDZ;
    this.ahDT = this.ahDZ;
    this.ahDU = this.ahDZ;
    this.ahDV = this.ahDZ;
    this.ahDY = this.ahDZ;
    this.ahDW = this.ahDZ;
    this.ahDX = this.ahDZ;
  }
  
  public final void dEH()
  {
    AppMethodBeat.i(228524);
    this.ahDQ.dEH();
    AppMethodBeat.o(228524);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(228490);
    this.ahDN.onCompletion();
    AppMethodBeat.o(228490);
  }
  
  public final void onStateChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228577);
    this.ahDY.onStateChange(paramInt1, paramInt2);
    AppMethodBeat.o(228577);
  }
  
  static final class a
    implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m
  {
    String mTag;
    
    public a(String paramString)
    {
      this.mTag = paramString;
    }
    
    public final void Qz()
    {
      AppMethodBeat.i(228539);
      g.i(this.mTag, " empty base listener , notify , onPrepared");
      AppMethodBeat.o(228539);
    }
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(228599);
      g.i(this.mTag, " empty base listener , notify , onVideoProcessFrameOut");
      AppMethodBeat.o(228599);
      return null;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(228564);
      g.i(this.mTag, " empty base listener , notify , onError");
      AppMethodBeat.o(228564);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(228556);
      g.i(this.mTag, " empty base listener , notify , onInfo");
      AppMethodBeat.o(228556);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(228597);
      g.i(this.mTag, " empty base listener , notify , onAudioFrameOut");
      AppMethodBeat.o(228597);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(228583);
      g.i(this.mTag, " empty base listener , notify , onSubtitleData");
      AppMethodBeat.o(228583);
    }
    
    public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(228588);
      g.i(this.mTag, " empty base listener , notify , TPSubtitleFrameBuffer");
      AppMethodBeat.o(228588);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(228593);
      g.i(this.mTag, " empty base listener , notify , onVideoFrameOut");
      AppMethodBeat.o(228593);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(228607);
      g.i(this.mTag, " empty base listener , notify , onAudioProcessFrameOut");
      AppMethodBeat.o(228607);
      return null;
    }
    
    public final void bN(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(228576);
      g.i(this.mTag, " empty base listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(228576);
    }
    
    public final void dEH()
    {
      AppMethodBeat.i(228570);
      g.i(this.mTag, " empty base listener , notify , onSeekComplete");
      AppMethodBeat.o(228570);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(228547);
      g.i(this.mTag, " empty base listener , notify , onCompletion");
      AppMethodBeat.o(228547);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(228613);
      g.i(this.mTag, " empty base listener , notify , onStateChange");
      AppMethodBeat.o(228613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.e
 * JD-Core Version:    0.7.0.1
 */