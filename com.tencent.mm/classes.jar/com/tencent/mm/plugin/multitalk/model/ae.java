package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.HandlerThread;
import android.widget.ImageView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataHandler;", "()V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcDecoder;", "bReStart", "", "bitmapHolders", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$BitmapHolder;", "canDraw", "curAngle", "", "curUserName", "defaultAvatar", "Landroid/graphics/Bitmap;", "largeTargetBitmapHolder", "largeTargetHostName", "largeTargetState", "screenCastHWRenderHelper", "Lcom/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper;", "targetContainers", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "Lkotlin/collections/ArrayList;", "close", "", "isMini", "closeAvCodec", "disableDrawing", "drawAvatar", "target", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "drawVideo", "userName", "enableDrawing", "getBitmapHolder", "renderTarget", "getDefaultAvatar", "getVideoRenderTarget", "hasTargetContainer", "container", "loadAvatarBitmap", "width", "height", "onScreenDataArrive", "pBuffer", "", "w", "h", "mirror", "angle", "onScreenHwDataArrive", "", "onVideoDataArrive", "refreshBitmap", "bmHolder", "Ljava/nio/ByteBuffer;", "registerTargetContainer", "targetContainer", "screenDrawAtLargeTarget", "setLargeTargetState", "state", "largeHostName", "unRegisterTargetContainer", "videoDrawAtLargeTarget", "BitmapHolder", "Companion", "plugin-multitalk_release"})
public final class ae
  implements ad
{
  public static final ae.b zPk;
  private volatile boolean kyn;
  ArrayList<g> zPa;
  private volatile int zPb;
  private String zPc;
  private final ae.a zPd;
  private final ConcurrentHashMap<String, ae.a> zPe;
  private aa zPf;
  private j zPg;
  private boolean zPh;
  private int zPi;
  private String zPj;
  
  static
  {
    AppMethodBeat.i(239703);
    zPk = new ae.b((byte)0);
    AppMethodBeat.o(239703);
  }
  
  public ae()
  {
    AppMethodBeat.i(239702);
    this.kyn = true;
    this.zPc = "";
    this.zPd = new ae.a("", (byte)0);
    this.zPe = new ConcurrentHashMap();
    this.zPh = true;
    this.zPj = "";
    AppMethodBeat.o(239702);
  }
  
  private final void a(ae.a parama, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(239695);
        if (parama.zPl != null)
        {
          Bitmap localBitmap = parama.zPl;
          if (localBitmap == null) {
            p.hyc();
          }
          if (localBitmap.getWidth() == paramInt1)
          {
            localBitmap = parama.zPl;
            if (localBitmap == null) {
              p.hyc();
            }
            if (localBitmap.getHeight() == paramInt2) {
              continue;
            }
          }
        }
        parama.zPl = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        parama = parama.zPl;
        if (parama != null)
        {
          try
          {
            parama.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
            AppMethodBeat.o(239695);
          }
          catch (Exception paramArrayOfInt)
          {
            paramArrayOfInt = new StringBuilder("error happened in set pixel while w is ").append(paramInt1).append(" and h is ").append(paramInt2).append(" and bitmap bound is ");
            paramInt1 = parama.getWidth();
            Log.e("VideoDisplayDataMuxer", parama.getHeight() * paramInt1);
            AppMethodBeat.o(239695);
            continue;
          }
          return;
        }
      }
      finally {}
      AppMethodBeat.o(239695);
    }
  }
  
  public static void a(final f paramf)
  {
    AppMethodBeat.i(239696);
    p.h(paramf, "target");
    ImageView localImageView = paramf.getAvatarIv();
    if (localImageView != null)
    {
      h.RTc.aV((Runnable)new c(localImageView, paramf));
      AppMethodBeat.o(239696);
      return;
    }
    AppMethodBeat.o(239696);
  }
  
  private final boolean aGn(String paramString)
  {
    AppMethodBeat.i(239698);
    if ((this.zPb == 1) && (p.j(paramString, this.zPc)))
    {
      AppMethodBeat.o(239698);
      return true;
    }
    AppMethodBeat.o(239698);
    return false;
  }
  
  private final boolean aGo(String paramString)
  {
    AppMethodBeat.i(239699);
    if ((this.zPb == 2) && (p.j(paramString, this.zPc)))
    {
      AppMethodBeat.o(239699);
      return true;
    }
    AppMethodBeat.o(239699);
    return false;
  }
  
  private final ArrayList<f> aGp(String paramString)
  {
    AppMethodBeat.i(239701);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.zPa;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (g)((Iterator)localObject1).next();
        if (aGn(paramString))
        {
          localObject2 = ((g)localObject2).Rc(0);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
        else
        {
          localObject2 = ((g)localObject2).aFB(paramString);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(239701);
    return localArrayList;
  }
  
  private final ae.a b(f paramf)
  {
    AppMethodBeat.i(239700);
    if (aGn(paramf.getUsername()))
    {
      paramf = this.zPd;
      AppMethodBeat.o(239700);
      return paramf;
    }
    if (this.zPe.get(paramf.getUsername()) == null)
    {
      ae.a locala = new ae.a(paramf.getUsername(), (byte)0);
      ((Map)this.zPe).put(paramf.getUsername(), locala);
      AppMethodBeat.o(239700);
      return locala;
    }
    paramf = (ae.a)this.zPe.get(paramf.getUsername());
    AppMethodBeat.o(239700);
    return paramf;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(239689);
    p.h(paramg, "targetContainer");
    ArrayList localArrayList = this.zPa;
    if ((localArrayList != null) && (localArrayList.contains(paramg) == true))
    {
      AppMethodBeat.o(239689);
      return;
    }
    if (this.zPa == null) {
      this.zPa = new ArrayList();
    }
    localArrayList = this.zPa;
    if (localArrayList != null)
    {
      localArrayList.add(paramg);
      AppMethodBeat.o(239689);
      return;
    }
    AppMethodBeat.o(239689);
  }
  
  public final void a(final String paramString, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(239693);
    p.h(paramString, "userName");
    p.h(paramArrayOfByte, "pBuffer");
    Object localObject1 = Boolean.valueOf(aGo(paramString));
    if (((Boolean)localObject1).booleanValue()) {}
    while (localObject1 != null)
    {
      ((Boolean)localObject1).booleanValue();
      localObject1 = this.zPa;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (g)((Iterator)localObject1).next();
            if (((g)localObject2).Rc(0) != null)
            {
              this.zPi = paramInt2;
              this.zPj = paramString;
              if ((this.zPg == null) || (this.zPf == null))
              {
                aa localaa = new aa();
                localaa.eog();
                localaa.c((kotlin.g.a.q)new e((g)localObject2, this, paramInt2, paramString, paramArrayOfByte, paramInt1));
                localaa.U((a)new f(localaa, (g)localObject2, this, paramInt2, paramString, paramArrayOfByte, paramInt1));
                this.zPf = localaa;
                this.zPh = false;
              }
              long l = Util.currentTicks();
              localObject2 = this.zPg;
              if (localObject2 != null) {
                ((j)localObject2).f(paramArrayOfByte, paramInt1, this.zPh);
              }
              localObject2 = com.tencent.mm.plugin.multitalk.d.d.zZa;
              com.tencent.mm.plugin.multitalk.d.d.append(2, Util.ticksToNow(l));
              continue;
              localObject1 = null;
              break;
            }
          }
        }
        AppMethodBeat.o(239693);
        return;
      }
      AppMethodBeat.o(239693);
      return;
    }
    AppMethodBeat.o(239693);
  }
  
  public final void a(final String paramString, final int[] paramArrayOfInt, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(239692);
    p.h(paramString, "userName");
    p.h(paramArrayOfInt, "pBuffer");
    this.zPh = true;
    Object localObject1 = Boolean.valueOf(aGo(paramString));
    int i;
    if ((((Boolean)localObject1).booleanValue()) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      i = 1;
      if (i == 0) {
        break label215;
      }
    }
    for (;;)
    {
      label60:
      if (localObject1 != null)
      {
        ((Boolean)localObject1).booleanValue();
        localObject1 = this.zPa;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              final g localg = (g)((Iterator)localObject1).next();
              final f localf = localg.Rc(paramInt3);
              if (localf != null)
              {
                this.zPi = paramInt3;
                Object localObject2 = this.zPd;
                a((ae.a)localObject2, paramArrayOfInt, paramInt1, paramInt2);
                ((ae.a)localObject2).mirror = 0;
                ((ae.a)localObject2).angle = paramInt3;
                localObject2 = ((ae.a)localObject2).zPl;
                if (localObject2 != null)
                {
                  com.tencent.mm.ac.d.h((a)new d((Bitmap)localObject2, localf, localg, this, paramInt3, paramArrayOfInt, paramInt1, paramInt2, paramString));
                  continue;
                  i = 0;
                  break;
                  label215:
                  localObject1 = null;
                  break label60;
                }
              }
            }
          }
          AppMethodBeat.o(239692);
          return;
        }
        AppMethodBeat.o(239692);
        return;
      }
    }
    AppMethodBeat.o(239692);
  }
  
  public final void a(final String paramString, final int[] paramArrayOfInt, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(239691);
    p.h(paramString, "userName");
    p.h(paramArrayOfInt, "pBuffer");
    final ArrayList localArrayList = aGp(paramString);
    int i;
    if (!((Collection)localArrayList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label156;
      }
    }
    for (;;)
    {
      if (localArrayList != null)
      {
        Object localObject = b((f)kotlin.a.j.ks((List)localArrayList));
        if (localObject != null)
        {
          a((ae.a)localObject, paramArrayOfInt, paramInt1, paramInt2);
          ((ae.a)localObject).mirror = paramInt3;
          ((ae.a)localObject).angle = paramInt4;
          if (localObject != null)
          {
            localObject = ((ae.a)localObject).zPl;
            if (localObject != null)
            {
              com.tencent.mm.ac.d.h((a)new g((Bitmap)localObject, localArrayList, this, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramString));
              AppMethodBeat.o(239691);
              return;
              i = 0;
              break;
              label156:
              localArrayList = null;
              continue;
            }
          }
        }
        AppMethodBeat.o(239691);
        return;
      }
    }
    AppMethodBeat.o(239691);
  }
  
  public final void aa(boolean paramBoolean)
  {
    AppMethodBeat.i(239697);
    ArrayList localArrayList = this.zPa;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.zPa = null;
    a(this);
    if (!paramBoolean) {
      this.zPe.clear();
    }
    this.zPd.zPl = null;
    eos();
    AppMethodBeat.o(239697);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(239690);
    p.h(paramg, "targetContainer");
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.zPa;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        g localg = (g)((Iterator)localObject).next();
        if ((p.j(localg, paramg) ^ true)) {
          localArrayList.add(localg);
        }
      }
    }
    this.zPa = localArrayList;
    AppMethodBeat.o(239690);
  }
  
  public final void bJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(239687);
    p.h(paramString, "largeHostName");
    Log.printInfoStack("VideoDisplayDataMuxer", "setLargeTargetState ".concat(String.valueOf(paramInt)), new Object[0]);
    this.zPb = paramInt;
    this.zPc = paramString;
    AppMethodBeat.o(239687);
  }
  
  public final void eor()
  {
    this.kyn = true;
  }
  
  public final void eos()
  {
    AppMethodBeat.i(239694);
    Object localObject = this.zPg;
    if (localObject != null)
    {
      ((j)localObject).emB();
      localObject = this.zPf;
      if (localObject != null)
      {
        ((aa)localObject).U((a)new aa.b((aa)localObject));
        localObject = ((aa)localObject).handlerThread;
        if (localObject != null) {
          ((HandlerThread)localObject).quitSafely();
        }
      }
      this.zPf = null;
    }
    this.zPg = null;
    AppMethodBeat.o(239694);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$drawAvatar$1$1"})
  static final class c
    implements Runnable
  {
    c(ImageView paramImageView, f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(239681);
      a.b.y(this.zPm, paramf.getUsername());
      paramf.emz();
      AppMethodBeat.o(239681);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenDataArrive$2$1$1$2$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$3", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$forEach$lambda$1"})
  static final class d
    extends kotlin.g.b.q
    implements a<x>
  {
    d(Bitmap paramBitmap, f paramf, g paramg, ae paramae, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenHwDataArrive$2$1$1$1$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$apply$lambda$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$4", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$forEach$lambda$2"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.q<ByteBuffer, Integer, Integer, x>
  {
    e(g paramg, ae paramae, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenHwDataArrive$2$1$1$1$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$apply$lambda$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$5", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$forEach$lambda$3"})
  static final class f
    extends kotlin.g.b.q
    implements a<x>
  {
    f(aa paramaa, g paramg, ae paramae, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onVideoDataArrive$2$2$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$1"})
  static final class g
    extends kotlin.g.b.q
    implements a<x>
  {
    g(Bitmap paramBitmap, ArrayList paramArrayList, ae paramae, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ae
 * JD-Core Version:    0.7.0.1
 */