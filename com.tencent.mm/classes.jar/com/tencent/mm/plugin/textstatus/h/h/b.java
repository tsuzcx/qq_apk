package com.tencent.mm.plugin.textstatus.h.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader;", "", "()V", "TAG", "", "uploadFileToCDN", "", "mediaType", "", "filePath", "thumbPath", "uploadCallback", "Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "uploadImage", "cdnCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "uploadVideo", "TextStatusUploadCallback", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b TnZ;
  
  static
  {
    AppMethodBeat.i(290640);
    TnZ = new b();
    AppMethodBeat.o(290640);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(290636);
    s.u(parama, "uploadCallback");
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
          break label77;
        }
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label83;
      }
      AppMethodBeat.o(290636);
      return;
      i = 0;
      break;
    }
    label83:
    parama = new b(parama);
    if (paramInt == 2)
    {
      Log.d("MicroMsg.TextStatus.TextStatusUploader", "isVideo");
      parama = (g.a)parama;
      localObject = new com.tencent.mm.g.g();
      ((com.tencent.mm.g.g)localObject).taskName = "task_TextStatusUploader_1";
      ((com.tencent.mm.g.g)localObject).lwL = parama;
      ((com.tencent.mm.g.g)localObject).field_mediaId = MD5Util.getMD5String(paramString1);
      ((com.tencent.mm.g.g)localObject).field_fullpath = paramString1;
      ((com.tencent.mm.g.g)localObject).field_thumbpath = paramString2;
      ((com.tencent.mm.g.g)localObject).field_talker = "";
      ((com.tencent.mm.g.g)localObject).field_needStorage = true;
      ((com.tencent.mm.g.g)localObject).field_fileType = 20302;
      ((com.tencent.mm.g.g)localObject).field_appType = 256;
      ((com.tencent.mm.g.g)localObject).lxc = 8;
      ((com.tencent.mm.g.g)localObject).field_bzScene = 2;
      ((com.tencent.mm.g.g)localObject).lwP = 600;
      ((com.tencent.mm.g.g)localObject).lwQ = 1200;
      ((com.tencent.mm.g.g)localObject).field_priority = a.lvZ;
      k.bHW().g((com.tencent.mm.g.g)localObject);
      AppMethodBeat.o(290636);
      return;
    }
    Log.d("MicroMsg.TextStatus.TextStatusUploader", "uploadImage");
    parama = (g.a)parama;
    localObject = new com.tencent.mm.g.g();
    ((com.tencent.mm.g.g)localObject).taskName = "task_TextStatusUploader_2";
    ((com.tencent.mm.g.g)localObject).lwL = parama;
    ((com.tencent.mm.g.g)localObject).field_mediaId = MD5Util.getMD5String(paramString1);
    ((com.tencent.mm.g.g)localObject).field_fullpath = paramString1;
    ((com.tencent.mm.g.g)localObject).field_thumbpath = paramString2;
    ((com.tencent.mm.g.g)localObject).field_talker = "";
    ((com.tencent.mm.g.g)localObject).field_needStorage = true;
    ((com.tencent.mm.g.g)localObject).field_fileType = 20304;
    ((com.tencent.mm.g.g)localObject).field_appType = 256;
    ((com.tencent.mm.g.g)localObject).field_bzScene = 2;
    ((com.tencent.mm.g.g)localObject).lwP = 60;
    ((com.tencent.mm.g.g)localObject).lwQ = 300;
    ((com.tencent.mm.g.g)localObject).field_priority = a.lvZ;
    k.bHW().g((com.tencent.mm.g.g)localObject);
    AppMethodBeat.o(290636);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "", "onUploadEnd", "", "errorCode", "", "isOk", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt, boolean paramBoolean, d paramd);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$uploadFileToCDN$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a
  {
    b(b.a parama) {}
    
    public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(290634);
      s.u(paramString, "mediaId");
      if (paramInt == -21005)
      {
        Log.d("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        AppMethodBeat.o(290634);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        this.Toa.a(0, true, paramd);
        AppMethodBeat.o(290634);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        Log.i("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        this.Toa.a(paramd.field_retCode, false, paramd);
        AppMethodBeat.o(290634);
        return 0;
      }
      if (paramInt != 0)
      {
        Log.i("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        this.Toa.a(paramInt, false, paramd);
        AppMethodBeat.o(290634);
        return 0;
      }
      Log.d("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(290634);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(290637);
      s.u(paramString, "mediaId");
      s.u(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(290637);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(290644);
      s.u(paramString, "mediaId");
      s.u(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(290644);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.h.b
 * JD-Core Version:    0.7.0.1
 */