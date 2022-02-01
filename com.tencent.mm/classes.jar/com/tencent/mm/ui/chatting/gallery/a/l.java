package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.api.d;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.protocal.protobuf.bqf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager;", "", "()V", "mPreviewImageCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "previewCallbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/GallerySearchImagePreviewResultCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "previewFilter", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "previewRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/GalleryScanOpImageRequestWrapper;", "previewRequestSessionSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "cancelPreviewImage", "", "session", "doPreviewImage", "requestWrapper", "callback", "getImagePHashByMsgId", "msgId", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "onPreviewCallbackWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "previewImage", "release", "canPreview", "", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "valid", "Companion", "ImagePHashInfoWrapper", "ImagePreviewFilter", "app_release"})
public final class l
{
  private static final HashMap<String, bqf> KqE;
  private static final ConcurrentHashMap<Long, b> KqF;
  public static final l.a KqG;
  public HashSet<Long> KqA;
  public HashMap<Long, ArrayList<c>> KqB;
  public HashMap<Long, a> KqC;
  private e KqD;
  private c Kqz;
  
  static
  {
    AppMethodBeat.i(188336);
    KqG = new l.a((byte)0);
    KqE = new HashMap();
    KqF = new ConcurrentHashMap();
    AppMethodBeat.o(188336);
  }
  
  public l()
  {
    AppMethodBeat.i(188335);
    this.Kqz = new c();
    this.KqA = new HashSet();
    this.KqB = new HashMap();
    this.KqC = new HashMap();
    ae.i("MicroMsg.ImageSearchPreviewManager", "alvinluo ImageSearchPreviewManager init cache size: %d", new Object[] { Integer.valueOf(KqE.size()) });
    this.KqD = ((e)new e(this));
    AppMethodBeat.o(188335);
  }
  
  public static void a(long paramLong, d.g.a.b<? super b, z> paramb)
  {
    AppMethodBeat.i(188333);
    h.MqF.i((Runnable)new d(paramLong, paramb), "search_preview_compute_phash");
    AppMethodBeat.o(188333);
  }
  
  public static boolean a(bqf parambqf)
  {
    AppMethodBeat.i(188334);
    p.h(parambqf, "$this$canPreview");
    if ((parambqf.timestamp > 0L) && (System.currentTimeMillis() - parambqf.timestamp > 604800000L))
    {
      AppMethodBeat.o(188334);
      return true;
    }
    AppMethodBeat.o(188334);
    return false;
  }
  
  public static boolean b(bqf parambqf)
  {
    return (parambqf != null) && (parambqf.timestamp > 0L);
  }
  
  public static void zs(long paramLong)
  {
    AppMethodBeat.i(188332);
    ae.i("MicroMsg.ImageSearchPreviewManager", "alvinluo cancelPreviewImage session: %d", new Object[] { Long.valueOf(paramLong) });
    ((com.tencent.mm.plugin.scanner.api.b)g.ab(com.tencent.mm.plugin.scanner.api.b.class)).zs(paramLong);
    AppMethodBeat.o(188332);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "", "()V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "pHashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "getPHashInfo", "()Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "setPHashInfo", "(Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;)V", "app_release"})
  static final class b
  {
    String imagePath;
    ScanImagePHashInfo yzQ;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePreviewFilter;", "", "()V", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "username", "", "kotlin.jvm.PlatformType", "filterPreview", "", "pHash", "filterPreviewByMMKV", "Lcom/tencent/mm/protocal/protobuf/ImageSearchPreviewResult;", "filterPreviewByMemory", "getPreviewResult", "saveRequest", "", "timestamp", "", "saveRequestInMMKV", "requestTime", "saveRequestInMemory", "saveResult", "result", "FilterResult", "app_release"})
  static final class c
  {
    final as DSc;
    private final String username;
    
    public c()
    {
      AppMethodBeat.i(188326);
      this.username = v.aAC();
      ay localay = ay.aRW(this.username + "__image_gallery_search_preview_slot_mmkv_key__");
      p.g(localay, "MultiProcessMMKV.getMMKV…preview_slot_mmkv_key__\")");
      this.DSc = new as(localay, 604800L);
      AppMethodBeat.o(188326);
    }
    
    public static void cn(String paramString, long paramLong)
    {
      AppMethodBeat.i(188325);
      ae.d("MicroMsg.ImageSearchPreviewManager", "alvinluo saveRequestInMemory pHash: %s, requestTime: %d", new Object[] { paramString, Long.valueOf(paramLong) });
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(188325);
        return;
      }
      paramString = (bqf)l.fLi().get(paramString);
      if (paramString != null)
      {
        paramString.timestamp = paramLong;
        AppMethodBeat.o(188325);
        return;
      }
      AppMethodBeat.o(188325);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(long paramLong, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(188328);
      final y.f localf = new y.f();
      localf.NiY = ((l.b)l.fLj().get(Long.valueOf(this.DVm)));
      long l = this.DVm;
      Object localObject1 = (l.b)localf.NiY;
      if (localObject1 != null)
      {
        localObject1 = ((l.b)localObject1).yzQ;
        if (localObject1 != null)
        {
          localObject1 = ((ScanImagePHashInfo)localObject1).pHash;
          ae.v("MicroMsg.ImageSearchPreviewManager", "alvinluo getImagePHashByMsgId msgId: %s, pHash: %s", new Object[] { Long.valueOf(l), localObject1 });
          if ((l.b)localf.NiY == null) {
            localf.NiY = new l.b();
          }
          if (((l.b)localf.NiY).yzQ != null)
          {
            localObject1 = ((l.b)localf.NiY).yzQ;
            if (localObject1 == null) {
              p.gkB();
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
          l.b localb = (l.b)localf.NiY;
          Object localObject2 = ((com.tencent.mm.plugin.scanner.api.b)g.ab(com.tencent.mm.plugin.scanner.api.b.class)).Gt(this.DVm);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localb.imagePath = ((String)localObject1);
          localObject1 = (l.b)localf.NiY;
          localObject2 = aa.yDM;
          localObject2 = ((l.b)localf.NiY).imagePath;
          if (localObject2 == null) {
            p.gkB();
          }
          ((l.b)localObject1).yzQ = aa.axW((String)localObject2);
          ((Map)l.fLj()).put(Long.valueOf(this.DVm), (l.b)localf.NiY);
        }
        h.MqF.aM((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(188327);
            this.KqH.gll.invoke((l.b)localf.NiY);
            AppMethodBeat.o(188327);
          }
        });
        AppMethodBeat.o(188328);
        return;
        localObject1 = null;
        break;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class e
    implements e
  {
    e(l paraml) {}
    
    public final void a(long paramLong, d paramd)
    {
      AppMethodBeat.i(188330);
      p.h(paramd, "result");
      l.a(this.KqJ, paramLong, paramd);
      AppMethodBeat.o(188330);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "pHashInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageSearchPreviewManager$ImagePHashInfoWrapper;", "invoke"})
  public static final class f
    extends q
    implements d.g.a.b<l.b, z>
  {
    public f(l paraml, c paramc, long paramLong1, long paramLong2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.l
 * JD-Core Version:    0.7.0.1
 */