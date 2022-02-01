package com.tencent.tmediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b.c;
import com.tencent.tmediacodec.b.e;
import com.tencent.tmediacodec.b.f;
import com.tencent.tmediacodec.b.g;
import com.tencent.tmediacodec.e.a.b;
import java.util.HashMap;

public final class a
{
  private static a ZNL;
  private static boolean ZNP;
  public com.tencent.tmediacodec.e.b ZNM;
  public boolean ZNN;
  private boolean ZNO;
  private final HashMap<b, c> ZNQ;
  private final com.tencent.tmediacodec.d.a ZNR;
  private final com.tencent.tmediacodec.c.a ZNS;
  private final com.tencent.tmediacodec.c.a ZNT;
  
  static
  {
    AppMethodBeat.i(224117);
    ZNL = new a();
    ZNP = false;
    AppMethodBeat.o(224117);
  }
  
  public a()
  {
    AppMethodBeat.i(224093);
    this.ZNM = com.tencent.tmediacodec.e.b.ZPv;
    this.ZNN = true;
    this.ZNQ = new HashMap();
    this.ZNR = new com.tencent.tmediacodec.d.a();
    this.ZNS = new com.tencent.tmediacodec.c.a();
    this.ZNT = new com.tencent.tmediacodec.c.a();
    AppMethodBeat.o(224093);
  }
  
  public static a isT()
  {
    return ZNL;
  }
  
