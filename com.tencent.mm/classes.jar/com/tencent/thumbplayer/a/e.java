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
  private c.f RVZ;
  private c.c RWa;
  private c.e RWb;
  private c.d RWc;
  private c.g RWd;
  private c.m RWe;
  private c.i RWf;
  private c.k RWg;
  private c.a RWh;
  private c.j RWi;
  private c.l RWj;
  private c.b RWk;
  c.h RWl;
  a RWm;
  private String mTag;
  
  public e(String paramString)
  {
    AppMethodBeat.i(188707);
    this.mTag = "TPPlayerListenerS";
    bqx(paramString);
    this.RWm = new a(this.mTag);
    this.RVZ = this.RWm;
    this.RWa = this.RWm;
    this.RWb = this.RWm;
    this.RWc = this.RWm;
    this.RWd = this.RWm;
    this.RWe = this.RWm;
    this.RWf = this.RWm;
    this.RWg = this.RWm;
    this.RWh = this.RWm;
    this.RWi = this.RWm;
    this.RWj = this.RWm;
    this.RWk = this.RWm;
    AppMethodBeat.o(188707);
  }
  
  public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(188719);
    paramTPPostProcessFrameBuffer = this.RWj.a(paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(188719);
    return paramTPPostProcessFrameBuffer;
  }
  
  public final void a(@TPCommonEnum.TPErrorType int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188712);
    this.RWc.a(paramInt1, paramInt2, paramLong1, paramLong2);
    AppMethodBeat.o(188712);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(188711);
    this.RWb.a(paramInt, paramLong1, paramLong2, paramObject);
    AppMethodBeat.o(188711);
  }
  
  public final void a(c.c paramc)
  {
    Object localObject = paramc;
    if (paramc == null) {
      localObject = this.RWm;
    }
    this.RWa = ((c.c)localObject);
  }
  
  public final void a(c.d paramd)
  {
    Object localObject = paramd;
    if (paramd == null) {
      localObject = this.RWm;
    }
    this.RWc = ((c.d)localObject);
  }
  
  public final void a(c.e parame)
  {
    Object localObject = parame;
    if (parame == null) {
      localObject = this.RWm;
    }
    this.RWb = ((c.e)localObject);
  }
  
  public final void a(c.f paramf)
  {
    Object localObject = paramf;
    if (paramf == null) {
      localObject = this.RWm;
    }
    this.RVZ = ((c.f)localObject);
  }
  
  public final void a(c.g paramg)
  {
    Object localObject = paramg;
    if (paramg == null) {
      localObject = this.RWm;
    }
    this.RWd = ((c.g)localObject);
  }
  
  public final void a(c.i parami)
  {
    Object localObject = parami;
    if (parami == null) {
      localObject = this.RWm;
    }
    this.RWf = ((c.i)localObject);
  }
  
  public final void a(c.j paramj)
  {
    Object localObject = paramj;
    if (paramj == null) {
      localObject = this.RWm;
    }
    this.RWi = ((c.j)localObject);
  }
  
  public final void a(c.k paramk)
  {
    Object localObject = paramk;
    if (paramk == null) {
      localObject = this.RWm;
    }
    this.RWg = ((c.k)localObject);
  }
  
  public final void a(c.m paramm)
  {
    Object localObject = paramm;
    if (paramm == null) {
      localObject = this.RWm;
    }
    this.RWe = ((c.m)localObject);
  }
  
  public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    AppMethodBeat.i(188718);
    this.RWh.a(paramTPAudioFrameBuffer);
    AppMethodBeat.o(188718);
  }
  
  public final void a(TPSubtitleData paramTPSubtitleData)
  {
    AppMethodBeat.i(188715);
    this.RWf.a(paramTPSubtitleData);
    AppMethodBeat.o(188715);
  }
  
  public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    AppMethodBeat.i(188716);
    this.RWi.a(paramTPSubtitleFrameBuffer);
    AppMethodBeat.o(188716);
  }
  
  public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    AppMethodBeat.i(188717);
    this.RWg.a(paramTPVideoFrameBuffer);
    AppMethodBeat.o(188717);
  }
  
  public final void aI(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188714);
    this.RWe.aI(paramLong1, paramLong2);
    AppMethodBeat.o(188714);
  }
  
  public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    AppMethodBeat.i(188720);
    paramTPPostProcessFrameBuffer = this.RWk.b(paramTPPostProcessFrameBuffer);
    AppMethodBeat.o(188720);
    return paramTPPostProcessFrameBuffer;
  }
  
  public final void b(c.a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = this.RWm;
    }
    this.RWh = ((c.a)localObject);
  }
  
  public final void b(c.b paramb)
  {
    Object localObject = paramb;
    if (paramb == null) {
      localObject = this.RWm;
    }
    this.RWk = ((c.b)localObject);
  }
  
  public final void b(c.l paraml)
  {
    Object localObject = paraml;
    if (paraml == null) {
      localObject = this.RWm;
    }
    this.RWj = ((c.l)localObject);
  }
  
  public final void bqx(String paramString)
  {
    AppMethodBeat.i(188708);
    if (TextUtils.isEmpty(paramString)) {}
    for (this.mTag = "TPPlayerListenerS";; this.mTag = paramString)
    {
      if (this.RWm != null) {
        this.RWm.mTag = this.mTag;
      }
      AppMethodBeat.o(188708);
      return;
    }
  }
  
  public final void cJH()
  {
    AppMethodBeat.i(188713);
    this.RWd.cJH();
    AppMethodBeat.o(188713);
  }
  
  public final void clear()
  {
    this.RVZ = this.RWm;
    this.RWa = this.RWm;
    this.RWb = this.RWm;
    this.RWc = this.RWm;
    this.RWd = this.RWm;
    this.RWe = this.RWm;
    this.RWf = this.RWm;
    this.RWg = this.RWm;
    this.RWh = this.RWm;
    this.RWi = this.RWm;
    this.RWl = this.RWm;
    this.RWj = this.RWm;
    this.RWk = this.RWm;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(188710);
    this.RWa.onCompletion();
    AppMethodBeat.o(188710);
  }
  
  public final void onStateChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188721);
    this.RWl.onStateChange(paramInt1, paramInt2);
    AppMethodBeat.o(188721);
  }
  
  public final void tf()
  {
    AppMethodBeat.i(188709);
    this.RVZ.tf();
    AppMethodBeat.o(188709);
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
      AppMethodBeat.i(188704);
      g.i(this.mTag, " empty base listener , notify , onVideoProcessFrameOut");
      AppMethodBeat.o(188704);
      return null;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(188697);
      g.i(this.mTag, " empty base listener , notify , onError");
      AppMethodBeat.o(188697);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(188696);
      g.i(this.mTag, " empty base listener , notify , onInfo");
      AppMethodBeat.o(188696);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(188703);
      g.i(this.mTag, " empty base listener , notify , onAudioFrameOut");
      AppMethodBeat.o(188703);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(188700);
      g.i(this.mTag, " empty base listener , notify , onSubtitleData");
      AppMethodBeat.o(188700);
    }
    
    public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(188701);
      g.i(this.mTag, " empty base listener , notify , TPSubtitleFrameBuffer");
      AppMethodBeat.o(188701);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(188702);
      g.i(this.mTag, " empty base listener , notify , onVideoFrameOut");
      AppMethodBeat.o(188702);
    }
    
    public final void aI(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(188699);
      g.i(this.mTag, " empty base listener , notify , onVideoSizeChanged");
      AppMethodBeat.o(188699);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(188705);
      g.i(this.mTag, " empty base listener , notify , onAudioProcessFrameOut");
      AppMethodBeat.o(188705);
      return null;
    }
    
    public final void cJH()
    {
      AppMethodBeat.i(188698);
      g.i(this.mTag, " empty base listener , notify , onSeekComplete");
      AppMethodBeat.o(188698);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(188695);
      g.i(this.mTag, " empty base listener , notify , onCompletion");
      AppMethodBeat.o(188695);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(188706);
      g.i(this.mTag, " empty base listener , notify , onStateChange");
      AppMethodBeat.o(188706);
    }
    
    public final void tf()
    {
      AppMethodBeat.i(188694);
      g.i(this.mTag, " empty base listener , notify , onPrepared");
      AppMethodBeat.o(188694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.e
 * JD-Core Version:    0.7.0.1
 */