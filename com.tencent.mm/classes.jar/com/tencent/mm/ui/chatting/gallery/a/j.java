package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.protocal.protobuf.clb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.b;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager;", "", "()V", "mPreviewImageCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "previewCallbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/GallerySearchImagePreviewResultCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "previewFilter", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "previewRequestMap", "", "Lcom/tencent/mm/ui/chatting/gallery/scan/GalleryScanOpImageRequestWrapper;", "cancelPreviewImage", "", "session", "doPreviewImage", "requestWrapper", "callback", "getImagePHashByMsgId", "msgId", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "getImagePath", "getRequestKey", "onPreviewCallbackWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "previewImage", "release", "canPreview", "", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "valid", "Companion", "ImagePHashInfoWrapper", "ImagePreviewFilter", "app_release"})
public final class j
{
  private static final HashMap<String, clb> WXF;
  private static final ConcurrentHashMap<Long, b> WXG;
  public static final j.a WXH;
  private c WXB;
  public HashMap<String, ArrayList<c>> WXC;
  public HashMap<Long, a> WXD;
  private g WXE;
  
  static
  {
    AppMethodBeat.i(200889);
    WXH = new j.a((byte)0);
    WXF = new HashMap();
    WXG = new ConcurrentHashMap();
    AppMethodBeat.o(200889);
  }
  
  public j()
  {
    AppMethodBeat.i(200886);
    this.WXB = new c();
    this.WXC = new HashMap();
    this.WXD = new HashMap();
    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo ImageSearchPreviewManager init cache size: %d", new Object[] { Integer.valueOf(WXF.size()) });
    this.WXE = ((g)new f(this));
    AppMethodBeat.o(200886);
  }
  
  public static void PM(long paramLong)
  {
    AppMethodBeat.i(200875);
    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo cancelPreviewImage session: %d", new Object[] { Long.valueOf(paramLong) });
    ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.scanner.api.c.class)).PM(paramLong);
    AppMethodBeat.o(200875);
  }
  
  private static String a(a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200880);
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama != null)
    {
      localObject1 = parama.IJW;
      if (localObject1 == null) {}
    }
    for (Object localObject1 = Long.valueOf(((e)localObject1).msgId);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(',');
      localObject1 = localObject2;
      if (parama != null)
      {
        parama = parama.IJW;
        localObject1 = localObject2;
        if (parama != null) {
          localObject1 = parama.imagePath;
        }
      }
      parama = (String)localObject1;
      AppMethodBeat.o(200880);
      return parama;
    }
  }
  
  public static void a(long paramLong, b<? super b, x> paramb)
  {
    AppMethodBeat.i(200877);
    com.tencent.e.h.ZvG.g((Runnable)new d(paramLong, paramb), "search_preview_compute_phash");
    AppMethodBeat.o(200877);
  }
  
  public static boolean a(clb paramclb)
  {
    AppMethodBeat.i(200881);
    p.k(paramclb, "$this$canPreview");
    if ((paramclb.timestamp > 0L) && (System.currentTimeMillis() - paramclb.timestamp > 604800000L))
    {
      AppMethodBeat.o(200881);
      return true;
    }
    AppMethodBeat.o(200881);
    return false;
  }
  
  public static boolean b(clb paramclb)
  {
    return (paramclb != null) && (paramclb.timestamp > 0L);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "", "()V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "getPHashInfo", "()Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "setPHashInfo", "(Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "app_release"})
  static final class b
  {
    ScanImagePHashInfo IGB;
    String imagePath;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "", "()V", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "username", "", "kotlin.jvm.PlatformType", "filterPreview", "", "pHash", "filterPreviewByMMKV", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "filterPreviewByMemory", "getPreviewResult", "saveRequest", "", "timestamp", "", "saveRequestInMMKV", "requestTime", "saveRequestInMemory", "saveResult", "result", "FilterResult", "app_release"})
  static final class c
  {
    final MMKVSlotManager sFn;
    private final String username;
    
    public c()
    {
      AppMethodBeat.i(269820);
      this.username = z.bcZ();
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(this.username + "__image_gallery_search_preview_slot_mmkv_key__");
      p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…preview_slot_mmkv_key__\")");
      this.sFn = new MMKVSlotManager(localMultiProcessMMKV, 604800L);
      AppMethodBeat.o(269820);
    }
    
    public static void cp(String paramString, long paramLong)
    {
      AppMethodBeat.i(269819);
      Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo saveRequestInMemory pHash: %s, requestTime: %d", new Object[] { paramString, Long.valueOf(paramLong) });
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(269819);
        return;
      }
      paramString = (clb)j.hTg().get(paramString);
      if (paramString != null)
      {
        paramString.timestamp = paramLong;
        AppMethodBeat.o(269819);
        return;
      }
      AppMethodBeat.o(269819);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(long paramLong, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(268215);
      final aa.f localf = new aa.f();
      localf.aaBC = ((j.b)j.hTh().get(Long.valueOf(this.sFC)));
      long l = this.sFC;
      Object localObject1 = (j.b)localf.aaBC;
      if (localObject1 != null)
      {
        localObject1 = ((j.b)localObject1).IGB;
        if (localObject1 != null)
        {
          localObject1 = ((ScanImagePHashInfo)localObject1).pHash;
          Log.v("MicroMsg.ImageSearchPreviewManager", "alvinluo getImagePHashByMsgId msgId: %s, pHash: %s", new Object[] { Long.valueOf(l), localObject1 });
          if ((j.b)localf.aaBC == null) {
            localf.aaBC = new j.b();
          }
          if (((j.b)localf.aaBC).IGB != null)
          {
            localObject1 = ((j.b)localf.aaBC).IGB;
            if (localObject1 == null) {
              p.iCn();
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
          j.b localb = (j.b)localf.aaBC;
          Object localObject2 = ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.scanner.api.c.class)).PK(this.sFC);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localb.imagePath = ((String)localObject1);
          localObject1 = (j.b)localf.aaBC;
          localObject2 = aa.ILM;
          localObject2 = ((j.b)localf.aaBC).imagePath;
          if (localObject2 == null) {
            p.iCn();
          }
          ((j.b)localObject1).IGB = aa.aXh((String)localObject2);
          ((Map)j.hTh()).put(Long.valueOf(this.sFC), (j.b)localf.aaBC);
        }
        com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(286947);
            this.WXI.jFa.invoke((j.b)localf.aaBC);
            AppMethodBeat.o(286947);
          }
        });
        AppMethodBeat.o(268215);
        return;
        localObject1 = null;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pHashInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "invoke"})
  public static final class e
    extends q
    implements b<j.b, x>
  {
    public e(c paramc, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class f
    implements g
  {
    f(j paramj) {}
    
    public final void a(long paramLong, f paramf)
    {
      AppMethodBeat.i(286064);
      p.k(paramf, "result");
      j.a(this.WXL, paramLong, paramf);
      AppMethodBeat.o(286064);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pHashInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "invoke"})
  public static final class g
    extends q
    implements b<j.b, x>
  {
    public g(j paramj, c paramc, long paramLong1, long paramLong2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.j
 * JD-Core Version:    0.7.0.1
 */