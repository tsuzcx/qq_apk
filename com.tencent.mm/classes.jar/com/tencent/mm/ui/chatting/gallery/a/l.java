package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager;", "", "()V", "mPreviewImageCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "previewCallbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/GallerySearchImagePreviewResultCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "previewFilter", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "previewRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/GalleryScanOpImageRequestWrapper;", "previewRequestSessionSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "cancelPreviewImage", "", "session", "doPreviewImage", "requestWrapper", "callback", "getImagePHashByMsgId", "msgId", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "getImagePath", "onPreviewCallbackWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "previewImage", "release", "canPreview", "", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "valid", "Companion", "ImagePHashInfoWrapper", "ImagePreviewFilter", "app_release"})
public final class l
{
  private static final HashMap<String, ccx> PCN;
  private static final ConcurrentHashMap<Long, b> PCO;
  public static final l.a PCP;
  private c PCI;
  public HashSet<Long> PCJ;
  public HashMap<Long, ArrayList<c>> PCK;
  public HashMap<Long, a> PCL;
  private com.tencent.mm.plugin.scanner.api.g PCM;
  
  static
  {
    AppMethodBeat.i(231289);
    PCP = new l.a((byte)0);
    PCN = new HashMap();
    PCO = new ConcurrentHashMap();
    AppMethodBeat.o(231289);
  }
  
  public l()
  {
    AppMethodBeat.i(231288);
    this.PCI = new c();
    this.PCJ = new HashSet();
    this.PCK = new HashMap();
    this.PCL = new HashMap();
    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo ImageSearchPreviewManager init cache size: %d", new Object[] { Integer.valueOf(PCN.size()) });
    this.PCM = ((com.tencent.mm.plugin.scanner.api.g)new f(this));
    AppMethodBeat.o(231288);
  }
  
  public static void Is(long paramLong)
  {
    AppMethodBeat.i(231285);
    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo cancelPreviewImage session: %d", new Object[] { Long.valueOf(paramLong) });
    ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).Is(paramLong);
    AppMethodBeat.o(231285);
  }
  
  public static void a(long paramLong, b<? super b, x> paramb)
  {
    AppMethodBeat.i(231286);
    h.RTc.e((Runnable)new d(paramLong, paramb), "search_preview_compute_phash");
    AppMethodBeat.o(231286);
  }
  
  public static boolean a(ccx paramccx)
  {
    AppMethodBeat.i(231287);
    p.h(paramccx, "$this$canPreview");
    if ((paramccx.timestamp > 0L) && (System.currentTimeMillis() - paramccx.timestamp > 604800000L))
    {
      AppMethodBeat.o(231287);
      return true;
    }
    AppMethodBeat.o(231287);
    return false;
  }
  
  public static boolean b(ccx paramccx)
  {
    return (paramccx != null) && (paramccx.timestamp > 0L);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "", "()V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "getPHashInfo", "()Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "setPHashInfo", "(Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "app_release"})
  static final class b
  {
    ScanImagePHashInfo CAW;
    String imagePath;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "", "()V", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "username", "", "kotlin.jvm.PlatformType", "filterPreview", "", "pHash", "filterPreviewByMMKV", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "filterPreviewByMemory", "getPreviewResult", "saveRequest", "", "timestamp", "", "saveRequestInMMKV", "requestTime", "saveRequestInMemory", "saveResult", "result", "FilterResult", "app_release"})
  static final class c
  {
    final MMKVSlotManager pvV;
    private final String username;
    
    public c()
    {
      AppMethodBeat.i(231278);
      this.username = z.aTY();
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(this.username + "__image_gallery_search_preview_slot_mmkv_key__");
      p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…preview_slot_mmkv_key__\")");
      this.pvV = new MMKVSlotManager(localMultiProcessMMKV, 604800L);
      AppMethodBeat.o(231278);
    }
    
    public static void ci(String paramString, long paramLong)
    {
      AppMethodBeat.i(231277);
      Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo saveRequestInMemory pHash: %s, requestTime: %d", new Object[] { paramString, Long.valueOf(paramLong) });
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(231277);
        return;
      }
      paramString = (ccx)l.gTA().get(paramString);
      if (paramString != null)
      {
        paramString.timestamp = paramLong;
        AppMethodBeat.o(231277);
        return;
      }
      AppMethodBeat.o(231277);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(long paramLong, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(231280);
      final z.f localf = new z.f();
      localf.SYG = ((l.b)l.gTB().get(Long.valueOf(this.pwg)));
      long l = this.pwg;
      Object localObject1 = (l.b)localf.SYG;
      if (localObject1 != null)
      {
        localObject1 = ((l.b)localObject1).CAW;
        if (localObject1 != null)
        {
          localObject1 = ((ScanImagePHashInfo)localObject1).pHash;
          Log.v("MicroMsg.ImageSearchPreviewManager", "alvinluo getImagePHashByMsgId msgId: %s, pHash: %s", new Object[] { Long.valueOf(l), localObject1 });
          if ((l.b)localf.SYG == null) {
            localf.SYG = new l.b();
          }
          if (((l.b)localf.SYG).CAW != null)
          {
            localObject1 = ((l.b)localf.SYG).CAW;
            if (localObject1 == null) {
              p.hyc();
            }
            localObject1 = (CharSequence)((ScanImagePHashInfo)localObject1).pHash;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label342;
            }
          }
        }
      }
      label342:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          l.b localb = (l.b)localf.SYG;
          Object localObject2 = ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).Iq(this.pwg);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localb.imagePath = ((String)localObject1);
          localObject1 = (l.b)localf.SYG;
          localObject2 = ac.CGB;
          localObject2 = ((l.b)localf.SYG).imagePath;
          if (localObject2 == null) {
            p.hyc();
          }
          ((l.b)localObject1).CAW = ac.aMA((String)localObject2);
          ((Map)l.gTB()).put(Long.valueOf(this.pwg), (l.b)localf.SYG);
        }
        h.RTc.aV((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231279);
            this.PCQ.gWe.invoke((l.b)localf.SYG);
            AppMethodBeat.o(231279);
          }
        });
        AppMethodBeat.o(231280);
        return;
        localObject1 = null;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pHashInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "invoke"})
  public static final class e
    extends q
    implements b<l.b, x>
  {
    public e(c paramc, long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class f
    implements com.tencent.mm.plugin.scanner.api.g
  {
    f(l paraml) {}
    
    public final void a(long paramLong, f paramf)
    {
      AppMethodBeat.i(231283);
      p.h(paramf, "result");
      l.a(this.PCT, paramLong, paramf);
      AppMethodBeat.o(231283);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pHashInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "invoke"})
  public static final class g
    extends q
    implements b<l.b, x>
  {
    public g(l paraml, c paramc, long paramLong1, long paramLong2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.l
 * JD-Core Version:    0.7.0.1
 */