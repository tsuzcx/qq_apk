package com.tencent.thumbplayer.a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.g;
import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.b.f.b;
import com.tencent.thumbplayer.b.f.c;
import com.tencent.thumbplayer.b.j;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.l;
import com.tencent.thumbplayer.b.m;
import com.tencent.thumbplayer.b.n;
import com.tencent.thumbplayer.b.o;
import com.tencent.thumbplayer.b.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
  implements a, c.g
{
  j LWA;
  boolean LWB;
  e LWC;
  private a LWD;
  c LWE;
  g LWF;
  com.tencent.thumbplayer.a.b.a LWG;
  b LWH;
  int LWI;
  com.tencent.thumbplayer.a.a.b LWz;
  private Context mContext;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(191566);
    this.mContext = paramContext;
    this.LWA = new j();
    this.LWA.LZi = this;
    this.LWE = new c();
    this.LWD = new a((byte)0);
    this.LWC = new e("TPThumbPlayer[TPPlayerAdapter.java]");
    this.LWF = new g(this.LWA);
    this.LWH = new b();
    AppMethodBeat.o(191566);
  }
  
  private static com.tencent.thumbplayer.a.b.a a(c paramc)
  {
    AppMethodBeat.i(191609);
    try
    {
      paramc = new com.tencent.thumbplayer.a.b.a.a(paramc);
      paramc = new com.tencent.thumbplayer.a.b.c(paramc);
      AppMethodBeat.o(191609);
      return paramc;
    }
    catch (IllegalArgumentException paramc)
    {
      for (;;)
      {
        paramc = new com.tencent.thumbplayer.a.b.a.a(null);
      }
    }
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(191608);
    paramb.a(this.LWD);
    paramb.a(this.LWD);
    paramb.a(this.LWD);
    paramb.a(this.LWD);
    paramb.a(this.LWD);
    paramb.a(this.LWD);
    paramb.a(this.LWD);
    if (fWj())
    {
      paramb.a(this.LWD);
      paramb.a(this.LWD);
    }
    if (1 == this.LWE.LWl.mType) {
      paramb.b(this.LWE.LWl.LWV);
    }
    for (;;)
    {
      localObject1 = this.LWE.fWf().iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramb.b((com.tencent.thumbplayer.b.f)((Iterator)localObject1).next());
      }
      if (this.LWE.LWl.mType == 0) {
        paramb.setDataSource(this.LWE.LWl.mUrl, this.LWE.LWl.mHttpHeaders);
      } else if (2 == this.LWE.LWl.mType) {
        paramb.a(this.LWE.LWl.LWW);
      }
    }
    int i = 0;
    Object localObject3;
    if (i < this.LWE.LWr.size())
    {
      localObject1 = (n)this.LWE.LWr.get(i);
      if (((n)localObject1).trackType == 3)
      {
        localObject2 = this.LWE.fWd().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (c.d)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((c.d)localObject3).name)) && (((c.d)localObject3).name.equals(((n)localObject1).name)))
          {
            paramb.bk(((c.d)localObject3).url, ((c.d)localObject3).mimeType, ((c.d)localObject3).name);
            label368:
            break label398;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((n)localObject1).trackType == 2)
        {
          localObject2 = this.LWE.fWe().iterator();
          label398:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (c.a)((Iterator)localObject2).next();
            if ((TextUtils.isEmpty(((c.a)localObject3).name)) || (!((c.a)localObject3).name.equals(((n)localObject1).name))) {
              break label368;
            }
            paramb.g(((c.a)localObject3).url, ((c.a)localObject3).name, ((c.a)localObject3).LWt);
          }
        }
      }
    }
    Object localObject1 = this.LWE.LWj.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.c)((Iterator)localObject1).next();
      if (((c.c)localObject2).LWy.isSelected)
      {
        localObject3 = paramb.fWg();
        if (localObject3 == null)
        {
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerAdapter.java]", "playerTrackInfoList is null.");
        }
        else
        {
          i = 0;
          while (i < localObject3.length)
          {
            if (((c.c)localObject2).LWy.name.equals(localObject3[i].name)) {
              paramb.aQ(i, ((c.c)localObject2).LWx);
            }
            i += 1;
          }
        }
      }
    }
    if (this.LWE.LWm != null) {
      paramb.c(this.LWE.LWm.LWu, this.LWE.LWm.LWv, this.LWE.LWm.LWw);
    }
    paramb.zw(this.LWE.LWn);
    if (this.LWE.LWo != 0.0F) {
      paramb.ci(this.LWE.LWo);
    }
    if (this.LWE.LWp != 0.0F) {
      paramb.cj(this.LWE.LWp);
    }
    if (this.LWE.mSurface != null) {
      paramb.setSurface(this.LWE.mSurface);
    }
    localObject1 = new com.tencent.thumbplayer.b.f();
    Object localObject2 = this.LWG.fWt();
    ((com.tencent.thumbplayer.b.f)localObject1).LYM = 4;
    ((com.tencent.thumbplayer.b.f)localObject1).key = 204;
    ((com.tencent.thumbplayer.b.f)localObject1).LYQ = new f.c();
    ((com.tencent.thumbplayer.b.f)localObject1).LYQ.LYU = ((int[])localObject2);
    paramb.b((com.tencent.thumbplayer.b.f)localObject1);
    AppMethodBeat.o(191608);
  }
  
  private int fWi()
  {
    AppMethodBeat.i(191606);
    if (this.LWG == null) {
      this.LWG = a(this.LWE);
    }
    int i = this.LWG.a(this.LWH);
    AppMethodBeat.o(191606);
    return i;
  }
  
  public final void M(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(191588);
    if (!this.LWF.agX(17))
    {
      paramString = new IllegalStateException("error , switch definition , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191588);
      throw paramString;
    }
    if (this.LWz != null)
    {
      this.LWz.M(paramString, paramInt, paramLong);
      AppMethodBeat.o(191588);
      return;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(191588);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    this.LWC.LWS = parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    this.LWC.LWL = paramb;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.c paramc)
  {
    this.LWC.LWN = paramc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    this.LWC.LWM = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.LWC.LWK = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.LWC.LWO = paramf;
  }
  
  public final void a(c.g paramg)
  {
    this.LWC.LWT = paramg;
  }
  
  public final void a(c.h paramh)
  {
    this.LWC.LWQ = paramh;
  }
  
  public final void a(c.i parami)
  {
    this.LWC.LWR = parami;
  }
  
  public final void a(c.j paramj)
  {
    this.LWC.LWP = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(191572);
    if (!this.LWF.agX(2))
    {
      parama = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(191572);
      throw parama;
    }
    if (parama == null)
    {
      parama = new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
      AppMethodBeat.o(191572);
      throw parama;
    }
    f localf = this.LWE.LWl;
    localf.mUrl = null;
    localf.mType = 2;
    localf.mHttpHeaders.clear();
    localf.LWV = null;
    localf.LWW = parama;
    this.LWA.changeState(2);
    AppMethodBeat.o(191572);
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(191589);
    if (!this.LWF.agX(17))
    {
      parama = new IllegalStateException("error , switch definition , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191589);
      throw parama;
    }
    if (this.LWz != null)
    {
      this.LWz.a(parama, paramInt, paramLong);
      AppMethodBeat.o(191589);
      return;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(191589);
  }
  
  public final void a(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(191605);
    if (this.LWz != null)
    {
      this.LWz.a(parame, paramd);
      AppMethodBeat.o(191605);
      return;
    }
    parame = new IllegalStateException("error , no player for capture :" + this.LWA);
    AppMethodBeat.o(191605);
    throw parame;
  }
  
  public final void a(p paramp)
  {
    int i = 26;
    AppMethodBeat.i(191573);
    if (!this.LWF.agX(2)) {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerAdapter.java]", "setVideoInfo state invalid");
    }
    b localb;
    int j;
    if (paramp != null)
    {
      this.LWH.bbt = paramp.bbt;
      this.LWH.bbs = paramp.bbs;
      localb = this.LWH;
      j = paramp.videoCodecId;
      if (26 != j) {
        break label84;
      }
    }
    for (;;)
    {
      localb.LVY = i;
      AppMethodBeat.o(191573);
      return;
      label84:
      if (172 == j) {
        i = 172;
      } else {
        i = j;
      }
    }
  }
  
  public final void aQ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191577);
    if (!this.LWF.agX(3))
    {
      localObject = new IllegalStateException("error : selectTrack , state invalid");
      AppMethodBeat.o(191577);
      throw ((Throwable)localObject);
    }
    Object localObject = fWg();
    if (localObject == null)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerAdapter.java]", "fatal err, tpTrackInfos is null");
      AppMethodBeat.o(191577);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(191577);
      throw ((Throwable)localObject);
    }
    if (this.LWz != null) {
      this.LWz.aQ(paramInt, paramLong);
    }
    this.LWE.a(paramInt, paramLong, localObject[paramInt]);
    AppMethodBeat.o(191577);
  }
  
  public final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191578);
    if (!this.LWF.agX(3))
    {
      localObject = new IllegalStateException("error : deselectTrack , state invalid");
      AppMethodBeat.o(191578);
      throw ((Throwable)localObject);
    }
    Object localObject = fWg();
    if (localObject == null)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerAdapter.java]", "fatal err, tpTrackInfos is null");
      AppMethodBeat.o(191578);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(191578);
      throw ((Throwable)localObject);
    }
    if (this.LWz != null) {
      this.LWz.aR(paramInt, paramLong);
    }
    this.LWE.a(paramInt, localObject[paramInt]);
    AppMethodBeat.o(191578);
  }
  
  public final void aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191603);
    if (!this.LWF.agX(18))
    {
      localObject = new IllegalStateException("error : selectProgram , state invalid");
      AppMethodBeat.o(191603);
      throw ((Throwable)localObject);
    }
    k[] arrayOfk = fWh();
    Object localObject = arrayOfk;
    if (arrayOfk == null) {
      localObject = new k[0];
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : program index not found");
      AppMethodBeat.o(191603);
      throw ((Throwable)localObject);
    }
    if (this.LWz != null) {
      this.LWz.aS(paramInt, paramLong);
    }
    this.LWE.LWs = localObject[paramInt];
    AppMethodBeat.o(191603);
  }
  
  final com.tencent.thumbplayer.a.a.b agW(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(191607);
    if (paramInt == 1) {}
    com.tencent.thumbplayer.a.a.b.b localb;
    for (;;)
    {
      try
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create androidPlayer");
        localObject = this.mContext;
        c localc = this.LWE;
        if (localc.LWl == null) {
          continue;
        }
        if (localc.LWl.mType != 2) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        localObject = new com.tencent.thumbplayer.a.a.a.b((Context)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create Player," + localException.toString());
        localb = null;
        continue;
      }
      if (localObject != null) {
        break;
      }
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "play is null!");
      AppMethodBeat.o(191607);
      return null;
      i = 0;
      continue;
      i = 0;
      continue;
      localObject = new com.tencent.thumbplayer.a.a.a.c((Context)localObject);
      continue;
      if (paramInt == 2)
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create thumbPlayer");
        localb = new com.tencent.thumbplayer.a.a.b.b(this.mContext);
      }
      else
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create no Player");
        localb = null;
      }
    }
    this.LWI = paramInt;
    a(localb);
    AppMethodBeat.o(191607);
    return localb;
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(191571);
    if (!this.LWF.agX(2))
    {
      paramParcelFileDescriptor = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(191571);
      throw paramParcelFileDescriptor;
    }
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalArgumentException("error : setDataSource , pfd invalid");
      AppMethodBeat.o(191571);
      throw paramParcelFileDescriptor;
    }
    this.LWE.b(paramParcelFileDescriptor);
    this.LWA.changeState(2);
    AppMethodBeat.o(191571);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(191567);
    if (!this.LWF.agX(3))
    {
      paramf = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(191567);
      throw paramf;
    }
    if (this.LWz != null) {
      this.LWz.b(paramf);
    }
    this.LWE.a(paramf);
    AppMethodBeat.o(191567);
  }
  
  public final void bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(191575);
    if (!this.LWF.agX(3))
    {
      paramString1 = new IllegalStateException("error : addSubtitleSource , state invalid");
      AppMethodBeat.o(191575);
      throw paramString1;
    }
    if (this.LWz != null) {
      this.LWz.bk(paramString1, paramString2, paramString3);
    }
    this.LWE.bk(paramString1, paramString2, paramString3);
    AppMethodBeat.o(191575);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191594);
    if (!this.LWF.agX(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191594);
      throw localIllegalStateException;
    }
    if (this.LWz != null) {
      this.LWz.c(paramBoolean, paramLong1, paramLong2);
    }
    for (;;)
    {
      this.LWE.c(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(191594);
      return;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void ci(float paramFloat)
  {
    AppMethodBeat.i(191591);
    if (!this.LWF.agX(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191591);
      throw localIllegalStateException;
    }
    if (this.LWz != null) {
      this.LWz.ci(paramFloat);
    }
    for (;;)
    {
      this.LWE.LWo = paramFloat;
      AppMethodBeat.o(191591);
      return;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public final void cj(float paramFloat)
  {
    AppMethodBeat.i(191592);
    if (!this.LWF.agX(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191592);
      throw localIllegalStateException;
    }
    if (this.LWz != null) {
      this.LWz.cj(paramFloat);
    }
    for (;;)
    {
      this.LWE.LWp = paramFloat;
      AppMethodBeat.o(191592);
      return;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "setPlaySpeedRatio, mPlayerBase = null!");
    }
  }
  
  public final void fW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191610);
    this.LWC.fW(paramInt1, paramInt2);
    AppMethodBeat.o(191610);
  }
  
  public final b fWa()
  {
    return this.LWH;
  }
  
  public final j fWb()
  {
    return this.LWA;
  }
  
  public final n[] fWg()
  {
    AppMethodBeat.i(191602);
    if (this.LWz != null)
    {
      arrayOfn = this.LWz.fWg();
      AppMethodBeat.o(191602);
      return arrayOfn;
    }
    n[] arrayOfn = (n[])this.LWE.LWr.toArray(new n[0]);
    AppMethodBeat.o(191602);
    return arrayOfn;
  }
  
  public final k[] fWh()
  {
    AppMethodBeat.i(191604);
    if ((this.LWz != null) && (this.LWz.fWh() != null))
    {
      k[] arrayOfk = this.LWz.fWh();
      AppMethodBeat.o(191604);
      return arrayOfk;
    }
    AppMethodBeat.o(191604);
    return new k[0];
  }
  
  final boolean fWj()
  {
    return this.LWI == 2;
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(191576);
    if (!this.LWF.agX(3))
    {
      paramString1 = new IllegalStateException("error : addAudioTrackSource , state invalid");
      AppMethodBeat.o(191576);
      throw paramString1;
    }
    if (this.LWz != null) {
      this.LWz.g(paramString1, paramString2, paramList);
    }
    c localc = this.LWE;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      c.a locala = new c.a();
      locala.url = paramString1;
      locala.name = paramString2;
      locala.LWt = paramList;
      localc.LWi.put(paramString1, locala);
      localc.trackId += 1;
      paramString1 = new n();
      paramString1.trackType = 2;
      paramString1.name = paramString2;
      paramString1.isSelected = false;
      paramString1.isExclusive = true;
      paramString1.isInternal = false;
      localc.LWr.add(paramString1);
    }
    AppMethodBeat.o(191576);
  }
  
  public final long getBufferedDurationMs()
  {
    AppMethodBeat.i(191599);
    if (!this.LWF.agX(12))
    {
      AppMethodBeat.o(191599);
      return 0L;
    }
    if (this.LWz == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getBufferedDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(191599);
      return 0L;
    }
    long l = this.LWz.getBufferedDurationMs();
    if (this.LWH != null) {
      this.LWH.LWf = l;
    }
    AppMethodBeat.o(191599);
    return l;
  }
  
  public final int getCurrentPlayClipNo()
  {
    if (this.LWH != null) {
      return this.LWH.LWg;
    }
    return 0;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(191598);
    if (!this.LWF.agX(12))
    {
      if (this.LWH != null)
      {
        l = this.LWH.LWe;
        AppMethodBeat.o(191598);
        return l;
      }
      AppMethodBeat.o(191598);
      return 0L;
    }
    if (this.LWz == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getCurrentPositionMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(191598);
      return 0L;
    }
    long l = this.LWz.getCurrentPositionMs();
    if (this.LWH != null) {
      this.LWH.LWe = l;
    }
    AppMethodBeat.o(191598);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(191597);
    if ((this.LWH != null) && (this.LWH.bup > 0L))
    {
      l = this.LWH.bup;
      AppMethodBeat.o(191597);
      return l;
    }
    if (!this.LWF.agX(11))
    {
      AppMethodBeat.o(191597);
      return 0L;
    }
    if (this.LWz == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(191597);
      return 0L;
    }
    long l = this.LWz.getDurationMs();
    if (this.LWH != null) {
      this.LWH.bup = l;
    }
    AppMethodBeat.o(191597);
    return l;
  }
  
  public final int getPlayerType()
  {
    return this.LWI;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(191595);
    if (this.LWz != null)
    {
      long l = this.LWz.getPropertyLong(paramInt);
      AppMethodBeat.o(191595);
      return l;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getPropertyLong, mPlayerBase = null, return !");
    AppMethodBeat.o(191595);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(191596);
    if (this.LWz != null)
    {
      String str = this.LWz.getPropertyString(paramInt);
      AppMethodBeat.o(191596);
      return str;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getPropertyString, mPlayerBase = null, return !");
    AppMethodBeat.o(191596);
    return "";
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(191601);
    if ((this.LWH != null) && (this.LWH.bbt > 0L))
    {
      i = (int)this.LWH.bbt;
      AppMethodBeat.o(191601);
      return i;
    }
    if (!this.LWF.agX(13))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoHeight, state error!");
      AppMethodBeat.o(191601);
      return 0;
    }
    if (this.LWz == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoHeight, mPlayerBase = null, return 0!");
      AppMethodBeat.o(191601);
      return 0;
    }
    int i = this.LWz.getVideoHeight();
    if (this.LWH != null) {
      this.LWH.bbt = i;
    }
    AppMethodBeat.o(191601);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(191600);
    if ((this.LWH != null) && (this.LWH.bbs > 0L))
    {
      i = (int)this.LWH.bbs;
      AppMethodBeat.o(191600);
      return i;
    }
    if (!this.LWF.agX(13))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoWidth, state error!");
      AppMethodBeat.o(191600);
      return 0;
    }
    if (this.LWz == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoWidth, mPlayerBase = null, return 0!");
      AppMethodBeat.o(191600);
      return 0;
    }
    int i = this.LWz.getVideoWidth();
    if (this.LWH != null) {
      this.LWH.bbs = i;
    }
    AppMethodBeat.o(191600);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(191574);
    if ((this.LWA != null) && (this.LWA.fWx() == 5))
    {
      AppMethodBeat.o(191574);
      return true;
    }
    AppMethodBeat.o(191574);
    return false;
  }
  
  public final void kS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191587);
    if (!this.LWF.agX(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191587);
      throw localIllegalStateException;
    }
    if (this.LWz != null)
    {
      this.LWz.kS(paramInt1, paramInt2);
      AppMethodBeat.o(191587);
      return;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "seekTo, mPlayerBase = null!");
    AppMethodBeat.o(191587);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(191582);
    IllegalStateException localIllegalStateException1;
    if (!this.LWF.agX(6))
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191582);
      throw localIllegalStateException1;
    }
    if (this.LWz == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(191582);
      throw localIllegalStateException1;
    }
    try
    {
      this.LWz.pause();
      this.LWA.changeState(6);
      AppMethodBeat.o(191582);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(191582);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(191579);
    Object localObject;
    if (!this.LWF.agX(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191579);
      throw ((Throwable)localObject);
    }
    if (!this.LWE.fWc())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(191579);
      throw ((Throwable)localObject);
    }
    this.LWz = agW(fWi());
    if (this.LWz == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(191579);
      throw ((Throwable)localObject);
    }
    this.LWA.changeState(3);
    this.LWz.prepare();
    AppMethodBeat.o(191579);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(191580);
    Object localObject;
    if (!this.LWF.agX(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191580);
      throw ((Throwable)localObject);
    }
    if (!this.LWE.fWc())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(191580);
      throw ((Throwable)localObject);
    }
    this.LWz = agW(fWi());
    if (this.LWz == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(191580);
      throw ((Throwable)localObject);
    }
    this.LWA.changeState(3);
    this.LWz.prepareAsync();
    AppMethodBeat.o(191580);
  }
  
  public final void release()
  {
    AppMethodBeat.i(191585);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "release");
    if (!this.LWF.agX(16))
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , release , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191585);
      throw localIllegalStateException1;
    }
    try
    {
      if (this.LWz != null)
      {
        this.LWz.release();
        this.LWz = null;
      }
      return;
    }
    catch (Exception localException)
    {
      IllegalStateException localIllegalStateException2 = new IllegalStateException("error , release , exception");
      AppMethodBeat.o(191585);
      throw localIllegalStateException2;
    }
    finally
    {
      this.LWE.reset();
      this.LWC.clear();
      this.LWH = null;
      this.LWG = null;
      this.LWA.changeState(10);
      AppMethodBeat.o(191585);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191584);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "reset");
    if (!this.LWF.agX(8))
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , reset , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191584);
      throw localIllegalStateException1;
    }
    try
    {
      if (this.LWz != null)
      {
        this.LWz.reset();
        this.LWz.release();
        this.LWz = null;
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , reset ,state invalid");
      AppMethodBeat.o(191584);
      throw localIllegalStateException3;
    }
    finally
    {
      this.LWE.reset();
      this.LWH.clear();
      this.LWG = null;
      this.LWA.changeState(1);
      AppMethodBeat.o(191584);
    }
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(191586);
    if (!this.LWF.agX(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191586);
      throw localIllegalStateException;
    }
    if (this.LWz != null)
    {
      this.LWz.seekTo(paramInt);
      AppMethodBeat.o(191586);
      return;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "seekTo, mPlayerBase = null!");
    AppMethodBeat.o(191586);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(191569);
    setDataSource(paramString, null);
    AppMethodBeat.o(191569);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(191570);
    if (!this.LWF.agX(2))
    {
      paramString = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(191570);
      throw paramString;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(191570);
      throw paramString;
    }
    this.LWE.setDataSource(paramString, paramMap);
    this.LWA.changeState(2);
    AppMethodBeat.o(191570);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(191568);
    if (!this.LWF.agX(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(191568);
      throw paramSurface;
    }
    if (this.LWz != null) {
      this.LWz.setSurface(paramSurface);
    }
    this.LWE.mSurface = paramSurface;
    AppMethodBeat.o(191568);
  }
  
  public final void start()
  {
    AppMethodBeat.i(191581);
    IllegalStateException localIllegalStateException1;
    if (!this.LWF.agX(5))
    {
      localIllegalStateException1 = new IllegalStateException("error , start , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191581);
      throw localIllegalStateException1;
    }
    if (this.LWz == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(191581);
      throw localIllegalStateException1;
    }
    try
    {
      this.LWz.start();
      this.LWA.changeState(5);
      AppMethodBeat.o(191581);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(191581);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(191583);
    IllegalStateException localIllegalStateException1;
    if (!this.LWF.agX(7))
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191583);
      throw localIllegalStateException1;
    }
    if (this.LWz == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(191583);
      throw localIllegalStateException1;
    }
    try
    {
      this.LWz.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(191583);
      throw localIllegalStateException3;
    }
    finally
    {
      this.LWA.changeState(8);
      AppMethodBeat.o(191583);
    }
  }
  
  public final void zv(boolean paramBoolean)
  {
    AppMethodBeat.i(191593);
    if (!this.LWF.agX(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191593);
      throw localIllegalStateException;
    }
    if (this.LWz != null) {
      this.LWz.zv(paramBoolean);
    }
    for (;;)
    {
      this.LWE.zv(paramBoolean);
      AppMethodBeat.o(191593);
      return;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void zw(boolean paramBoolean)
  {
    AppMethodBeat.i(191590);
    if (!this.LWF.agX(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.LWA);
      AppMethodBeat.o(191590);
      throw localIllegalStateException;
    }
    if (this.LWz != null) {
      this.LWz.zw(paramBoolean);
    }
    for (;;)
    {
      this.LWE.LWn = paramBoolean;
      AppMethodBeat.o(191590);
      return;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "setOutputMute, mPlayerBase = null!");
    }
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, com.tencent.thumbplayer.a.a.c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.h, c.i, c.j
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191560);
      d locald = d.this;
      if (locald.LWF.agY(4))
      {
        int i = locald.LWG.a(locald.LWH, new com.tencent.thumbplayer.a.b.a.b(locald.LWI, paramInt1, paramInt2));
        if (i == 0)
        {
          locald.LWC.a(paramInt1, paramInt2, paramLong1, paramLong2);
          AppMethodBeat.o(191560);
          return;
        }
        try
        {
          if (locald.LWz != null)
          {
            locald.LWH.LWe = locald.LWz.getCurrentPositionMs();
            locald.LWH.LWf = locald.LWz.getBufferedDurationMs();
            locald.LWz.release();
          }
          locald.LWz = locald.agW(i);
          if (locald.LWz != null) {
            break label192;
          }
          RuntimeException localRuntimeException = new RuntimeException("error , create player failed");
          AppMethodBeat.o(191560);
          throw localRuntimeException;
        }
        catch (IOException localIOException)
        {
          locald.LWC.a(paramInt1, paramInt2, paramLong1, paramLong2);
        }
      }
      else
      {
        AppMethodBeat.o(191560);
        return;
      }
      label192:
      locald.LWB = true;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "switch player to type:" + locald.LWI);
      if (locald.LWH != null)
      {
        com.tencent.thumbplayer.b.f localf = new com.tencent.thumbplayer.b.f().aU(100, locald.LWH.LWe);
        locald.LWz.b(localf);
      }
      locald.LWz.prepare();
      AppMethodBeat.o(191560);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(191559);
      d locald = d.this;
      if (locald.LWB)
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnInfo, mIsRetrying");
        AppMethodBeat.o(191559);
        return;
      }
      if ((paramInt == 152) && (locald.LWH != null)) {
        locald.LWH.LWg = ((int)paramLong1 + 1);
      }
      locald.LWC.a(paramInt, paramLong1, paramLong2, paramObject);
      AppMethodBeat.o(191559);
    }
    
    public final void a(com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(191565);
      d locald = d.this;
      if (locald.LWF.agY(7)) {
        locald.LWC.a(paramc);
      }
      AppMethodBeat.o(191565);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(191563);
      d locald = d.this;
      if (!locald.LWF.agY(7))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnSubtitleData, invalid state");
        AppMethodBeat.o(191563);
        return;
      }
      locald.LWC.a(paramm);
      AppMethodBeat.o(191563);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(191564);
      d locald = d.this;
      if (!locald.LWF.agY(7))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnVideoFrameOut, invalid state");
        AppMethodBeat.o(191564);
        return;
      }
      locald.LWC.a(paramo);
      AppMethodBeat.o(191564);
    }
    
    public final void aD(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191562);
      d locald = d.this;
      if (!locald.LWF.agY(6))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnVideoSizeChange, invalid state");
        AppMethodBeat.o(191562);
        return;
      }
      locald.LWH.bbt = paramLong2;
      locald.LWH.bbs = paramLong1;
      locald.LWC.aD(paramLong1, paramLong2);
      AppMethodBeat.o(191562);
    }
    
    public final void ckp()
    {
      AppMethodBeat.i(191561);
      d locald = d.this;
      if (locald.LWF.agY(5)) {
        locald.LWC.ckp();
      }
      AppMethodBeat.o(191561);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(191558);
      d locald = d.this;
      if (!locald.LWF.agY(2))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnComplete, invalid state");
        AppMethodBeat.o(191558);
        return;
      }
      locald.LWA.changeState(7);
      locald.LWC.onCompletion();
      AppMethodBeat.o(191558);
    }
    
    public final void ta()
    {
      AppMethodBeat.i(191557);
      Object localObject1 = d.this;
      ((d)localObject1).LWC.a(1000, ((d)localObject1).LWI, 0L, null);
      if (((d)localObject1).LWB)
      {
        if (((d)localObject1).LWA.fWx() != 6) {
          ((d)localObject1).start();
        }
        ((d)localObject1).LWB = false;
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnPrepared, mIsRetrying,recoverState!");
        AppMethodBeat.o(191557);
        return;
      }
      if (!((d)localObject1).LWF.agY(1))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnPrepared, invalid state");
        AppMethodBeat.o(191557);
        return;
      }
      if (((d)localObject1).fWj())
      {
        ((d)localObject1).LWH = b.aZI(((d)localObject1).getPropertyString(l.STRING_MEDIA_INFO));
        ((d)localObject1).LWH.LWd = ((int)((d)localObject1).LWz.getPropertyLong(l.LONG_VIDEO_LEVEL));
        ((d)localObject1).LWH.LVX = ((int)((d)localObject1).LWz.getPropertyLong(l.LONG_VIDEO_PROFILE));
        ((d)localObject1).LWH.LVX = ((int)((d)localObject1).LWz.getPropertyLong(l.LONG_AUDIO_PROFILE));
        ((d)localObject1).LWH.LVY = ((int)((d)localObject1).LWz.getPropertyLong(l.LONG_VIDEO_CODEC_ID));
      }
      if (((d)localObject1).LWH == null) {
        ((d)localObject1).LWH = new b();
      }
      ((d)localObject1).LWH.bup = ((d)localObject1).LWz.getDurationMs();
      Object localObject2 = ((d)localObject1).LWE.agV(100);
      if (localObject2 != null) {
        ((d)localObject1).LWH.LWe = ((com.tencent.thumbplayer.b.f)localObject2).LYO.value;
      }
      ((d)localObject1).LWA.changeState(4);
      ((d)localObject1).LWC.ta();
      localObject2 = ((d)localObject1).LWz;
      k[] arrayOfk = ((d)localObject1).fWh();
      if (arrayOfk != null)
      {
        localObject1 = ((d)localObject1).LWE.LWs;
        if (localObject1 != null)
        {
          int i = 0;
          while (i < arrayOfk.length)
          {
            if ((!TextUtils.isEmpty(((k)localObject1).name)) && (arrayOfk[i] != null) && (((k)localObject1).name.equals(arrayOfk[i].name)))
            {
              ((com.tencent.thumbplayer.a.a.b)localObject2).aS(i, -1L);
              AppMethodBeat.o(191557);
              return;
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(191557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.d
 * JD-Core Version:    0.7.0.1
 */