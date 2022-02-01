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
  private static a Sla;
  private static boolean Sle;
  public com.tencent.tmediacodec.e.b Slb;
  public boolean Slc;
  private boolean Sld;
  private final HashMap<b, c> Slf;
  private final com.tencent.tmediacodec.d.a Slg;
  private final com.tencent.tmediacodec.c.a Slh;
  private final com.tencent.tmediacodec.c.a Sli;
  
  static
  {
    AppMethodBeat.i(190079);
    Sla = new a();
    Sle = false;
    AppMethodBeat.o(190079);
  }
  
  public a()
  {
    AppMethodBeat.i(190074);
    this.Slb = com.tencent.tmediacodec.e.b.SmK;
    this.Slc = true;
    this.Slf = new HashMap();
    this.Slg = new com.tencent.tmediacodec.d.a();
    this.Slh = new com.tencent.tmediacodec.c.a();
    this.Sli = new com.tencent.tmediacodec.c.a();
    AppMethodBeat.o(190074);
  }
  
  public static a hpn()
  {
    return Sla;
  }
  
  public final c a(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, b paramb)
  {
    AppMethodBeat.i(190076);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder("configureStart videoPoolInfo:").append(this.Slh.hpC()).append(", audioPoolInfo:").append(this.Sli.hpC());
      com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
    }
    this.Sld = true;
    boolean bool3 = this.Slc;
    boolean bool4 = paramb.Slo;
    boolean bool5 = com.tencent.tmediacodec.g.d.by(paramb.Slq);
    boolean bool1;
    boolean bool2;
    label109:
    Object localObject1;
    if ((bool3) && (bool4))
    {
      bool1 = true;
      if ((Build.VERSION.SDK_INT < 23) || (com.tencent.tmediacodec.g.d.hpH())) {
        break label513;
      }
      bool2 = true;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("getCodec isVideo:").append(bool5).append(" reuseEnable:").append(bool1).append(' ').append("globalReuseEnable:").append(bool3).append(" mediaCodecReuseEnable:").append(bool4).append(" canUseSetOutputSurfaceAPI:").append(bool2).append(" ,surface:").append(paramSurface);
        com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
      }
      if ((!bool1) || (!bool5) || (!bool2) || (paramSurface == null)) {
        break label519;
      }
      bool1 = true;
      label211:
      paramb.Slj = bool1;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("getCodec isVideo:").append(bool5).append(" codecFinalReuseEnable:").append(bool1);
        com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
      }
      if (bool1) {
        break label545;
      }
      paramb.Slk = false;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("getCodec return DirectCodecWrapper for mediaFormat:").append(paramMediaFormat).append(" globalReuseEnable:").append(bool3).append(' ').append("mediaCodecReuseEnable:").append(bool4).append(" surface:").append(paramSurface);
        com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
      }
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("createDirectCodecWrapper mediaFormat:").append(paramMediaFormat).append(" createBy:").append(paramb.Slr).append(" nameOrType:").append(paramb.Slq);
        com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
      }
      if (paramb.Slr != b.b.Slt) {
        break label525;
      }
      localObject1 = new com.tencent.tmediacodec.b.d(MediaCodec.createByCodecName(paramb.Slq));
      label403:
      if (this.Slc)
      {
        if (!(localObject1 instanceof g)) {
          break label1101;
        }
        this.Slh.f((f)localObject1);
      }
    }
    for (;;)
    {
      ((c)localObject1).a(paramb.Slm);
      ((c)localObject1).configure(paramMediaFormat, paramSurface, paramMediaCrypto, 0);
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("configureEnd   videoPoolInfo:").append(this.Slh.hpC()).append(", audioPoolInfo:").append(this.Sli.hpC());
        com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
      }
      AppMethodBeat.o(190076);
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
      localObject1 = new com.tencent.tmediacodec.b.d(MediaCodec.createDecoderByType(paramb.Slq));
      break label403;
      label545:
      Object localObject2 = e.i(paramMediaFormat);
      if (bool5) {}
      for (localObject1 = this.Slh.c((e)localObject2);; localObject1 = this.Sli.c((e)localObject2))
      {
        e.bA(((e)localObject2).Slz);
        if (localObject1 == null) {
          break label725;
        }
        localObject2 = ((c)localObject1).b((e)localObject2);
        if ((localObject2 != a.b.SmE) && (localObject2 != a.b.SmD)) {
          break label680;
        }
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          new StringBuilder("getCodec reuse, isVideo:").append(bool5).append(" reuseType:").append(localObject2);
          com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
        }
        ((c)localObject1).hpt();
        ((c)localObject1).hpu();
        paramb.Slk = true;
        break;
      }
      label680:
      if ((localObject2 == a.b.SmB) && (com.tencent.tmediacodec.g.b.isLogEnable()))
      {
        new StringBuilder("getCodec not reuse, isVideo:").append(bool5).append(" reuseType:").append(localObject2);
        com.tencent.tmediacodec.g.b.bqS("TCodecManager");
      }
      label725:
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        "getCodec not reuse, for can't find reUseAble CodecWrapper. isVideo:".concat(String.valueOf(bool5));
        com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
      }
      paramb.Slk = false;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("createNewReuseCodecWrapper mediaFormat:").append(paramMediaFormat).append(" createBy:").append(paramb.Slr).append(" nameOrType:").append(paramb.Slq);
        com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
      }
      localObject1 = paramMediaFormat.getString("mime");
      localObject2 = e.i(paramMediaFormat);
      com.tencent.tmediacodec.e.b localb = Sla.Slb;
      int i = Math.max(localb.SmH, ((e)localObject2).width);
      int j = Math.max(localb.SmI, ((e)localObject2).height);
      if (localb.SmG)
      {
        localb.SmH = i;
        localb.SmI = j;
      }
      int k = Math.max(0, com.tencent.tmediacodec.g.d.d(((e)localObject2).bdq, i, j, false));
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("initFormatWrapper initWidth:").append(i).append(" initHeight:").append(j).append(" initMaxInputSize:").append(k).append(' ').append("reusePolicy:").append(localb);
        com.tencent.tmediacodec.g.b.bqQ("ReuseHelper");
      }
      ((e)localObject2).maxWidth = i;
      ((e)localObject2).maxHeight = j;
      ((e)localObject2).bdr = k;
      paramMediaFormat.setInteger("max-input-size", Math.max(k, 0));
      if ((((e)localObject2).cWJ()) && (Build.VERSION.SDK_INT >= 19))
      {
        paramMediaFormat.setInteger("max-width", i);
        paramMediaFormat.setInteger("max-height", j);
      }
      if (paramb.Slr == b.b.Slt) {}
      for (localObject1 = f.a(MediaCodec.createByCodecName(paramb.Slq), (String)localObject1, (e)localObject2);; localObject1 = f.a(MediaCodec.createDecoderByType((String)localObject1), (String)localObject1, (e)localObject2))
      {
        ((c)localObject1).hpt();
        this.Slf.put(paramb, localObject1);
        break;
      }
      label1101:
      if ((localObject1 instanceof com.tencent.tmediacodec.b.a)) {
        this.Sli.f((f)localObject1);
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(190077);
    if (this.Slc)
    {
      if ((paramc instanceof g))
      {
        this.Slh.g((f)paramc);
        AppMethodBeat.o(190077);
        return;
      }
      if ((paramc instanceof com.tencent.tmediacodec.b.a)) {
        this.Sli.g((f)paramc);
      }
    }
    AppMethodBeat.o(190077);
  }
  
  public final void a(com.tencent.tmediacodec.e.b paramb)
  {
    this.Slb = paramb;
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(190078);
    if (this.Slc)
    {
      if ((paramc instanceof g))
      {
        this.Slh.h((f)paramc);
        AppMethodBeat.o(190078);
        return;
      }
      if ((paramc instanceof com.tencent.tmediacodec.b.a)) {
        this.Sli.h((f)paramc);
      }
    }
    AppMethodBeat.o(190078);
  }
  
  public final void hpo()
  {
    AppMethodBeat.i(190075);
    if (this.Slc != true)
    {
      this.Slc = true;
      if ((this.Sld) && (!this.Slc))
      {
        this.Slh.hpB();
        this.Sli.hpB();
      }
    }
    AppMethodBeat.o(190075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.a
 * JD-Core Version:    0.7.0.1
 */