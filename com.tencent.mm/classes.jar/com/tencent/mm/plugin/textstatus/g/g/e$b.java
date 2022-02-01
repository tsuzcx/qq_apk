package com.tencent.mm.plugin.textstatus.g.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.al;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/model/upload/UploadTask$doUpload$uploadCallback$1", "Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "onUploadEnd", "", "errorCode", "", "isOk", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-textstatus_release"})
public final class e$b
  implements b.a
{
  e$b(long paramLong) {}
  
  public final void a(int paramInt, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(232221);
    StringBuilder localStringBuilder = new StringBuilder("onUploadEnd cost").append(System.currentTimeMillis() - this.uyk).append(".errorCode").append(paramInt).append(",isOk").append(paramBoolean).append(",mediaType");
    Object localObject = e.a(this.MEz).MFN;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((TextStatusExtInfo)localObject).mediaType);
      Log.i("MicroMsg.TextStatus.UploadTask", localObject + ",sceneResult" + paramd);
      if ((paramBoolean) && (paramd != null))
      {
        localObject = (CharSequence)paramd.field_fileUrl;
        if ((localObject != null) && (!n.ba((CharSequence)localObject))) {
          break label278;
        }
        paramInt = 1;
        label133:
        if (paramInt == 0)
        {
          localObject = (CharSequence)paramd.field_thumbUrl;
          if ((localObject != null) && (!n.ba((CharSequence)localObject))) {
            break label283;
          }
        }
      }
    }
    label278:
    label283:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label288;
      }
      paramd = c.MEt;
      paramd = e.a(this.MEz);
      p.k(paramd, "postInfo");
      Log.i("MicroMsg.TextStatus.UploadManager", "makeCdnFail " + paramd.MFT + ' ' + paramd.MFR + ' ' + paramd.MFS);
      paramd.MFR += 1;
      c.a(paramd);
      localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.c(paramd.MFV, Long.valueOf(2L));
      c.eCf();
      AppMethodBeat.o(232221);
      return;
      localObject = null;
      break;
      paramInt = 0;
      break label133;
    }
    label288:
    e.a(this.MEz).MFN.mediaUrl = paramd.field_fileUrl;
    e.a(this.MEz).MFN.mediaThumbUrl = paramd.field_thumbUrl;
    new a(e.a(this.MEz)).gmi();
    AppMethodBeat.o(232221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.g.e.b
 * JD-Core Version:    0.7.0.1
 */