  public final c a(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, b paramb)
  {
    AppMethodBeat.i(224111);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder("configureStart videoPoolInfo:").append(this.ZNS.iti()).append(", audioPoolInfo:").append(this.ZNT.iti());
      com.tencent.tmediacodec.g.b.bDP("TCodecManager");
    }
    this.ZNO = true;
    boolean bool3 = this.ZNN;
    boolean bool4 = paramb.ZNZ;
    boolean bool5 = com.tencent.tmediacodec.g.d.bJ(paramb.ZOb);
    boolean bool1;
    boolean bool2;
    label109:
    Object localObject1;
    if ((bool3) && (bool4))
    {
      bool1 = true;
      if ((Build.VERSION.SDK_INT < 23) || (com.tencent.tmediacodec.g.d.ito())) {
        break label513;
      }
      bool2 = true;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("getCodec isVideo:").append(bool5).append(" reuseEnable:").append(bool1).append(' ').append("globalReuseEnable:").append(bool3).append(" mediaCodecReuseEnable:").append(bool4).append(" canUseSetOutputSurfaceAPI:").append(bool2).append(" ,surface:").append(paramSurface);
        com.tencent.tmediacodec.g.b.bDP("TCodecManager");
      }
      if ((!bool1) || (!bool5) || (!bool2) || (paramSurface == null)) {
        break label519;
      }
      bool1 = true;
      label211:
      paramb.ZNU = bool1;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("getCodec isVideo:").append(bool5).append(" codecFinalReuseEnable:").append(bool1);
        com.tencent.tmediacodec.g.b.bDP("TCodecManager");
      }
      if (bool1) {
        break label545;
      }
      paramb.ZNV = false;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("getCodec return DirectCodecWrapper for mediaFormat:").append(paramMediaFormat).append(" globalReuseEnable:").append(bool3).append(' ').append("mediaCodecReuseEnable:").append(bool4).append(" surface:").append(paramSurface);
        com.tencent.tmediacodec.g.b.bDP("TCodecManager");
      }
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("createDirectCodecWrapper mediaFormat:").append(paramMediaFormat).append(" createBy:").append(paramb.ZOc).append(" nameOrType:").append(paramb.ZOb);
        com.tencent.tmediacodec.g.b.bDP("TCodecManager");
      }
      if (paramb.ZOc != b.b.ZOe) {
        break label525;
      }
      localObject1 = new com.tencent.tmediacodec.b.d(MediaCodec.createByCodecName(paramb.ZOb));
      label403:
      if (this.ZNN)
      {
        if (!(localObject1 instanceof g)) {
          break label1101;
        }
        this.ZNS.f((f)localObject1);
      }
    }
    for (;;)
    {
      ((c)localObject1).a(paramb.ZNX);
      ((c)localObject1).a(paramMediaFormat, paramSurface, paramMediaCrypto, 0);
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("configureEnd   videoPoolInfo:").append(this.ZNS.iti()).append(", audioPoolInfo:").append(this.ZNT.iti());
        com.tencent.tmediacodec.g.b.bDP("TCodecManager");
      }
      AppMethodBeat.o(224111);
      return localObject1;
      bool1 = false;
      break;
      label513:
      bool2 = false;
      break label109;
      label519:
      bool1 = false;
      break label211;
      label525:
      localObject1 = new com.tencent.tmediacodec.b.d(MediaCodec.createDecoderByType(paramb.ZOb));
      break label403;
      label545:
      Object localObject2 = e.g(paramMediaFormat);
      if (bool5) {}
      for (localObject1 = this.ZNS.c((e)localObject2);; localObject1 = this.ZNT.c((e)localObject2))
      {
        e.bL(((e)localObject2).ZOk);
        if (localObject1 == null) {
          break label725;
        }
        localObject2 = ((c)localObject1).b((e)localObject2);
        if ((localObject2 != a.b.ZPp) && (localObject2 != a.b.ZPo)) {
          break label680;
        }
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          new StringBuilder("getCodec reuse, isVideo:").append(bool5).append(" reuseType:").append(localObject2);
          com.tencent.tmediacodec.g.b.bDP("TCodecManager");
        }
        ((c)localObject1).isZ();
        ((c)localObject1).ita();
        paramb.ZNV = true;
        break;
      }
      label680:
      if ((localObject2 == a.b.ZPm) && (com.tencent.tmediacodec.g.b.isLogEnable()))
      {
        new StringBuilder("getCodec not reuse, isVideo:").append(bool5).append(" reuseType:").append(localObject2);
        com.tencent.tmediacodec.g.b.bDR("TCodecManager");
      }
      label725:
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        "getCodec not reuse, for can't find reUseAble CodecWrapper. isVideo:".concat(String.valueOf(bool5));
        com.tencent.tmediacodec.g.b.bDP("TCodecManager");
      }
      paramb.ZNV = false;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("createNewReuseCodecWrapper mediaFormat:").append(paramMediaFormat).append(" createBy:").append(paramb.ZOc).append(" nameOrType:").append(paramb.ZOb);
        com.tencent.tmediacodec.g.b.bDP("TCodecManager");
      }
      localObject1 = paramMediaFormat.getString("mime");
      localObject2 = e.g(paramMediaFormat);
      com.tencent.tmediacodec.e.b localb = ZNL.ZNM;
      int i = Math.max(localb.ZPs, ((e)localObject2).width);
      int j = Math.max(localb.ZPt, ((e)localObject2).height);
      if (localb.ZPr)
      {
        localb.ZPs = i;
        localb.ZPt = j;
      }
      int k = Math.max(0, com.tencent.tmediacodec.g.d.d(((e)localObject2).aMQ, i, j, false));
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("initFormatWrapper initWidth:").append(i).append(" initHeight:").append(j).append(" initMaxInputSize:").append(k).append(' ').append("reusePolicy:").append(localb);
        com.tencent.tmediacodec.g.b.bDP("ReuseHelper");
      }
      ((e)localObject2).maxWidth = i;
      ((e)localObject2).maxHeight = j;
      ((e)localObject2).aMR = k;
      paramMediaFormat.setInteger("max-input-size", Math.max(k, 0));
      if ((((e)localObject2).dlR()) && (Build.VERSION.SDK_INT >= 19))
      {
        paramMediaFormat.setInteger("max-width", i);
        paramMediaFormat.setInteger("max-height", j);
      }
      if (paramb.ZOc == b.b.ZOe) {}
      for (localObject1 = f.a(MediaCodec.createByCodecName(paramb.ZOb), (String)localObject1, (e)localObject2);; localObject1 = f.a(MediaCodec.createDecoderByType((String)localObject1), (String)localObject1, (e)localObject2))
      {
        ((c)localObject1).isZ();
        this.ZNQ.put(paramb, localObject1);
        break;
      }
      label1101:
      if ((localObject1 instanceof com.tencent.tmediacodec.b.a)) {
        this.ZNT.f((f)localObject1);
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(224112);
    if (this.ZNN)
    {
      if ((paramc instanceof g))
      {
        this.ZNS.g((f)paramc);
        AppMethodBeat.o(224112);
        return;
      }
      if ((paramc instanceof com.tencent.tmediacodec.b.a)) {
        this.ZNT.g((f)paramc);
      }
    }
    AppMethodBeat.o(224112);
  }
  
  public final void a(com.tencent.tmediacodec.e.b paramb)
  {
    this.ZNM = paramb;
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(224115);
    if (this.ZNN)
    {
      if ((paramc instanceof g))
      {
        this.ZNS.h((f)paramc);
        AppMethodBeat.o(224115);
        return;
      }
      if ((paramc instanceof com.tencent.tmediacodec.b.a)) {
        this.ZNT.h((f)paramc);
      }
    }
    AppMethodBeat.o(224115);
  }
  
  public final void isU()
  {
    AppMethodBeat.i(224099);
    if (this.ZNN != true)
    {
      this.ZNN = true;
      if ((this.ZNO) && (!this.ZNN))
      {
        this.ZNS.ith();
        this.ZNT.ith();
      }
    }
    AppMethodBeat.o(224099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.a
 * JD-Core Version:    0.7.0.1
 */