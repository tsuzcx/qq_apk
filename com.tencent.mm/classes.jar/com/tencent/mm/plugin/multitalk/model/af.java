package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.HandlerThread;
import android.widget.ImageView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataHandler;", "()V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcDecoder;", "bReStart", "", "bitmapHolders", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$BitmapHolder;", "canDraw", "curAngle", "", "curUserName", "defaultAvatar", "Landroid/graphics/Bitmap;", "largeTargetBitmapHolder", "largeTargetHostName", "largeTargetState", "screenCastHWRenderHelper", "Lcom/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper;", "targetContainers", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "Lkotlin/collections/ArrayList;", "close", "", "isMini", "closeAvCodec", "disableDrawing", "drawAvatar", "target", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "drawVideo", "userName", "enableDrawing", "getBitmapHolder", "renderTarget", "getDefaultAvatar", "getVideoRenderTarget", "hasTargetContainer", "container", "loadAvatarBitmap", "width", "height", "onScreenDataArrive", "pBuffer", "", "w", "h", "mirror", "angle", "onScreenHwDataArrive", "", "onVideoDataArrive", "refreshBitmap", "bmHolder", "Ljava/nio/ByteBuffer;", "registerTargetContainer", "targetContainer", "screenDrawAtLargeTarget", "setLargeTargetState", "state", "largeHostName", "unRegisterTargetContainer", "videoDrawAtLargeTarget", "BitmapHolder", "Companion", "plugin-multitalk_release"})
public final class af
  implements ae
{
  public static final af.b FuJ;
  private volatile int FuA;
  private String FuB;
  private final af.a FuC;
  private final ConcurrentHashMap<String, af.a> FuD;
  private aa FuE;
  private j FuF;
  private boolean FuG;
  private int FuH;
  private String FuI;
  ArrayList<g> Fuz;
  private volatile boolean nrn;
  
  static
  {
    AppMethodBeat.i(199315);
    FuJ = new af.b((byte)0);
    AppMethodBeat.o(199315);
  }
  
  public af()
  {
    AppMethodBeat.i(199314);
    this.nrn = true;
    this.FuB = "";
    this.FuC = new af.a("", (byte)0);
    this.FuD = new ConcurrentHashMap();
    this.FuG = true;
    this.FuI = "";
    AppMethodBeat.o(199314);
  }
  
  private final void a(af.a parama, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(199304);
        if (parama.FuK != null)
        {
          Bitmap localBitmap = parama.FuK;
          if (localBitmap == null) {
            p.iCn();
          }
          if (localBitmap.getWidth() == paramInt1)
          {
            localBitmap = parama.FuK;
            if (localBitmap == null) {
              p.iCn();
            }
            if (localBitmap.getHeight() == paramInt2) {
              continue;
            }
          }
        }
        parama.FuK = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        parama = parama.FuK;
        if (parama != null)
        {
          try
          {
            parama.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
            AppMethodBeat.o(199304);
          }
          catch (Exception paramArrayOfInt)
          {
            paramArrayOfInt = new StringBuilder("error happened in set pixel while w is ").append(paramInt1).append(" and h is ").append(paramInt2).append(" and bitmap bound is ");
            paramInt1 = parama.getWidth();
            Log.e("VideoDisplayDataMuxer", parama.getHeight() * paramInt1);
            AppMethodBeat.o(199304);
            continue;
          }
          return;
        }
      }
      finally {}
      AppMethodBeat.o(199304);
    }
  }
  
  public static void a(final f paramf)
  {
    AppMethodBeat.i(199305);
    p.k(paramf, "target");
    ImageView localImageView = paramf.getAvatarIv();
    if (localImageView != null)
    {
      h.ZvG.bc((Runnable)new c(localImageView, paramf));
      AppMethodBeat.o(199305);
      return;
    }
    AppMethodBeat.o(199305);
  }
  
  private final boolean aQB(String paramString)
  {
    AppMethodBeat.i(199308);
    if ((this.FuA == 1) && (p.h(paramString, this.FuB)))
    {
      AppMethodBeat.o(199308);
      return true;
    }
    AppMethodBeat.o(199308);
    return false;
  }
  
  private final boolean aQC(String paramString)
  {
    AppMethodBeat.i(199309);
    if ((this.FuA == 2) && (p.h(paramString, this.FuB)))
    {
      AppMethodBeat.o(199309);
      return true;
    }
    AppMethodBeat.o(199309);
    return false;
  }
  
  private final ArrayList<f> aQD(String paramString)
  {
    AppMethodBeat.i(199313);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.Fuz;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (g)((Iterator)localObject1).next();
        if (aQB(paramString))
        {
          localObject2 = ((g)localObject2).Xq(0);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
        else
        {
          localObject2 = ((g)localObject2).aPM(paramString);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(199313);
    return localArrayList;
  }
  
  private final af.a b(f paramf)
  {
    AppMethodBeat.i(199312);
    if (aQB(paramf.getUsername()))
    {
      paramf = this.FuC;
      AppMethodBeat.o(199312);
      return paramf;
    }
    if (this.FuD.get(paramf.getUsername()) == null)
    {
      af.a locala = new af.a(paramf.getUsername(), (byte)0);
      ((Map)this.FuD).put(paramf.getUsername(), locala);
      AppMethodBeat.o(199312);
      return locala;
    }
    paramf = (af.a)this.FuD.get(paramf.getUsername());
    AppMethodBeat.o(199312);
    return paramf;
  }
  
  public final void G(boolean paramBoolean)
  {
    AppMethodBeat.i(199307);
    ArrayList localArrayList = this.Fuz;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.Fuz = null;
    a(this);
    if (!paramBoolean) {
      this.FuD.clear();
    }
    this.FuC.FuK = null;
    eYi();
    AppMethodBeat.o(199307);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(199288);
    p.k(paramg, "targetContainer");
    ArrayList localArrayList = this.Fuz;
    if ((localArrayList != null) && (localArrayList.contains(paramg) == true))
    {
      AppMethodBeat.o(199288);
      return;
    }
    if (this.Fuz == null) {
      this.Fuz = new ArrayList();
    }
    localArrayList = this.Fuz;
    if (localArrayList != null)
    {
      localArrayList.add(paramg);
      AppMethodBeat.o(199288);
      return;
    }
    AppMethodBeat.o(199288);
  }
  
  public final void a(final String paramString, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(199300);
    p.k(paramString, "userName");
    p.k(paramArrayOfByte, "pBuffer");
    Object localObject1 = Boolean.valueOf(aQC(paramString));
    if (((Boolean)localObject1).booleanValue()) {}
    while (localObject1 != null)
    {
      ((Boolean)localObject1).booleanValue();
      localObject1 = this.Fuz;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (g)((Iterator)localObject1).next();
            if (((g)localObject2).Xq(0) != null)
            {
              this.FuH = paramInt2;
              this.FuI = paramString;
              if ((this.FuF == null) || (this.FuE == null))
              {
                aa localaa = new aa();
                localaa.eXW();
                localaa.c((kotlin.g.a.q)new e((g)localObject2, this, paramInt2, paramString, paramArrayOfByte, paramInt1));
                localaa.X((a)new f(localaa, (g)localObject2, this, paramInt2, paramString, paramArrayOfByte, paramInt1));
                this.FuE = localaa;
                this.FuG = false;
              }
              long l = Util.currentTicks();
              localObject2 = this.FuF;
              if (localObject2 != null) {
                ((j)localObject2).f(paramArrayOfByte, paramInt1, this.FuG);
              }
              localObject2 = com.tencent.mm.plugin.multitalk.d.d.FEN;
              com.tencent.mm.plugin.multitalk.d.d.aC(2, Util.ticksToNow(l));
              continue;
              localObject1 = null;
              break;
            }
          }
        }
        AppMethodBeat.o(199300);
        return;
      }
      AppMethodBeat.o(199300);
      return;
    }
    AppMethodBeat.o(199300);
  }
  
  public final void a(final String paramString, final int[] paramArrayOfInt, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(199297);
    p.k(paramString, "userName");
    p.k(paramArrayOfInt, "pBuffer");
    this.FuG = true;
    Object localObject1 = Boolean.valueOf(aQC(paramString));
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
        localObject1 = this.Fuz;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              final g localg = (g)((Iterator)localObject1).next();
              final f localf = localg.Xq(paramInt3);
              if (localf != null)
              {
                this.FuH = paramInt3;
                Object localObject2 = this.FuC;
                a((af.a)localObject2, paramArrayOfInt, paramInt1, paramInt2);
                ((af.a)localObject2).mirror = 0;
                ((af.a)localObject2).Frq = paramInt3;
                localObject2 = ((af.a)localObject2).FuK;
                if (localObject2 != null)
                {
                  com.tencent.mm.ae.d.uiThread((a)new d((Bitmap)localObject2, localf, localg, this, paramInt3, paramArrayOfInt, paramInt1, paramInt2, paramString));
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
          AppMethodBeat.o(199297);
          return;
        }
        AppMethodBeat.o(199297);
        return;
      }
    }
    AppMethodBeat.o(199297);
  }
  
  public final void a(final String paramString, final int[] paramArrayOfInt, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(199292);
    p.k(paramString, "userName");
    p.k(paramArrayOfInt, "pBuffer");
    final ArrayList localArrayList = aQD(paramString);
    int i;
    if (!((Collection)localArrayList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label173;
      }
    }
    label173:
    for (;;)
    {
      label48:
      if (localArrayList != null)
      {
        Iterator localIterator = ((Iterable)localArrayList).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject = b((f)localIterator.next());
            if (localObject != null)
            {
              a((af.a)localObject, paramArrayOfInt, paramInt1, paramInt2);
              ((af.a)localObject).mirror = paramInt3;
              ((af.a)localObject).Frq = paramInt4;
              if (localObject != null)
              {
                localObject = ((af.a)localObject).FuK;
                if (localObject != null)
                {
                  com.tencent.mm.ae.d.uiThread((a)new g((Bitmap)localObject, localArrayList, this, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramString));
                  continue;
                  i = 0;
                  break;
                  localArrayList = null;
                  break label48;
                }
              }
            }
          }
        }
        AppMethodBeat.o(199292);
        return;
      }
    }
    AppMethodBeat.o(199292);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(199290);
    p.k(paramg, "targetContainer");
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.Fuz;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        g localg = (g)((Iterator)localObject).next();
        if ((p.h(localg, paramg) ^ true)) {
          localArrayList.add(localg);
        }
      }
    }
    this.Fuz = localArrayList;
    AppMethodBeat.o(199290);
  }
  
  public final void bH(int paramInt, String paramString)
  {
    AppMethodBeat.i(199286);
    p.k(paramString, "largeHostName");
    Log.printInfoStack("VideoDisplayDataMuxer", "setLargeTargetState ".concat(String.valueOf(paramInt)), new Object[0]);
    this.FuA = paramInt;
    this.FuB = paramString;
    AppMethodBeat.o(199286);
  }
  
  public final void eYh()
  {
    this.nrn = true;
  }
  
  public final void eYi()
  {
    AppMethodBeat.i(199303);
    Object localObject = this.FuF;
    if (localObject != null)
    {
      ((j)localObject).eWp();
      localObject = this.FuE;
      if (localObject != null)
      {
        ((aa)localObject).X((a)new aa.b((aa)localObject));
        localObject = ((aa)localObject).handlerThread;
        if (localObject != null) {
          ((HandlerThread)localObject).quitSafely();
        }
      }
      this.FuE = null;
    }
    this.FuF = null;
    AppMethodBeat.o(199303);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$drawAvatar$1$1"})
  static final class c
    implements Runnable
  {
    c(ImageView paramImageView, f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(203614);
      a.b.A(this.FuL, paramf.getUsername());
      paramf.eWn();
      AppMethodBeat.o(203614);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenDataArrive$2$1$1$2$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$3", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$forEach$lambda$2"})
  static final class d
    extends kotlin.g.b.q
    implements a<x>
  {
    d(Bitmap paramBitmap, f paramf, g paramg, af paramaf, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenHwDataArrive$2$1$1$1$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$apply$lambda$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$4", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$forEach$lambda$3"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.q<ByteBuffer, Integer, Integer, x>
  {
    e(g paramg, af paramaf, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onScreenHwDataArrive$2$1$1$1$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$apply$lambda$2", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$5", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$forEach$lambda$4"})
  static final class f
    extends kotlin.g.b.q
    implements a<x>
  {
    f(aa paramaa, g paramg, af paramaf, int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$onVideoDataArrive$2$1$2$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$$special$$inlined$forEach$lambda$1"})
  static final class g
    extends kotlin.g.b.q
    implements a<x>
  {
    g(Bitmap paramBitmap, ArrayList paramArrayList, af paramaf, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.af
 * JD-Core Version:    0.7.0.1
 */