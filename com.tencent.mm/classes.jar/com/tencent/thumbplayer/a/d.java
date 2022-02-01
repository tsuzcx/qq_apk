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
  g MtA;
  com.tencent.thumbplayer.a.b.a MtB;
  b MtC;
  int MtD;
  com.tencent.thumbplayer.a.a.b Mtu;
  j Mtv;
  boolean Mtw;
  e Mtx;
  private a Mty;
  c Mtz;
  private Context mContext;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(194244);
    this.mContext = paramContext;
    this.Mtv = new j();
    this.Mtv.Mwd = this;
    this.Mtz = new c();
    this.Mty = new a((byte)0);
    this.Mtx = new e("TPThumbPlayer[TPPlayerAdapter.java]");
    this.MtA = new g(this.Mtv);
    this.MtC = new b();
    AppMethodBeat.o(194244);
  }
  
  private static com.tencent.thumbplayer.a.b.a a(c paramc)
  {
    AppMethodBeat.i(194287);
    try
    {
      paramc = new com.tencent.thumbplayer.a.b.a.a(paramc);
      paramc = new com.tencent.thumbplayer.a.b.c(paramc);
      AppMethodBeat.o(194287);
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
    AppMethodBeat.i(194286);
    paramb.a(this.Mty);
    paramb.a(this.Mty);
    paramb.a(this.Mty);
    paramb.a(this.Mty);
    paramb.a(this.Mty);
    paramb.a(this.Mty);
    paramb.a(this.Mty);
    if (gaI())
    {
      paramb.a(this.Mty);
      paramb.a(this.Mty);
    }
    if (1 == this.Mtz.Mtg.mType) {
      paramb.b(this.Mtz.Mtg.MtQ);
    }
    for (;;)
    {
      localObject1 = this.Mtz.gaE().iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramb.b((com.tencent.thumbplayer.b.f)((Iterator)localObject1).next());
      }
      if (this.Mtz.Mtg.mType == 0) {
        paramb.setDataSource(this.Mtz.Mtg.mUrl, this.Mtz.Mtg.mHttpHeaders);
      } else if (2 == this.Mtz.Mtg.mType) {
        paramb.a(this.Mtz.Mtg.MtR);
      }
    }
    int i = 0;
    Object localObject3;
    if (i < this.Mtz.Mtm.size())
    {
      localObject1 = (n)this.Mtz.Mtm.get(i);
      if (((n)localObject1).trackType == 3)
      {
        localObject2 = this.Mtz.gaC().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (c.d)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((c.d)localObject3).name)) && (((c.d)localObject3).name.equals(((n)localObject1).name)))
          {
            paramb.bl(((c.d)localObject3).url, ((c.d)localObject3).mimeType, ((c.d)localObject3).name);
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
          localObject2 = this.Mtz.gaD().iterator();
          label398:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (c.a)((Iterator)localObject2).next();
            if ((TextUtils.isEmpty(((c.a)localObject3).name)) || (!((c.a)localObject3).name.equals(((n)localObject1).name))) {
              break label368;
            }
            paramb.g(((c.a)localObject3).url, ((c.a)localObject3).name, ((c.a)localObject3).Mto);
          }
        }
      }
    }
    Object localObject1 = this.Mtz.Mte.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.c)((Iterator)localObject1).next();
      if (((c.c)localObject2).Mtt.isSelected)
      {
        localObject3 = paramb.gaF();
        if (localObject3 == null)
        {
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerAdapter.java]", "playerTrackInfoList is null.");
        }
        else
        {
          i = 0;
          while (i < localObject3.length)
          {
            if (((c.c)localObject2).Mtt.name.equals(localObject3[i].name)) {
              paramb.aR(i, ((c.c)localObject2).Mts);
            }
            i += 1;
          }
        }
      }
    }
    if (this.Mtz.Mth != null) {
      paramb.c(this.Mtz.Mth.Mtp, this.Mtz.Mth.Mtq, this.Mtz.Mth.Mtr);
    }
    paramb.zK(this.Mtz.Mti);
    if (this.Mtz.Mtj != 0.0F) {
      paramb.cg(this.Mtz.Mtj);
    }
    if (this.Mtz.Mtk != 0.0F) {
      paramb.ch(this.Mtz.Mtk);
    }
    if (this.Mtz.mSurface != null) {
      paramb.setSurface(this.Mtz.mSurface);
    }
    localObject1 = new com.tencent.thumbplayer.b.f();
    Object localObject2 = this.MtB.gaS();
    ((com.tencent.thumbplayer.b.f)localObject1).MvH = 4;
    ((com.tencent.thumbplayer.b.f)localObject1).key = 204;
    ((com.tencent.thumbplayer.b.f)localObject1).MvL = new f.c();
    ((com.tencent.thumbplayer.b.f)localObject1).MvL.MvP = ((int[])localObject2);
    paramb.b((com.tencent.thumbplayer.b.f)localObject1);
    AppMethodBeat.o(194286);
  }
  
  private int gaH()
  {
    AppMethodBeat.i(194284);
    if (this.MtB == null) {
      this.MtB = a(this.Mtz);
    }
    int i = this.MtB.a(this.MtC);
    AppMethodBeat.o(194284);
    return i;
  }
  
  public final void L(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(194266);
    if (!this.MtA.ahG(17))
    {
      paramString = new IllegalStateException("error , switch definition , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194266);
      throw paramString;
    }
    if (this.Mtu != null)
    {
      this.Mtu.L(paramString, paramInt, paramLong);
      AppMethodBeat.o(194266);
      return;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(194266);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    this.Mtx.MtN = parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    this.Mtx.MtG = paramb;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.c paramc)
  {
    this.Mtx.MtI = paramc;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    this.Mtx.MtH = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.Mtx.MtF = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.Mtx.MtJ = paramf;
  }
  
  public final void a(c.g paramg)
  {
    this.Mtx.MtO = paramg;
  }
  
  public final void a(c.h paramh)
  {
    this.Mtx.MtL = paramh;
  }
  
  public final void a(c.i parami)
  {
    this.Mtx.MtM = parami;
  }
  
  public final void a(c.j paramj)
  {
    this.Mtx.MtK = paramj;
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(194250);
    if (!this.MtA.ahG(2))
    {
      parama = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(194250);
      throw parama;
    }
    if (parama == null)
    {
      parama = new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
      AppMethodBeat.o(194250);
      throw parama;
    }
    f localf = this.Mtz.Mtg;
    localf.mUrl = null;
    localf.mType = 2;
    localf.mHttpHeaders.clear();
    localf.MtQ = null;
    localf.MtR = parama;
    this.Mtv.changeState(2);
    AppMethodBeat.o(194250);
  }
  
  public final void a(com.tencent.thumbplayer.b.a.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(194267);
    if (!this.MtA.ahG(17))
    {
      parama = new IllegalStateException("error , switch definition , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194267);
      throw parama;
    }
    if (this.Mtu != null)
    {
      this.Mtu.a(parama, paramInt, paramLong);
      AppMethodBeat.o(194267);
      return;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(194267);
  }
  
  public final void a(com.tencent.thumbplayer.b.e parame, com.tencent.thumbplayer.b.d paramd)
  {
    AppMethodBeat.i(194283);
    if (this.Mtu != null)
    {
      this.Mtu.a(parame, paramd);
      AppMethodBeat.o(194283);
      return;
    }
    parame = new IllegalStateException("error , no player for capture :" + this.Mtv);
    AppMethodBeat.o(194283);
    throw parame;
  }
  
  public final void a(p paramp)
  {
    int i = 26;
    AppMethodBeat.i(194251);
    if (!this.MtA.ahG(2)) {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerAdapter.java]", "setVideoInfo state invalid");
    }
    b localb;
    int j;
    if (paramp != null)
    {
      this.MtC.bbt = paramp.bbt;
      this.MtC.bbs = paramp.bbs;
      localb = this.MtC;
      j = paramp.videoCodecId;
      if (26 != j) {
        break label84;
      }
    }
    for (;;)
    {
      localb.MsT = i;
      AppMethodBeat.o(194251);
      return;
      label84:
      if (172 == j) {
        i = 172;
      } else {
        i = j;
      }
    }
  }
  
  public final void aR(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194255);
    if (!this.MtA.ahG(3))
    {
      localObject = new IllegalStateException("error : selectTrack , state invalid");
      AppMethodBeat.o(194255);
      throw ((Throwable)localObject);
    }
    Object localObject = gaF();
    if (localObject == null)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerAdapter.java]", "fatal err, tpTrackInfos is null");
      AppMethodBeat.o(194255);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(194255);
      throw ((Throwable)localObject);
    }
    if (this.Mtu != null) {
      this.Mtu.aR(paramInt, paramLong);
    }
    this.Mtz.a(paramInt, paramLong, localObject[paramInt]);
    AppMethodBeat.o(194255);
  }
  
  public final void aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194256);
    if (!this.MtA.ahG(3))
    {
      localObject = new IllegalStateException("error : deselectTrack , state invalid");
      AppMethodBeat.o(194256);
      throw ((Throwable)localObject);
    }
    Object localObject = gaF();
    if (localObject == null)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayerAdapter.java]", "fatal err, tpTrackInfos is null");
      AppMethodBeat.o(194256);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(194256);
      throw ((Throwable)localObject);
    }
    if (this.Mtu != null) {
      this.Mtu.aS(paramInt, paramLong);
    }
    this.Mtz.a(paramInt, localObject[paramInt]);
    AppMethodBeat.o(194256);
  }
  
  public final void aT(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194281);
    if (!this.MtA.ahG(18))
    {
      localObject = new IllegalStateException("error : selectProgram , state invalid");
      AppMethodBeat.o(194281);
      throw ((Throwable)localObject);
    }
    k[] arrayOfk = gaG();
    Object localObject = arrayOfk;
    if (arrayOfk == null) {
      localObject = new k[0];
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : program index not found");
      AppMethodBeat.o(194281);
      throw ((Throwable)localObject);
    }
    if (this.Mtu != null) {
      this.Mtu.aT(paramInt, paramLong);
    }
    this.Mtz.Mtn = localObject[paramInt];
    AppMethodBeat.o(194281);
  }
  
  final com.tencent.thumbplayer.a.a.b ahF(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(194285);
    if (paramInt == 1) {}
    com.tencent.thumbplayer.a.a.b.b localb;
    for (;;)
    {
      try
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "to create androidPlayer");
        localObject = this.mContext;
        c localc = this.Mtz;
        if (localc.Mtg == null) {
          continue;
        }
        if (localc.Mtg.mType != 2) {
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
      AppMethodBeat.o(194285);
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
    this.MtD = paramInt;
    a(localb);
    AppMethodBeat.o(194285);
    return localb;
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(194249);
    if (!this.MtA.ahG(2))
    {
      paramParcelFileDescriptor = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(194249);
      throw paramParcelFileDescriptor;
    }
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalArgumentException("error : setDataSource , pfd invalid");
      AppMethodBeat.o(194249);
      throw paramParcelFileDescriptor;
    }
    this.Mtz.b(paramParcelFileDescriptor);
    this.Mtv.changeState(2);
    AppMethodBeat.o(194249);
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(194245);
    if (!this.MtA.ahG(3))
    {
      paramf = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(194245);
      throw paramf;
    }
    if (this.Mtu != null) {
      this.Mtu.b(paramf);
    }
    this.Mtz.a(paramf);
    AppMethodBeat.o(194245);
  }
  
  public final void bl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194253);
    if (!this.MtA.ahG(3))
    {
      paramString1 = new IllegalStateException("error : addSubtitleSource , state invalid");
      AppMethodBeat.o(194253);
      throw paramString1;
    }
    if (this.Mtu != null) {
      this.Mtu.bl(paramString1, paramString2, paramString3);
    }
    this.Mtz.bl(paramString1, paramString2, paramString3);
    AppMethodBeat.o(194253);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194272);
    if (!this.MtA.ahG(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194272);
      throw localIllegalStateException;
    }
    if (this.Mtu != null) {
      this.Mtu.c(paramBoolean, paramLong1, paramLong2);
    }
    for (;;)
    {
      this.Mtz.c(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(194272);
      return;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void cg(float paramFloat)
  {
    AppMethodBeat.i(194269);
    if (!this.MtA.ahG(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194269);
      throw localIllegalStateException;
    }
    if (this.Mtu != null) {
      this.Mtu.cg(paramFloat);
    }
    for (;;)
    {
      this.Mtz.Mtj = paramFloat;
      AppMethodBeat.o(194269);
      return;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public final void ch(float paramFloat)
  {
    AppMethodBeat.i(194270);
    if (!this.MtA.ahG(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194270);
      throw localIllegalStateException;
    }
    if (this.Mtu != null) {
      this.Mtu.ch(paramFloat);
    }
    for (;;)
    {
      this.Mtz.Mtk = paramFloat;
      AppMethodBeat.o(194270);
      return;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "setPlaySpeedRatio, mPlayerBase = null!");
    }
  }
  
  public final void fW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194288);
    this.Mtx.fW(paramInt1, paramInt2);
    AppMethodBeat.o(194288);
  }
  
  public final void g(String paramString1, String paramString2, List<com.tencent.thumbplayer.b.f> paramList)
  {
    AppMethodBeat.i(194254);
    if (!this.MtA.ahG(3))
    {
      paramString1 = new IllegalStateException("error : addAudioTrackSource , state invalid");
      AppMethodBeat.o(194254);
      throw paramString1;
    }
    if (this.Mtu != null) {
      this.Mtu.g(paramString1, paramString2, paramList);
    }
    c localc = this.Mtz;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      c.a locala = new c.a();
      locala.url = paramString1;
      locala.name = paramString2;
      locala.Mto = paramList;
      localc.Mtd.put(paramString1, locala);
      localc.trackId += 1;
      paramString1 = new n();
      paramString1.trackType = 2;
      paramString1.name = paramString2;
      paramString1.isSelected = false;
      paramString1.isExclusive = true;
      paramString1.isInternal = false;
      localc.Mtm.add(paramString1);
    }
    AppMethodBeat.o(194254);
  }
  
  public final j gaA()
  {
    return this.Mtv;
  }
  
  public final n[] gaF()
  {
    AppMethodBeat.i(194280);
    if (this.Mtu != null)
    {
      arrayOfn = this.Mtu.gaF();
      AppMethodBeat.o(194280);
      return arrayOfn;
    }
    n[] arrayOfn = (n[])this.Mtz.Mtm.toArray(new n[0]);
    AppMethodBeat.o(194280);
    return arrayOfn;
  }
  
  public final k[] gaG()
  {
    AppMethodBeat.i(194282);
    if ((this.Mtu != null) && (this.Mtu.gaG() != null))
    {
      k[] arrayOfk = this.Mtu.gaG();
      AppMethodBeat.o(194282);
      return arrayOfk;
    }
    AppMethodBeat.o(194282);
    return new k[0];
  }
  
  final boolean gaI()
  {
    return this.MtD == 2;
  }
  
  public final b gaz()
  {
    return this.MtC;
  }
  
  public final long getBufferedDurationMs()
  {
    AppMethodBeat.i(194277);
    if (!this.MtA.ahG(12))
    {
      AppMethodBeat.o(194277);
      return 0L;
    }
    if (this.Mtu == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getBufferedDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(194277);
      return 0L;
    }
    long l = this.Mtu.getBufferedDurationMs();
    if (this.MtC != null) {
      this.MtC.Mta = l;
    }
    AppMethodBeat.o(194277);
    return l;
  }
  
  public final int getCurrentPlayClipNo()
  {
    if (this.MtC != null) {
      return this.MtC.Mtb;
    }
    return 0;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(194276);
    if (!this.MtA.ahG(12))
    {
      if (this.MtC != null)
      {
        l = this.MtC.MsZ;
        AppMethodBeat.o(194276);
        return l;
      }
      AppMethodBeat.o(194276);
      return 0L;
    }
    if (this.Mtu == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getCurrentPositionMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(194276);
      return 0L;
    }
    long l = this.Mtu.getCurrentPositionMs();
    if (this.MtC != null) {
      this.MtC.MsZ = l;
    }
    AppMethodBeat.o(194276);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(194275);
    if ((this.MtC != null) && (this.MtC.bup > 0L))
    {
      l = this.MtC.bup;
      AppMethodBeat.o(194275);
      return l;
    }
    if (!this.MtA.ahG(11))
    {
      AppMethodBeat.o(194275);
      return 0L;
    }
    if (this.Mtu == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(194275);
      return 0L;
    }
    long l = this.Mtu.getDurationMs();
    if (this.MtC != null) {
      this.MtC.bup = l;
    }
    AppMethodBeat.o(194275);
    return l;
  }
  
  public final int getPlayerType()
  {
    return this.MtD;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(194273);
    if (this.Mtu != null)
    {
      long l = this.Mtu.getPropertyLong(paramInt);
      AppMethodBeat.o(194273);
      return l;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getPropertyLong, mPlayerBase = null, return !");
    AppMethodBeat.o(194273);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(194274);
    if (this.Mtu != null)
    {
      String str = this.Mtu.getPropertyString(paramInt);
      AppMethodBeat.o(194274);
      return str;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getPropertyString, mPlayerBase = null, return !");
    AppMethodBeat.o(194274);
    return "";
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(194279);
    if ((this.MtC != null) && (this.MtC.bbt > 0L))
    {
      i = (int)this.MtC.bbt;
      AppMethodBeat.o(194279);
      return i;
    }
    if (!this.MtA.ahG(13))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoHeight, state error!");
      AppMethodBeat.o(194279);
      return 0;
    }
    if (this.Mtu == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoHeight, mPlayerBase = null, return 0!");
      AppMethodBeat.o(194279);
      return 0;
    }
    int i = this.Mtu.getVideoHeight();
    if (this.MtC != null) {
      this.MtC.bbt = i;
    }
    AppMethodBeat.o(194279);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(194278);
    if ((this.MtC != null) && (this.MtC.bbs > 0L))
    {
      i = (int)this.MtC.bbs;
      AppMethodBeat.o(194278);
      return i;
    }
    if (!this.MtA.ahG(13))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoWidth, state error!");
      AppMethodBeat.o(194278);
      return 0;
    }
    if (this.Mtu == null)
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "getVideoWidth, mPlayerBase = null, return 0!");
      AppMethodBeat.o(194278);
      return 0;
    }
    int i = this.Mtu.getVideoWidth();
    if (this.MtC != null) {
      this.MtC.bbs = i;
    }
    AppMethodBeat.o(194278);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(194252);
    if ((this.Mtv != null) && (this.Mtv.gaW() == 5))
    {
      AppMethodBeat.o(194252);
      return true;
    }
    AppMethodBeat.o(194252);
    return false;
  }
  
  public final void kZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194265);
    if (!this.MtA.ahG(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194265);
      throw localIllegalStateException;
    }
    if (this.Mtu != null)
    {
      this.Mtu.kZ(paramInt1, paramInt2);
      AppMethodBeat.o(194265);
      return;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "seekTo, mPlayerBase = null!");
    AppMethodBeat.o(194265);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(194260);
    IllegalStateException localIllegalStateException1;
    if (!this.MtA.ahG(6))
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194260);
      throw localIllegalStateException1;
    }
    if (this.Mtu == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(194260);
      throw localIllegalStateException1;
    }
    try
    {
      this.Mtu.pause();
      this.Mtv.changeState(6);
      AppMethodBeat.o(194260);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(194260);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(194257);
    Object localObject;
    if (!this.MtA.ahG(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194257);
      throw ((Throwable)localObject);
    }
    if (!this.Mtz.gaB())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(194257);
      throw ((Throwable)localObject);
    }
    this.Mtu = ahF(gaH());
    if (this.Mtu == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(194257);
      throw ((Throwable)localObject);
    }
    this.Mtv.changeState(3);
    this.Mtu.prepare();
    AppMethodBeat.o(194257);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(194258);
    Object localObject;
    if (!this.MtA.ahG(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194258);
      throw ((Throwable)localObject);
    }
    if (!this.Mtz.gaB())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(194258);
      throw ((Throwable)localObject);
    }
    this.Mtu = ahF(gaH());
    if (this.Mtu == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(194258);
      throw ((Throwable)localObject);
    }
    this.Mtv.changeState(3);
    this.Mtu.prepareAsync();
    AppMethodBeat.o(194258);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194263);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "release");
    if (!this.MtA.ahG(16))
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , release , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194263);
      throw localIllegalStateException1;
    }
    try
    {
      if (this.Mtu != null)
      {
        this.Mtu.release();
        this.Mtu = null;
      }
      return;
    }
    catch (Exception localException)
    {
      IllegalStateException localIllegalStateException2 = new IllegalStateException("error , release , exception");
      AppMethodBeat.o(194263);
      throw localIllegalStateException2;
    }
    finally
    {
      this.Mtz.reset();
      this.Mtx.clear();
      this.MtC = null;
      this.MtB = null;
      this.Mtv.changeState(10);
      AppMethodBeat.o(194263);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194262);
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "reset");
    if (!this.MtA.ahG(8))
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , reset , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194262);
      throw localIllegalStateException1;
    }
    try
    {
      if (this.Mtu != null)
      {
        this.Mtu.reset();
        this.Mtu.release();
        this.Mtu = null;
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , reset ,state invalid");
      AppMethodBeat.o(194262);
      throw localIllegalStateException3;
    }
    finally
    {
      this.Mtz.reset();
      this.MtC.clear();
      this.MtB = null;
      this.Mtv.changeState(1);
      AppMethodBeat.o(194262);
    }
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(194264);
    if (!this.MtA.ahG(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194264);
      throw localIllegalStateException;
    }
    if (this.Mtu != null)
    {
      this.Mtu.seekTo(paramInt);
      AppMethodBeat.o(194264);
      return;
    }
    com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayerAdapter.java]", "seekTo, mPlayerBase = null!");
    AppMethodBeat.o(194264);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(194247);
    setDataSource(paramString, null);
    AppMethodBeat.o(194247);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(194248);
    if (!this.MtA.ahG(2))
    {
      paramString = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(194248);
      throw paramString;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(194248);
      throw paramString;
    }
    this.Mtz.setDataSource(paramString, paramMap);
    this.Mtv.changeState(2);
    AppMethodBeat.o(194248);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(194246);
    if (!this.MtA.ahG(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(194246);
      throw paramSurface;
    }
    if (this.Mtu != null) {
      this.Mtu.setSurface(paramSurface);
    }
    this.Mtz.mSurface = paramSurface;
    AppMethodBeat.o(194246);
  }
  
  public final void start()
  {
    AppMethodBeat.i(194259);
    IllegalStateException localIllegalStateException1;
    if (!this.MtA.ahG(5))
    {
      localIllegalStateException1 = new IllegalStateException("error , start , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194259);
      throw localIllegalStateException1;
    }
    if (this.Mtu == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(194259);
      throw localIllegalStateException1;
    }
    try
    {
      this.Mtu.start();
      this.Mtv.changeState(5);
      AppMethodBeat.o(194259);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(194259);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194261);
    IllegalStateException localIllegalStateException1;
    if (!this.MtA.ahG(7))
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194261);
      throw localIllegalStateException1;
    }
    if (this.Mtu == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(194261);
      throw localIllegalStateException1;
    }
    try
    {
      this.Mtu.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(194261);
      throw localIllegalStateException3;
    }
    finally
    {
      this.Mtv.changeState(8);
      AppMethodBeat.o(194261);
    }
  }
  
  public final void zJ(boolean paramBoolean)
  {
    AppMethodBeat.i(194271);
    if (!this.MtA.ahG(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194271);
      throw localIllegalStateException;
    }
    if (this.Mtu != null) {
      this.Mtu.zJ(paramBoolean);
    }
    for (;;)
    {
      this.Mtz.zJ(paramBoolean);
      AppMethodBeat.o(194271);
      return;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void zK(boolean paramBoolean)
  {
    AppMethodBeat.i(194268);
    if (!this.MtA.ahG(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.Mtv);
      AppMethodBeat.o(194268);
      throw localIllegalStateException;
    }
    if (this.Mtu != null) {
      this.Mtu.zK(paramBoolean);
    }
    for (;;)
    {
      this.Mtz.Mti = paramBoolean;
      AppMethodBeat.o(194268);
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
      AppMethodBeat.i(194238);
      d locald = d.this;
      if (locald.MtA.ahH(4))
      {
        int i = locald.MtB.a(locald.MtC, new com.tencent.thumbplayer.a.b.a.b(locald.MtD, paramInt1, paramInt2));
        if (i == 0)
        {
          locald.Mtx.a(paramInt1, paramInt2, paramLong1, paramLong2);
          AppMethodBeat.o(194238);
          return;
        }
        try
        {
          if (locald.Mtu != null)
          {
            locald.MtC.MsZ = locald.Mtu.getCurrentPositionMs();
            locald.MtC.Mta = locald.Mtu.getBufferedDurationMs();
            locald.Mtu.release();
          }
          locald.Mtu = locald.ahF(i);
          if (locald.Mtu != null) {
            break label192;
          }
          RuntimeException localRuntimeException = new RuntimeException("error , create player failed");
          AppMethodBeat.o(194238);
          throw localRuntimeException;
        }
        catch (IOException localIOException)
        {
          locald.Mtx.a(paramInt1, paramInt2, paramLong1, paramLong2);
        }
      }
      else
      {
        AppMethodBeat.o(194238);
        return;
      }
      label192:
      locald.Mtw = true;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "switch player to type:" + locald.MtD);
      if (locald.MtC != null)
      {
        com.tencent.thumbplayer.b.f localf = new com.tencent.thumbplayer.b.f().aV(100, locald.MtC.MsZ);
        locald.Mtu.b(localf);
      }
      locald.Mtu.prepare();
      AppMethodBeat.o(194238);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(194237);
      d locald = d.this;
      if (locald.Mtw)
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnInfo, mIsRetrying");
        AppMethodBeat.o(194237);
        return;
      }
      if ((paramInt == 152) && (locald.MtC != null)) {
        locald.MtC.Mtb = ((int)paramLong1 + 1);
      }
      locald.Mtx.a(paramInt, paramLong1, paramLong2, paramObject);
      AppMethodBeat.o(194237);
    }
    
    public final void a(com.tencent.thumbplayer.b.c paramc)
    {
      AppMethodBeat.i(194243);
      d locald = d.this;
      if (locald.MtA.ahH(7)) {
        locald.Mtx.a(paramc);
      }
      AppMethodBeat.o(194243);
    }
    
    public final void a(m paramm)
    {
      AppMethodBeat.i(194241);
      d locald = d.this;
      if (!locald.MtA.ahH(7))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnSubtitleData, invalid state");
        AppMethodBeat.o(194241);
        return;
      }
      locald.Mtx.a(paramm);
      AppMethodBeat.o(194241);
    }
    
    public final void a(o paramo)
    {
      AppMethodBeat.i(194242);
      d locald = d.this;
      if (!locald.MtA.ahH(7))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnVideoFrameOut, invalid state");
        AppMethodBeat.o(194242);
        return;
      }
      locald.Mtx.a(paramo);
      AppMethodBeat.o(194242);
    }
    
    public final void aC(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194240);
      d locald = d.this;
      if (!locald.MtA.ahH(6))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnVideoSizeChange, invalid state");
        AppMethodBeat.o(194240);
        return;
      }
      locald.MtC.bbt = paramLong2;
      locald.MtC.bbs = paramLong1;
      locald.Mtx.aC(paramLong1, paramLong2);
      AppMethodBeat.o(194240);
    }
    
    public final void clF()
    {
      AppMethodBeat.i(194239);
      d locald = d.this;
      if (locald.MtA.ahH(5)) {
        locald.Mtx.clF();
      }
      AppMethodBeat.o(194239);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(194236);
      d locald = d.this;
      if (!locald.MtA.ahH(2))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnComplete, invalid state");
        AppMethodBeat.o(194236);
        return;
      }
      locald.Mtv.changeState(7);
      locald.Mtx.onCompletion();
      AppMethodBeat.o(194236);
    }
    
    public final void ta()
    {
      AppMethodBeat.i(194235);
      Object localObject1 = d.this;
      ((d)localObject1).Mtx.a(1000, ((d)localObject1).MtD, 0L, null);
      if (((d)localObject1).Mtw)
      {
        if (((d)localObject1).Mtv.gaW() != 6) {
          ((d)localObject1).start();
        }
        ((d)localObject1).Mtw = false;
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnPrepared, mIsRetrying,recoverState!");
        AppMethodBeat.o(194235);
        return;
      }
      if (!((d)localObject1).MtA.ahH(1))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayerAdapter.java]", "handleOnPrepared, invalid state");
        AppMethodBeat.o(194235);
        return;
      }
      if (((d)localObject1).gaI())
      {
        ((d)localObject1).MtC = b.bbl(((d)localObject1).getPropertyString(l.STRING_MEDIA_INFO));
        ((d)localObject1).MtC.MsY = ((int)((d)localObject1).Mtu.getPropertyLong(l.LONG_VIDEO_LEVEL));
        ((d)localObject1).MtC.MsS = ((int)((d)localObject1).Mtu.getPropertyLong(l.LONG_VIDEO_PROFILE));
        ((d)localObject1).MtC.MsS = ((int)((d)localObject1).Mtu.getPropertyLong(l.LONG_AUDIO_PROFILE));
        ((d)localObject1).MtC.MsT = ((int)((d)localObject1).Mtu.getPropertyLong(l.LONG_VIDEO_CODEC_ID));
      }
      if (((d)localObject1).MtC == null) {
        ((d)localObject1).MtC = new b();
      }
      ((d)localObject1).MtC.bup = ((d)localObject1).Mtu.getDurationMs();
      Object localObject2 = ((d)localObject1).Mtz.ahE(100);
      if (localObject2 != null) {
        ((d)localObject1).MtC.MsZ = ((com.tencent.thumbplayer.b.f)localObject2).MvJ.value;
      }
      ((d)localObject1).Mtv.changeState(4);
      ((d)localObject1).Mtx.ta();
      localObject2 = ((d)localObject1).Mtu;
      k[] arrayOfk = ((d)localObject1).gaG();
      if (arrayOfk != null)
      {
        localObject1 = ((d)localObject1).Mtz.Mtn;
        if (localObject1 != null)
        {
          int i = 0;
          while (i < arrayOfk.length)
          {
            if ((!TextUtils.isEmpty(((k)localObject1).name)) && (arrayOfk[i] != null) && (((k)localObject1).name.equals(arrayOfk[i].name)))
            {
              ((com.tencent.thumbplayer.a.a.b)localObject2).aT(i, -1L);
              AppMethodBeat.o(194235);
              return;
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(194235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.d
 * JD-Core Version:    0.7.0.1
 */