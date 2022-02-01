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
  private c.f ZyJ;
  private c.c ZyK;
  private c.e ZyL;
  private c.d ZyM;
  private c.g ZyN;
  private c.m ZyO;
  private c.i ZyP;
  private c.k ZyQ;
  private c.a ZyR;
  private c.j ZyS;
  private c.l ZyT;
  private c.b ZyU;
  c.h ZyV;
  a ZyW;
  private String mTag;
  
  public e(String paramString)
  {
    AppMethodBeat.i(218834);
    this.mTag = "TPPlayerListenerS";
    bDr(paramString);
    this.ZyW = new a(this.mTag);
    this.ZyJ = this.ZyW;
    this.ZyK = this.ZyW;
    this.ZyL = this.ZyW;
    this.ZyM = this.ZyW;
    this.ZyN = this.ZyW;
    this.ZyO = this.ZyW;
    this.ZyP = this.ZyW;
    this.ZyQ = this.ZyW;
    this.ZyR = this.ZyW;
    this.ZyS = this.ZyW;
    this.ZyT = this.ZyW;
    this.ZyU = this.ZyW;
    AppMethodBeat.o(218834);
  }
  
  public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(218849);
    paramTPPostProcessFrameBuffer = this.ZyT.a(paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(218849);
    return paramTPPostProcessFrameBuffer;
  }
  
  public final void a(@TPCommonEnum.TPErrorType int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(218841);
    this.ZyM.a(paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(218841);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(218840);
    this.ZyL.a(paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(218840);
  }
  
  public final void a(c.c paramc)
  {
    Object localObject = paramc;
    if (paramc == null) {
      localObject = this.ZyW;
    }
    this.ZyK = ((c.c)localObject);
  }
  
  public final void a(c.d paramd)
  {
    Object localObject = paramd;
    if (paramd == null) {
      localObject = this.ZyW;
    }
    this.ZyM = ((c.d)localObject);
  }
  
  public final void a(c.e parame)
  {
    Object localObject = parame;
    if (parame == null) {
      localObject = this.ZyW;
    }
    this.ZyL = ((c.e)localObject);
  }
  
  public final void a(c.f paramf)
  {
    Object localObject = paramf;
    if (paramf == null) {
      localObject = this.ZyW;
    }
    this.ZyJ = ((c.f)localObject);
  }
  
  public final void a(c.g paramg)
  {
    Object localObject = paramg;
    if (paramg == null) {
      localObject = this.ZyW;
    }
    this.ZyN = ((c.g)localObject);
  }
  
  public final void a(c.i parami)
  {
    Object localObject = parami;
    if (parami == null) {
      localObject = this.ZyW;
    }
    this.ZyP = ((c.i)localObject);
  }
  
  public final void a(c.j paramj)
  {
    Object localObject = paramj;
    if (paramj == null) {
      localObject = this.ZyW;
    }
    this.ZyS = ((c.j)localObject);
  }
  
  public final void a(c.k paramk)
  {
    Object localObject = paramk;
    if (paramk == null) {
      localObject = this.ZyW;
    }
    this.ZyQ = ((c.k)localObject);
  }
  
  public final void a(c.m paramm)
  {
    Object localObject = paramm;
    if (paramm == null) {
      localObject = this.ZyW;
    }
    this.ZyO = ((c.m)localObject);
  }
  
  public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    AppMethodBeat.i(218848);
    this.ZyR.a(paramTPAudioFrameBuffer);
    AppMethodBeat.o(218848);
  }
  
  public final void a(TPSubtitleData paramTPSubtitleData)
  {
    AppMethodBeat.i(218844);
    this.ZyP.a(paramTPSubtitleData);
    AppMethodBeat.o(218844);
  }
  
  public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    AppMethodBeat.i(218845);
    this.ZyS.a(paramTPSubtitleFrameBuffer);
    AppMethodBeat.o(218845);
  }
  
  public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    AppMethodBeat.i(218847);
    this.ZyQ.a(paramTPVideoFrameBuffer);
    AppMethodBeat.o(218847);
  }
  
  public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(218850);
    paramTPPostProcessFrameBuffer = this.ZyU.b(paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(218850);
    return paramTPPostProcessFrameBuffer;
  }
  
  public final void b(c.a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = this.ZyW;
    }
    this.ZyR = ((c.a)localObject);
  }
  
  public final void b(c.b paramb)
  {
    Object localObject = paramb;
    if (paramb == null) {
      localObject = this.ZyW;
    }
    this.ZyU = ((c.b)localObject);
  }
  
  public final void b(c.l paraml)
  {
    Object localObject = paraml;
    if (paraml == null) {
      localObject = this.ZyW;
    }
    this.ZyT = ((c.l)localObject);
  }
  
  public final void bDr(String paramString)
  {
    AppMethodBeat.i(218836);
    if (TextUtils.isEmpty(paramString)) {}
    for (this.mTag = "TPPlayerListenerS";; this.mTag = paramString)
    {
      if (this.ZyW != null) {
        this.ZyW.mTag = this.mTag;
      }
      AppMethodBeat.o(218836);
      return;
    }
  }
  
  public final void ba(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(218843);
    this.ZyO.ba(paramLong1, paramLong2);
    AppMethodBeat.o(218843);
  }
  
  public final void cYp()
  {
    AppMethodBeat.i(218842);
    this.ZyN.cYp();
    AppMethodBeat.o(218842);
  }
  
  public final void clear()
  {
    this.ZyJ = this.ZyW;
    this.ZyK = this.ZyW;
    this.ZyL = this.ZyW;
    this.ZyM = this.ZyW;
    this.ZyN = this.ZyW;
    this.ZyO = this.ZyW;
    this.ZyP = this.ZyW;
    this.ZyQ = this.ZyW;
    this.ZyR = this.ZyW;
    this.ZyS = this.ZyW;
    this.ZyV = this.ZyW;
    this.ZyT = this.ZyW;
    this.ZyU = this.ZyW;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(218839);
    this.ZyK.onCompletion();
    AppMethodBeat.o(218839);
  }
  
  public final void onStateChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218853);
    this.ZyV.onStateChange(paramInt1, paramInt2);
    AppMethodBeat.o(218853);
  }
  
  public final void qX()
  {
    AppMethodBeat.i(218838);
    this.ZyJ.qX();
    AppMethodBeat.o(218838);
  }
  
  static final class a
    implements c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m
  {
    String mTag;
    
    public a(String paramString)
    {
      this.mTag = paramString;
    }
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(218828);
      g.i(this.mTag, " empty base listener , notify , onVideoProcessFrameOut");
      AppMethodBeat.o(218828);
      return null;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(218818);
      g.i(this.mTag, " empty base listener , notify , onError");
      AppMethodBeat.o(218818);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(218817);
      g.i(this.mTag, " empty base listener , notify , onInfo");
      AppMethodBeat.o(218817);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(218827);
      g.i(this.mTag, " empty base listener , notify , onAudioFrameOut");
      AppMethodBeat.o(218827);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(218823);
      g.i(this.mTag, " empty base listener , notify , onSubtitleData");
      AppMethodBeat.o(218823);
    }
    
    public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(218825);
      g.i(this.mTag, " empty base listener , notify , TPSubtitleFrameBuffer");
      AppMethodBeat.o(218825);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(218826);
      g.i(this.mTag, " empty base listener , notify , onVideoFrameOut");
      AppMethodBeat.o(218826);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(218829);
      g.i(this.mTag, " empty base listener , notify , onAudioProcessFrameOut");
      AppMethodBeat.o(218829);
      return null;
    }
    
    public final void ba(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(218821);
      g.i(this.mTag, " empty base listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(218821);
    }
    
    public final void cYp()
    {
      AppMethodBeat.i(218820);
      g.i(this.mTag, " empty base listener , notify , onSeekComplete");
      AppMethodBeat.o(218820);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(218816);
      g.i(this.mTag, " empty base listener , notify , onCompletion");
      AppMethodBeat.o(218816);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(218831);
      g.i(this.mTag, " empty base listener , notify , onStateChange");
      AppMethodBeat.o(218831);
    }
    
    public final void qX()
    {
      AppMethodBeat.i(218815);
      g.i(this.mTag, " empty base listener , notify , onPrepared");
      AppMethodBeat.o(218815);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.e
 * JD-Core Version:    0.7.0.1
 */