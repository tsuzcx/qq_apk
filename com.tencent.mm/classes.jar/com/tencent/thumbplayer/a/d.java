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
  com.tencent.thumbplayer.a.a.b KcD;
  j KcE;
  boolean KcF;
  e KcG;
  private a KcH;
  c KcI;
  g KcJ;
  com.tencent.thumbplayer.a.b.a KcK;
  b KcL;
  int KcM;
  private Context mContext;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(187545);
    this.mContext = paramContext;
    this.KcE = new j();
    this.KcE.Kfn = this;
    this.KcI = new c();
    this.KcH = new a((byte)0);
    this.KcG = new e("TPThumbPlayer[TPPlayerAdapter.java]");
    this.KcJ = new g(this.KcE);
    this.KcL = new b();
    AppMethodBeat.o(187545);
  }
  
  private static com.tencent.thumbplayer.a.b.a a(c paramc)
  {
    AppMethodBeat.i(187588);
    try
    {
      paramc = new com.tencent.thumbplayer.a.b.a.a(paramc);
      paramc = new com.tencent.thumbplayer.a.b.c(paramc);
      AppMethodBeat.o(187588);
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
    AppMethodBeat.i(187587);
    paramb.a(this.KcH);
    paramb.a(this.KcH);
    paramb.a(this.KcH);
    paramb.a(this.KcH);
    paramb.a(this.KcH);
    paramb.a(this.KcH);
    paramb.a(this.KcH);
    if (fER())
    {
      paramb.a(this.KcH);
      paramb.a(this.KcH);
    }
    if (1 == this.KcI.Kcp.mType) {
      paramb.b(this.KcI.Kcp.KcZ);
    }
    for (;;)
    {
      localObject1 = this.KcI.fEN().iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramb.b((com.tencent.thumbplayer.b.f)((Iterator)localObject1).next());
      }
      if (this.KcI.Kcp.mType == 0) {
        paramb.setDataSource(this.KcI.Kcp.mUrl, this.KcI.Kcp.mHttpHeaders);
      } else if (2 == this.KcI.Kcp.mType) {
        paramb.a(this.KcI.Kcp.Kda);
      }
    }
    int i = 0;
    Object localObject3;
    if (i < this.KcI.Kcv.size())
    {
      localObject1 = (n)this.KcI.Kcv.get(i);
      if (((n)localObject1).trackType == 3)
      {
        localObject2 = this.KcI.fEL().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (c.d)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((c.d)localObject3).name)) && (((c.d)localObject3).name.equals(((n)localObject1).name)))
          {
            paramb.bb(((c.d)localObject3).url, ((c.d)localObject3).mimeType, ((c.d)localObject3).name);
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
          localObject2 = this.KcI.fEM().iterator();
          label398:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (c.a)((Iterator)localObject2).next();
            if ((TextUtils.isEmpty(((c.a)localObject3).name)) || (!((c.a)localObject3).name.equals(((n)localObject1).name))) {
              break label368;
            }
            paramb.g(((c.a)localObject3).url, ((c.a)localObject3).name, ((c.a)localObject3).Kcx);
          }
        }
      }
    }
    Object localObject1 = this.KcI.Kcn.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.c)((Iterator)localObject1).next();
      if (((c.c)localObject2).KcC.isSelected)
      {
        localObject3 = paramb.fEO();
        if (localObject3 == null)
        {
          com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayerAdapter.java]", "playerTrackInfoList is null.");
        }
        else
        {
          i = 0;
          while (i < localObject3.length)
          {
            if (((c.c)localObject2).KcC.name.equals(localObject3[i].name)) {
              paramb.aG(i, ((c.c)localObject2).KcB);
            }
            i += 1;
          }
        }
      }
    }
    if (this.KcI.Kcq != null) {
      paramb.c(this.KcI.Kcq.Kcy, this.KcI.Kcq.Kcz, this.KcI.Kcq.KcA);
    }
    paramb.yJ(this.KcI.Kcr);
    if (this.KcI.Kcs != 0.0F) {
      paramb.cd(this.KcI.Kcs);
    }
    if (this.KcI.Kct != 0.0F) {
      paramb.ce(this.KcI.Kct);
    }
    if (this.KcI.mSurface != null) {
      paramb.setSurface(this.KcI.mSurface);
    }
    localObject1 = new com.tencent.thumbplayer.b.f();
    Object localObject2 = this.KcK.fFb();
    ((com.tencent.thumbplayer.b.f)localObject1).KeQ = 4;
    ((com.tencent.thumbplayer.b.f)localObject1).key = 204;
    ((com.tencent.thumbplayer.b.f)localObject1).KeU = new f.c();
    ((com.tencent.thumbplayer.b.f)localObject1).KeU.KeY = ((int[])localObject2);
    paramb.b((com.tencent.thumbplayer.b.f)localObject1);
    AppMethodBeat.o(187587);
  }
  
  private int fEQ()
  {
    AppMethodBeat.i(187585);
    if (this.KcK == null) {
      this.KcK = a(this.KcI);
    }
    int i = this.KcK.a(this.KcL);
    AppMethodBeat.o(187585);
    return i;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    this.KcG.KcW = parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    this.KcG.KcP = paramb;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.c paramc)
  {
    this.KcG.KcR = paramc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    this.KcG.KcQ = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.KcG.KcO = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.KcG.KcS = paramf;
  }
  
  public final void a(c.g paramg)
  {
    this.KcG.KcX = paramg;
  }
  
  public final void a(c.h paramh)
  {
    this.KcG.KcU = paramh;
  }
  
  public final void a(c.i parami)
  {
    this.KcG.KcV = parami;
  }
  
  public final void a(c.j paramj)
  {
    this.KcG.KcT = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(187551);
    if (!this.KcJ.aex(2))
    {
      parama = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(187551);
      throw parama;
    }
    if (parama == null)
    {
      parama = new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
      AppMethodBeat.o(187551);
      throw parama;
    }
    f localf = this.KcI.Kcp;
    localf.mUrl = null;
    localf.mType = 2;
    localf.mHttpHeaders.clear();
    localf.KcZ = null;
    localf.Kda = parama;
    this.KcE.changeState(2);
    AppMethodBeat.o(187551);
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(187568);
    if (!this.KcJ.aex(17))
    {
      parama = new IllegalStateException("error , switch definition , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187568);
      throw parama;
    }
    if (this.KcD != null)
    {
      this.KcD.a(parama, paramInt, paramLong);
      AppMethodBeat.o(187568);
      return;
    }
    com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(187568);
  }
  
  public final void a(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(187584);
    if (this.KcD != null)
    {
      this.KcD.a(parame, paramd);
      AppMethodBeat.o(187584);
      return;
    }
    parame = new IllegalStateException("error , no player for capture :" + this.KcE);
    AppMethodBeat.o(187584);
    throw parame;
  }
  
  public final void a(p paramp)
  {
    int i = 26;
    AppMethodBeat.i(187552);
    if (!this.KcJ.aex(2)) {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayerAdapter.java]", "setVideoInfo state invalid");
    }
    b localb;
    int j;
    if (paramp != null)
    {
      this.KcL.aQY = paramp.aQY;
      this.KcL.aQX = paramp.aQX;
      localb = this.KcL;
      j = paramp.videoCodecId;
      if (26 != j) {
        break label84;
      }
    }
    for (;;)
    {
      localb.Kcc = i;
      AppMethodBeat.o(187552);
      return;
      label84:
      if (172 == j) {
        i = 172;
      } else {
        i = j;
      }
    }
  }
  
  public final void aG(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187556);
    if (!this.KcJ.aex(3))
    {
      localObject = new IllegalStateException("error : selectTrack , state invalid");
      AppMethodBeat.o(187556);
      throw ((Throwable)localObject);
    }
    Object localObject = fEO();
    if (localObject == null)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayerAdapter.java]", "fatal err, tpTrackInfos is null");
      AppMethodBeat.o(187556);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(187556);
      throw ((Throwable)localObject);
    }
    if (this.KcD != null) {
      this.KcD.aG(paramInt, paramLong);
    }
    this.KcI.a(paramInt, paramLong, localObject[paramInt]);
    AppMethodBeat.o(187556);
  }
  
  public final void aH(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187557);
    if (!this.KcJ.aex(3))
    {
      localObject = new IllegalStateException("error : deselectTrack , state invalid");
      AppMethodBeat.o(187557);
      throw ((Throwable)localObject);
    }
    Object localObject = fEO();
    if (localObject == null)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayerAdapter.java]", "fatal err, tpTrackInfos is null");
      AppMethodBeat.o(187557);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(187557);
      throw ((Throwable)localObject);
    }
    if (this.KcD != null) {
      this.KcD.aH(paramInt, paramLong);
    }
    this.KcI.a(paramInt, localObject[paramInt]);
    AppMethodBeat.o(187557);
  }
  
  public final void aI(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187582);
    if (!this.KcJ.aex(18))
    {
      localObject = new IllegalStateException("error : selectProgram , state invalid");
      AppMethodBeat.o(187582);
      throw ((Throwable)localObject);
    }
    k[] arrayOfk = fEP();
    Object localObject = arrayOfk;
    if (arrayOfk == null) {
      localObject = new k[0];
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : program index not found");
      AppMethodBeat.o(187582);
      throw ((Throwable)localObject);
    }
    if (this.KcD != null) {
      this.KcD.aI(paramInt, paramLong);
    }
    this.KcI.Kcw = localObject[paramInt];
    AppMethodBeat.o(187582);
  }
  
  final com.tencent.thumbplayer.a.a.b aew(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(187586);
    if (paramInt == 1) {}
    com.tencent.thumbplayer.a.a.b.b localb;
    for (;;)
    {
      try
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create androidPlayer");
        localObject = this.mContext;
        c localc = this.KcI;
        if (localc.Kcp == null) {
          continue;
        }
        if (localc.Kcp.mType != 2) {
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
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create Player," + localException.toString());
        localb = null;
        continue;
      }
      if (localObject != null) {
        break;
      }
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "play is null!");
      AppMethodBeat.o(187586);
      return null;
      i = 0;
      continue;
      i = 0;
      continue;
      localObject = new com.tencent.thumbplayer.a.a.a.c((Context)localObject);
      continue;
      if (paramInt == 2)
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create thumbPlayer");
        localb = new com.tencent.thumbplayer.a.a.b.b(this.mContext);
      }
      else
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create no Player");
        localb = null;
      }
    }
    this.KcM = paramInt;
    a(localb);
    AppMethodBeat.o(187586);
    return localb;
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(187550);
    if (!this.KcJ.aex(2))
    {
      paramParcelFileDescriptor = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(187550);
      throw paramParcelFileDescriptor;
    }
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalArgumentException("error : setDataSource , pfd invalid");
      AppMethodBeat.o(187550);
      throw paramParcelFileDescriptor;
    }
    this.KcI.b(paramParcelFileDescriptor);
    this.KcE.changeState(2);
    AppMethodBeat.o(187550);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(187546);
    if (!this.KcJ.aex(3))
    {
      paramf = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(187546);
      throw paramf;
    }
    if (this.KcD != null) {
      this.KcD.b(paramf);
    }
    this.KcI.a(paramf);
    AppMethodBeat.o(187546);
  }
  
  public final void bb(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187554);
    if (!this.KcJ.aex(3))
    {
      paramString1 = new IllegalStateException("error : addSubtitleSource , state invalid");
      AppMethodBeat.o(187554);
      throw paramString1;
    }
    if (this.KcD != null) {
      this.KcD.bb(paramString1, paramString2, paramString3);
    }
    this.KcI.bb(paramString1, paramString2, paramString3);
    AppMethodBeat.o(187554);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187573);
    if (!this.KcJ.aex(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187573);
      throw localIllegalStateException;
    }
    if (this.KcD != null) {
      this.KcD.c(paramBoolean, paramLong1, paramLong2);
    }
    for (;;)
    {
      this.KcI.c(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(187573);
      return;
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void cd(float paramFloat)
  {
    AppMethodBeat.i(187570);
    if (!this.KcJ.aex(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187570);
      throw localIllegalStateException;
    }
    if (this.KcD != null) {
      this.KcD.cd(paramFloat);
    }
    for (;;)
    {
      this.KcI.Kcs = paramFloat;
      AppMethodBeat.o(187570);
      return;
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public final void ce(float paramFloat)
  {
    AppMethodBeat.i(187571);
    if (!this.KcJ.aex(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187571);
      throw localIllegalStateException;
    }
    if (this.KcD != null) {
      this.KcD.ce(paramFloat);
    }
    for (;;)
    {
      this.KcI.Kct = paramFloat;
      AppMethodBeat.o(187571);
      return;
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "setPlaySpeedRatio, mPlayerBase = null!");
    }
  }
  
  public final b fEI()
  {
    return this.KcL;
  }
  
  public final j fEJ()
  {
    return this.KcE;
  }
  
  public final n[] fEO()
  {
    AppMethodBeat.i(187581);
    if (this.KcD != null)
    {
      arrayOfn = this.KcD.fEO();
      AppMethodBeat.o(187581);
      return arrayOfn;
    }
    n[] arrayOfn = (n[])this.KcI.Kcv.toArray(new n[0]);
    AppMethodBeat.o(187581);
    return arrayOfn;
  }
  
  public final k[] fEP()
  {
    AppMethodBeat.i(187583);
    if ((this.KcD != null) && (this.KcD.fEP() != null))
    {
      k[] arrayOfk = this.KcD.fEP();
      AppMethodBeat.o(187583);
      return arrayOfk;
    }
    AppMethodBeat.o(187583);
    return new k[0];
  }
  
  final boolean fER()
  {
    return this.KcM == 2;
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187589);
    this.KcG.fI(paramInt1, paramInt2);
    AppMethodBeat.o(187589);
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(187555);
    if (!this.KcJ.aex(3))
    {
      paramString1 = new IllegalStateException("error : addAudioTrackSource , state invalid");
      AppMethodBeat.o(187555);
      throw paramString1;
    }
    if (this.KcD != null) {
      this.KcD.g(paramString1, paramString2, paramList);
    }
    c localc = this.KcI;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      c.a locala = new c.a();
      locala.url = paramString1;
      locala.name = paramString2;
      locala.Kcx = paramList;
      localc.Kcm.put(paramString1, locala);
      localc.trackId += 1;
      paramString1 = new n();
      paramString1.trackType = 2;
      paramString1.name = paramString2;
      paramString1.isSelected = false;
      paramString1.isExclusive = true;
      paramString1.isInternal = false;
      localc.Kcv.add(paramString1);
    }
    AppMethodBeat.o(187555);
  }
  
  public final long getBufferedDurationMs()
  {
    AppMethodBeat.i(187578);
    if (!this.KcJ.aex(12))
    {
      AppMethodBeat.o(187578);
      return 0L;
    }
    if (this.KcD == null)
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "getBufferedDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(187578);
      return 0L;
    }
    long l = this.KcD.getBufferedDurationMs();
    if (this.KcL != null) {
      this.KcL.Kcj = l;
    }
    AppMethodBeat.o(187578);
    return l;
  }
  
  public final int getCurrentPlayClipNo()
  {
    if (this.KcL != null) {
      return this.KcL.Kck;
    }
    return 0;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(187577);
    if (!this.KcJ.aex(12))
    {
      if (this.KcL != null)
      {
        l = this.KcL.Kci;
        AppMethodBeat.o(187577);
        return l;
      }
      AppMethodBeat.o(187577);
      return 0L;
    }
    if (this.KcD == null)
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "getCurrentPositionMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(187577);
      return 0L;
    }
    long l = this.KcD.getCurrentPositionMs();
    if (this.KcL != null) {
      this.KcL.Kci = l;
    }
    AppMethodBeat.o(187577);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(187576);
    if ((this.KcL != null) && (this.KcL.bjU > 0L))
    {
      l = this.KcL.bjU;
      AppMethodBeat.o(187576);
      return l;
    }
    if (!this.KcJ.aex(11))
    {
      AppMethodBeat.o(187576);
      return 0L;
    }
    if (this.KcD == null)
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "getDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(187576);
      return 0L;
    }
    long l = this.KcD.getDurationMs();
    if (this.KcL != null) {
      this.KcL.bjU = l;
    }
    AppMethodBeat.o(187576);
    return l;
  }
  
  public final int getPlayerType()
  {
    return this.KcM;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(187574);
    if (this.KcD != null)
    {
      long l = this.KcD.getPropertyLong(paramInt);
      AppMethodBeat.o(187574);
      return l;
    }
    com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "getPropertyLong, mPlayerBase = null, return !");
    AppMethodBeat.o(187574);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(187575);
    if (this.KcD != null)
    {
      String str = this.KcD.getPropertyString(paramInt);
      AppMethodBeat.o(187575);
      return str;
    }
    com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "getPropertyString, mPlayerBase = null, return !");
    AppMethodBeat.o(187575);
    return "";
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(187580);
    if ((this.KcL != null) && (this.KcL.aQY > 0L))
    {
      i = (int)this.KcL.aQY;
      AppMethodBeat.o(187580);
      return i;
    }
    if (!this.KcJ.aex(13))
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoHeight, state error!");
      AppMethodBeat.o(187580);
      return 0;
    }
    if (this.KcD == null)
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoHeight, mPlayerBase = null, return 0!");
      AppMethodBeat.o(187580);
      return 0;
    }
    int i = this.KcD.getVideoHeight();
    if (this.KcL != null) {
      this.KcL.aQY = i;
    }
    AppMethodBeat.o(187580);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(187579);
    if ((this.KcL != null) && (this.KcL.aQX > 0L))
    {
      i = (int)this.KcL.aQX;
      AppMethodBeat.o(187579);
      return i;
    }
    if (!this.KcJ.aex(13))
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoWidth, state error!");
      AppMethodBeat.o(187579);
      return 0;
    }
    if (this.KcD == null)
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoWidth, mPlayerBase = null, return 0!");
      AppMethodBeat.o(187579);
      return 0;
    }
    int i = this.KcD.getVideoWidth();
    if (this.KcL != null) {
      this.KcL.aQX = i;
    }
    AppMethodBeat.o(187579);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(187553);
    if ((this.KcE != null) && (this.KcE.fFg() == 5))
    {
      AppMethodBeat.o(187553);
      return true;
    }
    AppMethodBeat.o(187553);
    return false;
  }
  
  public final void kD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187566);
    if (!this.KcJ.aex(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187566);
      throw localIllegalStateException;
    }
    if (this.KcD != null)
    {
      this.KcD.kD(paramInt1, paramInt2);
      AppMethodBeat.o(187566);
      return;
    }
    com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "seekTo, mPlayerBase = null!");
    AppMethodBeat.o(187566);
  }
  
  public final void p(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(187567);
    if (!this.KcJ.aex(17))
    {
      paramString = new IllegalStateException("error , switch definition , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187567);
      throw paramString;
    }
    if (this.KcD != null)
    {
      this.KcD.p(paramString, paramInt, paramLong);
      AppMethodBeat.o(187567);
      return;
    }
    com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(187567);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(187561);
    IllegalStateException localIllegalStateException1;
    if (!this.KcJ.aex(6))
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187561);
      throw localIllegalStateException1;
    }
    if (this.KcD == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(187561);
      throw localIllegalStateException1;
    }
    try
    {
      this.KcD.pause();
      this.KcE.changeState(6);
      AppMethodBeat.o(187561);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(187561);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(187558);
    Object localObject;
    if (!this.KcJ.aex(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187558);
      throw ((Throwable)localObject);
    }
    if (!this.KcI.fEK())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(187558);
      throw ((Throwable)localObject);
    }
    this.KcD = aew(fEQ());
    if (this.KcD == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(187558);
      throw ((Throwable)localObject);
    }
    this.KcE.changeState(3);
    this.KcD.prepare();
    AppMethodBeat.o(187558);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(187559);
    Object localObject;
    if (!this.KcJ.aex(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187559);
      throw ((Throwable)localObject);
    }
    if (!this.KcI.fEK())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(187559);
      throw ((Throwable)localObject);
    }
    this.KcD = aew(fEQ());
    if (this.KcD == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(187559);
      throw ((Throwable)localObject);
    }
    this.KcE.changeState(3);
    this.KcD.prepareAsync();
    AppMethodBeat.o(187559);
  }
  
  public final void release()
  {
    AppMethodBeat.i(187564);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "release");
    if (!this.KcJ.aex(16))
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , release , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187564);
      throw localIllegalStateException1;
    }
    try
    {
      if (this.KcD != null)
      {
        this.KcD.release();
        this.KcD = null;
      }
      return;
    }
    catch (Exception localException)
    {
      IllegalStateException localIllegalStateException2 = new IllegalStateException("error , release , exception");
      AppMethodBeat.o(187564);
      throw localIllegalStateException2;
    }
    finally
    {
      this.KcI.reset();
      this.KcG.clear();
      this.KcL = null;
      this.KcK = null;
      this.KcE.changeState(10);
      AppMethodBeat.o(187564);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(187563);
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "reset");
    if (!this.KcJ.aex(8))
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , reset , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187563);
      throw localIllegalStateException1;
    }
    try
    {
      if (this.KcD != null)
      {
        this.KcD.reset();
        this.KcD.release();
        this.KcD = null;
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , reset ,state invalid");
      AppMethodBeat.o(187563);
      throw localIllegalStateException3;
    }
    finally
    {
      this.KcI.reset();
      this.KcL.clear();
      this.KcK = null;
      this.KcE.changeState(1);
      AppMethodBeat.o(187563);
    }
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(187565);
    if (!this.KcJ.aex(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187565);
      throw localIllegalStateException;
    }
    if (this.KcD != null)
    {
      this.KcD.seekTo(paramInt);
      AppMethodBeat.o(187565);
      return;
    }
    com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayerAdapter.java]", "seekTo, mPlayerBase = null!");
    AppMethodBeat.o(187565);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(187548);
    setDataSource(paramString, null);
    AppMethodBeat.o(187548);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187549);
    if (!this.KcJ.aex(2))
    {
      paramString = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(187549);
      throw paramString;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(187549);
      throw paramString;
    }
    this.KcI.setDataSource(paramString, paramMap);
    this.KcE.changeState(2);
    AppMethodBeat.o(187549);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(187547);
    if (!this.KcJ.aex(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(187547);
      throw paramSurface;
    }
    if (this.KcD != null) {
      this.KcD.setSurface(paramSurface);
    }
    this.KcI.mSurface = paramSurface;
    AppMethodBeat.o(187547);
  }
  
  public final void start()
  {
    AppMethodBeat.i(187560);
    IllegalStateException localIllegalStateException1;
    if (!this.KcJ.aex(5))
    {
      localIllegalStateException1 = new IllegalStateException("error , start , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187560);
      throw localIllegalStateException1;
    }
    if (this.KcD == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(187560);
      throw localIllegalStateException1;
    }
    try
    {
      this.KcD.start();
      this.KcE.changeState(5);
      AppMethodBeat.o(187560);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(187560);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(187562);
    IllegalStateException localIllegalStateException1;
    if (!this.KcJ.aex(7))
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187562);
      throw localIllegalStateException1;
    }
    if (this.KcD == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(187562);
      throw localIllegalStateException1;
    }
    try
    {
      this.KcD.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(187562);
      throw localIllegalStateException3;
    }
    finally
    {
      this.KcE.changeState(8);
      AppMethodBeat.o(187562);
    }
  }
  
  public final void yI(boolean paramBoolean)
  {
    AppMethodBeat.i(187572);
    if (!this.KcJ.aex(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187572);
      throw localIllegalStateException;
    }
    if (this.KcD != null) {
      this.KcD.yI(paramBoolean);
    }
    for (;;)
    {
      this.KcI.yI(paramBoolean);
      AppMethodBeat.o(187572);
      return;
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void yJ(boolean paramBoolean)
  {
    AppMethodBeat.i(187569);
    if (!this.KcJ.aex(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.KcE);
      AppMethodBeat.o(187569);
      throw localIllegalStateException;
    }
    if (this.KcD != null) {
      this.KcD.yJ(paramBoolean);
    }
    for (;;)
    {
      this.KcI.Kcr = paramBoolean;
      AppMethodBeat.o(187569);
      return;
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "setOutputMute, mPlayerBase = null!");
    }
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, com.tencent.thumbplayer.a.a.c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.h, c.i, c.j
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187539);
      d locald = d.this;
      if (locald.KcJ.aey(4))
      {
        int i = locald.KcK.a(locald.KcL, new com.tencent.thumbplayer.a.b.a.b(locald.KcM, paramInt1, paramInt2));
        if (i == 0)
        {
          locald.KcG.a(paramInt1, paramInt2, paramLong1, paramLong2);
          AppMethodBeat.o(187539);
          return;
        }
        try
        {
          if (locald.KcD != null)
          {
            locald.KcL.Kci = locald.KcD.getCurrentPositionMs();
            locald.KcL.Kcj = locald.KcD.getBufferedDurationMs();
            locald.KcD.release();
          }
          locald.KcD = locald.aew(i);
          if (locald.KcD != null) {
            break label192;
          }
          RuntimeException localRuntimeException = new RuntimeException("error , create player failed");
          AppMethodBeat.o(187539);
          throw localRuntimeException;
        }
        catch (IOException localIOException)
        {
          locald.KcG.a(paramInt1, paramInt2, paramLong1, paramLong2);
        }
      }
      else
      {
        AppMethodBeat.o(187539);
        return;
      }
      label192:
      locald.KcF = true;
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "switch player to type:" + locald.KcM);
      if (locald.KcL != null)
      {
        com.tencent.thumbplayer.b.f localf = new com.tencent.thumbplayer.b.f().aK(100, locald.KcL.Kci);
        locald.KcD.b(localf);
      }
      locald.KcD.prepare();
      AppMethodBeat.o(187539);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(187538);
      d locald = d.this;
      if (locald.KcF)
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnInfo, mIsRetrying");
        AppMethodBeat.o(187538);
        return;
      }
      if ((paramInt == 152) && (locald.KcL != null)) {
        locald.KcL.Kck = ((int)paramLong1 + 1);
      }
      locald.KcG.a(paramInt, paramLong1, paramLong2, paramObject);
      AppMethodBeat.o(187538);
    }
    
    public final void a(com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(187544);
      d locald = d.this;
      if (locald.KcJ.aey(7)) {
        locald.KcG.a(paramc);
      }
      AppMethodBeat.o(187544);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(187542);
      d locald = d.this;
      if (!locald.KcJ.aey(7))
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnSubtitleData, invalid state");
        AppMethodBeat.o(187542);
        return;
      }
      locald.KcG.a(paramm);
      AppMethodBeat.o(187542);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(187543);
      d locald = d.this;
      if (!locald.KcJ.aey(7))
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnVideoFrameOut, invalid state");
        AppMethodBeat.o(187543);
        return;
      }
      locald.KcG.a(paramo);
      AppMethodBeat.o(187543);
    }
    
    public final void ay(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187541);
      d locald = d.this;
      if (!locald.KcJ.aey(6))
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnVideoSizeChange, invalid state");
        AppMethodBeat.o(187541);
        return;
      }
      locald.KcL.aQY = paramLong2;
      locald.KcL.aQX = paramLong1;
      locald.KcG.ay(paramLong1, paramLong2);
      AppMethodBeat.o(187541);
    }
    
    public final void cfM()
    {
      AppMethodBeat.i(187540);
      d locald = d.this;
      if (locald.KcJ.aey(5)) {
        locald.KcG.cfM();
      }
      AppMethodBeat.o(187540);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(187537);
      d locald = d.this;
      if (!locald.KcJ.aey(2))
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnComplete, invalid state");
        AppMethodBeat.o(187537);
        return;
      }
      locald.KcE.changeState(7);
      locald.KcG.onCompletion();
      AppMethodBeat.o(187537);
    }
    
    public final void rB()
    {
      AppMethodBeat.i(187536);
      Object localObject1 = d.this;
      ((d)localObject1).KcG.a(1000, ((d)localObject1).KcM, 0L, null);
      if (((d)localObject1).KcF)
      {
        if (((d)localObject1).KcE.fFg() != 6) {
          ((d)localObject1).start();
        }
        ((d)localObject1).KcF = false;
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnPrepared, mIsRetrying,recoverState!");
        AppMethodBeat.o(187536);
        return;
      }
      if (!((d)localObject1).KcJ.aey(1))
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnPrepared, invalid state");
        AppMethodBeat.o(187536);
        return;
      }
      if (((d)localObject1).fER())
      {
        ((d)localObject1).KcL = b.aTI(((d)localObject1).getPropertyString(l.STRING_MEDIA_INFO));
        ((d)localObject1).KcL.Kch = ((int)((d)localObject1).KcD.getPropertyLong(l.LONG_VIDEO_LEVEL));
        ((d)localObject1).KcL.Kcb = ((int)((d)localObject1).KcD.getPropertyLong(l.LONG_VIDEO_PROFILE));
        ((d)localObject1).KcL.Kcb = ((int)((d)localObject1).KcD.getPropertyLong(l.LONG_AUDIO_PROFILE));
        ((d)localObject1).KcL.Kcc = ((int)((d)localObject1).KcD.getPropertyLong(l.LONG_VIDEO_CODEC_ID));
      }
      if (((d)localObject1).KcL == null) {
        ((d)localObject1).KcL = new b();
      }
      ((d)localObject1).KcL.bjU = ((d)localObject1).KcD.getDurationMs();
      Object localObject2 = ((d)localObject1).KcI.aev(100);
      if (localObject2 != null) {
        ((d)localObject1).KcL.Kci = ((com.tencent.thumbplayer.b.f)localObject2).KeS.value;
      }
      ((d)localObject1).KcE.changeState(4);
      ((d)localObject1).KcG.rB();
      localObject2 = ((d)localObject1).KcD;
      k[] arrayOfk = ((d)localObject1).fEP();
      if (arrayOfk != null)
      {
        localObject1 = ((d)localObject1).KcI.Kcw;
        if (localObject1 != null)
        {
          int i = 0;
          while (i < arrayOfk.length)
          {
            if ((!TextUtils.isEmpty(((k)localObject1).name)) && (arrayOfk[i] != null) && (((k)localObject1).name.equals(arrayOfk[i].name)))
            {
              ((com.tencent.thumbplayer.a.a.b)localObject2).aI(i, -1L);
              AppMethodBeat.o(187536);
              return;
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(187536);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.d
 * JD-Core Version:    0.7.0.1
 */