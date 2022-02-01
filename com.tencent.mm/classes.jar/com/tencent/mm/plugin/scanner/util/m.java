package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService;", "", "()V", "TAG", "", "callbackMap", "", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallback;", "cdnCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "addUploadTask", "", "mediaId", "filePath", "mediaType", "", "uploadCallback", "cancelUploadTask", "doUpload", "getMediaIdByPath", "notifyCallBack", "result", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallbackResult;", "ScanTranslateUploadCallback", "ScanTranslateUploadCallbackResult", "ScanTranslateUploadErrCode", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m Pjn;
  private static g.a osH;
  private static final Map<String, a> vcA;
  
  static
  {
    AppMethodBeat.i(314131);
    Pjn = new m();
    vcA = (Map)new HashMap();
    osH = (g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(314194);
        s.u(paramAnonymousString, "mediaId");
        Log.i("MicroMsg.ScanTranslationCdnService", "scanTranslateUploadCdn on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        paramAnonymousc = new m.b();
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.ScanTranslationCdnService", "scanTranslateUploadCdn start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          paramAnonymousc.errCode = paramAnonymousInt;
          paramAnonymousc.errMsg = "start cdn upload failed";
          paramAnonymousd = m.Pjn;
          m.b(paramAnonymousString, paramAnonymousc);
          AppMethodBeat.o(314194);
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
          paramAnonymousd = m.Pjn;
          m.b(paramAnonymousString, paramAnonymousc);
          AppMethodBeat.o(314194);
          return 0;
          label180:
          Log.i("MicroMsg.ScanTranslationCdnService", "scanTranslateUploadCdn cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          paramAnonymousc.fileId = paramAnonymousd.field_fileId;
          paramAnonymousc.aeskey = paramAnonymousd.field_aesKey;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(314200);
        s.u(paramAnonymousString, "mediaId");
        s.u(paramAnonymousByteArrayOutputStream, "buff");
        Log.i("MicroMsg.ScanTranslationCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(314200);
      }
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(314203);
        s.u(paramAnonymousString, "mediaId");
        s.u(paramAnonymousArrayOfByte, "inbuf");
        Log.i("MicroMsg.ScanTranslationCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(314203);
        return null;
      }
    };
    AppMethodBeat.o(314131);
  }
  
  public static final void a(final String paramString1, String paramString2, final int paramInt, final a parama)
  {
    AppMethodBeat.i(314113);
    s.u(parama, "uploadCallback");
    if (g.aVh(paramString2))
    {
      final String str = MD5Util.getMD5String(s.X(paramString2, Long.valueOf(y.bEm(paramString2))));
      str = ((com.tencent.mm.plugin.scanner.g)h.az(com.tencent.mm.plugin.scanner.g.class)).genScanTmpImgPath(str, "jpg");
      if (y.ZC(str))
      {
        Log.i("MicroMsg.ScanTranslationCdnService", "alvinluo addUploadTask hevc image exist");
        b(paramString1, str, paramInt, parama);
        AppMethodBeat.o(314113);
        return;
      }
      j.a((aq)bu.ajwo, null, null, (kotlin.g.a.m)new c(paramString2, str, paramString1, paramInt, parama, null), 3);
      AppMethodBeat.o(314113);
      return;
    }
    b(paramString1, paramString2, paramInt, parama);
    AppMethodBeat.o(314113);
  }
  
  public static final String aVi(String paramString)
  {
    AppMethodBeat.i(314112);
    paramString = z.bAM() + '_' + paramString + '_' + System.currentTimeMillis();
    AppMethodBeat.o(314112);
    return paramString;
  }
  
  private static void b(String paramString1, String paramString2, int paramInt, a parama)
  {
    AppMethodBeat.i(314119);
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_ScannerCdnService";
    localg.lwL = osH;
    localg.field_mediaId = paramString1;
    localg.field_fullpath = paramString2;
    localg.field_fileType = paramInt;
    localg.field_priority = com.tencent.mm.g.a.lvZ;
    localg.field_needStorage = false;
    localg.field_needCompressImage = true;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    vcA.put(paramString1, parama);
    com.tencent.mm.modelcdntran.k.bHW().g(localg);
    AppMethodBeat.o(314119);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallback;", "", "onFinish", "", "mediaId", "", "result", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallbackResult;", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(String paramString, m.b paramb);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanTranslateCdnService$ScanTranslateUploadCallbackResult;", "", "()V", "aeskey", "", "getAeskey", "()Ljava/lang/String;", "setAeskey", "(Ljava/lang/String;)V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errMsg", "getErrMsg", "setErrMsg", "fileId", "getFileId", "setFileId", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public String aeskey;
    public int errCode;
    String errMsg;
    public String fileId;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(String paramString1, String paramString2, String paramString3, int paramInt, m.a parama, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(314107);
      paramObject = (kotlin.d.d)new c(this.svx, str, paramString1, paramInt, parama, paramd);
      AppMethodBeat.o(314107);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(314103);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(314103);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.svx;
        Object localObject = str;
        s.s(localObject, "uploadPath");
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = g.b(paramObject, (String)localObject, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(314103);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      boolean bool2 = ((Boolean)paramObject).booleanValue();
      boolean bool1;
      if (bool2)
      {
        bool1 = true;
        Log.i("MicroMsg.ScanTranslationCdnService", "alvinluo addUploadTask convertHevcToJpeg success: %s, exist: %s, uploadPath: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(y.ZC(str)), str });
        if (!bool2) {
          break label213;
        }
        paramObject = m.Pjn;
        m.c(paramString1, str, paramInt, parama);
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(314103);
        return paramObject;
        bool1 = false;
        break;
        label213:
        paramObject = new m.b();
        paramObject.errCode = 1;
        paramObject.errMsg = "convert hevc to jpeg failed";
        parama.a(paramString1, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.m
 * JD-Core Version:    0.7.0.1
 */