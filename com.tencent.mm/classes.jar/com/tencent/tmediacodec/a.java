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
  private static a ahSM;
  private static boolean ahSQ;
  public com.tencent.tmediacodec.e.b ahSN;
  public boolean ahSO;
  private boolean ahSP;
  private final HashMap<b, c> ahSR;
  private final com.tencent.tmediacodec.d.a ahSS;
  private final com.tencent.tmediacodec.c.a ahST;
  private final com.tencent.tmediacodec.c.a ahSU;
  
  static
  {
    AppMethodBeat.i(210765);
    ahSM = new a();
    ahSQ = false;
    AppMethodBeat.o(210765);
  }
  
  public a()
  {
    AppMethodBeat.i(210740);
    this.ahSN = com.tencent.tmediacodec.e.b.ahUw;
    this.ahSO = true;
    this.ahSR = new HashMap();
    this.ahSS = new com.tencent.tmediacodec.d.a();
    this.ahST = new com.tencent.tmediacodec.c.a();
    this.ahSU = new com.tencent.tmediacodec.c.a();
    AppMethodBeat.o(210740);
  }
  
  public static a kcn()
  {
    return ahSM;
  }
  
  private void kco()
  {
    AppMethodBeat.i(210756);
    this.ahST.kcB();
    this.ahSU.kcB();
    AppMethodBeat.o(210756);
  }
  
  public final void OE(boolean paramBoolean)
  {
    AppMethodBeat.i(210777);
    if (this.ahSO != paramBoolean)
    {
      this.ahSO = paramBoolean;
      if ((this.ahSP) && (!this.ahSO)) {
        kco();
      }
    }
    AppMethodBeat.o(210777);
  }
  
  public final c a(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, b paramb)
  {
    AppMethodBeat.i(210803);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder("configureStart videoPoolInfo:").append(this.ahST.kcC()).append(", audioPoolInfo:").append(this.ahSU.kcC());
      com.tencent.tmediacodec.g.b.O("TCodecManager");
    }
    this.ahSP = true;
    boolean bool3 = this.ahSO;
    boolean bool4 = paramb.ahTa;
    boolean bool5 = com.tencent.tmediacodec.g.d.isVideo(paramb.ahTc);
    boolean bool1;
    boolean bool2;
    label109:
    Object localObject1;
    if ((bool3) && (bool4))
    {
      bool1 = true;
      if ((Build.VERSION.SDK_INT < 23) || (com.tencent.tmediacodec.g.d.kcI())) {
        break label513;
      }
      bool2 = true;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("getCodec isVideo:").append(bool5).append(" reuseEnable:").append(bool1).append(' ').append("globalReuseEnable:").append(bool3).append(" mediaCodecReuseEnable:").append(bool4).append(" canUseSetOutputSurfaceAPI:").append(bool2).append(" ,surface:").append(paramSurface);
        com.tencent.tmediacodec.g.b.O("TCodecManager");
      }
      if ((!bool1) || (!bool5) || (!bool2) || (paramSurface == null)) {
        break label519;
      }
      bool1 = true;
      label211:
      paramb.ahSV = bool1;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("getCodec isVideo:").append(bool5).append(" codecFinalReuseEnable:").append(bool1);
        com.tencent.tmediacodec.g.b.O("TCodecManager");
      }
      if (bool1) {
        break label545;
      }
      paramb.ahSW = false;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("getCodec return DirectCodecWrapper for mediaFormat:").append(paramMediaFormat).append(" globalReuseEnable:").append(bool3).append(' ').append("mediaCodecReuseEnable:").append(bool4).append(" surface:").append(paramSurface);
        com.tencent.tmediacodec.g.b.O("TCodecManager");
      }
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("createDirectCodecWrapper mediaFormat:").append(paramMediaFormat).append(" createBy:").append(paramb.ahTd).append(" nameOrType:").append(paramb.ahTc);
        com.tencent.tmediacodec.g.b.O("TCodecManager");
      }
      if (paramb.ahTd != b.b.ahTf) {
        break label525;
      }
      localObject1 = new com.tencent.tmediacodec.b.d(MediaCodec.createByCodecName(paramb.ahTc));
      label403:
      if (this.ahSO)
      {
        if (!(localObject1 instanceof g)) {
          break label1104;
        }
        this.ahST.f((f)localObject1);
      }
    }
    for (;;)
    {
      ((c)localObject1).a(paramb.ahSY);
      ((c)localObject1).configure(paramMediaFormat, paramSurface, paramMediaCrypto, 0);
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("configureEnd   videoPoolInfo:").append(this.ahST.kcC()).append(", audioPoolInfo:").append(this.ahSU.kcC());
        com.tencent.tmediacodec.g.b.O("TCodecManager");
      }
      AppMethodBeat.o(210803);
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
      localObject1 = new com.tencent.tmediacodec.b.d(MediaCodec.createDecoderByType(paramb.ahTc));
      break label403;
      label545:
      Object localObject2 = e.g(paramMediaFormat);
      if (bool5) {}
      for (localObject1 = this.ahST.c((e)localObject2);; localObject1 = this.ahSU.c((e)localObject2))
      {
        e.cl(((e)localObject2).ahTl);
        if (localObject1 == null) {
          break label728;
        }
        localObject2 = ((c)localObject1).b((e)localObject2);
        if ((localObject2 != a.b.ahUq) && (localObject2 != a.b.ahUp)) {
          break label682;
        }
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          new StringBuilder("getCodec reuse, isVideo:").append(bool5).append(" reuseType:").append(localObject2);
          com.tencent.tmediacodec.g.b.O("TCodecManager");
        }
        ((c)localObject1).kct();
        ((c)localObject1).kcu();
        paramb.ahSW = true;
        break;
      }
      label682:
      if ((localObject2 == a.b.ahUn) && (com.tencent.tmediacodec.g.b.isLogEnable()))
      {
        new StringBuilder("getCodec not reuse, isVideo:").append(bool5).append(" reuseType:").append(localObject2);
        com.tencent.tmediacodec.g.b.R("TCodecManager");
      }
      label728:
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        "getCodec not reuse, for can't find reUseAble CodecWrapper. isVideo:".concat(String.valueOf(bool5));
        com.tencent.tmediacodec.g.b.O("TCodecManager");
      }
      paramb.ahSW = false;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("createNewReuseCodecWrapper mediaFormat:").append(paramMediaFormat).append(" createBy:").append(paramb.ahTd).append(" nameOrType:").append(paramb.ahTc);
        com.tencent.tmediacodec.g.b.O("TCodecManager");
      }
      localObject1 = paramMediaFormat.getString("mime");
      localObject2 = e.g(paramMediaFormat);
      com.tencent.tmediacodec.e.b localb = ahSM.ahSN;
      int i = Math.max(localb.ahUt, ((e)localObject2).width);
      int j = Math.max(localb.ahUu, ((e)localObject2).height);
      if (localb.ahUs)
      {
        localb.ahUt = i;
        localb.ahUu = j;
      }
      int k = Math.max(0, com.tencent.tmediacodec.g.d.d(((e)localObject2).cGN, i, j, false));
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder("initFormatWrapper initWidth:").append(i).append(" initHeight:").append(j).append(" initMaxInputSize:").append(k).append(' ').append("reusePolicy:").append(localb);
        com.tencent.tmediacodec.g.b.O("ReuseHelper");
      }
      ((e)localObject2).maxWidth = i;
      ((e)localObject2).maxHeight = j;
      ((e)localObject2).cGO = k;
      paramMediaFormat.setInteger("max-input-size", Math.max(k, 0));
      if ((((e)localObject2).dSH()) && (Build.VERSION.SDK_INT >= 19))
      {
        paramMediaFormat.setInteger("max-width", i);
        paramMediaFormat.setInteger("max-height", j);
      }
      if (paramb.ahTd == b.b.ahTf) {}
      for (localObject1 = f.a(MediaCodec.createByCodecName(paramb.ahTc), (String)localObject1, (e)localObject2);; localObject1 = f.a(MediaCodec.createDecoderByType((String)localObject1), (String)localObject1, (e)localObject2))
      {
        ((c)localObject1).kct();
        this.ahSR.put(paramb, localObject1);
        break;
      }
      label1104:
      if ((localObject1 instanceof com.tencent.tmediacodec.b.a)) {
        this.ahSU.f((f)localObject1);
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(210812);
    if (this.ahSO)
    {
      if ((paramc instanceof g))
      {
        this.ahST.g((f)paramc);
        AppMethodBeat.o(210812);
        return;
      }
      if ((paramc instanceof com.tencent.tmediacodec.b.a)) {
        this.ahSU.g((f)paramc);
      }
    }
    AppMethodBeat.o(210812);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(210824);
    if (this.ahSO)
    {
      if ((paramc instanceof g))
      {
        this.ahST.h((f)paramc);
        AppMethodBeat.o(210824);
        return;
      }
      if ((paramc instanceof com.tencent.tmediacodec.b.a)) {
        this.ahSU.h((f)paramc);
      }
    }
    AppMethodBeat.o(210824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.a
 * JD-Core Version:    0.7.0.1
 */