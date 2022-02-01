package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.br;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService;", "", "()V", "TAG", "", "callbackMap", "", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallback;", "cdnCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "addUploadTask", "", "mediaId", "filePath", "mediaType", "", "uploadCallback", "cancelUploadTask", "doUpload", "getMediaIdByPath", "notifyCallBack", "result", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallbackResult;", "ScanTranslateUploadCallback", "ScanTranslateUploadCallbackResult", "ScanTranslateUploadErrCode", "scan-sdk_release"})
public final class k
{
  public static final k IZu;
  private static g.a lPx;
  private static final Map<String, a> rRk;
  
  static
  {
    AppMethodBeat.i(193201);
    IZu = new k();
    rRk = (Map)new HashMap();
    lPx = (g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(192676);
        p.k(paramAnonymousString, "mediaId");
        Log.i("MicroMsg.ScanTranslationCdnService", "scanTranslateUploadCdn on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        paramAnonymousc = new k.b();
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.ScanTranslationCdnService", "scanTranslateUploadCdn start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          paramAnonymousc.errCode = paramAnonymousInt;
          paramAnonymousc.errMsg = "start cdn upload failed";
          paramAnonymousd = k.IZu;
          k.b(paramAnonymousString, paramAnonymousc);
          AppMethodBeat.o(192676);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          paramAnonymousc.errCode = paramAnonymousd.field_retCode;
          if (paramAnonymousd.field_retCode == 0) {
            break label180;
          }
          paramAnonymousc.errMsg = "cdn upload failed";
          Log.e("MicroMsg.ScanTranslationCdnService", "scanTranslateUploadCdn cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
        }
        for (;;)
        {
          paramAnonymousd = k.IZu;
          k.b(paramAnonymousString, paramAnonymousc);
          AppMethodBeat.o(192676);
          return 0;
          label180:
          Log.i("MicroMsg.ScanTranslationCdnService", "scanTranslateUploadCdn cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          paramAnonymousc.fileId = paramAnonymousd.field_fileId;
          paramAnonymousc.aeskey = paramAnonymousd.field_aesKey;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(192677);
        p.k(paramAnonymousString, "mediaId");
        p.k(paramAnonymousByteArrayOutputStream, "buff");
        Log.i("MicroMsg.ScanTranslationCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(192677);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(192679);
        p.k(paramAnonymousString, "mediaId");
        p.k(paramAnonymousArrayOfByte, "inbuf");
        Log.i("MicroMsg.ScanTranslationCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(192679);
        return null;
      }
    };
    AppMethodBeat.o(193201);
  }
  
  public static final void a(final String paramString1, String paramString2, final int paramInt, final a parama)
  {
    AppMethodBeat.i(193193);
    p.k(parama, "uploadCallback");
    if (f.aXz(paramString2))
    {
      final String str = MD5Util.getMD5String(p.I(paramString2, Long.valueOf(u.bBR(paramString2))));
      str = ((com.tencent.mm.plugin.scanner.g)h.ag(com.tencent.mm.plugin.scanner.g.class)).genScanTmpImgPath(str, "jpg");
      if (u.agG(str))
      {
        Log.i("MicroMsg.ScanTranslationCdnService", "alvinluo addUploadTask hevc image exist");
        b(paramString1, str, paramInt, parama);
        AppMethodBeat.o(193193);
        return;
      }
      kotlinx.coroutines.g.b((ak)br.abxo, null, (m)new c(paramString2, str, paramString1, paramInt, parama, null), 3);
      AppMethodBeat.o(193193);
      return;
    }
    b(paramString1, paramString2, paramInt, parama);
    AppMethodBeat.o(193193);
  }
  
  public static final String aXA(String paramString)
  {
    AppMethodBeat.i(193187);
    paramString = z.bcZ() + "_" + paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(193187);
    return paramString;
  }
  
  private static void b(String paramString1, String paramString2, int paramInt, a parama)
  {
    AppMethodBeat.i(193196);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_ScannerCdnService";
    localg.iUG = lPx;
    localg.field_mediaId = paramString1;
    localg.field_fullpath = paramString2;
    localg.field_fileType = paramInt;
    localg.field_priority = com.tencent.mm.i.a.iTU;
    localg.field_needStorage = false;
    localg.field_needCompressImage = true;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    rRk.put(paramString1, parama);
    com.tencent.mm.aq.f.bkg().f(localg);
    AppMethodBeat.o(193196);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallback;", "", "onFinish", "", "mediaId", "", "result", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallbackResult;", "scan-sdk_release"})
  public static abstract interface a
  {
    public abstract void a(String paramString, k.b paramb);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallbackResult;", "", "()V", "aeskey", "", "getAeskey", "()Ljava/lang/String;", "setAeskey", "(Ljava/lang/String;)V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errMsg", "getErrMsg", "setErrMsg", "fileId", "getFileId", "setFileId", "scan-sdk_release"})
  public static final class b
  {
    public String aeskey;
    public int errCode;
    String errMsg;
    public String fileId;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    c(String paramString1, String paramString2, String paramString3, int paramInt, k.a parama, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(193017);
      p.k(paramd, "completion");
      paramd = new c(this.pqJ, str, paramString1, paramInt, parama, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(193017);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(193021);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(193021);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(193008);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(193008);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        Object localObject = this.pqJ;
        String str = str;
        p.j(str, "uploadPath");
        this.L$0 = paramObject;
        this.label = 1;
        localObject = f.a((String)localObject, str, this);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(193008);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      boolean bool = ((Boolean)paramObject).booleanValue();
      Log.i("MicroMsg.ScanTranslationCdnService", "alvinluo addUploadTask convertHevcToJpeg success: %s, exist: %s, uploadPath: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(u.agG(str)), str });
      if (bool)
      {
        paramObject = k.IZu;
        k.c(paramString1, str, paramInt, parama);
      }
      for (;;)
      {
        paramObject = x.aazN;
        AppMethodBeat.o(193008);
        return paramObject;
        paramObject = new k.b();
        paramObject.errCode = 1;
        paramObject.errMsg = "convert hevc to jpeg failed";
        parama.a(paramString1, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.k
 * JD-Core Version:    0.7.0.1
 */