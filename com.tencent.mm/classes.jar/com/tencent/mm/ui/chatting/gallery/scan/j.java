package com.tencent.mm.ui.chatting.gallery.scan;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager;", "", "()V", "mPreviewImageCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "previewCallbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/GallerySearchImagePreviewResultCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "previewFilter", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "previewRequestMap", "", "Lcom/tencent/mm/ui/chatting/gallery/scan/GalleryScanOpImageRequestWrapper;", "cancelPreviewImage", "", "session", "doPreviewImage", "requestWrapper", "callback", "getImagePHashByMsgId", "msgId", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "getImagePath", "getRequestKey", "onPreviewCallbackWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "previewImage", "release", "canPreview", "", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "valid", "Companion", "ImagePHashInfoWrapper", "ImagePreviewFilter", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j.a aeHd;
  private static final HashMap<String, dbj> aeHi;
  private static final ConcurrentHashMap<Long, b> aeHj;
  private c aeHe;
  public HashMap<String, ArrayList<c>> aeHf;
  public HashMap<Long, a> aeHg;
  private g aeHh;
  
  static
  {
    AppMethodBeat.i(254894);
    aeHd = new j.a((byte)0);
    aeHi = new HashMap();
    aeHj = new ConcurrentHashMap();
    AppMethodBeat.o(254894);
  }
  
  public j()
  {
    AppMethodBeat.i(254817);
    this.aeHe = new c();
    this.aeHf = new HashMap();
    this.aeHg = new HashMap();
    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo ImageSearchPreviewManager init cache size: %d", new Object[] { Integer.valueOf(aeHi.size()) });
    this.aeHh = new j..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(254817);
  }
  
  private static String a(a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(254831);
    Object localObject3 = new StringBuilder();
    Object localObject1;
    if (parama == null)
    {
      localObject1 = null;
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(',');
      if (parama != null) {
        break label81;
      }
      parama = localObject2;
    }
    for (;;)
    {
      parama = parama;
      AppMethodBeat.o(254831);
      return parama;
      localObject1 = parama.OQI;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((e)localObject1).msgId);
      break;
      label81:
      localObject3 = parama.OQI;
      parama = localObject2;
      if (localObject3 != null) {
        parama = ((e)localObject3).imagePath;
      }
    }
  }
  
  private static final void a(j paramj, long paramLong, f paramf)
  {
    int j = 1;
    AppMethodBeat.i(254853);
    s.u(paramj, "this$0");
    s.u(paramf, "result");
    Log.v("MicroMsg.ImageSearchPreviewManager", "onPreviewCallbackWrapper session: %s", new Object[] { Long.valueOf(paramLong) });
    label84:
    Object localObject2;
    if (paramf.success)
    {
      localObject1 = (CharSequence)paramf.OMP;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label221;
        }
        i = 2;
        localObject2 = (a)paramj.aeHg.remove(Long.valueOf(paramLong));
        localObject1 = new b();
        ((b)localObject1).vCl = System.currentTimeMillis();
        ((b)localObject1).aeGq = paramf;
        if (localObject2 != null) {
          break label227;
        }
      }
    }
    label221:
    label227:
    for (long l = 0L;; l = ((a)localObject2).msgId)
    {
      ((b)localObject1).msgId = l;
      ((b)localObject1).resultCode = i;
      paramf = a((a)localObject2);
      paramf = (ArrayList)paramj.aeHf.remove(paramf);
      if (paramf == null) {
        break label237;
      }
      paramf = ((Iterable)paramf).iterator();
      while (paramf.hasNext())
      {
        c localc = (c)paramf.next();
        if (localc != null) {
          localc.onCallback(paramLong, localObject1);
        }
      }
      i = 0;
      break;
      i = 1;
      break label84;
    }
    label237:
    paramf = new dbj();
    paramf.timestamp = System.currentTimeMillis();
    paramf.result = i;
    Object localObject1 = paramj.aeHe;
    if (localObject2 == null)
    {
      paramj = null;
      s.u(paramf, "result");
      localObject2 = (CharSequence)paramj;
      i = j;
      if (localObject2 != null) {
        if (((CharSequence)localObject2).length() != 0) {
          break label390;
        }
      }
    }
    label390:
    for (int i = j;; i = 0)
    {
      if (i == 0)
      {
        ((Map)aeHi).put(paramj, paramf);
        ((MultiProcessMMKV)((c)localObject1).vKT.getSlotForWrite()).encode(paramj, paramf.toByteArray());
      }
      AppMethodBeat.o(254853);
      return;
      paramj = ((a)localObject2).OQI;
      if (paramj == null)
      {
        paramj = null;
        break;
      }
      paramj = paramj.OMJ;
      if (paramj == null)
      {
        paramj = null;
        break;
      }
      paramj = paramj.pHash;
      break;
    }
  }
  
  public static boolean a(dbj paramdbj)
  {
    AppMethodBeat.i(254836);
    s.u(paramdbj, "<this>");
    if ((paramdbj.timestamp > 0L) && (System.currentTimeMillis() - paramdbj.timestamp > 604800000L))
    {
      AppMethodBeat.o(254836);
      return true;
    }
    AppMethodBeat.o(254836);
    return false;
  }
  
  public static void b(long paramLong, kotlin.g.a.b<? super b, kotlin.ah> paramb)
  {
    AppMethodBeat.i(254826);
    com.tencent.threadpool.h.ahAA.j(new j..ExternalSyntheticLambda1(paramLong, paramb), "search_preview_compute_phash");
    AppMethodBeat.o(254826);
  }
  
  private static final void b(kotlin.g.a.b paramb, ah.f paramf)
  {
    AppMethodBeat.i(254859);
    s.u(paramb, "$callback");
    s.u(paramf, "$pHash");
    paramb.invoke(paramf.aqH);
    AppMethodBeat.o(254859);
  }
  
  public static boolean b(dbj paramdbj)
  {
    return (paramdbj != null) && (paramdbj.timestamp > 0L);
  }
  
  private static final void c(long paramLong, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(254872);
    s.u(paramb, "$callback");
    ah.f localf = new ah.f();
    localf.aqH = aeHj.get(Long.valueOf(paramLong));
    Object localObject1 = (b)localf.aqH;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.v("MicroMsg.ImageSearchPreviewManager", "alvinluo getImagePHashByMsgId msgId: %s, pHash: %s", new Object[] { Long.valueOf(paramLong), localObject1 });
      if (localf.aqH == null) {
        localf.aqH = new b();
      }
      if (((b)localf.aqH).OMJ != null)
      {
        localObject1 = ((b)localf.aqH).OMJ;
        s.checkNotNull(localObject1);
        localObject1 = (CharSequence)((ScanImagePHashInfo)localObject1).pHash;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label342;
        }
      }
    }
    label342:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        b localb = (b)localf.aqH;
        Object localObject2 = ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.c.class)).tM(paramLong);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localb.imagePath = ((String)localObject1);
        if (((b)localf.aqH).imagePath != null)
        {
          localObject1 = (b)localf.aqH;
          localObject2 = com.tencent.mm.plugin.scanner.model.ah.OSL;
          localObject2 = ((b)localf.aqH).imagePath;
          s.checkNotNull(localObject2);
          ((b)localObject1).OMJ = com.tencent.mm.plugin.scanner.model.ah.aUL((String)localObject2);
          ((Map)aeHj).put(Long.valueOf(paramLong), localf.aqH);
        }
      }
      com.tencent.threadpool.h.ahAA.bk(new j..ExternalSyntheticLambda2(paramb, localf));
      AppMethodBeat.o(254872);
      return;
      localObject1 = ((b)localObject1).OMJ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((ScanImagePHashInfo)localObject1).pHash;
      break;
    }
  }
  
  public static void tO(long paramLong)
  {
    AppMethodBeat.i(254820);
    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo cancelPreviewImage session: %d", new Object[] { Long.valueOf(paramLong) });
    ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.c.class)).tO(paramLong);
    AppMethodBeat.o(254820);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "", "()V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "getPHashInfo", "()Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "setPHashInfo", "(Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    ScanImagePHashInfo OMJ;
    String imagePath;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "", "()V", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "username", "", "kotlin.jvm.PlatformType", "filterPreview", "", "pHash", "filterPreviewByMMKV", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "filterPreviewByMemory", "getPreviewResult", "saveRequest", "", "timestamp", "", "saveRequestInMMKV", "requestTime", "saveRequestInMemory", "saveResult", "result", "FilterResult", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
  {
    private final String username;
    final MMKVSlotManager vKT;
    
    public c()
    {
      AppMethodBeat.i(254792);
      this.username = z.bAM();
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(s.X(this.username, "__image_gallery_search_preview_slot_mmkv_key__"));
      s.s(localMultiProcessMMKV, "getMMKV(\"${username}__im…preview_slot_mmkv_key__\")");
      this.vKT = new MMKVSlotManager(localMultiProcessMMKV, 604800L);
      AppMethodBeat.o(254792);
    }
    
    public static void cB(String paramString, long paramLong)
    {
      AppMethodBeat.i(254797);
      Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo saveRequestInMemory pHash: %s, requestTime: %d", new Object[] { paramString, Long.valueOf(paramLong) });
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(254797);
        return;
      }
      paramString = (dbj)j.jwH().get(paramString);
      if (paramString != null) {
        paramString.timestamp = paramLong;
      }
      AppMethodBeat.o(254797);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pHashInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements kotlin.g.a.b<j.b, kotlin.ah>
  {
    public d(c paramc, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pHashInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements kotlin.g.a.b<j.b, kotlin.ah>
  {
    public e(c paramc, long paramLong1, long paramLong2, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.scan.j
 * JD-Core Version:    0.7.0.1
 */