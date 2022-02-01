package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataHandler;", "()V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcDecoder;", "bReStart", "", "bitmapHolders", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$BitmapHolder;", "canDraw", "curAngle", "", "curUserName", "defaultAvatar", "Landroid/graphics/Bitmap;", "largeTargetBitmapHolder", "largeTargetHostName", "largeTargetState", "screenCastHWRenderHelper", "Lcom/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper;", "targetContainer", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "close", "", "isMini", "closeAvCodec", "disableDrawing", "drawAvatar", "target", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "width", "height", "forceUpdate", "userName", "drawVideo", "enableDrawing", "getBitmapHolder", "getDefaultAvatar", "getVideoRenderTarget", "hasTargetContainer", "loadAvatarBitmap", "onScreenDataArrive", "pBuffer", "", "w", "h", "mirror", "angle", "onScreenHwDataArrive", "", "onVideoDataArrive", "refreshBitmap", "bmHolder", "Ljava/nio/ByteBuffer;", "registerTargetContainer", "screenDrawAtLargeTarget", "setLargeTargetState", "state", "largeHostName", "videoDrawAtLargeTarget", "BitmapHolder", "Companion", "plugin-multitalk_release"})
public final class ab
  implements aa
{
  public static final ab.b wdu;
  private volatile boolean juJ;
  private Bitmap nZT;
  g wdk;
  private volatile int wdl;
  private String wdm;
  private final ab.a wdn;
  private final ConcurrentHashMap<String, ab.a> wdo;
  private x wdp;
  private j wdq;
  private boolean wdr;
  private int wds;
  private String wdt;
  
  static
  {
    AppMethodBeat.i(206717);
    wdu = new ab.b((byte)0);
    AppMethodBeat.o(206717);
  }
  
  public ab()
  {
    AppMethodBeat.i(206716);
    this.juJ = true;
    this.wdm = "";
    this.wdn = new ab.a("", (byte)0);
    this.wdo = new ConcurrentHashMap();
    this.wdr = true;
    this.wdt = "";
    AppMethodBeat.o(206716);
  }
  
  private static void a(ab.a parama, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206710);
    System.currentTimeMillis();
    if (parama.wdv != null)
    {
      Bitmap localBitmap = parama.wdv;
      if (localBitmap == null) {
        p.gfZ();
      }
      if (localBitmap.getWidth() == paramInt1)
      {
        localBitmap = parama.wdv;
        if (localBitmap == null) {
          p.gfZ();
        }
        if (localBitmap.getHeight() == paramInt2) {
          break label74;
        }
      }
    }
    parama.wdv = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    label74:
    parama = parama.wdv;
    if (parama != null) {
      parama.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    }
    System.currentTimeMillis();
    AppMethodBeat.o(206710);
  }
  
  private final boolean arC(String paramString)
  {
    AppMethodBeat.i(206713);
    if ((this.wdl == 1) && (p.i(paramString, this.wdm)))
    {
      AppMethodBeat.o(206713);
      return true;
    }
    AppMethodBeat.o(206713);
    return false;
  }
  
  private final boolean arD(String paramString)
  {
    AppMethodBeat.i(206714);
    if ((this.wdl == 2) && (p.i(paramString, this.wdm)))
    {
      AppMethodBeat.o(206714);
      return true;
    }
    AppMethodBeat.o(206714);
    return false;
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206711);
    p.h(paramf, "target");
    ab.a locala = arE(paramf.getUsername());
    Object localObject2 = locala.joW;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = locala.userName;
      localObject1 = a.b.fbx().a((String)localObject1, paramInt1, paramInt2, 1);
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
        localObject2 = this.nZT;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = com.tencent.mm.compatible.e.a.decodeResource(aj.getContext().getResources(), 2131690013);
          this.nZT = ((Bitmap)localObject1);
          p.g(localObject1, "CBitmapFactory.decodeRes…ltAvatar = this\n        }");
        }
      }
    }
    locala.joW = ((Bitmap)localObject1);
    localObject1 = locala.joW;
    if (localObject1 != null)
    {
      paramf.e((Bitmap)localObject1, 0, 0);
      AppMethodBeat.o(206711);
      return;
    }
    AppMethodBeat.o(206711);
  }
  
  public final void a(final String paramString, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(206708);
    p.h(paramString, "userName");
    p.h(paramArrayOfByte, "pBuffer");
    Object localObject = Boolean.valueOf(arD(paramString));
    x localx;
    if (((Boolean)localObject).booleanValue())
    {
      if (localObject == null) {
        break label317;
      }
      ((Boolean)localObject).booleanValue();
      localObject = this.wdk;
      if ((localObject == null) || (((g)localObject).Kx(0) == null)) {
        break label310;
      }
      this.wds = paramInt2;
      this.wdt = paramString;
      if ((this.wdq == null) || (this.wdp == null))
      {
        localx = new x();
        if (localx.handlerThread == null)
        {
          localObject = com.tencent.e.c.d.gW("multatalk_HW_render_thread", -4);
          if (localObject == null) {
            break label304;
          }
          ((HandlerThread)localObject).start();
          localx.handler = new Handler(((HandlerThread)localObject).getLooper());
        }
      }
    }
    for (;;)
    {
      localx.handlerThread = ((HandlerThread)localObject);
      localx.B((d.g.a.a)new x.a(localx));
      localObject = (d.g.a.q)new d(this, paramInt2, paramString, paramArrayOfByte, paramInt1);
      p.h(localObject, "listener");
      localx.B((d.g.a.a)new x.d(localx, (d.g.a.q)localObject));
      localx.B((d.g.a.a)new e(localx, this, paramInt2, paramString, paramArrayOfByte, paramInt1));
      this.wdp = localx;
      this.wdr = false;
      long l = bt.HI();
      paramString = this.wdq;
      if (paramString != null) {
        paramString.f(paramArrayOfByte, paramInt1, this.wdr);
      }
      paramString = com.tencent.mm.plugin.multitalk.c.d.whH;
      com.tencent.mm.plugin.multitalk.c.d.append(2, bt.aO(l));
      AppMethodBeat.o(206708);
      return;
      localObject = null;
      break;
      label304:
      localObject = null;
    }
    label310:
    AppMethodBeat.o(206708);
    return;
    label317:
    AppMethodBeat.o(206708);
  }
  
  public final void a(final String paramString, final int[] paramArrayOfInt, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(206707);
    p.h(paramString, "userName");
    p.h(paramArrayOfInt, "pBuffer");
    this.wdr = true;
    paramString = Boolean.valueOf(arD(paramString));
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
        paramString = this.wdk;
        if (paramString != null)
        {
          paramString = paramString.Kx(paramInt3);
          if (paramString != null)
          {
            this.wds = paramInt3;
            Object localObject = this.wdn;
            a((ab.a)localObject, paramArrayOfInt, paramInt1, paramInt2);
            ((ab.a)localObject).mirror = 0;
            ((ab.a)localObject).angle = paramInt3;
            localObject = ((ab.a)localObject).wdv;
            if (localObject != null)
            {
              c.g((d.g.a.a)new c((Bitmap)localObject, paramString, this, paramInt3, paramArrayOfInt, paramInt1, paramInt2));
              AppMethodBeat.o(206707);
              return;
              i = 0;
              break;
              label171:
              paramString = null;
              continue;
            }
            AppMethodBeat.o(206707);
            return;
          }
        }
        AppMethodBeat.o(206707);
        return;
      }
    }
    AppMethodBeat.o(206707);
  }
  
  public final void a(final String paramString, final int[] paramArrayOfInt, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(206706);
    p.h(paramString, "userName");
    p.h(paramArrayOfInt, "pBuffer");
    Object localObject1;
    if (arC(paramString))
    {
      localObject1 = this.wdk;
      if (localObject1 != null) {
        localObject1 = ((g)localObject1).Kx(0);
      }
    }
    while (localObject1 != null)
    {
      Object localObject2 = arE(paramString);
      a((ab.a)localObject2, paramArrayOfInt, paramInt1, paramInt2);
      ((ab.a)localObject2).mirror = paramInt3;
      ((ab.a)localObject2).angle = paramInt4;
      localObject2 = ((ab.a)localObject2).wdv;
      if (localObject2 != null)
      {
        c.g((d.g.a.a)new f((Bitmap)localObject2, (f)localObject1, this, paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4));
        AppMethodBeat.o(206706);
        return;
        localObject1 = null;
        continue;
        localObject1 = this.wdk;
        if (localObject1 != null) {
          localObject1 = ((g)localObject1).aqZ(paramString);
        } else {
          localObject1 = null;
        }
      }
      else
      {
        AppMethodBeat.o(206706);
        return;
      }
    }
    AppMethodBeat.o(206706);
  }
  
  public final void ab(boolean paramBoolean)
  {
    AppMethodBeat.i(206712);
    this.wdk = null;
    a(this);
    if (!paramBoolean) {
      this.wdo.clear();
    }
    ab.a locala = this.wdn;
    locala.wdv = null;
    locala.joW = null;
    dqC();
    AppMethodBeat.o(206712);
  }
  
  public final ab.a arE(String paramString)
  {
    AppMethodBeat.i(206715);
    if (arC(paramString))
    {
      paramString = this.wdn;
      AppMethodBeat.o(206715);
      return paramString;
    }
    ab.a locala2 = (ab.a)this.wdo.get(paramString);
    ab.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new ab.a(paramString, (byte)0);
      ((Map)this.wdo).put(paramString, locala1);
    }
    AppMethodBeat.o(206715);
    return locala1;
  }
  
  public final void bx(int paramInt, String paramString)
  {
    AppMethodBeat.i(206704);
    p.h(paramString, "largeHostName");
    ad.i("VideoDisplayDataMuxer", "setLargeTargetState ".concat(String.valueOf(paramInt)));
    this.wdl = paramInt;
    this.wdm = paramString;
    AppMethodBeat.o(206704);
  }
  
  public final void dqA()
  {
    this.juJ = true;
  }
  
  public final void dqB()
  {
    this.juJ = false;
  }
  
  public final void dqC()
  {
    AppMethodBeat.i(206709);
    Object localObject = this.wdq;
    if (localObject != null)
    {
      ((j)localObject).dpf();
      localObject = this.wdp;
      if (localObject != null)
      {
        ((x)localObject).B((d.g.a.a)new x.b((x)localObject));
        localObject = ((x)localObject).handlerThread;
        if (localObject != null) {
          ((HandlerThread)localObject).quitSafely();
        }
      }
      this.wdp = null;
    }
    this.wdq = null;
    AppMethodBeat.o(206709);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenDataArrive$2$1$2$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$3"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(Bitmap paramBitmap, f paramf, ab paramab, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenHwDataArrive$2$1$1$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$apply$lambda$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$4"})
  static final class d
    extends d.g.b.q
    implements d.g.a.q<ByteBuffer, Integer, Integer, z>
  {
    d(ab paramab, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenHwDataArrive$2$1$1$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$apply$lambda$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$5"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(x paramx, ab paramab, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onVideoDataArrive$1$2$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$1"})
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