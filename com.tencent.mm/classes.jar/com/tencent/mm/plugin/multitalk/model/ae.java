package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.multitalk.e.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataHandler;", "()V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcDecoder;", "bReStart", "", "bitmapHolders", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataMuxer$BitmapHolder;", "canDraw", "curAngle", "", "curUserName", "defaultAvatar", "Landroid/graphics/Bitmap;", "largeTargetBitmapHolder", "largeTargetHostName", "largeTargetState", "screenCastHWRenderHelper", "Lcom/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper;", "targetContainers", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "Lkotlin/collections/ArrayList;", "close", "", "isMini", "closeAvCodec", "disableDrawing", "drawAvatar", "target", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "drawVideo", "userName", "enableDrawing", "getBitmapHolder", "renderTarget", "getDefaultAvatar", "getVideoRenderTarget", "hasTargetContainer", "container", "loadAvatarBitmap", "width", "height", "onScreenDataArrive", "pBuffer", "", "w", "h", "mirror", "angle", "onScreenHwDataArrive", "", "onVideoDataArrive", "refreshBitmap", "bmHolder", "Ljava/nio/ByteBuffer;", "registerTargetContainer", "targetContainer", "screenDrawAtLargeTarget", "setLargeTargetState", "state", "largeHostName", "unRegisterTargetContainer", "videoDrawAtLargeTarget", "BitmapHolder", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  implements ad
{
  public static final ae.b LqR;
  ArrayList<g> LqS;
  private volatile int LqT;
  private String LqU;
  private final ae.a LqV;
  private final ConcurrentHashMap<String, ae.a> LqW;
  private z LqX;
  private j LqY;
  private boolean LqZ;
  private int Lra;
  private String Lrb;
  private volatile boolean qpU;
  
  static
  {
    AppMethodBeat.i(284893);
    LqR = new ae.b((byte)0);
    AppMethodBeat.o(284893);
  }
  
  public ae()
  {
    AppMethodBeat.i(284818);
    this.qpU = true;
    this.LqU = "";
    this.LqV = new ae.a("", (byte)0);
    this.LqW = new ConcurrentHashMap();
    this.LqZ = true;
    this.Lrb = "";
    AppMethodBeat.o(284818);
  }
  
  private static final void a(ImageView paramImageView, f paramf)
  {
    AppMethodBeat.i(284867);
    s.u(paramImageView, "$it");
    s.u(paramf, "$target");
    a.b.A(paramImageView, paramf.getUsername());
    paramf.gfe();
    AppMethodBeat.o(284867);
  }
  
  /* Error */
  private final void a(ae.a parama, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 232
    //   4: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: getfield 199	com/tencent/mm/plugin/multitalk/model/ae$a:Lrc	Landroid/graphics/Bitmap;
    //   11: ifnull +44 -> 55
    //   14: aload_1
    //   15: getfield 199	com/tencent/mm/plugin/multitalk/model/ae$a:Lrc	Landroid/graphics/Bitmap;
    //   18: astore 5
    //   20: aload 5
    //   22: invokestatic 203	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   25: aload 5
    //   27: invokevirtual 209	android/graphics/Bitmap:getWidth	()I
    //   30: iload_3
    //   31: if_icmpne +24 -> 55
    //   34: aload_1
    //   35: getfield 199	com/tencent/mm/plugin/multitalk/model/ae$a:Lrc	Landroid/graphics/Bitmap;
    //   38: astore 5
    //   40: aload 5
    //   42: invokestatic 203	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   45: aload 5
    //   47: invokevirtual 212	android/graphics/Bitmap:getHeight	()I
    //   50: iload 4
    //   52: if_icmpeq +16 -> 68
    //   55: aload_1
    //   56: iload_3
    //   57: iload 4
    //   59: getstatic 218	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   62: invokestatic 222	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   65: putfield 199	com/tencent/mm/plugin/multitalk/model/ae$a:Lrc	Landroid/graphics/Bitmap;
    //   68: aload_1
    //   69: getfield 199	com/tencent/mm/plugin/multitalk/model/ae$a:Lrc	Landroid/graphics/Bitmap;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +77 -> 151
    //   77: aload_1
    //   78: aload_2
    //   79: iconst_0
    //   80: iload_3
    //   81: iconst_0
    //   82: iconst_0
    //   83: iload_3
    //   84: iload 4
    //   86: invokevirtual 236	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   89: ldc 232
    //   91: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: monitorexit
    //   96: return
    //   97: astore_2
    //   98: new 238	java/lang/StringBuilder
    //   101: dup
    //   102: ldc 240
    //   104: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: iload_3
    //   108: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc 249
    //   113: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload 4
    //   118: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc 254
    //   123: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: astore_2
    //   127: aload_1
    //   128: invokevirtual 209	android/graphics/Bitmap:getWidth	()I
    //   131: istore_3
    //   132: ldc_w 256
    //   135: aload_2
    //   136: aload_1
    //   137: invokevirtual 212	android/graphics/Bitmap:getHeight	()I
    //   140: iload_3
    //   141: imul
    //   142: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc 232
    //   153: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: goto -62 -> 94
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	ae
    //   0	164	1	parama	ae.a
    //   0	164	2	paramArrayOfInt	int[]
    //   0	164	3	paramInt1	int
    //   0	164	4	paramInt2	int
    //   18	28	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   77	89	97	java/lang/Exception
    //   2	55	159	finally
    //   55	68	159	finally
    //   68	73	159	finally
    //   77	89	159	finally
    //   89	94	159	finally
    //   98	151	159	finally
    //   151	156	159	finally
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(284836);
    s.u(paramf, "target");
    ImageView localImageView = paramf.getAvatarIv();
    if (localImageView != null) {
      h.ahAA.bk(new ae..ExternalSyntheticLambda0(localImageView, paramf));
    }
    AppMethodBeat.o(284836);
  }
  
  private final boolean aNu(String paramString)
  {
    AppMethodBeat.i(284841);
    if ((this.LqT == 1) && (s.p(paramString, this.LqU)))
    {
      AppMethodBeat.o(284841);
      return true;
    }
    AppMethodBeat.o(284841);
    return false;
  }
  
  private final boolean aNv(String paramString)
  {
    AppMethodBeat.i(284845);
    if ((this.LqT == 2) && (s.p(paramString, this.LqU)))
    {
      AppMethodBeat.o(284845);
      return true;
    }
    AppMethodBeat.o(284845);
    return false;
  }
  
  private final ArrayList<f> aNw(String paramString)
  {
    AppMethodBeat.i(284863);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.LqS;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (g)((Iterator)localObject1).next();
        if (aNu(paramString))
        {
          localObject2 = ((g)localObject2).abB(0);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
        else
        {
          localObject2 = ((g)localObject2).aMH(paramString);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(284863);
    return localArrayList;
  }
  
  private final ae.a b(f paramf)
  {
    AppMethodBeat.i(284852);
    if (aNu(paramf.getUsername()))
    {
      paramf = this.LqV;
      AppMethodBeat.o(284852);
      return paramf;
    }
    if (this.LqW.get(paramf.getUsername()) == null)
    {
      ae.a locala = new ae.a(paramf.getUsername(), (byte)0);
      ((Map)this.LqW).put(paramf.getUsername(), locala);
      AppMethodBeat.o(284852);
      return locala;
    }
    paramf = (ae.a)this.LqW.get(paramf.getUsername());
    AppMethodBeat.o(284852);
    return paramf;
  }
  
  public final void K(boolean paramBoolean)
  {
    AppMethodBeat.i(284949);
    ArrayList localArrayList = this.LqS;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.LqS = null;
    a(this);
    if (!paramBoolean) {
      this.LqW.clear();
    }
    this.LqV.Lrc = null;
    ggY();
    AppMethodBeat.o(284949);
  }
  
  public final void a(g paramg)
  {
    int i = 1;
    AppMethodBeat.i(284908);
    s.u(paramg, "targetContainer");
    ArrayList localArrayList = this.LqS;
    if ((localArrayList != null) && (localArrayList.contains(paramg) == true)) {}
    while (i != 0)
    {
      AppMethodBeat.o(284908);
      return;
      i = 0;
    }
    if (this.LqS == null) {
      this.LqS = new ArrayList();
    }
    localArrayList = this.LqS;
    if (localArrayList != null) {
      localArrayList.add(paramg);
    }
    AppMethodBeat.o(284908);
  }
  
  public final void a(final String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284940);
    s.u(paramString, "userName");
    s.u(paramArrayOfByte, "pBuffer");
    Object localObject1 = Boolean.valueOf(aNv(paramString));
    if (((Boolean)localObject1).booleanValue()) {}
    while (localObject1 != null)
    {
      ((Boolean)localObject1).booleanValue();
      localObject1 = this.LqS;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (g)((Iterator)localObject1).next();
        if (((g)localObject3).abB(0) != null)
        {
          this.Lra = paramInt2;
          this.Lrb = paramString;
          if ((this.LqY == null) || (this.LqX == null))
          {
            localObject2 = new z();
            ((z)localObject2).ggL();
            ((z)localObject2).i((q)new d(this, (g)localObject3, paramString));
            ((z)localObject2).bI((a)new e(this, (z)localObject2));
            localObject3 = ah.aiuX;
            this.LqX = ((z)localObject2);
            this.LqZ = false;
          }
          long l = Util.currentTicks();
          Object localObject2 = this.LqY;
          if (localObject2 != null) {
            ((j)localObject2).f(paramArrayOfByte, paramInt1, this.LqZ);
          }
          localObject2 = e.LAH;
          e.aJ(2, Util.ticksToNow(l));
        }
      }
      localObject1 = null;
    }
    AppMethodBeat.o(284940);
  }
  
  public final void a(final String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(284931);
    s.u(paramString, "userName");
    s.u(paramArrayOfInt, "pBuffer");
    this.LqZ = true;
    Object localObject1 = Boolean.valueOf(aNv(paramString));
    if ((((Boolean)localObject1).booleanValue()) && (paramInt1 > 0) && (paramInt2 > 0)) {
      if (i == 0) {
        break label209;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label215;
      }
      ((Boolean)localObject1).booleanValue();
      localObject1 = this.LqS;
      if (localObject1 == null) {
        break label215;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        final g localg = (g)((Iterator)localObject1).next();
        final f localf = localg.abB(paramInt3);
        if (localf != null)
        {
          this.Lra = paramInt3;
          Object localObject2 = this.LqV;
          a((ae.a)localObject2, paramArrayOfInt, paramInt1, paramInt2);
          ((ae.a)localObject2).mirror = 0;
          ((ae.a)localObject2).LnD = paramInt3;
          localObject2 = ((ae.a)localObject2).Lrc;
          if (localObject2 != null) {
            d.uiThread((a)new c(this, localg, localf, paramString, (Bitmap)localObject2));
          }
        }
      }
      i = 0;
      break;
      label209:
      localObject1 = null;
    }
    label215:
    AppMethodBeat.o(284931);
  }
  
  public final void a(final String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(284923);
    s.u(paramString, "userName");
    s.u(paramArrayOfInt, "pBuffer");
    final ArrayList localArrayList = aNw(paramString);
    int i;
    if (!((Collection)localArrayList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label164;
      }
    }
    for (;;)
    {
      if (localArrayList == null) {
        break label170;
      }
      Iterator localIterator = ((Iterable)localArrayList).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = b((f)localIterator.next());
        if (localObject != null)
        {
          a((ae.a)localObject, paramArrayOfInt, paramInt1, paramInt2);
          ((ae.a)localObject).mirror = paramInt3;
          ((ae.a)localObject).LnD = paramInt4;
          localObject = ((ae.a)localObject).Lrc;
          if (localObject != null) {
            d.uiThread((a)new f(this, localArrayList, paramString, (Bitmap)localObject, paramInt4, paramInt3));
          }
        }
      }
      i = 0;
      break;
      label164:
      localArrayList = null;
    }
    label170:
    AppMethodBeat.o(284923);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(284914);
    s.u(paramg, "targetContainer");
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.LqS;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        g localg = (g)((Iterator)localObject).next();
        if (!s.p(localg, paramg)) {
          localArrayList.add(localg);
        }
      }
    }
    this.LqS = localArrayList;
    AppMethodBeat.o(284914);
  }
  
  public final void cp(int paramInt, String paramString)
  {
    AppMethodBeat.i(284903);
    s.u(paramString, "largeHostName");
    Log.printInfoStack("VideoDisplayDataMuxer", s.X("setLargeTargetState ", Integer.valueOf(paramInt)), new Object[0]);
    this.LqT = paramInt;
    this.LqU = paramString;
    AppMethodBeat.o(284903);
  }
  
  public final void ggX()
  {
    this.qpU = true;
  }
  
  public final void ggY()
  {
    AppMethodBeat.i(284943);
    Object localObject = this.LqY;
    if (localObject != null)
    {
      ((j)localObject).gfg();
      localObject = this.LqX;
      if (localObject != null) {
        ((z)localObject).release();
      }
      this.LqX = null;
    }
    this.LqY = null;
    AppMethodBeat.o(284943);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(ae paramae, g paramg, f paramf, String paramString, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements q<ByteBuffer, Integer, Integer, ah>
  {
    d(ae paramae, g paramg, String paramString)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(ae paramae, g paramg, f paramf, String paramString, Bitmap paramBitmap, int paramInt)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(ae paramae, z paramz)
    {
      super();
    }
    
    private static final void a(z paramz, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(284935);
      s.u(paramz, "$this_apply");
      paramz.width = paramInt1;
      paramz.height = paramInt2;
      AppMethodBeat.o(284935);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<ah>
  {
    f(ae paramae, ArrayList<f> paramArrayList, String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ae
 * JD-Core Version:    0.7.0.1
 */