package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.multitalk.d.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataHandler;", "()V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcDecoder;", "bReStart", "", "bitmapHolders", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$BitmapHolder;", "canDraw", "curAngle", "", "curUserName", "defaultAvatar", "Landroid/graphics/Bitmap;", "largeTargetBitmapHolder", "largeTargetHostName", "largeTargetState", "screenCastHWRenderHelper", "Lcom/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper;", "targetContainer", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "close", "", "isMini", "closeAvCodec", "disableDrawing", "drawAvatar", "target", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "width", "height", "forceUpdate", "userName", "drawVideo", "enableDrawing", "getBitmapHolder", "getDefaultAvatar", "getVideoRenderTarget", "hasTargetContainer", "loadAvatarBitmap", "onScreenDataArrive", "pBuffer", "", "w", "h", "mirror", "angle", "onScreenHwDataArrive", "", "onVideoDataArrive", "refreshBitmap", "bmHolder", "Ljava/nio/ByteBuffer;", "registerTargetContainer", "screenDrawAtLargeTarget", "setLargeTargetState", "state", "largeHostName", "videoDrawAtLargeTarget", "BitmapHolder", "Companion", "plugin-multitalk_release"})
public final class ab
  implements aa
{
  public static final ab.b wsW;
  private volatile boolean jxE;
  private Bitmap ofD;
  g wsM;
  private volatile int wsN;
  private String wsO;
  private final ab.a wsP;
  private final ConcurrentHashMap<String, ab.a> wsQ;
  private x wsR;
  private j wsS;
  private boolean wsT;
  private int wsU;
  private String wsV;
  
  static
  {
    AppMethodBeat.i(190990);
    wsW = new ab.b((byte)0);
    AppMethodBeat.o(190990);
  }
  
  public ab()
  {
    AppMethodBeat.i(190989);
    this.jxE = true;
    this.wsO = "";
    this.wsP = new ab.a("", (byte)0);
    this.wsQ = new ConcurrentHashMap();
    this.wsT = true;
    this.wsV = "";
    AppMethodBeat.o(190989);
  }
  
  private static void a(ab.a parama, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190982);
    System.currentTimeMillis();
    if (parama.wsX != null)
    {
      Bitmap localBitmap = parama.wsX;
      if (localBitmap == null) {
        p.gkB();
      }
      if (localBitmap.getWidth() == paramInt1)
      {
        localBitmap = parama.wsX;
        if (localBitmap == null) {
          p.gkB();
        }
        if (localBitmap.getHeight() == paramInt2) {
          break label74;
        }
      }
    }
    parama.wsX = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    label74:
    parama = parama.wsX;
    if (parama != null) {
      parama.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    }
    System.currentTimeMillis();
    AppMethodBeat.o(190982);
  }
  
  private final boolean asO(String paramString)
  {
    AppMethodBeat.i(190985);
    if ((this.wsN == 1) && (p.i(paramString, this.wsO)))
    {
      AppMethodBeat.o(190985);
      return true;
    }
    AppMethodBeat.o(190985);
    return false;
  }
  
  private final boolean asP(String paramString)
  {
    AppMethodBeat.i(190986);
    if ((this.wsN == 2) && (p.i(paramString, this.wsO)))
    {
      AppMethodBeat.o(190986);
      return true;
    }
    AppMethodBeat.o(190986);
    return false;
  }
  
  private final f asR(String paramString)
  {
    AppMethodBeat.i(190988);
    if (asO(paramString))
    {
      paramString = this.wsM;
      if (paramString != null)
      {
        paramString = paramString.Lc(0);
        AppMethodBeat.o(190988);
        return paramString;
      }
      AppMethodBeat.o(190988);
      return null;
    }
    g localg = this.wsM;
    if (localg != null)
    {
      paramString = localg.ash(paramString);
      AppMethodBeat.o(190988);
      return paramString;
    }
    AppMethodBeat.o(190988);
    return null;
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190983);
    p.h(paramf, "target");
    ab.a locala = asQ(paramf.getUsername());
    Object localObject2 = locala.jrP;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = locala.userName;
      localObject1 = a.b.ffl().a((String)localObject1, paramInt1, paramInt2, 1);
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((Bitmap)localObject1).getHeight() < ((Bitmap)localObject1).getWidth()) {
          localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getHeight(), ((Bitmap)localObject1).getHeight());
        }
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject2 = this.ofD;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = com.tencent.mm.compatible.e.a.decodeResource(ak.getContext().getResources(), 2131690013);
          this.ofD = ((Bitmap)localObject1);
          p.g(localObject1, "CBitmapFactory.decodeRes…ltAvatar = this\n        }");
        }
      }
    }
    locala.jrP = ((Bitmap)localObject1);
    localObject1 = locala.jrP;
    if (localObject1 != null)
    {
      paramf.e((Bitmap)localObject1, 0, 0);
      AppMethodBeat.o(190983);
      return;
    }
    AppMethodBeat.o(190983);
  }
  
  public final void a(final String paramString, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(190980);
    p.h(paramString, "userName");
    p.h(paramArrayOfByte, "pBuffer");
    Object localObject = Boolean.valueOf(asP(paramString));
    if (((Boolean)localObject).booleanValue()) {}
    while (localObject != null)
    {
      ((Boolean)localObject).booleanValue();
      localObject = this.wsM;
      if ((localObject != null) && (((g)localObject).Lc(0) != null))
      {
        this.wsU = paramInt2;
        this.wsV = paramString;
        if ((this.wsS == null) || (this.wsR == null))
        {
          localObject = new x();
          ((x)localObject).dtE();
          ((x)localObject).d((d.g.a.q)new d(this, paramInt2, paramString, paramArrayOfByte, paramInt1));
          ((x)localObject).B((d.g.a.a)new e((x)localObject, this, paramInt2, paramString, paramArrayOfByte, paramInt1));
          this.wsR = ((x)localObject);
          this.wsT = false;
        }
        long l = bu.HQ();
        paramString = this.wsS;
        if (paramString != null) {
          paramString.f(paramArrayOfByte, paramInt1, this.wsT);
        }
        paramString = d.wxl;
        d.append(2, bu.aO(l));
        AppMethodBeat.o(190980);
        return;
        localObject = null;
      }
      else
      {
        AppMethodBeat.o(190980);
        return;
      }
    }
    AppMethodBeat.o(190980);
  }
  
  public final void a(final String paramString, final int[] paramArrayOfInt, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(190979);
    p.h(paramString, "userName");
    p.h(paramArrayOfInt, "pBuffer");
    this.wsT = true;
    paramString = Boolean.valueOf(asP(paramString));
    if ((paramString.booleanValue()) && (paramInt1 > 0) && (paramInt2 > 0)) {
      if (i == 0) {
        break label171;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString.booleanValue();
        paramString = this.wsM;
        if (paramString != null)
        {
          paramString = paramString.Lc(paramInt3);
          if (paramString != null)
          {
            this.wsU = paramInt3;
            Object localObject = this.wsP;
            a((ab.a)localObject, paramArrayOfInt, paramInt1, paramInt2);
            ((ab.a)localObject).mirror = 0;
            ((ab.a)localObject).angle = paramInt3;
            localObject = ((ab.a)localObject).wsX;
            if (localObject != null)
            {
              c.h((d.g.a.a)new c((Bitmap)localObject, paramString, this, paramInt3, paramArrayOfInt, paramInt1, paramInt2));
              AppMethodBeat.o(190979);
              return;
              i = 0;
              break;
              label171:
              paramString = null;
              continue;
            }
            AppMethodBeat.o(190979);
            return;
          }
        }
        AppMethodBeat.o(190979);
        return;
      }
    }
    AppMethodBeat.o(190979);
  }
  
  public final void a(final String paramString, final int[] paramArrayOfInt, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(190978);
    p.h(paramString, "userName");
    p.h(paramArrayOfInt, "pBuffer");
    final f localf = asR(paramString);
    if (localf != null)
    {
      Object localObject = asQ(paramString);
      a((ab.a)localObject, paramArrayOfInt, paramInt1, paramInt2);
      ((ab.a)localObject).mirror = paramInt3;
      ((ab.a)localObject).angle = paramInt4;
      localObject = ((ab.a)localObject).wsX;
      if (localObject != null)
      {
        c.h((d.g.a.a)new f((Bitmap)localObject, localf, this, paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4));
        AppMethodBeat.o(190978);
        return;
      }
      AppMethodBeat.o(190978);
      return;
    }
    AppMethodBeat.o(190978);
  }
  
  public final void ab(boolean paramBoolean)
  {
    AppMethodBeat.i(190984);
    this.wsM = null;
    a(this);
    if (!paramBoolean) {
      this.wsQ.clear();
    }
    ab.a locala = this.wsP;
    locala.wsX = null;
    locala.jrP = null;
    dtP();
    AppMethodBeat.o(190984);
  }
  
  public final ab.a asQ(String paramString)
  {
    AppMethodBeat.i(190987);
    if (asO(paramString))
    {
      paramString = this.wsP;
      AppMethodBeat.o(190987);
      return paramString;
    }
    ab.a locala2 = (ab.a)this.wsQ.get(paramString);
    ab.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new ab.a(paramString, (byte)0);
      ((Map)this.wsQ).put(paramString, locala1);
    }
    AppMethodBeat.o(190987);
    return locala1;
  }
  
  public final void bx(int paramInt, String paramString)
  {
    AppMethodBeat.i(190976);
    p.h(paramString, "largeHostName");
    ae.i("VideoDisplayDataMuxer", "setLargeTargetState ".concat(String.valueOf(paramInt)));
    this.wsN = paramInt;
    this.wsO = paramString;
    AppMethodBeat.o(190976);
  }
  
  public final void dtN()
  {
    this.jxE = true;
  }
  
  public final void dtO()
  {
    this.jxE = false;
  }
  
  public final void dtP()
  {
    AppMethodBeat.i(190981);
    Object localObject = this.wsS;
    if (localObject != null)
    {
      ((j)localObject).dsq();
      localObject = this.wsR;
      if (localObject != null)
      {
        ((x)localObject).B((d.g.a.a)new x.b((x)localObject));
        localObject = ((x)localObject).handlerThread;
        if (localObject != null) {
          ((HandlerThread)localObject).quitSafely();
        }
      }
      this.wsR = null;
    }
    this.wsS = null;
    AppMethodBeat.o(190981);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenDataArrive$2$1$2$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$3"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(Bitmap paramBitmap, f paramf, ab paramab, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenHwDataArrive$2$1$1$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$apply$lambda$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$4"})
  static final class d
    extends d.g.b.q
    implements d.g.a.q<ByteBuffer, Integer, Integer, z>
  {
    d(ab paramab, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenHwDataArrive$2$1$1$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$apply$lambda$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$5"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(x paramx, ab paramab, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onVideoDataArrive$1$2$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$1"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    f(Bitmap paramBitmap, f paramf, ab paramab, String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ab
 * JD-Core Version:    0.7.0.1
 */