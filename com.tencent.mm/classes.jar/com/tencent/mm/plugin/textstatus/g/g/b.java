package com.tencent.mm.plugin.textstatus.g.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader;", "", "()V", "TAG", "", "uploadFileToCDN", "", "mediaType", "", "filePath", "thumbPath", "uploadCallback", "Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "uploadImage", "cdnCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "uploadVideo", "TextStatusUploadCallback", "plugin-textstatus_release"})
public final class b
{
  public static final b MEq;
  
  static
  {
    AppMethodBeat.i(238696);
    MEq = new b();
    AppMethodBeat.o(238696);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(238693);
    p.k(parama, "uploadCallback");
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (n.ba((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (!n.ba((CharSequence)localObject))) {
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
      AppMethodBeat.o(238693);
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
      localObject = new g();
      ((g)localObject).taskName = "task_TextStatusUploader_1";
      ((g)localObject).iUG = parama;
      ((g)localObject).field_mediaId = MD5Util.getMD5String(paramString1);
      ((g)localObject).field_fullpath = paramString1;
      ((g)localObject).field_thumbpath = paramString2;
      ((g)localObject).field_talker = "";
      ((g)localObject).field_needStorage = true;
      ((g)localObject).field_fileType = 20302;
      ((g)localObject).field_appType = 256;
      ((g)localObject).iUX = 8;
      ((g)localObject).field_bzScene = 2;
      ((g)localObject).iUK = 600;
      ((g)localObject).iUL = 1200;
      ((g)localObject).field_priority = a.iTU;
      f.bkg().f((g)localObject);
      AppMethodBeat.o(238693);
      return;
    }
    Log.d("MicroMsg.TextStatus.TextStatusUploader", "uploadImage");
    parama = (g.a)parama;
    localObject = new g();
    ((g)localObject).taskName = "task_TextStatusUploader_2";
    ((g)localObject).iUG = parama;
    ((g)localObject).field_mediaId = MD5Util.getMD5String(paramString1);
    ((g)localObject).field_fullpath = paramString1;
    ((g)localObject).field_thumbpath = paramString2;
    ((g)localObject).field_talker = "";
    ((g)localObject).field_needStorage = true;
    ((g)localObject).field_fileType = 20304;
    ((g)localObject).field_appType = 256;
    ((g)localObject).field_bzScene = 2;
    ((g)localObject).iUK = 60;
    ((g)localObject).iUL = 300;
    ((g)localObject).field_priority = a.iTU;
    f.bkg().f((g)localObject);
    AppMethodBeat.o(238693);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "", "onUploadEnd", "", "errorCode", "", "isOk", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-textstatus_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt, boolean paramBoolean, d paramd);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$uploadFileToCDN$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-textstatus_release"})
  public static final class b
    implements g.a
  {
    b(b.a parama) {}
    
    public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(233210);
      p.k(paramString, "mediaId");
      if (paramInt == -21005)
      {
        Log.d("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        AppMethodBeat.o(233210);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        this.MEr.a(0, true, paramd);
        AppMethodBeat.o(233210);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        Log.i("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        this.MEr.a(paramd.field_retCode, false, paramd);
        AppMethodBeat.o(233210);
        return 0;
      }
      if (paramInt != 0)
      {
        Log.i("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        this.MEr.a(paramInt, false, paramd);
        AppMethodBeat.o(233210);
        return 0;
      }
      Log.d("MicroMsg.TextStatus.TextStatusUploader", "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(233210);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(233211);
      p.k(paramString, "mediaId");
      p.k(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(233211);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(233213);
      p.k(paramString, "mediaId");
      p.k(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(233213);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.g.b
 * JD-Core Version:    0.7.0.1
 */